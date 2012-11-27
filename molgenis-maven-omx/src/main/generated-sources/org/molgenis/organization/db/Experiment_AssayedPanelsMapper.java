/* File:        org.molgenis/model/Experiment_AssayedPanels.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 26, 2012
 * Template:	MultiqueryMapperGen.java.ftl
 * generator:   org.molgenis.generators.db.MultiqueryMapperGen 4.0.0-testing
 *
 * Using "subclass per table" strategy
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.organization.db;

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
import org.molgenis.organization.Experiment_AssayedPanels;

import org.molgenis.observ.target.Panel;
import org.molgenis.organization.Experiment;

public class Experiment_AssayedPanelsMapper extends AbstractJDBCMapper<Experiment_AssayedPanels>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends Experiment_AssayedPanels> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO Experiment_AssayedPanels (AssayedPanels,Experiment) VALUES ");
		{
		
			boolean first = true;
			for(Experiment_AssayedPanels e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//assayedPanels
				if(e.getAssayedPanels_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getAssayedPanels_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//experiment
				if(e.getExperiment_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getExperiment_Id().toString())+"'"
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
	public int executeUpdate(List<? extends Experiment_AssayedPanels> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO Experiment_AssayedPanels (autoid,AssayedPanels,Experiment) VALUES ");		
		boolean first = true;
		for(Experiment_AssayedPanels e: entities)
		{
			// put the ,
			if(first)
				first = false;
			else
				sql.append(",");

			sql.append("(");
			
			//autoid


			if(e.getAutoid() != null){
                sql.append("'"+this.escapeSql(e.getAutoid()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//assayedPanels


			if(e.getAssayedPanels_Id() != null){
                sql.append("'"+this.escapeSql(e.getAssayedPanels_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//experiment


			if(e.getExperiment_Id() != null){
                sql.append("'"+this.escapeSql(e.getExperiment_Id()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE autoid=LAST_INSERT_ID(autoid),AssayedPanels=VALUES(AssayedPanels),Experiment=VALUES(Experiment)");

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
	public int executeRemove(List<? extends Experiment_AssayedPanels> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM Experiment_AssayedPanels WHERE ");
		
		//key $f_index: autoid
		{
			sql.append("autoid in (");
			boolean first = true;
			for(Experiment_AssayedPanels e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");			
				sql.append("'"+this.escapeSql(e.getAutoid().toString())+"'");
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
	
	public Experiment_AssayedPanelsMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT Experiment_AssayedPanels.autoid"
			+", Experiment_AssayedPanels.AssayedPanels"
			+", Experiment_AssayedPanels.Experiment"
			//parent is SimpleTree(name='AssayedPanels')
			+", xref_AssayedPanels.Identifier AS AssayedPanels_Identifier"
			//parent is SimpleTree(name='Experiment')
			+", xref_Experiment.Identifier AS Experiment_Identifier"
			+" FROM Experiment_AssayedPanels "

			
			//label for AssayedPanels=Identifier
//path==AssayedPanels. type==xref.
//path==AssayedPanels_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Characteristic AS xref_AssayedPanels " 
			+" ON xref_AssayedPanels.id = Experiment_AssayedPanels.AssayedPanels"
			
			//label for Experiment=Identifier
//path==Experiment. type==xref.
//path==Experiment_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Experiment AS xref_Experiment " 
			+" ON xref_Experiment.id = Experiment_AssayedPanels.Experiment"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM Experiment_AssayedPanels "
			
			//label for AssayedPanels=Identifier
//AssayedPanels
//AssayedPanels_Identifier
		   	+" LEFT JOIN Characteristic AS xref_AssayedPanels " 
			+" ON xref_AssayedPanels.id = Experiment_AssayedPanels.AssayedPanels"
			
			//label for Experiment=Identifier
//Experiment
//Experiment_Identifier
		   	+" LEFT JOIN Experiment AS xref_Experiment " 
			+" ON xref_Experiment.id = Experiment_AssayedPanels.Experiment"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("autoid".equalsIgnoreCase(fieldName)) return "Experiment_AssayedPanels.autoid";
		if("Experiment_AssayedPanels_autoid".equalsIgnoreCase(fieldName)) return "Experiment_AssayedPanels.autoid";
		if("AssayedPanels".equalsIgnoreCase(fieldName)) return "Experiment_AssayedPanels.AssayedPanels";
		if("Experiment_AssayedPanels_AssayedPanels".equalsIgnoreCase(fieldName)) return "Experiment_AssayedPanels.AssayedPanels";
		if("Experiment".equalsIgnoreCase(fieldName)) return "Experiment_AssayedPanels.Experiment";
		if("Experiment_AssayedPanels_Experiment".equalsIgnoreCase(fieldName)) return "Experiment_AssayedPanels.Experiment";
		if("AssayedPanels_id".equalsIgnoreCase(fieldName)) return "Experiment_AssayedPanels.AssayedPanels";
		if("Experiment_AssayedPanels_AssayedPanels_id".equalsIgnoreCase(fieldName)) return "Experiment_AssayedPanels.AssayedPanels";
		if("AssayedPanels_Identifier".equalsIgnoreCase(fieldName)) return "xref_AssayedPanels.Identifier";	
		if("Experiment_AssayedPanels_AssayedPanels_Identifier".equalsIgnoreCase(fieldName)) return "xref_AssayedPanels.Identifier";
		if("Experiment_id".equalsIgnoreCase(fieldName)) return "Experiment_AssayedPanels.Experiment";
		if("Experiment_AssayedPanels_Experiment_id".equalsIgnoreCase(fieldName)) return "Experiment_AssayedPanels.Experiment";
		if("Experiment_Identifier".equalsIgnoreCase(fieldName)) return "xref_Experiment.Identifier";	
		if("Experiment_AssayedPanels_Experiment_Identifier".equalsIgnoreCase(fieldName)) return "xref_Experiment.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.organization.Experiment_AssayedPanels> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.organization.Experiment_AssayedPanels>(size); 
	}			

	public org.molgenis.organization.Experiment_AssayedPanels create()
	{
		return new org.molgenis.organization.Experiment_AssayedPanels();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.organization.Experiment_AssayedPanels> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'assayedPanels' to panel.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> assayedPanelsRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'experiment' to experiment.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> experimentRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.organization.Experiment_AssayedPanels object: entities)
		{
			//create xref/mref rule filtering Panel on the label Identifier
			if(object.getAssayedPanels_Id() == null && object.getAssayedPanels_Identifier() != null)
			{
				Object label = object.getAssayedPanels_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !assayedPanelsRules.containsKey(label))
					{
						assayedPanelsRules.put(""+label, xrefFilter);
						assayedPanelsRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering Experiment on the label Identifier
			if(object.getExperiment_Id() == null && object.getExperiment_Identifier() != null)
			{
				Object label = object.getExperiment_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !experimentRules.containsKey(label))
					{
						experimentRules.put(""+label, xrefFilter);
						experimentRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
		}

		//resolve foreign key field 'assayedPanels' to panel.id using Identifier)
		final java.util.Map<String,Integer> assayedPanels_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(assayedPanelsRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.observ.target.Panel> assayedPanelsList = null;
			try
			{
				assayedPanelsList = getDatabase().find(org.molgenis.observ.target.Panel.class, assayedPanelsRules.values().toArray(new org.molgenis.framework.db.QueryRule[assayedPanelsRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.observ.target.Panel xref :  assayedPanelsList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				assayedPanels_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'experiment' to experiment.id using Identifier)
		final java.util.Map<String,Integer> experiment_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(experimentRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.organization.Experiment> experimentList = null;
			try
			{
				experimentList = getDatabase().find(org.molgenis.organization.Experiment.class, experimentRules.values().toArray(new org.molgenis.framework.db.QueryRule[experimentRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.organization.Experiment xref :  experimentList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				experiment_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.organization.Experiment_AssayedPanels object = entities.get(i);		
			//update object using label fields Identifier
			if(object.getAssayedPanels_Id() == null )
			{
					String key = "";
					if(object.getAssayedPanels_Identifier() != null)
						key += 	object.getAssayedPanels_Identifier();
					
					if(!"".equals(key) && assayedPanels_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("AssayedPanels_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setAssayedPanels_Id(assayedPanels_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields Identifier
			if(object.getExperiment_Id() == null )
			{
					String key = "";
					if(object.getExperiment_Identifier() != null)
						key += 	object.getExperiment_Identifier();
					
					if(!"".equals(key) && experiment_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Experiment_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setExperiment_Id(experiment_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("autoid".equalsIgnoreCase(fieldName) || "experiment_AssayedPanels.autoid".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("assayedPanels".equalsIgnoreCase(fieldName) || "experiment_AssayedPanels.assayedPanels".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("experiment".equalsIgnoreCase(fieldName) || "experiment_AssayedPanels.experiment".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, Experiment_AssayedPanels entity)
	{
		entity.setAutoid(i);
	}
	
	@Override
	public QueryRule rewriteMrefRule(Database db, QueryRule rule) throws DatabaseException
	{
		
		{
			return rule;
		}
	}

//Generated by MapperFileAttachments.java.ftl
	public void prepareFileAttachements(java.util.List<org.molgenis.organization.Experiment_AssayedPanels> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.organization.Experiment_AssayedPanels> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<Experiment_AssayedPanels> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<Experiment_AssayedPanels> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<Experiment_AssayedPanels> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
