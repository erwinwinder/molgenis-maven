
/* File:        org.molgenis.omx/model/EffectSize.java
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
import org.molgenis.gwascentral.UsedMarkerSet;
import org.molgenis.gwascentral.EffectSize;


/**
 * Reads EffectSize from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class EffectSizeCsvReader extends CsvToDatabase<EffectSize>
{
	private static final Logger logger = Logger.getLogger(EffectSizeCsvReader.class);
	
	//foreign key map for xref 'protocolUsed' (maps protocol.Identifier -> protocol.id)			
	final Map<String,Integer> protocolUsedKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'usedMarkerSetID' (maps usedMarkerSet.Identifier -> usedMarkerSet.id)			
	final Map<String,Integer> usedMarkerSetIDKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports EffectSize from tab/comma delimited File
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
		List<EffectSize> effectSizesMissingRefs = new ArrayList<EffectSize>();
	
		//cache for objects to be imported from file (in batch)
		final List<EffectSize> effectSizeList = new ArrayList<EffectSize>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			EffectSize object = new EffectSize();
			object.set(defaults, false); 
			object.set(tuple, false);				
			effectSizeList.add(object);		
			
			//add to db when batch size is reached
			if(effectSizeList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				effectSizesMissingRefs.addAll(resolveForeignKeys(db, effectSizeList));
				effectSizeList.removeAll(effectSizesMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
				db.update(effectSizeList,dbAction, "Identifier");
				
				//clear for next batch						
				effectSizeList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!effectSizeList.isEmpty())
		{
			total.set(total.get() + effectSizeList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			effectSizesMissingRefs.addAll(resolveForeignKeys(db, effectSizeList));
			effectSizeList.removeAll(effectSizesMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
			db.update(effectSizeList,dbAction, "Identifier");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<EffectSize> effectSizes = new ArrayList<EffectSize>(effectSizesMissingRefs);

		int iterationCount = 0;

		do
		{
			effectSizesMissingRefs = resolveForeignKeys(db, effectSizesMissingRefs);
			@SuppressWarnings("unchecked")
			List<EffectSize> resolvableeffectSizes = new ArrayList<EffectSize>(CollectionUtils.disjunction(effectSizes,
					effectSizesMissingRefs));
			effectSizes.removeAll(resolvableeffectSizes);
			
			db.update(resolvableeffectSizes,dbAction, "Identifier");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'effectSize' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still effectSizes referring to Individuals that are neither in the database nor in the list of to-be imported effectSizes."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (effectSizesMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " effectSize from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param effectSizeList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<EffectSize> resolveForeignKeys(Database db, List<EffectSize> effectSizeList) throws Exception
	{
		//keep a list of EffectSize instances that miss a reference which might be resolvable later
		List<EffectSize> effectSizesMissingRefs = new ArrayList<EffectSize>();
	
		//resolve xref 'protocolUsed' from protocol.Identifier -> protocol.id
		for(EffectSize o: effectSizeList) 
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
		//resolve xref 'usedMarkerSetID' from usedMarkerSet.Identifier -> usedMarkerSet.id
		for(EffectSize o: effectSizeList) 
		{
			if(o.getUsedMarkerSetID_Identifier() != null) 
				usedMarkerSetIDKeymap.put(o.getUsedMarkerSetID_Identifier(), null);
		}
		
		if(usedMarkerSetIDKeymap.size() > 0) 
		{
			List<UsedMarkerSet> usedMarkerSetIDList = db.query(UsedMarkerSet.class).in("Identifier",new ArrayList<Object>(usedMarkerSetIDKeymap.keySet())).find();
			for(UsedMarkerSet xref :  usedMarkerSetIDList)
			{
				usedMarkerSetIDKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(EffectSize o:  effectSizeList)
		{
			while(true){
				//update xref ProtocolUsed
				if(o.getProtocolUsed_Identifier() != null) 
				{
					String key = o.getProtocolUsed_Identifier();
					if(protocolUsedKeymap.get(key) == null)
					{
						throw new Exception("Import of 'EffectSize' objects failed: cannot find Protocol for protocolUsed_Identifier='"+o.getProtocolUsed_Identifier()+"'");
					}
					o.setProtocolUsed_Id(protocolUsedKeymap.get(key));
				}
				//update xref UsedMarkerSetID
				if(o.getUsedMarkerSetID_Identifier() != null) 
				{
					String key = o.getUsedMarkerSetID_Identifier();
					if(usedMarkerSetIDKeymap.get(key) == null)
					{
						throw new Exception("Import of 'EffectSize' objects failed: cannot find UsedMarkerSet for usedMarkerSetID_Identifier='"+o.getUsedMarkerSetID_Identifier()+"'");
					}
					o.setUsedMarkerSetID_Id(usedMarkerSetIDKeymap.get(key));
				}
				break;
			}
		}
		
		protocolUsedKeymap.clear();
		usedMarkerSetIDKeymap.clear();
		
		return effectSizesMissingRefs;
	}
}

