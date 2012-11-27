/* File:        org.molgenis/model/Individual.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 26, 2012
 * Template:	MultiqueryMapperGen.java.ftl
 * generator:   org.molgenis.generators.db.MultiqueryMapperGen 4.0.0-testing
 *
 * Using "subclass per table" strategy
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.observ.target.db;

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
import org.molgenis.observ.target.Individual;

import org.molgenis.observ.ObservationTarget;
import org.molgenis.observ.db.ObservationTargetMapper;
import org.molgenis.observ.target.Individual;
import org.molgenis.observ.target.Individual;

public class IndividualMapper extends AbstractJDBCMapper<Individual>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends Individual> entities) throws DatabaseException
	{	
		//add superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.ObservationTarget.class).executeAdd(entities);
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO Individual (Mother,Father,id) VALUES ");
		{
		
			boolean first = true;
			for(Individual e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//mother
				if(e.getMother_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getMother_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//father
				if(e.getFather_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getFather_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//id
				if(e.getId() != null){
								
					sql.append("'"+this.escapeSql(e.getId().toString())+"'"
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
	public int executeUpdate(List<? extends Individual> entities) throws DatabaseException
	{
		//update superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.ObservationTarget.class).executeUpdate(entities);
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO Individual (Mother,Father,id) VALUES ");		
		boolean first = true;
		for(Individual e: entities)
		{
			// put the ,
			if(first)
				first = false;
			else
				sql.append(",");

			sql.append("(");
			
			//mother


			if(e.getMother_Id() != null){
                sql.append("'"+this.escapeSql(e.getMother_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//father


			if(e.getFather_Id() != null){
                sql.append("'"+this.escapeSql(e.getFather_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//id


			if(e.getId() != null){
                sql.append("'"+this.escapeSql(e.getId()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE Mother=VALUES(Mother),Father=VALUES(Father),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends Individual> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM Individual WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(Individual e: entities)
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
		//remove superclass after
		this.getDatabase().getMapperFor(org.molgenis.observ.ObservationTarget.class).executeRemove(entities);
		return rowsAffected;
	}
	
//Generated by MapperCommons.subclass_per_table.java.ftl
	
	public IndividualMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT Individual.id"
			+", Characteristic.Identifier"
			+", Characteristic.Name"
			+", Characteristic.__Type"
			+", Characteristic.description"
			+", Individual.Mother"
			+", Individual.Father"
			//parent is SimpleTree(name='Mother')
			+", xref_Mother.Identifier AS Mother_Identifier"
			//parent is SimpleTree(name='Father')
			+", xref_Father.Identifier AS Father_Identifier"
			+" FROM Individual "
			+" INNER JOIN ObservationTarget ON (Individual.id = ObservationTarget.id)"
			+" INNER JOIN Characteristic ON (Individual.id = Characteristic.id)"

			
			//label for Mother=Identifier
//path==Mother. type==xref.
//path==Mother_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Characteristic AS xref_Mother " 
			+" ON xref_Mother.id = Individual.Mother"
			
			//label for Father=Identifier
//path==Father. type==xref.
//path==Father_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Characteristic AS xref_Father " 
			+" ON xref_Father.id = Individual.Father"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM Individual "
			  +" INNER JOIN ObservationTarget ON (Individual.id = ObservationTarget.id)"
			  +" INNER JOIN Characteristic ON (Individual.id = Characteristic.id)"
			
			//label for Mother=Identifier
//Mother
//Mother_Identifier
		   	+" LEFT JOIN Characteristic AS xref_Mother " 
			+" ON xref_Mother.id = Individual.Mother"
			
			//label for Father=Identifier
//Father
//Father_Identifier
		   	+" LEFT JOIN Characteristic AS xref_Father " 
			+" ON xref_Father.id = Individual.Father"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "Individual.id";
		if("Individual_id".equalsIgnoreCase(fieldName)) return "Individual.id";
		if("Identifier".equalsIgnoreCase(fieldName)) return "Characteristic.Identifier";
		if("Individual_Identifier".equalsIgnoreCase(fieldName)) return "Characteristic.Identifier";
		if("Name".equalsIgnoreCase(fieldName)) return "Characteristic.Name";
		if("Individual_Name".equalsIgnoreCase(fieldName)) return "Characteristic.Name";
		if("__Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("Individual___Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("description".equalsIgnoreCase(fieldName)) return "Characteristic.description";
		if("Individual_description".equalsIgnoreCase(fieldName)) return "Characteristic.description";
		if("Mother".equalsIgnoreCase(fieldName)) return "Individual.Mother";
		if("Individual_Mother".equalsIgnoreCase(fieldName)) return "Individual.Mother";
		if("Father".equalsIgnoreCase(fieldName)) return "Individual.Father";
		if("Individual_Father".equalsIgnoreCase(fieldName)) return "Individual.Father";
		if("Mother_id".equalsIgnoreCase(fieldName)) return "Individual.Mother";
		if("Individual_Mother_id".equalsIgnoreCase(fieldName)) return "Individual.Mother";
		if("Mother_Identifier".equalsIgnoreCase(fieldName)) return "xref_Mother.Identifier";	
		if("Individual_Mother_Identifier".equalsIgnoreCase(fieldName)) return "xref_Mother.Identifier";
		if("Father_id".equalsIgnoreCase(fieldName)) return "Individual.Father";
		if("Individual_Father_id".equalsIgnoreCase(fieldName)) return "Individual.Father";
		if("Father_Identifier".equalsIgnoreCase(fieldName)) return "xref_Father.Identifier";	
		if("Individual_Father_Identifier".equalsIgnoreCase(fieldName)) return "xref_Father.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.observ.target.Individual> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.observ.target.Individual>(size); 
	}			

	public org.molgenis.observ.target.Individual create()
	{
		return new org.molgenis.observ.target.Individual();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.observ.target.Individual> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'mother' to individual.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> motherRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'father' to individual.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> fatherRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.observ.target.Individual object: entities)
		{
			//create xref/mref rule filtering Individual on the label Identifier
			if(object.getMother_Id() == null && object.getMother_Identifier() != null)
			{
				Object label = object.getMother_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !motherRules.containsKey(label))
					{
						motherRules.put(""+label, xrefFilter);
						motherRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering Individual on the label Identifier
			if(object.getFather_Id() == null && object.getFather_Identifier() != null)
			{
				Object label = object.getFather_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !fatherRules.containsKey(label))
					{
						fatherRules.put(""+label, xrefFilter);
						fatherRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
		}

		//resolve foreign key field 'mother' to individual.id using Identifier)
		final java.util.Map<String,Integer> mother_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(motherRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.observ.target.Individual> motherList = null;
			try
			{
				motherList = getDatabase().find(org.molgenis.observ.target.Individual.class, motherRules.values().toArray(new org.molgenis.framework.db.QueryRule[motherRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.observ.target.Individual xref :  motherList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				mother_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'father' to individual.id using Identifier)
		final java.util.Map<String,Integer> father_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(fatherRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.observ.target.Individual> fatherList = null;
			try
			{
				fatherList = getDatabase().find(org.molgenis.observ.target.Individual.class, fatherRules.values().toArray(new org.molgenis.framework.db.QueryRule[fatherRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.observ.target.Individual xref :  fatherList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				father_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.observ.target.Individual object = entities.get(i);		
			//update object using label fields Identifier
			if(object.getMother_Id() == null )
			{
					String key = "";
					if(object.getMother_Identifier() != null)
						key += 	object.getMother_Identifier();
					
					if(!"".equals(key) && mother_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Mother_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setMother_Id(mother_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields Identifier
			if(object.getFather_Id() == null )
			{
					String key = "";
					if(object.getFather_Identifier() != null)
						key += 	object.getFather_Identifier();
					
					if(!"".equals(key) && father_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Father_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setFather_Id(father_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "individual.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("identifier".equalsIgnoreCase(fieldName) || "characteristic.identifier".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("name".equalsIgnoreCase(fieldName) || "characteristic.name".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("__Type".equalsIgnoreCase(fieldName) || "characteristic.__Type".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.EnumField();
			if("description".equalsIgnoreCase(fieldName) || "characteristic.description".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("mother".equalsIgnoreCase(fieldName) || "individual.mother".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("father".equalsIgnoreCase(fieldName) || "individual.father".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, Individual entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.observ.target.Individual> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.observ.target.Individual> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<Individual> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<Individual> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<Individual> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
