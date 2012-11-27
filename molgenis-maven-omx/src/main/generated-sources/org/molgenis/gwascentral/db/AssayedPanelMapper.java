/* File:        org.molgenis/model/AssayedPanel.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 26, 2012
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
import org.molgenis.util.ValueLabel;
import org.molgenis.gwascentral.AssayedPanel;

import org.molgenis.observ.target.Panel;
import org.molgenis.observ.target.db.PanelMapper;
import org.molgenis.observ.target.OntologyTerm;
import org.molgenis.observ.target.Species;
import org.molgenis.observ.target.Individual;
import org.molgenis.observ.target.Panel_Individuals;

public class AssayedPanelMapper extends AbstractJDBCMapper<AssayedPanel>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends AssayedPanel> entities) throws DatabaseException
	{	
		//add superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.target.Panel.class).executeAdd(entities);
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO AssayedPanel (id,Identifier,Name,Description,TotalNumberOfIndividuals,NumberOfSexMale,NumberOfSexFemale,NumberOfSexUnknown,NumberOfProbands,NumberOfParents) VALUES ");
		{
		
			boolean first = true;
			for(AssayedPanel e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//id
				if(e.getId() != null){
								
					sql.append("'"+this.escapeSql(e.getId().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
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
				//description
				if(e.getDescription() != null){
								
					sql.append("'"+this.escapeSql(e.getDescription().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//totalNumberOfIndividuals
				if(e.getTotalNumberOfIndividuals() != null){
								
					sql.append("'"+this.escapeSql(e.getTotalNumberOfIndividuals().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//numberOfSexMale
				if(e.getNumberOfSexMale() != null){
								
					sql.append("'"+this.escapeSql(e.getNumberOfSexMale().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//numberOfSexFemale
				if(e.getNumberOfSexFemale() != null){
								
					sql.append("'"+this.escapeSql(e.getNumberOfSexFemale().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//numberOfSexUnknown
				if(e.getNumberOfSexUnknown() != null){
								
					sql.append("'"+this.escapeSql(e.getNumberOfSexUnknown().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//numberOfProbands
				if(e.getNumberOfProbands() != null){
								
					sql.append("'"+this.escapeSql(e.getNumberOfProbands().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//numberOfParents
				if(e.getNumberOfParents() != null){
								
					sql.append("'"+this.escapeSql(e.getNumberOfParents().toString())+"'"
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
	public int executeUpdate(List<? extends AssayedPanel> entities) throws DatabaseException
	{
		//update superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.target.Panel.class).executeUpdate(entities);
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO AssayedPanel (id,Identifier,Name,Description,TotalNumberOfIndividuals,NumberOfSexMale,NumberOfSexFemale,NumberOfSexUnknown,NumberOfProbands,NumberOfParents) VALUES ");		
		boolean first = true;
		for(AssayedPanel e: entities)
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
		
			//description


			if(e.getDescription() != null){
                sql.append("'"+this.escapeSql(e.getDescription()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//totalNumberOfIndividuals


			if(e.getTotalNumberOfIndividuals() != null){
                sql.append("'"+this.escapeSql(e.getTotalNumberOfIndividuals()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//numberOfSexMale


			if(e.getNumberOfSexMale() != null){
                sql.append("'"+this.escapeSql(e.getNumberOfSexMale()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//numberOfSexFemale


			if(e.getNumberOfSexFemale() != null){
                sql.append("'"+this.escapeSql(e.getNumberOfSexFemale()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//numberOfSexUnknown


			if(e.getNumberOfSexUnknown() != null){
                sql.append("'"+this.escapeSql(e.getNumberOfSexUnknown()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//numberOfProbands


			if(e.getNumberOfProbands() != null){
                sql.append("'"+this.escapeSql(e.getNumberOfProbands()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//numberOfParents


			if(e.getNumberOfParents() != null){
                sql.append("'"+this.escapeSql(e.getNumberOfParents()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE Name=VALUES(Name),Description=VALUES(Description),TotalNumberOfIndividuals=VALUES(TotalNumberOfIndividuals),NumberOfSexMale=VALUES(NumberOfSexMale),NumberOfSexFemale=VALUES(NumberOfSexFemale),NumberOfSexUnknown=VALUES(NumberOfSexUnknown),NumberOfProbands=VALUES(NumberOfProbands),NumberOfParents=VALUES(NumberOfParents),Identifier=VALUES(Identifier),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends AssayedPanel> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM AssayedPanel WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(AssayedPanel e: entities)
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
		this.getDatabase().getMapperFor(org.molgenis.observ.target.Panel.class).executeRemove(entities);
		return rowsAffected;
	}
	
//Generated by MapperCommons.subclass_per_table.java.ftl
	
	public AssayedPanelMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT AssayedPanel.id"
			+", AssayedPanel.Identifier"
			+", AssayedPanel.Name"
			+", Characteristic.__Type"
			+", AssayedPanel.Description"
			+", Panel.PanelType"
			+", Panel.NumberOfIndividuals"
			+", Panel.Species"
			+", AssayedPanel.TotalNumberOfIndividuals"
			+", AssayedPanel.NumberOfSexMale"
			+", AssayedPanel.NumberOfSexFemale"
			+", AssayedPanel.NumberOfSexUnknown"
			+", AssayedPanel.NumberOfProbands"
			+", AssayedPanel.NumberOfParents"
			//parent is SimpleTree(name='PanelType')
			+", xref_PanelType.Identifier AS PanelType_Identifier"
			//parent is SimpleTree(name='Species')
			+", xref_Species.Identifier AS Species_Identifier"
			+" FROM AssayedPanel "
			+" INNER JOIN Panel ON (AssayedPanel.id = Panel.id)"
			+" INNER JOIN ObservationTarget ON (AssayedPanel.id = ObservationTarget.id)"
			+" INNER JOIN Characteristic ON (AssayedPanel.id = Characteristic.id)"

			
			//label for PanelType=Identifier
//path==PanelType. type==xref.
//path==PanelType_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN OntologyTerm AS xref_PanelType " 
			+" ON xref_PanelType.id = Panel.PanelType"
			
			//label for Species=Identifier
//path==Species. type==xref.
//path==Species_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN OntologyTerm AS xref_Species " 
			+" ON xref_Species.id = Panel.Species"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM AssayedPanel "
			  +" INNER JOIN Panel ON (AssayedPanel.id = Panel.id)"
			  +" INNER JOIN ObservationTarget ON (AssayedPanel.id = ObservationTarget.id)"
			  +" INNER JOIN Characteristic ON (AssayedPanel.id = Characteristic.id)"
			
			//label for PanelType=Identifier
//PanelType
//PanelType_Identifier
		   	+" LEFT JOIN OntologyTerm AS xref_PanelType " 
			+" ON xref_PanelType.id = Panel.PanelType"
			
			//label for Species=Identifier
//Species
//Species_Identifier
		   	+" LEFT JOIN OntologyTerm AS xref_Species " 
			+" ON xref_Species.id = Panel.Species"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "AssayedPanel.id";
		if("AssayedPanel_id".equalsIgnoreCase(fieldName)) return "AssayedPanel.id";
		if("Identifier".equalsIgnoreCase(fieldName)) return "AssayedPanel.Identifier";
		if("AssayedPanel_Identifier".equalsIgnoreCase(fieldName)) return "AssayedPanel.Identifier";
		if("Name".equalsIgnoreCase(fieldName)) return "AssayedPanel.Name";
		if("AssayedPanel_Name".equalsIgnoreCase(fieldName)) return "AssayedPanel.Name";
		if("__Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("AssayedPanel___Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("Description".equalsIgnoreCase(fieldName)) return "AssayedPanel.Description";
		if("AssayedPanel_Description".equalsIgnoreCase(fieldName)) return "AssayedPanel.Description";
		if("PanelType".equalsIgnoreCase(fieldName)) return "Panel.PanelType";
		if("AssayedPanel_PanelType".equalsIgnoreCase(fieldName)) return "Panel.PanelType";
		if("NumberOfIndividuals".equalsIgnoreCase(fieldName)) return "Panel.NumberOfIndividuals";
		if("AssayedPanel_NumberOfIndividuals".equalsIgnoreCase(fieldName)) return "Panel.NumberOfIndividuals";
		if("Species".equalsIgnoreCase(fieldName)) return "Panel.Species";
		if("AssayedPanel_Species".equalsIgnoreCase(fieldName)) return "Panel.Species";
		if("TotalNumberOfIndividuals".equalsIgnoreCase(fieldName)) return "AssayedPanel.TotalNumberOfIndividuals";
		if("AssayedPanel_TotalNumberOfIndividuals".equalsIgnoreCase(fieldName)) return "AssayedPanel.TotalNumberOfIndividuals";
		if("NumberOfSexMale".equalsIgnoreCase(fieldName)) return "AssayedPanel.NumberOfSexMale";
		if("AssayedPanel_NumberOfSexMale".equalsIgnoreCase(fieldName)) return "AssayedPanel.NumberOfSexMale";
		if("NumberOfSexFemale".equalsIgnoreCase(fieldName)) return "AssayedPanel.NumberOfSexFemale";
		if("AssayedPanel_NumberOfSexFemale".equalsIgnoreCase(fieldName)) return "AssayedPanel.NumberOfSexFemale";
		if("NumberOfSexUnknown".equalsIgnoreCase(fieldName)) return "AssayedPanel.NumberOfSexUnknown";
		if("AssayedPanel_NumberOfSexUnknown".equalsIgnoreCase(fieldName)) return "AssayedPanel.NumberOfSexUnknown";
		if("NumberOfProbands".equalsIgnoreCase(fieldName)) return "AssayedPanel.NumberOfProbands";
		if("AssayedPanel_NumberOfProbands".equalsIgnoreCase(fieldName)) return "AssayedPanel.NumberOfProbands";
		if("NumberOfParents".equalsIgnoreCase(fieldName)) return "AssayedPanel.NumberOfParents";
		if("AssayedPanel_NumberOfParents".equalsIgnoreCase(fieldName)) return "AssayedPanel.NumberOfParents";
		if("PanelType_id".equalsIgnoreCase(fieldName)) return "Panel.PanelType";
		if("AssayedPanel_PanelType_id".equalsIgnoreCase(fieldName)) return "Panel.PanelType";
		if("PanelType_Identifier".equalsIgnoreCase(fieldName)) return "xref_PanelType.Identifier";	
		if("AssayedPanel_PanelType_Identifier".equalsIgnoreCase(fieldName)) return "xref_PanelType.Identifier";
		if("Species_id".equalsIgnoreCase(fieldName)) return "Panel.Species";
		if("AssayedPanel_Species_id".equalsIgnoreCase(fieldName)) return "Panel.Species";
		if("Species_Identifier".equalsIgnoreCase(fieldName)) return "xref_Species.Identifier";	
		if("AssayedPanel_Species_Identifier".equalsIgnoreCase(fieldName)) return "xref_Species.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.gwascentral.AssayedPanel> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.gwascentral.AssayedPanel>(size); 
	}			

	public org.molgenis.gwascentral.AssayedPanel create()
	{
		return new org.molgenis.gwascentral.AssayedPanel();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.gwascentral.AssayedPanel> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'panelType' to ontologyTerm.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> panelTypeRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'species' to species.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> speciesRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'individuals' to individual.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> individualsRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.gwascentral.AssayedPanel object: entities)
		{
			//create xref/mref rule filtering OntologyTerm on the label Identifier
			if(object.getPanelType_Id() == null && object.getPanelType_Identifier() != null)
			{
				Object label = object.getPanelType_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !panelTypeRules.containsKey(label))
					{
						panelTypeRules.put(""+label, xrefFilter);
						panelTypeRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
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
			//create xref/mref rule filtering Individual on the label Identifier
			if(object.getIndividuals_Id().size() == 0 && object.getIndividuals_Identifier().size() > 0)
			{
				for(String label: object.getIndividuals_Identifier())
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !individualsRules.containsKey(label))
					{
						individualsRules.put(""+label, xrefFilter);
						individualsRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
		}

		//resolve foreign key field 'panelType' to ontologyTerm.id using Identifier)
		final java.util.Map<String,Integer> panelType_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(panelTypeRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.observ.target.OntologyTerm> panelTypeList = null;
			try
			{
				panelTypeList = getDatabase().find(org.molgenis.observ.target.OntologyTerm.class, panelTypeRules.values().toArray(new org.molgenis.framework.db.QueryRule[panelTypeRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.observ.target.OntologyTerm xref :  panelTypeList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				panelType_Labels_to_IdMap.put(key, xref.getId());
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
		//resolve foreign key field 'individuals' to individual.id using Identifier)
		final java.util.Map<String,Integer> individuals_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(individualsRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.observ.target.Individual> individualsList = null;
			try
			{
				individualsList = getDatabase().find(org.molgenis.observ.target.Individual.class, individualsRules.values().toArray(new org.molgenis.framework.db.QueryRule[individualsRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.observ.target.Individual xref :  individualsList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				individuals_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.gwascentral.AssayedPanel object = entities.get(i);		
			//update object using label fields Identifier
			if(object.getPanelType_Id() == null )
			{
					String key = "";
					if(object.getPanelType_Identifier() != null)
						key += 	object.getPanelType_Identifier();
					
					if(!"".equals(key) && panelType_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("PanelType_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setPanelType_Id(panelType_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields Identifier
			if(object.getSpecies_Id() == null )
			{
					String key = "";
					if(object.getSpecies_Identifier() != null)
						key += 	object.getSpecies_Identifier();
					
					if(!"".equals(key) && species_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Species_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setSpecies_Id(species_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields Identifier
			if(object.getIndividuals_Id() == null || object.getIndividuals_Id().size() == 0)
			{
				java.util.List<Integer> idList = new java.util.ArrayList<Integer>();
				for(int j = 0; j < object.getIndividuals_Identifier().size(); j++)
				{
					String key = "";
					if(object.getIndividuals_Identifier().get(j) != null)
						key += 	object.getIndividuals_Identifier().get(j);
					
					if(!"".equals(key) && individuals_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Individuals_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						idList.add(individuals_Labels_to_IdMap.get(key));
					}
				}
				object.setIndividuals_Id(idList);
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "assayedPanel.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("identifier".equalsIgnoreCase(fieldName) || "assayedPanel.identifier".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("name".equalsIgnoreCase(fieldName) || "assayedPanel.name".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("__Type".equalsIgnoreCase(fieldName) || "characteristic.__Type".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.EnumField();
			if("description".equalsIgnoreCase(fieldName) || "assayedPanel.description".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("panelType".equalsIgnoreCase(fieldName) || "panel.panelType".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("numberOfIndividuals".equalsIgnoreCase(fieldName) || "panel.numberOfIndividuals".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("species".equalsIgnoreCase(fieldName) || "panel.species".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("totalNumberOfIndividuals".equalsIgnoreCase(fieldName) || "assayedPanel.totalNumberOfIndividuals".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("numberOfSexMale".equalsIgnoreCase(fieldName) || "assayedPanel.numberOfSexMale".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("numberOfSexFemale".equalsIgnoreCase(fieldName) || "assayedPanel.numberOfSexFemale".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("numberOfSexUnknown".equalsIgnoreCase(fieldName) || "assayedPanel.numberOfSexUnknown".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("numberOfProbands".equalsIgnoreCase(fieldName) || "assayedPanel.numberOfProbands".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("numberOfParents".equalsIgnoreCase(fieldName) || "assayedPanel.numberOfParents".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, AssayedPanel entity)
	{
		entity.setId(i);
	}
	
	@Override
	public QueryRule rewriteMrefRule(Database db, QueryRule rule) throws DatabaseException
	{
		if("Individuals".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// Panel_Individuals
			List<Panel_Individuals> mref_mapping_entities = db.find(Panel_Individuals.class, new QueryRule(
					"Individuals", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (Panel_Individuals mref : mref_mapping_entities) mref_ids.add(mref.getPanel_Id());
				return new QueryRule("id", Operator.IN, mref_ids);
			}		
			else
			{
				// no records to be shown
				return new QueryRule("id", Operator.EQUALS, Integer.MIN_VALUE);
			}			
		}
		else if("Individuals_Identifier".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// Panel_Individuals
			List<Panel_Individuals> mref_mapping_entities = db.find(Panel_Individuals.class, new QueryRule(
					"Individuals_Identifier", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (Panel_Individuals mref : mref_mapping_entities) mref_ids.add(mref.getPanel_Id());
				return new QueryRule("id", Operator.IN, mref_ids);
			}		
			else
			{
				// no records to be shown
				return new QueryRule("id", Operator.EQUALS, Integer.MIN_VALUE);
			}
		}
		else
		{
			return rule;
		}
	}

//Generated by MapperFileAttachments.java.ftl
	public void prepareFileAttachements(java.util.List<org.molgenis.gwascentral.AssayedPanel> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.gwascentral.AssayedPanel> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<AssayedPanel> entities ) throws DatabaseException			
	{
		try
		{
			//list the assayedPanel ids to query
			List<Integer> assayedPanelIds = new ArrayList<Integer>();
			for(AssayedPanel entity: entities)
			{
				assayedPanelIds.add(entity.getId());
			}
			
			//map the Individuals mrefs
			List<Panel_Individuals> individuals_mrefs = this.getDatabase().query(Panel_Individuals.class).in("Panel", assayedPanelIds).sortASC("autoid").find();
			Map<Integer,List<Integer>> individuals_individuals_map = new LinkedHashMap<Integer,List<Integer>>();
			Map<Integer,List<String>> individuals_Identifier_map = new LinkedHashMap<Integer,List<String>>();
			
			for(Panel_Individuals ref: individuals_mrefs)
			{
				if(individuals_individuals_map.get(ref.getPanel_Id()) == null) individuals_individuals_map.put(ref.getPanel_Id(),new ArrayList<Integer>()); 
				individuals_individuals_map.get(ref.getPanel_Id()).add(ref.getIndividuals_Id());
				if(individuals_Identifier_map.get(ref.getPanel_Id()) == null)	individuals_Identifier_map.put(ref.getPanel_Id(),new ArrayList<String>());
				individuals_Identifier_map.get(ref.getPanel_Id()).add(ref.getIndividuals_Identifier());
			}
			
			//load the mapped data into the entities
			for(AssayedPanel entity: entities)
			{
				Integer id = entity.getId();
				if(individuals_individuals_map.get(id) != null)
				{
					entity.setIndividuals_Id(individuals_individuals_map.get(id));
				}
				if(individuals_Identifier_map.get(id) != null)
				{
					entity.setIndividuals_Identifier(individuals_Identifier_map.get(id));
				}
			}
		} 
		catch(Exception e)
		{	
			throw new DatabaseException(e);
		}
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<AssayedPanel> entities ) throws DatabaseException, IOException, ParseException	
	{
		//create an List of AssayedPanel ids to query for
		List<Integer> entityIds = new ArrayList<Integer>(); 
		for (AssayedPanel entity : entities) 
		{
			entityIds.add(entity.getId());		
		}
		
		//delete existing mrefs
		getDatabase().remove(getDatabase().query( Panel_Individuals.class).in("Panel", entityIds).find());
		List<Panel_Individuals> panel_IndividualsToAdd = new ArrayList<Panel_Individuals>();


		//check for each mref what needs to be added
		for(AssayedPanel entity: entities)
		{
			//remove duplicates using Set
			entity.setIndividuals(new ArrayList(new LinkedHashSet(entity.getIndividuals_Id())));
			for(Integer id: entity.getIndividuals_Id())
			{
				Panel_Individuals new_mref = new Panel_Individuals();
				new_mref.setPanel( entity.getId() );
				new_mref.setIndividuals( id );
				panel_IndividualsToAdd.add(new_mref);
			}
			
		}
		
		//process changes to Panel_Individuals
		getDatabase().add( panel_IndividualsToAdd );
	}
		
	
	public void removeMrefs( List<AssayedPanel> entities ) throws DatabaseException, IOException, ParseException
	{
		//create an list of AssayedPanel ids to query for
		List<Integer> entityIds = new ArrayList<Integer>(); 
		for (AssayedPanel entity : entities) 
		{
			entityIds.add(entity.getId());		
		}	
	
		//remove all Panel_Individuals elements for field entity.Individuals
		getDatabase().remove( getDatabase().query( Panel_Individuals.class).in("Panel", entityIds).find() );
	}	
}
