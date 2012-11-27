
/* File:        org.molgenis/model/Experiment_DataSets.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 26, 2012
 * 
 * generator:   org.molgenis.generators.csv.CsvReaderGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.organization.csv;

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
import org.molgenis.organization.Experiment;
import org.molgenis.organization.Experiment_DataSets;


/**
 * Reads Experiment_DataSets from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class Experiment_DataSetsCsvReader extends CsvToDatabase<Experiment_DataSets>
{
	private static final Logger logger = Logger.getLogger(Experiment_DataSetsCsvReader.class);
	
	//foreign key map for xref 'dataSets' (maps dataSet.Identifier -> dataSet.id)			
	final Map<String,Integer> dataSetsKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'experiment' (maps experiment.Identifier -> experiment.id)			
	final Map<String,Integer> experimentKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports Experiment_DataSets from tab/comma delimited File
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
		List<Experiment_DataSets> experiment_DataSetssMissingRefs = new ArrayList<Experiment_DataSets>();
	
		//cache for objects to be imported from file (in batch)
		final List<Experiment_DataSets> experiment_DataSetsList = new ArrayList<Experiment_DataSets>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Experiment_DataSets object = new Experiment_DataSets();
			object.set(defaults, false); 
			object.set(tuple, false);				
			experiment_DataSetsList.add(object);		
			
			//add to db when batch size is reached
			if(experiment_DataSetsList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				experiment_DataSetssMissingRefs.addAll(resolveForeignKeys(db, experiment_DataSetsList));
				experiment_DataSetsList.removeAll(experiment_DataSetssMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'DataSets,Experiment' defined in xref_label
				db.update(experiment_DataSetsList,dbAction, "DataSets", "Experiment");
				
				//clear for next batch						
				experiment_DataSetsList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!experiment_DataSetsList.isEmpty())
		{
			total.set(total.get() + experiment_DataSetsList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			experiment_DataSetssMissingRefs.addAll(resolveForeignKeys(db, experiment_DataSetsList));
			experiment_DataSetsList.removeAll(experiment_DataSetssMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'DataSets,Experiment' defined in xref_label
			db.update(experiment_DataSetsList,dbAction, "DataSets", "Experiment");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<Experiment_DataSets> experiment_DataSetss = new ArrayList<Experiment_DataSets>(experiment_DataSetssMissingRefs);

		int iterationCount = 0;

		do
		{
			experiment_DataSetssMissingRefs = resolveForeignKeys(db, experiment_DataSetssMissingRefs);
			@SuppressWarnings("unchecked")
			List<Experiment_DataSets> resolvableexperiment_DataSetss = new ArrayList<Experiment_DataSets>(CollectionUtils.disjunction(experiment_DataSetss,
					experiment_DataSetssMissingRefs));
			experiment_DataSetss.removeAll(resolvableexperiment_DataSetss);
			
			db.update(resolvableexperiment_DataSetss,dbAction, "DataSets", "Experiment");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'experiment_DataSets' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still experiment_DataSetss referring to Individuals that are neither in the database nor in the list of to-be imported experiment_DataSetss."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (experiment_DataSetssMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " experiment_DataSets from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param experiment_DataSetsList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Experiment_DataSets> resolveForeignKeys(Database db, List<Experiment_DataSets> experiment_DataSetsList) throws Exception
	{
		//keep a list of Experiment_DataSets instances that miss a reference which might be resolvable later
		List<Experiment_DataSets> experiment_DataSetssMissingRefs = new ArrayList<Experiment_DataSets>();
	
		//resolve xref 'dataSets' from dataSet.Identifier -> dataSet.id
		for(Experiment_DataSets o: experiment_DataSetsList) 
		{
			if(o.getDataSets_Identifier() != null) 
				dataSetsKeymap.put(o.getDataSets_Identifier(), null);
		}
		
		if(dataSetsKeymap.size() > 0) 
		{
			List<DataSet> dataSetsList = db.query(DataSet.class).in("Identifier",new ArrayList<Object>(dataSetsKeymap.keySet())).find();
			for(DataSet xref :  dataSetsList)
			{
				dataSetsKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//resolve xref 'experiment' from experiment.Identifier -> experiment.id
		for(Experiment_DataSets o: experiment_DataSetsList) 
		{
			if(o.getExperiment_Identifier() != null) 
				experimentKeymap.put(o.getExperiment_Identifier(), null);
		}
		
		if(experimentKeymap.size() > 0) 
		{
			List<Experiment> experimentList = db.query(Experiment.class).in("Identifier",new ArrayList<Object>(experimentKeymap.keySet())).find();
			for(Experiment xref :  experimentList)
			{
				experimentKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(Experiment_DataSets o:  experiment_DataSetsList)
		{
			while(true){
				//update xref DataSets
				if(o.getDataSets_Identifier() != null) 
				{
					String key = o.getDataSets_Identifier();
					if(dataSetsKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Experiment_DataSets' objects failed: cannot find DataSet for dataSets_Identifier='"+o.getDataSets_Identifier()+"'");
					}
					o.setDataSets_Id(dataSetsKeymap.get(key));
				}
				//update xref Experiment
				if(o.getExperiment_Identifier() != null) 
				{
					String key = o.getExperiment_Identifier();
					if(experimentKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Experiment_DataSets' objects failed: cannot find Experiment for experiment_Identifier='"+o.getExperiment_Identifier()+"'");
					}
					o.setExperiment_Id(experimentKeymap.get(key));
				}
				break;
			}
		}
		
		dataSetsKeymap.clear();
		experimentKeymap.clear();
		
		return experiment_DataSetssMissingRefs;
	}
}

