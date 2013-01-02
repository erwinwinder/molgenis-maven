
/* File:        org.molgenis.omx/model/Citation.java
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

import org.molgenis.observ.target.OntologyTerm;
import org.molgenis.organization.Citation;


/**
 * Reads Citation from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class CitationCsvReader extends CsvToDatabase<Citation>
{
	private static final Logger logger = Logger.getLogger(CitationCsvReader.class);
	
	//foreign key map for xref 'ontologyTerms' (maps ontologyTerm.Identifier -> ontologyTerm.id)			
	final Map<String,Integer> ontologyTermsKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'status' (maps ontologyTerm.Identifier -> ontologyTerm.id)			
	final Map<String,Integer> statusKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports Citation from tab/comma delimited File
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
		List<Citation> citationsMissingRefs = new ArrayList<Citation>();
	
		//cache for objects to be imported from file (in batch)
		final List<Citation> citationList = new ArrayList<Citation>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Citation object = new Citation();
			object.set(defaults, false); 
			object.set(tuple, false);				
			citationList.add(object);		
			
			//add to db when batch size is reached
			if(citationList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				citationsMissingRefs.addAll(resolveForeignKeys(db, citationList));
				citationList.removeAll(citationsMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
				db.update(citationList,dbAction, "Identifier");
				
				//clear for next batch						
				citationList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!citationList.isEmpty())
		{
			total.set(total.get() + citationList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			citationsMissingRefs.addAll(resolveForeignKeys(db, citationList));
			citationList.removeAll(citationsMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
			db.update(citationList,dbAction, "Identifier");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<Citation> citations = new ArrayList<Citation>(citationsMissingRefs);

		int iterationCount = 0;

		do
		{
			citationsMissingRefs = resolveForeignKeys(db, citationsMissingRefs);
			@SuppressWarnings("unchecked")
			List<Citation> resolvablecitations = new ArrayList<Citation>(CollectionUtils.disjunction(citations,
					citationsMissingRefs));
			citations.removeAll(resolvablecitations);
			
			db.update(resolvablecitations,dbAction, "Identifier");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'citation' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still citations referring to Individuals that are neither in the database nor in the list of to-be imported citations."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (citationsMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " citation from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param citationList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Citation> resolveForeignKeys(Database db, List<Citation> citationList) throws Exception
	{
		//keep a list of Citation instances that miss a reference which might be resolvable later
		List<Citation> citationsMissingRefs = new ArrayList<Citation>();
	
		//resolve xref 'ontologyTerms' from ontologyTerm.Identifier -> ontologyTerm.id
		for(Citation o: citationList) for(String xref_label: o.getOntologyTerms_Identifier())
		{
			if(xref_label != null) 
				ontologyTermsKeymap.put(xref_label, null);
		}
		
		if(ontologyTermsKeymap.size() > 0) 
		{
			List<OntologyTerm> ontologyTermsList = db.query(OntologyTerm.class).in("Identifier",new ArrayList<Object>(ontologyTermsKeymap.keySet())).find();
			for(OntologyTerm xref :  ontologyTermsList)
			{
				ontologyTermsKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//resolve xref 'status' from ontologyTerm.Identifier -> ontologyTerm.id
		for(Citation o: citationList) 
		{
			if(o.getStatus_Identifier() != null) 
				statusKeymap.put(o.getStatus_Identifier(), null);
		}
		
		if(statusKeymap.size() > 0) 
		{
			List<OntologyTerm> statusList = db.query(OntologyTerm.class).in("Identifier",new ArrayList<Object>(statusKeymap.keySet())).find();
			for(OntologyTerm xref :  statusList)
			{
				statusKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(Citation o:  citationList)
		{
			while(true){
				//update mref ontologyTerms
				if(o.getOntologyTerms_Identifier() != null) 
				{
					List<Integer> mrefs = new ArrayList<Integer>();
					boolean breakToNextCitation = false;

					int listSize = 0;
					if(o.getOntologyTerms_Identifier() != null) listSize = Math.max(o.getOntologyTerms_Identifier().size(), listSize);
					for(int i = 0; i < listSize; i++)
					{
						String key = o.getOntologyTerms_Identifier().get(i);
						if(ontologyTermsKeymap.get(key) == null){
							logger.error("Import of 'Citation' objects failed: "+o);
							throw new Exception("Import of 'Citation' objects failed: cannot find ontologyTerms_Identifier='"+(o.getOntologyTerms_Identifier() != null && i < o.getOntologyTerms_Identifier().size() ? o.getOntologyTerms_Identifier().get(i) : "null")+"'");
						}
						mrefs.add(ontologyTermsKeymap.get(key));
					}
					if(breakToNextCitation){
						break;
					}
					o.setOntologyTerms_Id(mrefs);
				}
				//update xref Status
				if(o.getStatus_Identifier() != null) 
				{
					String key = o.getStatus_Identifier();
					if(statusKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Citation' objects failed: cannot find OntologyTerm for status_Identifier='"+o.getStatus_Identifier()+"'");
					}
					o.setStatus_Id(statusKeymap.get(key));
				}
				break;
			}
		}
		
		ontologyTermsKeymap.clear();
		statusKeymap.clear();
		
		return citationsMissingRefs;
	}
}

