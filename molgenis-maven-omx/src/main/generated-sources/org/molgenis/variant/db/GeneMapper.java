/* File:        org.molgenis.omx/model/Gene.java
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
import org.molgenis.variant.Gene;

import org.molgenis.observ.Characteristic;
import org.molgenis.observ.db.CharacteristicMapper;
import org.molgenis.variant.Chromosome;

public class GeneMapper extends AbstractJDBCMapper<Gene>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends Gene> entities) throws DatabaseException
	{	
		//add superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.Characteristic.class).executeAdd(entities);
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO Gene (gdna,gdna_start,gdna_end,residues,seqlen,strand,id) VALUES ");
		{
		
			boolean first = true;
			for(Gene e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//gdna
				if(e.getGdna_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getGdna_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//gdna_start
				if(e.getGdna_Start() != null){
								
					sql.append("'"+this.escapeSql(e.getGdna_Start().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//gdna_end
				if(e.getGdna_End() != null){
								
					sql.append("'"+this.escapeSql(e.getGdna_End().toString())+"'"
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
				//strand
				if(e.getStrand() != null){
								
					sql.append("'"+this.escapeSql(e.getStrand().toString())+"'"
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
	public int executeUpdate(List<? extends Gene> entities) throws DatabaseException
	{
		//update superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.Characteristic.class).executeUpdate(entities);
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO Gene (gdna,gdna_start,gdna_end,residues,seqlen,strand,id) VALUES ");		
		boolean first = true;
		for(Gene e: entities)
		{
			// put the ,
			if(first)
				first = false;
			else
				sql.append(",");

			sql.append("(");
			
			//gdna


			if(e.getGdna_Id() != null){
                sql.append("'"+this.escapeSql(e.getGdna_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//gdna_start


			if(e.getGdna_Start() != null){
                sql.append("'"+this.escapeSql(e.getGdna_Start()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//gdna_end


			if(e.getGdna_End() != null){
                sql.append("'"+this.escapeSql(e.getGdna_End()).toString()+"'" +",");
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
		
			//strand


			if(e.getStrand() != null){
                sql.append("'"+this.escapeSql(e.getStrand())+"'" +",");
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
		sql.append(" ON DUPLICATE KEY UPDATE strand=VALUES(strand),id=LAST_INSERT_ID(id),gdna=VALUES(gdna),gdna_start=VALUES(gdna_start),gdna_end=VALUES(gdna_end),residues=VALUES(residues),seqlen=VALUES(seqlen)");

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
	public int executeRemove(List<? extends Gene> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM Gene WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(Gene e: entities)
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
	
	public GeneMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT Gene.id"
			+", Characteristic.Identifier"
			+", Characteristic.Name"
			+", Characteristic.__Type"
			+", Characteristic.description"
			+", Gene.gdna"
			+", Gene.gdna_start"
			+", Gene.gdna_end"
			+", Gene.residues"
			+", Gene.seqlen"
			+", Gene.strand"
			//parent is SimpleTree(name='gdna')
			+", xref_gdna.Identifier AS gdna_Identifier"
			+" FROM Gene "
			+" INNER JOIN Characteristic ON (Gene.id = Characteristic.id)"

			
			//label for gdna=Identifier
//path==gdna. type==xref.
//path==gdna_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Characteristic AS xref_gdna " 
			+" ON xref_gdna.id = Gene.gdna"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM Gene "
			  +" INNER JOIN Characteristic ON (Gene.id = Characteristic.id)"
			
			//label for gdna=Identifier
//gdna
//gdna_Identifier
		   	+" LEFT JOIN Characteristic AS xref_gdna " 
			+" ON xref_gdna.id = Gene.gdna"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "Gene.id";
		if("Gene_id".equalsIgnoreCase(fieldName)) return "Gene.id";
		if("Identifier".equalsIgnoreCase(fieldName)) return "Characteristic.Identifier";
		if("Gene_Identifier".equalsIgnoreCase(fieldName)) return "Characteristic.Identifier";
		if("Name".equalsIgnoreCase(fieldName)) return "Characteristic.Name";
		if("Gene_Name".equalsIgnoreCase(fieldName)) return "Characteristic.Name";
		if("__Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("Gene___Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("description".equalsIgnoreCase(fieldName)) return "Characteristic.description";
		if("Gene_description".equalsIgnoreCase(fieldName)) return "Characteristic.description";
		if("gdna".equalsIgnoreCase(fieldName)) return "Gene.gdna";
		if("Gene_gdna".equalsIgnoreCase(fieldName)) return "Gene.gdna";
		if("gdna_start".equalsIgnoreCase(fieldName)) return "Gene.gdna_start";
		if("Gene_gdna_start".equalsIgnoreCase(fieldName)) return "Gene.gdna_start";
		if("gdna_end".equalsIgnoreCase(fieldName)) return "Gene.gdna_end";
		if("Gene_gdna_end".equalsIgnoreCase(fieldName)) return "Gene.gdna_end";
		if("residues".equalsIgnoreCase(fieldName)) return "Gene.residues";
		if("Gene_residues".equalsIgnoreCase(fieldName)) return "Gene.residues";
		if("seqlen".equalsIgnoreCase(fieldName)) return "Gene.seqlen";
		if("Gene_seqlen".equalsIgnoreCase(fieldName)) return "Gene.seqlen";
		if("strand".equalsIgnoreCase(fieldName)) return "Gene.strand";
		if("Gene_strand".equalsIgnoreCase(fieldName)) return "Gene.strand";
		if("gdna_id".equalsIgnoreCase(fieldName)) return "Gene.gdna";
		if("Gene_gdna_id".equalsIgnoreCase(fieldName)) return "Gene.gdna";
		if("gdna_Identifier".equalsIgnoreCase(fieldName)) return "xref_gdna.Identifier";	
		if("Gene_gdna_Identifier".equalsIgnoreCase(fieldName)) return "xref_gdna.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.variant.Gene> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.variant.Gene>(size); 
	}			

	public org.molgenis.variant.Gene create()
	{
		return new org.molgenis.variant.Gene();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.variant.Gene> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'gdna' to chromosome.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> gdnaRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.variant.Gene object: entities)
		{
			//create xref/mref rule filtering Chromosome on the label Identifier
			if(object.getGdna_Id() == null && object.getGdna_Identifier() != null)
			{
				Object label = object.getGdna_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !gdnaRules.containsKey(label))
					{
						gdnaRules.put(""+label, xrefFilter);
						gdnaRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
		}

		//resolve foreign key field 'gdna' to chromosome.id using Identifier)
		final java.util.Map<String,Integer> gdna_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(gdnaRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.variant.Chromosome> gdnaList = null;
			try
			{
				gdnaList = getDatabase().find(org.molgenis.variant.Chromosome.class, gdnaRules.values().toArray(new org.molgenis.framework.db.QueryRule[gdnaRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.variant.Chromosome xref :  gdnaList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				gdna_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.variant.Gene object = entities.get(i);		
			//update object using label fields Identifier
			if(object.getGdna_Id() == null )
			{
					String key = "";
					if(object.getGdna_Identifier() != null)
						key += 	object.getGdna_Identifier();
					
					if(!"".equals(key) && gdna_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("gdna_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setGdna_Id(gdna_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "gene.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("identifier".equalsIgnoreCase(fieldName) || "characteristic.identifier".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("name".equalsIgnoreCase(fieldName) || "characteristic.name".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("__Type".equalsIgnoreCase(fieldName) || "characteristic.__Type".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.EnumField();
			if("description".equalsIgnoreCase(fieldName) || "characteristic.description".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("gdna".equalsIgnoreCase(fieldName) || "gene.gdna".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("gdna_start".equalsIgnoreCase(fieldName) || "gene.gdna_start".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("gdna_end".equalsIgnoreCase(fieldName) || "gene.gdna_end".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("residues".equalsIgnoreCase(fieldName) || "gene.residues".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("seqlen".equalsIgnoreCase(fieldName) || "gene.seqlen".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("strand".equalsIgnoreCase(fieldName) || "gene.strand".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.EnumField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, Gene entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.variant.Gene> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.variant.Gene> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<Gene> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<Gene> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<Gene> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
