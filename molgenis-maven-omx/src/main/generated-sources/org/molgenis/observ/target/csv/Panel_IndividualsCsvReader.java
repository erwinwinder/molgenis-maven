
/* File:        org.molgenis/model/Panel_Individuals.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 26, 2012
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

import org.molgenis.observ.target.Individual;
import org.molgenis.observ.target.Panel;
import org.molgenis.observ.target.Panel_Individuals;


/**
 * Reads Panel_Individuals from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class Panel_IndividualsCsvReader extends CsvToDatabase<Panel_Individuals>
{
	private static final Logger logger = Logger.getLogger(Panel_IndividualsCsvReader.class);
	
	//foreign key map for xref 'individuals' (maps individual.Identifier -> individual.id)			
	final Map<String,Integer> individualsKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'panel' (maps panel.Identifier -> panel.id)			
	final Map<String,Integer> panelKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports Panel_Individuals from tab/comma delimited File
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
		List<Panel_Individuals> panel_IndividualssMissingRefs = new ArrayList<Panel_Individuals>();
	
		//cache for objects to be imported from file (in batch)
		final List<Panel_Individuals> panel_IndividualsList = new ArrayList<Panel_Individuals>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Panel_Individuals object = new Panel_Individuals();
			object.set(defaults, false); 
			object.set(tuple, false);				
			panel_IndividualsList.add(object);		
			
			//add to db when batch size is reached
			if(panel_IndividualsList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				panel_IndividualssMissingRefs.addAll(resolveForeignKeys(db, panel_IndividualsList));
				panel_IndividualsList.removeAll(panel_IndividualssMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'Individuals,Panel' defined in xref_label
				db.update(panel_IndividualsList,dbAction, "Individuals", "Panel");
				
				//clear for next batch						
				panel_IndividualsList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!panel_IndividualsList.isEmpty())
		{
			total.set(total.get() + panel_IndividualsList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			panel_IndividualssMissingRefs.addAll(resolveForeignKeys(db, panel_IndividualsList));
			panel_IndividualsList.removeAll(panel_IndividualssMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'Individuals,Panel' defined in xref_label
			db.update(panel_IndividualsList,dbAction, "Individuals", "Panel");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<Panel_Individuals> panel_Individualss = new ArrayList<Panel_Individuals>(panel_IndividualssMissingRefs);

		int iterationCount = 0;

		do
		{
			panel_IndividualssMissingRefs = resolveForeignKeys(db, panel_IndividualssMissingRefs);
			@SuppressWarnings("unchecked")
			List<Panel_Individuals> resolvablepanel_Individualss = new ArrayList<Panel_Individuals>(CollectionUtils.disjunction(panel_Individualss,
					panel_IndividualssMissingRefs));
			panel_Individualss.removeAll(resolvablepanel_Individualss);
			
			db.update(resolvablepanel_Individualss,dbAction, "Individuals", "Panel");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'panel_Individuals' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still panel_Individualss referring to Individuals that are neither in the database nor in the list of to-be imported panel_Individualss."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (panel_IndividualssMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " panel_Individuals from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param panel_IndividualsList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Panel_Individuals> resolveForeignKeys(Database db, List<Panel_Individuals> panel_IndividualsList) throws Exception
	{
		//keep a list of Panel_Individuals instances that miss a reference which might be resolvable later
		List<Panel_Individuals> panel_IndividualssMissingRefs = new ArrayList<Panel_Individuals>();
	
		//resolve xref 'individuals' from individual.Identifier -> individual.id
		for(Panel_Individuals o: panel_IndividualsList) 
		{
			if(o.getIndividuals_Identifier() != null) 
				individualsKeymap.put(o.getIndividuals_Identifier(), null);
		}
		
		if(individualsKeymap.size() > 0) 
		{
			List<Individual> individualsList = db.query(Individual.class).in("Identifier",new ArrayList<Object>(individualsKeymap.keySet())).find();
			for(Individual xref :  individualsList)
			{
				individualsKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//resolve xref 'panel' from panel.Identifier -> panel.id
		for(Panel_Individuals o: panel_IndividualsList) 
		{
			if(o.getPanel_Identifier() != null) 
				panelKeymap.put(o.getPanel_Identifier(), null);
		}
		
		if(panelKeymap.size() > 0) 
		{
			List<Panel> panelList = db.query(Panel.class).in("Identifier",new ArrayList<Object>(panelKeymap.keySet())).find();
			for(Panel xref :  panelList)
			{
				panelKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(Panel_Individuals o:  panel_IndividualsList)
		{
			while(true){
				//update xref Individuals
				if(o.getIndividuals_Identifier() != null) 
				{
					String key = o.getIndividuals_Identifier();
					if(individualsKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Panel_Individuals' objects failed: cannot find Individual for individuals_Identifier='"+o.getIndividuals_Identifier()+"'");
					}
					o.setIndividuals_Id(individualsKeymap.get(key));
				}
				//update xref Panel
				if(o.getPanel_Identifier() != null) 
				{
					String key = o.getPanel_Identifier();
					if(panelKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Panel_Individuals' objects failed: cannot find Panel for panel_Identifier='"+o.getPanel_Identifier()+"'");
					}
					o.setPanel_Id(panelKeymap.get(key));
				}
				break;
			}
		}
		
		individualsKeymap.clear();
		panelKeymap.clear();
		
		return panel_IndividualssMissingRefs;
	}
}

