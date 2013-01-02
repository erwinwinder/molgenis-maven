
/* File:        org.molgenis.omx/model/AssayedPanel.java
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

import org.molgenis.observ.target.OntologyTerm;
import org.molgenis.observ.target.Species;
import org.molgenis.observ.target.Individual;
import org.molgenis.gwascentral.AssayedPanel;


/**
 * Reads AssayedPanel from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class AssayedPanelCsvReader extends CsvToDatabase<AssayedPanel>
{
	private static final Logger logger = Logger.getLogger(AssayedPanelCsvReader.class);
	
	//foreign key map for xref 'panelType' (maps ontologyTerm.Identifier -> ontologyTerm.id)			
	final Map<String,Integer> panelTypeKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'species' (maps species.Identifier -> species.id)			
	final Map<String,Integer> speciesKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'individuals' (maps individual.Identifier -> individual.id)			
	final Map<String,Integer> individualsKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports AssayedPanel from tab/comma delimited File
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
		List<AssayedPanel> assayedPanelsMissingRefs = new ArrayList<AssayedPanel>();
	
		//cache for objects to be imported from file (in batch)
		final List<AssayedPanel> assayedPanelList = new ArrayList<AssayedPanel>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			AssayedPanel object = new AssayedPanel();
			object.set(defaults, false); 
			object.set(tuple, false);				
			assayedPanelList.add(object);		
			
			//add to db when batch size is reached
			if(assayedPanelList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				assayedPanelsMissingRefs.addAll(resolveForeignKeys(db, assayedPanelList));
				assayedPanelList.removeAll(assayedPanelsMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
				db.update(assayedPanelList,dbAction, "Identifier");
				
				//clear for next batch						
				assayedPanelList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!assayedPanelList.isEmpty())
		{
			total.set(total.get() + assayedPanelList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			assayedPanelsMissingRefs.addAll(resolveForeignKeys(db, assayedPanelList));
			assayedPanelList.removeAll(assayedPanelsMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
			db.update(assayedPanelList,dbAction, "Identifier");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<AssayedPanel> assayedPanels = new ArrayList<AssayedPanel>(assayedPanelsMissingRefs);

		int iterationCount = 0;

		do
		{
			assayedPanelsMissingRefs = resolveForeignKeys(db, assayedPanelsMissingRefs);
			@SuppressWarnings("unchecked")
			List<AssayedPanel> resolvableassayedPanels = new ArrayList<AssayedPanel>(CollectionUtils.disjunction(assayedPanels,
					assayedPanelsMissingRefs));
			assayedPanels.removeAll(resolvableassayedPanels);
			
			db.update(resolvableassayedPanels,dbAction, "Identifier");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'assayedPanel' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still assayedPanels referring to Individuals that are neither in the database nor in the list of to-be imported assayedPanels."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (assayedPanelsMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " assayedPanel from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param assayedPanelList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<AssayedPanel> resolveForeignKeys(Database db, List<AssayedPanel> assayedPanelList) throws Exception
	{
		//keep a list of AssayedPanel instances that miss a reference which might be resolvable later
		List<AssayedPanel> assayedPanelsMissingRefs = new ArrayList<AssayedPanel>();
	
		//resolve xref 'panelType' from ontologyTerm.Identifier -> ontologyTerm.id
		for(AssayedPanel o: assayedPanelList) 
		{
			if(o.getPanelType_Identifier() != null) 
				panelTypeKeymap.put(o.getPanelType_Identifier(), null);
		}
		
		if(panelTypeKeymap.size() > 0) 
		{
			List<OntologyTerm> panelTypeList = db.query(OntologyTerm.class).in("Identifier",new ArrayList<Object>(panelTypeKeymap.keySet())).find();
			for(OntologyTerm xref :  panelTypeList)
			{
				panelTypeKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//resolve xref 'species' from species.Identifier -> species.id
		for(AssayedPanel o: assayedPanelList) 
		{
			if(o.getSpecies_Identifier() != null) 
				speciesKeymap.put(o.getSpecies_Identifier(), null);
		}
		
		if(speciesKeymap.size() > 0) 
		{
			List<Species> speciesList = db.query(Species.class).in("Identifier",new ArrayList<Object>(speciesKeymap.keySet())).find();
			for(Species xref :  speciesList)
			{
				speciesKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//resolve xref 'individuals' from individual.Identifier -> individual.id
		for(AssayedPanel o: assayedPanelList) for(String xref_label: o.getIndividuals_Identifier())
		{
			if(xref_label != null) 
				individualsKeymap.put(xref_label, null);
		}
		
		if(individualsKeymap.size() > 0) 
		{
			List<Individual> individualsList = db.query(Individual.class).in("Identifier",new ArrayList<Object>(individualsKeymap.keySet())).find();
			for(Individual xref :  individualsList)
			{
				individualsKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(AssayedPanel o:  assayedPanelList)
		{
			while(true){
				//update xref PanelType
				if(o.getPanelType_Identifier() != null) 
				{
					String key = o.getPanelType_Identifier();
					if(panelTypeKeymap.get(key) == null)
					{
						throw new Exception("Import of 'AssayedPanel' objects failed: cannot find OntologyTerm for panelType_Identifier='"+o.getPanelType_Identifier()+"'");
					}
					o.setPanelType_Id(panelTypeKeymap.get(key));
				}
				//update xref Species
				if(o.getSpecies_Identifier() != null) 
				{
					String key = o.getSpecies_Identifier();
					if(speciesKeymap.get(key) == null)
					{
						throw new Exception("Import of 'AssayedPanel' objects failed: cannot find Species for species_Identifier='"+o.getSpecies_Identifier()+"'");
					}
					o.setSpecies_Id(speciesKeymap.get(key));
				}
				//update mref Individuals
				if(o.getIndividuals_Identifier() != null) 
				{
					List<Integer> mrefs = new ArrayList<Integer>();
					boolean breakToNextAssayedPanel = false;

					int listSize = 0;
					if(o.getIndividuals_Identifier() != null) listSize = Math.max(o.getIndividuals_Identifier().size(), listSize);
					for(int i = 0; i < listSize; i++)
					{
						String key = o.getIndividuals_Identifier().get(i);
						if(individualsKeymap.get(key) == null){
							logger.error("Import of 'AssayedPanel' objects failed: "+o);
							throw new Exception("Import of 'AssayedPanel' objects failed: cannot find individuals_Identifier='"+(o.getIndividuals_Identifier() != null && i < o.getIndividuals_Identifier().size() ? o.getIndividuals_Identifier().get(i) : "null")+"'");
						}
						mrefs.add(individualsKeymap.get(key));
					}
					if(breakToNextAssayedPanel){
						break;
					}
					o.setIndividuals_Id(mrefs);
				}
				break;
			}
		}
		
		panelTypeKeymap.clear();
		speciesKeymap.clear();
		individualsKeymap.clear();
		
		return assayedPanelsMissingRefs;
	}
}

