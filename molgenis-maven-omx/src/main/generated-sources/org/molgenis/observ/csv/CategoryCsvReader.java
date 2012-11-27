
/* File:        org.molgenis/model/Category.java
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

import org.molgenis.observ.ObservableFeature;
import org.molgenis.observ.Category;


/**
 * Reads Category from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class CategoryCsvReader extends CsvToDatabase<Category>
{
	private static final Logger logger = Logger.getLogger(CategoryCsvReader.class);
	
	//foreign key map for xref 'observableFeature' (maps observableFeature.Identifier -> observableFeature.id)			
	final Map<String,Integer> observableFeatureKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports Category from tab/comma delimited File
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
		List<Category> categorysMissingRefs = new ArrayList<Category>();
	
		//cache for objects to be imported from file (in batch)
		final List<Category> categoryList = new ArrayList<Category>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Category object = new Category();
			object.set(defaults, false); 
			object.set(tuple, false);				
			categoryList.add(object);		
			
			//add to db when batch size is reached
			if(categoryList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				categorysMissingRefs.addAll(resolveForeignKeys(db, categoryList));
				categoryList.removeAll(categorysMissingRefs);
				
				//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
				db.update(categoryList,dbAction, "Identifier");
				
				//clear for next batch						
				categoryList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!categoryList.isEmpty())
		{
			total.set(total.get() + categoryList.size());
			
			//resolve foreign keys, again keeping track of those entities that could not be solved
			categorysMissingRefs.addAll(resolveForeignKeys(db, categoryList));
			categoryList.removeAll(categorysMissingRefs);
			
			//update objects in the database using xref_label defined secondary key(s) 'Identifier' defined in xref_label
			db.update(categoryList,dbAction, "Identifier");
		}
		
		//Try to resolve FK's for entities until all are resolved or we have more then 100 iterations
		List<Category> categorys = new ArrayList<Category>(categorysMissingRefs);

		int iterationCount = 0;

		do
		{
			categorysMissingRefs = resolveForeignKeys(db, categorysMissingRefs);
			@SuppressWarnings("unchecked")
			List<Category> resolvablecategorys = new ArrayList<Category>(CollectionUtils.disjunction(categorys,
					categorysMissingRefs));
			categorys.removeAll(resolvablecategorys);
			
			db.update(resolvablecategorys,dbAction, "Identifier");

			if (iterationCount++ > 100)
			{
				throw new Exception(
						"Import of 'category' objects failed: attempting to resolve in-list references,"
								+ "but after 100 iterations there are still categorys referring to Individuals that are neither in the database nor in the list of to-be imported categorys."
								+ "Maybe there is a cyclic reference somewhere ?");
			}
		}
		while (categorysMissingRefs.size() > 0);

		logger.info("imported " + total.get() + " category from CSV");

		return total.get();
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param categoryList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Category> resolveForeignKeys(Database db, List<Category> categoryList) throws Exception
	{
		//keep a list of Category instances that miss a reference which might be resolvable later
		List<Category> categorysMissingRefs = new ArrayList<Category>();
	
		//resolve xref 'observableFeature' from observableFeature.Identifier -> observableFeature.id
		for(Category o: categoryList) 
		{
			if(o.getObservableFeature_Identifier() != null) 
				observableFeatureKeymap.put(o.getObservableFeature_Identifier(), null);
		}
		
		if(observableFeatureKeymap.size() > 0) 
		{
			List<ObservableFeature> observableFeatureList = db.query(ObservableFeature.class).in("Identifier",new ArrayList<Object>(observableFeatureKeymap.keySet())).find();
			for(ObservableFeature xref :  observableFeatureList)
			{
				observableFeatureKeymap.put(xref.getIdentifier(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(Category o:  categoryList)
		{
			while(true){
				//update xref observableFeature
				if(o.getObservableFeature_Identifier() != null) 
				{
					String key = o.getObservableFeature_Identifier();
					if(observableFeatureKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Category' objects failed: cannot find ObservableFeature for observableFeature_Identifier='"+o.getObservableFeature_Identifier()+"'");
					}
					o.setObservableFeature_Id(observableFeatureKeymap.get(key));
				}
				break;
			}
		}
		
		observableFeatureKeymap.clear();
		
		return categorysMissingRefs;
	}
}

