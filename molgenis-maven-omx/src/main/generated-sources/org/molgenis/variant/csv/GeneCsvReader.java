
/* File:        org.molgenis.omx/model/Gene.java
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

import org.molgenis.variant.Chromosome;
import org.molgenis.variant.Gene;


/**
 * Reads Gene from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class GeneCsvReader extends CsvToDatabase<Gene>
{
	private static final Logger logger = Logger.getLogger(GeneCsvReader.class);
	
	//foreign key map for xref 'gdna' (maps chromosome.Identifier -> chromosome.id)			
	final Map<String,Integer> gdnaKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports Gene from tab/comma delimited File
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
		List<Gene> genesMissingRefs = new ArrayList<Gene>();
	
		//cache for objects to be imported from file (in batch)
		final List<Gene> geneList = new ArrayList<Gene>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Gene object = new Gene();
			object.set(defaults, false); 
			object.set(tuple, false);				
			geneList.add(object);		
			
			//add to db when batch size is reached
			if(geneList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				genesMissingRefs.addAll(resolveForeignKeys(db, geneList));
				geneList.removeAll(genesMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
				db.update(geneList,dbAction, "Identifier");
				
				//clear for next batch						
				geneList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!geneList.isEmpty())
		{
			total.set(total.get() + geneList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			genesMissingRefs.addAll(resolveForeignKeys(db, geneList));
			geneList.removeAll(genesMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
			db.update(geneList,dbAction, "Identifier");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<Gene> genes = new ArrayList<Gene>(genesMissingRefs);

		int iterationCount = 0;

		do
		{
			genesMissingRefs = resolveForeignKeys(db, genesMissingRefs);
			@SuppressWarnings("unchecked")
			List<Gene> resolvablegenes = new ArrayList<Gene>(CollectionUtils.disjunction(genes,
					genesMissingRefs));
			genes.removeAll(resolvablegenes);
			
			db.update(resolvablegenes,dbAction, "Identifier");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'gene' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still genes referring to Individuals that are neither in the database nor in the list of to-be imported genes."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (genesMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " gene from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param geneList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Gene> resolveForeignKeys(Database db, List<Gene> geneList) throws Exception
	{
		//keep a list of Gene instances that miss a reference which might be resolvable later
		List<Gene> genesMissingRefs = new ArrayList<Gene>();
	
		//resolve xref 'gdna' from chromosome.Identifier -> chromosome.id
		for(Gene o: geneList) 
		{
			if(o.getGdna_Identifier() != null) 
				gdnaKeymap.put(o.getGdna_Identifier(), null);
		}
		
		if(gdnaKeymap.size() > 0) 
		{
			List<Chromosome> gdnaList = db.query(Chromosome.class).in("Identifier",new ArrayList<Object>(gdnaKeymap.keySet())).find();
			for(Chromosome xref :  gdnaList)
			{
				gdnaKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(Gene o:  geneList)
		{
			while(true){
				//update xref gdna
				if(o.getGdna_Identifier() != null) 
				{
					String key = o.getGdna_Identifier();
					if(gdnaKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Gene' objects failed: cannot find Chromosome for gdna_Identifier='"+o.getGdna_Identifier()+"'");
					}
					o.setGdna_Id(gdnaKeymap.get(key));
				}
				break;
			}
		}
		
		gdnaKeymap.clear();
		
		return genesMissingRefs;
	}
}

