/* File:        org.molgenis.omx/model/Chromosome.java
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
import org.molgenis.variant.Chromosome;

import org.molgenis.observ.Characteristic;
import org.molgenis.observ.db.CharacteristicMapper;
import org.molgenis.variant.Genome;

public class ChromosomeMapper extends AbstractJDBCMapper<Chromosome>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends Chromosome> entities) throws DatabaseException
	{	
		//add superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.Characteristic.class).executeAdd(entities);
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO Chromosome (residues,seqlen,genome,orderNr,isAutosomal,id) VALUES ");
		{
		
			boolean first = true;
			for(Chromosome e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
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
				//genome
				if(e.getGenome_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getGenome_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//orderNr
				if(e.getOrderNr() != null){
								
					sql.append("'"+this.escapeSql(e.getOrderNr().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//isAutosomal
				if(e.getIsAutosomal() != null){
								
					sql.append(e.getIsAutosomal()
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
	public int executeUpdate(List<? extends Chromosome> entities) throws DatabaseException
	{
		//update superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.Characteristic.class).executeUpdate(entities);
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO Chromosome (residues,seqlen,genome,orderNr,isAutosomal,id) VALUES ");		
		boolean first = true;
		for(Chromosome e: entities)
		{
			// put the ,
			if(first)
				first = false;
			else
				sql.append(",");

			sql.append("(");
			
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
		
			//genome


			if(e.getGenome_Id() != null){
                sql.append("'"+this.escapeSql(e.getGenome_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//orderNr


			if(e.getOrderNr() != null){
                sql.append("'"+this.escapeSql(e.getOrderNr()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//isAutosomal


			if(e.getIsAutosomal() != null){
                sql.append(e.getIsAutosomal() +",");
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
		sql.append(" ON DUPLICATE KEY UPDATE genome=VALUES(genome),orderNr=VALUES(orderNr),isAutosomal=VALUES(isAutosomal),id=LAST_INSERT_ID(id),residues=VALUES(residues),seqlen=VALUES(seqlen)");

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
	public int executeRemove(List<? extends Chromosome> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM Chromosome WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(Chromosome e: entities)
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
	
	public ChromosomeMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT Chromosome.id"
			+", Characteristic.Identifier"
			+", Characteristic.Name"
			+", Characteristic.__Type"
			+", Characteristic.description"
			+", Chromosome.residues"
			+", Chromosome.seqlen"
			+", Chromosome.genome"
			+", Chromosome.orderNr"
			+", Chromosome.isAutosomal"
			//parent is SimpleTree(name='genome')
			+", xref_genome.Identifier AS genome_Identifier"
			+" FROM Chromosome "
			+" INNER JOIN Characteristic ON (Chromosome.id = Characteristic.id)"

			
			//label for genome=Identifier
//path==genome. type==xref.
//path==genome_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Characteristic AS xref_genome " 
			+" ON xref_genome.id = Chromosome.genome"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM Chromosome "
			  +" INNER JOIN Characteristic ON (Chromosome.id = Characteristic.id)"
			
			//label for genome=Identifier
//genome
//genome_Identifier
		   	+" LEFT JOIN Characteristic AS xref_genome " 
			+" ON xref_genome.id = Chromosome.genome"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "Chromosome.id";
		if("Chromosome_id".equalsIgnoreCase(fieldName)) return "Chromosome.id";
		if("Identifier".equalsIgnoreCase(fieldName)) return "Characteristic.Identifier";
		if("Chromosome_Identifier".equalsIgnoreCase(fieldName)) return "Characteristic.Identifier";
		if("Name".equalsIgnoreCase(fieldName)) return "Characteristic.Name";
		if("Chromosome_Name".equalsIgnoreCase(fieldName)) return "Characteristic.Name";
		if("__Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("Chromosome___Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("description".equalsIgnoreCase(fieldName)) return "Characteristic.description";
		if("Chromosome_description".equalsIgnoreCase(fieldName)) return "Characteristic.description";
		if("residues".equalsIgnoreCase(fieldName)) return "Chromosome.residues";
		if("Chromosome_residues".equalsIgnoreCase(fieldName)) return "Chromosome.residues";
		if("seqlen".equalsIgnoreCase(fieldName)) return "Chromosome.seqlen";
		if("Chromosome_seqlen".equalsIgnoreCase(fieldName)) return "Chromosome.seqlen";
		if("genome".equalsIgnoreCase(fieldName)) return "Chromosome.genome";
		if("Chromosome_genome".equalsIgnoreCase(fieldName)) return "Chromosome.genome";
		if("orderNr".equalsIgnoreCase(fieldName)) return "Chromosome.orderNr";
		if("Chromosome_orderNr".equalsIgnoreCase(fieldName)) return "Chromosome.orderNr";
		if("isAutosomal".equalsIgnoreCase(fieldName)) return "Chromosome.isAutosomal";
		if("Chromosome_isAutosomal".equalsIgnoreCase(fieldName)) return "Chromosome.isAutosomal";
		if("genome_id".equalsIgnoreCase(fieldName)) return "Chromosome.genome";
		if("Chromosome_genome_id".equalsIgnoreCase(fieldName)) return "Chromosome.genome";
		if("genome_Identifier".equalsIgnoreCase(fieldName)) return "xref_genome.Identifier";	
		if("Chromosome_genome_Identifier".equalsIgnoreCase(fieldName)) return "xref_genome.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.variant.Chromosome> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.variant.Chromosome>(size); 
	}			

	public org.molgenis.variant.Chromosome create()
	{
		return new org.molgenis.variant.Chromosome();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.variant.Chromosome> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'genome' to genome.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> genomeRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.variant.Chromosome object: entities)
		{
			//create xref/mref rule filtering Genome on the label Identifier
			if(object.getGenome_Id() == null && object.getGenome_Identifier() != null)
			{
				Object label = object.getGenome_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !genomeRules.containsKey(label))
					{
						genomeRules.put(""+label, xrefFilter);
						genomeRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
		}

		//resolve foreign key field 'genome' to genome.id using Identifier)
		final java.util.Map<String,Integer> genome_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(genomeRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.variant.Genome> genomeList = null;
			try
			{
				genomeList = getDatabase().find(org.molgenis.variant.Genome.class, genomeRules.values().toArray(new org.molgenis.framework.db.QueryRule[genomeRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.variant.Genome xref :  genomeList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				genome_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.variant.Chromosome object = entities.get(i);		
			//update object using label fields Identifier
			if(object.getGenome_Id() == null )
			{
					String key = "";
					if(object.getGenome_Identifier() != null)
						key += 	object.getGenome_Identifier();
					
					if(!"".equals(key) && genome_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("genome_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setGenome_Id(genome_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "chromosome.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("identifier".equalsIgnoreCase(fieldName) || "characteristic.identifier".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("name".equalsIgnoreCase(fieldName) || "characteristic.name".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("__Type".equalsIgnoreCase(fieldName) || "characteristic.__Type".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.EnumField();
			if("description".equalsIgnoreCase(fieldName) || "characteristic.description".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("residues".equalsIgnoreCase(fieldName) || "chromosome.residues".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("seqlen".equalsIgnoreCase(fieldName) || "chromosome.seqlen".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("genome".equalsIgnoreCase(fieldName) || "chromosome.genome".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("orderNr".equalsIgnoreCase(fieldName) || "chromosome.orderNr".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("isAutosomal".equalsIgnoreCase(fieldName) || "chromosome.isAutosomal".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.BoolField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, Chromosome entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.variant.Chromosome> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.variant.Chromosome> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<Chromosome> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<Chromosome> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<Chromosome> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
