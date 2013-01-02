/* File:        org.molgenis.omx/model/Institute.java
 * Copyright:   GBIC 2000-2013, all rights reserved
 * Date:        January 2, 2013
 * Template:	MultiqueryMapperGen.java.ftl
 * generator:   org.molgenis.generators.db.MultiqueryMapperGen 4.0.0-testing
 *
 * Using "subclass per table" strategy
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.organization.db;

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
import org.molgenis.organization.Institute;


public class InstituteMapper extends AbstractJDBCMapper<Institute>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends Institute> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO Institute (name,Address,Phone,City,Country,Fax) VALUES ");
		{
		
			boolean first = true;
			for(Institute e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//name
				if(e.getName() != null){
								
					sql.append("'"+this.escapeSql(e.getName().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//address
				if(e.getAddress() != null){
								
					sql.append("'"+this.escapeSql(e.getAddress().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//phone
				if(e.getPhone() != null){
								
					sql.append("'"+this.escapeSql(e.getPhone().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//city
				if(e.getCity() != null){
								
					sql.append("'"+this.escapeSql(e.getCity().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//country
				if(e.getCountry() != null){
								
					sql.append("'"+this.escapeSql(e.getCountry().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//fax
				if(e.getFax() != null){
								
					sql.append("'"+this.escapeSql(e.getFax().toString())+"'"
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
	public int executeUpdate(List<? extends Institute> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO Institute (id,name,Address,Phone,City,Country,Fax) VALUES ");		
		boolean first = true;
		for(Institute e: entities)
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
		
			//name


			if(e.getName() != null){
                sql.append("'"+this.escapeSql(e.getName()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//address


			if(e.getAddress() != null){
                sql.append("'"+this.escapeSql(e.getAddress()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//phone


			if(e.getPhone() != null){
                sql.append("'"+this.escapeSql(e.getPhone()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//city


			if(e.getCity() != null){
                sql.append("'"+this.escapeSql(e.getCity()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//country


			if(e.getCountry() != null){
                sql.append("'"+this.escapeSql(e.getCountry()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//fax


			if(e.getFax() != null){
                sql.append("'"+this.escapeSql(e.getFax()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE name=VALUES(name),Address=VALUES(Address),Phone=VALUES(Phone),City=VALUES(City),Country=VALUES(Country),Fax=VALUES(Fax),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends Institute> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM Institute WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(Institute e: entities)
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
	
	public InstituteMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT Institute.id"
			+", Institute.name"
			+", Institute.Address"
			+", Institute.Phone"
			+", Institute.City"
			+", Institute.Country"
			+", Institute.Fax"
			+" FROM Institute "

;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM Institute "
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "Institute.id";
		if("Institute_id".equalsIgnoreCase(fieldName)) return "Institute.id";
		if("name".equalsIgnoreCase(fieldName)) return "Institute.name";
		if("Institute_name".equalsIgnoreCase(fieldName)) return "Institute.name";
		if("Address".equalsIgnoreCase(fieldName)) return "Institute.Address";
		if("Institute_Address".equalsIgnoreCase(fieldName)) return "Institute.Address";
		if("Phone".equalsIgnoreCase(fieldName)) return "Institute.Phone";
		if("Institute_Phone".equalsIgnoreCase(fieldName)) return "Institute.Phone";
		if("City".equalsIgnoreCase(fieldName)) return "Institute.City";
		if("Institute_City".equalsIgnoreCase(fieldName)) return "Institute.City";
		if("Country".equalsIgnoreCase(fieldName)) return "Institute.Country";
		if("Institute_Country".equalsIgnoreCase(fieldName)) return "Institute.Country";
		if("Fax".equalsIgnoreCase(fieldName)) return "Institute.Fax";
		if("Institute_Fax".equalsIgnoreCase(fieldName)) return "Institute.Fax";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.organization.Institute> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.organization.Institute>(size); 
	}			

	public org.molgenis.organization.Institute create()
	{
		return new org.molgenis.organization.Institute();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.organization.Institute> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "institute.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("name".equalsIgnoreCase(fieldName) || "institute.name".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("address".equalsIgnoreCase(fieldName) || "institute.address".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("phone".equalsIgnoreCase(fieldName) || "institute.phone".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("city".equalsIgnoreCase(fieldName) || "institute.city".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("country".equalsIgnoreCase(fieldName) || "institute.country".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("fax".equalsIgnoreCase(fieldName) || "institute.fax".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, Institute entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.organization.Institute> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.organization.Institute> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<Institute> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<Institute> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<Institute> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
