/* File:        org.molgenis/model/MolgenisPermission.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 26, 2012
 * Template:	MultiqueryMapperGen.java.ftl
 * generator:   org.molgenis.generators.db.MultiqueryMapperGen 4.0.0-testing
 *
 * Using "subclass per table" strategy
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.auth.db;

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
import org.molgenis.auth.MolgenisPermission;

import org.molgenis.auth.MolgenisRole;
import org.molgenis.core.MolgenisEntity;

public class MolgenisPermissionMapper extends AbstractJDBCMapper<MolgenisPermission>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends MolgenisPermission> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO MolgenisPermission (role_,entity,permission) VALUES ");
		{
		
			boolean first = true;
			for(MolgenisPermission e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//role_
				if(e.getRole_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getRole_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//entity
				if(e.getEntity_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getEntity_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//permission
				if(e.getPermission() != null){
								
					sql.append("'"+this.escapeSql(e.getPermission().toString())+"'"
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
	public int executeUpdate(List<? extends MolgenisPermission> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO MolgenisPermission (id,role_,entity,permission) VALUES ");		
		boolean first = true;
		for(MolgenisPermission e: entities)
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
		
			//role_


			if(e.getRole_Id() != null){
                sql.append("'"+this.escapeSql(e.getRole_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//entity


			if(e.getEntity_Id() != null){
                sql.append("'"+this.escapeSql(e.getEntity_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//permission


			if(e.getPermission() != null){
                sql.append("'"+this.escapeSql(e.getPermission())+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE role_=VALUES(role_),entity=VALUES(entity),permission=VALUES(permission),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends MolgenisPermission> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM MolgenisPermission WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(MolgenisPermission e: entities)
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
	
	public MolgenisPermissionMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT MolgenisPermission.id"
			+", MolgenisPermission.role_"
			+", MolgenisPermission.entity"
			+", MolgenisPermission.permission"
			//parent is SimpleTree(name='role_')
			+", xref_role_.name AS role__Name"
			//parent is SimpleTree(name='entity')
			+", xref_entity.className AS entity_ClassName"
			+" FROM MolgenisPermission "

			
			//label for role_=name
//path==role_. type==xref.
//path==role__Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN MolgenisRole AS xref_role_ " 
			+" ON xref_role_.id = MolgenisPermission.role_"
			
			//label for entity=className
//path==entity. type==xref.
//path==entity_ClassName. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN MolgenisEntity AS xref_entity " 
			+" ON xref_entity.id = MolgenisPermission.entity"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM MolgenisPermission "
			
			//label for role_=name
//role_
//role__Name
		   	+" LEFT JOIN MolgenisRole AS xref_role_ " 
			+" ON xref_role_.id = MolgenisPermission.role_"
			
			//label for entity=className
//entity
//entity_ClassName
		   	+" LEFT JOIN MolgenisEntity AS xref_entity " 
			+" ON xref_entity.id = MolgenisPermission.entity"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "MolgenisPermission.id";
		if("MolgenisPermission_id".equalsIgnoreCase(fieldName)) return "MolgenisPermission.id";
		if("role_".equalsIgnoreCase(fieldName)) return "MolgenisPermission.role_";
		if("MolgenisPermission_role_".equalsIgnoreCase(fieldName)) return "MolgenisPermission.role_";
		if("entity".equalsIgnoreCase(fieldName)) return "MolgenisPermission.entity";
		if("MolgenisPermission_entity".equalsIgnoreCase(fieldName)) return "MolgenisPermission.entity";
		if("permission".equalsIgnoreCase(fieldName)) return "MolgenisPermission.permission";
		if("MolgenisPermission_permission".equalsIgnoreCase(fieldName)) return "MolgenisPermission.permission";
		if("role__id".equalsIgnoreCase(fieldName)) return "MolgenisPermission.role_";
		if("MolgenisPermission_role__id".equalsIgnoreCase(fieldName)) return "MolgenisPermission.role_";
		if("role__Name".equalsIgnoreCase(fieldName)) return "xref_role_.name";	
		if("MolgenisPermission_role__Name".equalsIgnoreCase(fieldName)) return "xref_role_.name";
		if("entity_id".equalsIgnoreCase(fieldName)) return "MolgenisPermission.entity";
		if("MolgenisPermission_entity_id".equalsIgnoreCase(fieldName)) return "MolgenisPermission.entity";
		if("entity_ClassName".equalsIgnoreCase(fieldName)) return "xref_entity.className";	
		if("MolgenisPermission_entity_ClassName".equalsIgnoreCase(fieldName)) return "xref_entity.className";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.auth.MolgenisPermission> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.auth.MolgenisPermission>(size); 
	}			

	public org.molgenis.auth.MolgenisPermission create()
	{
		return new org.molgenis.auth.MolgenisPermission();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.auth.MolgenisPermission> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'role_' to molgenisRole.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> role_Rules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'entity' to molgenisEntity.id using className)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> entityRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.auth.MolgenisPermission object: entities)
		{
			//create xref/mref rule filtering MolgenisRole on the label name
			if(object.getRole_Id() == null && object.getRole_Name() != null)
			{
				Object label = object.getRole_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !role_Rules.containsKey(label))
					{
						role_Rules.put(""+label, xrefFilter);
						role_Rules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering MolgenisEntity on the label className
			if(object.getEntity_Id() == null && object.getEntity_ClassName() != null)
			{
				Object label = object.getEntity_ClassName();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("className", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !entityRules.containsKey(label))
					{
						entityRules.put(""+label, xrefFilter);
						entityRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
		}

		//resolve foreign key field 'role_' to molgenisRole.id using name)
		final java.util.Map<String,Integer> role__Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(role_Rules.size() > 0)
		{		
		
			java.util.List<org.molgenis.auth.MolgenisRole> role_List = null;
			try
			{
				role_List = getDatabase().find(org.molgenis.auth.MolgenisRole.class, role_Rules.values().toArray(new org.molgenis.framework.db.QueryRule[role_Rules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.auth.MolgenisRole xref :  role_List)
			{
				String key = "";
				key += 	xref.getName();
				
				role__Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'entity' to molgenisEntity.id using className)
		final java.util.Map<String,Integer> entity_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(entityRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.core.MolgenisEntity> entityList = null;
			try
			{
				entityList = getDatabase().find(org.molgenis.core.MolgenisEntity.class, entityRules.values().toArray(new org.molgenis.framework.db.QueryRule[entityRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.core.MolgenisEntity xref :  entityList)
			{
				String key = "";
				key += 	xref.getClassName();
				
				entity_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.auth.MolgenisPermission object = entities.get(i);		
			//update object using label fields name
			if(object.getRole_Id() == null )
			{
					String key = "";
					if(object.getRole_Name() != null)
						key += 	object.getRole_Name();
					
					if(!"".equals(key) && role__Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("role__name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setRole_Id(role__Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields className
			if(object.getEntity_Id() == null )
			{
					String key = "";
					if(object.getEntity_ClassName() != null)
						key += 	object.getEntity_ClassName();
					
					if(!"".equals(key) && entity_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("entity_className cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setEntity_Id(entity_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "molgenisPermission.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("role_".equalsIgnoreCase(fieldName) || "molgenisPermission.role_".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("entity".equalsIgnoreCase(fieldName) || "molgenisPermission.entity".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("permission".equalsIgnoreCase(fieldName) || "molgenisPermission.permission".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.EnumField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, MolgenisPermission entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.auth.MolgenisPermission> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.auth.MolgenisPermission> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<MolgenisPermission> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<MolgenisPermission> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<MolgenisPermission> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
