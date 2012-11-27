
/* File:        org.molgenis/model/ObservationSet.java
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

import org.molgenis.observ.DataSet;
import org.molgenis.observ.Characteristic;
import org.molgenis.observ.ObservationSet;


/**
 * Reads ObservationSet from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class ObservationSetCsvReader extends CsvToDatabase<ObservationSet>
{
	private static final Logger logger = Logger.getLogger(ObservationSetCsvReader.class);
	
	//foreign key map for xref 'partOfDataSet' (maps dataSet.Identifier -> dataSet.id)			
	final Map<String,Integer> partOfDataSetKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'target' (maps characteristic.Identifier -> characteristic.id)			
	final Map<String,Integer> targetKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports ObservationSet from tab/comma delimited File
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
		List<ObservationSet> observationSetsMissingRefs = new ArrayList<ObservationSet>();
	
		//cache for objects to be imported from file (in batch)
		final List<ObservationSet> observationSetList = new ArrayList<ObservationSet>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			ObservationSet object = new ObservationSet();
			object.set(defaults, false); 
			object.set(tuple, false);				
			observationSetList.add(object);		
			
			//add to db when batch size is reached
			if(observationSetList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				observationSetsMissingRefs.addAll(resolveForeignKeys(db, observationSetList));
				observationSetList.removeAll(observationSetsMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'id' defined in xref_label
				db.update(observationSetList,dbAction, "id");
				
				//clear for next batch						
				observationSetList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!observationSetList.isEmpty())
		{
			total.set(total.get() + observationSetList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			observationSetsMissingRefs.addAll(resolveForeignKeys(db, observationSetList));
			observationSetList.removeAll(observationSetsMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'id' defined in xref_label
			db.update(observationSetList,dbAction, "id");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<ObservationSet> observationSets = new ArrayList<ObservationSet>(observationSetsMissingRefs);

		int iterationCount = 0;

		do
		{
			observationSetsMissingRefs = resolveForeignKeys(db, observationSetsMissingRefs);
			@SuppressWarnings("unchecked")
			List<ObservationSet> resolvableobservationSets = new ArrayList<ObservationSet>(CollectionUtils.disjunction(observationSets,
					observationSetsMissingRefs));
			observationSets.removeAll(resolvableobservationSets);
			
			db.update(resolvableobservationSets,dbAction, "id");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'observationSet' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still observationSets referring to Individuals that are neither in the database nor in the list of to-be imported observationSets."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (observationSetsMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " observationSet from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param observationSetList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<ObservationSet> resolveForeignKeys(Database db, List<ObservationSet> observationSetList) throws Exception
	{
		//keep a list of ObservationSet instances that miss a reference which might be resolvable later
		List<ObservationSet> observationSetsMissingRefs = new ArrayList<ObservationSet>();
	
		//resolve xref 'partOfDataSet' from dataSet.Identifier -> dataSet.id
		for(ObservationSet o: observationSetList) 
		{
			if(o.getPartOfDataSet_Identifier() != null) 
				partOfDataSetKeymap.put(o.getPartOfDataSet_Identifier(), null);
		}
		
		if(partOfDataSetKeymap.size() > 0) 
		{
			List<DataSet> partOfDataSetList = db.query(DataSet.class).in("Identifier",new ArrayList<Object>(partOfDataSetKeymap.keySet())).find();
			for(DataSet xref :  partOfDataSetList)
			{
				partOfDataSetKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//resolve xref 'target' from characteristic.Identifier -> characteristic.id
		for(ObservationSet o: observationSetList) 
		{
			if(o.getTarget_Identifier() != null) 
				targetKeymap.put(o.getTarget_Identifier(), null);
		}
		
		if(targetKeymap.size() > 0) 
		{
			List<Characteristic> targetList = db.query(Characteristic.class).in("Identifier",new ArrayList<Object>(targetKeymap.keySet())).find();
			for(Characteristic xref :  targetList)
			{
				targetKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(ObservationSet o:  observationSetList)
		{
			while(true){
				//update xref partOfDataSet
				if(o.getPartOfDataSet_Identifier() != null) 
				{
					String key = o.getPartOfDataSet_Identifier();
					if(partOfDataSetKeymap.get(key) == null)
					{
						throw new Exception("Import of 'ObservationSet' objects failed: cannot find DataSet for partOfDataSet_Identifier='"+o.getPartOfDataSet_Identifier()+"'");
					}
					o.setPartOfDataSet_Id(partOfDataSetKeymap.get(key));
				}
				//update xref Target
				if(o.getTarget_Identifier() != null) 
				{
					String key = o.getTarget_Identifier();
					if(targetKeymap.get(key) == null)
					{
						throw new Exception("Import of 'ObservationSet' objects failed: cannot find Characteristic for target_Identifier='"+o.getTarget_Identifier()+"'");
					}
					o.setTarget_Id(targetKeymap.get(key));
				}
				break;
			}
		}
		
		partOfDataSetKeymap.clear();
		targetKeymap.clear();
		
		return observationSetsMissingRefs;
	}
}

