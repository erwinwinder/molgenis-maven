/* File:        org.molgenis.omx/model/PhenotypeValue.java
 * Copyright:   GBIC 2000-2013, all rights reserved
 * Date:        January 2, 2013
 * Template:	MultiqueryMapperGen.java.ftl
 * generator:   org.molgenis.generators.db.MultiqueryMapperGen 4.0.0-testing
 *
 * Using "subclass per table" strategy
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.gwascentral.db;

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
import org.molgenis.gwascentral.PhenotypeValue;

import org.molgenis.observ.ObservedValue;
import org.molgenis.observ.db.ObservedValueMapper;
import org.molgenis.observ.ObservationSet;
import org.molgenis.observ.ObservableFeature;
import org.molgenis.observ.Characteristic;
import org.molgenis.gwascentral.PhenotypeProperty;

public class PhenotypeValueMapper extends AbstractJDBCMapper<PhenotypeValue>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends PhenotypeValue> entities) throws DatabaseException
	{	
		//add superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.ObservedValue.class).executeAdd(entities);
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO PhenotypeValue (id,Identifier,Name,PhenotypePropertyID,Value,ValueRank,ValueIsMean,STD,Min,Max) VALUES ");
		{
		
			boolean first = true;
			for(PhenotypeValue e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//id
				if(e.getId() != null){
								
					sql.append("'"+this.escapeSql(e.getId().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//identifier
				if(e.getIdentifier() != null){
								
					sql.append("'"+this.escapeSql(e.getIdentifier().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//name
				if(e.getName() != null){
								
					sql.append("'"+this.escapeSql(e.getName().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//phenotypePropertyID
				if(e.getPhenotypePropertyID_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getPhenotypePropertyID_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//value
				if(e.getValue() != null){
								
					sql.append("'"+this.escapeSql(e.getValue().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//valueRank
				if(e.getValueRank() != null){
								
					sql.append("'"+this.escapeSql(e.getValueRank().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//valueIsMean
				if(e.getValueIsMean() != null){
								
					sql.append("'"+this.escapeSql(e.getValueIsMean().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//sTD
				if(e.getSTD() != null){
								
					sql.append("'"+this.escapeSql(e.getSTD().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//min
				if(e.getMin() != null){
								
					sql.append("'"+this.escapeSql(e.getMin().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//max
				if(e.getMax() != null){
								
					sql.append("'"+this.escapeSql(e.getMax().toString())+"'"
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
	public int executeUpdate(List<? extends PhenotypeValue> entities) throws DatabaseException
	{
		//update superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.ObservedValue.class).executeUpdate(entities);
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO PhenotypeValue (id,Identifier,Name,PhenotypePropertyID,Value,ValueRank,ValueIsMean,STD,Min,Max) VALUES ");		
		boolean first = true;
		for(PhenotypeValue e: entities)
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
		
			//identifier


			if(e.getIdentifier() != null){
                sql.append("'"+this.escapeSql(e.getIdentifier()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//name


			if(e.getName() != null){
                sql.append("'"+this.escapeSql(e.getName()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//phenotypePropertyID


			if(e.getPhenotypePropertyID_Id() != null){
                sql.append("'"+this.escapeSql(e.getPhenotypePropertyID_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//value


			if(e.getValue() != null){
                sql.append("'"+this.escapeSql(e.getValue()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//valueRank


			if(e.getValueRank() != null){
                sql.append("'"+this.escapeSql(e.getValueRank()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//valueIsMean


			if(e.getValueIsMean() != null){
                sql.append("'"+this.escapeSql(e.getValueIsMean()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//sTD


			if(e.getSTD() != null){
                sql.append("'"+this.escapeSql(e.getSTD()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//min


			if(e.getMin() != null){
                sql.append("'"+this.escapeSql(e.getMin()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//max


			if(e.getMax() != null){
                sql.append("'"+this.escapeSql(e.getMax()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE PhenotypePropertyID=VALUES(PhenotypePropertyID),Name=VALUES(Name),Value=VALUES(Value),ValueRank=VALUES(ValueRank),ValueIsMean=VALUES(ValueIsMean),STD=VALUES(STD),Min=VALUES(Min),Max=VALUES(Max),Identifier=VALUES(Identifier),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends PhenotypeValue> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM PhenotypeValue WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(PhenotypeValue e: entities)
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
		this.getDatabase().getMapperFor(org.molgenis.observ.ObservedValue.class).executeRemove(entities);
		return rowsAffected;
	}
	
//Generated by MapperCommons.subclass_per_table.java.ftl
	
	public PhenotypeValueMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT PhenotypeValue.id"
			+", ObservedValue.__Type"
			+", ObservedValue.ObservationSet"
			+", ObservedValue.Feature"
			+", ObservedValue.Characteristic"
			+", PhenotypeValue.Value"
			+", PhenotypeValue.Identifier"
			+", PhenotypeValue.Name"
			+", PhenotypeValue.PhenotypePropertyID"
			+", PhenotypeValue.ValueRank"
			+", PhenotypeValue.ValueIsMean"
			+", PhenotypeValue.STD"
			+", PhenotypeValue.Min"
			+", PhenotypeValue.Max"
			//parent is SimpleTree(name='ObservationSet')
			+", xref_ObservationSet.id AS ObservationSet_Id"
			//parent is SimpleTree(name='Feature')
			+", xref_Feature.Identifier AS Feature_Identifier"
			//parent is SimpleTree(name='Characteristic')
			+", xref_Characteristic.Identifier AS Characteristic_Identifier"
			//parent is SimpleTree(name='PhenotypePropertyID')
			+", xref_PhenotypePropertyID.Identifier AS PhenotypePropertyID_Identifier"
			+" FROM PhenotypeValue "
			+" INNER JOIN ObservedValue ON (PhenotypeValue.id = ObservedValue.id)"

			
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
			
			//label for PhenotypePropertyID=Identifier
//path==PhenotypePropertyID. type==xref.
//path==PhenotypePropertyID_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN PhenotypeProperty AS xref_PhenotypePropertyID " 
			+" ON xref_PhenotypePropertyID.id = PhenotypeValue.PhenotypePropertyID"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM PhenotypeValue "
			  +" INNER JOIN ObservedValue ON (PhenotypeValue.id = ObservedValue.id)"
			
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
			
			//label for PhenotypePropertyID=Identifier
//PhenotypePropertyID
//PhenotypePropertyID_Identifier
		   	+" LEFT JOIN PhenotypeProperty AS xref_PhenotypePropertyID " 
			+" ON xref_PhenotypePropertyID.id = PhenotypeValue.PhenotypePropertyID"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "PhenotypeValue.id";
		if("PhenotypeValue_id".equalsIgnoreCase(fieldName)) return "PhenotypeValue.id";
		if("__Type".equalsIgnoreCase(fieldName)) return "ObservedValue.__Type";
		if("PhenotypeValue___Type".equalsIgnoreCase(fieldName)) return "ObservedValue.__Type";
		if("ObservationSet".equalsIgnoreCase(fieldName)) return "ObservedValue.ObservationSet";
		if("PhenotypeValue_ObservationSet".equalsIgnoreCase(fieldName)) return "ObservedValue.ObservationSet";
		if("Feature".equalsIgnoreCase(fieldName)) return "ObservedValue.Feature";
		if("PhenotypeValue_Feature".equalsIgnoreCase(fieldName)) return "ObservedValue.Feature";
		if("Characteristic".equalsIgnoreCase(fieldName)) return "ObservedValue.Characteristic";
		if("PhenotypeValue_Characteristic".equalsIgnoreCase(fieldName)) return "ObservedValue.Characteristic";
		if("Value".equalsIgnoreCase(fieldName)) return "PhenotypeValue.Value";
		if("PhenotypeValue_Value".equalsIgnoreCase(fieldName)) return "PhenotypeValue.Value";
		if("Identifier".equalsIgnoreCase(fieldName)) return "PhenotypeValue.Identifier";
		if("PhenotypeValue_Identifier".equalsIgnoreCase(fieldName)) return "PhenotypeValue.Identifier";
		if("Name".equalsIgnoreCase(fieldName)) return "PhenotypeValue.Name";
		if("PhenotypeValue_Name".equalsIgnoreCase(fieldName)) return "PhenotypeValue.Name";
		if("PhenotypePropertyID".equalsIgnoreCase(fieldName)) return "PhenotypeValue.PhenotypePropertyID";
		if("PhenotypeValue_PhenotypePropertyID".equalsIgnoreCase(fieldName)) return "PhenotypeValue.PhenotypePropertyID";
		if("ValueRank".equalsIgnoreCase(fieldName)) return "PhenotypeValue.ValueRank";
		if("PhenotypeValue_ValueRank".equalsIgnoreCase(fieldName)) return "PhenotypeValue.ValueRank";
		if("ValueIsMean".equalsIgnoreCase(fieldName)) return "PhenotypeValue.ValueIsMean";
		if("PhenotypeValue_ValueIsMean".equalsIgnoreCase(fieldName)) return "PhenotypeValue.ValueIsMean";
		if("STD".equalsIgnoreCase(fieldName)) return "PhenotypeValue.STD";
		if("PhenotypeValue_STD".equalsIgnoreCase(fieldName)) return "PhenotypeValue.STD";
		if("Min".equalsIgnoreCase(fieldName)) return "PhenotypeValue.Min";
		if("PhenotypeValue_Min".equalsIgnoreCase(fieldName)) return "PhenotypeValue.Min";
		if("Max".equalsIgnoreCase(fieldName)) return "PhenotypeValue.Max";
		if("PhenotypeValue_Max".equalsIgnoreCase(fieldName)) return "PhenotypeValue.Max";
		if("ObservationSet_id".equalsIgnoreCase(fieldName)) return "ObservedValue.ObservationSet";
		if("PhenotypeValue_ObservationSet_id".equalsIgnoreCase(fieldName)) return "ObservedValue.ObservationSet";
		if("ObservationSet_Id".equalsIgnoreCase(fieldName)) return "xref_ObservationSet.id";	
		if("PhenotypeValue_ObservationSet_Id".equalsIgnoreCase(fieldName)) return "xref_ObservationSet.id";
		if("Feature_id".equalsIgnoreCase(fieldName)) return "ObservedValue.Feature";
		if("PhenotypeValue_Feature_id".equalsIgnoreCase(fieldName)) return "ObservedValue.Feature";
		if("Feature_Identifier".equalsIgnoreCase(fieldName)) return "xref_Feature.Identifier";	
		if("PhenotypeValue_Feature_Identifier".equalsIgnoreCase(fieldName)) return "xref_Feature.Identifier";
		if("Characteristic_id".equalsIgnoreCase(fieldName)) return "ObservedValue.Characteristic";
		if("PhenotypeValue_Characteristic_id".equalsIgnoreCase(fieldName)) return "ObservedValue.Characteristic";
		if("Characteristic_Identifier".equalsIgnoreCase(fieldName)) return "xref_Characteristic.Identifier";	
		if("PhenotypeValue_Characteristic_Identifier".equalsIgnoreCase(fieldName)) return "xref_Characteristic.Identifier";
		if("PhenotypePropertyID_id".equalsIgnoreCase(fieldName)) return "PhenotypeValue.PhenotypePropertyID";
		if("PhenotypeValue_PhenotypePropertyID_id".equalsIgnoreCase(fieldName)) return "PhenotypeValue.PhenotypePropertyID";
		if("PhenotypePropertyID_Identifier".equalsIgnoreCase(fieldName)) return "xref_PhenotypePropertyID.Identifier";	
		if("PhenotypeValue_PhenotypePropertyID_Identifier".equalsIgnoreCase(fieldName)) return "xref_PhenotypePropertyID.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.gwascentral.PhenotypeValue> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.gwascentral.PhenotypeValue>(size); 
	}			

	public org.molgenis.gwascentral.PhenotypeValue create()
	{
		return new org.molgenis.gwascentral.PhenotypeValue();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.gwascentral.PhenotypeValue> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'feature' to observableFeature.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> featureRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'characteristic' to characteristic.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> characteristicRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'phenotypePropertyID' to phenotypeProperty.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> phenotypePropertyIDRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.gwascentral.PhenotypeValue object: entities)
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
			//create xref/mref rule filtering PhenotypeProperty on the label Identifier
			if(object.getPhenotypePropertyID_Id() == null && object.getPhenotypePropertyID_Identifier() != null)
			{
				Object label = object.getPhenotypePropertyID_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !phenotypePropertyIDRules.containsKey(label))
					{
						phenotypePropertyIDRules.put(""+label, xrefFilter);
						phenotypePropertyIDRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
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
		//resolve foreign key field 'phenotypePropertyID' to phenotypeProperty.id using Identifier)
		final java.util.Map<String,Integer> phenotypePropertyID_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(phenotypePropertyIDRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.gwascentral.PhenotypeProperty> phenotypePropertyIDList = null;
			try
			{
				phenotypePropertyIDList = getDatabase().find(org.molgenis.gwascentral.PhenotypeProperty.class, phenotypePropertyIDRules.values().toArray(new org.molgenis.framework.db.QueryRule[phenotypePropertyIDRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.gwascentral.PhenotypeProperty xref :  phenotypePropertyIDList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				phenotypePropertyID_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.gwascentral.PhenotypeValue object = entities.get(i);		
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
			//update object using label fields Identifier
			if(object.getPhenotypePropertyID_Id() == null )
			{
					String key = "";
					if(object.getPhenotypePropertyID_Identifier() != null)
						key += 	object.getPhenotypePropertyID_Identifier();
					
					if(!"".equals(key) && phenotypePropertyID_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("PhenotypePropertyID_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setPhenotypePropertyID_Id(phenotypePropertyID_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "phenotypeValue.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("__Type".equalsIgnoreCase(fieldName) || "observedValue.__Type".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.EnumField();
			if("observationSet".equalsIgnoreCase(fieldName) || "observedValue.observationSet".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("feature".equalsIgnoreCase(fieldName) || "observedValue.feature".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("characteristic".equalsIgnoreCase(fieldName) || "observedValue.characteristic".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("value".equalsIgnoreCase(fieldName) || "phenotypeValue.value".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("identifier".equalsIgnoreCase(fieldName) || "phenotypeValue.identifier".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("name".equalsIgnoreCase(fieldName) || "phenotypeValue.name".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("phenotypePropertyID".equalsIgnoreCase(fieldName) || "phenotypeValue.phenotypePropertyID".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("valueRank".equalsIgnoreCase(fieldName) || "phenotypeValue.valueRank".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("valueIsMean".equalsIgnoreCase(fieldName) || "phenotypeValue.valueIsMean".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("sTD".equalsIgnoreCase(fieldName) || "phenotypeValue.sTD".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("min".equalsIgnoreCase(fieldName) || "phenotypeValue.min".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("max".equalsIgnoreCase(fieldName) || "phenotypeValue.max".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, PhenotypeValue entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.gwascentral.PhenotypeValue> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.gwascentral.PhenotypeValue> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<PhenotypeValue> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<PhenotypeValue> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<PhenotypeValue> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
