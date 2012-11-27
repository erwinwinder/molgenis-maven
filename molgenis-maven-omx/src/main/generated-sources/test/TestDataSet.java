/* File:        app/JUnitTest.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 26, 2012
 * 
 * generator:   org.molgenis.generators.tests.TestDataSetGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import org.molgenis.Molgenis;
import org.molgenis.util.Entity;
import org.molgenis.util.SimpleTuple;
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
 * This class produces a random data set
 */
public class TestDataSet
{
	//private static Database db;
	private static final Logger logger = Logger.getLogger(TestCsv.class);
	DateFormat dateFormat = new SimpleDateFormat(SimpleTuple.DATEFORMAT, Locale.US);
	DateFormat dateTimeFormat = new SimpleDateFormat(SimpleTuple.DATETIMEFORMAT, Locale.US);	 
	
	/**
	 * An empty set
	 */	
	public TestDataSet()
	{	
	}
		
	

    public TestDataSet(int size, int mrefSize) 
	{
		//generating MolgenisEntity data:
		for(Integer i = 0; i < size; i++)
		{
			MolgenisEntity e = new MolgenisEntity();
			//assign field name
			e.setName(truncate("molgenisentity_name_"+i, 255));			
			//assign field type_
			e.setType(truncate("molgenisentity_type__"+i, 255));			
			//assign field className
			e.setClassName(truncate("molgenisentity_classname_"+i, 255));			
			this.molgenisEntity.add(e);
		}		
		//generating MolgenisFile data:
		for(Integer i = 0; i < size; i++)
		{
			MolgenisFile e = new MolgenisFile();
			//assign field Identifier
			e.setIdentifier(truncate("molgenisfile_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("molgenisfile_name_"+i, 255));			
			//assign field Extension
			e.setExtension(truncate("molgenisfile_extension_"+i, 8));			
			this.molgenisFile.add(e);
		}		
		//generating RuntimeProperty data:
		for(Integer i = 0; i < size; i++)
		{
			RuntimeProperty e = new RuntimeProperty();
			//assign field Identifier
			e.setIdentifier(truncate("runtimeproperty_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("runtimeproperty_name_"+i, 255));			
			//assign field Value
			e.setValue(truncate("runtimeproperty_value_"+i, 127));			
			this.runtimeProperty.add(e);
		}		
		//generating MolgenisRole data:
		for(Integer i = 0; i < size; i++)
		{
			MolgenisRole e = new MolgenisRole();
			//assign field name
			e.setName(truncate("molgenisrole_name_"+i, 255));			
			this.molgenisRole.add(e);
		}		
		//generating MolgenisGroup data:
		for(Integer i = 0; i < size; i++)
		{
			MolgenisGroup e = new MolgenisGroup();
			//assign field name
			e.setName(truncate("molgenisgroup_name_"+i, 255));			
			this.molgenisGroup.add(e);
		}		
		//generating MolgenisUser data:
		for(Integer i = 0; i < size; i++)
		{
			MolgenisUser e = new MolgenisUser();
			//assign field username
			e.setUsername(truncate("molgenisuser_username_"+i, 255));			
			//assign field password_
			e.setPassword(truncate("molgenisuser_password__"+i, 255));			
			//assign field activationCode
			e.setActivationCode(truncate("molgenisuser_activationcode_"+i, 255));			
			//assign field active
			e.setActive(randomBool(i));
			//assign field superuser
			e.setSuperuser(randomBool(i));
			this.molgenisUser.add(e);
		}		
		//generating MolgenisRoleGroupLink data:
		for(Integer i = 0; i < size; i++)
		{
			MolgenisRoleGroupLink e = new MolgenisRoleGroupLink();
			//assign field Identifier
			e.setIdentifier(truncate("molgenisrolegrouplink_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("molgenisrolegrouplink_name_"+i, 255));			
			//assign field group_
			if( this.molgenisGroup.size() > 0  && i < this.molgenisGroup.size())
			{ 
				MolgenisGroup ref = this.molgenisGroup.get(i);
				e.setGroup_Name(ref.getName() );
			}
			//assign field role_
			if( this.molgenisRole.size() > 0  && i < this.molgenisRole.size())
			{ 
				MolgenisRole ref = this.molgenisRole.get(i);
				e.setRole_Name(ref.getName() );
			}
			this.molgenisRoleGroupLink.add(e);
		}		
		//generating MolgenisPermission data:
		for(Integer i = 0; i < size; i++)
		{
			MolgenisPermission e = new MolgenisPermission();
			//assign field role_
			if( this.molgenisRole.size() > 0  && i < this.molgenisRole.size())
			{ 
				MolgenisRole ref = this.molgenisRole.get(i);
				e.setRole_Name(ref.getName() );
			}
			//assign field entity
			if( this.molgenisEntity.size() > 0  && i < this.molgenisEntity.size())
			{ 
				MolgenisEntity ref = this.molgenisEntity.get(i);
				e.setEntity_ClassName(ref.getClassName() );
			}
			//assign field permission
			e.setPermission(randomEnum(new String[]{"read","write","own"}));
			this.molgenisPermission.add(e);
		}		
		//generating Characteristic data:
		for(Integer i = 0; i < size; i++)
		{
			Characteristic e = new Characteristic();
			//assign field Identifier
			e.setIdentifier(truncate("characteristic_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("characteristic_name_"+i, 255));			
			//assign field description
			e.setDescription("characteristic_description"+i);
			this.characteristic.add(e);
		}		
		//generating ObservationTarget data:
		for(Integer i = 0; i < size; i++)
		{
			ObservationTarget e = new ObservationTarget();
			//assign field Identifier
			e.setIdentifier(truncate("observationtarget_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("observationtarget_name_"+i, 255));			
			//assign field description
			e.setDescription("observationtarget_description"+i);
			this.observationTarget.add(e);
		}		
		//generating Individual data:
		for(Integer i = 0; i < size; i++)
		{
			Individual e = new Individual();
			//assign field Identifier
			e.setIdentifier(truncate("individual_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("individual_name_"+i, 255));			
			//assign field description
			e.setDescription("individual_description"+i);
			//assign field Mother
			//ignoring cyclic relationship which would break the tests
			//assign field Father
			//ignoring cyclic relationship which would break the tests
			this.individual.add(e);
		}		
		//generating Ontology data:
		for(Integer i = 0; i < size; i++)
		{
			Ontology e = new Ontology();
			//assign field Identifier
			e.setIdentifier(truncate("ontology_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("ontology_name_"+i, 255));			
			//assign field ontologyAccession
			e.setOntologyAccession(truncate("ontology_ontologyaccession_"+i, 255));			
			//assign field ontologyURI
			e.setOntologyURI("ontology_ontologyuri"+i);
			this.ontology.add(e);
		}		
		//generating Species data:
		for(Integer i = 0; i < size; i++)
		{
			Species e = new Species();
			//assign field Identifier
			e.setIdentifier(truncate("species_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("species_name_"+i, 255));			
			//assign field ontology
			if( this.ontology.size() > 0  && i < this.ontology.size())
			{ 
				Ontology ref = this.ontology.get(i);
				e.setOntology_Identifier(ref.getIdentifier() );
			}
			//assign field termAccession
			e.setTermAccession(truncate("species_termaccession_"+i, 255));			
			//assign field definition
			e.setDefinition(truncate("species_definition_"+i, 255));			
			this.species.add(e);
		}		
		//generating OntologyTerm data:
		for(Integer i = 0; i < size; i++)
		{
			OntologyTerm e = new OntologyTerm();
			//assign field Identifier
			e.setIdentifier(truncate("ontologyterm_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("ontologyterm_name_"+i, 255));			
			//assign field ontology
			if( this.ontology.size() > 0  && i < this.ontology.size())
			{ 
				Ontology ref = this.ontology.get(i);
				e.setOntology_Identifier(ref.getIdentifier() );
			}
			//assign field termAccession
			e.setTermAccession(truncate("ontologyterm_termaccession_"+i, 255));			
			//assign field definition
			e.setDefinition(truncate("ontologyterm_definition_"+i, 255));			
			this.ontologyTerm.add(e);
		}		
		//generating Accession data:
		for(Integer i = 0; i < size; i++)
		{
			Accession e = new Accession();
			//assign field Identifier
			e.setIdentifier(truncate("accession_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("accession_name_"+i, 255));			
			//assign field ontology
			if( this.ontology.size() > 0  && i < this.ontology.size())
			{ 
				Ontology ref = this.ontology.get(i);
				e.setOntology_Identifier(ref.getIdentifier() );
			}
			//assign field termAccession
			e.setTermAccession(truncate("accession_termaccession_"+i, 255));			
			//assign field definition
			e.setDefinition(truncate("accession_definition_"+i, 255));			
			this.accession.add(e);
		}		
		//generating ObservableFeature data:
		for(Integer i = 0; i < size; i++)
		{
			ObservableFeature e = new ObservableFeature();
			//assign field Identifier
			e.setIdentifier(truncate("observablefeature_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("observablefeature_name_"+i, 255));			
			//assign field description
			e.setDescription("observablefeature_description"+i);
			//assign field unit
			if( this.ontologyTerm.size() > 0  && i < this.ontologyTerm.size())
			{ 
				OntologyTerm ref = this.ontologyTerm.get(i);
				e.setUnit_Identifier(ref.getIdentifier() );
			}
			//assign field dataType
			e.setDataType(randomEnum(new String[]{"xref","string","categorical","nominal","ordinal","date","datetime","int","code","image","decimal","bool","file","log","data","exe"}));
			//assign field temporal
			e.setTemporal(randomBool(i));
			this.observableFeature.add(e);
		}		
		//generating Protocol data:
		for(Integer i = 0; i < size; i++)
		{
			Protocol e = new Protocol();
			//assign field Identifier
			e.setIdentifier(truncate("protocol_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("protocol_name_"+i, 255));			
			//assign field description
			e.setDescription("protocol_description"+i);
			//assign field ProtocolType
			if( this.ontologyTerm.size() > 0  && i < this.ontologyTerm.size())
			{ 
				OntologyTerm ref = this.ontologyTerm.get(i);
				e.setProtocolType_Identifier(ref.getIdentifier() );
			}
			//assign field subprotocols
			//ignoring cyclic relationship which would break the tests
			//assign field Features
			if( this.observableFeature.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.observableFeature.size() ? j : this.observableFeature.size()-1);
				}
				List<String> IdentifierList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					IdentifierList.add( this.observableFeature.get(index).getIdentifier() );
				}
				e.setFeatures_Identifier( IdentifierList );
			}
			this.protocol.add(e);
		}		
		//generating DataSet data:
		for(Integer i = 0; i < size; i++)
		{
			DataSet e = new DataSet();
			//assign field Identifier
			e.setIdentifier(truncate("dataset_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("dataset_name_"+i, 255));			
			//assign field description
			e.setDescription("dataset_description"+i);
			//assign field ProtocolUsed
			if( this.protocol.size() > 0  && i < this.protocol.size())
			{ 
				Protocol ref = this.protocol.get(i);
				e.setProtocolUsed_Identifier(ref.getIdentifier() );
			}
			this.dataSet.add(e);
		}		
		//generating Panel data:
		for(Integer i = 0; i < size; i++)
		{
			Panel e = new Panel();
			//assign field Identifier
			e.setIdentifier(truncate("panel_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("panel_name_"+i, 255));			
			//assign field description
			e.setDescription("panel_description"+i);
			//assign field PanelType
			if( this.ontologyTerm.size() > 0  && i < this.ontologyTerm.size())
			{ 
				OntologyTerm ref = this.ontologyTerm.get(i);
				e.setPanelType_Identifier(ref.getIdentifier() );
			}
			//assign field NumberOfIndividuals
			e.setNumberOfIndividuals(i);
			//assign field Species
			if( this.species.size() > 0  && i < this.species.size())
			{ 
				Species ref = this.species.get(i);
				e.setSpecies_Identifier(ref.getIdentifier() );
			}
			//assign field Individuals
			if( this.individual.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.individual.size() ? j : this.individual.size()-1);
				}
				List<String> IdentifierList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					IdentifierList.add( this.individual.get(index).getIdentifier() );
				}
				e.setIndividuals_Identifier( IdentifierList );
			}
			this.panel.add(e);
		}		
		//generating Genome data:
		for(Integer i = 0; i < size; i++)
		{
			Genome e = new Genome();
			//assign field Identifier
			e.setIdentifier(truncate("genome_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("genome_name_"+i, 255));			
			//assign field description
			e.setDescription("genome_description"+i);
			//assign field residues
			e.setResidues("genome_residues"+i);
			//assign field seqlen
			e.setSeqlen(i);
			//assign field species
			if( this.species.size() > 0  && i < this.species.size())
			{ 
				Species ref = this.species.get(i);
				e.setSpecies_Identifier(ref.getIdentifier() );
			}
			this.genome.add(e);
		}		
		//generating Chromosome data:
		for(Integer i = 0; i < size; i++)
		{
			Chromosome e = new Chromosome();
			//assign field Identifier
			e.setIdentifier(truncate("chromosome_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("chromosome_name_"+i, 255));			
			//assign field description
			e.setDescription("chromosome_description"+i);
			//assign field residues
			e.setResidues("chromosome_residues"+i);
			//assign field seqlen
			e.setSeqlen(i);
			//assign field genome
			if( this.genome.size() > 0  && i < this.genome.size())
			{ 
				Genome ref = this.genome.get(i);
				e.setGenome_Identifier(ref.getIdentifier() );
			}
			//assign field orderNr
			e.setOrderNr(i);
			//assign field isAutosomal
			e.setIsAutosomal(randomBool(i));
			this.chromosome.add(e);
		}		
		//generating Gene data:
		for(Integer i = 0; i < size; i++)
		{
			Gene e = new Gene();
			//assign field Identifier
			e.setIdentifier(truncate("gene_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("gene_name_"+i, 255));			
			//assign field description
			e.setDescription("gene_description"+i);
			//assign field gdna
			if( this.chromosome.size() > 0  && i < this.chromosome.size())
			{ 
				Chromosome ref = this.chromosome.get(i);
				e.setGdna_Identifier(ref.getIdentifier() );
			}
			//assign field gdna_start
			e.setGdna_Start(i);
			//assign field gdna_end
			e.setGdna_End(i);
			//assign field residues
			e.setResidues("gene_residues"+i);
			//assign field seqlen
			e.setSeqlen(i);
			//assign field strand
			e.setStrand(randomEnum(new String[]{"0","-1","+1"}));
			this.gene.add(e);
		}		
		//generating Protein data:
		for(Integer i = 0; i < size; i++)
		{
			Protein e = new Protein();
			//assign field Identifier
			e.setIdentifier(truncate("protein_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("protein_name_"+i, 255));			
			//assign field description
			e.setDescription("protein_description"+i);
			//assign field cdna
			if( this.gene.size() > 0  && i < this.gene.size())
			{ 
				Gene ref = this.gene.get(i);
				e.setCdna_Identifier(ref.getIdentifier() );
			}
			//assign field cdna_start
			e.setCdna_Start(i);
			//assign field cdna_end
			e.setCdna_End(i);
			//assign field residues
			e.setResidues("protein_residues"+i);
			//assign field seqlen
			e.setSeqlen(i);
			this.protein.add(e);
		}		
		//generating ProteinDomain data:
		for(Integer i = 0; i < size; i++)
		{
			ProteinDomain e = new ProteinDomain();
			//assign field Identifier
			e.setIdentifier(truncate("proteindomain_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("proteindomain_name_"+i, 255));			
			//assign field description
			e.setDescription("proteindomain_description"+i);
			//assign field cdna
			if( this.gene.size() > 0  && i < this.gene.size())
			{ 
				Gene ref = this.gene.get(i);
				e.setCdna_Identifier(ref.getIdentifier() );
			}
			//assign field cdna_start
			e.setCdna_Start(i);
			//assign field cdna_end
			e.setCdna_End(i);
			//assign field gdna
			if( this.chromosome.size() > 0  && i < this.chromosome.size())
			{ 
				Chromosome ref = this.chromosome.get(i);
				e.setGdna_Identifier(ref.getIdentifier() );
			}
			//assign field gdna_start
			e.setGdna_Start(i);
			//assign field gdna_end
			e.setGdna_End(i);
			this.proteinDomain.add(e);
		}		
		//generating Exon data:
		for(Integer i = 0; i < size; i++)
		{
			Exon e = new Exon();
			//assign field Identifier
			e.setIdentifier(truncate("exon_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("exon_name_"+i, 255));			
			//assign field description
			e.setDescription("exon_description"+i);
			//assign field cdna
			if( this.gene.size() > 0  && i < this.gene.size())
			{ 
				Gene ref = this.gene.get(i);
				e.setCdna_Identifier(ref.getIdentifier() );
			}
			//assign field cdna_start
			e.setCdna_Start(i);
			//assign field cdna_end
			e.setCdna_End(i);
			//assign field gdna
			if( this.chromosome.size() > 0  && i < this.chromosome.size())
			{ 
				Chromosome ref = this.chromosome.get(i);
				e.setGdna_Identifier(ref.getIdentifier() );
			}
			//assign field gdna_start
			e.setGdna_Start(i);
			//assign field gdna_end
			e.setGdna_End(i);
			//assign field isIntron
			e.setIsIntron(randomBool(i));
			this.exon.add(e);
		}		
		//generating Variant data:
		for(Integer i = 0; i < size; i++)
		{
			Variant e = new Variant();
			//assign field Identifier
			e.setIdentifier(truncate("variant_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("variant_name_"+i, 255));			
			//assign field description
			e.setDescription("variant_description"+i);
			//assign field gdna
			if( this.chromosome.size() > 0  && i < this.chromosome.size())
			{ 
				Chromosome ref = this.chromosome.get(i);
				e.setGdna_Identifier(ref.getIdentifier() );
			}
			//assign field gdna_start
			e.setGdna_Start(i);
			//assign field gdna_end
			e.setGdna_End(i);
			//assign field cdna
			if( this.gene.size() > 0  && i < this.gene.size())
			{ 
				Gene ref = this.gene.get(i);
				e.setCdna_Identifier(ref.getIdentifier() );
			}
			//assign field cdna_start
			e.setCdna_Start(i);
			//assign field cdna_end
			e.setCdna_End(i);
			//assign field aa
			if( this.protein.size() > 0  && i < this.protein.size())
			{ 
				Protein ref = this.protein.get(i);
				e.setAa_Identifier(ref.getIdentifier() );
			}
			//assign field aa_start
			e.setAa_Start(i);
			//assign field aa_end
			e.setAa_End(i);
			//assign field gdna_notation
			e.setGdna_Notation(truncate("variant_gdna_notation_"+i, 255));			
			//assign field cdna_notation
			e.setCdna_Notation(truncate("variant_cdna_notation_"+i, 255));			
			//assign field aa_notation
			e.setAa_Notation(truncate("variant_aa_notation_"+i, 255));			
			//assign field variantType
			if( this.ontologyTerm.size() > 0  && i < this.ontologyTerm.size())
			{ 
				OntologyTerm ref = this.ontologyTerm.get(i);
				e.setVariantType_Identifier(ref.getIdentifier() );
			}
			this.variant.add(e);
		}		
		//generating Institute data:
		for(Integer i = 0; i < size; i++)
		{
			Institute e = new Institute();
			//assign field name
			e.setName(truncate("institute_name_"+i, 255));			
			//assign field Address
			e.setAddress("institute_address"+i);
			//assign field Phone
			e.setPhone(truncate("institute_phone_"+i, 255));			
			//assign field City
			e.setCity(truncate("institute_city_"+i, 255));			
			//assign field Country
			e.setCountry(truncate("institute_country_"+i, 255));			
			//assign field Fax
			e.setFax(truncate("institute_fax_"+i, 255));			
			this.institute.add(e);
		}		
		//generating Person data:
		for(Integer i = 0; i < size; i++)
		{
			Person e = new Person();
			//assign field Name
			e.setName(truncate("person_name_"+i, 255));			
			//assign field Title
			e.setTitle(truncate("person_title_"+i, 255));			
			//assign field FirstName
			e.setFirstName(truncate("person_firstname_"+i, 255));			
			//assign field MidInitials
			e.setMidInitials(truncate("person_midinitials_"+i, 255));			
			//assign field LastName
			e.setLastName(truncate("person_lastname_"+i, 255));			
			//assign field Email
			e.setEmail("person_email"+i);
			//assign field Phone
			e.setPhone(truncate("person_phone_"+i, 255));			
			//assign field PrimaryAffilation
			if( this.institute.size() > 0  && i < this.institute.size())
			{ 
				Institute ref = this.institute.get(i);
				e.setPrimaryAffilation_Name(ref.getName() );
			}
			//assign field AffiliateInstitutions
			if( this.institute.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.institute.size() ? j : this.institute.size()-1);
				}
				List<String> nameList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					nameList.add( this.institute.get(index).getName() );
				}
				e.setAffiliateInstitutions_Name( nameList );
			}
			//assign field OrcidPersonReference
			if( this.ontologyTerm.size() > 0  && i < this.ontologyTerm.size())
			{ 
				OntologyTerm ref = this.ontologyTerm.get(i);
				e.setOrcidPersonReference_Identifier(ref.getIdentifier() );
			}
			this.person.add(e);
		}		
		//generating Citation data:
		for(Integer i = 0; i < size; i++)
		{
			Citation e = new Citation();
			//assign field Identifier
			e.setIdentifier(truncate("citation_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("citation_name_"+i, 255));			
			//assign field PubmedID
			e.setPubmedID(truncate("citation_pubmedid_"+i, 255));			
			//assign field DOI
			e.setDOI(truncate("citation_doi_"+i, 255));			
			//assign field ontologyTerms
			if( this.ontologyTerm.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.ontologyTerm.size() ? j : this.ontologyTerm.size()-1);
				}
				List<String> IdentifierList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					IdentifierList.add( this.ontologyTerm.get(index).getIdentifier() );
				}
				e.setOntologyTerms_Identifier( IdentifierList );
			}
			//assign field authorList
			e.setAuthorList("citation_authorlist"+i);
			//assign field Title
			e.setTitle(truncate("citation_title_"+i, 255));			
			//assign field Description
			e.setDescription("citation_description"+i);
			//assign field Status
			if( this.ontologyTerm.size() > 0  && i < this.ontologyTerm.size())
			{ 
				OntologyTerm ref = this.ontologyTerm.get(i);
				e.setStatus_Identifier(ref.getIdentifier() );
			}
			this.citation.add(e);
		}		
		//generating Investigation data:
		for(Integer i = 0; i < size; i++)
		{
			Investigation e = new Investigation();
			//assign field Identifier
			e.setIdentifier(truncate("investigation_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("investigation_name_"+i, 255));			
			//assign field Title
			e.setTitle("investigation_title"+i);
			//assign field ShortName
			e.setShortName("investigation_shortname"+i);
			//assign field Version
			e.setVersion(truncate("investigation_version_"+i, 255));			
			//assign field Background
			e.setBackground("investigation_background"+i);
			this.investigation.add(e);
		}		
		//generating Study data:
		for(Integer i = 0; i < size; i++)
		{
			Study e = new Study();
			//assign field Identifier
			e.setIdentifier(truncate("study_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("study_name_"+i, 255));			
			//assign field Description
			e.setDescription("study_description"+i);
			//assign field EndDate
			e.setEndDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			//assign field Contact
			if( this.person.size() > 0  && i < this.person.size())
			{ 
				Person ref = this.person.get(i);
				e.setContact_Name(ref.getName() );
			}
			//assign field PartOfInvestigation
			if( this.investigation.size() > 0  && i < this.investigation.size())
			{ 
				Investigation ref = this.investigation.get(i);
				e.setPartOfInvestigation_Identifier(ref.getIdentifier() );
			}
			this.study.add(e);
		}		
		//generating Experiment data:
		for(Integer i = 0; i < size; i++)
		{
			Experiment e = new Experiment();
			//assign field Identifier
			e.setIdentifier(truncate("experiment_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("experiment_name_"+i, 255));			
			//assign field Study
			if( this.study.size() > 0  && i < this.study.size())
			{ 
				Study ref = this.study.get(i);
				e.setStudy_Identifier(ref.getIdentifier() );
			}
			//assign field Design
			e.setDesign(truncate("experiment_design_"+i, 50));			
			//assign field ExperimentType
			if( this.ontologyTerm.size() > 0  && i < this.ontologyTerm.size())
			{ 
				OntologyTerm ref = this.ontologyTerm.get(i);
				e.setExperimentType_Identifier(ref.getIdentifier() );
			}
			//assign field TotalMarkersTested
			e.setTotalMarkersTested(i);
			//assign field TotalMarkersImported
			e.setTotalMarkersImported(i);
			//assign field Objective
			e.setObjective("experiment_objective"+i);
			//assign field Outcome
			e.setOutcome("experiment_outcome"+i);
			//assign field Comments
			e.setComments("experiment_comments"+i);
			//assign field IndividualDataStatement
			e.setIndividualDataStatement("experiment_individualdatastatement"+i);
			//assign field TimeCreated
			e.setTimeCreated(new java.sql.Timestamp(new java.util.Date().getTime()));
			//assign field AssayedPanels
			if( this.panel.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.panel.size() ? j : this.panel.size()-1);
				}
				List<String> IdentifierList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					IdentifierList.add( this.panel.get(index).getIdentifier() );
				}
				e.setAssayedPanels_Identifier( IdentifierList );
			}
			//assign field DataSets
			if( this.dataSet.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.dataSet.size() ? j : this.dataSet.size()-1);
				}
				List<String> IdentifierList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					IdentifierList.add( this.dataSet.get(index).getIdentifier() );
				}
				e.setDataSets_Identifier( IdentifierList );
			}
			this.experiment.add(e);
		}		
		//generating Submission data:
		for(Integer i = 0; i < size; i++)
		{
			Submission e = new Submission();
			//assign field Identifier
			e.setIdentifier(truncate("submission_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("submission_name_"+i, 255));			
			//assign field TimeCreated
			e.setTimeCreated(new java.sql.Timestamp(new java.util.Date().getTime()));
			//assign field Study
			if( this.study.size() > 0  && i < this.study.size())
			{ 
				Study ref = this.study.get(i);
				e.setStudy_Identifier(ref.getIdentifier() );
			}
			this.submission.add(e);
		}		
		//generating Contribution data:
		for(Integer i = 0; i < size; i++)
		{
			Contribution e = new Contribution();
			//assign field Identifier
			e.setIdentifier(truncate("contribution_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("contribution_name_"+i, 255));			
			//assign field Researcher
			if( this.person.size() > 0  && i < this.person.size())
			{ 
				Person ref = this.person.get(i);
				e.setResearcher_Name(ref.getName() );
			}
			//assign field Submission
			if( this.submission.size() > 0  && i < this.submission.size())
			{ 
				Submission ref = this.submission.get(i);
				e.setSubmission_Identifier(ref.getIdentifier() );
			}
			//assign field IsSubmitter
			e.setIsSubmitter(randomEnum(new String[]{"yes","no"}));
			//assign field IsAuthor
			e.setIsAuthor(randomEnum(new String[]{"yes","no"}));
			//assign field IsSource
			e.setIsSource(randomEnum(new String[]{"yes","no"}));
			this.contribution.add(e);
		}		
		//generating StudyDetails data:
		for(Integer i = 0; i < size; i++)
		{
			StudyDetails e = new StudyDetails();
			//assign field Study
			if( this.study.size() > 0  && i < this.study.size())
			{ 
				Study ref = this.study.get(i);
				e.setStudy_Identifier(ref.getIdentifier() );
			}
			//assign field Title
			e.setTitle("studydetails_title"+i);
			//assign field ShortName
			e.setShortName("studydetails_shortname"+i);
			//assign field StudyAbstract
			e.setStudyAbstract("studydetails_studyabstract"+i);
			//assign field Version
			e.setVersion(truncate("studydetails_version_"+i, 255));			
			//assign field Background
			e.setBackground("studydetails_background"+i);
			//assign field Objectives
			e.setObjectives("studydetails_objectives"+i);
			//assign field KeyResults
			e.setKeyResults("studydetails_keyresults"+i);
			//assign field Conclusions
			e.setConclusions("studydetails_conclusions"+i);
			//assign field StudyDesign
			e.setStudyDesign("studydetails_studydesign"+i);
			//assign field StudySizeReason
			e.setStudySizeReason("studydetails_studysizereason"+i);
			//assign field StudyPower
			e.setStudyPower("studydetails_studypower"+i);
			//assign field SourcesOfBias
			e.setSourcesOfBias("studydetails_sourcesofbias"+i);
			//assign field Limitations
			e.setLimitations("studydetails_limitations"+i);
			//assign field Acknowledgements
			e.setAcknowledgements("studydetails_acknowledgements"+i);
			//assign field primaryCitation
			if( this.citation.size() > 0  && i < this.citation.size())
			{ 
				Citation ref = this.citation.get(i);
				e.setPrimaryCitation_Identifier(ref.getIdentifier() );
			}
			//assign field otherCitations
			if( this.citation.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.citation.size() ? j : this.citation.size()-1);
				}
				List<String> IdentifierList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					IdentifierList.add( this.citation.get(index).getIdentifier() );
				}
				e.setOtherCitations_Identifier( IdentifierList );
			}
			//assign field Accession
			e.setAccession("studydetails_accession"+i);
			this.studyDetails.add(e);
		}		
		//generating PhenotypeProperty data:
		for(Integer i = 0; i < size; i++)
		{
			PhenotypeProperty e = new PhenotypeProperty();
			//assign field Identifier
			e.setIdentifier(truncate("phenotypeproperty_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("phenotypeproperty_name_"+i, 100));			
			//assign field description
			e.setDescription("phenotypeproperty_description"+i);
			//assign field unit
			if( this.ontologyTerm.size() > 0  && i < this.ontologyTerm.size())
			{ 
				OntologyTerm ref = this.ontologyTerm.get(i);
				e.setUnit_Identifier(ref.getIdentifier() );
			}
			//assign field dataType
			e.setDataType(randomEnum(new String[]{"xref","string","categorical","nominal","ordinal","date","datetime","int","code","image","decimal","bool","file","log","data","exe"}));
			//assign field temporal
			e.setTemporal(randomBool(i));
			this.phenotypeProperty.add(e);
		}		
		//generating PhenotypeMethod data:
		for(Integer i = 0; i < size; i++)
		{
			PhenotypeMethod e = new PhenotypeMethod();
			//assign field Identifier
			e.setIdentifier(truncate("phenotypemethod_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("phenotypemethod_name_"+i, 255));			
			//assign field description
			e.setDescription("phenotypemethod_description"+i);
			//assign field ProtocolUsed
			if( this.protocol.size() > 0  && i < this.protocol.size())
			{ 
				Protocol ref = this.protocol.get(i);
				e.setProtocolUsed_Identifier(ref.getIdentifier() );
			}
			//assign field StudyID
			if( this.study.size() > 0  && i < this.study.size())
			{ 
				Study ref = this.study.get(i);
				e.setStudyID_Identifier(ref.getIdentifier() );
			}
			//assign field PhenotypePropertyID
			if( this.phenotypeProperty.size() > 0  && i < this.phenotypeProperty.size())
			{ 
				PhenotypeProperty ref = this.phenotypeProperty.get(i);
				e.setPhenotypePropertyID_Identifier(ref.getIdentifier() );
			}
			//assign field Sample
			e.setSample(truncate("phenotypemethod_sample_"+i, 100));			
			this.phenotypeMethod.add(e);
		}		
		//generating SamplePanel data:
		for(Integer i = 0; i < size; i++)
		{
			SamplePanel e = new SamplePanel();
			//assign field Identifier
			e.setIdentifier(truncate("samplepanel_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("samplepanel_name_"+i, 100));			
			//assign field Description
			e.setDescription("samplepanel_description"+i);
			//assign field PanelType
			if( this.ontologyTerm.size() > 0  && i < this.ontologyTerm.size())
			{ 
				OntologyTerm ref = this.ontologyTerm.get(i);
				e.setPanelType_Identifier(ref.getIdentifier() );
			}
			//assign field NumberOfIndividuals
			e.setNumberOfIndividuals(i);
			//assign field Species
			if( this.species.size() > 0  && i < this.species.size())
			{ 
				Species ref = this.species.get(i);
				e.setSpecies_Identifier(ref.getIdentifier() );
			}
			//assign field Individuals
			if( this.individual.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.individual.size() ? j : this.individual.size()-1);
				}
				List<String> IdentifierList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					IdentifierList.add( this.individual.get(index).getIdentifier() );
				}
				e.setIndividuals_Identifier( IdentifierList );
			}
			//assign field CentralIdentifier
			if( this.ontologyTerm.size() > 0  && i < this.ontologyTerm.size())
			{ 
				OntologyTerm ref = this.ontologyTerm.get(i);
				e.setCentralIdentifier_Identifier(ref.getIdentifier() );
			}
			//assign field Label
			e.setLabel(truncate("samplepanel_label_"+i, 10));			
			//assign field Accession
			e.setAccession(truncate("samplepanel_accession_"+i, 15));			
			//assign field AccessionVersion
			e.setAccessionVersion(truncate("samplepanel_accessionversion_"+i, 10));			
			//assign field Composition
			e.setComposition("samplepanel_composition"+i);
			//assign field TotalNumberOfIndividuals
			e.setTotalNumberOfIndividuals(i);
			//assign field NumberOfSexMale
			e.setNumberOfSexMale(i);
			//assign field NumberOfSexFemale
			e.setNumberOfSexFemale(i);
			//assign field NumberOfSexUnknown
			e.setNumberOfSexUnknown(i);
			//assign field NumberOfProbands
			e.setNumberOfProbands(i);
			//assign field NumberOfParents
			e.setNumberOfParents(i);
			//assign field ModeOfRecruitment
			e.setModeOfRecruitment(truncate("samplepanel_modeofrecruitment_"+i, 255));			
			//assign field DiagnosisAgeRange
			e.setDiagnosisAgeRange(truncate("samplepanel_diagnosisagerange_"+i, 150));			
			//assign field DiagnosisPeriod
			e.setDiagnosisPeriod(truncate("samplepanel_diagnosisperiod_"+i, 150));			
			//assign field SamplingAgeRange
			e.setSamplingAgeRange(truncate("samplepanel_samplingagerange_"+i, 150));			
			//assign field SamplingPeriod
			e.setSamplingPeriod(truncate("samplepanel_samplingperiod_"+i, 150));			
			//assign field PopulationInfo
			e.setPopulationInfo(truncate("samplepanel_populationinfo_"+i, 250));			
			//assign field GeographicRegionInfo
			e.setGeographicRegionInfo(truncate("samplepanel_geographicregioninfo_"+i, 250));			
			//assign field EthnicityInfo
			e.setEthnicityInfo(truncate("samplepanel_ethnicityinfo_"+i, 250));			
			//assign field BirthPlaceInfo
			e.setBirthPlaceInfo(truncate("samplepanel_birthplaceinfo_"+i, 250));			
			//assign field AdmixtureInfo
			e.setAdmixtureInfo(truncate("samplepanel_admixtureinfo_"+i, 250));			
			//assign field EnvironmentInfo
			e.setEnvironmentInfo("samplepanel_environmentinfo"+i);
			//assign field SourceOfDNA
			e.setSourceOfDNA(truncate("samplepanel_sourceofdna_"+i, 100));			
			//assign field DNAsArePooled
			e.setDNAsArePooled(randomEnum(new String[]{"Undefined","Pre-prep","Post-prep","No"}));
			//assign field DNAsAreWGA
			e.setDNAsAreWGA(randomEnum(new String[]{"Undefined","None","All","Some"}));
			this.samplePanel.add(e);
		}		
		//generating AssayedPanel data:
		for(Integer i = 0; i < size; i++)
		{
			AssayedPanel e = new AssayedPanel();
			//assign field Identifier
			e.setIdentifier(truncate("assayedpanel_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("assayedpanel_name_"+i, 100));			
			//assign field Description
			e.setDescription("assayedpanel_description"+i);
			//assign field PanelType
			if( this.ontologyTerm.size() > 0  && i < this.ontologyTerm.size())
			{ 
				OntologyTerm ref = this.ontologyTerm.get(i);
				e.setPanelType_Identifier(ref.getIdentifier() );
			}
			//assign field NumberOfIndividuals
			e.setNumberOfIndividuals(i);
			//assign field Species
			if( this.species.size() > 0  && i < this.species.size())
			{ 
				Species ref = this.species.get(i);
				e.setSpecies_Identifier(ref.getIdentifier() );
			}
			//assign field Individuals
			if( this.individual.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.individual.size() ? j : this.individual.size()-1);
				}
				List<String> IdentifierList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					IdentifierList.add( this.individual.get(index).getIdentifier() );
				}
				e.setIndividuals_Identifier( IdentifierList );
			}
			//assign field TotalNumberOfIndividuals
			e.setTotalNumberOfIndividuals(i);
			//assign field NumberOfSexMale
			e.setNumberOfSexMale(i);
			//assign field NumberOfSexFemale
			e.setNumberOfSexFemale(i);
			//assign field NumberOfSexUnknown
			e.setNumberOfSexUnknown(i);
			//assign field NumberOfProbands
			e.setNumberOfProbands(i);
			//assign field NumberOfParents
			e.setNumberOfParents(i);
			this.assayedPanel.add(e);
		}		
		//generating PanelSource data:
		for(Integer i = 0; i < size; i++)
		{
			PanelSource e = new PanelSource();
			//assign field CurrentPanel
			if( this.panel.size() > 0  && i < this.panel.size())
			{ 
				Panel ref = this.panel.get(i);
				e.setCurrentPanel_Identifier(ref.getIdentifier() );
			}
			//assign field SourcePanel
			if( this.panel.size() > 0  && i < this.panel.size())
			{ 
				Panel ref = this.panel.get(i);
				e.setSourcePanel_Identifier(ref.getIdentifier() );
			}
			//assign field NumberOfIndividuals
			e.setNumberOfIndividuals(i);
			//assign field SelectionCriteria
			e.setSelectionCriteria("panelsource_selectioncriteria"+i);
			this.panelSource.add(e);
		}		
		//generating GWASExperiment data:
		for(Integer i = 0; i < size; i++)
		{
			GWASExperiment e = new GWASExperiment();
			//assign field Identifier
			e.setIdentifier(truncate("gwasexperiment_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("gwasexperiment_name_"+i, 255));			
			//assign field Study
			if( this.study.size() > 0  && i < this.study.size())
			{ 
				Study ref = this.study.get(i);
				e.setStudy_Identifier(ref.getIdentifier() );
			}
			//assign field Design
			e.setDesign(truncate("gwasexperiment_design_"+i, 50));			
			//assign field ExperimentType
			if( this.ontologyTerm.size() > 0  && i < this.ontologyTerm.size())
			{ 
				OntologyTerm ref = this.ontologyTerm.get(i);
				e.setExperimentType_Identifier(ref.getIdentifier() );
			}
			//assign field TotalMarkersTested
			e.setTotalMarkersTested(i);
			//assign field TotalMarkersImported
			e.setTotalMarkersImported(i);
			//assign field Objective
			e.setObjective("gwasexperiment_objective"+i);
			//assign field Outcome
			e.setOutcome("gwasexperiment_outcome"+i);
			//assign field Comments
			e.setComments("gwasexperiment_comments"+i);
			//assign field IndividualDataStatement
			e.setIndividualDataStatement("gwasexperiment_individualdatastatement"+i);
			//assign field TimeCreated
			e.setTimeCreated(new java.sql.Timestamp(new java.util.Date().getTime()));
			//assign field AssayedPanels
			if( this.panel.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.panel.size() ? j : this.panel.size()-1);
				}
				List<String> IdentifierList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					IdentifierList.add( this.panel.get(index).getIdentifier() );
				}
				e.setAssayedPanels_Identifier( IdentifierList );
			}
			//assign field DataSets
			if( this.dataSet.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.dataSet.size() ? j : this.dataSet.size()-1);
				}
				List<String> IdentifierList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					IdentifierList.add( this.dataSet.get(index).getIdentifier() );
				}
				e.setDataSets_Identifier( IdentifierList );
			}
			this.gWASExperiment.add(e);
		}		
		//generating UsedMarkerSet data:
		for(Integer i = 0; i < size; i++)
		{
			UsedMarkerSet e = new UsedMarkerSet();
			//assign field Identifier
			e.setIdentifier(truncate("usedmarkerset_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("usedmarkerset_name_"+i, 255));			
			//assign field description
			e.setDescription("usedmarkerset_description"+i);
			//assign field unit
			if( this.ontologyTerm.size() > 0  && i < this.ontologyTerm.size())
			{ 
				OntologyTerm ref = this.ontologyTerm.get(i);
				e.setUnit_Identifier(ref.getIdentifier() );
			}
			//assign field dataType
			e.setDataType(randomEnum(new String[]{"xref","string","categorical","nominal","ordinal","date","datetime","int","code","image","decimal","bool","file","log","data","exe"}));
			//assign field temporal
			e.setTemporal(randomBool(i));
			//assign field ExperimentID
			if( this.experiment.size() > 0  && i < this.experiment.size())
			{ 
				Experiment ref = this.experiment.get(i);
				e.setExperimentID_Identifier(ref.getIdentifier() );
			}
			//assign field MarkerIdentifier
			e.setMarkerIdentifier(truncate("usedmarkerset_markeridentifier_"+i, 255));			
			this.usedMarkerSet.add(e);
		}		
		//generating Category data:
		for(Integer i = 0; i < size; i++)
		{
			Category e = new Category();
			//assign field Identifier
			e.setIdentifier(truncate("category_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("category_name_"+i, 255));			
			//assign field description
			e.setDescription("category_description"+i);
			//assign field observableFeature
			if( this.observableFeature.size() > 0  && i < this.observableFeature.size())
			{ 
				ObservableFeature ref = this.observableFeature.get(i);
				e.setObservableFeature_Identifier(ref.getIdentifier() );
			}
			//assign field valueCode
			e.setValueCode(truncate("category_valuecode_"+i, 255));			
			//assign field isMissing
			e.setIsMissing(randomBool(i));
			this.category.add(e);
		}		
		//generating Significance data:
		for(Integer i = 0; i < size; i++)
		{
			Significance e = new Significance();
			//assign field Identifier
			e.setIdentifier(truncate("significance_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("significance_name_"+i, 255));			
			//assign field description
			e.setDescription("significance_description"+i);
			//assign field ProtocolUsed
			if( this.protocol.size() > 0  && i < this.protocol.size())
			{ 
				Protocol ref = this.protocol.get(i);
				e.setProtocolUsed_Identifier(ref.getIdentifier() );
			}
			//assign field UsedmarkersetID
			if( this.usedMarkerSet.size() > 0  && i < this.usedMarkerSet.size())
			{ 
				UsedMarkerSet ref = this.usedMarkerSet.get(i);
				e.setUsedmarkersetID_Identifier(ref.getIdentifier() );
			}
			//assign field NegLogPValue
			e.setNegLogPValue(i.doubleValue());
			//assign field UnadjustedPValue
			e.setUnadjustedPValue("significance_unadjustedpvalue"+i);
			//assign field AdjustedPValue
			e.setAdjustedPValue(i.doubleValue());
			this.significance.add(e);
		}		
		//generating EffectSize data:
		for(Integer i = 0; i < size; i++)
		{
			EffectSize e = new EffectSize();
			//assign field Identifier
			e.setIdentifier(truncate("effectsize_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("effectsize_name_"+i, 255));			
			//assign field description
			e.setDescription("effectsize_description"+i);
			//assign field ProtocolUsed
			if( this.protocol.size() > 0  && i < this.protocol.size())
			{ 
				Protocol ref = this.protocol.get(i);
				e.setProtocolUsed_Identifier(ref.getIdentifier() );
			}
			//assign field UsedMarkerSetID
			if( this.usedMarkerSet.size() > 0  && i < this.usedMarkerSet.size())
			{ 
				UsedMarkerSet ref = this.usedMarkerSet.get(i);
				e.setUsedMarkerSetID_Identifier(ref.getIdentifier() );
			}
			//assign field Lower95Bound
			e.setLower95Bound(i.doubleValue());
			//assign field Upper95Bound
			e.setUpper95Bound(i.doubleValue());
			//assign field StdError
			e.setStdError(i.doubleValue());
			this.effectSize.add(e);
		}		
		//generating SelectionCriteria data:
		for(Integer i = 0; i < size; i++)
		{
			SelectionCriteria e = new SelectionCriteria();
			//assign field SourcePanel
			if( this.panel.size() > 0  && i < this.panel.size())
			{ 
				Panel ref = this.panel.get(i);
				e.setSourcePanel_Identifier(ref.getIdentifier() );
			}
			//assign field TargetPanel
			if( this.panel.size() > 0  && i < this.panel.size())
			{ 
				Panel ref = this.panel.get(i);
				e.setTargetPanel_Identifier(ref.getIdentifier() );
			}
			//assign field NumberOfIndividuals
			e.setNumberOfIndividuals(i);
			//assign field Details
			e.setDetails("selectioncriteria_details"+i);
			this.selectionCriteria.add(e);
		}		
		//generating ObservationSet data:
		for(Integer i = 0; i < size; i++)
		{
			ObservationSet e = new ObservationSet();
			//assign field partOfDataSet
			if( this.dataSet.size() > 0  && i < this.dataSet.size())
			{ 
				DataSet ref = this.dataSet.get(i);
				e.setPartOfDataSet_Identifier(ref.getIdentifier() );
			}
			//assign field Target
			if( this.characteristic.size() > 0  && i < this.characteristic.size())
			{ 
				Characteristic ref = this.characteristic.get(i);
				e.setTarget_Identifier(ref.getIdentifier() );
			}
			//assign field Time
			e.setTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			this.observationSet.add(e);
		}		
		//generating ObservedValue data:
		for(Integer i = 0; i < size; i++)
		{
			ObservedValue e = new ObservedValue();
			//assign field ObservationSet
			if( this.observationSet.size() > 0  && i < this.observationSet.size())
			{ 
				ObservationSet ref = this.observationSet.get(i);
				e.setObservationSet_Id(ref.getId() );
			}
			//assign field Feature
			if( this.observableFeature.size() > 0  && i < this.observableFeature.size())
			{ 
				ObservableFeature ref = this.observableFeature.get(i);
				e.setFeature_Identifier(ref.getIdentifier() );
			}
			//assign field Characteristic
			if( this.characteristic.size() > 0  && i < this.characteristic.size())
			{ 
				Characteristic ref = this.characteristic.get(i);
				e.setCharacteristic_Identifier(ref.getIdentifier() );
			}
			//assign field Value
			e.setValue(truncate("observedvalue_value_"+i, 255));			
			this.observedValue.add(e);
		}		
		//generating FrequencyCluster data:
		for(Integer i = 0; i < size; i++)
		{
			FrequencyCluster e = new FrequencyCluster();
			//assign field Identifier
			e.setIdentifier(truncate("frequencycluster_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("frequencycluster_name_"+i, 255));			
			//assign field description
			e.setDescription("frequencycluster_description"+i);
			//assign field ProtocolUsed
			if( this.protocol.size() > 0  && i < this.protocol.size())
			{ 
				Protocol ref = this.protocol.get(i);
				e.setProtocolUsed_Identifier(ref.getIdentifier() );
			}
			//assign field DataSet
			if( this.dataSet.size() > 0  && i < this.dataSet.size())
			{ 
				DataSet ref = this.dataSet.get(i);
				e.setDataSet_Identifier(ref.getIdentifier() );
			}
			//assign field UsedMarkerSet
			if( this.usedMarkerSet.size() > 0  && i < this.usedMarkerSet.size())
			{ 
				UsedMarkerSet ref = this.usedMarkerSet.get(i);
				e.setUsedMarkerSet_Identifier(ref.getIdentifier() );
			}
			//assign field MarkerID
			e.setMarkerID(i);
			//assign field NumberOfGenotypedSamples
			e.setNumberOfGenotypedSamples(i);
			//assign field PValueHWE
			e.setPValueHWE(i.doubleValue());
			//assign field UnadjustedPValue
			e.setUnadjustedPValue(i.doubleValue());
			//assign field OddsRatioStatement
			e.setOddsRatioStatement(truncate("frequencycluster_oddsratiostatement_"+i, 255));			
			//assign field AttributableRiskStatement
			e.setAttributableRiskStatement(truncate("frequencycluster_attributableriskstatement_"+i, 255));			
			this.frequencyCluster.add(e);
		}		
		//generating GenotypeFrequency data:
		for(Integer i = 0; i < size; i++)
		{
			GenotypeFrequency e = new GenotypeFrequency();
			//assign field Identifier
			e.setIdentifier(truncate("genotypefrequency_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("genotypefrequency_name_"+i, 255));			
			//assign field description
			e.setDescription("genotypefrequency_description"+i);
			//assign field ProtocolUsed
			if( this.protocol.size() > 0  && i < this.protocol.size())
			{ 
				Protocol ref = this.protocol.get(i);
				e.setProtocolUsed_Identifier(ref.getIdentifier() );
			}
			//assign field FrequencyCluster
			if( this.frequencyCluster.size() > 0  && i < this.frequencyCluster.size())
			{ 
				FrequencyCluster ref = this.frequencyCluster.get(i);
				e.setFrequencyCluster_Identifier(ref.getIdentifier() );
			}
			//assign field GenotypeCombo
			e.setGenotypeCombo("genotypefrequency_genotypecombo"+i);
			//assign field FrequencyAsProportion
			e.setFrequencyAsProportion(i.doubleValue());
			//assign field NumberSamplesWithGenotype
			e.setNumberSamplesWithGenotype(i);
			this.genotypeFrequency.add(e);
		}		
		//generating AlleleFrequency data:
		for(Integer i = 0; i < size; i++)
		{
			AlleleFrequency e = new AlleleFrequency();
			//assign field Identifier
			e.setIdentifier(truncate("allelefrequency_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("allelefrequency_name_"+i, 255));			
			//assign field description
			e.setDescription("allelefrequency_description"+i);
			//assign field ProtocolUsed
			if( this.protocol.size() > 0  && i < this.protocol.size())
			{ 
				Protocol ref = this.protocol.get(i);
				e.setProtocolUsed_Identifier(ref.getIdentifier() );
			}
			//assign field FrequencyCluster
			if( this.frequencyCluster.size() > 0  && i < this.frequencyCluster.size())
			{ 
				FrequencyCluster ref = this.frequencyCluster.get(i);
				e.setFrequencyCluster_Identifier(ref.getIdentifier() );
			}
			//assign field AlleleCombo
			e.setAlleleCombo("allelefrequency_allelecombo"+i);
			//assign field FrequencyAsProportion
			e.setFrequencyAsProportion(i.doubleValue());
			this.alleleFrequency.add(e);
		}		
		//generating PhenotypeValue data:
		for(Integer i = 0; i < size; i++)
		{
			PhenotypeValue e = new PhenotypeValue();
			//assign field ObservationSet
			if( this.observationSet.size() > 0  && i < this.observationSet.size())
			{ 
				ObservationSet ref = this.observationSet.get(i);
				e.setObservationSet_Id(ref.getId() );
			}
			//assign field Feature
			if( this.observableFeature.size() > 0  && i < this.observableFeature.size())
			{ 
				ObservableFeature ref = this.observableFeature.get(i);
				e.setFeature_Identifier(ref.getIdentifier() );
			}
			//assign field Characteristic
			if( this.characteristic.size() > 0  && i < this.characteristic.size())
			{ 
				Characteristic ref = this.characteristic.get(i);
				e.setCharacteristic_Identifier(ref.getIdentifier() );
			}
			//assign field Value
			e.setValue(truncate("phenotypevalue_value_"+i, 255));			
			//assign field Identifier
			e.setIdentifier(truncate("phenotypevalue_identifier_"+i, 255));			
			//assign field Name
			e.setName(truncate("phenotypevalue_name_"+i, 255));			
			//assign field PhenotypePropertyID
			if( this.phenotypeProperty.size() > 0  && i < this.phenotypeProperty.size())
			{ 
				PhenotypeProperty ref = this.phenotypeProperty.get(i);
				e.setPhenotypePropertyID_Identifier(ref.getIdentifier() );
			}
			//assign field ValueRank
			e.setValueRank(truncate("phenotypevalue_valuerank_"+i, 255));			
			//assign field ValueIsMean
			e.setValueIsMean(truncate("phenotypevalue_valueismean_"+i, 255));			
			//assign field STD
			e.setSTD(truncate("phenotypevalue_std_"+i, 255));			
			//assign field Min
			e.setMin(truncate("phenotypevalue_min_"+i, 255));			
			//assign field Max
			e.setMax(truncate("phenotypevalue_max_"+i, 255));			
			this.phenotypeValue.add(e);
		}		
	}	 
	
	public String truncate(String value, int length)
	{
	   if (value != null && value.length() > length)
          value = value.substring(0, length-1);
       return value;
	}	
	 
	 /** Helper to get random element from a list */
	private int random(int max)
	{
		return new Long(Math.round(Math.floor( Math.random() * max ))).intValue();
	}
	
	private Boolean randomBool(int i)
	{
		return i % 2 == 0 ? true : false;
	}
	
	private String randomEnum(String[] options)
	{
		Integer index = Long.valueOf(Math.round(Math.random() * (options.length - 1) )).intValue();
		return options[index];
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (other == null || !this.getClass().equals(other.getClass()))
			return false;
		TestDataSet set = (TestDataSet) other;
		
		if ( this.autoid == null ? set.autoid != null : !this.autoid.equals( set.autoid ) )
			return false;
		if ( this.identifiable == null ? set.identifiable != null : !this.identifiable.equals( set.identifiable ) )
			return false;
		if ( this.molgenisEntity == null ? set.molgenisEntity != null : !this.molgenisEntity.equals( set.molgenisEntity ) )
			return false;
		if ( this.molgenisFile == null ? set.molgenisFile != null : !this.molgenisFile.equals( set.molgenisFile ) )
			return false;
		if ( this.runtimeProperty == null ? set.runtimeProperty != null : !this.runtimeProperty.equals( set.runtimeProperty ) )
			return false;
		if ( this.molgenisRole == null ? set.molgenisRole != null : !this.molgenisRole.equals( set.molgenisRole ) )
			return false;
		if ( this.molgenisGroup == null ? set.molgenisGroup != null : !this.molgenisGroup.equals( set.molgenisGroup ) )
			return false;
		if ( this.molgenisUser == null ? set.molgenisUser != null : !this.molgenisUser.equals( set.molgenisUser ) )
			return false;
		if ( this.molgenisRoleGroupLink == null ? set.molgenisRoleGroupLink != null : !this.molgenisRoleGroupLink.equals( set.molgenisRoleGroupLink ) )
			return false;
		if ( this.molgenisPermission == null ? set.molgenisPermission != null : !this.molgenisPermission.equals( set.molgenisPermission ) )
			return false;
		if ( this.authorizable == null ? set.authorizable != null : !this.authorizable.equals( set.authorizable ) )
			return false;
		if ( this.characteristic == null ? set.characteristic != null : !this.characteristic.equals( set.characteristic ) )
			return false;
		if ( this.observationTarget == null ? set.observationTarget != null : !this.observationTarget.equals( set.observationTarget ) )
			return false;
		if ( this.observableFeature == null ? set.observableFeature != null : !this.observableFeature.equals( set.observableFeature ) )
			return false;
		if ( this.category == null ? set.category != null : !this.category.equals( set.category ) )
			return false;
		if ( this.protocol == null ? set.protocol != null : !this.protocol.equals( set.protocol ) )
			return false;
		if ( this.dataSet == null ? set.dataSet != null : !this.dataSet.equals( set.dataSet ) )
			return false;
		if ( this.observationSet == null ? set.observationSet != null : !this.observationSet.equals( set.observationSet ) )
			return false;
		if ( this.observedValue == null ? set.observedValue != null : !this.observedValue.equals( set.observedValue ) )
			return false;
		if ( this.species == null ? set.species != null : !this.species.equals( set.species ) )
			return false;
		if ( this.individual == null ? set.individual != null : !this.individual.equals( set.individual ) )
			return false;
		if ( this.panel == null ? set.panel != null : !this.panel.equals( set.panel ) )
			return false;
		if ( this.panelSource == null ? set.panelSource != null : !this.panelSource.equals( set.panelSource ) )
			return false;
		if ( this.ontology == null ? set.ontology != null : !this.ontology.equals( set.ontology ) )
			return false;
		if ( this.ontologyTerm == null ? set.ontologyTerm != null : !this.ontologyTerm.equals( set.ontologyTerm ) )
			return false;
		if ( this.accession == null ? set.accession != null : !this.accession.equals( set.accession ) )
			return false;
		if ( this.bioSequence == null ? set.bioSequence != null : !this.bioSequence.equals( set.bioSequence ) )
			return false;
		if ( this.gdnaPosition == null ? set.gdnaPosition != null : !this.gdnaPosition.equals( set.gdnaPosition ) )
			return false;
		if ( this.cdnaPosition == null ? set.cdnaPosition != null : !this.cdnaPosition.equals( set.cdnaPosition ) )
			return false;
		if ( this.aaPosition == null ? set.aaPosition != null : !this.aaPosition.equals( set.aaPosition ) )
			return false;
		if ( this.genome == null ? set.genome != null : !this.genome.equals( set.genome ) )
			return false;
		if ( this.chromosome == null ? set.chromosome != null : !this.chromosome.equals( set.chromosome ) )
			return false;
		if ( this.gene == null ? set.gene != null : !this.gene.equals( set.gene ) )
			return false;
		if ( this.protein == null ? set.protein != null : !this.protein.equals( set.protein ) )
			return false;
		if ( this.proteinDomain == null ? set.proteinDomain != null : !this.proteinDomain.equals( set.proteinDomain ) )
			return false;
		if ( this.exon == null ? set.exon != null : !this.exon.equals( set.exon ) )
			return false;
		if ( this.variant == null ? set.variant != null : !this.variant.equals( set.variant ) )
			return false;
		if ( this.study == null ? set.study != null : !this.study.equals( set.study ) )
			return false;
		if ( this.experiment == null ? set.experiment != null : !this.experiment.equals( set.experiment ) )
			return false;
		if ( this.institute == null ? set.institute != null : !this.institute.equals( set.institute ) )
			return false;
		if ( this.person == null ? set.person != null : !this.person.equals( set.person ) )
			return false;
		if ( this.citation == null ? set.citation != null : !this.citation.equals( set.citation ) )
			return false;
		if ( this.contribution == null ? set.contribution != null : !this.contribution.equals( set.contribution ) )
			return false;
		if ( this.submission == null ? set.submission != null : !this.submission.equals( set.submission ) )
			return false;
		if ( this.investigation == null ? set.investigation != null : !this.investigation.equals( set.investigation ) )
			return false;
		if ( this.studyDetails == null ? set.studyDetails != null : !this.studyDetails.equals( set.studyDetails ) )
			return false;
		if ( this.frequencyCluster == null ? set.frequencyCluster != null : !this.frequencyCluster.equals( set.frequencyCluster ) )
			return false;
		if ( this.genotypeFrequency == null ? set.genotypeFrequency != null : !this.genotypeFrequency.equals( set.genotypeFrequency ) )
			return false;
		if ( this.alleleFrequency == null ? set.alleleFrequency != null : !this.alleleFrequency.equals( set.alleleFrequency ) )
			return false;
		if ( this.phenotypeProperty == null ? set.phenotypeProperty != null : !this.phenotypeProperty.equals( set.phenotypeProperty ) )
			return false;
		if ( this.phenotypeMethod == null ? set.phenotypeMethod != null : !this.phenotypeMethod.equals( set.phenotypeMethod ) )
			return false;
		if ( this.phenotypeValue == null ? set.phenotypeValue != null : !this.phenotypeValue.equals( set.phenotypeValue ) )
			return false;
		if ( this.samplePanel == null ? set.samplePanel != null : !this.samplePanel.equals( set.samplePanel ) )
			return false;
		if ( this.assayedPanel == null ? set.assayedPanel != null : !this.assayedPanel.equals( set.assayedPanel ) )
			return false;
		if ( this.gWASExperiment == null ? set.gWASExperiment != null : !this.gWASExperiment.equals( set.gWASExperiment ) )
			return false;
		if ( this.usedMarkerSet == null ? set.usedMarkerSet != null : !this.usedMarkerSet.equals( set.usedMarkerSet ) )
			return false;
		if ( this.significance == null ? set.significance != null : !this.significance.equals( set.significance ) )
			return false;
		if ( this.effectSize == null ? set.effectSize != null : !this.effectSize.equals( set.effectSize ) )
			return false;
		if ( this.selectionCriteria == null ? set.selectionCriteria != null : !this.selectionCriteria.equals( set.selectionCriteria ) )
			return false;
		if ( this.protocol_subprotocols == null ? set.protocol_subprotocols != null : !this.protocol_subprotocols.equals( set.protocol_subprotocols ) )
			return false;
		if ( this.protocol_Features == null ? set.protocol_Features != null : !this.protocol_Features.equals( set.protocol_Features ) )
			return false;
		if ( this.panel_Individuals == null ? set.panel_Individuals != null : !this.panel_Individuals.equals( set.panel_Individuals ) )
			return false;
		if ( this.experiment_AssayedPanels == null ? set.experiment_AssayedPanels != null : !this.experiment_AssayedPanels.equals( set.experiment_AssayedPanels ) )
			return false;
		if ( this.experiment_DataSets == null ? set.experiment_DataSets != null : !this.experiment_DataSets.equals( set.experiment_DataSets ) )
			return false;
		if ( this.person_AffiliateInstitutions == null ? set.person_AffiliateInstitutions != null : !this.person_AffiliateInstitutions.equals( set.person_AffiliateInstitutions ) )
			return false;
		if ( this.citation_ontologyTerms == null ? set.citation_ontologyTerms != null : !this.citation_ontologyTerms.equals( set.citation_ontologyTerms ) )
			return false;
		if ( this.studyDetails_otherCitations == null ? set.studyDetails_otherCitations != null : !this.studyDetails_otherCitations.equals( set.studyDetails_otherCitations ) )
			return false;
		
		return true;
	}
	
	@Override
 	public int hashCode() 
 	{ 
    	int hash = 1;
    	hash = hash * 31 + (this.autoid == null ? 0 : autoid.hashCode());
    	hash = hash * 31 + (this.identifiable == null ? 0 : identifiable.hashCode());
    	hash = hash * 31 + (this.molgenisEntity == null ? 0 : molgenisEntity.hashCode());
    	hash = hash * 31 + (this.molgenisFile == null ? 0 : molgenisFile.hashCode());
    	hash = hash * 31 + (this.runtimeProperty == null ? 0 : runtimeProperty.hashCode());
    	hash = hash * 31 + (this.molgenisRole == null ? 0 : molgenisRole.hashCode());
    	hash = hash * 31 + (this.molgenisGroup == null ? 0 : molgenisGroup.hashCode());
    	hash = hash * 31 + (this.molgenisUser == null ? 0 : molgenisUser.hashCode());
    	hash = hash * 31 + (this.molgenisRoleGroupLink == null ? 0 : molgenisRoleGroupLink.hashCode());
    	hash = hash * 31 + (this.molgenisPermission == null ? 0 : molgenisPermission.hashCode());
    	hash = hash * 31 + (this.authorizable == null ? 0 : authorizable.hashCode());
    	hash = hash * 31 + (this.characteristic == null ? 0 : characteristic.hashCode());
    	hash = hash * 31 + (this.observationTarget == null ? 0 : observationTarget.hashCode());
    	hash = hash * 31 + (this.observableFeature == null ? 0 : observableFeature.hashCode());
    	hash = hash * 31 + (this.category == null ? 0 : category.hashCode());
    	hash = hash * 31 + (this.protocol == null ? 0 : protocol.hashCode());
    	hash = hash * 31 + (this.dataSet == null ? 0 : dataSet.hashCode());
    	hash = hash * 31 + (this.observationSet == null ? 0 : observationSet.hashCode());
    	hash = hash * 31 + (this.observedValue == null ? 0 : observedValue.hashCode());
    	hash = hash * 31 + (this.species == null ? 0 : species.hashCode());
    	hash = hash * 31 + (this.individual == null ? 0 : individual.hashCode());
    	hash = hash * 31 + (this.panel == null ? 0 : panel.hashCode());
    	hash = hash * 31 + (this.panelSource == null ? 0 : panelSource.hashCode());
    	hash = hash * 31 + (this.ontology == null ? 0 : ontology.hashCode());
    	hash = hash * 31 + (this.ontologyTerm == null ? 0 : ontologyTerm.hashCode());
    	hash = hash * 31 + (this.accession == null ? 0 : accession.hashCode());
    	hash = hash * 31 + (this.bioSequence == null ? 0 : bioSequence.hashCode());
    	hash = hash * 31 + (this.gdnaPosition == null ? 0 : gdnaPosition.hashCode());
    	hash = hash * 31 + (this.cdnaPosition == null ? 0 : cdnaPosition.hashCode());
    	hash = hash * 31 + (this.aaPosition == null ? 0 : aaPosition.hashCode());
    	hash = hash * 31 + (this.genome == null ? 0 : genome.hashCode());
    	hash = hash * 31 + (this.chromosome == null ? 0 : chromosome.hashCode());
    	hash = hash * 31 + (this.gene == null ? 0 : gene.hashCode());
    	hash = hash * 31 + (this.protein == null ? 0 : protein.hashCode());
    	hash = hash * 31 + (this.proteinDomain == null ? 0 : proteinDomain.hashCode());
    	hash = hash * 31 + (this.exon == null ? 0 : exon.hashCode());
    	hash = hash * 31 + (this.variant == null ? 0 : variant.hashCode());
    	hash = hash * 31 + (this.study == null ? 0 : study.hashCode());
    	hash = hash * 31 + (this.experiment == null ? 0 : experiment.hashCode());
    	hash = hash * 31 + (this.institute == null ? 0 : institute.hashCode());
    	hash = hash * 31 + (this.person == null ? 0 : person.hashCode());
    	hash = hash * 31 + (this.citation == null ? 0 : citation.hashCode());
    	hash = hash * 31 + (this.contribution == null ? 0 : contribution.hashCode());
    	hash = hash * 31 + (this.submission == null ? 0 : submission.hashCode());
    	hash = hash * 31 + (this.investigation == null ? 0 : investigation.hashCode());
    	hash = hash * 31 + (this.studyDetails == null ? 0 : studyDetails.hashCode());
    	hash = hash * 31 + (this.frequencyCluster == null ? 0 : frequencyCluster.hashCode());
    	hash = hash * 31 + (this.genotypeFrequency == null ? 0 : genotypeFrequency.hashCode());
    	hash = hash * 31 + (this.alleleFrequency == null ? 0 : alleleFrequency.hashCode());
    	hash = hash * 31 + (this.phenotypeProperty == null ? 0 : phenotypeProperty.hashCode());
    	hash = hash * 31 + (this.phenotypeMethod == null ? 0 : phenotypeMethod.hashCode());
    	hash = hash * 31 + (this.phenotypeValue == null ? 0 : phenotypeValue.hashCode());
    	hash = hash * 31 + (this.samplePanel == null ? 0 : samplePanel.hashCode());
    	hash = hash * 31 + (this.assayedPanel == null ? 0 : assayedPanel.hashCode());
    	hash = hash * 31 + (this.gWASExperiment == null ? 0 : gWASExperiment.hashCode());
    	hash = hash * 31 + (this.usedMarkerSet == null ? 0 : usedMarkerSet.hashCode());
    	hash = hash * 31 + (this.significance == null ? 0 : significance.hashCode());
    	hash = hash * 31 + (this.effectSize == null ? 0 : effectSize.hashCode());
    	hash = hash * 31 + (this.selectionCriteria == null ? 0 : selectionCriteria.hashCode());
    	hash = hash * 31 + (this.protocol_subprotocols == null ? 0 : protocol_subprotocols.hashCode());
    	hash = hash * 31 + (this.protocol_Features == null ? 0 : protocol_Features.hashCode());
    	hash = hash * 31 + (this.panel_Individuals == null ? 0 : panel_Individuals.hashCode());
    	hash = hash * 31 + (this.experiment_AssayedPanels == null ? 0 : experiment_AssayedPanels.hashCode());
    	hash = hash * 31 + (this.experiment_DataSets == null ? 0 : experiment_DataSets.hashCode());
    	hash = hash * 31 + (this.person_AffiliateInstitutions == null ? 0 : person_AffiliateInstitutions.hashCode());
    	hash = hash * 31 + (this.citation_ontologyTerms == null ? 0 : citation_ontologyTerms.hashCode());
    	hash = hash * 31 + (this.studyDetails_otherCitations == null ? 0 : studyDetails_otherCitations.hashCode());
    	return hash;
  	}
	
	public List<Autoid> autoid = new ArrayList<Autoid>();
	public List<Identifiable> identifiable = new ArrayList<Identifiable>();
	public List<MolgenisEntity> molgenisEntity = new ArrayList<MolgenisEntity>();
	public List<MolgenisFile> molgenisFile = new ArrayList<MolgenisFile>();
	public List<RuntimeProperty> runtimeProperty = new ArrayList<RuntimeProperty>();
	public List<MolgenisRole> molgenisRole = new ArrayList<MolgenisRole>();
	public List<MolgenisGroup> molgenisGroup = new ArrayList<MolgenisGroup>();
	public List<MolgenisUser> molgenisUser = new ArrayList<MolgenisUser>();
	public List<MolgenisRoleGroupLink> molgenisRoleGroupLink = new ArrayList<MolgenisRoleGroupLink>();
	public List<MolgenisPermission> molgenisPermission = new ArrayList<MolgenisPermission>();
	public List<Authorizable> authorizable = new ArrayList<Authorizable>();
	public List<Characteristic> characteristic = new ArrayList<Characteristic>();
	public List<ObservationTarget> observationTarget = new ArrayList<ObservationTarget>();
	public List<ObservableFeature> observableFeature = new ArrayList<ObservableFeature>();
	public List<Category> category = new ArrayList<Category>();
	public List<Protocol> protocol = new ArrayList<Protocol>();
	public List<DataSet> dataSet = new ArrayList<DataSet>();
	public List<ObservationSet> observationSet = new ArrayList<ObservationSet>();
	public List<ObservedValue> observedValue = new ArrayList<ObservedValue>();
	public List<Species> species = new ArrayList<Species>();
	public List<Individual> individual = new ArrayList<Individual>();
	public List<Panel> panel = new ArrayList<Panel>();
	public List<PanelSource> panelSource = new ArrayList<PanelSource>();
	public List<Ontology> ontology = new ArrayList<Ontology>();
	public List<OntologyTerm> ontologyTerm = new ArrayList<OntologyTerm>();
	public List<Accession> accession = new ArrayList<Accession>();
	public List<BioSequence> bioSequence = new ArrayList<BioSequence>();
	public List<GdnaPosition> gdnaPosition = new ArrayList<GdnaPosition>();
	public List<CdnaPosition> cdnaPosition = new ArrayList<CdnaPosition>();
	public List<AaPosition> aaPosition = new ArrayList<AaPosition>();
	public List<Genome> genome = new ArrayList<Genome>();
	public List<Chromosome> chromosome = new ArrayList<Chromosome>();
	public List<Gene> gene = new ArrayList<Gene>();
	public List<Protein> protein = new ArrayList<Protein>();
	public List<ProteinDomain> proteinDomain = new ArrayList<ProteinDomain>();
	public List<Exon> exon = new ArrayList<Exon>();
	public List<Variant> variant = new ArrayList<Variant>();
	public List<Study> study = new ArrayList<Study>();
	public List<Experiment> experiment = new ArrayList<Experiment>();
	public List<Institute> institute = new ArrayList<Institute>();
	public List<Person> person = new ArrayList<Person>();
	public List<Citation> citation = new ArrayList<Citation>();
	public List<Contribution> contribution = new ArrayList<Contribution>();
	public List<Submission> submission = new ArrayList<Submission>();
	public List<Investigation> investigation = new ArrayList<Investigation>();
	public List<StudyDetails> studyDetails = new ArrayList<StudyDetails>();
	public List<FrequencyCluster> frequencyCluster = new ArrayList<FrequencyCluster>();
	public List<GenotypeFrequency> genotypeFrequency = new ArrayList<GenotypeFrequency>();
	public List<AlleleFrequency> alleleFrequency = new ArrayList<AlleleFrequency>();
	public List<PhenotypeProperty> phenotypeProperty = new ArrayList<PhenotypeProperty>();
	public List<PhenotypeMethod> phenotypeMethod = new ArrayList<PhenotypeMethod>();
	public List<PhenotypeValue> phenotypeValue = new ArrayList<PhenotypeValue>();
	public List<SamplePanel> samplePanel = new ArrayList<SamplePanel>();
	public List<AssayedPanel> assayedPanel = new ArrayList<AssayedPanel>();
	public List<GWASExperiment> gWASExperiment = new ArrayList<GWASExperiment>();
	public List<UsedMarkerSet> usedMarkerSet = new ArrayList<UsedMarkerSet>();
	public List<Significance> significance = new ArrayList<Significance>();
	public List<EffectSize> effectSize = new ArrayList<EffectSize>();
	public List<SelectionCriteria> selectionCriteria = new ArrayList<SelectionCriteria>();
	public List<Protocol_Subprotocols> protocol_subprotocols = new ArrayList<Protocol_Subprotocols>();
	public List<Protocol_Features> protocol_Features = new ArrayList<Protocol_Features>();
	public List<Panel_Individuals> panel_Individuals = new ArrayList<Panel_Individuals>();
	public List<Experiment_AssayedPanels> experiment_AssayedPanels = new ArrayList<Experiment_AssayedPanels>();
	public List<Experiment_DataSets> experiment_DataSets = new ArrayList<Experiment_DataSets>();
	public List<Person_AffiliateInstitutions> person_AffiliateInstitutions = new ArrayList<Person_AffiliateInstitutions>();
	public List<Citation_OntologyTerms> citation_ontologyTerms = new ArrayList<Citation_OntologyTerms>();
	public List<StudyDetails_OtherCitations> studyDetails_otherCitations = new ArrayList<StudyDetails_OtherCitations>();
}