
/* File:        Org.molgenis/html/Submission.java
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


import org.molgenis.organization.Study;
import org.molgenis.organization.Submission;


/**
 * A HtmlForm that is preloaded with all inputs for entity Submission
 * @see EntityForm
 */
public class SubmissionForm extends EntityForm<Submission>
{
	
	public SubmissionForm()
	{
		super();
	}
	
	public SubmissionForm(Submission entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<Submission> getEntityClass()
	{
		return Submission.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("Identifier");
		headers.add("Name");
		headers.add("Time created");
		headers.add("Study");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=Submission, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("Submission_id",getEntity().getId());
			
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
		//Identifier: Field(entity=Submission, name=Identifier, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("Submission_Identifier",getEntity().getIdentifier());
			
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
		//Name: Field(entity=Submission, name=Name, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("Submission_Name",getEntity().getName());
			
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
		//TimeCreated: Field(entity=Submission, name=TimeCreated, type=datetime, auto=false, nillable=false, readonly=false, default=)
		{
			DatetimeInput input = new DatetimeInput("Submission_TimeCreated",getEntity().getTimeCreated());
			
			input.setLabel("Time created");
			input.setDescription("Time created");
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
		//Study: Field(entity=Submission, name=Study, type=xref[Study.id], xref_label='Identifier', auto=false, nillable=false, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<Submission> input = new XrefInput<Submission>("Submission_Study", getEntity().getStudy());
			//create xref dummy object
			Study dummy = null;
			if(getEntity().getStudy_Id() != null)
			{
			 	dummy = new Study();
				dummy.setId(getEntity().getStudy_Id());
				dummy.setIdentifier( getEntity().getStudy_Identifier() ); 
			}
			XrefInput<Study> input = new XrefInput<Study>("Submission_Study", org.molgenis.organization.Study.class, dummy);
			
			input.setLabel("Study");
			input.setDescription("Study");
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

		return inputs;
	}
}


