
/* File:        org.molgenis/model/Person_AffiliateInstitutions.java
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
import org.molgenis.organization.Person;
import org.molgenis.organization.Person_AffiliateInstitutions;


/**
 * Reads Person_AffiliateInstitutions from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class Person_AffiliateInstitutionsCsvReader extends CsvToDatabase<Person_AffiliateInstitutions>
{
	private static final Logger logger = Logger.getLogger(Person_AffiliateInstitutionsCsvReader.class);
	
	//foreign key map for xref 'affiliateInstitutions' (maps institute.name -> institute.id)			
	final Map<String,Integer> affiliateInstitutionsKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'person' (maps person.Name -> person.id)			
	final Map<String,Integer> personKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports Person_AffiliateInstitutions from tab/comma delimited File
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
		List<Person_AffiliateInstitutions> person_AffiliateInstitutionssMissingRefs = new ArrayList<Person_AffiliateInstitutions>();
	
		//cache for objects to be imported from file (in batch)
		final List<Person_AffiliateInstitutions> person_AffiliateInstitutionsList = new ArrayList<Person_AffiliateInstitutions>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Person_AffiliateInstitutions object = new Person_AffiliateInstitutions();
			object.set(defaults, false); 
			object.set(tuple, false);				
			person_AffiliateInstitutionsList.add(object);		
			
			//add to db when batch size is reached
			if(person_AffiliateInstitutionsList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				person_AffiliateInstitutionssMissingRefs.addAll(resolveForeignKeys(db, person_AffiliateInstitutionsList));
				person_AffiliateInstitutionsList.removeAll(person_AffiliateInstitutionssMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'AffiliateInstitutions,Person' defined in xref_label
				db.update(person_AffiliateInstitutionsList,dbAction, "AffiliateInstitutions", "Person");
				
				//clear for next batch						
				person_AffiliateInstitutionsList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!person_AffiliateInstitutionsList.isEmpty())
		{
			total.set(total.get() + person_AffiliateInstitutionsList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			person_AffiliateInstitutionssMissingRefs.addAll(resolveForeignKeys(db, person_AffiliateInstitutionsList));
			person_AffiliateInstitutionsList.removeAll(person_AffiliateInstitutionssMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'AffiliateInstitutions,Person' defined in xref_label
			db.update(person_AffiliateInstitutionsList,dbAction, "AffiliateInstitutions", "Person");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<Person_AffiliateInstitutions> person_AffiliateInstitutionss = new ArrayList<Person_AffiliateInstitutions>(person_AffiliateInstitutionssMissingRefs);

		int iterationCount = 0;

		do
		{
			person_AffiliateInstitutionssMissingRefs = resolveForeignKeys(db, person_AffiliateInstitutionssMissingRefs);
			@SuppressWarnings("unchecked")
			List<Person_AffiliateInstitutions> resolvableperson_AffiliateInstitutionss = new ArrayList<Person_AffiliateInstitutions>(CollectionUtils.disjunction(person_AffiliateInstitutionss,
					person_AffiliateInstitutionssMissingRefs));
			person_AffiliateInstitutionss.removeAll(resolvableperson_AffiliateInstitutionss);
			
			db.update(resolvableperson_AffiliateInstitutionss,dbAction, "AffiliateInstitutions", "Person");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'person_AffiliateInstitutions' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still person_AffiliateInstitutionss referring to Individuals that are neither in the database nor in the list of to-be imported person_AffiliateInstitutionss."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (person_AffiliateInstitutionssMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " person_AffiliateInstitutions from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param person_AffiliateInstitutionsList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Person_AffiliateInstitutions> resolveForeignKeys(Database db, List<Person_AffiliateInstitutions> person_AffiliateInstitutionsList) throws Exception
	{
		//keep a list of Person_AffiliateInstitutions instances that miss a reference which might be resolvable later
		List<Person_AffiliateInstitutions> person_AffiliateInstitutionssMissingRefs = new ArrayList<Person_AffiliateInstitutions>();
	
		//resolve xref 'affiliateInstitutions' from institute.name -> institute.id
		for(Person_AffiliateInstitutions o: person_AffiliateInstitutionsList) 
		{
			if(o.getAffiliateInstitutions_Name() != null) 
				affiliateInstitutionsKeymap.put(o.getAffiliateInstitutions_Name(), null);
		}
		
		if(affiliateInstitutionsKeymap.size() > 0) 
		{
			List<Institute> affiliateInstitutionsList = db.query(Institute.class).in("name",new ArrayList<Object>(affiliateInstitutionsKeymap.keySet())).find();
			for(Institute xref :  affiliateInstitutionsList)
			{
				affiliateInstitutionsKeymap.put(xref.getName(), xref.getId());
			}
		}
		//resolve xref 'person' from person.Name -> person.id
		for(Person_AffiliateInstitutions o: person_AffiliateInstitutionsList) 
		{
			if(o.getPerson_Name() != null) 
				personKeymap.put(o.getPerson_Name(), null);
		}
		
		if(personKeymap.size() > 0) 
		{
			List<Person> personList = db.query(Person.class).in("Name",new ArrayList<Object>(personKeymap.keySet())).find();
			for(Person xref :  personList)
			{
				personKeymap.put(xref.getName(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(Person_AffiliateInstitutions o:  person_AffiliateInstitutionsList)
		{
			while(true){
				//update xref AffiliateInstitutions
				if(o.getAffiliateInstitutions_Name() != null) 
				{
					String key = o.getAffiliateInstitutions_Name();
					if(affiliateInstitutionsKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Person_AffiliateInstitutions' objects failed: cannot find Institute for affiliateInstitutions_name='"+o.getAffiliateInstitutions_Name()+"'");
					}
					o.setAffiliateInstitutions_Id(affiliateInstitutionsKeymap.get(key));
				}
				//update xref Person
				if(o.getPerson_Name() != null) 
				{
					String key = o.getPerson_Name();
					if(personKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Person_AffiliateInstitutions' objects failed: cannot find Person for person_Name='"+o.getPerson_Name()+"'");
					}
					o.setPerson_Id(personKeymap.get(key));
				}
				break;
			}
		}
		
		affiliateInstitutionsKeymap.clear();
		personKeymap.clear();
		
		return person_AffiliateInstitutionssMissingRefs;
	}
}

