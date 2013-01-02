
/* File:        org.molgenis.omx/model/PanelSource.java
 * Copyright:   GBIC 2000-2013, all rights reserved
 * Date:        January 2, 2013
 * 
 * generator:   org.molgenis.generators.csv.CsvReaderGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.observ.target.csv;

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
import org.molgenis.observ.target.PanelSource;


/**
 * Reads PanelSource from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class PanelSourceCsvReader extends CsvToDatabase<PanelSource>
{
	private static final Logger logger = Logger.getLogger(PanelSourceCsvReader.class);
	
	//foreign key map for xref 'currentPanel' (maps panel.Identifier -> panel.id)			
	final Map<String,Integer> currentPanelKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'sourcePanel' (maps panel.Identifier -> panel.id)			
	final Map<String,Integer> sourcePanelKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports PanelSource from tab/comma delimited File
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
		List<PanelSource> panelSourcesMissingRefs = new ArrayList<PanelSource>();
	
		//cache for objects to be imported from file (in batch)
		final List<PanelSource> panelSourceList = new ArrayList<PanelSource>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			PanelSource object = new PanelSource();
			object.set(defaults, false); 
			object.set(tuple, false);				
			panelSourceList.add(object);		
			
			//add to db when batch size is reached
			if(panelSourceList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				panelSourcesMissingRefs.addAll(resolveForeignKeys(db, panelSourceList));
				panelSourceList.removeAll(panelSourcesMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'id' defined in xref_label
				db.update(panelSourceList,dbAction, "id");
				
				//clear for next batch						
				panelSourceList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!panelSourceList.isEmpty())
		{
			total.set(total.get() + panelSourceList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			panelSourcesMissingRefs.addAll(resolveForeignKeys(db, panelSourceList));
			panelSourceList.removeAll(panelSourcesMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'id' defined in xref_label
			db.update(panelSourceList,dbAction, "id");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<PanelSource> panelSources = new ArrayList<PanelSource>(panelSourcesMissingRefs);

		int iterationCount = 0;

		do
		{
			panelSourcesMissingRefs = resolveForeignKeys(db, panelSourcesMissingRefs);
			@SuppressWarnings("unchecked")
			List<PanelSource> resolvablepanelSources = new ArrayList<PanelSource>(CollectionUtils.disjunction(panelSources,
					panelSourcesMissingRefs));
			panelSources.removeAll(resolvablepanelSources);
			
			db.update(resolvablepanelSources,dbAction, "id");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'panelSource' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still panelSources referring to Individuals that are neither in the database nor in the list of to-be imported panelSources."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (panelSourcesMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " panelSource from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param panelSourceList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<PanelSource> resolveForeignKeys(Database db, List<PanelSource> panelSourceList) throws Exception
	{
		//keep a list of PanelSource instances that miss a reference which might be resolvable later
		List<PanelSource> panelSourcesMissingRefs = new ArrayList<PanelSource>();
	
		//resolve xref 'currentPanel' from panel.Identifier -> panel.id
		for(PanelSource o: panelSourceList) 
		{
			if(o.getCurrentPanel_Identifier() != null) 
				currentPanelKeymap.put(o.getCurrentPanel_Identifier(), null);
		}
		
		if(currentPanelKeymap.size() > 0) 
		{
			List<Panel> currentPanelList = db.query(Panel.class).in("Identifier",new ArrayList<Object>(currentPanelKeymap.keySet())).find();
			for(Panel xref :  currentPanelList)
			{
				currentPanelKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//resolve xref 'sourcePanel' from panel.Identifier -> panel.id
		for(PanelSource o: panelSourceList) 
		{
			if(o.getSourcePanel_Identifier() != null) 
				sourcePanelKeymap.put(o.getSourcePanel_Identifier(), null);
		}
		
		if(sourcePanelKeymap.size() > 0) 
		{
			List<Panel> sourcePanelList = db.query(Panel.class).in("Identifier",new ArrayList<Object>(sourcePanelKeymap.keySet())).find();
			for(Panel xref :  sourcePanelList)
			{
				sourcePanelKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(PanelSource o:  panelSourceList)
		{
			while(true){
				//update xref CurrentPanel
				if(o.getCurrentPanel_Identifier() != null) 
				{
					String key = o.getCurrentPanel_Identifier();
					if(currentPanelKeymap.get(key) == null)
					{
						throw new Exception("Import of 'PanelSource' objects failed: cannot find Panel for currentPanel_Identifier='"+o.getCurrentPanel_Identifier()+"'");
					}
					o.setCurrentPanel_Id(currentPanelKeymap.get(key));
				}
				//update xref SourcePanel
				if(o.getSourcePanel_Identifier() != null) 
				{
					String key = o.getSourcePanel_Identifier();
					if(sourcePanelKeymap.get(key) == null)
					{
						throw new Exception("Import of 'PanelSource' objects failed: cannot find Panel for sourcePanel_Identifier='"+o.getSourcePanel_Identifier()+"'");
					}
					o.setSourcePanel_Id(sourcePanelKeymap.get(key));
				}
				break;
			}
		}
		
		currentPanelKeymap.clear();
		sourcePanelKeymap.clear();
		
		return panelSourcesMissingRefs;
	}
}

