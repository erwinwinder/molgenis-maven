
/* File:        org.molgenis.omx/model/MolgenisEntity.java
 * Copyright:   GBIC 2000-2013, all rights reserved
 * Date:        January 2, 2013
 * 
 * generator:   org.molgenis.generators.csv.CsvReaderGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.core.csv;

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

import org.molgenis.core.MolgenisEntity;


/**
 * Reads MolgenisEntity from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class MolgenisEntityCsvReader extends CsvToDatabase<MolgenisEntity>
{
	private static final Logger logger = Logger.getLogger(MolgenisEntityCsvReader.class);
	
			
	/**
	 * Imports MolgenisEntity from tab/comma delimited File
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
		List<MolgenisEntity> molgenisEntitysMissingRefs = new ArrayList<MolgenisEntity>();
	
		//cache for objects to be imported from file (in batch)
		final List<MolgenisEntity> molgenisEntityList = new ArrayList<MolgenisEntity>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			MolgenisEntity object = new MolgenisEntity();
			object.set(defaults, false); 
			object.set(tuple, false);				
			molgenisEntityList.add(object);		
			
			//add to db when batch size is reached
			if(molgenisEntityList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				molgenisEntitysMissingRefs.addAll(resolveForeignKeys(db, molgenisEntityList));
				molgenisEntityList.removeAll(molgenisEntitysMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'className' defined in xref_label
				db.update(molgenisEntityList,dbAction, "className");
				
				//clear for next batch						
				molgenisEntityList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!molgenisEntityList.isEmpty())
		{
			total.set(total.get() + molgenisEntityList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			molgenisEntitysMissingRefs.addAll(resolveForeignKeys(db, molgenisEntityList));
			molgenisEntityList.removeAll(molgenisEntitysMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'className' defined in xref_label
			db.update(molgenisEntityList,dbAction, "className");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<MolgenisEntity> molgenisEntitys = new ArrayList<MolgenisEntity>(molgenisEntitysMissingRefs);

		int iterationCount = 0;

		do
		{
			molgenisEntitysMissingRefs = resolveForeignKeys(db, molgenisEntitysMissingRefs);
			@SuppressWarnings("unchecked")
			List<MolgenisEntity> resolvablemolgenisEntitys = new ArrayList<MolgenisEntity>(CollectionUtils.disjunction(molgenisEntitys,
					molgenisEntitysMissingRefs));
			molgenisEntitys.removeAll(resolvablemolgenisEntitys);
			
			db.update(resolvablemolgenisEntitys,dbAction, "className");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'molgenisEntity' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still molgenisEntitys referring to Individuals that are neither in the database nor in the list of to-be imported molgenisEntitys."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (molgenisEntitysMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " molgenisEntity from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param molgenisEntityList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<MolgenisEntity> resolveForeignKeys(Database db, List<MolgenisEntity> molgenisEntityList) throws Exception
	{
		//keep a list of MolgenisEntity instances that miss a reference which might be resolvable later
		List<MolgenisEntity> molgenisEntitysMissingRefs = new ArrayList<MolgenisEntity>();
	
		//update objects with foreign key values
		for(MolgenisEntity o:  molgenisEntityList)
		{
			while(true){
				break;
			}
		}
		
		
		return molgenisEntitysMissingRefs;
	}
}

