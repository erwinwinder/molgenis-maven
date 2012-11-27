
/* File:        org.molgenis/model/ObservedValue.java
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

import org.molgenis.observ.ObservationSet;
import org.molgenis.observ.ObservableFeature;
import org.molgenis.observ.Characteristic;
import org.molgenis.observ.ObservedValue;


/**
 * Reads ObservedValue from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class ObservedValueCsvReader extends CsvToDatabase<ObservedValue>
{
	private static final Logger logger = Logger.getLogger(ObservedValueCsvReader.class);
	
	//foreign key map for xref 'feature' (maps observableFeature.Identifier -> observableFeature.id)			
	final Map<String,Integer> featureKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'characteristic' (maps characteristic.Identifier -> characteristic.id)			
	final Map<String,Integer> characteristicKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports ObservedValue from tab/comma delimited File
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
		List<ObservedValue> observedValuesMissingRefs = new ArrayList<ObservedValue>();
	
		//cache for objects to be imported from file (in batch)
		final List<ObservedValue> observedValueList = new ArrayList<ObservedValue>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			ObservedValue object = new ObservedValue();
			object.set(defaults, false); 
			object.set(tuple, false);				
			observedValueList.add(object);		
			
			//add to db when batch size is reached
			if(observedValueList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				observedValuesMissingRefs.addAll(resolveForeignKeys(db, observedValueList));
				observedValueList.removeAll(observedValuesMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'id' defined in xref_label
				db.update(observedValueList,dbAction, "id");
				
				//clear for next batch						
				observedValueList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!observedValueList.isEmpty())
		{
			total.set(total.get() + observedValueList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			observedValuesMissingRefs.addAll(resolveForeignKeys(db, observedValueList));
			observedValueList.removeAll(observedValuesMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'id' defined in xref_label
			db.update(observedValueList,dbAction, "id");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<ObservedValue> observedValues = new ArrayList<ObservedValue>(observedValuesMissingRefs);

		int iterationCount = 0;

		do
		{
			observedValuesMissingRefs = resolveForeignKeys(db, observedValuesMissingRefs);
			@SuppressWarnings("unchecked")
			List<ObservedValue> resolvableobservedValues = new ArrayList<ObservedValue>(CollectionUtils.disjunction(observedValues,
					observedValuesMissingRefs));
			observedValues.removeAll(resolvableobservedValues);
			
			db.update(resolvableobservedValues,dbAction, "id");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'observedValue' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still observedValues referring to Individuals that are neither in the database nor in the list of to-be imported observedValues."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (observedValuesMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " observedValue from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param observedValueList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<ObservedValue> resolveForeignKeys(Database db, List<ObservedValue> observedValueList) throws Exception
	{
		//keep a list of ObservedValue instances that miss a reference which might be resolvable later
		List<ObservedValue> observedValuesMissingRefs = new ArrayList<ObservedValue>();
	
		//resolve xref 'feature' from observableFeature.Identifier -> observableFeature.id
		for(ObservedValue o: observedValueList) 
		{
			if(o.getFeature_Identifier() != null) 
				featureKeymap.put(o.getFeature_Identifier(), null);
		}
		
		if(featureKeymap.size() > 0) 
		{
			List<ObservableFeature> featureList = db.query(ObservableFeature.class).in("Identifier",new ArrayList<Object>(featureKeymap.keySet())).find();
			for(ObservableFeature xref :  featureList)
			{
				featureKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//resolve xref 'characteristic' from characteristic.Identifier -> characteristic.id
		for(ObservedValue o: observedValueList) 
		{
			if(o.getCharacteristic_Identifier() != null) 
				characteristicKeymap.put(o.getCharacteristic_Identifier(), null);
		}
		
		if(characteristicKeymap.size() > 0) 
		{
			List<Characteristic> characteristicList = db.query(Characteristic.class).in("Identifier",new ArrayList<Object>(characteristicKeymap.keySet())).find();
			for(Characteristic xref :  characteristicList)
			{
				characteristicKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(ObservedValue o:  observedValueList)
		{
			while(true){
				//update xref Feature
				if(o.getFeature_Identifier() != null) 
				{
					String key = o.getFeature_Identifier();
					if(featureKeymap.get(key) == null)
					{
						throw new Exception("Import of 'ObservedValue' objects failed: cannot find ObservableFeature for feature_Identifier='"+o.getFeature_Identifier()+"'");
					}
					o.setFeature_Id(featureKeymap.get(key));
				}
				//update xref Characteristic
				if(o.getCharacteristic_Identifier() != null) 
				{
					String key = o.getCharacteristic_Identifier();
					if(characteristicKeymap.get(key) == null)
					{
						throw new Exception("Import of 'ObservedValue' objects failed: cannot find Characteristic for characteristic_Identifier='"+o.getCharacteristic_Identifier()+"'");
					}
					o.setCharacteristic_Id(characteristicKeymap.get(key));
				}
				break;
			}
		}
		
		featureKeymap.clear();
		characteristicKeymap.clear();
		
		return observedValuesMissingRefs;
	}
}

