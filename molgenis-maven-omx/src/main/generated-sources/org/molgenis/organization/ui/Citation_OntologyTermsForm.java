
/* File:        Org.molgenis/html/Citation_ontologyTerms.java
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
import org.molgenis.organization.Citation_OntologyTerms;


/**
 * A HtmlForm that is preloaded with all inputs for entity Citation_OntologyTerms
 * @see EntityForm
 */
public class Citation_OntologyTermsForm extends EntityForm<Citation_OntologyTerms>
{
	
	public Citation_OntologyTermsForm()
	{
		super();
	}
	
	public Citation_OntologyTermsForm(Citation_OntologyTerms entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<Citation_OntologyTerms> getEntityClass()
	{
		return Citation_OntologyTerms.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("ontologyTerms");
		headers.add("Citation");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Autoid: Field(entity=Citation_ontologyTerms, name=autoid, type=int, auto=true, nillable=false, readonly=false, default=null)
		{
			IntInput input = new IntInput("Citation_ontologyTerms_autoid",getEntity().getAutoid());
			
			input.setLabel("autoid");
			input.setDescription("automatic id field to ensure ordering of mrefs");
			input.setNillable(false);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			input.setHidden(!isNewRecord());
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//OntologyTerms: Field(entity=Citation_ontologyTerms, name=ontologyTerms, type=xref[OntologyTerm.id], xref_label='Identifier', auto=false, nillable=false, readonly=false, default=null)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<Citation_OntologyTerms> input = new XrefInput<Citation_OntologyTerms>("Citation_ontologyTerms_ontologyTerms", getEntity().getOntologyTerms());
			//create xref dummy object
			OntologyTerm dummy = null;
			if(getEntity().getOntologyTerms_Id() != null)
			{
			 	dummy = new OntologyTerm();
				dummy.setId(getEntity().getOntologyTerms_Id());
				dummy.setIdentifier( getEntity().getOntologyTerms_Identifier() ); 
			}
			XrefInput<OntologyTerm> input = new XrefInput<OntologyTerm>("Citation_ontologyTerms_ontologyTerms", org.molgenis.observ.target.OntologyTerm.class, dummy);
			
			input.setLabel("ontologyTerms");
			input.setDescription("");
			input.setNillable(false);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(!isNewRecord());
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//Citation: Field(entity=Citation_ontologyTerms, name=Citation, type=xref[Citation.id], xref_label=, auto=false, nillable=false, readonly=false, default=null)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<Citation_OntologyTerms> input = new XrefInput<Citation_OntologyTerms>("Citation_ontologyTerms_Citation", getEntity().getCitation());
			//create xref dummy object
			Citation dummy = null;
			if(getEntity().getCitation_Id() != null)
			{
			 	dummy = new Citation();
				dummy.setId(getEntity().getCitation_Id());
				dummy.setIdentifier( getEntity().getCitation_Identifier() ); 
			}
			XrefInput<Citation> input = new XrefInput<Citation>("Citation_ontologyTerms_Citation", org.molgenis.organization.Citation.class, dummy);
			
			input.setLabel("Citation");
			input.setDescription("");
			input.setNillable(false);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(!isNewRecord());
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


