/* File:        org.molgenis.omx/model/Investigation.java
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
import org.molgenis.gwascentral.Investigation;


public class InvestigationMapper extends AbstractJDBCMapper<Investigation>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends Investigation> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO Investigation (Identifier,Name,Title,ShortName,Version,Background) VALUES ");
		{
		
			boolean first = true;
			for(Investigation e: entities)
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
				//title
				if(e.getTitle() != null){
								
					sql.append("'"+this.escapeSql(e.getTitle().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//shortName
				if(e.getShortName() != null){
								
					sql.append("'"+this.escapeSql(e.getShortName().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//version
				if(e.getVersion() != null){
								
					sql.append("'"+this.escapeSql(e.getVersion().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//background
				if(e.getBackground() != null){
								
					sql.append("'"+this.escapeSql(e.getBackground().toString())+"'"
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
	public int executeUpdate(List<? extends Investigation> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO Investigation (id,Identifier,Name,Title,ShortName,Version,Background) VALUES ");		
		boolean first = true;
		for(Investigation e: entities)
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
		
			//title


			if(e.getTitle() != null){
                sql.append("'"+this.escapeSql(e.getTitle()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//shortName


			if(e.getShortName() != null){
                sql.append("'"+this.escapeSql(e.getShortName()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//version


			if(e.getVersion() != null){
                sql.append("'"+this.escapeSql(e.getVersion()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//background


			if(e.getBackground() != null){
                sql.append("'"+this.escapeSql(e.getBackground()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE Title=VALUES(Title),ShortName=VALUES(ShortName),Version=VALUES(Version),Background=VALUES(Background),Identifier=VALUES(Identifier),Name=VALUES(Name),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends Investigation> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM Investigation WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(Investigation e: entities)
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
	
	public InvestigationMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT Investigation.id"
			+", Investigation.Identifier"
			+", Investigation.Name"
			+", Investigation.Title"
			+", Investigation.ShortName"
			+", Investigation.Version"
			+", Investigation.Background"
			+" FROM Investigation "

;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM Investigation "
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "Investigation.id";
		if("Investigation_id".equalsIgnoreCase(fieldName)) return "Investigation.id";
		if("Identifier".equalsIgnoreCase(fieldName)) return "Investigation.Identifier";
		if("Investigation_Identifier".equalsIgnoreCase(fieldName)) return "Investigation.Identifier";
		if("Name".equalsIgnoreCase(fieldName)) return "Investigation.Name";
		if("Investigation_Name".equalsIgnoreCase(fieldName)) return "Investigation.Name";
		if("Title".equalsIgnoreCase(fieldName)) return "Investigation.Title";
		if("Investigation_Title".equalsIgnoreCase(fieldName)) return "Investigation.Title";
		if("ShortName".equalsIgnoreCase(fieldName)) return "Investigation.ShortName";
		if("Investigation_ShortName".equalsIgnoreCase(fieldName)) return "Investigation.ShortName";
		if("Version".equalsIgnoreCase(fieldName)) return "Investigation.Version";
		if("Investigation_Version".equalsIgnoreCase(fieldName)) return "Investigation.Version";
		if("Background".equalsIgnoreCase(fieldName)) return "Investigation.Background";
		if("Investigation_Background".equalsIgnoreCase(fieldName)) return "Investigation.Background";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.gwascentral.Investigation> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.gwascentral.Investigation>(size); 
	}			

	public org.molgenis.gwascentral.Investigation create()
	{
		return new org.molgenis.gwascentral.Investigation();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.gwascentral.Investigation> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "investigation.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("identifier".equalsIgnoreCase(fieldName) || "investigation.identifier".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("name".equalsIgnoreCase(fieldName) || "investigation.name".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("title".equalsIgnoreCase(fieldName) || "investigation.title".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("shortName".equalsIgnoreCase(fieldName) || "investigation.shortName".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("version".equalsIgnoreCase(fieldName) || "investigation.version".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("background".equalsIgnoreCase(fieldName) || "investigation.background".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, Investigation entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.gwascentral.Investigation> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.gwascentral.Investigation> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<Investigation> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<Investigation> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<Investigation> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
