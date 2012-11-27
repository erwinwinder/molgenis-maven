
/* File:        org.molgenis/model/PhenotypeValue.java
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

import org.molgenis.observ.ObservationSet;
import org.molgenis.observ.ObservableFeature;
import org.molgenis.observ.Characteristic;
import org.molgenis.gwascentral.PhenotypeProperty;
import org.molgenis.gwascentral.PhenotypeValue;


/**
 * Reads PhenotypeValue from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class PhenotypeValueCsvReader extends CsvToDatabase<PhenotypeValue>
{
	private static final Logger logger = Logger.getLogger(PhenotypeValueCsvReader.class);
	
	//foreign key map for xref 'feature' (maps observableFeature.Identifier -> observableFeature.id)			
	final Map<String,Integer> featureKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'characteristic' (maps characteristic.Identifier -> characteristic.id)			
	final Map<String,Integer> characteristicKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'phenotypePropertyID' (maps phenotypeProperty.Identifier -> phenotypeProperty.id)			
	final Map<String,Integer> phenotypePropertyIDKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports PhenotypeValue from tab/comma delimited File
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
		List<PhenotypeValue> phenotypeValuesMissingRefs = new ArrayList<PhenotypeValue>();
	
		//cache for objects to be imported from file (in batch)
		final List<PhenotypeValue> phenotypeValueList = new ArrayList<PhenotypeValue>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			PhenotypeValue object = new PhenotypeValue();
			object.set(defaults, false); 
			object.set(tuple, false);				
			phenotypeValueList.add(object);		
			
			//add to db when batch size is reached
			if(phenotypeValueList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				phenotypeValuesMissingRefs.addAll(resolveForeignKeys(db, phenotypeValueList));
				phenotypeValueList.removeAll(phenotypeValuesMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'id' defined in xref_label
				db.update(phenotypeValueList,dbAction, "id");
				
				//clear for next batch						
				phenotypeValueList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!phenotypeValueList.isEmpty())
		{
			total.set(total.get() + phenotypeValueList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			phenotypeValuesMissingRefs.addAll(resolveForeignKeys(db, phenotypeValueList));
			phenotypeValueList.removeAll(phenotypeValuesMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'id' defined in xref_label
			db.update(phenotypeValueList,dbAction, "id");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<PhenotypeValue> phenotypeValues = new ArrayList<PhenotypeValue>(phenotypeValuesMissingRefs);

		int iterationCount = 0;

		do
		{
			phenotypeValuesMissingRefs = resolveForeignKeys(db, phenotypeValuesMissingRefs);
			@SuppressWarnings("unchecked")
			List<PhenotypeValue> resolvablephenotypeValues = new ArrayList<PhenotypeValue>(CollectionUtils.disjunction(phenotypeValues,
					phenotypeValuesMissingRefs));
			phenotypeValues.removeAll(resolvablephenotypeValues);
			
			db.update(resolvablephenotypeValues,dbAction, "id");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'phenotypeValue' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still phenotypeValues referring to Individuals that are neither in the database nor in the list of to-be imported phenotypeValues."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (phenotypeValuesMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " phenotypeValue from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param phenotypeValueList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<PhenotypeValue> resolveForeignKeys(Database db, List<PhenotypeValue> phenotypeValueList) throws Exception
	{
		//keep a list of PhenotypeValue instances that miss a reference which might be resolvable later
		List<PhenotypeValue> phenotypeValuesMissingRefs = new ArrayList<PhenotypeValue>();
	
		//resolve xref 'feature' from observableFeature.Identifier -> observableFeature.id
		for(PhenotypeValue o: phenotypeValueList) 
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
		for(PhenotypeValue o: phenotypeValueList) 
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
		//resolve xref 'phenotypePropertyID' from phenotypeProperty.Identifier -> phenotypeProperty.id
		for(PhenotypeValue o: phenotypeValueList) 
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
		for(PhenotypeValue o:  phenotypeValueList)
		{
			while(true){
				//update xref Feature
				if(o.getFeature_Identifier() != null) 
				{
					String key = o.getFeature_Identifier();
					if(featureKeymap.get(key) == null)
					{
						throw new Exception("Import of 'PhenotypeValue' objects failed: cannot find ObservableFeature for feature_Identifier='"+o.getFeature_Identifier()+"'");
					}
					o.setFeature_Id(featureKeymap.get(key));
				}
				//update xref Characteristic
				if(o.getCharacteristic_Identifier() != null) 
				{
					String key = o.getCharacteristic_Identifier();
					if(characteristicKeymap.get(key) == null)
					{
						throw new Exception("Import of 'PhenotypeValue' objects failed: cannot find Characteristic for characteristic_Identifier='"+o.getCharacteristic_Identifier()+"'");
					}
					o.setCharacteristic_Id(characteristicKeymap.get(key));
				}
				//update xref PhenotypePropertyID
				if(o.getPhenotypePropertyID_Identifier() != null) 
				{
					String key = o.getPhenotypePropertyID_Identifier();
					if(phenotypePropertyIDKeymap.get(key) == null)
					{
						throw new Exception("Import of 'PhenotypeValue' objects failed: cannot find PhenotypeProperty for phenotypePropertyID_Identifier='"+o.getPhenotypePropertyID_Identifier()+"'");
					}
					o.setPhenotypePropertyID_Id(phenotypePropertyIDKeymap.get(key));
				}
				break;
			}
		}
		
		featureKeymap.clear();
		characteristicKeymap.clear();
		phenotypePropertyIDKeymap.clear();
		
		return phenotypeValuesMissingRefs;
	}
}

