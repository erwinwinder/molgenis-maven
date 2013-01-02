/* File:        org.molgenis.omx/model/Protein.java
 * Copyright:   GBIC 2000-2013, all rights reserved
 * Date:        January 2, 2013
 * Template:	MultiqueryMapperGen.java.ftl
 * generator:   org.molgenis.generators.db.MultiqueryMapperGen 4.0.0-testing
 *
 * Using "subclass per table" strategy
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.variant.db;

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
import org.molgenis.variant.Protein;

import org.molgenis.observ.Characteristic;
import org.molgenis.observ.db.CharacteristicMapper;
import org.molgenis.variant.Gene;

public class ProteinMapper extends AbstractJDBCMapper<Protein>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends Protein> entities) throws DatabaseException
	{	
		//add superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.Characteristic.class).executeAdd(entities);
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO Protein (cdna,cdna_start,cdna_end,residues,seqlen,id) VALUES ");
		{
		
			boolean first = true;
			for(Protein e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//cdna
				if(e.getCdna_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getCdna_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//cdna_start
				if(e.getCdna_Start() != null){
								
					sql.append("'"+this.escapeSql(e.getCdna_Start().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//cdna_end
				if(e.getCdna_End() != null){
								
					sql.append("'"+this.escapeSql(e.getCdna_End().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//residues
				if(e.getResidues() != null){
								
					sql.append("'"+this.escapeSql(e.getResidues().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//seqlen
				if(e.getSeqlen() != null){
								
					sql.append("'"+this.escapeSql(e.getSeqlen().toString())+"'"
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
	public int executeUpdate(List<? extends Protein> entities) throws DatabaseException
	{
		//update superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.Characteristic.class).executeUpdate(entities);
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO Protein (cdna,cdna_start,cdna_end,residues,seqlen,id) VALUES ");		
		boolean first = true;
		for(Protein e: entities)
		{
			// put the ,
			if(first)
				first = false;
			else
				sql.append(",");

			sql.append("(");
			
			//cdna


			if(e.getCdna_Id() != null){
                sql.append("'"+this.escapeSql(e.getCdna_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//cdna_start


			if(e.getCdna_Start() != null){
                sql.append("'"+this.escapeSql(e.getCdna_Start()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//cdna_end


			if(e.getCdna_End() != null){
                sql.append("'"+this.escapeSql(e.getCdna_End()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//residues


			if(e.getResidues() != null){
                sql.append("'"+this.escapeSql(e.getResidues()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//seqlen


			if(e.getSeqlen() != null){
                sql.append("'"+this.escapeSql(e.getSeqlen()).toString()+"'" +",");
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
		sql.append(" ON DUPLICATE KEY UPDATE id=LAST_INSERT_ID(id),cdna=VALUES(cdna),cdna_start=VALUES(cdna_start),cdna_end=VALUES(cdna_end),residues=VALUES(residues),seqlen=VALUES(seqlen)");

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
	public int executeRemove(List<? extends Protein> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM Protein WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(Protein e: entities)
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
	
	public ProteinMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT Protein.id"
			+", Characteristic.Identifier"
			+", Characteristic.Name"
			+", Characteristic.__Type"
			+", Characteristic.description"
			+", Protein.cdna"
			+", Protein.cdna_start"
			+", Protein.cdna_end"
			+", Protein.residues"
			+", Protein.seqlen"
			//parent is SimpleTree(name='cdna')
			+", xref_cdna.Identifier AS cdna_Identifier"
			+" FROM Protein "
			+" INNER JOIN Characteristic ON (Protein.id = Characteristic.id)"

			
			//label for cdna=Identifier
//path==cdna. type==xref.
//path==cdna_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Characteristic AS xref_cdna " 
			+" ON xref_cdna.id = Protein.cdna"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM Protein "
			  +" INNER JOIN Characteristic ON (Protein.id = Characteristic.id)"
			
			//label for cdna=Identifier
//cdna
//cdna_Identifier
		   	+" LEFT JOIN Characteristic AS xref_cdna " 
			+" ON xref_cdna.id = Protein.cdna"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "Protein.id";
		if("Protein_id".equalsIgnoreCase(fieldName)) return "Protein.id";
		if("Identifier".equalsIgnoreCase(fieldName)) return "Characteristic.Identifier";
		if("Protein_Identifier".equalsIgnoreCase(fieldName)) return "Characteristic.Identifier";
		if("Name".equalsIgnoreCase(fieldName)) return "Characteristic.Name";
		if("Protein_Name".equalsIgnoreCase(fieldName)) return "Characteristic.Name";
		if("__Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("Protein___Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("description".equalsIgnoreCase(fieldName)) return "Characteristic.description";
		if("Protein_description".equalsIgnoreCase(fieldName)) return "Characteristic.description";
		if("cdna".equalsIgnoreCase(fieldName)) return "Protein.cdna";
		if("Protein_cdna".equalsIgnoreCase(fieldName)) return "Protein.cdna";
		if("cdna_start".equalsIgnoreCase(fieldName)) return "Protein.cdna_start";
		if("Protein_cdna_start".equalsIgnoreCase(fieldName)) return "Protein.cdna_start";
		if("cdna_end".equalsIgnoreCase(fieldName)) return "Protein.cdna_end";
		if("Protein_cdna_end".equalsIgnoreCase(fieldName)) return "Protein.cdna_end";
		if("residues".equalsIgnoreCase(fieldName)) return "Protein.residues";
		if("Protein_residues".equalsIgnoreCase(fieldName)) return "Protein.residues";
		if("seqlen".equalsIgnoreCase(fieldName)) return "Protein.seqlen";
		if("Protein_seqlen".equalsIgnoreCase(fieldName)) return "Protein.seqlen";
		if("cdna_id".equalsIgnoreCase(fieldName)) return "Protein.cdna";
		if("Protein_cdna_id".equalsIgnoreCase(fieldName)) return "Protein.cdna";
		if("cdna_Identifier".equalsIgnoreCase(fieldName)) return "xref_cdna.Identifier";	
		if("Protein_cdna_Identifier".equalsIgnoreCase(fieldName)) return "xref_cdna.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.variant.Protein> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.variant.Protein>(size); 
	}			

	public org.molgenis.variant.Protein create()
	{
		return new org.molgenis.variant.Protein();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.variant.Protein> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'cdna' to gene.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> cdnaRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.variant.Protein object: entities)
		{
			//create xref/mref rule filtering Gene on the label Identifier
			if(object.getCdna_Id() == null && object.getCdna_Identifier() != null)
			{
				Object label = object.getCdna_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !cdnaRules.containsKey(label))
					{
						cdnaRules.put(""+label, xrefFilter);
						cdnaRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
		}

		//resolve foreign key field 'cdna' to gene.id using Identifier)
		final java.util.Map<String,Integer> cdna_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(cdnaRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.variant.Gene> cdnaList = null;
			try
			{
				cdnaList = getDatabase().find(org.molgenis.variant.Gene.class, cdnaRules.values().toArray(new org.molgenis.framework.db.QueryRule[cdnaRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.variant.Gene xref :  cdnaList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				cdna_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.variant.Protein object = entities.get(i);		
			//update object using label fields Identifier
			if(object.getCdna_Id() == null )
			{
					String key = "";
					if(object.getCdna_Identifier() != null)
						key += 	object.getCdna_Identifier();
					
					if(!"".equals(key) && cdna_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("cdna_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setCdna_Id(cdna_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "protein.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("identifier".equalsIgnoreCase(fieldName) || "characteristic.identifier".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("name".equalsIgnoreCase(fieldName) || "characteristic.name".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("__Type".equalsIgnoreCase(fieldName) || "characteristic.__Type".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.EnumField();
			if("description".equalsIgnoreCase(fieldName) || "characteristic.description".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("cdna".equalsIgnoreCase(fieldName) || "protein.cdna".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("cdna_start".equalsIgnoreCase(fieldName) || "protein.cdna_start".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("cdna_end".equalsIgnoreCase(fieldName) || "protein.cdna_end".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("residues".equalsIgnoreCase(fieldName) || "protein.residues".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("seqlen".equalsIgnoreCase(fieldName) || "protein.seqlen".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, Protein entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.variant.Protein> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.variant.Protein> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<Protein> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<Protein> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<Protein> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
