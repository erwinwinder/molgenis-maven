/* File:        org.molgenis/model/StudyDetails_otherCitations.java
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
import org.molgenis.gwascentral.StudyDetails_OtherCitations;

import org.molgenis.organization.Citation;
import org.molgenis.gwascentral.StudyDetails;

public class StudyDetails_OtherCitationsMapper extends AbstractJDBCMapper<StudyDetails_OtherCitations>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends StudyDetails_OtherCitations> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO StudyDetails_otherCitations (otherCitations,StudyDetails) VALUES ");
		{
		
			boolean first = true;
			for(StudyDetails_OtherCitations e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//otherCitations
				if(e.getOtherCitations_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getOtherCitations_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//studyDetails
				if(e.getStudyDetails_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getStudyDetails_Id().toString())+"'"
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
	public int executeUpdate(List<? extends StudyDetails_OtherCitations> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO StudyDetails_otherCitations (autoid,otherCitations,StudyDetails) VALUES ");		
		boolean first = true;
		for(StudyDetails_OtherCitations e: entities)
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
		
			//otherCitations


			if(e.getOtherCitations_Id() != null){
                sql.append("'"+this.escapeSql(e.getOtherCitations_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//studyDetails


			if(e.getStudyDetails_Id() != null){
                sql.append("'"+this.escapeSql(e.getStudyDetails_Id()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE autoid=LAST_INSERT_ID(autoid),otherCitations=VALUES(otherCitations),StudyDetails=VALUES(StudyDetails)");

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
	public int executeRemove(List<? extends StudyDetails_OtherCitations> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM StudyDetails_otherCitations WHERE ");
		
		//key $f_index: autoid
		{
			sql.append("autoid in (");
			boolean first = true;
			for(StudyDetails_OtherCitations e: entities)
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
	
	public StudyDetails_OtherCitationsMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT StudyDetails_otherCitations.autoid"
			+", StudyDetails_otherCitations.otherCitations"
			+", StudyDetails_otherCitations.StudyDetails"
			//parent is SimpleTree(name='otherCitations')
			+", xref_otherCitations.Identifier AS otherCitations_Identifier"
			//parent is SimpleTree(name='StudyDetails')
			+", xref_StudyDetails.id AS StudyDetails_Id"
			+" FROM StudyDetails_otherCitations "

			
			//label for otherCitations=Identifier
//path==otherCitations. type==xref.
//path==otherCitations_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Citation AS xref_otherCitations " 
			+" ON xref_otherCitations.id = StudyDetails_otherCitations.otherCitations"
			
			//label for StudyDetails=id
//path==StudyDetails. type==xref.
//path==StudyDetails_Id. type==int.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN StudyDetails AS xref_StudyDetails " 
			+" ON xref_StudyDetails.id = StudyDetails_otherCitations.StudyDetails"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM StudyDetails_otherCitations "
			
			//label for otherCitations=Identifier
//otherCitations
//otherCitations_Identifier
		   	+" LEFT JOIN Citation AS xref_otherCitations " 
			+" ON xref_otherCitations.id = StudyDetails_otherCitations.otherCitations"
			
			//label for StudyDetails=id
//StudyDetails
//StudyDetails_Id
		   	+" LEFT JOIN StudyDetails AS xref_StudyDetails " 
			+" ON xref_StudyDetails.id = StudyDetails_otherCitations.StudyDetails"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("autoid".equalsIgnoreCase(fieldName)) return "StudyDetails_otherCitations.autoid";
		if("StudyDetails_otherCitations_autoid".equalsIgnoreCase(fieldName)) return "StudyDetails_otherCitations.autoid";
		if("otherCitations".equalsIgnoreCase(fieldName)) return "StudyDetails_otherCitations.otherCitations";
		if("StudyDetails_otherCitations_otherCitations".equalsIgnoreCase(fieldName)) return "StudyDetails_otherCitations.otherCitations";
		if("StudyDetails".equalsIgnoreCase(fieldName)) return "StudyDetails_otherCitations.StudyDetails";
		if("StudyDetails_otherCitations_StudyDetails".equalsIgnoreCase(fieldName)) return "StudyDetails_otherCitations.StudyDetails";
		if("otherCitations_id".equalsIgnoreCase(fieldName)) return "StudyDetails_otherCitations.otherCitations";
		if("StudyDetails_otherCitations_otherCitations_id".equalsIgnoreCase(fieldName)) return "StudyDetails_otherCitations.otherCitations";
		if("otherCitations_Identifier".equalsIgnoreCase(fieldName)) return "xref_otherCitations.Identifier";	
		if("StudyDetails_otherCitations_otherCitations_Identifier".equalsIgnoreCase(fieldName)) return "xref_otherCitations.Identifier";
		if("StudyDetails_id".equalsIgnoreCase(fieldName)) return "StudyDetails_otherCitations.StudyDetails";
		if("StudyDetails_otherCitations_StudyDetails_id".equalsIgnoreCase(fieldName)) return "StudyDetails_otherCitations.StudyDetails";
		if("StudyDetails_Id".equalsIgnoreCase(fieldName)) return "xref_StudyDetails.id";	
		if("StudyDetails_otherCitations_StudyDetails_Id".equalsIgnoreCase(fieldName)) return "xref_StudyDetails.id";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.gwascentral.StudyDetails_OtherCitations> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.gwascentral.StudyDetails_OtherCitations>(size); 
	}			

	public org.molgenis.gwascentral.StudyDetails_OtherCitations create()
	{
		return new org.molgenis.gwascentral.StudyDetails_OtherCitations();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.gwascentral.StudyDetails_OtherCitations> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'otherCitations' to citation.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> otherCitationsRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.gwascentral.StudyDetails_OtherCitations object: entities)
		{
			//create xref/mref rule filtering Citation on the label Identifier
			if(object.getOtherCitations_Id() == null && object.getOtherCitations_Identifier() != null)
			{
				Object label = object.getOtherCitations_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !otherCitationsRules.containsKey(label))
					{
						otherCitationsRules.put(""+label, xrefFilter);
						otherCitationsRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
		}

		//resolve foreign key field 'otherCitations' to citation.id using Identifier)
		final java.util.Map<String,Integer> otherCitations_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(otherCitationsRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.organization.Citation> otherCitationsList = null;
			try
			{
				otherCitationsList = getDatabase().find(org.molgenis.organization.Citation.class, otherCitationsRules.values().toArray(new org.molgenis.framework.db.QueryRule[otherCitationsRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.organization.Citation xref :  otherCitationsList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				otherCitations_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.gwascentral.StudyDetails_OtherCitations object = entities.get(i);		
			//update object using label fields Identifier
			if(object.getOtherCitations_Id() == null )
			{
					String key = "";
					if(object.getOtherCitations_Identifier() != null)
						key += 	object.getOtherCitations_Identifier();
					
					if(!"".equals(key) && otherCitations_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("otherCitations_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setOtherCitations_Id(otherCitations_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("autoid".equalsIgnoreCase(fieldName) || "studyDetails_otherCitations.autoid".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("otherCitations".equalsIgnoreCase(fieldName) || "studyDetails_otherCitations.otherCitations".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("studyDetails".equalsIgnoreCase(fieldName) || "studyDetails_otherCitations.studyDetails".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, StudyDetails_OtherCitations entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.gwascentral.StudyDetails_OtherCitations> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.gwascentral.StudyDetails_OtherCitations> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<StudyDetails_OtherCitations> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<StudyDetails_OtherCitations> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<StudyDetails_OtherCitations> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
