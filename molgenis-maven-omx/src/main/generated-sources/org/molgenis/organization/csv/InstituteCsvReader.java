
/* File:        org.molgenis.omx/model/Institute.java
 * Copyright:   GBIC 2000-2013, all rights reserved
 * Date:        January 2, 2013
 * 
 * generator:   org.molgenis.generators.csv.CsvReaderGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.organization.csv;

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

import org.molgenis.organization.Institute;


/**
 * Reads Institute from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class InstituteCsvReader extends CsvToDatabase<Institute>
{
	private static final Logger logger = Logger.getLogger(InstituteCsvReader.class);
	
			
	/**
	 * Imports Institute from tab/comma delimited File
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
		List<Institute> institutesMissingRefs = new ArrayList<Institute>();
	
		//cache for objects to be imported from file (in batch)
		final List<Institute> instituteList = new ArrayList<Institute>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Institute object = new Institute();
			object.set(defaults, false); 
			object.set(tuple, false);				
			instituteList.add(object);		
			
			//add to db when batch size is reached
			if(instituteList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				institutesMissingRefs.addAll(resolveForeignKeys(db, instituteList));
				instituteList.removeAll(institutesMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'name' defined in xref_label
				db.update(instituteList,dbAction, "name");
				
				//clear for next batch						
				instituteList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!instituteList.isEmpty())
		{
			total.set(total.get() + instituteList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			institutesMissingRefs.addAll(resolveForeignKeys(db, instituteList));
			instituteList.removeAll(institutesMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'name' defined in xref_label
			db.update(instituteList,dbAction, "name");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<Institute> institutes = new ArrayList<Institute>(institutesMissingRefs);

		int iterationCount = 0;

		do
		{
			institutesMissingRefs = resolveForeignKeys(db, institutesMissingRefs);
			@SuppressWarnings("unchecked")
			List<Institute> resolvableinstitutes = new ArrayList<Institute>(CollectionUtils.disjunction(institutes,
					institutesMissingRefs));
			institutes.removeAll(resolvableinstitutes);
			
			db.update(resolvableinstitutes,dbAction, "name");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'institute' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still institutes referring to Individuals that are neither in the database nor in the list of to-be imported institutes."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (institutesMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " institute from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param instituteList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Institute> resolveForeignKeys(Database db, List<Institute> instituteList) throws Exception
	{
		//keep a list of Institute instances that miss a reference which might be resolvable later
		List<Institute> institutesMissingRefs = new ArrayList<Institute>();
	
		//update objects with foreign key values
		for(Institute o:  instituteList)
		{
			while(true){
				break;
			}
		}
		
		
		return institutesMissingRefs;
	}
}

