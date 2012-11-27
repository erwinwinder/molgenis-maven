
/* File:        org.molgenis/model/FrequencyCluster.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 26, 2012
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
import org.molgenis.observ.DataSet;
import org.molgenis.gwascentral.UsedMarkerSet;
import org.molgenis.gwascentral.FrequencyCluster;


/**
 * Reads FrequencyCluster from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class FrequencyClusterCsvReader extends CsvToDatabase<FrequencyCluster>
{
	private static final Logger logger = Logger.getLogger(FrequencyClusterCsvReader.class);
	
	//foreign key map for xref 'protocolUsed' (maps protocol.Identifier -> protocol.id)			
	final Map<String,Integer> protocolUsedKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'dataSet' (maps dataSet.Identifier -> dataSet.id)			
	final Map<String,Integer> dataSetKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'usedMarkerSet' (maps usedMarkerSet.Identifier -> usedMarkerSet.id)			
	final Map<String,Integer> usedMarkerSetKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports FrequencyCluster from tab/comma delimited File
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
		List<FrequencyCluster> frequencyClustersMissingRefs = new ArrayList<FrequencyCluster>();
	
		//cache for objects to be imported from file (in batch)
		final List<FrequencyCluster> frequencyClusterList = new ArrayList<FrequencyCluster>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			FrequencyCluster object = new FrequencyCluster();
			object.set(defaults, false); 
			object.set(tuple, false);				
			frequencyClusterList.add(object);		
			
			//add to db when batch size is reached
			if(frequencyClusterList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				frequencyClustersMissingRefs.addAll(resolveForeignKeys(db, frequencyClusterList));
				frequencyClusterList.removeAll(frequencyClustersMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
				db.update(frequencyClusterList,dbAction, "Identifier");
				
				//clear for next batch						
				frequencyClusterList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!frequencyClusterList.isEmpty())
		{
			total.set(total.get() + frequencyClusterList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			frequencyClustersMissingRefs.addAll(resolveForeignKeys(db, frequencyClusterList));
			frequencyClusterList.removeAll(frequencyClustersMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
			db.update(frequencyClusterList,dbAction, "Identifier");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<FrequencyCluster> frequencyClusters = new ArrayList<FrequencyCluster>(frequencyClustersMissingRefs);

		int iterationCount = 0;

		do
		{
			frequencyClustersMissingRefs = resolveForeignKeys(db, frequencyClustersMissingRefs);
			@SuppressWarnings("unchecked")
			List<FrequencyCluster> resolvablefrequencyClusters = new ArrayList<FrequencyCluster>(CollectionUtils.disjunction(frequencyClusters,
					frequencyClustersMissingRefs));
			frequencyClusters.removeAll(resolvablefrequencyClusters);
			
			db.update(resolvablefrequencyClusters,dbAction, "Identifier");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'frequencyCluster' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still frequencyClusters referring to Individuals that are neither in the database nor in the list of to-be imported frequencyClusters."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (frequencyClustersMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " frequencyCluster from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param frequencyClusterList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<FrequencyCluster> resolveForeignKeys(Database db, List<FrequencyCluster> frequencyClusterList) throws Exception
	{
		//keep a list of FrequencyCluster instances that miss a reference which might be resolvable later
		List<FrequencyCluster> frequencyClustersMissingRefs = new ArrayList<FrequencyCluster>();
	
		//resolve xref 'protocolUsed' from protocol.Identifier -> protocol.id
		for(FrequencyCluster o: frequencyClusterList) 
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
		//resolve xref 'dataSet' from dataSet.Identifier -> dataSet.id
		for(FrequencyCluster o: frequencyClusterList) 
		{
			if(o.getDataSet_Identifier() != null) 
				dataSetKeymap.put(o.getDataSet_Identifier(), null);
		}
		
		if(dataSetKeymap.size() > 0) 
		{
			List<DataSet> dataSetList = db.query(DataSet.class).in("Identifier",new ArrayList<Object>(dataSetKeymap.keySet())).find();
			for(DataSet xref :  dataSetList)
			{
				dataSetKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//resolve xref 'usedMarkerSet' from usedMarkerSet.Identifier -> usedMarkerSet.id
		for(FrequencyCluster o: frequencyClusterList) 
		{
			if(o.getUsedMarkerSet_Identifier() != null) 
				usedMarkerSetKeymap.put(o.getUsedMarkerSet_Identifier(), null);
		}
		
		if(usedMarkerSetKeymap.size() > 0) 
		{
			List<UsedMarkerSet> usedMarkerSetList = db.query(UsedMarkerSet.class).in("Identifier",new ArrayList<Object>(usedMarkerSetKeymap.keySet())).find();
			for(UsedMarkerSet xref :  usedMarkerSetList)
			{
				usedMarkerSetKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(FrequencyCluster o:  frequencyClusterList)
		{
			while(true){
				//update xref ProtocolUsed
				if(o.getProtocolUsed_Identifier() != null) 
				{
					String key = o.getProtocolUsed_Identifier();
					if(protocolUsedKeymap.get(key) == null)
					{
						throw new Exception("Import of 'FrequencyCluster' objects failed: cannot find Protocol for protocolUsed_Identifier='"+o.getProtocolUsed_Identifier()+"'");
					}
					o.setProtocolUsed_Id(protocolUsedKeymap.get(key));
				}
				//update xref DataSet
				if(o.getDataSet_Identifier() != null) 
				{
					String key = o.getDataSet_Identifier();
					if(dataSetKeymap.get(key) == null)
					{
						throw new Exception("Import of 'FrequencyCluster' objects failed: cannot find DataSet for dataSet_Identifier='"+o.getDataSet_Identifier()+"'");
					}
					o.setDataSet_Id(dataSetKeymap.get(key));
				}
				//update xref UsedMarkerSet
				if(o.getUsedMarkerSet_Identifier() != null) 
				{
					String key = o.getUsedMarkerSet_Identifier();
					if(usedMarkerSetKeymap.get(key) == null)
					{
						throw new Exception("Import of 'FrequencyCluster' objects failed: cannot find UsedMarkerSet for usedMarkerSet_Identifier='"+o.getUsedMarkerSet_Identifier()+"'");
					}
					o.setUsedMarkerSet_Id(usedMarkerSetKeymap.get(key));
				}
				break;
			}
		}
		
		protocolUsedKeymap.clear();
		dataSetKeymap.clear();
		usedMarkerSetKeymap.clear();
		
		return frequencyClustersMissingRefs;
	}
}

