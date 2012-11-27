
/* File:        org.molgenis/model/Characteristic.java
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
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.molgenis.framework.db.CsvToDatabase;
import org.molgenis.framework.db.Database;
import org.molgenis.framework.db.DatabaseException;
import org.molgenis.framework.db.Query;
import org.molgenis.framework.db.Database.DatabaseAction;
import org.molgenis.util.CsvReader;
import org.molgenis.util.Tuple;

import org.molgenis.observ.Characteristic;


/**
 * Reads Characteristic from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class CharacteristicCsvReader extends CsvToDatabase<Characteristic>
{
	private static final Logger logger = Logger.getLogger(CharacteristicCsvReader.class);
	
			
	/**
	 * Imports Characteristic from tab/comma delimited File
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
		List<Characteristic> characteristicsMissingRefs = new ArrayList<Characteristic>();
	
		//cache for objects to be imported from file (in batch)
		final List<Characteristic> characteristicList = new ArrayList<Characteristic>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Characteristic object = new Characteristic();
			object.set(defaults, false); 
			object.set(tuple, false);				
			characteristicList.add(object);		
			
			//add to db when batch size is reached
			if(characteristicList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				characteristicsMissingRefs.addAll(resolveForeignKeys(db, characteristicList));
				characteristicList.removeAll(characteristicsMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
				db.update(characteristicList,dbAction, "Identifier");
				
				//clear for next batch						
				characteristicList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!characteristicList.isEmpty())
		{
			total.set(total.get() + characteristicList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			characteristicsMissingRefs.addAll(resolveForeignKeys(db, characteristicList));
			characteristicList.removeAll(characteristicsMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
			db.update(characteristicList,dbAction, "Identifier");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<Characteristic> characteristics = new ArrayList<Characteristic>(characteristicsMissingRefs);

		int iterationCount = 0;

		do
		{
			characteristicsMissingRefs = resolveForeignKeys(db, characteristicsMissingRefs);
			@SuppressWarnings("unchecked")
			List<Characteristic> resolvablecharacteristics = new ArrayList<Characteristic>(CollectionUtils.disjunction(characteristics,
					characteristicsMissingRefs));
			characteristics.removeAll(resolvablecharacteristics);
			
			db.update(resolvablecharacteristics,dbAction, "Identifier");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'characteristic' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still characteristics referring to Individuals that are neither in the database nor in the list of to-be imported characteristics."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (characteristicsMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " characteristic from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param characteristicList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Characteristic> resolveForeignKeys(Database db, List<Characteristic> characteristicList) throws Exception
	{
		//keep a list of Characteristic instances that miss a reference which might be resolvable later
		List<Characteristic> characteristicsMissingRefs = new ArrayList<Characteristic>();
	
		//update objects with foreign key values
		for(Characteristic o:  characteristicList)
		{
			while(true){
				break;
			}
		}
		
		
		return characteristicsMissingRefs;
	}
}

