/* File:        org.molgenis.omx/model/PhenotypeMethod.java
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
import org.molgenis.gwascentral.PhenotypeMethod;

import org.molgenis.observ.DataSet;
import org.molgenis.observ.db.DataSetMapper;
import org.molgenis.observ.Protocol;
import org.molgenis.organization.Study;
import org.molgenis.gwascentral.PhenotypeProperty;

public class PhenotypeMethodMapper extends AbstractJDBCMapper<PhenotypeMethod>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends PhenotypeMethod> entities) throws DatabaseException
	{	
		//add superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.DataSet.class).executeAdd(entities);
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO PhenotypeMethod (id,Identifier,Name,StudyID,PhenotypePropertyID,Sample) VALUES ");
		{
		
			boolean first = true;
			for(PhenotypeMethod e: entities)
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
				+",");
				}
				else{
					sql.append("null,");
				}
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
				//studyID
				if(e.getStudyID_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getStudyID_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//phenotypePropertyID
				if(e.getPhenotypePropertyID_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getPhenotypePropertyID_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//sample
				if(e.getSample() != null){
								
					sql.append("'"+this.escapeSql(e.getSample().toString())+"'"
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
	public int executeUpdate(List<? extends PhenotypeMethod> entities) throws DatabaseException
	{
		//update superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.DataSet.class).executeUpdate(entities);
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO PhenotypeMethod (id,Identifier,Name,StudyID,PhenotypePropertyID,Sample) VALUES ");		
		boolean first = true;
		for(PhenotypeMethod e: entities)
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
		
			//studyID


			if(e.getStudyID_Id() != null){
                sql.append("'"+this.escapeSql(e.getStudyID_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//phenotypePropertyID


			if(e.getPhenotypePropertyID_Id() != null){
                sql.append("'"+this.escapeSql(e.getPhenotypePropertyID_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//sample


			if(e.getSample() != null){
                sql.append("'"+this.escapeSql(e.getSample()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE StudyID=VALUES(StudyID),PhenotypePropertyID=VALUES(PhenotypePropertyID),Name=VALUES(Name),Sample=VALUES(Sample),Identifier=VALUES(Identifier),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends PhenotypeMethod> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM PhenotypeMethod WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(PhenotypeMethod e: entities)
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
	
	public PhenotypeMethodMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT PhenotypeMethod.id"
			+", PhenotypeMethod.Identifier"
			+", PhenotypeMethod.Name"
			+", Characteristic.__Type"
			+", Characteristic.description"
			+", DataSet.ProtocolUsed"
			+", DataSet.startTime"
			+", DataSet.endTime"
			+", PhenotypeMethod.StudyID"
			+", PhenotypeMethod.PhenotypePropertyID"
			+", PhenotypeMethod.Sample"
			//parent is SimpleTree(name='ProtocolUsed')
			+", xref_ProtocolUsed.Identifier AS ProtocolUsed_Identifier"
			//parent is SimpleTree(name='StudyID')
			+", xref_StudyID.Identifier AS StudyID_Identifier"
			//parent is SimpleTree(name='PhenotypePropertyID')
			+", xref_PhenotypePropertyID.Identifier AS PhenotypePropertyID_Identifier"
			+" FROM PhenotypeMethod "
			+" INNER JOIN DataSet ON (PhenotypeMethod.id = DataSet.id)"
			+" INNER JOIN Characteristic ON (PhenotypeMethod.id = Characteristic.id)"

			
			//label for ProtocolUsed=Identifier
//path==ProtocolUsed. type==xref.
//path==ProtocolUsed_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Characteristic AS xref_ProtocolUsed " 
			+" ON xref_ProtocolUsed.id = DataSet.ProtocolUsed"
			
			//label for StudyID=Identifier
//path==StudyID. type==xref.
//path==StudyID_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Study AS xref_StudyID " 
			+" ON xref_StudyID.id = PhenotypeMethod.StudyID"
			
			//label for PhenotypePropertyID=Identifier
//path==PhenotypePropertyID. type==xref.
//path==PhenotypePropertyID_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN PhenotypeProperty AS xref_PhenotypePropertyID " 
			+" ON xref_PhenotypePropertyID.id = PhenotypeMethod.PhenotypePropertyID"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM PhenotypeMethod "
			  +" INNER JOIN DataSet ON (PhenotypeMethod.id = DataSet.id)"
			  +" INNER JOIN Characteristic ON (PhenotypeMethod.id = Characteristic.id)"
			
			//label for ProtocolUsed=Identifier
//ProtocolUsed
//ProtocolUsed_Identifier
		   	+" LEFT JOIN Characteristic AS xref_ProtocolUsed " 
			+" ON xref_ProtocolUsed.id = DataSet.ProtocolUsed"
			
			//label for StudyID=Identifier
//StudyID
//StudyID_Identifier
		   	+" LEFT JOIN Study AS xref_StudyID " 
			+" ON xref_StudyID.id = PhenotypeMethod.StudyID"
			
			//label for PhenotypePropertyID=Identifier
//PhenotypePropertyID
//PhenotypePropertyID_Identifier
		   	+" LEFT JOIN PhenotypeProperty AS xref_PhenotypePropertyID " 
			+" ON xref_PhenotypePropertyID.id = PhenotypeMethod.PhenotypePropertyID"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "PhenotypeMethod.id";
		if("PhenotypeMethod_id".equalsIgnoreCase(fieldName)) return "PhenotypeMethod.id";
		if("Identifier".equalsIgnoreCase(fieldName)) return "PhenotypeMethod.Identifier";
		if("PhenotypeMethod_Identifier".equalsIgnoreCase(fieldName)) return "PhenotypeMethod.Identifier";
		if("Name".equalsIgnoreCase(fieldName)) return "PhenotypeMethod.Name";
		if("PhenotypeMethod_Name".equalsIgnoreCase(fieldName)) return "PhenotypeMethod.Name";
		if("__Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("PhenotypeMethod___Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("description".equalsIgnoreCase(fieldName)) return "Characteristic.description";
		if("PhenotypeMethod_description".equalsIgnoreCase(fieldName)) return "Characteristic.description";
		if("ProtocolUsed".equalsIgnoreCase(fieldName)) return "DataSet.ProtocolUsed";
		if("PhenotypeMethod_ProtocolUsed".equalsIgnoreCase(fieldName)) return "DataSet.ProtocolUsed";
		if("startTime".equalsIgnoreCase(fieldName)) return "DataSet.startTime";
		if("PhenotypeMethod_startTime".equalsIgnoreCase(fieldName)) return "DataSet.startTime";
		if("endTime".equalsIgnoreCase(fieldName)) return "DataSet.endTime";
		if("PhenotypeMethod_endTime".equalsIgnoreCase(fieldName)) return "DataSet.endTime";
		if("StudyID".equalsIgnoreCase(fieldName)) return "PhenotypeMethod.StudyID";
		if("PhenotypeMethod_StudyID".equalsIgnoreCase(fieldName)) return "PhenotypeMethod.StudyID";
		if("PhenotypePropertyID".equalsIgnoreCase(fieldName)) return "PhenotypeMethod.PhenotypePropertyID";
		if("PhenotypeMethod_PhenotypePropertyID".equalsIgnoreCase(fieldName)) return "PhenotypeMethod.PhenotypePropertyID";
		if("Sample".equalsIgnoreCase(fieldName)) return "PhenotypeMethod.Sample";
		if("PhenotypeMethod_Sample".equalsIgnoreCase(fieldName)) return "PhenotypeMethod.Sample";
		if("ProtocolUsed_id".equalsIgnoreCase(fieldName)) return "DataSet.ProtocolUsed";
		if("PhenotypeMethod_ProtocolUsed_id".equalsIgnoreCase(fieldName)) return "DataSet.ProtocolUsed";
		if("ProtocolUsed_Identifier".equalsIgnoreCase(fieldName)) return "xref_ProtocolUsed.Identifier";	
		if("PhenotypeMethod_ProtocolUsed_Identifier".equalsIgnoreCase(fieldName)) return "xref_ProtocolUsed.Identifier";
		if("StudyID_id".equalsIgnoreCase(fieldName)) return "PhenotypeMethod.StudyID";
		if("PhenotypeMethod_StudyID_id".equalsIgnoreCase(fieldName)) return "PhenotypeMethod.StudyID";
		if("StudyID_Identifier".equalsIgnoreCase(fieldName)) return "xref_StudyID.Identifier";	
		if("PhenotypeMethod_StudyID_Identifier".equalsIgnoreCase(fieldName)) return "xref_StudyID.Identifier";
		if("PhenotypePropertyID_id".equalsIgnoreCase(fieldName)) return "PhenotypeMethod.PhenotypePropertyID";
		if("PhenotypeMethod_PhenotypePropertyID_id".equalsIgnoreCase(fieldName)) return "PhenotypeMethod.PhenotypePropertyID";
		if("PhenotypePropertyID_Identifier".equalsIgnoreCase(fieldName)) return "xref_PhenotypePropertyID.Identifier";	
		if("PhenotypeMethod_PhenotypePropertyID_Identifier".equalsIgnoreCase(fieldName)) return "xref_PhenotypePropertyID.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.gwascentral.PhenotypeMethod> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.gwascentral.PhenotypeMethod>(size); 
	}			

	public org.molgenis.gwascentral.PhenotypeMethod create()
	{
		return new org.molgenis.gwascentral.PhenotypeMethod();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.gwascentral.PhenotypeMethod> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'protocolUsed' to protocol.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> protocolUsedRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'studyID' to study.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> studyIDRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'phenotypePropertyID' to phenotypeProperty.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> phenotypePropertyIDRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.gwascentral.PhenotypeMethod object: entities)
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
			//create xref/mref rule filtering Study on the label Identifier
			if(object.getStudyID_Id() == null && object.getStudyID_Identifier() != null)
			{
				Object label = object.getStudyID_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !studyIDRules.containsKey(label))
					{
						studyIDRules.put(""+label, xrefFilter);
						studyIDRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering PhenotypeProperty on the label Identifier
			if(object.getPhenotypePropertyID_Id() == null && object.getPhenotypePropertyID_Identifier() != null)
			{
				Object label = object.getPhenotypePropertyID_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !phenotypePropertyIDRules.containsKey(label))
					{
						phenotypePropertyIDRules.put(""+label, xrefFilter);
						phenotypePropertyIDRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
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
		//resolve foreign key field 'studyID' to study.id using Identifier)
		final java.util.Map<String,Integer> studyID_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(studyIDRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.organization.Study> studyIDList = null;
			try
			{
				studyIDList = getDatabase().find(org.molgenis.organization.Study.class, studyIDRules.values().toArray(new org.molgenis.framework.db.QueryRule[studyIDRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.organization.Study xref :  studyIDList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				studyID_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'phenotypePropertyID' to phenotypeProperty.id using Identifier)
		final java.util.Map<String,Integer> phenotypePropertyID_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(phenotypePropertyIDRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.gwascentral.PhenotypeProperty> phenotypePropertyIDList = null;
			try
			{
				phenotypePropertyIDList = getDatabase().find(org.molgenis.gwascentral.PhenotypeProperty.class, phenotypePropertyIDRules.values().toArray(new org.molgenis.framework.db.QueryRule[phenotypePropertyIDRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.gwascentral.PhenotypeProperty xref :  phenotypePropertyIDList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				phenotypePropertyID_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.gwascentral.PhenotypeMethod object = entities.get(i);		
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
			if(object.getStudyID_Id() == null )
			{
					String key = "";
					if(object.getStudyID_Identifier() != null)
						key += 	object.getStudyID_Identifier();
					
					if(!"".equals(key) && studyID_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("StudyID_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setStudyID_Id(studyID_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields Identifier
			if(object.getPhenotypePropertyID_Id() == null )
			{
					String key = "";
					if(object.getPhenotypePropertyID_Identifier() != null)
						key += 	object.getPhenotypePropertyID_Identifier();
					
					if(!"".equals(key) && phenotypePropertyID_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("PhenotypePropertyID_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setPhenotypePropertyID_Id(phenotypePropertyID_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "phenotypeMethod.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("identifier".equalsIgnoreCase(fieldName) || "phenotypeMethod.identifier".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("name".equalsIgnoreCase(fieldName) || "phenotypeMethod.name".equalsIgnoreCase(fieldName)) 
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
			if("studyID".equalsIgnoreCase(fieldName) || "phenotypeMethod.studyID".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("phenotypePropertyID".equalsIgnoreCase(fieldName) || "phenotypeMethod.phenotypePropertyID".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("sample".equalsIgnoreCase(fieldName) || "phenotypeMethod.sample".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, PhenotypeMethod entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.gwascentral.PhenotypeMethod> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.gwascentral.PhenotypeMethod> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<PhenotypeMethod> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<PhenotypeMethod> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<PhenotypeMethod> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
