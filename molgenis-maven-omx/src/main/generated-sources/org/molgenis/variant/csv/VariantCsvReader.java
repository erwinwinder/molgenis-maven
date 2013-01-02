
/* File:        org.molgenis.omx/model/Variant.java
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
import org.molgenis.variant.Protein;
import org.molgenis.observ.target.OntologyTerm;
import org.molgenis.variant.Variant;


/**
 * Reads Variant from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class VariantCsvReader extends CsvToDatabase<Variant>
{
	private static final Logger logger = Logger.getLogger(VariantCsvReader.class);
	
	//foreign key map for xref 'gdna' (maps chromosome.Identifier -> chromosome.id)			
	final Map<String,Integer> gdnaKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'cdna' (maps gene.Identifier -> gene.id)			
	final Map<String,Integer> cdnaKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'aa' (maps protein.Identifier -> protein.id)			
	final Map<String,Integer> aaKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'variantType' (maps ontologyTerm.Identifier -> ontologyTerm.id)			
	final Map<String,Integer> variantTypeKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports Variant from tab/comma delimited File
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
		List<Variant> variantsMissingRefs = new ArrayList<Variant>();
	
		//cache for objects to be imported from file (in batch)
		final List<Variant> variantList = new ArrayList<Variant>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Variant object = new Variant();
			object.set(defaults, false); 
			object.set(tuple, false);				
			variantList.add(object);		
			
			//add to db when batch size is reached
			if(variantList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				variantsMissingRefs.addAll(resolveForeignKeys(db, variantList));
				variantList.removeAll(variantsMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
				db.update(variantList,dbAction, "Identifier");
				
				//clear for next batch						
				variantList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!variantList.isEmpty())
		{
			total.set(total.get() + variantList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			variantsMissingRefs.addAll(resolveForeignKeys(db, variantList));
			variantList.removeAll(variantsMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
			db.update(variantList,dbAction, "Identifier");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<Variant> variants = new ArrayList<Variant>(variantsMissingRefs);

		int iterationCount = 0;

		do
		{
			variantsMissingRefs = resolveForeignKeys(db, variantsMissingRefs);
			@SuppressWarnings("unchecked")
			List<Variant> resolvablevariants = new ArrayList<Variant>(CollectionUtils.disjunction(variants,
					variantsMissingRefs));
			variants.removeAll(resolvablevariants);
			
			db.update(resolvablevariants,dbAction, "Identifier");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'variant' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still variants referring to Individuals that are neither in the database nor in the list of to-be imported variants."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (variantsMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " variant from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param variantList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Variant> resolveForeignKeys(Database db, List<Variant> variantList) throws Exception
	{
		//keep a list of Variant instances that miss a reference which might be resolvable later
		List<Variant> variantsMissingRefs = new ArrayList<Variant>();
	
		//resolve xref 'gdna' from chromosome.Identifier -> chromosome.id
		for(Variant o: variantList) 
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
		//resolve xref 'cdna' from gene.Identifier -> gene.id
		for(Variant o: variantList) 
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
		//resolve xref 'aa' from protein.Identifier -> protein.id
		for(Variant o: variantList) 
		{
			if(o.getAa_Identifier() != null) 
				aaKeymap.put(o.getAa_Identifier(), null);
		}
		
		if(aaKeymap.size() > 0) 
		{
			List<Protein> aaList = db.query(Protein.class).in("Identifier",new ArrayList<Object>(aaKeymap.keySet())).find();
			for(Protein xref :  aaList)
			{
				aaKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//resolve xref 'variantType' from ontologyTerm.Identifier -> ontologyTerm.id
		for(Variant o: variantList) 
		{
			if(o.getVariantType_Identifier() != null) 
				variantTypeKeymap.put(o.getVariantType_Identifier(), null);
		}
		
		if(variantTypeKeymap.size() > 0) 
		{
			List<OntologyTerm> variantTypeList = db.query(OntologyTerm.class).in("Identifier",new ArrayList<Object>(variantTypeKeymap.keySet())).find();
			for(OntologyTerm xref :  variantTypeList)
			{
				variantTypeKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(Variant o:  variantList)
		{
			while(true){
				//update xref gdna
				if(o.getGdna_Identifier() != null) 
				{
					String key = o.getGdna_Identifier();
					if(gdnaKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Variant' objects failed: cannot find Chromosome for gdna_Identifier='"+o.getGdna_Identifier()+"'");
					}
					o.setGdna_Id(gdnaKeymap.get(key));
				}
				//update xref cdna
				if(o.getCdna_Identifier() != null) 
				{
					String key = o.getCdna_Identifier();
					if(cdnaKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Variant' objects failed: cannot find Gene for cdna_Identifier='"+o.getCdna_Identifier()+"'");
					}
					o.setCdna_Id(cdnaKeymap.get(key));
				}
				//update xref aa
				if(o.getAa_Identifier() != null) 
				{
					String key = o.getAa_Identifier();
					if(aaKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Variant' objects failed: cannot find Protein for aa_Identifier='"+o.getAa_Identifier()+"'");
					}
					o.setAa_Id(aaKeymap.get(key));
				}
				//update xref variantType
				if(o.getVariantType_Identifier() != null) 
				{
					String key = o.getVariantType_Identifier();
					if(variantTypeKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Variant' objects failed: cannot find OntologyTerm for variantType_Identifier='"+o.getVariantType_Identifier()+"'");
					}
					o.setVariantType_Id(variantTypeKeymap.get(key));
				}
				break;
			}
		}
		
		gdnaKeymap.clear();
		cdnaKeymap.clear();
		aaKeymap.clear();
		variantTypeKeymap.clear();
		
		return variantsMissingRefs;
	}
}

