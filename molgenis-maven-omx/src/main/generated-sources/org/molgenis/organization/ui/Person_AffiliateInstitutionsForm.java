
/* File:        Org.molgenis/html/Person_AffiliateInstitutions.java
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


import org.molgenis.organization.Institute;
import org.molgenis.organization.Person;
import org.molgenis.organization.Person_AffiliateInstitutions;


/**
 * A HtmlForm that is preloaded with all inputs for entity Person_AffiliateInstitutions
 * @see EntityForm
 */
public class Person_AffiliateInstitutionsForm extends EntityForm<Person_AffiliateInstitutions>
{
	
	public Person_AffiliateInstitutionsForm()
	{
		super();
	}
	
	public Person_AffiliateInstitutionsForm(Person_AffiliateInstitutions entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<Person_AffiliateInstitutions> getEntityClass()
	{
		return Person_AffiliateInstitutions.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("AffiliateInstitutions");
		headers.add("Person");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Autoid: Field(entity=Person_AffiliateInstitutions, name=autoid, type=int, auto=true, nillable=false, readonly=false, default=null)
		{
			IntInput input = new IntInput("Person_AffiliateInstitutions_autoid",getEntity().getAutoid());
			
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
		//AffiliateInstitutions: Field(entity=Person_AffiliateInstitutions, name=AffiliateInstitutions, type=xref[Institute.id], xref_label='name', auto=false, nillable=false, readonly=false, default=null)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<Person_AffiliateInstitutions> input = new XrefInput<Person_AffiliateInstitutions>("Person_AffiliateInstitutions_AffiliateInstitutions", getEntity().getAffiliateInstitutions());
			//create xref dummy object
			Institute dummy = null;
			if(getEntity().getAffiliateInstitutions_Id() != null)
			{
			 	dummy = new Institute();
				dummy.setId(getEntity().getAffiliateInstitutions_Id());
				dummy.setName( getEntity().getAffiliateInstitutions_Name() ); 
			}
			XrefInput<Institute> input = new XrefInput<Institute>("Person_AffiliateInstitutions_AffiliateInstitutions", org.molgenis.organization.Institute.class, dummy);
			
			input.setLabel("AffiliateInstitutions");
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
		//Person: Field(entity=Person_AffiliateInstitutions, name=Person, type=xref[Person.id], xref_label=, auto=false, nillable=false, readonly=false, default=null)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<Person_AffiliateInstitutions> input = new XrefInput<Person_AffiliateInstitutions>("Person_AffiliateInstitutions_Person", getEntity().getPerson());
			//create xref dummy object
			Person dummy = null;
			if(getEntity().getPerson_Id() != null)
			{
			 	dummy = new Person();
				dummy.setId(getEntity().getPerson_Id());
				dummy.setName( getEntity().getPerson_Name() ); 
			}
			XrefInput<Person> input = new XrefInput<Person>("Person_AffiliateInstitutions_Person", org.molgenis.organization.Person.class, dummy);
			
			input.setLabel("Person");
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


