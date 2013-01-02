
/* File:        org.molgenis.omx/model/Accession.java
 * Copyright:   GBIC 2000-2013, all rights reserved
 * Date:        January 2, 2013
 * 
 * generator:   org.molgenis.generators.csv.CsvReaderGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.observ.target.csv;

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

import org.molgenis.observ.target.Ontology;
import org.molgenis.observ.target.Accession;


/**
 * Reads Accession from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class AccessionCsvReader extends CsvToDatabase<Accession>
{
	private static final Logger logger = Logger.getLogger(AccessionCsvReader.class);
	
	//foreign key map for xref 'ontology' (maps ontology.Identifier -> ontology.id)			
	final Map<String,Integer> ontologyKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports Accession from tab/comma delimited File
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
		List<Accession> accessionsMissingRefs = new ArrayList<Accession>();
	
		//cache for objects to be imported from file (in batch)
		final List<Accession> accessionList = new ArrayList<Accession>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Accession object = new Accession();
			object.set(defaults, false); 
			object.set(tuple, false);				
			accessionList.add(object);		
			
			//add to db when batch size is reached
			if(accessionList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				accessionsMissingRefs.addAll(resolveForeignKeys(db, accessionList));
				accessionList.removeAll(accessionsMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
				db.update(accessionList,dbAction, "Identifier");
				
				//clear for next batch						
				accessionList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!accessionList.isEmpty())
		{
			total.set(total.get() + accessionList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			accessionsMissingRefs.addAll(resolveForeignKeys(db, accessionList));
			accessionList.removeAll(accessionsMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
			db.update(accessionList,dbAction, "Identifier");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<Accession> accessions = new ArrayList<Accession>(accessionsMissingRefs);

		int iterationCount = 0;

		do
		{
			accessionsMissingRefs = resolveForeignKeys(db, accessionsMissingRefs);
			@SuppressWarnings("unchecked")
			List<Accession> resolvableaccessions = new ArrayList<Accession>(CollectionUtils.disjunction(accessions,
					accessionsMissingRefs));
			accessions.removeAll(resolvableaccessions);
			
			db.update(resolvableaccessions,dbAction, "Identifier");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'accession' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still accessions referring to Individuals that are neither in the database nor in the list of to-be imported accessions."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (accessionsMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " accession from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param accessionList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Accession> resolveForeignKeys(Database db, List<Accession> accessionList) throws Exception
	{
		//keep a list of Accession instances that miss a reference which might be resolvable later
		List<Accession> accessionsMissingRefs = new ArrayList<Accession>();
	
		//resolve xref 'ontology' from ontology.Identifier -> ontology.id
		for(Accession o: accessionList) 
		{
			if(o.getOntology_Identifier() != null) 
				ontologyKeymap.put(o.getOntology_Identifier(), null);
		}
		
		if(ontologyKeymap.size() > 0) 
		{
			List<Ontology> ontologyList = db.query(Ontology.class).in("Identifier",new ArrayList<Object>(ontologyKeymap.keySet())).find();
			for(Ontology xref :  ontologyList)
			{
				ontologyKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(Accession o:  accessionList)
		{
			while(true){
				//update xref ontology
				if(o.getOntology_Identifier() != null) 
				{
					String key = o.getOntology_Identifier();
					if(ontologyKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Accession' objects failed: cannot find Ontology for ontology_Identifier='"+o.getOntology_Identifier()+"'");
					}
					o.setOntology_Id(ontologyKeymap.get(key));
				}
				break;
			}
		}
		
		ontologyKeymap.clear();
		
		return accessionsMissingRefs;
	}
}

