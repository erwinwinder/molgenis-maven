
/* File:        org.molgenis.omx/model/MolgenisPermission.java
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

import org.molgenis.auth.MolgenisRole;
import org.molgenis.core.MolgenisEntity;
import org.molgenis.auth.MolgenisPermission;


/**
 * Reads MolgenisPermission from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class MolgenisPermissionCsvReader extends CsvToDatabase<MolgenisPermission>
{
	private static final Logger logger = Logger.getLogger(MolgenisPermissionCsvReader.class);
	
	//foreign key map for xref 'role_' (maps molgenisRole.name -> molgenisRole.id)			
	final Map<String,Integer> role_Keymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'entity' (maps molgenisEntity.className -> molgenisEntity.id)			
	final Map<String,Integer> entityKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports MolgenisPermission from tab/comma delimited File
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
		List<MolgenisPermission> molgenisPermissionsMissingRefs = new ArrayList<MolgenisPermission>();
	
		//cache for objects to be imported from file (in batch)
		final List<MolgenisPermission> molgenisPermissionList = new ArrayList<MolgenisPermission>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			MolgenisPermission object = new MolgenisPermission();
			object.set(defaults, false); 
			object.set(tuple, false);				
			molgenisPermissionList.add(object);		
			
			//add to db when batch size is reached
			if(molgenisPermissionList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				molgenisPermissionsMissingRefs.addAll(resolveForeignKeys(db, molgenisPermissionList));
				molgenisPermissionList.removeAll(molgenisPermissionsMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'id' defined in xref_label
				db.update(molgenisPermissionList,dbAction, "id");
				
				//clear for next batch						
				molgenisPermissionList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!molgenisPermissionList.isEmpty())
		{
			total.set(total.get() + molgenisPermissionList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			molgenisPermissionsMissingRefs.addAll(resolveForeignKeys(db, molgenisPermissionList));
			molgenisPermissionList.removeAll(molgenisPermissionsMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'id' defined in xref_label
			db.update(molgenisPermissionList,dbAction, "id");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<MolgenisPermission> molgenisPermissions = new ArrayList<MolgenisPermission>(molgenisPermissionsMissingRefs);

		int iterationCount = 0;

		do
		{
			molgenisPermissionsMissingRefs = resolveForeignKeys(db, molgenisPermissionsMissingRefs);
			@SuppressWarnings("unchecked")
			List<MolgenisPermission> resolvablemolgenisPermissions = new ArrayList<MolgenisPermission>(CollectionUtils.disjunction(molgenisPermissions,
					molgenisPermissionsMissingRefs));
			molgenisPermissions.removeAll(resolvablemolgenisPermissions);
			
			db.update(resolvablemolgenisPermissions,dbAction, "id");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'molgenisPermission' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still molgenisPermissions referring to Individuals that are neither in the database nor in the list of to-be imported molgenisPermissions."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (molgenisPermissionsMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " molgenisPermission from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param molgenisPermissionList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<MolgenisPermission> resolveForeignKeys(Database db, List<MolgenisPermission> molgenisPermissionList) throws Exception
	{
		//keep a list of MolgenisPermission instances that miss a reference which might be resolvable later
		List<MolgenisPermission> molgenisPermissionsMissingRefs = new ArrayList<MolgenisPermission>();
	
		//resolve xref 'role_' from molgenisRole.name -> molgenisRole.id
		for(MolgenisPermission o: molgenisPermissionList) 
		{
			if(o.getRole_Name() != null) 
				role_Keymap.put(o.getRole_Name(), null);
		}
		
		if(role_Keymap.size() > 0) 
		{
			List<MolgenisRole> role_List = db.query(MolgenisRole.class).in("name",new ArrayList<Object>(role_Keymap.keySet())).find();
			for(MolgenisRole xref :  role_List)
			{
				role_Keymap.put(xref.getName(), xref.getId());
			}
		}
		//resolve xref 'entity' from molgenisEntity.className -> molgenisEntity.id
		for(MolgenisPermission o: molgenisPermissionList) 
		{
			if(o.getEntity_ClassName() != null) 
				entityKeymap.put(o.getEntity_ClassName(), null);
		}
		
		if(entityKeymap.size() > 0) 
		{
			List<MolgenisEntity> entityList = db.query(MolgenisEntity.class).in("className",new ArrayList<Object>(entityKeymap.keySet())).find();
			for(MolgenisEntity xref :  entityList)
			{
				entityKeymap.put(xref.getClassName(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(MolgenisPermission o:  molgenisPermissionList)
		{
			while(true){
				//update xref role_
				if(o.getRole_Name() != null) 
				{
					String key = o.getRole_Name();
					if(role_Keymap.get(key) == null)
					{
						throw new Exception("Import of 'MolgenisPermission' objects failed: cannot find MolgenisRole for role__name='"+o.getRole_Name()+"'");
					}
					o.setRole_Id(role_Keymap.get(key));
				}
				//update xref entity
				if(o.getEntity_ClassName() != null) 
				{
					String key = o.getEntity_ClassName();
					if(entityKeymap.get(key) == null)
					{
						throw new Exception("Import of 'MolgenisPermission' objects failed: cannot find MolgenisEntity for entity_className='"+o.getEntity_ClassName()+"'");
					}
					o.setEntity_Id(entityKeymap.get(key));
				}
				break;
			}
		}
		
		role_Keymap.clear();
		entityKeymap.clear();
		
		return molgenisPermissionsMissingRefs;
	}
}

