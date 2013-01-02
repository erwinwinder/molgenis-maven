
/* File:        org.molgenis.omx/model/UsedMarkerSet.java
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
import org.molgenis.organization.Experiment;
import org.molgenis.gwascentral.UsedMarkerSet;


/**
 * Reads UsedMarkerSet from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class UsedMarkerSetCsvReader extends CsvToDatabase<UsedMarkerSet>
{
	private static final Logger logger = Logger.getLogger(UsedMarkerSetCsvReader.class);
	
	//foreign key map for xref 'unit' (maps ontologyTerm.Identifier -> ontologyTerm.id)			
	final Map<String,Integer> unitKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'experimentID' (maps experiment.Identifier -> experiment.id)			
	final Map<String,Integer> experimentIDKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports UsedMarkerSet from tab/comma delimited File
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
		List<UsedMarkerSet> usedMarkerSetsMissingRefs = new ArrayList<UsedMarkerSet>();
	
		//cache for objects to be imported from file (in batch)
		final List<UsedMarkerSet> usedMarkerSetList = new ArrayList<UsedMarkerSet>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			UsedMarkerSet object = new UsedMarkerSet();
			object.set(defaults, false); 
			object.set(tuple, false);				
			usedMarkerSetList.add(object);		
			
			//add to db when batch size is reached
			if(usedMarkerSetList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				usedMarkerSetsMissingRefs.addAll(resolveForeignKeys(db, usedMarkerSetList));
				usedMarkerSetList.removeAll(usedMarkerSetsMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
				db.update(usedMarkerSetList,dbAction, "Identifier");
				
				//clear for next batch						
				usedMarkerSetList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!usedMarkerSetList.isEmpty())
		{
			total.set(total.get() + usedMarkerSetList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			usedMarkerSetsMissingRefs.addAll(resolveForeignKeys(db, usedMarkerSetList));
			usedMarkerSetList.removeAll(usedMarkerSetsMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
			db.update(usedMarkerSetList,dbAction, "Identifier");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<UsedMarkerSet> usedMarkerSets = new ArrayList<UsedMarkerSet>(usedMarkerSetsMissingRefs);

		int iterationCount = 0;

		do
		{
			usedMarkerSetsMissingRefs = resolveForeignKeys(db, usedMarkerSetsMissingRefs);
			@SuppressWarnings("unchecked")
			List<UsedMarkerSet> resolvableusedMarkerSets = new ArrayList<UsedMarkerSet>(CollectionUtils.disjunction(usedMarkerSets,
					usedMarkerSetsMissingRefs));
			usedMarkerSets.removeAll(resolvableusedMarkerSets);
			
			db.update(resolvableusedMarkerSets,dbAction, "Identifier");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'usedMarkerSet' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still usedMarkerSets referring to Individuals that are neither in the database nor in the list of to-be imported usedMarkerSets."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (usedMarkerSetsMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " usedMarkerSet from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param usedMarkerSetList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<UsedMarkerSet> resolveForeignKeys(Database db, List<UsedMarkerSet> usedMarkerSetList) throws Exception
	{
		//keep a list of UsedMarkerSet instances that miss a reference which might be resolvable later
		List<UsedMarkerSet> usedMarkerSetsMissingRefs = new ArrayList<UsedMarkerSet>();
	
		//resolve xref 'unit' from ontologyTerm.Identifier -> ontologyTerm.id
		for(UsedMarkerSet o: usedMarkerSetList) 
		{
			if(o.getUnit_Identifier() != null) 
				unitKeymap.put(o.getUnit_Identifier(), null);
		}
		
		if(unitKeymap.size() > 0) 
		{
			List<OntologyTerm> unitList = db.query(OntologyTerm.class).in("Identifier",new ArrayList<Object>(unitKeymap.keySet())).find();
			for(OntologyTerm xref :  unitList)
			{
				unitKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//resolve xref 'experimentID' from experiment.Identifier -> experiment.id
		for(UsedMarkerSet o: usedMarkerSetList) 
		{
			if(o.getExperimentID_Identifier() != null) 
				experimentIDKeymap.put(o.getExperimentID_Identifier(), null);
		}
		
		if(experimentIDKeymap.size() > 0) 
		{
			List<Experiment> experimentIDList = db.query(Experiment.class).in("Identifier",new ArrayList<Object>(experimentIDKeymap.keySet())).find();
			for(Experiment xref :  experimentIDList)
			{
				experimentIDKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(UsedMarkerSet o:  usedMarkerSetList)
		{
			while(true){
				//update xref unit
				if(o.getUnit_Identifier() != null) 
				{
					String key = o.getUnit_Identifier();
					if(unitKeymap.get(key) == null)
					{
						throw new Exception("Import of 'UsedMarkerSet' objects failed: cannot find OntologyTerm for unit_Identifier='"+o.getUnit_Identifier()+"'");
					}
					o.setUnit_Id(unitKeymap.get(key));
				}
				//update xref ExperimentID
				if(o.getExperimentID_Identifier() != null) 
				{
					String key = o.getExperimentID_Identifier();
					if(experimentIDKeymap.get(key) == null)
					{
						throw new Exception("Import of 'UsedMarkerSet' objects failed: cannot find Experiment for experimentID_Identifier='"+o.getExperimentID_Identifier()+"'");
					}
					o.setExperimentID_Id(experimentIDKeymap.get(key));
				}
				break;
			}
		}
		
		unitKeymap.clear();
		experimentIDKeymap.clear();
		
		return usedMarkerSetsMissingRefs;
	}
}

