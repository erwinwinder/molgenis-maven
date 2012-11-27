
/* Date:        November 26, 2012
 * 
 * generator:   org.molgenis.generators.excel.ImportWizardExcelPrognosisGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package app;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import jxl.Sheet;
import jxl.Workbook;
import org.molgenis.framework.db.Database;
import org.molgenis.framework.db.DatabaseException;
import org.molgenis.model.MolgenisModelException;
import org.molgenis.model.elements.Field;
import org.molgenis.core.MolgenisEntity;
import org.molgenis.core.excel.MolgenisEntityExcelReader;
import org.molgenis.core.MolgenisFile;
import org.molgenis.core.excel.MolgenisFileExcelReader;
import org.molgenis.core.RuntimeProperty;
import org.molgenis.core.excel.RuntimePropertyExcelReader;
import org.molgenis.auth.MolgenisRole;
import org.molgenis.auth.excel.MolgenisRoleExcelReader;
import org.molgenis.auth.MolgenisGroup;
import org.molgenis.auth.excel.MolgenisGroupExcelReader;
import org.molgenis.auth.MolgenisUser;
import org.molgenis.auth.excel.MolgenisUserExcelReader;
import org.molgenis.auth.MolgenisRoleGroupLink;
import org.molgenis.auth.excel.MolgenisRoleGroupLinkExcelReader;
import org.molgenis.auth.MolgenisPermission;
import org.molgenis.auth.excel.MolgenisPermissionExcelReader;
import org.molgenis.observ.Characteristic;
import org.molgenis.observ.excel.CharacteristicExcelReader;
import org.molgenis.observ.ObservationTarget;
import org.molgenis.observ.excel.ObservationTargetExcelReader;
import org.molgenis.observ.ObservableFeature;
import org.molgenis.observ.excel.ObservableFeatureExcelReader;
import org.molgenis.observ.Category;
import org.molgenis.observ.excel.CategoryExcelReader;
import org.molgenis.observ.Protocol;
import org.molgenis.observ.excel.ProtocolExcelReader;
import org.molgenis.observ.DataSet;
import org.molgenis.observ.excel.DataSetExcelReader;
import org.molgenis.observ.ObservationSet;
import org.molgenis.observ.excel.ObservationSetExcelReader;
import org.molgenis.observ.ObservedValue;
import org.molgenis.observ.excel.ObservedValueExcelReader;
import org.molgenis.observ.target.Species;
import org.molgenis.observ.target.excel.SpeciesExcelReader;
import org.molgenis.observ.target.Individual;
import org.molgenis.observ.target.excel.IndividualExcelReader;
import org.molgenis.observ.target.Panel;
import org.molgenis.observ.target.excel.PanelExcelReader;
import org.molgenis.observ.target.PanelSource;
import org.molgenis.observ.target.excel.PanelSourceExcelReader;
import org.molgenis.observ.target.Ontology;
import org.molgenis.observ.target.excel.OntologyExcelReader;
import org.molgenis.observ.target.OntologyTerm;
import org.molgenis.observ.target.excel.OntologyTermExcelReader;
import org.molgenis.observ.target.Accession;
import org.molgenis.observ.target.excel.AccessionExcelReader;
import org.molgenis.variant.Genome;
import org.molgenis.variant.excel.GenomeExcelReader;
import org.molgenis.variant.Chromosome;
import org.molgenis.variant.excel.ChromosomeExcelReader;
import org.molgenis.variant.Gene;
import org.molgenis.variant.excel.GeneExcelReader;
import org.molgenis.variant.Protein;
import org.molgenis.variant.excel.ProteinExcelReader;
import org.molgenis.variant.ProteinDomain;
import org.molgenis.variant.excel.ProteinDomainExcelReader;
import org.molgenis.variant.Exon;
import org.molgenis.variant.excel.ExonExcelReader;
import org.molgenis.variant.Variant;
import org.molgenis.variant.excel.VariantExcelReader;
import org.molgenis.organization.Study;
import org.molgenis.organization.excel.StudyExcelReader;
import org.molgenis.organization.Experiment;
import org.molgenis.organization.excel.ExperimentExcelReader;
import org.molgenis.organization.Institute;
import org.molgenis.organization.excel.InstituteExcelReader;
import org.molgenis.organization.Person;
import org.molgenis.organization.excel.PersonExcelReader;
import org.molgenis.organization.Citation;
import org.molgenis.organization.excel.CitationExcelReader;
import org.molgenis.organization.Contribution;
import org.molgenis.organization.excel.ContributionExcelReader;
import org.molgenis.organization.Submission;
import org.molgenis.organization.excel.SubmissionExcelReader;
import org.molgenis.gwascentral.Investigation;
import org.molgenis.gwascentral.excel.InvestigationExcelReader;
import org.molgenis.gwascentral.StudyDetails;
import org.molgenis.gwascentral.excel.StudyDetailsExcelReader;
import org.molgenis.gwascentral.FrequencyCluster;
import org.molgenis.gwascentral.excel.FrequencyClusterExcelReader;
import org.molgenis.gwascentral.GenotypeFrequency;
import org.molgenis.gwascentral.excel.GenotypeFrequencyExcelReader;
import org.molgenis.gwascentral.AlleleFrequency;
import org.molgenis.gwascentral.excel.AlleleFrequencyExcelReader;
import org.molgenis.gwascentral.PhenotypeProperty;
import org.molgenis.gwascentral.excel.PhenotypePropertyExcelReader;
import org.molgenis.gwascentral.PhenotypeMethod;
import org.molgenis.gwascentral.excel.PhenotypeMethodExcelReader;
import org.molgenis.gwascentral.PhenotypeValue;
import org.molgenis.gwascentral.excel.PhenotypeValueExcelReader;
import org.molgenis.gwascentral.SamplePanel;
import org.molgenis.gwascentral.excel.SamplePanelExcelReader;
import org.molgenis.gwascentral.AssayedPanel;
import org.molgenis.gwascentral.excel.AssayedPanelExcelReader;
import org.molgenis.gwascentral.GWASExperiment;
import org.molgenis.gwascentral.excel.GWASExperimentExcelReader;
import org.molgenis.gwascentral.UsedMarkerSet;
import org.molgenis.gwascentral.excel.UsedMarkerSetExcelReader;
import org.molgenis.gwascentral.Significance;
import org.molgenis.gwascentral.excel.SignificanceExcelReader;
import org.molgenis.gwascentral.EffectSize;
import org.molgenis.gwascentral.excel.EffectSizeExcelReader;
import org.molgenis.gwascentral.SelectionCriteria;
import org.molgenis.gwascentral.excel.SelectionCriteriaExcelReader;
import org.molgenis.observ.Protocol_Subprotocols;
import org.molgenis.observ.excel.Protocol_SubprotocolsExcelReader;
import org.molgenis.observ.Protocol_Features;
import org.molgenis.observ.excel.Protocol_FeaturesExcelReader;
import org.molgenis.observ.target.Panel_Individuals;
import org.molgenis.observ.target.excel.Panel_IndividualsExcelReader;
import org.molgenis.organization.Experiment_AssayedPanels;
import org.molgenis.organization.excel.Experiment_AssayedPanelsExcelReader;
import org.molgenis.organization.Experiment_DataSets;
import org.molgenis.organization.excel.Experiment_DataSetsExcelReader;
import org.molgenis.organization.Person_AffiliateInstitutions;
import org.molgenis.organization.excel.Person_AffiliateInstitutionsExcelReader;
import org.molgenis.organization.Citation_OntologyTerms;
import org.molgenis.organization.excel.Citation_OntologyTermsExcelReader;
import org.molgenis.gwascentral.StudyDetails_OtherCitations;
import org.molgenis.gwascentral.excel.StudyDetails_OtherCitationsExcelReader;

public class ImportWizardExcelPrognosis {

	// map of all sheets, and whether they are importable (recognized) or not
	private Map<String, Boolean> sheetsImportable = new LinkedHashMap<String, Boolean>();

	// map of importable sheets and their importable fields
	private Map<String, Collection<String>> fieldsImportable = new LinkedHashMap<String, Collection<String>>();

	// map of importable sheets and their unknown fields
	private Map<String, Collection<String>> fieldsUnknown = new LinkedHashMap<String, Collection<String>>();

	// map of importable sheets and their required/missing fields
	private Map<String, Collection<String>> fieldsRequired = new LinkedHashMap<String, Collection<String>>();
	
	// map of importable sheets and their available/optional fields
	private Map<String, Collection<String>> fieldsAvailable = new LinkedHashMap<String, Collection<String>>();
	
	// import order of the sheets
	private List<String> importOrder = new ArrayList<String>();

	public ImportWizardExcelPrognosis(Database db, File excelFile) throws Exception {

		Workbook workbook = Workbook.getWorkbook(excelFile);
		ArrayList<String> lowercasedSheetNames = new ArrayList<String>();
		Map<String, String> lowerToOriginalName = new LinkedHashMap<String, String>();

		try {

			for (String sheetName : workbook.getSheetNames()) {
				lowercasedSheetNames.add(sheetName.toLowerCase());
				lowerToOriginalName.put(sheetName.toLowerCase(), sheetName);
			}

			if (lowercasedSheetNames.contains("molgenisentity")) {
				String originalSheetname = lowerToOriginalName.get("molgenisentity");
				Sheet sheet = workbook.getSheet(originalSheetname);
				MolgenisEntityExcelReader excelReader = new MolgenisEntityExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(MolgenisEntity.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("molgenisfile")) {
				String originalSheetname = lowerToOriginalName.get("molgenisfile");
				Sheet sheet = workbook.getSheet(originalSheetname);
				MolgenisFileExcelReader excelReader = new MolgenisFileExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(MolgenisFile.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("runtimeproperty")) {
				String originalSheetname = lowerToOriginalName.get("runtimeproperty");
				Sheet sheet = workbook.getSheet(originalSheetname);
				RuntimePropertyExcelReader excelReader = new RuntimePropertyExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(RuntimeProperty.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("molgenisrole")) {
				String originalSheetname = lowerToOriginalName.get("molgenisrole");
				Sheet sheet = workbook.getSheet(originalSheetname);
				MolgenisRoleExcelReader excelReader = new MolgenisRoleExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(MolgenisRole.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("molgenisgroup")) {
				String originalSheetname = lowerToOriginalName.get("molgenisgroup");
				Sheet sheet = workbook.getSheet(originalSheetname);
				MolgenisGroupExcelReader excelReader = new MolgenisGroupExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(MolgenisGroup.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("molgenisuser")) {
				String originalSheetname = lowerToOriginalName.get("molgenisuser");
				Sheet sheet = workbook.getSheet(originalSheetname);
				MolgenisUserExcelReader excelReader = new MolgenisUserExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(MolgenisUser.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("molgenisrolegrouplink")) {
				String originalSheetname = lowerToOriginalName.get("molgenisrolegrouplink");
				Sheet sheet = workbook.getSheet(originalSheetname);
				MolgenisRoleGroupLinkExcelReader excelReader = new MolgenisRoleGroupLinkExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(MolgenisRoleGroupLink.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("molgenispermission")) {
				String originalSheetname = lowerToOriginalName.get("molgenispermission");
				Sheet sheet = workbook.getSheet(originalSheetname);
				MolgenisPermissionExcelReader excelReader = new MolgenisPermissionExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(MolgenisPermission.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("characteristic")) {
				String originalSheetname = lowerToOriginalName.get("characteristic");
				Sheet sheet = workbook.getSheet(originalSheetname);
				CharacteristicExcelReader excelReader = new CharacteristicExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(Characteristic.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("observationtarget")) {
				String originalSheetname = lowerToOriginalName.get("observationtarget");
				Sheet sheet = workbook.getSheet(originalSheetname);
				ObservationTargetExcelReader excelReader = new ObservationTargetExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(ObservationTarget.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("individual")) {
				String originalSheetname = lowerToOriginalName.get("individual");
				Sheet sheet = workbook.getSheet(originalSheetname);
				IndividualExcelReader excelReader = new IndividualExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(Individual.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("ontology")) {
				String originalSheetname = lowerToOriginalName.get("ontology");
				Sheet sheet = workbook.getSheet(originalSheetname);
				OntologyExcelReader excelReader = new OntologyExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(Ontology.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("species")) {
				String originalSheetname = lowerToOriginalName.get("species");
				Sheet sheet = workbook.getSheet(originalSheetname);
				SpeciesExcelReader excelReader = new SpeciesExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(Species.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("ontologyterm")) {
				String originalSheetname = lowerToOriginalName.get("ontologyterm");
				Sheet sheet = workbook.getSheet(originalSheetname);
				OntologyTermExcelReader excelReader = new OntologyTermExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(OntologyTerm.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("accession")) {
				String originalSheetname = lowerToOriginalName.get("accession");
				Sheet sheet = workbook.getSheet(originalSheetname);
				AccessionExcelReader excelReader = new AccessionExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(Accession.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("observablefeature")) {
				String originalSheetname = lowerToOriginalName.get("observablefeature");
				Sheet sheet = workbook.getSheet(originalSheetname);
				ObservableFeatureExcelReader excelReader = new ObservableFeatureExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(ObservableFeature.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("protocol")) {
				String originalSheetname = lowerToOriginalName.get("protocol");
				Sheet sheet = workbook.getSheet(originalSheetname);
				ProtocolExcelReader excelReader = new ProtocolExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(Protocol.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("dataset")) {
				String originalSheetname = lowerToOriginalName.get("dataset");
				Sheet sheet = workbook.getSheet(originalSheetname);
				DataSetExcelReader excelReader = new DataSetExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(DataSet.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("panel")) {
				String originalSheetname = lowerToOriginalName.get("panel");
				Sheet sheet = workbook.getSheet(originalSheetname);
				PanelExcelReader excelReader = new PanelExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(Panel.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("genome")) {
				String originalSheetname = lowerToOriginalName.get("genome");
				Sheet sheet = workbook.getSheet(originalSheetname);
				GenomeExcelReader excelReader = new GenomeExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(Genome.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("chromosome")) {
				String originalSheetname = lowerToOriginalName.get("chromosome");
				Sheet sheet = workbook.getSheet(originalSheetname);
				ChromosomeExcelReader excelReader = new ChromosomeExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(Chromosome.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("gene")) {
				String originalSheetname = lowerToOriginalName.get("gene");
				Sheet sheet = workbook.getSheet(originalSheetname);
				GeneExcelReader excelReader = new GeneExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(Gene.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("protein")) {
				String originalSheetname = lowerToOriginalName.get("protein");
				Sheet sheet = workbook.getSheet(originalSheetname);
				ProteinExcelReader excelReader = new ProteinExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(Protein.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("proteindomain")) {
				String originalSheetname = lowerToOriginalName.get("proteindomain");
				Sheet sheet = workbook.getSheet(originalSheetname);
				ProteinDomainExcelReader excelReader = new ProteinDomainExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(ProteinDomain.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("exon")) {
				String originalSheetname = lowerToOriginalName.get("exon");
				Sheet sheet = workbook.getSheet(originalSheetname);
				ExonExcelReader excelReader = new ExonExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(Exon.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("variant")) {
				String originalSheetname = lowerToOriginalName.get("variant");
				Sheet sheet = workbook.getSheet(originalSheetname);
				VariantExcelReader excelReader = new VariantExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(Variant.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("institute")) {
				String originalSheetname = lowerToOriginalName.get("institute");
				Sheet sheet = workbook.getSheet(originalSheetname);
				InstituteExcelReader excelReader = new InstituteExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(Institute.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("person")) {
				String originalSheetname = lowerToOriginalName.get("person");
				Sheet sheet = workbook.getSheet(originalSheetname);
				PersonExcelReader excelReader = new PersonExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(Person.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("citation")) {
				String originalSheetname = lowerToOriginalName.get("citation");
				Sheet sheet = workbook.getSheet(originalSheetname);
				CitationExcelReader excelReader = new CitationExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(Citation.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("investigation")) {
				String originalSheetname = lowerToOriginalName.get("investigation");
				Sheet sheet = workbook.getSheet(originalSheetname);
				InvestigationExcelReader excelReader = new InvestigationExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(Investigation.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("study")) {
				String originalSheetname = lowerToOriginalName.get("study");
				Sheet sheet = workbook.getSheet(originalSheetname);
				StudyExcelReader excelReader = new StudyExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(Study.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("experiment")) {
				String originalSheetname = lowerToOriginalName.get("experiment");
				Sheet sheet = workbook.getSheet(originalSheetname);
				ExperimentExcelReader excelReader = new ExperimentExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(Experiment.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("submission")) {
				String originalSheetname = lowerToOriginalName.get("submission");
				Sheet sheet = workbook.getSheet(originalSheetname);
				SubmissionExcelReader excelReader = new SubmissionExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(Submission.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("contribution")) {
				String originalSheetname = lowerToOriginalName.get("contribution");
				Sheet sheet = workbook.getSheet(originalSheetname);
				ContributionExcelReader excelReader = new ContributionExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(Contribution.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("studydetails")) {
				String originalSheetname = lowerToOriginalName.get("studydetails");
				Sheet sheet = workbook.getSheet(originalSheetname);
				StudyDetailsExcelReader excelReader = new StudyDetailsExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(StudyDetails.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("phenotypeproperty")) {
				String originalSheetname = lowerToOriginalName.get("phenotypeproperty");
				Sheet sheet = workbook.getSheet(originalSheetname);
				PhenotypePropertyExcelReader excelReader = new PhenotypePropertyExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(PhenotypeProperty.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("phenotypemethod")) {
				String originalSheetname = lowerToOriginalName.get("phenotypemethod");
				Sheet sheet = workbook.getSheet(originalSheetname);
				PhenotypeMethodExcelReader excelReader = new PhenotypeMethodExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(PhenotypeMethod.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("samplepanel")) {
				String originalSheetname = lowerToOriginalName.get("samplepanel");
				Sheet sheet = workbook.getSheet(originalSheetname);
				SamplePanelExcelReader excelReader = new SamplePanelExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(SamplePanel.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("assayedpanel")) {
				String originalSheetname = lowerToOriginalName.get("assayedpanel");
				Sheet sheet = workbook.getSheet(originalSheetname);
				AssayedPanelExcelReader excelReader = new AssayedPanelExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(AssayedPanel.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("panelsource")) {
				String originalSheetname = lowerToOriginalName.get("panelsource");
				Sheet sheet = workbook.getSheet(originalSheetname);
				PanelSourceExcelReader excelReader = new PanelSourceExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(PanelSource.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("gwasexperiment")) {
				String originalSheetname = lowerToOriginalName.get("gwasexperiment");
				Sheet sheet = workbook.getSheet(originalSheetname);
				GWASExperimentExcelReader excelReader = new GWASExperimentExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(GWASExperiment.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("usedmarkerset")) {
				String originalSheetname = lowerToOriginalName.get("usedmarkerset");
				Sheet sheet = workbook.getSheet(originalSheetname);
				UsedMarkerSetExcelReader excelReader = new UsedMarkerSetExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(UsedMarkerSet.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("category")) {
				String originalSheetname = lowerToOriginalName.get("category");
				Sheet sheet = workbook.getSheet(originalSheetname);
				CategoryExcelReader excelReader = new CategoryExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(Category.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("significance")) {
				String originalSheetname = lowerToOriginalName.get("significance");
				Sheet sheet = workbook.getSheet(originalSheetname);
				SignificanceExcelReader excelReader = new SignificanceExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(Significance.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("effectsize")) {
				String originalSheetname = lowerToOriginalName.get("effectsize");
				Sheet sheet = workbook.getSheet(originalSheetname);
				EffectSizeExcelReader excelReader = new EffectSizeExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(EffectSize.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("selectioncriteria")) {
				String originalSheetname = lowerToOriginalName.get("selectioncriteria");
				Sheet sheet = workbook.getSheet(originalSheetname);
				SelectionCriteriaExcelReader excelReader = new SelectionCriteriaExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(SelectionCriteria.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("protocol_subprotocols")) {
				String originalSheetname = lowerToOriginalName.get("protocol_subprotocols");
				Sheet sheet = workbook.getSheet(originalSheetname);
				Protocol_SubprotocolsExcelReader excelReader = new Protocol_SubprotocolsExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(Protocol_Subprotocols.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("protocol_features")) {
				String originalSheetname = lowerToOriginalName.get("protocol_features");
				Sheet sheet = workbook.getSheet(originalSheetname);
				Protocol_FeaturesExcelReader excelReader = new Protocol_FeaturesExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(Protocol_Features.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("panel_individuals")) {
				String originalSheetname = lowerToOriginalName.get("panel_individuals");
				Sheet sheet = workbook.getSheet(originalSheetname);
				Panel_IndividualsExcelReader excelReader = new Panel_IndividualsExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(Panel_Individuals.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("experiment_assayedpanels")) {
				String originalSheetname = lowerToOriginalName.get("experiment_assayedpanels");
				Sheet sheet = workbook.getSheet(originalSheetname);
				Experiment_AssayedPanelsExcelReader excelReader = new Experiment_AssayedPanelsExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(Experiment_AssayedPanels.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("person_affiliateinstitutions")) {
				String originalSheetname = lowerToOriginalName.get("person_affiliateinstitutions");
				Sheet sheet = workbook.getSheet(originalSheetname);
				Person_AffiliateInstitutionsExcelReader excelReader = new Person_AffiliateInstitutionsExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(Person_AffiliateInstitutions.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("citation_ontologyterms")) {
				String originalSheetname = lowerToOriginalName.get("citation_ontologyterms");
				Sheet sheet = workbook.getSheet(originalSheetname);
				Citation_OntologyTermsExcelReader excelReader = new Citation_OntologyTermsExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(Citation_OntologyTerms.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("studydetails_othercitations")) {
				String originalSheetname = lowerToOriginalName.get("studydetails_othercitations");
				Sheet sheet = workbook.getSheet(originalSheetname);
				StudyDetails_OtherCitationsExcelReader excelReader = new StudyDetails_OtherCitationsExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(StudyDetails_OtherCitations.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("observationset")) {
				String originalSheetname = lowerToOriginalName.get("observationset");
				Sheet sheet = workbook.getSheet(originalSheetname);
				ObservationSetExcelReader excelReader = new ObservationSetExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(ObservationSet.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("observedvalue")) {
				String originalSheetname = lowerToOriginalName.get("observedvalue");
				Sheet sheet = workbook.getSheet(originalSheetname);
				ObservedValueExcelReader excelReader = new ObservedValueExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(ObservedValue.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("frequencycluster")) {
				String originalSheetname = lowerToOriginalName.get("frequencycluster");
				Sheet sheet = workbook.getSheet(originalSheetname);
				FrequencyClusterExcelReader excelReader = new FrequencyClusterExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(FrequencyCluster.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("genotypefrequency")) {
				String originalSheetname = lowerToOriginalName.get("genotypefrequency");
				Sheet sheet = workbook.getSheet(originalSheetname);
				GenotypeFrequencyExcelReader excelReader = new GenotypeFrequencyExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(GenotypeFrequency.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("allelefrequency")) {
				String originalSheetname = lowerToOriginalName.get("allelefrequency");
				Sheet sheet = workbook.getSheet(originalSheetname);
				AlleleFrequencyExcelReader excelReader = new AlleleFrequencyExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(AlleleFrequency.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("phenotypevalue")) {
				String originalSheetname = lowerToOriginalName.get("phenotypevalue");
				Sheet sheet = workbook.getSheet(originalSheetname);
				PhenotypeValueExcelReader excelReader = new PhenotypeValueExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(PhenotypeValue.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			if (lowercasedSheetNames.contains("experiment_datasets")) {
				String originalSheetname = lowerToOriginalName.get("experiment_datasets");
				Sheet sheet = workbook.getSheet(originalSheetname);
				Experiment_DataSetsExcelReader excelReader = new Experiment_DataSetsExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				List<Field> entityFields = db.getMetaData().getEntity(Experiment_DataSets.class.getSimpleName()).getAllFields();
				headersToMaps(originalSheetname, allHeaders, entityFields);
			}
			
			for(String sheetName : lowerToOriginalName.values()){
				if(importOrder.contains(sheetName)){
					sheetsImportable.put(sheetName, true);
				}else{
					sheetsImportable.put(sheetName, false);
				}
			}

		} catch (Exception e) {
			throw e;
		} finally {
			workbook.close();
		}
	}
	
	public void headersToMaps(String originalSheetname, List<String> allHeaders, List<Field> entityFields)
			throws MolgenisModelException, DatabaseException
	{
		// construct a list of all required and optional fields
		Map<String, Field> requiredFields = new LinkedHashMap<String, Field>();
		Map<String, Field> availableFields = new LinkedHashMap<String, Field>();

		for (Field field : entityFields)
		{
			if (!field.isSystem() && !field.isAuto())
			{
				List<String> xrefNames = getXrefNames(field);
				String fieldName = field.getName().toLowerCase();

				// determine if this field is required or optional
				Map<String, Field> fieldMap;
				if (!field.isNillable())
				{
					if (field.getDefaultValue() == null) fieldMap = requiredFields;
					else
						fieldMap = availableFields;
				}
				else
					fieldMap = availableFields;

				// add name and xref names
				fieldMap.put(fieldName, field);
				for (String xrefName : xrefNames)
					fieldMap.put(fieldName + '_' + xrefName.toLowerCase(), field);
			}
		}

		// keep track of to-be-removed required and optional fields
		List<Field> removeRequiredFields = new ArrayList<Field>();
		List<Field> removeAvailableFields = new ArrayList<Field>();

		// collect
		List<String> detectedFieldNames = new ArrayList<String>();
		List<String> unknownFieldNames = new ArrayList<String>();
		for (String header : allHeaders)
		{
			String fieldName = header.toLowerCase();
			if (requiredFields.containsKey(fieldName))
			{
				detectedFieldNames.add(fieldName);
				// remove all references to field
				Field removedField = requiredFields.remove(fieldName);
				removeRequiredFields.add(removedField);
			}
			else if (availableFields.containsKey(fieldName))
			{
				detectedFieldNames.add(fieldName);
				// remove all references to field
				Field removedField = availableFields.remove(fieldName);
				removeAvailableFields.add(removedField);
			}
			else
			{
				unknownFieldNames.add(fieldName);
			}
		}

		for (Field field : removeRequiredFields)
		{
			for (Iterator<Entry<String, Field>> it = requiredFields.entrySet().iterator(); it.hasNext();)
			{
				Field other = it.next().getValue();
				if (field.equals(other)) it.remove();
			}
		}
		for (Field field : removeAvailableFields)
		{
			for (Iterator<Entry<String, Field>> it = availableFields.entrySet().iterator(); it.hasNext();)
			{
				Field other = it.next().getValue();
				if (field.equals(other)) it.remove();
			}
		}

		importOrder.add(originalSheetname);
		fieldsImportable.put(originalSheetname, detectedFieldNames);
		fieldsUnknown.put(originalSheetname, unknownFieldNames);
		fieldsRequired.put(originalSheetname, requiredFields.keySet());
		fieldsAvailable.put(originalSheetname, availableFields.keySet());
	}

	private List<String> getXrefNames(Field field) throws MolgenisModelException, DatabaseException
	{
		if (!field.isXRef()) return Collections.emptyList();

		List<Field> xrefFields = field.getXrefLabels();
		List<String> fieldNames = new ArrayList<String>(xrefFields.size());
		for (Field xrefField : xrefFields)
			fieldNames.add(xrefField.getName());

		return fieldNames;
	}

	public Map<String, Boolean> getSheetsImportable()
	{
		return sheetsImportable;
	}

	public Map<String, Collection<String>> getFieldsImportable()
	{
		return fieldsImportable;
	}

	public Map<String, Collection<String>> getFieldsUnknown()
	{
		return fieldsUnknown;
	}

	public Map<String, Collection<String>> getFieldsRequired()
	{
		return fieldsRequired;
	}

	public Map<String, Collection<String>> getFieldsAvailable()
	{
		return fieldsAvailable;
	}

	public List<String> getImportOrder()
	{
		return importOrder;
	}
}