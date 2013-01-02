
/* Date:        January 2, 2013
 * 
 * generator:   org.molgenis.generators.csv.CsvImportByIdGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.omx;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.molgenis.framework.db.Database;
import org.molgenis.framework.db.DatabaseException;
import org.molgenis.util.CsvReader;
import org.molgenis.util.CsvFileReader;

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
	import org.molgenis.observ.Protocol_Subprotocols;
	import org.molgenis.observ.Protocol_Features;
	import org.molgenis.observ.target.Panel_Individuals;
	import org.molgenis.organization.Experiment_AssayedPanels;
	import org.molgenis.organization.Person_AffiliateInstitutions;
	import org.molgenis.organization.Citation_OntologyTerms;
	import org.molgenis.gwascentral.StudyDetails_OtherCitations;
	import org.molgenis.observ.ObservationSet;
	import org.molgenis.observ.ObservedValue;
	import org.molgenis.gwascentral.FrequencyCluster;
	import org.molgenis.gwascentral.GenotypeFrequency;
	import org.molgenis.gwascentral.AlleleFrequency;
	import org.molgenis.gwascentral.PhenotypeValue;
	import org.molgenis.organization.Experiment_DataSets;


public class CsvImportById
{
	static Logger logger = Logger.getLogger(CsvImport.class.getSimpleName());
	//mappings between imported and internally assigned ids
	//only necessary for automatic ids
	static Map<Integer,Integer> autoidIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> identifiableIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> molgenisEntityIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> molgenisFileIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> runtimePropertyIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> molgenisRoleIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> molgenisGroupIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> molgenisUserIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> molgenisRoleGroupLinkIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> molgenisPermissionIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> characteristicIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> observationTargetIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> individualIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> ontologyIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> speciesIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> ontologyTermIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> accessionIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> observableFeatureIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> protocolIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> dataSetIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> panelIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> genomeIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> chromosomeIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> geneIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> proteinIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> proteinDomainIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> exonIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> variantIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> instituteIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> personIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> citationIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> investigationIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> studyIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> experimentIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> submissionIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> contributionIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> studyDetailsIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> phenotypePropertyIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> phenotypeMethodIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> samplePanelIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> assayedPanelIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> panelSourceIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> gWASExperimentIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> usedMarkerSetIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> categoryIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> significanceIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> effectSizeIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> selectionCriteriaIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> protocol_subprotocolsIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> protocol_FeaturesIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> panel_IndividualsIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> experiment_AssayedPanelsIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> person_AffiliateInstitutionsIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> citation_ontologyTermsIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> studyDetails_otherCitationsIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> observationSetIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> observedValueIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> frequencyClusterIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> genotypeFrequencyIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> alleleFrequencyIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> phenotypeValueIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> experiment_DataSetsIdMap = new TreeMap<Integer,Integer>(); 

	/**
	 * Csv import of whole database.
	 * TODO: add filter parameters...
	 */
	public static void importData(File directory, Database db) throws Exception
	{
		try
		{
			db.beginTx();
						
			importMolgenisEntity(db, new File(directory + "/molgenisentity.txt"));
			importMolgenisFile(db, new File(directory + "/molgenisfile.txt"));
			importRuntimeProperty(db, new File(directory + "/runtimeproperty.txt"));
			importMolgenisRole(db, new File(directory + "/molgenisrole.txt"));
			importMolgenisGroup(db, new File(directory + "/molgenisgroup.txt"));
			importMolgenisUser(db, new File(directory + "/molgenisuser.txt"));
			importMolgenisRoleGroupLink(db, new File(directory + "/molgenisrolegrouplink.txt"));
			importMolgenisPermission(db, new File(directory + "/molgenispermission.txt"));
			importCharacteristic(db, new File(directory + "/characteristic.txt"));
			importObservationTarget(db, new File(directory + "/observationtarget.txt"));
			importIndividual(db, new File(directory + "/individual.txt"));
			importOntology(db, new File(directory + "/ontology.txt"));
			importSpecies(db, new File(directory + "/species.txt"));
			importOntologyTerm(db, new File(directory + "/ontologyterm.txt"));
			importAccession(db, new File(directory + "/accession.txt"));
			importObservableFeature(db, new File(directory + "/observablefeature.txt"));
			importProtocol(db, new File(directory + "/protocol.txt"));
			importDataSet(db, new File(directory + "/dataset.txt"));
			importPanel(db, new File(directory + "/panel.txt"));
			importGenome(db, new File(directory + "/genome.txt"));
			importChromosome(db, new File(directory + "/chromosome.txt"));
			importGene(db, new File(directory + "/gene.txt"));
			importProtein(db, new File(directory + "/protein.txt"));
			importProteinDomain(db, new File(directory + "/proteindomain.txt"));
			importExon(db, new File(directory + "/exon.txt"));
			importVariant(db, new File(directory + "/variant.txt"));
			importInstitute(db, new File(directory + "/institute.txt"));
			importPerson(db, new File(directory + "/person.txt"));
			importCitation(db, new File(directory + "/citation.txt"));
			importInvestigation(db, new File(directory + "/investigation.txt"));
			importStudy(db, new File(directory + "/study.txt"));
			importExperiment(db, new File(directory + "/experiment.txt"));
			importSubmission(db, new File(directory + "/submission.txt"));
			importContribution(db, new File(directory + "/contribution.txt"));
			importStudyDetails(db, new File(directory + "/studydetails.txt"));
			importPhenotypeProperty(db, new File(directory + "/phenotypeproperty.txt"));
			importPhenotypeMethod(db, new File(directory + "/phenotypemethod.txt"));
			importSamplePanel(db, new File(directory + "/samplepanel.txt"));
			importAssayedPanel(db, new File(directory + "/assayedpanel.txt"));
			importPanelSource(db, new File(directory + "/panelsource.txt"));
			importGWASExperiment(db, new File(directory + "/gwasexperiment.txt"));
			importUsedMarkerSet(db, new File(directory + "/usedmarkerset.txt"));
			importCategory(db, new File(directory + "/category.txt"));
			importSignificance(db, new File(directory + "/significance.txt"));
			importEffectSize(db, new File(directory + "/effectsize.txt"));
			importSelectionCriteria(db, new File(directory + "/selectioncriteria.txt"));
			importProtocol_Subprotocols(db, new File(directory + "/protocol_subprotocols.txt"));
			importProtocol_Features(db, new File(directory + "/protocol_features.txt"));
			importPanel_Individuals(db, new File(directory + "/panel_individuals.txt"));
			importExperiment_AssayedPanels(db, new File(directory + "/experiment_assayedpanels.txt"));
			importPerson_AffiliateInstitutions(db, new File(directory + "/person_affiliateinstitutions.txt"));
			importCitation_OntologyTerms(db, new File(directory + "/citation_ontologyterms.txt"));
			importStudyDetails_OtherCitations(db, new File(directory + "/studydetails_othercitations.txt"));
			importObservationSet(db, new File(directory + "/observationset.txt"));
			importObservedValue(db, new File(directory + "/observedvalue.txt"));
			importFrequencyCluster(db, new File(directory + "/frequencycluster.txt"));
			importGenotypeFrequency(db, new File(directory + "/genotypefrequency.txt"));
			importAlleleFrequency(db, new File(directory + "/allelefrequency.txt"));
			importPhenotypeValue(db, new File(directory + "/phenotypevalue.txt"));
			importExperiment_DataSets(db, new File(directory + "/experiment_datasets.txt"));
			
			// insert back again...
			logger.debug("commiting transactions...");
			
			db.commitTx();
		}
		catch (Exception e)
		{
			logger.error("import failed: " + e.getMessage());
			logger.debug("rolling back transactions...");
			db.rollbackTx();

			throw e;
		}

		logger.debug("done");
	}
	
	/**
	 * Imports MolgenisEntity from tab/comma delimited File.
	 * @param MolgenisEntityFile a tab delimited file with MolgenisEntity data.
	 */
	private static void importMolgenisEntity(Database db, File MolgenisEntityFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+MolgenisEntityFile);
		if(	!MolgenisEntityFile.exists() )
		{
			logger.warn("MolgenisEntity.txt file is missing, skipped import");
		}
		else
		{
			//read MolgenisEntity from file
			CsvReader reader = new CsvFileReader(MolgenisEntityFile);
			List<MolgenisEntity> molgenisEntityList = db.toList(MolgenisEntity.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+molgenisEntityList.size()+" MolgenisEntity objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> molgenisEntityIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < molgenisEntityList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				MolgenisEntity object = molgenisEntityList.get(i);
				
				//remember index of this id for incoming fkeys
				molgenisEntityIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				
				//add assay back to list
				molgenisEntityList.set(i, object);
			}
			//add to database
			db.add(molgenisEntityList);
			for(int i = 0; i < molgenisEntityList.size(); i++)
			{
				molgenisEntityIdMap.put(molgenisEntityIds.get(i), molgenisEntityList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports MolgenisFile from tab/comma delimited File.
	 * @param MolgenisFileFile a tab delimited file with MolgenisFile data.
	 */
	private static void importMolgenisFile(Database db, File MolgenisFileFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+MolgenisFileFile);
		if(	!MolgenisFileFile.exists() )
		{
			logger.warn("MolgenisFile.txt file is missing, skipped import");
		}
		else
		{
			//read MolgenisFile from file
			CsvReader reader = new CsvFileReader(MolgenisFileFile);
			List<MolgenisFile> molgenisFileList = db.toList(MolgenisFile.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+molgenisFileList.size()+" MolgenisFile objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> molgenisFileIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < molgenisFileList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				MolgenisFile object = molgenisFileList.get(i);
				
				//remember index of this id for incoming fkeys
				molgenisFileIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				
				//add assay back to list
				molgenisFileList.set(i, object);
			}
			//add to database
			db.add(molgenisFileList);
			for(int i = 0; i < molgenisFileList.size(); i++)
			{
				molgenisFileIdMap.put(molgenisFileIds.get(i), molgenisFileList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports RuntimeProperty from tab/comma delimited File.
	 * @param RuntimePropertyFile a tab delimited file with RuntimeProperty data.
	 */
	private static void importRuntimeProperty(Database db, File RuntimePropertyFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+RuntimePropertyFile);
		if(	!RuntimePropertyFile.exists() )
		{
			logger.warn("RuntimeProperty.txt file is missing, skipped import");
		}
		else
		{
			//read RuntimeProperty from file
			CsvReader reader = new CsvFileReader(RuntimePropertyFile);
			List<RuntimeProperty> runtimePropertyList = db.toList(RuntimeProperty.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+runtimePropertyList.size()+" RuntimeProperty objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> runtimePropertyIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < runtimePropertyList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				RuntimeProperty object = runtimePropertyList.get(i);
				
				//remember index of this id for incoming fkeys
				runtimePropertyIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				
				//add assay back to list
				runtimePropertyList.set(i, object);
			}
			//add to database
			db.add(runtimePropertyList);
			for(int i = 0; i < runtimePropertyList.size(); i++)
			{
				runtimePropertyIdMap.put(runtimePropertyIds.get(i), runtimePropertyList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports MolgenisRole from tab/comma delimited File.
	 * @param MolgenisRoleFile a tab delimited file with MolgenisRole data.
	 */
	private static void importMolgenisRole(Database db, File MolgenisRoleFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+MolgenisRoleFile);
		if(	!MolgenisRoleFile.exists() )
		{
			logger.warn("MolgenisRole.txt file is missing, skipped import");
		}
		else
		{
			//read MolgenisRole from file
			CsvReader reader = new CsvFileReader(MolgenisRoleFile);
			List<MolgenisRole> molgenisRoleList = db.toList(MolgenisRole.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+molgenisRoleList.size()+" MolgenisRole objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> molgenisRoleIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < molgenisRoleList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				MolgenisRole object = molgenisRoleList.get(i);
				
				//remember index of this id for incoming fkeys
				molgenisRoleIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				
				//add assay back to list
				molgenisRoleList.set(i, object);
			}
			//add to database
			db.add(molgenisRoleList);
			for(int i = 0; i < molgenisRoleList.size(); i++)
			{
				molgenisRoleIdMap.put(molgenisRoleIds.get(i), molgenisRoleList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports MolgenisGroup from tab/comma delimited File.
	 * @param MolgenisGroupFile a tab delimited file with MolgenisGroup data.
	 */
	private static void importMolgenisGroup(Database db, File MolgenisGroupFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+MolgenisGroupFile);
		if(	!MolgenisGroupFile.exists() )
		{
			logger.warn("MolgenisGroup.txt file is missing, skipped import");
		}
		else
		{
			//read MolgenisGroup from file
			CsvReader reader = new CsvFileReader(MolgenisGroupFile);
			List<MolgenisGroup> molgenisGroupList = db.toList(MolgenisGroup.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+molgenisGroupList.size()+" MolgenisGroup objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> molgenisGroupIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < molgenisGroupList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				MolgenisGroup object = molgenisGroupList.get(i);
				
				//remember index of this id for incoming fkeys
				molgenisGroupIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				
				//add assay back to list
				molgenisGroupList.set(i, object);
			}
			//add to database
			db.add(molgenisGroupList);
			for(int i = 0; i < molgenisGroupList.size(); i++)
			{
				molgenisGroupIdMap.put(molgenisGroupIds.get(i), molgenisGroupList.get(i).getId());
				molgenisRoleIdMap.put(molgenisGroupIds.get(i), molgenisGroupList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports MolgenisUser from tab/comma delimited File.
	 * @param MolgenisUserFile a tab delimited file with MolgenisUser data.
	 */
	private static void importMolgenisUser(Database db, File MolgenisUserFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+MolgenisUserFile);
		if(	!MolgenisUserFile.exists() )
		{
			logger.warn("MolgenisUser.txt file is missing, skipped import");
		}
		else
		{
			//read MolgenisUser from file
			CsvReader reader = new CsvFileReader(MolgenisUserFile);
			List<MolgenisUser> molgenisUserList = db.toList(MolgenisUser.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+molgenisUserList.size()+" MolgenisUser objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> molgenisUserIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < molgenisUserList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				MolgenisUser object = molgenisUserList.get(i);
				
				//remember index of this id for incoming fkeys
				molgenisUserIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				
				//add assay back to list
				molgenisUserList.set(i, object);
			}
			//add to database
			db.add(molgenisUserList);
			for(int i = 0; i < molgenisUserList.size(); i++)
			{
				molgenisUserIdMap.put(molgenisUserIds.get(i), molgenisUserList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports MolgenisRoleGroupLink from tab/comma delimited File.
	 * @param MolgenisRoleGroupLinkFile a tab delimited file with MolgenisRoleGroupLink data.
	 */
	private static void importMolgenisRoleGroupLink(Database db, File MolgenisRoleGroupLinkFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+MolgenisRoleGroupLinkFile);
		if(	!MolgenisRoleGroupLinkFile.exists() )
		{
			logger.warn("MolgenisRoleGroupLink.txt file is missing, skipped import");
		}
		else
		{
			//read MolgenisRoleGroupLink from file
			CsvReader reader = new CsvFileReader(MolgenisRoleGroupLinkFile);
			List<MolgenisRoleGroupLink> molgenisRoleGroupLinkList = db.toList(MolgenisRoleGroupLink.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+molgenisRoleGroupLinkList.size()+" MolgenisRoleGroupLink objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> molgenisRoleGroupLinkIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < molgenisRoleGroupLinkList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				MolgenisRoleGroupLink object = molgenisRoleGroupLinkList.get(i);
				
				//remember index of this id for incoming fkeys
				molgenisRoleGroupLinkIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getGroup() != null) object.setGroup_Id(molgenisGroupIdMap.get(object.getGroup_Id()));
				if(object.getRole() != null) object.setRole_Id(molgenisRoleIdMap.get(object.getRole_Id()));
				
				//add assay back to list
				molgenisRoleGroupLinkList.set(i, object);
			}
			//add to database
			db.add(molgenisRoleGroupLinkList);
			for(int i = 0; i < molgenisRoleGroupLinkList.size(); i++)
			{
				molgenisRoleGroupLinkIdMap.put(molgenisRoleGroupLinkIds.get(i), molgenisRoleGroupLinkList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports MolgenisPermission from tab/comma delimited File.
	 * @param MolgenisPermissionFile a tab delimited file with MolgenisPermission data.
	 */
	private static void importMolgenisPermission(Database db, File MolgenisPermissionFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+MolgenisPermissionFile);
		if(	!MolgenisPermissionFile.exists() )
		{
			logger.warn("MolgenisPermission.txt file is missing, skipped import");
		}
		else
		{
			//read MolgenisPermission from file
			CsvReader reader = new CsvFileReader(MolgenisPermissionFile);
			List<MolgenisPermission> molgenisPermissionList = db.toList(MolgenisPermission.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+molgenisPermissionList.size()+" MolgenisPermission objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> molgenisPermissionIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < molgenisPermissionList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				MolgenisPermission object = molgenisPermissionList.get(i);
				
				//remember index of this id for incoming fkeys
				molgenisPermissionIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getRole() != null) object.setRole_Id(molgenisRoleIdMap.get(object.getRole_Id()));
				if(object.getEntity() != null) object.setEntity_Id(molgenisEntityIdMap.get(object.getEntity_Id()));
				
				//add assay back to list
				molgenisPermissionList.set(i, object);
			}
			//add to database
			db.add(molgenisPermissionList);
			for(int i = 0; i < molgenisPermissionList.size(); i++)
			{
				molgenisPermissionIdMap.put(molgenisPermissionIds.get(i), molgenisPermissionList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Characteristic from tab/comma delimited File.
	 * @param CharacteristicFile a tab delimited file with Characteristic data.
	 */
	private static void importCharacteristic(Database db, File CharacteristicFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+CharacteristicFile);
		if(	!CharacteristicFile.exists() )
		{
			logger.warn("Characteristic.txt file is missing, skipped import");
		}
		else
		{
			//read Characteristic from file
			CsvReader reader = new CsvFileReader(CharacteristicFile);
			List<Characteristic> characteristicList = db.toList(Characteristic.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+characteristicList.size()+" Characteristic objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> characteristicIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < characteristicList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Characteristic object = characteristicList.get(i);
				
				//remember index of this id for incoming fkeys
				characteristicIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				
				//add assay back to list
				characteristicList.set(i, object);
			}
			//add to database
			db.add(characteristicList);
			for(int i = 0; i < characteristicList.size(); i++)
			{
				characteristicIdMap.put(characteristicIds.get(i), characteristicList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports ObservationTarget from tab/comma delimited File.
	 * @param ObservationTargetFile a tab delimited file with ObservationTarget data.
	 */
	private static void importObservationTarget(Database db, File ObservationTargetFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+ObservationTargetFile);
		if(	!ObservationTargetFile.exists() )
		{
			logger.warn("ObservationTarget.txt file is missing, skipped import");
		}
		else
		{
			//read ObservationTarget from file
			CsvReader reader = new CsvFileReader(ObservationTargetFile);
			List<ObservationTarget> observationTargetList = db.toList(ObservationTarget.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+observationTargetList.size()+" ObservationTarget objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> observationTargetIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < observationTargetList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				ObservationTarget object = observationTargetList.get(i);
				
				//remember index of this id for incoming fkeys
				observationTargetIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				
				//add assay back to list
				observationTargetList.set(i, object);
			}
			//add to database
			db.add(observationTargetList);
			for(int i = 0; i < observationTargetList.size(); i++)
			{
				observationTargetIdMap.put(observationTargetIds.get(i), observationTargetList.get(i).getId());
				characteristicIdMap.put(observationTargetIds.get(i), observationTargetList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Individual from tab/comma delimited File.
	 * @param IndividualFile a tab delimited file with Individual data.
	 */
	private static void importIndividual(Database db, File IndividualFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+IndividualFile);
		if(	!IndividualFile.exists() )
		{
			logger.warn("Individual.txt file is missing, skipped import");
		}
		else
		{
			//read Individual from file
			CsvReader reader = new CsvFileReader(IndividualFile);
			List<Individual> individualList = db.toList(Individual.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+individualList.size()+" Individual objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> individualIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < individualList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Individual object = individualList.get(i);
				
				//remember index of this id for incoming fkeys
				individualIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getMother() != null) object.setMother_Id(individualIdMap.get(object.getMother_Id()));
				if(object.getFather() != null) object.setFather_Id(individualIdMap.get(object.getFather_Id()));
				
				//add assay back to list
				individualList.set(i, object);
			}
			//add to database
			db.add(individualList);
			for(int i = 0; i < individualList.size(); i++)
			{
				individualIdMap.put(individualIds.get(i), individualList.get(i).getId());
				characteristicIdMap.put(individualIds.get(i), individualList.get(i).getId());
				observationTargetIdMap.put(individualIds.get(i), individualList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Ontology from tab/comma delimited File.
	 * @param OntologyFile a tab delimited file with Ontology data.
	 */
	private static void importOntology(Database db, File OntologyFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+OntologyFile);
		if(	!OntologyFile.exists() )
		{
			logger.warn("Ontology.txt file is missing, skipped import");
		}
		else
		{
			//read Ontology from file
			CsvReader reader = new CsvFileReader(OntologyFile);
			List<Ontology> ontologyList = db.toList(Ontology.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+ontologyList.size()+" Ontology objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> ontologyIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < ontologyList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Ontology object = ontologyList.get(i);
				
				//remember index of this id for incoming fkeys
				ontologyIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				
				//add assay back to list
				ontologyList.set(i, object);
			}
			//add to database
			db.add(ontologyList);
			for(int i = 0; i < ontologyList.size(); i++)
			{
				ontologyIdMap.put(ontologyIds.get(i), ontologyList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Species from tab/comma delimited File.
	 * @param SpeciesFile a tab delimited file with Species data.
	 */
	private static void importSpecies(Database db, File SpeciesFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+SpeciesFile);
		if(	!SpeciesFile.exists() )
		{
			logger.warn("Species.txt file is missing, skipped import");
		}
		else
		{
			//read Species from file
			CsvReader reader = new CsvFileReader(SpeciesFile);
			List<Species> speciesList = db.toList(Species.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+speciesList.size()+" Species objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> speciesIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < speciesList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Species object = speciesList.get(i);
				
				//remember index of this id for incoming fkeys
				speciesIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getOntology() != null) object.setOntology_Id(ontologyIdMap.get(object.getOntology_Id()));
				
				//add assay back to list
				speciesList.set(i, object);
			}
			//add to database
			db.add(speciesList);
			for(int i = 0; i < speciesList.size(); i++)
			{
				speciesIdMap.put(speciesIds.get(i), speciesList.get(i).getId());
				ontologyTermIdMap.put(speciesIds.get(i), speciesList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports OntologyTerm from tab/comma delimited File.
	 * @param OntologyTermFile a tab delimited file with OntologyTerm data.
	 */
	private static void importOntologyTerm(Database db, File OntologyTermFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+OntologyTermFile);
		if(	!OntologyTermFile.exists() )
		{
			logger.warn("OntologyTerm.txt file is missing, skipped import");
		}
		else
		{
			//read OntologyTerm from file
			CsvReader reader = new CsvFileReader(OntologyTermFile);
			List<OntologyTerm> ontologyTermList = db.toList(OntologyTerm.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+ontologyTermList.size()+" OntologyTerm objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> ontologyTermIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < ontologyTermList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				OntologyTerm object = ontologyTermList.get(i);
				
				//remember index of this id for incoming fkeys
				ontologyTermIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getOntology() != null) object.setOntology_Id(ontologyIdMap.get(object.getOntology_Id()));
				
				//add assay back to list
				ontologyTermList.set(i, object);
			}
			//add to database
			db.add(ontologyTermList);
			for(int i = 0; i < ontologyTermList.size(); i++)
			{
				ontologyTermIdMap.put(ontologyTermIds.get(i), ontologyTermList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Accession from tab/comma delimited File.
	 * @param AccessionFile a tab delimited file with Accession data.
	 */
	private static void importAccession(Database db, File AccessionFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+AccessionFile);
		if(	!AccessionFile.exists() )
		{
			logger.warn("Accession.txt file is missing, skipped import");
		}
		else
		{
			//read Accession from file
			CsvReader reader = new CsvFileReader(AccessionFile);
			List<Accession> accessionList = db.toList(Accession.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+accessionList.size()+" Accession objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> accessionIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < accessionList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Accession object = accessionList.get(i);
				
				//remember index of this id for incoming fkeys
				accessionIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getOntology() != null) object.setOntology_Id(ontologyIdMap.get(object.getOntology_Id()));
				
				//add assay back to list
				accessionList.set(i, object);
			}
			//add to database
			db.add(accessionList);
			for(int i = 0; i < accessionList.size(); i++)
			{
				accessionIdMap.put(accessionIds.get(i), accessionList.get(i).getId());
				ontologyTermIdMap.put(accessionIds.get(i), accessionList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports ObservableFeature from tab/comma delimited File.
	 * @param ObservableFeatureFile a tab delimited file with ObservableFeature data.
	 */
	private static void importObservableFeature(Database db, File ObservableFeatureFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+ObservableFeatureFile);
		if(	!ObservableFeatureFile.exists() )
		{
			logger.warn("ObservableFeature.txt file is missing, skipped import");
		}
		else
		{
			//read ObservableFeature from file
			CsvReader reader = new CsvFileReader(ObservableFeatureFile);
			List<ObservableFeature> observableFeatureList = db.toList(ObservableFeature.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+observableFeatureList.size()+" ObservableFeature objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> observableFeatureIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < observableFeatureList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				ObservableFeature object = observableFeatureList.get(i);
				
				//remember index of this id for incoming fkeys
				observableFeatureIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getUnit() != null) object.setUnit_Id(ontologyTermIdMap.get(object.getUnit_Id()));
				
				//add assay back to list
				observableFeatureList.set(i, object);
			}
			//add to database
			db.add(observableFeatureList);
			for(int i = 0; i < observableFeatureList.size(); i++)
			{
				observableFeatureIdMap.put(observableFeatureIds.get(i), observableFeatureList.get(i).getId());
				characteristicIdMap.put(observableFeatureIds.get(i), observableFeatureList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Protocol from tab/comma delimited File.
	 * @param ProtocolFile a tab delimited file with Protocol data.
	 */
	private static void importProtocol(Database db, File ProtocolFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+ProtocolFile);
		if(	!ProtocolFile.exists() )
		{
			logger.warn("Protocol.txt file is missing, skipped import");
		}
		else
		{
			//read Protocol from file
			CsvReader reader = new CsvFileReader(ProtocolFile);
			List<Protocol> protocolList = db.toList(Protocol.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+protocolList.size()+" Protocol objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> protocolIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < protocolList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Protocol object = protocolList.get(i);
				
				//remember index of this id for incoming fkeys
				protocolIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getProtocolType() != null) object.setProtocolType_Id(ontologyTermIdMap.get(object.getProtocolType_Id()));
				List<Integer > subprotocolsIds = new ArrayList<Integer>();
				for(Integer id: object.getSubprotocols_Id())
				{
					subprotocolsIds.add(protocolIdMap.get(id));
				}
				List<Integer > featuresIds = new ArrayList<Integer>();
				for(Integer id: object.getFeatures_Id())
				{
					featuresIds.add(observableFeatureIdMap.get(id));
				}
				
				//add assay back to list
				protocolList.set(i, object);
			}
			//add to database
			db.add(protocolList);
			for(int i = 0; i < protocolList.size(); i++)
			{
				protocolIdMap.put(protocolIds.get(i), protocolList.get(i).getId());
				characteristicIdMap.put(protocolIds.get(i), protocolList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports DataSet from tab/comma delimited File.
	 * @param DataSetFile a tab delimited file with DataSet data.
	 */
	private static void importDataSet(Database db, File DataSetFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+DataSetFile);
		if(	!DataSetFile.exists() )
		{
			logger.warn("DataSet.txt file is missing, skipped import");
		}
		else
		{
			//read DataSet from file
			CsvReader reader = new CsvFileReader(DataSetFile);
			List<DataSet> dataSetList = db.toList(DataSet.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+dataSetList.size()+" DataSet objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> dataSetIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < dataSetList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				DataSet object = dataSetList.get(i);
				
				//remember index of this id for incoming fkeys
				dataSetIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getProtocolUsed() != null) object.setProtocolUsed_Id(protocolIdMap.get(object.getProtocolUsed_Id()));
				
				//add assay back to list
				dataSetList.set(i, object);
			}
			//add to database
			db.add(dataSetList);
			for(int i = 0; i < dataSetList.size(); i++)
			{
				dataSetIdMap.put(dataSetIds.get(i), dataSetList.get(i).getId());
				characteristicIdMap.put(dataSetIds.get(i), dataSetList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Panel from tab/comma delimited File.
	 * @param PanelFile a tab delimited file with Panel data.
	 */
	private static void importPanel(Database db, File PanelFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+PanelFile);
		if(	!PanelFile.exists() )
		{
			logger.warn("Panel.txt file is missing, skipped import");
		}
		else
		{
			//read Panel from file
			CsvReader reader = new CsvFileReader(PanelFile);
			List<Panel> panelList = db.toList(Panel.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+panelList.size()+" Panel objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> panelIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < panelList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Panel object = panelList.get(i);
				
				//remember index of this id for incoming fkeys
				panelIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getPanelType() != null) object.setPanelType_Id(ontologyTermIdMap.get(object.getPanelType_Id()));
				if(object.getSpecies() != null) object.setSpecies_Id(speciesIdMap.get(object.getSpecies_Id()));
				List<Integer > individualsIds = new ArrayList<Integer>();
				for(Integer id: object.getIndividuals_Id())
				{
					individualsIds.add(individualIdMap.get(id));
				}
				
				//add assay back to list
				panelList.set(i, object);
			}
			//add to database
			db.add(panelList);
			for(int i = 0; i < panelList.size(); i++)
			{
				panelIdMap.put(panelIds.get(i), panelList.get(i).getId());
				characteristicIdMap.put(panelIds.get(i), panelList.get(i).getId());
				observationTargetIdMap.put(panelIds.get(i), panelList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Genome from tab/comma delimited File.
	 * @param GenomeFile a tab delimited file with Genome data.
	 */
	private static void importGenome(Database db, File GenomeFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+GenomeFile);
		if(	!GenomeFile.exists() )
		{
			logger.warn("Genome.txt file is missing, skipped import");
		}
		else
		{
			//read Genome from file
			CsvReader reader = new CsvFileReader(GenomeFile);
			List<Genome> genomeList = db.toList(Genome.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+genomeList.size()+" Genome objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> genomeIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < genomeList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Genome object = genomeList.get(i);
				
				//remember index of this id for incoming fkeys
				genomeIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getSpecies() != null) object.setSpecies_Id(speciesIdMap.get(object.getSpecies_Id()));
				
				//add assay back to list
				genomeList.set(i, object);
			}
			//add to database
			db.add(genomeList);
			for(int i = 0; i < genomeList.size(); i++)
			{
				genomeIdMap.put(genomeIds.get(i), genomeList.get(i).getId());
				characteristicIdMap.put(genomeIds.get(i), genomeList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Chromosome from tab/comma delimited File.
	 * @param ChromosomeFile a tab delimited file with Chromosome data.
	 */
	private static void importChromosome(Database db, File ChromosomeFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+ChromosomeFile);
		if(	!ChromosomeFile.exists() )
		{
			logger.warn("Chromosome.txt file is missing, skipped import");
		}
		else
		{
			//read Chromosome from file
			CsvReader reader = new CsvFileReader(ChromosomeFile);
			List<Chromosome> chromosomeList = db.toList(Chromosome.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+chromosomeList.size()+" Chromosome objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> chromosomeIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < chromosomeList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Chromosome object = chromosomeList.get(i);
				
				//remember index of this id for incoming fkeys
				chromosomeIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getGenome() != null) object.setGenome_Id(genomeIdMap.get(object.getGenome_Id()));
				
				//add assay back to list
				chromosomeList.set(i, object);
			}
			//add to database
			db.add(chromosomeList);
			for(int i = 0; i < chromosomeList.size(); i++)
			{
				chromosomeIdMap.put(chromosomeIds.get(i), chromosomeList.get(i).getId());
				characteristicIdMap.put(chromosomeIds.get(i), chromosomeList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Gene from tab/comma delimited File.
	 * @param GeneFile a tab delimited file with Gene data.
	 */
	private static void importGene(Database db, File GeneFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+GeneFile);
		if(	!GeneFile.exists() )
		{
			logger.warn("Gene.txt file is missing, skipped import");
		}
		else
		{
			//read Gene from file
			CsvReader reader = new CsvFileReader(GeneFile);
			List<Gene> geneList = db.toList(Gene.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+geneList.size()+" Gene objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> geneIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < geneList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Gene object = geneList.get(i);
				
				//remember index of this id for incoming fkeys
				geneIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getGdna() != null) object.setGdna_Id(chromosomeIdMap.get(object.getGdna_Id()));
				
				//add assay back to list
				geneList.set(i, object);
			}
			//add to database
			db.add(geneList);
			for(int i = 0; i < geneList.size(); i++)
			{
				geneIdMap.put(geneIds.get(i), geneList.get(i).getId());
				characteristicIdMap.put(geneIds.get(i), geneList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Protein from tab/comma delimited File.
	 * @param ProteinFile a tab delimited file with Protein data.
	 */
	private static void importProtein(Database db, File ProteinFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+ProteinFile);
		if(	!ProteinFile.exists() )
		{
			logger.warn("Protein.txt file is missing, skipped import");
		}
		else
		{
			//read Protein from file
			CsvReader reader = new CsvFileReader(ProteinFile);
			List<Protein> proteinList = db.toList(Protein.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+proteinList.size()+" Protein objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> proteinIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < proteinList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Protein object = proteinList.get(i);
				
				//remember index of this id for incoming fkeys
				proteinIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getCdna() != null) object.setCdna_Id(geneIdMap.get(object.getCdna_Id()));
				
				//add assay back to list
				proteinList.set(i, object);
			}
			//add to database
			db.add(proteinList);
			for(int i = 0; i < proteinList.size(); i++)
			{
				proteinIdMap.put(proteinIds.get(i), proteinList.get(i).getId());
				characteristicIdMap.put(proteinIds.get(i), proteinList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports ProteinDomain from tab/comma delimited File.
	 * @param ProteinDomainFile a tab delimited file with ProteinDomain data.
	 */
	private static void importProteinDomain(Database db, File ProteinDomainFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+ProteinDomainFile);
		if(	!ProteinDomainFile.exists() )
		{
			logger.warn("ProteinDomain.txt file is missing, skipped import");
		}
		else
		{
			//read ProteinDomain from file
			CsvReader reader = new CsvFileReader(ProteinDomainFile);
			List<ProteinDomain> proteinDomainList = db.toList(ProteinDomain.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+proteinDomainList.size()+" ProteinDomain objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> proteinDomainIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < proteinDomainList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				ProteinDomain object = proteinDomainList.get(i);
				
				//remember index of this id for incoming fkeys
				proteinDomainIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getCdna() != null) object.setCdna_Id(geneIdMap.get(object.getCdna_Id()));
				if(object.getGdna() != null) object.setGdna_Id(chromosomeIdMap.get(object.getGdna_Id()));
				
				//add assay back to list
				proteinDomainList.set(i, object);
			}
			//add to database
			db.add(proteinDomainList);
			for(int i = 0; i < proteinDomainList.size(); i++)
			{
				proteinDomainIdMap.put(proteinDomainIds.get(i), proteinDomainList.get(i).getId());
				characteristicIdMap.put(proteinDomainIds.get(i), proteinDomainList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Exon from tab/comma delimited File.
	 * @param ExonFile a tab delimited file with Exon data.
	 */
	private static void importExon(Database db, File ExonFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+ExonFile);
		if(	!ExonFile.exists() )
		{
			logger.warn("Exon.txt file is missing, skipped import");
		}
		else
		{
			//read Exon from file
			CsvReader reader = new CsvFileReader(ExonFile);
			List<Exon> exonList = db.toList(Exon.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+exonList.size()+" Exon objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> exonIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < exonList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Exon object = exonList.get(i);
				
				//remember index of this id for incoming fkeys
				exonIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getCdna() != null) object.setCdna_Id(geneIdMap.get(object.getCdna_Id()));
				if(object.getGdna() != null) object.setGdna_Id(chromosomeIdMap.get(object.getGdna_Id()));
				
				//add assay back to list
				exonList.set(i, object);
			}
			//add to database
			db.add(exonList);
			for(int i = 0; i < exonList.size(); i++)
			{
				exonIdMap.put(exonIds.get(i), exonList.get(i).getId());
				characteristicIdMap.put(exonIds.get(i), exonList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Variant from tab/comma delimited File.
	 * @param VariantFile a tab delimited file with Variant data.
	 */
	private static void importVariant(Database db, File VariantFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+VariantFile);
		if(	!VariantFile.exists() )
		{
			logger.warn("Variant.txt file is missing, skipped import");
		}
		else
		{
			//read Variant from file
			CsvReader reader = new CsvFileReader(VariantFile);
			List<Variant> variantList = db.toList(Variant.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+variantList.size()+" Variant objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> variantIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < variantList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Variant object = variantList.get(i);
				
				//remember index of this id for incoming fkeys
				variantIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getGdna() != null) object.setGdna_Id(chromosomeIdMap.get(object.getGdna_Id()));
				if(object.getCdna() != null) object.setCdna_Id(geneIdMap.get(object.getCdna_Id()));
				if(object.getAa() != null) object.setAa_Id(proteinIdMap.get(object.getAa_Id()));
				if(object.getVariantType() != null) object.setVariantType_Id(ontologyTermIdMap.get(object.getVariantType_Id()));
				
				//add assay back to list
				variantList.set(i, object);
			}
			//add to database
			db.add(variantList);
			for(int i = 0; i < variantList.size(); i++)
			{
				variantIdMap.put(variantIds.get(i), variantList.get(i).getId());
				characteristicIdMap.put(variantIds.get(i), variantList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Institute from tab/comma delimited File.
	 * @param InstituteFile a tab delimited file with Institute data.
	 */
	private static void importInstitute(Database db, File InstituteFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+InstituteFile);
		if(	!InstituteFile.exists() )
		{
			logger.warn("Institute.txt file is missing, skipped import");
		}
		else
		{
			//read Institute from file
			CsvReader reader = new CsvFileReader(InstituteFile);
			List<Institute> instituteList = db.toList(Institute.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+instituteList.size()+" Institute objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> instituteIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < instituteList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Institute object = instituteList.get(i);
				
				//remember index of this id for incoming fkeys
				instituteIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				
				//add assay back to list
				instituteList.set(i, object);
			}
			//add to database
			db.add(instituteList);
			for(int i = 0; i < instituteList.size(); i++)
			{
				instituteIdMap.put(instituteIds.get(i), instituteList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Person from tab/comma delimited File.
	 * @param PersonFile a tab delimited file with Person data.
	 */
	private static void importPerson(Database db, File PersonFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+PersonFile);
		if(	!PersonFile.exists() )
		{
			logger.warn("Person.txt file is missing, skipped import");
		}
		else
		{
			//read Person from file
			CsvReader reader = new CsvFileReader(PersonFile);
			List<Person> personList = db.toList(Person.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+personList.size()+" Person objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> personIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < personList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Person object = personList.get(i);
				
				//remember index of this id for incoming fkeys
				personIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getPrimaryAffilation() != null) object.setPrimaryAffilation_Id(instituteIdMap.get(object.getPrimaryAffilation_Id()));
				List<Integer > affiliateInstitutionsIds = new ArrayList<Integer>();
				for(Integer id: object.getAffiliateInstitutions_Id())
				{
					affiliateInstitutionsIds.add(instituteIdMap.get(id));
				}
				if(object.getOrcidPersonReference() != null) object.setOrcidPersonReference_Id(ontologyTermIdMap.get(object.getOrcidPersonReference_Id()));
				
				//add assay back to list
				personList.set(i, object);
			}
			//add to database
			db.add(personList);
			for(int i = 0; i < personList.size(); i++)
			{
				personIdMap.put(personIds.get(i), personList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Citation from tab/comma delimited File.
	 * @param CitationFile a tab delimited file with Citation data.
	 */
	private static void importCitation(Database db, File CitationFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+CitationFile);
		if(	!CitationFile.exists() )
		{
			logger.warn("Citation.txt file is missing, skipped import");
		}
		else
		{
			//read Citation from file
			CsvReader reader = new CsvFileReader(CitationFile);
			List<Citation> citationList = db.toList(Citation.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+citationList.size()+" Citation objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> citationIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < citationList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Citation object = citationList.get(i);
				
				//remember index of this id for incoming fkeys
				citationIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				List<Integer > ontologyTermsIds = new ArrayList<Integer>();
				for(Integer id: object.getOntologyTerms_Id())
				{
					ontologyTermsIds.add(ontologyTermIdMap.get(id));
				}
				if(object.getStatus() != null) object.setStatus_Id(ontologyTermIdMap.get(object.getStatus_Id()));
				
				//add assay back to list
				citationList.set(i, object);
			}
			//add to database
			db.add(citationList);
			for(int i = 0; i < citationList.size(); i++)
			{
				citationIdMap.put(citationIds.get(i), citationList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Investigation from tab/comma delimited File.
	 * @param InvestigationFile a tab delimited file with Investigation data.
	 */
	private static void importInvestigation(Database db, File InvestigationFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+InvestigationFile);
		if(	!InvestigationFile.exists() )
		{
			logger.warn("Investigation.txt file is missing, skipped import");
		}
		else
		{
			//read Investigation from file
			CsvReader reader = new CsvFileReader(InvestigationFile);
			List<Investigation> investigationList = db.toList(Investigation.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+investigationList.size()+" Investigation objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> investigationIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < investigationList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Investigation object = investigationList.get(i);
				
				//remember index of this id for incoming fkeys
				investigationIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				
				//add assay back to list
				investigationList.set(i, object);
			}
			//add to database
			db.add(investigationList);
			for(int i = 0; i < investigationList.size(); i++)
			{
				investigationIdMap.put(investigationIds.get(i), investigationList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Study from tab/comma delimited File.
	 * @param StudyFile a tab delimited file with Study data.
	 */
	private static void importStudy(Database db, File StudyFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+StudyFile);
		if(	!StudyFile.exists() )
		{
			logger.warn("Study.txt file is missing, skipped import");
		}
		else
		{
			//read Study from file
			CsvReader reader = new CsvFileReader(StudyFile);
			List<Study> studyList = db.toList(Study.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+studyList.size()+" Study objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> studyIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < studyList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Study object = studyList.get(i);
				
				//remember index of this id for incoming fkeys
				studyIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getContact() != null) object.setContact_Id(personIdMap.get(object.getContact_Id()));
				if(object.getPartOfInvestigation() != null) object.setPartOfInvestigation_Id(investigationIdMap.get(object.getPartOfInvestigation_Id()));
				
				//add assay back to list
				studyList.set(i, object);
			}
			//add to database
			db.add(studyList);
			for(int i = 0; i < studyList.size(); i++)
			{
				studyIdMap.put(studyIds.get(i), studyList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Experiment from tab/comma delimited File.
	 * @param ExperimentFile a tab delimited file with Experiment data.
	 */
	private static void importExperiment(Database db, File ExperimentFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+ExperimentFile);
		if(	!ExperimentFile.exists() )
		{
			logger.warn("Experiment.txt file is missing, skipped import");
		}
		else
		{
			//read Experiment from file
			CsvReader reader = new CsvFileReader(ExperimentFile);
			List<Experiment> experimentList = db.toList(Experiment.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+experimentList.size()+" Experiment objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> experimentIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < experimentList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Experiment object = experimentList.get(i);
				
				//remember index of this id for incoming fkeys
				experimentIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getStudy() != null) object.setStudy_Id(studyIdMap.get(object.getStudy_Id()));
				if(object.getExperimentType() != null) object.setExperimentType_Id(ontologyTermIdMap.get(object.getExperimentType_Id()));
				List<Integer > assayedPanelsIds = new ArrayList<Integer>();
				for(Integer id: object.getAssayedPanels_Id())
				{
					assayedPanelsIds.add(panelIdMap.get(id));
				}
				List<Integer > dataSetsIds = new ArrayList<Integer>();
				for(Integer id: object.getDataSets_Id())
				{
					dataSetsIds.add(dataSetIdMap.get(id));
				}
				
				//add assay back to list
				experimentList.set(i, object);
			}
			//add to database
			db.add(experimentList);
			for(int i = 0; i < experimentList.size(); i++)
			{
				experimentIdMap.put(experimentIds.get(i), experimentList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Submission from tab/comma delimited File.
	 * @param SubmissionFile a tab delimited file with Submission data.
	 */
	private static void importSubmission(Database db, File SubmissionFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+SubmissionFile);
		if(	!SubmissionFile.exists() )
		{
			logger.warn("Submission.txt file is missing, skipped import");
		}
		else
		{
			//read Submission from file
			CsvReader reader = new CsvFileReader(SubmissionFile);
			List<Submission> submissionList = db.toList(Submission.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+submissionList.size()+" Submission objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> submissionIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < submissionList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Submission object = submissionList.get(i);
				
				//remember index of this id for incoming fkeys
				submissionIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getStudy() != null) object.setStudy_Id(studyIdMap.get(object.getStudy_Id()));
				
				//add assay back to list
				submissionList.set(i, object);
			}
			//add to database
			db.add(submissionList);
			for(int i = 0; i < submissionList.size(); i++)
			{
				submissionIdMap.put(submissionIds.get(i), submissionList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Contribution from tab/comma delimited File.
	 * @param ContributionFile a tab delimited file with Contribution data.
	 */
	private static void importContribution(Database db, File ContributionFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+ContributionFile);
		if(	!ContributionFile.exists() )
		{
			logger.warn("Contribution.txt file is missing, skipped import");
		}
		else
		{
			//read Contribution from file
			CsvReader reader = new CsvFileReader(ContributionFile);
			List<Contribution> contributionList = db.toList(Contribution.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+contributionList.size()+" Contribution objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> contributionIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < contributionList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Contribution object = contributionList.get(i);
				
				//remember index of this id for incoming fkeys
				contributionIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getResearcher() != null) object.setResearcher_Id(personIdMap.get(object.getResearcher_Id()));
				if(object.getSubmission() != null) object.setSubmission_Id(submissionIdMap.get(object.getSubmission_Id()));
				
				//add assay back to list
				contributionList.set(i, object);
			}
			//add to database
			db.add(contributionList);
			for(int i = 0; i < contributionList.size(); i++)
			{
				contributionIdMap.put(contributionIds.get(i), contributionList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports StudyDetails from tab/comma delimited File.
	 * @param StudyDetailsFile a tab delimited file with StudyDetails data.
	 */
	private static void importStudyDetails(Database db, File StudyDetailsFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+StudyDetailsFile);
		if(	!StudyDetailsFile.exists() )
		{
			logger.warn("StudyDetails.txt file is missing, skipped import");
		}
		else
		{
			//read StudyDetails from file
			CsvReader reader = new CsvFileReader(StudyDetailsFile);
			List<StudyDetails> studyDetailsList = db.toList(StudyDetails.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+studyDetailsList.size()+" StudyDetails objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> studyDetailsIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < studyDetailsList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				StudyDetails object = studyDetailsList.get(i);
				
				//remember index of this id for incoming fkeys
				studyDetailsIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getStudy() != null) object.setStudy_Id(studyIdMap.get(object.getStudy_Id()));
				if(object.getPrimaryCitation() != null) object.setPrimaryCitation_Id(citationIdMap.get(object.getPrimaryCitation_Id()));
				List<Integer > otherCitationsIds = new ArrayList<Integer>();
				for(Integer id: object.getOtherCitations_Id())
				{
					otherCitationsIds.add(citationIdMap.get(id));
				}
				
				//add assay back to list
				studyDetailsList.set(i, object);
			}
			//add to database
			db.add(studyDetailsList);
			for(int i = 0; i < studyDetailsList.size(); i++)
			{
				studyDetailsIdMap.put(studyDetailsIds.get(i), studyDetailsList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports PhenotypeProperty from tab/comma delimited File.
	 * @param PhenotypePropertyFile a tab delimited file with PhenotypeProperty data.
	 */
	private static void importPhenotypeProperty(Database db, File PhenotypePropertyFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+PhenotypePropertyFile);
		if(	!PhenotypePropertyFile.exists() )
		{
			logger.warn("PhenotypeProperty.txt file is missing, skipped import");
		}
		else
		{
			//read PhenotypeProperty from file
			CsvReader reader = new CsvFileReader(PhenotypePropertyFile);
			List<PhenotypeProperty> phenotypePropertyList = db.toList(PhenotypeProperty.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+phenotypePropertyList.size()+" PhenotypeProperty objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> phenotypePropertyIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < phenotypePropertyList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				PhenotypeProperty object = phenotypePropertyList.get(i);
				
				//remember index of this id for incoming fkeys
				phenotypePropertyIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getUnit() != null) object.setUnit_Id(ontologyTermIdMap.get(object.getUnit_Id()));
				
				//add assay back to list
				phenotypePropertyList.set(i, object);
			}
			//add to database
			db.add(phenotypePropertyList);
			for(int i = 0; i < phenotypePropertyList.size(); i++)
			{
				phenotypePropertyIdMap.put(phenotypePropertyIds.get(i), phenotypePropertyList.get(i).getId());
				characteristicIdMap.put(phenotypePropertyIds.get(i), phenotypePropertyList.get(i).getId());
				observableFeatureIdMap.put(phenotypePropertyIds.get(i), phenotypePropertyList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports PhenotypeMethod from tab/comma delimited File.
	 * @param PhenotypeMethodFile a tab delimited file with PhenotypeMethod data.
	 */
	private static void importPhenotypeMethod(Database db, File PhenotypeMethodFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+PhenotypeMethodFile);
		if(	!PhenotypeMethodFile.exists() )
		{
			logger.warn("PhenotypeMethod.txt file is missing, skipped import");
		}
		else
		{
			//read PhenotypeMethod from file
			CsvReader reader = new CsvFileReader(PhenotypeMethodFile);
			List<PhenotypeMethod> phenotypeMethodList = db.toList(PhenotypeMethod.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+phenotypeMethodList.size()+" PhenotypeMethod objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> phenotypeMethodIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < phenotypeMethodList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				PhenotypeMethod object = phenotypeMethodList.get(i);
				
				//remember index of this id for incoming fkeys
				phenotypeMethodIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getProtocolUsed() != null) object.setProtocolUsed_Id(protocolIdMap.get(object.getProtocolUsed_Id()));
				if(object.getStudyID() != null) object.setStudyID_Id(studyIdMap.get(object.getStudyID_Id()));
				if(object.getPhenotypePropertyID() != null) object.setPhenotypePropertyID_Id(phenotypePropertyIdMap.get(object.getPhenotypePropertyID_Id()));
				
				//add assay back to list
				phenotypeMethodList.set(i, object);
			}
			//add to database
			db.add(phenotypeMethodList);
			for(int i = 0; i < phenotypeMethodList.size(); i++)
			{
				phenotypeMethodIdMap.put(phenotypeMethodIds.get(i), phenotypeMethodList.get(i).getId());
				characteristicIdMap.put(phenotypeMethodIds.get(i), phenotypeMethodList.get(i).getId());
				dataSetIdMap.put(phenotypeMethodIds.get(i), phenotypeMethodList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports SamplePanel from tab/comma delimited File.
	 * @param SamplePanelFile a tab delimited file with SamplePanel data.
	 */
	private static void importSamplePanel(Database db, File SamplePanelFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+SamplePanelFile);
		if(	!SamplePanelFile.exists() )
		{
			logger.warn("SamplePanel.txt file is missing, skipped import");
		}
		else
		{
			//read SamplePanel from file
			CsvReader reader = new CsvFileReader(SamplePanelFile);
			List<SamplePanel> samplePanelList = db.toList(SamplePanel.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+samplePanelList.size()+" SamplePanel objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> samplePanelIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < samplePanelList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				SamplePanel object = samplePanelList.get(i);
				
				//remember index of this id for incoming fkeys
				samplePanelIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getPanelType() != null) object.setPanelType_Id(ontologyTermIdMap.get(object.getPanelType_Id()));
				if(object.getSpecies() != null) object.setSpecies_Id(speciesIdMap.get(object.getSpecies_Id()));
				List<Integer > individualsIds = new ArrayList<Integer>();
				for(Integer id: object.getIndividuals_Id())
				{
					individualsIds.add(individualIdMap.get(id));
				}
				if(object.getCentralIdentifier() != null) object.setCentralIdentifier_Id(ontologyTermIdMap.get(object.getCentralIdentifier_Id()));
				
				//add assay back to list
				samplePanelList.set(i, object);
			}
			//add to database
			db.add(samplePanelList);
			for(int i = 0; i < samplePanelList.size(); i++)
			{
				samplePanelIdMap.put(samplePanelIds.get(i), samplePanelList.get(i).getId());
				characteristicIdMap.put(samplePanelIds.get(i), samplePanelList.get(i).getId());
				observationTargetIdMap.put(samplePanelIds.get(i), samplePanelList.get(i).getId());
				panelIdMap.put(samplePanelIds.get(i), samplePanelList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports AssayedPanel from tab/comma delimited File.
	 * @param AssayedPanelFile a tab delimited file with AssayedPanel data.
	 */
	private static void importAssayedPanel(Database db, File AssayedPanelFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+AssayedPanelFile);
		if(	!AssayedPanelFile.exists() )
		{
			logger.warn("AssayedPanel.txt file is missing, skipped import");
		}
		else
		{
			//read AssayedPanel from file
			CsvReader reader = new CsvFileReader(AssayedPanelFile);
			List<AssayedPanel> assayedPanelList = db.toList(AssayedPanel.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+assayedPanelList.size()+" AssayedPanel objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> assayedPanelIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < assayedPanelList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				AssayedPanel object = assayedPanelList.get(i);
				
				//remember index of this id for incoming fkeys
				assayedPanelIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getPanelType() != null) object.setPanelType_Id(ontologyTermIdMap.get(object.getPanelType_Id()));
				if(object.getSpecies() != null) object.setSpecies_Id(speciesIdMap.get(object.getSpecies_Id()));
				List<Integer > individualsIds = new ArrayList<Integer>();
				for(Integer id: object.getIndividuals_Id())
				{
					individualsIds.add(individualIdMap.get(id));
				}
				
				//add assay back to list
				assayedPanelList.set(i, object);
			}
			//add to database
			db.add(assayedPanelList);
			for(int i = 0; i < assayedPanelList.size(); i++)
			{
				assayedPanelIdMap.put(assayedPanelIds.get(i), assayedPanelList.get(i).getId());
				characteristicIdMap.put(assayedPanelIds.get(i), assayedPanelList.get(i).getId());
				observationTargetIdMap.put(assayedPanelIds.get(i), assayedPanelList.get(i).getId());
				panelIdMap.put(assayedPanelIds.get(i), assayedPanelList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports PanelSource from tab/comma delimited File.
	 * @param PanelSourceFile a tab delimited file with PanelSource data.
	 */
	private static void importPanelSource(Database db, File PanelSourceFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+PanelSourceFile);
		if(	!PanelSourceFile.exists() )
		{
			logger.warn("PanelSource.txt file is missing, skipped import");
		}
		else
		{
			//read PanelSource from file
			CsvReader reader = new CsvFileReader(PanelSourceFile);
			List<PanelSource> panelSourceList = db.toList(PanelSource.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+panelSourceList.size()+" PanelSource objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> panelSourceIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < panelSourceList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				PanelSource object = panelSourceList.get(i);
				
				//remember index of this id for incoming fkeys
				panelSourceIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getCurrentPanel() != null) object.setCurrentPanel_Id(panelIdMap.get(object.getCurrentPanel_Id()));
				if(object.getSourcePanel() != null) object.setSourcePanel_Id(panelIdMap.get(object.getSourcePanel_Id()));
				
				//add assay back to list
				panelSourceList.set(i, object);
			}
			//add to database
			db.add(panelSourceList);
			for(int i = 0; i < panelSourceList.size(); i++)
			{
				panelSourceIdMap.put(panelSourceIds.get(i), panelSourceList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports GWASExperiment from tab/comma delimited File.
	 * @param GWASExperimentFile a tab delimited file with GWASExperiment data.
	 */
	private static void importGWASExperiment(Database db, File GWASExperimentFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+GWASExperimentFile);
		if(	!GWASExperimentFile.exists() )
		{
			logger.warn("GWASExperiment.txt file is missing, skipped import");
		}
		else
		{
			//read GWASExperiment from file
			CsvReader reader = new CsvFileReader(GWASExperimentFile);
			List<GWASExperiment> gWASExperimentList = db.toList(GWASExperiment.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+gWASExperimentList.size()+" GWASExperiment objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> gWASExperimentIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < gWASExperimentList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				GWASExperiment object = gWASExperimentList.get(i);
				
				//remember index of this id for incoming fkeys
				gWASExperimentIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getStudy() != null) object.setStudy_Id(studyIdMap.get(object.getStudy_Id()));
				if(object.getExperimentType() != null) object.setExperimentType_Id(ontologyTermIdMap.get(object.getExperimentType_Id()));
				List<Integer > assayedPanelsIds = new ArrayList<Integer>();
				for(Integer id: object.getAssayedPanels_Id())
				{
					assayedPanelsIds.add(panelIdMap.get(id));
				}
				List<Integer > dataSetsIds = new ArrayList<Integer>();
				for(Integer id: object.getDataSets_Id())
				{
					dataSetsIds.add(dataSetIdMap.get(id));
				}
				
				//add assay back to list
				gWASExperimentList.set(i, object);
			}
			//add to database
			db.add(gWASExperimentList);
			for(int i = 0; i < gWASExperimentList.size(); i++)
			{
				gWASExperimentIdMap.put(gWASExperimentIds.get(i), gWASExperimentList.get(i).getId());
				experimentIdMap.put(gWASExperimentIds.get(i), gWASExperimentList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports UsedMarkerSet from tab/comma delimited File.
	 * @param UsedMarkerSetFile a tab delimited file with UsedMarkerSet data.
	 */
	private static void importUsedMarkerSet(Database db, File UsedMarkerSetFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+UsedMarkerSetFile);
		if(	!UsedMarkerSetFile.exists() )
		{
			logger.warn("UsedMarkerSet.txt file is missing, skipped import");
		}
		else
		{
			//read UsedMarkerSet from file
			CsvReader reader = new CsvFileReader(UsedMarkerSetFile);
			List<UsedMarkerSet> usedMarkerSetList = db.toList(UsedMarkerSet.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+usedMarkerSetList.size()+" UsedMarkerSet objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> usedMarkerSetIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < usedMarkerSetList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				UsedMarkerSet object = usedMarkerSetList.get(i);
				
				//remember index of this id for incoming fkeys
				usedMarkerSetIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getUnit() != null) object.setUnit_Id(ontologyTermIdMap.get(object.getUnit_Id()));
				if(object.getExperimentID() != null) object.setExperimentID_Id(experimentIdMap.get(object.getExperimentID_Id()));
				
				//add assay back to list
				usedMarkerSetList.set(i, object);
			}
			//add to database
			db.add(usedMarkerSetList);
			for(int i = 0; i < usedMarkerSetList.size(); i++)
			{
				usedMarkerSetIdMap.put(usedMarkerSetIds.get(i), usedMarkerSetList.get(i).getId());
				characteristicIdMap.put(usedMarkerSetIds.get(i), usedMarkerSetList.get(i).getId());
				observableFeatureIdMap.put(usedMarkerSetIds.get(i), usedMarkerSetList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Category from tab/comma delimited File.
	 * @param CategoryFile a tab delimited file with Category data.
	 */
	private static void importCategory(Database db, File CategoryFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+CategoryFile);
		if(	!CategoryFile.exists() )
		{
			logger.warn("Category.txt file is missing, skipped import");
		}
		else
		{
			//read Category from file
			CsvReader reader = new CsvFileReader(CategoryFile);
			List<Category> categoryList = db.toList(Category.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+categoryList.size()+" Category objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> categoryIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < categoryList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Category object = categoryList.get(i);
				
				//remember index of this id for incoming fkeys
				categoryIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getObservableFeature() != null) object.setObservableFeature_Id(observableFeatureIdMap.get(object.getObservableFeature_Id()));
				
				//add assay back to list
				categoryList.set(i, object);
			}
			//add to database
			db.add(categoryList);
			for(int i = 0; i < categoryList.size(); i++)
			{
				categoryIdMap.put(categoryIds.get(i), categoryList.get(i).getId());
				characteristicIdMap.put(categoryIds.get(i), categoryList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Significance from tab/comma delimited File.
	 * @param SignificanceFile a tab delimited file with Significance data.
	 */
	private static void importSignificance(Database db, File SignificanceFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+SignificanceFile);
		if(	!SignificanceFile.exists() )
		{
			logger.warn("Significance.txt file is missing, skipped import");
		}
		else
		{
			//read Significance from file
			CsvReader reader = new CsvFileReader(SignificanceFile);
			List<Significance> significanceList = db.toList(Significance.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+significanceList.size()+" Significance objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> significanceIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < significanceList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Significance object = significanceList.get(i);
				
				//remember index of this id for incoming fkeys
				significanceIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getProtocolUsed() != null) object.setProtocolUsed_Id(protocolIdMap.get(object.getProtocolUsed_Id()));
				if(object.getUsedmarkersetID() != null) object.setUsedmarkersetID_Id(usedMarkerSetIdMap.get(object.getUsedmarkersetID_Id()));
				
				//add assay back to list
				significanceList.set(i, object);
			}
			//add to database
			db.add(significanceList);
			for(int i = 0; i < significanceList.size(); i++)
			{
				significanceIdMap.put(significanceIds.get(i), significanceList.get(i).getId());
				characteristicIdMap.put(significanceIds.get(i), significanceList.get(i).getId());
				dataSetIdMap.put(significanceIds.get(i), significanceList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports EffectSize from tab/comma delimited File.
	 * @param EffectSizeFile a tab delimited file with EffectSize data.
	 */
	private static void importEffectSize(Database db, File EffectSizeFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+EffectSizeFile);
		if(	!EffectSizeFile.exists() )
		{
			logger.warn("EffectSize.txt file is missing, skipped import");
		}
		else
		{
			//read EffectSize from file
			CsvReader reader = new CsvFileReader(EffectSizeFile);
			List<EffectSize> effectSizeList = db.toList(EffectSize.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+effectSizeList.size()+" EffectSize objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> effectSizeIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < effectSizeList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				EffectSize object = effectSizeList.get(i);
				
				//remember index of this id for incoming fkeys
				effectSizeIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getProtocolUsed() != null) object.setProtocolUsed_Id(protocolIdMap.get(object.getProtocolUsed_Id()));
				if(object.getUsedMarkerSetID() != null) object.setUsedMarkerSetID_Id(usedMarkerSetIdMap.get(object.getUsedMarkerSetID_Id()));
				
				//add assay back to list
				effectSizeList.set(i, object);
			}
			//add to database
			db.add(effectSizeList);
			for(int i = 0; i < effectSizeList.size(); i++)
			{
				effectSizeIdMap.put(effectSizeIds.get(i), effectSizeList.get(i).getId());
				characteristicIdMap.put(effectSizeIds.get(i), effectSizeList.get(i).getId());
				dataSetIdMap.put(effectSizeIds.get(i), effectSizeList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports SelectionCriteria from tab/comma delimited File.
	 * @param SelectionCriteriaFile a tab delimited file with SelectionCriteria data.
	 */
	private static void importSelectionCriteria(Database db, File SelectionCriteriaFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+SelectionCriteriaFile);
		if(	!SelectionCriteriaFile.exists() )
		{
			logger.warn("SelectionCriteria.txt file is missing, skipped import");
		}
		else
		{
			//read SelectionCriteria from file
			CsvReader reader = new CsvFileReader(SelectionCriteriaFile);
			List<SelectionCriteria> selectionCriteriaList = db.toList(SelectionCriteria.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+selectionCriteriaList.size()+" SelectionCriteria objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> selectionCriteriaIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < selectionCriteriaList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				SelectionCriteria object = selectionCriteriaList.get(i);
				
				//remember index of this id for incoming fkeys
				selectionCriteriaIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getSourcePanel() != null) object.setSourcePanel_Id(panelIdMap.get(object.getSourcePanel_Id()));
				if(object.getTargetPanel() != null) object.setTargetPanel_Id(panelIdMap.get(object.getTargetPanel_Id()));
				
				//add assay back to list
				selectionCriteriaList.set(i, object);
			}
			//add to database
			db.add(selectionCriteriaList);
			for(int i = 0; i < selectionCriteriaList.size(); i++)
			{
				selectionCriteriaIdMap.put(selectionCriteriaIds.get(i), selectionCriteriaList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Protocol_Subprotocols from tab/comma delimited File.
	 * @param Protocol_subprotocolsFile a tab delimited file with Protocol_Subprotocols data.
	 */
	private static void importProtocol_Subprotocols(Database db, File Protocol_subprotocolsFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+Protocol_subprotocolsFile);
		if(	!Protocol_subprotocolsFile.exists() )
		{
			logger.warn("Protocol_subprotocols.txt file is missing, skipped import");
		}
		else
		{
			//read Protocol_subprotocols from file
			CsvReader reader = new CsvFileReader(Protocol_subprotocolsFile);
			List<Protocol_Subprotocols> protocol_subprotocolsList = db.toList(Protocol_Subprotocols.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+protocol_subprotocolsList.size()+" Protocol_subprotocols objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> protocol_subprotocolsIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < protocol_subprotocolsList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Protocol_Subprotocols object = protocol_subprotocolsList.get(i);
				
				//remember index of this id for incoming fkeys
				protocol_subprotocolsIds.add(object.getAutoid()); 
				
				//redirect outgoing fkeys
				if(object.getSubprotocols() != null) object.setSubprotocols_Id(protocolIdMap.get(object.getSubprotocols_Id()));
				if(object.getProtocol() != null) object.setProtocol_Id(protocolIdMap.get(object.getProtocol_Id()));
				
				//add assay back to list
				protocol_subprotocolsList.set(i, object);
			}
			//add to database
			db.add(protocol_subprotocolsList);
			for(int i = 0; i < protocol_subprotocolsList.size(); i++)
			{
				protocol_subprotocolsIdMap.put(protocol_subprotocolsIds.get(i), protocol_subprotocolsList.get(i).getAutoid());
			}
		}	 
	}
	/**
	 * Imports Protocol_Features from tab/comma delimited File.
	 * @param Protocol_FeaturesFile a tab delimited file with Protocol_Features data.
	 */
	private static void importProtocol_Features(Database db, File Protocol_FeaturesFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+Protocol_FeaturesFile);
		if(	!Protocol_FeaturesFile.exists() )
		{
			logger.warn("Protocol_Features.txt file is missing, skipped import");
		}
		else
		{
			//read Protocol_Features from file
			CsvReader reader = new CsvFileReader(Protocol_FeaturesFile);
			List<Protocol_Features> protocol_FeaturesList = db.toList(Protocol_Features.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+protocol_FeaturesList.size()+" Protocol_Features objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> protocol_FeaturesIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < protocol_FeaturesList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Protocol_Features object = protocol_FeaturesList.get(i);
				
				//remember index of this id for incoming fkeys
				protocol_FeaturesIds.add(object.getAutoid()); 
				
				//redirect outgoing fkeys
				if(object.getFeatures() != null) object.setFeatures_Id(observableFeatureIdMap.get(object.getFeatures_Id()));
				if(object.getProtocol() != null) object.setProtocol_Id(protocolIdMap.get(object.getProtocol_Id()));
				
				//add assay back to list
				protocol_FeaturesList.set(i, object);
			}
			//add to database
			db.add(protocol_FeaturesList);
			for(int i = 0; i < protocol_FeaturesList.size(); i++)
			{
				protocol_FeaturesIdMap.put(protocol_FeaturesIds.get(i), protocol_FeaturesList.get(i).getAutoid());
			}
		}	 
	}
	/**
	 * Imports Panel_Individuals from tab/comma delimited File.
	 * @param Panel_IndividualsFile a tab delimited file with Panel_Individuals data.
	 */
	private static void importPanel_Individuals(Database db, File Panel_IndividualsFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+Panel_IndividualsFile);
		if(	!Panel_IndividualsFile.exists() )
		{
			logger.warn("Panel_Individuals.txt file is missing, skipped import");
		}
		else
		{
			//read Panel_Individuals from file
			CsvReader reader = new CsvFileReader(Panel_IndividualsFile);
			List<Panel_Individuals> panel_IndividualsList = db.toList(Panel_Individuals.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+panel_IndividualsList.size()+" Panel_Individuals objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> panel_IndividualsIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < panel_IndividualsList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Panel_Individuals object = panel_IndividualsList.get(i);
				
				//remember index of this id for incoming fkeys
				panel_IndividualsIds.add(object.getAutoid()); 
				
				//redirect outgoing fkeys
				if(object.getIndividuals() != null) object.setIndividuals_Id(individualIdMap.get(object.getIndividuals_Id()));
				if(object.getPanel() != null) object.setPanel_Id(panelIdMap.get(object.getPanel_Id()));
				
				//add assay back to list
				panel_IndividualsList.set(i, object);
			}
			//add to database
			db.add(panel_IndividualsList);
			for(int i = 0; i < panel_IndividualsList.size(); i++)
			{
				panel_IndividualsIdMap.put(panel_IndividualsIds.get(i), panel_IndividualsList.get(i).getAutoid());
			}
		}	 
	}
	/**
	 * Imports Experiment_AssayedPanels from tab/comma delimited File.
	 * @param Experiment_AssayedPanelsFile a tab delimited file with Experiment_AssayedPanels data.
	 */
	private static void importExperiment_AssayedPanels(Database db, File Experiment_AssayedPanelsFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+Experiment_AssayedPanelsFile);
		if(	!Experiment_AssayedPanelsFile.exists() )
		{
			logger.warn("Experiment_AssayedPanels.txt file is missing, skipped import");
		}
		else
		{
			//read Experiment_AssayedPanels from file
			CsvReader reader = new CsvFileReader(Experiment_AssayedPanelsFile);
			List<Experiment_AssayedPanels> experiment_AssayedPanelsList = db.toList(Experiment_AssayedPanels.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+experiment_AssayedPanelsList.size()+" Experiment_AssayedPanels objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> experiment_AssayedPanelsIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < experiment_AssayedPanelsList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Experiment_AssayedPanels object = experiment_AssayedPanelsList.get(i);
				
				//remember index of this id for incoming fkeys
				experiment_AssayedPanelsIds.add(object.getAutoid()); 
				
				//redirect outgoing fkeys
				if(object.getAssayedPanels() != null) object.setAssayedPanels_Id(panelIdMap.get(object.getAssayedPanels_Id()));
				if(object.getExperiment() != null) object.setExperiment_Id(experimentIdMap.get(object.getExperiment_Id()));
				
				//add assay back to list
				experiment_AssayedPanelsList.set(i, object);
			}
			//add to database
			db.add(experiment_AssayedPanelsList);
			for(int i = 0; i < experiment_AssayedPanelsList.size(); i++)
			{
				experiment_AssayedPanelsIdMap.put(experiment_AssayedPanelsIds.get(i), experiment_AssayedPanelsList.get(i).getAutoid());
			}
		}	 
	}
	/**
	 * Imports Person_AffiliateInstitutions from tab/comma delimited File.
	 * @param Person_AffiliateInstitutionsFile a tab delimited file with Person_AffiliateInstitutions data.
	 */
	private static void importPerson_AffiliateInstitutions(Database db, File Person_AffiliateInstitutionsFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+Person_AffiliateInstitutionsFile);
		if(	!Person_AffiliateInstitutionsFile.exists() )
		{
			logger.warn("Person_AffiliateInstitutions.txt file is missing, skipped import");
		}
		else
		{
			//read Person_AffiliateInstitutions from file
			CsvReader reader = new CsvFileReader(Person_AffiliateInstitutionsFile);
			List<Person_AffiliateInstitutions> person_AffiliateInstitutionsList = db.toList(Person_AffiliateInstitutions.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+person_AffiliateInstitutionsList.size()+" Person_AffiliateInstitutions objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> person_AffiliateInstitutionsIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < person_AffiliateInstitutionsList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Person_AffiliateInstitutions object = person_AffiliateInstitutionsList.get(i);
				
				//remember index of this id for incoming fkeys
				person_AffiliateInstitutionsIds.add(object.getAutoid()); 
				
				//redirect outgoing fkeys
				if(object.getAffiliateInstitutions() != null) object.setAffiliateInstitutions_Id(instituteIdMap.get(object.getAffiliateInstitutions_Id()));
				if(object.getPerson() != null) object.setPerson_Id(personIdMap.get(object.getPerson_Id()));
				
				//add assay back to list
				person_AffiliateInstitutionsList.set(i, object);
			}
			//add to database
			db.add(person_AffiliateInstitutionsList);
			for(int i = 0; i < person_AffiliateInstitutionsList.size(); i++)
			{
				person_AffiliateInstitutionsIdMap.put(person_AffiliateInstitutionsIds.get(i), person_AffiliateInstitutionsList.get(i).getAutoid());
			}
		}	 
	}
	/**
	 * Imports Citation_OntologyTerms from tab/comma delimited File.
	 * @param Citation_ontologyTermsFile a tab delimited file with Citation_OntologyTerms data.
	 */
	private static void importCitation_OntologyTerms(Database db, File Citation_ontologyTermsFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+Citation_ontologyTermsFile);
		if(	!Citation_ontologyTermsFile.exists() )
		{
			logger.warn("Citation_ontologyTerms.txt file is missing, skipped import");
		}
		else
		{
			//read Citation_ontologyTerms from file
			CsvReader reader = new CsvFileReader(Citation_ontologyTermsFile);
			List<Citation_OntologyTerms> citation_ontologyTermsList = db.toList(Citation_OntologyTerms.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+citation_ontologyTermsList.size()+" Citation_ontologyTerms objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> citation_ontologyTermsIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < citation_ontologyTermsList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Citation_OntologyTerms object = citation_ontologyTermsList.get(i);
				
				//remember index of this id for incoming fkeys
				citation_ontologyTermsIds.add(object.getAutoid()); 
				
				//redirect outgoing fkeys
				if(object.getOntologyTerms() != null) object.setOntologyTerms_Id(ontologyTermIdMap.get(object.getOntologyTerms_Id()));
				if(object.getCitation() != null) object.setCitation_Id(citationIdMap.get(object.getCitation_Id()));
				
				//add assay back to list
				citation_ontologyTermsList.set(i, object);
			}
			//add to database
			db.add(citation_ontologyTermsList);
			for(int i = 0; i < citation_ontologyTermsList.size(); i++)
			{
				citation_ontologyTermsIdMap.put(citation_ontologyTermsIds.get(i), citation_ontologyTermsList.get(i).getAutoid());
			}
		}	 
	}
	/**
	 * Imports StudyDetails_OtherCitations from tab/comma delimited File.
	 * @param StudyDetails_otherCitationsFile a tab delimited file with StudyDetails_OtherCitations data.
	 */
	private static void importStudyDetails_OtherCitations(Database db, File StudyDetails_otherCitationsFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+StudyDetails_otherCitationsFile);
		if(	!StudyDetails_otherCitationsFile.exists() )
		{
			logger.warn("StudyDetails_otherCitations.txt file is missing, skipped import");
		}
		else
		{
			//read StudyDetails_otherCitations from file
			CsvReader reader = new CsvFileReader(StudyDetails_otherCitationsFile);
			List<StudyDetails_OtherCitations> studyDetails_otherCitationsList = db.toList(StudyDetails_OtherCitations.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+studyDetails_otherCitationsList.size()+" StudyDetails_otherCitations objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> studyDetails_otherCitationsIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < studyDetails_otherCitationsList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				StudyDetails_OtherCitations object = studyDetails_otherCitationsList.get(i);
				
				//remember index of this id for incoming fkeys
				studyDetails_otherCitationsIds.add(object.getAutoid()); 
				
				//redirect outgoing fkeys
				if(object.getOtherCitations() != null) object.setOtherCitations_Id(citationIdMap.get(object.getOtherCitations_Id()));
				if(object.getStudyDetails() != null) object.setStudyDetails_Id(studyDetailsIdMap.get(object.getStudyDetails_Id()));
				
				//add assay back to list
				studyDetails_otherCitationsList.set(i, object);
			}
			//add to database
			db.add(studyDetails_otherCitationsList);
			for(int i = 0; i < studyDetails_otherCitationsList.size(); i++)
			{
				studyDetails_otherCitationsIdMap.put(studyDetails_otherCitationsIds.get(i), studyDetails_otherCitationsList.get(i).getAutoid());
			}
		}	 
	}
	/**
	 * Imports ObservationSet from tab/comma delimited File.
	 * @param ObservationSetFile a tab delimited file with ObservationSet data.
	 */
	private static void importObservationSet(Database db, File ObservationSetFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+ObservationSetFile);
		if(	!ObservationSetFile.exists() )
		{
			logger.warn("ObservationSet.txt file is missing, skipped import");
		}
		else
		{
			//read ObservationSet from file
			CsvReader reader = new CsvFileReader(ObservationSetFile);
			List<ObservationSet> observationSetList = db.toList(ObservationSet.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+observationSetList.size()+" ObservationSet objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> observationSetIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < observationSetList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				ObservationSet object = observationSetList.get(i);
				
				//remember index of this id for incoming fkeys
				observationSetIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getPartOfDataSet() != null) object.setPartOfDataSet_Id(dataSetIdMap.get(object.getPartOfDataSet_Id()));
				if(object.getTarget() != null) object.setTarget_Id(characteristicIdMap.get(object.getTarget_Id()));
				
				//add assay back to list
				observationSetList.set(i, object);
			}
			//add to database
			db.add(observationSetList);
			for(int i = 0; i < observationSetList.size(); i++)
			{
				observationSetIdMap.put(observationSetIds.get(i), observationSetList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports ObservedValue from tab/comma delimited File.
	 * @param ObservedValueFile a tab delimited file with ObservedValue data.
	 */
	private static void importObservedValue(Database db, File ObservedValueFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+ObservedValueFile);
		if(	!ObservedValueFile.exists() )
		{
			logger.warn("ObservedValue.txt file is missing, skipped import");
		}
		else
		{
			//read ObservedValue from file
			CsvReader reader = new CsvFileReader(ObservedValueFile);
			List<ObservedValue> observedValueList = db.toList(ObservedValue.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+observedValueList.size()+" ObservedValue objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> observedValueIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < observedValueList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				ObservedValue object = observedValueList.get(i);
				
				//remember index of this id for incoming fkeys
				observedValueIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getObservationSet() != null) object.setObservationSet_Id(observationSetIdMap.get(object.getObservationSet_Id()));
				if(object.getFeature() != null) object.setFeature_Id(observableFeatureIdMap.get(object.getFeature_Id()));
				if(object.getCharacteristic() != null) object.setCharacteristic_Id(characteristicIdMap.get(object.getCharacteristic_Id()));
				
				//add assay back to list
				observedValueList.set(i, object);
			}
			//add to database
			db.add(observedValueList);
			for(int i = 0; i < observedValueList.size(); i++)
			{
				observedValueIdMap.put(observedValueIds.get(i), observedValueList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports FrequencyCluster from tab/comma delimited File.
	 * @param FrequencyClusterFile a tab delimited file with FrequencyCluster data.
	 */
	private static void importFrequencyCluster(Database db, File FrequencyClusterFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+FrequencyClusterFile);
		if(	!FrequencyClusterFile.exists() )
		{
			logger.warn("FrequencyCluster.txt file is missing, skipped import");
		}
		else
		{
			//read FrequencyCluster from file
			CsvReader reader = new CsvFileReader(FrequencyClusterFile);
			List<FrequencyCluster> frequencyClusterList = db.toList(FrequencyCluster.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+frequencyClusterList.size()+" FrequencyCluster objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> frequencyClusterIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < frequencyClusterList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				FrequencyCluster object = frequencyClusterList.get(i);
				
				//remember index of this id for incoming fkeys
				frequencyClusterIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getProtocolUsed() != null) object.setProtocolUsed_Id(protocolIdMap.get(object.getProtocolUsed_Id()));
				if(object.getDataSet() != null) object.setDataSet_Id(dataSetIdMap.get(object.getDataSet_Id()));
				if(object.getUsedMarkerSet() != null) object.setUsedMarkerSet_Id(usedMarkerSetIdMap.get(object.getUsedMarkerSet_Id()));
				
				//add assay back to list
				frequencyClusterList.set(i, object);
			}
			//add to database
			db.add(frequencyClusterList);
			for(int i = 0; i < frequencyClusterList.size(); i++)
			{
				frequencyClusterIdMap.put(frequencyClusterIds.get(i), frequencyClusterList.get(i).getId());
				characteristicIdMap.put(frequencyClusterIds.get(i), frequencyClusterList.get(i).getId());
				dataSetIdMap.put(frequencyClusterIds.get(i), frequencyClusterList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports GenotypeFrequency from tab/comma delimited File.
	 * @param GenotypeFrequencyFile a tab delimited file with GenotypeFrequency data.
	 */
	private static void importGenotypeFrequency(Database db, File GenotypeFrequencyFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+GenotypeFrequencyFile);
		if(	!GenotypeFrequencyFile.exists() )
		{
			logger.warn("GenotypeFrequency.txt file is missing, skipped import");
		}
		else
		{
			//read GenotypeFrequency from file
			CsvReader reader = new CsvFileReader(GenotypeFrequencyFile);
			List<GenotypeFrequency> genotypeFrequencyList = db.toList(GenotypeFrequency.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+genotypeFrequencyList.size()+" GenotypeFrequency objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> genotypeFrequencyIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < genotypeFrequencyList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				GenotypeFrequency object = genotypeFrequencyList.get(i);
				
				//remember index of this id for incoming fkeys
				genotypeFrequencyIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getProtocolUsed() != null) object.setProtocolUsed_Id(protocolIdMap.get(object.getProtocolUsed_Id()));
				if(object.getFrequencyCluster() != null) object.setFrequencyCluster_Id(frequencyClusterIdMap.get(object.getFrequencyCluster_Id()));
				
				//add assay back to list
				genotypeFrequencyList.set(i, object);
			}
			//add to database
			db.add(genotypeFrequencyList);
			for(int i = 0; i < genotypeFrequencyList.size(); i++)
			{
				genotypeFrequencyIdMap.put(genotypeFrequencyIds.get(i), genotypeFrequencyList.get(i).getId());
				characteristicIdMap.put(genotypeFrequencyIds.get(i), genotypeFrequencyList.get(i).getId());
				dataSetIdMap.put(genotypeFrequencyIds.get(i), genotypeFrequencyList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports AlleleFrequency from tab/comma delimited File.
	 * @param AlleleFrequencyFile a tab delimited file with AlleleFrequency data.
	 */
	private static void importAlleleFrequency(Database db, File AlleleFrequencyFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+AlleleFrequencyFile);
		if(	!AlleleFrequencyFile.exists() )
		{
			logger.warn("AlleleFrequency.txt file is missing, skipped import");
		}
		else
		{
			//read AlleleFrequency from file
			CsvReader reader = new CsvFileReader(AlleleFrequencyFile);
			List<AlleleFrequency> alleleFrequencyList = db.toList(AlleleFrequency.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+alleleFrequencyList.size()+" AlleleFrequency objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> alleleFrequencyIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < alleleFrequencyList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				AlleleFrequency object = alleleFrequencyList.get(i);
				
				//remember index of this id for incoming fkeys
				alleleFrequencyIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getProtocolUsed() != null) object.setProtocolUsed_Id(protocolIdMap.get(object.getProtocolUsed_Id()));
				if(object.getFrequencyCluster() != null) object.setFrequencyCluster_Id(frequencyClusterIdMap.get(object.getFrequencyCluster_Id()));
				
				//add assay back to list
				alleleFrequencyList.set(i, object);
			}
			//add to database
			db.add(alleleFrequencyList);
			for(int i = 0; i < alleleFrequencyList.size(); i++)
			{
				alleleFrequencyIdMap.put(alleleFrequencyIds.get(i), alleleFrequencyList.get(i).getId());
				characteristicIdMap.put(alleleFrequencyIds.get(i), alleleFrequencyList.get(i).getId());
				dataSetIdMap.put(alleleFrequencyIds.get(i), alleleFrequencyList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports PhenotypeValue from tab/comma delimited File.
	 * @param PhenotypeValueFile a tab delimited file with PhenotypeValue data.
	 */
	private static void importPhenotypeValue(Database db, File PhenotypeValueFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+PhenotypeValueFile);
		if(	!PhenotypeValueFile.exists() )
		{
			logger.warn("PhenotypeValue.txt file is missing, skipped import");
		}
		else
		{
			//read PhenotypeValue from file
			CsvReader reader = new CsvFileReader(PhenotypeValueFile);
			List<PhenotypeValue> phenotypeValueList = db.toList(PhenotypeValue.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+phenotypeValueList.size()+" PhenotypeValue objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> phenotypeValueIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < phenotypeValueList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				PhenotypeValue object = phenotypeValueList.get(i);
				
				//remember index of this id for incoming fkeys
				phenotypeValueIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getObservationSet() != null) object.setObservationSet_Id(observationSetIdMap.get(object.getObservationSet_Id()));
				if(object.getFeature() != null) object.setFeature_Id(observableFeatureIdMap.get(object.getFeature_Id()));
				if(object.getCharacteristic() != null) object.setCharacteristic_Id(characteristicIdMap.get(object.getCharacteristic_Id()));
				if(object.getPhenotypePropertyID() != null) object.setPhenotypePropertyID_Id(phenotypePropertyIdMap.get(object.getPhenotypePropertyID_Id()));
				
				//add assay back to list
				phenotypeValueList.set(i, object);
			}
			//add to database
			db.add(phenotypeValueList);
			for(int i = 0; i < phenotypeValueList.size(); i++)
			{
				phenotypeValueIdMap.put(phenotypeValueIds.get(i), phenotypeValueList.get(i).getId());
				observedValueIdMap.put(phenotypeValueIds.get(i), phenotypeValueList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Experiment_DataSets from tab/comma delimited File.
	 * @param Experiment_DataSetsFile a tab delimited file with Experiment_DataSets data.
	 */
	private static void importExperiment_DataSets(Database db, File Experiment_DataSetsFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+Experiment_DataSetsFile);
		if(	!Experiment_DataSetsFile.exists() )
		{
			logger.warn("Experiment_DataSets.txt file is missing, skipped import");
		}
		else
		{
			//read Experiment_DataSets from file
			CsvReader reader = new CsvFileReader(Experiment_DataSetsFile);
			List<Experiment_DataSets> experiment_DataSetsList = db.toList(Experiment_DataSets.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+experiment_DataSetsList.size()+" Experiment_DataSets objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> experiment_DataSetsIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < experiment_DataSetsList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Experiment_DataSets object = experiment_DataSetsList.get(i);
				
				//remember index of this id for incoming fkeys
				experiment_DataSetsIds.add(object.getAutoid()); 
				
				//redirect outgoing fkeys
				if(object.getDataSets() != null) object.setDataSets_Id(dataSetIdMap.get(object.getDataSets_Id()));
				if(object.getExperiment() != null) object.setExperiment_Id(experimentIdMap.get(object.getExperiment_Id()));
				
				//add assay back to list
				experiment_DataSetsList.set(i, object);
			}
			//add to database
			db.add(experiment_DataSetsList);
			for(int i = 0; i < experiment_DataSetsList.size(); i++)
			{
				experiment_DataSetsIdMap.put(experiment_DataSetsIds.get(i), experiment_DataSetsList.get(i).getAutoid());
			}
		}	 
	}
}