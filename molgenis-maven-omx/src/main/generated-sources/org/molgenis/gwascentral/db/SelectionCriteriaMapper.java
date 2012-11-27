/* File:        org.molgenis/model/SelectionCriteria.java
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
import org.molgenis.gwascentral.SelectionCriteria;

import org.molgenis.observ.target.Panel;
import org.molgenis.observ.target.Panel;

public class SelectionCriteriaMapper extends AbstractJDBCMapper<SelectionCriteria>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends SelectionCriteria> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO SelectionCriteria (SourcePanel,TargetPanel,NumberOfIndividuals,Details) VALUES ");
		{
		
			boolean first = true;
			for(SelectionCriteria e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//sourcePanel
				if(e.getSourcePanel_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getSourcePanel_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//targetPanel
				if(e.getTargetPanel_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getTargetPanel_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//numberOfIndividuals
				if(e.getNumberOfIndividuals() != null){
								
					sql.append("'"+this.escapeSql(e.getNumberOfIndividuals().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//details
				if(e.getDetails() != null){
								
					sql.append("'"+this.escapeSql(e.getDetails().toString())+"'"
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
	public int executeUpdate(List<? extends SelectionCriteria> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO SelectionCriteria (id,SourcePanel,TargetPanel,NumberOfIndividuals,Details) VALUES ");		
		boolean first = true;
		for(SelectionCriteria e: entities)
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
		
			//sourcePanel


			if(e.getSourcePanel_Id() != null){
                sql.append("'"+this.escapeSql(e.getSourcePanel_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//targetPanel


			if(e.getTargetPanel_Id() != null){
                sql.append("'"+this.escapeSql(e.getTargetPanel_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//numberOfIndividuals


			if(e.getNumberOfIndividuals() != null){
                sql.append("'"+this.escapeSql(e.getNumberOfIndividuals()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//details


			if(e.getDetails() != null){
                sql.append("'"+this.escapeSql(e.getDetails()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE SourcePanel=VALUES(SourcePanel),TargetPanel=VALUES(TargetPanel),NumberOfIndividuals=VALUES(NumberOfIndividuals),Details=VALUES(Details),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends SelectionCriteria> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM SelectionCriteria WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(SelectionCriteria e: entities)
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
	
	public SelectionCriteriaMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT SelectionCriteria.id"
			+", SelectionCriteria.SourcePanel"
			+", SelectionCriteria.TargetPanel"
			+", SelectionCriteria.NumberOfIndividuals"
			+", SelectionCriteria.Details"
			//parent is SimpleTree(name='SourcePanel')
			+", xref_SourcePanel.Identifier AS SourcePanel_Identifier"
			//parent is SimpleTree(name='TargetPanel')
			+", xref_TargetPanel.Identifier AS TargetPanel_Identifier"
			+" FROM SelectionCriteria "

			
			//label for SourcePanel=Identifier
//path==SourcePanel. type==xref.
//path==SourcePanel_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Characteristic AS xref_SourcePanel " 
			+" ON xref_SourcePanel.id = SelectionCriteria.SourcePanel"
			
			//label for TargetPanel=Identifier
//path==TargetPanel. type==xref.
//path==TargetPanel_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Characteristic AS xref_TargetPanel " 
			+" ON xref_TargetPanel.id = SelectionCriteria.TargetPanel"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM SelectionCriteria "
			
			//label for SourcePanel=Identifier
//SourcePanel
//SourcePanel_Identifier
		   	+" LEFT JOIN Characteristic AS xref_SourcePanel " 
			+" ON xref_SourcePanel.id = SelectionCriteria.SourcePanel"
			
			//label for TargetPanel=Identifier
//TargetPanel
//TargetPanel_Identifier
		   	+" LEFT JOIN Characteristic AS xref_TargetPanel " 
			+" ON xref_TargetPanel.id = SelectionCriteria.TargetPanel"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "SelectionCriteria.id";
		if("SelectionCriteria_id".equalsIgnoreCase(fieldName)) return "SelectionCriteria.id";
		if("SourcePanel".equalsIgnoreCase(fieldName)) return "SelectionCriteria.SourcePanel";
		if("SelectionCriteria_SourcePanel".equalsIgnoreCase(fieldName)) return "SelectionCriteria.SourcePanel";
		if("TargetPanel".equalsIgnoreCase(fieldName)) return "SelectionCriteria.TargetPanel";
		if("SelectionCriteria_TargetPanel".equalsIgnoreCase(fieldName)) return "SelectionCriteria.TargetPanel";
		if("NumberOfIndividuals".equalsIgnoreCase(fieldName)) return "SelectionCriteria.NumberOfIndividuals";
		if("SelectionCriteria_NumberOfIndividuals".equalsIgnoreCase(fieldName)) return "SelectionCriteria.NumberOfIndividuals";
		if("Details".equalsIgnoreCase(fieldName)) return "SelectionCriteria.Details";
		if("SelectionCriteria_Details".equalsIgnoreCase(fieldName)) return "SelectionCriteria.Details";
		if("SourcePanel_id".equalsIgnoreCase(fieldName)) return "SelectionCriteria.SourcePanel";
		if("SelectionCriteria_SourcePanel_id".equalsIgnoreCase(fieldName)) return "SelectionCriteria.SourcePanel";
		if("SourcePanel_Identifier".equalsIgnoreCase(fieldName)) return "xref_SourcePanel.Identifier";	
		if("SelectionCriteria_SourcePanel_Identifier".equalsIgnoreCase(fieldName)) return "xref_SourcePanel.Identifier";
		if("TargetPanel_id".equalsIgnoreCase(fieldName)) return "SelectionCriteria.TargetPanel";
		if("SelectionCriteria_TargetPanel_id".equalsIgnoreCase(fieldName)) return "SelectionCriteria.TargetPanel";
		if("TargetPanel_Identifier".equalsIgnoreCase(fieldName)) return "xref_TargetPanel.Identifier";	
		if("SelectionCriteria_TargetPanel_Identifier".equalsIgnoreCase(fieldName)) return "xref_TargetPanel.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.gwascentral.SelectionCriteria> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.gwascentral.SelectionCriteria>(size); 
	}			

	public org.molgenis.gwascentral.SelectionCriteria create()
	{
		return new org.molgenis.gwascentral.SelectionCriteria();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.gwascentral.SelectionCriteria> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'sourcePanel' to panel.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> sourcePanelRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'targetPanel' to panel.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> targetPanelRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.gwascentral.SelectionCriteria object: entities)
		{
			//create xref/mref rule filtering Panel on the label Identifier
			if(object.getSourcePanel_Id() == null && object.getSourcePanel_Identifier() != null)
			{
				Object label = object.getSourcePanel_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !sourcePanelRules.containsKey(label))
					{
						sourcePanelRules.put(""+label, xrefFilter);
						sourcePanelRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering Panel on the label Identifier
			if(object.getTargetPanel_Id() == null && object.getTargetPanel_Identifier() != null)
			{
				Object label = object.getTargetPanel_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !targetPanelRules.containsKey(label))
					{
						targetPanelRules.put(""+label, xrefFilter);
						targetPanelRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
		}

		//resolve foreign key field 'sourcePanel' to panel.id using Identifier)
		final java.util.Map<String,Integer> sourcePanel_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(sourcePanelRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.observ.target.Panel> sourcePanelList = null;
			try
			{
				sourcePanelList = getDatabase().find(org.molgenis.observ.target.Panel.class, sourcePanelRules.values().toArray(new org.molgenis.framework.db.QueryRule[sourcePanelRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.observ.target.Panel xref :  sourcePanelList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				sourcePanel_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'targetPanel' to panel.id using Identifier)
		final java.util.Map<String,Integer> targetPanel_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(targetPanelRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.observ.target.Panel> targetPanelList = null;
			try
			{
				targetPanelList = getDatabase().find(org.molgenis.observ.target.Panel.class, targetPanelRules.values().toArray(new org.molgenis.framework.db.QueryRule[targetPanelRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.observ.target.Panel xref :  targetPanelList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				targetPanel_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.gwascentral.SelectionCriteria object = entities.get(i);		
			//update object using label fields Identifier
			if(object.getSourcePanel_Id() == null )
			{
					String key = "";
					if(object.getSourcePanel_Identifier() != null)
						key += 	object.getSourcePanel_Identifier();
					
					if(!"".equals(key) && sourcePanel_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("SourcePanel_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setSourcePanel_Id(sourcePanel_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields Identifier
			if(object.getTargetPanel_Id() == null )
			{
					String key = "";
					if(object.getTargetPanel_Identifier() != null)
						key += 	object.getTargetPanel_Identifier();
					
					if(!"".equals(key) && targetPanel_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("TargetPanel_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setTargetPanel_Id(targetPanel_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "selectionCriteria.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("sourcePanel".equalsIgnoreCase(fieldName) || "selectionCriteria.sourcePanel".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("targetPanel".equalsIgnoreCase(fieldName) || "selectionCriteria.targetPanel".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("numberOfIndividuals".equalsIgnoreCase(fieldName) || "selectionCriteria.numberOfIndividuals".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("details".equalsIgnoreCase(fieldName) || "selectionCriteria.details".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, SelectionCriteria entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.gwascentral.SelectionCriteria> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.gwascentral.SelectionCriteria> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<SelectionCriteria> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<SelectionCriteria> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<SelectionCriteria> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
