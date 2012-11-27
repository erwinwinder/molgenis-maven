/* File:        org.molgenis/model/Experiment.java
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
import org.molgenis.organization.Experiment;

import org.molgenis.organization.Study;
import org.molgenis.observ.target.OntologyTerm;
import org.molgenis.observ.target.Panel;
import org.molgenis.organization.Experiment_AssayedPanels;
import org.molgenis.observ.DataSet;
import org.molgenis.organization.Experiment_DataSets;

public class ExperimentMapper extends AbstractJDBCMapper<Experiment>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends Experiment> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO Experiment (Identifier,Name,__Type,Study,Design,ExperimentType,TotalMarkersTested,TotalMarkersImported,Objective,Outcome,Comments,IndividualDataStatement,TimeCreated) VALUES ");
		{
		
			boolean first = true;
			for(Experiment e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
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
				//__Type
				if(e.get__Type() != null){
								
					sql.append("'"+this.escapeSql(e.get__Type().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//study
				if(e.getStudy_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getStudy_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//design
				if(e.getDesign() != null){
								
					sql.append("'"+this.escapeSql(e.getDesign().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//experimentType
				if(e.getExperimentType_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getExperimentType_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//totalMarkersTested
				if(e.getTotalMarkersTested() != null){
								
					sql.append("'"+this.escapeSql(e.getTotalMarkersTested().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//totalMarkersImported
				if(e.getTotalMarkersImported() != null){
								
					sql.append("'"+this.escapeSql(e.getTotalMarkersImported().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//objective
				if(e.getObjective() != null){
								
					sql.append("'"+this.escapeSql(e.getObjective().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//outcome
				if(e.getOutcome() != null){
								
					sql.append("'"+this.escapeSql(e.getOutcome().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//comments
				if(e.getComments() != null){
								
					sql.append("'"+this.escapeSql(e.getComments().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//individualDataStatement
				if(e.getIndividualDataStatement() != null){
								
					sql.append("'"+this.escapeSql(e.getIndividualDataStatement().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//timeCreated
				if(e.getTimeCreated() != null){
								
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String mysqlDateTime = dateFormat.format(e.getTimeCreated());
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
	public int executeUpdate(List<? extends Experiment> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO Experiment (id,Identifier,Name,__Type,Study,Design,ExperimentType,TotalMarkersTested,TotalMarkersImported,Objective,Outcome,Comments,IndividualDataStatement,TimeCreated) VALUES ");		
		boolean first = true;
		for(Experiment e: entities)
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
		
			//__Type
			//readonly placeholder for insert-clause to prohibit not "null" errors: will be ignored in update
			sql.append("'Experiment' ,");	
		
			//study


			if(e.getStudy_Id() != null){
                sql.append("'"+this.escapeSql(e.getStudy_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//design


			if(e.getDesign() != null){
                sql.append("'"+this.escapeSql(e.getDesign()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//experimentType


			if(e.getExperimentType_Id() != null){
                sql.append("'"+this.escapeSql(e.getExperimentType_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//totalMarkersTested


			if(e.getTotalMarkersTested() != null){
                sql.append("'"+this.escapeSql(e.getTotalMarkersTested()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//totalMarkersImported
			//readonly placeholder for insert-clause to prohibit not "null" errors: will be ignored in update
			sql.append("0 ,");	
		
			//objective


			if(e.getObjective() != null){
                sql.append("'"+this.escapeSql(e.getObjective()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//outcome


			if(e.getOutcome() != null){
                sql.append("'"+this.escapeSql(e.getOutcome()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//comments


			if(e.getComments() != null){
                sql.append("'"+this.escapeSql(e.getComments()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//individualDataStatement


			if(e.getIndividualDataStatement() != null){
                sql.append("'"+this.escapeSql(e.getIndividualDataStatement()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//timeCreated
			//readonly placeholder for insert-clause to prohibit not "null" errors: will be ignored in update
			sql.append("'"+new java.sql.Timestamp(e.getTimeCreated().getTime()).toString()+"'" +"");	
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE Study=VALUES(Study),Design=VALUES(Design),ExperimentType=VALUES(ExperimentType),TotalMarkersTested=VALUES(TotalMarkersTested),Objective=VALUES(Objective),Outcome=VALUES(Outcome),Comments=VALUES(Comments),IndividualDataStatement=VALUES(IndividualDataStatement),Identifier=VALUES(Identifier),Name=VALUES(Name),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends Experiment> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM Experiment WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(Experiment e: entities)
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
	
	public ExperimentMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT Experiment.id"
			+", Experiment.Identifier"
			+", Experiment.Name"
			+", Experiment.__Type"
			+", Experiment.Study"
			+", Experiment.Design"
			+", Experiment.ExperimentType"
			+", Experiment.TotalMarkersTested"
			+", Experiment.TotalMarkersImported"
			+", Experiment.Objective"
			+", Experiment.Outcome"
			+", Experiment.Comments"
			+", Experiment.IndividualDataStatement"
			+", Experiment.TimeCreated"
			//parent is SimpleTree(name='Study')
			+", xref_Study.Identifier AS Study_Identifier"
			//parent is SimpleTree(name='ExperimentType')
			+", xref_ExperimentType.Identifier AS ExperimentType_Identifier"
			+" FROM Experiment "

			
			//label for Study=Identifier
//path==Study. type==xref.
//path==Study_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Study AS xref_Study " 
			+" ON xref_Study.id = Experiment.Study"
			
			//label for ExperimentType=Identifier
//path==ExperimentType. type==xref.
//path==ExperimentType_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN OntologyTerm AS xref_ExperimentType " 
			+" ON xref_ExperimentType.id = Experiment.ExperimentType"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM Experiment "
			
			//label for Study=Identifier
//Study
//Study_Identifier
		   	+" LEFT JOIN Study AS xref_Study " 
			+" ON xref_Study.id = Experiment.Study"
			
			//label for ExperimentType=Identifier
//ExperimentType
//ExperimentType_Identifier
		   	+" LEFT JOIN OntologyTerm AS xref_ExperimentType " 
			+" ON xref_ExperimentType.id = Experiment.ExperimentType"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "Experiment.id";
		if("Experiment_id".equalsIgnoreCase(fieldName)) return "Experiment.id";
		if("Identifier".equalsIgnoreCase(fieldName)) return "Experiment.Identifier";
		if("Experiment_Identifier".equalsIgnoreCase(fieldName)) return "Experiment.Identifier";
		if("Name".equalsIgnoreCase(fieldName)) return "Experiment.Name";
		if("Experiment_Name".equalsIgnoreCase(fieldName)) return "Experiment.Name";
		if("__Type".equalsIgnoreCase(fieldName)) return "Experiment.__Type";
		if("Experiment___Type".equalsIgnoreCase(fieldName)) return "Experiment.__Type";
		if("Study".equalsIgnoreCase(fieldName)) return "Experiment.Study";
		if("Experiment_Study".equalsIgnoreCase(fieldName)) return "Experiment.Study";
		if("Design".equalsIgnoreCase(fieldName)) return "Experiment.Design";
		if("Experiment_Design".equalsIgnoreCase(fieldName)) return "Experiment.Design";
		if("ExperimentType".equalsIgnoreCase(fieldName)) return "Experiment.ExperimentType";
		if("Experiment_ExperimentType".equalsIgnoreCase(fieldName)) return "Experiment.ExperimentType";
		if("TotalMarkersTested".equalsIgnoreCase(fieldName)) return "Experiment.TotalMarkersTested";
		if("Experiment_TotalMarkersTested".equalsIgnoreCase(fieldName)) return "Experiment.TotalMarkersTested";
		if("TotalMarkersImported".equalsIgnoreCase(fieldName)) return "Experiment.TotalMarkersImported";
		if("Experiment_TotalMarkersImported".equalsIgnoreCase(fieldName)) return "Experiment.TotalMarkersImported";
		if("Objective".equalsIgnoreCase(fieldName)) return "Experiment.Objective";
		if("Experiment_Objective".equalsIgnoreCase(fieldName)) return "Experiment.Objective";
		if("Outcome".equalsIgnoreCase(fieldName)) return "Experiment.Outcome";
		if("Experiment_Outcome".equalsIgnoreCase(fieldName)) return "Experiment.Outcome";
		if("Comments".equalsIgnoreCase(fieldName)) return "Experiment.Comments";
		if("Experiment_Comments".equalsIgnoreCase(fieldName)) return "Experiment.Comments";
		if("IndividualDataStatement".equalsIgnoreCase(fieldName)) return "Experiment.IndividualDataStatement";
		if("Experiment_IndividualDataStatement".equalsIgnoreCase(fieldName)) return "Experiment.IndividualDataStatement";
		if("TimeCreated".equalsIgnoreCase(fieldName)) return "Experiment.TimeCreated";
		if("Experiment_TimeCreated".equalsIgnoreCase(fieldName)) return "Experiment.TimeCreated";
		if("Study_id".equalsIgnoreCase(fieldName)) return "Experiment.Study";
		if("Experiment_Study_id".equalsIgnoreCase(fieldName)) return "Experiment.Study";
		if("Study_Identifier".equalsIgnoreCase(fieldName)) return "xref_Study.Identifier";	
		if("Experiment_Study_Identifier".equalsIgnoreCase(fieldName)) return "xref_Study.Identifier";
		if("ExperimentType_id".equalsIgnoreCase(fieldName)) return "Experiment.ExperimentType";
		if("Experiment_ExperimentType_id".equalsIgnoreCase(fieldName)) return "Experiment.ExperimentType";
		if("ExperimentType_Identifier".equalsIgnoreCase(fieldName)) return "xref_ExperimentType.Identifier";	
		if("Experiment_ExperimentType_Identifier".equalsIgnoreCase(fieldName)) return "xref_ExperimentType.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.organization.Experiment> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.organization.Experiment>(size); 
	}			

	public org.molgenis.organization.Experiment create()
	{
		return new org.molgenis.organization.Experiment();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.organization.Experiment> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'study' to study.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> studyRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'experimentType' to ontologyTerm.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> experimentTypeRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'assayedPanels' to panel.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> assayedPanelsRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'dataSets' to dataSet.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> dataSetsRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.organization.Experiment object: entities)
		{
			//create xref/mref rule filtering Study on the label Identifier
			if(object.getStudy_Id() == null && object.getStudy_Identifier() != null)
			{
				Object label = object.getStudy_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !studyRules.containsKey(label))
					{
						studyRules.put(""+label, xrefFilter);
						studyRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering OntologyTerm on the label Identifier
			if(object.getExperimentType_Id() == null && object.getExperimentType_Identifier() != null)
			{
				Object label = object.getExperimentType_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !experimentTypeRules.containsKey(label))
					{
						experimentTypeRules.put(""+label, xrefFilter);
						experimentTypeRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering Panel on the label Identifier
			if(object.getAssayedPanels_Id().size() == 0 && object.getAssayedPanels_Identifier().size() > 0)
			{
				for(String label: object.getAssayedPanels_Identifier())
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !assayedPanelsRules.containsKey(label))
					{
						assayedPanelsRules.put(""+label, xrefFilter);
						assayedPanelsRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering DataSet on the label Identifier
			if(object.getDataSets_Id().size() == 0 && object.getDataSets_Identifier().size() > 0)
			{
				for(String label: object.getDataSets_Identifier())
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !dataSetsRules.containsKey(label))
					{
						dataSetsRules.put(""+label, xrefFilter);
						dataSetsRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
		}

		//resolve foreign key field 'study' to study.id using Identifier)
		final java.util.Map<String,Integer> study_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(studyRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.organization.Study> studyList = null;
			try
			{
				studyList = getDatabase().find(org.molgenis.organization.Study.class, studyRules.values().toArray(new org.molgenis.framework.db.QueryRule[studyRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.organization.Study xref :  studyList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				study_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'experimentType' to ontologyTerm.id using Identifier)
		final java.util.Map<String,Integer> experimentType_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(experimentTypeRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.observ.target.OntologyTerm> experimentTypeList = null;
			try
			{
				experimentTypeList = getDatabase().find(org.molgenis.observ.target.OntologyTerm.class, experimentTypeRules.values().toArray(new org.molgenis.framework.db.QueryRule[experimentTypeRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.observ.target.OntologyTerm xref :  experimentTypeList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				experimentType_Labels_to_IdMap.put(key, xref.getId());
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

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.organization.Experiment object = entities.get(i);		
			//update object using label fields Identifier
			if(object.getStudy_Id() == null )
			{
					String key = "";
					if(object.getStudy_Identifier() != null)
						key += 	object.getStudy_Identifier();
					
					if(!"".equals(key) && study_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Study_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setStudy_Id(study_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields Identifier
			if(object.getExperimentType_Id() == null )
			{
					String key = "";
					if(object.getExperimentType_Identifier() != null)
						key += 	object.getExperimentType_Identifier();
					
					if(!"".equals(key) && experimentType_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("ExperimentType_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setExperimentType_Id(experimentType_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields Identifier
			if(object.getAssayedPanels_Id() == null || object.getAssayedPanels_Id().size() == 0)
			{
				java.util.List<Integer> idList = new java.util.ArrayList<Integer>();
				for(int j = 0; j < object.getAssayedPanels_Identifier().size(); j++)
				{
					String key = "";
					if(object.getAssayedPanels_Identifier().get(j) != null)
						key += 	object.getAssayedPanels_Identifier().get(j);
					
					if(!"".equals(key) && assayedPanels_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("AssayedPanels_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						idList.add(assayedPanels_Labels_to_IdMap.get(key));
					}
				}
				object.setAssayedPanels_Id(idList);
			}
			//update object using label fields Identifier
			if(object.getDataSets_Id() == null || object.getDataSets_Id().size() == 0)
			{
				java.util.List<Integer> idList = new java.util.ArrayList<Integer>();
				for(int j = 0; j < object.getDataSets_Identifier().size(); j++)
				{
					String key = "";
					if(object.getDataSets_Identifier().get(j) != null)
						key += 	object.getDataSets_Identifier().get(j);
					
					if(!"".equals(key) && dataSets_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("DataSets_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						idList.add(dataSets_Labels_to_IdMap.get(key));
					}
				}
				object.setDataSets_Id(idList);
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "experiment.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("identifier".equalsIgnoreCase(fieldName) || "experiment.identifier".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("name".equalsIgnoreCase(fieldName) || "experiment.name".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("__Type".equalsIgnoreCase(fieldName) || "experiment.__Type".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.EnumField();
			if("study".equalsIgnoreCase(fieldName) || "experiment.study".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("design".equalsIgnoreCase(fieldName) || "experiment.design".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("experimentType".equalsIgnoreCase(fieldName) || "experiment.experimentType".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("totalMarkersTested".equalsIgnoreCase(fieldName) || "experiment.totalMarkersTested".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("totalMarkersImported".equalsIgnoreCase(fieldName) || "experiment.totalMarkersImported".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("objective".equalsIgnoreCase(fieldName) || "experiment.objective".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("outcome".equalsIgnoreCase(fieldName) || "experiment.outcome".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("comments".equalsIgnoreCase(fieldName) || "experiment.comments".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("individualDataStatement".equalsIgnoreCase(fieldName) || "experiment.individualDataStatement".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("timeCreated".equalsIgnoreCase(fieldName) || "experiment.timeCreated".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.DatetimeField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, Experiment entity)
	{
		entity.setId(i);
	}
	
	@Override
	public QueryRule rewriteMrefRule(Database db, QueryRule rule) throws DatabaseException
	{
		if("AssayedPanels".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// Experiment_AssayedPanels
			List<Experiment_AssayedPanels> mref_mapping_entities = db.find(Experiment_AssayedPanels.class, new QueryRule(
					"AssayedPanels", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (Experiment_AssayedPanels mref : mref_mapping_entities) mref_ids.add(mref.getExperiment_Id());
				return new QueryRule("id", Operator.IN, mref_ids);
			}		
			else
			{
				// no records to be shown
				return new QueryRule("id", Operator.EQUALS, Integer.MIN_VALUE);
			}			
		}
		else if("AssayedPanels_Identifier".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// Experiment_AssayedPanels
			List<Experiment_AssayedPanels> mref_mapping_entities = db.find(Experiment_AssayedPanels.class, new QueryRule(
					"AssayedPanels_Identifier", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (Experiment_AssayedPanels mref : mref_mapping_entities) mref_ids.add(mref.getExperiment_Id());
				return new QueryRule("id", Operator.IN, mref_ids);
			}		
			else
			{
				// no records to be shown
				return new QueryRule("id", Operator.EQUALS, Integer.MIN_VALUE);
			}
		}
		else if("DataSets".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// Experiment_DataSets
			List<Experiment_DataSets> mref_mapping_entities = db.find(Experiment_DataSets.class, new QueryRule(
					"DataSets", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (Experiment_DataSets mref : mref_mapping_entities) mref_ids.add(mref.getExperiment_Id());
				return new QueryRule("id", Operator.IN, mref_ids);
			}		
			else
			{
				// no records to be shown
				return new QueryRule("id", Operator.EQUALS, Integer.MIN_VALUE);
			}			
		}
		else if("DataSets_Identifier".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// Experiment_DataSets
			List<Experiment_DataSets> mref_mapping_entities = db.find(Experiment_DataSets.class, new QueryRule(
					"DataSets_Identifier", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (Experiment_DataSets mref : mref_mapping_entities) mref_ids.add(mref.getExperiment_Id());
				return new QueryRule("id", Operator.IN, mref_ids);
			}		
			else
			{
				// no records to be shown
				return new QueryRule("id", Operator.EQUALS, Integer.MIN_VALUE);
			}
		}
		else
		{
			return rule;
		}
	}

//Generated by MapperFileAttachments.java.ftl
	public void prepareFileAttachements(java.util.List<org.molgenis.organization.Experiment> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.organization.Experiment> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<Experiment> entities ) throws DatabaseException			
	{
		try
		{
			//list the experiment ids to query
			List<Integer> experimentIds = new ArrayList<Integer>();
			for(Experiment entity: entities)
			{
				experimentIds.add(entity.getId());
			}
			
			//map the AssayedPanels mrefs
			List<Experiment_AssayedPanels> assayedPanels_mrefs = this.getDatabase().query(Experiment_AssayedPanels.class).in("Experiment", experimentIds).sortASC("autoid").find();
			Map<Integer,List<Integer>> assayedPanels_assayedPanels_map = new LinkedHashMap<Integer,List<Integer>>();
			Map<Integer,List<String>> assayedPanels_Identifier_map = new LinkedHashMap<Integer,List<String>>();
			
			for(Experiment_AssayedPanels ref: assayedPanels_mrefs)
			{
				if(assayedPanels_assayedPanels_map.get(ref.getExperiment_Id()) == null) assayedPanels_assayedPanels_map.put(ref.getExperiment_Id(),new ArrayList<Integer>()); 
				assayedPanels_assayedPanels_map.get(ref.getExperiment_Id()).add(ref.getAssayedPanels_Id());
				if(assayedPanels_Identifier_map.get(ref.getExperiment_Id()) == null)	assayedPanels_Identifier_map.put(ref.getExperiment_Id(),new ArrayList<String>());
				assayedPanels_Identifier_map.get(ref.getExperiment_Id()).add(ref.getAssayedPanels_Identifier());
			}
			//map the DataSets mrefs
			List<Experiment_DataSets> dataSets_mrefs = this.getDatabase().query(Experiment_DataSets.class).in("Experiment", experimentIds).sortASC("autoid").find();
			Map<Integer,List<Integer>> dataSets_dataSets_map = new LinkedHashMap<Integer,List<Integer>>();
			Map<Integer,List<String>> dataSets_Identifier_map = new LinkedHashMap<Integer,List<String>>();
			
			for(Experiment_DataSets ref: dataSets_mrefs)
			{
				if(dataSets_dataSets_map.get(ref.getExperiment_Id()) == null) dataSets_dataSets_map.put(ref.getExperiment_Id(),new ArrayList<Integer>()); 
				dataSets_dataSets_map.get(ref.getExperiment_Id()).add(ref.getDataSets_Id());
				if(dataSets_Identifier_map.get(ref.getExperiment_Id()) == null)	dataSets_Identifier_map.put(ref.getExperiment_Id(),new ArrayList<String>());
				dataSets_Identifier_map.get(ref.getExperiment_Id()).add(ref.getDataSets_Identifier());
			}
			
			//load the mapped data into the entities
			for(Experiment entity: entities)
			{
				Integer id = entity.getId();
				if(assayedPanels_assayedPanels_map.get(id) != null)
				{
					entity.setAssayedPanels_Id(assayedPanels_assayedPanels_map.get(id));
				}
				if(assayedPanels_Identifier_map.get(id) != null)
				{
					entity.setAssayedPanels_Identifier(assayedPanels_Identifier_map.get(id));
				}
				if(dataSets_dataSets_map.get(id) != null)
				{
					entity.setDataSets_Id(dataSets_dataSets_map.get(id));
				}
				if(dataSets_Identifier_map.get(id) != null)
				{
					entity.setDataSets_Identifier(dataSets_Identifier_map.get(id));
				}
			}
		} 
		catch(Exception e)
		{	
			throw new DatabaseException(e);
		}
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<Experiment> entities ) throws DatabaseException, IOException, ParseException	
	{
		//create an List of Experiment ids to query for
		List<Integer> entityIds = new ArrayList<Integer>(); 
		for (Experiment entity : entities) 
		{
			entityIds.add(entity.getId());		
		}
		
		//delete existing mrefs
		getDatabase().remove(getDatabase().query( Experiment_AssayedPanels.class).in("Experiment", entityIds).find());
		List<Experiment_AssayedPanels> experiment_AssayedPanelsToAdd = new ArrayList<Experiment_AssayedPanels>();

		//delete existing mrefs
		getDatabase().remove(getDatabase().query( Experiment_DataSets.class).in("Experiment", entityIds).find());
		List<Experiment_DataSets> experiment_DataSetsToAdd = new ArrayList<Experiment_DataSets>();


		//check for each mref what needs to be added
		for(Experiment entity: entities)
		{
			//remove duplicates using Set
			entity.setAssayedPanels(new ArrayList(new LinkedHashSet(entity.getAssayedPanels_Id())));
			for(Integer id: entity.getAssayedPanels_Id())
			{
				Experiment_AssayedPanels new_mref = new Experiment_AssayedPanels();
				new_mref.setExperiment( entity.getId() );
				new_mref.setAssayedPanels( id );
				experiment_AssayedPanelsToAdd.add(new_mref);
			}
			
			//remove duplicates using Set
			entity.setDataSets(new ArrayList(new LinkedHashSet(entity.getDataSets_Id())));
			for(Integer id: entity.getDataSets_Id())
			{
				Experiment_DataSets new_mref = new Experiment_DataSets();
				new_mref.setExperiment( entity.getId() );
				new_mref.setDataSets( id );
				experiment_DataSetsToAdd.add(new_mref);
			}
			
		}
		
		//process changes to Experiment_AssayedPanels
		getDatabase().add( experiment_AssayedPanelsToAdd );
		//process changes to Experiment_DataSets
		getDatabase().add( experiment_DataSetsToAdd );
	}
		
	
	public void removeMrefs( List<Experiment> entities ) throws DatabaseException, IOException, ParseException
	{
		//create an list of Experiment ids to query for
		List<Integer> entityIds = new ArrayList<Integer>(); 
		for (Experiment entity : entities) 
		{
			entityIds.add(entity.getId());		
		}	
	
		//remove all Experiment_AssayedPanels elements for field entity.AssayedPanels
		getDatabase().remove( getDatabase().query( Experiment_AssayedPanels.class).in("Experiment", entityIds).find() );
		//remove all Experiment_DataSets elements for field entity.DataSets
		getDatabase().remove( getDatabase().query( Experiment_DataSets.class).in("Experiment", entityIds).find() );
	}	
}
