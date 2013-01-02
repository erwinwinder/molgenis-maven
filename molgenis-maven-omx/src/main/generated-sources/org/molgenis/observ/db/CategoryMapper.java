/* File:        org.molgenis.omx/model/Category.java
 * Copyright:   GBIC 2000-2013, all rights reserved
 * Date:        January 2, 2013
 * Template:	MultiqueryMapperGen.java.ftl
 * generator:   org.molgenis.generators.db.MultiqueryMapperGen 4.0.0-testing
 *
 * Using "subclass per table" strategy
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.observ.db;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

import org.molgenis.framework.db.Database;
import org.molgenis.framework.db.QueryRule;
import org.molgenis.framework.db.QueryRule.Operator;
import org.molgenis.framework.db.DatabaseException;
import org.molgenis.framework.db.jdbc.AbstractJDBCMapper;
import org.molgenis.MolgenisFieldTypes;
import org.molgenis.fieldtypes.*;


import org.molgenis.framework.db.jdbc.JDBCDatabase;
import org.molgenis.framework.db.QueryRule;
import org.molgenis.util.ValueLabel;
import org.molgenis.observ.Category;

import org.molgenis.observ.Characteristic;
import org.molgenis.observ.db.CharacteristicMapper;
import org.molgenis.observ.ObservableFeature;

public class CategoryMapper extends AbstractJDBCMapper<Category>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends Category> entities) throws DatabaseException
	{	
		//add superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.Characteristic.class).executeAdd(entities);
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO Category (observableFeature,valueCode,isMissing,id) VALUES ");
		{
		
			boolean first = true;
			for(Category e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//observableFeature
				if(e.getObservableFeature_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getObservableFeature_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//valueCode
				if(e.getValueCode() != null){
								
					sql.append("'"+this.escapeSql(e.getValueCode().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//isMissing
				if(e.getIsMissing() != null){
								
					sql.append(e.getIsMissing()
				+",");
				}
				else{
					sql.append("null,");
				}
				//id
				if(e.getId() != null){
								
					sql.append("'"+this.escapeSql(e.getId().toString())+"'"
				);
				}
				else{
					sql.append("null");
				}
				sql.append(")");
			}
		}		
		
		//execute sql
		Statement stmt = null; 		
		try
		{			
			stmt = conn.createStatement();
			//logger.debug("created statement: "+sql.toString());
			int updatedRows = stmt.executeUpdate(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			getGeneratedKeys(entities, stmt, 0);
			return updatedRows;			
		} catch (SQLException sqlEx) {
                    throw new DatabaseException(sqlEx);
                }
		finally
		{
			JDBCDatabase.closeStatement(stmt);
		}
	}

	@Override
	public int executeUpdate(List<? extends Category> entities) throws DatabaseException
	{
		//update superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.Characteristic.class).executeUpdate(entities);
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO Category (observableFeature,valueCode,isMissing,id) VALUES ");		
		boolean first = true;
		for(Category e: entities)
		{
			// put the ,
			if(first)
				first = false;
			else
				sql.append(",");

			sql.append("(");
			
			//observableFeature


			if(e.getObservableFeature_Id() != null){
                sql.append("'"+this.escapeSql(e.getObservableFeature_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//valueCode


			if(e.getValueCode() != null){
                sql.append("'"+this.escapeSql(e.getValueCode()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//isMissing


			if(e.getIsMissing() != null){
                sql.append(e.getIsMissing() +",");
			} else {
				sql.append("null,");
            }
		
			//id


			if(e.getId() != null){
                sql.append("'"+this.escapeSql(e.getId()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE observableFeature=VALUES(observableFeature),valueCode=VALUES(valueCode),isMissing=VALUES(isMissing),id=LAST_INSERT_ID(id)");

		//execute sql
		Statement stmt = null;	
		try
		{
			stmt = conn.createStatement();
			return stmt.executeUpdate(sql.toString())/2;	
		}
		catch(SQLException sqlEx){
                    logger.debug("Query that caused exception:" + sql.toString());                    
                    throw new DatabaseException(sqlEx);
		}
		finally
		{
			JDBCDatabase.closeStatement(stmt);
		}		
	}

	@Override
	public int executeRemove(List<? extends Category> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM Category WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(Category e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");			
				sql.append("'"+this.escapeSql(e.getId().toString())+"'");
			}				
			sql.append(") ");
		}
	
		//execute sql
		Statement stmt = null;
		try
		{	
			stmt = conn.createStatement();
			rowsAffected = stmt.executeUpdate(sql.toString());	
		} 
		catch (SQLException sqlEx) 
		{
			throw new DatabaseException(sqlEx);
		}
		finally
		{
			JDBCDatabase.closeStatement(stmt);
		}		
		//remove superclass after
		this.getDatabase().getMapperFor(org.molgenis.observ.Characteristic.class).executeRemove(entities);
		return rowsAffected;
	}
	
//Generated by MapperCommons.subclass_per_table.java.ftl
	
	public CategoryMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT Category.id"
			+", Characteristic.Identifier"
			+", Characteristic.Name"
			+", Characteristic.__Type"
			+", Characteristic.description"
			+", Category.observableFeature"
			+", Category.valueCode"
			+", Category.isMissing"
			//parent is SimpleTree(name='observableFeature')
			+", xref_observableFeature.Identifier AS observableFeature_Identifier"
			+" FROM Category "
			+" INNER JOIN Characteristic ON (Category.id = Characteristic.id)"

			
			//label for observableFeature=Identifier
//path==observableFeature. type==xref.
//path==observableFeature_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Characteristic AS xref_observableFeature " 
			+" ON xref_observableFeature.id = Category.observableFeature"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM Category "
			  +" INNER JOIN Characteristic ON (Category.id = Characteristic.id)"
			
			//label for observableFeature=Identifier
//observableFeature
//observableFeature_Identifier
		   	+" LEFT JOIN Characteristic AS xref_observableFeature " 
			+" ON xref_observableFeature.id = Category.observableFeature"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "Category.id";
		if("Category_id".equalsIgnoreCase(fieldName)) return "Category.id";
		if("Identifier".equalsIgnoreCase(fieldName)) return "Characteristic.Identifier";
		if("Category_Identifier".equalsIgnoreCase(fieldName)) return "Characteristic.Identifier";
		if("Name".equalsIgnoreCase(fieldName)) return "Characteristic.Name";
		if("Category_Name".equalsIgnoreCase(fieldName)) return "Characteristic.Name";
		if("__Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("Category___Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("description".equalsIgnoreCase(fieldName)) return "Characteristic.description";
		if("Category_description".equalsIgnoreCase(fieldName)) return "Characteristic.description";
		if("observableFeature".equalsIgnoreCase(fieldName)) return "Category.observableFeature";
		if("Category_observableFeature".equalsIgnoreCase(fieldName)) return "Category.observableFeature";
		if("valueCode".equalsIgnoreCase(fieldName)) return "Category.valueCode";
		if("Category_valueCode".equalsIgnoreCase(fieldName)) return "Category.valueCode";
		if("isMissing".equalsIgnoreCase(fieldName)) return "Category.isMissing";
		if("Category_isMissing".equalsIgnoreCase(fieldName)) return "Category.isMissing";
		if("observableFeature_id".equalsIgnoreCase(fieldName)) return "Category.observableFeature";
		if("Category_observableFeature_id".equalsIgnoreCase(fieldName)) return "Category.observableFeature";
		if("observableFeature_Identifier".equalsIgnoreCase(fieldName)) return "xref_observableFeature.Identifier";	
		if("Category_observableFeature_Identifier".equalsIgnoreCase(fieldName)) return "xref_observableFeature.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.observ.Category> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.observ.Category>(size); 
	}			

	public org.molgenis.observ.Category create()
	{
		return new org.molgenis.observ.Category();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.observ.Category> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'observableFeature' to observableFeature.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> observableFeatureRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.observ.Category object: entities)
		{
			//create xref/mref rule filtering ObservableFeature on the label Identifier
			if(object.getObservableFeature_Id() == null && object.getObservableFeature_Identifier() != null)
			{
				Object label = object.getObservableFeature_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !observableFeatureRules.containsKey(label))
					{
						observableFeatureRules.put(""+label, xrefFilter);
						observableFeatureRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
		}

		//resolve foreign key field 'observableFeature' to observableFeature.id using Identifier)
		final java.util.Map<String,Integer> observableFeature_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(observableFeatureRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.observ.ObservableFeature> observableFeatureList = null;
			try
			{
				observableFeatureList = getDatabase().find(org.molgenis.observ.ObservableFeature.class, observableFeatureRules.values().toArray(new org.molgenis.framework.db.QueryRule[observableFeatureRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.observ.ObservableFeature xref :  observableFeatureList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				observableFeature_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.observ.Category object = entities.get(i);		
			//update object using label fields Identifier
			if(object.getObservableFeature_Id() == null )
			{
					String key = "";
					if(object.getObservableFeature_Identifier() != null)
						key += 	object.getObservableFeature_Identifier();
					
					if(!"".equals(key) && observableFeature_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("observableFeature_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setObservableFeature_Id(observableFeature_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "category.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("identifier".equalsIgnoreCase(fieldName) || "characteristic.identifier".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("name".equalsIgnoreCase(fieldName) || "characteristic.name".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("__Type".equalsIgnoreCase(fieldName) || "characteristic.__Type".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.EnumField();
			if("description".equalsIgnoreCase(fieldName) || "characteristic.description".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("observableFeature".equalsIgnoreCase(fieldName) || "category.observableFeature".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("valueCode".equalsIgnoreCase(fieldName) || "category.valueCode".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("isMissing".equalsIgnoreCase(fieldName) || "category.isMissing".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.BoolField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, Category entity)
	{
		entity.setId(i);
	}
	
	@Override
	public QueryRule rewriteMrefRule(Database db, QueryRule rule) throws DatabaseException
	{
		
		{
			return rule;
		}
	}

//Generated by MapperFileAttachments.java.ftl
	public void prepareFileAttachements(java.util.List<org.molgenis.observ.Category> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.observ.Category> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<Category> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<Category> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<Category> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
