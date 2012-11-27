
/* File:        org.molgenis/model/Investigation.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 26, 2012
 * 
 * generator:   org.molgenis.generators.csv.CsvReaderGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.gwascentral.csv;

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

import org.molgenis.gwascentral.Investigation;


/**
 * Reads Investigation from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class InvestigationCsvReader extends CsvToDatabase<Investigation>
{
	private static final Logger logger = Logger.getLogger(InvestigationCsvReader.class);
	
			
	/**
	 * Imports Investigation from tab/comma delimited File
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
		List<Investigation> investigationsMissingRefs = new ArrayList<Investigation>();
	
		//cache for objects to be imported from file (in batch)
		final List<Investigation> investigationList = new ArrayList<Investigation>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Investigation object = new Investigation();
			object.set(defaults, false); 
			object.set(tuple, false);				
			investigationList.add(object);		
			
			//add to db when batch size is reached
			if(investigationList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				investigationsMissingRefs.addAll(resolveForeignKeys(db, investigationList));
				investigationList.removeAll(investigationsMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
				db.update(investigationList,dbAction, "Identifier");
				
				//clear for next batch						
				investigationList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!investigationList.isEmpty())
		{
			total.set(total.get() + investigationList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			investigationsMissingRefs.addAll(resolveForeignKeys(db, investigationList));
			investigationList.removeAll(investigationsMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
			db.update(investigationList,dbAction, "Identifier");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<Investigation> investigations = new ArrayList<Investigation>(investigationsMissingRefs);

		int iterationCount = 0;

		do
		{
			investigationsMissingRefs = resolveForeignKeys(db, investigationsMissingRefs);
			@SuppressWarnings("unchecked")
			List<Investigation> resolvableinvestigations = new ArrayList<Investigation>(CollectionUtils.disjunction(investigations,
					investigationsMissingRefs));
			investigations.removeAll(resolvableinvestigations);
			
			db.update(resolvableinvestigations,dbAction, "Identifier");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'investigation' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still investigations referring to Individuals that are neither in the database nor in the list of to-be imported investigations."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (investigationsMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " investigation from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param investigationList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Investigation> resolveForeignKeys(Database db, List<Investigation> investigationList) throws Exception
	{
		//keep a list of Investigation instances that miss a reference which might be resolvable later
		List<Investigation> investigationsMissingRefs = new ArrayList<Investigation>();
	
		//update objects with foreign key values
		for(Investigation o:  investigationList)
		{
			while(true){
				break;
			}
		}
		
		
		return investigationsMissingRefs;
	}
}

