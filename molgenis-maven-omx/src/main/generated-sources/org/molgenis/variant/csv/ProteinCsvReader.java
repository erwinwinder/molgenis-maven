
/* File:        org.molgenis.omx/model/Protein.java
 * Copyright:   GBIC 2000-2013, all rights reserved
 * Date:        January 2, 2013
 * 
 * generator:   org.molgenis.generators.csv.CsvReaderGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.variant.csv;

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

import org.molgenis.variant.Gene;
import org.molgenis.variant.Protein;


/**
 * Reads Protein from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class ProteinCsvReader extends CsvToDatabase<Protein>
{
	private static final Logger logger = Logger.getLogger(ProteinCsvReader.class);
	
	//foreign key map for xref 'cdna' (maps gene.Identifier -> gene.id)			
	final Map<String,Integer> cdnaKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports Protein from tab/comma delimited File
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
		List<Protein> proteinsMissingRefs = new ArrayList<Protein>();
	
		//cache for objects to be imported from file (in batch)
		final List<Protein> proteinList = new ArrayList<Protein>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Protein object = new Protein();
			object.set(defaults, false); 
			object.set(tuple, false);				
			proteinList.add(object);		
			
			//add to db when batch size is reached
			if(proteinList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				proteinsMissingRefs.addAll(resolveForeignKeys(db, proteinList));
				proteinList.removeAll(proteinsMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
				db.update(proteinList,dbAction, "Identifier");
				
				//clear for next batch						
				proteinList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!proteinList.isEmpty())
		{
			total.set(total.get() + proteinList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			proteinsMissingRefs.addAll(resolveForeignKeys(db, proteinList));
			proteinList.removeAll(proteinsMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
			db.update(proteinList,dbAction, "Identifier");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<Protein> proteins = new ArrayList<Protein>(proteinsMissingRefs);

		int iterationCount = 0;

		do
		{
			proteinsMissingRefs = resolveForeignKeys(db, proteinsMissingRefs);
			@SuppressWarnings("unchecked")
			List<Protein> resolvableproteins = new ArrayList<Protein>(CollectionUtils.disjunction(proteins,
					proteinsMissingRefs));
			proteins.removeAll(resolvableproteins);
			
			db.update(resolvableproteins,dbAction, "Identifier");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'protein' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still proteins referring to Individuals that are neither in the database nor in the list of to-be imported proteins."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (proteinsMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " protein from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param proteinList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Protein> resolveForeignKeys(Database db, List<Protein> proteinList) throws Exception
	{
		//keep a list of Protein instances that miss a reference which might be resolvable later
		List<Protein> proteinsMissingRefs = new ArrayList<Protein>();
	
		//resolve xref 'cdna' from gene.Identifier -> gene.id
		for(Protein o: proteinList) 
		{
			if(o.getCdna_Identifier() != null) 
				cdnaKeymap.put(o.getCdna_Identifier(), null);
		}
		
		if(cdnaKeymap.size() > 0) 
		{
			List<Gene> cdnaList = db.query(Gene.class).in("Identifier",new ArrayList<Object>(cdnaKeymap.keySet())).find();
			for(Gene xref :  cdnaList)
			{
				cdnaKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(Protein o:  proteinList)
		{
			while(true){
				//update xref cdna
				if(o.getCdna_Identifier() != null) 
				{
					String key = o.getCdna_Identifier();
					if(cdnaKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Protein' objects failed: cannot find Gene for cdna_Identifier='"+o.getCdna_Identifier()+"'");
					}
					o.setCdna_Id(cdnaKeymap.get(key));
				}
				break;
			}
		}
		
		cdnaKeymap.clear();
		
		return proteinsMissingRefs;
	}
}

