
/* File:        org.molgenis.omx/model/Species.java
 * Copyright:   GBIC 2000-2013, all rights reserved
 * Date:        January 2, 2013
 * 
 * generator:   org.molgenis.generators.csv.CsvReaderGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.observ.target.csv;

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

import org.molgenis.observ.target.Ontology;
import org.molgenis.observ.target.Species;


/**
 * Reads Species from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class SpeciesCsvReader extends CsvToDatabase<Species>
{
	private static final Logger logger = Logger.getLogger(SpeciesCsvReader.class);
	
	//foreign key map for xref 'ontology' (maps ontology.Identifier -> ontology.id)			
	final Map<String,Integer> ontologyKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports Species from tab/comma delimited File
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
		List<Species> speciessMissingRefs = new ArrayList<Species>();
	
		//cache for objects to be imported from file (in batch)
		final List<Species> speciesList = new ArrayList<Species>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Species object = new Species();
			object.set(defaults, false); 
			object.set(tuple, false);				
			speciesList.add(object);		
			
			//add to db when batch size is reached
			if(speciesList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				speciessMissingRefs.addAll(resolveForeignKeys(db, speciesList));
				speciesList.removeAll(speciessMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
				db.update(speciesList,dbAction, "Identifier");
				
				//clear for next batch						
				speciesList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!speciesList.isEmpty())
		{
			total.set(total.get() + speciesList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			speciessMissingRefs.addAll(resolveForeignKeys(db, speciesList));
			speciesList.removeAll(speciessMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
			db.update(speciesList,dbAction, "Identifier");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<Species> speciess = new ArrayList<Species>(speciessMissingRefs);

		int iterationCount = 0;

		do
		{
			speciessMissingRefs = resolveForeignKeys(db, speciessMissingRefs);
			@SuppressWarnings("unchecked")
			List<Species> resolvablespeciess = new ArrayList<Species>(CollectionUtils.disjunction(speciess,
					speciessMissingRefs));
			speciess.removeAll(resolvablespeciess);
			
			db.update(resolvablespeciess,dbAction, "Identifier");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'species' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still speciess referring to Individuals that are neither in the database nor in the list of to-be imported speciess."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (speciessMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " species from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param speciesList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Species> resolveForeignKeys(Database db, List<Species> speciesList) throws Exception
	{
		//keep a list of Species instances that miss a reference which might be resolvable later
		List<Species> speciessMissingRefs = new ArrayList<Species>();
	
		//resolve xref 'ontology' from ontology.Identifier -> ontology.id
		for(Species o: speciesList) 
		{
			if(o.getOntology_Identifier() != null) 
				ontologyKeymap.put(o.getOntology_Identifier(), null);
		}
		
		if(ontologyKeymap.size() > 0) 
		{
			List<Ontology> ontologyList = db.query(Ontology.class).in("Identifier",new ArrayList<Object>(ontologyKeymap.keySet())).find();
			for(Ontology xref :  ontologyList)
			{
				ontologyKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(Species o:  speciesList)
		{
			while(true){
				//update xref ontology
				if(o.getOntology_Identifier() != null) 
				{
					String key = o.getOntology_Identifier();
					if(ontologyKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Species' objects failed: cannot find Ontology for ontology_Identifier='"+o.getOntology_Identifier()+"'");
					}
					o.setOntology_Id(ontologyKeymap.get(key));
				}
				break;
			}
		}
		
		ontologyKeymap.clear();
		
		return speciessMissingRefs;
	}
}

