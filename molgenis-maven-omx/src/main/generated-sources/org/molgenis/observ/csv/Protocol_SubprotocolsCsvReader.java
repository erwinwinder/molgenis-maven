
/* File:        org.molgenis.omx/model/Protocol_subprotocols.java
 * Copyright:   GBIC 2000-2013, all rights reserved
 * Date:        January 2, 2013
 * 
 * generator:   org.molgenis.generators.csv.CsvReaderGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.observ.csv;

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
import org.molgenis.observ.Protocol_Subprotocols;


/**
 * Reads Protocol_Subprotocols from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class Protocol_SubprotocolsCsvReader extends CsvToDatabase<Protocol_Subprotocols>
{
	private static final Logger logger = Logger.getLogger(Protocol_SubprotocolsCsvReader.class);
	
	//foreign key map for xref 'subprotocols' (maps protocol.Identifier -> protocol.id)			
	final Map<String,Integer> subprotocolsKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'protocol' (maps protocol.Identifier -> protocol.id)			
	final Map<String,Integer> protocolKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports Protocol_Subprotocols from tab/comma delimited File
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
		List<Protocol_Subprotocols> protocol_subprotocolssMissingRefs = new ArrayList<Protocol_Subprotocols>();
	
		//cache for objects to be imported from file (in batch)
		final List<Protocol_Subprotocols> protocol_subprotocolsList = new ArrayList<Protocol_Subprotocols>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Protocol_Subprotocols object = new Protocol_Subprotocols();
			object.set(defaults, false); 
			object.set(tuple, false);				
			protocol_subprotocolsList.add(object);		
			
			//add to db when batch size is reached
			if(protocol_subprotocolsList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				protocol_subprotocolssMissingRefs.addAll(resolveForeignKeys(db, protocol_subprotocolsList));
				protocol_subprotocolsList.removeAll(protocol_subprotocolssMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'subprotocols,Protocol' defined in xref_label
				db.update(protocol_subprotocolsList,dbAction, "subprotocols", "Protocol");
				
				//clear for next batch						
				protocol_subprotocolsList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!protocol_subprotocolsList.isEmpty())
		{
			total.set(total.get() + protocol_subprotocolsList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			protocol_subprotocolssMissingRefs.addAll(resolveForeignKeys(db, protocol_subprotocolsList));
			protocol_subprotocolsList.removeAll(protocol_subprotocolssMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'subprotocols,Protocol' defined in xref_label
			db.update(protocol_subprotocolsList,dbAction, "subprotocols", "Protocol");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<Protocol_Subprotocols> protocol_subprotocolss = new ArrayList<Protocol_Subprotocols>(protocol_subprotocolssMissingRefs);

		int iterationCount = 0;

		do
		{
			protocol_subprotocolssMissingRefs = resolveForeignKeys(db, protocol_subprotocolssMissingRefs);
			@SuppressWarnings("unchecked")
			List<Protocol_Subprotocols> resolvableprotocol_subprotocolss = new ArrayList<Protocol_Subprotocols>(CollectionUtils.disjunction(protocol_subprotocolss,
					protocol_subprotocolssMissingRefs));
			protocol_subprotocolss.removeAll(resolvableprotocol_subprotocolss);
			
			db.update(resolvableprotocol_subprotocolss,dbAction, "subprotocols", "Protocol");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'protocol_subprotocols' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still protocol_subprotocolss referring to Individuals that are neither in the database nor in the list of to-be imported protocol_subprotocolss."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (protocol_subprotocolssMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " protocol_subprotocols from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param protocol_subprotocolsList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Protocol_Subprotocols> resolveForeignKeys(Database db, List<Protocol_Subprotocols> protocol_subprotocolsList) throws Exception
	{
		//keep a list of Protocol_subprotocols instances that miss a reference which might be resolvable later
		List<Protocol_Subprotocols> protocol_subprotocolssMissingRefs = new ArrayList<Protocol_Subprotocols>();
	
		//resolve xref 'subprotocols' from protocol.Identifier -> protocol.id
		for(Protocol_Subprotocols o: protocol_subprotocolsList) 
		{
			if(o.getSubprotocols_Identifier() != null) 
				subprotocolsKeymap.put(o.getSubprotocols_Identifier(), null);
		}
		
		if(subprotocolsKeymap.size() > 0) 
		{
			List<Protocol> subprotocolsList = db.query(Protocol.class).in("Identifier",new ArrayList<Object>(subprotocolsKeymap.keySet())).find();
			for(Protocol xref :  subprotocolsList)
			{
				subprotocolsKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//resolve xref 'protocol' from protocol.Identifier -> protocol.id
		for(Protocol_Subprotocols o: protocol_subprotocolsList) 
		{
			if(o.getProtocol_Identifier() != null) 
				protocolKeymap.put(o.getProtocol_Identifier(), null);
		}
		
		if(protocolKeymap.size() > 0) 
		{
			List<Protocol> protocolList = db.query(Protocol.class).in("Identifier",new ArrayList<Object>(protocolKeymap.keySet())).find();
			for(Protocol xref :  protocolList)
			{
				protocolKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(Protocol_Subprotocols o:  protocol_subprotocolsList)
		{
			while(true){
				//update xref subprotocols
				if(o.getSubprotocols_Identifier() != null) 
				{
					String key = o.getSubprotocols_Identifier();
					if(subprotocolsKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Protocol_subprotocols' objects failed: cannot find Protocol for subprotocols_Identifier='"+o.getSubprotocols_Identifier()+"'");
					}
					o.setSubprotocols_Id(subprotocolsKeymap.get(key));
				}
				//update xref Protocol
				if(o.getProtocol_Identifier() != null) 
				{
					String key = o.getProtocol_Identifier();
					if(protocolKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Protocol_subprotocols' objects failed: cannot find Protocol for protocol_Identifier='"+o.getProtocol_Identifier()+"'");
					}
					o.setProtocol_Id(protocolKeymap.get(key));
				}
				break;
			}
		}
		
		subprotocolsKeymap.clear();
		protocolKeymap.clear();
		
		return protocol_subprotocolssMissingRefs;
	}
}

