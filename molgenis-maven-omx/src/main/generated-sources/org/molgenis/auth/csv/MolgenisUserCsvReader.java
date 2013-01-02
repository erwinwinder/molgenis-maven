
/* File:        org.molgenis.omx/model/MolgenisUser.java
 * Copyright:   GBIC 2000-2013, all rights reserved
 * Date:        January 2, 2013
 * 
 * generator:   org.molgenis.generators.csv.CsvReaderGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.auth.csv;

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

import org.molgenis.auth.MolgenisUser;


/**
 * Reads MolgenisUser from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class MolgenisUserCsvReader extends CsvToDatabase<MolgenisUser>
{
	private static final Logger logger = Logger.getLogger(MolgenisUserCsvReader.class);
	
			
	/**
	 * Imports MolgenisUser from tab/comma delimited File
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
		List<MolgenisUser> molgenisUsersMissingRefs = new ArrayList<MolgenisUser>();
	
		//cache for objects to be imported from file (in batch)
		final List<MolgenisUser> molgenisUserList = new ArrayList<MolgenisUser>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			MolgenisUser object = new MolgenisUser();
			object.set(defaults, false); 
			object.set(tuple, false);				
			molgenisUserList.add(object);		
			
			//add to db when batch size is reached
			if(molgenisUserList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				molgenisUsersMissingRefs.addAll(resolveForeignKeys(db, molgenisUserList));
				molgenisUserList.removeAll(molgenisUsersMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'username' defined in xref_label
				db.update(molgenisUserList,dbAction, "username");
				
				//clear for next batch						
				molgenisUserList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!molgenisUserList.isEmpty())
		{
			total.set(total.get() + molgenisUserList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			molgenisUsersMissingRefs.addAll(resolveForeignKeys(db, molgenisUserList));
			molgenisUserList.removeAll(molgenisUsersMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'username' defined in xref_label
			db.update(molgenisUserList,dbAction, "username");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<MolgenisUser> molgenisUsers = new ArrayList<MolgenisUser>(molgenisUsersMissingRefs);

		int iterationCount = 0;

		do
		{
			molgenisUsersMissingRefs = resolveForeignKeys(db, molgenisUsersMissingRefs);
			@SuppressWarnings("unchecked")
			List<MolgenisUser> resolvablemolgenisUsers = new ArrayList<MolgenisUser>(CollectionUtils.disjunction(molgenisUsers,
					molgenisUsersMissingRefs));
			molgenisUsers.removeAll(resolvablemolgenisUsers);
			
			db.update(resolvablemolgenisUsers,dbAction, "username");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'molgenisUser' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still molgenisUsers referring to Individuals that are neither in the database nor in the list of to-be imported molgenisUsers."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (molgenisUsersMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " molgenisUser from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param molgenisUserList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<MolgenisUser> resolveForeignKeys(Database db, List<MolgenisUser> molgenisUserList) throws Exception
	{
		//keep a list of MolgenisUser instances that miss a reference which might be resolvable later
		List<MolgenisUser> molgenisUsersMissingRefs = new ArrayList<MolgenisUser>();
	
		//update objects with foreign key values
		for(MolgenisUser o:  molgenisUserList)
		{
			while(true){
				break;
			}
		}
		
		
		return molgenisUsersMissingRefs;
	}
}

