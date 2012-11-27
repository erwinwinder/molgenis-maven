
/* File:        org.molgenis/model/Study.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 26, 2012
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

import org.molgenis.organization.Person;
import org.molgenis.gwascentral.Investigation;
import org.molgenis.organization.Study;


/**
 * Reads Study from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class StudyCsvReader extends CsvToDatabase<Study>
{
	private static final Logger logger = Logger.getLogger(StudyCsvReader.class);
	
	//foreign key map for xref 'contact' (maps person.Name -> person.id)			
	final Map<String,Integer> contactKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'partOfInvestigation' (maps investigation.Identifier -> investigation.id)			
	final Map<String,Integer> partOfInvestigationKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports Study from tab/comma delimited File
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
		List<Study> studysMissingRefs = new ArrayList<Study>();
	
		//cache for objects to be imported from file (in batch)
		final List<Study> studyList = new ArrayList<Study>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Study object = new Study();
			object.set(defaults, false); 
			object.set(tuple, false);				
			studyList.add(object);		
			
			//add to db when batch size is reached
			if(studyList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				studysMissingRefs.addAll(resolveForeignKeys(db, studyList));
				studyList.removeAll(studysMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
				db.update(studyList,dbAction, "Identifier");
				
				//clear for next batch						
				studyList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!studyList.isEmpty())
		{
			total.set(total.get() + studyList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			studysMissingRefs.addAll(resolveForeignKeys(db, studyList));
			studyList.removeAll(studysMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
			db.update(studyList,dbAction, "Identifier");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<Study> studys = new ArrayList<Study>(studysMissingRefs);

		int iterationCount = 0;

		do
		{
			studysMissingRefs = resolveForeignKeys(db, studysMissingRefs);
			@SuppressWarnings("unchecked")
			List<Study> resolvablestudys = new ArrayList<Study>(CollectionUtils.disjunction(studys,
					studysMissingRefs));
			studys.removeAll(resolvablestudys);
			
			db.update(resolvablestudys,dbAction, "Identifier");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'study' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still studys referring to Individuals that are neither in the database nor in the list of to-be imported studys."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (studysMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " study from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param studyList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Study> resolveForeignKeys(Database db, List<Study> studyList) throws Exception
	{
		//keep a list of Study instances that miss a reference which might be resolvable later
		List<Study> studysMissingRefs = new ArrayList<Study>();
	
		//resolve xref 'contact' from person.Name -> person.id
		for(Study o: studyList) 
		{
			if(o.getContact_Name() != null) 
				contactKeymap.put(o.getContact_Name(), null);
		}
		
		if(contactKeymap.size() > 0) 
		{
			List<Person> contactList = db.query(Person.class).in("Name",new ArrayList<Object>(contactKeymap.keySet())).find();
			for(Person xref :  contactList)
			{
				contactKeymap.put(xref.getName(), xref.getId());
			}
		}
		//resolve xref 'partOfInvestigation' from investigation.Identifier -> investigation.id
		for(Study o: studyList) 
		{
			if(o.getPartOfInvestigation_Identifier() != null) 
				partOfInvestigationKeymap.put(o.getPartOfInvestigation_Identifier(), null);
		}
		
		if(partOfInvestigationKeymap.size() > 0) 
		{
			List<Investigation> partOfInvestigationList = db.query(Investigation.class).in("Identifier",new ArrayList<Object>(partOfInvestigationKeymap.keySet())).find();
			for(Investigation xref :  partOfInvestigationList)
			{
				partOfInvestigationKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(Study o:  studyList)
		{
			while(true){
				//update xref Contact
				if(o.getContact_Name() != null) 
				{
					String key = o.getContact_Name();
					if(contactKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Study' objects failed: cannot find Person for contact_Name='"+o.getContact_Name()+"'");
					}
					o.setContact_Id(contactKeymap.get(key));
				}
				//update xref PartOfInvestigation
				if(o.getPartOfInvestigation_Identifier() != null) 
				{
					String key = o.getPartOfInvestigation_Identifier();
					if(partOfInvestigationKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Study' objects failed: cannot find Investigation for partOfInvestigation_Identifier='"+o.getPartOfInvestigation_Identifier()+"'");
					}
					o.setPartOfInvestigation_Id(partOfInvestigationKeymap.get(key));
				}
				break;
			}
		}
		
		contactKeymap.clear();
		partOfInvestigationKeymap.clear();
		
		return studysMissingRefs;
	}
}

