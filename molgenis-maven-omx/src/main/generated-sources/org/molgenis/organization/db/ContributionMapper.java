/* File:        org.molgenis.omx/model/Contribution.java
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
import org.molgenis.organization.Contribution;

import org.molgenis.organization.Person;
import org.molgenis.organization.Submission;

public class ContributionMapper extends AbstractJDBCMapper<Contribution>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends Contribution> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO Contribution (Identifier,Name,Researcher,Submission,IsSubmitter,IsAuthor,IsSource) VALUES ");
		{
		
			boolean first = true;
			for(Contribution e: entities)
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
				//researcher
				if(e.getResearcher_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getResearcher_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//submission
				if(e.getSubmission_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getSubmission_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//isSubmitter
				if(e.getIsSubmitter() != null){
								
					sql.append("'"+this.escapeSql(e.getIsSubmitter().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//isAuthor
				if(e.getIsAuthor() != null){
								
					sql.append("'"+this.escapeSql(e.getIsAuthor().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//isSource
				if(e.getIsSource() != null){
								
					sql.append("'"+this.escapeSql(e.getIsSource().toString())+"'"
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
	public int executeUpdate(List<? extends Contribution> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO Contribution (id,Identifier,Name,Researcher,Submission,IsSubmitter,IsAuthor,IsSource) VALUES ");		
		boolean first = true;
		for(Contribution e: entities)
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
		
			//researcher


			if(e.getResearcher_Id() != null){
                sql.append("'"+this.escapeSql(e.getResearcher_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//submission


			if(e.getSubmission_Id() != null){
                sql.append("'"+this.escapeSql(e.getSubmission_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//isSubmitter


			if(e.getIsSubmitter() != null){
                sql.append("'"+this.escapeSql(e.getIsSubmitter())+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//isAuthor


			if(e.getIsAuthor() != null){
                sql.append("'"+this.escapeSql(e.getIsAuthor())+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//isSource


			if(e.getIsSource() != null){
                sql.append("'"+this.escapeSql(e.getIsSource())+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE Researcher=VALUES(Researcher),Submission=VALUES(Submission),IsSubmitter=VALUES(IsSubmitter),IsAuthor=VALUES(IsAuthor),IsSource=VALUES(IsSource),Identifier=VALUES(Identifier),Name=VALUES(Name),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends Contribution> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM Contribution WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(Contribution e: entities)
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
	
	public ContributionMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT Contribution.id"
			+", Contribution.Identifier"
			+", Contribution.Name"
			+", Contribution.Researcher"
			+", Contribution.Submission"
			+", Contribution.IsSubmitter"
			+", Contribution.IsAuthor"
			+", Contribution.IsSource"
			//parent is SimpleTree(name='Researcher')
			+", xref_Researcher.Name AS Researcher_Name"
			//parent is SimpleTree(name='Submission')
			+", xref_Submission.Identifier AS Submission_Identifier"
			+" FROM Contribution "

			
			//label for Researcher=Name
//path==Researcher. type==xref.
//path==Researcher_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Person AS xref_Researcher " 
			+" ON xref_Researcher.id = Contribution.Researcher"
			
			//label for Submission=Identifier
//path==Submission. type==xref.
//path==Submission_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Submission AS xref_Submission " 
			+" ON xref_Submission.id = Contribution.Submission"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM Contribution "
			
			//label for Researcher=Name
//Researcher
//Researcher_Name
		   	+" LEFT JOIN Person AS xref_Researcher " 
			+" ON xref_Researcher.id = Contribution.Researcher"
			
			//label for Submission=Identifier
//Submission
//Submission_Identifier
		   	+" LEFT JOIN Submission AS xref_Submission " 
			+" ON xref_Submission.id = Contribution.Submission"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "Contribution.id";
		if("Contribution_id".equalsIgnoreCase(fieldName)) return "Contribution.id";
		if("Identifier".equalsIgnoreCase(fieldName)) return "Contribution.Identifier";
		if("Contribution_Identifier".equalsIgnoreCase(fieldName)) return "Contribution.Identifier";
		if("Name".equalsIgnoreCase(fieldName)) return "Contribution.Name";
		if("Contribution_Name".equalsIgnoreCase(fieldName)) return "Contribution.Name";
		if("Researcher".equalsIgnoreCase(fieldName)) return "Contribution.Researcher";
		if("Contribution_Researcher".equalsIgnoreCase(fieldName)) return "Contribution.Researcher";
		if("Submission".equalsIgnoreCase(fieldName)) return "Contribution.Submission";
		if("Contribution_Submission".equalsIgnoreCase(fieldName)) return "Contribution.Submission";
		if("IsSubmitter".equalsIgnoreCase(fieldName)) return "Contribution.IsSubmitter";
		if("Contribution_IsSubmitter".equalsIgnoreCase(fieldName)) return "Contribution.IsSubmitter";
		if("IsAuthor".equalsIgnoreCase(fieldName)) return "Contribution.IsAuthor";
		if("Contribution_IsAuthor".equalsIgnoreCase(fieldName)) return "Contribution.IsAuthor";
		if("IsSource".equalsIgnoreCase(fieldName)) return "Contribution.IsSource";
		if("Contribution_IsSource".equalsIgnoreCase(fieldName)) return "Contribution.IsSource";
		if("Researcher_id".equalsIgnoreCase(fieldName)) return "Contribution.Researcher";
		if("Contribution_Researcher_id".equalsIgnoreCase(fieldName)) return "Contribution.Researcher";
		if("Researcher_Name".equalsIgnoreCase(fieldName)) return "xref_Researcher.Name";	
		if("Contribution_Researcher_Name".equalsIgnoreCase(fieldName)) return "xref_Researcher.Name";
		if("Submission_id".equalsIgnoreCase(fieldName)) return "Contribution.Submission";
		if("Contribution_Submission_id".equalsIgnoreCase(fieldName)) return "Contribution.Submission";
		if("Submission_Identifier".equalsIgnoreCase(fieldName)) return "xref_Submission.Identifier";	
		if("Contribution_Submission_Identifier".equalsIgnoreCase(fieldName)) return "xref_Submission.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.organization.Contribution> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.organization.Contribution>(size); 
	}			

	public org.molgenis.organization.Contribution create()
	{
		return new org.molgenis.organization.Contribution();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.organization.Contribution> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'researcher' to person.id using Name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> researcherRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'submission' to submission.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> submissionRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.organization.Contribution object: entities)
		{
			//create xref/mref rule filtering Person on the label Name
			if(object.getResearcher_Id() == null && object.getResearcher_Name() != null)
			{
				Object label = object.getResearcher_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !researcherRules.containsKey(label))
					{
						researcherRules.put(""+label, xrefFilter);
						researcherRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering Submission on the label Identifier
			if(object.getSubmission_Id() == null && object.getSubmission_Identifier() != null)
			{
				Object label = object.getSubmission_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !submissionRules.containsKey(label))
					{
						submissionRules.put(""+label, xrefFilter);
						submissionRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
		}

		//resolve foreign key field 'researcher' to person.id using Name)
		final java.util.Map<String,Integer> researcher_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(researcherRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.organization.Person> researcherList = null;
			try
			{
				researcherList = getDatabase().find(org.molgenis.organization.Person.class, researcherRules.values().toArray(new org.molgenis.framework.db.QueryRule[researcherRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.organization.Person xref :  researcherList)
			{
				String key = "";
				key += 	xref.getName();
				
				researcher_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'submission' to submission.id using Identifier)
		final java.util.Map<String,Integer> submission_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(submissionRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.organization.Submission> submissionList = null;
			try
			{
				submissionList = getDatabase().find(org.molgenis.organization.Submission.class, submissionRules.values().toArray(new org.molgenis.framework.db.QueryRule[submissionRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.organization.Submission xref :  submissionList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				submission_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.organization.Contribution object = entities.get(i);		
			//update object using label fields Name
			if(object.getResearcher_Id() == null )
			{
					String key = "";
					if(object.getResearcher_Name() != null)
						key += 	object.getResearcher_Name();
					
					if(!"".equals(key) && researcher_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Researcher_Name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setResearcher_Id(researcher_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields Identifier
			if(object.getSubmission_Id() == null )
			{
					String key = "";
					if(object.getSubmission_Identifier() != null)
						key += 	object.getSubmission_Identifier();
					
					if(!"".equals(key) && submission_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Submission_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setSubmission_Id(submission_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "contribution.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("identifier".equalsIgnoreCase(fieldName) || "contribution.identifier".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("name".equalsIgnoreCase(fieldName) || "contribution.name".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("researcher".equalsIgnoreCase(fieldName) || "contribution.researcher".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("submission".equalsIgnoreCase(fieldName) || "contribution.submission".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("isSubmitter".equalsIgnoreCase(fieldName) || "contribution.isSubmitter".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.EnumField();
			if("isAuthor".equalsIgnoreCase(fieldName) || "contribution.isAuthor".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.EnumField();
			if("isSource".equalsIgnoreCase(fieldName) || "contribution.isSource".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.EnumField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, Contribution entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.organization.Contribution> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.organization.Contribution> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<Contribution> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<Contribution> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<Contribution> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
