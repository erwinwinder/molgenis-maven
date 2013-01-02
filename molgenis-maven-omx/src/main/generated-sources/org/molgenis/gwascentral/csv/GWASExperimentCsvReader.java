
/* File:        org.molgenis.omx/model/GWASExperiment.java
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

import org.molgenis.organization.Study;
import org.molgenis.observ.target.OntologyTerm;
import org.molgenis.observ.target.Panel;
import org.molgenis.observ.DataSet;
import org.molgenis.gwascentral.GWASExperiment;


/**
 * Reads GWASExperiment from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class GWASExperimentCsvReader extends CsvToDatabase<GWASExperiment>
{
	private static final Logger logger = Logger.getLogger(GWASExperimentCsvReader.class);
	
	//foreign key map for xref 'study' (maps study.Identifier -> study.id)			
	final Map<String,Integer> studyKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'experimentType' (maps ontologyTerm.Identifier -> ontologyTerm.id)			
	final Map<String,Integer> experimentTypeKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'assayedPanels' (maps panel.Identifier -> panel.id)			
	final Map<String,Integer> assayedPanelsKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'dataSets' (maps dataSet.Identifier -> dataSet.id)			
	final Map<String,Integer> dataSetsKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports GWASExperiment from tab/comma delimited File
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
		List<GWASExperiment> gWASExperimentsMissingRefs = new ArrayList<GWASExperiment>();
	
		//cache for objects to be imported from file (in batch)
		final List<GWASExperiment> gWASExperimentList = new ArrayList<GWASExperiment>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			GWASExperiment object = new GWASExperiment();
			object.set(defaults, false); 
			object.set(tuple, false);				
			gWASExperimentList.add(object);		
			
			//add to db when batch size is reached
			if(gWASExperimentList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				gWASExperimentsMissingRefs.addAll(resolveForeignKeys(db, gWASExperimentList));
				gWASExperimentList.removeAll(gWASExperimentsMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
				db.update(gWASExperimentList,dbAction, "Identifier");
				
				//clear for next batch						
				gWASExperimentList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!gWASExperimentList.isEmpty())
		{
			total.set(total.get() + gWASExperimentList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			gWASExperimentsMissingRefs.addAll(resolveForeignKeys(db, gWASExperimentList));
			gWASExperimentList.removeAll(gWASExperimentsMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
			db.update(gWASExperimentList,dbAction, "Identifier");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<GWASExperiment> gWASExperiments = new ArrayList<GWASExperiment>(gWASExperimentsMissingRefs);

		int iterationCount = 0;

		do
		{
			gWASExperimentsMissingRefs = resolveForeignKeys(db, gWASExperimentsMissingRefs);
			@SuppressWarnings("unchecked")
			List<GWASExperiment> resolvablegWASExperiments = new ArrayList<GWASExperiment>(CollectionUtils.disjunction(gWASExperiments,
					gWASExperimentsMissingRefs));
			gWASExperiments.removeAll(resolvablegWASExperiments);
			
			db.update(resolvablegWASExperiments,dbAction, "Identifier");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'gWASExperiment' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still gWASExperiments referring to Individuals that are neither in the database nor in the list of to-be imported gWASExperiments."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (gWASExperimentsMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " gWASExperiment from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param gWASExperimentList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<GWASExperiment> resolveForeignKeys(Database db, List<GWASExperiment> gWASExperimentList) throws Exception
	{
		//keep a list of GWASExperiment instances that miss a reference which might be resolvable later
		List<GWASExperiment> gWASExperimentsMissingRefs = new ArrayList<GWASExperiment>();
	
		//resolve xref 'study' from study.Identifier -> study.id
		for(GWASExperiment o: gWASExperimentList) 
		{
			if(o.getStudy_Identifier() != null) 
				studyKeymap.put(o.getStudy_Identifier(), null);
		}
		
		if(studyKeymap.size() > 0) 
		{
			List<Study> studyList = db.query(Study.class).in("Identifier",new ArrayList<Object>(studyKeymap.keySet())).find();
			for(Study xref :  studyList)
			{
				studyKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//resolve xref 'experimentType' from ontologyTerm.Identifier -> ontologyTerm.id
		for(GWASExperiment o: gWASExperimentList) 
		{
			if(o.getExperimentType_Identifier() != null) 
				experimentTypeKeymap.put(o.getExperimentType_Identifier(), null);
		}
		
		if(experimentTypeKeymap.size() > 0) 
		{
			List<OntologyTerm> experimentTypeList = db.query(OntologyTerm.class).in("Identifier",new ArrayList<Object>(experimentTypeKeymap.keySet())).find();
			for(OntologyTerm xref :  experimentTypeList)
			{
				experimentTypeKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//resolve xref 'assayedPanels' from panel.Identifier -> panel.id
		for(GWASExperiment o: gWASExperimentList) for(String xref_label: o.getAssayedPanels_Identifier())
		{
			if(xref_label != null) 
				assayedPanelsKeymap.put(xref_label, null);
		}
		
		if(assayedPanelsKeymap.size() > 0) 
		{
			List<Panel> assayedPanelsList = db.query(Panel.class).in("Identifier",new ArrayList<Object>(assayedPanelsKeymap.keySet())).find();
			for(Panel xref :  assayedPanelsList)
			{
				assayedPanelsKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//resolve xref 'dataSets' from dataSet.Identifier -> dataSet.id
		for(GWASExperiment o: gWASExperimentList) for(String xref_label: o.getDataSets_Identifier())
		{
			if(xref_label != null) 
				dataSetsKeymap.put(xref_label, null);
		}
		
		if(dataSetsKeymap.size() > 0) 
		{
			List<DataSet> dataSetsList = db.query(DataSet.class).in("Identifier",new ArrayList<Object>(dataSetsKeymap.keySet())).find();
			for(DataSet xref :  dataSetsList)
			{
				dataSetsKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(GWASExperiment o:  gWASExperimentList)
		{
			while(true){
				//update xref Study
				if(o.getStudy_Identifier() != null) 
				{
					String key = o.getStudy_Identifier();
					if(studyKeymap.get(key) == null)
					{
						throw new Exception("Import of 'GWASExperiment' objects failed: cannot find Study for study_Identifier='"+o.getStudy_Identifier()+"'");
					}
					o.setStudy_Id(studyKeymap.get(key));
				}
				//update xref ExperimentType
				if(o.getExperimentType_Identifier() != null) 
				{
					String key = o.getExperimentType_Identifier();
					if(experimentTypeKeymap.get(key) == null)
					{
						throw new Exception("Import of 'GWASExperiment' objects failed: cannot find OntologyTerm for experimentType_Identifier='"+o.getExperimentType_Identifier()+"'");
					}
					o.setExperimentType_Id(experimentTypeKeymap.get(key));
				}
				//update mref AssayedPanels
				if(o.getAssayedPanels_Identifier() != null) 
				{
					List<Integer> mrefs = new ArrayList<Integer>();
					boolean breakToNextGWASExperiment = false;

					int listSize = 0;
					if(o.getAssayedPanels_Identifier() != null) listSize = Math.max(o.getAssayedPanels_Identifier().size(), listSize);
					for(int i = 0; i < listSize; i++)
					{
						String key = o.getAssayedPanels_Identifier().get(i);
						if(assayedPanelsKeymap.get(key) == null){
							logger.error("Import of 'GWASExperiment' objects failed: "+o);
							throw new Exception("Import of 'GWASExperiment' objects failed: cannot find assayedPanels_Identifier='"+(o.getAssayedPanels_Identifier() != null && i < o.getAssayedPanels_Identifier().size() ? o.getAssayedPanels_Identifier().get(i) : "null")+"'");
						}
						mrefs.add(assayedPanelsKeymap.get(key));
					}
					if(breakToNextGWASExperiment){
						break;
					}
					o.setAssayedPanels_Id(mrefs);
				}
				//update mref DataSets
				if(o.getDataSets_Identifier() != null) 
				{
					List<Integer> mrefs = new ArrayList<Integer>();
					boolean breakToNextGWASExperiment = false;

					int listSize = 0;
					if(o.getDataSets_Identifier() != null) listSize = Math.max(o.getDataSets_Identifier().size(), listSize);
					for(int i = 0; i < listSize; i++)
					{
						String key = o.getDataSets_Identifier().get(i);
						if(dataSetsKeymap.get(key) == null){
							logger.error("Import of 'GWASExperiment' objects failed: "+o);
							throw new Exception("Import of 'GWASExperiment' objects failed: cannot find dataSets_Identifier='"+(o.getDataSets_Identifier() != null && i < o.getDataSets_Identifier().size() ? o.getDataSets_Identifier().get(i) : "null")+"'");
						}
						mrefs.add(dataSetsKeymap.get(key));
					}
					if(breakToNextGWASExperiment){
						break;
					}
					o.setDataSets_Id(mrefs);
				}
				break;
			}
		}
		
		studyKeymap.clear();
		experimentTypeKeymap.clear();
		assayedPanelsKeymap.clear();
		dataSetsKeymap.clear();
		
		return gWASExperimentsMissingRefs;
	}
}

