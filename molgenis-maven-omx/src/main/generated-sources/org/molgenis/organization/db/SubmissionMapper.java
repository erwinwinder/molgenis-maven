/* File:        org.molgenis/model/Submission.java
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
import org.molgenis.organization.Submission;

import org.molgenis.organization.Study;

public class SubmissionMapper extends AbstractJDBCMapper<Submission>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends Submission> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO Submission (Identifier,Name,TimeCreated,Study) VALUES ");
		{
		
			boolean first = true;
			for(Submission e: entities)
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
				//timeCreated
				if(e.getTimeCreated() != null){
								
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String mysqlDateTime = dateFormat.format(e.getTimeCreated());
					sql.append("'"+this.escapeSql(mysqlDateTime)+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//study
				if(e.getStudy_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getStudy_Id().toString())+"'"
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
	public int executeUpdate(List<? extends Submission> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO Submission (id,Identifier,Name,TimeCreated,Study) VALUES ");		
		boolean first = true;
		for(Submission e: entities)
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
		
			//timeCreated


			if(e.getTimeCreated() != null){
                sql.append("'"+new java.sql.Timestamp(e.getTimeCreated().getTime()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//study


			if(e.getStudy_Id() != null){
                sql.append("'"+this.escapeSql(e.getStudy_Id()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE TimeCreated=VALUES(TimeCreated),Study=VALUES(Study),Identifier=VALUES(Identifier),Name=VALUES(Name),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends Submission> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM Submission WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(Submission e: entities)
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
	
	public SubmissionMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT Submission.id"
			+", Submission.Identifier"
			+", Submission.Name"
			+", Submission.TimeCreated"
			+", Submission.Study"
			//parent is SimpleTree(name='Study')
			+", xref_Study.Identifier AS Study_Identifier"
			+" FROM Submission "

			
			//label for Study=Identifier
//path==Study. type==xref.
//path==Study_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Study AS xref_Study " 
			+" ON xref_Study.id = Submission.Study"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM Submission "
			
			//label for Study=Identifier
//Study
//Study_Identifier
		   	+" LEFT JOIN Study AS xref_Study " 
			+" ON xref_Study.id = Submission.Study"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "Submission.id";
		if("Submission_id".equalsIgnoreCase(fieldName)) return "Submission.id";
		if("Identifier".equalsIgnoreCase(fieldName)) return "Submission.Identifier";
		if("Submission_Identifier".equalsIgnoreCase(fieldName)) return "Submission.Identifier";
		if("Name".equalsIgnoreCase(fieldName)) return "Submission.Name";
		if("Submission_Name".equalsIgnoreCase(fieldName)) return "Submission.Name";
		if("TimeCreated".equalsIgnoreCase(fieldName)) return "Submission.TimeCreated";
		if("Submission_TimeCreated".equalsIgnoreCase(fieldName)) return "Submission.TimeCreated";
		if("Study".equalsIgnoreCase(fieldName)) return "Submission.Study";
		if("Submission_Study".equalsIgnoreCase(fieldName)) return "Submission.Study";
		if("Study_id".equalsIgnoreCase(fieldName)) return "Submission.Study";
		if("Submission_Study_id".equalsIgnoreCase(fieldName)) return "Submission.Study";
		if("Study_Identifier".equalsIgnoreCase(fieldName)) return "xref_Study.Identifier";	
		if("Submission_Study_Identifier".equalsIgnoreCase(fieldName)) return "xref_Study.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.organization.Submission> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.organization.Submission>(size); 
	}			

	public org.molgenis.organization.Submission create()
	{
		return new org.molgenis.organization.Submission();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.organization.Submission> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'study' to study.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> studyRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.organization.Submission object: entities)
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

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.organization.Submission object = entities.get(i);		
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
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "submission.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("identifier".equalsIgnoreCase(fieldName) || "submission.identifier".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("name".equalsIgnoreCase(fieldName) || "submission.name".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("timeCreated".equalsIgnoreCase(fieldName) || "submission.timeCreated".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.DatetimeField();
			if("study".equalsIgnoreCase(fieldName) || "submission.study".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, Submission entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.organization.Submission> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.organization.Submission> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<Submission> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<Submission> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<Submission> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
