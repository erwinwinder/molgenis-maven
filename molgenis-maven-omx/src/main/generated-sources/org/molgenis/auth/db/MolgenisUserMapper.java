/* File:        org.molgenis.omx/model/MolgenisUser.java
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
import org.molgenis.auth.MolgenisUser;


public class MolgenisUserMapper extends AbstractJDBCMapper<MolgenisUser>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends MolgenisUser> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO MolgenisUser (username,password_,activationCode,active,superuser) VALUES ");
		{
		
			boolean first = true;
			for(MolgenisUser e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//username
				if(e.getUsername() != null){
								
					sql.append("'"+this.escapeSql(e.getUsername().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//password_
				if(e.getPassword() != null){
								
					sql.append("'"+this.escapeSql(e.getPassword().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//activationCode
				if(e.getActivationCode() != null){
								
					sql.append("'"+this.escapeSql(e.getActivationCode().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//active
				if(e.getActive() != null){
								
					sql.append(e.getActive()
				+",");
				}
				else{
					sql.append("null,");
				}
				//superuser
				if(e.getSuperuser() != null){
								
					sql.append(e.getSuperuser()
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
	public int executeUpdate(List<? extends MolgenisUser> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO MolgenisUser (id,username,password_,activationCode,active,superuser) VALUES ");		
		boolean first = true;
		for(MolgenisUser e: entities)
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
		
			//username


			if(e.getUsername() != null){
                sql.append("'"+this.escapeSql(e.getUsername()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//password_


			if(e.getPassword() != null){
                sql.append("'"+this.escapeSql(e.getPassword()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//activationCode


			if(e.getActivationCode() != null){
                sql.append("'"+this.escapeSql(e.getActivationCode()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//active


			if(e.getActive() != null){
                sql.append(e.getActive() +",");
			} else {
				sql.append("null,");
            }
		
			//superuser


			if(e.getSuperuser() != null){
                sql.append(e.getSuperuser());
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE username=VALUES(username),password_=VALUES(password_),activationCode=VALUES(activationCode),active=VALUES(active),superuser=VALUES(superuser),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends MolgenisUser> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM MolgenisUser WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(MolgenisUser e: entities)
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
	
	public MolgenisUserMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT MolgenisUser.id"
			+", MolgenisUser.username"
			+", MolgenisUser.password_"
			+", MolgenisUser.activationCode"
			+", MolgenisUser.active"
			+", MolgenisUser.superuser"
			+" FROM MolgenisUser "

;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM MolgenisUser "
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "MolgenisUser.id";
		if("MolgenisUser_id".equalsIgnoreCase(fieldName)) return "MolgenisUser.id";
		if("username".equalsIgnoreCase(fieldName)) return "MolgenisUser.username";
		if("MolgenisUser_username".equalsIgnoreCase(fieldName)) return "MolgenisUser.username";
		if("password_".equalsIgnoreCase(fieldName)) return "MolgenisUser.password_";
		if("MolgenisUser_password_".equalsIgnoreCase(fieldName)) return "MolgenisUser.password_";
		if("activationCode".equalsIgnoreCase(fieldName)) return "MolgenisUser.activationCode";
		if("MolgenisUser_activationCode".equalsIgnoreCase(fieldName)) return "MolgenisUser.activationCode";
		if("active".equalsIgnoreCase(fieldName)) return "MolgenisUser.active";
		if("MolgenisUser_active".equalsIgnoreCase(fieldName)) return "MolgenisUser.active";
		if("superuser".equalsIgnoreCase(fieldName)) return "MolgenisUser.superuser";
		if("MolgenisUser_superuser".equalsIgnoreCase(fieldName)) return "MolgenisUser.superuser";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.auth.MolgenisUser> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.auth.MolgenisUser>(size); 
	}			

	public org.molgenis.auth.MolgenisUser create()
	{
		return new org.molgenis.auth.MolgenisUser();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.auth.MolgenisUser> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "molgenisUser.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("username".equalsIgnoreCase(fieldName) || "molgenisUser.username".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("password_".equalsIgnoreCase(fieldName) || "molgenisUser.password_".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("activationCode".equalsIgnoreCase(fieldName) || "molgenisUser.activationCode".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("active".equalsIgnoreCase(fieldName) || "molgenisUser.active".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.BoolField();
			if("superuser".equalsIgnoreCase(fieldName) || "molgenisUser.superuser".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.BoolField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, MolgenisUser entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.auth.MolgenisUser> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.auth.MolgenisUser> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<MolgenisUser> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<MolgenisUser> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<MolgenisUser> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
