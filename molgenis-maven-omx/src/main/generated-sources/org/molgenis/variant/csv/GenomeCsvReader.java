
/* File:        org.molgenis/model/Genome.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 26, 2012
 * 
 * generator:   org.molgenis.generators.csv.CsvReaderGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.variant.csv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.molgenis.framework.db.CsvToDatabase;
import org.molgenis.framework.db.Database;
import org.molgenis.framework.db.DatabaseException;
import org.molgenis.framework.db.Query;
import org.molgenis.framework.db.Database.DatabaseAction;
import org.molgenis.util.CsvReader;
import org.molgenis.util.Tuple;

import org.molgenis.observ.target.Species;
import org.molgenis.variant.Genome;


/**
 * Reads Genome from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class GenomeCsvReader extends CsvToDatabase<Genome>
{
	private static final Logger logger = Logger.getLogger(GenomeCsvReader.class);
	
	//foreign key map for xref 'species' (maps species.Identifier -> species.id)			
	final Map<String,Integer> speciesKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports Genome from tab/comma delimited File
	 * @param db database to import into
	 * @param reader csv reader to load data from
	 * @param defaults to set default values for each row
	 * @param dbAction indicating wether to add,update,remove etc
	 * @param missingValues indicating what value in the csv is treated as 'null' (e.g. "" or "NA")
	 * @return number of elements imported
	 */
	public int importCsv(final Database db, CsvReader reader, final Tuple defaults, final DatabaseAction dbAction, final String missingValues) throws DatabaseException, IOException, Exception 
	{
		//cache for entities of which xrefs couldn't be resolved (e.g. if there is a self-refence)
		//these entities can be updated with their xrefs in a second round when all entities are in the database
		List<Genome> genomesMissingRefs = new ArrayList<Genome>();
	
		//cache for objects to be imported from file (in batch)
		final List<Genome> genomeList = new ArrayList<Genome>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Genome object = new Genome();
			object.set(defaults, false); 
			object.set(tuple, false);				
			genomeList.add(object);		
			
			//add to db when batch size is reached
			if(genomeList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				genomesMissingRefs.addAll(resolveForeignKeys(db, genomeList));
				genomeList.removeAll(genomesMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
				db.update(genomeList,dbAction, "Identifier");
				
				//clear for next batch						
				genomeList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!genomeList.isEmpty())
		{
			total.set(total.get() + genomeList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			genomesMissingRefs.addAll(resolveForeignKeys(db, genomeList));
			genomeList.removeAll(genomesMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
			db.update(genomeList,dbAction, "Identifier");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<Genome> genomes = new ArrayList<Genome>(genomesMissingRefs);

		int iterationCount = 0;

		do
		{
			genomesMissingRefs = resolveForeignKeys(db, genomesMissingRefs);
			@SuppressWarnings("unchecked")
			List<Genome> resolvablegenomes = new ArrayList<Genome>(CollectionUtils.disjunction(genomes,
					genomesMissingRefs));
			genomes.removeAll(resolvablegenomes);
			
			db.update(resolvablegenomes,dbAction, "Identifier");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'genome' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still genomes referring to Individuals that are neither in the database nor in the list of to-be imported genomes."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (genomesMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " genome from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param genomeList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Genome> resolveForeignKeys(Database db, List<Genome> genomeList) throws Exception
	{
		//keep a list of Genome instances that miss a reference which might be resolvable later
		List<Genome> genomesMissingRefs = new ArrayList<Genome>();
	
		//resolve xref 'species' from species.Identifier -> species.id
		for(Genome o: genomeList) 
		{
			if(o.getSpecies_Identifier() != null) 
				speciesKeymap.put(o.getSpecies_Identifier(), null);
		}
		
		if(speciesKeymap.size() > 0) 
		{
			List<Species> speciesList = db.query(Species.class).in("Identifier",new ArrayList<Object>(speciesKeymap.keySet())).find();
			for(Species xref :  speciesList)
			{
				speciesKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(Genome o:  genomeList)
		{
			while(true){
				//update xref species
				if(o.getSpecies_Identifier() != null) 
				{
					String key = o.getSpecies_Identifier();
					if(speciesKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Genome' objects failed: cannot find Species for species_Identifier='"+o.getSpecies_Identifier()+"'");
					}
					o.setSpecies_Id(speciesKeymap.get(key));
				}
				break;
			}
		}
		
		speciesKeymap.clear();
		
		return genomesMissingRefs;
	}
}

