/* File:        org.molgenis/model/Panel_Individuals.java
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
import org.molgenis.observ.target.Panel_Individuals;

import org.molgenis.observ.target.Individual;
import org.molgenis.observ.target.Panel;

public class Panel_IndividualsMapper extends AbstractJDBCMapper<Panel_Individuals>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends Panel_Individuals> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO Panel_Individuals (Individuals,Panel) VALUES ");
		{
		
			boolean first = true;
			for(Panel_Individuals e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//individuals
				if(e.getIndividuals_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getIndividuals_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//panel
				if(e.getPanel_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getPanel_Id().toString())+"'"
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
	public int executeUpdate(List<? extends Panel_Individuals> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO Panel_Individuals (autoid,Individuals,Panel) VALUES ");		
		boolean first = true;
		for(Panel_Individuals e: entities)
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
		
			//individuals


			if(e.getIndividuals_Id() != null){
                sql.append("'"+this.escapeSql(e.getIndividuals_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//panel


			if(e.getPanel_Id() != null){
                sql.append("'"+this.escapeSql(e.getPanel_Id()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE autoid=LAST_INSERT_ID(autoid),Individuals=VALUES(Individuals),Panel=VALUES(Panel)");

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
	public int executeRemove(List<? extends Panel_Individuals> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM Panel_Individuals WHERE ");
		
		//key $f_index: autoid
		{
			sql.append("autoid in (");
			boolean first = true;
			for(Panel_Individuals e: entities)
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
	
	public Panel_IndividualsMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT Panel_Individuals.autoid"
			+", Panel_Individuals.Individuals"
			+", Panel_Individuals.Panel"
			//parent is SimpleTree(name='Individuals')
			+", xref_Individuals.Identifier AS Individuals_Identifier"
			//parent is SimpleTree(name='Panel')
			+", xref_Panel.Identifier AS Panel_Identifier"
			+" FROM Panel_Individuals "

			
			//label for Individuals=Identifier
//path==Individuals. type==xref.
//path==Individuals_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Characteristic AS xref_Individuals " 
			+" ON xref_Individuals.id = Panel_Individuals.Individuals"
			
			//label for Panel=Identifier
//path==Panel. type==xref.
//path==Panel_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Characteristic AS xref_Panel " 
			+" ON xref_Panel.id = Panel_Individuals.Panel"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM Panel_Individuals "
			
			//label for Individuals=Identifier
//Individuals
//Individuals_Identifier
		   	+" LEFT JOIN Characteristic AS xref_Individuals " 
			+" ON xref_Individuals.id = Panel_Individuals.Individuals"
			
			//label for Panel=Identifier
//Panel
//Panel_Identifier
		   	+" LEFT JOIN Characteristic AS xref_Panel " 
			+" ON xref_Panel.id = Panel_Individuals.Panel"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("autoid".equalsIgnoreCase(fieldName)) return "Panel_Individuals.autoid";
		if("Panel_Individuals_autoid".equalsIgnoreCase(fieldName)) return "Panel_Individuals.autoid";
		if("Individuals".equalsIgnoreCase(fieldName)) return "Panel_Individuals.Individuals";
		if("Panel_Individuals_Individuals".equalsIgnoreCase(fieldName)) return "Panel_Individuals.Individuals";
		if("Panel".equalsIgnoreCase(fieldName)) return "Panel_Individuals.Panel";
		if("Panel_Individuals_Panel".equalsIgnoreCase(fieldName)) return "Panel_Individuals.Panel";
		if("Individuals_id".equalsIgnoreCase(fieldName)) return "Panel_Individuals.Individuals";
		if("Panel_Individuals_Individuals_id".equalsIgnoreCase(fieldName)) return "Panel_Individuals.Individuals";
		if("Individuals_Identifier".equalsIgnoreCase(fieldName)) return "xref_Individuals.Identifier";	
		if("Panel_Individuals_Individuals_Identifier".equalsIgnoreCase(fieldName)) return "xref_Individuals.Identifier";
		if("Panel_id".equalsIgnoreCase(fieldName)) return "Panel_Individuals.Panel";
		if("Panel_Individuals_Panel_id".equalsIgnoreCase(fieldName)) return "Panel_Individuals.Panel";
		if("Panel_Identifier".equalsIgnoreCase(fieldName)) return "xref_Panel.Identifier";	
		if("Panel_Individuals_Panel_Identifier".equalsIgnoreCase(fieldName)) return "xref_Panel.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.observ.target.Panel_Individuals> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.observ.target.Panel_Individuals>(size); 
	}			

	public org.molgenis.observ.target.Panel_Individuals create()
	{
		return new org.molgenis.observ.target.Panel_Individuals();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.observ.target.Panel_Individuals> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'individuals' to individual.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> individualsRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'panel' to panel.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> panelRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.observ.target.Panel_Individuals object: entities)
		{
			//create xref/mref rule filtering Individual on the label Identifier
			if(object.getIndividuals_Id() == null && object.getIndividuals_Identifier() != null)
			{
				Object label = object.getIndividuals_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !individualsRules.containsKey(label))
					{
						individualsRules.put(""+label, xrefFilter);
						individualsRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering Panel on the label Identifier
			if(object.getPanel_Id() == null && object.getPanel_Identifier() != null)
			{
				Object label = object.getPanel_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !panelRules.containsKey(label))
					{
						panelRules.put(""+label, xrefFilter);
						panelRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
		}

		//resolve foreign key field 'individuals' to individual.id using Identifier)
		final java.util.Map<String,Integer> individuals_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(individualsRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.observ.target.Individual> individualsList = null;
			try
			{
				individualsList = getDatabase().find(org.molgenis.observ.target.Individual.class, individualsRules.values().toArray(new org.molgenis.framework.db.QueryRule[individualsRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.observ.target.Individual xref :  individualsList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				individuals_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'panel' to panel.id using Identifier)
		final java.util.Map<String,Integer> panel_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(panelRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.observ.target.Panel> panelList = null;
			try
			{
				panelList = getDatabase().find(org.molgenis.observ.target.Panel.class, panelRules.values().toArray(new org.molgenis.framework.db.QueryRule[panelRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.observ.target.Panel xref :  panelList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				panel_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.observ.target.Panel_Individuals object = entities.get(i);		
			//update object using label fields Identifier
			if(object.getIndividuals_Id() == null )
			{
					String key = "";
					if(object.getIndividuals_Identifier() != null)
						key += 	object.getIndividuals_Identifier();
					
					if(!"".equals(key) && individuals_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Individuals_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setIndividuals_Id(individuals_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields Identifier
			if(object.getPanel_Id() == null )
			{
					String key = "";
					if(object.getPanel_Identifier() != null)
						key += 	object.getPanel_Identifier();
					
					if(!"".equals(key) && panel_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Panel_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setPanel_Id(panel_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("autoid".equalsIgnoreCase(fieldName) || "panel_Individuals.autoid".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("individuals".equalsIgnoreCase(fieldName) || "panel_Individuals.individuals".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("panel".equalsIgnoreCase(fieldName) || "panel_Individuals.panel".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, Panel_Individuals entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.observ.target.Panel_Individuals> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.observ.target.Panel_Individuals> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<Panel_Individuals> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<Panel_Individuals> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<Panel_Individuals> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
