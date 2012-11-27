
/* File:        org.molgenis/model/PhenotypeProperty.java
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

import org.molgenis.observ.target.OntologyTerm;
import org.molgenis.gwascentral.PhenotypeProperty;


/**
 * Reads PhenotypeProperty from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class PhenotypePropertyCsvReader extends CsvToDatabase<PhenotypeProperty>
{
	private static final Logger logger = Logger.getLogger(PhenotypePropertyCsvReader.class);
	
	//foreign key map for xref 'unit' (maps ontologyTerm.Identifier -> ontologyTerm.id)			
	final Map<String,Integer> unitKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports PhenotypeProperty from tab/comma delimited File
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
		List<PhenotypeProperty> phenotypePropertysMissingRefs = new ArrayList<PhenotypeProperty>();
	
		//cache for objects to be imported from file (in batch)
		final List<PhenotypeProperty> phenotypePropertyList = new ArrayList<PhenotypeProperty>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			PhenotypeProperty object = new PhenotypeProperty();
			object.set(defaults, false); 
			object.set(tuple, false);				
			phenotypePropertyList.add(object);		
			
			//add to db when batch size is reached
			if(phenotypePropertyList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				phenotypePropertysMissingRefs.addAll(resolveForeignKeys(db, phenotypePropertyList));
				phenotypePropertyList.removeAll(phenotypePropertysMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
				db.update(phenotypePropertyList,dbAction, "Identifier");
				
				//clear for next batch						
				phenotypePropertyList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!phenotypePropertyList.isEmpty())
		{
			total.set(total.get() + phenotypePropertyList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			phenotypePropertysMissingRefs.addAll(resolveForeignKeys(db, phenotypePropertyList));
			phenotypePropertyList.removeAll(phenotypePropertysMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
			db.update(phenotypePropertyList,dbAction, "Identifier");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<PhenotypeProperty> phenotypePropertys = new ArrayList<PhenotypeProperty>(phenotypePropertysMissingRefs);

		int iterationCount = 0;

		do
		{
			phenotypePropertysMissingRefs = resolveForeignKeys(db, phenotypePropertysMissingRefs);
			@SuppressWarnings("unchecked")
			List<PhenotypeProperty> resolvablephenotypePropertys = new ArrayList<PhenotypeProperty>(CollectionUtils.disjunction(phenotypePropertys,
					phenotypePropertysMissingRefs));
			phenotypePropertys.removeAll(resolvablephenotypePropertys);
			
			db.update(resolvablephenotypePropertys,dbAction, "Identifier");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'phenotypeProperty' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still phenotypePropertys referring to Individuals that are neither in the database nor in the list of to-be imported phenotypePropertys."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (phenotypePropertysMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " phenotypeProperty from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param phenotypePropertyList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<PhenotypeProperty> resolveForeignKeys(Database db, List<PhenotypeProperty> phenotypePropertyList) throws Exception
	{
		//keep a list of PhenotypeProperty instances that miss a reference which might be resolvable later
		List<PhenotypeProperty> phenotypePropertysMissingRefs = new ArrayList<PhenotypeProperty>();
	
		//resolve xref 'unit' from ontologyTerm.Identifier -> ontologyTerm.id
		for(PhenotypeProperty o: phenotypePropertyList) 
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
		//update objects with foreign key values
		for(PhenotypeProperty o:  phenotypePropertyList)
		{
			while(true){
				//update xref unit
				if(o.getUnit_Identifier() != null) 
				{
					String key = o.getUnit_Identifier();
					if(unitKeymap.get(key) == null)
					{
						throw new Exception("Import of 'PhenotypeProperty' objects failed: cannot find OntologyTerm for unit_Identifier='"+o.getUnit_Identifier()+"'");
					}
					o.setUnit_Id(unitKeymap.get(key));
				}
				break;
			}
		}
		
		unitKeymap.clear();
		
		return phenotypePropertysMissingRefs;
	}
}

