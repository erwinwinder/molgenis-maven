/* File:        org.molgenis.omx/model/GenotypeFrequency.java
 * Copyright:   GBIC 2000-2013, all rights reserved
 * Date:        January 2, 2013
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
import org.molgenis.gwascentral.GenotypeFrequency;

import org.molgenis.observ.DataSet;
import org.molgenis.observ.db.DataSetMapper;
import org.molgenis.observ.Protocol;
import org.molgenis.gwascentral.FrequencyCluster;

public class GenotypeFrequencyMapper extends AbstractJDBCMapper<GenotypeFrequency>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends GenotypeFrequency> entities) throws DatabaseException
	{	
		//add superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.DataSet.class).executeAdd(entities);
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO GenotypeFrequency (FrequencyCluster,GenotypeCombo,FrequencyAsProportion,NumberSamplesWithGenotype,id) VALUES ");
		{
		
			boolean first = true;
			for(GenotypeFrequency e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//frequencyCluster
				if(e.getFrequencyCluster_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getFrequencyCluster_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//genotypeCombo
				if(e.getGenotypeCombo() != null){
								
					sql.append("'"+this.escapeSql(e.getGenotypeCombo().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//frequencyAsProportion
				if(e.getFrequencyAsProportion() != null){
								
					sql.append("'"+this.escapeSql(e.getFrequencyAsProportion().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//numberSamplesWithGenotype
				if(e.getNumberSamplesWithGenotype() != null){
								
					sql.append("'"+this.escapeSql(e.getNumberSamplesWithGenotype().toString())+"'"
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
	public int executeUpdate(List<? extends GenotypeFrequency> entities) throws DatabaseException
	{
		//update superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.DataSet.class).executeUpdate(entities);
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO GenotypeFrequency (FrequencyCluster,GenotypeCombo,FrequencyAsProportion,NumberSamplesWithGenotype,id) VALUES ");		
		boolean first = true;
		for(GenotypeFrequency e: entities)
		{
			// put the ,
			if(first)
				first = false;
			else
				sql.append(",");

			sql.append("(");
			
			//frequencyCluster


			if(e.getFrequencyCluster_Id() != null){
                sql.append("'"+this.escapeSql(e.getFrequencyCluster_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//genotypeCombo


			if(e.getGenotypeCombo() != null){
                sql.append("'"+this.escapeSql(e.getGenotypeCombo()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//frequencyAsProportion


			if(e.getFrequencyAsProportion() != null){
                sql.append("'"+this.escapeSql(e.getFrequencyAsProportion()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//numberSamplesWithGenotype


			if(e.getNumberSamplesWithGenotype() != null){
                sql.append("'"+this.escapeSql(e.getNumberSamplesWithGenotype()).toString()+"'" +",");
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
		sql.append(" ON DUPLICATE KEY UPDATE FrequencyCluster=VALUES(FrequencyCluster),GenotypeCombo=VALUES(GenotypeCombo),FrequencyAsProportion=VALUES(FrequencyAsProportion),NumberSamplesWithGenotype=VALUES(NumberSamplesWithGenotype),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends GenotypeFrequency> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM GenotypeFrequency WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(GenotypeFrequency e: entities)
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
		this.getDatabase().getMapperFor(org.molgenis.observ.DataSet.class).executeRemove(entities);
		return rowsAffected;
	}
	
//Generated by MapperCommons.subclass_per_table.java.ftl
	
	public GenotypeFrequencyMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT GenotypeFrequency.id"
			+", Characteristic.Identifier"
			+", Characteristic.Name"
			+", Characteristic.__Type"
			+", Characteristic.description"
			+", DataSet.ProtocolUsed"
			+", DataSet.startTime"
			+", DataSet.endTime"
			+", GenotypeFrequency.FrequencyCluster"
			+", GenotypeFrequency.GenotypeCombo"
			+", GenotypeFrequency.FrequencyAsProportion"
			+", GenotypeFrequency.NumberSamplesWithGenotype"
			//parent is SimpleTree(name='ProtocolUsed')
			+", xref_ProtocolUsed.Identifier AS ProtocolUsed_Identifier"
			//parent is SimpleTree(name='FrequencyCluster')
			+", xref_FrequencyCluster.Identifier AS FrequencyCluster_Identifier"
			+" FROM GenotypeFrequency "
			+" INNER JOIN DataSet ON (GenotypeFrequency.id = DataSet.id)"
			+" INNER JOIN Characteristic ON (GenotypeFrequency.id = Characteristic.id)"

			
			//label for ProtocolUsed=Identifier
//path==ProtocolUsed. type==xref.
//path==ProtocolUsed_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Characteristic AS xref_ProtocolUsed " 
			+" ON xref_ProtocolUsed.id = DataSet.ProtocolUsed"
			
			//label for FrequencyCluster=Identifier
//path==FrequencyCluster. type==xref.
//path==FrequencyCluster_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Characteristic AS xref_FrequencyCluster " 
			+" ON xref_FrequencyCluster.id = GenotypeFrequency.FrequencyCluster"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM GenotypeFrequency "
			  +" INNER JOIN DataSet ON (GenotypeFrequency.id = DataSet.id)"
			  +" INNER JOIN Characteristic ON (GenotypeFrequency.id = Characteristic.id)"
			
			//label for ProtocolUsed=Identifier
//ProtocolUsed
//ProtocolUsed_Identifier
		   	+" LEFT JOIN Characteristic AS xref_ProtocolUsed " 
			+" ON xref_ProtocolUsed.id = DataSet.ProtocolUsed"
			
			//label for FrequencyCluster=Identifier
//FrequencyCluster
//FrequencyCluster_Identifier
		   	+" LEFT JOIN Characteristic AS xref_FrequencyCluster " 
			+" ON xref_FrequencyCluster.id = GenotypeFrequency.FrequencyCluster"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "GenotypeFrequency.id";
		if("GenotypeFrequency_id".equalsIgnoreCase(fieldName)) return "GenotypeFrequency.id";
		if("Identifier".equalsIgnoreCase(fieldName)) return "Characteristic.Identifier";
		if("GenotypeFrequency_Identifier".equalsIgnoreCase(fieldName)) return "Characteristic.Identifier";
		if("Name".equalsIgnoreCase(fieldName)) return "Characteristic.Name";
		if("GenotypeFrequency_Name".equalsIgnoreCase(fieldName)) return "Characteristic.Name";
		if("__Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("GenotypeFrequency___Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("description".equalsIgnoreCase(fieldName)) return "Characteristic.description";
		if("GenotypeFrequency_description".equalsIgnoreCase(fieldName)) return "Characteristic.description";
		if("ProtocolUsed".equalsIgnoreCase(fieldName)) return "DataSet.ProtocolUsed";
		if("GenotypeFrequency_ProtocolUsed".equalsIgnoreCase(fieldName)) return "DataSet.ProtocolUsed";
		if("startTime".equalsIgnoreCase(fieldName)) return "DataSet.startTime";
		if("GenotypeFrequency_startTime".equalsIgnoreCase(fieldName)) return "DataSet.startTime";
		if("endTime".equalsIgnoreCase(fieldName)) return "DataSet.endTime";
		if("GenotypeFrequency_endTime".equalsIgnoreCase(fieldName)) return "DataSet.endTime";
		if("FrequencyCluster".equalsIgnoreCase(fieldName)) return "GenotypeFrequency.FrequencyCluster";
		if("GenotypeFrequency_FrequencyCluster".equalsIgnoreCase(fieldName)) return "GenotypeFrequency.FrequencyCluster";
		if("GenotypeCombo".equalsIgnoreCase(fieldName)) return "GenotypeFrequency.GenotypeCombo";
		if("GenotypeFrequency_GenotypeCombo".equalsIgnoreCase(fieldName)) return "GenotypeFrequency.GenotypeCombo";
		if("FrequencyAsProportion".equalsIgnoreCase(fieldName)) return "GenotypeFrequency.FrequencyAsProportion";
		if("GenotypeFrequency_FrequencyAsProportion".equalsIgnoreCase(fieldName)) return "GenotypeFrequency.FrequencyAsProportion";
		if("NumberSamplesWithGenotype".equalsIgnoreCase(fieldName)) return "GenotypeFrequency.NumberSamplesWithGenotype";
		if("GenotypeFrequency_NumberSamplesWithGenotype".equalsIgnoreCase(fieldName)) return "GenotypeFrequency.NumberSamplesWithGenotype";
		if("ProtocolUsed_id".equalsIgnoreCase(fieldName)) return "DataSet.ProtocolUsed";
		if("GenotypeFrequency_ProtocolUsed_id".equalsIgnoreCase(fieldName)) return "DataSet.ProtocolUsed";
		if("ProtocolUsed_Identifier".equalsIgnoreCase(fieldName)) return "xref_ProtocolUsed.Identifier";	
		if("GenotypeFrequency_ProtocolUsed_Identifier".equalsIgnoreCase(fieldName)) return "xref_ProtocolUsed.Identifier";
		if("FrequencyCluster_id".equalsIgnoreCase(fieldName)) return "GenotypeFrequency.FrequencyCluster";
		if("GenotypeFrequency_FrequencyCluster_id".equalsIgnoreCase(fieldName)) return "GenotypeFrequency.FrequencyCluster";
		if("FrequencyCluster_Identifier".equalsIgnoreCase(fieldName)) return "xref_FrequencyCluster.Identifier";	
		if("GenotypeFrequency_FrequencyCluster_Identifier".equalsIgnoreCase(fieldName)) return "xref_FrequencyCluster.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.gwascentral.GenotypeFrequency> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.gwascentral.GenotypeFrequency>(size); 
	}			

	public org.molgenis.gwascentral.GenotypeFrequency create()
	{
		return new org.molgenis.gwascentral.GenotypeFrequency();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.gwascentral.GenotypeFrequency> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'protocolUsed' to protocol.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> protocolUsedRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'frequencyCluster' to frequencyCluster.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> frequencyClusterRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.gwascentral.GenotypeFrequency object: entities)
		{
			//create xref/mref rule filtering Protocol on the label Identifier
			if(object.getProtocolUsed_Id() == null && object.getProtocolUsed_Identifier() != null)
			{
				Object label = object.getProtocolUsed_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !protocolUsedRules.containsKey(label))
					{
						protocolUsedRules.put(""+label, xrefFilter);
						protocolUsedRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering FrequencyCluster on the label Identifier
			if(object.getFrequencyCluster_Id() == null && object.getFrequencyCluster_Identifier() != null)
			{
				Object label = object.getFrequencyCluster_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !frequencyClusterRules.containsKey(label))
					{
						frequencyClusterRules.put(""+label, xrefFilter);
						frequencyClusterRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
		}

		//resolve foreign key field 'protocolUsed' to protocol.id using Identifier)
		final java.util.Map<String,Integer> protocolUsed_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(protocolUsedRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.observ.Protocol> protocolUsedList = null;
			try
			{
				protocolUsedList = getDatabase().find(org.molgenis.observ.Protocol.class, protocolUsedRules.values().toArray(new org.molgenis.framework.db.QueryRule[protocolUsedRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.observ.Protocol xref :  protocolUsedList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				protocolUsed_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'frequencyCluster' to frequencyCluster.id using Identifier)
		final java.util.Map<String,Integer> frequencyCluster_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(frequencyClusterRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.gwascentral.FrequencyCluster> frequencyClusterList = null;
			try
			{
				frequencyClusterList = getDatabase().find(org.molgenis.gwascentral.FrequencyCluster.class, frequencyClusterRules.values().toArray(new org.molgenis.framework.db.QueryRule[frequencyClusterRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.gwascentral.FrequencyCluster xref :  frequencyClusterList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				frequencyCluster_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.gwascentral.GenotypeFrequency object = entities.get(i);		
			//update object using label fields Identifier
			if(object.getProtocolUsed_Id() == null )
			{
					String key = "";
					if(object.getProtocolUsed_Identifier() != null)
						key += 	object.getProtocolUsed_Identifier();
					
					if(!"".equals(key) && protocolUsed_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("ProtocolUsed_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setProtocolUsed_Id(protocolUsed_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields Identifier
			if(object.getFrequencyCluster_Id() == null )
			{
					String key = "";
					if(object.getFrequencyCluster_Identifier() != null)
						key += 	object.getFrequencyCluster_Identifier();
					
					if(!"".equals(key) && frequencyCluster_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("FrequencyCluster_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setFrequencyCluster_Id(frequencyCluster_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "genotypeFrequency.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("identifier".equalsIgnoreCase(fieldName) || "characteristic.identifier".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("name".equalsIgnoreCase(fieldName) || "characteristic.name".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("__Type".equalsIgnoreCase(fieldName) || "characteristic.__Type".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.EnumField();
			if("description".equalsIgnoreCase(fieldName) || "characteristic.description".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("protocolUsed".equalsIgnoreCase(fieldName) || "dataSet.protocolUsed".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("startTime".equalsIgnoreCase(fieldName) || "dataSet.startTime".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.DatetimeField();
			if("endTime".equalsIgnoreCase(fieldName) || "dataSet.endTime".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.DatetimeField();
			if("frequencyCluster".equalsIgnoreCase(fieldName) || "genotypeFrequency.frequencyCluster".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("genotypeCombo".equalsIgnoreCase(fieldName) || "genotypeFrequency.genotypeCombo".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("frequencyAsProportion".equalsIgnoreCase(fieldName) || "genotypeFrequency.frequencyAsProportion".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.DecimalField();
			if("numberSamplesWithGenotype".equalsIgnoreCase(fieldName) || "genotypeFrequency.numberSamplesWithGenotype".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, GenotypeFrequency entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.gwascentral.GenotypeFrequency> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.gwascentral.GenotypeFrequency> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<GenotypeFrequency> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<GenotypeFrequency> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<GenotypeFrequency> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
