
/* File:        org.molgenis.omx/model/PhenotypeMethod.java
 * Copyright:   GBIC 2000-2013, all rights reserved
 * Date:        January 2, 2013
 * 
 * generator:   org.molgenis.generators.csv.CsvReaderGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.gwascentral.csv;

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

import org.molgenis.observ.Protocol;
import org.molgenis.organization.Study;
import org.molgenis.gwascentral.PhenotypeProperty;
import org.molgenis.gwascentral.PhenotypeMethod;


/**
 * Reads PhenotypeMethod from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class PhenotypeMethodCsvReader extends CsvToDatabase<PhenotypeMethod>
{
	private static final Logger logger = Logger.getLogger(PhenotypeMethodCsvReader.class);
	
	//foreign key map for xref 'protocolUsed' (maps protocol.Identifier -> protocol.id)			
	final Map<String,Integer> protocolUsedKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'studyID' (maps study.Identifier -> study.id)			
	final Map<String,Integer> studyIDKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'phenotypePropertyID' (maps phenotypeProperty.Identifier -> phenotypeProperty.id)			
	final Map<String,Integer> phenotypePropertyIDKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports PhenotypeMethod from tab/comma delimited File
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
		List<PhenotypeMethod> phenotypeMethodsMissingRefs = new ArrayList<PhenotypeMethod>();
	
		//cache for objects to be imported from file (in batch)
		final List<PhenotypeMethod> phenotypeMethodList = new ArrayList<PhenotypeMethod>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			PhenotypeMethod object = new PhenotypeMethod();
			object.set(defaults, false); 
			object.set(tuple, false);				
			phenotypeMethodList.add(object);		
			
			//add to db when batch size is reached
			if(phenotypeMethodList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				phenotypeMethodsMissingRefs.addAll(resolveForeignKeys(db, phenotypeMethodList));
				phenotypeMethodList.removeAll(phenotypeMethodsMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
				db.update(phenotypeMethodList,dbAction, "Identifier");
				
				//clear for next batch						
				phenotypeMethodList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!phenotypeMethodList.isEmpty())
		{
			total.set(total.get() + phenotypeMethodList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			phenotypeMethodsMissingRefs.addAll(resolveForeignKeys(db, phenotypeMethodList));
			phenotypeMethodList.removeAll(phenotypeMethodsMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
			db.update(phenotypeMethodList,dbAction, "Identifier");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<PhenotypeMethod> phenotypeMethods = new ArrayList<PhenotypeMethod>(phenotypeMethodsMissingRefs);

		int iterationCount = 0;

		do
		{
			phenotypeMethodsMissingRefs = resolveForeignKeys(db, phenotypeMethodsMissingRefs);
			@SuppressWarnings("unchecked")
			List<PhenotypeMethod> resolvablephenotypeMethods = new ArrayList<PhenotypeMethod>(CollectionUtils.disjunction(phenotypeMethods,
					phenotypeMethodsMissingRefs));
			phenotypeMethods.removeAll(resolvablephenotypeMethods);
			
			db.update(resolvablephenotypeMethods,dbAction, "Identifier");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'phenotypeMethod' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still phenotypeMethods referring to Individuals that are neither in the database nor in the list of to-be imported phenotypeMethods."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (phenotypeMethodsMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " phenotypeMethod from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param phenotypeMethodList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<PhenotypeMethod> resolveForeignKeys(Database db, List<PhenotypeMethod> phenotypeMethodList) throws Exception
	{
		//keep a list of PhenotypeMethod instances that miss a reference which might be resolvable later
		List<PhenotypeMethod> phenotypeMethodsMissingRefs = new ArrayList<PhenotypeMethod>();
	
		//resolve xref 'protocolUsed' from protocol.Identifier -> protocol.id
		for(PhenotypeMethod o: phenotypeMethodList) 
		{
			if(o.getProtocolUsed_Identifier() != null) 
				protocolUsedKeymap.put(o.getProtocolUsed_Identifier(), null);
		}
		
		if(protocolUsedKeymap.size() > 0) 
		{
			List<Protocol> protocolUsedList = db.query(Protocol.class).in("Identifier",new ArrayList<Object>(protocolUsedKeymap.keySet())).find();
			for(Protocol xref :  protocolUsedList)
			{
				protocolUsedKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//resolve xref 'studyID' from study.Identifier -> study.id
		for(PhenotypeMethod o: phenotypeMethodList) 
		{
			if(o.getStudyID_Identifier() != null) 
				studyIDKeymap.put(o.getStudyID_Identifier(), null);
		}
		
		if(studyIDKeymap.size() > 0) 
		{
			List<Study> studyIDList = db.query(Study.class).in("Identifier",new ArrayList<Object>(studyIDKeymap.keySet())).find();
			for(Study xref :  studyIDList)
			{
				studyIDKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//resolve xref 'phenotypePropertyID' from phenotypeProperty.Identifier -> phenotypeProperty.id
		for(PhenotypeMethod o: phenotypeMethodList) 
		{
			if(o.getPhenotypePropertyID_Identifier() != null) 
				phenotypePropertyIDKeymap.put(o.getPhenotypePropertyID_Identifier(), null);
		}
		
		if(phenotypePropertyIDKeymap.size() > 0) 
		{
			List<PhenotypeProperty> phenotypePropertyIDList = db.query(PhenotypeProperty.class).in("Identifier",new ArrayList<Object>(phenotypePropertyIDKeymap.keySet())).find();
			for(PhenotypeProperty xref :  phenotypePropertyIDList)
			{
				phenotypePropertyIDKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(PhenotypeMethod o:  phenotypeMethodList)
		{
			while(true){
				//update xref ProtocolUsed
				if(o.getProtocolUsed_Identifier() != null) 
				{
					String key = o.getProtocolUsed_Identifier();
					if(protocolUsedKeymap.get(key) == null)
					{
						throw new Exception("Import of 'PhenotypeMethod' objects failed: cannot find Protocol for protocolUsed_Identifier='"+o.getProtocolUsed_Identifier()+"'");
					}
					o.setProtocolUsed_Id(protocolUsedKeymap.get(key));
				}
				//update xref StudyID
				if(o.getStudyID_Identifier() != null) 
				{
					String key = o.getStudyID_Identifier();
					if(studyIDKeymap.get(key) == null)
					{
						throw new Exception("Import of 'PhenotypeMethod' objects failed: cannot find Study for studyID_Identifier='"+o.getStudyID_Identifier()+"'");
					}
					o.setStudyID_Id(studyIDKeymap.get(key));
				}
				//update xref PhenotypePropertyID
				if(o.getPhenotypePropertyID_Identifier() != null) 
				{
					String key = o.getPhenotypePropertyID_Identifier();
					if(phenotypePropertyIDKeymap.get(key) == null)
					{
						throw new Exception("Import of 'PhenotypeMethod' objects failed: cannot find PhenotypeProperty for phenotypePropertyID_Identifier='"+o.getPhenotypePropertyID_Identifier()+"'");
					}
					o.setPhenotypePropertyID_Id(phenotypePropertyIDKeymap.get(key));
				}
				break;
			}
		}
		
		protocolUsedKeymap.clear();
		studyIDKeymap.clear();
		phenotypePropertyIDKeymap.clear();
		
		return phenotypeMethodsMissingRefs;
	}
}

