/* File:        org.molgenis/model/Person.java
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
import org.molgenis.organization.Person;

import org.molgenis.organization.Institute;
import org.molgenis.organization.Institute;
import org.molgenis.organization.Person_AffiliateInstitutions;
import org.molgenis.observ.target.OntologyTerm;

public class PersonMapper extends AbstractJDBCMapper<Person>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends Person> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO Person (Name,Title,FirstName,MidInitials,LastName,Email,Phone,PrimaryAffilation,OrcidPersonReference) VALUES ");
		{
		
			boolean first = true;
			for(Person e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//name
				if(e.getName() != null){
								
					sql.append("'"+this.escapeSql(e.getName().toString())+"'"
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
				//firstName
				if(e.getFirstName() != null){
								
					sql.append("'"+this.escapeSql(e.getFirstName().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//midInitials
				if(e.getMidInitials() != null){
								
					sql.append("'"+this.escapeSql(e.getMidInitials().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//lastName
				if(e.getLastName() != null){
								
					sql.append("'"+this.escapeSql(e.getLastName().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//email
				if(e.getEmail() != null){
								
					sql.append("'"+this.escapeSql(e.getEmail().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//phone
				if(e.getPhone() != null){
								
					sql.append("'"+this.escapeSql(e.getPhone().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//primaryAffilation
				if(e.getPrimaryAffilation_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getPrimaryAffilation_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//orcidPersonReference
				if(e.getOrcidPersonReference_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getOrcidPersonReference_Id().toString())+"'"
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
	public int executeUpdate(List<? extends Person> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO Person (id,Name,Title,FirstName,MidInitials,LastName,Email,Phone,PrimaryAffilation,OrcidPersonReference) VALUES ");		
		boolean first = true;
		for(Person e: entities)
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
		
			//name


			if(e.getName() != null){
                sql.append("'"+this.escapeSql(e.getName()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//title


			if(e.getTitle() != null){
                sql.append("'"+this.escapeSql(e.getTitle()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//firstName


			if(e.getFirstName() != null){
                sql.append("'"+this.escapeSql(e.getFirstName()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//midInitials


			if(e.getMidInitials() != null){
                sql.append("'"+this.escapeSql(e.getMidInitials()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//lastName


			if(e.getLastName() != null){
                sql.append("'"+this.escapeSql(e.getLastName()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//email


			if(e.getEmail() != null){
                sql.append("'"+this.escapeSql(e.getEmail()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//phone


			if(e.getPhone() != null){
                sql.append("'"+this.escapeSql(e.getPhone()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//primaryAffilation


			if(e.getPrimaryAffilation_Id() != null){
                sql.append("'"+this.escapeSql(e.getPrimaryAffilation_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//orcidPersonReference


			if(e.getOrcidPersonReference_Id() != null){
                sql.append("'"+this.escapeSql(e.getOrcidPersonReference_Id()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE Name=VALUES(Name),Title=VALUES(Title),FirstName=VALUES(FirstName),MidInitials=VALUES(MidInitials),LastName=VALUES(LastName),Email=VALUES(Email),Phone=VALUES(Phone),PrimaryAffilation=VALUES(PrimaryAffilation),OrcidPersonReference=VALUES(OrcidPersonReference),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends Person> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM Person WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(Person e: entities)
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
	
	public PersonMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT Person.id"
			+", Person.Name"
			+", Person.Title"
			+", Person.FirstName"
			+", Person.MidInitials"
			+", Person.LastName"
			+", Person.Email"
			+", Person.Phone"
			+", Person.PrimaryAffilation"
			+", Person.OrcidPersonReference"
			//parent is SimpleTree(name='PrimaryAffilation')
			+", xref_PrimaryAffilation.name AS PrimaryAffilation_Name"
			//parent is SimpleTree(name='OrcidPersonReference')
			+", xref_OrcidPersonReference.Identifier AS OrcidPersonReference_Identifier"
			+" FROM Person "

			
			//label for PrimaryAffilation=name
//path==PrimaryAffilation. type==xref.
//path==PrimaryAffilation_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Institute AS xref_PrimaryAffilation " 
			+" ON xref_PrimaryAffilation.id = Person.PrimaryAffilation"
			
			//label for OrcidPersonReference=Identifier
//path==OrcidPersonReference. type==xref.
//path==OrcidPersonReference_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN OntologyTerm AS xref_OrcidPersonReference " 
			+" ON xref_OrcidPersonReference.id = Person.OrcidPersonReference"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM Person "
			
			//label for PrimaryAffilation=name
//PrimaryAffilation
//PrimaryAffilation_Name
		   	+" LEFT JOIN Institute AS xref_PrimaryAffilation " 
			+" ON xref_PrimaryAffilation.id = Person.PrimaryAffilation"
			
			//label for OrcidPersonReference=Identifier
//OrcidPersonReference
//OrcidPersonReference_Identifier
		   	+" LEFT JOIN OntologyTerm AS xref_OrcidPersonReference " 
			+" ON xref_OrcidPersonReference.id = Person.OrcidPersonReference"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "Person.id";
		if("Person_id".equalsIgnoreCase(fieldName)) return "Person.id";
		if("Name".equalsIgnoreCase(fieldName)) return "Person.Name";
		if("Person_Name".equalsIgnoreCase(fieldName)) return "Person.Name";
		if("Title".equalsIgnoreCase(fieldName)) return "Person.Title";
		if("Person_Title".equalsIgnoreCase(fieldName)) return "Person.Title";
		if("FirstName".equalsIgnoreCase(fieldName)) return "Person.FirstName";
		if("Person_FirstName".equalsIgnoreCase(fieldName)) return "Person.FirstName";
		if("MidInitials".equalsIgnoreCase(fieldName)) return "Person.MidInitials";
		if("Person_MidInitials".equalsIgnoreCase(fieldName)) return "Person.MidInitials";
		if("LastName".equalsIgnoreCase(fieldName)) return "Person.LastName";
		if("Person_LastName".equalsIgnoreCase(fieldName)) return "Person.LastName";
		if("Email".equalsIgnoreCase(fieldName)) return "Person.Email";
		if("Person_Email".equalsIgnoreCase(fieldName)) return "Person.Email";
		if("Phone".equalsIgnoreCase(fieldName)) return "Person.Phone";
		if("Person_Phone".equalsIgnoreCase(fieldName)) return "Person.Phone";
		if("PrimaryAffilation".equalsIgnoreCase(fieldName)) return "Person.PrimaryAffilation";
		if("Person_PrimaryAffilation".equalsIgnoreCase(fieldName)) return "Person.PrimaryAffilation";
		if("OrcidPersonReference".equalsIgnoreCase(fieldName)) return "Person.OrcidPersonReference";
		if("Person_OrcidPersonReference".equalsIgnoreCase(fieldName)) return "Person.OrcidPersonReference";
		if("PrimaryAffilation_id".equalsIgnoreCase(fieldName)) return "Person.PrimaryAffilation";
		if("Person_PrimaryAffilation_id".equalsIgnoreCase(fieldName)) return "Person.PrimaryAffilation";
		if("PrimaryAffilation_Name".equalsIgnoreCase(fieldName)) return "xref_PrimaryAffilation.name";	
		if("Person_PrimaryAffilation_Name".equalsIgnoreCase(fieldName)) return "xref_PrimaryAffilation.name";
		if("OrcidPersonReference_id".equalsIgnoreCase(fieldName)) return "Person.OrcidPersonReference";
		if("Person_OrcidPersonReference_id".equalsIgnoreCase(fieldName)) return "Person.OrcidPersonReference";
		if("OrcidPersonReference_Identifier".equalsIgnoreCase(fieldName)) return "xref_OrcidPersonReference.Identifier";	
		if("Person_OrcidPersonReference_Identifier".equalsIgnoreCase(fieldName)) return "xref_OrcidPersonReference.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.organization.Person> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.organization.Person>(size); 
	}			

	public org.molgenis.organization.Person create()
	{
		return new org.molgenis.organization.Person();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.organization.Person> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'primaryAffilation' to institute.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> primaryAffilationRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'affiliateInstitutions' to institute.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> affiliateInstitutionsRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'orcidPersonReference' to ontologyTerm.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> orcidPersonReferenceRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.organization.Person object: entities)
		{
			//create xref/mref rule filtering Institute on the label name
			if(object.getPrimaryAffilation_Id() == null && object.getPrimaryAffilation_Name() != null)
			{
				Object label = object.getPrimaryAffilation_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !primaryAffilationRules.containsKey(label))
					{
						primaryAffilationRules.put(""+label, xrefFilter);
						primaryAffilationRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering Institute on the label name
			if(object.getAffiliateInstitutions_Id().size() == 0 && object.getAffiliateInstitutions_Name().size() > 0)
			{
				for(String label: object.getAffiliateInstitutions_Name())
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !affiliateInstitutionsRules.containsKey(label))
					{
						affiliateInstitutionsRules.put(""+label, xrefFilter);
						affiliateInstitutionsRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering OntologyTerm on the label Identifier
			if(object.getOrcidPersonReference_Id() == null && object.getOrcidPersonReference_Identifier() != null)
			{
				Object label = object.getOrcidPersonReference_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !orcidPersonReferenceRules.containsKey(label))
					{
						orcidPersonReferenceRules.put(""+label, xrefFilter);
						orcidPersonReferenceRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
		}

		//resolve foreign key field 'primaryAffilation' to institute.id using name)
		final java.util.Map<String,Integer> primaryAffilation_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(primaryAffilationRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.organization.Institute> primaryAffilationList = null;
			try
			{
				primaryAffilationList = getDatabase().find(org.molgenis.organization.Institute.class, primaryAffilationRules.values().toArray(new org.molgenis.framework.db.QueryRule[primaryAffilationRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.organization.Institute xref :  primaryAffilationList)
			{
				String key = "";
				key += 	xref.getName();
				
				primaryAffilation_Labels_to_IdMap.put(key, xref.getId());
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
		//resolve foreign key field 'orcidPersonReference' to ontologyTerm.id using Identifier)
		final java.util.Map<String,Integer> orcidPersonReference_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(orcidPersonReferenceRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.observ.target.OntologyTerm> orcidPersonReferenceList = null;
			try
			{
				orcidPersonReferenceList = getDatabase().find(org.molgenis.observ.target.OntologyTerm.class, orcidPersonReferenceRules.values().toArray(new org.molgenis.framework.db.QueryRule[orcidPersonReferenceRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.observ.target.OntologyTerm xref :  orcidPersonReferenceList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				orcidPersonReference_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.organization.Person object = entities.get(i);		
			//update object using label fields name
			if(object.getPrimaryAffilation_Id() == null )
			{
					String key = "";
					if(object.getPrimaryAffilation_Name() != null)
						key += 	object.getPrimaryAffilation_Name();
					
					if(!"".equals(key) && primaryAffilation_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("PrimaryAffilation_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setPrimaryAffilation_Id(primaryAffilation_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields name
			if(object.getAffiliateInstitutions_Id() == null || object.getAffiliateInstitutions_Id().size() == 0)
			{
				java.util.List<Integer> idList = new java.util.ArrayList<Integer>();
				for(int j = 0; j < object.getAffiliateInstitutions_Name().size(); j++)
				{
					String key = "";
					if(object.getAffiliateInstitutions_Name().get(j) != null)
						key += 	object.getAffiliateInstitutions_Name().get(j);
					
					if(!"".equals(key) && affiliateInstitutions_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("AffiliateInstitutions_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						idList.add(affiliateInstitutions_Labels_to_IdMap.get(key));
					}
				}
				object.setAffiliateInstitutions_Id(idList);
			}
			//update object using label fields Identifier
			if(object.getOrcidPersonReference_Id() == null )
			{
					String key = "";
					if(object.getOrcidPersonReference_Identifier() != null)
						key += 	object.getOrcidPersonReference_Identifier();
					
					if(!"".equals(key) && orcidPersonReference_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("OrcidPersonReference_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setOrcidPersonReference_Id(orcidPersonReference_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "person.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("name".equalsIgnoreCase(fieldName) || "person.name".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("title".equalsIgnoreCase(fieldName) || "person.title".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("firstName".equalsIgnoreCase(fieldName) || "person.firstName".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("midInitials".equalsIgnoreCase(fieldName) || "person.midInitials".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("lastName".equalsIgnoreCase(fieldName) || "person.lastName".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("email".equalsIgnoreCase(fieldName) || "person.email".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.EmailField();
			if("phone".equalsIgnoreCase(fieldName) || "person.phone".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("primaryAffilation".equalsIgnoreCase(fieldName) || "person.primaryAffilation".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("orcidPersonReference".equalsIgnoreCase(fieldName) || "person.orcidPersonReference".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, Person entity)
	{
		entity.setId(i);
	}
	
	@Override
	public QueryRule rewriteMrefRule(Database db, QueryRule rule) throws DatabaseException
	{
		if("AffiliateInstitutions".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// Person_AffiliateInstitutions
			List<Person_AffiliateInstitutions> mref_mapping_entities = db.find(Person_AffiliateInstitutions.class, new QueryRule(
					"AffiliateInstitutions", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (Person_AffiliateInstitutions mref : mref_mapping_entities) mref_ids.add(mref.getPerson_Id());
				return new QueryRule("id", Operator.IN, mref_ids);
			}		
			else
			{
				// no records to be shown
				return new QueryRule("id", Operator.EQUALS, Integer.MIN_VALUE);
			}			
		}
		else if("AffiliateInstitutions_name".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// Person_AffiliateInstitutions
			List<Person_AffiliateInstitutions> mref_mapping_entities = db.find(Person_AffiliateInstitutions.class, new QueryRule(
					"AffiliateInstitutions_name", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (Person_AffiliateInstitutions mref : mref_mapping_entities) mref_ids.add(mref.getPerson_Id());
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
	public void prepareFileAttachements(java.util.List<org.molgenis.organization.Person> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.organization.Person> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<Person> entities ) throws DatabaseException			
	{
		try
		{
			//list the person ids to query
			List<Integer> personIds = new ArrayList<Integer>();
			for(Person entity: entities)
			{
				personIds.add(entity.getId());
			}
			
			//map the AffiliateInstitutions mrefs
			List<Person_AffiliateInstitutions> affiliateInstitutions_mrefs = this.getDatabase().query(Person_AffiliateInstitutions.class).in("Person", personIds).sortASC("autoid").find();
			Map<Integer,List<Integer>> affiliateInstitutions_affiliateInstitutions_map = new LinkedHashMap<Integer,List<Integer>>();
			Map<Integer,List<String>> affiliateInstitutions_name_map = new LinkedHashMap<Integer,List<String>>();
			
			for(Person_AffiliateInstitutions ref: affiliateInstitutions_mrefs)
			{
				if(affiliateInstitutions_affiliateInstitutions_map.get(ref.getPerson_Id()) == null) affiliateInstitutions_affiliateInstitutions_map.put(ref.getPerson_Id(),new ArrayList<Integer>()); 
				affiliateInstitutions_affiliateInstitutions_map.get(ref.getPerson_Id()).add(ref.getAffiliateInstitutions_Id());
				if(affiliateInstitutions_name_map.get(ref.getPerson_Id()) == null)	affiliateInstitutions_name_map.put(ref.getPerson_Id(),new ArrayList<String>());
				affiliateInstitutions_name_map.get(ref.getPerson_Id()).add(ref.getAffiliateInstitutions_Name());
			}
			
			//load the mapped data into the entities
			for(Person entity: entities)
			{
				Integer id = entity.getId();
				if(affiliateInstitutions_affiliateInstitutions_map.get(id) != null)
				{
					entity.setAffiliateInstitutions_Id(affiliateInstitutions_affiliateInstitutions_map.get(id));
				}
				if(affiliateInstitutions_name_map.get(id) != null)
				{
					entity.setAffiliateInstitutions_Name(affiliateInstitutions_name_map.get(id));
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
	public void storeMrefs( List<Person> entities ) throws DatabaseException, IOException, ParseException	
	{
		//create an List of Person ids to query for
		List<Integer> entityIds = new ArrayList<Integer>(); 
		for (Person entity : entities) 
		{
			entityIds.add(entity.getId());		
		}
		
		//delete existing mrefs
		getDatabase().remove(getDatabase().query( Person_AffiliateInstitutions.class).in("Person", entityIds).find());
		List<Person_AffiliateInstitutions> person_AffiliateInstitutionsToAdd = new ArrayList<Person_AffiliateInstitutions>();


		//check for each mref what needs to be added
		for(Person entity: entities)
		{
			//remove duplicates using Set
			entity.setAffiliateInstitutions(new ArrayList(new LinkedHashSet(entity.getAffiliateInstitutions_Id())));
			for(Integer id: entity.getAffiliateInstitutions_Id())
			{
				Person_AffiliateInstitutions new_mref = new Person_AffiliateInstitutions();
				new_mref.setPerson( entity.getId() );
				new_mref.setAffiliateInstitutions( id );
				person_AffiliateInstitutionsToAdd.add(new_mref);
			}
			
		}
		
		//process changes to Person_AffiliateInstitutions
		getDatabase().add( person_AffiliateInstitutionsToAdd );
	}
		
	
	public void removeMrefs( List<Person> entities ) throws DatabaseException, IOException, ParseException
	{
		//create an list of Person ids to query for
		List<Integer> entityIds = new ArrayList<Integer>(); 
		for (Person entity : entities) 
		{
			entityIds.add(entity.getId());		
		}	
	
		//remove all Person_AffiliateInstitutions elements for field entity.AffiliateInstitutions
		getDatabase().remove( getDatabase().query( Person_AffiliateInstitutions.class).in("Person", entityIds).find() );
	}	
}
