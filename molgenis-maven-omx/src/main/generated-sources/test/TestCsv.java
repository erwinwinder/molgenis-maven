/* File:        app/JUnitTest.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 26, 2012
 * 
 * generator:   org.molgenis.generators.tests.TestCsvGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package test;

import app.CsvExport;
import app.CsvImport;
import app.DatabaseFactory;

import app.JDBCDatabase;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Arrays;

import org.apache.log4j.Logger;

import org.molgenis.Molgenis;
import org.molgenis.util.*;
import org.molgenis.framework.db.Database;
import org.molgenis.framework.db.Query;
import org.molgenis.framework.db.DatabaseException;

import static  org.testng.AssertJUnit.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.molgenis.core.Autoid;
import org.molgenis.core.Identifiable;
import org.molgenis.core.MolgenisEntity;
import org.molgenis.core.MolgenisFile;
import org.molgenis.core.RuntimeProperty;
import org.molgenis.auth.MolgenisRole;
import org.molgenis.auth.MolgenisGroup;
import org.molgenis.auth.MolgenisUser;
import org.molgenis.auth.MolgenisRoleGroupLink;
import org.molgenis.auth.MolgenisPermission;
import org.molgenis.auth.Authorizable;
import org.molgenis.observ.Characteristic;
import org.molgenis.observ.ObservationTarget;
import org.molgenis.observ.ObservableFeature;
import org.molgenis.observ.Category;
import org.molgenis.observ.Protocol;
import org.molgenis.observ.DataSet;
import org.molgenis.observ.ObservationSet;
import org.molgenis.observ.ObservedValue;
import org.molgenis.observ.target.Species;
import org.molgenis.observ.target.Individual;
import org.molgenis.observ.target.Panel;
import org.molgenis.observ.target.PanelSource;
import org.molgenis.observ.target.Ontology;
import org.molgenis.observ.target.OntologyTerm;
import org.molgenis.observ.target.Accession;
import org.molgenis.variant.BioSequence;
import org.molgenis.variant.GdnaPosition;
import org.molgenis.variant.CdnaPosition;
import org.molgenis.variant.AaPosition;
import org.molgenis.variant.Genome;
import org.molgenis.variant.Chromosome;
import org.molgenis.variant.Gene;
import org.molgenis.variant.Protein;
import org.molgenis.variant.ProteinDomain;
import org.molgenis.variant.Exon;
import org.molgenis.variant.Variant;
import org.molgenis.organization.Study;
import org.molgenis.organization.Experiment;
import org.molgenis.organization.Institute;
import org.molgenis.organization.Person;
import org.molgenis.organization.Citation;
import org.molgenis.organization.Contribution;
import org.molgenis.organization.Submission;
import org.molgenis.gwascentral.Investigation;
import org.molgenis.gwascentral.StudyDetails;
import org.molgenis.gwascentral.FrequencyCluster;
import org.molgenis.gwascentral.GenotypeFrequency;
import org.molgenis.gwascentral.AlleleFrequency;
import org.molgenis.gwascentral.PhenotypeProperty;
import org.molgenis.gwascentral.PhenotypeMethod;
import org.molgenis.gwascentral.PhenotypeValue;
import org.molgenis.gwascentral.SamplePanel;
import org.molgenis.gwascentral.AssayedPanel;
import org.molgenis.gwascentral.GWASExperiment;
import org.molgenis.gwascentral.UsedMarkerSet;
import org.molgenis.gwascentral.Significance;
import org.molgenis.gwascentral.EffectSize;
import org.molgenis.gwascentral.SelectionCriteria;
import org.molgenis.observ.Protocol_Subprotocols;
import org.molgenis.observ.Protocol_Features;
import org.molgenis.observ.target.Panel_Individuals;
import org.molgenis.organization.Experiment_AssayedPanels;
import org.molgenis.organization.Experiment_DataSets;
import org.molgenis.organization.Person_AffiliateInstitutions;
import org.molgenis.organization.Citation_OntologyTerms;
import org.molgenis.gwascentral.StudyDetails_OtherCitations;

/**
 * This procecure tests file import and export
 * - create csv set1 in tmp
 * - TEST load set1 via CsvImport (should be error free)
 * - export it to set2 via CsvExport
 * - query all of set1 into memory (as lists)
 * - empty the database
 * - import set2 via CsvImport
 * - query all of set2 into memory (as lists)
 * - TEST set1 and set2 should be 'Set' equivalent 
 * - export it to set3 via CsvExport
 * - TEST files of set2 and set3 to be identical on disk
 */
