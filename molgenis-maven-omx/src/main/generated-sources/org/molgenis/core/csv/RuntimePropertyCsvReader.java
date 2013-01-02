
/* File:        org.molgenis.omx/model/RuntimeProperty.java
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

import org.molgenis.core.RuntimeProperty;


/**
 * Reads RuntimeProperty from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class RuntimePropertyCsvReader extends CsvToDatabase<RuntimeProperty>
{
	private static final Logger logger = Logger.getLogger(RuntimePropertyCsvReader.class);
	
			
	/**
	 * Imports RuntimeProperty from tab/comma delimited File
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
		List<RuntimeProperty> runtimePropertysMissingRefs = new ArrayList<RuntimeProperty>();
	
		//cache for objects to be imported from file (in batch)
		final List<RuntimeProperty> runtimePropertyList = new ArrayList<RuntimeProperty>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			RuntimeProperty object = new RuntimeProperty();
			object.set(defaults, false); 
			object.set(tuple, false);				
			runtimePropertyList.add(object);		
			
			//add to db when batch size is reached
			if(runtimePropertyList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				runtimePropertysMissingRefs.addAll(resolveForeignKeys(db, runtimePropertyList));
				runtimePropertyList.removeAll(runtimePropertysMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'Name' defined in xref_label
				db.update(runtimePropertyList,dbAction, "Name");
				
				//clear for next batch						
				runtimePropertyList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!runtimePropertyList.isEmpty())
		{
			total.set(total.get() + runtimePropertyList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			runtimePropertysMissingRefs.addAll(resolveForeignKeys(db, runtimePropertyList));
			runtimePropertyList.removeAll(runtimePropertysMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'Name' defined in xref_label
			db.update(runtimePropertyList,dbAction, "Name");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<RuntimeProperty> runtimePropertys = new ArrayList<RuntimeProperty>(runtimePropertysMissingRefs);

		int iterationCount = 0;

		do
		{
			runtimePropertysMissingRefs = resolveForeignKeys(db, runtimePropertysMissingRefs);
			@SuppressWarnings("unchecked")
			List<RuntimeProperty> resolvableruntimePropertys = new ArrayList<RuntimeProperty>(CollectionUtils.disjunction(runtimePropertys,
					runtimePropertysMissingRefs));
			runtimePropertys.removeAll(resolvableruntimePropertys);
			
			db.update(resolvableruntimePropertys,dbAction, "Name");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'runtimeProperty' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still runtimePropertys referring to Individuals that are neither in the database nor in the list of to-be imported runtimePropertys."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (runtimePropertysMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " runtimeProperty from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param runtimePropertyList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<RuntimeProperty> resolveForeignKeys(Database db, List<RuntimeProperty> runtimePropertyList) throws Exception
	{
		//keep a list of RuntimeProperty instances that miss a reference which might be resolvable later
		List<RuntimeProperty> runtimePropertysMissingRefs = new ArrayList<RuntimeProperty>();
	
		//update objects with foreign key values
		for(RuntimeProperty o:  runtimePropertyList)
		{
			while(true){
				break;
			}
		}
		
		
		return runtimePropertysMissingRefs;
	}
}

