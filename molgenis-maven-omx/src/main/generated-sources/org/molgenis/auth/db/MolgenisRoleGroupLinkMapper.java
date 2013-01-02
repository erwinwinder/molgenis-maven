/* File:        org.molgenis.omx/model/MolgenisRoleGroupLink.java
 * Copyright:   GBIC 2000-2013, all rights reserved
 * Date:        January 2, 2013
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
import org.molgenis.auth.MolgenisRoleGroupLink;

import org.molgenis.auth.MolgenisGroup;
import org.molgenis.auth.MolgenisRole;

public class MolgenisRoleGroupLinkMapper extends AbstractJDBCMapper<MolgenisRoleGroupLink>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends MolgenisRoleGroupLink> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO MolgenisRoleGroupLink (Identifier,Name,group_,role_) VALUES ");
		{
		
			boolean first = true;
			for(MolgenisRoleGroupLink e: entities)
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
				//group_
				if(e.getGroup_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getGroup_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//role_
				if(e.getRole_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getRole_Id().toString())+"'"
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
	public int executeUpdate(List<? extends MolgenisRoleGroupLink> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO MolgenisRoleGroupLink (id,Identifier,Name,group_,role_) VALUES ");		
		boolean first = true;
		for(MolgenisRoleGroupLink e: entities)
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
		
			//group_


			if(e.getGroup_Id() != null){
                sql.append("'"+this.escapeSql(e.getGroup_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//role_


			if(e.getRole_Id() != null){
                sql.append("'"+this.escapeSql(e.getRole_Id()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE group_=VALUES(group_),role_=VALUES(role_),Identifier=VALUES(Identifier),Name=VALUES(Name),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends MolgenisRoleGroupLink> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM MolgenisRoleGroupLink WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(MolgenisRoleGroupLink e: entities)
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
	
	public MolgenisRoleGroupLinkMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT MolgenisRoleGroupLink.id"
			+", MolgenisRoleGroupLink.Identifier"
			+", MolgenisRoleGroupLink.Name"
			+", MolgenisRoleGroupLink.group_"
			+", MolgenisRoleGroupLink.role_"
			//parent is SimpleTree(name='group_')
			+", xref_group_.name AS group__Name"
			//parent is SimpleTree(name='role_')
			+", xref_role_.name AS role__Name"
			+" FROM MolgenisRoleGroupLink "

			
			//label for group_=name
//path==group_. type==xref.
//path==group__Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN MolgenisRole AS xref_group_ " 
			+" ON xref_group_.id = MolgenisRoleGroupLink.group_"
			
			//label for role_=name
//path==role_. type==xref.
//path==role__Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN MolgenisRole AS xref_role_ " 
			+" ON xref_role_.id = MolgenisRoleGroupLink.role_"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM MolgenisRoleGroupLink "
			
			//label for group_=name
//group_
//group__Name
		   	+" LEFT JOIN MolgenisRole AS xref_group_ " 
			+" ON xref_group_.id = MolgenisRoleGroupLink.group_"
			
			//label for role_=name
//role_
//role__Name
		   	+" LEFT JOIN MolgenisRole AS xref_role_ " 
			+" ON xref_role_.id = MolgenisRoleGroupLink.role_"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "MolgenisRoleGroupLink.id";
		if("MolgenisRoleGroupLink_id".equalsIgnoreCase(fieldName)) return "MolgenisRoleGroupLink.id";
		if("Identifier".equalsIgnoreCase(fieldName)) return "MolgenisRoleGroupLink.Identifier";
		if("MolgenisRoleGroupLink_Identifier".equalsIgnoreCase(fieldName)) return "MolgenisRoleGroupLink.Identifier";
		if("Name".equalsIgnoreCase(fieldName)) return "MolgenisRoleGroupLink.Name";
		if("MolgenisRoleGroupLink_Name".equalsIgnoreCase(fieldName)) return "MolgenisRoleGroupLink.Name";
		if("group_".equalsIgnoreCase(fieldName)) return "MolgenisRoleGroupLink.group_";
		if("MolgenisRoleGroupLink_group_".equalsIgnoreCase(fieldName)) return "MolgenisRoleGroupLink.group_";
		if("role_".equalsIgnoreCase(fieldName)) return "MolgenisRoleGroupLink.role_";
		if("MolgenisRoleGroupLink_role_".equalsIgnoreCase(fieldName)) return "MolgenisRoleGroupLink.role_";
		if("group__id".equalsIgnoreCase(fieldName)) return "MolgenisRoleGroupLink.group_";
		if("MolgenisRoleGroupLink_group__id".equalsIgnoreCase(fieldName)) return "MolgenisRoleGroupLink.group_";
		if("group__Name".equalsIgnoreCase(fieldName)) return "xref_group_.name";	
		if("MolgenisRoleGroupLink_group__Name".equalsIgnoreCase(fieldName)) return "xref_group_.name";
		if("role__id".equalsIgnoreCase(fieldName)) return "MolgenisRoleGroupLink.role_";
		if("MolgenisRoleGroupLink_role__id".equalsIgnoreCase(fieldName)) return "MolgenisRoleGroupLink.role_";
		if("role__Name".equalsIgnoreCase(fieldName)) return "xref_role_.name";	
		if("MolgenisRoleGroupLink_role__Name".equalsIgnoreCase(fieldName)) return "xref_role_.name";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.auth.MolgenisRoleGroupLink> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.auth.MolgenisRoleGroupLink>(size); 
	}			

	public org.molgenis.auth.MolgenisRoleGroupLink create()
	{
		return new org.molgenis.auth.MolgenisRoleGroupLink();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.auth.MolgenisRoleGroupLink> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'group_' to molgenisGroup.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> group_Rules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'role_' to molgenisRole.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> role_Rules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.auth.MolgenisRoleGroupLink object: entities)
		{
			//create xref/mref rule filtering MolgenisGroup on the label name
			if(object.getGroup_Id() == null && object.getGroup_Name() != null)
			{
				Object label = object.getGroup_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !group_Rules.containsKey(label))
					{
						group_Rules.put(""+label, xrefFilter);
						group_Rules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
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
		}

		//resolve foreign key field 'group_' to molgenisGroup.id using name)
		final java.util.Map<String,Integer> group__Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(group_Rules.size() > 0)
		{		
		
			java.util.List<org.molgenis.auth.MolgenisGroup> group_List = null;
			try
			{
				group_List = getDatabase().find(org.molgenis.auth.MolgenisGroup.class, group_Rules.values().toArray(new org.molgenis.framework.db.QueryRule[group_Rules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.auth.MolgenisGroup xref :  group_List)
			{
				String key = "";
				key += 	xref.getName();
				
				group__Labels_to_IdMap.put(key, xref.getId());
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

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.auth.MolgenisRoleGroupLink object = entities.get(i);		
			//update object using label fields name
			if(object.getGroup_Id() == null )
			{
					String key = "";
					if(object.getGroup_Name() != null)
						key += 	object.getGroup_Name();
					
					if(!"".equals(key) && group__Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("group__name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setGroup_Id(group__Labels_to_IdMap.get(key));
					}
			}
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
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "molgenisRoleGroupLink.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("identifier".equalsIgnoreCase(fieldName) || "molgenisRoleGroupLink.identifier".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("name".equalsIgnoreCase(fieldName) || "molgenisRoleGroupLink.name".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("group_".equalsIgnoreCase(fieldName) || "molgenisRoleGroupLink.group_".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("role_".equalsIgnoreCase(fieldName) || "molgenisRoleGroupLink.role_".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, MolgenisRoleGroupLink entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.auth.MolgenisRoleGroupLink> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.auth.MolgenisRoleGroupLink> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<MolgenisRoleGroupLink> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<MolgenisRoleGroupLink> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<MolgenisRoleGroupLink> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
