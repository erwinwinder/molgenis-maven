
/* File:        org.molgenis/model/ObservationTarget.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 26, 2012
 * 
 * generator:   org.molgenis.generators.csv.CsvReaderGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.observ.csv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.molgenis.framework.db.CsvToDatabase;
import org.molgenis.framework.db.Database;
import org.molgenis.framework.db.DatabaseException;
import org.molgenis.framework.db.Query;
import org.molgenis.framework.db.Database.DatabaseAction;
import org.molgenis.util.CsvReader;
import org.molgenis.util.Tuple;

import org.molgenis.observ.ObservationTarget;


/**
 * Reads ObservationTarget from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class ObservationTargetCsvReader extends CsvToDatabase<ObservationTarget>
{
	private static final Logger logger = Logger.getLogger(ObservationTargetCsvReader.class);
	
			
	/**
	 * Imports ObservationTarget from tab/comma delimited File
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
		List<ObservationTarget> observationTargetsMissingRefs = new ArrayList<ObservationTarget>();
	
		//cache for objects to be imported from file (in batch)
		final List<ObservationTarget> observationTargetList = new ArrayList<ObservationTarget>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			ObservationTarget object = new ObservationTarget();
			object.set(defaults, false); 
			object.set(tuple, false);				
			observationTargetList.add(object);		
			
			//add to db when batch size is reached
			if(observationTargetList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				observationTargetsMissingRefs.addAll(resolveForeignKeys(db, observationTargetList));
				observationTargetList.removeAll(observationTargetsMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
				db.update(observationTargetList,dbAction, "Identifier");
				
				//clear for next batch						
				observationTargetList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!observationTargetList.isEmpty())
		{
			total.set(total.get() + observationTargetList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			observationTargetsMissingRefs.addAll(resolveForeignKeys(db, observationTargetList));
			observationTargetList.removeAll(observationTargetsMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
			db.update(observationTargetList,dbAction, "Identifier");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<ObservationTarget> observationTargets = new ArrayList<ObservationTarget>(observationTargetsMissingRefs);

		int iterationCount = 0;

		do
		{
			observationTargetsMissingRefs = resolveForeignKeys(db, observationTargetsMissingRefs);
			@SuppressWarnings("unchecked")
			List<ObservationTarget> resolvableobservationTargets = new ArrayList<ObservationTarget>(CollectionUtils.disjunction(observationTargets,
					observationTargetsMissingRefs));
			observationTargets.removeAll(resolvableobservationTargets);
			
			db.update(resolvableobservationTargets,dbAction, "Identifier");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'observationTarget' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still observationTargets referring to Individuals that are neither in the database nor in the list of to-be imported observationTargets."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (observationTargetsMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " observationTarget from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param observationTargetList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<ObservationTarget> resolveForeignKeys(Database db, List<ObservationTarget> observationTargetList) throws Exception
	{
		//keep a list of ObservationTarget instances that miss a reference which might be resolvable later
		List<ObservationTarget> observationTargetsMissingRefs = new ArrayList<ObservationTarget>();
	
		//update objects with foreign key values
		for(ObservationTarget o:  observationTargetList)
		{
			while(true){
				break;
			}
		}
		
		
		return observationTargetsMissingRefs;
	}
}

