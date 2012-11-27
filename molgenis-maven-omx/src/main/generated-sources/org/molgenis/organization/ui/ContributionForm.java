
/* File:        Org.molgenis/html/Contribution.java
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


import org.molgenis.organization.Person;
import org.molgenis.organization.Submission;
import org.molgenis.organization.Contribution;


/**
 * A HtmlForm that is preloaded with all inputs for entity Contribution
 * @see EntityForm
 */
public class ContributionForm extends EntityForm<Contribution>
{
	
	public ContributionForm()
	{
		super();
	}
	
	public ContributionForm(Contribution entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<Contribution> getEntityClass()
	{
		return Contribution.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("Identifier");
		headers.add("Name");
		headers.add("Researcher");
		headers.add("Submission");
		headers.add("Submitter?");
		headers.add("Author?");
		headers.add("Source?");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=Contribution, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("Contribution_id",getEntity().getId());
			
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
		//Identifier: Field(entity=Contribution, name=Identifier, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("Contribution_Identifier",getEntity().getIdentifier());
			
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
		//Name: Field(entity=Contribution, name=Name, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("Contribution_Name",getEntity().getName());
			
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
		//Researcher: Field(entity=Contribution, name=Researcher, type=xref[Person.id], xref_label='Name', auto=false, nillable=false, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<Contribution> input = new XrefInput<Contribution>("Contribution_Researcher", getEntity().getResearcher());
			//create xref dummy object
			Person dummy = null;
			if(getEntity().getResearcher_Id() != null)
			{
			 	dummy = new Person();
				dummy.setId(getEntity().getResearcher_Id());
				dummy.setName( getEntity().getResearcher_Name() ); 
			}
			XrefInput<Person> input = new XrefInput<Person>("Contribution_Researcher", org.molgenis.organization.Person.class, dummy);
			
			input.setLabel("Researcher");
			input.setDescription("The person involved");
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
		//Submission: Field(entity=Contribution, name=Submission, type=xref[Submission.id], xref_label='Identifier', auto=false, nillable=false, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<Contribution> input = new XrefInput<Contribution>("Contribution_Submission", getEntity().getSubmission());
			//create xref dummy object
			Submission dummy = null;
			if(getEntity().getSubmission_Id() != null)
			{
			 	dummy = new Submission();
				dummy.setId(getEntity().getSubmission_Id());
				dummy.setIdentifier( getEntity().getSubmission_Identifier() ); 
			}
			XrefInput<Submission> input = new XrefInput<Submission>("Contribution_Submission", org.molgenis.organization.Submission.class, dummy);
			
			input.setLabel("Submission");
			input.setDescription("The submission contributed to.");
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
		//IsSubmitter: Field(entity=Contribution, name=IsSubmitter, type=enum, auto=false, nillable=false, readonly=false, default=, enum_options=[yes, no])
		{
			EnumInput input = new EnumInput("Contribution_IsSubmitter",getEntity().getIsSubmitter());
			
			input.setLabel("Submitter?");
			input.setDescription("Submitter?");
			input.setNillable(false);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			input.setOptions(getEntity().getIsSubmitterOptions());
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
		//IsAuthor: Field(entity=Contribution, name=IsAuthor, type=enum, auto=false, nillable=false, readonly=false, default=, enum_options=[yes, no])
		{
			EnumInput input = new EnumInput("Contribution_IsAuthor",getEntity().getIsAuthor());
			
			input.setLabel("Author?");
			input.setDescription("Author?");
			input.setNillable(false);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			input.setOptions(getEntity().getIsAuthorOptions());
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
		//IsSource: Field(entity=Contribution, name=IsSource, type=enum, auto=false, nillable=false, readonly=false, default=, enum_options=[yes, no])
		{
			EnumInput input = new EnumInput("Contribution_IsSource",getEntity().getIsSource());
			
			input.setLabel("Source?");
			input.setDescription("Source?");
			input.setNillable(false);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			input.setOptions(getEntity().getIsSourceOptions());
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


