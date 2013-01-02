/*
 * Created by: org.molgenis.generators.sql.MySqlCreateSubclassPerTableGen
 * Date: January 2, 2013
 */

/**********CREATE TABLES**********/
SET FOREIGN_KEY_CHECKS = 0; ##allows us to drop fkeyed tables

/*molgenisEntity implements autoid*/
DROP TABLE IF EXISTS MolgenisEntity;
CREATE TABLE MolgenisEntity (
	id INTEGER NOT NULL AUTO_INCREMENT
	, name VARCHAR(255) NOT NULL
	, type_ VARCHAR(255) NOT NULL
	, className VARCHAR(255) NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*molgenisFile implements identifiable*/
DROP TABLE IF EXISTS MolgenisFile;
CREATE TABLE MolgenisFile (
	id INTEGER NOT NULL AUTO_INCREMENT
	, Identifier VARCHAR(255) NOT NULL
	, Name VARCHAR(255) NOT NULL
	, Extension VARCHAR(8) NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*runtimeProperty implements identifiable*/
DROP TABLE IF EXISTS RuntimeProperty;
CREATE TABLE RuntimeProperty (
	id INTEGER NOT NULL AUTO_INCREMENT
	, Identifier VARCHAR(255) NOT NULL
	, Name VARCHAR(255) NOT NULL
	, Value VARCHAR(127) NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*molgenisRole implements autoid*/
DROP TABLE IF EXISTS MolgenisRole;
CREATE TABLE MolgenisRole (
	id INTEGER NOT NULL AUTO_INCREMENT
	, __Type ENUM('MolgenisRole','MolgenisGroup') NOT NULL
	, name VARCHAR(255) NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*molgenisGroup extends molgenisRole*/
DROP TABLE IF EXISTS MolgenisGroup;
CREATE TABLE MolgenisGroup (
	id INTEGER NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*molgenisUser implements autoid*/
DROP TABLE IF EXISTS MolgenisUser;
CREATE TABLE MolgenisUser (
	id INTEGER NOT NULL AUTO_INCREMENT
	, username VARCHAR(255) NOT NULL
	, password_ VARCHAR(255) NOT NULL DEFAULT "secret"
	, activationCode VARCHAR(255) NULL
	, active BOOL NOT NULL DEFAULT false
	, superuser BOOL NOT NULL DEFAULT false
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*molgenisRoleGroupLink implements identifiable*/
DROP TABLE IF EXISTS MolgenisRoleGroupLink;
CREATE TABLE MolgenisRoleGroupLink (
	id INTEGER NOT NULL AUTO_INCREMENT
	, Identifier VARCHAR(255) NOT NULL
	, Name VARCHAR(255) NOT NULL
	, group_ INTEGER NOT NULL
	, role_ INTEGER NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*molgenisPermission implements autoid*/
DROP TABLE IF EXISTS MolgenisPermission;
CREATE TABLE MolgenisPermission (
	id INTEGER NOT NULL AUTO_INCREMENT
	, role_ INTEGER NOT NULL
	, entity INTEGER NOT NULL
	, permission ENUM('read','write','own') NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*characteristic implements identifiable*/
DROP TABLE IF EXISTS Characteristic;
CREATE TABLE Characteristic (
	id INTEGER NOT NULL AUTO_INCREMENT
	, Identifier VARCHAR(255) NOT NULL
	, Name VARCHAR(255) NOT NULL
	, __Type ENUM('Characteristic','Individual','SamplePanel','AssayedPanel','Panel','ObservationTarget','PhenotypeProperty','UsedMarkerSet','ObservableFeature','Category','Protocol','FrequencyCluster','GenotypeFrequency','AlleleFrequency','PhenotypeMethod','Significance','EffectSize','DataSet','Genome','Chromosome','Gene','Protein','ProteinDomain','Exon','Variant') NOT NULL
	, description TEXT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*observationTarget extends characteristic*/
DROP TABLE IF EXISTS ObservationTarget;
CREATE TABLE ObservationTarget (
	id INTEGER NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*individual extends observationTarget*/
DROP TABLE IF EXISTS Individual;
CREATE TABLE Individual (
	Mother INTEGER NULL
	, Father INTEGER NULL
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*ontology implements identifiable*/
DROP TABLE IF EXISTS Ontology;
CREATE TABLE Ontology (
	id INTEGER NOT NULL AUTO_INCREMENT
	, Identifier VARCHAR(255) NOT NULL
	, Name VARCHAR(255) NOT NULL
	, ontologyAccession VARCHAR(255) NULL
	, ontologyURI VARCHAR(255) NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*species extends ontologyTerm*/
DROP TABLE IF EXISTS Species;
CREATE TABLE Species (
	id INTEGER NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*ontologyTerm implements identifiable*/
DROP TABLE IF EXISTS OntologyTerm;
CREATE TABLE OntologyTerm (
	id INTEGER NOT NULL AUTO_INCREMENT
	, Identifier VARCHAR(255) NOT NULL
	, Name VARCHAR(255) NOT NULL
	, __Type ENUM('OntologyTerm','Species','Accession') NOT NULL
	, ontology INTEGER NULL
	, termAccession VARCHAR(255) NULL
	, definition VARCHAR(255) NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*accession extends ontologyTerm*/
DROP TABLE IF EXISTS Accession;
CREATE TABLE Accession (
	id INTEGER NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*observableFeature extends characteristic*/
DROP TABLE IF EXISTS ObservableFeature;
CREATE TABLE ObservableFeature (
	unit INTEGER NULL
	, dataType ENUM('xref','string','categorical','nominal','ordinal','date','datetime','int','code','image','decimal','bool','file','log','data','exe') NOT NULL DEFAULT "string"
	, temporal BOOL NOT NULL DEFAULT false
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*protocol extends characteristic*/
DROP TABLE IF EXISTS Protocol;
CREATE TABLE Protocol (
	ProtocolType INTEGER NULL
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*dataSet extends characteristic*/
DROP TABLE IF EXISTS DataSet;
CREATE TABLE DataSet (
	ProtocolUsed INTEGER NULL
	, startTime DATETIME NOT NULL
	, endTime DATETIME NULL
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*panel extends observationTarget*/
DROP TABLE IF EXISTS Panel;
CREATE TABLE Panel (
	PanelType INTEGER NULL
	, NumberOfIndividuals INTEGER NOT NULL
	, Species INTEGER NULL
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*genome extends characteristic implements bioSequence*/
DROP TABLE IF EXISTS Genome;
CREATE TABLE Genome (
	residues TEXT NULL
	, seqlen INTEGER NULL
	, species INTEGER NULL
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*chromosome extends characteristic implements bioSequence*/
DROP TABLE IF EXISTS Chromosome;
CREATE TABLE Chromosome (
	residues TEXT NULL
	, seqlen INTEGER NULL
	, genome INTEGER NOT NULL
	, orderNr INTEGER NOT NULL
	, isAutosomal BOOL NOT NULL
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*gene extends characteristic implements gdnaPosition,bioSequence*/
DROP TABLE IF EXISTS Gene;
CREATE TABLE Gene (
	gdna INTEGER NULL
	, gdna_start INTEGER NULL
	, gdna_end INTEGER NULL
	, residues TEXT NULL
	, seqlen INTEGER NULL
	, strand ENUM('0','-1','+1') NOT NULL
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
	, INDEX (gdna_start)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*protein extends characteristic implements cdnaPosition,bioSequence*/
DROP TABLE IF EXISTS Protein;
CREATE TABLE Protein (
	cdna INTEGER NULL
	, cdna_start INTEGER NULL
	, cdna_end INTEGER NULL
	, residues TEXT NULL
	, seqlen INTEGER NULL
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
	, INDEX (cdna_start)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*proteinDomain extends characteristic implements cdnaPosition,gdnaPosition*/
DROP TABLE IF EXISTS ProteinDomain;
CREATE TABLE ProteinDomain (
	cdna INTEGER NULL
	, cdna_start INTEGER NULL
	, cdna_end INTEGER NULL
	, gdna INTEGER NULL
	, gdna_start INTEGER NULL
	, gdna_end INTEGER NULL
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
	, INDEX (cdna_start)
	, INDEX (gdna_start)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*exon extends characteristic implements cdnaPosition,gdnaPosition*/
DROP TABLE IF EXISTS Exon;
CREATE TABLE Exon (
	cdna INTEGER NULL
	, cdna_start INTEGER NULL
	, cdna_end INTEGER NULL
	, gdna INTEGER NULL
	, gdna_start INTEGER NULL
	, gdna_end INTEGER NULL
	, isIntron BOOL NOT NULL
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
	, INDEX (isIntron)
	, INDEX (cdna_start)
	, INDEX (gdna_start)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*variant extends characteristic implements gdnaPosition,cdnaPosition,aaPosition*/
DROP TABLE IF EXISTS Variant;
CREATE TABLE Variant (
	gdna INTEGER NULL
	, gdna_start INTEGER NULL
	, gdna_end INTEGER NULL
	, cdna INTEGER NULL
	, cdna_start INTEGER NULL
	, cdna_end INTEGER NULL
	, aa INTEGER NULL
	, aa_start INTEGER NULL
	, aa_end INTEGER NULL
	, gdna_notation VARCHAR(255) NOT NULL
	, cdna_notation VARCHAR(255) NOT NULL
	, aa_notation VARCHAR(255) NULL
	, variantType INTEGER NULL
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
	, INDEX (gdna_notation)
	, INDEX (cdna_notation)
	, INDEX (aa_notation)
	, INDEX (gdna_start)
	, INDEX (cdna_start)
	, INDEX (aa_start)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*institute implements autoid*/
DROP TABLE IF EXISTS Institute;
CREATE TABLE Institute (
	id INTEGER NOT NULL AUTO_INCREMENT
	, name VARCHAR(255) NOT NULL
	, Address TEXT NULL
	, Phone VARCHAR(255) NULL
	, City VARCHAR(255) NULL
	, Country VARCHAR(255) NULL
	, Fax VARCHAR(255) NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*person implements autoid*/
DROP TABLE IF EXISTS Person;
CREATE TABLE Person (
	id INTEGER NOT NULL AUTO_INCREMENT
	, Name VARCHAR(255) NOT NULL
	, Title VARCHAR(255) NULL
	, FirstName VARCHAR(255) NULL
	, MidInitials VARCHAR(255) NULL
	, LastName VARCHAR(255) NULL
	, Email VARCHAR(255) NULL
	, Phone VARCHAR(255) NULL
	, PrimaryAffilation INTEGER NULL
	, OrcidPersonReference INTEGER NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*citation implements identifiable*/
DROP TABLE IF EXISTS Citation;
CREATE TABLE Citation (
	id INTEGER NOT NULL AUTO_INCREMENT
	, Identifier VARCHAR(255) NOT NULL
	, Name VARCHAR(255) NOT NULL
	, PubmedID VARCHAR(255) NULL
	, DOI VARCHAR(255) NULL
	, authorList TEXT NULL
	, Title VARCHAR(255) NOT NULL
	, Description TEXT NOT NULL
	, Status INTEGER NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*investigation implements identifiable*/
DROP TABLE IF EXISTS Investigation;
CREATE TABLE Investigation (
	id INTEGER NOT NULL AUTO_INCREMENT
	, Identifier VARCHAR(255) NOT NULL
	, Name VARCHAR(255) NOT NULL
	, Title TEXT NULL
	, ShortName TEXT NULL
	, Version VARCHAR(255) NULL
	, Background TEXT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*study implements identifiable*/
DROP TABLE IF EXISTS Study;
CREATE TABLE Study (
	id INTEGER NOT NULL AUTO_INCREMENT
	, Identifier VARCHAR(255) NOT NULL
	, Name VARCHAR(255) NOT NULL
	, Description TEXT NULL
	, StartDate DATETIME NULL
	, UpdateDate DATETIME NOT NULL
	, EndDate DATETIME NULL
	, Contact INTEGER NULL
	, PartOfInvestigation INTEGER NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*experiment implements identifiable*/
DROP TABLE IF EXISTS Experiment;
CREATE TABLE Experiment (
	id INTEGER NOT NULL AUTO_INCREMENT
	, Identifier VARCHAR(255) NOT NULL
	, Name VARCHAR(255) NOT NULL
	, __Type ENUM('Experiment','GWASExperiment') NOT NULL
	, Study INTEGER NOT NULL
	, Design VARCHAR(50) NULL
	, ExperimentType INTEGER NOT NULL
	, TotalMarkersTested INTEGER NULL
	, TotalMarkersImported INTEGER NULL
	, Objective TEXT NULL
	, Outcome TEXT NULL
	, Comments TEXT NULL
	, IndividualDataStatement TEXT NULL
	, TimeCreated DATETIME NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*submission implements identifiable*/
DROP TABLE IF EXISTS Submission;
CREATE TABLE Submission (
	id INTEGER NOT NULL AUTO_INCREMENT
	, Identifier VARCHAR(255) NOT NULL
	, Name VARCHAR(255) NOT NULL
	, TimeCreated DATETIME NOT NULL
	, Study INTEGER NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*contribution implements identifiable*/
DROP TABLE IF EXISTS Contribution;
CREATE TABLE Contribution (
	id INTEGER NOT NULL AUTO_INCREMENT
	, Identifier VARCHAR(255) NOT NULL
	, Name VARCHAR(255) NOT NULL
	, Researcher INTEGER NOT NULL
	, Submission INTEGER NOT NULL
	, IsSubmitter ENUM('yes','no') NOT NULL
	, IsAuthor ENUM('yes','no') NOT NULL
	, IsSource ENUM('yes','no') NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*studyDetails implements autoid*/
DROP TABLE IF EXISTS StudyDetails;
CREATE TABLE StudyDetails (
	id INTEGER NOT NULL AUTO_INCREMENT
	, Study INTEGER NOT NULL
	, Title TEXT NULL
	, ShortName TEXT NULL
	, StudyAbstract TEXT NOT NULL
	, Version VARCHAR(255) NULL
	, Background TEXT NULL
	, Objectives TEXT NULL
	, KeyResults TEXT NULL
	, Conclusions TEXT NULL
	, StudyDesign TEXT NULL
	, StudySizeReason TEXT NULL
	, StudyPower TEXT NULL
	, SourcesOfBias TEXT NULL
	, Limitations TEXT NULL
	, Acknowledgements TEXT NULL
	, primaryCitation INTEGER NULL
	, Accession VARCHAR(255) NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*phenotypeProperty extends observableFeature implements identifiable*/
DROP TABLE IF EXISTS PhenotypeProperty;
CREATE TABLE PhenotypeProperty (
	id INTEGER NOT NULL
	, Identifier VARCHAR(255) NOT NULL
	, Name VARCHAR(100) NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*phenotypeMethod extends dataSet implements identifiable*/
DROP TABLE IF EXISTS PhenotypeMethod;
CREATE TABLE PhenotypeMethod (
	id INTEGER NOT NULL
	, Identifier VARCHAR(255) NOT NULL
	, Name VARCHAR(255) NULL
	, StudyID INTEGER NOT NULL
	, PhenotypePropertyID INTEGER NOT NULL
	, Sample VARCHAR(100) NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*samplePanel extends panel implements identifiable*/
DROP TABLE IF EXISTS SamplePanel;
CREATE TABLE SamplePanel (
	id INTEGER NOT NULL
	, Identifier VARCHAR(255) NOT NULL
	, Name VARCHAR(100) NULL
	, CentralIdentifier INTEGER NULL
	, Label VARCHAR(10) NULL
	, Accession VARCHAR(15) NULL
	, AccessionVersion VARCHAR(10) NULL
	, Description TEXT NULL
	, Composition TEXT NULL
	, TotalNumberOfIndividuals INTEGER NULL
	, NumberOfSexMale INTEGER NULL
	, NumberOfSexFemale INTEGER NULL
	, NumberOfSexUnknown INTEGER NULL
	, NumberOfProbands INTEGER NULL
	, NumberOfParents INTEGER NULL
	, ModeOfRecruitment VARCHAR(255) NULL
	, DiagnosisAgeRange VARCHAR(150) NULL
	, DiagnosisPeriod VARCHAR(150) NULL
	, SamplingAgeRange VARCHAR(150) NULL
	, SamplingPeriod VARCHAR(150) NULL
	, PopulationInfo VARCHAR(250) NULL
	, GeographicRegionInfo VARCHAR(250) NULL
	, EthnicityInfo VARCHAR(250) NULL
	, BirthPlaceInfo VARCHAR(250) NULL
	, AdmixtureInfo VARCHAR(250) NULL
	, EnvironmentInfo TEXT NULL
	, SourceOfDNA VARCHAR(100) NULL
	, DNAsArePooled ENUM('Undefined','Pre-prep','Post-prep','No') NOT NULL DEFAULT "Undefined"
	, DNAsAreWGA ENUM('Undefined','None','All','Some') NOT NULL DEFAULT "Undefined"
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*assayedPanel extends panel implements identifiable*/
DROP TABLE IF EXISTS AssayedPanel;
CREATE TABLE AssayedPanel (
	id INTEGER NOT NULL
	, Identifier VARCHAR(255) NOT NULL
	, Name VARCHAR(100) NULL
	, Description TEXT NULL
	, TotalNumberOfIndividuals INTEGER NULL
	, NumberOfSexMale INTEGER NULL
	, NumberOfSexFemale INTEGER NULL
	, NumberOfSexUnknown INTEGER NULL
	, NumberOfProbands INTEGER NULL
	, NumberOfParents INTEGER NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*panelSource implements autoid*/
DROP TABLE IF EXISTS PanelSource;
CREATE TABLE PanelSource (
	id INTEGER NOT NULL AUTO_INCREMENT
	, CurrentPanel INTEGER NOT NULL
	, SourcePanel INTEGER NOT NULL
	, NumberOfIndividuals INTEGER NULL
	, SelectionCriteria TEXT NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*gWASExperiment extends experiment implements identifiable*/
DROP TABLE IF EXISTS GWASExperiment;
CREATE TABLE GWASExperiment (
	id INTEGER NOT NULL
	, Identifier VARCHAR(255) NOT NULL
	, Name VARCHAR(255) NOT NULL
	, IndividualDataStatement TEXT NULL
	, TotalMarkersTested INTEGER NULL
	, TotalMarkersImported INTEGER NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*usedMarkerSet extends observableFeature*/
DROP TABLE IF EXISTS UsedMarkerSet;
CREATE TABLE UsedMarkerSet (
	ExperimentID INTEGER NULL
	, MarkerIdentifier VARCHAR(255) NULL
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*category extends characteristic*/
DROP TABLE IF EXISTS Category;
CREATE TABLE Category (
	observableFeature INTEGER NOT NULL
	, valueCode VARCHAR(255) NOT NULL
	, isMissing BOOL NOT NULL DEFAULT false
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*significance extends dataSet implements autoid*/
DROP TABLE IF EXISTS Significance;
CREATE TABLE Significance (
	id INTEGER NOT NULL
	, UsedmarkersetID INTEGER NOT NULL
	, NegLogPValue DECIMAL(65,30) NULL
	, UnadjustedPValue TEXT NULL
	, AdjustedPValue DECIMAL(65,30) NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*effectSize extends dataSet*/
DROP TABLE IF EXISTS EffectSize;
CREATE TABLE EffectSize (
	UsedMarkerSetID INTEGER NULL
	, Lower95Bound DECIMAL(65,30) NOT NULL
	, Upper95Bound DECIMAL(65,30) NOT NULL
	, StdError DECIMAL(65,30) NOT NULL
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*selectionCriteria implements autoid*/
DROP TABLE IF EXISTS SelectionCriteria;
CREATE TABLE SelectionCriteria (
	id INTEGER NOT NULL AUTO_INCREMENT
	, SourcePanel INTEGER NOT NULL
	, TargetPanel INTEGER NOT NULL
	, NumberOfIndividuals INTEGER NOT NULL
	, Details TEXT NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*protocol_subprotocols*/
DROP TABLE IF EXISTS Protocol_subprotocols;
CREATE TABLE Protocol_subprotocols (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, subprotocols INTEGER NOT NULL
	, Protocol INTEGER NOT NULL
	, PRIMARY KEY(autoid)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*protocol_Features*/
DROP TABLE IF EXISTS Protocol_Features;
CREATE TABLE Protocol_Features (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, Features INTEGER NOT NULL
	, Protocol INTEGER NOT NULL
	, PRIMARY KEY(autoid)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*panel_Individuals*/
DROP TABLE IF EXISTS Panel_Individuals;
CREATE TABLE Panel_Individuals (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, Individuals INTEGER NOT NULL
	, Panel INTEGER NOT NULL
	, PRIMARY KEY(autoid)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*experiment_AssayedPanels*/
DROP TABLE IF EXISTS Experiment_AssayedPanels;
CREATE TABLE Experiment_AssayedPanels (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, AssayedPanels INTEGER NOT NULL
	, Experiment INTEGER NOT NULL
	, PRIMARY KEY(autoid)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*person_AffiliateInstitutions*/
DROP TABLE IF EXISTS Person_AffiliateInstitutions;
CREATE TABLE Person_AffiliateInstitutions (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, AffiliateInstitutions INTEGER NOT NULL
	, Person INTEGER NOT NULL
	, PRIMARY KEY(autoid)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*citation_ontologyTerms*/
DROP TABLE IF EXISTS Citation_ontologyTerms;
CREATE TABLE Citation_ontologyTerms (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, ontologyTerms INTEGER NOT NULL
	, Citation INTEGER NOT NULL
	, PRIMARY KEY(autoid)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*studyDetails_otherCitations*/
DROP TABLE IF EXISTS StudyDetails_otherCitations;
CREATE TABLE StudyDetails_otherCitations (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, otherCitations INTEGER NOT NULL
	, StudyDetails INTEGER NOT NULL
	, PRIMARY KEY(autoid)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*observationSet implements autoid*/
DROP TABLE IF EXISTS ObservationSet;
CREATE TABLE ObservationSet (
	id INTEGER NOT NULL AUTO_INCREMENT
	, partOfDataSet INTEGER NOT NULL
	, Target INTEGER NOT NULL
	, Time DATETIME NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*observedValue implements autoid*/
DROP TABLE IF EXISTS ObservedValue;
CREATE TABLE ObservedValue (
	id INTEGER NOT NULL AUTO_INCREMENT
	, __Type ENUM('ObservedValue','PhenotypeValue') NOT NULL
	, ObservationSet INTEGER NOT NULL
	, Feature INTEGER NOT NULL
	, Characteristic INTEGER NULL
	, Value VARCHAR(255) NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*frequencyCluster extends dataSet*/
DROP TABLE IF EXISTS FrequencyCluster;
CREATE TABLE FrequencyCluster (
	DataSet INTEGER NULL
	, UsedMarkerSet INTEGER NOT NULL
	, MarkerID INTEGER NOT NULL
	, NumberOfGenotypedSamples INTEGER NOT NULL
	, PValueHWE DECIMAL(65,30) NULL
	, UnadjustedPValue DECIMAL(65,30) NULL
	, OddsRatioStatement VARCHAR(255) NULL
	, AttributableRiskStatement VARCHAR(255) NULL
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*genotypeFrequency extends dataSet*/
DROP TABLE IF EXISTS GenotypeFrequency;
CREATE TABLE GenotypeFrequency (
	FrequencyCluster INTEGER NULL
	, GenotypeCombo TEXT NULL
	, FrequencyAsProportion DECIMAL(65,30) NOT NULL
	, NumberSamplesWithGenotype INTEGER NULL
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*alleleFrequency extends dataSet*/
DROP TABLE IF EXISTS AlleleFrequency;
CREATE TABLE AlleleFrequency (
	FrequencyCluster INTEGER NULL
	, AlleleCombo TEXT NULL
	, FrequencyAsProportion DECIMAL(65,30) NOT NULL
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*phenotypeValue extends observedValue implements identifiable*/
DROP TABLE IF EXISTS PhenotypeValue;
CREATE TABLE PhenotypeValue (
	id INTEGER NOT NULL
	, Identifier VARCHAR(255) NOT NULL
	, Name VARCHAR(255) NULL
	, PhenotypePropertyID INTEGER NOT NULL
	, Value VARCHAR(255) NOT NULL
	, ValueRank VARCHAR(255) NOT NULL
	, ValueIsMean VARCHAR(255) NOT NULL
	, STD VARCHAR(255) NOT NULL
	, Min VARCHAR(255) NOT NULL
	, Max VARCHAR(255) NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*experiment_DataSets*/
DROP TABLE IF EXISTS Experiment_DataSets;
CREATE TABLE Experiment_DataSets (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, DataSets INTEGER NOT NULL
	, Experiment INTEGER NOT NULL
	, PRIMARY KEY(autoid)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;
SET FOREIGN_KEY_CHECKS = 1;

/**********ADD UNIQUE CONSTRANTS**********/
ALTER TABLE MolgenisEntity ADD UNIQUE className(className);
ALTER TABLE MolgenisEntity ADD UNIQUE name_type_(name,type_);
ALTER TABLE MolgenisFile ADD UNIQUE Identifier(Identifier);
ALTER TABLE MolgenisFile ADD UNIQUE Name(Name);
ALTER TABLE RuntimeProperty ADD UNIQUE Identifier(Identifier);
ALTER TABLE RuntimeProperty ADD UNIQUE Name(Name);
ALTER TABLE MolgenisRole ADD UNIQUE name(name);
ALTER TABLE MolgenisUser ADD UNIQUE username(username);
ALTER TABLE MolgenisRoleGroupLink ADD UNIQUE Identifier(Identifier);
ALTER TABLE Characteristic ADD UNIQUE Identifier(Identifier);
ALTER TABLE Ontology ADD UNIQUE Identifier(Identifier);
ALTER TABLE OntologyTerm ADD UNIQUE Identifier(Identifier);
ALTER TABLE OntologyTerm ADD UNIQUE ontology_termAccession(ontology,termAccession);
ALTER TABLE Institute ADD UNIQUE name(name);
ALTER TABLE Person ADD UNIQUE Name(Name);
ALTER TABLE Person ADD UNIQUE FirstName_MidInitials_LastName(FirstName,MidInitials,LastName);
ALTER TABLE Citation ADD UNIQUE Identifier(Identifier);
ALTER TABLE Citation ADD UNIQUE PubmedID(PubmedID);
ALTER TABLE Citation ADD UNIQUE DOI(DOI);
ALTER TABLE Investigation ADD UNIQUE Identifier(Identifier);
ALTER TABLE Study ADD UNIQUE Identifier(Identifier);
ALTER TABLE Experiment ADD UNIQUE Identifier(Identifier);
ALTER TABLE Submission ADD UNIQUE Identifier(Identifier);
ALTER TABLE Contribution ADD UNIQUE Identifier(Identifier);
ALTER TABLE StudyDetails ADD UNIQUE Study(Study);
ALTER TABLE PhenotypeProperty ADD UNIQUE Identifier(Identifier);
ALTER TABLE PhenotypeMethod ADD UNIQUE Identifier(Identifier);
ALTER TABLE SamplePanel ADD UNIQUE Identifier(Identifier);
ALTER TABLE AssayedPanel ADD UNIQUE Identifier(Identifier);
ALTER TABLE GWASExperiment ADD UNIQUE Identifier(Identifier);
ALTER TABLE UsedMarkerSet ADD UNIQUE ExperimentID_MarkerIdentifier(ExperimentID,MarkerIdentifier);
ALTER TABLE Protocol_subprotocols ADD UNIQUE subprotocols_Protocol(subprotocols,Protocol);
ALTER TABLE Protocol_Features ADD UNIQUE Features_Protocol(Features,Protocol);
ALTER TABLE Panel_Individuals ADD UNIQUE Individuals_Panel(Individuals,Panel);
ALTER TABLE Experiment_AssayedPanels ADD UNIQUE AssayedPanels_Experiment(AssayedPanels,Experiment);
ALTER TABLE Person_AffiliateInstitutions ADD UNIQUE AffiliateInstitutions_Person(AffiliateInstitutions,Person);
ALTER TABLE Citation_ontologyTerms ADD UNIQUE ontologyTerms_Citation(ontologyTerms,Citation);
ALTER TABLE StudyDetails_otherCitations ADD UNIQUE otherCitations_StudyDetails(otherCitations,StudyDetails);
ALTER TABLE ObservationSet ADD UNIQUE partOfDataSet_Target_Time(partOfDataSet,Target,Time);
ALTER TABLE PhenotypeValue ADD UNIQUE Identifier(Identifier);
ALTER TABLE Experiment_DataSets ADD UNIQUE DataSets_Experiment(DataSets,Experiment);

/**********ADD FOREIGN KEYS**********/
ALTER TABLE MolgenisGroup ADD FOREIGN KEY (id) REFERENCES MolgenisRole (id) ON DELETE CASCADE;
ALTER TABLE ObservationTarget ADD FOREIGN KEY (id) REFERENCES Characteristic (id) ON DELETE CASCADE;
ALTER TABLE Individual ADD FOREIGN KEY (id) REFERENCES ObservationTarget (id) ON DELETE CASCADE;
ALTER TABLE Species ADD FOREIGN KEY (id) REFERENCES OntologyTerm (id) ON DELETE CASCADE;
ALTER TABLE Accession ADD FOREIGN KEY (id) REFERENCES OntologyTerm (id) ON DELETE CASCADE;
ALTER TABLE ObservableFeature ADD FOREIGN KEY (id) REFERENCES Characteristic (id) ON DELETE CASCADE;
ALTER TABLE Protocol ADD FOREIGN KEY (id) REFERENCES Characteristic (id) ON DELETE CASCADE;
ALTER TABLE DataSet ADD FOREIGN KEY (id) REFERENCES Characteristic (id) ON DELETE CASCADE;
ALTER TABLE Panel ADD FOREIGN KEY (id) REFERENCES ObservationTarget (id) ON DELETE CASCADE;
ALTER TABLE Genome ADD FOREIGN KEY (id) REFERENCES Characteristic (id) ON DELETE CASCADE;
ALTER TABLE Chromosome ADD FOREIGN KEY (id) REFERENCES Characteristic (id) ON DELETE CASCADE;
ALTER TABLE Gene ADD FOREIGN KEY (id) REFERENCES Characteristic (id) ON DELETE CASCADE;
ALTER TABLE Protein ADD FOREIGN KEY (id) REFERENCES Characteristic (id) ON DELETE CASCADE;
ALTER TABLE ProteinDomain ADD FOREIGN KEY (id) REFERENCES Characteristic (id) ON DELETE CASCADE;
ALTER TABLE Exon ADD FOREIGN KEY (id) REFERENCES Characteristic (id) ON DELETE CASCADE;
ALTER TABLE Variant ADD FOREIGN KEY (id) REFERENCES Characteristic (id) ON DELETE CASCADE;
ALTER TABLE PhenotypeProperty ADD FOREIGN KEY (id) REFERENCES ObservableFeature (id) ON DELETE CASCADE;
ALTER TABLE PhenotypeMethod ADD FOREIGN KEY (id) REFERENCES DataSet (id) ON DELETE CASCADE;
ALTER TABLE SamplePanel ADD FOREIGN KEY (id) REFERENCES Panel (id) ON DELETE CASCADE;
ALTER TABLE AssayedPanel ADD FOREIGN KEY (id) REFERENCES Panel (id) ON DELETE CASCADE;
ALTER TABLE GWASExperiment ADD FOREIGN KEY (id) REFERENCES Experiment (id) ON DELETE CASCADE;
ALTER TABLE UsedMarkerSet ADD FOREIGN KEY (id) REFERENCES ObservableFeature (id) ON DELETE CASCADE;
ALTER TABLE Category ADD FOREIGN KEY (id) REFERENCES Characteristic (id) ON DELETE CASCADE;
ALTER TABLE Significance ADD FOREIGN KEY (id) REFERENCES DataSet (id) ON DELETE CASCADE;
ALTER TABLE EffectSize ADD FOREIGN KEY (id) REFERENCES DataSet (id) ON DELETE CASCADE;
ALTER TABLE FrequencyCluster ADD FOREIGN KEY (id) REFERENCES DataSet (id) ON DELETE CASCADE;
ALTER TABLE GenotypeFrequency ADD FOREIGN KEY (id) REFERENCES DataSet (id) ON DELETE CASCADE;
ALTER TABLE AlleleFrequency ADD FOREIGN KEY (id) REFERENCES DataSet (id) ON DELETE CASCADE;
ALTER TABLE PhenotypeValue ADD FOREIGN KEY (id) REFERENCES ObservedValue (id) ON DELETE CASCADE;

ALTER TABLE MolgenisRoleGroupLink ADD FOREIGN KEY (group_) REFERENCES MolgenisGroup (id) ON DELETE RESTRICT;
ALTER TABLE MolgenisRoleGroupLink ADD FOREIGN KEY (role_) REFERENCES MolgenisRole (id) ON DELETE RESTRICT;
ALTER TABLE MolgenisPermission ADD FOREIGN KEY (role_) REFERENCES MolgenisRole (id) ON DELETE RESTRICT;
ALTER TABLE MolgenisPermission ADD FOREIGN KEY (entity) REFERENCES MolgenisEntity (id) ON DELETE RESTRICT;
ALTER TABLE Individual ADD FOREIGN KEY (Mother) REFERENCES Individual (id) ON DELETE RESTRICT;
ALTER TABLE Individual ADD FOREIGN KEY (Father) REFERENCES Individual (id) ON DELETE RESTRICT;
ALTER TABLE OntologyTerm ADD FOREIGN KEY (ontology) REFERENCES Ontology (id) ON DELETE RESTRICT;
ALTER TABLE ObservableFeature ADD FOREIGN KEY (unit) REFERENCES OntologyTerm (id) ON DELETE RESTRICT;
ALTER TABLE Protocol ADD FOREIGN KEY (ProtocolType) REFERENCES OntologyTerm (id) ON DELETE RESTRICT;
ALTER TABLE DataSet ADD FOREIGN KEY (ProtocolUsed) REFERENCES Protocol (id) ON DELETE RESTRICT;
ALTER TABLE Panel ADD FOREIGN KEY (PanelType) REFERENCES OntologyTerm (id) ON DELETE RESTRICT;
ALTER TABLE Panel ADD FOREIGN KEY (Species) REFERENCES Species (id) ON DELETE RESTRICT;
ALTER TABLE Genome ADD FOREIGN KEY (species) REFERENCES Species (id) ON DELETE RESTRICT;
ALTER TABLE Chromosome ADD FOREIGN KEY (genome) REFERENCES Genome (id) ON DELETE RESTRICT;
ALTER TABLE Gene ADD FOREIGN KEY (gdna) REFERENCES Chromosome (id) ON DELETE RESTRICT;
ALTER TABLE Protein ADD FOREIGN KEY (cdna) REFERENCES Gene (id) ON DELETE RESTRICT;
ALTER TABLE ProteinDomain ADD FOREIGN KEY (cdna) REFERENCES Gene (id) ON DELETE RESTRICT;
ALTER TABLE ProteinDomain ADD FOREIGN KEY (gdna) REFERENCES Chromosome (id) ON DELETE RESTRICT;
ALTER TABLE Exon ADD FOREIGN KEY (cdna) REFERENCES Gene (id) ON DELETE RESTRICT;
ALTER TABLE Exon ADD FOREIGN KEY (gdna) REFERENCES Chromosome (id) ON DELETE RESTRICT;
ALTER TABLE Variant ADD FOREIGN KEY (gdna) REFERENCES Chromosome (id) ON DELETE RESTRICT;
ALTER TABLE Variant ADD FOREIGN KEY (cdna) REFERENCES Gene (id) ON DELETE RESTRICT;
ALTER TABLE Variant ADD FOREIGN KEY (aa) REFERENCES Protein (id) ON DELETE RESTRICT;
ALTER TABLE Variant ADD FOREIGN KEY (variantType) REFERENCES OntologyTerm (id) ON DELETE RESTRICT;
ALTER TABLE Person ADD FOREIGN KEY (PrimaryAffilation) REFERENCES Institute (id) ON DELETE RESTRICT;
ALTER TABLE Person ADD FOREIGN KEY (OrcidPersonReference) REFERENCES OntologyTerm (id) ON DELETE RESTRICT;
ALTER TABLE Citation ADD FOREIGN KEY (Status) REFERENCES OntologyTerm (id) ON DELETE RESTRICT;
ALTER TABLE Study ADD FOREIGN KEY (Contact) REFERENCES Person (id) ON DELETE RESTRICT;
ALTER TABLE Study ADD FOREIGN KEY (PartOfInvestigation) REFERENCES Investigation (id) ON DELETE RESTRICT;
ALTER TABLE Experiment ADD FOREIGN KEY (Study) REFERENCES Study (id) ON DELETE RESTRICT;
ALTER TABLE Experiment ADD FOREIGN KEY (ExperimentType) REFERENCES OntologyTerm (id) ON DELETE RESTRICT;
ALTER TABLE Submission ADD FOREIGN KEY (Study) REFERENCES Study (id) ON DELETE RESTRICT;
ALTER TABLE Contribution ADD FOREIGN KEY (Researcher) REFERENCES Person (id) ON DELETE RESTRICT;
ALTER TABLE Contribution ADD FOREIGN KEY (Submission) REFERENCES Submission (id) ON DELETE CASCADE;
ALTER TABLE StudyDetails ADD FOREIGN KEY (Study) REFERENCES Study (id) ON DELETE RESTRICT;
ALTER TABLE StudyDetails ADD FOREIGN KEY (primaryCitation) REFERENCES Citation (id) ON DELETE RESTRICT;
ALTER TABLE PhenotypeMethod ADD FOREIGN KEY (StudyID) REFERENCES Study (id) ON DELETE RESTRICT;
ALTER TABLE PhenotypeMethod ADD FOREIGN KEY (PhenotypePropertyID) REFERENCES PhenotypeProperty (id) ON DELETE RESTRICT;
ALTER TABLE SamplePanel ADD FOREIGN KEY (CentralIdentifier) REFERENCES OntologyTerm (id) ON DELETE RESTRICT;
ALTER TABLE PanelSource ADD FOREIGN KEY (CurrentPanel) REFERENCES Panel (id) ON DELETE RESTRICT;
ALTER TABLE PanelSource ADD FOREIGN KEY (SourcePanel) REFERENCES Panel (id) ON DELETE RESTRICT;
ALTER TABLE UsedMarkerSet ADD FOREIGN KEY (ExperimentID) REFERENCES Experiment (id) ON DELETE RESTRICT;
ALTER TABLE Category ADD FOREIGN KEY (observableFeature) REFERENCES ObservableFeature (id) ON DELETE RESTRICT;
ALTER TABLE Significance ADD FOREIGN KEY (UsedmarkersetID) REFERENCES UsedMarkerSet (id) ON DELETE RESTRICT;
ALTER TABLE EffectSize ADD FOREIGN KEY (UsedMarkerSetID) REFERENCES UsedMarkerSet (id) ON DELETE RESTRICT;
ALTER TABLE SelectionCriteria ADD FOREIGN KEY (SourcePanel) REFERENCES Panel (id) ON DELETE RESTRICT;
ALTER TABLE SelectionCriteria ADD FOREIGN KEY (TargetPanel) REFERENCES Panel (id) ON DELETE RESTRICT;
ALTER TABLE Protocol_subprotocols ADD FOREIGN KEY (subprotocols) REFERENCES Protocol (id) ON DELETE RESTRICT;
ALTER TABLE Protocol_subprotocols ADD FOREIGN KEY (Protocol) REFERENCES Protocol (id) ON DELETE RESTRICT;
ALTER TABLE Protocol_Features ADD FOREIGN KEY (Features) REFERENCES ObservableFeature (id) ON DELETE RESTRICT;
ALTER TABLE Protocol_Features ADD FOREIGN KEY (Protocol) REFERENCES Protocol (id) ON DELETE RESTRICT;
ALTER TABLE Panel_Individuals ADD FOREIGN KEY (Individuals) REFERENCES Individual (id) ON DELETE RESTRICT;
ALTER TABLE Panel_Individuals ADD FOREIGN KEY (Panel) REFERENCES Panel (id) ON DELETE RESTRICT;
ALTER TABLE Experiment_AssayedPanels ADD FOREIGN KEY (AssayedPanels) REFERENCES Panel (id) ON DELETE RESTRICT;
ALTER TABLE Experiment_AssayedPanels ADD FOREIGN KEY (Experiment) REFERENCES Experiment (id) ON DELETE RESTRICT;
ALTER TABLE Person_AffiliateInstitutions ADD FOREIGN KEY (AffiliateInstitutions) REFERENCES Institute (id) ON DELETE RESTRICT;
ALTER TABLE Person_AffiliateInstitutions ADD FOREIGN KEY (Person) REFERENCES Person (id) ON DELETE RESTRICT;
ALTER TABLE Citation_ontologyTerms ADD FOREIGN KEY (ontologyTerms) REFERENCES OntologyTerm (id) ON DELETE RESTRICT;
ALTER TABLE Citation_ontologyTerms ADD FOREIGN KEY (Citation) REFERENCES Citation (id) ON DELETE RESTRICT;
ALTER TABLE StudyDetails_otherCitations ADD FOREIGN KEY (otherCitations) REFERENCES Citation (id) ON DELETE RESTRICT;
ALTER TABLE StudyDetails_otherCitations ADD FOREIGN KEY (StudyDetails) REFERENCES StudyDetails (id) ON DELETE RESTRICT;
ALTER TABLE ObservationSet ADD FOREIGN KEY (partOfDataSet) REFERENCES DataSet (id) ON DELETE RESTRICT;
ALTER TABLE ObservationSet ADD FOREIGN KEY (Target) REFERENCES Characteristic (id) ON DELETE RESTRICT;
ALTER TABLE ObservedValue ADD FOREIGN KEY (ObservationSet) REFERENCES ObservationSet (id) ON DELETE RESTRICT;
ALTER TABLE ObservedValue ADD FOREIGN KEY (Feature) REFERENCES ObservableFeature (id) ON DELETE RESTRICT;
ALTER TABLE ObservedValue ADD FOREIGN KEY (Characteristic) REFERENCES Characteristic (id) ON DELETE RESTRICT;
ALTER TABLE FrequencyCluster ADD FOREIGN KEY (DataSet) REFERENCES DataSet (id) ON DELETE RESTRICT;
ALTER TABLE FrequencyCluster ADD FOREIGN KEY (UsedMarkerSet) REFERENCES UsedMarkerSet (id) ON DELETE RESTRICT;
ALTER TABLE GenotypeFrequency ADD FOREIGN KEY (FrequencyCluster) REFERENCES FrequencyCluster (id) ON DELETE RESTRICT;
ALTER TABLE AlleleFrequency ADD FOREIGN KEY (FrequencyCluster) REFERENCES FrequencyCluster (id) ON DELETE RESTRICT;
ALTER TABLE PhenotypeValue ADD FOREIGN KEY (PhenotypePropertyID) REFERENCES PhenotypeProperty (id) ON DELETE RESTRICT;
ALTER TABLE Experiment_DataSets ADD FOREIGN KEY (DataSets) REFERENCES DataSet (id) ON DELETE RESTRICT;
ALTER TABLE Experiment_DataSets ADD FOREIGN KEY (Experiment) REFERENCES Experiment (id) ON DELETE RESTRICT;

