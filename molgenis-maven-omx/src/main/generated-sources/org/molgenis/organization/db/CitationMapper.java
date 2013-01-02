/* File:        org.molgenis.omx/model/Citation.java
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
import org.molgenis.organization.Citation;

import org.molgenis.observ.target.OntologyTerm;
import org.molgenis.organization.Citation_OntologyTerms;
import org.molgenis.observ.target.OntologyTerm;

public class CitationMapper extends AbstractJDBCMapper<Citation>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends Citation> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO Citation (Identifier,Name,PubmedID,DOI,authorList,Title,Description,Status) VALUES ");
		{
		
			boolean first = true;
			for(Citation e: entities)
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
				//pubmedID
				if(e.getPubmedID() != null){
								
					sql.append("'"+this.escapeSql(e.getPubmedID().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//dOI
				if(e.getDOI() != null){
								
					sql.append("'"+this.escapeSql(e.getDOI().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//authorList
				if(e.getAuthorList() != null){
								
					sql.append("'"+this.escapeSql(e.getAuthorList().toString())+"'"
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
				//description
				if(e.getDescription() != null){
								
					sql.append("'"+this.escapeSql(e.getDescription().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//status
				if(e.getStatus_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getStatus_Id().toString())+"'"
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
	public int executeUpdate(List<? extends Citation> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO Citation (id,Identifier,Name,PubmedID,DOI,authorList,Title,Description,Status) VALUES ");		
		boolean first = true;
		for(Citation e: entities)
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
		
			//pubmedID


			if(e.getPubmedID() != null){
                sql.append("'"+this.escapeSql(e.getPubmedID()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//dOI


			if(e.getDOI() != null){
                sql.append("'"+this.escapeSql(e.getDOI()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//authorList


			if(e.getAuthorList() != null){
                sql.append("'"+this.escapeSql(e.getAuthorList()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//title


			if(e.getTitle() != null){
                sql.append("'"+this.escapeSql(e.getTitle()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//description


			if(e.getDescription() != null){
                sql.append("'"+this.escapeSql(e.getDescription()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//status


			if(e.getStatus_Id() != null){
                sql.append("'"+this.escapeSql(e.getStatus_Id()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE PubmedID=VALUES(PubmedID),DOI=VALUES(DOI),authorList=VALUES(authorList),Title=VALUES(Title),Description=VALUES(Description),Status=VALUES(Status),Identifier=VALUES(Identifier),Name=VALUES(Name),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends Citation> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM Citation WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(Citation e: entities)
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
	
	public CitationMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT Citation.id"
			+", Citation.Identifier"
			+", Citation.Name"
			+", Citation.PubmedID"
			+", Citation.DOI"
			+", Citation.authorList"
			+", Citation.Title"
			+", Citation.Description"
			+", Citation.Status"
			//parent is SimpleTree(name='Status')
			+", xref_Status.Identifier AS Status_Identifier"
			+" FROM Citation "

			
			//label for Status=Identifier
//path==Status. type==xref.
//path==Status_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN OntologyTerm AS xref_Status " 
			+" ON xref_Status.id = Citation.Status"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM Citation "
			
			//label for Status=Identifier
//Status
//Status_Identifier
		   	+" LEFT JOIN OntologyTerm AS xref_Status " 
			+" ON xref_Status.id = Citation.Status"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "Citation.id";
		if("Citation_id".equalsIgnoreCase(fieldName)) return "Citation.id";
		if("Identifier".equalsIgnoreCase(fieldName)) return "Citation.Identifier";
		if("Citation_Identifier".equalsIgnoreCase(fieldName)) return "Citation.Identifier";
		if("Name".equalsIgnoreCase(fieldName)) return "Citation.Name";
		if("Citation_Name".equalsIgnoreCase(fieldName)) return "Citation.Name";
		if("PubmedID".equalsIgnoreCase(fieldName)) return "Citation.PubmedID";
		if("Citation_PubmedID".equalsIgnoreCase(fieldName)) return "Citation.PubmedID";
		if("DOI".equalsIgnoreCase(fieldName)) return "Citation.DOI";
		if("Citation_DOI".equalsIgnoreCase(fieldName)) return "Citation.DOI";
		if("authorList".equalsIgnoreCase(fieldName)) return "Citation.authorList";
		if("Citation_authorList".equalsIgnoreCase(fieldName)) return "Citation.authorList";
		if("Title".equalsIgnoreCase(fieldName)) return "Citation.Title";
		if("Citation_Title".equalsIgnoreCase(fieldName)) return "Citation.Title";
		if("Description".equalsIgnoreCase(fieldName)) return "Citation.Description";
		if("Citation_Description".equalsIgnoreCase(fieldName)) return "Citation.Description";
		if("Status".equalsIgnoreCase(fieldName)) return "Citation.Status";
		if("Citation_Status".equalsIgnoreCase(fieldName)) return "Citation.Status";
		if("Status_id".equalsIgnoreCase(fieldName)) return "Citation.Status";
		if("Citation_Status_id".equalsIgnoreCase(fieldName)) return "Citation.Status";
		if("Status_Identifier".equalsIgnoreCase(fieldName)) return "xref_Status.Identifier";	
		if("Citation_Status_Identifier".equalsIgnoreCase(fieldName)) return "xref_Status.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.organization.Citation> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.organization.Citation>(size); 
	}			

	public org.molgenis.organization.Citation create()
	{
		return new org.molgenis.organization.Citation();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.organization.Citation> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'ontologyTerms' to ontologyTerm.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> ontologyTermsRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'status' to ontologyTerm.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> statusRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.organization.Citation object: entities)
		{
			//create xref/mref rule filtering OntologyTerm on the label Identifier
			if(object.getOntologyTerms_Id().size() == 0 && object.getOntologyTerms_Identifier().size() > 0)
			{
				for(String label: object.getOntologyTerms_Identifier())
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !ontologyTermsRules.containsKey(label))
					{
						ontologyTermsRules.put(""+label, xrefFilter);
						ontologyTermsRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering OntologyTerm on the label Identifier
			if(object.getStatus_Id() == null && object.getStatus_Identifier() != null)
			{
				Object label = object.getStatus_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !statusRules.containsKey(label))
					{
						statusRules.put(""+label, xrefFilter);
						statusRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
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
		//resolve foreign key field 'status' to ontologyTerm.id using Identifier)
		final java.util.Map<String,Integer> status_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(statusRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.observ.target.OntologyTerm> statusList = null;
			try
			{
				statusList = getDatabase().find(org.molgenis.observ.target.OntologyTerm.class, statusRules.values().toArray(new org.molgenis.framework.db.QueryRule[statusRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.observ.target.OntologyTerm xref :  statusList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				status_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.organization.Citation object = entities.get(i);		
			//update object using label fields Identifier
			if(object.getOntologyTerms_Id() == null || object.getOntologyTerms_Id().size() == 0)
			{
				java.util.List<Integer> idList = new java.util.ArrayList<Integer>();
				for(int j = 0; j < object.getOntologyTerms_Identifier().size(); j++)
				{
					String key = "";
					if(object.getOntologyTerms_Identifier().get(j) != null)
						key += 	object.getOntologyTerms_Identifier().get(j);
					
					if(!"".equals(key) && ontologyTerms_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("ontologyTerms_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						idList.add(ontologyTerms_Labels_to_IdMap.get(key));
					}
				}
				object.setOntologyTerms_Id(idList);
			}
			//update object using label fields Identifier
			if(object.getStatus_Id() == null )
			{
					String key = "";
					if(object.getStatus_Identifier() != null)
						key += 	object.getStatus_Identifier();
					
					if(!"".equals(key) && status_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Status_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setStatus_Id(status_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "citation.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("identifier".equalsIgnoreCase(fieldName) || "citation.identifier".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("name".equalsIgnoreCase(fieldName) || "citation.name".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("pubmedID".equalsIgnoreCase(fieldName) || "citation.pubmedID".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("dOI".equalsIgnoreCase(fieldName) || "citation.dOI".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("authorList".equalsIgnoreCase(fieldName) || "citation.authorList".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("title".equalsIgnoreCase(fieldName) || "citation.title".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("description".equalsIgnoreCase(fieldName) || "citation.description".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("status".equalsIgnoreCase(fieldName) || "citation.status".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, Citation entity)
	{
		entity.setId(i);
	}
	
	@Override
	public QueryRule rewriteMrefRule(Database db, QueryRule rule) throws DatabaseException
	{
		if("ontologyTerms".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// Citation_ontologyTerms
			List<Citation_OntologyTerms> mref_mapping_entities = db.find(Citation_OntologyTerms.class, new QueryRule(
					"ontologyTerms", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (Citation_OntologyTerms mref : mref_mapping_entities) mref_ids.add(mref.getCitation_Id());
				return new QueryRule("id", Operator.IN, mref_ids);
			}		
			else
			{
				// no records to be shown
				return new QueryRule("id", Operator.EQUALS, Integer.MIN_VALUE);
			}			
		}
		else if("ontologyTerms_Identifier".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// Citation_ontologyTerms
			List<Citation_OntologyTerms> mref_mapping_entities = db.find(Citation_OntologyTerms.class, new QueryRule(
					"ontologyTerms_Identifier", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (Citation_OntologyTerms mref : mref_mapping_entities) mref_ids.add(mref.getCitation_Id());
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
	public void prepareFileAttachements(java.util.List<org.molgenis.organization.Citation> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.organization.Citation> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<Citation> entities ) throws DatabaseException			
	{
		try
		{
			//list the citation ids to query
			List<Integer> citationIds = new ArrayList<Integer>();
			for(Citation entity: entities)
			{
				citationIds.add(entity.getId());
			}
			
			//map the ontologyTerms mrefs
			List<Citation_OntologyTerms> ontologyTerms_mrefs = this.getDatabase().query(Citation_OntologyTerms.class).in("Citation", citationIds).sortASC("autoid").find();
			Map<Integer,List<Integer>> ontologyTerms_ontologyTerms_map = new LinkedHashMap<Integer,List<Integer>>();
			Map<Integer,List<String>> ontologyTerms_Identifier_map = new LinkedHashMap<Integer,List<String>>();
			
			for(Citation_OntologyTerms ref: ontologyTerms_mrefs)
			{
				if(ontologyTerms_ontologyTerms_map.get(ref.getCitation_Id()) == null) ontologyTerms_ontologyTerms_map.put(ref.getCitation_Id(),new ArrayList<Integer>()); 
				ontologyTerms_ontologyTerms_map.get(ref.getCitation_Id()).add(ref.getOntologyTerms_Id());
				if(ontologyTerms_Identifier_map.get(ref.getCitation_Id()) == null)	ontologyTerms_Identifier_map.put(ref.getCitation_Id(),new ArrayList<String>());
				ontologyTerms_Identifier_map.get(ref.getCitation_Id()).add(ref.getOntologyTerms_Identifier());
			}
			
			//load the mapped data into the entities
			for(Citation entity: entities)
			{
				Integer id = entity.getId();
				if(ontologyTerms_ontologyTerms_map.get(id) != null)
				{
					entity.setOntologyTerms_Id(ontologyTerms_ontologyTerms_map.get(id));
				}
				if(ontologyTerms_Identifier_map.get(id) != null)
				{
					entity.setOntologyTerms_Identifier(ontologyTerms_Identifier_map.get(id));
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
	public void storeMrefs( List<Citation> entities ) throws DatabaseException, IOException, ParseException	
	{
		//create an List of Citation ids to query for
		List<Integer> entityIds = new ArrayList<Integer>(); 
		for (Citation entity : entities) 
		{
			entityIds.add(entity.getId());		
		}
		
		//delete existing mrefs
		getDatabase().remove(getDatabase().query( Citation_OntologyTerms.class).in("Citation", entityIds).find());
		List<Citation_OntologyTerms> citation_ontologyTermsToAdd = new ArrayList<Citation_OntologyTerms>();


		//check for each mref what needs to be added
		for(Citation entity: entities)
		{
			//remove duplicates using Set
			entity.setOntologyTerms(new ArrayList(new LinkedHashSet(entity.getOntologyTerms_Id())));
			for(Integer id: entity.getOntologyTerms_Id())
			{
				Citation_OntologyTerms new_mref = new Citation_OntologyTerms();
				new_mref.setCitation( entity.getId() );
				new_mref.setOntologyTerms( id );
				citation_ontologyTermsToAdd.add(new_mref);
			}
			
		}
		
		//process changes to Citation_ontologyTerms
		getDatabase().add( citation_ontologyTermsToAdd );
	}
		
	
	public void removeMrefs( List<Citation> entities ) throws DatabaseException, IOException, ParseException
	{
		//create an list of Citation ids to query for
		List<Integer> entityIds = new ArrayList<Integer>(); 
		for (Citation entity : entities) 
		{
			entityIds.add(entity.getId());		
		}	
	
		//remove all Citation_ontologyTerms elements for field entity.ontologyTerms
		getDatabase().remove( getDatabase().query( Citation_OntologyTerms.class).in("Citation", entityIds).find() );
	}	
}
