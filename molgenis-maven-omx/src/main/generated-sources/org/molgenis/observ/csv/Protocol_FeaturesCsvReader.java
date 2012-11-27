
/* File:        org.molgenis/model/Protocol_Features.java
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

import org.molgenis.observ.ObservableFeature;
import org.molgenis.observ.Protocol;
import org.molgenis.observ.Protocol_Features;


/**
 * Reads Protocol_Features from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class Protocol_FeaturesCsvReader extends CsvToDatabase<Protocol_Features>
{
	private static final Logger logger = Logger.getLogger(Protocol_FeaturesCsvReader.class);
	
	//foreign key map for xref 'features' (maps observableFeature.Identifier -> observableFeature.id)			
	final Map<String,Integer> featuresKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'protocol' (maps protocol.Identifier -> protocol.id)			
	final Map<String,Integer> protocolKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports Protocol_Features from tab/comma delimited File
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
		List<Protocol_Features> protocol_FeaturessMissingRefs = new ArrayList<Protocol_Features>();
	
		//cache for objects to be imported from file (in batch)
		final List<Protocol_Features> protocol_FeaturesList = new ArrayList<Protocol_Features>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Protocol_Features object = new Protocol_Features();
			object.set(defaults, false); 
			object.set(tuple, false);				
			protocol_FeaturesList.add(object);		
			
			//add to db when batch size is reached
			if(protocol_FeaturesList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				protocol_FeaturessMissingRefs.addAll(resolveForeignKeys(db, protocol_FeaturesList));
				protocol_FeaturesList.removeAll(protocol_FeaturessMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'Features,Protocol' defined in xref_label
				db.update(protocol_FeaturesList,dbAction, "Features", "Protocol");
				
				//clear for next batch						
				protocol_FeaturesList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!protocol_FeaturesList.isEmpty())
		{
			total.set(total.get() + protocol_FeaturesList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			protocol_FeaturessMissingRefs.addAll(resolveForeignKeys(db, protocol_FeaturesList));
			protocol_FeaturesList.removeAll(protocol_FeaturessMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'Features,Protocol' defined in xref_label
			db.update(protocol_FeaturesList,dbAction, "Features", "Protocol");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<Protocol_Features> protocol_Featuress = new ArrayList<Protocol_Features>(protocol_FeaturessMissingRefs);

		int iterationCount = 0;

		do
		{
			protocol_FeaturessMissingRefs = resolveForeignKeys(db, protocol_FeaturessMissingRefs);
			@SuppressWarnings("unchecked")
			List<Protocol_Features> resolvableprotocol_Featuress = new ArrayList<Protocol_Features>(CollectionUtils.disjunction(protocol_Featuress,
					protocol_FeaturessMissingRefs));
			protocol_Featuress.removeAll(resolvableprotocol_Featuress);
			
			db.update(resolvableprotocol_Featuress,dbAction, "Features", "Protocol");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'protocol_Features' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still protocol_Featuress referring to Individuals that are neither in the database nor in the list of to-be imported protocol_Featuress."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (protocol_FeaturessMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " protocol_Features from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param protocol_FeaturesList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Protocol_Features> resolveForeignKeys(Database db, List<Protocol_Features> protocol_FeaturesList) throws Exception
	{
		//keep a list of Protocol_Features instances that miss a reference which might be resolvable later
		List<Protocol_Features> protocol_FeaturessMissingRefs = new ArrayList<Protocol_Features>();
	
		//resolve xref 'features' from observableFeature.Identifier -> observableFeature.id
		for(Protocol_Features o: protocol_FeaturesList) 
		{
			if(o.getFeatures_Identifier() != null) 
				featuresKeymap.put(o.getFeatures_Identifier(), null);
		}
		
		if(featuresKeymap.size() > 0) 
		{
			List<ObservableFeature> featuresList = db.query(ObservableFeature.class).in("Identifier",new ArrayList<Object>(featuresKeymap.keySet())).find();
			for(ObservableFeature xref :  featuresList)
			{
				featuresKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//resolve xref 'protocol' from protocol.Identifier -> protocol.id
		for(Protocol_Features o: protocol_FeaturesList) 
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
		for(Protocol_Features o:  protocol_FeaturesList)
		{
			while(true){
				//update xref Features
				if(o.getFeatures_Identifier() != null) 
				{
					String key = o.getFeatures_Identifier();
					if(featuresKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Protocol_Features' objects failed: cannot find ObservableFeature for features_Identifier='"+o.getFeatures_Identifier()+"'");
					}
					o.setFeatures_Id(featuresKeymap.get(key));
				}
				//update xref Protocol
				if(o.getProtocol_Identifier() != null) 
				{
					String key = o.getProtocol_Identifier();
					if(protocolKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Protocol_Features' objects failed: cannot find Protocol for protocol_Identifier='"+o.getProtocol_Identifier()+"'");
					}
					o.setProtocol_Id(protocolKeymap.get(key));
				}
				break;
			}
		}
		
		featuresKeymap.clear();
		protocolKeymap.clear();
		
		return protocol_FeaturessMissingRefs;
	}
}

