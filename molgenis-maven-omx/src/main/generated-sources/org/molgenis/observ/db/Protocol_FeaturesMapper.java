/* File:        org.molgenis/model/Protocol_Features.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 26, 2012
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
import org.molgenis.observ.Protocol_Features;

import org.molgenis.observ.ObservableFeature;
import org.molgenis.observ.Protocol;

public class Protocol_FeaturesMapper extends AbstractJDBCMapper<Protocol_Features>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends Protocol_Features> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO Protocol_Features (Features,Protocol) VALUES ");
		{
		
			boolean first = true;
			for(Protocol_Features e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//features
				if(e.getFeatures_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getFeatures_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//protocol
				if(e.getProtocol_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getProtocol_Id().toString())+"'"
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
	public int executeUpdate(List<? extends Protocol_Features> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO Protocol_Features (autoid,Features,Protocol) VALUES ");		
		boolean first = true;
		for(Protocol_Features e: entities)
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
		
			//features


			if(e.getFeatures_Id() != null){
                sql.append("'"+this.escapeSql(e.getFeatures_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//protocol


			if(e.getProtocol_Id() != null){
                sql.append("'"+this.escapeSql(e.getProtocol_Id()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE autoid=LAST_INSERT_ID(autoid),Features=VALUES(Features),Protocol=VALUES(Protocol)");

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
	public int executeRemove(List<? extends Protocol_Features> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM Protocol_Features WHERE ");
		
		//key $f_index: autoid
		{
			sql.append("autoid in (");
			boolean first = true;
			for(Protocol_Features e: entities)
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
	
	public Protocol_FeaturesMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT Protocol_Features.autoid"
			+", Protocol_Features.Features"
			+", Protocol_Features.Protocol"
			//parent is SimpleTree(name='Features')
			+", xref_Features.Identifier AS Features_Identifier"
			//parent is SimpleTree(name='Protocol')
			+", xref_Protocol.Identifier AS Protocol_Identifier"
			+" FROM Protocol_Features "

			
			//label for Features=Identifier
//path==Features. type==xref.
//path==Features_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Characteristic AS xref_Features " 
			+" ON xref_Features.id = Protocol_Features.Features"
			
			//label for Protocol=Identifier
//path==Protocol. type==xref.
//path==Protocol_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Characteristic AS xref_Protocol " 
			+" ON xref_Protocol.id = Protocol_Features.Protocol"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM Protocol_Features "
			
			//label for Features=Identifier
//Features
//Features_Identifier
		   	+" LEFT JOIN Characteristic AS xref_Features " 
			+" ON xref_Features.id = Protocol_Features.Features"
			
			//label for Protocol=Identifier
//Protocol
//Protocol_Identifier
		   	+" LEFT JOIN Characteristic AS xref_Protocol " 
			+" ON xref_Protocol.id = Protocol_Features.Protocol"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("autoid".equalsIgnoreCase(fieldName)) return "Protocol_Features.autoid";
		if("Protocol_Features_autoid".equalsIgnoreCase(fieldName)) return "Protocol_Features.autoid";
		if("Features".equalsIgnoreCase(fieldName)) return "Protocol_Features.Features";
		if("Protocol_Features_Features".equalsIgnoreCase(fieldName)) return "Protocol_Features.Features";
		if("Protocol".equalsIgnoreCase(fieldName)) return "Protocol_Features.Protocol";
		if("Protocol_Features_Protocol".equalsIgnoreCase(fieldName)) return "Protocol_Features.Protocol";
		if("Features_id".equalsIgnoreCase(fieldName)) return "Protocol_Features.Features";
		if("Protocol_Features_Features_id".equalsIgnoreCase(fieldName)) return "Protocol_Features.Features";
		if("Features_Identifier".equalsIgnoreCase(fieldName)) return "xref_Features.Identifier";	
		if("Protocol_Features_Features_Identifier".equalsIgnoreCase(fieldName)) return "xref_Features.Identifier";
		if("Protocol_id".equalsIgnoreCase(fieldName)) return "Protocol_Features.Protocol";
		if("Protocol_Features_Protocol_id".equalsIgnoreCase(fieldName)) return "Protocol_Features.Protocol";
		if("Protocol_Identifier".equalsIgnoreCase(fieldName)) return "xref_Protocol.Identifier";	
		if("Protocol_Features_Protocol_Identifier".equalsIgnoreCase(fieldName)) return "xref_Protocol.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.observ.Protocol_Features> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.observ.Protocol_Features>(size); 
	}			

	public org.molgenis.observ.Protocol_Features create()
	{
		return new org.molgenis.observ.Protocol_Features();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.observ.Protocol_Features> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'features' to observableFeature.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> featuresRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'protocol' to protocol.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> protocolRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.observ.Protocol_Features object: entities)
		{
			//create xref/mref rule filtering ObservableFeature on the label Identifier
			if(object.getFeatures_Id() == null && object.getFeatures_Identifier() != null)
			{
				Object label = object.getFeatures_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !featuresRules.containsKey(label))
					{
						featuresRules.put(""+label, xrefFilter);
						featuresRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering Protocol on the label Identifier
			if(object.getProtocol_Id() == null && object.getProtocol_Identifier() != null)
			{
				Object label = object.getProtocol_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !protocolRules.containsKey(label))
					{
						protocolRules.put(""+label, xrefFilter);
						protocolRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
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
		//resolve foreign key field 'protocol' to protocol.id using Identifier)
		final java.util.Map<String,Integer> protocol_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(protocolRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.observ.Protocol> protocolList = null;
			try
			{
				protocolList = getDatabase().find(org.molgenis.observ.Protocol.class, protocolRules.values().toArray(new org.molgenis.framework.db.QueryRule[protocolRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.observ.Protocol xref :  protocolList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				protocol_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.observ.Protocol_Features object = entities.get(i);		
			//update object using label fields Identifier
			if(object.getFeatures_Id() == null )
			{
					String key = "";
					if(object.getFeatures_Identifier() != null)
						key += 	object.getFeatures_Identifier();
					
					if(!"".equals(key) && features_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Features_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setFeatures_Id(features_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields Identifier
			if(object.getProtocol_Id() == null )
			{
					String key = "";
					if(object.getProtocol_Identifier() != null)
						key += 	object.getProtocol_Identifier();
					
					if(!"".equals(key) && protocol_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Protocol_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setProtocol_Id(protocol_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("autoid".equalsIgnoreCase(fieldName) || "protocol_Features.autoid".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("features".equalsIgnoreCase(fieldName) || "protocol_Features.features".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("protocol".equalsIgnoreCase(fieldName) || "protocol_Features.protocol".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, Protocol_Features entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.observ.Protocol_Features> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.observ.Protocol_Features> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<Protocol_Features> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<Protocol_Features> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<Protocol_Features> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
