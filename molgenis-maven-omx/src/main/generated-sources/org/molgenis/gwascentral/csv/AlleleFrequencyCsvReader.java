
/* File:        org.molgenis.omx/model/AlleleFrequency.java
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
import org.molgenis.gwascentral.FrequencyCluster;
import org.molgenis.gwascentral.AlleleFrequency;


/**
 * Reads AlleleFrequency from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class AlleleFrequencyCsvReader extends CsvToDatabase<AlleleFrequency>
{
	private static final Logger logger = Logger.getLogger(AlleleFrequencyCsvReader.class);
	
	//foreign key map for xref 'protocolUsed' (maps protocol.Identifier -> protocol.id)			
	final Map<String,Integer> protocolUsedKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'frequencyCluster' (maps frequencyCluster.Identifier -> frequencyCluster.id)			
	final Map<String,Integer> frequencyClusterKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports AlleleFrequency from tab/comma delimited File
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
		List<AlleleFrequency> alleleFrequencysMissingRefs = new ArrayList<AlleleFrequency>();
	
		//cache for objects to be imported from file (in batch)
		final List<AlleleFrequency> alleleFrequencyList = new ArrayList<AlleleFrequency>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			AlleleFrequency object = new AlleleFrequency();
			object.set(defaults, false); 
			object.set(tuple, false);				
			alleleFrequencyList.add(object);		
			
			//add to db when batch size is reached
			if(alleleFrequencyList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				alleleFrequencysMissingRefs.addAll(resolveForeignKeys(db, alleleFrequencyList));
				alleleFrequencyList.removeAll(alleleFrequencysMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
				db.update(alleleFrequencyList,dbAction, "Identifier");
				
				//clear for next batch						
				alleleFrequencyList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!alleleFrequencyList.isEmpty())
		{
			total.set(total.get() + alleleFrequencyList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			alleleFrequencysMissingRefs.addAll(resolveForeignKeys(db, alleleFrequencyList));
			alleleFrequencyList.removeAll(alleleFrequencysMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
			db.update(alleleFrequencyList,dbAction, "Identifier");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<AlleleFrequency> alleleFrequencys = new ArrayList<AlleleFrequency>(alleleFrequencysMissingRefs);

		int iterationCount = 0;

		do
		{
			alleleFrequencysMissingRefs = resolveForeignKeys(db, alleleFrequencysMissingRefs);
			@SuppressWarnings("unchecked")
			List<AlleleFrequency> resolvablealleleFrequencys = new ArrayList<AlleleFrequency>(CollectionUtils.disjunction(alleleFrequencys,
					alleleFrequencysMissingRefs));
			alleleFrequencys.removeAll(resolvablealleleFrequencys);
			
			db.update(resolvablealleleFrequencys,dbAction, "Identifier");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'alleleFrequency' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still alleleFrequencys referring to Individuals that are neither in the database nor in the list of to-be imported alleleFrequencys."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (alleleFrequencysMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " alleleFrequency from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param alleleFrequencyList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<AlleleFrequency> resolveForeignKeys(Database db, List<AlleleFrequency> alleleFrequencyList) throws Exception
	{
		//keep a list of AlleleFrequency instances that miss a reference which might be resolvable later
		List<AlleleFrequency> alleleFrequencysMissingRefs = new ArrayList<AlleleFrequency>();
	
		//resolve xref 'protocolUsed' from protocol.Identifier -> protocol.id
		for(AlleleFrequency o: alleleFrequencyList) 
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
		//resolve xref 'frequencyCluster' from frequencyCluster.Identifier -> frequencyCluster.id
		for(AlleleFrequency o: alleleFrequencyList) 
		{
			if(o.getFrequencyCluster_Identifier() != null) 
				frequencyClusterKeymap.put(o.getFrequencyCluster_Identifier(), null);
		}
		
		if(frequencyClusterKeymap.size() > 0) 
		{
			List<FrequencyCluster> frequencyClusterList = db.query(FrequencyCluster.class).in("Identifier",new ArrayList<Object>(frequencyClusterKeymap.keySet())).find();
			for(FrequencyCluster xref :  frequencyClusterList)
			{
				frequencyClusterKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(AlleleFrequency o:  alleleFrequencyList)
		{
			while(true){
				//update xref ProtocolUsed
				if(o.getProtocolUsed_Identifier() != null) 
				{
					String key = o.getProtocolUsed_Identifier();
					if(protocolUsedKeymap.get(key) == null)
					{
						throw new Exception("Import of 'AlleleFrequency' objects failed: cannot find Protocol for protocolUsed_Identifier='"+o.getProtocolUsed_Identifier()+"'");
					}
					o.setProtocolUsed_Id(protocolUsedKeymap.get(key));
				}
				//update xref FrequencyCluster
				if(o.getFrequencyCluster_Identifier() != null) 
				{
					String key = o.getFrequencyCluster_Identifier();
					if(frequencyClusterKeymap.get(key) == null)
					{
						throw new Exception("Import of 'AlleleFrequency' objects failed: cannot find FrequencyCluster for frequencyCluster_Identifier='"+o.getFrequencyCluster_Identifier()+"'");
					}
					o.setFrequencyCluster_Id(frequencyClusterKeymap.get(key));
				}
				break;
			}
		}
		
		protocolUsedKeymap.clear();
		frequencyClusterKeymap.clear();
		
		return alleleFrequencysMissingRefs;
	}
}

