
/* File:        Org.molgenis/html/Panel.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 26, 2012
 * 
 * generator:   org.molgenis.generators.ui.HtmlFormGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
package org.molgenis.observ.target.ui;

// jdk
import java.util.Vector;
import java.util.List;
import java.util.ArrayList;


// molgenis
import org.molgenis.framework.ui.html.*;


import org.molgenis.observ.target.OntologyTerm;
import org.molgenis.observ.target.Species;
import org.molgenis.observ.target.Individual;
import org.molgenis.observ.target.Panel;


/**
 * A HtmlForm that is preloaded with all inputs for entity Panel
 * @see EntityForm
 */
public class PanelForm extends EntityForm<Panel>
{
	
	public PanelForm()
	{
		super();
	}
	
	public PanelForm(Panel entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<Panel> getEntityClass()
	{
		return Panel.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("Identifier");
		headers.add("Name");
		headers.add("description");
		headers.add("PanelType");
		headers.add("NumberOfIndividuals");
		headers.add("Species");
		headers.add("Individuals");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=Panel, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("Panel_id",getEntity().getId());
			
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
		//Identifier: Field(entity=Characteristic, name=Identifier, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("Panel_Identifier",getEntity().getIdentifier());
			
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
		//Name: Field(entity=Characteristic, name=Name, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("Panel_Name",getEntity().getName());
			
			input.setLabel("Name");
			input.setDescription("human readible name, not necessary unique.");
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
		//__Type: Field(entity=Characteristic, name=__Type, type=enum, auto=true, nillable=false, readonly=true, default=null, enum_options=[Characteristic, Individual, SamplePanel, AssayedPanel, Panel, ObservationTarget, PhenotypeProperty, UsedMarkerSet, ObservableFeature, Category, Protocol, FrequencyCluster, GenotypeFrequency, AlleleFrequency, PhenotypeMethod, Significance, EffectSize, DataSet, Genome, Chromosome, Gene, Protein, ProteinDomain, Exon, Variant])
		{
			EnumInput input = new EnumInput("Panel___Type",getEntity().get__Type());
			
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
		//Description: Field(entity=Characteristic, name=description, type=text, auto=false, nillable=true, readonly=false, default=)
		{
			TextInput input = new TextInput("Panel_description",getEntity().getDescription());
			
			input.setLabel("description");
			input.setDescription("(Optional) Rudimentary meta data about the observable feature. Use of ontology       terms references to establish unambigious descriptions is recommended");
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
			//XrefInput<Panel> input = new XrefInput<Panel>("Panel_PanelType", getEntity().getPanelType());
			//create xref dummy object
			OntologyTerm dummy = null;
			if(getEntity().getPanelType_Id() != null)
			{
			 	dummy = new OntologyTerm();
				dummy.setId(getEntity().getPanelType_Id());
				dummy.setIdentifier( getEntity().getPanelType_Identifier() ); 
			}
			XrefInput<OntologyTerm> input = new XrefInput<OntologyTerm>("Panel_PanelType", org.molgenis.observ.target.OntologyTerm.class, dummy);
			
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
			IntInput input = new IntInput("Panel_NumberOfIndividuals",getEntity().getNumberOfIndividuals());
			
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
			//XrefInput<Panel> input = new XrefInput<Panel>("Panel_Species", getEntity().getSpecies());
			//create xref dummy object
			Species dummy = null;
			if(getEntity().getSpecies_Id() != null)
			{
			 	dummy = new Species();
				dummy.setId(getEntity().getSpecies_Id());
				dummy.setIdentifier( getEntity().getSpecies_Identifier() ); 
			}
			XrefInput<Species> input = new XrefInput<Species>("Panel_Species", org.molgenis.observ.target.Species.class, dummy);
			
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
			//MrefInput input = new MrefInput("Panel_Individuals", getEntity().getIndividuals());
			//create xref dummy list of references
			List<Individual> dummyList = new ArrayList<Individual>();
			if(getEntity().getIndividuals_Id() != null) for(int i = 0; i < getEntity().getIndividuals_Id().size(); i++ )
			{
				Individual dummy = new Individual();
				dummy.setId(getEntity().getIndividuals_Id().get(i));
				dummy.setIdentifier( getEntity().getIndividuals_Identifier().get(i) ); 
				dummyList.add(dummy);
			}   
			MrefInput<Individual> input = new MrefInput<Individual> ("Panel_Individuals", org.molgenis.observ.target.Individual.class, dummyList);
			
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

		return inputs;
	}
}


