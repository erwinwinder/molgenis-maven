
/* File:        org.molgenis.omx/model/Experiment_AssayedPanels.java
 * Copyright:   GBIC 2000-2013, all rights reserved
 * Date:        January 2, 2013
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

import org.molgenis.observ.target.Panel;
import org.molgenis.organization.Experiment;
import org.molgenis.organization.Experiment_AssayedPanels;


/**
 * Reads Experiment_AssayedPanels from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class Experiment_AssayedPanelsCsvReader extends CsvToDatabase<Experiment_AssayedPanels>
{
	private static final Logger logger = Logger.getLogger(Experiment_AssayedPanelsCsvReader.class);
	
	//foreign key map for xref 'assayedPanels' (maps panel.Identifier -> panel.id)			
	final Map<String,Integer> assayedPanelsKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'experiment' (maps experiment.Identifier -> experiment.id)			
	final Map<String,Integer> experimentKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports Experiment_AssayedPanels from tab/comma delimited File
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
		List<Experiment_AssayedPanels> experiment_AssayedPanelssMissingRefs = new ArrayList<Experiment_AssayedPanels>();
	
		//cache for objects to be imported from file (in batch)
		final List<Experiment_AssayedPanels> experiment_AssayedPanelsList = new ArrayList<Experiment_AssayedPanels>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Experiment_AssayedPanels object = new Experiment_AssayedPanels();
			object.set(defaults, false); 
			object.set(tuple, false);				
			experiment_AssayedPanelsList.add(object);		
			
			//add to db when batch size is reached
			if(experiment_AssayedPanelsList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				experiment_AssayedPanelssMissingRefs.addAll(resolveForeignKeys(db, experiment_AssayedPanelsList));
				experiment_AssayedPanelsList.removeAll(experiment_AssayedPanelssMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'AssayedPanels,Experiment' defined in xref_label
				db.update(experiment_AssayedPanelsList,dbAction, "AssayedPanels", "Experiment");
				
				//clear for next batch						
				experiment_AssayedPanelsList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!experiment_AssayedPanelsList.isEmpty())
		{
			total.set(total.get() + experiment_AssayedPanelsList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			experiment_AssayedPanelssMissingRefs.addAll(resolveForeignKeys(db, experiment_AssayedPanelsList));
			experiment_AssayedPanelsList.removeAll(experiment_AssayedPanelssMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'AssayedPanels,Experiment' defined in xref_label
			db.update(experiment_AssayedPanelsList,dbAction, "AssayedPanels", "Experiment");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<Experiment_AssayedPanels> experiment_AssayedPanelss = new ArrayList<Experiment_AssayedPanels>(experiment_AssayedPanelssMissingRefs);

		int iterationCount = 0;

		do
		{
			experiment_AssayedPanelssMissingRefs = resolveForeignKeys(db, experiment_AssayedPanelssMissingRefs);
			@SuppressWarnings("unchecked")
			List<Experiment_AssayedPanels> resolvableexperiment_AssayedPanelss = new ArrayList<Experiment_AssayedPanels>(CollectionUtils.disjunction(experiment_AssayedPanelss,
					experiment_AssayedPanelssMissingRefs));
			experiment_AssayedPanelss.removeAll(resolvableexperiment_AssayedPanelss);
			
			db.update(resolvableexperiment_AssayedPanelss,dbAction, "AssayedPanels", "Experiment");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'experiment_AssayedPanels' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still experiment_AssayedPanelss referring to Individuals that are neither in the database nor in the list of to-be imported experiment_AssayedPanelss."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (experiment_AssayedPanelssMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " experiment_AssayedPanels from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param experiment_AssayedPanelsList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Experiment_AssayedPanels> resolveForeignKeys(Database db, List<Experiment_AssayedPanels> experiment_AssayedPanelsList) throws Exception
	{
		//keep a list of Experiment_AssayedPanels instances that miss a reference which might be resolvable later
		List<Experiment_AssayedPanels> experiment_AssayedPanelssMissingRefs = new ArrayList<Experiment_AssayedPanels>();
	
		//resolve xref 'assayedPanels' from panel.Identifier -> panel.id
		for(Experiment_AssayedPanels o: experiment_AssayedPanelsList) 
		{
			if(o.getAssayedPanels_Identifier() != null) 
				assayedPanelsKeymap.put(o.getAssayedPanels_Identifier(), null);
		}
		
		if(assayedPanelsKeymap.size() > 0) 
		{
			List<Panel> assayedPanelsList = db.query(Panel.class).in("Identifier",new ArrayList<Object>(assayedPanelsKeymap.keySet())).find();
			for(Panel xref :  assayedPanelsList)
			{
				assayedPanelsKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//resolve xref 'experiment' from experiment.Identifier -> experiment.id
		for(Experiment_AssayedPanels o: experiment_AssayedPanelsList) 
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
		for(Experiment_AssayedPanels o:  experiment_AssayedPanelsList)
		{
			while(true){
				//update xref AssayedPanels
				if(o.getAssayedPanels_Identifier() != null) 
				{
					String key = o.getAssayedPanels_Identifier();
					if(assayedPanelsKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Experiment_AssayedPanels' objects failed: cannot find Panel for assayedPanels_Identifier='"+o.getAssayedPanels_Identifier()+"'");
					}
					o.setAssayedPanels_Id(assayedPanelsKeymap.get(key));
				}
				//update xref Experiment
				if(o.getExperiment_Identifier() != null) 
				{
					String key = o.getExperiment_Identifier();
					if(experimentKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Experiment_AssayedPanels' objects failed: cannot find Experiment for experiment_Identifier='"+o.getExperiment_Identifier()+"'");
					}
					o.setExperiment_Id(experimentKeymap.get(key));
				}
				break;
			}
		}
		
		assayedPanelsKeymap.clear();
		experimentKeymap.clear();
		
		return experiment_AssayedPanelssMissingRefs;
	}
}

