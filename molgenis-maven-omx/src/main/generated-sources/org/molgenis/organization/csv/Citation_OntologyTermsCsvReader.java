
/* File:        org.molgenis/model/Citation_ontologyTerms.java
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

import org.molgenis.observ.target.OntologyTerm;
import org.molgenis.organization.Citation;
import org.molgenis.organization.Citation_OntologyTerms;


/**
 * Reads Citation_OntologyTerms from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class Citation_OntologyTermsCsvReader extends CsvToDatabase<Citation_OntologyTerms>
{
	private static final Logger logger = Logger.getLogger(Citation_OntologyTermsCsvReader.class);
	
	//foreign key map for xref 'ontologyTerms' (maps ontologyTerm.Identifier -> ontologyTerm.id)			
	final Map<String,Integer> ontologyTermsKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'citation' (maps citation.Identifier -> citation.id)			
	final Map<String,Integer> citationKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports Citation_OntologyTerms from tab/comma delimited File
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
		List<Citation_OntologyTerms> citation_ontologyTermssMissingRefs = new ArrayList<Citation_OntologyTerms>();
	
		//cache for objects to be imported from file (in batch)
		final List<Citation_OntologyTerms> citation_ontologyTermsList = new ArrayList<Citation_OntologyTerms>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Citation_OntologyTerms object = new Citation_OntologyTerms();
			object.set(defaults, false); 
			object.set(tuple, false);				
			citation_ontologyTermsList.add(object);		
			
			//add to db when batch size is reached
			if(citation_ontologyTermsList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				citation_ontologyTermssMissingRefs.addAll(resolveForeignKeys(db, citation_ontologyTermsList));
				citation_ontologyTermsList.removeAll(citation_ontologyTermssMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'ontologyTerms,Citation' defined in xref_label
				db.update(citation_ontologyTermsList,dbAction, "ontologyTerms", "Citation");
				
				//clear for next batch						
				citation_ontologyTermsList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!citation_ontologyTermsList.isEmpty())
		{
			total.set(total.get() + citation_ontologyTermsList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			citation_ontologyTermssMissingRefs.addAll(resolveForeignKeys(db, citation_ontologyTermsList));
			citation_ontologyTermsList.removeAll(citation_ontologyTermssMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'ontologyTerms,Citation' defined in xref_label
			db.update(citation_ontologyTermsList,dbAction, "ontologyTerms", "Citation");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<Citation_OntologyTerms> citation_ontologyTermss = new ArrayList<Citation_OntologyTerms>(citation_ontologyTermssMissingRefs);

		int iterationCount = 0;

		do
		{
			citation_ontologyTermssMissingRefs = resolveForeignKeys(db, citation_ontologyTermssMissingRefs);
			@SuppressWarnings("unchecked")
			List<Citation_OntologyTerms> resolvablecitation_ontologyTermss = new ArrayList<Citation_OntologyTerms>(CollectionUtils.disjunction(citation_ontologyTermss,
					citation_ontologyTermssMissingRefs));
			citation_ontologyTermss.removeAll(resolvablecitation_ontologyTermss);
			
			db.update(resolvablecitation_ontologyTermss,dbAction, "ontologyTerms", "Citation");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'citation_ontologyTerms' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still citation_ontologyTermss referring to Individuals that are neither in the database nor in the list of to-be imported citation_ontologyTermss."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (citation_ontologyTermssMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " citation_ontologyTerms from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param citation_ontologyTermsList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Citation_OntologyTerms> resolveForeignKeys(Database db, List<Citation_OntologyTerms> citation_ontologyTermsList) throws Exception
	{
		//keep a list of Citation_ontologyTerms instances that miss a reference which might be resolvable later
		List<Citation_OntologyTerms> citation_ontologyTermssMissingRefs = new ArrayList<Citation_OntologyTerms>();
	
		//resolve xref 'ontologyTerms' from ontologyTerm.Identifier -> ontologyTerm.id
		for(Citation_OntologyTerms o: citation_ontologyTermsList) 
		{
			if(o.getOntologyTerms_Identifier() != null) 
				ontologyTermsKeymap.put(o.getOntologyTerms_Identifier(), null);
		}
		
		if(ontologyTermsKeymap.size() > 0) 
		{
			List<OntologyTerm> ontologyTermsList = db.query(OntologyTerm.class).in("Identifier",new ArrayList<Object>(ontologyTermsKeymap.keySet())).find();
			for(OntologyTerm xref :  ontologyTermsList)
			{
				ontologyTermsKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//resolve xref 'citation' from citation.Identifier -> citation.id
		for(Citation_OntologyTerms o: citation_ontologyTermsList) 
		{
			if(o.getCitation_Identifier() != null) 
				citationKeymap.put(o.getCitation_Identifier(), null);
		}
		
		if(citationKeymap.size() > 0) 
		{
			List<Citation> citationList = db.query(Citation.class).in("Identifier",new ArrayList<Object>(citationKeymap.keySet())).find();
			for(Citation xref :  citationList)
			{
				citationKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(Citation_OntologyTerms o:  citation_ontologyTermsList)
		{
			while(true){
				//update xref ontologyTerms
				if(o.getOntologyTerms_Identifier() != null) 
				{
					String key = o.getOntologyTerms_Identifier();
					if(ontologyTermsKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Citation_ontologyTerms' objects failed: cannot find OntologyTerm for ontologyTerms_Identifier='"+o.getOntologyTerms_Identifier()+"'");
					}
					o.setOntologyTerms_Id(ontologyTermsKeymap.get(key));
				}
				//update xref Citation
				if(o.getCitation_Identifier() != null) 
				{
					String key = o.getCitation_Identifier();
					if(citationKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Citation_ontologyTerms' objects failed: cannot find Citation for citation_Identifier='"+o.getCitation_Identifier()+"'");
					}
					o.setCitation_Id(citationKeymap.get(key));
				}
				break;
			}
		}
		
		ontologyTermsKeymap.clear();
		citationKeymap.clear();
		
		return citation_ontologyTermssMissingRefs;
	}
}

