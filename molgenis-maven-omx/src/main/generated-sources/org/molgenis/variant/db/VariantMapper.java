/* File:        org.molgenis/model/Variant.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 26, 2012
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
import org.molgenis.variant.Variant;

import org.molgenis.observ.Characteristic;
import org.molgenis.observ.db.CharacteristicMapper;
import org.molgenis.variant.Chromosome;
import org.molgenis.variant.Gene;
import org.molgenis.variant.Protein;
import org.molgenis.observ.target.OntologyTerm;

public class VariantMapper extends AbstractJDBCMapper<Variant>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends Variant> entities) throws DatabaseException
	{	
		//add superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.Characteristic.class).executeAdd(entities);
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO Variant (gdna,gdna_start,gdna_end,cdna,cdna_start,cdna_end,aa,aa_start,aa_end,gdna_notation,cdna_notation,aa_notation,variantType,id) VALUES ");
		{
		
			boolean first = true;
			for(Variant e: entities)
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
				//aa
				if(e.getAa_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getAa_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//aa_start
				if(e.getAa_Start() != null){
								
					sql.append("'"+this.escapeSql(e.getAa_Start().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//aa_end
				if(e.getAa_End() != null){
								
					sql.append("'"+this.escapeSql(e.getAa_End().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//gdna_notation
				if(e.getGdna_Notation() != null){
								
					sql.append("'"+this.escapeSql(e.getGdna_Notation().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//cdna_notation
				if(e.getCdna_Notation() != null){
								
					sql.append("'"+this.escapeSql(e.getCdna_Notation().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//aa_notation
				if(e.getAa_Notation() != null){
								
					sql.append("'"+this.escapeSql(e.getAa_Notation().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//variantType
				if(e.getVariantType_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getVariantType_Id().toString())+"'"
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
	public int executeUpdate(List<? extends Variant> entities) throws DatabaseException
	{
		//update superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.Characteristic.class).executeUpdate(entities);
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO Variant (gdna,gdna_start,gdna_end,cdna,cdna_start,cdna_end,aa,aa_start,aa_end,gdna_notation,cdna_notation,aa_notation,variantType,id) VALUES ");		
		boolean first = true;
		for(Variant e: entities)
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
		
			//aa


			if(e.getAa_Id() != null){
                sql.append("'"+this.escapeSql(e.getAa_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//aa_start


			if(e.getAa_Start() != null){
                sql.append("'"+this.escapeSql(e.getAa_Start()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//aa_end


			if(e.getAa_End() != null){
                sql.append("'"+this.escapeSql(e.getAa_End()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//gdna_notation


			if(e.getGdna_Notation() != null){
                sql.append("'"+this.escapeSql(e.getGdna_Notation()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//cdna_notation


			if(e.getCdna_Notation() != null){
                sql.append("'"+this.escapeSql(e.getCdna_Notation()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//aa_notation


			if(e.getAa_Notation() != null){
                sql.append("'"+this.escapeSql(e.getAa_Notation()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//variantType


			if(e.getVariantType_Id() != null){
                sql.append("'"+this.escapeSql(e.getVariantType_Id()).toString()+"'" +",");
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
		sql.append(" ON DUPLICATE KEY UPDATE gdna_notation=VALUES(gdna_notation),cdna_notation=VALUES(cdna_notation),aa_notation=VALUES(aa_notation),variantType=VALUES(variantType),id=LAST_INSERT_ID(id),gdna=VALUES(gdna),gdna_start=VALUES(gdna_start),gdna_end=VALUES(gdna_end),cdna=VALUES(cdna),cdna_start=VALUES(cdna_start),cdna_end=VALUES(cdna_end),aa=VALUES(aa),aa_start=VALUES(aa_start),aa_end=VALUES(aa_end)");

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
	public int executeRemove(List<? extends Variant> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM Variant WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(Variant e: entities)
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
	
	public VariantMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT Variant.id"
			+", Characteristic.Identifier"
			+", Characteristic.Name"
			+", Characteristic.__Type"
			+", Characteristic.description"
			+", Variant.gdna"
			+", Variant.gdna_start"
			+", Variant.gdna_end"
			+", Variant.cdna"
			+", Variant.cdna_start"
			+", Variant.cdna_end"
			+", Variant.aa"
			+", Variant.aa_start"
			+", Variant.aa_end"
			+", Variant.gdna_notation"
			+", Variant.cdna_notation"
			+", Variant.aa_notation"
			+", Variant.variantType"
			//parent is SimpleTree(name='gdna')
			+", xref_gdna.Identifier AS gdna_Identifier"
			//parent is SimpleTree(name='cdna')
			+", xref_cdna.Identifier AS cdna_Identifier"
			//parent is SimpleTree(name='aa')
			+", xref_aa.Identifier AS aa_Identifier"
			//parent is SimpleTree(name='variantType')
			+", xref_variantType.Identifier AS variantType_Identifier"
			+" FROM Variant "
			+" INNER JOIN Characteristic ON (Variant.id = Characteristic.id)"

			
			//label for gdna=Identifier
//path==gdna. type==xref.
//path==gdna_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Characteristic AS xref_gdna " 
			+" ON xref_gdna.id = Variant.gdna"
			
			//label for cdna=Identifier
//path==cdna. type==xref.
//path==cdna_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Characteristic AS xref_cdna " 
			+" ON xref_cdna.id = Variant.cdna"
			
			//label for aa=Identifier
//path==aa. type==xref.
//path==aa_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Characteristic AS xref_aa " 
			+" ON xref_aa.id = Variant.aa"
			
			//label for variantType=Identifier
//path==variantType. type==xref.
//path==variantType_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN OntologyTerm AS xref_variantType " 
			+" ON xref_variantType.id = Variant.variantType"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM Variant "
			  +" INNER JOIN Characteristic ON (Variant.id = Characteristic.id)"
			
			//label for gdna=Identifier
//gdna
//gdna_Identifier
		   	+" LEFT JOIN Characteristic AS xref_gdna " 
			+" ON xref_gdna.id = Variant.gdna"
			
			//label for cdna=Identifier
//cdna
//cdna_Identifier
		   	+" LEFT JOIN Characteristic AS xref_cdna " 
			+" ON xref_cdna.id = Variant.cdna"
			
			//label for aa=Identifier
//aa
//aa_Identifier
		   	+" LEFT JOIN Characteristic AS xref_aa " 
			+" ON xref_aa.id = Variant.aa"
			
			//label for variantType=Identifier
//variantType
//variantType_Identifier
		   	+" LEFT JOIN OntologyTerm AS xref_variantType " 
			+" ON xref_variantType.id = Variant.variantType"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "Variant.id";
		if("Variant_id".equalsIgnoreCase(fieldName)) return "Variant.id";
		if("Identifier".equalsIgnoreCase(fieldName)) return "Characteristic.Identifier";
		if("Variant_Identifier".equalsIgnoreCase(fieldName)) return "Characteristic.Identifier";
		if("Name".equalsIgnoreCase(fieldName)) return "Characteristic.Name";
		if("Variant_Name".equalsIgnoreCase(fieldName)) return "Characteristic.Name";
		if("__Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("Variant___Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("description".equalsIgnoreCase(fieldName)) return "Characteristic.description";
		if("Variant_description".equalsIgnoreCase(fieldName)) return "Characteristic.description";
		if("gdna".equalsIgnoreCase(fieldName)) return "Variant.gdna";
		if("Variant_gdna".equalsIgnoreCase(fieldName)) return "Variant.gdna";
		if("gdna_start".equalsIgnoreCase(fieldName)) return "Variant.gdna_start";
		if("Variant_gdna_start".equalsIgnoreCase(fieldName)) return "Variant.gdna_start";
		if("gdna_end".equalsIgnoreCase(fieldName)) return "Variant.gdna_end";
		if("Variant_gdna_end".equalsIgnoreCase(fieldName)) return "Variant.gdna_end";
		if("cdna".equalsIgnoreCase(fieldName)) return "Variant.cdna";
		if("Variant_cdna".equalsIgnoreCase(fieldName)) return "Variant.cdna";
		if("cdna_start".equalsIgnoreCase(fieldName)) return "Variant.cdna_start";
		if("Variant_cdna_start".equalsIgnoreCase(fieldName)) return "Variant.cdna_start";
		if("cdna_end".equalsIgnoreCase(fieldName)) return "Variant.cdna_end";
		if("Variant_cdna_end".equalsIgnoreCase(fieldName)) return "Variant.cdna_end";
		if("aa".equalsIgnoreCase(fieldName)) return "Variant.aa";
		if("Variant_aa".equalsIgnoreCase(fieldName)) return "Variant.aa";
		if("aa_start".equalsIgnoreCase(fieldName)) return "Variant.aa_start";
		if("Variant_aa_start".equalsIgnoreCase(fieldName)) return "Variant.aa_start";
		if("aa_end".equalsIgnoreCase(fieldName)) return "Variant.aa_end";
		if("Variant_aa_end".equalsIgnoreCase(fieldName)) return "Variant.aa_end";
		if("gdna_notation".equalsIgnoreCase(fieldName)) return "Variant.gdna_notation";
		if("Variant_gdna_notation".equalsIgnoreCase(fieldName)) return "Variant.gdna_notation";
		if("cdna_notation".equalsIgnoreCase(fieldName)) return "Variant.cdna_notation";
		if("Variant_cdna_notation".equalsIgnoreCase(fieldName)) return "Variant.cdna_notation";
		if("aa_notation".equalsIgnoreCase(fieldName)) return "Variant.aa_notation";
		if("Variant_aa_notation".equalsIgnoreCase(fieldName)) return "Variant.aa_notation";
		if("variantType".equalsIgnoreCase(fieldName)) return "Variant.variantType";
		if("Variant_variantType".equalsIgnoreCase(fieldName)) return "Variant.variantType";
		if("gdna_id".equalsIgnoreCase(fieldName)) return "Variant.gdna";
		if("Variant_gdna_id".equalsIgnoreCase(fieldName)) return "Variant.gdna";
		if("gdna_Identifier".equalsIgnoreCase(fieldName)) return "xref_gdna.Identifier";	
		if("Variant_gdna_Identifier".equalsIgnoreCase(fieldName)) return "xref_gdna.Identifier";
		if("cdna_id".equalsIgnoreCase(fieldName)) return "Variant.cdna";
		if("Variant_cdna_id".equalsIgnoreCase(fieldName)) return "Variant.cdna";
		if("cdna_Identifier".equalsIgnoreCase(fieldName)) return "xref_cdna.Identifier";	
		if("Variant_cdna_Identifier".equalsIgnoreCase(fieldName)) return "xref_cdna.Identifier";
		if("aa_id".equalsIgnoreCase(fieldName)) return "Variant.aa";
		if("Variant_aa_id".equalsIgnoreCase(fieldName)) return "Variant.aa";
		if("aa_Identifier".equalsIgnoreCase(fieldName)) return "xref_aa.Identifier";	
		if("Variant_aa_Identifier".equalsIgnoreCase(fieldName)) return "xref_aa.Identifier";
		if("variantType_id".equalsIgnoreCase(fieldName)) return "Variant.variantType";
		if("Variant_variantType_id".equalsIgnoreCase(fieldName)) return "Variant.variantType";
		if("variantType_Identifier".equalsIgnoreCase(fieldName)) return "xref_variantType.Identifier";	
		if("Variant_variantType_Identifier".equalsIgnoreCase(fieldName)) return "xref_variantType.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.variant.Variant> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.variant.Variant>(size); 
	}			

	public org.molgenis.variant.Variant create()
	{
		return new org.molgenis.variant.Variant();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.variant.Variant> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'gdna' to chromosome.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> gdnaRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'cdna' to gene.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> cdnaRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'aa' to protein.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> aaRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'variantType' to ontologyTerm.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> variantTypeRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.variant.Variant object: entities)
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
			//create xref/mref rule filtering Protein on the label Identifier
			if(object.getAa_Id() == null && object.getAa_Identifier() != null)
			{
				Object label = object.getAa_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !aaRules.containsKey(label))
					{
						aaRules.put(""+label, xrefFilter);
						aaRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering OntologyTerm on the label Identifier
			if(object.getVariantType_Id() == null && object.getVariantType_Identifier() != null)
			{
				Object label = object.getVariantType_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !variantTypeRules.containsKey(label))
					{
						variantTypeRules.put(""+label, xrefFilter);
						variantTypeRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
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
		//resolve foreign key field 'aa' to protein.id using Identifier)
		final java.util.Map<String,Integer> aa_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(aaRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.variant.Protein> aaList = null;
			try
			{
				aaList = getDatabase().find(org.molgenis.variant.Protein.class, aaRules.values().toArray(new org.molgenis.framework.db.QueryRule[aaRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.variant.Protein xref :  aaList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				aa_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'variantType' to ontologyTerm.id using Identifier)
		final java.util.Map<String,Integer> variantType_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(variantTypeRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.observ.target.OntologyTerm> variantTypeList = null;
			try
			{
				variantTypeList = getDatabase().find(org.molgenis.observ.target.OntologyTerm.class, variantTypeRules.values().toArray(new org.molgenis.framework.db.QueryRule[variantTypeRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.observ.target.OntologyTerm xref :  variantTypeList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				variantType_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.variant.Variant object = entities.get(i);		
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
			//update object using label fields Identifier
			if(object.getAa_Id() == null )
			{
					String key = "";
					if(object.getAa_Identifier() != null)
						key += 	object.getAa_Identifier();
					
					if(!"".equals(key) && aa_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("aa_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setAa_Id(aa_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields Identifier
			if(object.getVariantType_Id() == null )
			{
					String key = "";
					if(object.getVariantType_Identifier() != null)
						key += 	object.getVariantType_Identifier();
					
					if(!"".equals(key) && variantType_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("variantType_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setVariantType_Id(variantType_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "variant.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("identifier".equalsIgnoreCase(fieldName) || "characteristic.identifier".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("name".equalsIgnoreCase(fieldName) || "characteristic.name".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("__Type".equalsIgnoreCase(fieldName) || "characteristic.__Type".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.EnumField();
			if("description".equalsIgnoreCase(fieldName) || "characteristic.description".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("gdna".equalsIgnoreCase(fieldName) || "variant.gdna".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("gdna_start".equalsIgnoreCase(fieldName) || "variant.gdna_start".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("gdna_end".equalsIgnoreCase(fieldName) || "variant.gdna_end".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("cdna".equalsIgnoreCase(fieldName) || "variant.cdna".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("cdna_start".equalsIgnoreCase(fieldName) || "variant.cdna_start".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("cdna_end".equalsIgnoreCase(fieldName) || "variant.cdna_end".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("aa".equalsIgnoreCase(fieldName) || "variant.aa".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("aa_start".equalsIgnoreCase(fieldName) || "variant.aa_start".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("aa_end".equalsIgnoreCase(fieldName) || "variant.aa_end".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("gdna_notation".equalsIgnoreCase(fieldName) || "variant.gdna_notation".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("cdna_notation".equalsIgnoreCase(fieldName) || "variant.cdna_notation".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("aa_notation".equalsIgnoreCase(fieldName) || "variant.aa_notation".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("variantType".equalsIgnoreCase(fieldName) || "variant.variantType".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, Variant entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.variant.Variant> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.variant.Variant> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<Variant> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<Variant> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<Variant> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
