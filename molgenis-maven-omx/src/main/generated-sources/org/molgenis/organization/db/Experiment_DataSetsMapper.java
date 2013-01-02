/* File:        org.molgenis.omx/model/Experiment_DataSets.java
 * Copyright:   GBIC 2000-2013, all rights reserved
 * Date:        January 2, 2013
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
import org.molgenis.organization.Experiment_DataSets;

import org.molgenis.observ.DataSet;
import org.molgenis.organization.Experiment;

public class Experiment_DataSetsMapper extends AbstractJDBCMapper<Experiment_DataSets>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends Experiment_DataSets> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO Experiment_DataSets (DataSets,Experiment) VALUES ");
		{
		
			boolean first = true;
			for(Experiment_DataSets e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//dataSets
				if(e.getDataSets_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getDataSets_Id().toString())+"'"
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
	public int executeUpdate(List<? extends Experiment_DataSets> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO Experiment_DataSets (autoid,DataSets,Experiment) VALUES ");		
		boolean first = true;
		for(Experiment_DataSets e: entities)
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
		
			//dataSets


			if(e.getDataSets_Id() != null){
                sql.append("'"+this.escapeSql(e.getDataSets_Id()).toString()+"'" +",");
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
		sql.append(" ON DUPLICATE KEY UPDATE autoid=LAST_INSERT_ID(autoid),DataSets=VALUES(DataSets),Experiment=VALUES(Experiment)");

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
	public int executeRemove(List<? extends Experiment_DataSets> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM Experiment_DataSets WHERE ");
		
		//key $f_index: autoid
		{
			sql.append("autoid in (");
			boolean first = true;
			for(Experiment_DataSets e: entities)
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
	
	public Experiment_DataSetsMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT Experiment_DataSets.autoid"
			+", Experiment_DataSets.DataSets"
			+", Experiment_DataSets.Experiment"
			//parent is SimpleTree(name='DataSets')
			+", xref_DataSets.Identifier AS DataSets_Identifier"
			//parent is SimpleTree(name='Experiment')
			+", xref_Experiment.Identifier AS Experiment_Identifier"
			+" FROM Experiment_DataSets "

			
			//label for DataSets=Identifier
//path==DataSets. type==xref.
//path==DataSets_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Characteristic AS xref_DataSets " 
			+" ON xref_DataSets.id = Experiment_DataSets.DataSets"
			
			//label for Experiment=Identifier
//path==Experiment. type==xref.
//path==Experiment_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Experiment AS xref_Experiment " 
			+" ON xref_Experiment.id = Experiment_DataSets.Experiment"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM Experiment_DataSets "
			
			//label for DataSets=Identifier
//DataSets
//DataSets_Identifier
		   	+" LEFT JOIN Characteristic AS xref_DataSets " 
			+" ON xref_DataSets.id = Experiment_DataSets.DataSets"
			
			//label for Experiment=Identifier
//Experiment
//Experiment_Identifier
		   	+" LEFT JOIN Experiment AS xref_Experiment " 
			+" ON xref_Experiment.id = Experiment_DataSets.Experiment"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("autoid".equalsIgnoreCase(fieldName)) return "Experiment_DataSets.autoid";
		if("Experiment_DataSets_autoid".equalsIgnoreCase(fieldName)) return "Experiment_DataSets.autoid";
		if("DataSets".equalsIgnoreCase(fieldName)) return "Experiment_DataSets.DataSets";
		if("Experiment_DataSets_DataSets".equalsIgnoreCase(fieldName)) return "Experiment_DataSets.DataSets";
		if("Experiment".equalsIgnoreCase(fieldName)) return "Experiment_DataSets.Experiment";
		if("Experiment_DataSets_Experiment".equalsIgnoreCase(fieldName)) return "Experiment_DataSets.Experiment";
		if("DataSets_id".equalsIgnoreCase(fieldName)) return "Experiment_DataSets.DataSets";
		if("Experiment_DataSets_DataSets_id".equalsIgnoreCase(fieldName)) return "Experiment_DataSets.DataSets";
		if("DataSets_Identifier".equalsIgnoreCase(fieldName)) return "xref_DataSets.Identifier";	
		if("Experiment_DataSets_DataSets_Identifier".equalsIgnoreCase(fieldName)) return "xref_DataSets.Identifier";
		if("Experiment_id".equalsIgnoreCase(fieldName)) return "Experiment_DataSets.Experiment";
		if("Experiment_DataSets_Experiment_id".equalsIgnoreCase(fieldName)) return "Experiment_DataSets.Experiment";
		if("Experiment_Identifier".equalsIgnoreCase(fieldName)) return "xref_Experiment.Identifier";	
		if("Experiment_DataSets_Experiment_Identifier".equalsIgnoreCase(fieldName)) return "xref_Experiment.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.organization.Experiment_DataSets> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.organization.Experiment_DataSets>(size); 
	}			

	public org.molgenis.organization.Experiment_DataSets create()
	{
		return new org.molgenis.organization.Experiment_DataSets();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.organization.Experiment_DataSets> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'dataSets' to dataSet.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> dataSetsRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'experiment' to experiment.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> experimentRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.organization.Experiment_DataSets object: entities)
		{
			//create xref/mref rule filtering DataSet on the label Identifier
			if(object.getDataSets_Id() == null && object.getDataSets_Identifier() != null)
			{
				Object label = object.getDataSets_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !dataSetsRules.containsKey(label))
					{
						dataSetsRules.put(""+label, xrefFilter);
						dataSetsRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
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

		//resolve foreign key field 'dataSets' to dataSet.id using Identifier)
		final java.util.Map<String,Integer> dataSets_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(dataSetsRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.observ.DataSet> dataSetsList = null;
			try
			{
				dataSetsList = getDatabase().find(org.molgenis.observ.DataSet.class, dataSetsRules.values().toArray(new org.molgenis.framework.db.QueryRule[dataSetsRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.observ.DataSet xref :  dataSetsList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				dataSets_Labels_to_IdMap.put(key, xref.getId());
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
			org.molgenis.organization.Experiment_DataSets object = entities.get(i);		
			//update object using label fields Identifier
			if(object.getDataSets_Id() == null )
			{
					String key = "";
					if(object.getDataSets_Identifier() != null)
						key += 	object.getDataSets_Identifier();
					
					if(!"".equals(key) && dataSets_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("DataSets_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setDataSets_Id(dataSets_Labels_to_IdMap.get(key));
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
			if("autoid".equalsIgnoreCase(fieldName) || "experiment_DataSets.autoid".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("dataSets".equalsIgnoreCase(fieldName) || "experiment_DataSets.dataSets".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("experiment".equalsIgnoreCase(fieldName) || "experiment_DataSets.experiment".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, Experiment_DataSets entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.organization.Experiment_DataSets> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.organization.Experiment_DataSets> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<Experiment_DataSets> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<Experiment_DataSets> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<Experiment_DataSets> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
