
/* File:        org.molgenis/model/Person.java
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

import org.molgenis.organization.Institute;
import org.molgenis.observ.target.OntologyTerm;
import org.molgenis.organization.Person;


/**
 * Reads Person from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class PersonCsvReader extends CsvToDatabase<Person>
{
	private static final Logger logger = Logger.getLogger(PersonCsvReader.class);
	
	//foreign key map for xref 'primaryAffilation' (maps institute.name -> institute.id)			
	final Map<String,Integer> primaryAffilationKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'affiliateInstitutions' (maps institute.name -> institute.id)			
	final Map<String,Integer> affiliateInstitutionsKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'orcidPersonReference' (maps ontologyTerm.Identifier -> ontologyTerm.id)			
	final Map<String,Integer> orcidPersonReferenceKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports Person from tab/comma delimited File
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
		List<Person> personsMissingRefs = new ArrayList<Person>();
	
		//cache for objects to be imported from file (in batch)
		final List<Person> personList = new ArrayList<Person>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Person object = new Person();
			object.set(defaults, false); 
			object.set(tuple, false);				
			personList.add(object);		
			
			//add to db when batch size is reached
			if(personList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				personsMissingRefs.addAll(resolveForeignKeys(db, personList));
				personList.removeAll(personsMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'Name' defined in xref_label
				db.update(personList,dbAction, "Name");
				
				//clear for next batch						
				personList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!personList.isEmpty())
		{
			total.set(total.get() + personList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			personsMissingRefs.addAll(resolveForeignKeys(db, personList));
			personList.removeAll(personsMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'Name' defined in xref_label
			db.update(personList,dbAction, "Name");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<Person> persons = new ArrayList<Person>(personsMissingRefs);

		int iterationCount = 0;

		do
		{
			personsMissingRefs = resolveForeignKeys(db, personsMissingRefs);
			@SuppressWarnings("unchecked")
			List<Person> resolvablepersons = new ArrayList<Person>(CollectionUtils.disjunction(persons,
					personsMissingRefs));
			persons.removeAll(resolvablepersons);
			
			db.update(resolvablepersons,dbAction, "Name");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'person' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still persons referring to Individuals that are neither in the database nor in the list of to-be imported persons."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (personsMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " person from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param personList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Person> resolveForeignKeys(Database db, List<Person> personList) throws Exception
	{
		//keep a list of Person instances that miss a reference which might be resolvable later
		List<Person> personsMissingRefs = new ArrayList<Person>();
	
		//resolve xref 'primaryAffilation' from institute.name -> institute.id
		for(Person o: personList) 
		{
			if(o.getPrimaryAffilation_Name() != null) 
				primaryAffilationKeymap.put(o.getPrimaryAffilation_Name(), null);
		}
		
		if(primaryAffilationKeymap.size() > 0) 
		{
			List<Institute> primaryAffilationList = db.query(Institute.class).in("name",new ArrayList<Object>(primaryAffilationKeymap.keySet())).find();
			for(Institute xref :  primaryAffilationList)
			{
				primaryAffilationKeymap.put(xref.getName(), xref.getId());
			}
		}
		//resolve xref 'affiliateInstitutions' from institute.name -> institute.id
		for(Person o: personList) for(String xref_label: o.getAffiliateInstitutions_Name())
		{
			if(xref_label != null) 
				affiliateInstitutionsKeymap.put(xref_label, null);
		}
		
		if(affiliateInstitutionsKeymap.size() > 0) 
		{
			List<Institute> affiliateInstitutionsList = db.query(Institute.class).in("name",new ArrayList<Object>(affiliateInstitutionsKeymap.keySet())).find();
			for(Institute xref :  affiliateInstitutionsList)
			{
				affiliateInstitutionsKeymap.put(xref.getName(), xref.getId());
			}
		}
		//resolve xref 'orcidPersonReference' from ontologyTerm.Identifier -> ontologyTerm.id
		for(Person o: personList) 
		{
			if(o.getOrcidPersonReference_Identifier() != null) 
				orcidPersonReferenceKeymap.put(o.getOrcidPersonReference_Identifier(), null);
		}
		
		if(orcidPersonReferenceKeymap.size() > 0) 
		{
			List<OntologyTerm> orcidPersonReferenceList = db.query(OntologyTerm.class).in("Identifier",new ArrayList<Object>(orcidPersonReferenceKeymap.keySet())).find();
			for(OntologyTerm xref :  orcidPersonReferenceList)
			{
				orcidPersonReferenceKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(Person o:  personList)
		{
			while(true){
				//update xref PrimaryAffilation
				if(o.getPrimaryAffilation_Name() != null) 
				{
					String key = o.getPrimaryAffilation_Name();
					if(primaryAffilationKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Person' objects failed: cannot find Institute for primaryAffilation_name='"+o.getPrimaryAffilation_Name()+"'");
					}
					o.setPrimaryAffilation_Id(primaryAffilationKeymap.get(key));
				}
				//update mref AffiliateInstitutions
				if(o.getAffiliateInstitutions_Name() != null) 
				{
					List<Integer> mrefs = new ArrayList<Integer>();
					boolean breakToNextPerson = false;

					int listSize = 0;
					if(o.getAffiliateInstitutions_Name() != null) listSize = Math.max(o.getAffiliateInstitutions_Name().size(), listSize);
					for(int i = 0; i < listSize; i++)
					{
						String key = o.getAffiliateInstitutions_Name().get(i);
						if(affiliateInstitutionsKeymap.get(key) == null){
							logger.error("Import of 'Person' objects failed: "+o);
							throw new Exception("Import of 'Person' objects failed: cannot find affiliateInstitutions_name='"+(o.getAffiliateInstitutions_Name() != null && i < o.getAffiliateInstitutions_Name().size() ? o.getAffiliateInstitutions_Name().get(i) : "null")+"'");
						}
						mrefs.add(affiliateInstitutionsKeymap.get(key));
					}
					if(breakToNextPerson){
						break;
					}
					o.setAffiliateInstitutions_Id(mrefs);
				}
				//update xref OrcidPersonReference
				if(o.getOrcidPersonReference_Identifier() != null) 
				{
					String key = o.getOrcidPersonReference_Identifier();
					if(orcidPersonReferenceKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Person' objects failed: cannot find OntologyTerm for orcidPersonReference_Identifier='"+o.getOrcidPersonReference_Identifier()+"'");
					}
					o.setOrcidPersonReference_Id(orcidPersonReferenceKeymap.get(key));
				}
				break;
			}
		}
		
		primaryAffilationKeymap.clear();
		affiliateInstitutionsKeymap.clear();
		orcidPersonReferenceKeymap.clear();
		
		return personsMissingRefs;
	}
}

