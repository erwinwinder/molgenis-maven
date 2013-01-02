/* File:        org.molgenis.omx/model/Genome.java
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
import org.molgenis.variant.Genome;

import org.molgenis.observ.Characteristic;
import org.molgenis.observ.db.CharacteristicMapper;
import org.molgenis.observ.target.Species;

public class GenomeMapper extends AbstractJDBCMapper<Genome>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends Genome> entities) throws DatabaseException
	{	
		//add superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.Characteristic.class).executeAdd(entities);
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO Genome (residues,seqlen,species,id) VALUES ");
		{
		
			boolean first = true;
			for(Genome e: entities)
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
				//species
				if(e.getSpecies_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getSpecies_Id().toString())+"'"
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
	public int executeUpdate(List<? extends Genome> entities) throws DatabaseException
	{
		//update superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.Characteristic.class).executeUpdate(entities);
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO Genome (residues,seqlen,species,id) VALUES ");		
		boolean first = true;
		for(Genome e: entities)
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
		
			//species


			if(e.getSpecies_Id() != null){
                sql.append("'"+this.escapeSql(e.getSpecies_Id()).toString()+"'" +",");
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
		sql.append(" ON DUPLICATE KEY UPDATE species=VALUES(species),id=LAST_INSERT_ID(id),residues=VALUES(residues),seqlen=VALUES(seqlen)");

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
	public int executeRemove(List<? extends Genome> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM Genome WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(Genome e: entities)
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
	
	public GenomeMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT Genome.id"
			+", Characteristic.Identifier"
			+", Characteristic.Name"
			+", Characteristic.__Type"
			+", Characteristic.description"
			+", Genome.residues"
			+", Genome.seqlen"
			+", Genome.species"
			//parent is SimpleTree(name='species')
			+", xref_species.Identifier AS species_Identifier"
			+" FROM Genome "
			+" INNER JOIN Characteristic ON (Genome.id = Characteristic.id)"

			
			//label for species=Identifier
//path==species. type==xref.
//path==species_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN OntologyTerm AS xref_species " 
			+" ON xref_species.id = Genome.species"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM Genome "
			  +" INNER JOIN Characteristic ON (Genome.id = Characteristic.id)"
			
			//label for species=Identifier
//species
//species_Identifier
		   	+" LEFT JOIN OntologyTerm AS xref_species " 
			+" ON xref_species.id = Genome.species"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "Genome.id";
		if("Genome_id".equalsIgnoreCase(fieldName)) return "Genome.id";
		if("Identifier".equalsIgnoreCase(fieldName)) return "Characteristic.Identifier";
		if("Genome_Identifier".equalsIgnoreCase(fieldName)) return "Characteristic.Identifier";
		if("Name".equalsIgnoreCase(fieldName)) return "Characteristic.Name";
		if("Genome_Name".equalsIgnoreCase(fieldName)) return "Characteristic.Name";
		if("__Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("Genome___Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("description".equalsIgnoreCase(fieldName)) return "Characteristic.description";
		if("Genome_description".equalsIgnoreCase(fieldName)) return "Characteristic.description";
		if("residues".equalsIgnoreCase(fieldName)) return "Genome.residues";
		if("Genome_residues".equalsIgnoreCase(fieldName)) return "Genome.residues";
		if("seqlen".equalsIgnoreCase(fieldName)) return "Genome.seqlen";
		if("Genome_seqlen".equalsIgnoreCase(fieldName)) return "Genome.seqlen";
		if("species".equalsIgnoreCase(fieldName)) return "Genome.species";
		if("Genome_species".equalsIgnoreCase(fieldName)) return "Genome.species";
		if("species_id".equalsIgnoreCase(fieldName)) return "Genome.species";
		if("Genome_species_id".equalsIgnoreCase(fieldName)) return "Genome.species";
		if("species_Identifier".equalsIgnoreCase(fieldName)) return "xref_species.Identifier";	
		if("Genome_species_Identifier".equalsIgnoreCase(fieldName)) return "xref_species.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.variant.Genome> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.variant.Genome>(size); 
	}			

	public org.molgenis.variant.Genome create()
	{
		return new org.molgenis.variant.Genome();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.variant.Genome> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'species' to species.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> speciesRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.variant.Genome object: entities)
		{
			//create xref/mref rule filtering Species on the label Identifier
			if(object.getSpecies_Id() == null && object.getSpecies_Identifier() != null)
			{
				Object label = object.getSpecies_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !speciesRules.containsKey(label))
					{
						speciesRules.put(""+label, xrefFilter);
						speciesRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
		}

		//resolve foreign key field 'species' to species.id using Identifier)
		final java.util.Map<String,Integer> species_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(speciesRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.observ.target.Species> speciesList = null;
			try
			{
				speciesList = getDatabase().find(org.molgenis.observ.target.Species.class, speciesRules.values().toArray(new org.molgenis.framework.db.QueryRule[speciesRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.observ.target.Species xref :  speciesList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				species_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.variant.Genome object = entities.get(i);		
			//update object using label fields Identifier
			if(object.getSpecies_Id() == null )
			{
					String key = "";
					if(object.getSpecies_Identifier() != null)
						key += 	object.getSpecies_Identifier();
					
					if(!"".equals(key) && species_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("species_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setSpecies_Id(species_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "genome.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("identifier".equalsIgnoreCase(fieldName) || "characteristic.identifier".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("name".equalsIgnoreCase(fieldName) || "characteristic.name".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("__Type".equalsIgnoreCase(fieldName) || "characteristic.__Type".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.EnumField();
			if("description".equalsIgnoreCase(fieldName) || "characteristic.description".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("residues".equalsIgnoreCase(fieldName) || "genome.residues".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("seqlen".equalsIgnoreCase(fieldName) || "genome.seqlen".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("species".equalsIgnoreCase(fieldName) || "genome.species".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, Genome entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.variant.Genome> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.variant.Genome> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<Genome> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<Genome> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<Genome> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
