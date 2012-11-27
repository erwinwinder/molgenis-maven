/* File:        org.molgenis/model/Citation_ontologyTerms.java
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
import org.molgenis.organization.Citation_OntologyTerms;

import org.molgenis.observ.target.OntologyTerm;
import org.molgenis.organization.Citation;

public class Citation_OntologyTermsMapper extends AbstractJDBCMapper<Citation_OntologyTerms>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends Citation_OntologyTerms> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO Citation_ontologyTerms (ontologyTerms,Citation) VALUES ");
		{
		
			boolean first = true;
			for(Citation_OntologyTerms e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//ontologyTerms
				if(e.getOntologyTerms_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getOntologyTerms_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//citation
				if(e.getCitation_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getCitation_Id().toString())+"'"
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
	public int executeUpdate(List<? extends Citation_OntologyTerms> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO Citation_ontologyTerms (autoid,ontologyTerms,Citation) VALUES ");		
		boolean first = true;
		for(Citation_OntologyTerms e: entities)
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
		
			//ontologyTerms


			if(e.getOntologyTerms_Id() != null){
                sql.append("'"+this.escapeSql(e.getOntologyTerms_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//citation


			if(e.getCitation_Id() != null){
                sql.append("'"+this.escapeSql(e.getCitation_Id()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE autoid=LAST_INSERT_ID(autoid),ontologyTerms=VALUES(ontologyTerms),Citation=VALUES(Citation)");

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
	public int executeRemove(List<? extends Citation_OntologyTerms> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM Citation_ontologyTerms WHERE ");
		
		//key $f_index: autoid
		{
			sql.append("autoid in (");
			boolean first = true;
			for(Citation_OntologyTerms e: entities)
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
	
	public Citation_OntologyTermsMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT Citation_ontologyTerms.autoid"
			+", Citation_ontologyTerms.ontologyTerms"
			+", Citation_ontologyTerms.Citation"
			//parent is SimpleTree(name='ontologyTerms')
			+", xref_ontologyTerms.Identifier AS ontologyTerms_Identifier"
			//parent is SimpleTree(name='Citation')
			+", xref_Citation.Identifier AS Citation_Identifier"
			+" FROM Citation_ontologyTerms "

			
			//label for ontologyTerms=Identifier
//path==ontologyTerms. type==xref.
//path==ontologyTerms_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN OntologyTerm AS xref_ontologyTerms " 
			+" ON xref_ontologyTerms.id = Citation_ontologyTerms.ontologyTerms"
			
			//label for Citation=Identifier
//path==Citation. type==xref.
//path==Citation_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Citation AS xref_Citation " 
			+" ON xref_Citation.id = Citation_ontologyTerms.Citation"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM Citation_ontologyTerms "
			
			//label for ontologyTerms=Identifier
//ontologyTerms
//ontologyTerms_Identifier
		   	+" LEFT JOIN OntologyTerm AS xref_ontologyTerms " 
			+" ON xref_ontologyTerms.id = Citation_ontologyTerms.ontologyTerms"
			
			//label for Citation=Identifier
//Citation
//Citation_Identifier
		   	+" LEFT JOIN Citation AS xref_Citation " 
			+" ON xref_Citation.id = Citation_ontologyTerms.Citation"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("autoid".equalsIgnoreCase(fieldName)) return "Citation_ontologyTerms.autoid";
		if("Citation_ontologyTerms_autoid".equalsIgnoreCase(fieldName)) return "Citation_ontologyTerms.autoid";
		if("ontologyTerms".equalsIgnoreCase(fieldName)) return "Citation_ontologyTerms.ontologyTerms";
		if("Citation_ontologyTerms_ontologyTerms".equalsIgnoreCase(fieldName)) return "Citation_ontologyTerms.ontologyTerms";
		if("Citation".equalsIgnoreCase(fieldName)) return "Citation_ontologyTerms.Citation";
		if("Citation_ontologyTerms_Citation".equalsIgnoreCase(fieldName)) return "Citation_ontologyTerms.Citation";
		if("ontologyTerms_id".equalsIgnoreCase(fieldName)) return "Citation_ontologyTerms.ontologyTerms";
		if("Citation_ontologyTerms_ontologyTerms_id".equalsIgnoreCase(fieldName)) return "Citation_ontologyTerms.ontologyTerms";
		if("ontologyTerms_Identifier".equalsIgnoreCase(fieldName)) return "xref_ontologyTerms.Identifier";	
		if("Citation_ontologyTerms_ontologyTerms_Identifier".equalsIgnoreCase(fieldName)) return "xref_ontologyTerms.Identifier";
		if("Citation_id".equalsIgnoreCase(fieldName)) return "Citation_ontologyTerms.Citation";
		if("Citation_ontologyTerms_Citation_id".equalsIgnoreCase(fieldName)) return "Citation_ontologyTerms.Citation";
		if("Citation_Identifier".equalsIgnoreCase(fieldName)) return "xref_Citation.Identifier";	
		if("Citation_ontologyTerms_Citation_Identifier".equalsIgnoreCase(fieldName)) return "xref_Citation.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.organization.Citation_OntologyTerms> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.organization.Citation_OntologyTerms>(size); 
	}			

	public org.molgenis.organization.Citation_OntologyTerms create()
	{
		return new org.molgenis.organization.Citation_OntologyTerms();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.organization.Citation_OntologyTerms> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'ontologyTerms' to ontologyTerm.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> ontologyTermsRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'citation' to citation.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> citationRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.organization.Citation_OntologyTerms object: entities)
		{
			//create xref/mref rule filtering OntologyTerm on the label Identifier
			if(object.getOntologyTerms_Id() == null && object.getOntologyTerms_Identifier() != null)
			{
				Object label = object.getOntologyTerms_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !ontologyTermsRules.containsKey(label))
					{
						ontologyTermsRules.put(""+label, xrefFilter);
						ontologyTermsRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering Citation on the label Identifier
			if(object.getCitation_Id() == null && object.getCitation_Identifier() != null)
			{
				Object label = object.getCitation_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !citationRules.containsKey(label))
					{
						citationRules.put(""+label, xrefFilter);
						citationRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
		}

		//resolve foreign key field 'ontologyTerms' to ontologyTerm.id using Identifier)
		final java.util.Map<String,Integer> ontologyTerms_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(ontologyTermsRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.observ.target.OntologyTerm> ontologyTermsList = null;
			try
			{
				ontologyTermsList = getDatabase().find(org.molgenis.observ.target.OntologyTerm.class, ontologyTermsRules.values().toArray(new org.molgenis.framework.db.QueryRule[ontologyTermsRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.observ.target.OntologyTerm xref :  ontologyTermsList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				ontologyTerms_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'citation' to citation.id using Identifier)
		final java.util.Map<String,Integer> citation_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(citationRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.organization.Citation> citationList = null;
			try
			{
				citationList = getDatabase().find(org.molgenis.organization.Citation.class, citationRules.values().toArray(new org.molgenis.framework.db.QueryRule[citationRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.organization.Citation xref :  citationList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				citation_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.organization.Citation_OntologyTerms object = entities.get(i);		
			//update object using label fields Identifier
			if(object.getOntologyTerms_Id() == null )
			{
					String key = "";
					if(object.getOntologyTerms_Identifier() != null)
						key += 	object.getOntologyTerms_Identifier();
					
					if(!"".equals(key) && ontologyTerms_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("ontologyTerms_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setOntologyTerms_Id(ontologyTerms_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields Identifier
			if(object.getCitation_Id() == null )
			{
					String key = "";
					if(object.getCitation_Identifier() != null)
						key += 	object.getCitation_Identifier();
					
					if(!"".equals(key) && citation_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Citation_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setCitation_Id(citation_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("autoid".equalsIgnoreCase(fieldName) || "citation_ontologyTerms.autoid".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("ontologyTerms".equalsIgnoreCase(fieldName) || "citation_ontologyTerms.ontologyTerms".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("citation".equalsIgnoreCase(fieldName) || "citation_ontologyTerms.citation".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, Citation_OntologyTerms entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.organization.Citation_OntologyTerms> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.organization.Citation_OntologyTerms> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<Citation_OntologyTerms> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<Citation_OntologyTerms> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<Citation_OntologyTerms> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
