
/* File:        org.molgenis/model/Submission.java
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

import org.molgenis.organization.Study;
import org.molgenis.organization.Submission;


/**
 * Reads Submission from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class SubmissionCsvReader extends CsvToDatabase<Submission>
{
	private static final Logger logger = Logger.getLogger(SubmissionCsvReader.class);
	
	//foreign key map for xref 'study' (maps study.Identifier -> study.id)			
	final Map<String,Integer> studyKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports Submission from tab/comma delimited File
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
		List<Submission> submissionsMissingRefs = new ArrayList<Submission>();
	
		//cache for objects to be imported from file (in batch)
		final List<Submission> submissionList = new ArrayList<Submission>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Submission object = new Submission();
			object.set(defaults, false); 
			object.set(tuple, false);				
			submissionList.add(object);		
			
			//add to db when batch size is reached
			if(submissionList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				submissionsMissingRefs.addAll(resolveForeignKeys(db, submissionList));
				submissionList.removeAll(submissionsMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
				db.update(submissionList,dbAction, "Identifier");
				
				//clear for next batch						
				submissionList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!submissionList.isEmpty())
		{
			total.set(total.get() + submissionList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			submissionsMissingRefs.addAll(resolveForeignKeys(db, submissionList));
			submissionList.removeAll(submissionsMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
			db.update(submissionList,dbAction, "Identifier");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<Submission> submissions = new ArrayList<Submission>(submissionsMissingRefs);

		int iterationCount = 0;

		do
		{
			submissionsMissingRefs = resolveForeignKeys(db, submissionsMissingRefs);
			@SuppressWarnings("unchecked")
			List<Submission> resolvablesubmissions = new ArrayList<Submission>(CollectionUtils.disjunction(submissions,
					submissionsMissingRefs));
			submissions.removeAll(resolvablesubmissions);
			
			db.update(resolvablesubmissions,dbAction, "Identifier");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'submission' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still submissions referring to Individuals that are neither in the database nor in the list of to-be imported submissions."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (submissionsMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " submission from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param submissionList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Submission> resolveForeignKeys(Database db, List<Submission> submissionList) throws Exception
	{
		//keep a list of Submission instances that miss a reference which might be resolvable later
		List<Submission> submissionsMissingRefs = new ArrayList<Submission>();
	
		//resolve xref 'study' from study.Identifier -> study.id
		for(Submission o: submissionList) 
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
		//update objects with foreign key values
		for(Submission o:  submissionList)
		{
			while(true){
				//update xref Study
				if(o.getStudy_Identifier() != null) 
				{
					String key = o.getStudy_Identifier();
					if(studyKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Submission' objects failed: cannot find Study for study_Identifier='"+o.getStudy_Identifier()+"'");
					}
					o.setStudy_Id(studyKeymap.get(key));
				}
				break;
			}
		}
		
		studyKeymap.clear();
		
		return submissionsMissingRefs;
	}
}

