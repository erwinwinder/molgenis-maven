
/* File:        org.molgenis/model/Protocol.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 26, 2012
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

import org.molgenis.observ.target.OntologyTerm;
import org.molgenis.observ.Protocol;
import org.molgenis.observ.ObservableFeature;


/**
 * Reads Protocol from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class ProtocolCsvReader extends CsvToDatabase<Protocol>
{
	private static final Logger logger = Logger.getLogger(ProtocolCsvReader.class);
	
	//foreign key map for xref 'protocolType' (maps ontologyTerm.Identifier -> ontologyTerm.id)			
	final Map<String,Integer> protocolTypeKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'subprotocols' (maps protocol.Identifier -> protocol.id)			
	final Map<String,Integer> subprotocolsKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'features' (maps observableFeature.Identifier -> observableFeature.id)			
	final Map<String,Integer> featuresKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports Protocol from tab/comma delimited File
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
		List<Protocol> protocolsMissingRefs = new ArrayList<Protocol>();
	
		//cache for objects to be imported from file (in batch)
		final List<Protocol> protocolList = new ArrayList<Protocol>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Protocol object = new Protocol();
			object.set(defaults, false); 
			object.set(tuple, false);				
			protocolList.add(object);		
			
			//add to db when batch size is reached
			if(protocolList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				protocolsMissingRefs.addAll(resolveForeignKeys(db, protocolList));
				protocolList.removeAll(protocolsMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
				db.update(protocolList,dbAction, "Identifier");
				
				//clear for next batch						
				protocolList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!protocolList.isEmpty())
		{
			total.set(total.get() + protocolList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			protocolsMissingRefs.addAll(resolveForeignKeys(db, protocolList));
			protocolList.removeAll(protocolsMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
			db.update(protocolList,dbAction, "Identifier");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<Protocol> protocols = new ArrayList<Protocol>(protocolsMissingRefs);

		int iterationCount = 0;

		do
		{
			protocolsMissingRefs = resolveForeignKeys(db, protocolsMissingRefs);
			@SuppressWarnings("unchecked")
			List<Protocol> resolvableprotocols = new ArrayList<Protocol>(CollectionUtils.disjunction(protocols,
					protocolsMissingRefs));
			protocols.removeAll(resolvableprotocols);
			
			db.update(resolvableprotocols,dbAction, "Identifier");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'protocol' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still protocols referring to Individuals that are neither in the database nor in the list of to-be imported protocols."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (protocolsMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " protocol from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param protocolList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Protocol> resolveForeignKeys(Database db, List<Protocol> protocolList) throws Exception
	{
		//keep a list of Protocol instances that miss a reference which might be resolvable later
		List<Protocol> protocolsMissingRefs = new ArrayList<Protocol>();
	
		//resolve xref 'protocolType' from ontologyTerm.Identifier -> ontologyTerm.id
		for(Protocol o: protocolList) 
		{
			if(o.getProtocolType_Identifier() != null) 
				protocolTypeKeymap.put(o.getProtocolType_Identifier(), null);
		}
		
		if(protocolTypeKeymap.size() > 0) 
		{
			List<OntologyTerm> protocolTypeList = db.query(OntologyTerm.class).in("Identifier",new ArrayList<Object>(protocolTypeKeymap.keySet())).find();
			for(OntologyTerm xref :  protocolTypeList)
			{
				protocolTypeKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//resolve xref 'subprotocols' from protocol.Identifier -> protocol.id
		for(Protocol o: protocolList) for(String xref_label: o.getSubprotocols_Identifier())
		{
			if(xref_label != null) 
				subprotocolsKeymap.put(xref_label, null);
		}
		
		if(subprotocolsKeymap.size() > 0) 
		{
			List<Protocol> subprotocolsList = db.query(Protocol.class).in("Identifier",new ArrayList<Object>(subprotocolsKeymap.keySet())).find();
			for(Protocol xref :  subprotocolsList)
			{
				subprotocolsKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//resolve xref 'features' from observableFeature.Identifier -> observableFeature.id
		for(Protocol o: protocolList) for(String xref_label: o.getFeatures_Identifier())
		{
			if(xref_label != null) 
				featuresKeymap.put(xref_label, null);
		}
		
		if(featuresKeymap.size() > 0) 
		{
			List<ObservableFeature> featuresList = db.query(ObservableFeature.class).in("Identifier",new ArrayList<Object>(featuresKeymap.keySet())).find();
			for(ObservableFeature xref :  featuresList)
			{
				featuresKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(Protocol o:  protocolList)
		{
			while(true){
				//update xref ProtocolType
				if(o.getProtocolType_Identifier() != null) 
				{
					String key = o.getProtocolType_Identifier();
					if(protocolTypeKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Protocol' objects failed: cannot find OntologyTerm for protocolType_Identifier='"+o.getProtocolType_Identifier()+"'");
					}
					o.setProtocolType_Id(protocolTypeKeymap.get(key));
				}
				//update mref subprotocols
				if(o.getSubprotocols_Identifier() != null) 
				{
					List<Integer> mrefs = new ArrayList<Integer>();
					boolean breakToNextProtocol = false;

					int listSize = 0;
					if(o.getSubprotocols_Identifier() != null) listSize = Math.max(o.getSubprotocols_Identifier().size(), listSize);
					for(int i = 0; i < listSize; i++)
					{
						String key = o.getSubprotocols_Identifier().get(i);
						if(subprotocolsKeymap.get(key) == null){
							protocolsMissingRefs.add(o);
							breakToNextProtocol = true;
							break;
						}
						mrefs.add(subprotocolsKeymap.get(key));
					}
					if(breakToNextProtocol){
						break;
					}
					o.setSubprotocols_Id(mrefs);
				}
				//update mref Features
				if(o.getFeatures_Identifier() != null) 
				{
					List<Integer> mrefs = new ArrayList<Integer>();
					boolean breakToNextProtocol = false;

					int listSize = 0;
					if(o.getFeatures_Identifier() != null) listSize = Math.max(o.getFeatures_Identifier().size(), listSize);
					for(int i = 0; i < listSize; i++)
					{
						String key = o.getFeatures_Identifier().get(i);
						if(featuresKeymap.get(key) == null){
							logger.error("Import of 'Protocol' objects failed: "+o);
							throw new Exception("Import of 'Protocol' objects failed: cannot find features_Identifier='"+(o.getFeatures_Identifier() != null && i < o.getFeatures_Identifier().size() ? o.getFeatures_Identifier().get(i) : "null")+"'");
						}
						mrefs.add(featuresKeymap.get(key));
					}
					if(breakToNextProtocol){
						break;
					}
					o.setFeatures_Id(mrefs);
				}
				break;
			}
		}
		
		protocolTypeKeymap.clear();
		subprotocolsKeymap.clear();
		featuresKeymap.clear();
		
		return protocolsMissingRefs;
	}
}

