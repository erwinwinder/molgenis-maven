/* File:        org.molgenis/model/EffectSize.java
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
import org.molgenis.gwascentral.EffectSize;

import org.molgenis.observ.DataSet;
import org.molgenis.observ.db.DataSetMapper;
import org.molgenis.observ.Protocol;
import org.molgenis.gwascentral.UsedMarkerSet;

public class EffectSizeMapper extends AbstractJDBCMapper<EffectSize>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends EffectSize> entities) throws DatabaseException
	{	
		//add superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.DataSet.class).executeAdd(entities);
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO EffectSize (UsedMarkerSetID,Lower95Bound,Upper95Bound,StdError,id) VALUES ");
		{
		
			boolean first = true;
			for(EffectSize e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//usedMarkerSetID
				if(e.getUsedMarkerSetID_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getUsedMarkerSetID_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//lower95Bound
				if(e.getLower95Bound() != null){
								
					sql.append("'"+this.escapeSql(e.getLower95Bound().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//upper95Bound
				if(e.getUpper95Bound() != null){
								
					sql.append("'"+this.escapeSql(e.getUpper95Bound().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//stdError
				if(e.getStdError() != null){
								
					sql.append("'"+this.escapeSql(e.getStdError().toString())+"'"
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
	public int executeUpdate(List<? extends EffectSize> entities) throws DatabaseException
	{
		//update superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.DataSet.class).executeUpdate(entities);
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO EffectSize (UsedMarkerSetID,Lower95Bound,Upper95Bound,StdError,id) VALUES ");		
		boolean first = true;
		for(EffectSize e: entities)
		{
			// put the ,
			if(first)
				first = false;
			else
				sql.append(",");

			sql.append("(");
			
			//usedMarkerSetID


			if(e.getUsedMarkerSetID_Id() != null){
                sql.append("'"+this.escapeSql(e.getUsedMarkerSetID_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//lower95Bound


			if(e.getLower95Bound() != null){
                sql.append("'"+this.escapeSql(e.getLower95Bound()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//upper95Bound


			if(e.getUpper95Bound() != null){
                sql.append("'"+this.escapeSql(e.getUpper95Bound()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//stdError


			if(e.getStdError() != null){
                sql.append("'"+this.escapeSql(e.getStdError()).toString()+"'" +",");
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
		sql.append(" ON DUPLICATE KEY UPDATE UsedMarkerSetID=VALUES(UsedMarkerSetID),Lower95Bound=VALUES(Lower95Bound),Upper95Bound=VALUES(Upper95Bound),StdError=VALUES(StdError),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends EffectSize> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM EffectSize WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(EffectSize e: entities)
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
	
	public EffectSizeMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT EffectSize.id"
			+", Characteristic.Identifier"
			+", Characteristic.Name"
			+", Characteristic.__Type"
			+", Characteristic.description"
			+", DataSet.ProtocolUsed"
			+", DataSet.startTime"
			+", DataSet.endTime"
			+", EffectSize.UsedMarkerSetID"
			+", EffectSize.Lower95Bound"
			+", EffectSize.Upper95Bound"
			+", EffectSize.StdError"
			//parent is SimpleTree(name='ProtocolUsed')
			+", xref_ProtocolUsed.Identifier AS ProtocolUsed_Identifier"
			//parent is SimpleTree(name='UsedMarkerSetID')
			+", xref_UsedMarkerSetID.Identifier AS UsedMarkerSetID_Identifier"
			+" FROM EffectSize "
			+" INNER JOIN DataSet ON (EffectSize.id = DataSet.id)"
			+" INNER JOIN Characteristic ON (EffectSize.id = Characteristic.id)"

			
			//label for ProtocolUsed=Identifier
//path==ProtocolUsed. type==xref.
//path==ProtocolUsed_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Characteristic AS xref_ProtocolUsed " 
			+" ON xref_ProtocolUsed.id = DataSet.ProtocolUsed"
			
			//label for UsedMarkerSetID=Identifier
//path==UsedMarkerSetID. type==xref.
//path==UsedMarkerSetID_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Characteristic AS xref_UsedMarkerSetID " 
			+" ON xref_UsedMarkerSetID.id = EffectSize.UsedMarkerSetID"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM EffectSize "
			  +" INNER JOIN DataSet ON (EffectSize.id = DataSet.id)"
			  +" INNER JOIN Characteristic ON (EffectSize.id = Characteristic.id)"
			
			//label for ProtocolUsed=Identifier
//ProtocolUsed
//ProtocolUsed_Identifier
		   	+" LEFT JOIN Characteristic AS xref_ProtocolUsed " 
			+" ON xref_ProtocolUsed.id = DataSet.ProtocolUsed"
			
			//label for UsedMarkerSetID=Identifier
//UsedMarkerSetID
//UsedMarkerSetID_Identifier
		   	+" LEFT JOIN Characteristic AS xref_UsedMarkerSetID " 
			+" ON xref_UsedMarkerSetID.id = EffectSize.UsedMarkerSetID"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "EffectSize.id";
		if("EffectSize_id".equalsIgnoreCase(fieldName)) return "EffectSize.id";
		if("Identifier".equalsIgnoreCase(fieldName)) return "Characteristic.Identifier";
		if("EffectSize_Identifier".equalsIgnoreCase(fieldName)) return "Characteristic.Identifier";
		if("Name".equalsIgnoreCase(fieldName)) return "Characteristic.Name";
		if("EffectSize_Name".equalsIgnoreCase(fieldName)) return "Characteristic.Name";
		if("__Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("EffectSize___Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("description".equalsIgnoreCase(fieldName)) return "Characteristic.description";
		if("EffectSize_description".equalsIgnoreCase(fieldName)) return "Characteristic.description";
		if("ProtocolUsed".equalsIgnoreCase(fieldName)) return "DataSet.ProtocolUsed";
		if("EffectSize_ProtocolUsed".equalsIgnoreCase(fieldName)) return "DataSet.ProtocolUsed";
		if("startTime".equalsIgnoreCase(fieldName)) return "DataSet.startTime";
		if("EffectSize_startTime".equalsIgnoreCase(fieldName)) return "DataSet.startTime";
		if("endTime".equalsIgnoreCase(fieldName)) return "DataSet.endTime";
		if("EffectSize_endTime".equalsIgnoreCase(fieldName)) return "DataSet.endTime";
		if("UsedMarkerSetID".equalsIgnoreCase(fieldName)) return "EffectSize.UsedMarkerSetID";
		if("EffectSize_UsedMarkerSetID".equalsIgnoreCase(fieldName)) return "EffectSize.UsedMarkerSetID";
		if("Lower95Bound".equalsIgnoreCase(fieldName)) return "EffectSize.Lower95Bound";
		if("EffectSize_Lower95Bound".equalsIgnoreCase(fieldName)) return "EffectSize.Lower95Bound";
		if("Upper95Bound".equalsIgnoreCase(fieldName)) return "EffectSize.Upper95Bound";
		if("EffectSize_Upper95Bound".equalsIgnoreCase(fieldName)) return "EffectSize.Upper95Bound";
		if("StdError".equalsIgnoreCase(fieldName)) return "EffectSize.StdError";
		if("EffectSize_StdError".equalsIgnoreCase(fieldName)) return "EffectSize.StdError";
		if("ProtocolUsed_id".equalsIgnoreCase(fieldName)) return "DataSet.ProtocolUsed";
		if("EffectSize_ProtocolUsed_id".equalsIgnoreCase(fieldName)) return "DataSet.ProtocolUsed";
		if("ProtocolUsed_Identifier".equalsIgnoreCase(fieldName)) return "xref_ProtocolUsed.Identifier";	
		if("EffectSize_ProtocolUsed_Identifier".equalsIgnoreCase(fieldName)) return "xref_ProtocolUsed.Identifier";
		if("UsedMarkerSetID_id".equalsIgnoreCase(fieldName)) return "EffectSize.UsedMarkerSetID";
		if("EffectSize_UsedMarkerSetID_id".equalsIgnoreCase(fieldName)) return "EffectSize.UsedMarkerSetID";
		if("UsedMarkerSetID_Identifier".equalsIgnoreCase(fieldName)) return "xref_UsedMarkerSetID.Identifier";	
		if("EffectSize_UsedMarkerSetID_Identifier".equalsIgnoreCase(fieldName)) return "xref_UsedMarkerSetID.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.gwascentral.EffectSize> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.gwascentral.EffectSize>(size); 
	}			

	public org.molgenis.gwascentral.EffectSize create()
	{
		return new org.molgenis.gwascentral.EffectSize();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.gwascentral.EffectSize> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'protocolUsed' to protocol.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> protocolUsedRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'usedMarkerSetID' to usedMarkerSet.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> usedMarkerSetIDRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.gwascentral.EffectSize object: entities)
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
			if(object.getUsedMarkerSetID_Id() == null && object.getUsedMarkerSetID_Identifier() != null)
			{
				Object label = object.getUsedMarkerSetID_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !usedMarkerSetIDRules.containsKey(label))
					{
						usedMarkerSetIDRules.put(""+label, xrefFilter);
						usedMarkerSetIDRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
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
		//resolve foreign key field 'usedMarkerSetID' to usedMarkerSet.id using Identifier)
		final java.util.Map<String,Integer> usedMarkerSetID_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(usedMarkerSetIDRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.gwascentral.UsedMarkerSet> usedMarkerSetIDList = null;
			try
			{
				usedMarkerSetIDList = getDatabase().find(org.molgenis.gwascentral.UsedMarkerSet.class, usedMarkerSetIDRules.values().toArray(new org.molgenis.framework.db.QueryRule[usedMarkerSetIDRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.gwascentral.UsedMarkerSet xref :  usedMarkerSetIDList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				usedMarkerSetID_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.gwascentral.EffectSize object = entities.get(i);		
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
			if(object.getUsedMarkerSetID_Id() == null )
			{
					String key = "";
					if(object.getUsedMarkerSetID_Identifier() != null)
						key += 	object.getUsedMarkerSetID_Identifier();
					
					if(!"".equals(key) && usedMarkerSetID_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("UsedMarkerSetID_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setUsedMarkerSetID_Id(usedMarkerSetID_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "effectSize.id".equalsIgnoreCase(fieldName)) 
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
			if("usedMarkerSetID".equalsIgnoreCase(fieldName) || "effectSize.usedMarkerSetID".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("lower95Bound".equalsIgnoreCase(fieldName) || "effectSize.lower95Bound".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.DecimalField();
			if("upper95Bound".equalsIgnoreCase(fieldName) || "effectSize.upper95Bound".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.DecimalField();
			if("stdError".equalsIgnoreCase(fieldName) || "effectSize.stdError".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.DecimalField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, EffectSize entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.gwascentral.EffectSize> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.gwascentral.EffectSize> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<EffectSize> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<EffectSize> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<EffectSize> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
