/* File:        org.molgenis.omx/model/Protocol.java
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
import org.molgenis.observ.Protocol;

import org.molgenis.observ.Characteristic;
import org.molgenis.observ.db.CharacteristicMapper;
import org.molgenis.observ.target.OntologyTerm;
import org.molgenis.observ.Protocol;
import org.molgenis.observ.Protocol_Subprotocols;
import org.molgenis.observ.ObservableFeature;
import org.molgenis.observ.Protocol_Features;

public class ProtocolMapper extends AbstractJDBCMapper<Protocol>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends Protocol> entities) throws DatabaseException
	{	
		//add superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.Characteristic.class).executeAdd(entities);
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO Protocol (ProtocolType,id) VALUES ");
		{
		
			boolean first = true;
			for(Protocol e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//protocolType
				if(e.getProtocolType_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getProtocolType_Id().toString())+"'"
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
	public int executeUpdate(List<? extends Protocol> entities) throws DatabaseException
	{
		//update superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.Characteristic.class).executeUpdate(entities);
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO Protocol (ProtocolType,id) VALUES ");		
		boolean first = true;
		for(Protocol e: entities)
		{
			// put the ,
			if(first)
				first = false;
			else
				sql.append(",");

			sql.append("(");
			
			//protocolType


			if(e.getProtocolType_Id() != null){
                sql.append("'"+this.escapeSql(e.getProtocolType_Id()).toString()+"'" +",");
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
		sql.append(" ON DUPLICATE KEY UPDATE ProtocolType=VALUES(ProtocolType),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends Protocol> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM Protocol WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(Protocol e: entities)
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
	
	public ProtocolMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT Protocol.id"
			+", Characteristic.Identifier"
			+", Characteristic.Name"
			+", Characteristic.__Type"
			+", Characteristic.description"
			+", Protocol.ProtocolType"
			//parent is SimpleTree(name='ProtocolType')
			+", xref_ProtocolType.Identifier AS ProtocolType_Identifier"
			+" FROM Protocol "
			+" INNER JOIN Characteristic ON (Protocol.id = Characteristic.id)"

			
			//label for ProtocolType=Identifier
//path==ProtocolType. type==xref.
//path==ProtocolType_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN OntologyTerm AS xref_ProtocolType " 
			+" ON xref_ProtocolType.id = Protocol.ProtocolType"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM Protocol "
			  +" INNER JOIN Characteristic ON (Protocol.id = Characteristic.id)"
			
			//label for ProtocolType=Identifier
//ProtocolType
//ProtocolType_Identifier
		   	+" LEFT JOIN OntologyTerm AS xref_ProtocolType " 
			+" ON xref_ProtocolType.id = Protocol.ProtocolType"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "Protocol.id";
		if("Protocol_id".equalsIgnoreCase(fieldName)) return "Protocol.id";
		if("Identifier".equalsIgnoreCase(fieldName)) return "Characteristic.Identifier";
		if("Protocol_Identifier".equalsIgnoreCase(fieldName)) return "Characteristic.Identifier";
		if("Name".equalsIgnoreCase(fieldName)) return "Characteristic.Name";
		if("Protocol_Name".equalsIgnoreCase(fieldName)) return "Characteristic.Name";
		if("__Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("Protocol___Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("description".equalsIgnoreCase(fieldName)) return "Characteristic.description";
		if("Protocol_description".equalsIgnoreCase(fieldName)) return "Characteristic.description";
		if("ProtocolType".equalsIgnoreCase(fieldName)) return "Protocol.ProtocolType";
		if("Protocol_ProtocolType".equalsIgnoreCase(fieldName)) return "Protocol.ProtocolType";
		if("ProtocolType_id".equalsIgnoreCase(fieldName)) return "Protocol.ProtocolType";
		if("Protocol_ProtocolType_id".equalsIgnoreCase(fieldName)) return "Protocol.ProtocolType";
		if("ProtocolType_Identifier".equalsIgnoreCase(fieldName)) return "xref_ProtocolType.Identifier";	
		if("Protocol_ProtocolType_Identifier".equalsIgnoreCase(fieldName)) return "xref_ProtocolType.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.observ.Protocol> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.observ.Protocol>(size); 
	}			

	public org.molgenis.observ.Protocol create()
	{
		return new org.molgenis.observ.Protocol();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.observ.Protocol> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'protocolType' to ontologyTerm.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> protocolTypeRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'subprotocols' to protocol.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> subprotocolsRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'features' to observableFeature.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> featuresRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.observ.Protocol object: entities)
		{
			//create xref/mref rule filtering OntologyTerm on the label Identifier
			if(object.getProtocolType_Id() == null && object.getProtocolType_Identifier() != null)
			{
				Object label = object.getProtocolType_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !protocolTypeRules.containsKey(label))
					{
						protocolTypeRules.put(""+label, xrefFilter);
						protocolTypeRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering Protocol on the label Identifier
			if(object.getSubprotocols_Id().size() == 0 && object.getSubprotocols_Identifier().size() > 0)
			{
				for(String label: object.getSubprotocols_Identifier())
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !subprotocolsRules.containsKey(label))
					{
						subprotocolsRules.put(""+label, xrefFilter);
						subprotocolsRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering ObservableFeature on the label Identifier
			if(object.getFeatures_Id().size() == 0 && object.getFeatures_Identifier().size() > 0)
			{
				for(String label: object.getFeatures_Identifier())
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !featuresRules.containsKey(label))
					{
						featuresRules.put(""+label, xrefFilter);
						featuresRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
		}

		//resolve foreign key field 'protocolType' to ontologyTerm.id using Identifier)
		final java.util.Map<String,Integer> protocolType_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(protocolTypeRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.observ.target.OntologyTerm> protocolTypeList = null;
			try
			{
				protocolTypeList = getDatabase().find(org.molgenis.observ.target.OntologyTerm.class, protocolTypeRules.values().toArray(new org.molgenis.framework.db.QueryRule[protocolTypeRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.observ.target.OntologyTerm xref :  protocolTypeList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				protocolType_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'subprotocols' to protocol.id using Identifier)
		final java.util.Map<String,Integer> subprotocols_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(subprotocolsRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.observ.Protocol> subprotocolsList = null;
			try
			{
				subprotocolsList = getDatabase().find(org.molgenis.observ.Protocol.class, subprotocolsRules.values().toArray(new org.molgenis.framework.db.QueryRule[subprotocolsRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.observ.Protocol xref :  subprotocolsList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				subprotocols_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'features' to observableFeature.id using Identifier)
		final java.util.Map<String,Integer> features_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(featuresRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.observ.ObservableFeature> featuresList = null;
			try
			{
				featuresList = getDatabase().find(org.molgenis.observ.ObservableFeature.class, featuresRules.values().toArray(new org.molgenis.framework.db.QueryRule[featuresRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.observ.ObservableFeature xref :  featuresList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				features_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.observ.Protocol object = entities.get(i);		
			//update object using label fields Identifier
			if(object.getProtocolType_Id() == null )
			{
					String key = "";
					if(object.getProtocolType_Identifier() != null)
						key += 	object.getProtocolType_Identifier();
					
					if(!"".equals(key) && protocolType_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("ProtocolType_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setProtocolType_Id(protocolType_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields Identifier
			if(object.getSubprotocols_Id() == null || object.getSubprotocols_Id().size() == 0)
			{
				java.util.List<Integer> idList = new java.util.ArrayList<Integer>();
				for(int j = 0; j < object.getSubprotocols_Identifier().size(); j++)
				{
					String key = "";
					if(object.getSubprotocols_Identifier().get(j) != null)
						key += 	object.getSubprotocols_Identifier().get(j);
					
					if(!"".equals(key) && subprotocols_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("subprotocols_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						idList.add(subprotocols_Labels_to_IdMap.get(key));
					}
				}
				object.setSubprotocols_Id(idList);
			}
			//update object using label fields Identifier
			if(object.getFeatures_Id() == null || object.getFeatures_Id().size() == 0)
			{
				java.util.List<Integer> idList = new java.util.ArrayList<Integer>();
				for(int j = 0; j < object.getFeatures_Identifier().size(); j++)
				{
					String key = "";
					if(object.getFeatures_Identifier().get(j) != null)
						key += 	object.getFeatures_Identifier().get(j);
					
					if(!"".equals(key) && features_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Features_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						idList.add(features_Labels_to_IdMap.get(key));
					}
				}
				object.setFeatures_Id(idList);
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "protocol.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("identifier".equalsIgnoreCase(fieldName) || "characteristic.identifier".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("name".equalsIgnoreCase(fieldName) || "characteristic.name".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("__Type".equalsIgnoreCase(fieldName) || "characteristic.__Type".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.EnumField();
			if("description".equalsIgnoreCase(fieldName) || "characteristic.description".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("protocolType".equalsIgnoreCase(fieldName) || "protocol.protocolType".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, Protocol entity)
	{
		entity.setId(i);
	}
	
	@Override
	public QueryRule rewriteMrefRule(Database db, QueryRule rule) throws DatabaseException
	{
		if("subprotocols".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// Protocol_subprotocols
			List<Protocol_Subprotocols> mref_mapping_entities = db.find(Protocol_Subprotocols.class, new QueryRule(
					"subprotocols", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (Protocol_Subprotocols mref : mref_mapping_entities) mref_ids.add(mref.getProtocol_Id());
				return new QueryRule("id", Operator.IN, mref_ids);
			}		
			else
			{
				// no records to be shown
				return new QueryRule("id", Operator.EQUALS, Integer.MIN_VALUE);
			}			
		}
		else if("subprotocols_Identifier".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// Protocol_subprotocols
			List<Protocol_Subprotocols> mref_mapping_entities = db.find(Protocol_Subprotocols.class, new QueryRule(
					"subprotocols_Identifier", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (Protocol_Subprotocols mref : mref_mapping_entities) mref_ids.add(mref.getProtocol_Id());
				return new QueryRule("id", Operator.IN, mref_ids);
			}		
			else
			{
				// no records to be shown
				return new QueryRule("id", Operator.EQUALS, Integer.MIN_VALUE);
			}
		}
		else if("Features".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// Protocol_Features
			List<Protocol_Features> mref_mapping_entities = db.find(Protocol_Features.class, new QueryRule(
					"Features", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (Protocol_Features mref : mref_mapping_entities) mref_ids.add(mref.getProtocol_Id());
				return new QueryRule("id", Operator.IN, mref_ids);
			}		
			else
			{
				// no records to be shown
				return new QueryRule("id", Operator.EQUALS, Integer.MIN_VALUE);
			}			
		}
		else if("Features_Identifier".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// Protocol_Features
			List<Protocol_Features> mref_mapping_entities = db.find(Protocol_Features.class, new QueryRule(
					"Features_Identifier", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (Protocol_Features mref : mref_mapping_entities) mref_ids.add(mref.getProtocol_Id());
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
	public void prepareFileAttachements(java.util.List<org.molgenis.observ.Protocol> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.observ.Protocol> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<Protocol> entities ) throws DatabaseException			
	{
		try
		{
			//list the protocol ids to query
			List<Integer> protocolIds = new ArrayList<Integer>();
			for(Protocol entity: entities)
			{
				protocolIds.add(entity.getId());
			}
			
			//map the subprotocols mrefs
			List<Protocol_Subprotocols> subprotocols_mrefs = this.getDatabase().query(Protocol_Subprotocols.class).in("Protocol", protocolIds).sortASC("autoid").find();
			Map<Integer,List<Integer>> subprotocols_subprotocols_map = new LinkedHashMap<Integer,List<Integer>>();
			Map<Integer,List<String>> subprotocols_Identifier_map = new LinkedHashMap<Integer,List<String>>();
			
			for(Protocol_Subprotocols ref: subprotocols_mrefs)
			{
				if(subprotocols_subprotocols_map.get(ref.getProtocol_Id()) == null) subprotocols_subprotocols_map.put(ref.getProtocol_Id(),new ArrayList<Integer>()); 
				subprotocols_subprotocols_map.get(ref.getProtocol_Id()).add(ref.getSubprotocols_Id());
				if(subprotocols_Identifier_map.get(ref.getProtocol_Id()) == null)	subprotocols_Identifier_map.put(ref.getProtocol_Id(),new ArrayList<String>());
				subprotocols_Identifier_map.get(ref.getProtocol_Id()).add(ref.getSubprotocols_Identifier());
			}
			//map the Features mrefs
			List<Protocol_Features> features_mrefs = this.getDatabase().query(Protocol_Features.class).in("Protocol", protocolIds).sortASC("autoid").find();
			Map<Integer,List<Integer>> features_features_map = new LinkedHashMap<Integer,List<Integer>>();
			Map<Integer,List<String>> features_Identifier_map = new LinkedHashMap<Integer,List<String>>();
			
			for(Protocol_Features ref: features_mrefs)
			{
				if(features_features_map.get(ref.getProtocol_Id()) == null) features_features_map.put(ref.getProtocol_Id(),new ArrayList<Integer>()); 
				features_features_map.get(ref.getProtocol_Id()).add(ref.getFeatures_Id());
				if(features_Identifier_map.get(ref.getProtocol_Id()) == null)	features_Identifier_map.put(ref.getProtocol_Id(),new ArrayList<String>());
				features_Identifier_map.get(ref.getProtocol_Id()).add(ref.getFeatures_Identifier());
			}
			
			//load the mapped data into the entities
			for(Protocol entity: entities)
			{
				Integer id = entity.getId();
				if(subprotocols_subprotocols_map.get(id) != null)
				{
					entity.setSubprotocols_Id(subprotocols_subprotocols_map.get(id));
				}
				if(subprotocols_Identifier_map.get(id) != null)
				{
					entity.setSubprotocols_Identifier(subprotocols_Identifier_map.get(id));
				}
				if(features_features_map.get(id) != null)
				{
					entity.setFeatures_Id(features_features_map.get(id));
				}
				if(features_Identifier_map.get(id) != null)
				{
					entity.setFeatures_Identifier(features_Identifier_map.get(id));
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
	public void storeMrefs( List<Protocol> entities ) throws DatabaseException, IOException, ParseException	
	{
		//create an List of Protocol ids to query for
		List<Integer> entityIds = new ArrayList<Integer>(); 
		for (Protocol entity : entities) 
		{
			entityIds.add(entity.getId());		
		}
		
		//delete existing mrefs
		getDatabase().remove(getDatabase().query( Protocol_Subprotocols.class).in("Protocol", entityIds).find());
		List<Protocol_Subprotocols> protocol_subprotocolsToAdd = new ArrayList<Protocol_Subprotocols>();

		//delete existing mrefs
		getDatabase().remove(getDatabase().query( Protocol_Features.class).in("Protocol", entityIds).find());
		List<Protocol_Features> protocol_FeaturesToAdd = new ArrayList<Protocol_Features>();


		//check for each mref what needs to be added
		for(Protocol entity: entities)
		{
			//remove duplicates using Set
			entity.setSubprotocols(new ArrayList(new LinkedHashSet(entity.getSubprotocols_Id())));
			for(Integer id: entity.getSubprotocols_Id())
			{
				Protocol_Subprotocols new_mref = new Protocol_Subprotocols();
				new_mref.setProtocol( entity.getId() );
				new_mref.setSubprotocols( id );
				protocol_subprotocolsToAdd.add(new_mref);
			}
			
			//remove duplicates using Set
			entity.setFeatures(new ArrayList(new LinkedHashSet(entity.getFeatures_Id())));
			for(Integer id: entity.getFeatures_Id())
			{
				Protocol_Features new_mref = new Protocol_Features();
				new_mref.setProtocol( entity.getId() );
				new_mref.setFeatures( id );
				protocol_FeaturesToAdd.add(new_mref);
			}
			
		}
		
		//process changes to Protocol_subprotocols
		getDatabase().add( protocol_subprotocolsToAdd );
		//process changes to Protocol_Features
		getDatabase().add( protocol_FeaturesToAdd );
	}
		
	
	public void removeMrefs( List<Protocol> entities ) throws DatabaseException, IOException, ParseException
	{
		//create an list of Protocol ids to query for
		List<Integer> entityIds = new ArrayList<Integer>(); 
		for (Protocol entity : entities) 
		{
			entityIds.add(entity.getId());		
		}	
	
		//remove all Protocol_subprotocols elements for field entity.subprotocols
		getDatabase().remove( getDatabase().query( Protocol_Subprotocols.class).in("Protocol", entityIds).find() );
		//remove all Protocol_Features elements for field entity.Features
		getDatabase().remove( getDatabase().query( Protocol_Features.class).in("Protocol", entityIds).find() );
	}	
}