public class TestCsv
{
	private static int total = 10;
	private static Database db;
	private static final Logger logger = Logger.getLogger(TestCsv.class);
	DateFormat dateFormat = new SimpleDateFormat(SimpleTuple.DATEFORMAT, Locale.US);
	DateFormat dateTimeFormat = new SimpleDateFormat(SimpleTuple.DATETIMEFORMAT, Locale.US);	 

	
	@BeforeClass
	public static void oneTimeSetUp()   
	{
		try
		{
        		
			db = DatabaseFactory.createTest("src/main/resources/org/molgenis/omicsconnect/omicsconnect.properties");
			new Molgenis("src/main/resources/org/molgenis/omicsconnect/omicsconnect.properties");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		logger.info("Database created");
	}

	@AfterClass
	public static void destory() {
            
	}
	
	@Test
	public void testCsv1()  throws Exception
	{	
		//create tem working directory
		File dir = File.createTempFile("molgenis","");		
		dir.delete(); //delete the file, need dir
		
		//create a test set1
        TestDataSet set1 = new TestDataSet(50,5);
                



		//export set1 from memory to dir1
		File dir1 = new File(dir + "/dir1");
		dir1.mkdirs();
		new CsvExport().exportAll(dir1, set1.autoid,set1.identifiable,set1.molgenisEntity,set1.molgenisFile,set1.runtimeProperty,set1.molgenisRole,set1.molgenisGroup,set1.molgenisUser,set1.molgenisRoleGroupLink,set1.molgenisPermission,set1.authorizable,set1.characteristic,set1.observationTarget,set1.observableFeature,set1.category,set1.protocol,set1.dataSet,set1.observationSet,set1.observedValue,set1.species,set1.individual,set1.panel,set1.panelSource,set1.ontology,set1.ontologyTerm,set1.accession,set1.bioSequence,set1.gdnaPosition,set1.cdnaPosition,set1.aaPosition,set1.genome,set1.chromosome,set1.gene,set1.protein,set1.proteinDomain,set1.exon,set1.variant,set1.study,set1.experiment,set1.institute,set1.person,set1.citation,set1.contribution,set1.submission,set1.investigation,set1.studyDetails,set1.frequencyCluster,set1.genotypeFrequency,set1.alleleFrequency,set1.phenotypeProperty,set1.phenotypeMethod,set1.phenotypeValue,set1.samplePanel,set1.assayedPanel,set1.gWASExperiment,set1.usedMarkerSet,set1.significance,set1.effectSize,set1.selectionCriteria,set1.protocol_subprotocols,set1.protocol_Features,set1.panel_Individuals,set1.experiment_AssayedPanels,set1.experiment_DataSets,set1.person_AffiliateInstitutions,set1.citation_ontologyTerms,set1.studyDetails_otherCitations);
	
		//import dir1 into database
		new CsvImport().importAll(dir1, db, null);
		
		//copy database into memory as set2
		TestDataSet set2 = copyDb(db);
		
		//TODO compare set1 and set2 except automatic fields
		
		//export set1 from database to dir2
		File dir2 = new File(dir + "/dir2");
		dir2.mkdirs();
		new CsvExport().exportAll(dir2,db);
	
		//clean database
			new Molgenis("src/main/resources/org/molgenis/omicsconnect/omicsconnect.properties").updateDb();
		
		//import dir2 into database
		new CsvImport().importAll(dir2, db, null);
		
		//copy database into memory as set3
		TestDataSet set3 = copyDb(db);

		//TODO compare set2 and set3			
		
		//export database to dir3
		File dir3 = new File(dir + "/dir3");
		dir3.mkdirs();
		new CsvExport().exportAll(dir3,db);
		
		//clean database
			new Molgenis("src/main/resources/org/molgenis/omicsconnect/omicsconnect.properties").updateDb();
		
		//import dir3 into database
		new CsvImport().importAll(dir3, db, null);
		
		//copy database into memory as set4
		TestDataSet set4 = copyDb(db);

		//TODO compare set3 and set4			
		
		//export database to dir4
		File dir4 = new File(dir + "/dir4");
		dir4.mkdirs();
		new CsvExport().exportAll(dir4,db);
		
		//compare dir3 and dir4 cause should be equals because roundtrip
		logger.debug("Comparing "+dir3+" to "+dir4);
//		assertTrue(compareDirs(dir3,dir4));
//		assertEquals(set3,set4);
	}
	
	private TestDataSet copyDb(Database db) throws DatabaseException
	{
		TestDataSet copy = new TestDataSet();
		copy.molgenisEntity = db.find(MolgenisEntity.class);
		copy.molgenisFile = db.find(MolgenisFile.class);
		copy.runtimeProperty = db.find(RuntimeProperty.class);
		copy.molgenisRole = db.find(MolgenisRole.class);
		copy.molgenisGroup = db.find(MolgenisGroup.class);
		copy.molgenisUser = db.find(MolgenisUser.class);
		copy.molgenisRoleGroupLink = db.find(MolgenisRoleGroupLink.class);
		copy.molgenisPermission = db.find(MolgenisPermission.class);
		copy.characteristic = db.find(Characteristic.class);
		copy.observationTarget = db.find(ObservationTarget.class);
		copy.observableFeature = db.find(ObservableFeature.class);
		copy.category = db.find(Category.class);
		copy.protocol = db.find(Protocol.class);
		copy.dataSet = db.find(DataSet.class);
		copy.observationSet = db.find(ObservationSet.class);
		copy.observedValue = db.find(ObservedValue.class);
		copy.species = db.find(Species.class);
		copy.individual = db.find(Individual.class);
		copy.panel = db.find(Panel.class);
		copy.panelSource = db.find(PanelSource.class);
		copy.ontology = db.find(Ontology.class);
		copy.ontologyTerm = db.find(OntologyTerm.class);
		copy.accession = db.find(Accession.class);
		copy.genome = db.find(Genome.class);
		copy.chromosome = db.find(Chromosome.class);
		copy.gene = db.find(Gene.class);
		copy.protein = db.find(Protein.class);
		copy.proteinDomain = db.find(ProteinDomain.class);
		copy.exon = db.find(Exon.class);
		copy.variant = db.find(Variant.class);
		copy.study = db.find(Study.class);
		copy.experiment = db.find(Experiment.class);
		copy.institute = db.find(Institute.class);
		copy.person = db.find(Person.class);
		copy.citation = db.find(Citation.class);
		copy.contribution = db.find(Contribution.class);
		copy.submission = db.find(Submission.class);
		copy.investigation = db.find(Investigation.class);
		copy.studyDetails = db.find(StudyDetails.class);
		copy.frequencyCluster = db.find(FrequencyCluster.class);
		copy.genotypeFrequency = db.find(GenotypeFrequency.class);
		copy.alleleFrequency = db.find(AlleleFrequency.class);
		copy.phenotypeProperty = db.find(PhenotypeProperty.class);
		copy.phenotypeMethod = db.find(PhenotypeMethod.class);
		copy.phenotypeValue = db.find(PhenotypeValue.class);
		copy.samplePanel = db.find(SamplePanel.class);
		copy.assayedPanel = db.find(AssayedPanel.class);
		copy.gWASExperiment = db.find(GWASExperiment.class);
		copy.usedMarkerSet = db.find(UsedMarkerSet.class);
		copy.significance = db.find(Significance.class);
		copy.effectSize = db.find(EffectSize.class);
		copy.selectionCriteria = db.find(SelectionCriteria.class);
		return copy;	
	}
	
	private boolean compareDirs(File dir1, File dir2) throws IOException
	{
		if(dir1.listFiles().length != dir2.listFiles().length) {
			logger.error(String.format("Difference amount of files in between %s and %s",dir1.getName(), dir2.getName()));
			return false;
		}
		if(!Arrays.equals(dir1.list(), dir2.list())) {
			logger.error(String.format("Difference files in %s and %s",dir1.getName(), dir2.getName()));
			return false;
		}
		
		
		
		String errorMessage = "";
		for(File f: dir1.listFiles())
		{
			File f2 = new File(dir2.getAbsolutePath()+File.separator+f.getName());
			boolean result = CompareCSV.compareCSVFilesByContent(f, f2);
			if(!result) {
				logger.error(f + " and " + f2 + " differ");
				return false;
			}
		}
		return true;
	}
	
    public static void main(String[] args) throws Exception
    {
        oneTimeSetUp();
	new TestCsv().testCsv1();
        destory();
    }
}