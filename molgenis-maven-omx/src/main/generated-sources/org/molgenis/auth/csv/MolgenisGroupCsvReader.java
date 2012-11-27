
/* File:        org.molgenis/model/MolgenisGroup.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 26, 2012
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

import org.molgenis.auth.MolgenisGroup;


/**
 * Reads MolgenisGroup from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class MolgenisGroupCsvReader extends CsvToDatabase<MolgenisGroup>
{
	private static final Logger logger = Logger.getLogger(MolgenisGroupCsvReader.class);
	
			
	/**
	 * Imports MolgenisGroup from tab/comma delimited File
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
		List<MolgenisGroup> molgenisGroupsMissingRefs = new ArrayList<MolgenisGroup>();
	
		//cache for objects to be imported from file (in batch)
		final List<MolgenisGroup> molgenisGroupList = new ArrayList<MolgenisGroup>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			MolgenisGroup object = new MolgenisGroup();
			object.set(defaults, false); 
			object.set(tuple, false);				
			molgenisGroupList.add(object);		
			
			//add to db when batch size is reached
			if(molgenisGroupList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				molgenisGroupsMissingRefs.addAll(resolveForeignKeys(db, molgenisGroupList));
				molgenisGroupList.removeAll(molgenisGroupsMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'name' defined in xref_label
				db.update(molgenisGroupList,dbAction, "name");
				
				//clear for next batch						
				molgenisGroupList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!molgenisGroupList.isEmpty())
		{
			total.set(total.get() + molgenisGroupList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			molgenisGroupsMissingRefs.addAll(resolveForeignKeys(db, molgenisGroupList));
			molgenisGroupList.removeAll(molgenisGroupsMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'name' defined in xref_label
			db.update(molgenisGroupList,dbAction, "name");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<MolgenisGroup> molgenisGroups = new ArrayList<MolgenisGroup>(molgenisGroupsMissingRefs);

		int iterationCount = 0;

		do
		{
			molgenisGroupsMissingRefs = resolveForeignKeys(db, molgenisGroupsMissingRefs);
			@SuppressWarnings("unchecked")
			List<MolgenisGroup> resolvablemolgenisGroups = new ArrayList<MolgenisGroup>(CollectionUtils.disjunction(molgenisGroups,
					molgenisGroupsMissingRefs));
			molgenisGroups.removeAll(resolvablemolgenisGroups);
			
			db.update(resolvablemolgenisGroups,dbAction, "name");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'molgenisGroup' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still molgenisGroups referring to Individuals that are neither in the database nor in the list of to-be imported molgenisGroups."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (molgenisGroupsMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " molgenisGroup from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param molgenisGroupList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<MolgenisGroup> resolveForeignKeys(Database db, List<MolgenisGroup> molgenisGroupList) throws Exception
	{
		//keep a list of MolgenisGroup instances that miss a reference which might be resolvable later
		List<MolgenisGroup> molgenisGroupsMissingRefs = new ArrayList<MolgenisGroup>();
	
		//update objects with foreign key values
		for(MolgenisGroup o:  molgenisGroupList)
		{
			while(true){
				break;
			}
		}
		
		
		return molgenisGroupsMissingRefs;
	}
}

