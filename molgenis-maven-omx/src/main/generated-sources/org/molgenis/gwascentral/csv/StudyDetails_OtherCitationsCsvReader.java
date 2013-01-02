
/* File:        org.molgenis.omx/model/StudyDetails_otherCitations.java
 * Copyright:   GBIC 2000-2013, all rights reserved
 * Date:        January 2, 2013
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

import org.molgenis.organization.Citation;
import org.molgenis.gwascentral.StudyDetails;
import org.molgenis.gwascentral.StudyDetails_OtherCitations;


/**
 * Reads StudyDetails_OtherCitations from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class StudyDetails_OtherCitationsCsvReader extends CsvToDatabase<StudyDetails_OtherCitations>
{
	private static final Logger logger = Logger.getLogger(StudyDetails_OtherCitationsCsvReader.class);
	
	//foreign key map for xref 'otherCitations' (maps citation.Identifier -> citation.id)			
	final Map<String,Integer> otherCitationsKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports StudyDetails_OtherCitations from tab/comma delimited File
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
		List<StudyDetails_OtherCitations> studyDetails_otherCitationssMissingRefs = new ArrayList<StudyDetails_OtherCitations>();
	
		//cache for objects to be imported from file (in batch)
		final List<StudyDetails_OtherCitations> studyDetails_otherCitationsList = new ArrayList<StudyDetails_OtherCitations>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			StudyDetails_OtherCitations object = new StudyDetails_OtherCitations();
			object.set(defaults, false); 
			object.set(tuple, false);				
			studyDetails_otherCitationsList.add(object);		
			
			//add to db when batch size is reached
			if(studyDetails_otherCitationsList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				studyDetails_otherCitationssMissingRefs.addAll(resolveForeignKeys(db, studyDetails_otherCitationsList));
				studyDetails_otherCitationsList.removeAll(studyDetails_otherCitationssMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'otherCitations,StudyDetails' defined in xref_label
				db.update(studyDetails_otherCitationsList,dbAction, "otherCitations", "StudyDetails");
				
				//clear for next batch						
				studyDetails_otherCitationsList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!studyDetails_otherCitationsList.isEmpty())
		{
			total.set(total.get() + studyDetails_otherCitationsList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			studyDetails_otherCitationssMissingRefs.addAll(resolveForeignKeys(db, studyDetails_otherCitationsList));
			studyDetails_otherCitationsList.removeAll(studyDetails_otherCitationssMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'otherCitations,StudyDetails' defined in xref_label
			db.update(studyDetails_otherCitationsList,dbAction, "otherCitations", "StudyDetails");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<StudyDetails_OtherCitations> studyDetails_otherCitationss = new ArrayList<StudyDetails_OtherCitations>(studyDetails_otherCitationssMissingRefs);

		int iterationCount = 0;

		do
		{
			studyDetails_otherCitationssMissingRefs = resolveForeignKeys(db, studyDetails_otherCitationssMissingRefs);
			@SuppressWarnings("unchecked")
			List<StudyDetails_OtherCitations> resolvablestudyDetails_otherCitationss = new ArrayList<StudyDetails_OtherCitations>(CollectionUtils.disjunction(studyDetails_otherCitationss,
					studyDetails_otherCitationssMissingRefs));
			studyDetails_otherCitationss.removeAll(resolvablestudyDetails_otherCitationss);
			
			db.update(resolvablestudyDetails_otherCitationss,dbAction, "otherCitations", "StudyDetails");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'studyDetails_otherCitations' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still studyDetails_otherCitationss referring to Individuals that are neither in the database nor in the list of to-be imported studyDetails_otherCitationss."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (studyDetails_otherCitationssMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " studyDetails_otherCitations from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param studyDetails_otherCitationsList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<StudyDetails_OtherCitations> resolveForeignKeys(Database db, List<StudyDetails_OtherCitations> studyDetails_otherCitationsList) throws Exception
	{
		//keep a list of StudyDetails_otherCitations instances that miss a reference which might be resolvable later
		List<StudyDetails_OtherCitations> studyDetails_otherCitationssMissingRefs = new ArrayList<StudyDetails_OtherCitations>();
	
		//resolve xref 'otherCitations' from citation.Identifier -> citation.id
		for(StudyDetails_OtherCitations o: studyDetails_otherCitationsList) 
		{
			if(o.getOtherCitations_Identifier() != null) 
				otherCitationsKeymap.put(o.getOtherCitations_Identifier(), null);
		}
		
		if(otherCitationsKeymap.size() > 0) 
		{
			List<Citation> otherCitationsList = db.query(Citation.class).in("Identifier",new ArrayList<Object>(otherCitationsKeymap.keySet())).find();
			for(Citation xref :  otherCitationsList)
			{
				otherCitationsKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(StudyDetails_OtherCitations o:  studyDetails_otherCitationsList)
		{
			while(true){
				//update xref otherCitations
				if(o.getOtherCitations_Identifier() != null) 
				{
					String key = o.getOtherCitations_Identifier();
					if(otherCitationsKeymap.get(key) == null)
					{
						throw new Exception("Import of 'StudyDetails_otherCitations' objects failed: cannot find Citation for otherCitations_Identifier='"+o.getOtherCitations_Identifier()+"'");
					}
					o.setOtherCitations_Id(otherCitationsKeymap.get(key));
				}
				break;
			}
		}
		
		otherCitationsKeymap.clear();
		
		return studyDetails_otherCitationssMissingRefs;
	}
}

