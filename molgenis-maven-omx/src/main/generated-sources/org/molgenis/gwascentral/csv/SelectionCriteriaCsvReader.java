
/* File:        org.molgenis/model/SelectionCriteria.java
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

import org.molgenis.observ.target.Panel;
import org.molgenis.gwascentral.SelectionCriteria;


/**
 * Reads SelectionCriteria from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class SelectionCriteriaCsvReader extends CsvToDatabase<SelectionCriteria>
{
	private static final Logger logger = Logger.getLogger(SelectionCriteriaCsvReader.class);
	
	//foreign key map for xref 'sourcePanel' (maps panel.Identifier -> panel.id)			
	final Map<String,Integer> sourcePanelKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'targetPanel' (maps panel.Identifier -> panel.id)			
	final Map<String,Integer> targetPanelKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports SelectionCriteria from tab/comma delimited File
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
		List<SelectionCriteria> selectionCriteriasMissingRefs = new ArrayList<SelectionCriteria>();
	
		//cache for objects to be imported from file (in batch)
		final List<SelectionCriteria> selectionCriteriaList = new ArrayList<SelectionCriteria>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			SelectionCriteria object = new SelectionCriteria();
			object.set(defaults, false); 
			object.set(tuple, false);				
			selectionCriteriaList.add(object);		
			
			//add to db when batch size is reached
			if(selectionCriteriaList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				selectionCriteriasMissingRefs.addAll(resolveForeignKeys(db, selectionCriteriaList));
				selectionCriteriaList.removeAll(selectionCriteriasMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'id' defined in xref_label
				db.update(selectionCriteriaList,dbAction, "id");
				
				//clear for next batch						
				selectionCriteriaList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!selectionCriteriaList.isEmpty())
		{
			total.set(total.get() + selectionCriteriaList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			selectionCriteriasMissingRefs.addAll(resolveForeignKeys(db, selectionCriteriaList));
			selectionCriteriaList.removeAll(selectionCriteriasMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'id' defined in xref_label
			db.update(selectionCriteriaList,dbAction, "id");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<SelectionCriteria> selectionCriterias = new ArrayList<SelectionCriteria>(selectionCriteriasMissingRefs);

		int iterationCount = 0;

		do
		{
			selectionCriteriasMissingRefs = resolveForeignKeys(db, selectionCriteriasMissingRefs);
			@SuppressWarnings("unchecked")
			List<SelectionCriteria> resolvableselectionCriterias = new ArrayList<SelectionCriteria>(CollectionUtils.disjunction(selectionCriterias,
					selectionCriteriasMissingRefs));
			selectionCriterias.removeAll(resolvableselectionCriterias);
			
			db.update(resolvableselectionCriterias,dbAction, "id");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'selectionCriteria' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still selectionCriterias referring to Individuals that are neither in the database nor in the list of to-be imported selectionCriterias."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (selectionCriteriasMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " selectionCriteria from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param selectionCriteriaList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<SelectionCriteria> resolveForeignKeys(Database db, List<SelectionCriteria> selectionCriteriaList) throws Exception
	{
		//keep a list of SelectionCriteria instances that miss a reference which might be resolvable later
		List<SelectionCriteria> selectionCriteriasMissingRefs = new ArrayList<SelectionCriteria>();
	
		//resolve xref 'sourcePanel' from panel.Identifier -> panel.id
		for(SelectionCriteria o: selectionCriteriaList) 
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
		//resolve xref 'targetPanel' from panel.Identifier -> panel.id
		for(SelectionCriteria o: selectionCriteriaList) 
		{
			if(o.getTargetPanel_Identifier() != null) 
				targetPanelKeymap.put(o.getTargetPanel_Identifier(), null);
		}
		
		if(targetPanelKeymap.size() > 0) 
		{
			List<Panel> targetPanelList = db.query(Panel.class).in("Identifier",new ArrayList<Object>(targetPanelKeymap.keySet())).find();
			for(Panel xref :  targetPanelList)
			{
				targetPanelKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(SelectionCriteria o:  selectionCriteriaList)
		{
			while(true){
				//update xref SourcePanel
				if(o.getSourcePanel_Identifier() != null) 
				{
					String key = o.getSourcePanel_Identifier();
					if(sourcePanelKeymap.get(key) == null)
					{
						throw new Exception("Import of 'SelectionCriteria' objects failed: cannot find Panel for sourcePanel_Identifier='"+o.getSourcePanel_Identifier()+"'");
					}
					o.setSourcePanel_Id(sourcePanelKeymap.get(key));
				}
				//update xref TargetPanel
				if(o.getTargetPanel_Identifier() != null) 
				{
					String key = o.getTargetPanel_Identifier();
					if(targetPanelKeymap.get(key) == null)
					{
						throw new Exception("Import of 'SelectionCriteria' objects failed: cannot find Panel for targetPanel_Identifier='"+o.getTargetPanel_Identifier()+"'");
					}
					o.setTargetPanel_Id(targetPanelKeymap.get(key));
				}
				break;
			}
		}
		
		sourcePanelKeymap.clear();
		targetPanelKeymap.clear();
		
		return selectionCriteriasMissingRefs;
	}
}

