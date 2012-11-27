/* File:        org.molgenis/model/FrequencyCluster.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 26, 2012
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
import org.molgenis.gwascentral.FrequencyCluster;

import org.molgenis.observ.DataSet;
import org.molgenis.observ.db.DataSetMapper;
import org.molgenis.observ.Protocol;
import org.molgenis.observ.DataSet;
import org.molgenis.gwascentral.UsedMarkerSet;

public class FrequencyClusterMapper extends AbstractJDBCMapper<FrequencyCluster>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends FrequencyCluster> entities) throws DatabaseException
	{	
		//add superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.DataSet.class).executeAdd(entities);
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO FrequencyCluster (DataSet,UsedMarkerSet,MarkerID,NumberOfGenotypedSamples,PValueHWE,UnadjustedPValue,OddsRatioStatement,AttributableRiskStatement,id) VALUES ");
		{
		
			boolean first = true;
			for(FrequencyCluster e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//dataSet
				if(e.getDataSet_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getDataSet_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//usedMarkerSet
				if(e.getUsedMarkerSet_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getUsedMarkerSet_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//markerID
				if(e.getMarkerID() != null){
								
					sql.append("'"+this.escapeSql(e.getMarkerID().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//numberOfGenotypedSamples
				if(e.getNumberOfGenotypedSamples() != null){
								
					sql.append("'"+this.escapeSql(e.getNumberOfGenotypedSamples().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//pValueHWE
				if(e.getPValueHWE() != null){
								
					sql.append("'"+this.escapeSql(e.getPValueHWE().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//unadjustedPValue
				if(e.getUnadjustedPValue() != null){
								
					sql.append("'"+this.escapeSql(e.getUnadjustedPValue().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//oddsRatioStatement
				if(e.getOddsRatioStatement() != null){
								
					sql.append("'"+this.escapeSql(e.getOddsRatioStatement().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//attributableRiskStatement
				if(e.getAttributableRiskStatement() != null){
								
					sql.append("'"+this.escapeSql(e.getAttributableRiskStatement().toString())+"'"
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
	public int executeUpdate(List<? extends FrequencyCluster> entities) throws DatabaseException
	{
		//update superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.DataSet.class).executeUpdate(entities);
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO FrequencyCluster (DataSet,UsedMarkerSet,MarkerID,NumberOfGenotypedSamples,PValueHWE,UnadjustedPValue,OddsRatioStatement,AttributableRiskStatement,id) VALUES ");		
		boolean first = true;
		for(FrequencyCluster e: entities)
		{
			// put the ,
			if(first)
				first = false;
			else
				sql.append(",");

			sql.append("(");
			
			//dataSet


			if(e.getDataSet_Id() != null){
                sql.append("'"+this.escapeSql(e.getDataSet_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//usedMarkerSet


			if(e.getUsedMarkerSet_Id() != null){
                sql.append("'"+this.escapeSql(e.getUsedMarkerSet_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//markerID


			if(e.getMarkerID() != null){
                sql.append("'"+this.escapeSql(e.getMarkerID()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//numberOfGenotypedSamples


			if(e.getNumberOfGenotypedSamples() != null){
                sql.append("'"+this.escapeSql(e.getNumberOfGenotypedSamples()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//pValueHWE


			if(e.getPValueHWE() != null){
                sql.append("'"+this.escapeSql(e.getPValueHWE()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//unadjustedPValue


			if(e.getUnadjustedPValue() != null){
                sql.append("'"+this.escapeSql(e.getUnadjustedPValue()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//oddsRatioStatement


			if(e.getOddsRatioStatement() != null){
                sql.append("'"+this.escapeSql(e.getOddsRatioStatement()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//attributableRiskStatement


			if(e.getAttributableRiskStatement() != null){
                sql.append("'"+this.escapeSql(e.getAttributableRiskStatement()).toString()+"'" +",");
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
		sql.append(" ON DUPLICATE KEY UPDATE DataSet=VALUES(DataSet),UsedMarkerSet=VALUES(UsedMarkerSet),MarkerID=VALUES(MarkerID),NumberOfGenotypedSamples=VALUES(NumberOfGenotypedSamples),PValueHWE=VALUES(PValueHWE),UnadjustedPValue=VALUES(UnadjustedPValue),OddsRatioStatement=VALUES(OddsRatioStatement),AttributableRiskStatement=VALUES(AttributableRiskStatement),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends FrequencyCluster> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM FrequencyCluster WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(FrequencyCluster e: entities)
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
		this.getDatabase().getMapperFor(org.molgenis.observ.DataSet.class).executeRemove(entities);
		return rowsAffected;
	}
	
//Generated by MapperCommons.subclass_per_table.java.ftl
	
	public FrequencyClusterMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT FrequencyCluster.id"
			+", Characteristic.Identifier"
			+", Characteristic.Name"
			+", Characteristic.__Type"
			+", Characteristic.description"
			+", DataSet.ProtocolUsed"
			+", DataSet.startTime"
			+", DataSet.endTime"
			+", FrequencyCluster.DataSet"
			+", FrequencyCluster.UsedMarkerSet"
			+", FrequencyCluster.MarkerID"
			+", FrequencyCluster.NumberOfGenotypedSamples"
			+", FrequencyCluster.PValueHWE"
			+", FrequencyCluster.UnadjustedPValue"
			+", FrequencyCluster.OddsRatioStatement"
			+", FrequencyCluster.AttributableRiskStatement"
			//parent is SimpleTree(name='ProtocolUsed')
			+", xref_ProtocolUsed.Identifier AS ProtocolUsed_Identifier"
			//parent is SimpleTree(name='DataSet')
			+", xref_DataSet.Identifier AS DataSet_Identifier"
			//parent is SimpleTree(name='UsedMarkerSet')
			+", xref_UsedMarkerSet.Identifier AS UsedMarkerSet_Identifier"
			+" FROM FrequencyCluster "
			+" INNER JOIN DataSet ON (FrequencyCluster.id = DataSet.id)"
			+" INNER JOIN Characteristic ON (FrequencyCluster.id = Characteristic.id)"

			
			//label for ProtocolUsed=Identifier
//path==ProtocolUsed. type==xref.
//path==ProtocolUsed_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Characteristic AS xref_ProtocolUsed " 
			+" ON xref_ProtocolUsed.id = DataSet.ProtocolUsed"
			
			//label for DataSet=Identifier
//path==DataSet. type==xref.
//path==DataSet_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Characteristic AS xref_DataSet " 
			+" ON xref_DataSet.id = FrequencyCluster.DataSet"
			
			//label for UsedMarkerSet=Identifier
//path==UsedMarkerSet. type==xref.
//path==UsedMarkerSet_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Characteristic AS xref_UsedMarkerSet " 
			+" ON xref_UsedMarkerSet.id = FrequencyCluster.UsedMarkerSet"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM FrequencyCluster "
			  +" INNER JOIN DataSet ON (FrequencyCluster.id = DataSet.id)"
			  +" INNER JOIN Characteristic ON (FrequencyCluster.id = Characteristic.id)"
			
			//label for ProtocolUsed=Identifier
//ProtocolUsed
//ProtocolUsed_Identifier
		   	+" LEFT JOIN Characteristic AS xref_ProtocolUsed " 
			+" ON xref_ProtocolUsed.id = DataSet.ProtocolUsed"
			
			//label for DataSet=Identifier
//DataSet
//DataSet_Identifier
		   	+" LEFT JOIN Characteristic AS xref_DataSet " 
			+" ON xref_DataSet.id = FrequencyCluster.DataSet"
			
			//label for UsedMarkerSet=Identifier
//UsedMarkerSet
//UsedMarkerSet_Identifier
		   	+" LEFT JOIN Characteristic AS xref_UsedMarkerSet " 
			+" ON xref_UsedMarkerSet.id = FrequencyCluster.UsedMarkerSet"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "FrequencyCluster.id";
		if("FrequencyCluster_id".equalsIgnoreCase(fieldName)) return "FrequencyCluster.id";
		if("Identifier".equalsIgnoreCase(fieldName)) return "Characteristic.Identifier";
		if("FrequencyCluster_Identifier".equalsIgnoreCase(fieldName)) return "Characteristic.Identifier";
		if("Name".equalsIgnoreCase(fieldName)) return "Characteristic.Name";
		if("FrequencyCluster_Name".equalsIgnoreCase(fieldName)) return "Characteristic.Name";
		if("__Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("FrequencyCluster___Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("description".equalsIgnoreCase(fieldName)) return "Characteristic.description";
		if("FrequencyCluster_description".equalsIgnoreCase(fieldName)) return "Characteristic.description";
		if("ProtocolUsed".equalsIgnoreCase(fieldName)) return "DataSet.ProtocolUsed";
		if("FrequencyCluster_ProtocolUsed".equalsIgnoreCase(fieldName)) return "DataSet.ProtocolUsed";
		if("startTime".equalsIgnoreCase(fieldName)) return "DataSet.startTime";
		if("FrequencyCluster_startTime".equalsIgnoreCase(fieldName)) return "DataSet.startTime";
		if("endTime".equalsIgnoreCase(fieldName)) return "DataSet.endTime";
		if("FrequencyCluster_endTime".equalsIgnoreCase(fieldName)) return "DataSet.endTime";
		if("DataSet".equalsIgnoreCase(fieldName)) return "FrequencyCluster.DataSet";
		if("FrequencyCluster_DataSet".equalsIgnoreCase(fieldName)) return "FrequencyCluster.DataSet";
		if("UsedMarkerSet".equalsIgnoreCase(fieldName)) return "FrequencyCluster.UsedMarkerSet";
		if("FrequencyCluster_UsedMarkerSet".equalsIgnoreCase(fieldName)) return "FrequencyCluster.UsedMarkerSet";
		if("MarkerID".equalsIgnoreCase(fieldName)) return "FrequencyCluster.MarkerID";
		if("FrequencyCluster_MarkerID".equalsIgnoreCase(fieldName)) return "FrequencyCluster.MarkerID";
		if("NumberOfGenotypedSamples".equalsIgnoreCase(fieldName)) return "FrequencyCluster.NumberOfGenotypedSamples";
		if("FrequencyCluster_NumberOfGenotypedSamples".equalsIgnoreCase(fieldName)) return "FrequencyCluster.NumberOfGenotypedSamples";
		if("PValueHWE".equalsIgnoreCase(fieldName)) return "FrequencyCluster.PValueHWE";
		if("FrequencyCluster_PValueHWE".equalsIgnoreCase(fieldName)) return "FrequencyCluster.PValueHWE";
		if("UnadjustedPValue".equalsIgnoreCase(fieldName)) return "FrequencyCluster.UnadjustedPValue";
		if("FrequencyCluster_UnadjustedPValue".equalsIgnoreCase(fieldName)) return "FrequencyCluster.UnadjustedPValue";
		if("OddsRatioStatement".equalsIgnoreCase(fieldName)) return "FrequencyCluster.OddsRatioStatement";
		if("FrequencyCluster_OddsRatioStatement".equalsIgnoreCase(fieldName)) return "FrequencyCluster.OddsRatioStatement";
		if("AttributableRiskStatement".equalsIgnoreCase(fieldName)) return "FrequencyCluster.AttributableRiskStatement";
		if("FrequencyCluster_AttributableRiskStatement".equalsIgnoreCase(fieldName)) return "FrequencyCluster.AttributableRiskStatement";
		if("ProtocolUsed_id".equalsIgnoreCase(fieldName)) return "DataSet.ProtocolUsed";
		if("FrequencyCluster_ProtocolUsed_id".equalsIgnoreCase(fieldName)) return "DataSet.ProtocolUsed";
		if("ProtocolUsed_Identifier".equalsIgnoreCase(fieldName)) return "xref_ProtocolUsed.Identifier";	
		if("FrequencyCluster_ProtocolUsed_Identifier".equalsIgnoreCase(fieldName)) return "xref_ProtocolUsed.Identifier";
		if("DataSet_id".equalsIgnoreCase(fieldName)) return "FrequencyCluster.DataSet";
		if("FrequencyCluster_DataSet_id".equalsIgnoreCase(fieldName)) return "FrequencyCluster.DataSet";
		if("DataSet_Identifier".equalsIgnoreCase(fieldName)) return "xref_DataSet.Identifier";	
		if("FrequencyCluster_DataSet_Identifier".equalsIgnoreCase(fieldName)) return "xref_DataSet.Identifier";
		if("UsedMarkerSet_id".equalsIgnoreCase(fieldName)) return "FrequencyCluster.UsedMarkerSet";
		if("FrequencyCluster_UsedMarkerSet_id".equalsIgnoreCase(fieldName)) return "FrequencyCluster.UsedMarkerSet";
		if("UsedMarkerSet_Identifier".equalsIgnoreCase(fieldName)) return "xref_UsedMarkerSet.Identifier";	
		if("FrequencyCluster_UsedMarkerSet_Identifier".equalsIgnoreCase(fieldName)) return "xref_UsedMarkerSet.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.gwascentral.FrequencyCluster> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.gwascentral.FrequencyCluster>(size); 
	}			

	public org.molgenis.gwascentral.FrequencyCluster create()
	{
		return new org.molgenis.gwascentral.FrequencyCluster();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.gwascentral.FrequencyCluster> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'protocolUsed' to protocol.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> protocolUsedRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'dataSet' to dataSet.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> dataSetRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'usedMarkerSet' to usedMarkerSet.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> usedMarkerSetRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.gwascentral.FrequencyCluster object: entities)
		{
			//create xref/mref rule filtering Protocol on the label Identifier
			if(object.getProtocolUsed_Id() == null && object.getProtocolUsed_Identifier() != null)
			{
				Object label = object.getProtocolUsed_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !protocolUsedRules.containsKey(label))
					{
						protocolUsedRules.put(""+label, xrefFilter);
						protocolUsedRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering DataSet on the label Identifier
			if(object.getDataSet_Id() == null && object.getDataSet_Identifier() != null)
			{
				Object label = object.getDataSet_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !dataSetRules.containsKey(label))
					{
						dataSetRules.put(""+label, xrefFilter);
						dataSetRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering UsedMarkerSet on the label Identifier
			if(object.getUsedMarkerSet_Id() == null && object.getUsedMarkerSet_Identifier() != null)
			{
				Object label = object.getUsedMarkerSet_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !usedMarkerSetRules.containsKey(label))
					{
						usedMarkerSetRules.put(""+label, xrefFilter);
						usedMarkerSetRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
		}

		//resolve foreign key field 'protocolUsed' to protocol.id using Identifier)
		final java.util.Map<String,Integer> protocolUsed_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(protocolUsedRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.observ.Protocol> protocolUsedList = null;
			try
			{
				protocolUsedList = getDatabase().find(org.molgenis.observ.Protocol.class, protocolUsedRules.values().toArray(new org.molgenis.framework.db.QueryRule[protocolUsedRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.observ.Protocol xref :  protocolUsedList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				protocolUsed_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'dataSet' to dataSet.id using Identifier)
		final java.util.Map<String,Integer> dataSet_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(dataSetRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.observ.DataSet> dataSetList = null;
			try
			{
				dataSetList = getDatabase().find(org.molgenis.observ.DataSet.class, dataSetRules.values().toArray(new org.molgenis.framework.db.QueryRule[dataSetRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.observ.DataSet xref :  dataSetList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				dataSet_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'usedMarkerSet' to usedMarkerSet.id using Identifier)
		final java.util.Map<String,Integer> usedMarkerSet_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(usedMarkerSetRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.gwascentral.UsedMarkerSet> usedMarkerSetList = null;
			try
			{
				usedMarkerSetList = getDatabase().find(org.molgenis.gwascentral.UsedMarkerSet.class, usedMarkerSetRules.values().toArray(new org.molgenis.framework.db.QueryRule[usedMarkerSetRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.gwascentral.UsedMarkerSet xref :  usedMarkerSetList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				usedMarkerSet_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.gwascentral.FrequencyCluster object = entities.get(i);		
			//update object using label fields Identifier
			if(object.getProtocolUsed_Id() == null )
			{
					String key = "";
					if(object.getProtocolUsed_Identifier() != null)
						key += 	object.getProtocolUsed_Identifier();
					
					if(!"".equals(key) && protocolUsed_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("ProtocolUsed_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setProtocolUsed_Id(protocolUsed_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields Identifier
			if(object.getDataSet_Id() == null )
			{
					String key = "";
					if(object.getDataSet_Identifier() != null)
						key += 	object.getDataSet_Identifier();
					
					if(!"".equals(key) && dataSet_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("DataSet_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setDataSet_Id(dataSet_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields Identifier
			if(object.getUsedMarkerSet_Id() == null )
			{
					String key = "";
					if(object.getUsedMarkerSet_Identifier() != null)
						key += 	object.getUsedMarkerSet_Identifier();
					
					if(!"".equals(key) && usedMarkerSet_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("UsedMarkerSet_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setUsedMarkerSet_Id(usedMarkerSet_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "frequencyCluster.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("identifier".equalsIgnoreCase(fieldName) || "characteristic.identifier".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("name".equalsIgnoreCase(fieldName) || "characteristic.name".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("__Type".equalsIgnoreCase(fieldName) || "characteristic.__Type".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.EnumField();
			if("description".equalsIgnoreCase(fieldName) || "characteristic.description".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("protocolUsed".equalsIgnoreCase(fieldName) || "dataSet.protocolUsed".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("startTime".equalsIgnoreCase(fieldName) || "dataSet.startTime".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.DatetimeField();
			if("endTime".equalsIgnoreCase(fieldName) || "dataSet.endTime".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.DatetimeField();
			if("dataSet".equalsIgnoreCase(fieldName) || "frequencyCluster.dataSet".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("usedMarkerSet".equalsIgnoreCase(fieldName) || "frequencyCluster.usedMarkerSet".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("markerID".equalsIgnoreCase(fieldName) || "frequencyCluster.markerID".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("numberOfGenotypedSamples".equalsIgnoreCase(fieldName) || "frequencyCluster.numberOfGenotypedSamples".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("pValueHWE".equalsIgnoreCase(fieldName) || "frequencyCluster.pValueHWE".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.DecimalField();
			if("unadjustedPValue".equalsIgnoreCase(fieldName) || "frequencyCluster.unadjustedPValue".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.DecimalField();
			if("oddsRatioStatement".equalsIgnoreCase(fieldName) || "frequencyCluster.oddsRatioStatement".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("attributableRiskStatement".equalsIgnoreCase(fieldName) || "frequencyCluster.attributableRiskStatement".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, FrequencyCluster entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.gwascentral.FrequencyCluster> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.gwascentral.FrequencyCluster> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<FrequencyCluster> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<FrequencyCluster> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<FrequencyCluster> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
