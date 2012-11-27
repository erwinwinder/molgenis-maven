
/* File:        org.molgenis/model/Individual.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 26, 2012
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

import org.molgenis.observ.target.Individual;


/**
 * Reads Individual from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class IndividualCsvReader extends CsvToDatabase<Individual>
{
	private static final Logger logger = Logger.getLogger(IndividualCsvReader.class);
	
	//foreign key map for xref 'mother' (maps individual.Identifier -> individual.id)			
	final Map<String,Integer> motherKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'father' (maps individual.Identifier -> individual.id)			
	final Map<String,Integer> fatherKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports Individual from tab/comma delimited File
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
		List<Individual> individualsMissingRefs = new ArrayList<Individual>();
	
		//cache for objects to be imported from file (in batch)
		final List<Individual> individualList = new ArrayList<Individual>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Individual object = new Individual();
			object.set(defaults, false); 
			object.set(tuple, false);				
			individualList.add(object);		
			
			//add to db when batch size is reached
			if(individualList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				individualsMissingRefs.addAll(resolveForeignKeys(db, individualList));
				individualList.removeAll(individualsMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
				db.update(individualList,dbAction, "Identifier");
				
				//clear for next batch						
				individualList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!individualList.isEmpty())
		{
			total.set(total.get() + individualList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			individualsMissingRefs.addAll(resolveForeignKeys(db, individualList));
			individualList.removeAll(individualsMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
			db.update(individualList,dbAction, "Identifier");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<Individual> individuals = new ArrayList<Individual>(individualsMissingRefs);

		int iterationCount = 0;

		do
		{
			individualsMissingRefs = resolveForeignKeys(db, individualsMissingRefs);
			@SuppressWarnings("unchecked")
			List<Individual> resolvableindividuals = new ArrayList<Individual>(CollectionUtils.disjunction(individuals,
					individualsMissingRefs));
			individuals.removeAll(resolvableindividuals);
			
			db.update(resolvableindividuals,dbAction, "Identifier");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'individual' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still individuals referring to Individuals that are neither in the database nor in the list of to-be imported individuals."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (individualsMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " individual from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param individualList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Individual> resolveForeignKeys(Database db, List<Individual> individualList) throws Exception
	{
		//keep a list of Individual instances that miss a reference which might be resolvable later
		List<Individual> individualsMissingRefs = new ArrayList<Individual>();
	
		//resolve xref 'mother' from individual.Identifier -> individual.id
		for(Individual o: individualList) 
		{
			if(o.getMother_Identifier() != null) 
				motherKeymap.put(o.getMother_Identifier(), null);
		}
		
		if(motherKeymap.size() > 0) 
		{
			List<Individual> motherList = db.query(Individual.class).in("Identifier",new ArrayList<Object>(motherKeymap.keySet())).find();
			for(Individual xref :  motherList)
			{
				motherKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//resolve xref 'father' from individual.Identifier -> individual.id
		for(Individual o: individualList) 
		{
			if(o.getFather_Identifier() != null) 
				fatherKeymap.put(o.getFather_Identifier(), null);
		}
		
		if(fatherKeymap.size() > 0) 
		{
			List<Individual> fatherList = db.query(Individual.class).in("Identifier",new ArrayList<Object>(fatherKeymap.keySet())).find();
			for(Individual xref :  fatherList)
			{
				fatherKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(Individual o:  individualList)
		{
			while(true){
				//update xref Mother
				if(o.getMother_Identifier() != null) 
				{
					String key = o.getMother_Identifier();
					if(motherKeymap.get(key) == null)
					{
						individualsMissingRefs.add(o);
						break;
					}
					o.setMother_Id(motherKeymap.get(key));
				}
				//update xref Father
				if(o.getFather_Identifier() != null) 
				{
					String key = o.getFather_Identifier();
					if(fatherKeymap.get(key) == null)
					{
						individualsMissingRefs.add(o);
						break;
					}
					o.setFather_Id(fatherKeymap.get(key));
				}
				break;
			}
		}
		
		motherKeymap.clear();
		fatherKeymap.clear();
		
		return individualsMissingRefs;
	}
}

