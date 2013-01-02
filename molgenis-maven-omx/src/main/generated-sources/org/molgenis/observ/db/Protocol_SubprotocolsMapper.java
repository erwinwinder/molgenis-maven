/* File:        org.molgenis.omx/model/Protocol_subprotocols.java
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
import org.molgenis.observ.Protocol_Subprotocols;

import org.molgenis.observ.Protocol;
import org.molgenis.observ.Protocol;

public class Protocol_SubprotocolsMapper extends AbstractJDBCMapper<Protocol_Subprotocols>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends Protocol_Subprotocols> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO Protocol_subprotocols (subprotocols,Protocol) VALUES ");
		{
		
			boolean first = true;
			for(Protocol_Subprotocols e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//subprotocols
				if(e.getSubprotocols_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getSubprotocols_Id().toString())+"'"
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
	public int executeUpdate(List<? extends Protocol_Subprotocols> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO Protocol_subprotocols (autoid,subprotocols,Protocol) VALUES ");		
		boolean first = true;
		for(Protocol_Subprotocols e: entities)
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
		
			//subprotocols


			if(e.getSubprotocols_Id() != null){
                sql.append("'"+this.escapeSql(e.getSubprotocols_Id()).toString()+"'" +",");
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
		sql.append(" ON DUPLICATE KEY UPDATE autoid=LAST_INSERT_ID(autoid),subprotocols=VALUES(subprotocols),Protocol=VALUES(Protocol)");

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
	public int executeRemove(List<? extends Protocol_Subprotocols> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM Protocol_subprotocols WHERE ");
		
		//key $f_index: autoid
		{
			sql.append("autoid in (");
			boolean first = true;
			for(Protocol_Subprotocols e: entities)
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
	
	public Protocol_SubprotocolsMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT Protocol_subprotocols.autoid"
			+", Protocol_subprotocols.subprotocols"
			+", Protocol_subprotocols.Protocol"
			//parent is SimpleTree(name='subprotocols')
			+", xref_subprotocols.Identifier AS subprotocols_Identifier"
			//parent is SimpleTree(name='Protocol')
			+", xref_Protocol.Identifier AS Protocol_Identifier"
			+" FROM Protocol_subprotocols "

			
			//label for subprotocols=Identifier
//path==subprotocols. type==xref.
//path==subprotocols_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Characteristic AS xref_subprotocols " 
			+" ON xref_subprotocols.id = Protocol_subprotocols.subprotocols"
			
			//label for Protocol=Identifier
//path==Protocol. type==xref.
//path==Protocol_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Characteristic AS xref_Protocol " 
			+" ON xref_Protocol.id = Protocol_subprotocols.Protocol"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM Protocol_subprotocols "
			
			//label for subprotocols=Identifier
//subprotocols
//subprotocols_Identifier
		   	+" LEFT JOIN Characteristic AS xref_subprotocols " 
			+" ON xref_subprotocols.id = Protocol_subprotocols.subprotocols"
			
			//label for Protocol=Identifier
//Protocol
//Protocol_Identifier
		   	+" LEFT JOIN Characteristic AS xref_Protocol " 
			+" ON xref_Protocol.id = Protocol_subprotocols.Protocol"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("autoid".equalsIgnoreCase(fieldName)) return "Protocol_subprotocols.autoid";
		if("Protocol_subprotocols_autoid".equalsIgnoreCase(fieldName)) return "Protocol_subprotocols.autoid";
		if("subprotocols".equalsIgnoreCase(fieldName)) return "Protocol_subprotocols.subprotocols";
		if("Protocol_subprotocols_subprotocols".equalsIgnoreCase(fieldName)) return "Protocol_subprotocols.subprotocols";
		if("Protocol".equalsIgnoreCase(fieldName)) return "Protocol_subprotocols.Protocol";
		if("Protocol_subprotocols_Protocol".equalsIgnoreCase(fieldName)) return "Protocol_subprotocols.Protocol";
		if("subprotocols_id".equalsIgnoreCase(fieldName)) return "Protocol_subprotocols.subprotocols";
		if("Protocol_subprotocols_subprotocols_id".equalsIgnoreCase(fieldName)) return "Protocol_subprotocols.subprotocols";
		if("subprotocols_Identifier".equalsIgnoreCase(fieldName)) return "xref_subprotocols.Identifier";	
		if("Protocol_subprotocols_subprotocols_Identifier".equalsIgnoreCase(fieldName)) return "xref_subprotocols.Identifier";
		if("Protocol_id".equalsIgnoreCase(fieldName)) return "Protocol_subprotocols.Protocol";
		if("Protocol_subprotocols_Protocol_id".equalsIgnoreCase(fieldName)) return "Protocol_subprotocols.Protocol";
		if("Protocol_Identifier".equalsIgnoreCase(fieldName)) return "xref_Protocol.Identifier";	
		if("Protocol_subprotocols_Protocol_Identifier".equalsIgnoreCase(fieldName)) return "xref_Protocol.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.observ.Protocol_Subprotocols> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.observ.Protocol_Subprotocols>(size); 
	}			

	public org.molgenis.observ.Protocol_Subprotocols create()
	{
		return new org.molgenis.observ.Protocol_Subprotocols();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.observ.Protocol_Subprotocols> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'subprotocols' to protocol.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> subprotocolsRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'protocol' to protocol.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> protocolRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.observ.Protocol_Subprotocols object: entities)
		{
			//create xref/mref rule filtering Protocol on the label Identifier
			if(object.getSubprotocols_Id() == null && object.getSubprotocols_Identifier() != null)
			{
				Object label = object.getSubprotocols_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !subprotocolsRules.containsKey(label))
					{
						subprotocolsRules.put(""+label, xrefFilter);
						subprotocolsRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
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
			org.molgenis.observ.Protocol_Subprotocols object = entities.get(i);		
			//update object using label fields Identifier
			if(object.getSubprotocols_Id() == null )
			{
					String key = "";
					if(object.getSubprotocols_Identifier() != null)
						key += 	object.getSubprotocols_Identifier();
					
					if(!"".equals(key) && subprotocols_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("subprotocols_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setSubprotocols_Id(subprotocols_Labels_to_IdMap.get(key));
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
			if("autoid".equalsIgnoreCase(fieldName) || "protocol_subprotocols.autoid".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("subprotocols".equalsIgnoreCase(fieldName) || "protocol_subprotocols.subprotocols".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("protocol".equalsIgnoreCase(fieldName) || "protocol_subprotocols.protocol".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, Protocol_Subprotocols entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.observ.Protocol_Subprotocols> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.observ.Protocol_Subprotocols> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<Protocol_Subprotocols> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<Protocol_Subprotocols> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<Protocol_Subprotocols> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
