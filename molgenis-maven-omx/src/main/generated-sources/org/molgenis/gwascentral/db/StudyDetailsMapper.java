/* File:        org.molgenis.omx/model/StudyDetails.java
 * Copyright:   GBIC 2000-2013, all rights reserved
 * Date:        January 2, 2013
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
import org.molgenis.gwascentral.StudyDetails;

import org.molgenis.organization.Study;
import org.molgenis.organization.Citation;
import org.molgenis.organization.Citation;
import org.molgenis.gwascentral.StudyDetails_OtherCitations;

public class StudyDetailsMapper extends AbstractJDBCMapper<StudyDetails>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends StudyDetails> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO StudyDetails (Study,Title,ShortName,StudyAbstract,Version,Background,Objectives,KeyResults,Conclusions,StudyDesign,StudySizeReason,StudyPower,SourcesOfBias,Limitations,Acknowledgements,primaryCitation,Accession) VALUES ");
		{
		
			boolean first = true;
			for(StudyDetails e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//study
				if(e.getStudy_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getStudy_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//title
				if(e.getTitle() != null){
								
					sql.append("'"+this.escapeSql(e.getTitle().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//shortName
				if(e.getShortName() != null){
								
					sql.append("'"+this.escapeSql(e.getShortName().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//studyAbstract
				if(e.getStudyAbstract() != null){
								
					sql.append("'"+this.escapeSql(e.getStudyAbstract().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//version
				if(e.getVersion() != null){
								
					sql.append("'"+this.escapeSql(e.getVersion().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//background
				if(e.getBackground() != null){
								
					sql.append("'"+this.escapeSql(e.getBackground().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//objectives
				if(e.getObjectives() != null){
								
					sql.append("'"+this.escapeSql(e.getObjectives().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//keyResults
				if(e.getKeyResults() != null){
								
					sql.append("'"+this.escapeSql(e.getKeyResults().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//conclusions
				if(e.getConclusions() != null){
								
					sql.append("'"+this.escapeSql(e.getConclusions().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//studyDesign
				if(e.getStudyDesign() != null){
								
					sql.append("'"+this.escapeSql(e.getStudyDesign().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//studySizeReason
				if(e.getStudySizeReason() != null){
								
					sql.append("'"+this.escapeSql(e.getStudySizeReason().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//studyPower
				if(e.getStudyPower() != null){
								
					sql.append("'"+this.escapeSql(e.getStudyPower().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//sourcesOfBias
				if(e.getSourcesOfBias() != null){
								
					sql.append("'"+this.escapeSql(e.getSourcesOfBias().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//limitations
				if(e.getLimitations() != null){
								
					sql.append("'"+this.escapeSql(e.getLimitations().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//acknowledgements
				if(e.getAcknowledgements() != null){
								
					sql.append("'"+this.escapeSql(e.getAcknowledgements().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//primaryCitation
				if(e.getPrimaryCitation_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getPrimaryCitation_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//accession
				if(e.getAccession() != null){
								
					sql.append("'"+this.escapeSql(e.getAccession().toString())+"'"
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
	public int executeUpdate(List<? extends StudyDetails> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO StudyDetails (id,Study,Title,ShortName,StudyAbstract,Version,Background,Objectives,KeyResults,Conclusions,StudyDesign,StudySizeReason,StudyPower,SourcesOfBias,Limitations,Acknowledgements,primaryCitation,Accession) VALUES ");		
		boolean first = true;
		for(StudyDetails e: entities)
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
		
			//study


			if(e.getStudy_Id() != null){
                sql.append("'"+this.escapeSql(e.getStudy_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//title


			if(e.getTitle() != null){
                sql.append("'"+this.escapeSql(e.getTitle()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//shortName


			if(e.getShortName() != null){
                sql.append("'"+this.escapeSql(e.getShortName()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//studyAbstract


			if(e.getStudyAbstract() != null){
                sql.append("'"+this.escapeSql(e.getStudyAbstract()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//version


			if(e.getVersion() != null){
                sql.append("'"+this.escapeSql(e.getVersion()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//background


			if(e.getBackground() != null){
                sql.append("'"+this.escapeSql(e.getBackground()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//objectives


			if(e.getObjectives() != null){
                sql.append("'"+this.escapeSql(e.getObjectives()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//keyResults


			if(e.getKeyResults() != null){
                sql.append("'"+this.escapeSql(e.getKeyResults()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//conclusions


			if(e.getConclusions() != null){
                sql.append("'"+this.escapeSql(e.getConclusions()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//studyDesign


			if(e.getStudyDesign() != null){
                sql.append("'"+this.escapeSql(e.getStudyDesign()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//studySizeReason


			if(e.getStudySizeReason() != null){
                sql.append("'"+this.escapeSql(e.getStudySizeReason()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//studyPower


			if(e.getStudyPower() != null){
                sql.append("'"+this.escapeSql(e.getStudyPower()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//sourcesOfBias


			if(e.getSourcesOfBias() != null){
                sql.append("'"+this.escapeSql(e.getSourcesOfBias()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//limitations


			if(e.getLimitations() != null){
                sql.append("'"+this.escapeSql(e.getLimitations()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//acknowledgements


			if(e.getAcknowledgements() != null){
                sql.append("'"+this.escapeSql(e.getAcknowledgements()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//primaryCitation


			if(e.getPrimaryCitation_Id() != null){
                sql.append("'"+this.escapeSql(e.getPrimaryCitation_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//accession


			if(e.getAccession() != null){
                sql.append("'"+this.escapeSql(e.getAccession()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE Study=VALUES(Study),Title=VALUES(Title),ShortName=VALUES(ShortName),StudyAbstract=VALUES(StudyAbstract),Version=VALUES(Version),Background=VALUES(Background),Objectives=VALUES(Objectives),KeyResults=VALUES(KeyResults),Conclusions=VALUES(Conclusions),StudyDesign=VALUES(StudyDesign),StudySizeReason=VALUES(StudySizeReason),StudyPower=VALUES(StudyPower),SourcesOfBias=VALUES(SourcesOfBias),Limitations=VALUES(Limitations),Acknowledgements=VALUES(Acknowledgements),primaryCitation=VALUES(primaryCitation),Accession=VALUES(Accession),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends StudyDetails> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM StudyDetails WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(StudyDetails e: entities)
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
	
	public StudyDetailsMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT StudyDetails.id"
			+", StudyDetails.Study"
			+", StudyDetails.Title"
			+", StudyDetails.ShortName"
			+", StudyDetails.StudyAbstract"
			+", StudyDetails.Version"
			+", StudyDetails.Background"
			+", StudyDetails.Objectives"
			+", StudyDetails.KeyResults"
			+", StudyDetails.Conclusions"
			+", StudyDetails.StudyDesign"
			+", StudyDetails.StudySizeReason"
			+", StudyDetails.StudyPower"
			+", StudyDetails.SourcesOfBias"
			+", StudyDetails.Limitations"
			+", StudyDetails.Acknowledgements"
			+", StudyDetails.primaryCitation"
			+", StudyDetails.Accession"
			//parent is SimpleTree(name='Study')
			+", xref_Study.Identifier AS Study_Identifier"
			//parent is SimpleTree(name='primaryCitation')
			+", xref_primaryCitation.Identifier AS primaryCitation_Identifier"
			+" FROM StudyDetails "

			
			//label for Study=Identifier
//path==Study. type==xref.
//path==Study_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Study AS xref_Study " 
			+" ON xref_Study.id = StudyDetails.Study"
			
			//label for primaryCitation=Identifier
//path==primaryCitation. type==xref.
//path==primaryCitation_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Citation AS xref_primaryCitation " 
			+" ON xref_primaryCitation.id = StudyDetails.primaryCitation"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM StudyDetails "
			
			//label for Study=Identifier
//Study
//Study_Identifier
		   	+" LEFT JOIN Study AS xref_Study " 
			+" ON xref_Study.id = StudyDetails.Study"
			
			//label for primaryCitation=Identifier
//primaryCitation
//primaryCitation_Identifier
		   	+" LEFT JOIN Citation AS xref_primaryCitation " 
			+" ON xref_primaryCitation.id = StudyDetails.primaryCitation"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "StudyDetails.id";
		if("StudyDetails_id".equalsIgnoreCase(fieldName)) return "StudyDetails.id";
		if("Study".equalsIgnoreCase(fieldName)) return "StudyDetails.Study";
		if("StudyDetails_Study".equalsIgnoreCase(fieldName)) return "StudyDetails.Study";
		if("Title".equalsIgnoreCase(fieldName)) return "StudyDetails.Title";
		if("StudyDetails_Title".equalsIgnoreCase(fieldName)) return "StudyDetails.Title";
		if("ShortName".equalsIgnoreCase(fieldName)) return "StudyDetails.ShortName";
		if("StudyDetails_ShortName".equalsIgnoreCase(fieldName)) return "StudyDetails.ShortName";
		if("StudyAbstract".equalsIgnoreCase(fieldName)) return "StudyDetails.StudyAbstract";
		if("StudyDetails_StudyAbstract".equalsIgnoreCase(fieldName)) return "StudyDetails.StudyAbstract";
		if("Version".equalsIgnoreCase(fieldName)) return "StudyDetails.Version";
		if("StudyDetails_Version".equalsIgnoreCase(fieldName)) return "StudyDetails.Version";
		if("Background".equalsIgnoreCase(fieldName)) return "StudyDetails.Background";
		if("StudyDetails_Background".equalsIgnoreCase(fieldName)) return "StudyDetails.Background";
		if("Objectives".equalsIgnoreCase(fieldName)) return "StudyDetails.Objectives";
		if("StudyDetails_Objectives".equalsIgnoreCase(fieldName)) return "StudyDetails.Objectives";
		if("KeyResults".equalsIgnoreCase(fieldName)) return "StudyDetails.KeyResults";
		if("StudyDetails_KeyResults".equalsIgnoreCase(fieldName)) return "StudyDetails.KeyResults";
		if("Conclusions".equalsIgnoreCase(fieldName)) return "StudyDetails.Conclusions";
		if("StudyDetails_Conclusions".equalsIgnoreCase(fieldName)) return "StudyDetails.Conclusions";
		if("StudyDesign".equalsIgnoreCase(fieldName)) return "StudyDetails.StudyDesign";
		if("StudyDetails_StudyDesign".equalsIgnoreCase(fieldName)) return "StudyDetails.StudyDesign";
		if("StudySizeReason".equalsIgnoreCase(fieldName)) return "StudyDetails.StudySizeReason";
		if("StudyDetails_StudySizeReason".equalsIgnoreCase(fieldName)) return "StudyDetails.StudySizeReason";
		if("StudyPower".equalsIgnoreCase(fieldName)) return "StudyDetails.StudyPower";
		if("StudyDetails_StudyPower".equalsIgnoreCase(fieldName)) return "StudyDetails.StudyPower";
		if("SourcesOfBias".equalsIgnoreCase(fieldName)) return "StudyDetails.SourcesOfBias";
		if("StudyDetails_SourcesOfBias".equalsIgnoreCase(fieldName)) return "StudyDetails.SourcesOfBias";
		if("Limitations".equalsIgnoreCase(fieldName)) return "StudyDetails.Limitations";
		if("StudyDetails_Limitations".equalsIgnoreCase(fieldName)) return "StudyDetails.Limitations";
		if("Acknowledgements".equalsIgnoreCase(fieldName)) return "StudyDetails.Acknowledgements";
		if("StudyDetails_Acknowledgements".equalsIgnoreCase(fieldName)) return "StudyDetails.Acknowledgements";
		if("primaryCitation".equalsIgnoreCase(fieldName)) return "StudyDetails.primaryCitation";
		if("StudyDetails_primaryCitation".equalsIgnoreCase(fieldName)) return "StudyDetails.primaryCitation";
		if("Accession".equalsIgnoreCase(fieldName)) return "StudyDetails.Accession";
		if("StudyDetails_Accession".equalsIgnoreCase(fieldName)) return "StudyDetails.Accession";
		if("Study_id".equalsIgnoreCase(fieldName)) return "StudyDetails.Study";
		if("StudyDetails_Study_id".equalsIgnoreCase(fieldName)) return "StudyDetails.Study";
		if("Study_Identifier".equalsIgnoreCase(fieldName)) return "xref_Study.Identifier";	
		if("StudyDetails_Study_Identifier".equalsIgnoreCase(fieldName)) return "xref_Study.Identifier";
		if("primaryCitation_id".equalsIgnoreCase(fieldName)) return "StudyDetails.primaryCitation";
		if("StudyDetails_primaryCitation_id".equalsIgnoreCase(fieldName)) return "StudyDetails.primaryCitation";
		if("primaryCitation_Identifier".equalsIgnoreCase(fieldName)) return "xref_primaryCitation.Identifier";	
		if("StudyDetails_primaryCitation_Identifier".equalsIgnoreCase(fieldName)) return "xref_primaryCitation.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.gwascentral.StudyDetails> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.gwascentral.StudyDetails>(size); 
	}			

	public org.molgenis.gwascentral.StudyDetails create()
	{
		return new org.molgenis.gwascentral.StudyDetails();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.gwascentral.StudyDetails> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'study' to study.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> studyRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'primaryCitation' to citation.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> primaryCitationRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'otherCitations' to citation.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> otherCitationsRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.gwascentral.StudyDetails object: entities)
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
			//create xref/mref rule filtering Citation on the label Identifier
			if(object.getPrimaryCitation_Id() == null && object.getPrimaryCitation_Identifier() != null)
			{
				Object label = object.getPrimaryCitation_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !primaryCitationRules.containsKey(label))
					{
						primaryCitationRules.put(""+label, xrefFilter);
						primaryCitationRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering Citation on the label Identifier
			if(object.getOtherCitations_Id().size() == 0 && object.getOtherCitations_Identifier().size() > 0)
			{
				for(String label: object.getOtherCitations_Identifier())
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
		//resolve foreign key field 'primaryCitation' to citation.id using Identifier)
		final java.util.Map<String,Integer> primaryCitation_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(primaryCitationRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.organization.Citation> primaryCitationList = null;
			try
			{
				primaryCitationList = getDatabase().find(org.molgenis.organization.Citation.class, primaryCitationRules.values().toArray(new org.molgenis.framework.db.QueryRule[primaryCitationRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.organization.Citation xref :  primaryCitationList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				primaryCitation_Labels_to_IdMap.put(key, xref.getId());
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
			org.molgenis.gwascentral.StudyDetails object = entities.get(i);		
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
			if(object.getPrimaryCitation_Id() == null )
			{
					String key = "";
					if(object.getPrimaryCitation_Identifier() != null)
						key += 	object.getPrimaryCitation_Identifier();
					
					if(!"".equals(key) && primaryCitation_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("primaryCitation_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setPrimaryCitation_Id(primaryCitation_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields Identifier
			if(object.getOtherCitations_Id() == null || object.getOtherCitations_Id().size() == 0)
			{
				java.util.List<Integer> idList = new java.util.ArrayList<Integer>();
				for(int j = 0; j < object.getOtherCitations_Identifier().size(); j++)
				{
					String key = "";
					if(object.getOtherCitations_Identifier().get(j) != null)
						key += 	object.getOtherCitations_Identifier().get(j);
					
					if(!"".equals(key) && otherCitations_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("otherCitations_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						idList.add(otherCitations_Labels_to_IdMap.get(key));
					}
				}
				object.setOtherCitations_Id(idList);
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "studyDetails.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("study".equalsIgnoreCase(fieldName) || "studyDetails.study".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("title".equalsIgnoreCase(fieldName) || "studyDetails.title".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("shortName".equalsIgnoreCase(fieldName) || "studyDetails.shortName".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("studyAbstract".equalsIgnoreCase(fieldName) || "studyDetails.studyAbstract".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("version".equalsIgnoreCase(fieldName) || "studyDetails.version".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("background".equalsIgnoreCase(fieldName) || "studyDetails.background".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("objectives".equalsIgnoreCase(fieldName) || "studyDetails.objectives".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("keyResults".equalsIgnoreCase(fieldName) || "studyDetails.keyResults".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("conclusions".equalsIgnoreCase(fieldName) || "studyDetails.conclusions".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("studyDesign".equalsIgnoreCase(fieldName) || "studyDetails.studyDesign".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("studySizeReason".equalsIgnoreCase(fieldName) || "studyDetails.studySizeReason".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("studyPower".equalsIgnoreCase(fieldName) || "studyDetails.studyPower".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("sourcesOfBias".equalsIgnoreCase(fieldName) || "studyDetails.sourcesOfBias".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("limitations".equalsIgnoreCase(fieldName) || "studyDetails.limitations".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("acknowledgements".equalsIgnoreCase(fieldName) || "studyDetails.acknowledgements".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("primaryCitation".equalsIgnoreCase(fieldName) || "studyDetails.primaryCitation".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("accession".equalsIgnoreCase(fieldName) || "studyDetails.accession".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.HyperlinkField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, StudyDetails entity)
	{
		entity.setId(i);
	}
	
	@Override
	public QueryRule rewriteMrefRule(Database db, QueryRule rule) throws DatabaseException
	{
		if("otherCitations".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// StudyDetails_otherCitations
			List<StudyDetails_OtherCitations> mref_mapping_entities = db.find(StudyDetails_OtherCitations.class, new QueryRule(
					"otherCitations", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (StudyDetails_OtherCitations mref : mref_mapping_entities) mref_ids.add(mref.getStudyDetails_Id());
				return new QueryRule("id", Operator.IN, mref_ids);
			}		
			else
			{
				// no records to be shown
				return new QueryRule("id", Operator.EQUALS, Integer.MIN_VALUE);
			}			
		}
		else if("otherCitations_Identifier".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// StudyDetails_otherCitations
			List<StudyDetails_OtherCitations> mref_mapping_entities = db.find(StudyDetails_OtherCitations.class, new QueryRule(
					"otherCitations_Identifier", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (StudyDetails_OtherCitations mref : mref_mapping_entities) mref_ids.add(mref.getStudyDetails_Id());
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
	public void prepareFileAttachements(java.util.List<org.molgenis.gwascentral.StudyDetails> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.gwascentral.StudyDetails> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<StudyDetails> entities ) throws DatabaseException			
	{
		try
		{
			//list the studyDetails ids to query
			List<Integer> studyDetailsIds = new ArrayList<Integer>();
			for(StudyDetails entity: entities)
			{
				studyDetailsIds.add(entity.getId());
			}
			
			//map the otherCitations mrefs
			List<StudyDetails_OtherCitations> otherCitations_mrefs = this.getDatabase().query(StudyDetails_OtherCitations.class).in("StudyDetails", studyDetailsIds).sortASC("autoid").find();
			Map<Integer,List<Integer>> otherCitations_otherCitations_map = new LinkedHashMap<Integer,List<Integer>>();
			Map<Integer,List<String>> otherCitations_Identifier_map = new LinkedHashMap<Integer,List<String>>();
			
			for(StudyDetails_OtherCitations ref: otherCitations_mrefs)
			{
				if(otherCitations_otherCitations_map.get(ref.getStudyDetails_Id()) == null) otherCitations_otherCitations_map.put(ref.getStudyDetails_Id(),new ArrayList<Integer>()); 
				otherCitations_otherCitations_map.get(ref.getStudyDetails_Id()).add(ref.getOtherCitations_Id());
				if(otherCitations_Identifier_map.get(ref.getStudyDetails_Id()) == null)	otherCitations_Identifier_map.put(ref.getStudyDetails_Id(),new ArrayList<String>());
				otherCitations_Identifier_map.get(ref.getStudyDetails_Id()).add(ref.getOtherCitations_Identifier());
			}
			
			//load the mapped data into the entities
			for(StudyDetails entity: entities)
			{
				Integer id = entity.getId();
				if(otherCitations_otherCitations_map.get(id) != null)
				{
					entity.setOtherCitations_Id(otherCitations_otherCitations_map.get(id));
				}
				if(otherCitations_Identifier_map.get(id) != null)
				{
					entity.setOtherCitations_Identifier(otherCitations_Identifier_map.get(id));
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
	public void storeMrefs( List<StudyDetails> entities ) throws DatabaseException, IOException, ParseException	
	{
		//create an List of StudyDetails ids to query for
		List<Integer> entityIds = new ArrayList<Integer>(); 
		for (StudyDetails entity : entities) 
		{
			entityIds.add(entity.getId());		
		}
		
		//delete existing mrefs
		getDatabase().remove(getDatabase().query( StudyDetails_OtherCitations.class).in("StudyDetails", entityIds).find());
		List<StudyDetails_OtherCitations> studyDetails_otherCitationsToAdd = new ArrayList<StudyDetails_OtherCitations>();


		//check for each mref what needs to be added
		for(StudyDetails entity: entities)
		{
			//remove duplicates using Set
			entity.setOtherCitations(new ArrayList(new LinkedHashSet(entity.getOtherCitations_Id())));
			for(Integer id: entity.getOtherCitations_Id())
			{
				StudyDetails_OtherCitations new_mref = new StudyDetails_OtherCitations();
				new_mref.setStudyDetails( entity.getId() );
				new_mref.setOtherCitations( id );
				studyDetails_otherCitationsToAdd.add(new_mref);
			}
			
		}
		
		//process changes to StudyDetails_otherCitations
		getDatabase().add( studyDetails_otherCitationsToAdd );
	}
		
	
	public void removeMrefs( List<StudyDetails> entities ) throws DatabaseException, IOException, ParseException
	{
		//create an list of StudyDetails ids to query for
		List<Integer> entityIds = new ArrayList<Integer>(); 
		for (StudyDetails entity : entities) 
		{
			entityIds.add(entity.getId());		
		}	
	
		//remove all StudyDetails_otherCitations elements for field entity.otherCitations
		getDatabase().remove( getDatabase().query( StudyDetails_OtherCitations.class).in("StudyDetails", entityIds).find() );
	}	
}
