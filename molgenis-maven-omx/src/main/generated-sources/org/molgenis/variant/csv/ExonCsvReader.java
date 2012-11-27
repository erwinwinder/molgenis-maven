
/* File:        org.molgenis/model/Exon.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 26, 2012
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
import org.molgenis.variant.Chromosome;
import org.molgenis.variant.Exon;


/**
 * Reads Exon from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class ExonCsvReader extends CsvToDatabase<Exon>
{
	private static final Logger logger = Logger.getLogger(ExonCsvReader.class);
	
	//foreign key map for xref 'cdna' (maps gene.Identifier -> gene.id)			
	final Map<String,Integer> cdnaKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'gdna' (maps chromosome.Identifier -> chromosome.id)			
	final Map<String,Integer> gdnaKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports Exon from tab/comma delimited File
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
		List<Exon> exonsMissingRefs = new ArrayList<Exon>();
	
		//cache for objects to be imported from file (in batch)
		final List<Exon> exonList = new ArrayList<Exon>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Exon object = new Exon();
			object.set(defaults, false); 
			object.set(tuple, false);				
			exonList.add(object);		
			
			//add to db when batch size is reached
			if(exonList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				exonsMissingRefs.addAll(resolveForeignKeys(db, exonList));
				exonList.removeAll(exonsMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
				db.update(exonList,dbAction, "Identifier");
				
				//clear for next batch						
				exonList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!exonList.isEmpty())
		{
			total.set(total.get() + exonList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			exonsMissingRefs.addAll(resolveForeignKeys(db, exonList));
			exonList.removeAll(exonsMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
			db.update(exonList,dbAction, "Identifier");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<Exon> exons = new ArrayList<Exon>(exonsMissingRefs);

		int iterationCount = 0;

		do
		{
			exonsMissingRefs = resolveForeignKeys(db, exonsMissingRefs);
			@SuppressWarnings("unchecked")
			List<Exon> resolvableexons = new ArrayList<Exon>(CollectionUtils.disjunction(exons,
					exonsMissingRefs));
			exons.removeAll(resolvableexons);
			
			db.update(resolvableexons,dbAction, "Identifier");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'exon' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still exons referring to Individuals that are neither in the database nor in the list of to-be imported exons."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (exonsMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " exon from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param exonList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Exon> resolveForeignKeys(Database db, List<Exon> exonList) throws Exception
	{
		//keep a list of Exon instances that miss a reference which might be resolvable later
		List<Exon> exonsMissingRefs = new ArrayList<Exon>();
	
		//resolve xref 'cdna' from gene.Identifier -> gene.id
		for(Exon o: exonList) 
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
		//resolve xref 'gdna' from chromosome.Identifier -> chromosome.id
		for(Exon o: exonList) 
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
		for(Exon o:  exonList)
		{
			while(true){
				//update xref cdna
				if(o.getCdna_Identifier() != null) 
				{
					String key = o.getCdna_Identifier();
					if(cdnaKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Exon' objects failed: cannot find Gene for cdna_Identifier='"+o.getCdna_Identifier()+"'");
					}
					o.setCdna_Id(cdnaKeymap.get(key));
				}
				//update xref gdna
				if(o.getGdna_Identifier() != null) 
				{
					String key = o.getGdna_Identifier();
					if(gdnaKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Exon' objects failed: cannot find Chromosome for gdna_Identifier='"+o.getGdna_Identifier()+"'");
					}
					o.setGdna_Id(gdnaKeymap.get(key));
				}
				break;
			}
		}
		
		cdnaKeymap.clear();
		gdnaKeymap.clear();
		
		return exonsMissingRefs;
	}
}

