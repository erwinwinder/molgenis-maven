/* File:        org.molgenis.omx/model/ObservationSet.java
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
import org.molgenis.observ.ObservationSet;

import org.molgenis.observ.DataSet;
import org.molgenis.observ.Characteristic;

public class ObservationSetMapper extends AbstractJDBCMapper<ObservationSet>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends ObservationSet> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO ObservationSet (partOfDataSet,Target,Time) VALUES ");
		{
		
			boolean first = true;
			for(ObservationSet e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//partOfDataSet
				if(e.getPartOfDataSet_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getPartOfDataSet_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//target
				if(e.getTarget_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getTarget_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//time
				if(e.getTime() != null){
								
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String mysqlDateTime = dateFormat.format(e.getTime());
					sql.append("'"+this.escapeSql(mysqlDateTime)+"'"
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
	public int executeUpdate(List<? extends ObservationSet> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO ObservationSet (id,partOfDataSet,Target,Time) VALUES ");		
		boolean first = true;
		for(ObservationSet e: entities)
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
		
			//partOfDataSet


			if(e.getPartOfDataSet_Id() != null){
                sql.append("'"+this.escapeSql(e.getPartOfDataSet_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//target


			if(e.getTarget_Id() != null){
                sql.append("'"+this.escapeSql(e.getTarget_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//time


			if(e.getTime() != null){
                sql.append("'"+new java.sql.Timestamp(e.getTime().getTime()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE partOfDataSet=VALUES(partOfDataSet),Target=VALUES(Target),Time=VALUES(Time),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends ObservationSet> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM ObservationSet WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(ObservationSet e: entities)
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
	
	public ObservationSetMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT ObservationSet.id"
			+", ObservationSet.partOfDataSet"
			+", ObservationSet.Target"
			+", ObservationSet.Time"
			//parent is SimpleTree(name='partOfDataSet')
			+", xref_partOfDataSet.Identifier AS partOfDataSet_Identifier"
			//parent is SimpleTree(name='Target')
			+", xref_Target.Identifier AS Target_Identifier"
			+" FROM ObservationSet "

			
			//label for partOfDataSet=Identifier
//path==partOfDataSet. type==xref.
//path==partOfDataSet_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Characteristic AS xref_partOfDataSet " 
			+" ON xref_partOfDataSet.id = ObservationSet.partOfDataSet"
			
			//label for Target=Identifier
//path==Target. type==xref.
//path==Target_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Characteristic AS xref_Target " 
			+" ON xref_Target.id = ObservationSet.Target"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM ObservationSet "
			
			//label for partOfDataSet=Identifier
//partOfDataSet
//partOfDataSet_Identifier
		   	+" LEFT JOIN Characteristic AS xref_partOfDataSet " 
			+" ON xref_partOfDataSet.id = ObservationSet.partOfDataSet"
			
			//label for Target=Identifier
//Target
//Target_Identifier
		   	+" LEFT JOIN Characteristic AS xref_Target " 
			+" ON xref_Target.id = ObservationSet.Target"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "ObservationSet.id";
		if("ObservationSet_id".equalsIgnoreCase(fieldName)) return "ObservationSet.id";
		if("partOfDataSet".equalsIgnoreCase(fieldName)) return "ObservationSet.partOfDataSet";
		if("ObservationSet_partOfDataSet".equalsIgnoreCase(fieldName)) return "ObservationSet.partOfDataSet";
		if("Target".equalsIgnoreCase(fieldName)) return "ObservationSet.Target";
		if("ObservationSet_Target".equalsIgnoreCase(fieldName)) return "ObservationSet.Target";
		if("Time".equalsIgnoreCase(fieldName)) return "ObservationSet.Time";
		if("ObservationSet_Time".equalsIgnoreCase(fieldName)) return "ObservationSet.Time";
		if("partOfDataSet_id".equalsIgnoreCase(fieldName)) return "ObservationSet.partOfDataSet";
		if("ObservationSet_partOfDataSet_id".equalsIgnoreCase(fieldName)) return "ObservationSet.partOfDataSet";
		if("partOfDataSet_Identifier".equalsIgnoreCase(fieldName)) return "xref_partOfDataSet.Identifier";	
		if("ObservationSet_partOfDataSet_Identifier".equalsIgnoreCase(fieldName)) return "xref_partOfDataSet.Identifier";
		if("Target_id".equalsIgnoreCase(fieldName)) return "ObservationSet.Target";
		if("ObservationSet_Target_id".equalsIgnoreCase(fieldName)) return "ObservationSet.Target";
		if("Target_Identifier".equalsIgnoreCase(fieldName)) return "xref_Target.Identifier";	
		if("ObservationSet_Target_Identifier".equalsIgnoreCase(fieldName)) return "xref_Target.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.observ.ObservationSet> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.observ.ObservationSet>(size); 
	}			

	public org.molgenis.observ.ObservationSet create()
	{
		return new org.molgenis.observ.ObservationSet();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.observ.ObservationSet> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'partOfDataSet' to dataSet.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> partOfDataSetRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'target' to characteristic.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> targetRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.observ.ObservationSet object: entities)
		{
			//create xref/mref rule filtering DataSet on the label Identifier
			if(object.getPartOfDataSet_Id() == null && object.getPartOfDataSet_Identifier() != null)
			{
				Object label = object.getPartOfDataSet_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !partOfDataSetRules.containsKey(label))
					{
						partOfDataSetRules.put(""+label, xrefFilter);
						partOfDataSetRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering Characteristic on the label Identifier
			if(object.getTarget_Id() == null && object.getTarget_Identifier() != null)
			{
				Object label = object.getTarget_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !targetRules.containsKey(label))
					{
						targetRules.put(""+label, xrefFilter);
						targetRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
		}

		//resolve foreign key field 'partOfDataSet' to dataSet.id using Identifier)
		final java.util.Map<String,Integer> partOfDataSet_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(partOfDataSetRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.observ.DataSet> partOfDataSetList = null;
			try
			{
				partOfDataSetList = getDatabase().find(org.molgenis.observ.DataSet.class, partOfDataSetRules.values().toArray(new org.molgenis.framework.db.QueryRule[partOfDataSetRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.observ.DataSet xref :  partOfDataSetList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				partOfDataSet_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'target' to characteristic.id using Identifier)
		final java.util.Map<String,Integer> target_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(targetRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.observ.Characteristic> targetList = null;
			try
			{
				targetList = getDatabase().find(org.molgenis.observ.Characteristic.class, targetRules.values().toArray(new org.molgenis.framework.db.QueryRule[targetRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.observ.Characteristic xref :  targetList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				target_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.observ.ObservationSet object = entities.get(i);		
			//update object using label fields Identifier
			if(object.getPartOfDataSet_Id() == null )
			{
					String key = "";
					if(object.getPartOfDataSet_Identifier() != null)
						key += 	object.getPartOfDataSet_Identifier();
					
					if(!"".equals(key) && partOfDataSet_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("partOfDataSet_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setPartOfDataSet_Id(partOfDataSet_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields Identifier
			if(object.getTarget_Id() == null )
			{
					String key = "";
					if(object.getTarget_Identifier() != null)
						key += 	object.getTarget_Identifier();
					
					if(!"".equals(key) && target_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Target_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setTarget_Id(target_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "observationSet.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("partOfDataSet".equalsIgnoreCase(fieldName) || "observationSet.partOfDataSet".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("target".equalsIgnoreCase(fieldName) || "observationSet.target".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("time".equalsIgnoreCase(fieldName) || "observationSet.time".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.DatetimeField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, ObservationSet entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.observ.ObservationSet> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.observ.ObservationSet> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<ObservationSet> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<ObservationSet> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<ObservationSet> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
