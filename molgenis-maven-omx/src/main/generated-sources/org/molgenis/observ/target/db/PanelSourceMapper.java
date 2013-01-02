/* File:        org.molgenis.omx/model/PanelSource.java
 * Copyright:   GBIC 2000-2013, all rights reserved
 * Date:        January 2, 2013
 * Template:	MultiqueryMapperGen.java.ftl
 * generator:   org.molgenis.generators.db.MultiqueryMapperGen 4.0.0-testing
 *
 * Using "subclass per table" strategy
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.observ.target.db;

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
import org.molgenis.observ.target.PanelSource;

import org.molgenis.observ.target.Panel;
import org.molgenis.observ.target.Panel;

public class PanelSourceMapper extends AbstractJDBCMapper<PanelSource>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends PanelSource> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO PanelSource (CurrentPanel,SourcePanel,NumberOfIndividuals,SelectionCriteria) VALUES ");
		{
		
			boolean first = true;
			for(PanelSource e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//currentPanel
				if(e.getCurrentPanel_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getCurrentPanel_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//sourcePanel
				if(e.getSourcePanel_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getSourcePanel_Id().toString())+"'"
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
				//selectionCriteria
				if(e.getSelectionCriteria() != null){
								
					sql.append("'"+this.escapeSql(e.getSelectionCriteria().toString())+"'"
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
	public int executeUpdate(List<? extends PanelSource> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO PanelSource (id,CurrentPanel,SourcePanel,NumberOfIndividuals,SelectionCriteria) VALUES ");		
		boolean first = true;
		for(PanelSource e: entities)
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
		
			//currentPanel


			if(e.getCurrentPanel_Id() != null){
                sql.append("'"+this.escapeSql(e.getCurrentPanel_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//sourcePanel


			if(e.getSourcePanel_Id() != null){
                sql.append("'"+this.escapeSql(e.getSourcePanel_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//numberOfIndividuals


			if(e.getNumberOfIndividuals() != null){
                sql.append("'"+this.escapeSql(e.getNumberOfIndividuals()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//selectionCriteria


			if(e.getSelectionCriteria() != null){
                sql.append("'"+this.escapeSql(e.getSelectionCriteria()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE CurrentPanel=VALUES(CurrentPanel),SourcePanel=VALUES(SourcePanel),NumberOfIndividuals=VALUES(NumberOfIndividuals),SelectionCriteria=VALUES(SelectionCriteria),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends PanelSource> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM PanelSource WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(PanelSource e: entities)
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
	
	public PanelSourceMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT PanelSource.id"
			+", PanelSource.CurrentPanel"
			+", PanelSource.SourcePanel"
			+", PanelSource.NumberOfIndividuals"
			+", PanelSource.SelectionCriteria"
			//parent is SimpleTree(name='CurrentPanel')
			+", xref_CurrentPanel.Identifier AS CurrentPanel_Identifier"
			//parent is SimpleTree(name='SourcePanel')
			+", xref_SourcePanel.Identifier AS SourcePanel_Identifier"
			+" FROM PanelSource "

			
			//label for CurrentPanel=Identifier
//path==CurrentPanel. type==xref.
//path==CurrentPanel_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Characteristic AS xref_CurrentPanel " 
			+" ON xref_CurrentPanel.id = PanelSource.CurrentPanel"
			
			//label for SourcePanel=Identifier
//path==SourcePanel. type==xref.
//path==SourcePanel_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Characteristic AS xref_SourcePanel " 
			+" ON xref_SourcePanel.id = PanelSource.SourcePanel"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM PanelSource "
			
			//label for CurrentPanel=Identifier
//CurrentPanel
//CurrentPanel_Identifier
		   	+" LEFT JOIN Characteristic AS xref_CurrentPanel " 
			+" ON xref_CurrentPanel.id = PanelSource.CurrentPanel"
			
			//label for SourcePanel=Identifier
//SourcePanel
//SourcePanel_Identifier
		   	+" LEFT JOIN Characteristic AS xref_SourcePanel " 
			+" ON xref_SourcePanel.id = PanelSource.SourcePanel"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "PanelSource.id";
		if("PanelSource_id".equalsIgnoreCase(fieldName)) return "PanelSource.id";
		if("CurrentPanel".equalsIgnoreCase(fieldName)) return "PanelSource.CurrentPanel";
		if("PanelSource_CurrentPanel".equalsIgnoreCase(fieldName)) return "PanelSource.CurrentPanel";
		if("SourcePanel".equalsIgnoreCase(fieldName)) return "PanelSource.SourcePanel";
		if("PanelSource_SourcePanel".equalsIgnoreCase(fieldName)) return "PanelSource.SourcePanel";
		if("NumberOfIndividuals".equalsIgnoreCase(fieldName)) return "PanelSource.NumberOfIndividuals";
		if("PanelSource_NumberOfIndividuals".equalsIgnoreCase(fieldName)) return "PanelSource.NumberOfIndividuals";
		if("SelectionCriteria".equalsIgnoreCase(fieldName)) return "PanelSource.SelectionCriteria";
		if("PanelSource_SelectionCriteria".equalsIgnoreCase(fieldName)) return "PanelSource.SelectionCriteria";
		if("CurrentPanel_id".equalsIgnoreCase(fieldName)) return "PanelSource.CurrentPanel";
		if("PanelSource_CurrentPanel_id".equalsIgnoreCase(fieldName)) return "PanelSource.CurrentPanel";
		if("CurrentPanel_Identifier".equalsIgnoreCase(fieldName)) return "xref_CurrentPanel.Identifier";	
		if("PanelSource_CurrentPanel_Identifier".equalsIgnoreCase(fieldName)) return "xref_CurrentPanel.Identifier";
		if("SourcePanel_id".equalsIgnoreCase(fieldName)) return "PanelSource.SourcePanel";
		if("PanelSource_SourcePanel_id".equalsIgnoreCase(fieldName)) return "PanelSource.SourcePanel";
		if("SourcePanel_Identifier".equalsIgnoreCase(fieldName)) return "xref_SourcePanel.Identifier";	
		if("PanelSource_SourcePanel_Identifier".equalsIgnoreCase(fieldName)) return "xref_SourcePanel.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.observ.target.PanelSource> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.observ.target.PanelSource>(size); 
	}			

	public org.molgenis.observ.target.PanelSource create()
	{
		return new org.molgenis.observ.target.PanelSource();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.observ.target.PanelSource> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'currentPanel' to panel.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> currentPanelRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'sourcePanel' to panel.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> sourcePanelRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.observ.target.PanelSource object: entities)
		{
			//create xref/mref rule filtering Panel on the label Identifier
			if(object.getCurrentPanel_Id() == null && object.getCurrentPanel_Identifier() != null)
			{
				Object label = object.getCurrentPanel_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !currentPanelRules.containsKey(label))
					{
						currentPanelRules.put(""+label, xrefFilter);
						currentPanelRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
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
		}

		//resolve foreign key field 'currentPanel' to panel.id using Identifier)
		final java.util.Map<String,Integer> currentPanel_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(currentPanelRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.observ.target.Panel> currentPanelList = null;
			try
			{
				currentPanelList = getDatabase().find(org.molgenis.observ.target.Panel.class, currentPanelRules.values().toArray(new org.molgenis.framework.db.QueryRule[currentPanelRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.observ.target.Panel xref :  currentPanelList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				currentPanel_Labels_to_IdMap.put(key, xref.getId());
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

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.observ.target.PanelSource object = entities.get(i);		
			//update object using label fields Identifier
			if(object.getCurrentPanel_Id() == null )
			{
					String key = "";
					if(object.getCurrentPanel_Identifier() != null)
						key += 	object.getCurrentPanel_Identifier();
					
					if(!"".equals(key) && currentPanel_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("CurrentPanel_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setCurrentPanel_Id(currentPanel_Labels_to_IdMap.get(key));
					}
			}
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
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "panelSource.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("currentPanel".equalsIgnoreCase(fieldName) || "panelSource.currentPanel".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("sourcePanel".equalsIgnoreCase(fieldName) || "panelSource.sourcePanel".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("numberOfIndividuals".equalsIgnoreCase(fieldName) || "panelSource.numberOfIndividuals".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("selectionCriteria".equalsIgnoreCase(fieldName) || "panelSource.selectionCriteria".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, PanelSource entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.observ.target.PanelSource> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.observ.target.PanelSource> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<PanelSource> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<PanelSource> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<PanelSource> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
