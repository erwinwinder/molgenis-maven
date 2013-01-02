/* File:        org.molgenis.omx/model/DataSet.java
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
import org.molgenis.observ.DataSet;

import org.molgenis.observ.Characteristic;
import org.molgenis.observ.db.CharacteristicMapper;
import org.molgenis.observ.Protocol;

public class DataSetMapper extends AbstractJDBCMapper<DataSet>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends DataSet> entities) throws DatabaseException
	{	
		//add superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.Characteristic.class).executeAdd(entities);
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO DataSet (ProtocolUsed,startTime,endTime,id) VALUES ");
		{
		
			boolean first = true;
			for(DataSet e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//protocolUsed
				if(e.getProtocolUsed_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getProtocolUsed_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//startTime
				if(e.getStartTime() != null){
								
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String mysqlDateTime = dateFormat.format(e.getStartTime());
					sql.append("'"+this.escapeSql(mysqlDateTime)+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//endTime
				if(e.getEndTime() != null){
								
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String mysqlDateTime = dateFormat.format(e.getEndTime());
					sql.append("'"+this.escapeSql(mysqlDateTime)+"'"
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
	public int executeUpdate(List<? extends DataSet> entities) throws DatabaseException
	{
		//update superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.Characteristic.class).executeUpdate(entities);
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO DataSet (ProtocolUsed,startTime,endTime,id) VALUES ");		
		boolean first = true;
		for(DataSet e: entities)
		{
			// put the ,
			if(first)
				first = false;
			else
				sql.append(",");

			sql.append("(");
			
			//protocolUsed


			if(e.getProtocolUsed_Id() != null){
                sql.append("'"+this.escapeSql(e.getProtocolUsed_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//startTime


			if(e.getStartTime() != null){
                sql.append("'"+new java.sql.Timestamp(e.getStartTime().getTime()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//endTime


			if(e.getEndTime() != null){
                sql.append("'"+new java.sql.Timestamp(e.getEndTime().getTime()).toString()+"'" +",");
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
		sql.append(" ON DUPLICATE KEY UPDATE ProtocolUsed=VALUES(ProtocolUsed),startTime=VALUES(startTime),endTime=VALUES(endTime),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends DataSet> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM DataSet WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(DataSet e: entities)
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
	
	public DataSetMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT DataSet.id"
			+", Characteristic.Identifier"
			+", Characteristic.Name"
			+", Characteristic.__Type"
			+", Characteristic.description"
			+", DataSet.ProtocolUsed"
			+", DataSet.startTime"
			+", DataSet.endTime"
			//parent is SimpleTree(name='ProtocolUsed')
			+", xref_ProtocolUsed.Identifier AS ProtocolUsed_Identifier"
			+" FROM DataSet "
			+" INNER JOIN Characteristic ON (DataSet.id = Characteristic.id)"

			
			//label for ProtocolUsed=Identifier
//path==ProtocolUsed. type==xref.
//path==ProtocolUsed_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Characteristic AS xref_ProtocolUsed " 
			+" ON xref_ProtocolUsed.id = DataSet.ProtocolUsed"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM DataSet "
			  +" INNER JOIN Characteristic ON (DataSet.id = Characteristic.id)"
			
			//label for ProtocolUsed=Identifier
//ProtocolUsed
//ProtocolUsed_Identifier
		   	+" LEFT JOIN Characteristic AS xref_ProtocolUsed " 
			+" ON xref_ProtocolUsed.id = DataSet.ProtocolUsed"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "DataSet.id";
		if("DataSet_id".equalsIgnoreCase(fieldName)) return "DataSet.id";
		if("Identifier".equalsIgnoreCase(fieldName)) return "Characteristic.Identifier";
		if("DataSet_Identifier".equalsIgnoreCase(fieldName)) return "Characteristic.Identifier";
		if("Name".equalsIgnoreCase(fieldName)) return "Characteristic.Name";
		if("DataSet_Name".equalsIgnoreCase(fieldName)) return "Characteristic.Name";
		if("__Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("DataSet___Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("description".equalsIgnoreCase(fieldName)) return "Characteristic.description";
		if("DataSet_description".equalsIgnoreCase(fieldName)) return "Characteristic.description";
		if("ProtocolUsed".equalsIgnoreCase(fieldName)) return "DataSet.ProtocolUsed";
		if("DataSet_ProtocolUsed".equalsIgnoreCase(fieldName)) return "DataSet.ProtocolUsed";
		if("startTime".equalsIgnoreCase(fieldName)) return "DataSet.startTime";
		if("DataSet_startTime".equalsIgnoreCase(fieldName)) return "DataSet.startTime";
		if("endTime".equalsIgnoreCase(fieldName)) return "DataSet.endTime";
		if("DataSet_endTime".equalsIgnoreCase(fieldName)) return "DataSet.endTime";
		if("ProtocolUsed_id".equalsIgnoreCase(fieldName)) return "DataSet.ProtocolUsed";
		if("DataSet_ProtocolUsed_id".equalsIgnoreCase(fieldName)) return "DataSet.ProtocolUsed";
		if("ProtocolUsed_Identifier".equalsIgnoreCase(fieldName)) return "xref_ProtocolUsed.Identifier";	
		if("DataSet_ProtocolUsed_Identifier".equalsIgnoreCase(fieldName)) return "xref_ProtocolUsed.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.observ.DataSet> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.observ.DataSet>(size); 
	}			

	public org.molgenis.observ.DataSet create()
	{
		return new org.molgenis.observ.DataSet();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.observ.DataSet> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'protocolUsed' to protocol.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> protocolUsedRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.observ.DataSet object: entities)
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

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.observ.DataSet object = entities.get(i);		
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
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "dataSet.id".equalsIgnoreCase(fieldName)) 
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
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, DataSet entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.observ.DataSet> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.observ.DataSet> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<DataSet> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<DataSet> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<DataSet> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
