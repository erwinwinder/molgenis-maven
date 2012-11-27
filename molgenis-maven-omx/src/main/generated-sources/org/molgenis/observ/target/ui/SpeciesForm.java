
/* File:        Org.molgenis/html/Species.java
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


import org.molgenis.observ.target.Ontology;
import org.molgenis.observ.target.Species;


/**
 * A HtmlForm that is preloaded with all inputs for entity Species
 * @see EntityForm
 */
public class SpeciesForm extends EntityForm<Species>
{
	
	public SpeciesForm()
	{
		super();
	}
	
	public SpeciesForm(Species entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<Species> getEntityClass()
	{
		return Species.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("Identifier");
		headers.add("Name");
		headers.add("ontology");
		headers.add("termAccession");
		headers.add("definition");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=Species, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("Species_id",getEntity().getId());
			
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
		//Identifier: Field(entity=OntologyTerm, name=Identifier, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("Species_Identifier",getEntity().getIdentifier());
			
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
		//Name: Field(entity=OntologyTerm, name=Name, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("Species_Name",getEntity().getName());
			
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
		//__Type: Field(entity=OntologyTerm, name=__Type, type=enum, auto=true, nillable=false, readonly=true, default=null, enum_options=[OntologyTerm, Species, Accession])
		{
			EnumInput input = new EnumInput("Species___Type",getEntity().get__Type());
			
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
		//Ontology: Field(entity=OntologyTerm, name=ontology, type=xref[Ontology.id], xref_label='Identifier', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<Species> input = new XrefInput<Species>("Species_ontology", getEntity().getOntology());
			//create xref dummy object
			Ontology dummy = null;
			if(getEntity().getOntology_Id() != null)
			{
			 	dummy = new Ontology();
				dummy.setId(getEntity().getOntology_Id());
				dummy.setIdentifier( getEntity().getOntology_Identifier() ); 
			}
			XrefInput<Ontology> input = new XrefInput<Ontology>("Species_ontology", org.molgenis.observ.target.Ontology.class, dummy);
			
			input.setLabel("ontology");
			input.setDescription("(Optional) The source ontology or controlled vocabulary list that ontology terms have been obtained from.");
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
		//TermAccession: Field(entity=OntologyTerm, name=termAccession, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("Species_termAccession",getEntity().getTermAccession());
			
			input.setLabel("termAccession");
			input.setDescription("(Optional) The accession number assigned to the ontology term in its source ontology. If empty it is assumed to be a locally defined term.");
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
		//Definition: Field(entity=OntologyTerm, name=definition, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("Species_definition",getEntity().getDefinition());
			
			input.setLabel("definition");
			input.setDescription("(Optional) The definition of the term.");
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

		return inputs;
	}
}


