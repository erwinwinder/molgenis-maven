/* File:        org.molgenis.omx/model/Person_AffiliateInstitutions.java
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
import org.molgenis.organization.Person_AffiliateInstitutions;

import org.molgenis.organization.Institute;
import org.molgenis.organization.Person;

public class Person_AffiliateInstitutionsMapper extends AbstractJDBCMapper<Person_AffiliateInstitutions>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends Person_AffiliateInstitutions> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO Person_AffiliateInstitutions (AffiliateInstitutions,Person) VALUES ");
		{
		
			boolean first = true;
			for(Person_AffiliateInstitutions e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//affiliateInstitutions
				if(e.getAffiliateInstitutions_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getAffiliateInstitutions_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//person
				if(e.getPerson_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getPerson_Id().toString())+"'"
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
	public int executeUpdate(List<? extends Person_AffiliateInstitutions> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO Person_AffiliateInstitutions (autoid,AffiliateInstitutions,Person) VALUES ");		
		boolean first = true;
		for(Person_AffiliateInstitutions e: entities)
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
		
			//affiliateInstitutions


			if(e.getAffiliateInstitutions_Id() != null){
                sql.append("'"+this.escapeSql(e.getAffiliateInstitutions_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//person


			if(e.getPerson_Id() != null){
                sql.append("'"+this.escapeSql(e.getPerson_Id()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE autoid=LAST_INSERT_ID(autoid),AffiliateInstitutions=VALUES(AffiliateInstitutions),Person=VALUES(Person)");

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
	public int executeRemove(List<? extends Person_AffiliateInstitutions> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM Person_AffiliateInstitutions WHERE ");
		
		//key $f_index: autoid
		{
			sql.append("autoid in (");
			boolean first = true;
			for(Person_AffiliateInstitutions e: entities)
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
	
	public Person_AffiliateInstitutionsMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT Person_AffiliateInstitutions.autoid"
			+", Person_AffiliateInstitutions.AffiliateInstitutions"
			+", Person_AffiliateInstitutions.Person"
			//parent is SimpleTree(name='AffiliateInstitutions')
			+", xref_AffiliateInstitutions.name AS AffiliateInstitutions_Name"
			//parent is SimpleTree(name='Person')
			+", xref_Person.Name AS Person_Name"
			+" FROM Person_AffiliateInstitutions "

			
			//label for AffiliateInstitutions=name
//path==AffiliateInstitutions. type==xref.
//path==AffiliateInstitutions_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Institute AS xref_AffiliateInstitutions " 
			+" ON xref_AffiliateInstitutions.id = Person_AffiliateInstitutions.AffiliateInstitutions"
			
			//label for Person=Name
//path==Person. type==xref.
//path==Person_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Person AS xref_Person " 
			+" ON xref_Person.id = Person_AffiliateInstitutions.Person"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM Person_AffiliateInstitutions "
			
			//label for AffiliateInstitutions=name
//AffiliateInstitutions
//AffiliateInstitutions_Name
		   	+" LEFT JOIN Institute AS xref_AffiliateInstitutions " 
			+" ON xref_AffiliateInstitutions.id = Person_AffiliateInstitutions.AffiliateInstitutions"
			
			//label for Person=Name
//Person
//Person_Name
		   	+" LEFT JOIN Person AS xref_Person " 
			+" ON xref_Person.id = Person_AffiliateInstitutions.Person"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("autoid".equalsIgnoreCase(fieldName)) return "Person_AffiliateInstitutions.autoid";
		if("Person_AffiliateInstitutions_autoid".equalsIgnoreCase(fieldName)) return "Person_AffiliateInstitutions.autoid";
		if("AffiliateInstitutions".equalsIgnoreCase(fieldName)) return "Person_AffiliateInstitutions.AffiliateInstitutions";
		if("Person_AffiliateInstitutions_AffiliateInstitutions".equalsIgnoreCase(fieldName)) return "Person_AffiliateInstitutions.AffiliateInstitutions";
		if("Person".equalsIgnoreCase(fieldName)) return "Person_AffiliateInstitutions.Person";
		if("Person_AffiliateInstitutions_Person".equalsIgnoreCase(fieldName)) return "Person_AffiliateInstitutions.Person";
		if("AffiliateInstitutions_id".equalsIgnoreCase(fieldName)) return "Person_AffiliateInstitutions.AffiliateInstitutions";
		if("Person_AffiliateInstitutions_AffiliateInstitutions_id".equalsIgnoreCase(fieldName)) return "Person_AffiliateInstitutions.AffiliateInstitutions";
		if("AffiliateInstitutions_Name".equalsIgnoreCase(fieldName)) return "xref_AffiliateInstitutions.name";	
		if("Person_AffiliateInstitutions_AffiliateInstitutions_Name".equalsIgnoreCase(fieldName)) return "xref_AffiliateInstitutions.name";
		if("Person_id".equalsIgnoreCase(fieldName)) return "Person_AffiliateInstitutions.Person";
		if("Person_AffiliateInstitutions_Person_id".equalsIgnoreCase(fieldName)) return "Person_AffiliateInstitutions.Person";
		if("Person_Name".equalsIgnoreCase(fieldName)) return "xref_Person.Name";	
		if("Person_AffiliateInstitutions_Person_Name".equalsIgnoreCase(fieldName)) return "xref_Person.Name";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.organization.Person_AffiliateInstitutions> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.organization.Person_AffiliateInstitutions>(size); 
	}			

	public org.molgenis.organization.Person_AffiliateInstitutions create()
	{
		return new org.molgenis.organization.Person_AffiliateInstitutions();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.organization.Person_AffiliateInstitutions> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'affiliateInstitutions' to institute.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> affiliateInstitutionsRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'person' to person.id using Name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> personRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.organization.Person_AffiliateInstitutions object: entities)
		{
			//create xref/mref rule filtering Institute on the label name
			if(object.getAffiliateInstitutions_Id() == null && object.getAffiliateInstitutions_Name() != null)
			{
				Object label = object.getAffiliateInstitutions_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !affiliateInstitutionsRules.containsKey(label))
					{
						affiliateInstitutionsRules.put(""+label, xrefFilter);
						affiliateInstitutionsRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering Person on the label Name
			if(object.getPerson_Id() == null && object.getPerson_Name() != null)
			{
				Object label = object.getPerson_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !personRules.containsKey(label))
					{
						personRules.put(""+label, xrefFilter);
						personRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
		}

		//resolve foreign key field 'affiliateInstitutions' to institute.id using name)
		final java.util.Map<String,Integer> affiliateInstitutions_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(affiliateInstitutionsRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.organization.Institute> affiliateInstitutionsList = null;
			try
			{
				affiliateInstitutionsList = getDatabase().find(org.molgenis.organization.Institute.class, affiliateInstitutionsRules.values().toArray(new org.molgenis.framework.db.QueryRule[affiliateInstitutionsRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.organization.Institute xref :  affiliateInstitutionsList)
			{
				String key = "";
				key += 	xref.getName();
				
				affiliateInstitutions_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'person' to person.id using Name)
		final java.util.Map<String,Integer> person_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(personRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.organization.Person> personList = null;
			try
			{
				personList = getDatabase().find(org.molgenis.organization.Person.class, personRules.values().toArray(new org.molgenis.framework.db.QueryRule[personRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.organization.Person xref :  personList)
			{
				String key = "";
				key += 	xref.getName();
				
				person_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.organization.Person_AffiliateInstitutions object = entities.get(i);		
			//update object using label fields name
			if(object.getAffiliateInstitutions_Id() == null )
			{
					String key = "";
					if(object.getAffiliateInstitutions_Name() != null)
						key += 	object.getAffiliateInstitutions_Name();
					
					if(!"".equals(key) && affiliateInstitutions_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("AffiliateInstitutions_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setAffiliateInstitutions_Id(affiliateInstitutions_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields Name
			if(object.getPerson_Id() == null )
			{
					String key = "";
					if(object.getPerson_Name() != null)
						key += 	object.getPerson_Name();
					
					if(!"".equals(key) && person_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Person_Name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setPerson_Id(person_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("autoid".equalsIgnoreCase(fieldName) || "person_AffiliateInstitutions.autoid".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("affiliateInstitutions".equalsIgnoreCase(fieldName) || "person_AffiliateInstitutions.affiliateInstitutions".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("person".equalsIgnoreCase(fieldName) || "person_AffiliateInstitutions.person".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, Person_AffiliateInstitutions entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.organization.Person_AffiliateInstitutions> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.organization.Person_AffiliateInstitutions> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<Person_AffiliateInstitutions> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<Person_AffiliateInstitutions> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<Person_AffiliateInstitutions> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
