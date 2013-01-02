
/* 
 * 
 * generator:   org.molgenis.generators.csv.CsvExportGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
package org.molgenis.omx;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.molgenis.framework.db.Database;
import org.molgenis.framework.db.DatabaseException;
import org.molgenis.framework.db.Query;
import org.molgenis.framework.db.QueryRule;
import org.molgenis.framework.db.QueryRule.Operator;
import org.molgenis.model.MolgenisModelException;
import org.molgenis.util.Entity;
import org.molgenis.util.CsvFileWriter;


	import org.molgenis.core.MolgenisEntity;
	import org.molgenis.core.MolgenisFile;
	import org.molgenis.core.RuntimeProperty;
	import org.molgenis.auth.MolgenisRole;
	import org.molgenis.auth.MolgenisGroup;
	import org.molgenis.auth.MolgenisUser;
	import org.molgenis.auth.MolgenisRoleGroupLink;
	import org.molgenis.auth.MolgenisPermission;
	import org.molgenis.observ.Characteristic;
	import org.molgenis.observ.ObservationTarget;
	import org.molgenis.observ.target.Individual;
	import org.molgenis.observ.target.Ontology;
	import org.molgenis.observ.target.Species;
	import org.molgenis.observ.target.OntologyTerm;
	import org.molgenis.observ.target.Accession;
	import org.molgenis.observ.ObservableFeature;
	import org.molgenis.observ.Protocol;
	import org.molgenis.observ.DataSet;
	import org.molgenis.observ.target.Panel;
	import org.molgenis.variant.Genome;
	import org.molgenis.variant.Chromosome;
	import org.molgenis.variant.Gene;
	import org.molgenis.variant.Protein;
	import org.molgenis.variant.ProteinDomain;
	import org.molgenis.variant.Exon;
	import org.molgenis.variant.Variant;
	import org.molgenis.organization.Institute;
	import org.molgenis.organization.Person;
	import org.molgenis.organization.Citation;
	import org.molgenis.gwascentral.Investigation;
	import org.molgenis.organization.Study;
	import org.molgenis.organization.Experiment;
	import org.molgenis.organization.Submission;
	import org.molgenis.organization.Contribution;
	import org.molgenis.gwascentral.StudyDetails;
	import org.molgenis.gwascentral.PhenotypeProperty;
	import org.molgenis.gwascentral.PhenotypeMethod;
	import org.molgenis.gwascentral.SamplePanel;
	import org.molgenis.gwascentral.AssayedPanel;
	import org.molgenis.observ.target.PanelSource;
	import org.molgenis.gwascentral.GWASExperiment;
	import org.molgenis.gwascentral.UsedMarkerSet;
	import org.molgenis.observ.Category;
	import org.molgenis.gwascentral.Significance;
	import org.molgenis.gwascentral.EffectSize;
	import org.molgenis.gwascentral.SelectionCriteria;
	import org.molgenis.observ.ObservationSet;
	import org.molgenis.observ.ObservedValue;
	import org.molgenis.gwascentral.FrequencyCluster;
	import org.molgenis.gwascentral.GenotypeFrequency;
	import org.molgenis.gwascentral.AlleleFrequency;
	import org.molgenis.gwascentral.PhenotypeValue;

public class CsvExport
{
	static Logger logger = Logger.getLogger(CsvExport.class.getSimpleName());
		
		/**
	 * Default export all using a target directory and a database to export
	 * @param directory
	 * @param db
	 * @throws Exception
	 */
	public void exportAll(File directory, Database db) throws Exception
	{
		exportAll(directory, db, true, new QueryRule[]{});
	}
	
	/**
	 * Export all using a set of QueryRules used for all entities if applicable to that entity
	 * @param directory
	 * @param db
	 * @param rules
	 * @throws Exception
	 */
	public void exportAll(File directory, Database db, QueryRule ... rules) throws Exception
	{
		exportAll(directory, db, true, rules);
	}
	
	/**
	 * Export all where a boolean skip autoid fields forces an ignore of the auto id field ("id")
	 * @param directory
	 * @param db
	 * @param skipAutoId
	 * @throws Exception
	 */
	public void exportAll(File directory, Database db, boolean skipAutoId) throws Exception
	{
		exportAll(directory, db, skipAutoId, new QueryRule[]{});
	}
	
	/**
	 * Export all with both a boolean skipAutoId and a set of QueryRules to specify both the skipping of auto id, and applying of a filter
	 * @param directory
	 * @param db
	 * @param skipAutoId
	 * @param rules
	 * @throws Exception
	 */
	public void exportAll(File directory, Database db, boolean skipAutoId, QueryRule ... rules) throws Exception
	{				
		exportMolgenisEntity(db, new File(directory+"/molgenisentity.txt"), skipAutoId ? Arrays.asList(new String[]{"name","type_","className"}) : null, rules);		
		exportMolgenisFile(db, new File(directory+"/molgenisfile.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","Extension"}) : null, rules);		
		exportRuntimeProperty(db, new File(directory+"/runtimeproperty.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","Value"}) : null, rules);		
		exportMolgenisRole(db, new File(directory+"/molgenisrole.txt"), skipAutoId ? Arrays.asList(new String[]{"__Type","name"}) : null, rules);		
		exportMolgenisGroup(db, new File(directory+"/molgenisgroup.txt"), skipAutoId ? Arrays.asList(new String[]{"__Type","name"}) : null, rules);		
		exportMolgenisUser(db, new File(directory+"/molgenisuser.txt"), skipAutoId ? Arrays.asList(new String[]{"username","password_","activationCode","active","superuser"}) : null, rules);		
		exportMolgenisRoleGroupLink(db, new File(directory+"/molgenisrolegrouplink.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","group__name","role__name"}) : null, rules);		
		exportMolgenisPermission(db, new File(directory+"/molgenispermission.txt"), skipAutoId ? Arrays.asList(new String[]{"role__name","entity_className","permission"}) : null, rules);		
		exportCharacteristic(db, new File(directory+"/characteristic.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description"}) : null, rules);		
		exportObservationTarget(db, new File(directory+"/observationtarget.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description"}) : null, rules);		
		exportIndividual(db, new File(directory+"/individual.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","Mother_Identifier","Father_Identifier"}) : null, rules);		
		exportOntology(db, new File(directory+"/ontology.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","ontologyAccession","ontologyURI"}) : null, rules);		
		exportSpecies(db, new File(directory+"/species.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","ontology_Identifier","termAccession","definition"}) : null, rules);		
		exportOntologyTerm(db, new File(directory+"/ontologyterm.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","ontology_Identifier","termAccession","definition"}) : null, rules);		
		exportAccession(db, new File(directory+"/accession.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","ontology_Identifier","termAccession","definition"}) : null, rules);		
		exportObservableFeature(db, new File(directory+"/observablefeature.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","unit_Identifier","dataType","temporal"}) : null, rules);		
		exportProtocol(db, new File(directory+"/protocol.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","ProtocolType_Identifier","subprotocols_Identifier","Features_Identifier"}) : null, rules);		
		exportDataSet(db, new File(directory+"/dataset.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","ProtocolUsed_Identifier","startTime","endTime"}) : null, rules);		
		exportPanel(db, new File(directory+"/panel.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","PanelType_Identifier","NumberOfIndividuals","Species_Identifier","Individuals_Identifier"}) : null, rules);		
		exportGenome(db, new File(directory+"/genome.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","residues","seqlen","species_Identifier"}) : null, rules);		
		exportChromosome(db, new File(directory+"/chromosome.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","residues","seqlen","genome_Identifier","orderNr","isAutosomal"}) : null, rules);		
		exportGene(db, new File(directory+"/gene.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","gdna_Identifier","gdna_start","gdna_end","residues","seqlen","strand"}) : null, rules);		
		exportProtein(db, new File(directory+"/protein.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","cdna_Identifier","cdna_start","cdna_end","residues","seqlen"}) : null, rules);		
		exportProteinDomain(db, new File(directory+"/proteindomain.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","cdna_Identifier","cdna_start","cdna_end","gdna_Identifier","gdna_start","gdna_end"}) : null, rules);		
		exportExon(db, new File(directory+"/exon.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","cdna_Identifier","cdna_start","cdna_end","gdna_Identifier","gdna_start","gdna_end","isIntron"}) : null, rules);		
		exportVariant(db, new File(directory+"/variant.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","gdna_Identifier","gdna_start","gdna_end","cdna_Identifier","cdna_start","cdna_end","aa_Identifier","aa_start","aa_end","gdna_notation","cdna_notation","aa_notation","variantType_Identifier"}) : null, rules);		
		exportInstitute(db, new File(directory+"/institute.txt"), skipAutoId ? Arrays.asList(new String[]{"name","Address","Phone","City","Country","Fax"}) : null, rules);		
		exportPerson(db, new File(directory+"/person.txt"), skipAutoId ? Arrays.asList(new String[]{"Name","Title","FirstName","MidInitials","LastName","Email","Phone","PrimaryAffilation_name","AffiliateInstitutions_name","OrcidPersonReference_Identifier"}) : null, rules);		
		exportCitation(db, new File(directory+"/citation.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","PubmedID","DOI","ontologyTerms_Identifier","authorList","Title","Description","Status_Identifier"}) : null, rules);		
		exportInvestigation(db, new File(directory+"/investigation.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","Title","ShortName","Version","Background"}) : null, rules);		
		exportStudy(db, new File(directory+"/study.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","Description","StartDate","UpdateDate","EndDate","Contact_Name","PartOfInvestigation_Identifier"}) : null, rules);		
		exportExperiment(db, new File(directory+"/experiment.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","Study_Identifier","Design","ExperimentType_Identifier","TotalMarkersTested","TotalMarkersImported","Objective","Outcome","Comments","IndividualDataStatement","TimeCreated","AssayedPanels_Identifier","DataSets_Identifier"}) : null, rules);		
		exportSubmission(db, new File(directory+"/submission.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","TimeCreated","Study_Identifier"}) : null, rules);		
		exportContribution(db, new File(directory+"/contribution.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","Researcher_Name","Submission_Identifier","IsSubmitter","IsAuthor","IsSource"}) : null, rules);		
		exportStudyDetails(db, new File(directory+"/studydetails.txt"), skipAutoId ? Arrays.asList(new String[]{"Study_Identifier","Title","ShortName","StudyAbstract","Version","Background","Objectives","KeyResults","Conclusions","StudyDesign","StudySizeReason","StudyPower","SourcesOfBias","Limitations","Acknowledgements","primaryCitation_Identifier","otherCitations_Identifier","Accession"}) : null, rules);		
		exportPhenotypeProperty(db, new File(directory+"/phenotypeproperty.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","unit_Identifier","dataType","temporal"}) : null, rules);		
		exportPhenotypeMethod(db, new File(directory+"/phenotypemethod.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","ProtocolUsed_Identifier","startTime","endTime","StudyID_Identifier","PhenotypePropertyID_Identifier","Sample"}) : null, rules);		
		exportSamplePanel(db, new File(directory+"/samplepanel.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","Description","PanelType_Identifier","NumberOfIndividuals","Species_Identifier","Individuals_Identifier","CentralIdentifier_Identifier","Label","Accession","AccessionVersion","Composition","TotalNumberOfIndividuals","NumberOfSexMale","NumberOfSexFemale","NumberOfSexUnknown","NumberOfProbands","NumberOfParents","ModeOfRecruitment","DiagnosisAgeRange","DiagnosisPeriod","SamplingAgeRange","SamplingPeriod","PopulationInfo","GeographicRegionInfo","EthnicityInfo","BirthPlaceInfo","AdmixtureInfo","EnvironmentInfo","SourceOfDNA","DNAsArePooled","DNAsAreWGA"}) : null, rules);		
		exportAssayedPanel(db, new File(directory+"/assayedpanel.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","Description","PanelType_Identifier","NumberOfIndividuals","Species_Identifier","Individuals_Identifier","TotalNumberOfIndividuals","NumberOfSexMale","NumberOfSexFemale","NumberOfSexUnknown","NumberOfProbands","NumberOfParents"}) : null, rules);		
		exportPanelSource(db, new File(directory+"/panelsource.txt"), skipAutoId ? Arrays.asList(new String[]{"CurrentPanel_Identifier","SourcePanel_Identifier","NumberOfIndividuals","SelectionCriteria"}) : null, rules);		
		exportGWASExperiment(db, new File(directory+"/gwasexperiment.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","Study_Identifier","Design","ExperimentType_Identifier","TotalMarkersTested","TotalMarkersImported","Objective","Outcome","Comments","IndividualDataStatement","TimeCreated","AssayedPanels_Identifier","DataSets_Identifier"}) : null, rules);		
		exportUsedMarkerSet(db, new File(directory+"/usedmarkerset.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","unit_Identifier","dataType","temporal","ExperimentID_Identifier","MarkerIdentifier"}) : null, rules);		
		exportCategory(db, new File(directory+"/category.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","observableFeature_Identifier","valueCode","isMissing"}) : null, rules);		
		exportSignificance(db, new File(directory+"/significance.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","ProtocolUsed_Identifier","startTime","endTime","UsedmarkersetID_Identifier","NegLogPValue","UnadjustedPValue","AdjustedPValue"}) : null, rules);		
		exportEffectSize(db, new File(directory+"/effectsize.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","ProtocolUsed_Identifier","startTime","endTime","UsedMarkerSetID_Identifier","Lower95Bound","Upper95Bound","StdError"}) : null, rules);		
		exportSelectionCriteria(db, new File(directory+"/selectioncriteria.txt"), skipAutoId ? Arrays.asList(new String[]{"SourcePanel_Identifier","TargetPanel_Identifier","NumberOfIndividuals","Details"}) : null, rules);		
		exportObservationSet(db, new File(directory+"/observationset.txt"), skipAutoId ? Arrays.asList(new String[]{"partOfDataSet_Identifier","Target_Identifier","Time"}) : null, rules);		
		exportObservedValue(db, new File(directory+"/observedvalue.txt"), skipAutoId ? Arrays.asList(new String[]{"__Type","ObservationSet_id","Feature_Identifier","Characteristic_Identifier","Value"}) : null, rules);		
		exportFrequencyCluster(db, new File(directory+"/frequencycluster.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","ProtocolUsed_Identifier","startTime","endTime","DataSet_Identifier","UsedMarkerSet_Identifier","MarkerID","NumberOfGenotypedSamples","PValueHWE","UnadjustedPValue","OddsRatioStatement","AttributableRiskStatement"}) : null, rules);		
		exportGenotypeFrequency(db, new File(directory+"/genotypefrequency.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","ProtocolUsed_Identifier","startTime","endTime","FrequencyCluster_Identifier","GenotypeCombo","FrequencyAsProportion","NumberSamplesWithGenotype"}) : null, rules);		
		exportAlleleFrequency(db, new File(directory+"/allelefrequency.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","ProtocolUsed_Identifier","startTime","endTime","FrequencyCluster_Identifier","AlleleCombo","FrequencyAsProportion"}) : null, rules);		
		exportPhenotypeValue(db, new File(directory+"/phenotypevalue.txt"), skipAutoId ? Arrays.asList(new String[]{"__Type","ObservationSet_id","Feature_Identifier","Characteristic_Identifier","Value","Identifier","Name","PhenotypePropertyID_Identifier","ValueRank","ValueIsMean","STD","Min","Max"}) : null, rules);		
			
		logger.debug("done");
	}
	
   /**
	* Export without system tables.
	*/
	public void exportRegular(File directory, Database db, boolean skipAutoId) throws Exception
	{
		exportRegular(directory, db, skipAutoId, new QueryRule[]{});
	}
	
   /**
	* Export without system tables.
	*/
	public void exportRegular(File directory, Database db, boolean skipAutoId, QueryRule ... rules) throws Exception
	{				
		exportMolgenisFile(db, new File(directory+"/molgenisfile.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","Extension"}) : null, rules);		
		exportRuntimeProperty(db, new File(directory+"/runtimeproperty.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","Value"}) : null, rules);		
		exportCharacteristic(db, new File(directory+"/characteristic.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description"}) : null, rules);		
		exportObservationTarget(db, new File(directory+"/observationtarget.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description"}) : null, rules);		
		exportIndividual(db, new File(directory+"/individual.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","Mother_Identifier","Father_Identifier"}) : null, rules);		
		exportOntology(db, new File(directory+"/ontology.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","ontologyAccession","ontologyURI"}) : null, rules);		
		exportSpecies(db, new File(directory+"/species.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","ontology_Identifier","termAccession","definition"}) : null, rules);		
		exportOntologyTerm(db, new File(directory+"/ontologyterm.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","ontology_Identifier","termAccession","definition"}) : null, rules);		
		exportAccession(db, new File(directory+"/accession.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","ontology_Identifier","termAccession","definition"}) : null, rules);		
		exportObservableFeature(db, new File(directory+"/observablefeature.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","unit_Identifier","dataType","temporal"}) : null, rules);		
		exportProtocol(db, new File(directory+"/protocol.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","ProtocolType_Identifier","subprotocols_Identifier","Features_Identifier"}) : null, rules);		
		exportDataSet(db, new File(directory+"/dataset.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","ProtocolUsed_Identifier","startTime","endTime"}) : null, rules);		
		exportPanel(db, new File(directory+"/panel.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","PanelType_Identifier","NumberOfIndividuals","Species_Identifier","Individuals_Identifier"}) : null, rules);		
		exportGenome(db, new File(directory+"/genome.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","residues","seqlen","species_Identifier"}) : null, rules);		
		exportChromosome(db, new File(directory+"/chromosome.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","residues","seqlen","genome_Identifier","orderNr","isAutosomal"}) : null, rules);		
		exportGene(db, new File(directory+"/gene.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","gdna_Identifier","gdna_start","gdna_end","residues","seqlen","strand"}) : null, rules);		
		exportProtein(db, new File(directory+"/protein.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","cdna_Identifier","cdna_start","cdna_end","residues","seqlen"}) : null, rules);		
		exportProteinDomain(db, new File(directory+"/proteindomain.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","cdna_Identifier","cdna_start","cdna_end","gdna_Identifier","gdna_start","gdna_end"}) : null, rules);		
		exportExon(db, new File(directory+"/exon.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","cdna_Identifier","cdna_start","cdna_end","gdna_Identifier","gdna_start","gdna_end","isIntron"}) : null, rules);		
		exportVariant(db, new File(directory+"/variant.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","gdna_Identifier","gdna_start","gdna_end","cdna_Identifier","cdna_start","cdna_end","aa_Identifier","aa_start","aa_end","gdna_notation","cdna_notation","aa_notation","variantType_Identifier"}) : null, rules);		
		exportInstitute(db, new File(directory+"/institute.txt"), skipAutoId ? Arrays.asList(new String[]{"name","Address","Phone","City","Country","Fax"}) : null, rules);		
		exportPerson(db, new File(directory+"/person.txt"), skipAutoId ? Arrays.asList(new String[]{"Name","Title","FirstName","MidInitials","LastName","Email","Phone","PrimaryAffilation_name","AffiliateInstitutions_name","OrcidPersonReference_Identifier"}) : null, rules);		
		exportCitation(db, new File(directory+"/citation.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","PubmedID","DOI","ontologyTerms_Identifier","authorList","Title","Description","Status_Identifier"}) : null, rules);		
		exportInvestigation(db, new File(directory+"/investigation.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","Title","ShortName","Version","Background"}) : null, rules);		
		exportStudy(db, new File(directory+"/study.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","Description","StartDate","UpdateDate","EndDate","Contact_Name","PartOfInvestigation_Identifier"}) : null, rules);		
		exportExperiment(db, new File(directory+"/experiment.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","Study_Identifier","Design","ExperimentType_Identifier","TotalMarkersTested","TotalMarkersImported","Objective","Outcome","Comments","IndividualDataStatement","TimeCreated","AssayedPanels_Identifier","DataSets_Identifier"}) : null, rules);		
		exportSubmission(db, new File(directory+"/submission.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","TimeCreated","Study_Identifier"}) : null, rules);		
		exportContribution(db, new File(directory+"/contribution.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","Researcher_Name","Submission_Identifier","IsSubmitter","IsAuthor","IsSource"}) : null, rules);		
		exportStudyDetails(db, new File(directory+"/studydetails.txt"), skipAutoId ? Arrays.asList(new String[]{"Study_Identifier","Title","ShortName","StudyAbstract","Version","Background","Objectives","KeyResults","Conclusions","StudyDesign","StudySizeReason","StudyPower","SourcesOfBias","Limitations","Acknowledgements","primaryCitation_Identifier","otherCitations_Identifier","Accession"}) : null, rules);		
		exportPhenotypeProperty(db, new File(directory+"/phenotypeproperty.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","unit_Identifier","dataType","temporal"}) : null, rules);		
		exportPhenotypeMethod(db, new File(directory+"/phenotypemethod.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","ProtocolUsed_Identifier","startTime","endTime","StudyID_Identifier","PhenotypePropertyID_Identifier","Sample"}) : null, rules);		
		exportSamplePanel(db, new File(directory+"/samplepanel.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","Description","PanelType_Identifier","NumberOfIndividuals","Species_Identifier","Individuals_Identifier","CentralIdentifier_Identifier","Label","Accession","AccessionVersion","Composition","TotalNumberOfIndividuals","NumberOfSexMale","NumberOfSexFemale","NumberOfSexUnknown","NumberOfProbands","NumberOfParents","ModeOfRecruitment","DiagnosisAgeRange","DiagnosisPeriod","SamplingAgeRange","SamplingPeriod","PopulationInfo","GeographicRegionInfo","EthnicityInfo","BirthPlaceInfo","AdmixtureInfo","EnvironmentInfo","SourceOfDNA","DNAsArePooled","DNAsAreWGA"}) : null, rules);		
		exportAssayedPanel(db, new File(directory+"/assayedpanel.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","Description","PanelType_Identifier","NumberOfIndividuals","Species_Identifier","Individuals_Identifier","TotalNumberOfIndividuals","NumberOfSexMale","NumberOfSexFemale","NumberOfSexUnknown","NumberOfProbands","NumberOfParents"}) : null, rules);		
		exportPanelSource(db, new File(directory+"/panelsource.txt"), skipAutoId ? Arrays.asList(new String[]{"CurrentPanel_Identifier","SourcePanel_Identifier","NumberOfIndividuals","SelectionCriteria"}) : null, rules);		
		exportGWASExperiment(db, new File(directory+"/gwasexperiment.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","Study_Identifier","Design","ExperimentType_Identifier","TotalMarkersTested","TotalMarkersImported","Objective","Outcome","Comments","IndividualDataStatement","TimeCreated","AssayedPanels_Identifier","DataSets_Identifier"}) : null, rules);		
		exportUsedMarkerSet(db, new File(directory+"/usedmarkerset.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","unit_Identifier","dataType","temporal","ExperimentID_Identifier","MarkerIdentifier"}) : null, rules);		
		exportCategory(db, new File(directory+"/category.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","observableFeature_Identifier","valueCode","isMissing"}) : null, rules);		
		exportSignificance(db, new File(directory+"/significance.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","ProtocolUsed_Identifier","startTime","endTime","UsedmarkersetID_Identifier","NegLogPValue","UnadjustedPValue","AdjustedPValue"}) : null, rules);		
		exportEffectSize(db, new File(directory+"/effectsize.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","ProtocolUsed_Identifier","startTime","endTime","UsedMarkerSetID_Identifier","Lower95Bound","Upper95Bound","StdError"}) : null, rules);		
		exportSelectionCriteria(db, new File(directory+"/selectioncriteria.txt"), skipAutoId ? Arrays.asList(new String[]{"SourcePanel_Identifier","TargetPanel_Identifier","NumberOfIndividuals","Details"}) : null, rules);		
		exportObservationSet(db, new File(directory+"/observationset.txt"), skipAutoId ? Arrays.asList(new String[]{"partOfDataSet_Identifier","Target_Identifier","Time"}) : null, rules);		
		exportObservedValue(db, new File(directory+"/observedvalue.txt"), skipAutoId ? Arrays.asList(new String[]{"__Type","ObservationSet_id","Feature_Identifier","Characteristic_Identifier","Value"}) : null, rules);		
		exportFrequencyCluster(db, new File(directory+"/frequencycluster.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","ProtocolUsed_Identifier","startTime","endTime","DataSet_Identifier","UsedMarkerSet_Identifier","MarkerID","NumberOfGenotypedSamples","PValueHWE","UnadjustedPValue","OddsRatioStatement","AttributableRiskStatement"}) : null, rules);		
		exportGenotypeFrequency(db, new File(directory+"/genotypefrequency.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","ProtocolUsed_Identifier","startTime","endTime","FrequencyCluster_Identifier","GenotypeCombo","FrequencyAsProportion","NumberSamplesWithGenotype"}) : null, rules);		
		exportAlleleFrequency(db, new File(directory+"/allelefrequency.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","ProtocolUsed_Identifier","startTime","endTime","FrequencyCluster_Identifier","AlleleCombo","FrequencyAsProportion"}) : null, rules);		
		exportPhenotypeValue(db, new File(directory+"/phenotypevalue.txt"), skipAutoId ? Arrays.asList(new String[]{"__Type","ObservationSet_id","Feature_Identifier","Characteristic_Identifier","Value","Identifier","Name","PhenotypePropertyID_Identifier","ValueRank","ValueIsMean","STD","Min","Max"}) : null, rules);		
			
		logger.debug("done");
	}
	
	public void exportAll(File directory, List ... entityLists) throws Exception
	{				
		for(List<? extends Entity> l: entityLists) if(l.size()>0)
		{
			if(l.get(0).getClass().equals(MolgenisEntity.class))
				exportMolgenisEntity(l, new File(directory+"/molgenisentity.txt"));		
			if(l.get(0).getClass().equals(MolgenisFile.class))
				exportMolgenisFile(l, new File(directory+"/molgenisfile.txt"));		
			if(l.get(0).getClass().equals(RuntimeProperty.class))
				exportRuntimeProperty(l, new File(directory+"/runtimeproperty.txt"));		
			if(l.get(0).getClass().equals(MolgenisRole.class))
				exportMolgenisRole(l, new File(directory+"/molgenisrole.txt"));		
			if(l.get(0).getClass().equals(MolgenisGroup.class))
				exportMolgenisGroup(l, new File(directory+"/molgenisgroup.txt"));		
			if(l.get(0).getClass().equals(MolgenisUser.class))
				exportMolgenisUser(l, new File(directory+"/molgenisuser.txt"));		
			if(l.get(0).getClass().equals(MolgenisRoleGroupLink.class))
				exportMolgenisRoleGroupLink(l, new File(directory+"/molgenisrolegrouplink.txt"));		
			if(l.get(0).getClass().equals(MolgenisPermission.class))
				exportMolgenisPermission(l, new File(directory+"/molgenispermission.txt"));		
			if(l.get(0).getClass().equals(Characteristic.class))
				exportCharacteristic(l, new File(directory+"/characteristic.txt"));		
			if(l.get(0).getClass().equals(ObservationTarget.class))
				exportObservationTarget(l, new File(directory+"/observationtarget.txt"));		
			if(l.get(0).getClass().equals(Individual.class))
				exportIndividual(l, new File(directory+"/individual.txt"));		
			if(l.get(0).getClass().equals(Ontology.class))
				exportOntology(l, new File(directory+"/ontology.txt"));		
			if(l.get(0).getClass().equals(Species.class))
				exportSpecies(l, new File(directory+"/species.txt"));		
			if(l.get(0).getClass().equals(OntologyTerm.class))
				exportOntologyTerm(l, new File(directory+"/ontologyterm.txt"));		
			if(l.get(0).getClass().equals(Accession.class))
				exportAccession(l, new File(directory+"/accession.txt"));		
			if(l.get(0).getClass().equals(ObservableFeature.class))
				exportObservableFeature(l, new File(directory+"/observablefeature.txt"));		
			if(l.get(0).getClass().equals(Protocol.class))
				exportProtocol(l, new File(directory+"/protocol.txt"));		
			if(l.get(0).getClass().equals(DataSet.class))
				exportDataSet(l, new File(directory+"/dataset.txt"));		
			if(l.get(0).getClass().equals(Panel.class))
				exportPanel(l, new File(directory+"/panel.txt"));		
			if(l.get(0).getClass().equals(Genome.class))
				exportGenome(l, new File(directory+"/genome.txt"));		
			if(l.get(0).getClass().equals(Chromosome.class))
				exportChromosome(l, new File(directory+"/chromosome.txt"));		
			if(l.get(0).getClass().equals(Gene.class))
				exportGene(l, new File(directory+"/gene.txt"));		
			if(l.get(0).getClass().equals(Protein.class))
				exportProtein(l, new File(directory+"/protein.txt"));		
			if(l.get(0).getClass().equals(ProteinDomain.class))
				exportProteinDomain(l, new File(directory+"/proteindomain.txt"));		
			if(l.get(0).getClass().equals(Exon.class))
				exportExon(l, new File(directory+"/exon.txt"));		
			if(l.get(0).getClass().equals(Variant.class))
				exportVariant(l, new File(directory+"/variant.txt"));		
			if(l.get(0).getClass().equals(Institute.class))
				exportInstitute(l, new File(directory+"/institute.txt"));		
			if(l.get(0).getClass().equals(Person.class))
				exportPerson(l, new File(directory+"/person.txt"));		
			if(l.get(0).getClass().equals(Citation.class))
				exportCitation(l, new File(directory+"/citation.txt"));		
			if(l.get(0).getClass().equals(Investigation.class))
				exportInvestigation(l, new File(directory+"/investigation.txt"));		
			if(l.get(0).getClass().equals(Study.class))
				exportStudy(l, new File(directory+"/study.txt"));		
			if(l.get(0).getClass().equals(Experiment.class))
				exportExperiment(l, new File(directory+"/experiment.txt"));		
			if(l.get(0).getClass().equals(Submission.class))
				exportSubmission(l, new File(directory+"/submission.txt"));		
			if(l.get(0).getClass().equals(Contribution.class))
				exportContribution(l, new File(directory+"/contribution.txt"));		
			if(l.get(0).getClass().equals(StudyDetails.class))
				exportStudyDetails(l, new File(directory+"/studydetails.txt"));		
			if(l.get(0).getClass().equals(PhenotypeProperty.class))
				exportPhenotypeProperty(l, new File(directory+"/phenotypeproperty.txt"));		
			if(l.get(0).getClass().equals(PhenotypeMethod.class))
				exportPhenotypeMethod(l, new File(directory+"/phenotypemethod.txt"));		
			if(l.get(0).getClass().equals(SamplePanel.class))
				exportSamplePanel(l, new File(directory+"/samplepanel.txt"));		
			if(l.get(0).getClass().equals(AssayedPanel.class))
				exportAssayedPanel(l, new File(directory+"/assayedpanel.txt"));		
			if(l.get(0).getClass().equals(PanelSource.class))
				exportPanelSource(l, new File(directory+"/panelsource.txt"));		
			if(l.get(0).getClass().equals(GWASExperiment.class))
				exportGWASExperiment(l, new File(directory+"/gwasexperiment.txt"));		
			if(l.get(0).getClass().equals(UsedMarkerSet.class))
				exportUsedMarkerSet(l, new File(directory+"/usedmarkerset.txt"));		
			if(l.get(0).getClass().equals(Category.class))
				exportCategory(l, new File(directory+"/category.txt"));		
			if(l.get(0).getClass().equals(Significance.class))
				exportSignificance(l, new File(directory+"/significance.txt"));		
			if(l.get(0).getClass().equals(EffectSize.class))
				exportEffectSize(l, new File(directory+"/effectsize.txt"));		
			if(l.get(0).getClass().equals(SelectionCriteria.class))
				exportSelectionCriteria(l, new File(directory+"/selectioncriteria.txt"));		
			if(l.get(0).getClass().equals(ObservationSet.class))
				exportObservationSet(l, new File(directory+"/observationset.txt"));		
			if(l.get(0).getClass().equals(ObservedValue.class))
				exportObservedValue(l, new File(directory+"/observedvalue.txt"));		
			if(l.get(0).getClass().equals(FrequencyCluster.class))
				exportFrequencyCluster(l, new File(directory+"/frequencycluster.txt"));		
			if(l.get(0).getClass().equals(GenotypeFrequency.class))
				exportGenotypeFrequency(l, new File(directory+"/genotypefrequency.txt"));		
			if(l.get(0).getClass().equals(AlleleFrequency.class))
				exportAlleleFrequency(l, new File(directory+"/allelefrequency.txt"));		
			if(l.get(0).getClass().equals(PhenotypeValue.class))
				exportPhenotypeValue(l, new File(directory+"/phenotypevalue.txt"));		
		}
			
		logger.debug("done");
	}
	
	/**
	* Export while excluding or including certain entity types. Defaults set: skip autoId, no QueryRules.
	* If exclusion is set to true, the specialCases are used to exlude those entities from the export (entities not in list are exported).
	* If exclusion is set to false, the specialCases are used to include those entities in the export (only entities in list are exported).
	*/
	public void exportSpecial(File directory, Database db, List<Class<? extends Entity>> specialCases, boolean exclusion) throws Exception
	{
		exportSpecial(directory, db, true, specialCases, exclusion, new QueryRule[]{});
	}
	
	/**
	* Export while excluding or including certain entity types.
	* If exclusion is set to true, the specialCases are used to exlude those entities from the export (entities not in list are exported).
	* If exclusion is set to false, the specialCases are used to include those entities in the export (only entities in list are exported).
	* TODO: Could maybe replace exportAll(File directory, List ... entityLists) ?
	*/
	public void exportSpecial(File directory, Database db, boolean skipAutoId, List<Class<? extends Entity>> specialCases, boolean exclusion, QueryRule ... rules) throws Exception
	{
		if((exclusion && !specialCases.contains(MolgenisEntity.class)) || (!exclusion && specialCases.contains(MolgenisEntity.class)))
			{ exportMolgenisEntity(db, new File(directory+"/molgenisentity.txt"), skipAutoId ? Arrays.asList(new String[]{"name","type_","className"}) : null, rules); }
		if((exclusion && !specialCases.contains(MolgenisFile.class)) || (!exclusion && specialCases.contains(MolgenisFile.class)))
			{ exportMolgenisFile(db, new File(directory+"/molgenisfile.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","Extension"}) : null, rules); }
		if((exclusion && !specialCases.contains(RuntimeProperty.class)) || (!exclusion && specialCases.contains(RuntimeProperty.class)))
			{ exportRuntimeProperty(db, new File(directory+"/runtimeproperty.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","Value"}) : null, rules); }
		if((exclusion && !specialCases.contains(MolgenisRole.class)) || (!exclusion && specialCases.contains(MolgenisRole.class)))
			{ exportMolgenisRole(db, new File(directory+"/molgenisrole.txt"), skipAutoId ? Arrays.asList(new String[]{"__Type","name"}) : null, rules); }
		if((exclusion && !specialCases.contains(MolgenisGroup.class)) || (!exclusion && specialCases.contains(MolgenisGroup.class)))
			{ exportMolgenisGroup(db, new File(directory+"/molgenisgroup.txt"), skipAutoId ? Arrays.asList(new String[]{"__Type","name"}) : null, rules); }
		if((exclusion && !specialCases.contains(MolgenisUser.class)) || (!exclusion && specialCases.contains(MolgenisUser.class)))
			{ exportMolgenisUser(db, new File(directory+"/molgenisuser.txt"), skipAutoId ? Arrays.asList(new String[]{"username","password_","activationCode","active","superuser"}) : null, rules); }
		if((exclusion && !specialCases.contains(MolgenisRoleGroupLink.class)) || (!exclusion && specialCases.contains(MolgenisRoleGroupLink.class)))
			{ exportMolgenisRoleGroupLink(db, new File(directory+"/molgenisrolegrouplink.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","group__name","role__name"}) : null, rules); }
		if((exclusion && !specialCases.contains(MolgenisPermission.class)) || (!exclusion && specialCases.contains(MolgenisPermission.class)))
			{ exportMolgenisPermission(db, new File(directory+"/molgenispermission.txt"), skipAutoId ? Arrays.asList(new String[]{"role__name","entity_className","permission"}) : null, rules); }
		if((exclusion && !specialCases.contains(Characteristic.class)) || (!exclusion && specialCases.contains(Characteristic.class)))
			{ exportCharacteristic(db, new File(directory+"/characteristic.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description"}) : null, rules); }
		if((exclusion && !specialCases.contains(ObservationTarget.class)) || (!exclusion && specialCases.contains(ObservationTarget.class)))
			{ exportObservationTarget(db, new File(directory+"/observationtarget.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description"}) : null, rules); }
		if((exclusion && !specialCases.contains(Individual.class)) || (!exclusion && specialCases.contains(Individual.class)))
			{ exportIndividual(db, new File(directory+"/individual.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","Mother_Identifier","Father_Identifier"}) : null, rules); }
		if((exclusion && !specialCases.contains(Ontology.class)) || (!exclusion && specialCases.contains(Ontology.class)))
			{ exportOntology(db, new File(directory+"/ontology.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","ontologyAccession","ontologyURI"}) : null, rules); }
		if((exclusion && !specialCases.contains(Species.class)) || (!exclusion && specialCases.contains(Species.class)))
			{ exportSpecies(db, new File(directory+"/species.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","ontology_Identifier","termAccession","definition"}) : null, rules); }
		if((exclusion && !specialCases.contains(OntologyTerm.class)) || (!exclusion && specialCases.contains(OntologyTerm.class)))
			{ exportOntologyTerm(db, new File(directory+"/ontologyterm.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","ontology_Identifier","termAccession","definition"}) : null, rules); }
		if((exclusion && !specialCases.contains(Accession.class)) || (!exclusion && specialCases.contains(Accession.class)))
			{ exportAccession(db, new File(directory+"/accession.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","ontology_Identifier","termAccession","definition"}) : null, rules); }
		if((exclusion && !specialCases.contains(ObservableFeature.class)) || (!exclusion && specialCases.contains(ObservableFeature.class)))
			{ exportObservableFeature(db, new File(directory+"/observablefeature.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","unit_Identifier","dataType","temporal"}) : null, rules); }
		if((exclusion && !specialCases.contains(Protocol.class)) || (!exclusion && specialCases.contains(Protocol.class)))
			{ exportProtocol(db, new File(directory+"/protocol.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","ProtocolType_Identifier","subprotocols_Identifier","Features_Identifier"}) : null, rules); }
		if((exclusion && !specialCases.contains(DataSet.class)) || (!exclusion && specialCases.contains(DataSet.class)))
			{ exportDataSet(db, new File(directory+"/dataset.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","ProtocolUsed_Identifier","startTime","endTime"}) : null, rules); }
		if((exclusion && !specialCases.contains(Panel.class)) || (!exclusion && specialCases.contains(Panel.class)))
			{ exportPanel(db, new File(directory+"/panel.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","PanelType_Identifier","NumberOfIndividuals","Species_Identifier","Individuals_Identifier"}) : null, rules); }
		if((exclusion && !specialCases.contains(Genome.class)) || (!exclusion && specialCases.contains(Genome.class)))
			{ exportGenome(db, new File(directory+"/genome.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","residues","seqlen","species_Identifier"}) : null, rules); }
		if((exclusion && !specialCases.contains(Chromosome.class)) || (!exclusion && specialCases.contains(Chromosome.class)))
			{ exportChromosome(db, new File(directory+"/chromosome.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","residues","seqlen","genome_Identifier","orderNr","isAutosomal"}) : null, rules); }
		if((exclusion && !specialCases.contains(Gene.class)) || (!exclusion && specialCases.contains(Gene.class)))
			{ exportGene(db, new File(directory+"/gene.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","gdna_Identifier","gdna_start","gdna_end","residues","seqlen","strand"}) : null, rules); }
		if((exclusion && !specialCases.contains(Protein.class)) || (!exclusion && specialCases.contains(Protein.class)))
			{ exportProtein(db, new File(directory+"/protein.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","cdna_Identifier","cdna_start","cdna_end","residues","seqlen"}) : null, rules); }
		if((exclusion && !specialCases.contains(ProteinDomain.class)) || (!exclusion && specialCases.contains(ProteinDomain.class)))
			{ exportProteinDomain(db, new File(directory+"/proteindomain.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","cdna_Identifier","cdna_start","cdna_end","gdna_Identifier","gdna_start","gdna_end"}) : null, rules); }
		if((exclusion && !specialCases.contains(Exon.class)) || (!exclusion && specialCases.contains(Exon.class)))
			{ exportExon(db, new File(directory+"/exon.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","cdna_Identifier","cdna_start","cdna_end","gdna_Identifier","gdna_start","gdna_end","isIntron"}) : null, rules); }
		if((exclusion && !specialCases.contains(Variant.class)) || (!exclusion && specialCases.contains(Variant.class)))
			{ exportVariant(db, new File(directory+"/variant.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","gdna_Identifier","gdna_start","gdna_end","cdna_Identifier","cdna_start","cdna_end","aa_Identifier","aa_start","aa_end","gdna_notation","cdna_notation","aa_notation","variantType_Identifier"}) : null, rules); }
		if((exclusion && !specialCases.contains(Institute.class)) || (!exclusion && specialCases.contains(Institute.class)))
			{ exportInstitute(db, new File(directory+"/institute.txt"), skipAutoId ? Arrays.asList(new String[]{"name","Address","Phone","City","Country","Fax"}) : null, rules); }
		if((exclusion && !specialCases.contains(Person.class)) || (!exclusion && specialCases.contains(Person.class)))
			{ exportPerson(db, new File(directory+"/person.txt"), skipAutoId ? Arrays.asList(new String[]{"Name","Title","FirstName","MidInitials","LastName","Email","Phone","PrimaryAffilation_name","AffiliateInstitutions_name","OrcidPersonReference_Identifier"}) : null, rules); }
		if((exclusion && !specialCases.contains(Citation.class)) || (!exclusion && specialCases.contains(Citation.class)))
			{ exportCitation(db, new File(directory+"/citation.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","PubmedID","DOI","ontologyTerms_Identifier","authorList","Title","Description","Status_Identifier"}) : null, rules); }
		if((exclusion && !specialCases.contains(Investigation.class)) || (!exclusion && specialCases.contains(Investigation.class)))
			{ exportInvestigation(db, new File(directory+"/investigation.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","Title","ShortName","Version","Background"}) : null, rules); }
		if((exclusion && !specialCases.contains(Study.class)) || (!exclusion && specialCases.contains(Study.class)))
			{ exportStudy(db, new File(directory+"/study.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","Description","StartDate","UpdateDate","EndDate","Contact_Name","PartOfInvestigation_Identifier"}) : null, rules); }
		if((exclusion && !specialCases.contains(Experiment.class)) || (!exclusion && specialCases.contains(Experiment.class)))
			{ exportExperiment(db, new File(directory+"/experiment.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","Study_Identifier","Design","ExperimentType_Identifier","TotalMarkersTested","TotalMarkersImported","Objective","Outcome","Comments","IndividualDataStatement","TimeCreated","AssayedPanels_Identifier","DataSets_Identifier"}) : null, rules); }
		if((exclusion && !specialCases.contains(Submission.class)) || (!exclusion && specialCases.contains(Submission.class)))
			{ exportSubmission(db, new File(directory+"/submission.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","TimeCreated","Study_Identifier"}) : null, rules); }
		if((exclusion && !specialCases.contains(Contribution.class)) || (!exclusion && specialCases.contains(Contribution.class)))
			{ exportContribution(db, new File(directory+"/contribution.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","Researcher_Name","Submission_Identifier","IsSubmitter","IsAuthor","IsSource"}) : null, rules); }
		if((exclusion && !specialCases.contains(StudyDetails.class)) || (!exclusion && specialCases.contains(StudyDetails.class)))
			{ exportStudyDetails(db, new File(directory+"/studydetails.txt"), skipAutoId ? Arrays.asList(new String[]{"Study_Identifier","Title","ShortName","StudyAbstract","Version","Background","Objectives","KeyResults","Conclusions","StudyDesign","StudySizeReason","StudyPower","SourcesOfBias","Limitations","Acknowledgements","primaryCitation_Identifier","otherCitations_Identifier","Accession"}) : null, rules); }
		if((exclusion && !specialCases.contains(PhenotypeProperty.class)) || (!exclusion && specialCases.contains(PhenotypeProperty.class)))
			{ exportPhenotypeProperty(db, new File(directory+"/phenotypeproperty.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","unit_Identifier","dataType","temporal"}) : null, rules); }
		if((exclusion && !specialCases.contains(PhenotypeMethod.class)) || (!exclusion && specialCases.contains(PhenotypeMethod.class)))
			{ exportPhenotypeMethod(db, new File(directory+"/phenotypemethod.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","ProtocolUsed_Identifier","startTime","endTime","StudyID_Identifier","PhenotypePropertyID_Identifier","Sample"}) : null, rules); }
		if((exclusion && !specialCases.contains(SamplePanel.class)) || (!exclusion && specialCases.contains(SamplePanel.class)))
			{ exportSamplePanel(db, new File(directory+"/samplepanel.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","Description","PanelType_Identifier","NumberOfIndividuals","Species_Identifier","Individuals_Identifier","CentralIdentifier_Identifier","Label","Accession","AccessionVersion","Composition","TotalNumberOfIndividuals","NumberOfSexMale","NumberOfSexFemale","NumberOfSexUnknown","NumberOfProbands","NumberOfParents","ModeOfRecruitment","DiagnosisAgeRange","DiagnosisPeriod","SamplingAgeRange","SamplingPeriod","PopulationInfo","GeographicRegionInfo","EthnicityInfo","BirthPlaceInfo","AdmixtureInfo","EnvironmentInfo","SourceOfDNA","DNAsArePooled","DNAsAreWGA"}) : null, rules); }
		if((exclusion && !specialCases.contains(AssayedPanel.class)) || (!exclusion && specialCases.contains(AssayedPanel.class)))
			{ exportAssayedPanel(db, new File(directory+"/assayedpanel.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","Description","PanelType_Identifier","NumberOfIndividuals","Species_Identifier","Individuals_Identifier","TotalNumberOfIndividuals","NumberOfSexMale","NumberOfSexFemale","NumberOfSexUnknown","NumberOfProbands","NumberOfParents"}) : null, rules); }
		if((exclusion && !specialCases.contains(PanelSource.class)) || (!exclusion && specialCases.contains(PanelSource.class)))
			{ exportPanelSource(db, new File(directory+"/panelsource.txt"), skipAutoId ? Arrays.asList(new String[]{"CurrentPanel_Identifier","SourcePanel_Identifier","NumberOfIndividuals","SelectionCriteria"}) : null, rules); }
		if((exclusion && !specialCases.contains(GWASExperiment.class)) || (!exclusion && specialCases.contains(GWASExperiment.class)))
			{ exportGWASExperiment(db, new File(directory+"/gwasexperiment.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","Study_Identifier","Design","ExperimentType_Identifier","TotalMarkersTested","TotalMarkersImported","Objective","Outcome","Comments","IndividualDataStatement","TimeCreated","AssayedPanels_Identifier","DataSets_Identifier"}) : null, rules); }
		if((exclusion && !specialCases.contains(UsedMarkerSet.class)) || (!exclusion && specialCases.contains(UsedMarkerSet.class)))
			{ exportUsedMarkerSet(db, new File(directory+"/usedmarkerset.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","unit_Identifier","dataType","temporal","ExperimentID_Identifier","MarkerIdentifier"}) : null, rules); }
		if((exclusion && !specialCases.contains(Category.class)) || (!exclusion && specialCases.contains(Category.class)))
			{ exportCategory(db, new File(directory+"/category.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","observableFeature_Identifier","valueCode","isMissing"}) : null, rules); }
		if((exclusion && !specialCases.contains(Significance.class)) || (!exclusion && specialCases.contains(Significance.class)))
			{ exportSignificance(db, new File(directory+"/significance.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","ProtocolUsed_Identifier","startTime","endTime","UsedmarkersetID_Identifier","NegLogPValue","UnadjustedPValue","AdjustedPValue"}) : null, rules); }
		if((exclusion && !specialCases.contains(EffectSize.class)) || (!exclusion && specialCases.contains(EffectSize.class)))
			{ exportEffectSize(db, new File(directory+"/effectsize.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","ProtocolUsed_Identifier","startTime","endTime","UsedMarkerSetID_Identifier","Lower95Bound","Upper95Bound","StdError"}) : null, rules); }
		if((exclusion && !specialCases.contains(SelectionCriteria.class)) || (!exclusion && specialCases.contains(SelectionCriteria.class)))
			{ exportSelectionCriteria(db, new File(directory+"/selectioncriteria.txt"), skipAutoId ? Arrays.asList(new String[]{"SourcePanel_Identifier","TargetPanel_Identifier","NumberOfIndividuals","Details"}) : null, rules); }
		if((exclusion && !specialCases.contains(ObservationSet.class)) || (!exclusion && specialCases.contains(ObservationSet.class)))
			{ exportObservationSet(db, new File(directory+"/observationset.txt"), skipAutoId ? Arrays.asList(new String[]{"partOfDataSet_Identifier","Target_Identifier","Time"}) : null, rules); }
		if((exclusion && !specialCases.contains(ObservedValue.class)) || (!exclusion && specialCases.contains(ObservedValue.class)))
			{ exportObservedValue(db, new File(directory+"/observedvalue.txt"), skipAutoId ? Arrays.asList(new String[]{"__Type","ObservationSet_id","Feature_Identifier","Characteristic_Identifier","Value"}) : null, rules); }
		if((exclusion && !specialCases.contains(FrequencyCluster.class)) || (!exclusion && specialCases.contains(FrequencyCluster.class)))
			{ exportFrequencyCluster(db, new File(directory+"/frequencycluster.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","ProtocolUsed_Identifier","startTime","endTime","DataSet_Identifier","UsedMarkerSet_Identifier","MarkerID","NumberOfGenotypedSamples","PValueHWE","UnadjustedPValue","OddsRatioStatement","AttributableRiskStatement"}) : null, rules); }
		if((exclusion && !specialCases.contains(GenotypeFrequency.class)) || (!exclusion && specialCases.contains(GenotypeFrequency.class)))
			{ exportGenotypeFrequency(db, new File(directory+"/genotypefrequency.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","ProtocolUsed_Identifier","startTime","endTime","FrequencyCluster_Identifier","GenotypeCombo","FrequencyAsProportion","NumberSamplesWithGenotype"}) : null, rules); }
		if((exclusion && !specialCases.contains(AlleleFrequency.class)) || (!exclusion && specialCases.contains(AlleleFrequency.class)))
			{ exportAlleleFrequency(db, new File(directory+"/allelefrequency.txt"), skipAutoId ? Arrays.asList(new String[]{"Identifier","Name","__Type","description","ProtocolUsed_Identifier","startTime","endTime","FrequencyCluster_Identifier","AlleleCombo","FrequencyAsProportion"}) : null, rules); }
		if((exclusion && !specialCases.contains(PhenotypeValue.class)) || (!exclusion && specialCases.contains(PhenotypeValue.class)))
			{ exportPhenotypeValue(db, new File(directory+"/phenotypevalue.txt"), skipAutoId ? Arrays.asList(new String[]{"__Type","ObservationSet_id","Feature_Identifier","Characteristic_Identifier","Value","Identifier","Name","PhenotypePropertyID_Identifier","ValueRank","ValueIsMean","STD","Min","Max"}) : null, rules); }
	
		logger.debug("done");
	}
	
		private QueryRule[] matchQueryRulesToEntity(org.molgenis.model.elements.Entity e, QueryRule ... rules) throws MolgenisModelException
	{
		ArrayList<QueryRule> tmpResult = new ArrayList<QueryRule>();
		for(QueryRule q : rules){
			if(!(e.getAllField(q.getField()) == null)){
				tmpResult.add(q); //field is okay for this entity
			}
			//special case: eg. investigation.name -> if current entity is 'investigation', use field 'name'
			String[] splitField = q.getField().split("\\.");
			if(splitField.length == 2){
				if(e.getName().equals(splitField[0])){
					QueryRule copy = new QueryRule(q);
					copy.setField(splitField[1]);
					tmpResult.add(copy);
				}
			}
		}
		QueryRule[] result = new QueryRule[tmpResult.size()];
		for(int i=0; i<result.length; i++){
			result[i] = tmpResult.get(i);
		}
		return result;
	}

	/**
	 *	export MolgenisEntity to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportMolgenisEntity(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(MolgenisEntity.class) > 0)
		{
			
			org.molgenis.framework.db.Query<MolgenisEntity> query = db.query(MolgenisEntity.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("MolgenisEntity"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter molgenisEntityWriter = new CsvFileWriter(f);
				query.find(molgenisEntityWriter, fieldsToExport);
				molgenisEntityWriter.close();
			}
		}
	}
	
	public void exportMolgenisEntity(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter molgenisEntityWriter = new CsvFileWriter(file, notNulls);
			molgenisEntityWriter.writeHeader();
			for(Entity e: entities)
			{
				molgenisEntityWriter.writeRow((org.molgenis.util.Entity)e);
			}
			molgenisEntityWriter.close();
		}
	}
	/**
	 *	export MolgenisFile to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportMolgenisFile(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(MolgenisFile.class) > 0)
		{
			
			org.molgenis.framework.db.Query<MolgenisFile> query = db.query(MolgenisFile.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("MolgenisFile"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter molgenisFileWriter = new CsvFileWriter(f);
				query.find(molgenisFileWriter, fieldsToExport);
				molgenisFileWriter.close();
			}
		}
	}
	
	public void exportMolgenisFile(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter molgenisFileWriter = new CsvFileWriter(file, notNulls);
			molgenisFileWriter.writeHeader();
			for(Entity e: entities)
			{
				molgenisFileWriter.writeRow((org.molgenis.util.Entity)e);
			}
			molgenisFileWriter.close();
		}
	}
	/**
	 *	export RuntimeProperty to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportRuntimeProperty(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(RuntimeProperty.class) > 0)
		{
			
			org.molgenis.framework.db.Query<RuntimeProperty> query = db.query(RuntimeProperty.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("RuntimeProperty"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter runtimePropertyWriter = new CsvFileWriter(f);
				query.find(runtimePropertyWriter, fieldsToExport);
				runtimePropertyWriter.close();
			}
		}
	}
	
	public void exportRuntimeProperty(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter runtimePropertyWriter = new CsvFileWriter(file, notNulls);
			runtimePropertyWriter.writeHeader();
			for(Entity e: entities)
			{
				runtimePropertyWriter.writeRow((org.molgenis.util.Entity)e);
			}
			runtimePropertyWriter.close();
		}
	}
	/**
	 *	export MolgenisRole to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportMolgenisRole(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(MolgenisRole.class, new QueryRule("__Type",Operator.EQUALS, "MolgenisRole")) > 0)
		{
			
			org.molgenis.framework.db.Query<MolgenisRole> query = db.query(MolgenisRole.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "MolgenisRole");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("MolgenisRole"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter molgenisRoleWriter = new CsvFileWriter(f);
				query.find(molgenisRoleWriter, fieldsToExport);
				molgenisRoleWriter.close();
			}
		}
	}
	
	public void exportMolgenisRole(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter molgenisRoleWriter = new CsvFileWriter(file, notNulls);
			molgenisRoleWriter.writeHeader();
			for(Entity e: entities)
			{
				molgenisRoleWriter.writeRow((org.molgenis.util.Entity)e);
			}
			molgenisRoleWriter.close();
		}
	}
	/**
	 *	export MolgenisGroup to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportMolgenisGroup(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(MolgenisGroup.class, new QueryRule("__Type",Operator.EQUALS, "MolgenisGroup")) > 0)
		{
			
			org.molgenis.framework.db.Query<MolgenisGroup> query = db.query(MolgenisGroup.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "MolgenisGroup");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("MolgenisGroup"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter molgenisGroupWriter = new CsvFileWriter(f);
				query.find(molgenisGroupWriter, fieldsToExport);
				molgenisGroupWriter.close();
			}
		}
	}
	
	public void exportMolgenisGroup(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter molgenisGroupWriter = new CsvFileWriter(file, notNulls);
			molgenisGroupWriter.writeHeader();
			for(Entity e: entities)
			{
				molgenisGroupWriter.writeRow((org.molgenis.util.Entity)e);
			}
			molgenisGroupWriter.close();
		}
	}
	/**
	 *	export MolgenisUser to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportMolgenisUser(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(MolgenisUser.class) > 0)
		{
			
			org.molgenis.framework.db.Query<MolgenisUser> query = db.query(MolgenisUser.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("MolgenisUser"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter molgenisUserWriter = new CsvFileWriter(f);
				query.find(molgenisUserWriter, fieldsToExport);
				molgenisUserWriter.close();
			}
		}
	}
	
	public void exportMolgenisUser(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter molgenisUserWriter = new CsvFileWriter(file, notNulls);
			molgenisUserWriter.writeHeader();
			for(Entity e: entities)
			{
				molgenisUserWriter.writeRow((org.molgenis.util.Entity)e);
			}
			molgenisUserWriter.close();
		}
	}
	/**
	 *	export MolgenisRoleGroupLink to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportMolgenisRoleGroupLink(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(MolgenisRoleGroupLink.class) > 0)
		{
			
			org.molgenis.framework.db.Query<MolgenisRoleGroupLink> query = db.query(MolgenisRoleGroupLink.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("MolgenisRoleGroupLink"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter molgenisRoleGroupLinkWriter = new CsvFileWriter(f);
				query.find(molgenisRoleGroupLinkWriter, fieldsToExport);
				molgenisRoleGroupLinkWriter.close();
			}
		}
	}
	
	public void exportMolgenisRoleGroupLink(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter molgenisRoleGroupLinkWriter = new CsvFileWriter(file, notNulls);
			molgenisRoleGroupLinkWriter.writeHeader();
			for(Entity e: entities)
			{
				molgenisRoleGroupLinkWriter.writeRow((org.molgenis.util.Entity)e);
			}
			molgenisRoleGroupLinkWriter.close();
		}
	}
	/**
	 *	export MolgenisPermission to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportMolgenisPermission(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(MolgenisPermission.class) > 0)
		{
			
			org.molgenis.framework.db.Query<MolgenisPermission> query = db.query(MolgenisPermission.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("MolgenisPermission"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter molgenisPermissionWriter = new CsvFileWriter(f);
				query.find(molgenisPermissionWriter, fieldsToExport);
				molgenisPermissionWriter.close();
			}
		}
	}
	
	public void exportMolgenisPermission(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter molgenisPermissionWriter = new CsvFileWriter(file, notNulls);
			molgenisPermissionWriter.writeHeader();
			for(Entity e: entities)
			{
				molgenisPermissionWriter.writeRow((org.molgenis.util.Entity)e);
			}
			molgenisPermissionWriter.close();
		}
	}
	/**
	 *	export Characteristic to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportCharacteristic(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Characteristic.class, new QueryRule("__Type",Operator.EQUALS, "Characteristic")) > 0)
		{
			
			org.molgenis.framework.db.Query<Characteristic> query = db.query(Characteristic.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "Characteristic");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Characteristic"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter characteristicWriter = new CsvFileWriter(f);
				query.find(characteristicWriter, fieldsToExport);
				characteristicWriter.close();
			}
		}
	}
	
	public void exportCharacteristic(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter characteristicWriter = new CsvFileWriter(file, notNulls);
			characteristicWriter.writeHeader();
			for(Entity e: entities)
			{
				characteristicWriter.writeRow((org.molgenis.util.Entity)e);
			}
			characteristicWriter.close();
		}
	}
	/**
	 *	export ObservationTarget to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportObservationTarget(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(ObservationTarget.class, new QueryRule("__Type",Operator.EQUALS, "ObservationTarget")) > 0)
		{
			
			org.molgenis.framework.db.Query<ObservationTarget> query = db.query(ObservationTarget.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "ObservationTarget");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("ObservationTarget"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter observationTargetWriter = new CsvFileWriter(f);
				query.find(observationTargetWriter, fieldsToExport);
				observationTargetWriter.close();
			}
		}
	}
	
	public void exportObservationTarget(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter observationTargetWriter = new CsvFileWriter(file, notNulls);
			observationTargetWriter.writeHeader();
			for(Entity e: entities)
			{
				observationTargetWriter.writeRow((org.molgenis.util.Entity)e);
			}
			observationTargetWriter.close();
		}
	}
	/**
	 *	export Individual to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportIndividual(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Individual.class, new QueryRule("__Type",Operator.EQUALS, "Individual")) > 0)
		{
			
			org.molgenis.framework.db.Query<Individual> query = db.query(Individual.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "Individual");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Individual"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter individualWriter = new CsvFileWriter(f);
				query.find(individualWriter, fieldsToExport);
				individualWriter.close();
			}
		}
	}
	
	public void exportIndividual(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter individualWriter = new CsvFileWriter(file, notNulls);
			individualWriter.writeHeader();
			for(Entity e: entities)
			{
				individualWriter.writeRow((org.molgenis.util.Entity)e);
			}
			individualWriter.close();
		}
	}
	/**
	 *	export Ontology to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportOntology(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Ontology.class) > 0)
		{
			
			org.molgenis.framework.db.Query<Ontology> query = db.query(Ontology.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Ontology"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter ontologyWriter = new CsvFileWriter(f);
				query.find(ontologyWriter, fieldsToExport);
				ontologyWriter.close();
			}
		}
	}
	
	public void exportOntology(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter ontologyWriter = new CsvFileWriter(file, notNulls);
			ontologyWriter.writeHeader();
			for(Entity e: entities)
			{
				ontologyWriter.writeRow((org.molgenis.util.Entity)e);
			}
			ontologyWriter.close();
		}
	}
	/**
	 *	export Species to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportSpecies(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Species.class, new QueryRule("__Type",Operator.EQUALS, "Species")) > 0)
		{
			
			org.molgenis.framework.db.Query<Species> query = db.query(Species.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "Species");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Species"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter speciesWriter = new CsvFileWriter(f);
				query.find(speciesWriter, fieldsToExport);
				speciesWriter.close();
			}
		}
	}
	
	public void exportSpecies(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter speciesWriter = new CsvFileWriter(file, notNulls);
			speciesWriter.writeHeader();
			for(Entity e: entities)
			{
				speciesWriter.writeRow((org.molgenis.util.Entity)e);
			}
			speciesWriter.close();
		}
	}
	/**
	 *	export OntologyTerm to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportOntologyTerm(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(OntologyTerm.class, new QueryRule("__Type",Operator.EQUALS, "OntologyTerm")) > 0)
		{
			
			org.molgenis.framework.db.Query<OntologyTerm> query = db.query(OntologyTerm.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "OntologyTerm");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("OntologyTerm"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter ontologyTermWriter = new CsvFileWriter(f);
				query.find(ontologyTermWriter, fieldsToExport);
				ontologyTermWriter.close();
			}
		}
	}
	
	public void exportOntologyTerm(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter ontologyTermWriter = new CsvFileWriter(file, notNulls);
			ontologyTermWriter.writeHeader();
			for(Entity e: entities)
			{
				ontologyTermWriter.writeRow((org.molgenis.util.Entity)e);
			}
			ontologyTermWriter.close();
		}
	}
	/**
	 *	export Accession to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportAccession(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Accession.class, new QueryRule("__Type",Operator.EQUALS, "Accession")) > 0)
		{
			
			org.molgenis.framework.db.Query<Accession> query = db.query(Accession.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "Accession");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Accession"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter accessionWriter = new CsvFileWriter(f);
				query.find(accessionWriter, fieldsToExport);
				accessionWriter.close();
			}
		}
	}
	
	public void exportAccession(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter accessionWriter = new CsvFileWriter(file, notNulls);
			accessionWriter.writeHeader();
			for(Entity e: entities)
			{
				accessionWriter.writeRow((org.molgenis.util.Entity)e);
			}
			accessionWriter.close();
		}
	}
	/**
	 *	export ObservableFeature to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportObservableFeature(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(ObservableFeature.class, new QueryRule("__Type",Operator.EQUALS, "ObservableFeature")) > 0)
		{
			
			org.molgenis.framework.db.Query<ObservableFeature> query = db.query(ObservableFeature.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "ObservableFeature");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("ObservableFeature"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter observableFeatureWriter = new CsvFileWriter(f);
				query.find(observableFeatureWriter, fieldsToExport);
				observableFeatureWriter.close();
			}
		}
	}
	
	public void exportObservableFeature(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter observableFeatureWriter = new CsvFileWriter(file, notNulls);
			observableFeatureWriter.writeHeader();
			for(Entity e: entities)
			{
				observableFeatureWriter.writeRow((org.molgenis.util.Entity)e);
			}
			observableFeatureWriter.close();
		}
	}
	/**
	 *	export Protocol to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportProtocol(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Protocol.class, new QueryRule("__Type",Operator.EQUALS, "Protocol")) > 0)
		{
			
			org.molgenis.framework.db.Query<Protocol> query = db.query(Protocol.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "Protocol");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Protocol"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter protocolWriter = new CsvFileWriter(f);
				query.find(protocolWriter, fieldsToExport);
				protocolWriter.close();
			}
		}
	}
	
	public void exportProtocol(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter protocolWriter = new CsvFileWriter(file, notNulls);
			protocolWriter.writeHeader();
			for(Entity e: entities)
			{
				protocolWriter.writeRow((org.molgenis.util.Entity)e);
			}
			protocolWriter.close();
		}
	}
	/**
	 *	export DataSet to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportDataSet(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(DataSet.class, new QueryRule("__Type",Operator.EQUALS, "DataSet")) > 0)
		{
			
			org.molgenis.framework.db.Query<DataSet> query = db.query(DataSet.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "DataSet");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("DataSet"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter dataSetWriter = new CsvFileWriter(f);
				query.find(dataSetWriter, fieldsToExport);
				dataSetWriter.close();
			}
		}
	}
	
	public void exportDataSet(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter dataSetWriter = new CsvFileWriter(file, notNulls);
			dataSetWriter.writeHeader();
			for(Entity e: entities)
			{
				dataSetWriter.writeRow((org.molgenis.util.Entity)e);
			}
			dataSetWriter.close();
		}
	}
	/**
	 *	export Panel to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportPanel(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Panel.class, new QueryRule("__Type",Operator.EQUALS, "Panel")) > 0)
		{
			
			org.molgenis.framework.db.Query<Panel> query = db.query(Panel.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "Panel");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Panel"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter panelWriter = new CsvFileWriter(f);
				query.find(panelWriter, fieldsToExport);
				panelWriter.close();
			}
		}
	}
	
	public void exportPanel(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter panelWriter = new CsvFileWriter(file, notNulls);
			panelWriter.writeHeader();
			for(Entity e: entities)
			{
				panelWriter.writeRow((org.molgenis.util.Entity)e);
			}
			panelWriter.close();
		}
	}
	/**
	 *	export Genome to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportGenome(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Genome.class, new QueryRule("__Type",Operator.EQUALS, "Genome")) > 0)
		{
			
			org.molgenis.framework.db.Query<Genome> query = db.query(Genome.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "Genome");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Genome"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter genomeWriter = new CsvFileWriter(f);
				query.find(genomeWriter, fieldsToExport);
				genomeWriter.close();
			}
		}
	}
	
	public void exportGenome(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter genomeWriter = new CsvFileWriter(file, notNulls);
			genomeWriter.writeHeader();
			for(Entity e: entities)
			{
				genomeWriter.writeRow((org.molgenis.util.Entity)e);
			}
			genomeWriter.close();
		}
	}
	/**
	 *	export Chromosome to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportChromosome(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Chromosome.class, new QueryRule("__Type",Operator.EQUALS, "Chromosome")) > 0)
		{
			
			org.molgenis.framework.db.Query<Chromosome> query = db.query(Chromosome.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "Chromosome");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Chromosome"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter chromosomeWriter = new CsvFileWriter(f);
				query.find(chromosomeWriter, fieldsToExport);
				chromosomeWriter.close();
			}
		}
	}
	
	public void exportChromosome(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter chromosomeWriter = new CsvFileWriter(file, notNulls);
			chromosomeWriter.writeHeader();
			for(Entity e: entities)
			{
				chromosomeWriter.writeRow((org.molgenis.util.Entity)e);
			}
			chromosomeWriter.close();
		}
	}
	/**
	 *	export Gene to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportGene(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Gene.class, new QueryRule("__Type",Operator.EQUALS, "Gene")) > 0)
		{
			
			org.molgenis.framework.db.Query<Gene> query = db.query(Gene.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "Gene");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Gene"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter geneWriter = new CsvFileWriter(f);
				query.find(geneWriter, fieldsToExport);
				geneWriter.close();
			}
		}
	}
	
	public void exportGene(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter geneWriter = new CsvFileWriter(file, notNulls);
			geneWriter.writeHeader();
			for(Entity e: entities)
			{
				geneWriter.writeRow((org.molgenis.util.Entity)e);
			}
			geneWriter.close();
		}
	}
	/**
	 *	export Protein to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportProtein(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Protein.class, new QueryRule("__Type",Operator.EQUALS, "Protein")) > 0)
		{
			
			org.molgenis.framework.db.Query<Protein> query = db.query(Protein.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "Protein");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Protein"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter proteinWriter = new CsvFileWriter(f);
				query.find(proteinWriter, fieldsToExport);
				proteinWriter.close();
			}
		}
	}
	
	public void exportProtein(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter proteinWriter = new CsvFileWriter(file, notNulls);
			proteinWriter.writeHeader();
			for(Entity e: entities)
			{
				proteinWriter.writeRow((org.molgenis.util.Entity)e);
			}
			proteinWriter.close();
		}
	}
	/**
	 *	export ProteinDomain to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportProteinDomain(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(ProteinDomain.class, new QueryRule("__Type",Operator.EQUALS, "ProteinDomain")) > 0)
		{
			
			org.molgenis.framework.db.Query<ProteinDomain> query = db.query(ProteinDomain.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "ProteinDomain");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("ProteinDomain"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter proteinDomainWriter = new CsvFileWriter(f);
				query.find(proteinDomainWriter, fieldsToExport);
				proteinDomainWriter.close();
			}
		}
	}
	
	public void exportProteinDomain(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter proteinDomainWriter = new CsvFileWriter(file, notNulls);
			proteinDomainWriter.writeHeader();
			for(Entity e: entities)
			{
				proteinDomainWriter.writeRow((org.molgenis.util.Entity)e);
			}
			proteinDomainWriter.close();
		}
	}
	/**
	 *	export Exon to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportExon(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Exon.class, new QueryRule("__Type",Operator.EQUALS, "Exon")) > 0)
		{
			
			org.molgenis.framework.db.Query<Exon> query = db.query(Exon.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "Exon");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Exon"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter exonWriter = new CsvFileWriter(f);
				query.find(exonWriter, fieldsToExport);
				exonWriter.close();
			}
		}
	}
	
	public void exportExon(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter exonWriter = new CsvFileWriter(file, notNulls);
			exonWriter.writeHeader();
			for(Entity e: entities)
			{
				exonWriter.writeRow((org.molgenis.util.Entity)e);
			}
			exonWriter.close();
		}
	}
	/**
	 *	export Variant to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportVariant(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Variant.class, new QueryRule("__Type",Operator.EQUALS, "Variant")) > 0)
		{
			
			org.molgenis.framework.db.Query<Variant> query = db.query(Variant.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "Variant");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Variant"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter variantWriter = new CsvFileWriter(f);
				query.find(variantWriter, fieldsToExport);
				variantWriter.close();
			}
		}
	}
	
	public void exportVariant(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter variantWriter = new CsvFileWriter(file, notNulls);
			variantWriter.writeHeader();
			for(Entity e: entities)
			{
				variantWriter.writeRow((org.molgenis.util.Entity)e);
			}
			variantWriter.close();
		}
	}
	/**
	 *	export Institute to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportInstitute(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Institute.class) > 0)
		{
			
			org.molgenis.framework.db.Query<Institute> query = db.query(Institute.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Institute"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter instituteWriter = new CsvFileWriter(f);
				query.find(instituteWriter, fieldsToExport);
				instituteWriter.close();
			}
		}
	}
	
	public void exportInstitute(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter instituteWriter = new CsvFileWriter(file, notNulls);
			instituteWriter.writeHeader();
			for(Entity e: entities)
			{
				instituteWriter.writeRow((org.molgenis.util.Entity)e);
			}
			instituteWriter.close();
		}
	}
	/**
	 *	export Person to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportPerson(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Person.class) > 0)
		{
			
			org.molgenis.framework.db.Query<Person> query = db.query(Person.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Person"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter personWriter = new CsvFileWriter(f);
				query.find(personWriter, fieldsToExport);
				personWriter.close();
			}
		}
	}
	
	public void exportPerson(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter personWriter = new CsvFileWriter(file, notNulls);
			personWriter.writeHeader();
			for(Entity e: entities)
			{
				personWriter.writeRow((org.molgenis.util.Entity)e);
			}
			personWriter.close();
		}
	}
	/**
	 *	export Citation to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportCitation(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Citation.class) > 0)
		{
			
			org.molgenis.framework.db.Query<Citation> query = db.query(Citation.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Citation"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter citationWriter = new CsvFileWriter(f);
				query.find(citationWriter, fieldsToExport);
				citationWriter.close();
			}
		}
	}
	
	public void exportCitation(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter citationWriter = new CsvFileWriter(file, notNulls);
			citationWriter.writeHeader();
			for(Entity e: entities)
			{
				citationWriter.writeRow((org.molgenis.util.Entity)e);
			}
			citationWriter.close();
		}
	}
	/**
	 *	export Investigation to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportInvestigation(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Investigation.class) > 0)
		{
			
			org.molgenis.framework.db.Query<Investigation> query = db.query(Investigation.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Investigation"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter investigationWriter = new CsvFileWriter(f);
				query.find(investigationWriter, fieldsToExport);
				investigationWriter.close();
			}
		}
	}
	
	public void exportInvestigation(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter investigationWriter = new CsvFileWriter(file, notNulls);
			investigationWriter.writeHeader();
			for(Entity e: entities)
			{
				investigationWriter.writeRow((org.molgenis.util.Entity)e);
			}
			investigationWriter.close();
		}
	}
	/**
	 *	export Study to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportStudy(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Study.class) > 0)
		{
			
			org.molgenis.framework.db.Query<Study> query = db.query(Study.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Study"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter studyWriter = new CsvFileWriter(f);
				query.find(studyWriter, fieldsToExport);
				studyWriter.close();
			}
		}
	}
	
	public void exportStudy(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter studyWriter = new CsvFileWriter(file, notNulls);
			studyWriter.writeHeader();
			for(Entity e: entities)
			{
				studyWriter.writeRow((org.molgenis.util.Entity)e);
			}
			studyWriter.close();
		}
	}
	/**
	 *	export Experiment to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportExperiment(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Experiment.class, new QueryRule("__Type",Operator.EQUALS, "Experiment")) > 0)
		{
			
			org.molgenis.framework.db.Query<Experiment> query = db.query(Experiment.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "Experiment");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Experiment"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter experimentWriter = new CsvFileWriter(f);
				query.find(experimentWriter, fieldsToExport);
				experimentWriter.close();
			}
		}
	}
	
	public void exportExperiment(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter experimentWriter = new CsvFileWriter(file, notNulls);
			experimentWriter.writeHeader();
			for(Entity e: entities)
			{
				experimentWriter.writeRow((org.molgenis.util.Entity)e);
			}
			experimentWriter.close();
		}
	}
	/**
	 *	export Submission to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportSubmission(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Submission.class) > 0)
		{
			
			org.molgenis.framework.db.Query<Submission> query = db.query(Submission.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Submission"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter submissionWriter = new CsvFileWriter(f);
				query.find(submissionWriter, fieldsToExport);
				submissionWriter.close();
			}
		}
	}
	
	public void exportSubmission(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter submissionWriter = new CsvFileWriter(file, notNulls);
			submissionWriter.writeHeader();
			for(Entity e: entities)
			{
				submissionWriter.writeRow((org.molgenis.util.Entity)e);
			}
			submissionWriter.close();
		}
	}
	/**
	 *	export Contribution to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportContribution(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Contribution.class) > 0)
		{
			
			org.molgenis.framework.db.Query<Contribution> query = db.query(Contribution.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Contribution"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter contributionWriter = new CsvFileWriter(f);
				query.find(contributionWriter, fieldsToExport);
				contributionWriter.close();
			}
		}
	}
	
	public void exportContribution(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter contributionWriter = new CsvFileWriter(file, notNulls);
			contributionWriter.writeHeader();
			for(Entity e: entities)
			{
				contributionWriter.writeRow((org.molgenis.util.Entity)e);
			}
			contributionWriter.close();
		}
	}
	/**
	 *	export StudyDetails to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportStudyDetails(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(StudyDetails.class) > 0)
		{
			
			org.molgenis.framework.db.Query<StudyDetails> query = db.query(StudyDetails.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("StudyDetails"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter studyDetailsWriter = new CsvFileWriter(f);
				query.find(studyDetailsWriter, fieldsToExport);
				studyDetailsWriter.close();
			}
		}
	}
	
	public void exportStudyDetails(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter studyDetailsWriter = new CsvFileWriter(file, notNulls);
			studyDetailsWriter.writeHeader();
			for(Entity e: entities)
			{
				studyDetailsWriter.writeRow((org.molgenis.util.Entity)e);
			}
			studyDetailsWriter.close();
		}
	}
	/**
	 *	export PhenotypeProperty to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportPhenotypeProperty(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(PhenotypeProperty.class, new QueryRule("__Type",Operator.EQUALS, "PhenotypeProperty")) > 0)
		{
			
			org.molgenis.framework.db.Query<PhenotypeProperty> query = db.query(PhenotypeProperty.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "PhenotypeProperty");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("PhenotypeProperty"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter phenotypePropertyWriter = new CsvFileWriter(f);
				query.find(phenotypePropertyWriter, fieldsToExport);
				phenotypePropertyWriter.close();
			}
		}
	}
	
	public void exportPhenotypeProperty(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter phenotypePropertyWriter = new CsvFileWriter(file, notNulls);
			phenotypePropertyWriter.writeHeader();
			for(Entity e: entities)
			{
				phenotypePropertyWriter.writeRow((org.molgenis.util.Entity)e);
			}
			phenotypePropertyWriter.close();
		}
	}
	/**
	 *	export PhenotypeMethod to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportPhenotypeMethod(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(PhenotypeMethod.class, new QueryRule("__Type",Operator.EQUALS, "PhenotypeMethod")) > 0)
		{
			
			org.molgenis.framework.db.Query<PhenotypeMethod> query = db.query(PhenotypeMethod.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "PhenotypeMethod");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("PhenotypeMethod"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter phenotypeMethodWriter = new CsvFileWriter(f);
				query.find(phenotypeMethodWriter, fieldsToExport);
				phenotypeMethodWriter.close();
			}
		}
	}
	
	public void exportPhenotypeMethod(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter phenotypeMethodWriter = new CsvFileWriter(file, notNulls);
			phenotypeMethodWriter.writeHeader();
			for(Entity e: entities)
			{
				phenotypeMethodWriter.writeRow((org.molgenis.util.Entity)e);
			}
			phenotypeMethodWriter.close();
		}
	}
	/**
	 *	export SamplePanel to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportSamplePanel(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(SamplePanel.class, new QueryRule("__Type",Operator.EQUALS, "SamplePanel")) > 0)
		{
			
			org.molgenis.framework.db.Query<SamplePanel> query = db.query(SamplePanel.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "SamplePanel");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("SamplePanel"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter samplePanelWriter = new CsvFileWriter(f);
				query.find(samplePanelWriter, fieldsToExport);
				samplePanelWriter.close();
			}
		}
	}
	
	public void exportSamplePanel(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter samplePanelWriter = new CsvFileWriter(file, notNulls);
			samplePanelWriter.writeHeader();
			for(Entity e: entities)
			{
				samplePanelWriter.writeRow((org.molgenis.util.Entity)e);
			}
			samplePanelWriter.close();
		}
	}
	/**
	 *	export AssayedPanel to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportAssayedPanel(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(AssayedPanel.class, new QueryRule("__Type",Operator.EQUALS, "AssayedPanel")) > 0)
		{
			
			org.molgenis.framework.db.Query<AssayedPanel> query = db.query(AssayedPanel.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "AssayedPanel");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("AssayedPanel"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter assayedPanelWriter = new CsvFileWriter(f);
				query.find(assayedPanelWriter, fieldsToExport);
				assayedPanelWriter.close();
			}
		}
	}
	
	public void exportAssayedPanel(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter assayedPanelWriter = new CsvFileWriter(file, notNulls);
			assayedPanelWriter.writeHeader();
			for(Entity e: entities)
			{
				assayedPanelWriter.writeRow((org.molgenis.util.Entity)e);
			}
			assayedPanelWriter.close();
		}
	}
	/**
	 *	export PanelSource to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportPanelSource(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(PanelSource.class) > 0)
		{
			
			org.molgenis.framework.db.Query<PanelSource> query = db.query(PanelSource.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("PanelSource"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter panelSourceWriter = new CsvFileWriter(f);
				query.find(panelSourceWriter, fieldsToExport);
				panelSourceWriter.close();
			}
		}
	}
	
	public void exportPanelSource(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter panelSourceWriter = new CsvFileWriter(file, notNulls);
			panelSourceWriter.writeHeader();
			for(Entity e: entities)
			{
				panelSourceWriter.writeRow((org.molgenis.util.Entity)e);
			}
			panelSourceWriter.close();
		}
	}
	/**
	 *	export GWASExperiment to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportGWASExperiment(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(GWASExperiment.class, new QueryRule("__Type",Operator.EQUALS, "GWASExperiment")) > 0)
		{
			
			org.molgenis.framework.db.Query<GWASExperiment> query = db.query(GWASExperiment.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "GWASExperiment");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("GWASExperiment"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter gWASExperimentWriter = new CsvFileWriter(f);
				query.find(gWASExperimentWriter, fieldsToExport);
				gWASExperimentWriter.close();
			}
		}
	}
	
	public void exportGWASExperiment(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter gWASExperimentWriter = new CsvFileWriter(file, notNulls);
			gWASExperimentWriter.writeHeader();
			for(Entity e: entities)
			{
				gWASExperimentWriter.writeRow((org.molgenis.util.Entity)e);
			}
			gWASExperimentWriter.close();
		}
	}
	/**
	 *	export UsedMarkerSet to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportUsedMarkerSet(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(UsedMarkerSet.class, new QueryRule("__Type",Operator.EQUALS, "UsedMarkerSet")) > 0)
		{
			
			org.molgenis.framework.db.Query<UsedMarkerSet> query = db.query(UsedMarkerSet.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "UsedMarkerSet");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("UsedMarkerSet"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter usedMarkerSetWriter = new CsvFileWriter(f);
				query.find(usedMarkerSetWriter, fieldsToExport);
				usedMarkerSetWriter.close();
			}
		}
	}
	
	public void exportUsedMarkerSet(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter usedMarkerSetWriter = new CsvFileWriter(file, notNulls);
			usedMarkerSetWriter.writeHeader();
			for(Entity e: entities)
			{
				usedMarkerSetWriter.writeRow((org.molgenis.util.Entity)e);
			}
			usedMarkerSetWriter.close();
		}
	}
	/**
	 *	export Category to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportCategory(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Category.class, new QueryRule("__Type",Operator.EQUALS, "Category")) > 0)
		{
			
			org.molgenis.framework.db.Query<Category> query = db.query(Category.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "Category");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Category"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter categoryWriter = new CsvFileWriter(f);
				query.find(categoryWriter, fieldsToExport);
				categoryWriter.close();
			}
		}
	}
	
	public void exportCategory(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter categoryWriter = new CsvFileWriter(file, notNulls);
			categoryWriter.writeHeader();
			for(Entity e: entities)
			{
				categoryWriter.writeRow((org.molgenis.util.Entity)e);
			}
			categoryWriter.close();
		}
	}
	/**
	 *	export Significance to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportSignificance(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Significance.class, new QueryRule("__Type",Operator.EQUALS, "Significance")) > 0)
		{
			
			org.molgenis.framework.db.Query<Significance> query = db.query(Significance.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "Significance");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Significance"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter significanceWriter = new CsvFileWriter(f);
				query.find(significanceWriter, fieldsToExport);
				significanceWriter.close();
			}
		}
	}
	
	public void exportSignificance(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter significanceWriter = new CsvFileWriter(file, notNulls);
			significanceWriter.writeHeader();
			for(Entity e: entities)
			{
				significanceWriter.writeRow((org.molgenis.util.Entity)e);
			}
			significanceWriter.close();
		}
	}
	/**
	 *	export EffectSize to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportEffectSize(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(EffectSize.class, new QueryRule("__Type",Operator.EQUALS, "EffectSize")) > 0)
		{
			
			org.molgenis.framework.db.Query<EffectSize> query = db.query(EffectSize.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "EffectSize");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("EffectSize"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter effectSizeWriter = new CsvFileWriter(f);
				query.find(effectSizeWriter, fieldsToExport);
				effectSizeWriter.close();
			}
		}
	}
	
	public void exportEffectSize(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter effectSizeWriter = new CsvFileWriter(file, notNulls);
			effectSizeWriter.writeHeader();
			for(Entity e: entities)
			{
				effectSizeWriter.writeRow((org.molgenis.util.Entity)e);
			}
			effectSizeWriter.close();
		}
	}
	/**
	 *	export SelectionCriteria to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportSelectionCriteria(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(SelectionCriteria.class) > 0)
		{
			
			org.molgenis.framework.db.Query<SelectionCriteria> query = db.query(SelectionCriteria.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("SelectionCriteria"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter selectionCriteriaWriter = new CsvFileWriter(f);
				query.find(selectionCriteriaWriter, fieldsToExport);
				selectionCriteriaWriter.close();
			}
		}
	}
	
	public void exportSelectionCriteria(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter selectionCriteriaWriter = new CsvFileWriter(file, notNulls);
			selectionCriteriaWriter.writeHeader();
			for(Entity e: entities)
			{
				selectionCriteriaWriter.writeRow((org.molgenis.util.Entity)e);
			}
			selectionCriteriaWriter.close();
		}
	}
	/**
	 *	export ObservationSet to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportObservationSet(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(ObservationSet.class) > 0)
		{
			
			org.molgenis.framework.db.Query<ObservationSet> query = db.query(ObservationSet.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("ObservationSet"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter observationSetWriter = new CsvFileWriter(f);
				query.find(observationSetWriter, fieldsToExport);
				observationSetWriter.close();
			}
		}
	}
	
	public void exportObservationSet(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter observationSetWriter = new CsvFileWriter(file, notNulls);
			observationSetWriter.writeHeader();
			for(Entity e: entities)
			{
				observationSetWriter.writeRow((org.molgenis.util.Entity)e);
			}
			observationSetWriter.close();
		}
	}
	/**
	 *	export ObservedValue to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportObservedValue(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(ObservedValue.class, new QueryRule("__Type",Operator.EQUALS, "ObservedValue")) > 0)
		{
			
			org.molgenis.framework.db.Query<ObservedValue> query = db.query(ObservedValue.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "ObservedValue");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("ObservedValue"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter observedValueWriter = new CsvFileWriter(f);
				query.find(observedValueWriter, fieldsToExport);
				observedValueWriter.close();
			}
		}
	}
	
	public void exportObservedValue(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter observedValueWriter = new CsvFileWriter(file, notNulls);
			observedValueWriter.writeHeader();
			for(Entity e: entities)
			{
				observedValueWriter.writeRow((org.molgenis.util.Entity)e);
			}
			observedValueWriter.close();
		}
	}
	/**
	 *	export FrequencyCluster to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportFrequencyCluster(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(FrequencyCluster.class, new QueryRule("__Type",Operator.EQUALS, "FrequencyCluster")) > 0)
		{
			
			org.molgenis.framework.db.Query<FrequencyCluster> query = db.query(FrequencyCluster.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "FrequencyCluster");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("FrequencyCluster"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter frequencyClusterWriter = new CsvFileWriter(f);
				query.find(frequencyClusterWriter, fieldsToExport);
				frequencyClusterWriter.close();
			}
		}
	}
	
	public void exportFrequencyCluster(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter frequencyClusterWriter = new CsvFileWriter(file, notNulls);
			frequencyClusterWriter.writeHeader();
			for(Entity e: entities)
			{
				frequencyClusterWriter.writeRow((org.molgenis.util.Entity)e);
			}
			frequencyClusterWriter.close();
		}
	}
	/**
	 *	export GenotypeFrequency to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportGenotypeFrequency(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(GenotypeFrequency.class, new QueryRule("__Type",Operator.EQUALS, "GenotypeFrequency")) > 0)
		{
			
			org.molgenis.framework.db.Query<GenotypeFrequency> query = db.query(GenotypeFrequency.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "GenotypeFrequency");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("GenotypeFrequency"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter genotypeFrequencyWriter = new CsvFileWriter(f);
				query.find(genotypeFrequencyWriter, fieldsToExport);
				genotypeFrequencyWriter.close();
			}
		}
	}
	
	public void exportGenotypeFrequency(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter genotypeFrequencyWriter = new CsvFileWriter(file, notNulls);
			genotypeFrequencyWriter.writeHeader();
			for(Entity e: entities)
			{
				genotypeFrequencyWriter.writeRow((org.molgenis.util.Entity)e);
			}
			genotypeFrequencyWriter.close();
		}
	}
	/**
	 *	export AlleleFrequency to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportAlleleFrequency(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(AlleleFrequency.class, new QueryRule("__Type",Operator.EQUALS, "AlleleFrequency")) > 0)
		{
			
			org.molgenis.framework.db.Query<AlleleFrequency> query = db.query(AlleleFrequency.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "AlleleFrequency");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("AlleleFrequency"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter alleleFrequencyWriter = new CsvFileWriter(f);
				query.find(alleleFrequencyWriter, fieldsToExport);
				alleleFrequencyWriter.close();
			}
		}
	}
	
	public void exportAlleleFrequency(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter alleleFrequencyWriter = new CsvFileWriter(file, notNulls);
			alleleFrequencyWriter.writeHeader();
			for(Entity e: entities)
			{
				alleleFrequencyWriter.writeRow((org.molgenis.util.Entity)e);
			}
			alleleFrequencyWriter.close();
		}
	}
	/**
	 *	export PhenotypeValue to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportPhenotypeValue(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(PhenotypeValue.class, new QueryRule("__Type",Operator.EQUALS, "PhenotypeValue")) > 0)
		{
			
			org.molgenis.framework.db.Query<PhenotypeValue> query = db.query(PhenotypeValue.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "PhenotypeValue");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("PhenotypeValue"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter phenotypeValueWriter = new CsvFileWriter(f);
				query.find(phenotypeValueWriter, fieldsToExport);
				phenotypeValueWriter.close();
			}
		}
	}
	
	public void exportPhenotypeValue(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter phenotypeValueWriter = new CsvFileWriter(file, notNulls);
			phenotypeValueWriter.writeHeader();
			for(Entity e: entities)
			{
				phenotypeValueWriter.writeRow((org.molgenis.util.Entity)e);
			}
			phenotypeValueWriter.close();
		}
	}
}