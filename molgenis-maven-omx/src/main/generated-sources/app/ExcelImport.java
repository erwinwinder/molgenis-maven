
/* Date:        November 26, 2012
 * 
 * generator:   org.molgenis.generators.excel.ExcelImportGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package app;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import jxl.Workbook;

import org.apache.log4j.Logger;
import org.molgenis.framework.db.Database;
import org.molgenis.framework.db.DatabaseException;
import org.molgenis.framework.db.CsvToDatabase.ImportResult;
import org.molgenis.framework.db.Database.DatabaseAction;
import org.molgenis.util.Tuple;

import org.molgenis.core.excel.MolgenisEntityExcelReader;
import org.molgenis.core.excel.MolgenisFileExcelReader;
import org.molgenis.core.excel.RuntimePropertyExcelReader;
import org.molgenis.auth.excel.MolgenisRoleExcelReader;
import org.molgenis.auth.excel.MolgenisGroupExcelReader;
import org.molgenis.auth.excel.MolgenisUserExcelReader;
import org.molgenis.auth.excel.MolgenisRoleGroupLinkExcelReader;
import org.molgenis.auth.excel.MolgenisPermissionExcelReader;
import org.molgenis.observ.excel.CharacteristicExcelReader;
import org.molgenis.observ.excel.ObservationTargetExcelReader;
import org.molgenis.observ.excel.ObservableFeatureExcelReader;
import org.molgenis.observ.excel.CategoryExcelReader;
import org.molgenis.observ.excel.ProtocolExcelReader;
import org.molgenis.observ.excel.DataSetExcelReader;
import org.molgenis.observ.excel.ObservationSetExcelReader;
import org.molgenis.observ.excel.ObservedValueExcelReader;
import org.molgenis.observ.target.excel.SpeciesExcelReader;
import org.molgenis.observ.target.excel.IndividualExcelReader;
import org.molgenis.observ.target.excel.PanelExcelReader;
import org.molgenis.observ.target.excel.PanelSourceExcelReader;
import org.molgenis.observ.target.excel.OntologyExcelReader;
import org.molgenis.observ.target.excel.OntologyTermExcelReader;
import org.molgenis.observ.target.excel.AccessionExcelReader;
import org.molgenis.variant.excel.GenomeExcelReader;
import org.molgenis.variant.excel.ChromosomeExcelReader;
import org.molgenis.variant.excel.GeneExcelReader;
import org.molgenis.variant.excel.ProteinExcelReader;
import org.molgenis.variant.excel.ProteinDomainExcelReader;
import org.molgenis.variant.excel.ExonExcelReader;
import org.molgenis.variant.excel.VariantExcelReader;
import org.molgenis.organization.excel.StudyExcelReader;
import org.molgenis.organization.excel.ExperimentExcelReader;
import org.molgenis.organization.excel.InstituteExcelReader;
import org.molgenis.organization.excel.PersonExcelReader;
import org.molgenis.organization.excel.CitationExcelReader;
import org.molgenis.organization.excel.ContributionExcelReader;
import org.molgenis.organization.excel.SubmissionExcelReader;
import org.molgenis.gwascentral.excel.InvestigationExcelReader;
import org.molgenis.gwascentral.excel.StudyDetailsExcelReader;
import org.molgenis.gwascentral.excel.FrequencyClusterExcelReader;
import org.molgenis.gwascentral.excel.GenotypeFrequencyExcelReader;
import org.molgenis.gwascentral.excel.AlleleFrequencyExcelReader;
import org.molgenis.gwascentral.excel.PhenotypePropertyExcelReader;
import org.molgenis.gwascentral.excel.PhenotypeMethodExcelReader;
import org.molgenis.gwascentral.excel.PhenotypeValueExcelReader;
import org.molgenis.gwascentral.excel.SamplePanelExcelReader;
import org.molgenis.gwascentral.excel.AssayedPanelExcelReader;
import org.molgenis.gwascentral.excel.GWASExperimentExcelReader;
import org.molgenis.gwascentral.excel.UsedMarkerSetExcelReader;
import org.molgenis.gwascentral.excel.SignificanceExcelReader;
import org.molgenis.gwascentral.excel.EffectSizeExcelReader;
import org.molgenis.gwascentral.excel.SelectionCriteriaExcelReader;
import org.molgenis.observ.excel.Protocol_SubprotocolsExcelReader;
import org.molgenis.observ.excel.Protocol_FeaturesExcelReader;
import org.molgenis.observ.target.excel.Panel_IndividualsExcelReader;
import org.molgenis.organization.excel.Experiment_AssayedPanelsExcelReader;
import org.molgenis.organization.excel.Experiment_DataSetsExcelReader;
import org.molgenis.organization.excel.Person_AffiliateInstitutionsExcelReader;
import org.molgenis.organization.excel.Citation_OntologyTermsExcelReader;
import org.molgenis.gwascentral.excel.StudyDetails_OtherCitationsExcelReader;

public class ExcelImport
{
	static Logger logger = Logger.getLogger(ExcelImport.class.getSimpleName());
	
	public static void importAll(File excelFile, Database db, Tuple defaults) throws Exception
	{
		importAll(excelFile, db, defaults, null, DatabaseAction.ADD, "", true);
	}
	
	public static ImportResult importAll(File excelFile, Database db, Tuple defaults, List<String> components, DatabaseAction dbAction, String missingValue) throws Exception
	{
		return importAll(excelFile, db, defaults, components, dbAction, missingValue, true);
	}
	
	public static void importAll(File excelFile, Database db, Tuple defaults, boolean useDbTransaction) throws Exception
	{
		//set default missing value to ""
		importAll(excelFile, db, defaults, null, DatabaseAction.ADD, "", useDbTransaction);
	}

	public static ImportResult importAll(File excelFile, Database db, Tuple defaults, List<String> components, DatabaseAction dbAction, String missingValue, boolean useDbTransaction) throws Exception
	{
		//fixes the problem where, even though decimals have a "." they are still read as "," because of the locale!
		//TODO: dangerous: entire application locale changes! but workbook locale settings don't seem to have an effect...
		Locale saveTheDefault = Locale.getDefault();
		Locale.setDefault(Locale.US);
		
		Workbook workbook = Workbook.getWorkbook(excelFile);
		ArrayList<String> sheetNames = new ArrayList<String>();
		for(String sheetName : workbook.getSheetNames()){
			sheetNames.add(sheetName.toLowerCase());
		}
		
		ImportResult result = new ImportResult();

		try
		{
			if (useDbTransaction)
			{
				if (!db.inTx())
				{
					db.beginTx();
				}
				else
				{
					throw new DatabaseException("Cannot continue ExcelImport: database already in transaction.");
				}
			}
						
			if(dbAction.toString().startsWith("REMOVE"))
			{
				//reverse xref dependency order for remove
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("experiment_datasets")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("experiment_datasets")){
							count = new Experiment_DataSetsExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("experiment_datasets")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("experiment_datasets");
						result.getMessages().put("experiment_datasets", "evaluated "+count+" experiment_datasets elements");
					} catch (Exception e) {
						result.setErrorItem("experiment_datasets");
						result.getMessages().put("experiment_datasets", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("phenotypevalue")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("phenotypevalue")){
							count = new PhenotypeValueExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("phenotypevalue")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("phenotypevalue");
						result.getMessages().put("phenotypevalue", "evaluated "+count+" phenotypevalue elements");
					} catch (Exception e) {
						result.setErrorItem("phenotypevalue");
						result.getMessages().put("phenotypevalue", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("allelefrequency")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("allelefrequency")){
							count = new AlleleFrequencyExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("allelefrequency")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("allelefrequency");
						result.getMessages().put("allelefrequency", "evaluated "+count+" allelefrequency elements");
					} catch (Exception e) {
						result.setErrorItem("allelefrequency");
						result.getMessages().put("allelefrequency", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("genotypefrequency")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("genotypefrequency")){
							count = new GenotypeFrequencyExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("genotypefrequency")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("genotypefrequency");
						result.getMessages().put("genotypefrequency", "evaluated "+count+" genotypefrequency elements");
					} catch (Exception e) {
						result.setErrorItem("genotypefrequency");
						result.getMessages().put("genotypefrequency", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("frequencycluster")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("frequencycluster")){
							count = new FrequencyClusterExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("frequencycluster")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("frequencycluster");
						result.getMessages().put("frequencycluster", "evaluated "+count+" frequencycluster elements");
					} catch (Exception e) {
						result.setErrorItem("frequencycluster");
						result.getMessages().put("frequencycluster", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("observedvalue")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("observedvalue")){
							count = new ObservedValueExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("observedvalue")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("observedvalue");
						result.getMessages().put("observedvalue", "evaluated "+count+" observedvalue elements");
					} catch (Exception e) {
						result.setErrorItem("observedvalue");
						result.getMessages().put("observedvalue", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("observationset")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("observationset")){
							count = new ObservationSetExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("observationset")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("observationset");
						result.getMessages().put("observationset", "evaluated "+count+" observationset elements");
					} catch (Exception e) {
						result.setErrorItem("observationset");
						result.getMessages().put("observationset", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("studydetails_othercitations")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("studydetails_othercitations")){
							count = new StudyDetails_OtherCitationsExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("studydetails_othercitations")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("studydetails_othercitations");
						result.getMessages().put("studydetails_othercitations", "evaluated "+count+" studydetails_othercitations elements");
					} catch (Exception e) {
						result.setErrorItem("studydetails_othercitations");
						result.getMessages().put("studydetails_othercitations", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("citation_ontologyterms")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("citation_ontologyterms")){
							count = new Citation_OntologyTermsExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("citation_ontologyterms")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("citation_ontologyterms");
						result.getMessages().put("citation_ontologyterms", "evaluated "+count+" citation_ontologyterms elements");
					} catch (Exception e) {
						result.setErrorItem("citation_ontologyterms");
						result.getMessages().put("citation_ontologyterms", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("person_affiliateinstitutions")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("person_affiliateinstitutions")){
							count = new Person_AffiliateInstitutionsExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("person_affiliateinstitutions")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("person_affiliateinstitutions");
						result.getMessages().put("person_affiliateinstitutions", "evaluated "+count+" person_affiliateinstitutions elements");
					} catch (Exception e) {
						result.setErrorItem("person_affiliateinstitutions");
						result.getMessages().put("person_affiliateinstitutions", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("experiment_assayedpanels")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("experiment_assayedpanels")){
							count = new Experiment_AssayedPanelsExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("experiment_assayedpanels")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("experiment_assayedpanels");
						result.getMessages().put("experiment_assayedpanels", "evaluated "+count+" experiment_assayedpanels elements");
					} catch (Exception e) {
						result.setErrorItem("experiment_assayedpanels");
						result.getMessages().put("experiment_assayedpanels", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("panel_individuals")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("panel_individuals")){
							count = new Panel_IndividualsExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("panel_individuals")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("panel_individuals");
						result.getMessages().put("panel_individuals", "evaluated "+count+" panel_individuals elements");
					} catch (Exception e) {
						result.setErrorItem("panel_individuals");
						result.getMessages().put("panel_individuals", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("protocol_features")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("protocol_features")){
							count = new Protocol_FeaturesExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("protocol_features")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("protocol_features");
						result.getMessages().put("protocol_features", "evaluated "+count+" protocol_features elements");
					} catch (Exception e) {
						result.setErrorItem("protocol_features");
						result.getMessages().put("protocol_features", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("protocol_subprotocols")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("protocol_subprotocols")){
							count = new Protocol_SubprotocolsExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("protocol_subprotocols")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("protocol_subprotocols");
						result.getMessages().put("protocol_subprotocols", "evaluated "+count+" protocol_subprotocols elements");
					} catch (Exception e) {
						result.setErrorItem("protocol_subprotocols");
						result.getMessages().put("protocol_subprotocols", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("selectioncriteria")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("selectioncriteria")){
							count = new SelectionCriteriaExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("selectioncriteria")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("selectioncriteria");
						result.getMessages().put("selectioncriteria", "evaluated "+count+" selectioncriteria elements");
					} catch (Exception e) {
						result.setErrorItem("selectioncriteria");
						result.getMessages().put("selectioncriteria", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("effectsize")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("effectsize")){
							count = new EffectSizeExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("effectsize")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("effectsize");
						result.getMessages().put("effectsize", "evaluated "+count+" effectsize elements");
					} catch (Exception e) {
						result.setErrorItem("effectsize");
						result.getMessages().put("effectsize", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("significance")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("significance")){
							count = new SignificanceExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("significance")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("significance");
						result.getMessages().put("significance", "evaluated "+count+" significance elements");
					} catch (Exception e) {
						result.setErrorItem("significance");
						result.getMessages().put("significance", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("category")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("category")){
							count = new CategoryExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("category")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("category");
						result.getMessages().put("category", "evaluated "+count+" category elements");
					} catch (Exception e) {
						result.setErrorItem("category");
						result.getMessages().put("category", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("usedmarkerset")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("usedmarkerset")){
							count = new UsedMarkerSetExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("usedmarkerset")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("usedmarkerset");
						result.getMessages().put("usedmarkerset", "evaluated "+count+" usedmarkerset elements");
					} catch (Exception e) {
						result.setErrorItem("usedmarkerset");
						result.getMessages().put("usedmarkerset", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("gwasexperiment")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("gwasexperiment")){
							count = new GWASExperimentExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("gwasexperiment")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("gwasexperiment");
						result.getMessages().put("gwasexperiment", "evaluated "+count+" gwasexperiment elements");
					} catch (Exception e) {
						result.setErrorItem("gwasexperiment");
						result.getMessages().put("gwasexperiment", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("panelsource")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("panelsource")){
							count = new PanelSourceExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("panelsource")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("panelsource");
						result.getMessages().put("panelsource", "evaluated "+count+" panelsource elements");
					} catch (Exception e) {
						result.setErrorItem("panelsource");
						result.getMessages().put("panelsource", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("assayedpanel")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("assayedpanel")){
							count = new AssayedPanelExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("assayedpanel")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("assayedpanel");
						result.getMessages().put("assayedpanel", "evaluated "+count+" assayedpanel elements");
					} catch (Exception e) {
						result.setErrorItem("assayedpanel");
						result.getMessages().put("assayedpanel", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("samplepanel")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("samplepanel")){
							count = new SamplePanelExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("samplepanel")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("samplepanel");
						result.getMessages().put("samplepanel", "evaluated "+count+" samplepanel elements");
					} catch (Exception e) {
						result.setErrorItem("samplepanel");
						result.getMessages().put("samplepanel", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("phenotypemethod")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("phenotypemethod")){
							count = new PhenotypeMethodExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("phenotypemethod")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("phenotypemethod");
						result.getMessages().put("phenotypemethod", "evaluated "+count+" phenotypemethod elements");
					} catch (Exception e) {
						result.setErrorItem("phenotypemethod");
						result.getMessages().put("phenotypemethod", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("phenotypeproperty")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("phenotypeproperty")){
							count = new PhenotypePropertyExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("phenotypeproperty")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("phenotypeproperty");
						result.getMessages().put("phenotypeproperty", "evaluated "+count+" phenotypeproperty elements");
					} catch (Exception e) {
						result.setErrorItem("phenotypeproperty");
						result.getMessages().put("phenotypeproperty", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("studydetails")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("studydetails")){
							count = new StudyDetailsExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("studydetails")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("studydetails");
						result.getMessages().put("studydetails", "evaluated "+count+" studydetails elements");
					} catch (Exception e) {
						result.setErrorItem("studydetails");
						result.getMessages().put("studydetails", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("contribution")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("contribution")){
							count = new ContributionExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("contribution")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("contribution");
						result.getMessages().put("contribution", "evaluated "+count+" contribution elements");
					} catch (Exception e) {
						result.setErrorItem("contribution");
						result.getMessages().put("contribution", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("submission")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("submission")){
							count = new SubmissionExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("submission")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("submission");
						result.getMessages().put("submission", "evaluated "+count+" submission elements");
					} catch (Exception e) {
						result.setErrorItem("submission");
						result.getMessages().put("submission", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("experiment")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("experiment")){
							count = new ExperimentExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("experiment")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("experiment");
						result.getMessages().put("experiment", "evaluated "+count+" experiment elements");
					} catch (Exception e) {
						result.setErrorItem("experiment");
						result.getMessages().put("experiment", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("study")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("study")){
							count = new StudyExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("study")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("study");
						result.getMessages().put("study", "evaluated "+count+" study elements");
					} catch (Exception e) {
						result.setErrorItem("study");
						result.getMessages().put("study", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("investigation")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("investigation")){
							count = new InvestigationExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("investigation")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("investigation");
						result.getMessages().put("investigation", "evaluated "+count+" investigation elements");
					} catch (Exception e) {
						result.setErrorItem("investigation");
						result.getMessages().put("investigation", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("citation")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("citation")){
							count = new CitationExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("citation")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("citation");
						result.getMessages().put("citation", "evaluated "+count+" citation elements");
					} catch (Exception e) {
						result.setErrorItem("citation");
						result.getMessages().put("citation", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("person")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("person")){
							count = new PersonExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("person")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("person");
						result.getMessages().put("person", "evaluated "+count+" person elements");
					} catch (Exception e) {
						result.setErrorItem("person");
						result.getMessages().put("person", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("institute")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("institute")){
							count = new InstituteExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("institute")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("institute");
						result.getMessages().put("institute", "evaluated "+count+" institute elements");
					} catch (Exception e) {
						result.setErrorItem("institute");
						result.getMessages().put("institute", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("variant")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("variant")){
							count = new VariantExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("variant")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("variant");
						result.getMessages().put("variant", "evaluated "+count+" variant elements");
					} catch (Exception e) {
						result.setErrorItem("variant");
						result.getMessages().put("variant", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("exon")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("exon")){
							count = new ExonExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("exon")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("exon");
						result.getMessages().put("exon", "evaluated "+count+" exon elements");
					} catch (Exception e) {
						result.setErrorItem("exon");
						result.getMessages().put("exon", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("proteindomain")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("proteindomain")){
							count = new ProteinDomainExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("proteindomain")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("proteindomain");
						result.getMessages().put("proteindomain", "evaluated "+count+" proteindomain elements");
					} catch (Exception e) {
						result.setErrorItem("proteindomain");
						result.getMessages().put("proteindomain", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("protein")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("protein")){
							count = new ProteinExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("protein")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("protein");
						result.getMessages().put("protein", "evaluated "+count+" protein elements");
					} catch (Exception e) {
						result.setErrorItem("protein");
						result.getMessages().put("protein", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("gene")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("gene")){
							count = new GeneExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("gene")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("gene");
						result.getMessages().put("gene", "evaluated "+count+" gene elements");
					} catch (Exception e) {
						result.setErrorItem("gene");
						result.getMessages().put("gene", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("chromosome")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("chromosome")){
							count = new ChromosomeExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("chromosome")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("chromosome");
						result.getMessages().put("chromosome", "evaluated "+count+" chromosome elements");
					} catch (Exception e) {
						result.setErrorItem("chromosome");
						result.getMessages().put("chromosome", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("genome")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("genome")){
							count = new GenomeExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("genome")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("genome");
						result.getMessages().put("genome", "evaluated "+count+" genome elements");
					} catch (Exception e) {
						result.setErrorItem("genome");
						result.getMessages().put("genome", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("panel")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("panel")){
							count = new PanelExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("panel")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("panel");
						result.getMessages().put("panel", "evaluated "+count+" panel elements");
					} catch (Exception e) {
						result.setErrorItem("panel");
						result.getMessages().put("panel", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("dataset")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("dataset")){
							count = new DataSetExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("dataset")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("dataset");
						result.getMessages().put("dataset", "evaluated "+count+" dataset elements");
					} catch (Exception e) {
						result.setErrorItem("dataset");
						result.getMessages().put("dataset", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("protocol")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("protocol")){
							count = new ProtocolExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("protocol")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("protocol");
						result.getMessages().put("protocol", "evaluated "+count+" protocol elements");
					} catch (Exception e) {
						result.setErrorItem("protocol");
						result.getMessages().put("protocol", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("observablefeature")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("observablefeature")){
							count = new ObservableFeatureExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("observablefeature")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("observablefeature");
						result.getMessages().put("observablefeature", "evaluated "+count+" observablefeature elements");
					} catch (Exception e) {
						result.setErrorItem("observablefeature");
						result.getMessages().put("observablefeature", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("accession")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("accession")){
							count = new AccessionExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("accession")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("accession");
						result.getMessages().put("accession", "evaluated "+count+" accession elements");
					} catch (Exception e) {
						result.setErrorItem("accession");
						result.getMessages().put("accession", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("ontologyterm")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("ontologyterm")){
							count = new OntologyTermExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("ontologyterm")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("ontologyterm");
						result.getMessages().put("ontologyterm", "evaluated "+count+" ontologyterm elements");
					} catch (Exception e) {
						result.setErrorItem("ontologyterm");
						result.getMessages().put("ontologyterm", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("species")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("species")){
							count = new SpeciesExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("species")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("species");
						result.getMessages().put("species", "evaluated "+count+" species elements");
					} catch (Exception e) {
						result.setErrorItem("species");
						result.getMessages().put("species", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("ontology")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("ontology")){
							count = new OntologyExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("ontology")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("ontology");
						result.getMessages().put("ontology", "evaluated "+count+" ontology elements");
					} catch (Exception e) {
						result.setErrorItem("ontology");
						result.getMessages().put("ontology", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("individual")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("individual")){
							count = new IndividualExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("individual")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("individual");
						result.getMessages().put("individual", "evaluated "+count+" individual elements");
					} catch (Exception e) {
						result.setErrorItem("individual");
						result.getMessages().put("individual", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("observationtarget")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("observationtarget")){
							count = new ObservationTargetExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("observationtarget")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("observationtarget");
						result.getMessages().put("observationtarget", "evaluated "+count+" observationtarget elements");
					} catch (Exception e) {
						result.setErrorItem("observationtarget");
						result.getMessages().put("observationtarget", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("characteristic")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("characteristic")){
							count = new CharacteristicExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("characteristic")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("characteristic");
						result.getMessages().put("characteristic", "evaluated "+count+" characteristic elements");
					} catch (Exception e) {
						result.setErrorItem("characteristic");
						result.getMessages().put("characteristic", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("molgenispermission")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("molgenispermission")){
							count = new MolgenisPermissionExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("molgenispermission")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("molgenispermission");
						result.getMessages().put("molgenispermission", "evaluated "+count+" molgenispermission elements");
					} catch (Exception e) {
						result.setErrorItem("molgenispermission");
						result.getMessages().put("molgenispermission", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("molgenisrolegrouplink")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("molgenisrolegrouplink")){
							count = new MolgenisRoleGroupLinkExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("molgenisrolegrouplink")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("molgenisrolegrouplink");
						result.getMessages().put("molgenisrolegrouplink", "evaluated "+count+" molgenisrolegrouplink elements");
					} catch (Exception e) {
						result.setErrorItem("molgenisrolegrouplink");
						result.getMessages().put("molgenisrolegrouplink", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("molgenisuser")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("molgenisuser")){
							count = new MolgenisUserExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("molgenisuser")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("molgenisuser");
						result.getMessages().put("molgenisuser", "evaluated "+count+" molgenisuser elements");
					} catch (Exception e) {
						result.setErrorItem("molgenisuser");
						result.getMessages().put("molgenisuser", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("molgenisgroup")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("molgenisgroup")){
							count = new MolgenisGroupExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("molgenisgroup")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("molgenisgroup");
						result.getMessages().put("molgenisgroup", "evaluated "+count+" molgenisgroup elements");
					} catch (Exception e) {
						result.setErrorItem("molgenisgroup");
						result.getMessages().put("molgenisgroup", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("molgenisrole")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("molgenisrole")){
							count = new MolgenisRoleExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("molgenisrole")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("molgenisrole");
						result.getMessages().put("molgenisrole", "evaluated "+count+" molgenisrole elements");
					} catch (Exception e) {
						result.setErrorItem("molgenisrole");
						result.getMessages().put("molgenisrole", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("runtimeproperty")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("runtimeproperty")){
							count = new RuntimePropertyExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("runtimeproperty")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("runtimeproperty");
						result.getMessages().put("runtimeproperty", "evaluated "+count+" runtimeproperty elements");
					} catch (Exception e) {
						result.setErrorItem("runtimeproperty");
						result.getMessages().put("runtimeproperty", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("molgenisfile")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("molgenisfile")){
							count = new MolgenisFileExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("molgenisfile")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("molgenisfile");
						result.getMessages().put("molgenisfile", "evaluated "+count+" molgenisfile elements");
					} catch (Exception e) {
						result.setErrorItem("molgenisfile");
						result.getMessages().put("molgenisfile", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("molgenisentity")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("molgenisentity")){
							count = new MolgenisEntityExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("molgenisentity")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("molgenisentity");
						result.getMessages().put("molgenisentity", "evaluated "+count+" molgenisentity elements");
					} catch (Exception e) {
						result.setErrorItem("molgenisentity");
						result.getMessages().put("molgenisentity", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
			}
			else
			{
				//follow xref dependency order
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("molgenisentity")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("molgenisentity")){
							count = new MolgenisEntityExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("molgenisentity")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("molgenisentity");
						result.getMessages().put("molgenisentity",  "evaluated "+count+" molgenisentity elements");
					} catch (Exception e) {
						result.setErrorItem("molgenisentity");
						result.getMessages().put("molgenisentity", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("molgenisfile")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("molgenisfile")){
							count = new MolgenisFileExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("molgenisfile")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("molgenisfile");
						result.getMessages().put("molgenisfile",  "evaluated "+count+" molgenisfile elements");
					} catch (Exception e) {
						result.setErrorItem("molgenisfile");
						result.getMessages().put("molgenisfile", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("runtimeproperty")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("runtimeproperty")){
							count = new RuntimePropertyExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("runtimeproperty")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("runtimeproperty");
						result.getMessages().put("runtimeproperty",  "evaluated "+count+" runtimeproperty elements");
					} catch (Exception e) {
						result.setErrorItem("runtimeproperty");
						result.getMessages().put("runtimeproperty", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("molgenisrole")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("molgenisrole")){
							count = new MolgenisRoleExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("molgenisrole")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("molgenisrole");
						result.getMessages().put("molgenisrole",  "evaluated "+count+" molgenisrole elements");
					} catch (Exception e) {
						result.setErrorItem("molgenisrole");
						result.getMessages().put("molgenisrole", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("molgenisgroup")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("molgenisgroup")){
							count = new MolgenisGroupExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("molgenisgroup")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("molgenisgroup");
						result.getMessages().put("molgenisgroup",  "evaluated "+count+" molgenisgroup elements");
					} catch (Exception e) {
						result.setErrorItem("molgenisgroup");
						result.getMessages().put("molgenisgroup", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("molgenisuser")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("molgenisuser")){
							count = new MolgenisUserExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("molgenisuser")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("molgenisuser");
						result.getMessages().put("molgenisuser",  "evaluated "+count+" molgenisuser elements");
					} catch (Exception e) {
						result.setErrorItem("molgenisuser");
						result.getMessages().put("molgenisuser", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("molgenisrolegrouplink")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("molgenisrolegrouplink")){
							count = new MolgenisRoleGroupLinkExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("molgenisrolegrouplink")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("molgenisrolegrouplink");
						result.getMessages().put("molgenisrolegrouplink",  "evaluated "+count+" molgenisrolegrouplink elements");
					} catch (Exception e) {
						result.setErrorItem("molgenisrolegrouplink");
						result.getMessages().put("molgenisrolegrouplink", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("molgenispermission")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("molgenispermission")){
							count = new MolgenisPermissionExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("molgenispermission")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("molgenispermission");
						result.getMessages().put("molgenispermission",  "evaluated "+count+" molgenispermission elements");
					} catch (Exception e) {
						result.setErrorItem("molgenispermission");
						result.getMessages().put("molgenispermission", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("characteristic")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("characteristic")){
							count = new CharacteristicExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("characteristic")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("characteristic");
						result.getMessages().put("characteristic",  "evaluated "+count+" characteristic elements");
					} catch (Exception e) {
						result.setErrorItem("characteristic");
						result.getMessages().put("characteristic", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("observationtarget")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("observationtarget")){
							count = new ObservationTargetExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("observationtarget")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("observationtarget");
						result.getMessages().put("observationtarget",  "evaluated "+count+" observationtarget elements");
					} catch (Exception e) {
						result.setErrorItem("observationtarget");
						result.getMessages().put("observationtarget", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("individual")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("individual")){
							count = new IndividualExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("individual")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("individual");
						result.getMessages().put("individual",  "evaluated "+count+" individual elements");
					} catch (Exception e) {
						result.setErrorItem("individual");
						result.getMessages().put("individual", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("ontology")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("ontology")){
							count = new OntologyExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("ontology")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("ontology");
						result.getMessages().put("ontology",  "evaluated "+count+" ontology elements");
					} catch (Exception e) {
						result.setErrorItem("ontology");
						result.getMessages().put("ontology", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("species")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("species")){
							count = new SpeciesExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("species")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("species");
						result.getMessages().put("species",  "evaluated "+count+" species elements");
					} catch (Exception e) {
						result.setErrorItem("species");
						result.getMessages().put("species", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("ontologyterm")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("ontologyterm")){
							count = new OntologyTermExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("ontologyterm")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("ontologyterm");
						result.getMessages().put("ontologyterm",  "evaluated "+count+" ontologyterm elements");
					} catch (Exception e) {
						result.setErrorItem("ontologyterm");
						result.getMessages().put("ontologyterm", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("accession")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("accession")){
							count = new AccessionExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("accession")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("accession");
						result.getMessages().put("accession",  "evaluated "+count+" accession elements");
					} catch (Exception e) {
						result.setErrorItem("accession");
						result.getMessages().put("accession", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("observablefeature")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("observablefeature")){
							count = new ObservableFeatureExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("observablefeature")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("observablefeature");
						result.getMessages().put("observablefeature",  "evaluated "+count+" observablefeature elements");
					} catch (Exception e) {
						result.setErrorItem("observablefeature");
						result.getMessages().put("observablefeature", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("protocol")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("protocol")){
							count = new ProtocolExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("protocol")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("protocol");
						result.getMessages().put("protocol",  "evaluated "+count+" protocol elements");
					} catch (Exception e) {
						result.setErrorItem("protocol");
						result.getMessages().put("protocol", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("dataset")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("dataset")){
							count = new DataSetExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("dataset")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("dataset");
						result.getMessages().put("dataset",  "evaluated "+count+" dataset elements");
					} catch (Exception e) {
						result.setErrorItem("dataset");
						result.getMessages().put("dataset", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("panel")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("panel")){
							count = new PanelExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("panel")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("panel");
						result.getMessages().put("panel",  "evaluated "+count+" panel elements");
					} catch (Exception e) {
						result.setErrorItem("panel");
						result.getMessages().put("panel", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("genome")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("genome")){
							count = new GenomeExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("genome")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("genome");
						result.getMessages().put("genome",  "evaluated "+count+" genome elements");
					} catch (Exception e) {
						result.setErrorItem("genome");
						result.getMessages().put("genome", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("chromosome")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("chromosome")){
							count = new ChromosomeExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("chromosome")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("chromosome");
						result.getMessages().put("chromosome",  "evaluated "+count+" chromosome elements");
					} catch (Exception e) {
						result.setErrorItem("chromosome");
						result.getMessages().put("chromosome", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("gene")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("gene")){
							count = new GeneExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("gene")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("gene");
						result.getMessages().put("gene",  "evaluated "+count+" gene elements");
					} catch (Exception e) {
						result.setErrorItem("gene");
						result.getMessages().put("gene", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("protein")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("protein")){
							count = new ProteinExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("protein")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("protein");
						result.getMessages().put("protein",  "evaluated "+count+" protein elements");
					} catch (Exception e) {
						result.setErrorItem("protein");
						result.getMessages().put("protein", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("proteindomain")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("proteindomain")){
							count = new ProteinDomainExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("proteindomain")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("proteindomain");
						result.getMessages().put("proteindomain",  "evaluated "+count+" proteindomain elements");
					} catch (Exception e) {
						result.setErrorItem("proteindomain");
						result.getMessages().put("proteindomain", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("exon")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("exon")){
							count = new ExonExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("exon")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("exon");
						result.getMessages().put("exon",  "evaluated "+count+" exon elements");
					} catch (Exception e) {
						result.setErrorItem("exon");
						result.getMessages().put("exon", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("variant")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("variant")){
							count = new VariantExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("variant")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("variant");
						result.getMessages().put("variant",  "evaluated "+count+" variant elements");
					} catch (Exception e) {
						result.setErrorItem("variant");
						result.getMessages().put("variant", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("institute")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("institute")){
							count = new InstituteExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("institute")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("institute");
						result.getMessages().put("institute",  "evaluated "+count+" institute elements");
					} catch (Exception e) {
						result.setErrorItem("institute");
						result.getMessages().put("institute", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("person")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("person")){
							count = new PersonExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("person")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("person");
						result.getMessages().put("person",  "evaluated "+count+" person elements");
					} catch (Exception e) {
						result.setErrorItem("person");
						result.getMessages().put("person", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("citation")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("citation")){
							count = new CitationExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("citation")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("citation");
						result.getMessages().put("citation",  "evaluated "+count+" citation elements");
					} catch (Exception e) {
						result.setErrorItem("citation");
						result.getMessages().put("citation", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("investigation")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("investigation")){
							count = new InvestigationExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("investigation")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("investigation");
						result.getMessages().put("investigation",  "evaluated "+count+" investigation elements");
					} catch (Exception e) {
						result.setErrorItem("investigation");
						result.getMessages().put("investigation", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("study")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("study")){
							count = new StudyExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("study")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("study");
						result.getMessages().put("study",  "evaluated "+count+" study elements");
					} catch (Exception e) {
						result.setErrorItem("study");
						result.getMessages().put("study", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("experiment")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("experiment")){
							count = new ExperimentExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("experiment")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("experiment");
						result.getMessages().put("experiment",  "evaluated "+count+" experiment elements");
					} catch (Exception e) {
						result.setErrorItem("experiment");
						result.getMessages().put("experiment", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("submission")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("submission")){
							count = new SubmissionExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("submission")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("submission");
						result.getMessages().put("submission",  "evaluated "+count+" submission elements");
					} catch (Exception e) {
						result.setErrorItem("submission");
						result.getMessages().put("submission", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("contribution")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("contribution")){
							count = new ContributionExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("contribution")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("contribution");
						result.getMessages().put("contribution",  "evaluated "+count+" contribution elements");
					} catch (Exception e) {
						result.setErrorItem("contribution");
						result.getMessages().put("contribution", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("studydetails")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("studydetails")){
							count = new StudyDetailsExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("studydetails")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("studydetails");
						result.getMessages().put("studydetails",  "evaluated "+count+" studydetails elements");
					} catch (Exception e) {
						result.setErrorItem("studydetails");
						result.getMessages().put("studydetails", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("phenotypeproperty")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("phenotypeproperty")){
							count = new PhenotypePropertyExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("phenotypeproperty")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("phenotypeproperty");
						result.getMessages().put("phenotypeproperty",  "evaluated "+count+" phenotypeproperty elements");
					} catch (Exception e) {
						result.setErrorItem("phenotypeproperty");
						result.getMessages().put("phenotypeproperty", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("phenotypemethod")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("phenotypemethod")){
							count = new PhenotypeMethodExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("phenotypemethod")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("phenotypemethod");
						result.getMessages().put("phenotypemethod",  "evaluated "+count+" phenotypemethod elements");
					} catch (Exception e) {
						result.setErrorItem("phenotypemethod");
						result.getMessages().put("phenotypemethod", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("samplepanel")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("samplepanel")){
							count = new SamplePanelExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("samplepanel")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("samplepanel");
						result.getMessages().put("samplepanel",  "evaluated "+count+" samplepanel elements");
					} catch (Exception e) {
						result.setErrorItem("samplepanel");
						result.getMessages().put("samplepanel", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("assayedpanel")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("assayedpanel")){
							count = new AssayedPanelExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("assayedpanel")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("assayedpanel");
						result.getMessages().put("assayedpanel",  "evaluated "+count+" assayedpanel elements");
					} catch (Exception e) {
						result.setErrorItem("assayedpanel");
						result.getMessages().put("assayedpanel", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("panelsource")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("panelsource")){
							count = new PanelSourceExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("panelsource")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("panelsource");
						result.getMessages().put("panelsource",  "evaluated "+count+" panelsource elements");
					} catch (Exception e) {
						result.setErrorItem("panelsource");
						result.getMessages().put("panelsource", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("gwasexperiment")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("gwasexperiment")){
							count = new GWASExperimentExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("gwasexperiment")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("gwasexperiment");
						result.getMessages().put("gwasexperiment",  "evaluated "+count+" gwasexperiment elements");
					} catch (Exception e) {
						result.setErrorItem("gwasexperiment");
						result.getMessages().put("gwasexperiment", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("usedmarkerset")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("usedmarkerset")){
							count = new UsedMarkerSetExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("usedmarkerset")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("usedmarkerset");
						result.getMessages().put("usedmarkerset",  "evaluated "+count+" usedmarkerset elements");
					} catch (Exception e) {
						result.setErrorItem("usedmarkerset");
						result.getMessages().put("usedmarkerset", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("category")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("category")){
							count = new CategoryExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("category")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("category");
						result.getMessages().put("category",  "evaluated "+count+" category elements");
					} catch (Exception e) {
						result.setErrorItem("category");
						result.getMessages().put("category", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("significance")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("significance")){
							count = new SignificanceExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("significance")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("significance");
						result.getMessages().put("significance",  "evaluated "+count+" significance elements");
					} catch (Exception e) {
						result.setErrorItem("significance");
						result.getMessages().put("significance", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("effectsize")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("effectsize")){
							count = new EffectSizeExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("effectsize")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("effectsize");
						result.getMessages().put("effectsize",  "evaluated "+count+" effectsize elements");
					} catch (Exception e) {
						result.setErrorItem("effectsize");
						result.getMessages().put("effectsize", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("selectioncriteria")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("selectioncriteria")){
							count = new SelectionCriteriaExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("selectioncriteria")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("selectioncriteria");
						result.getMessages().put("selectioncriteria",  "evaluated "+count+" selectioncriteria elements");
					} catch (Exception e) {
						result.setErrorItem("selectioncriteria");
						result.getMessages().put("selectioncriteria", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("protocol_subprotocols")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("protocol_subprotocols")){
							count = new Protocol_SubprotocolsExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("protocol_subprotocols")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("protocol_subprotocols");
						result.getMessages().put("protocol_subprotocols",  "evaluated "+count+" protocol_subprotocols elements");
					} catch (Exception e) {
						result.setErrorItem("protocol_subprotocols");
						result.getMessages().put("protocol_subprotocols", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("protocol_features")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("protocol_features")){
							count = new Protocol_FeaturesExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("protocol_features")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("protocol_features");
						result.getMessages().put("protocol_features",  "evaluated "+count+" protocol_features elements");
					} catch (Exception e) {
						result.setErrorItem("protocol_features");
						result.getMessages().put("protocol_features", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("panel_individuals")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("panel_individuals")){
							count = new Panel_IndividualsExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("panel_individuals")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("panel_individuals");
						result.getMessages().put("panel_individuals",  "evaluated "+count+" panel_individuals elements");
					} catch (Exception e) {
						result.setErrorItem("panel_individuals");
						result.getMessages().put("panel_individuals", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("experiment_assayedpanels")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("experiment_assayedpanels")){
							count = new Experiment_AssayedPanelsExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("experiment_assayedpanels")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("experiment_assayedpanels");
						result.getMessages().put("experiment_assayedpanels",  "evaluated "+count+" experiment_assayedpanels elements");
					} catch (Exception e) {
						result.setErrorItem("experiment_assayedpanels");
						result.getMessages().put("experiment_assayedpanels", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("person_affiliateinstitutions")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("person_affiliateinstitutions")){
							count = new Person_AffiliateInstitutionsExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("person_affiliateinstitutions")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("person_affiliateinstitutions");
						result.getMessages().put("person_affiliateinstitutions",  "evaluated "+count+" person_affiliateinstitutions elements");
					} catch (Exception e) {
						result.setErrorItem("person_affiliateinstitutions");
						result.getMessages().put("person_affiliateinstitutions", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("citation_ontologyterms")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("citation_ontologyterms")){
							count = new Citation_OntologyTermsExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("citation_ontologyterms")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("citation_ontologyterms");
						result.getMessages().put("citation_ontologyterms",  "evaluated "+count+" citation_ontologyterms elements");
					} catch (Exception e) {
						result.setErrorItem("citation_ontologyterms");
						result.getMessages().put("citation_ontologyterms", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("studydetails_othercitations")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("studydetails_othercitations")){
							count = new StudyDetails_OtherCitationsExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("studydetails_othercitations")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("studydetails_othercitations");
						result.getMessages().put("studydetails_othercitations",  "evaluated "+count+" studydetails_othercitations elements");
					} catch (Exception e) {
						result.setErrorItem("studydetails_othercitations");
						result.getMessages().put("studydetails_othercitations", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("observationset")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("observationset")){
							count = new ObservationSetExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("observationset")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("observationset");
						result.getMessages().put("observationset",  "evaluated "+count+" observationset elements");
					} catch (Exception e) {
						result.setErrorItem("observationset");
						result.getMessages().put("observationset", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("observedvalue")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("observedvalue")){
							count = new ObservedValueExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("observedvalue")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("observedvalue");
						result.getMessages().put("observedvalue",  "evaluated "+count+" observedvalue elements");
					} catch (Exception e) {
						result.setErrorItem("observedvalue");
						result.getMessages().put("observedvalue", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("frequencycluster")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("frequencycluster")){
							count = new FrequencyClusterExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("frequencycluster")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("frequencycluster");
						result.getMessages().put("frequencycluster",  "evaluated "+count+" frequencycluster elements");
					} catch (Exception e) {
						result.setErrorItem("frequencycluster");
						result.getMessages().put("frequencycluster", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("genotypefrequency")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("genotypefrequency")){
							count = new GenotypeFrequencyExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("genotypefrequency")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("genotypefrequency");
						result.getMessages().put("genotypefrequency",  "evaluated "+count+" genotypefrequency elements");
					} catch (Exception e) {
						result.setErrorItem("genotypefrequency");
						result.getMessages().put("genotypefrequency", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("allelefrequency")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("allelefrequency")){
							count = new AlleleFrequencyExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("allelefrequency")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("allelefrequency");
						result.getMessages().put("allelefrequency",  "evaluated "+count+" allelefrequency elements");
					} catch (Exception e) {
						result.setErrorItem("allelefrequency");
						result.getMessages().put("allelefrequency", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("phenotypevalue")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("phenotypevalue")){
							count = new PhenotypeValueExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("phenotypevalue")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("phenotypevalue");
						result.getMessages().put("phenotypevalue",  "evaluated "+count+" phenotypevalue elements");
					} catch (Exception e) {
						result.setErrorItem("phenotypevalue");
						result.getMessages().put("phenotypevalue", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("experiment_datasets")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("experiment_datasets")){
							count = new Experiment_DataSetsExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("experiment_datasets")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("experiment_datasets");
						result.getMessages().put("experiment_datasets",  "evaluated "+count+" experiment_datasets elements");
					} catch (Exception e) {
						result.setErrorItem("experiment_datasets");
						result.getMessages().put("experiment_datasets", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
			}			
			
			if (useDbTransaction)
			{
				logger.debug("commiting transactions...");
				if (db.inTx()){
					db.commitTx();
				}else{
					throw new DatabaseException("Cannot commit ExcelImport: database not in transaction.");
				}
			}
		}
		catch (Exception e)
		{
			logger.error("Import failed: " + e.getMessage());
			if (useDbTransaction)
			{
				if (db.inTx()){
					logger.debug("Db in transaction, rolling back...");
					db.rollbackTx();
				}else{
					logger.debug("Db not in transaction");
				}
			}
			throw e;
		}finally{
			//restore the locale settings (important!)
			Locale.setDefault(saveTheDefault);
			workbook.close();
		}
		return result;
	}
}