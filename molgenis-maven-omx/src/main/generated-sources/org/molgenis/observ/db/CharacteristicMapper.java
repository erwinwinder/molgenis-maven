/* File:        org.molgenis/model/Characteristic.java
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
import org.molgenis.observ.Characteristic;


public class CharacteristicMapper extends AbstractJDBCMapper<Characteristic>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends Characteristic> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO Characteristic (Identifier,Name,__Type,description) VALUES ");
		{
		
			boolean first = true;
			for(Characteristic e: entities)
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
				//__Type
				if(e.get__Type() != null){
								
					sql.append("'"+this.escapeSql(e.get__Type().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//description
				if(e.getDescription() != null){
								
					sql.append("'"+this.escapeSql(e.getDescription().toString())+"'"
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
	public int executeUpdate(List<? extends Characteristic> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO Characteristic (id,Identifier,Name,__Type,description) VALUES ");		
		boolean first = true;
		for(Characteristic e: entities)
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
		
			//__Type
			//readonly placeholder for insert-clause to prohibit not "null" errors: will be ignored in update
			sql.append("'Characteristic' ,");	
		
			//description


			if(e.getDescription() != null){
                sql.append("'"+this.escapeSql(e.getDescription()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE description=VALUES(description),Identifier=VALUES(Identifier),Name=VALUES(Name),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends Characteristic> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM Characteristic WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(Characteristic e: entities)
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
	
	public CharacteristicMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT Characteristic.id"
			+", Characteristic.Identifier"
			+", Characteristic.Name"
			+", Characteristic.__Type"
			+", Characteristic.description"
			+" FROM Characteristic "

;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM Characteristic "
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "Characteristic.id";
		if("Characteristic_id".equalsIgnoreCase(fieldName)) return "Characteristic.id";
		if("Identifier".equalsIgnoreCase(fieldName)) return "Characteristic.Identifier";
		if("Characteristic_Identifier".equalsIgnoreCase(fieldName)) return "Characteristic.Identifier";
		if("Name".equalsIgnoreCase(fieldName)) return "Characteristic.Name";
		if("Characteristic_Name".equalsIgnoreCase(fieldName)) return "Characteristic.Name";
		if("__Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("Characteristic___Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("description".equalsIgnoreCase(fieldName)) return "Characteristic.description";
		if("Characteristic_description".equalsIgnoreCase(fieldName)) return "Characteristic.description";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.observ.Characteristic> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.observ.Characteristic>(size); 
	}			

	public org.molgenis.observ.Characteristic create()
	{
		return new org.molgenis.observ.Characteristic();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.observ.Characteristic> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "characteristic.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("identifier".equalsIgnoreCase(fieldName) || "characteristic.identifier".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("name".equalsIgnoreCase(fieldName) || "characteristic.name".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("__Type".equalsIgnoreCase(fieldName) || "characteristic.__Type".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.EnumField();
			if("description".equalsIgnoreCase(fieldName) || "characteristic.description".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, Characteristic entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.observ.Characteristic> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.observ.Characteristic> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<Characteristic> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<Characteristic> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<Characteristic> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
