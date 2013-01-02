/* File:        org.molgenis.omx/model/Study.java
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
import org.molgenis.organization.Study;

import org.molgenis.organization.Person;
import org.molgenis.gwascentral.Investigation;

public class StudyMapper extends AbstractJDBCMapper<Study>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends Study> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO Study (Identifier,Name,Description,StartDate,UpdateDate,EndDate,Contact,PartOfInvestigation) VALUES ");
		{
		
			boolean first = true;
			for(Study e: entities)
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
				//description
				if(e.getDescription() != null){
								
					sql.append("'"+this.escapeSql(e.getDescription().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//startDate
				if(e.getStartDate() != null){
								
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String mysqlDateTime = dateFormat.format(e.getStartDate());
					sql.append("'"+this.escapeSql(mysqlDateTime)+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//updateDate
				if(e.getUpdateDate() != null){
								
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String mysqlDateTime = dateFormat.format(e.getUpdateDate());
					sql.append("'"+this.escapeSql(mysqlDateTime)+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//endDate
				if(e.getEndDate() != null){
								
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String mysqlDateTime = dateFormat.format(e.getEndDate());
					sql.append("'"+this.escapeSql(mysqlDateTime)+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//contact
				if(e.getContact_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getContact_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//partOfInvestigation
				if(e.getPartOfInvestigation_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getPartOfInvestigation_Id().toString())+"'"
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
	public int executeUpdate(List<? extends Study> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO Study (id,Identifier,Name,Description,StartDate,UpdateDate,EndDate,Contact,PartOfInvestigation) VALUES ");		
		boolean first = true;
		for(Study e: entities)
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
		
			//description


			if(e.getDescription() != null){
                sql.append("'"+this.escapeSql(e.getDescription()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//startDate


			if(e.getStartDate() != null){
                sql.append("'"+new java.sql.Timestamp(e.getStartDate().getTime()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//updateDate


			if(e.getUpdateDate() != null){
                sql.append("'"+new java.sql.Timestamp(e.getUpdateDate().getTime()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//endDate


			if(e.getEndDate() != null){
                sql.append("'"+new java.sql.Timestamp(e.getEndDate().getTime()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//contact


			if(e.getContact_Id() != null){
                sql.append("'"+this.escapeSql(e.getContact_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//partOfInvestigation


			if(e.getPartOfInvestigation_Id() != null){
                sql.append("'"+this.escapeSql(e.getPartOfInvestigation_Id()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE Description=VALUES(Description),StartDate=VALUES(StartDate),UpdateDate=VALUES(UpdateDate),EndDate=VALUES(EndDate),Contact=VALUES(Contact),PartOfInvestigation=VALUES(PartOfInvestigation),Identifier=VALUES(Identifier),Name=VALUES(Name),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends Study> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM Study WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(Study e: entities)
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
	
	public StudyMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT Study.id"
			+", Study.Identifier"
			+", Study.Name"
			+", Study.Description"
			+", Study.StartDate"
			+", Study.UpdateDate"
			+", Study.EndDate"
			+", Study.Contact"
			+", Study.PartOfInvestigation"
			//parent is SimpleTree(name='Contact')
			+", xref_Contact.Name AS Contact_Name"
			//parent is SimpleTree(name='PartOfInvestigation')
			+", xref_PartOfInvestigation.Identifier AS PartOfInvestigation_Identifier"
			+" FROM Study "

			
			//label for Contact=Name
//path==Contact. type==xref.
//path==Contact_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Person AS xref_Contact " 
			+" ON xref_Contact.id = Study.Contact"
			
			//label for PartOfInvestigation=Identifier
//path==PartOfInvestigation. type==xref.
//path==PartOfInvestigation_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Investigation AS xref_PartOfInvestigation " 
			+" ON xref_PartOfInvestigation.id = Study.PartOfInvestigation"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM Study "
			
			//label for Contact=Name
//Contact
//Contact_Name
		   	+" LEFT JOIN Person AS xref_Contact " 
			+" ON xref_Contact.id = Study.Contact"
			
			//label for PartOfInvestigation=Identifier
//PartOfInvestigation
//PartOfInvestigation_Identifier
		   	+" LEFT JOIN Investigation AS xref_PartOfInvestigation " 
			+" ON xref_PartOfInvestigation.id = Study.PartOfInvestigation"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "Study.id";
		if("Study_id".equalsIgnoreCase(fieldName)) return "Study.id";
		if("Identifier".equalsIgnoreCase(fieldName)) return "Study.Identifier";
		if("Study_Identifier".equalsIgnoreCase(fieldName)) return "Study.Identifier";
		if("Name".equalsIgnoreCase(fieldName)) return "Study.Name";
		if("Study_Name".equalsIgnoreCase(fieldName)) return "Study.Name";
		if("Description".equalsIgnoreCase(fieldName)) return "Study.Description";
		if("Study_Description".equalsIgnoreCase(fieldName)) return "Study.Description";
		if("StartDate".equalsIgnoreCase(fieldName)) return "Study.StartDate";
		if("Study_StartDate".equalsIgnoreCase(fieldName)) return "Study.StartDate";
		if("UpdateDate".equalsIgnoreCase(fieldName)) return "Study.UpdateDate";
		if("Study_UpdateDate".equalsIgnoreCase(fieldName)) return "Study.UpdateDate";
		if("EndDate".equalsIgnoreCase(fieldName)) return "Study.EndDate";
		if("Study_EndDate".equalsIgnoreCase(fieldName)) return "Study.EndDate";
		if("Contact".equalsIgnoreCase(fieldName)) return "Study.Contact";
		if("Study_Contact".equalsIgnoreCase(fieldName)) return "Study.Contact";
		if("PartOfInvestigation".equalsIgnoreCase(fieldName)) return "Study.PartOfInvestigation";
		if("Study_PartOfInvestigation".equalsIgnoreCase(fieldName)) return "Study.PartOfInvestigation";
		if("Contact_id".equalsIgnoreCase(fieldName)) return "Study.Contact";
		if("Study_Contact_id".equalsIgnoreCase(fieldName)) return "Study.Contact";
		if("Contact_Name".equalsIgnoreCase(fieldName)) return "xref_Contact.Name";	
		if("Study_Contact_Name".equalsIgnoreCase(fieldName)) return "xref_Contact.Name";
		if("PartOfInvestigation_id".equalsIgnoreCase(fieldName)) return "Study.PartOfInvestigation";
		if("Study_PartOfInvestigation_id".equalsIgnoreCase(fieldName)) return "Study.PartOfInvestigation";
		if("PartOfInvestigation_Identifier".equalsIgnoreCase(fieldName)) return "xref_PartOfInvestigation.Identifier";	
		if("Study_PartOfInvestigation_Identifier".equalsIgnoreCase(fieldName)) return "xref_PartOfInvestigation.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.organization.Study> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.organization.Study>(size); 
	}			

	public org.molgenis.organization.Study create()
	{
		return new org.molgenis.organization.Study();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.organization.Study> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'contact' to person.id using Name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> contactRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'partOfInvestigation' to investigation.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> partOfInvestigationRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.organization.Study object: entities)
		{
			//create xref/mref rule filtering Person on the label Name
			if(object.getContact_Id() == null && object.getContact_Name() != null)
			{
				Object label = object.getContact_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !contactRules.containsKey(label))
					{
						contactRules.put(""+label, xrefFilter);
						contactRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering Investigation on the label Identifier
			if(object.getPartOfInvestigation_Id() == null && object.getPartOfInvestigation_Identifier() != null)
			{
				Object label = object.getPartOfInvestigation_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !partOfInvestigationRules.containsKey(label))
					{
						partOfInvestigationRules.put(""+label, xrefFilter);
						partOfInvestigationRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
		}

		//resolve foreign key field 'contact' to person.id using Name)
		final java.util.Map<String,Integer> contact_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(contactRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.organization.Person> contactList = null;
			try
			{
				contactList = getDatabase().find(org.molgenis.organization.Person.class, contactRules.values().toArray(new org.molgenis.framework.db.QueryRule[contactRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.organization.Person xref :  contactList)
			{
				String key = "";
				key += 	xref.getName();
				
				contact_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'partOfInvestigation' to investigation.id using Identifier)
		final java.util.Map<String,Integer> partOfInvestigation_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(partOfInvestigationRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.gwascentral.Investigation> partOfInvestigationList = null;
			try
			{
				partOfInvestigationList = getDatabase().find(org.molgenis.gwascentral.Investigation.class, partOfInvestigationRules.values().toArray(new org.molgenis.framework.db.QueryRule[partOfInvestigationRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.gwascentral.Investigation xref :  partOfInvestigationList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				partOfInvestigation_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.organization.Study object = entities.get(i);		
			//update object using label fields Name
			if(object.getContact_Id() == null )
			{
					String key = "";
					if(object.getContact_Name() != null)
						key += 	object.getContact_Name();
					
					if(!"".equals(key) && contact_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Contact_Name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setContact_Id(contact_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields Identifier
			if(object.getPartOfInvestigation_Id() == null )
			{
					String key = "";
					if(object.getPartOfInvestigation_Identifier() != null)
						key += 	object.getPartOfInvestigation_Identifier();
					
					if(!"".equals(key) && partOfInvestigation_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("PartOfInvestigation_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setPartOfInvestigation_Id(partOfInvestigation_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "study.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("identifier".equalsIgnoreCase(fieldName) || "study.identifier".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("name".equalsIgnoreCase(fieldName) || "study.name".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("description".equalsIgnoreCase(fieldName) || "study.description".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("startDate".equalsIgnoreCase(fieldName) || "study.startDate".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.DatetimeField();
			if("updateDate".equalsIgnoreCase(fieldName) || "study.updateDate".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.DatetimeField();
			if("endDate".equalsIgnoreCase(fieldName) || "study.endDate".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.DatetimeField();
			if("contact".equalsIgnoreCase(fieldName) || "study.contact".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("partOfInvestigation".equalsIgnoreCase(fieldName) || "study.partOfInvestigation".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, Study entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.organization.Study> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.organization.Study> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<Study> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<Study> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<Study> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
