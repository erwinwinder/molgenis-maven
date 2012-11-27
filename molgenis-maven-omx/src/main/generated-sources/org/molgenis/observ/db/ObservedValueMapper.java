/* File:        org.molgenis/model/ObservedValue.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 26, 2012
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
import org.molgenis.observ.ObservedValue;

import org.molgenis.observ.ObservationSet;
import org.molgenis.observ.ObservableFeature;
import org.molgenis.observ.Characteristic;

public class ObservedValueMapper extends AbstractJDBCMapper<ObservedValue>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends ObservedValue> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO ObservedValue (__Type,ObservationSet,Feature,Characteristic,Value) VALUES ");
		{
		
			boolean first = true;
			for(ObservedValue e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//__Type
				if(e.get__Type() != null){
								
					sql.append("'"+this.escapeSql(e.get__Type().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//observationSet
				if(e.getObservationSet_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getObservationSet_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//feature
				if(e.getFeature_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getFeature_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//characteristic
				if(e.getCharacteristic_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getCharacteristic_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//value
				if(e.getValue() != null){
								
					sql.append("'"+this.escapeSql(e.getValue().toString())+"'"
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
	public int executeUpdate(List<? extends ObservedValue> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO ObservedValue (id,__Type,ObservationSet,Feature,Characteristic,Value) VALUES ");		
		boolean first = true;
		for(ObservedValue e: entities)
		{
			// put the ,
			if(first)
				first = false;
			else
				sql.append(",");

			sql.append("(");
			
			//id


			if(e.getId() != null){
                sql.append("'"+this.escapeSql(e.getId()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//__Type
			//readonly placeholder for insert-clause to prohibit not "null" errors: will be ignored in update
			sql.append("'ObservedValue' ,");	
		
			//observationSet


			if(e.getObservationSet_Id() != null){
                sql.append("'"+this.escapeSql(e.getObservationSet_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//feature


			if(e.getFeature_Id() != null){
                sql.append("'"+this.escapeSql(e.getFeature_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//characteristic


			if(e.getCharacteristic_Id() != null){
                sql.append("'"+this.escapeSql(e.getCharacteristic_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//value


			if(e.getValue() != null){
                sql.append("'"+this.escapeSql(e.getValue()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE ObservationSet=VALUES(ObservationSet),Feature=VALUES(Feature),Characteristic=VALUES(Characteristic),Value=VALUES(Value),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends ObservedValue> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM ObservedValue WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(ObservedValue e: entities)
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
		return rowsAffected;
	}
	
//Generated by MapperCommons.subclass_per_table.java.ftl
	
	public ObservedValueMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT ObservedValue.id"
			+", ObservedValue.__Type"
			+", ObservedValue.ObservationSet"
			+", ObservedValue.Feature"
			+", ObservedValue.Characteristic"
			+", ObservedValue.Value"
			//parent is SimpleTree(name='ObservationSet')
			+", xref_ObservationSet.id AS ObservationSet_Id"
			//parent is SimpleTree(name='Feature')
			+", xref_Feature.Identifier AS Feature_Identifier"
			//parent is SimpleTree(name='Characteristic')
			+", xref_Characteristic.Identifier AS Characteristic_Identifier"
			+" FROM ObservedValue "

			
			//label for ObservationSet=id
//path==ObservationSet. type==xref.
//path==ObservationSet_Id. type==int.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN ObservationSet AS xref_ObservationSet " 
			+" ON xref_ObservationSet.id = ObservedValue.ObservationSet"
			
			//label for Feature=Identifier
//path==Feature. type==xref.
//path==Feature_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Characteristic AS xref_Feature " 
			+" ON xref_Feature.id = ObservedValue.Feature"
			
			//label for Characteristic=Identifier
//path==Characteristic. type==xref.
//path==Characteristic_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Characteristic AS xref_Characteristic " 
			+" ON xref_Characteristic.id = ObservedValue.Characteristic"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM ObservedValue "
			
			//label for ObservationSet=id
//ObservationSet
//ObservationSet_Id
		   	+" LEFT JOIN ObservationSet AS xref_ObservationSet " 
			+" ON xref_ObservationSet.id = ObservedValue.ObservationSet"
			
			//label for Feature=Identifier
//Feature
//Feature_Identifier
		   	+" LEFT JOIN Characteristic AS xref_Feature " 
			+" ON xref_Feature.id = ObservedValue.Feature"
			
			//label for Characteristic=Identifier
//Characteristic
//Characteristic_Identifier
		   	+" LEFT JOIN Characteristic AS xref_Characteristic " 
			+" ON xref_Characteristic.id = ObservedValue.Characteristic"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "ObservedValue.id";
		if("ObservedValue_id".equalsIgnoreCase(fieldName)) return "ObservedValue.id";
		if("__Type".equalsIgnoreCase(fieldName)) return "ObservedValue.__Type";
		if("ObservedValue___Type".equalsIgnoreCase(fieldName)) return "ObservedValue.__Type";
		if("ObservationSet".equalsIgnoreCase(fieldName)) return "ObservedValue.ObservationSet";
		if("ObservedValue_ObservationSet".equalsIgnoreCase(fieldName)) return "ObservedValue.ObservationSet";
		if("Feature".equalsIgnoreCase(fieldName)) return "ObservedValue.Feature";
		if("ObservedValue_Feature".equalsIgnoreCase(fieldName)) return "ObservedValue.Feature";
		if("Characteristic".equalsIgnoreCase(fieldName)) return "ObservedValue.Characteristic";
		if("ObservedValue_Characteristic".equalsIgnoreCase(fieldName)) return "ObservedValue.Characteristic";
		if("Value".equalsIgnoreCase(fieldName)) return "ObservedValue.Value";
		if("ObservedValue_Value".equalsIgnoreCase(fieldName)) return "ObservedValue.Value";
		if("ObservationSet_id".equalsIgnoreCase(fieldName)) return "ObservedValue.ObservationSet";
		if("ObservedValue_ObservationSet_id".equalsIgnoreCase(fieldName)) return "ObservedValue.ObservationSet";
		if("ObservationSet_Id".equalsIgnoreCase(fieldName)) return "xref_ObservationSet.id";	
		if("ObservedValue_ObservationSet_Id".equalsIgnoreCase(fieldName)) return "xref_ObservationSet.id";
		if("Feature_id".equalsIgnoreCase(fieldName)) return "ObservedValue.Feature";
		if("ObservedValue_Feature_id".equalsIgnoreCase(fieldName)) return "ObservedValue.Feature";
		if("Feature_Identifier".equalsIgnoreCase(fieldName)) return "xref_Feature.Identifier";	
		if("ObservedValue_Feature_Identifier".equalsIgnoreCase(fieldName)) return "xref_Feature.Identifier";
		if("Characteristic_id".equalsIgnoreCase(fieldName)) return "ObservedValue.Characteristic";
		if("ObservedValue_Characteristic_id".equalsIgnoreCase(fieldName)) return "ObservedValue.Characteristic";
		if("Characteristic_Identifier".equalsIgnoreCase(fieldName)) return "xref_Characteristic.Identifier";	
		if("ObservedValue_Characteristic_Identifier".equalsIgnoreCase(fieldName)) return "xref_Characteristic.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.observ.ObservedValue> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.observ.ObservedValue>(size); 
	}			

	public org.molgenis.observ.ObservedValue create()
	{
		return new org.molgenis.observ.ObservedValue();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.observ.ObservedValue> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'feature' to observableFeature.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> featureRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'characteristic' to characteristic.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> characteristicRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.observ.ObservedValue object: entities)
		{
			//create xref/mref rule filtering ObservableFeature on the label Identifier
			if(object.getFeature_Id() == null && object.getFeature_Identifier() != null)
			{
				Object label = object.getFeature_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !featureRules.containsKey(label))
					{
						featureRules.put(""+label, xrefFilter);
						featureRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering Characteristic on the label Identifier
			if(object.getCharacteristic_Id() == null && object.getCharacteristic_Identifier() != null)
			{
				Object label = object.getCharacteristic_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !characteristicRules.containsKey(label))
					{
						characteristicRules.put(""+label, xrefFilter);
						characteristicRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
		}

		//resolve foreign key field 'feature' to observableFeature.id using Identifier)
		final java.util.Map<String,Integer> feature_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(featureRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.observ.ObservableFeature> featureList = null;
			try
			{
				featureList = getDatabase().find(org.molgenis.observ.ObservableFeature.class, featureRules.values().toArray(new org.molgenis.framework.db.QueryRule[featureRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.observ.ObservableFeature xref :  featureList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				feature_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'characteristic' to characteristic.id using Identifier)
		final java.util.Map<String,Integer> characteristic_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(characteristicRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.observ.Characteristic> characteristicList = null;
			try
			{
				characteristicList = getDatabase().find(org.molgenis.observ.Characteristic.class, characteristicRules.values().toArray(new org.molgenis.framework.db.QueryRule[characteristicRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.observ.Characteristic xref :  characteristicList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				characteristic_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.observ.ObservedValue object = entities.get(i);		
			//update object using label fields Identifier
			if(object.getFeature_Id() == null )
			{
					String key = "";
					if(object.getFeature_Identifier() != null)
						key += 	object.getFeature_Identifier();
					
					if(!"".equals(key) && feature_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Feature_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setFeature_Id(feature_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields Identifier
			if(object.getCharacteristic_Id() == null )
			{
					String key = "";
					if(object.getCharacteristic_Identifier() != null)
						key += 	object.getCharacteristic_Identifier();
					
					if(!"".equals(key) && characteristic_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Characteristic_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setCharacteristic_Id(characteristic_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "observedValue.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("__Type".equalsIgnoreCase(fieldName) || "observedValue.__Type".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.EnumField();
			if("observationSet".equalsIgnoreCase(fieldName) || "observedValue.observationSet".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("feature".equalsIgnoreCase(fieldName) || "observedValue.feature".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("characteristic".equalsIgnoreCase(fieldName) || "observedValue.characteristic".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("value".equalsIgnoreCase(fieldName) || "observedValue.value".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, ObservedValue entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.observ.ObservedValue> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.observ.ObservedValue> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<ObservedValue> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<ObservedValue> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<ObservedValue> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
