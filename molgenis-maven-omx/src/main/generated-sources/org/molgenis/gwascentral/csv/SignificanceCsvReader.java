
/* File:        org.molgenis.omx/model/Significance.java
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
import org.molgenis.gwascentral.Significance;


/**
 * Reads Significance from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class SignificanceCsvReader extends CsvToDatabase<Significance>
{
	private static final Logger logger = Logger.getLogger(SignificanceCsvReader.class);
	
	//foreign key map for xref 'protocolUsed' (maps protocol.Identifier -> protocol.id)			
	final Map<String,Integer> protocolUsedKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'usedmarkersetID' (maps usedMarkerSet.Identifier -> usedMarkerSet.id)			
	final Map<String,Integer> usedmarkersetIDKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports Significance from tab/comma delimited File
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
		List<Significance> significancesMissingRefs = new ArrayList<Significance>();
	
		//cache for objects to be imported from file (in batch)
		final List<Significance> significanceList = new ArrayList<Significance>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Significance object = new Significance();
			object.set(defaults, false); 
			object.set(tuple, false);				
			significanceList.add(object);		
			
			//add to db when batch size is reached
			if(significanceList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				significancesMissingRefs.addAll(resolveForeignKeys(db, significanceList));
				significanceList.removeAll(significancesMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
				db.update(significanceList,dbAction, "Identifier");
				
				//clear for next batch						
				significanceList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!significanceList.isEmpty())
		{
			total.set(total.get() + significanceList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			significancesMissingRefs.addAll(resolveForeignKeys(db, significanceList));
			significanceList.removeAll(significancesMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
			db.update(significanceList,dbAction, "Identifier");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<Significance> significances = new ArrayList<Significance>(significancesMissingRefs);

		int iterationCount = 0;

		do
		{
			significancesMissingRefs = resolveForeignKeys(db, significancesMissingRefs);
			@SuppressWarnings("unchecked")
			List<Significance> resolvablesignificances = new ArrayList<Significance>(CollectionUtils.disjunction(significances,
					significancesMissingRefs));
			significances.removeAll(resolvablesignificances);
			
			db.update(resolvablesignificances,dbAction, "Identifier");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'significance' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still significances referring to Individuals that are neither in the database nor in the list of to-be imported significances."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (significancesMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " significance from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param significanceList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Significance> resolveForeignKeys(Database db, List<Significance> significanceList) throws Exception
	{
		//keep a list of Significance instances that miss a reference which might be resolvable later
		List<Significance> significancesMissingRefs = new ArrayList<Significance>();
	
		//resolve xref 'protocolUsed' from protocol.Identifier -> protocol.id
		for(Significance o: significanceList) 
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
		//resolve xref 'usedmarkersetID' from usedMarkerSet.Identifier -> usedMarkerSet.id
		for(Significance o: significanceList) 
		{
			if(o.getUsedmarkersetID_Identifier() != null) 
				usedmarkersetIDKeymap.put(o.getUsedmarkersetID_Identifier(), null);
		}
		
		if(usedmarkersetIDKeymap.size() > 0) 
		{
			List<UsedMarkerSet> usedmarkersetIDList = db.query(UsedMarkerSet.class).in("Identifier",new ArrayList<Object>(usedmarkersetIDKeymap.keySet())).find();
			for(UsedMarkerSet xref :  usedmarkersetIDList)
			{
				usedmarkersetIDKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(Significance o:  significanceList)
		{
			while(true){
				//update xref ProtocolUsed
				if(o.getProtocolUsed_Identifier() != null) 
				{
					String key = o.getProtocolUsed_Identifier();
					if(protocolUsedKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Significance' objects failed: cannot find Protocol for protocolUsed_Identifier='"+o.getProtocolUsed_Identifier()+"'");
					}
					o.setProtocolUsed_Id(protocolUsedKeymap.get(key));
				}
				//update xref UsedmarkersetID
				if(o.getUsedmarkersetID_Identifier() != null) 
				{
					String key = o.getUsedmarkersetID_Identifier();
					if(usedmarkersetIDKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Significance' objects failed: cannot find UsedMarkerSet for usedmarkersetID_Identifier='"+o.getUsedmarkersetID_Identifier()+"'");
					}
					o.setUsedmarkersetID_Id(usedmarkersetIDKeymap.get(key));
				}
				break;
			}
		}
		
		protocolUsedKeymap.clear();
		usedmarkersetIDKeymap.clear();
		
		return significancesMissingRefs;
	}
}

