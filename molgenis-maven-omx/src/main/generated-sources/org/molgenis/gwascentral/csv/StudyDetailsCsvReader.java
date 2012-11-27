
/* File:        org.molgenis/model/StudyDetails.java
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

import org.molgenis.organization.Study;
import org.molgenis.organization.Citation;
import org.molgenis.gwascentral.StudyDetails;


/**
 * Reads StudyDetails from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class StudyDetailsCsvReader extends CsvToDatabase<StudyDetails>
{
	private static final Logger logger = Logger.getLogger(StudyDetailsCsvReader.class);
	
	//foreign key map for xref 'study' (maps study.Identifier -> study.id)			
	final Map<String,Integer> studyKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'primaryCitation' (maps citation.Identifier -> citation.id)			
	final Map<String,Integer> primaryCitationKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'otherCitations' (maps citation.Identifier -> citation.id)			
	final Map<String,Integer> otherCitationsKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports StudyDetails from tab/comma delimited File
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
		List<StudyDetails> studyDetailssMissingRefs = new ArrayList<StudyDetails>();
	
		//cache for objects to be imported from file (in batch)
		final List<StudyDetails> studyDetailsList = new ArrayList<StudyDetails>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			StudyDetails object = new StudyDetails();
			object.set(defaults, false); 
			object.set(tuple, false);				
			studyDetailsList.add(object);		
			
			//add to db when batch size is reached
			if(studyDetailsList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				studyDetailssMissingRefs.addAll(resolveForeignKeys(db, studyDetailsList));
				studyDetailsList.removeAll(studyDetailssMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'id' defined in xref_label
				db.update(studyDetailsList,dbAction, "id");
				
				//clear for next batch						
				studyDetailsList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!studyDetailsList.isEmpty())
		{
			total.set(total.get() + studyDetailsList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			studyDetailssMissingRefs.addAll(resolveForeignKeys(db, studyDetailsList));
			studyDetailsList.removeAll(studyDetailssMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'id' defined in xref_label
			db.update(studyDetailsList,dbAction, "id");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<StudyDetails> studyDetailss = new ArrayList<StudyDetails>(studyDetailssMissingRefs);

		int iterationCount = 0;

		do
		{
			studyDetailssMissingRefs = resolveForeignKeys(db, studyDetailssMissingRefs);
			@SuppressWarnings("unchecked")
			List<StudyDetails> resolvablestudyDetailss = new ArrayList<StudyDetails>(CollectionUtils.disjunction(studyDetailss,
					studyDetailssMissingRefs));
			studyDetailss.removeAll(resolvablestudyDetailss);
			
			db.update(resolvablestudyDetailss,dbAction, "id");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'studyDetails' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still studyDetailss referring to Individuals that are neither in the database nor in the list of to-be imported studyDetailss."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (studyDetailssMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " studyDetails from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param studyDetailsList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<StudyDetails> resolveForeignKeys(Database db, List<StudyDetails> studyDetailsList) throws Exception
	{
		//keep a list of StudyDetails instances that miss a reference which might be resolvable later
		List<StudyDetails> studyDetailssMissingRefs = new ArrayList<StudyDetails>();
	
		//resolve xref 'study' from study.Identifier -> study.id
		for(StudyDetails o: studyDetailsList) 
		{
			if(o.getStudy_Identifier() != null) 
				studyKeymap.put(o.getStudy_Identifier(), null);
		}
		
		if(studyKeymap.size() > 0) 
		{
			List<Study> studyList = db.query(Study.class).in("Identifier",new ArrayList<Object>(studyKeymap.keySet())).find();
			for(Study xref :  studyList)
			{
				studyKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//resolve xref 'primaryCitation' from citation.Identifier -> citation.id
		for(StudyDetails o: studyDetailsList) 
		{
			if(o.getPrimaryCitation_Identifier() != null) 
				primaryCitationKeymap.put(o.getPrimaryCitation_Identifier(), null);
		}
		
		if(primaryCitationKeymap.size() > 0) 
		{
			List<Citation> primaryCitationList = db.query(Citation.class).in("Identifier",new ArrayList<Object>(primaryCitationKeymap.keySet())).find();
			for(Citation xref :  primaryCitationList)
			{
				primaryCitationKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//resolve xref 'otherCitations' from citation.Identifier -> citation.id
		for(StudyDetails o: studyDetailsList) for(String xref_label: o.getOtherCitations_Identifier())
		{
			if(xref_label != null) 
				otherCitationsKeymap.put(xref_label, null);
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
		for(StudyDetails o:  studyDetailsList)
		{
			while(true){
				//update xref Study
				if(o.getStudy_Identifier() != null) 
				{
					String key = o.getStudy_Identifier();
					if(studyKeymap.get(key) == null)
					{
						throw new Exception("Import of 'StudyDetails' objects failed: cannot find Study for study_Identifier='"+o.getStudy_Identifier()+"'");
					}
					o.setStudy_Id(studyKeymap.get(key));
				}
				//update xref primaryCitation
				if(o.getPrimaryCitation_Identifier() != null) 
				{
					String key = o.getPrimaryCitation_Identifier();
					if(primaryCitationKeymap.get(key) == null)
					{
						throw new Exception("Import of 'StudyDetails' objects failed: cannot find Citation for primaryCitation_Identifier='"+o.getPrimaryCitation_Identifier()+"'");
					}
					o.setPrimaryCitation_Id(primaryCitationKeymap.get(key));
				}
				//update mref otherCitations
				if(o.getOtherCitations_Identifier() != null) 
				{
					List<Integer> mrefs = new ArrayList<Integer>();
					boolean breakToNextStudyDetails = false;

					int listSize = 0;
					if(o.getOtherCitations_Identifier() != null) listSize = Math.max(o.getOtherCitations_Identifier().size(), listSize);
					for(int i = 0; i < listSize; i++)
					{
						String key = o.getOtherCitations_Identifier().get(i);
						if(otherCitationsKeymap.get(key) == null){
							logger.error("Import of 'StudyDetails' objects failed: "+o);
							throw new Exception("Import of 'StudyDetails' objects failed: cannot find otherCitations_Identifier='"+(o.getOtherCitations_Identifier() != null && i < o.getOtherCitations_Identifier().size() ? o.getOtherCitations_Identifier().get(i) : "null")+"'");
						}
						mrefs.add(otherCitationsKeymap.get(key));
					}
					if(breakToNextStudyDetails){
						break;
					}
					o.setOtherCitations_Id(mrefs);
				}
				break;
			}
		}
		
		studyKeymap.clear();
		primaryCitationKeymap.clear();
		otherCitationsKeymap.clear();
		
		return studyDetailssMissingRefs;
	}
}

