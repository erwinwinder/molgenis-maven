/*
 * Created by: org.molgenis.generators.sql.MySqlAlterSubclassPerTableGen
 * Date: November 26, 2012
 */

/**********CREATE TABLES**********/
SET FOREIGN_KEY_CHECKS = 0; ##allows us to drop fkeyed tables

/*molgenisEntity implements autoid*/
#create the table if not exists
CREATE TABLE MolgenisEntity (
	id INTEGER NOT NULL AUTO_INCREMENT
	, name VARCHAR(255) NOT NULL
	, type_ VARCHAR(255) NOT NULL
	, className VARCHAR(255) NOT NULL
	, PRIMARY KEY(id)
	, UNIQUE(className)
	, UNIQUE(name,type_)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisEntity MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisEntity ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisEntity , MODIFY COLUMN name VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisEntity , ADD COLUMN name VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisEntity , MODIFY COLUMN type_ VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisEntity , ADD COLUMN type_ VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisEntity , MODIFY COLUMN className VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisEntity , ADD COLUMN className VARCHAR(255) NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*molgenisFile implements identifiable*/
#create the table if not exists
CREATE TABLE MolgenisFile (
	id INTEGER NOT NULL AUTO_INCREMENT
	, Identifier VARCHAR(255) NOT NULL
	, Name VARCHAR(255) NOT NULL
	, Extension VARCHAR(8) NOT NULL
	, PRIMARY KEY(id)
	, UNIQUE(Identifier)
	, UNIQUE(Name)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisFile MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisFile ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisFile , MODIFY COLUMN Identifier VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisFile , ADD COLUMN Identifier VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisFile , MODIFY COLUMN Name VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisFile , ADD COLUMN Name VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisFile , MODIFY COLUMN Extension VARCHAR(8) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisFile , ADD COLUMN Extension VARCHAR(8) NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*runtimeProperty implements identifiable*/
#create the table if not exists
CREATE TABLE RuntimeProperty (
	id INTEGER NOT NULL AUTO_INCREMENT
	, Identifier VARCHAR(255) NOT NULL
	, Name VARCHAR(255) NOT NULL
	, Value VARCHAR(127) NOT NULL
	, PRIMARY KEY(id)
	, UNIQUE(Identifier)
	, UNIQUE(Name)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE RuntimeProperty MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE RuntimeProperty ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE RuntimeProperty , MODIFY COLUMN Identifier VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE RuntimeProperty , ADD COLUMN Identifier VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE RuntimeProperty , MODIFY COLUMN Name VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE RuntimeProperty , ADD COLUMN Name VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE RuntimeProperty , MODIFY COLUMN Value VARCHAR(127) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE RuntimeProperty , ADD COLUMN Value VARCHAR(127) NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*molgenisRole implements autoid*/
#create the table if not exists
CREATE TABLE MolgenisRole (
	id INTEGER NOT NULL AUTO_INCREMENT
	, __Type ENUM('MolgenisRole','MolgenisGroup') NOT NULL
	, name VARCHAR(255) NOT NULL
	, PRIMARY KEY(id)
	, UNIQUE(name)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisRole MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisRole ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisRole , MODIFY COLUMN __Type ENUM('MolgenisRole','MolgenisGroup') NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisRole , ADD COLUMN __Type ENUM('MolgenisRole','MolgenisGroup') NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisRole , MODIFY COLUMN name VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisRole , ADD COLUMN name VARCHAR(255) NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*molgenisGroup extends molgenisRole*/
#create the table if not exists
CREATE TABLE MolgenisGroup (
	id INTEGER NOT NULL
	, PRIMARY KEY(id)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisGroup MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisGroup ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*molgenisUser implements autoid*/
#create the table if not exists
CREATE TABLE MolgenisUser (
	id INTEGER NOT NULL AUTO_INCREMENT
	, username VARCHAR(255) NOT NULL
	, password_ VARCHAR(255) NOT NULL DEFAULT "secret"
	, activationCode VARCHAR(255) NULL
	, active BOOL NOT NULL DEFAULT false
	, superuser BOOL NOT NULL DEFAULT false
	, PRIMARY KEY(id)
	, UNIQUE(username)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisUser MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisUser ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisUser , MODIFY COLUMN username VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisUser , ADD COLUMN username VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisUser , MODIFY COLUMN password_ VARCHAR(255) NOT NULL DEFAULT "secret" IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisUser , ADD COLUMN password_ VARCHAR(255) NOT NULL DEFAULT "secret" IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisUser , MODIFY COLUMN activationCode VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisUser , ADD COLUMN activationCode VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisUser , MODIFY COLUMN active BOOL NOT NULL DEFAULT false IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisUser , ADD COLUMN active BOOL NOT NULL DEFAULT false IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisUser , MODIFY COLUMN superuser BOOL NOT NULL DEFAULT false IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisUser , ADD COLUMN superuser BOOL NOT NULL DEFAULT false IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*molgenisRoleGroupLink implements identifiable*/
#create the table if not exists
CREATE TABLE MolgenisRoleGroupLink (
	id INTEGER NOT NULL AUTO_INCREMENT
	, Identifier VARCHAR(255) NOT NULL
	, Name VARCHAR(255) NOT NULL
	, group_ INTEGER NOT NULL
	, role_ INTEGER NOT NULL
	, PRIMARY KEY(id)
	, UNIQUE(Identifier)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisRoleGroupLink MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisRoleGroupLink ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisRoleGroupLink , MODIFY COLUMN Identifier VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisRoleGroupLink , ADD COLUMN Identifier VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisRoleGroupLink , MODIFY COLUMN Name VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisRoleGroupLink , ADD COLUMN Name VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisRoleGroupLink , MODIFY COLUMN group_ INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisRoleGroupLink , ADD COLUMN group_ INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisRoleGroupLink , MODIFY COLUMN role_ INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisRoleGroupLink , ADD COLUMN role_ INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*molgenisPermission implements autoid*/
#create the table if not exists
CREATE TABLE MolgenisPermission (
	id INTEGER NOT NULL AUTO_INCREMENT
	, role_ INTEGER NOT NULL
	, entity INTEGER NOT NULL
	, permission ENUM('read','write','own') NOT NULL
	, PRIMARY KEY(id)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisPermission MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisPermission ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisPermission , MODIFY COLUMN role_ INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisPermission , ADD COLUMN role_ INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisPermission , MODIFY COLUMN entity INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisPermission , ADD COLUMN entity INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisPermission , MODIFY COLUMN permission ENUM('read','write','own') NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisPermission , ADD COLUMN permission ENUM('read','write','own') NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*characteristic implements identifiable*/
#create the table if not exists
CREATE TABLE Characteristic (
	id INTEGER NOT NULL AUTO_INCREMENT
	, Identifier VARCHAR(255) NOT NULL
	, Name VARCHAR(255) NOT NULL
	, __Type ENUM('Characteristic','Individual','SamplePanel','AssayedPanel','Panel','ObservationTarget','PhenotypeProperty','UsedMarkerSet','ObservableFeature','Category','Protocol','FrequencyCluster','GenotypeFrequency','AlleleFrequency','PhenotypeMethod','Significance','EffectSize','DataSet','Genome','Chromosome','Gene','Protein','ProteinDomain','Exon','Variant') NOT NULL
	, description TEXT NULL
	, PRIMARY KEY(id)
	, UNIQUE(Identifier)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Characteristic MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Characteristic ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Characteristic , MODIFY COLUMN Identifier VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Characteristic , ADD COLUMN Identifier VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Characteristic , MODIFY COLUMN Name VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Characteristic , ADD COLUMN Name VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Characteristic , MODIFY COLUMN __Type ENUM('Characteristic','Individual','SamplePanel','AssayedPanel','Panel','ObservationTarget','PhenotypeProperty','UsedMarkerSet','ObservableFeature','Category','Protocol','FrequencyCluster','GenotypeFrequency','AlleleFrequency','PhenotypeMethod','Significance','EffectSize','DataSet','Genome','Chromosome','Gene','Protein','ProteinDomain','Exon','Variant') NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Characteristic , ADD COLUMN __Type ENUM('Characteristic','Individual','SamplePanel','AssayedPanel','Panel','ObservationTarget','PhenotypeProperty','UsedMarkerSet','ObservableFeature','Category','Protocol','FrequencyCluster','GenotypeFrequency','AlleleFrequency','PhenotypeMethod','Significance','EffectSize','DataSet','Genome','Chromosome','Gene','Protein','ProteinDomain','Exon','Variant') NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Characteristic , MODIFY COLUMN description TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Characteristic , ADD COLUMN description TEXT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*observationTarget extends characteristic*/
#create the table if not exists
CREATE TABLE ObservationTarget (
	id INTEGER NOT NULL
	, PRIMARY KEY(id)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservationTarget MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservationTarget ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*individual extends observationTarget*/
#create the table if not exists
CREATE TABLE Individual (
	Mother INTEGER NULL
	, Father INTEGER NULL
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Individual MODIFY COLUMN Mother INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Individual ADD COLUMN Mother INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Individual , MODIFY COLUMN Father INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Individual , ADD COLUMN Father INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Individual , MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Individual , ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*ontology implements identifiable*/
#create the table if not exists
CREATE TABLE Ontology (
	id INTEGER NOT NULL AUTO_INCREMENT
	, Identifier VARCHAR(255) NOT NULL
	, Name VARCHAR(255) NOT NULL
	, ontologyAccession VARCHAR(255) NULL
	, ontologyURI VARCHAR(255) NULL
	, PRIMARY KEY(id)
	, UNIQUE(Identifier)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Ontology MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Ontology ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Ontology , MODIFY COLUMN Identifier VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Ontology , ADD COLUMN Identifier VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Ontology , MODIFY COLUMN Name VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Ontology , ADD COLUMN Name VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Ontology , MODIFY COLUMN ontologyAccession VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Ontology , ADD COLUMN ontologyAccession VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Ontology , MODIFY COLUMN ontologyURI VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Ontology , ADD COLUMN ontologyURI VARCHAR(255) NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*species extends ontologyTerm*/
#create the table if not exists
CREATE TABLE Species (
	id INTEGER NOT NULL
	, PRIMARY KEY(id)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Species MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Species ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*ontologyTerm implements identifiable*/
#create the table if not exists
CREATE TABLE OntologyTerm (
	id INTEGER NOT NULL AUTO_INCREMENT
	, Identifier VARCHAR(255) NOT NULL
	, Name VARCHAR(255) NOT NULL
	, __Type ENUM('OntologyTerm','Species','Accession') NOT NULL
	, ontology INTEGER NULL
	, termAccession VARCHAR(255) NULL
	, definition VARCHAR(255) NULL
	, PRIMARY KEY(id)
	, UNIQUE(Identifier)
	, UNIQUE(ontology,termAccession)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE OntologyTerm MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE OntologyTerm ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE OntologyTerm , MODIFY COLUMN Identifier VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE OntologyTerm , ADD COLUMN Identifier VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE OntologyTerm , MODIFY COLUMN Name VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE OntologyTerm , ADD COLUMN Name VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE OntologyTerm , MODIFY COLUMN __Type ENUM('OntologyTerm','Species','Accession') NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE OntologyTerm , ADD COLUMN __Type ENUM('OntologyTerm','Species','Accession') NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE OntologyTerm , MODIFY COLUMN ontology INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE OntologyTerm , ADD COLUMN ontology INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE OntologyTerm , MODIFY COLUMN termAccession VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE OntologyTerm , ADD COLUMN termAccession VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE OntologyTerm , MODIFY COLUMN definition VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE OntologyTerm , ADD COLUMN definition VARCHAR(255) NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*accession extends ontologyTerm*/
#create the table if not exists
CREATE TABLE Accession (
	id INTEGER NOT NULL
	, PRIMARY KEY(id)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Accession MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Accession ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*observableFeature extends characteristic*/
#create the table if not exists
CREATE TABLE ObservableFeature (
	unit INTEGER NULL
	, dataType ENUM('xref','string','categorical','nominal','ordinal','date','datetime','int','code','image','decimal','bool','file','log','data','exe') NOT NULL DEFAULT "string"
	, temporal BOOL NOT NULL DEFAULT false
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservableFeature MODIFY COLUMN unit INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservableFeature ADD COLUMN unit INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservableFeature , MODIFY COLUMN dataType ENUM('xref','string','categorical','nominal','ordinal','date','datetime','int','code','image','decimal','bool','file','log','data','exe') NOT NULL DEFAULT "string" IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservableFeature , ADD COLUMN dataType ENUM('xref','string','categorical','nominal','ordinal','date','datetime','int','code','image','decimal','bool','file','log','data','exe') NOT NULL DEFAULT "string" IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservableFeature , MODIFY COLUMN temporal BOOL NOT NULL DEFAULT false IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservableFeature , ADD COLUMN temporal BOOL NOT NULL DEFAULT false IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservableFeature , MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservableFeature , ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*protocol extends characteristic*/
#create the table if not exists
CREATE TABLE Protocol (
	ProtocolType INTEGER NULL
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Protocol MODIFY COLUMN ProtocolType INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Protocol ADD COLUMN ProtocolType INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Protocol , MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Protocol , ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*dataSet extends characteristic*/
#create the table if not exists
CREATE TABLE DataSet (
	ProtocolUsed INTEGER NULL
	, startTime DATETIME NOT NULL
	, endTime DATETIME NULL
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE DataSet MODIFY COLUMN ProtocolUsed INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE DataSet ADD COLUMN ProtocolUsed INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE DataSet , MODIFY COLUMN startTime DATETIME NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE DataSet , ADD COLUMN startTime DATETIME NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE DataSet , MODIFY COLUMN endTime DATETIME NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE DataSet , ADD COLUMN endTime DATETIME NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE DataSet , MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE DataSet , ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*panel extends observationTarget*/
#create the table if not exists
CREATE TABLE Panel (
	PanelType INTEGER NULL
	, NumberOfIndividuals INTEGER NOT NULL
	, Species INTEGER NULL
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Panel MODIFY COLUMN PanelType INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Panel ADD COLUMN PanelType INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Panel , MODIFY COLUMN NumberOfIndividuals INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Panel , ADD COLUMN NumberOfIndividuals INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Panel , MODIFY COLUMN Species INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Panel , ADD COLUMN Species INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Panel , MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Panel , ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*genome extends characteristic implements bioSequence*/
#create the table if not exists
CREATE TABLE Genome (
	residues TEXT NULL
	, seqlen INTEGER NULL
	, species INTEGER NULL
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Genome MODIFY COLUMN residues TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Genome ADD COLUMN residues TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Genome , MODIFY COLUMN seqlen INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Genome , ADD COLUMN seqlen INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Genome , MODIFY COLUMN species INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Genome , ADD COLUMN species INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Genome , MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Genome , ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*chromosome extends characteristic implements bioSequence*/
#create the table if not exists
CREATE TABLE Chromosome (
	residues TEXT NULL
	, seqlen INTEGER NULL
	, genome INTEGER NOT NULL
	, orderNr INTEGER NOT NULL
	, isAutosomal BOOL NOT NULL
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Chromosome MODIFY COLUMN residues TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Chromosome ADD COLUMN residues TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Chromosome , MODIFY COLUMN seqlen INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Chromosome , ADD COLUMN seqlen INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Chromosome , MODIFY COLUMN genome INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Chromosome , ADD COLUMN genome INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Chromosome , MODIFY COLUMN orderNr INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Chromosome , ADD COLUMN orderNr INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Chromosome , MODIFY COLUMN isAutosomal BOOL NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Chromosome , ADD COLUMN isAutosomal BOOL NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Chromosome , MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Chromosome , ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*gene extends characteristic implements gdnaPosition,bioSequence*/
#create the table if not exists
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
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Gene MODIFY COLUMN gdna INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Gene ADD COLUMN gdna INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Gene , MODIFY COLUMN gdna_start INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Gene , ADD COLUMN gdna_start INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Gene , MODIFY COLUMN gdna_end INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Gene , ADD COLUMN gdna_end INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Gene , MODIFY COLUMN residues TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Gene , ADD COLUMN residues TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Gene , MODIFY COLUMN seqlen INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Gene , ADD COLUMN seqlen INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Gene , MODIFY COLUMN strand ENUM('0','-1','+1') NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Gene , ADD COLUMN strand ENUM('0','-1','+1') NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Gene , MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Gene , ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*protein extends characteristic implements cdnaPosition,bioSequence*/
#create the table if not exists
CREATE TABLE Protein (
	cdna INTEGER NULL
	, cdna_start INTEGER NULL
	, cdna_end INTEGER NULL
	, residues TEXT NULL
	, seqlen INTEGER NULL
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
	, INDEX (cdna_start)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Protein MODIFY COLUMN cdna INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Protein ADD COLUMN cdna INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Protein , MODIFY COLUMN cdna_start INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Protein , ADD COLUMN cdna_start INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Protein , MODIFY COLUMN cdna_end INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Protein , ADD COLUMN cdna_end INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Protein , MODIFY COLUMN residues TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Protein , ADD COLUMN residues TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Protein , MODIFY COLUMN seqlen INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Protein , ADD COLUMN seqlen INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Protein , MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Protein , ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*proteinDomain extends characteristic implements cdnaPosition,gdnaPosition*/
#create the table if not exists
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
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ProteinDomain MODIFY COLUMN cdna INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ProteinDomain ADD COLUMN cdna INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ProteinDomain , MODIFY COLUMN cdna_start INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ProteinDomain , ADD COLUMN cdna_start INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ProteinDomain , MODIFY COLUMN cdna_end INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ProteinDomain , ADD COLUMN cdna_end INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ProteinDomain , MODIFY COLUMN gdna INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ProteinDomain , ADD COLUMN gdna INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ProteinDomain , MODIFY COLUMN gdna_start INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ProteinDomain , ADD COLUMN gdna_start INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ProteinDomain , MODIFY COLUMN gdna_end INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ProteinDomain , ADD COLUMN gdna_end INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ProteinDomain , MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ProteinDomain , ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*exon extends characteristic implements cdnaPosition,gdnaPosition*/
#create the table if not exists
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
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Exon MODIFY COLUMN cdna INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Exon ADD COLUMN cdna INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Exon , MODIFY COLUMN cdna_start INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Exon , ADD COLUMN cdna_start INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Exon , MODIFY COLUMN cdna_end INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Exon , ADD COLUMN cdna_end INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Exon , MODIFY COLUMN gdna INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Exon , ADD COLUMN gdna INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Exon , MODIFY COLUMN gdna_start INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Exon , ADD COLUMN gdna_start INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Exon , MODIFY COLUMN gdna_end INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Exon , ADD COLUMN gdna_end INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Exon , MODIFY COLUMN isIntron BOOL NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Exon , ADD COLUMN isIntron BOOL NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Exon , MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Exon , ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*variant extends characteristic implements gdnaPosition,cdnaPosition,aaPosition*/
#create the table if not exists
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
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Variant MODIFY COLUMN gdna INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Variant ADD COLUMN gdna INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Variant , MODIFY COLUMN gdna_start INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Variant , ADD COLUMN gdna_start INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Variant , MODIFY COLUMN gdna_end INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Variant , ADD COLUMN gdna_end INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Variant , MODIFY COLUMN cdna INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Variant , ADD COLUMN cdna INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Variant , MODIFY COLUMN cdna_start INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Variant , ADD COLUMN cdna_start INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Variant , MODIFY COLUMN cdna_end INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Variant , ADD COLUMN cdna_end INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Variant , MODIFY COLUMN aa INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Variant , ADD COLUMN aa INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Variant , MODIFY COLUMN aa_start INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Variant , ADD COLUMN aa_start INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Variant , MODIFY COLUMN aa_end INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Variant , ADD COLUMN aa_end INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Variant , MODIFY COLUMN gdna_notation VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Variant , ADD COLUMN gdna_notation VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Variant , MODIFY COLUMN cdna_notation VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Variant , ADD COLUMN cdna_notation VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Variant , MODIFY COLUMN aa_notation VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Variant , ADD COLUMN aa_notation VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Variant , MODIFY COLUMN variantType INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Variant , ADD COLUMN variantType INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Variant , MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Variant , ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*institute implements autoid*/
#create the table if not exists
CREATE TABLE Institute (
	id INTEGER NOT NULL AUTO_INCREMENT
	, name VARCHAR(255) NOT NULL
	, Address TEXT NULL
	, Phone VARCHAR(255) NULL
	, City VARCHAR(255) NULL
	, Country VARCHAR(255) NULL
	, Fax VARCHAR(255) NULL
	, PRIMARY KEY(id)
	, UNIQUE(name)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Institute MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Institute ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Institute , MODIFY COLUMN name VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Institute , ADD COLUMN name VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Institute , MODIFY COLUMN Address TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Institute , ADD COLUMN Address TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Institute , MODIFY COLUMN Phone VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Institute , ADD COLUMN Phone VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Institute , MODIFY COLUMN City VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Institute , ADD COLUMN City VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Institute , MODIFY COLUMN Country VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Institute , ADD COLUMN Country VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Institute , MODIFY COLUMN Fax VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Institute , ADD COLUMN Fax VARCHAR(255) NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*person implements autoid*/
#create the table if not exists
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
	, UNIQUE(Name)
	, UNIQUE(FirstName,MidInitials,LastName)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Person MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Person ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Person , MODIFY COLUMN Name VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Person , ADD COLUMN Name VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Person , MODIFY COLUMN Title VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Person , ADD COLUMN Title VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Person , MODIFY COLUMN FirstName VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Person , ADD COLUMN FirstName VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Person , MODIFY COLUMN MidInitials VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Person , ADD COLUMN MidInitials VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Person , MODIFY COLUMN LastName VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Person , ADD COLUMN LastName VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Person , MODIFY COLUMN Email VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Person , ADD COLUMN Email VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Person , MODIFY COLUMN Phone VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Person , ADD COLUMN Phone VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Person , MODIFY COLUMN PrimaryAffilation INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Person , ADD COLUMN PrimaryAffilation INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Person , MODIFY COLUMN OrcidPersonReference INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Person , ADD COLUMN OrcidPersonReference INTEGER NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*citation implements identifiable*/
#create the table if not exists
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
	, UNIQUE(Identifier)
	, UNIQUE(PubmedID)
	, UNIQUE(DOI)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Citation MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Citation ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Citation , MODIFY COLUMN Identifier VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Citation , ADD COLUMN Identifier VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Citation , MODIFY COLUMN Name VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Citation , ADD COLUMN Name VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Citation , MODIFY COLUMN PubmedID VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Citation , ADD COLUMN PubmedID VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Citation , MODIFY COLUMN DOI VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Citation , ADD COLUMN DOI VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Citation , MODIFY COLUMN authorList TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Citation , ADD COLUMN authorList TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Citation , MODIFY COLUMN Title VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Citation , ADD COLUMN Title VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Citation , MODIFY COLUMN Description TEXT NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Citation , ADD COLUMN Description TEXT NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Citation , MODIFY COLUMN Status INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Citation , ADD COLUMN Status INTEGER NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*investigation implements identifiable*/
#create the table if not exists
CREATE TABLE Investigation (
	id INTEGER NOT NULL AUTO_INCREMENT
	, Identifier VARCHAR(255) NOT NULL
	, Name VARCHAR(255) NOT NULL
	, Title TEXT NULL
	, ShortName TEXT NULL
	, Version VARCHAR(255) NULL
	, Background TEXT NULL
	, PRIMARY KEY(id)
	, UNIQUE(Identifier)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Investigation MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Investigation ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Investigation , MODIFY COLUMN Identifier VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Investigation , ADD COLUMN Identifier VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Investigation , MODIFY COLUMN Name VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Investigation , ADD COLUMN Name VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Investigation , MODIFY COLUMN Title TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Investigation , ADD COLUMN Title TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Investigation , MODIFY COLUMN ShortName TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Investigation , ADD COLUMN ShortName TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Investigation , MODIFY COLUMN Version VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Investigation , ADD COLUMN Version VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Investigation , MODIFY COLUMN Background TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Investigation , ADD COLUMN Background TEXT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*study implements identifiable*/
#create the table if not exists
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
	, UNIQUE(Identifier)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Study MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Study ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Study , MODIFY COLUMN Identifier VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Study , ADD COLUMN Identifier VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Study , MODIFY COLUMN Name VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Study , ADD COLUMN Name VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Study , MODIFY COLUMN Description TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Study , ADD COLUMN Description TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Study , MODIFY COLUMN StartDate DATETIME NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Study , ADD COLUMN StartDate DATETIME NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Study , MODIFY COLUMN UpdateDate DATETIME NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Study , ADD COLUMN UpdateDate DATETIME NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Study , MODIFY COLUMN EndDate DATETIME NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Study , ADD COLUMN EndDate DATETIME NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Study , MODIFY COLUMN Contact INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Study , ADD COLUMN Contact INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Study , MODIFY COLUMN PartOfInvestigation INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Study , ADD COLUMN PartOfInvestigation INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*experiment implements identifiable*/
#create the table if not exists
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
	, UNIQUE(Identifier)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Experiment MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Experiment ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Experiment , MODIFY COLUMN Identifier VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Experiment , ADD COLUMN Identifier VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Experiment , MODIFY COLUMN Name VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Experiment , ADD COLUMN Name VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Experiment , MODIFY COLUMN __Type ENUM('Experiment','GWASExperiment') NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Experiment , ADD COLUMN __Type ENUM('Experiment','GWASExperiment') NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Experiment , MODIFY COLUMN Study INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Experiment , ADD COLUMN Study INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Experiment , MODIFY COLUMN Design VARCHAR(50) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Experiment , ADD COLUMN Design VARCHAR(50) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Experiment , MODIFY COLUMN ExperimentType INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Experiment , ADD COLUMN ExperimentType INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Experiment , MODIFY COLUMN TotalMarkersTested INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Experiment , ADD COLUMN TotalMarkersTested INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Experiment , MODIFY COLUMN TotalMarkersImported INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Experiment , ADD COLUMN TotalMarkersImported INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Experiment , MODIFY COLUMN Objective TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Experiment , ADD COLUMN Objective TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Experiment , MODIFY COLUMN Outcome TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Experiment , ADD COLUMN Outcome TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Experiment , MODIFY COLUMN Comments TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Experiment , ADD COLUMN Comments TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Experiment , MODIFY COLUMN IndividualDataStatement TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Experiment , ADD COLUMN IndividualDataStatement TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Experiment , MODIFY COLUMN TimeCreated DATETIME NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Experiment , ADD COLUMN TimeCreated DATETIME NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*submission implements identifiable*/
#create the table if not exists
CREATE TABLE Submission (
	id INTEGER NOT NULL AUTO_INCREMENT
	, Identifier VARCHAR(255) NOT NULL
	, Name VARCHAR(255) NOT NULL
	, TimeCreated DATETIME NOT NULL
	, Study INTEGER NOT NULL
	, PRIMARY KEY(id)
	, UNIQUE(Identifier)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Submission MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Submission ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Submission , MODIFY COLUMN Identifier VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Submission , ADD COLUMN Identifier VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Submission , MODIFY COLUMN Name VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Submission , ADD COLUMN Name VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Submission , MODIFY COLUMN TimeCreated DATETIME NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Submission , ADD COLUMN TimeCreated DATETIME NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Submission , MODIFY COLUMN Study INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Submission , ADD COLUMN Study INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*contribution implements identifiable*/
#create the table if not exists
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
	, UNIQUE(Identifier)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Contribution MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Contribution ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Contribution , MODIFY COLUMN Identifier VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Contribution , ADD COLUMN Identifier VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Contribution , MODIFY COLUMN Name VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Contribution , ADD COLUMN Name VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Contribution , MODIFY COLUMN Researcher INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Contribution , ADD COLUMN Researcher INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Contribution , MODIFY COLUMN Submission INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Contribution , ADD COLUMN Submission INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Contribution , MODIFY COLUMN IsSubmitter ENUM('yes','no') NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Contribution , ADD COLUMN IsSubmitter ENUM('yes','no') NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Contribution , MODIFY COLUMN IsAuthor ENUM('yes','no') NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Contribution , ADD COLUMN IsAuthor ENUM('yes','no') NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Contribution , MODIFY COLUMN IsSource ENUM('yes','no') NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Contribution , ADD COLUMN IsSource ENUM('yes','no') NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*studyDetails implements autoid*/
#create the table if not exists
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
	, UNIQUE(Study)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE StudyDetails MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE StudyDetails ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE StudyDetails , MODIFY COLUMN Study INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE StudyDetails , ADD COLUMN Study INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE StudyDetails , MODIFY COLUMN Title TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE StudyDetails , ADD COLUMN Title TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE StudyDetails , MODIFY COLUMN ShortName TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE StudyDetails , ADD COLUMN ShortName TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE StudyDetails , MODIFY COLUMN StudyAbstract TEXT NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE StudyDetails , ADD COLUMN StudyAbstract TEXT NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE StudyDetails , MODIFY COLUMN Version VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE StudyDetails , ADD COLUMN Version VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE StudyDetails , MODIFY COLUMN Background TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE StudyDetails , ADD COLUMN Background TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE StudyDetails , MODIFY COLUMN Objectives TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE StudyDetails , ADD COLUMN Objectives TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE StudyDetails , MODIFY COLUMN KeyResults TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE StudyDetails , ADD COLUMN KeyResults TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE StudyDetails , MODIFY COLUMN Conclusions TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE StudyDetails , ADD COLUMN Conclusions TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE StudyDetails , MODIFY COLUMN StudyDesign TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE StudyDetails , ADD COLUMN StudyDesign TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE StudyDetails , MODIFY COLUMN StudySizeReason TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE StudyDetails , ADD COLUMN StudySizeReason TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE StudyDetails , MODIFY COLUMN StudyPower TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE StudyDetails , ADD COLUMN StudyPower TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE StudyDetails , MODIFY COLUMN SourcesOfBias TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE StudyDetails , ADD COLUMN SourcesOfBias TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE StudyDetails , MODIFY COLUMN Limitations TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE StudyDetails , ADD COLUMN Limitations TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE StudyDetails , MODIFY COLUMN Acknowledgements TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE StudyDetails , ADD COLUMN Acknowledgements TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE StudyDetails , MODIFY COLUMN primaryCitation INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE StudyDetails , ADD COLUMN primaryCitation INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE StudyDetails , MODIFY COLUMN Accession VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE StudyDetails , ADD COLUMN Accession VARCHAR(255) NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*phenotypeProperty extends observableFeature implements identifiable*/
#create the table if not exists
CREATE TABLE PhenotypeProperty (
	id INTEGER NOT NULL
	, Identifier VARCHAR(255) NOT NULL
	, Name VARCHAR(100) NULL
	, PRIMARY KEY(id)
	, UNIQUE(Identifier)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE PhenotypeProperty MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE PhenotypeProperty ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE PhenotypeProperty , MODIFY COLUMN Identifier VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE PhenotypeProperty , ADD COLUMN Identifier VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE PhenotypeProperty , MODIFY COLUMN Name VARCHAR(100) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE PhenotypeProperty , ADD COLUMN Name VARCHAR(100) NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*phenotypeMethod extends dataSet implements identifiable*/
#create the table if not exists
CREATE TABLE PhenotypeMethod (
	id INTEGER NOT NULL
	, Identifier VARCHAR(255) NOT NULL
	, Name VARCHAR(255) NULL
	, StudyID INTEGER NOT NULL
	, PhenotypePropertyID INTEGER NOT NULL
	, Sample VARCHAR(100) NULL
	, PRIMARY KEY(id)
	, UNIQUE(Identifier)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE PhenotypeMethod MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE PhenotypeMethod ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE PhenotypeMethod , MODIFY COLUMN Identifier VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE PhenotypeMethod , ADD COLUMN Identifier VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE PhenotypeMethod , MODIFY COLUMN Name VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE PhenotypeMethod , ADD COLUMN Name VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE PhenotypeMethod , MODIFY COLUMN StudyID INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE PhenotypeMethod , ADD COLUMN StudyID INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE PhenotypeMethod , MODIFY COLUMN PhenotypePropertyID INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE PhenotypeMethod , ADD COLUMN PhenotypePropertyID INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE PhenotypeMethod , MODIFY COLUMN Sample VARCHAR(100) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE PhenotypeMethod , ADD COLUMN Sample VARCHAR(100) NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*samplePanel extends panel implements identifiable*/
#create the table if not exists
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
	, UNIQUE(Identifier)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE SamplePanel MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE SamplePanel ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE SamplePanel , MODIFY COLUMN Identifier VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE SamplePanel , ADD COLUMN Identifier VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE SamplePanel , MODIFY COLUMN Name VARCHAR(100) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE SamplePanel , ADD COLUMN Name VARCHAR(100) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE SamplePanel , MODIFY COLUMN CentralIdentifier INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE SamplePanel , ADD COLUMN CentralIdentifier INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE SamplePanel , MODIFY COLUMN Label VARCHAR(10) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE SamplePanel , ADD COLUMN Label VARCHAR(10) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE SamplePanel , MODIFY COLUMN Accession VARCHAR(15) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE SamplePanel , ADD COLUMN Accession VARCHAR(15) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE SamplePanel , MODIFY COLUMN AccessionVersion VARCHAR(10) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE SamplePanel , ADD COLUMN AccessionVersion VARCHAR(10) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE SamplePanel , MODIFY COLUMN Description TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE SamplePanel , ADD COLUMN Description TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE SamplePanel , MODIFY COLUMN Composition TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE SamplePanel , ADD COLUMN Composition TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE SamplePanel , MODIFY COLUMN TotalNumberOfIndividuals INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE SamplePanel , ADD COLUMN TotalNumberOfIndividuals INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE SamplePanel , MODIFY COLUMN NumberOfSexMale INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE SamplePanel , ADD COLUMN NumberOfSexMale INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE SamplePanel , MODIFY COLUMN NumberOfSexFemale INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE SamplePanel , ADD COLUMN NumberOfSexFemale INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE SamplePanel , MODIFY COLUMN NumberOfSexUnknown INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE SamplePanel , ADD COLUMN NumberOfSexUnknown INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE SamplePanel , MODIFY COLUMN NumberOfProbands INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE SamplePanel , ADD COLUMN NumberOfProbands INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE SamplePanel , MODIFY COLUMN NumberOfParents INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE SamplePanel , ADD COLUMN NumberOfParents INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE SamplePanel , MODIFY COLUMN ModeOfRecruitment VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE SamplePanel , ADD COLUMN ModeOfRecruitment VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE SamplePanel , MODIFY COLUMN DiagnosisAgeRange VARCHAR(150) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE SamplePanel , ADD COLUMN DiagnosisAgeRange VARCHAR(150) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE SamplePanel , MODIFY COLUMN DiagnosisPeriod VARCHAR(150) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE SamplePanel , ADD COLUMN DiagnosisPeriod VARCHAR(150) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE SamplePanel , MODIFY COLUMN SamplingAgeRange VARCHAR(150) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE SamplePanel , ADD COLUMN SamplingAgeRange VARCHAR(150) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE SamplePanel , MODIFY COLUMN SamplingPeriod VARCHAR(150) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE SamplePanel , ADD COLUMN SamplingPeriod VARCHAR(150) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE SamplePanel , MODIFY COLUMN PopulationInfo VARCHAR(250) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE SamplePanel , ADD COLUMN PopulationInfo VARCHAR(250) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE SamplePanel , MODIFY COLUMN GeographicRegionInfo VARCHAR(250) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE SamplePanel , ADD COLUMN GeographicRegionInfo VARCHAR(250) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE SamplePanel , MODIFY COLUMN EthnicityInfo VARCHAR(250) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE SamplePanel , ADD COLUMN EthnicityInfo VARCHAR(250) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE SamplePanel , MODIFY COLUMN BirthPlaceInfo VARCHAR(250) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE SamplePanel , ADD COLUMN BirthPlaceInfo VARCHAR(250) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE SamplePanel , MODIFY COLUMN AdmixtureInfo VARCHAR(250) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE SamplePanel , ADD COLUMN AdmixtureInfo VARCHAR(250) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE SamplePanel , MODIFY COLUMN EnvironmentInfo TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE SamplePanel , ADD COLUMN EnvironmentInfo TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE SamplePanel , MODIFY COLUMN SourceOfDNA VARCHAR(100) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE SamplePanel , ADD COLUMN SourceOfDNA VARCHAR(100) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE SamplePanel , MODIFY COLUMN DNAsArePooled ENUM('Undefined','Pre-prep','Post-prep','No') NOT NULL DEFAULT "Undefined" IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE SamplePanel , ADD COLUMN DNAsArePooled ENUM('Undefined','Pre-prep','Post-prep','No') NOT NULL DEFAULT "Undefined" IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE SamplePanel , MODIFY COLUMN DNAsAreWGA ENUM('Undefined','None','All','Some') NOT NULL DEFAULT "Undefined" IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE SamplePanel , ADD COLUMN DNAsAreWGA ENUM('Undefined','None','All','Some') NOT NULL DEFAULT "Undefined" IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*assayedPanel extends panel implements identifiable*/
#create the table if not exists
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
	, UNIQUE(Identifier)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE AssayedPanel MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE AssayedPanel ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE AssayedPanel , MODIFY COLUMN Identifier VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE AssayedPanel , ADD COLUMN Identifier VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE AssayedPanel , MODIFY COLUMN Name VARCHAR(100) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE AssayedPanel , ADD COLUMN Name VARCHAR(100) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE AssayedPanel , MODIFY COLUMN Description TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE AssayedPanel , ADD COLUMN Description TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE AssayedPanel , MODIFY COLUMN TotalNumberOfIndividuals INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE AssayedPanel , ADD COLUMN TotalNumberOfIndividuals INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE AssayedPanel , MODIFY COLUMN NumberOfSexMale INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE AssayedPanel , ADD COLUMN NumberOfSexMale INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE AssayedPanel , MODIFY COLUMN NumberOfSexFemale INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE AssayedPanel , ADD COLUMN NumberOfSexFemale INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE AssayedPanel , MODIFY COLUMN NumberOfSexUnknown INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE AssayedPanel , ADD COLUMN NumberOfSexUnknown INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE AssayedPanel , MODIFY COLUMN NumberOfProbands INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE AssayedPanel , ADD COLUMN NumberOfProbands INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE AssayedPanel , MODIFY COLUMN NumberOfParents INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE AssayedPanel , ADD COLUMN NumberOfParents INTEGER NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*panelSource implements autoid*/
#create the table if not exists
CREATE TABLE PanelSource (
	id INTEGER NOT NULL AUTO_INCREMENT
	, CurrentPanel INTEGER NOT NULL
	, SourcePanel INTEGER NOT NULL
	, NumberOfIndividuals INTEGER NULL
	, SelectionCriteria TEXT NOT NULL
	, PRIMARY KEY(id)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE PanelSource MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE PanelSource ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE PanelSource , MODIFY COLUMN CurrentPanel INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE PanelSource , ADD COLUMN CurrentPanel INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE PanelSource , MODIFY COLUMN SourcePanel INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE PanelSource , ADD COLUMN SourcePanel INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE PanelSource , MODIFY COLUMN NumberOfIndividuals INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE PanelSource , ADD COLUMN NumberOfIndividuals INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE PanelSource , MODIFY COLUMN SelectionCriteria TEXT NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE PanelSource , ADD COLUMN SelectionCriteria TEXT NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*gWASExperiment extends experiment implements identifiable*/
#create the table if not exists
CREATE TABLE GWASExperiment (
	id INTEGER NOT NULL
	, Identifier VARCHAR(255) NOT NULL
	, Name VARCHAR(255) NOT NULL
	, IndividualDataStatement TEXT NULL
	, TotalMarkersTested INTEGER NULL
	, TotalMarkersImported INTEGER NULL
	, PRIMARY KEY(id)
	, UNIQUE(Identifier)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE GWASExperiment MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE GWASExperiment ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE GWASExperiment , MODIFY COLUMN Identifier VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE GWASExperiment , ADD COLUMN Identifier VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE GWASExperiment , MODIFY COLUMN Name VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE GWASExperiment , ADD COLUMN Name VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE GWASExperiment , MODIFY COLUMN IndividualDataStatement TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE GWASExperiment , ADD COLUMN IndividualDataStatement TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE GWASExperiment , MODIFY COLUMN TotalMarkersTested INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE GWASExperiment , ADD COLUMN TotalMarkersTested INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE GWASExperiment , MODIFY COLUMN TotalMarkersImported INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE GWASExperiment , ADD COLUMN TotalMarkersImported INTEGER NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*usedMarkerSet extends observableFeature*/
#create the table if not exists
CREATE TABLE UsedMarkerSet (
	ExperimentID INTEGER NULL
	, MarkerIdentifier VARCHAR(255) NULL
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
	, UNIQUE(ExperimentID,MarkerIdentifier)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE UsedMarkerSet MODIFY COLUMN ExperimentID INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE UsedMarkerSet ADD COLUMN ExperimentID INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE UsedMarkerSet , MODIFY COLUMN MarkerIdentifier VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE UsedMarkerSet , ADD COLUMN MarkerIdentifier VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE UsedMarkerSet , MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE UsedMarkerSet , ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*category extends characteristic*/
#create the table if not exists
CREATE TABLE Category (
	observableFeature INTEGER NOT NULL
	, valueCode VARCHAR(255) NOT NULL
	, isMissing BOOL NOT NULL DEFAULT false
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Category MODIFY COLUMN observableFeature INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Category ADD COLUMN observableFeature INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Category , MODIFY COLUMN valueCode VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Category , ADD COLUMN valueCode VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Category , MODIFY COLUMN isMissing BOOL NOT NULL DEFAULT false IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Category , ADD COLUMN isMissing BOOL NOT NULL DEFAULT false IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Category , MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Category , ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*significance extends dataSet implements autoid*/
#create the table if not exists
CREATE TABLE Significance (
	id INTEGER NOT NULL
	, UsedmarkersetID INTEGER NOT NULL
	, NegLogPValue DECIMAL(65,30) NULL
	, UnadjustedPValue TEXT NULL
	, AdjustedPValue DECIMAL(65,30) NULL
	, PRIMARY KEY(id)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Significance MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Significance ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Significance , MODIFY COLUMN UsedmarkersetID INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Significance , ADD COLUMN UsedmarkersetID INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Significance , MODIFY COLUMN NegLogPValue DECIMAL(65,30) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Significance , ADD COLUMN NegLogPValue DECIMAL(65,30) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Significance , MODIFY COLUMN UnadjustedPValue TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Significance , ADD COLUMN UnadjustedPValue TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Significance , MODIFY COLUMN AdjustedPValue DECIMAL(65,30) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Significance , ADD COLUMN AdjustedPValue DECIMAL(65,30) NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*effectSize extends dataSet*/
#create the table if not exists
CREATE TABLE EffectSize (
	UsedMarkerSetID INTEGER NULL
	, Lower95Bound DECIMAL(65,30) NOT NULL
	, Upper95Bound DECIMAL(65,30) NOT NULL
	, StdError DECIMAL(65,30) NOT NULL
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE EffectSize MODIFY COLUMN UsedMarkerSetID INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE EffectSize ADD COLUMN UsedMarkerSetID INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE EffectSize , MODIFY COLUMN Lower95Bound DECIMAL(65,30) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE EffectSize , ADD COLUMN Lower95Bound DECIMAL(65,30) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE EffectSize , MODIFY COLUMN Upper95Bound DECIMAL(65,30) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE EffectSize , ADD COLUMN Upper95Bound DECIMAL(65,30) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE EffectSize , MODIFY COLUMN StdError DECIMAL(65,30) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE EffectSize , ADD COLUMN StdError DECIMAL(65,30) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE EffectSize , MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE EffectSize , ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*selectionCriteria implements autoid*/
#create the table if not exists
CREATE TABLE SelectionCriteria (
	id INTEGER NOT NULL AUTO_INCREMENT
	, SourcePanel INTEGER NOT NULL
	, TargetPanel INTEGER NOT NULL
	, NumberOfIndividuals INTEGER NOT NULL
	, Details TEXT NOT NULL
	, PRIMARY KEY(id)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE SelectionCriteria MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE SelectionCriteria ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE SelectionCriteria , MODIFY COLUMN SourcePanel INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE SelectionCriteria , ADD COLUMN SourcePanel INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE SelectionCriteria , MODIFY COLUMN TargetPanel INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE SelectionCriteria , ADD COLUMN TargetPanel INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE SelectionCriteria , MODIFY COLUMN NumberOfIndividuals INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE SelectionCriteria , ADD COLUMN NumberOfIndividuals INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE SelectionCriteria , MODIFY COLUMN Details TEXT NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE SelectionCriteria , ADD COLUMN Details TEXT NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*protocol_subprotocols*/
#create the table if not exists
CREATE TABLE Protocol_subprotocols (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, subprotocols INTEGER NOT NULL
	, Protocol INTEGER NOT NULL
	, PRIMARY KEY(autoid)
	, UNIQUE(subprotocols,Protocol)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Protocol_subprotocols MODIFY COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Protocol_subprotocols ADD COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Protocol_subprotocols , MODIFY COLUMN subprotocols INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Protocol_subprotocols , ADD COLUMN subprotocols INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Protocol_subprotocols , MODIFY COLUMN Protocol INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Protocol_subprotocols , ADD COLUMN Protocol INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*protocol_Features*/
#create the table if not exists
CREATE TABLE Protocol_Features (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, Features INTEGER NOT NULL
	, Protocol INTEGER NOT NULL
	, PRIMARY KEY(autoid)
	, UNIQUE(Features,Protocol)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Protocol_Features MODIFY COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Protocol_Features ADD COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Protocol_Features , MODIFY COLUMN Features INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Protocol_Features , ADD COLUMN Features INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Protocol_Features , MODIFY COLUMN Protocol INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Protocol_Features , ADD COLUMN Protocol INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*panel_Individuals*/
#create the table if not exists
CREATE TABLE Panel_Individuals (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, Individuals INTEGER NOT NULL
	, Panel INTEGER NOT NULL
	, PRIMARY KEY(autoid)
	, UNIQUE(Individuals,Panel)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Panel_Individuals MODIFY COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Panel_Individuals ADD COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Panel_Individuals , MODIFY COLUMN Individuals INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Panel_Individuals , ADD COLUMN Individuals INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Panel_Individuals , MODIFY COLUMN Panel INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Panel_Individuals , ADD COLUMN Panel INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*experiment_AssayedPanels*/
#create the table if not exists
CREATE TABLE Experiment_AssayedPanels (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, AssayedPanels INTEGER NOT NULL
	, Experiment INTEGER NOT NULL
	, PRIMARY KEY(autoid)
	, UNIQUE(AssayedPanels,Experiment)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Experiment_AssayedPanels MODIFY COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Experiment_AssayedPanels ADD COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Experiment_AssayedPanels , MODIFY COLUMN AssayedPanels INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Experiment_AssayedPanels , ADD COLUMN AssayedPanels INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Experiment_AssayedPanels , MODIFY COLUMN Experiment INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Experiment_AssayedPanels , ADD COLUMN Experiment INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*person_AffiliateInstitutions*/
#create the table if not exists
CREATE TABLE Person_AffiliateInstitutions (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, AffiliateInstitutions INTEGER NOT NULL
	, Person INTEGER NOT NULL
	, PRIMARY KEY(autoid)
	, UNIQUE(AffiliateInstitutions,Person)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Person_AffiliateInstitutions MODIFY COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Person_AffiliateInstitutions ADD COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Person_AffiliateInstitutions , MODIFY COLUMN AffiliateInstitutions INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Person_AffiliateInstitutions , ADD COLUMN AffiliateInstitutions INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Person_AffiliateInstitutions , MODIFY COLUMN Person INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Person_AffiliateInstitutions , ADD COLUMN Person INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*citation_ontologyTerms*/
#create the table if not exists
CREATE TABLE Citation_ontologyTerms (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, ontologyTerms INTEGER NOT NULL
	, Citation INTEGER NOT NULL
	, PRIMARY KEY(autoid)
	, UNIQUE(ontologyTerms,Citation)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Citation_ontologyTerms MODIFY COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Citation_ontologyTerms ADD COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Citation_ontologyTerms , MODIFY COLUMN ontologyTerms INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Citation_ontologyTerms , ADD COLUMN ontologyTerms INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Citation_ontologyTerms , MODIFY COLUMN Citation INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Citation_ontologyTerms , ADD COLUMN Citation INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*studyDetails_otherCitations*/
#create the table if not exists
CREATE TABLE StudyDetails_otherCitations (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, otherCitations INTEGER NOT NULL
	, StudyDetails INTEGER NOT NULL
	, PRIMARY KEY(autoid)
	, UNIQUE(otherCitations,StudyDetails)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE StudyDetails_otherCitations MODIFY COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE StudyDetails_otherCitations ADD COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE StudyDetails_otherCitations , MODIFY COLUMN otherCitations INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE StudyDetails_otherCitations , ADD COLUMN otherCitations INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE StudyDetails_otherCitations , MODIFY COLUMN StudyDetails INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE StudyDetails_otherCitations , ADD COLUMN StudyDetails INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*observationSet implements autoid*/
#create the table if not exists
CREATE TABLE ObservationSet (
	id INTEGER NOT NULL AUTO_INCREMENT
	, partOfDataSet INTEGER NOT NULL
	, Target INTEGER NOT NULL
	, Time DATETIME NULL
	, PRIMARY KEY(id)
	, UNIQUE(partOfDataSet,Target,Time)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservationSet MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservationSet ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservationSet , MODIFY COLUMN partOfDataSet INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservationSet , ADD COLUMN partOfDataSet INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservationSet , MODIFY COLUMN Target INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservationSet , ADD COLUMN Target INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservationSet , MODIFY COLUMN Time DATETIME NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservationSet , ADD COLUMN Time DATETIME NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*observedValue implements autoid*/
#create the table if not exists
CREATE TABLE ObservedValue (
	id INTEGER NOT NULL AUTO_INCREMENT
	, __Type ENUM('ObservedValue','PhenotypeValue') NOT NULL
	, ObservationSet INTEGER NOT NULL
	, Feature INTEGER NOT NULL
	, Characteristic INTEGER NULL
	, Value VARCHAR(255) NULL
	, PRIMARY KEY(id)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservedValue MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservedValue ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservedValue , MODIFY COLUMN __Type ENUM('ObservedValue','PhenotypeValue') NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservedValue , ADD COLUMN __Type ENUM('ObservedValue','PhenotypeValue') NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservedValue , MODIFY COLUMN ObservationSet INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservedValue , ADD COLUMN ObservationSet INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservedValue , MODIFY COLUMN Feature INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservedValue , ADD COLUMN Feature INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservedValue , MODIFY COLUMN Characteristic INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservedValue , ADD COLUMN Characteristic INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservedValue , MODIFY COLUMN Value VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservedValue , ADD COLUMN Value VARCHAR(255) NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*frequencyCluster extends dataSet*/
#create the table if not exists
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
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE FrequencyCluster MODIFY COLUMN DataSet INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE FrequencyCluster ADD COLUMN DataSet INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE FrequencyCluster , MODIFY COLUMN UsedMarkerSet INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE FrequencyCluster , ADD COLUMN UsedMarkerSet INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE FrequencyCluster , MODIFY COLUMN MarkerID INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE FrequencyCluster , ADD COLUMN MarkerID INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE FrequencyCluster , MODIFY COLUMN NumberOfGenotypedSamples INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE FrequencyCluster , ADD COLUMN NumberOfGenotypedSamples INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE FrequencyCluster , MODIFY COLUMN PValueHWE DECIMAL(65,30) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE FrequencyCluster , ADD COLUMN PValueHWE DECIMAL(65,30) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE FrequencyCluster , MODIFY COLUMN UnadjustedPValue DECIMAL(65,30) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE FrequencyCluster , ADD COLUMN UnadjustedPValue DECIMAL(65,30) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE FrequencyCluster , MODIFY COLUMN OddsRatioStatement VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE FrequencyCluster , ADD COLUMN OddsRatioStatement VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE FrequencyCluster , MODIFY COLUMN AttributableRiskStatement VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE FrequencyCluster , ADD COLUMN AttributableRiskStatement VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE FrequencyCluster , MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE FrequencyCluster , ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*genotypeFrequency extends dataSet*/
#create the table if not exists
CREATE TABLE GenotypeFrequency (
	FrequencyCluster INTEGER NULL
	, GenotypeCombo TEXT NULL
	, FrequencyAsProportion DECIMAL(65,30) NOT NULL
	, NumberSamplesWithGenotype INTEGER NULL
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE GenotypeFrequency MODIFY COLUMN FrequencyCluster INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE GenotypeFrequency ADD COLUMN FrequencyCluster INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE GenotypeFrequency , MODIFY COLUMN GenotypeCombo TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE GenotypeFrequency , ADD COLUMN GenotypeCombo TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE GenotypeFrequency , MODIFY COLUMN FrequencyAsProportion DECIMAL(65,30) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE GenotypeFrequency , ADD COLUMN FrequencyAsProportion DECIMAL(65,30) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE GenotypeFrequency , MODIFY COLUMN NumberSamplesWithGenotype INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE GenotypeFrequency , ADD COLUMN NumberSamplesWithGenotype INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE GenotypeFrequency , MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE GenotypeFrequency , ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*alleleFrequency extends dataSet*/
#create the table if not exists
CREATE TABLE AlleleFrequency (
	FrequencyCluster INTEGER NULL
	, AlleleCombo TEXT NULL
	, FrequencyAsProportion DECIMAL(65,30) NOT NULL
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE AlleleFrequency MODIFY COLUMN FrequencyCluster INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE AlleleFrequency ADD COLUMN FrequencyCluster INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE AlleleFrequency , MODIFY COLUMN AlleleCombo TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE AlleleFrequency , ADD COLUMN AlleleCombo TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE AlleleFrequency , MODIFY COLUMN FrequencyAsProportion DECIMAL(65,30) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE AlleleFrequency , ADD COLUMN FrequencyAsProportion DECIMAL(65,30) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE AlleleFrequency , MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE AlleleFrequency , ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*phenotypeValue extends observedValue implements identifiable*/
#create the table if not exists
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
	, UNIQUE(Identifier)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE PhenotypeValue MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE PhenotypeValue ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE PhenotypeValue , MODIFY COLUMN Identifier VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE PhenotypeValue , ADD COLUMN Identifier VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE PhenotypeValue , MODIFY COLUMN Name VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE PhenotypeValue , ADD COLUMN Name VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE PhenotypeValue , MODIFY COLUMN PhenotypePropertyID INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE PhenotypeValue , ADD COLUMN PhenotypePropertyID INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE PhenotypeValue , MODIFY COLUMN Value VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE PhenotypeValue , ADD COLUMN Value VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE PhenotypeValue , MODIFY COLUMN ValueRank VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE PhenotypeValue , ADD COLUMN ValueRank VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE PhenotypeValue , MODIFY COLUMN ValueIsMean VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE PhenotypeValue , ADD COLUMN ValueIsMean VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE PhenotypeValue , MODIFY COLUMN STD VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE PhenotypeValue , ADD COLUMN STD VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE PhenotypeValue , MODIFY COLUMN Min VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE PhenotypeValue , ADD COLUMN Min VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE PhenotypeValue , MODIFY COLUMN Max VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE PhenotypeValue , ADD COLUMN Max VARCHAR(255) NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*experiment_DataSets*/
#create the table if not exists
CREATE TABLE Experiment_DataSets (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, DataSets INTEGER NOT NULL
	, Experiment INTEGER NOT NULL
	, PRIMARY KEY(autoid)
	, UNIQUE(DataSets,Experiment)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Experiment_DataSets MODIFY COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Experiment_DataSets ADD COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Experiment_DataSets , MODIFY COLUMN DataSets INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Experiment_DataSets , ADD COLUMN DataSets INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Experiment_DataSets , MODIFY COLUMN Experiment INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Experiment_DataSets , ADD COLUMN Experiment INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns

SET FOREIGN_KEY_CHECKS = 1;

/**********ADD/UPDATE FOREIGN KEYS**********/
ALTER TABLE MolgenisGroup ADD FOREIGN KEY (id) REFERENCES MolgenisRole (id) ON DELETE RESTRICT;
ALTER TABLE ObservationTarget ADD FOREIGN KEY (id) REFERENCES Characteristic (id) ON DELETE RESTRICT;
ALTER TABLE Individual ADD FOREIGN KEY (id) REFERENCES ObservationTarget (id) ON DELETE RESTRICT;
ALTER TABLE Species ADD FOREIGN KEY (id) REFERENCES OntologyTerm (id) ON DELETE RESTRICT;
ALTER TABLE Accession ADD FOREIGN KEY (id) REFERENCES OntologyTerm (id) ON DELETE RESTRICT;
ALTER TABLE ObservableFeature ADD FOREIGN KEY (id) REFERENCES Characteristic (id) ON DELETE RESTRICT;
ALTER TABLE Protocol ADD FOREIGN KEY (id) REFERENCES Characteristic (id) ON DELETE RESTRICT;
ALTER TABLE DataSet ADD FOREIGN KEY (id) REFERENCES Characteristic (id) ON DELETE RESTRICT;
ALTER TABLE Panel ADD FOREIGN KEY (id) REFERENCES ObservationTarget (id) ON DELETE RESTRICT;
ALTER TABLE Genome ADD FOREIGN KEY (id) REFERENCES Characteristic (id) ON DELETE RESTRICT;
ALTER TABLE Chromosome ADD FOREIGN KEY (id) REFERENCES Characteristic (id) ON DELETE RESTRICT;
ALTER TABLE Gene ADD FOREIGN KEY (id) REFERENCES Characteristic (id) ON DELETE RESTRICT;
ALTER TABLE Protein ADD FOREIGN KEY (id) REFERENCES Characteristic (id) ON DELETE RESTRICT;
ALTER TABLE ProteinDomain ADD FOREIGN KEY (id) REFERENCES Characteristic (id) ON DELETE RESTRICT;
ALTER TABLE Exon ADD FOREIGN KEY (id) REFERENCES Characteristic (id) ON DELETE RESTRICT;
ALTER TABLE Variant ADD FOREIGN KEY (id) REFERENCES Characteristic (id) ON DELETE RESTRICT;
ALTER TABLE PhenotypeProperty ADD FOREIGN KEY (id) REFERENCES ObservableFeature (id) ON DELETE RESTRICT;
ALTER TABLE PhenotypeMethod ADD FOREIGN KEY (id) REFERENCES DataSet (id) ON DELETE RESTRICT;
ALTER TABLE SamplePanel ADD FOREIGN KEY (id) REFERENCES Panel (id) ON DELETE RESTRICT;
ALTER TABLE AssayedPanel ADD FOREIGN KEY (id) REFERENCES Panel (id) ON DELETE RESTRICT;
ALTER TABLE GWASExperiment ADD FOREIGN KEY (id) REFERENCES Experiment (id) ON DELETE RESTRICT;
ALTER TABLE UsedMarkerSet ADD FOREIGN KEY (id) REFERENCES ObservableFeature (id) ON DELETE RESTRICT;
ALTER TABLE Category ADD FOREIGN KEY (id) REFERENCES Characteristic (id) ON DELETE RESTRICT;
ALTER TABLE Significance ADD FOREIGN KEY (id) REFERENCES DataSet (id) ON DELETE RESTRICT;
ALTER TABLE EffectSize ADD FOREIGN KEY (id) REFERENCES DataSet (id) ON DELETE RESTRICT;
ALTER TABLE FrequencyCluster ADD FOREIGN KEY (id) REFERENCES DataSet (id) ON DELETE RESTRICT;
ALTER TABLE GenotypeFrequency ADD FOREIGN KEY (id) REFERENCES DataSet (id) ON DELETE RESTRICT;
ALTER TABLE AlleleFrequency ADD FOREIGN KEY (id) REFERENCES DataSet (id) ON DELETE RESTRICT;
ALTER TABLE PhenotypeValue ADD FOREIGN KEY (id) REFERENCES ObservedValue (id) ON DELETE RESTRICT;

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
ALTER TABLE Contribution ADD FOREIGN KEY (Submission) REFERENCES Submission (id) ON DELETE RESTRICT;
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
