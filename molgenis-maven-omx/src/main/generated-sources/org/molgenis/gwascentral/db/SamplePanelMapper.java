/* File:        org.molgenis/model/SamplePanel.java
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
import org.molgenis.gwascentral.SamplePanel;

import org.molgenis.observ.target.Panel;
import org.molgenis.observ.target.db.PanelMapper;
import org.molgenis.observ.target.OntologyTerm;
import org.molgenis.observ.target.Species;
import org.molgenis.observ.target.Individual;
import org.molgenis.observ.target.Panel_Individuals;
import org.molgenis.observ.target.OntologyTerm;

public class SamplePanelMapper extends AbstractJDBCMapper<SamplePanel>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends SamplePanel> entities) throws DatabaseException
	{	
		//add superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.target.Panel.class).executeAdd(entities);
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO SamplePanel (id,Identifier,Name,CentralIdentifier,Label,Accession,AccessionVersion,Description,Composition,TotalNumberOfIndividuals,NumberOfSexMale,NumberOfSexFemale,NumberOfSexUnknown,NumberOfProbands,NumberOfParents,ModeOfRecruitment,DiagnosisAgeRange,DiagnosisPeriod,SamplingAgeRange,SamplingPeriod,PopulationInfo,GeographicRegionInfo,EthnicityInfo,BirthPlaceInfo,AdmixtureInfo,EnvironmentInfo,SourceOfDNA,DNAsArePooled,DNAsAreWGA) VALUES ");
		{
		
			boolean first = true;
			for(SamplePanel e: entities)
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
				//centralIdentifier
				if(e.getCentralIdentifier_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getCentralIdentifier_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//label
				if(e.getLabel() != null){
								
					sql.append("'"+this.escapeSql(e.getLabel().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//accession
				if(e.getAccession() != null){
								
					sql.append("'"+this.escapeSql(e.getAccession().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//accessionVersion
				if(e.getAccessionVersion() != null){
								
					sql.append("'"+this.escapeSql(e.getAccessionVersion().toString())+"'"
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
				//composition
				if(e.getComposition() != null){
								
					sql.append("'"+this.escapeSql(e.getComposition().toString())+"'"
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
				+",");
				}
				else{
					sql.append("null,");
				}
				//modeOfRecruitment
				if(e.getModeOfRecruitment() != null){
								
					sql.append("'"+this.escapeSql(e.getModeOfRecruitment().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//diagnosisAgeRange
				if(e.getDiagnosisAgeRange() != null){
								
					sql.append("'"+this.escapeSql(e.getDiagnosisAgeRange().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//diagnosisPeriod
				if(e.getDiagnosisPeriod() != null){
								
					sql.append("'"+this.escapeSql(e.getDiagnosisPeriod().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//samplingAgeRange
				if(e.getSamplingAgeRange() != null){
								
					sql.append("'"+this.escapeSql(e.getSamplingAgeRange().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//samplingPeriod
				if(e.getSamplingPeriod() != null){
								
					sql.append("'"+this.escapeSql(e.getSamplingPeriod().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//populationInfo
				if(e.getPopulationInfo() != null){
								
					sql.append("'"+this.escapeSql(e.getPopulationInfo().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//geographicRegionInfo
				if(e.getGeographicRegionInfo() != null){
								
					sql.append("'"+this.escapeSql(e.getGeographicRegionInfo().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//ethnicityInfo
				if(e.getEthnicityInfo() != null){
								
					sql.append("'"+this.escapeSql(e.getEthnicityInfo().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//birthPlaceInfo
				if(e.getBirthPlaceInfo() != null){
								
					sql.append("'"+this.escapeSql(e.getBirthPlaceInfo().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//admixtureInfo
				if(e.getAdmixtureInfo() != null){
								
					sql.append("'"+this.escapeSql(e.getAdmixtureInfo().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//environmentInfo
				if(e.getEnvironmentInfo() != null){
								
					sql.append("'"+this.escapeSql(e.getEnvironmentInfo().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//sourceOfDNA
				if(e.getSourceOfDNA() != null){
								
					sql.append("'"+this.escapeSql(e.getSourceOfDNA().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//dNAsArePooled
				if(e.getDNAsArePooled() != null){
								
					sql.append("'"+this.escapeSql(e.getDNAsArePooled().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//dNAsAreWGA
				if(e.getDNAsAreWGA() != null){
								
					sql.append("'"+this.escapeSql(e.getDNAsAreWGA().toString())+"'"
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
	public int executeUpdate(List<? extends SamplePanel> entities) throws DatabaseException
	{
		//update superclass first
		this.getDatabase().getMapperFor(org.molgenis.observ.target.Panel.class).executeUpdate(entities);
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO SamplePanel (id,Identifier,Name,CentralIdentifier,Label,Accession,AccessionVersion,Description,Composition,TotalNumberOfIndividuals,NumberOfSexMale,NumberOfSexFemale,NumberOfSexUnknown,NumberOfProbands,NumberOfParents,ModeOfRecruitment,DiagnosisAgeRange,DiagnosisPeriod,SamplingAgeRange,SamplingPeriod,PopulationInfo,GeographicRegionInfo,EthnicityInfo,BirthPlaceInfo,AdmixtureInfo,EnvironmentInfo,SourceOfDNA,DNAsArePooled,DNAsAreWGA) VALUES ");		
		boolean first = true;
		for(SamplePanel e: entities)
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
		
			//centralIdentifier


			if(e.getCentralIdentifier_Id() != null){
                sql.append("'"+this.escapeSql(e.getCentralIdentifier_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//label


			if(e.getLabel() != null){
                sql.append("'"+this.escapeSql(e.getLabel()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//accession


			if(e.getAccession() != null){
                sql.append("'"+this.escapeSql(e.getAccession()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//accessionVersion


			if(e.getAccessionVersion() != null){
                sql.append("'"+this.escapeSql(e.getAccessionVersion()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//description


			if(e.getDescription() != null){
                sql.append("'"+this.escapeSql(e.getDescription()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//composition


			if(e.getComposition() != null){
                sql.append("'"+this.escapeSql(e.getComposition()).toString()+"'" +",");
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
                sql.append("'"+this.escapeSql(e.getNumberOfParents()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//modeOfRecruitment


			if(e.getModeOfRecruitment() != null){
                sql.append("'"+this.escapeSql(e.getModeOfRecruitment()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//diagnosisAgeRange


			if(e.getDiagnosisAgeRange() != null){
                sql.append("'"+this.escapeSql(e.getDiagnosisAgeRange()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//diagnosisPeriod


			if(e.getDiagnosisPeriod() != null){
                sql.append("'"+this.escapeSql(e.getDiagnosisPeriod()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//samplingAgeRange


			if(e.getSamplingAgeRange() != null){
                sql.append("'"+this.escapeSql(e.getSamplingAgeRange()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//samplingPeriod


			if(e.getSamplingPeriod() != null){
                sql.append("'"+this.escapeSql(e.getSamplingPeriod()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//populationInfo


			if(e.getPopulationInfo() != null){
                sql.append("'"+this.escapeSql(e.getPopulationInfo()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//geographicRegionInfo


			if(e.getGeographicRegionInfo() != null){
                sql.append("'"+this.escapeSql(e.getGeographicRegionInfo()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//ethnicityInfo


			if(e.getEthnicityInfo() != null){
                sql.append("'"+this.escapeSql(e.getEthnicityInfo()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//birthPlaceInfo


			if(e.getBirthPlaceInfo() != null){
                sql.append("'"+this.escapeSql(e.getBirthPlaceInfo()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//admixtureInfo


			if(e.getAdmixtureInfo() != null){
                sql.append("'"+this.escapeSql(e.getAdmixtureInfo()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//environmentInfo


			if(e.getEnvironmentInfo() != null){
                sql.append("'"+this.escapeSql(e.getEnvironmentInfo()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//sourceOfDNA


			if(e.getSourceOfDNA() != null){
                sql.append("'"+this.escapeSql(e.getSourceOfDNA()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//dNAsArePooled


			if(e.getDNAsArePooled() != null){
                sql.append("'"+this.escapeSql(e.getDNAsArePooled())+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//dNAsAreWGA


			if(e.getDNAsAreWGA() != null){
                sql.append("'"+this.escapeSql(e.getDNAsAreWGA())+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE CentralIdentifier=VALUES(CentralIdentifier),Name=VALUES(Name),Label=VALUES(Label),Accession=VALUES(Accession),AccessionVersion=VALUES(AccessionVersion),Description=VALUES(Description),Composition=VALUES(Composition),TotalNumberOfIndividuals=VALUES(TotalNumberOfIndividuals),NumberOfSexMale=VALUES(NumberOfSexMale),NumberOfSexFemale=VALUES(NumberOfSexFemale),NumberOfSexUnknown=VALUES(NumberOfSexUnknown),NumberOfProbands=VALUES(NumberOfProbands),NumberOfParents=VALUES(NumberOfParents),ModeOfRecruitment=VALUES(ModeOfRecruitment),DiagnosisAgeRange=VALUES(DiagnosisAgeRange),DiagnosisPeriod=VALUES(DiagnosisPeriod),SamplingAgeRange=VALUES(SamplingAgeRange),SamplingPeriod=VALUES(SamplingPeriod),PopulationInfo=VALUES(PopulationInfo),GeographicRegionInfo=VALUES(GeographicRegionInfo),EthnicityInfo=VALUES(EthnicityInfo),BirthPlaceInfo=VALUES(BirthPlaceInfo),AdmixtureInfo=VALUES(AdmixtureInfo),EnvironmentInfo=VALUES(EnvironmentInfo),SourceOfDNA=VALUES(SourceOfDNA),DNAsArePooled=VALUES(DNAsArePooled),DNAsAreWGA=VALUES(DNAsAreWGA),Identifier=VALUES(Identifier),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends SamplePanel> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM SamplePanel WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(SamplePanel e: entities)
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
	
	public SamplePanelMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT SamplePanel.id"
			+", SamplePanel.Identifier"
			+", SamplePanel.Name"
			+", Characteristic.__Type"
			+", SamplePanel.Description"
			+", Panel.PanelType"
			+", Panel.NumberOfIndividuals"
			+", Panel.Species"
			+", SamplePanel.CentralIdentifier"
			+", SamplePanel.Label"
			+", SamplePanel.Accession"
			+", SamplePanel.AccessionVersion"
			+", SamplePanel.Composition"
			+", SamplePanel.TotalNumberOfIndividuals"
			+", SamplePanel.NumberOfSexMale"
			+", SamplePanel.NumberOfSexFemale"
			+", SamplePanel.NumberOfSexUnknown"
			+", SamplePanel.NumberOfProbands"
			+", SamplePanel.NumberOfParents"
			+", SamplePanel.ModeOfRecruitment"
			+", SamplePanel.DiagnosisAgeRange"
			+", SamplePanel.DiagnosisPeriod"
			+", SamplePanel.SamplingAgeRange"
			+", SamplePanel.SamplingPeriod"
			+", SamplePanel.PopulationInfo"
			+", SamplePanel.GeographicRegionInfo"
			+", SamplePanel.EthnicityInfo"
			+", SamplePanel.BirthPlaceInfo"
			+", SamplePanel.AdmixtureInfo"
			+", SamplePanel.EnvironmentInfo"
			+", SamplePanel.SourceOfDNA"
			+", SamplePanel.DNAsArePooled"
			+", SamplePanel.DNAsAreWGA"
			//parent is SimpleTree(name='PanelType')
			+", xref_PanelType.Identifier AS PanelType_Identifier"
			//parent is SimpleTree(name='Species')
			+", xref_Species.Identifier AS Species_Identifier"
			//parent is SimpleTree(name='CentralIdentifier')
			+", xref_CentralIdentifier.Identifier AS CentralIdentifier_Identifier"
			+" FROM SamplePanel "
			+" INNER JOIN Panel ON (SamplePanel.id = Panel.id)"
			+" INNER JOIN ObservationTarget ON (SamplePanel.id = ObservationTarget.id)"
			+" INNER JOIN Characteristic ON (SamplePanel.id = Characteristic.id)"

			
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
			
			//label for CentralIdentifier=Identifier
//path==CentralIdentifier. type==xref.
//path==CentralIdentifier_Identifier. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN OntologyTerm AS xref_CentralIdentifier " 
			+" ON xref_CentralIdentifier.id = SamplePanel.CentralIdentifier"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM SamplePanel "
			  +" INNER JOIN Panel ON (SamplePanel.id = Panel.id)"
			  +" INNER JOIN ObservationTarget ON (SamplePanel.id = ObservationTarget.id)"
			  +" INNER JOIN Characteristic ON (SamplePanel.id = Characteristic.id)"
			
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
			
			//label for CentralIdentifier=Identifier
//CentralIdentifier
//CentralIdentifier_Identifier
		   	+" LEFT JOIN OntologyTerm AS xref_CentralIdentifier " 
			+" ON xref_CentralIdentifier.id = SamplePanel.CentralIdentifier"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "SamplePanel.id";
		if("SamplePanel_id".equalsIgnoreCase(fieldName)) return "SamplePanel.id";
		if("Identifier".equalsIgnoreCase(fieldName)) return "SamplePanel.Identifier";
		if("SamplePanel_Identifier".equalsIgnoreCase(fieldName)) return "SamplePanel.Identifier";
		if("Name".equalsIgnoreCase(fieldName)) return "SamplePanel.Name";
		if("SamplePanel_Name".equalsIgnoreCase(fieldName)) return "SamplePanel.Name";
		if("__Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("SamplePanel___Type".equalsIgnoreCase(fieldName)) return "Characteristic.__Type";
		if("Description".equalsIgnoreCase(fieldName)) return "SamplePanel.Description";
		if("SamplePanel_Description".equalsIgnoreCase(fieldName)) return "SamplePanel.Description";
		if("PanelType".equalsIgnoreCase(fieldName)) return "Panel.PanelType";
		if("SamplePanel_PanelType".equalsIgnoreCase(fieldName)) return "Panel.PanelType";
		if("NumberOfIndividuals".equalsIgnoreCase(fieldName)) return "Panel.NumberOfIndividuals";
		if("SamplePanel_NumberOfIndividuals".equalsIgnoreCase(fieldName)) return "Panel.NumberOfIndividuals";
		if("Species".equalsIgnoreCase(fieldName)) return "Panel.Species";
		if("SamplePanel_Species".equalsIgnoreCase(fieldName)) return "Panel.Species";
		if("CentralIdentifier".equalsIgnoreCase(fieldName)) return "SamplePanel.CentralIdentifier";
		if("SamplePanel_CentralIdentifier".equalsIgnoreCase(fieldName)) return "SamplePanel.CentralIdentifier";
		if("Label".equalsIgnoreCase(fieldName)) return "SamplePanel.Label";
		if("SamplePanel_Label".equalsIgnoreCase(fieldName)) return "SamplePanel.Label";
		if("Accession".equalsIgnoreCase(fieldName)) return "SamplePanel.Accession";
		if("SamplePanel_Accession".equalsIgnoreCase(fieldName)) return "SamplePanel.Accession";
		if("AccessionVersion".equalsIgnoreCase(fieldName)) return "SamplePanel.AccessionVersion";
		if("SamplePanel_AccessionVersion".equalsIgnoreCase(fieldName)) return "SamplePanel.AccessionVersion";
		if("Composition".equalsIgnoreCase(fieldName)) return "SamplePanel.Composition";
		if("SamplePanel_Composition".equalsIgnoreCase(fieldName)) return "SamplePanel.Composition";
		if("TotalNumberOfIndividuals".equalsIgnoreCase(fieldName)) return "SamplePanel.TotalNumberOfIndividuals";
		if("SamplePanel_TotalNumberOfIndividuals".equalsIgnoreCase(fieldName)) return "SamplePanel.TotalNumberOfIndividuals";
		if("NumberOfSexMale".equalsIgnoreCase(fieldName)) return "SamplePanel.NumberOfSexMale";
		if("SamplePanel_NumberOfSexMale".equalsIgnoreCase(fieldName)) return "SamplePanel.NumberOfSexMale";
		if("NumberOfSexFemale".equalsIgnoreCase(fieldName)) return "SamplePanel.NumberOfSexFemale";
		if("SamplePanel_NumberOfSexFemale".equalsIgnoreCase(fieldName)) return "SamplePanel.NumberOfSexFemale";
		if("NumberOfSexUnknown".equalsIgnoreCase(fieldName)) return "SamplePanel.NumberOfSexUnknown";
		if("SamplePanel_NumberOfSexUnknown".equalsIgnoreCase(fieldName)) return "SamplePanel.NumberOfSexUnknown";
		if("NumberOfProbands".equalsIgnoreCase(fieldName)) return "SamplePanel.NumberOfProbands";
		if("SamplePanel_NumberOfProbands".equalsIgnoreCase(fieldName)) return "SamplePanel.NumberOfProbands";
		if("NumberOfParents".equalsIgnoreCase(fieldName)) return "SamplePanel.NumberOfParents";
		if("SamplePanel_NumberOfParents".equalsIgnoreCase(fieldName)) return "SamplePanel.NumberOfParents";
		if("ModeOfRecruitment".equalsIgnoreCase(fieldName)) return "SamplePanel.ModeOfRecruitment";
		if("SamplePanel_ModeOfRecruitment".equalsIgnoreCase(fieldName)) return "SamplePanel.ModeOfRecruitment";
		if("DiagnosisAgeRange".equalsIgnoreCase(fieldName)) return "SamplePanel.DiagnosisAgeRange";
		if("SamplePanel_DiagnosisAgeRange".equalsIgnoreCase(fieldName)) return "SamplePanel.DiagnosisAgeRange";
		if("DiagnosisPeriod".equalsIgnoreCase(fieldName)) return "SamplePanel.DiagnosisPeriod";
		if("SamplePanel_DiagnosisPeriod".equalsIgnoreCase(fieldName)) return "SamplePanel.DiagnosisPeriod";
		if("SamplingAgeRange".equalsIgnoreCase(fieldName)) return "SamplePanel.SamplingAgeRange";
		if("SamplePanel_SamplingAgeRange".equalsIgnoreCase(fieldName)) return "SamplePanel.SamplingAgeRange";
		if("SamplingPeriod".equalsIgnoreCase(fieldName)) return "SamplePanel.SamplingPeriod";
		if("SamplePanel_SamplingPeriod".equalsIgnoreCase(fieldName)) return "SamplePanel.SamplingPeriod";
		if("PopulationInfo".equalsIgnoreCase(fieldName)) return "SamplePanel.PopulationInfo";
		if("SamplePanel_PopulationInfo".equalsIgnoreCase(fieldName)) return "SamplePanel.PopulationInfo";
		if("GeographicRegionInfo".equalsIgnoreCase(fieldName)) return "SamplePanel.GeographicRegionInfo";
		if("SamplePanel_GeographicRegionInfo".equalsIgnoreCase(fieldName)) return "SamplePanel.GeographicRegionInfo";
		if("EthnicityInfo".equalsIgnoreCase(fieldName)) return "SamplePanel.EthnicityInfo";
		if("SamplePanel_EthnicityInfo".equalsIgnoreCase(fieldName)) return "SamplePanel.EthnicityInfo";
		if("BirthPlaceInfo".equalsIgnoreCase(fieldName)) return "SamplePanel.BirthPlaceInfo";
		if("SamplePanel_BirthPlaceInfo".equalsIgnoreCase(fieldName)) return "SamplePanel.BirthPlaceInfo";
		if("AdmixtureInfo".equalsIgnoreCase(fieldName)) return "SamplePanel.AdmixtureInfo";
		if("SamplePanel_AdmixtureInfo".equalsIgnoreCase(fieldName)) return "SamplePanel.AdmixtureInfo";
		if("EnvironmentInfo".equalsIgnoreCase(fieldName)) return "SamplePanel.EnvironmentInfo";
		if("SamplePanel_EnvironmentInfo".equalsIgnoreCase(fieldName)) return "SamplePanel.EnvironmentInfo";
		if("SourceOfDNA".equalsIgnoreCase(fieldName)) return "SamplePanel.SourceOfDNA";
		if("SamplePanel_SourceOfDNA".equalsIgnoreCase(fieldName)) return "SamplePanel.SourceOfDNA";
		if("DNAsArePooled".equalsIgnoreCase(fieldName)) return "SamplePanel.DNAsArePooled";
		if("SamplePanel_DNAsArePooled".equalsIgnoreCase(fieldName)) return "SamplePanel.DNAsArePooled";
		if("DNAsAreWGA".equalsIgnoreCase(fieldName)) return "SamplePanel.DNAsAreWGA";
		if("SamplePanel_DNAsAreWGA".equalsIgnoreCase(fieldName)) return "SamplePanel.DNAsAreWGA";
		if("PanelType_id".equalsIgnoreCase(fieldName)) return "Panel.PanelType";
		if("SamplePanel_PanelType_id".equalsIgnoreCase(fieldName)) return "Panel.PanelType";
		if("PanelType_Identifier".equalsIgnoreCase(fieldName)) return "xref_PanelType.Identifier";	
		if("SamplePanel_PanelType_Identifier".equalsIgnoreCase(fieldName)) return "xref_PanelType.Identifier";
		if("Species_id".equalsIgnoreCase(fieldName)) return "Panel.Species";
		if("SamplePanel_Species_id".equalsIgnoreCase(fieldName)) return "Panel.Species";
		if("Species_Identifier".equalsIgnoreCase(fieldName)) return "xref_Species.Identifier";	
		if("SamplePanel_Species_Identifier".equalsIgnoreCase(fieldName)) return "xref_Species.Identifier";
		if("CentralIdentifier_id".equalsIgnoreCase(fieldName)) return "SamplePanel.CentralIdentifier";
		if("SamplePanel_CentralIdentifier_id".equalsIgnoreCase(fieldName)) return "SamplePanel.CentralIdentifier";
		if("CentralIdentifier_Identifier".equalsIgnoreCase(fieldName)) return "xref_CentralIdentifier.Identifier";	
		if("SamplePanel_CentralIdentifier_Identifier".equalsIgnoreCase(fieldName)) return "xref_CentralIdentifier.Identifier";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.gwascentral.SamplePanel> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.gwascentral.SamplePanel>(size); 
	}			

	public org.molgenis.gwascentral.SamplePanel create()
	{
		return new org.molgenis.gwascentral.SamplePanel();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.gwascentral.SamplePanel> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
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
		//create foreign key map for field 'centralIdentifier' to ontologyTerm.id using Identifier)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> centralIdentifierRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.gwascentral.SamplePanel object: entities)
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
			//create xref/mref rule filtering OntologyTerm on the label Identifier
			if(object.getCentralIdentifier_Id() == null && object.getCentralIdentifier_Identifier() != null)
			{
				Object label = object.getCentralIdentifier_Identifier();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("Identifier", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !centralIdentifierRules.containsKey(label))
					{
						centralIdentifierRules.put(""+label, xrefFilter);
						centralIdentifierRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
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
		//resolve foreign key field 'centralIdentifier' to ontologyTerm.id using Identifier)
		final java.util.Map<String,Integer> centralIdentifier_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(centralIdentifierRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.observ.target.OntologyTerm> centralIdentifierList = null;
			try
			{
				centralIdentifierList = getDatabase().find(org.molgenis.observ.target.OntologyTerm.class, centralIdentifierRules.values().toArray(new org.molgenis.framework.db.QueryRule[centralIdentifierRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.observ.target.OntologyTerm xref :  centralIdentifierList)
			{
				String key = "";
				key += 	xref.getIdentifier();
				
				centralIdentifier_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.gwascentral.SamplePanel object = entities.get(i);		
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
			//update object using label fields Identifier
			if(object.getCentralIdentifier_Id() == null )
			{
					String key = "";
					if(object.getCentralIdentifier_Identifier() != null)
						key += 	object.getCentralIdentifier_Identifier();
					
					if(!"".equals(key) && centralIdentifier_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("CentralIdentifier_Identifier cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setCentralIdentifier_Id(centralIdentifier_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "samplePanel.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("identifier".equalsIgnoreCase(fieldName) || "samplePanel.identifier".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("name".equalsIgnoreCase(fieldName) || "samplePanel.name".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("__Type".equalsIgnoreCase(fieldName) || "characteristic.__Type".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.EnumField();
			if("description".equalsIgnoreCase(fieldName) || "samplePanel.description".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("panelType".equalsIgnoreCase(fieldName) || "panel.panelType".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("numberOfIndividuals".equalsIgnoreCase(fieldName) || "panel.numberOfIndividuals".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("species".equalsIgnoreCase(fieldName) || "panel.species".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("centralIdentifier".equalsIgnoreCase(fieldName) || "samplePanel.centralIdentifier".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("label".equalsIgnoreCase(fieldName) || "samplePanel.label".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("accession".equalsIgnoreCase(fieldName) || "samplePanel.accession".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("accessionVersion".equalsIgnoreCase(fieldName) || "samplePanel.accessionVersion".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("composition".equalsIgnoreCase(fieldName) || "samplePanel.composition".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("totalNumberOfIndividuals".equalsIgnoreCase(fieldName) || "samplePanel.totalNumberOfIndividuals".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("numberOfSexMale".equalsIgnoreCase(fieldName) || "samplePanel.numberOfSexMale".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("numberOfSexFemale".equalsIgnoreCase(fieldName) || "samplePanel.numberOfSexFemale".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("numberOfSexUnknown".equalsIgnoreCase(fieldName) || "samplePanel.numberOfSexUnknown".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("numberOfProbands".equalsIgnoreCase(fieldName) || "samplePanel.numberOfProbands".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("numberOfParents".equalsIgnoreCase(fieldName) || "samplePanel.numberOfParents".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("modeOfRecruitment".equalsIgnoreCase(fieldName) || "samplePanel.modeOfRecruitment".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("diagnosisAgeRange".equalsIgnoreCase(fieldName) || "samplePanel.diagnosisAgeRange".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("diagnosisPeriod".equalsIgnoreCase(fieldName) || "samplePanel.diagnosisPeriod".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("samplingAgeRange".equalsIgnoreCase(fieldName) || "samplePanel.samplingAgeRange".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("samplingPeriod".equalsIgnoreCase(fieldName) || "samplePanel.samplingPeriod".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("populationInfo".equalsIgnoreCase(fieldName) || "samplePanel.populationInfo".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("geographicRegionInfo".equalsIgnoreCase(fieldName) || "samplePanel.geographicRegionInfo".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("ethnicityInfo".equalsIgnoreCase(fieldName) || "samplePanel.ethnicityInfo".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("birthPlaceInfo".equalsIgnoreCase(fieldName) || "samplePanel.birthPlaceInfo".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("admixtureInfo".equalsIgnoreCase(fieldName) || "samplePanel.admixtureInfo".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("environmentInfo".equalsIgnoreCase(fieldName) || "samplePanel.environmentInfo".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("sourceOfDNA".equalsIgnoreCase(fieldName) || "samplePanel.sourceOfDNA".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("dNAsArePooled".equalsIgnoreCase(fieldName) || "samplePanel.dNAsArePooled".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.EnumField();
			if("dNAsAreWGA".equalsIgnoreCase(fieldName) || "samplePanel.dNAsAreWGA".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.EnumField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, SamplePanel entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.gwascentral.SamplePanel> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.gwascentral.SamplePanel> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<SamplePanel> entities ) throws DatabaseException			
	{
		try
		{
			//list the samplePanel ids to query
			List<Integer> samplePanelIds = new ArrayList<Integer>();
			for(SamplePanel entity: entities)
			{
				samplePanelIds.add(entity.getId());
			}
			
			//map the Individuals mrefs
			List<Panel_Individuals> individuals_mrefs = this.getDatabase().query(Panel_Individuals.class).in("Panel", samplePanelIds).sortASC("autoid").find();
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
			for(SamplePanel entity: entities)
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
	public void storeMrefs( List<SamplePanel> entities ) throws DatabaseException, IOException, ParseException	
	{
		//create an List of SamplePanel ids to query for
		List<Integer> entityIds = new ArrayList<Integer>(); 
		for (SamplePanel entity : entities) 
		{
			entityIds.add(entity.getId());		
		}
		
		//delete existing mrefs
		getDatabase().remove(getDatabase().query( Panel_Individuals.class).in("Panel", entityIds).find());
		List<Panel_Individuals> panel_IndividualsToAdd = new ArrayList<Panel_Individuals>();


		//check for each mref what needs to be added
		for(SamplePanel entity: entities)
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
		
	
	public void removeMrefs( List<SamplePanel> entities ) throws DatabaseException, IOException, ParseException
	{
		//create an list of SamplePanel ids to query for
		List<Integer> entityIds = new ArrayList<Integer>(); 
		for (SamplePanel entity : entities) 
		{
			entityIds.add(entity.getId());		
		}	
	
		//remove all Panel_Individuals elements for field entity.Individuals
		getDatabase().remove( getDatabase().query( Panel_Individuals.class).in("Panel", entityIds).find() );
	}	
}
