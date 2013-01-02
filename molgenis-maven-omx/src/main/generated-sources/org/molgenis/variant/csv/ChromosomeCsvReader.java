
/* File:        org.molgenis.omx/model/Chromosome.java
 * Copyright:   GBIC 2000-2013, all rights reserved
 * Date:        January 2, 2013
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

import org.molgenis.variant.Genome;
import org.molgenis.variant.Chromosome;


/**
 * Reads Chromosome from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class ChromosomeCsvReader extends CsvToDatabase<Chromosome>
{
	private static final Logger logger = Logger.getLogger(ChromosomeCsvReader.class);
	
	//foreign key map for xref 'genome' (maps genome.Identifier -> genome.id)			
	final Map<String,Integer> genomeKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports Chromosome from tab/comma delimited File
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
		List<Chromosome> chromosomesMissingRefs = new ArrayList<Chromosome>();
	
		//cache for objects to be imported from file (in batch)
		final List<Chromosome> chromosomeList = new ArrayList<Chromosome>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Chromosome object = new Chromosome();
			object.set(defaults, false); 
			object.set(tuple, false);				
			chromosomeList.add(object);		
			
			//add to db when batch size is reached
			if(chromosomeList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				chromosomesMissingRefs.addAll(resolveForeignKeys(db, chromosomeList));
				chromosomeList.removeAll(chromosomesMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
				db.update(chromosomeList,dbAction, "Identifier");
				
				//clear for next batch						
				chromosomeList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!chromosomeList.isEmpty())
		{
			total.set(total.get() + chromosomeList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			chromosomesMissingRefs.addAll(resolveForeignKeys(db, chromosomeList));
			chromosomeList.removeAll(chromosomesMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
			db.update(chromosomeList,dbAction, "Identifier");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<Chromosome> chromosomes = new ArrayList<Chromosome>(chromosomesMissingRefs);

		int iterationCount = 0;

		do
		{
			chromosomesMissingRefs = resolveForeignKeys(db, chromosomesMissingRefs);
			@SuppressWarnings("unchecked")
			List<Chromosome> resolvablechromosomes = new ArrayList<Chromosome>(CollectionUtils.disjunction(chromosomes,
					chromosomesMissingRefs));
			chromosomes.removeAll(resolvablechromosomes);
			
			db.update(resolvablechromosomes,dbAction, "Identifier");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'chromosome' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still chromosomes referring to Individuals that are neither in the database nor in the list of to-be imported chromosomes."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (chromosomesMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " chromosome from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param chromosomeList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Chromosome> resolveForeignKeys(Database db, List<Chromosome> chromosomeList) throws Exception
	{
		//keep a list of Chromosome instances that miss a reference which might be resolvable later
		List<Chromosome> chromosomesMissingRefs = new ArrayList<Chromosome>();
	
		//resolve xref 'genome' from genome.Identifier -> genome.id
		for(Chromosome o: chromosomeList) 
		{
			if(o.getGenome_Identifier() != null) 
				genomeKeymap.put(o.getGenome_Identifier(), null);
		}
		
		if(genomeKeymap.size() > 0) 
		{
			List<Genome> genomeList = db.query(Genome.class).in("Identifier",new ArrayList<Object>(genomeKeymap.keySet())).find();
			for(Genome xref :  genomeList)
			{
				genomeKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(Chromosome o:  chromosomeList)
		{
			while(true){
				//update xref genome
				if(o.getGenome_Identifier() != null) 
				{
					String key = o.getGenome_Identifier();
					if(genomeKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Chromosome' objects failed: cannot find Genome for genome_Identifier='"+o.getGenome_Identifier()+"'");
					}
					o.setGenome_Id(genomeKeymap.get(key));
				}
				break;
			}
		}
		
		genomeKeymap.clear();
		
		return chromosomesMissingRefs;
	}
}

