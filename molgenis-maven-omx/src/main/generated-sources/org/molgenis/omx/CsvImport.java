
/* Date:        January 2, 2013
 * 
 * generator:   org.molgenis.generators.csv.CsvImportGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.omx;

import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;
//import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.molgenis.framework.db.Database;
import org.molgenis.framework.db.Database.DatabaseAction;
import org.molgenis.framework.db.DatabaseException;
//import org.molgenis.framework.db.QueryRule;
//import org.molgenis.framework.db.QueryRule.Operator;
import org.molgenis.util.Tuple;
//import org.molgenis.util.*;
//import org.molgenis.util.CsvFileReader;
//import org.molgenis.util.CsvReaderListener;
//import org.molgenis.util.SimpleTuple;

import org.molgenis.framework.db.CsvToDatabase.ImportResult;

import org.molgenis.core.csv.MolgenisEntityCsvReader;
import org.molgenis.core.csv.MolgenisFileCsvReader;
import org.molgenis.core.csv.RuntimePropertyCsvReader;
import org.molgenis.auth.csv.MolgenisRoleCsvReader;
import org.molgenis.auth.csv.MolgenisGroupCsvReader;
import org.molgenis.auth.csv.MolgenisUserCsvReader;
import org.molgenis.auth.csv.MolgenisRoleGroupLinkCsvReader;
import org.molgenis.auth.csv.MolgenisPermissionCsvReader;
import org.molgenis.observ.csv.CharacteristicCsvReader;
import org.molgenis.observ.csv.ObservationTargetCsvReader;
import org.molgenis.observ.csv.ObservableFeatureCsvReader;
import org.molgenis.observ.csv.CategoryCsvReader;
import org.molgenis.observ.csv.ProtocolCsvReader;
import org.molgenis.observ.csv.DataSetCsvReader;
import org.molgenis.observ.csv.ObservationSetCsvReader;
import org.molgenis.observ.csv.ObservedValueCsvReader;
import org.molgenis.observ.target.csv.SpeciesCsvReader;
import org.molgenis.observ.target.csv.IndividualCsvReader;
import org.molgenis.observ.target.csv.PanelCsvReader;
import org.molgenis.observ.target.csv.PanelSourceCsvReader;
import org.molgenis.observ.target.csv.OntologyCsvReader;
import org.molgenis.observ.target.csv.OntologyTermCsvReader;
import org.molgenis.observ.target.csv.AccessionCsvReader;
import org.molgenis.variant.csv.GenomeCsvReader;
import org.molgenis.variant.csv.ChromosomeCsvReader;
import org.molgenis.variant.csv.GeneCsvReader;
import org.molgenis.variant.csv.ProteinCsvReader;
import org.molgenis.variant.csv.ProteinDomainCsvReader;
import org.molgenis.variant.csv.ExonCsvReader;
import org.molgenis.variant.csv.VariantCsvReader;
import org.molgenis.organization.csv.StudyCsvReader;
import org.molgenis.organization.csv.ExperimentCsvReader;
import org.molgenis.organization.csv.InstituteCsvReader;
import org.molgenis.organization.csv.PersonCsvReader;
import org.molgenis.organization.csv.CitationCsvReader;
import org.molgenis.organization.csv.ContributionCsvReader;
import org.molgenis.organization.csv.SubmissionCsvReader;
import org.molgenis.gwascentral.csv.InvestigationCsvReader;
import org.molgenis.gwascentral.csv.StudyDetailsCsvReader;
import org.molgenis.gwascentral.csv.FrequencyClusterCsvReader;
import org.molgenis.gwascentral.csv.GenotypeFrequencyCsvReader;
import org.molgenis.gwascentral.csv.AlleleFrequencyCsvReader;
import org.molgenis.gwascentral.csv.PhenotypePropertyCsvReader;
import org.molgenis.gwascentral.csv.PhenotypeMethodCsvReader;
import org.molgenis.gwascentral.csv.PhenotypeValueCsvReader;
import org.molgenis.gwascentral.csv.SamplePanelCsvReader;
import org.molgenis.gwascentral.csv.AssayedPanelCsvReader;
import org.molgenis.gwascentral.csv.GWASExperimentCsvReader;
import org.molgenis.gwascentral.csv.UsedMarkerSetCsvReader;
import org.molgenis.gwascentral.csv.SignificanceCsvReader;
import org.molgenis.gwascentral.csv.EffectSizeCsvReader;
import org.molgenis.gwascentral.csv.SelectionCriteriaCsvReader;
import org.molgenis.observ.csv.Protocol_SubprotocolsCsvReader;
import org.molgenis.observ.csv.Protocol_FeaturesCsvReader;
import org.molgenis.observ.target.csv.Panel_IndividualsCsvReader;
import org.molgenis.organization.csv.Experiment_AssayedPanelsCsvReader;
import org.molgenis.organization.csv.Experiment_DataSetsCsvReader;
import org.molgenis.organization.csv.Person_AffiliateInstitutionsCsvReader;
import org.molgenis.organization.csv.Citation_OntologyTermsCsvReader;
import org.molgenis.gwascentral.csv.StudyDetails_OtherCitationsCsvReader;

public class CsvImport
{
	static int BATCH_SIZE = 10000;
	static int SMALL_BATCH_SIZE = 2500;
	static Logger logger = Logger.getLogger(CsvImport.class.getSimpleName());
	
	/**wrapper to use int inside anonymous classes (requires final, so cannot update directly)*/
	//FIXME move to value type elsewhere?
	public static class IntegerWrapper
	{
		private int value;
		
		public IntegerWrapper(int value)
		{
			this.value = value;
		}
		public void set(int value)
		{
			this.value = value;
		}
		public int get()
		{
			return this.value;
		}
	}
	
	public static ImportResult importAll(File directory, Database db, Tuple defaults) throws Exception
	{
		return importAll(directory, db, defaults, true);
	}
	
	public static ImportResult importAll(File directory, Database db, Tuple defaults, List<String> components, DatabaseAction dbAction, String missingValue) throws Exception
	{
		return importAll(directory, db, defaults, components, dbAction, missingValue, true);
	}
	
	public static ImportResult importAll(File directory, Database db, Tuple defaults, boolean useDbTransaction) throws Exception
	{
		//set default missing value to ""
		return importAll(directory, db, defaults, null, DatabaseAction.ADD, "", useDbTransaction);
	}

	/**
	 * Csv import of whole database.
	 * TODO: add filter parameters...
	 */
	public static ImportResult importAll(File directory, Database db, Tuple defaults, List<String> components, DatabaseAction dbAction, String missingValue, boolean useDbTransaction) throws Exception
	{
		ImportResult result = new ImportResult();
		boolean alreadyInTx = false;
		try
		{
			if (useDbTransaction)
			{
				if (!db.inTx())
				{
					db.beginTx();
				}else{
					alreadyInTx = true; 
					//throw new DatabaseException("Cannot continue CsvImport: database already in transaction.");
				}
			}
						
			if(dbAction.toString().startsWith("REMOVE"))
			{
				//reverse xref dependency order for remove
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("experiment_datasets")))
				{
					try {
						int count = new Experiment_DataSetsCsvReader().importCsv(db, new File(directory+"/experiment_datasets.txt"), defaults, dbAction, missingValue);
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
						int count = new PhenotypeValueCsvReader().importCsv(db, new File(directory+"/phenotypevalue.txt"), defaults, dbAction, missingValue);
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
						int count = new AlleleFrequencyCsvReader().importCsv(db, new File(directory+"/allelefrequency.txt"), defaults, dbAction, missingValue);
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
						int count = new GenotypeFrequencyCsvReader().importCsv(db, new File(directory+"/genotypefrequency.txt"), defaults, dbAction, missingValue);
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
						int count = new FrequencyClusterCsvReader().importCsv(db, new File(directory+"/frequencycluster.txt"), defaults, dbAction, missingValue);
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
						int count = new ObservedValueCsvReader().importCsv(db, new File(directory+"/observedvalue.txt"), defaults, dbAction, missingValue);
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
						int count = new ObservationSetCsvReader().importCsv(db, new File(directory+"/observationset.txt"), defaults, dbAction, missingValue);
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
						int count = new StudyDetails_OtherCitationsCsvReader().importCsv(db, new File(directory+"/studydetails_othercitations.txt"), defaults, dbAction, missingValue);
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
						int count = new Citation_OntologyTermsCsvReader().importCsv(db, new File(directory+"/citation_ontologyterms.txt"), defaults, dbAction, missingValue);
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
						int count = new Person_AffiliateInstitutionsCsvReader().importCsv(db, new File(directory+"/person_affiliateinstitutions.txt"), defaults, dbAction, missingValue);
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
						int count = new Experiment_AssayedPanelsCsvReader().importCsv(db, new File(directory+"/experiment_assayedpanels.txt"), defaults, dbAction, missingValue);
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
						int count = new Panel_IndividualsCsvReader().importCsv(db, new File(directory+"/panel_individuals.txt"), defaults, dbAction, missingValue);
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
						int count = new Protocol_FeaturesCsvReader().importCsv(db, new File(directory+"/protocol_features.txt"), defaults, dbAction, missingValue);
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
						int count = new Protocol_SubprotocolsCsvReader().importCsv(db, new File(directory+"/protocol_subprotocols.txt"), defaults, dbAction, missingValue);
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
						int count = new SelectionCriteriaCsvReader().importCsv(db, new File(directory+"/selectioncriteria.txt"), defaults, dbAction, missingValue);
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
						int count = new EffectSizeCsvReader().importCsv(db, new File(directory+"/effectsize.txt"), defaults, dbAction, missingValue);
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
						int count = new SignificanceCsvReader().importCsv(db, new File(directory+"/significance.txt"), defaults, dbAction, missingValue);
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
						int count = new CategoryCsvReader().importCsv(db, new File(directory+"/category.txt"), defaults, dbAction, missingValue);
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
						int count = new UsedMarkerSetCsvReader().importCsv(db, new File(directory+"/usedmarkerset.txt"), defaults, dbAction, missingValue);
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
						int count = new GWASExperimentCsvReader().importCsv(db, new File(directory+"/gwasexperiment.txt"), defaults, dbAction, missingValue);
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
						int count = new PanelSourceCsvReader().importCsv(db, new File(directory+"/panelsource.txt"), defaults, dbAction, missingValue);
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
						int count = new AssayedPanelCsvReader().importCsv(db, new File(directory+"/assayedpanel.txt"), defaults, dbAction, missingValue);
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
						int count = new SamplePanelCsvReader().importCsv(db, new File(directory+"/samplepanel.txt"), defaults, dbAction, missingValue);
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
						int count = new PhenotypeMethodCsvReader().importCsv(db, new File(directory+"/phenotypemethod.txt"), defaults, dbAction, missingValue);
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
						int count = new PhenotypePropertyCsvReader().importCsv(db, new File(directory+"/phenotypeproperty.txt"), defaults, dbAction, missingValue);
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
						int count = new StudyDetailsCsvReader().importCsv(db, new File(directory+"/studydetails.txt"), defaults, dbAction, missingValue);
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
						int count = new ContributionCsvReader().importCsv(db, new File(directory+"/contribution.txt"), defaults, dbAction, missingValue);
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
						int count = new SubmissionCsvReader().importCsv(db, new File(directory+"/submission.txt"), defaults, dbAction, missingValue);
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
						int count = new ExperimentCsvReader().importCsv(db, new File(directory+"/experiment.txt"), defaults, dbAction, missingValue);
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
						int count = new StudyCsvReader().importCsv(db, new File(directory+"/study.txt"), defaults, dbAction, missingValue);
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
						int count = new InvestigationCsvReader().importCsv(db, new File(directory+"/investigation.txt"), defaults, dbAction, missingValue);
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
						int count = new CitationCsvReader().importCsv(db, new File(directory+"/citation.txt"), defaults, dbAction, missingValue);
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
						int count = new PersonCsvReader().importCsv(db, new File(directory+"/person.txt"), defaults, dbAction, missingValue);
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
						int count = new InstituteCsvReader().importCsv(db, new File(directory+"/institute.txt"), defaults, dbAction, missingValue);
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
						int count = new VariantCsvReader().importCsv(db, new File(directory+"/variant.txt"), defaults, dbAction, missingValue);
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
						int count = new ExonCsvReader().importCsv(db, new File(directory+"/exon.txt"), defaults, dbAction, missingValue);
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
						int count = new ProteinDomainCsvReader().importCsv(db, new File(directory+"/proteindomain.txt"), defaults, dbAction, missingValue);
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
						int count = new ProteinCsvReader().importCsv(db, new File(directory+"/protein.txt"), defaults, dbAction, missingValue);
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
						int count = new GeneCsvReader().importCsv(db, new File(directory+"/gene.txt"), defaults, dbAction, missingValue);
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
						int count = new ChromosomeCsvReader().importCsv(db, new File(directory+"/chromosome.txt"), defaults, dbAction, missingValue);
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
						int count = new GenomeCsvReader().importCsv(db, new File(directory+"/genome.txt"), defaults, dbAction, missingValue);
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
						int count = new PanelCsvReader().importCsv(db, new File(directory+"/panel.txt"), defaults, dbAction, missingValue);
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
						int count = new DataSetCsvReader().importCsv(db, new File(directory+"/dataset.txt"), defaults, dbAction, missingValue);
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
						int count = new ProtocolCsvReader().importCsv(db, new File(directory+"/protocol.txt"), defaults, dbAction, missingValue);
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
						int count = new ObservableFeatureCsvReader().importCsv(db, new File(directory+"/observablefeature.txt"), defaults, dbAction, missingValue);
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
						int count = new AccessionCsvReader().importCsv(db, new File(directory+"/accession.txt"), defaults, dbAction, missingValue);
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
						int count = new OntologyTermCsvReader().importCsv(db, new File(directory+"/ontologyterm.txt"), defaults, dbAction, missingValue);
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
						int count = new SpeciesCsvReader().importCsv(db, new File(directory+"/species.txt"), defaults, dbAction, missingValue);
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
						int count = new OntologyCsvReader().importCsv(db, new File(directory+"/ontology.txt"), defaults, dbAction, missingValue);
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
						int count = new IndividualCsvReader().importCsv(db, new File(directory+"/individual.txt"), defaults, dbAction, missingValue);
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
						int count = new ObservationTargetCsvReader().importCsv(db, new File(directory+"/observationtarget.txt"), defaults, dbAction, missingValue);
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
						int count = new CharacteristicCsvReader().importCsv(db, new File(directory+"/characteristic.txt"), defaults, dbAction, missingValue);
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
						int count = new MolgenisPermissionCsvReader().importCsv(db, new File(directory+"/molgenispermission.txt"), defaults, dbAction, missingValue);
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
						int count = new MolgenisRoleGroupLinkCsvReader().importCsv(db, new File(directory+"/molgenisrolegrouplink.txt"), defaults, dbAction, missingValue);
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
						int count = new MolgenisUserCsvReader().importCsv(db, new File(directory+"/molgenisuser.txt"), defaults, dbAction, missingValue);
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
						int count = new MolgenisGroupCsvReader().importCsv(db, new File(directory+"/molgenisgroup.txt"), defaults, dbAction, missingValue);
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
						int count = new MolgenisRoleCsvReader().importCsv(db, new File(directory+"/molgenisrole.txt"), defaults, dbAction, missingValue);
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
						int count = new RuntimePropertyCsvReader().importCsv(db, new File(directory+"/runtimeproperty.txt"), defaults, dbAction, missingValue);
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
						int count = new MolgenisFileCsvReader().importCsv(db, new File(directory+"/molgenisfile.txt"), defaults, dbAction, missingValue);
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
						int count = new MolgenisEntityCsvReader().importCsv(db, new File(directory+"/molgenisentity.txt"), defaults, dbAction, missingValue);
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
						int count = new MolgenisEntityCsvReader().importCsv(db, new File(directory+"/molgenisentity.txt"), defaults, dbAction, missingValue);
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
						int count = new MolgenisFileCsvReader().importCsv(db, new File(directory+"/molgenisfile.txt"), defaults, dbAction, missingValue);
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
						int count = new RuntimePropertyCsvReader().importCsv(db, new File(directory+"/runtimeproperty.txt"), defaults, dbAction, missingValue);
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
						int count = new MolgenisRoleCsvReader().importCsv(db, new File(directory+"/molgenisrole.txt"), defaults, dbAction, missingValue);
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
						int count = new MolgenisGroupCsvReader().importCsv(db, new File(directory+"/molgenisgroup.txt"), defaults, dbAction, missingValue);
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
						int count = new MolgenisUserCsvReader().importCsv(db, new File(directory+"/molgenisuser.txt"), defaults, dbAction, missingValue);
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
						int count = new MolgenisRoleGroupLinkCsvReader().importCsv(db, new File(directory+"/molgenisrolegrouplink.txt"), defaults, dbAction, missingValue);
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
						int count = new MolgenisPermissionCsvReader().importCsv(db, new File(directory+"/molgenispermission.txt"), defaults, dbAction, missingValue);
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
						int count = new CharacteristicCsvReader().importCsv(db, new File(directory+"/characteristic.txt"), defaults, dbAction, missingValue);
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
						int count = new ObservationTargetCsvReader().importCsv(db, new File(directory+"/observationtarget.txt"), defaults, dbAction, missingValue);
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
						int count = new IndividualCsvReader().importCsv(db, new File(directory+"/individual.txt"), defaults, dbAction, missingValue);
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
						int count = new OntologyCsvReader().importCsv(db, new File(directory+"/ontology.txt"), defaults, dbAction, missingValue);
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
						int count = new SpeciesCsvReader().importCsv(db, new File(directory+"/species.txt"), defaults, dbAction, missingValue);
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
						int count = new OntologyTermCsvReader().importCsv(db, new File(directory+"/ontologyterm.txt"), defaults, dbAction, missingValue);
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
						int count = new AccessionCsvReader().importCsv(db, new File(directory+"/accession.txt"), defaults, dbAction, missingValue);
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
						int count = new ObservableFeatureCsvReader().importCsv(db, new File(directory+"/observablefeature.txt"), defaults, dbAction, missingValue);
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
						int count = new ProtocolCsvReader().importCsv(db, new File(directory+"/protocol.txt"), defaults, dbAction, missingValue);
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
						int count = new DataSetCsvReader().importCsv(db, new File(directory+"/dataset.txt"), defaults, dbAction, missingValue);
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
						int count = new PanelCsvReader().importCsv(db, new File(directory+"/panel.txt"), defaults, dbAction, missingValue);
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
						int count = new GenomeCsvReader().importCsv(db, new File(directory+"/genome.txt"), defaults, dbAction, missingValue);
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
						int count = new ChromosomeCsvReader().importCsv(db, new File(directory+"/chromosome.txt"), defaults, dbAction, missingValue);
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
						int count = new GeneCsvReader().importCsv(db, new File(directory+"/gene.txt"), defaults, dbAction, missingValue);
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
						int count = new ProteinCsvReader().importCsv(db, new File(directory+"/protein.txt"), defaults, dbAction, missingValue);
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
						int count = new ProteinDomainCsvReader().importCsv(db, new File(directory+"/proteindomain.txt"), defaults, dbAction, missingValue);
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
						int count = new ExonCsvReader().importCsv(db, new File(directory+"/exon.txt"), defaults, dbAction, missingValue);
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
						int count = new VariantCsvReader().importCsv(db, new File(directory+"/variant.txt"), defaults, dbAction, missingValue);
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
						int count = new InstituteCsvReader().importCsv(db, new File(directory+"/institute.txt"), defaults, dbAction, missingValue);
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
						int count = new PersonCsvReader().importCsv(db, new File(directory+"/person.txt"), defaults, dbAction, missingValue);
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
						int count = new CitationCsvReader().importCsv(db, new File(directory+"/citation.txt"), defaults, dbAction, missingValue);
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
						int count = new InvestigationCsvReader().importCsv(db, new File(directory+"/investigation.txt"), defaults, dbAction, missingValue);
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
						int count = new StudyCsvReader().importCsv(db, new File(directory+"/study.txt"), defaults, dbAction, missingValue);
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
						int count = new ExperimentCsvReader().importCsv(db, new File(directory+"/experiment.txt"), defaults, dbAction, missingValue);
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
						int count = new SubmissionCsvReader().importCsv(db, new File(directory+"/submission.txt"), defaults, dbAction, missingValue);
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
						int count = new ContributionCsvReader().importCsv(db, new File(directory+"/contribution.txt"), defaults, dbAction, missingValue);
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
						int count = new StudyDetailsCsvReader().importCsv(db, new File(directory+"/studydetails.txt"), defaults, dbAction, missingValue);
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
						int count = new PhenotypePropertyCsvReader().importCsv(db, new File(directory+"/phenotypeproperty.txt"), defaults, dbAction, missingValue);
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
						int count = new PhenotypeMethodCsvReader().importCsv(db, new File(directory+"/phenotypemethod.txt"), defaults, dbAction, missingValue);
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
						int count = new SamplePanelCsvReader().importCsv(db, new File(directory+"/samplepanel.txt"), defaults, dbAction, missingValue);
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
						int count = new AssayedPanelCsvReader().importCsv(db, new File(directory+"/assayedpanel.txt"), defaults, dbAction, missingValue);
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
						int count = new PanelSourceCsvReader().importCsv(db, new File(directory+"/panelsource.txt"), defaults, dbAction, missingValue);
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
						int count = new GWASExperimentCsvReader().importCsv(db, new File(directory+"/gwasexperiment.txt"), defaults, dbAction, missingValue);
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
						int count = new UsedMarkerSetCsvReader().importCsv(db, new File(directory+"/usedmarkerset.txt"), defaults, dbAction, missingValue);
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
						int count = new CategoryCsvReader().importCsv(db, new File(directory+"/category.txt"), defaults, dbAction, missingValue);
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
						int count = new SignificanceCsvReader().importCsv(db, new File(directory+"/significance.txt"), defaults, dbAction, missingValue);
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
						int count = new EffectSizeCsvReader().importCsv(db, new File(directory+"/effectsize.txt"), defaults, dbAction, missingValue);
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
						int count = new SelectionCriteriaCsvReader().importCsv(db, new File(directory+"/selectioncriteria.txt"), defaults, dbAction, missingValue);
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
						int count = new Protocol_SubprotocolsCsvReader().importCsv(db, new File(directory+"/protocol_subprotocols.txt"), defaults, dbAction, missingValue);
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
						int count = new Protocol_FeaturesCsvReader().importCsv(db, new File(directory+"/protocol_features.txt"), defaults, dbAction, missingValue);
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
						int count = new Panel_IndividualsCsvReader().importCsv(db, new File(directory+"/panel_individuals.txt"), defaults, dbAction, missingValue);
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
						int count = new Experiment_AssayedPanelsCsvReader().importCsv(db, new File(directory+"/experiment_assayedpanels.txt"), defaults, dbAction, missingValue);
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
						int count = new Person_AffiliateInstitutionsCsvReader().importCsv(db, new File(directory+"/person_affiliateinstitutions.txt"), defaults, dbAction, missingValue);
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
						int count = new Citation_OntologyTermsCsvReader().importCsv(db, new File(directory+"/citation_ontologyterms.txt"), defaults, dbAction, missingValue);
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
						int count = new StudyDetails_OtherCitationsCsvReader().importCsv(db, new File(directory+"/studydetails_othercitations.txt"), defaults, dbAction, missingValue);
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
						int count = new ObservationSetCsvReader().importCsv(db, new File(directory+"/observationset.txt"), defaults, dbAction, missingValue);
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
						int count = new ObservedValueCsvReader().importCsv(db, new File(directory+"/observedvalue.txt"), defaults, dbAction, missingValue);
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
						int count = new FrequencyClusterCsvReader().importCsv(db, new File(directory+"/frequencycluster.txt"), defaults, dbAction, missingValue);
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
						int count = new GenotypeFrequencyCsvReader().importCsv(db, new File(directory+"/genotypefrequency.txt"), defaults, dbAction, missingValue);
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
						int count = new AlleleFrequencyCsvReader().importCsv(db, new File(directory+"/allelefrequency.txt"), defaults, dbAction, missingValue);
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
						int count = new PhenotypeValueCsvReader().importCsv(db, new File(directory+"/phenotypevalue.txt"), defaults, dbAction, missingValue);
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
						int count = new Experiment_DataSetsCsvReader().importCsv(db, new File(directory+"/experiment_datasets.txt"), defaults, dbAction, missingValue);
						result.getProgressLog().add("experiment_datasets");
						result.getMessages().put("experiment_datasets",  "evaluated "+count+" experiment_datasets elements");
					} catch (Exception e) {
						result.setErrorItem("experiment_datasets");
						result.getMessages().put("experiment_datasets", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
			}			
			
			if (useDbTransaction &! alreadyInTx)
			{
				logger.debug("commiting transactions...");
				if (db.inTx()){
					db.commitTx();
				}else{
					throw new DatabaseException("Cannot commit CsvImport: database not in transaction.");
				}
			}
		}
		catch (Exception e)
		{
			logger.error("Import failed: " + e.getMessage());
			if (useDbTransaction &! alreadyInTx)
			{
				if (db.inTx()){
					logger.debug("Db in transaction, rolling back...");
					db.rollbackTx();
				}else{
					logger.debug("Db not in transaction");
				}
			}
			e.printStackTrace();
			
			//Don't throw to avoid 'try-catch' on usage. No harm done.
			//throw e;
		}
		return result;
	}
}