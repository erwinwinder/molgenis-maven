
/* File:        org.molgenis.omx/model/Contribution.java
 * Copyright:   GBIC 2000-2013, all rights reserved
 * Date:        January 2, 2013
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
import org.molgenis.organization.Submission;
import org.molgenis.organization.Contribution;


/**
 * Reads Contribution from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class ContributionCsvReader extends CsvToDatabase<Contribution>
{
	private static final Logger logger = Logger.getLogger(ContributionCsvReader.class);
	
	//foreign key map for xref 'researcher' (maps person.Name -> person.id)			
	final Map<String,Integer> researcherKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'submission' (maps submission.Identifier -> submission.id)			
	final Map<String,Integer> submissionKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports Contribution from tab/comma delimited File
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
		List<Contribution> contributionsMissingRefs = new ArrayList<Contribution>();
	
		//cache for objects to be imported from file (in batch)
		final List<Contribution> contributionList = new ArrayList<Contribution>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Contribution object = new Contribution();
			object.set(defaults, false); 
			object.set(tuple, false);				
			contributionList.add(object);		
			
			//add to db when batch size is reached
			if(contributionList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				contributionsMissingRefs.addAll(resolveForeignKeys(db, contributionList));
				contributionList.removeAll(contributionsMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
				db.update(contributionList,dbAction, "Identifier");
				
				//clear for next batch						
				contributionList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!contributionList.isEmpty())
		{
			total.set(total.get() + contributionList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			contributionsMissingRefs.addAll(resolveForeignKeys(db, contributionList));
			contributionList.removeAll(contributionsMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
			db.update(contributionList,dbAction, "Identifier");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<Contribution> contributions = new ArrayList<Contribution>(contributionsMissingRefs);

		int iterationCount = 0;

		do
		{
			contributionsMissingRefs = resolveForeignKeys(db, contributionsMissingRefs);
			@SuppressWarnings("unchecked")
			List<Contribution> resolvablecontributions = new ArrayList<Contribution>(CollectionUtils.disjunction(contributions,
					contributionsMissingRefs));
			contributions.removeAll(resolvablecontributions);
			
			db.update(resolvablecontributions,dbAction, "Identifier");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'contribution' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still contributions referring to Individuals that are neither in the database nor in the list of to-be imported contributions."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (contributionsMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " contribution from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param contributionList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Contribution> resolveForeignKeys(Database db, List<Contribution> contributionList) throws Exception
	{
		//keep a list of Contribution instances that miss a reference which might be resolvable later
		List<Contribution> contributionsMissingRefs = new ArrayList<Contribution>();
	
		//resolve xref 'researcher' from person.Name -> person.id
		for(Contribution o: contributionList) 
		{
			if(o.getResearcher_Name() != null) 
				researcherKeymap.put(o.getResearcher_Name(), null);
		}
		
		if(researcherKeymap.size() > 0) 
		{
			List<Person> researcherList = db.query(Person.class).in("Name",new ArrayList<Object>(researcherKeymap.keySet())).find();
			for(Person xref :  researcherList)
			{
				researcherKeymap.put(xref.getName(), xref.getId());
			}
		}
		//resolve xref 'submission' from submission.Identifier -> submission.id
		for(Contribution o: contributionList) 
		{
			if(o.getSubmission_Identifier() != null) 
				submissionKeymap.put(o.getSubmission_Identifier(), null);
		}
		
		if(submissionKeymap.size() > 0) 
		{
			List<Submission> submissionList = db.query(Submission.class).in("Identifier",new ArrayList<Object>(submissionKeymap.keySet())).find();
			for(Submission xref :  submissionList)
			{
				submissionKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(Contribution o:  contributionList)
		{
			while(true){
				//update xref Researcher
				if(o.getResearcher_Name() != null) 
				{
					String key = o.getResearcher_Name();
					if(researcherKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Contribution' objects failed: cannot find Person for researcher_Name='"+o.getResearcher_Name()+"'");
					}
					o.setResearcher_Id(researcherKeymap.get(key));
				}
				//update xref Submission
				if(o.getSubmission_Identifier() != null) 
				{
					String key = o.getSubmission_Identifier();
					if(submissionKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Contribution' objects failed: cannot find Submission for submission_Identifier='"+o.getSubmission_Identifier()+"'");
					}
					o.setSubmission_Id(submissionKeymap.get(key));
				}
				break;
			}
		}
		
		researcherKeymap.clear();
		submissionKeymap.clear();
		
		return contributionsMissingRefs;
	}
}

