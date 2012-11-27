/* File:        org.molgenis/model/Species.java
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
import org.molgenis.observ.target.Species;

import org.molgenis.observ.target.OntologyTerm;
import org.molgenis.observ.target.db.OntologyTermMapper;
import org.molgenis.observ.target.Ontology;

public class SpeciesMapper extends AbstractJDBCMapper<Species>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends Species> entities) throws DatabaseException
	{	
		//add superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.target.OntologyTerm.class).executeAdd(entities);
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO Species (id) VALUES ");
		{
		
			boolean first = true;
			for(Species e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
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
	public int executeUpdate(List<? extends Species> entities) throws DatabaseException
	{
		//update superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.target.OntologyTerm.class).executeUpdate(entities);
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO Species (id) VALUES ");		
		boolean first = true;
		for(Species e: entities)
		{
			// put the ,
			if(first)
				first = false;
			else
				sql.append(",");

			sql.append("(");
			
			//id


			if(e.getId() != null){
                sql.append("'"+this.escapeSql(e.getId()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends Species> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM Species WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(Species e: entities)
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
		this.getDatabase().getMapperFor(org.molgenis.observ.target.OntologyTerm.class).executeRemove(entities);
		return rowsAffected;
	}
	
//Generated by MapperCommons.subclass_per_table.java.ftl
	
	public SpeciesMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT Species.id"
			+", OntologyTerm.Identifier"
			+", OntologyTerm.Name"
			+", OntologyTerm.__Type"
			+", OntologyTerm.ontology"
			+", OntologyTerm.termAccession"
			+", OntologyTerm.definition"
			//parent is SimpleTree(name='ontology')
			+", xref_ontology.Identifier AS ontology_Identifier"
			+" FROM Species "
			+" INNER JOIN OntologyTerm ON (Species.id = OntologyTerm.id)"

			
			//label for ontology=Identifier
//path==ontology. type==xref.
//path==ontology_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Ontology AS xref_ontology " 
			+" ON xref_ontology.id = OntologyTerm.ontology"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM Species "
			  +" INNER JOIN OntologyTerm ON (Species.id = OntologyTerm.id)"
			
			//label for ontology=Identifier
//ontology
//ontology_Identifier
		   	+" LEFT JOIN Ontology AS xref_ontology " 
			+" ON xref_ontology.id = OntologyTerm.ontology"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "Species.id";
		if("Species_id".equalsIgnoreCase(fieldName)) return "Species.id";
		if("Identifier".equalsIgnoreCase(fieldName)) return "OntologyTerm.Identifier";
		if("Species_Identifier".equalsIgnoreCase(fieldName)) return "OntologyTerm.Identifier";
		if("Name".equalsIgnoreCase(fieldName)) return "OntologyTerm.Name";
		if("Species_Name".equalsIgnoreCase(fieldName)) return "OntologyTerm.Name";
		if("__Type".equalsIgnoreCase(fieldName)) return "OntologyTerm.__Type";
		if("Species___Type".equalsIgnoreCase(fieldName)) return "OntologyTerm.__Type";
		if("ontology".equalsIgnoreCase(fieldName)) return "OntologyTerm.ontology";
		if("Species_ontology".equalsIgnoreCase(fieldName)) return "OntologyTerm.ontology";
		if("termAccession".equalsIgnoreCase(fieldName)) return "OntologyTerm.termAccession";
		if("Species_termAccession".equalsIgnoreCase(fieldName)) return "OntologyTerm.termAccession";
		if("definition".equalsIgnoreCase(fieldName)) return "OntologyTerm.definition";
		if("Species_definition".equalsIgnoreCase(fieldName)) return "OntologyTerm.definition";
		if("ontology_id".equalsIgnoreCase(fieldName)) return "OntologyTerm.ontology";
		if("Species_ontology_id".equalsIgnoreCase(fieldName)) return "OntologyTerm.ontology";
		if("ontology_Identifier".equalsIgnoreCase(fieldName)) return "xref_ontology.Identifier";	
		if("Species_ontology_Identifier".equalsIgnoreCase(fieldName)) return "xref_ontology.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.observ.target.Species> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.observ.target.Species>(size); 
	}			

	public org.molgenis.observ.target.Species create()
	{
		return new org.molgenis.observ.target.Species();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.observ.target.Species> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'ontology' to ontology.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> ontologyRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.observ.target.Species object: entities)
		{
			//create xref/mref rule filtering Ontology on the label Identifier
			if(object.getOntology_Id() == null && object.getOntology_Identifier() != null)
			{
				Object label = object.getOntology_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !ontologyRules.containsKey(label))
					{
						ontologyRules.put(""+label, xrefFilter);
						ontologyRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
		}

		//resolve foreign key field 'ontology' to ontology.id using Identifier)
		final java.util.Map<String,Integer> ontology_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(ontologyRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.observ.target.Ontology> ontologyList = null;
			try
			{
				ontologyList = getDatabase().find(org.molgenis.observ.target.Ontology.class, ontologyRules.values().toArray(new org.molgenis.framework.db.QueryRule[ontologyRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.observ.target.Ontology xref :  ontologyList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				ontology_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.observ.target.Species object = entities.get(i);		
			//update object using label fields Identifier
			if(object.getOntology_Id() == null )
			{
					String key = "";
					if(object.getOntology_Identifier() != null)
						key += 	object.getOntology_Identifier();
					
					if(!"".equals(key) && ontology_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("ontology_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setOntology_Id(ontology_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "species.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("identifier".equalsIgnoreCase(fieldName) || "ontologyTerm.identifier".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("name".equalsIgnoreCase(fieldName) || "ontologyTerm.name".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("__Type".equalsIgnoreCase(fieldName) || "ontologyTerm.__Type".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.EnumField();
			if("ontology".equalsIgnoreCase(fieldName) || "ontologyTerm.ontology".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("termAccession".equalsIgnoreCase(fieldName) || "ontologyTerm.termAccession".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("definition".equalsIgnoreCase(fieldName) || "ontologyTerm.definition".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, Species entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.observ.target.Species> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.observ.target.Species> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<Species> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<Species> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<Species> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
