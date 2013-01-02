/* File:        org.molgenis.omx/model/Significance.java
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
import org.molgenis.gwascentral.Significance;

import org.molgenis.observ.DataSet;
import org.molgenis.observ.db.DataSetMapper;
import org.molgenis.observ.Protocol;
import org.molgenis.gwascentral.UsedMarkerSet;

public class SignificanceMapper extends AbstractJDBCMapper<Significance>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends Significance> entities) throws DatabaseException
	{	
		//add superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.DataSet.class).executeAdd(entities);
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO Significance (id,UsedmarkersetID,NegLogPValue,UnadjustedPValue,AdjustedPValue) VALUES ");
		{
		
			boolean first = true;
			for(Significance e: entities)
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
				//usedmarkersetID
				if(e.getUsedmarkersetID_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getUsedmarkersetID_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//negLogPValue
				if(e.getNegLogPValue() != null){
								
					sql.append("'"+this.escapeSql(e.getNegLogPValue().toString())+"'"
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
				//adjustedPValue
				if(e.getAdjustedPValue() != null){
								
					sql.append("'"+this.escapeSql(e.getAdjustedPValue().toString())+"'"
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
	public int executeUpdate(List<? extends Significance> entities) throws DatabaseException
	{
		//update superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.DataSet.class).executeUpdate(entities);
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO Significance (id,UsedmarkersetID,NegLogPValue,UnadjustedPValue,AdjustedPValue) VALUES ");		
		boolean first = true;
		for(Significance e: entities)
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
		
			//usedmarkersetID


			if(e.getUsedmarkersetID_Id() != null){
                sql.append("'"+this.escapeSql(e.getUsedmarkersetID_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//negLogPValue


			if(e.getNegLogPValue() != null){
                sql.append("'"+this.escapeSql(e.getNegLogPValue()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//unadjustedPValue


			if(e.getUnadjustedPValue() != null){
                sql.append("'"+this.escapeSql(e.getUnadjustedPValue()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//adjustedPValue


			if(e.getAdjustedPValue() != null){
                sql.append("'"+this.escapeSql(e.getAdjustedPValue()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE UsedmarkersetID=VALUES(UsedmarkersetID),NegLogPValue=VALUES(NegLogPValue),UnadjustedPValue=VALUES(UnadjustedPValue),AdjustedPValue=VALUES(AdjustedPValue),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends Significance> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM Significance WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(Significance e: entities)
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
	
	public SignificanceMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT Significance.id"
			+", Characteristic.Identifier"
			+", Characteristic.Name"
			+", Characteristic.__Type"
			+", Characteristic.description"
			+", DataSet.ProtocolUsed"
			+", DataSet.startTime"
			+", DataSet.endTime"
			+", Significance.UsedmarkersetID"
			+", Significance.NegLogPValue"
			+", Significance.UnadjustedPValue"
			+", Significance.AdjustedPValue"
			//parent is SimpleTree(name='ProtocolUsed')
			+", xref_ProtocolUsed.Identifier AS ProtocolUsed_Identifier"
			//parent is SimpleTree(name='UsedmarkersetID')
			+", xref_UsedmarkersetID.Identifier AS UsedmarkersetID_Identifier"
			+" FROM Significance "
			+" INNER JOIN DataSet ON (Significance.id = DataSet.id)"
			+" INNER JOIN Characteristic ON (Significance.id = Characteristic.id)"

			
			//label for ProtocolUsed=Identifier
//path==ProtocolUsed. type==xref.
//path==ProtocolUsed_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Characteristic AS xref_ProtocolUsed " 
			+" ON xref_ProtocolUsed.id = DataSet.ProtocolUsed"
			
			//label for UsedmarkersetID=Identifier
//path==UsedmarkersetID. type==xref.
//path==UsedmarkersetID_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Characteristic AS xref_UsedmarkersetID " 
			+" ON xref_UsedmarkersetID.id = Significance.UsedmarkersetID"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM Significance "
			  +" INNER JOIN DataSet ON (Significance.id = DataSet.id)"
			  +" INNER JOIN Characteristic ON (Significance.id = Characteristic.id)"
			
			//label for ProtocolUsed=Identifier
//ProtocolUsed
//ProtocolUsed_Identifier
		   	+" LEFT JOIN Characteristic AS xref_ProtocolUsed " 
			+" ON xref_ProtocolUsed.id = DataSet.ProtocolUsed"
			
			//label for UsedmarkersetID=Identifier
//UsedmarkersetID
//UsedmarkersetID_Identifier
		   	+" LEFT JOIN Characteristic AS xref_UsedmarkersetID " 
			+" ON xref_UsedmarkersetID.id = Significance.UsedmarkersetID"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "Significance.id";
		if("Significance_id".equalsIgnoreCase(fieldName)) return "Significance.id";
		if("Identifier".equalsIgnoreCase(fieldName)) return "Characteristic.Identifier";
		if("Significance_Identifier".equalsIgnoreCase(fieldName)) return "Characteristic.Identifier";
		if("Name".equalsIgnoreCase(fieldName)) return "Characteristic.Name";
		if("Significance_Name".equalsIgnoreCase(fieldName)) return "Characteristic.Name";
		if("__Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("Significance___Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("description".equalsIgnoreCase(fieldName)) return "Characteristic.description";
		if("Significance_description".equalsIgnoreCase(fieldName)) return "Characteristic.description";
		if("ProtocolUsed".equalsIgnoreCase(fieldName)) return "DataSet.ProtocolUsed";
		if("Significance_ProtocolUsed".equalsIgnoreCase(fieldName)) return "DataSet.ProtocolUsed";
		if("startTime".equalsIgnoreCase(fieldName)) return "DataSet.startTime";
		if("Significance_startTime".equalsIgnoreCase(fieldName)) return "DataSet.startTime";
		if("endTime".equalsIgnoreCase(fieldName)) return "DataSet.endTime";
		if("Significance_endTime".equalsIgnoreCase(fieldName)) return "DataSet.endTime";
		if("UsedmarkersetID".equalsIgnoreCase(fieldName)) return "Significance.UsedmarkersetID";
		if("Significance_UsedmarkersetID".equalsIgnoreCase(fieldName)) return "Significance.UsedmarkersetID";
		if("NegLogPValue".equalsIgnoreCase(fieldName)) return "Significance.NegLogPValue";
		if("Significance_NegLogPValue".equalsIgnoreCase(fieldName)) return "Significance.NegLogPValue";
		if("UnadjustedPValue".equalsIgnoreCase(fieldName)) return "Significance.UnadjustedPValue";
		if("Significance_UnadjustedPValue".equalsIgnoreCase(fieldName)) return "Significance.UnadjustedPValue";
		if("AdjustedPValue".equalsIgnoreCase(fieldName)) return "Significance.AdjustedPValue";
		if("Significance_AdjustedPValue".equalsIgnoreCase(fieldName)) return "Significance.AdjustedPValue";
		if("ProtocolUsed_id".equalsIgnoreCase(fieldName)) return "DataSet.ProtocolUsed";
		if("Significance_ProtocolUsed_id".equalsIgnoreCase(fieldName)) return "DataSet.ProtocolUsed";
		if("ProtocolUsed_Identifier".equalsIgnoreCase(fieldName)) return "xref_ProtocolUsed.Identifier";	
		if("Significance_ProtocolUsed_Identifier".equalsIgnoreCase(fieldName)) return "xref_ProtocolUsed.Identifier";
		if("UsedmarkersetID_id".equalsIgnoreCase(fieldName)) return "Significance.UsedmarkersetID";
		if("Significance_UsedmarkersetID_id".equalsIgnoreCase(fieldName)) return "Significance.UsedmarkersetID";
		if("UsedmarkersetID_Identifier".equalsIgnoreCase(fieldName)) return "xref_UsedmarkersetID.Identifier";	
		if("Significance_UsedmarkersetID_Identifier".equalsIgnoreCase(fieldName)) return "xref_UsedmarkersetID.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.gwascentral.Significance> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.gwascentral.Significance>(size); 
	}			

	public org.molgenis.gwascentral.Significance create()
	{
		return new org.molgenis.gwascentral.Significance();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.gwascentral.Significance> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'protocolUsed' to protocol.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> protocolUsedRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'usedmarkersetID' to usedMarkerSet.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> usedmarkersetIDRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.gwascentral.Significance object: entities)
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
			//create xref/mref rule filtering UsedMarkerSet on the label Identifier
			if(object.getUsedmarkersetID_Id() == null && object.getUsedmarkersetID_Identifier() != null)
			{
				Object label = object.getUsedmarkersetID_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !usedmarkersetIDRules.containsKey(label))
					{
						usedmarkersetIDRules.put(""+label, xrefFilter);
						usedmarkersetIDRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
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
		//resolve foreign key field 'usedmarkersetID' to usedMarkerSet.id using Identifier)
		final java.util.Map<String,Integer> usedmarkersetID_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(usedmarkersetIDRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.gwascentral.UsedMarkerSet> usedmarkersetIDList = null;
			try
			{
				usedmarkersetIDList = getDatabase().find(org.molgenis.gwascentral.UsedMarkerSet.class, usedmarkersetIDRules.values().toArray(new org.molgenis.framework.db.QueryRule[usedmarkersetIDRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.gwascentral.UsedMarkerSet xref :  usedmarkersetIDList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				usedmarkersetID_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.gwascentral.Significance object = entities.get(i);		
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
			if(object.getUsedmarkersetID_Id() == null )
			{
					String key = "";
					if(object.getUsedmarkersetID_Identifier() != null)
						key += 	object.getUsedmarkersetID_Identifier();
					
					if(!"".equals(key) && usedmarkersetID_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("UsedmarkersetID_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setUsedmarkersetID_Id(usedmarkersetID_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "significance.id".equalsIgnoreCase(fieldName)) 
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
			if("usedmarkersetID".equalsIgnoreCase(fieldName) || "significance.usedmarkersetID".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("negLogPValue".equalsIgnoreCase(fieldName) || "significance.negLogPValue".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.DecimalField();
			if("unadjustedPValue".equalsIgnoreCase(fieldName) || "significance.unadjustedPValue".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("adjustedPValue".equalsIgnoreCase(fieldName) || "significance.adjustedPValue".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.DecimalField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, Significance entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.gwascentral.Significance> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.gwascentral.Significance> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<Significance> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<Significance> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<Significance> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
