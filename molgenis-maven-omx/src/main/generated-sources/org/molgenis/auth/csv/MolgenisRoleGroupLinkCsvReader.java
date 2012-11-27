
/* File:        org.molgenis/model/MolgenisRoleGroupLink.java
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

import org.molgenis.auth.MolgenisGroup;
import org.molgenis.auth.MolgenisRole;
import org.molgenis.auth.MolgenisRoleGroupLink;


/**
 * Reads MolgenisRoleGroupLink from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class MolgenisRoleGroupLinkCsvReader extends CsvToDatabase<MolgenisRoleGroupLink>
{
	private static final Logger logger = Logger.getLogger(MolgenisRoleGroupLinkCsvReader.class);
	
	//foreign key map for xref 'group_' (maps molgenisGroup.name -> molgenisGroup.id)			
	final Map<String,Integer> group_Keymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'role_' (maps molgenisRole.name -> molgenisRole.id)			
	final Map<String,Integer> role_Keymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports MolgenisRoleGroupLink from tab/comma delimited File
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
		List<MolgenisRoleGroupLink> molgenisRoleGroupLinksMissingRefs = new ArrayList<MolgenisRoleGroupLink>();
	
		//cache for objects to be imported from file (in batch)
		final List<MolgenisRoleGroupLink> molgenisRoleGroupLinkList = new ArrayList<MolgenisRoleGroupLink>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			MolgenisRoleGroupLink object = new MolgenisRoleGroupLink();
			object.set(defaults, false); 
			object.set(tuple, false);				
			molgenisRoleGroupLinkList.add(object);		
			
			//add to db when batch size is reached
			if(molgenisRoleGroupLinkList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				molgenisRoleGroupLinksMissingRefs.addAll(resolveForeignKeys(db, molgenisRoleGroupLinkList));
				molgenisRoleGroupLinkList.removeAll(molgenisRoleGroupLinksMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
				db.update(molgenisRoleGroupLinkList,dbAction, "Identifier");
				
				//clear for next batch						
				molgenisRoleGroupLinkList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!molgenisRoleGroupLinkList.isEmpty())
		{
			total.set(total.get() + molgenisRoleGroupLinkList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			molgenisRoleGroupLinksMissingRefs.addAll(resolveForeignKeys(db, molgenisRoleGroupLinkList));
			molgenisRoleGroupLinkList.removeAll(molgenisRoleGroupLinksMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
			db.update(molgenisRoleGroupLinkList,dbAction, "Identifier");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<MolgenisRoleGroupLink> molgenisRoleGroupLinks = new ArrayList<MolgenisRoleGroupLink>(molgenisRoleGroupLinksMissingRefs);

		int iterationCount = 0;

		do
		{
			molgenisRoleGroupLinksMissingRefs = resolveForeignKeys(db, molgenisRoleGroupLinksMissingRefs);
			@SuppressWarnings("unchecked")
			List<MolgenisRoleGroupLink> resolvablemolgenisRoleGroupLinks = new ArrayList<MolgenisRoleGroupLink>(CollectionUtils.disjunction(molgenisRoleGroupLinks,
					molgenisRoleGroupLinksMissingRefs));
			molgenisRoleGroupLinks.removeAll(resolvablemolgenisRoleGroupLinks);
			
			db.update(resolvablemolgenisRoleGroupLinks,dbAction, "Identifier");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'molgenisRoleGroupLink' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still molgenisRoleGroupLinks referring to Individuals that are neither in the database nor in the list of to-be imported molgenisRoleGroupLinks."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (molgenisRoleGroupLinksMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " molgenisRoleGroupLink from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param molgenisRoleGroupLinkList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<MolgenisRoleGroupLink> resolveForeignKeys(Database db, List<MolgenisRoleGroupLink> molgenisRoleGroupLinkList) throws Exception
	{
		//keep a list of MolgenisRoleGroupLink instances that miss a reference which might be resolvable later
		List<MolgenisRoleGroupLink> molgenisRoleGroupLinksMissingRefs = new ArrayList<MolgenisRoleGroupLink>();
	
		//resolve xref 'group_' from molgenisGroup.name -> molgenisGroup.id
		for(MolgenisRoleGroupLink o: molgenisRoleGroupLinkList) 
		{
			if(o.getGroup_Name() != null) 
				group_Keymap.put(o.getGroup_Name(), null);
		}
		
		if(group_Keymap.size() > 0) 
		{
			List<MolgenisGroup> group_List = db.query(MolgenisGroup.class).in("name",new ArrayList<Object>(group_Keymap.keySet())).find();
			for(MolgenisGroup xref :  group_List)
			{
				group_Keymap.put(xref.getName(), xref.getId());
			}
		}
		//resolve xref 'role_' from molgenisRole.name -> molgenisRole.id
		for(MolgenisRoleGroupLink o: molgenisRoleGroupLinkList) 
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
		//update objects with foreign key values
		for(MolgenisRoleGroupLink o:  molgenisRoleGroupLinkList)
		{
			while(true){
				//update xref group_
				if(o.getGroup_Name() != null) 
				{
					String key = o.getGroup_Name();
					if(group_Keymap.get(key) == null)
					{
						throw new Exception("Import of 'MolgenisRoleGroupLink' objects failed: cannot find MolgenisGroup for group__name='"+o.getGroup_Name()+"'");
					}
					o.setGroup_Id(group_Keymap.get(key));
				}
				//update xref role_
				if(o.getRole_Name() != null) 
				{
					String key = o.getRole_Name();
					if(role_Keymap.get(key) == null)
					{
						throw new Exception("Import of 'MolgenisRoleGroupLink' objects failed: cannot find MolgenisRole for role__name='"+o.getRole_Name()+"'");
					}
					o.setRole_Id(role_Keymap.get(key));
				}
				break;
			}
		}
		
		group_Keymap.clear();
		role_Keymap.clear();
		
		return molgenisRoleGroupLinksMissingRefs;
	}
}

