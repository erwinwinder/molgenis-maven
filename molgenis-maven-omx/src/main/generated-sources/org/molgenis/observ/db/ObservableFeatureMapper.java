/* File:        org.molgenis.omx/model/ObservableFeature.java
 * Copyright:   GBIC 2000-2013, all rights reserved
 * Date:        January 2, 2013
 * Template:	MultiqueryMapperGen.java.ftl
 * generator:   org.molgenis.generators.db.MultiqueryMapperGen 4.0.0-testing
 *
 * Using "subclass per table" strategy
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.observ.db;

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
import org.molgenis.observ.ObservableFeature;

import org.molgenis.observ.Characteristic;
import org.molgenis.observ.db.CharacteristicMapper;
import org.molgenis.observ.target.OntologyTerm;

public class ObservableFeatureMapper extends AbstractJDBCMapper<ObservableFeature>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends ObservableFeature> entities) throws DatabaseException
	{	
		//add superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.Characteristic.class).executeAdd(entities);
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO ObservableFeature (unit,dataType,temporal,id) VALUES ");
		{
		
			boolean first = true;
			for(ObservableFeature e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//unit
				if(e.getUnit_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getUnit_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//dataType
				if(e.getDataType() != null){
								
					sql.append("'"+this.escapeSql(e.getDataType().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//temporal
				if(e.getTemporal() != null){
								
					sql.append(e.getTemporal()
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
	public int executeUpdate(List<? extends ObservableFeature> entities) throws DatabaseException
	{
		//update superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.Characteristic.class).executeUpdate(entities);
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO ObservableFeature (unit,dataType,temporal,id) VALUES ");		
		boolean first = true;
		for(ObservableFeature e: entities)
		{
			// put the ,
			if(first)
				first = false;
			else
				sql.append(",");

			sql.append("(");
			
			//unit


			if(e.getUnit_Id() != null){
                sql.append("'"+this.escapeSql(e.getUnit_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//dataType


			if(e.getDataType() != null){
                sql.append("'"+this.escapeSql(e.getDataType())+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//temporal


			if(e.getTemporal() != null){
                sql.append(e.getTemporal() +",");
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
		sql.append(" ON DUPLICATE KEY UPDATE unit=VALUES(unit),dataType=VALUES(dataType),temporal=VALUES(temporal),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends ObservableFeature> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM ObservableFeature WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(ObservableFeature e: entities)
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
		this.getDatabase().getMapperFor(org.molgenis.observ.Characteristic.class).executeRemove(entities);
		return rowsAffected;
	}
	
//Generated by MapperCommons.subclass_per_table.java.ftl
	
	public ObservableFeatureMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT ObservableFeature.id"
			+", Characteristic.Identifier"
			+", Characteristic.Name"
			+", Characteristic.__Type"
			+", Characteristic.description"
			+", ObservableFeature.unit"
			+", ObservableFeature.dataType"
			+", ObservableFeature.temporal"
			//parent is SimpleTree(name='unit')
			+", xref_unit.Identifier AS unit_Identifier"
			+" FROM ObservableFeature "
			+" INNER JOIN Characteristic ON (ObservableFeature.id = Characteristic.id)"

			
			//label for unit=Identifier
//path==unit. type==xref.
//path==unit_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN OntologyTerm AS xref_unit " 
			+" ON xref_unit.id = ObservableFeature.unit"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM ObservableFeature "
			  +" INNER JOIN Characteristic ON (ObservableFeature.id = Characteristic.id)"
			
			//label for unit=Identifier
//unit
//unit_Identifier
		   	+" LEFT JOIN OntologyTerm AS xref_unit " 
			+" ON xref_unit.id = ObservableFeature.unit"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "ObservableFeature.id";
		if("ObservableFeature_id".equalsIgnoreCase(fieldName)) return "ObservableFeature.id";
		if("Identifier".equalsIgnoreCase(fieldName)) return "Characteristic.Identifier";
		if("ObservableFeature_Identifier".equalsIgnoreCase(fieldName)) return "Characteristic.Identifier";
		if("Name".equalsIgnoreCase(fieldName)) return "Characteristic.Name";
		if("ObservableFeature_Name".equalsIgnoreCase(fieldName)) return "Characteristic.Name";
		if("__Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("ObservableFeature___Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("description".equalsIgnoreCase(fieldName)) return "Characteristic.description";
		if("ObservableFeature_description".equalsIgnoreCase(fieldName)) return "Characteristic.description";
		if("unit".equalsIgnoreCase(fieldName)) return "ObservableFeature.unit";
		if("ObservableFeature_unit".equalsIgnoreCase(fieldName)) return "ObservableFeature.unit";
		if("dataType".equalsIgnoreCase(fieldName)) return "ObservableFeature.dataType";
		if("ObservableFeature_dataType".equalsIgnoreCase(fieldName)) return "ObservableFeature.dataType";
		if("temporal".equalsIgnoreCase(fieldName)) return "ObservableFeature.temporal";
		if("ObservableFeature_temporal".equalsIgnoreCase(fieldName)) return "ObservableFeature.temporal";
		if("unit_id".equalsIgnoreCase(fieldName)) return "ObservableFeature.unit";
		if("ObservableFeature_unit_id".equalsIgnoreCase(fieldName)) return "ObservableFeature.unit";
		if("unit_Identifier".equalsIgnoreCase(fieldName)) return "xref_unit.Identifier";	
		if("ObservableFeature_unit_Identifier".equalsIgnoreCase(fieldName)) return "xref_unit.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.observ.ObservableFeature> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.observ.ObservableFeature>(size); 
	}			

	public org.molgenis.observ.ObservableFeature create()
	{
		return new org.molgenis.observ.ObservableFeature();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.observ.ObservableFeature> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'unit' to ontologyTerm.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> unitRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.observ.ObservableFeature object: entities)
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

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.observ.ObservableFeature object = entities.get(i);		
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
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "observableFeature.id".equalsIgnoreCase(fieldName)) 
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
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, ObservableFeature entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.observ.ObservableFeature> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.observ.ObservableFeature> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<ObservableFeature> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<ObservableFeature> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<ObservableFeature> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
