/* File:        org.molgenis/model/UsedMarkerSet.java
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
import org.molgenis.gwascentral.UsedMarkerSet;

import org.molgenis.observ.ObservableFeature;
import org.molgenis.observ.db.ObservableFeatureMapper;
import org.molgenis.observ.target.OntologyTerm;
import org.molgenis.organization.Experiment;

public class UsedMarkerSetMapper extends AbstractJDBCMapper<UsedMarkerSet>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends UsedMarkerSet> entities) throws DatabaseException
	{	
		//add superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.ObservableFeature.class).executeAdd(entities);
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO UsedMarkerSet (ExperimentID,MarkerIdentifier,id) VALUES ");
		{
		
			boolean first = true;
			for(UsedMarkerSet e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//experimentID
				if(e.getExperimentID_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getExperimentID_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//markerIdentifier
				if(e.getMarkerIdentifier() != null){
								
					sql.append("'"+this.escapeSql(e.getMarkerIdentifier().toString())+"'"
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
	public int executeUpdate(List<? extends UsedMarkerSet> entities) throws DatabaseException
	{
		//update superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.ObservableFeature.class).executeUpdate(entities);
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO UsedMarkerSet (ExperimentID,MarkerIdentifier,id) VALUES ");		
		boolean first = true;
		for(UsedMarkerSet e: entities)
		{
			// put the ,
			if(first)
				first = false;
			else
				sql.append(",");

			sql.append("(");
			
			//experimentID


			if(e.getExperimentID_Id() != null){
                sql.append("'"+this.escapeSql(e.getExperimentID_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//markerIdentifier


			if(e.getMarkerIdentifier() != null){
                sql.append("'"+this.escapeSql(e.getMarkerIdentifier()).toString()+"'" +",");
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
		sql.append(" ON DUPLICATE KEY UPDATE ExperimentID=VALUES(ExperimentID),MarkerIdentifier=VALUES(MarkerIdentifier),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends UsedMarkerSet> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM UsedMarkerSet WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(UsedMarkerSet e: entities)
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
		this.getDatabase().getMapperFor(org.molgenis.observ.ObservableFeature.class).executeRemove(entities);
		return rowsAffected;
	}
	
//Generated by MapperCommons.subclass_per_table.java.ftl
	
	public UsedMarkerSetMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT UsedMarkerSet.id"
			+", Characteristic.Identifier"
			+", Characteristic.Name"
			+", Characteristic.__Type"
			+", Characteristic.description"
			+", ObservableFeature.unit"
			+", ObservableFeature.dataType"
			+", ObservableFeature.temporal"
			+", UsedMarkerSet.ExperimentID"
			+", UsedMarkerSet.MarkerIdentifier"
			//parent is SimpleTree(name='unit')
			+", xref_unit.Identifier AS unit_Identifier"
			//parent is SimpleTree(name='ExperimentID')
			+", xref_ExperimentID.Identifier AS ExperimentID_Identifier"
			+" FROM UsedMarkerSet "
			+" INNER JOIN ObservableFeature ON (UsedMarkerSet.id = ObservableFeature.id)"
			+" INNER JOIN Characteristic ON (UsedMarkerSet.id = Characteristic.id)"

			
			//label for unit=Identifier
//path==unit. type==xref.
//path==unit_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN OntologyTerm AS xref_unit " 
			+" ON xref_unit.id = ObservableFeature.unit"
			
			//label for ExperimentID=Identifier
//path==ExperimentID. type==xref.
//path==ExperimentID_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Experiment AS xref_ExperimentID " 
			+" ON xref_ExperimentID.id = UsedMarkerSet.ExperimentID"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM UsedMarkerSet "
			  +" INNER JOIN ObservableFeature ON (UsedMarkerSet.id = ObservableFeature.id)"
			  +" INNER JOIN Characteristic ON (UsedMarkerSet.id = Characteristic.id)"
			
			//label for unit=Identifier
//unit
//unit_Identifier
		   	+" LEFT JOIN OntologyTerm AS xref_unit " 
			+" ON xref_unit.id = ObservableFeature.unit"
			
			//label for ExperimentID=Identifier
//ExperimentID
//ExperimentID_Identifier
		   	+" LEFT JOIN Experiment AS xref_ExperimentID " 
			+" ON xref_ExperimentID.id = UsedMarkerSet.ExperimentID"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "UsedMarkerSet.id";
		if("UsedMarkerSet_id".equalsIgnoreCase(fieldName)) return "UsedMarkerSet.id";
		if("Identifier".equalsIgnoreCase(fieldName)) return "Characteristic.Identifier";
		if("UsedMarkerSet_Identifier".equalsIgnoreCase(fieldName)) return "Characteristic.Identifier";
		if("Name".equalsIgnoreCase(fieldName)) return "Characteristic.Name";
		if("UsedMarkerSet_Name".equalsIgnoreCase(fieldName)) return "Characteristic.Name";
		if("__Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("UsedMarkerSet___Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("description".equalsIgnoreCase(fieldName)) return "Characteristic.description";
		if("UsedMarkerSet_description".equalsIgnoreCase(fieldName)) return "Characteristic.description";
		if("unit".equalsIgnoreCase(fieldName)) return "ObservableFeature.unit";
		if("UsedMarkerSet_unit".equalsIgnoreCase(fieldName)) return "ObservableFeature.unit";
		if("dataType".equalsIgnoreCase(fieldName)) return "ObservableFeature.dataType";
		if("UsedMarkerSet_dataType".equalsIgnoreCase(fieldName)) return "ObservableFeature.dataType";
		if("temporal".equalsIgnoreCase(fieldName)) return "ObservableFeature.temporal";
		if("UsedMarkerSet_temporal".equalsIgnoreCase(fieldName)) return "ObservableFeature.temporal";
		if("ExperimentID".equalsIgnoreCase(fieldName)) return "UsedMarkerSet.ExperimentID";
		if("UsedMarkerSet_ExperimentID".equalsIgnoreCase(fieldName)) return "UsedMarkerSet.ExperimentID";
		if("MarkerIdentifier".equalsIgnoreCase(fieldName)) return "UsedMarkerSet.MarkerIdentifier";
		if("UsedMarkerSet_MarkerIdentifier".equalsIgnoreCase(fieldName)) return "UsedMarkerSet.MarkerIdentifier";
		if("unit_id".equalsIgnoreCase(fieldName)) return "ObservableFeature.unit";
		if("UsedMarkerSet_unit_id".equalsIgnoreCase(fieldName)) return "ObservableFeature.unit";
		if("unit_Identifier".equalsIgnoreCase(fieldName)) return "xref_unit.Identifier";	
		if("UsedMarkerSet_unit_Identifier".equalsIgnoreCase(fieldName)) return "xref_unit.Identifier";
		if("ExperimentID_id".equalsIgnoreCase(fieldName)) return "UsedMarkerSet.ExperimentID";
		if("UsedMarkerSet_ExperimentID_id".equalsIgnoreCase(fieldName)) return "UsedMarkerSet.ExperimentID";
		if("ExperimentID_Identifier".equalsIgnoreCase(fieldName)) return "xref_ExperimentID.Identifier";	
		if("UsedMarkerSet_ExperimentID_Identifier".equalsIgnoreCase(fieldName)) return "xref_ExperimentID.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.gwascentral.UsedMarkerSet> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.gwascentral.UsedMarkerSet>(size); 
	}			

	public org.molgenis.gwascentral.UsedMarkerSet create()
	{
		return new org.molgenis.gwascentral.UsedMarkerSet();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.gwascentral.UsedMarkerSet> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'unit' to ontologyTerm.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> unitRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'experimentID' to experiment.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> experimentIDRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.gwascentral.UsedMarkerSet object: entities)
		{
			//create xref/mref rule filtering OntologyTerm on the label Identifier
			if(object.getUnit_Id() == null && object.getUnit_Identifier() != null)
			{
				Object label = object.getUnit_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !unitRules.containsKey(label))
					{
						unitRules.put(""+label, xrefFilter);
						unitRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering Experiment on the label Identifier
			if(object.getExperimentID_Id() == null && object.getExperimentID_Identifier() != null)
			{
				Object label = object.getExperimentID_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !experimentIDRules.containsKey(label))
					{
						experimentIDRules.put(""+label, xrefFilter);
						experimentIDRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
		}

		//resolve foreign key field 'unit' to ontologyTerm.id using Identifier)
		final java.util.Map<String,Integer> unit_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(unitRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.observ.target.OntologyTerm> unitList = null;
			try
			{
				unitList = getDatabase().find(org.molgenis.observ.target.OntologyTerm.class, unitRules.values().toArray(new org.molgenis.framework.db.QueryRule[unitRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.observ.target.OntologyTerm xref :  unitList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				unit_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'experimentID' to experiment.id using Identifier)
		final java.util.Map<String,Integer> experimentID_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(experimentIDRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.organization.Experiment> experimentIDList = null;
			try
			{
				experimentIDList = getDatabase().find(org.molgenis.organization.Experiment.class, experimentIDRules.values().toArray(new org.molgenis.framework.db.QueryRule[experimentIDRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.organization.Experiment xref :  experimentIDList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				experimentID_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.gwascentral.UsedMarkerSet object = entities.get(i);		
			//update object using label fields Identifier
			if(object.getUnit_Id() == null )
			{
					String key = "";
					if(object.getUnit_Identifier() != null)
						key += 	object.getUnit_Identifier();
					
					if(!"".equals(key) && unit_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("unit_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setUnit_Id(unit_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields Identifier
			if(object.getExperimentID_Id() == null )
			{
					String key = "";
					if(object.getExperimentID_Identifier() != null)
						key += 	object.getExperimentID_Identifier();
					
					if(!"".equals(key) && experimentID_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("ExperimentID_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setExperimentID_Id(experimentID_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "usedMarkerSet.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("identifier".equalsIgnoreCase(fieldName) || "characteristic.identifier".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("name".equalsIgnoreCase(fieldName) || "characteristic.name".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("__Type".equalsIgnoreCase(fieldName) || "characteristic.__Type".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.EnumField();
			if("description".equalsIgnoreCase(fieldName) || "characteristic.description".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("unit".equalsIgnoreCase(fieldName) || "observableFeature.unit".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("dataType".equalsIgnoreCase(fieldName) || "observableFeature.dataType".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.EnumField();
			if("temporal".equalsIgnoreCase(fieldName) || "observableFeature.temporal".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.BoolField();
			if("experimentID".equalsIgnoreCase(fieldName) || "usedMarkerSet.experimentID".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("markerIdentifier".equalsIgnoreCase(fieldName) || "usedMarkerSet.markerIdentifier".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, UsedMarkerSet entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.gwascentral.UsedMarkerSet> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.gwascentral.UsedMarkerSet> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<UsedMarkerSet> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<UsedMarkerSet> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<UsedMarkerSet> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
