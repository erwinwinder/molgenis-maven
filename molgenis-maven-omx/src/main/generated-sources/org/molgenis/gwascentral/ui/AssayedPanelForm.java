
/* File:        Org.molgenis.omx/html/AssayedPanel.java
 * Copyright:   GBIC 2000-2013, all rights reserved
 * Date:        January 2, 2013
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
import org.molgenis.gwascentral.AssayedPanel;


/**
 * A HtmlForm that is preloaded with all inputs for entity AssayedPanel
 * @see EntityForm
 */
public class AssayedPanelForm extends EntityForm<AssayedPanel>
{
	
	public AssayedPanelForm()
	{
		super();
	}
	
	public AssayedPanelForm(AssayedPanel entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<AssayedPanel> getEntityClass()
	{
		return AssayedPanel.class;
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
		headers.add("Total number of individuals");
		headers.add("Number of males");
		headers.add("Number of females");
		headers.add("Number of unknown sex");
		headers.add("Number of probands");
		headers.add("Number of parents");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=AssayedPanel, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("AssayedPanel_id",getEntity().getId());
			
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
		//Identifier: Field(entity=AssayedPanel, name=Identifier, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("AssayedPanel_Identifier",getEntity().getIdentifier());
			
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
		//Name: Field(entity=AssayedPanel, name=Name, type=string[100], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("AssayedPanel_Name",getEntity().getName());
			
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
			EnumInput input = new EnumInput("AssayedPanel___Type",getEntity().get__Type());
			
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
		//Description: Field(entity=AssayedPanel, name=Description, type=text, auto=false, nillable=true, readonly=false, default=)
		{
			TextInput input = new TextInput("AssayedPanel_Description",getEntity().getDescription());
			
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
			//XrefInput<AssayedPanel> input = new XrefInput<AssayedPanel>("AssayedPanel_PanelType", getEntity().getPanelType());
			//create xref dummy object
			OntologyTerm dummy = null;
			if(getEntity().getPanelType_Id() != null)
			{
			 	dummy = new OntologyTerm();
				dummy.setId(getEntity().getPanelType_Id());
				dummy.setIdentifier( getEntity().getPanelType_Identifier() ); 
			}
			XrefInput<OntologyTerm> input = new XrefInput<OntologyTerm>("AssayedPanel_PanelType", org.molgenis.observ.target.OntologyTerm.class, dummy);
			
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
			IntInput input = new IntInput("AssayedPanel_NumberOfIndividuals",getEntity().getNumberOfIndividuals());
			
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
			//XrefInput<AssayedPanel> input = new XrefInput<AssayedPanel>("AssayedPanel_Species", getEntity().getSpecies());
			//create xref dummy object
			Species dummy = null;
			if(getEntity().getSpecies_Id() != null)
			{
			 	dummy = new Species();
				dummy.setId(getEntity().getSpecies_Id());
				dummy.setIdentifier( getEntity().getSpecies_Identifier() ); 
			}
			XrefInput<Species> input = new XrefInput<Species>("AssayedPanel_Species", org.molgenis.observ.target.Species.class, dummy);
			
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
			//MrefInput input = new MrefInput("AssayedPanel_Individuals", getEntity().getIndividuals());
			//create xref dummy list of references
			List<Individual> dummyList = new ArrayList<Individual>();
			if(getEntity().getIndividuals_Id() != null) for(int i = 0; i < getEntity().getIndividuals_Id().size(); i++ )
			{
				Individual dummy = new Individual();
				dummy.setId(getEntity().getIndividuals_Id().get(i));
				dummy.setIdentifier( getEntity().getIndividuals_Identifier().get(i) ); 
				dummyList.add(dummy);
			}   
			MrefInput<Individual> input = new MrefInput<Individual> ("AssayedPanel_Individuals", org.molgenis.observ.target.Individual.class, dummyList);
			
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
		//TotalNumberOfIndividuals: Field(entity=AssayedPanel, name=TotalNumberOfIndividuals, type=int, auto=false, nillable=true, readonly=false, default=)
		{
			IntInput input = new IntInput("AssayedPanel_TotalNumberOfIndividuals",getEntity().getTotalNumberOfIndividuals());
			
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
		//NumberOfSexMale: Field(entity=AssayedPanel, name=NumberOfSexMale, type=int, auto=false, nillable=true, readonly=false, default=)
		{
			IntInput input = new IntInput("AssayedPanel_NumberOfSexMale",getEntity().getNumberOfSexMale());
			
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
		//NumberOfSexFemale: Field(entity=AssayedPanel, name=NumberOfSexFemale, type=int, auto=false, nillable=true, readonly=false, default=)
		{
			IntInput input = new IntInput("AssayedPanel_NumberOfSexFemale",getEntity().getNumberOfSexFemale());
			
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
		//NumberOfSexUnknown: Field(entity=AssayedPanel, name=NumberOfSexUnknown, type=int, auto=false, nillable=true, readonly=false, default=)
		{
			IntInput input = new IntInput("AssayedPanel_NumberOfSexUnknown",getEntity().getNumberOfSexUnknown());
			
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
		//NumberOfProbands: Field(entity=AssayedPanel, name=NumberOfProbands, type=int, auto=false, nillable=true, readonly=false, default=)
		{
			IntInput input = new IntInput("AssayedPanel_NumberOfProbands",getEntity().getNumberOfProbands());
			
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
		//NumberOfParents: Field(entity=AssayedPanel, name=NumberOfParents, type=int, auto=false, nillable=true, readonly=false, default=)
		{
			IntInput input = new IntInput("AssayedPanel_NumberOfParents",getEntity().getNumberOfParents());
			
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

		return inputs;
	}
}


