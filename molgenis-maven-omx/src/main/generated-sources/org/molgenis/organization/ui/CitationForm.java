
/* File:        Org.molgenis/html/Citation.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 26, 2012
 * 
 * generator:   org.molgenis.generators.ui.HtmlFormGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
package org.molgenis.organization.ui;

// jdk
import java.util.Vector;
import java.util.List;
import java.util.ArrayList;


// molgenis
import org.molgenis.framework.ui.html.*;


import org.molgenis.observ.target.OntologyTerm;
import org.molgenis.organization.Citation;


/**
 * A HtmlForm that is preloaded with all inputs for entity Citation
 * @see EntityForm
 */
public class CitationForm extends EntityForm<Citation>
{
	
	public CitationForm()
	{
		super();
	}
	
	public CitationForm(Citation entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<Citation> getEntityClass()
	{
		return Citation.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("Identifier");
		headers.add("Name");
		headers.add("Pubmed ID");
		headers.add("Publication DOI");
		headers.add("ontologyTerms");
		headers.add("authorList");
		headers.add("Publication Title");
		headers.add("Description");
		headers.add("Publication Status");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=Citation, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("Citation_id",getEntity().getId());
			
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
		//Identifier: Field(entity=Citation, name=Identifier, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("Citation_Identifier",getEntity().getIdentifier());
			
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
		//Name: Field(entity=Citation, name=Name, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("Citation_Name",getEntity().getName());
			
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
		//PubmedID: Field(entity=Citation, name=PubmedID, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("Citation_PubmedID",getEntity().getPubmedID());
			
			input.setLabel("Pubmed ID");
			input.setDescription("Pubmed ID");
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
		//DOI: Field(entity=Citation, name=DOI, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("Citation_DOI",getEntity().getDOI());
			
			input.setLabel("Publication DOI");
			input.setDescription("Publication DOI");
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
		//OntologyTerms: Field(entity=Citation, name=ontologyTerms, type=mref[OntologyTerm.id], mref_name=Citation_ontologyTerms, mref_localid=Citation, mref_remoteid=ontologyTerms, xref_label='Identifier', auto=false, nillable=true, readonly=false, default=)
		{
			//TODO: when we have JPA this should become:
			//MrefInput input = new MrefInput("Citation_ontologyTerms", getEntity().getOntologyTerms());
			//create xref dummy list of references
			List<OntologyTerm> dummyList = new ArrayList<OntologyTerm>();
			if(getEntity().getOntologyTerms_Id() != null) for(int i = 0; i < getEntity().getOntologyTerms_Id().size(); i++ )
			{
				OntologyTerm dummy = new OntologyTerm();
				dummy.setId(getEntity().getOntologyTerms_Id().get(i));
				dummy.setIdentifier( getEntity().getOntologyTerms_Identifier().get(i) ); 
				dummyList.add(dummy);
			}   
			MrefInput<OntologyTerm> input = new MrefInput<OntologyTerm> ("Citation_ontologyTerms", org.molgenis.observ.target.OntologyTerm.class, dummyList);
			
			input.setLabel("ontologyTerms");
			input.setDescription("ontology terms such as MeSH");
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
		//AuthorList: Field(entity=Citation, name=authorList, type=text, auto=false, nillable=true, readonly=false, default=)
		{
			TextInput input = new TextInput("Citation_authorList",getEntity().getAuthorList());
			
			input.setLabel("authorList");
			input.setDescription("The names of the authors of the publication");
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
		//Title: Field(entity=Citation, name=Title, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("Citation_Title",getEntity().getTitle());
			
			input.setLabel("Publication Title");
			input.setDescription("The title of the Publication");
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
		//Description: Field(entity=Citation, name=Description, type=text, auto=false, nillable=false, readonly=false, default=)
		{
			TextInput input = new TextInput("Citation_Description",getEntity().getDescription());
			
			input.setLabel("Description");
			input.setDescription("Description");
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
		//Status: Field(entity=Citation, name=Status, type=xref[OntologyTerm.id], xref_label='Identifier', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<Citation> input = new XrefInput<Citation>("Citation_Status", getEntity().getStatus());
			//create xref dummy object
			OntologyTerm dummy = null;
			if(getEntity().getStatus_Id() != null)
			{
			 	dummy = new OntologyTerm();
				dummy.setId(getEntity().getStatus_Id());
				dummy.setIdentifier( getEntity().getStatus_Identifier() ); 
			}
			XrefInput<OntologyTerm> input = new XrefInput<OntologyTerm>("Citation_Status", org.molgenis.observ.target.OntologyTerm.class, dummy);
			
			input.setLabel("Publication Status");
			input.setDescription("The status of the Publication");
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


