
/* File:        Org.molgenis/html/SamplePanel.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 26, 2012
 * 
 * generator:   org.molgenis.generators.ui.HtmlFormGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
package org.molgenis.gwascentral.ui;

// jdk
import java.util.Vector;
import java.util.List;
import java.util.ArrayList;


// molgenis
import org.molgenis.framework.ui.html.*;


import org.molgenis.observ.target.OntologyTerm;
import org.molgenis.observ.target.Species;
import org.molgenis.observ.target.Individual;
import org.molgenis.gwascentral.SamplePanel;


/**
 * A HtmlForm that is preloaded with all inputs for entity SamplePanel
 * @see EntityForm
 */
public class SamplePanelForm extends EntityForm<SamplePanel>
{
	
	public SamplePanelForm()
	{
		super();
	}
	
	public SamplePanelForm(SamplePanel entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<SamplePanel> getEntityClass()
	{
		return SamplePanel.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("Identifier");
		headers.add("Name");
		headers.add("Description");
		headers.add("PanelType");
		headers.add("NumberOfIndividuals");
		headers.add("Species");
		headers.add("Individuals");
		headers.add("CentralIdentifier");
		headers.add("Composition");
		headers.add("Total number of individuals");
		headers.add("Number of males");
		headers.add("Number of females");
		headers.add("Number of unknown sex");
		headers.add("Number of probands");
		headers.add("Number of parents");
		headers.add("Mode of recruitment");
		headers.add("Diagnosis age range");
		headers.add("Diagnosis period");
		headers.add("Sampling age range");
		headers.add("Sampling period");
		headers.add("Population information");
		headers.add("Geographic region information");
		headers.add("Ethnicity information");
		headers.add("Birth place information");
		headers.add("Admixture information");
		headers.add("Environment information");
		headers.add("Source of DNA");
		headers.add("Are DNAs pooled?");
		headers.add("Are DNAs WGA?");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=SamplePanel, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("SamplePanel_id",getEntity().getId());
			
			input.setLabel("id");
			input.setDescription("automatically generated internal id, only for internal use.");
			input.setNillable(false);
			input.setReadonly(true); //automatic fields that are readonly, are also readonly on newrecord
			input.setHidden(true);
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//Identifier: Field(entity=SamplePanel, name=Identifier, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("SamplePanel_Identifier",getEntity().getIdentifier());
			
			input.setLabel("Identifier");
			input.setDescription("user supplied or automatically assigned (using a decorator) unique and short identifier, e.g. MA1234");
			input.setNillable(false);
			input.setSize(255);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//Name: Field(entity=SamplePanel, name=Name, type=string[100], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("SamplePanel_Name",getEntity().getName());
			
			input.setLabel("Name");
			input.setDescription("Name");
			input.setNillable(true);
			input.setSize(100);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//__Type: Field(entity=Characteristic, name=__Type, type=enum, auto=true, nillable=false, readonly=true, default=null, enum_options=[Characteristic, Individual, SamplePanel, AssayedPanel, Panel, ObservationTarget, PhenotypeProperty, UsedMarkerSet, ObservableFeature, Category, Protocol, FrequencyCluster, GenotypeFrequency, AlleleFrequency, PhenotypeMethod, Significance, EffectSize, DataSet, Genome, Chromosome, Gene, Protein, ProteinDomain, Exon, Variant])
		{
			EnumInput input = new EnumInput("SamplePanel___Type",getEntity().get__Type());
			
			input.setLabel("__Type");
			input.setDescription("Subtypes have to be set to allow searching");
			input.setNillable(false);
			input.setReadonly(true); //automatic fields that are readonly, are also readonly on newrecord
			input.setOptions(getEntity().get__TypeOptions());
			input.setHidden(true);
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//Description: Field(entity=SamplePanel, name=Description, type=text, auto=false, nillable=true, readonly=false, default=)
		{
			TextInput input = new TextInput("SamplePanel_Description",getEntity().getDescription());
			
			input.setLabel("Description");
			input.setDescription("Description");
			input.setNillable(true);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//PanelType: Field(entity=Panel, name=PanelType, type=xref[OntologyTerm.id], xref_label='Identifier', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<SamplePanel> input = new XrefInput<SamplePanel>("SamplePanel_PanelType", getEntity().getPanelType());
			//create xref dummy object
			OntologyTerm dummy = null;
			if(getEntity().getPanelType_Id() != null)
			{
			 	dummy = new OntologyTerm();
				dummy.setId(getEntity().getPanelType_Id());
				dummy.setIdentifier( getEntity().getPanelType_Identifier() ); 
			}
			XrefInput<OntologyTerm> input = new XrefInput<OntologyTerm>("SamplePanel_PanelType", org.molgenis.observ.target.OntologyTerm.class, dummy);
			
			input.setLabel("PanelType");
			input.setDescription("Indicate the type of Panel (example: Sample panel, AssayedPanel, Natural=wild type, Parental=parents of a cross, F1=First generation of cross, RCC=Recombinant congenic, CSS=chromosome substitution)");
			input.setNillable(true);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//NumberOfIndividuals: Field(entity=Panel, name=NumberOfIndividuals, type=int, auto=false, nillable=false, readonly=false, default=)
		{
			IntInput input = new IntInput("SamplePanel_NumberOfIndividuals",getEntity().getNumberOfIndividuals());
			
			input.setLabel("NumberOfIndividuals");
			input.setDescription("NumberOfIndividuals");
			input.setNillable(false);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//Species: Field(entity=Panel, name=Species, type=xref[Species.id], xref_label='Identifier', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<SamplePanel> input = new XrefInput<SamplePanel>("SamplePanel_Species", getEntity().getSpecies());
			//create xref dummy object
			Species dummy = null;
			if(getEntity().getSpecies_Id() != null)
			{
			 	dummy = new Species();
				dummy.setId(getEntity().getSpecies_Id());
				dummy.setIdentifier( getEntity().getSpecies_Identifier() ); 
			}
			XrefInput<Species> input = new XrefInput<Species>("SamplePanel_Species", org.molgenis.observ.target.Species.class, dummy);
			
			input.setLabel("Species");
			input.setDescription("The species this panel is an instance of/part of/extracted from.");
			input.setNillable(true);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//Individuals: Field(entity=Panel, name=Individuals, type=mref[Individual.id], mref_name=Panel_Individuals, mref_localid=Panel, mref_remoteid=Individuals, xref_label='Identifier', auto=false, nillable=true, readonly=false, default=)
		{
			//TODO: when we have JPA this should become:
			//MrefInput input = new MrefInput("SamplePanel_Individuals", getEntity().getIndividuals());
			//create xref dummy list of references
			List<Individual> dummyList = new ArrayList<Individual>();
			if(getEntity().getIndividuals_Id() != null) for(int i = 0; i < getEntity().getIndividuals_Id().size(); i++ )
			{
				Individual dummy = new Individual();
				dummy.setId(getEntity().getIndividuals_Id().get(i));
				dummy.setIdentifier( getEntity().getIndividuals_Identifier().get(i) ); 
				dummyList.add(dummy);
			}   
			MrefInput<Individual> input = new MrefInput<Individual> ("SamplePanel_Individuals", org.molgenis.observ.target.Individual.class, dummyList);
			
			input.setLabel("Individuals");
			input.setDescription("The list of individuals in this panel");
			input.setNillable(true);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//CentralIdentifier: Field(entity=SamplePanel, name=CentralIdentifier, type=xref[OntologyTerm.id], xref_label='Identifier', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<SamplePanel> input = new XrefInput<SamplePanel>("SamplePanel_CentralIdentifier", getEntity().getCentralIdentifier());
			//create xref dummy object
			OntologyTerm dummy = null;
			if(getEntity().getCentralIdentifier_Id() != null)
			{
			 	dummy = new OntologyTerm();
				dummy.setId(getEntity().getCentralIdentifier_Id());
				dummy.setIdentifier( getEntity().getCentralIdentifier_Identifier() ); 
			}
			XrefInput<OntologyTerm> input = new XrefInput<OntologyTerm>("SamplePanel_CentralIdentifier", org.molgenis.observ.target.OntologyTerm.class, dummy);
			
			input.setLabel("CentralIdentifier");
			input.setDescription("The central GWAS identifier for this panel");
			input.setNillable(true);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//Label: Field(entity=SamplePanel, name=Label, type=string[10], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("SamplePanel_Label",getEntity().getLabel());
			
			input.setLabel("Label");
			input.setDescription("Label");
			input.setNillable(true);
			input.setSize(10);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			input.setHidden(true);
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//Accession: Field(entity=SamplePanel, name=Accession, type=string[15], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("SamplePanel_Accession",getEntity().getAccession());
			
			input.setLabel("Accession");
			input.setDescription("Accession");
			input.setNillable(true);
			input.setSize(15);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			input.setHidden(true);
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//AccessionVersion: Field(entity=SamplePanel, name=AccessionVersion, type=string[10], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("SamplePanel_AccessionVersion",getEntity().getAccessionVersion());
			
			input.setLabel("Accession version");
			input.setDescription("Accession version");
			input.setNillable(true);
			input.setSize(10);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			input.setHidden(true);
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//Composition: Field(entity=SamplePanel, name=Composition, type=text, auto=false, nillable=true, readonly=false, default=)
		{
			TextInput input = new TextInput("SamplePanel_Composition",getEntity().getComposition());
			
			input.setLabel("Composition");
			input.setDescription("Composition");
			input.setNillable(true);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//TotalNumberOfIndividuals: Field(entity=SamplePanel, name=TotalNumberOfIndividuals, type=int, auto=false, nillable=true, readonly=false, default=)
		{
			IntInput input = new IntInput("SamplePanel_TotalNumberOfIndividuals",getEntity().getTotalNumberOfIndividuals());
			
			input.setLabel("Total number of individuals");
			input.setDescription("*...but required for association datasets");
			input.setNillable(true);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//NumberOfSexMale: Field(entity=SamplePanel, name=NumberOfSexMale, type=int, auto=false, nillable=true, readonly=false, default=)
		{
			IntInput input = new IntInput("SamplePanel_NumberOfSexMale",getEntity().getNumberOfSexMale());
			
			input.setLabel("Number of males");
			input.setDescription("Number of males");
			input.setNillable(true);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//NumberOfSexFemale: Field(entity=SamplePanel, name=NumberOfSexFemale, type=int, auto=false, nillable=true, readonly=false, default=)
		{
			IntInput input = new IntInput("SamplePanel_NumberOfSexFemale",getEntity().getNumberOfSexFemale());
			
			input.setLabel("Number of females");
			input.setDescription("Number of females");
			input.setNillable(true);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//NumberOfSexUnknown: Field(entity=SamplePanel, name=NumberOfSexUnknown, type=int, auto=false, nillable=true, readonly=false, default=)
		{
			IntInput input = new IntInput("SamplePanel_NumberOfSexUnknown",getEntity().getNumberOfSexUnknown());
			
			input.setLabel("Number of unknown sex");
			input.setDescription("Number of unknown sex");
			input.setNillable(true);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//NumberOfProbands: Field(entity=SamplePanel, name=NumberOfProbands, type=int, auto=false, nillable=true, readonly=false, default=)
		{
			IntInput input = new IntInput("SamplePanel_NumberOfProbands",getEntity().getNumberOfProbands());
			
			input.setLabel("Number of probands");
			input.setDescription("field used only if Composition = &apos;Trios&apos;");
			input.setNillable(true);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//NumberOfParents: Field(entity=SamplePanel, name=NumberOfParents, type=int, auto=false, nillable=true, readonly=false, default=)
		{
			IntInput input = new IntInput("SamplePanel_NumberOfParents",getEntity().getNumberOfParents());
			
			input.setLabel("Number of parents");
			input.setDescription("field used only if Composition = &apos;Trios&apos;");
			input.setNillable(true);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//ModeOfRecruitment: Field(entity=SamplePanel, name=ModeOfRecruitment, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("SamplePanel_ModeOfRecruitment",getEntity().getModeOfRecruitment());
			
			input.setLabel("Mode of recruitment");
			input.setDescription("Mode of recruitment");
			input.setNillable(true);
			input.setSize(255);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//DiagnosisAgeRange: Field(entity=SamplePanel, name=DiagnosisAgeRange, type=string[150], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("SamplePanel_DiagnosisAgeRange",getEntity().getDiagnosisAgeRange());
			
			input.setLabel("Diagnosis age range");
			input.setDescription("Diagnosis age range");
			input.setNillable(true);
			input.setSize(150);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//DiagnosisPeriod: Field(entity=SamplePanel, name=DiagnosisPeriod, type=string[150], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("SamplePanel_DiagnosisPeriod",getEntity().getDiagnosisPeriod());
			
			input.setLabel("Diagnosis period");
			input.setDescription("Diagnosis period");
			input.setNillable(true);
			input.setSize(150);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//SamplingAgeRange: Field(entity=SamplePanel, name=SamplingAgeRange, type=string[150], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("SamplePanel_SamplingAgeRange",getEntity().getSamplingAgeRange());
			
			input.setLabel("Sampling age range");
			input.setDescription("Sampling age range");
			input.setNillable(true);
			input.setSize(150);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//SamplingPeriod: Field(entity=SamplePanel, name=SamplingPeriod, type=string[150], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("SamplePanel_SamplingPeriod",getEntity().getSamplingPeriod());
			
			input.setLabel("Sampling period");
			input.setDescription("Sampling period");
			input.setNillable(true);
			input.setSize(150);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//PopulationInfo: Field(entity=SamplePanel, name=PopulationInfo, type=string[250], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("SamplePanel_PopulationInfo",getEntity().getPopulationInfo());
			
			input.setLabel("Population information");
			input.setDescription("Population information");
			input.setNillable(true);
			input.setSize(250);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//GeographicRegionInfo: Field(entity=SamplePanel, name=GeographicRegionInfo, type=string[250], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("SamplePanel_GeographicRegionInfo",getEntity().getGeographicRegionInfo());
			
			input.setLabel("Geographic region information");
			input.setDescription("Geographic region information");
			input.setNillable(true);
			input.setSize(250);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//EthnicityInfo: Field(entity=SamplePanel, name=EthnicityInfo, type=string[250], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("SamplePanel_EthnicityInfo",getEntity().getEthnicityInfo());
			
			input.setLabel("Ethnicity information");
			input.setDescription("Ethnicity information");
			input.setNillable(true);
			input.setSize(250);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//BirthPlaceInfo: Field(entity=SamplePanel, name=BirthPlaceInfo, type=string[250], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("SamplePanel_BirthPlaceInfo",getEntity().getBirthPlaceInfo());
			
			input.setLabel("Birth place information");
			input.setDescription("Birth place information");
			input.setNillable(true);
			input.setSize(250);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//AdmixtureInfo: Field(entity=SamplePanel, name=AdmixtureInfo, type=string[250], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("SamplePanel_AdmixtureInfo",getEntity().getAdmixtureInfo());
			
			input.setLabel("Admixture information");
			input.setDescription("Admixture information");
			input.setNillable(true);
			input.setSize(250);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//EnvironmentInfo: Field(entity=SamplePanel, name=EnvironmentInfo, type=text, auto=false, nillable=true, readonly=false, default=)
		{
			TextInput input = new TextInput("SamplePanel_EnvironmentInfo",getEntity().getEnvironmentInfo());
			
			input.setLabel("Environment information");
			input.setDescription("Environment information");
			input.setNillable(true);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//SourceOfDNA: Field(entity=SamplePanel, name=SourceOfDNA, type=string[100], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("SamplePanel_SourceOfDNA",getEntity().getSourceOfDNA());
			
			input.setLabel("Source of DNA");
			input.setDescription("In (SELECT [SourceOfDNA] FROM [Sampleset_SourceOfDNAList];)");
			input.setNillable(true);
			input.setSize(100);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//DNAsArePooled: Field(entity=SamplePanel, name=DNAsArePooled, type=enum, auto=false, nillable=false, readonly=false, default=Undefined, enum_options=[Undefined, Pre-prep, Post-prep, No])
		{
			EnumInput input = new EnumInput("SamplePanel_DNAsArePooled",getEntity().getDNAsArePooled());
			
			input.setLabel("Are DNAs pooled?");
			input.setDescription("Are DNAs pooled?");
			input.setNillable(false);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			input.setOptions(getEntity().getDNAsArePooledOptions());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//DNAsAreWGA: Field(entity=SamplePanel, name=DNAsAreWGA, type=enum, auto=false, nillable=false, readonly=false, default=Undefined, enum_options=[Undefined, None, All, Some])
		{
			EnumInput input = new EnumInput("SamplePanel_DNAsAreWGA",getEntity().getDNAsAreWGA());
			
			input.setLabel("Are DNAs WGA?");
			input.setDescription("Are DNAs WGA?");
			input.setNillable(false);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			input.setOptions(getEntity().getDNAsAreWGAOptions());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}

		return inputs;
	}
}


