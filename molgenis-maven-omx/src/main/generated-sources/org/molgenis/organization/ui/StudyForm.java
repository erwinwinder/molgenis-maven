
/* File:        Org.molgenis/html/Study.java
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
import org.molgenis.gwascentral.Investigation;
import org.molgenis.organization.Study;


/**
 * A HtmlForm that is preloaded with all inputs for entity Study
 * @see EntityForm
 */
public class StudyForm extends EntityForm<Study>
{
	
	public StudyForm()
	{
		super();
	}
	
	public StudyForm(Study entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<Study> getEntityClass()
	{
		return Study.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("Identifier");
		headers.add("Name");
		headers.add("Description");
		headers.add("StartDate");
		headers.add("UpdateDate");
		headers.add("EndDate");
		headers.add("Contact");
		headers.add("Part of Investigation");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=Study, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("Study_id",getEntity().getId());
			
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
		//Identifier: Field(entity=Study, name=Identifier, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("Study_Identifier",getEntity().getIdentifier());
			
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
		//Name: Field(entity=Study, name=Name, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("Study_Name",getEntity().getName());
			
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
		//Description: Field(entity=Study, name=Description, type=text, auto=false, nillable=true, readonly=false, default=)
		{
			TextInput input = new TextInput("Study_Description",getEntity().getDescription());
			
			input.setLabel("Description");
			input.setDescription("(Optional)      Rudimentary meta data about the Investigation");
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
		//StartDate: Field(entity=Study, name=StartDate, type=datetime, auto=true, nillable=true, readonly=false, default=)
		{
			DatetimeInput input = new DatetimeInput("Study_StartDate",getEntity().getStartDate());
			
			input.setLabel("StartDate");
			input.setDescription("The start point of the study.");
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
		//UpdateDate: Field(entity=Study, name=UpdateDate, type=datetime, auto=true, nillable=false, readonly=false, default=)
		{
			DatetimeInput input = new DatetimeInput("Study_UpdateDate",getEntity().getUpdateDate());
			
			input.setLabel("UpdateDate");
			input.setDescription("Last time the investigation was modified");
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
		//EndDate: Field(entity=Study, name=EndDate, type=datetime, auto=false, nillable=true, readonly=false, default=)
		{
			DatetimeInput input = new DatetimeInput("Study_EndDate",getEntity().getEndDate());
			
			input.setLabel("EndDate");
			input.setDescription("The end point of the study.");
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
		//Contact: Field(entity=Study, name=Contact, type=xref[Person.id], xref_label='Name', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<Study> input = new XrefInput<Study>("Study_Contact", getEntity().getContact());
			//create xref dummy object
			Person dummy = null;
			if(getEntity().getContact_Id() != null)
			{
			 	dummy = new Person();
				dummy.setId(getEntity().getContact_Id());
				dummy.setName( getEntity().getContact_Name() ); 
			}
			XrefInput<Person> input = new XrefInput<Person>("Study_Contact", org.molgenis.organization.Person.class, dummy);
			
			input.setLabel("Contact");
			input.setDescription("Primary contact person for this study");
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
		//PartOfInvestigation: Field(entity=Study, name=PartOfInvestigation, type=xref[Investigation.id], xref_label='Identifier', auto=false, nillable=false, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<Study> input = new XrefInput<Study>("Study_PartOfInvestigation", getEntity().getPartOfInvestigation());
			//create xref dummy object
			Investigation dummy = null;
			if(getEntity().getPartOfInvestigation_Id() != null)
			{
			 	dummy = new Investigation();
				dummy.setId(getEntity().getPartOfInvestigation_Id());
				dummy.setIdentifier( getEntity().getPartOfInvestigation_Identifier() ); 
			}
			XrefInput<Investigation> input = new XrefInput<Investigation>("Study_PartOfInvestigation", org.molgenis.gwascentral.Investigation.class, dummy);
			
			input.setLabel("Part of Investigation");
			input.setDescription("xref to the investigation the study is part of");
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


