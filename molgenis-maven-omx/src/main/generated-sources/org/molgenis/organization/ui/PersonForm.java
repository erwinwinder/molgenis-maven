
/* File:        Org.molgenis/html/Person.java
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
import org.molgenis.observ.target.OntologyTerm;
import org.molgenis.organization.Person;


/**
 * A HtmlForm that is preloaded with all inputs for entity Person
 * @see EntityForm
 */
public class PersonForm extends EntityForm<Person>
{
	
	public PersonForm()
	{
		super();
	}
	
	public PersonForm(Person entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<Person> getEntityClass()
	{
		return Person.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("Name");
		headers.add("Title");
		headers.add("First Name");
		headers.add("Mid Initials");
		headers.add("Last Name");
		headers.add("Email");
		headers.add("Phone");
		headers.add("Affliations");
		headers.add("Affliated Institutes");
		headers.add("OrcidPersonReference");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=Person, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("Person_id",getEntity().getId());
			
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
		//Name: Field(entity=Person, name=Name, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("Person_Name",getEntity().getName());
			
			input.setLabel("Name");
			input.setDescription("Name");
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
		//Title: Field(entity=Person, name=Title, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("Person_Title",getEntity().getTitle());
			
			input.setLabel("Title");
			input.setDescription("An academic title, e.g. Prof.dr, PhD");
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
		//FirstName: Field(entity=Person, name=FirstName, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("Person_FirstName",getEntity().getFirstName());
			
			input.setLabel("First Name");
			input.setDescription("First Name");
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
		//MidInitials: Field(entity=Person, name=MidInitials, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("Person_MidInitials",getEntity().getMidInitials());
			
			input.setLabel("Mid Initials");
			input.setDescription("Mid Initials");
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
		//LastName: Field(entity=Person, name=LastName, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("Person_LastName",getEntity().getLastName());
			
			input.setLabel("Last Name");
			input.setDescription("Last Name");
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
		//Email: Field(entity=Person, name=Email, type=email, auto=false, nillable=true, readonly=false, default=)
		{
			EmailInput input = new EmailInput("Person_Email",getEntity().getEmail());
			
			input.setLabel("Email");
			input.setDescription("Email");
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
		//Phone: Field(entity=Person, name=Phone, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("Person_Phone",getEntity().getPhone());
			
			input.setLabel("Phone");
			input.setDescription("The telephone number of the Contact including the suitable area codes.");
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
		//PrimaryAffilation: Field(entity=Person, name=PrimaryAffilation, type=xref[Institute.id], xref_label='name', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<Person> input = new XrefInput<Person>("Person_PrimaryAffilation", getEntity().getPrimaryAffilation());
			//create xref dummy object
			Institute dummy = null;
			if(getEntity().getPrimaryAffilation_Id() != null)
			{
			 	dummy = new Institute();
				dummy.setId(getEntity().getPrimaryAffilation_Id());
				dummy.setName( getEntity().getPrimaryAffilation_Name() ); 
			}
			XrefInput<Institute> input = new XrefInput<Institute>("Person_PrimaryAffilation", org.molgenis.organization.Institute.class, dummy);
			
			input.setLabel("Affliations");
			input.setDescription("Affliations");
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
		//AffiliateInstitutions: Field(entity=Person, name=AffiliateInstitutions, type=mref[Institute.id], mref_name=Person_AffiliateInstitutions, mref_localid=Person, mref_remoteid=AffiliateInstitutions, xref_label='name', auto=false, nillable=true, readonly=false, default=)
		{
			//TODO: when we have JPA this should become:
			//MrefInput input = new MrefInput("Person_AffiliateInstitutions", getEntity().getAffiliateInstitutions());
			//create xref dummy list of references
			List<Institute> dummyList = new ArrayList<Institute>();
			if(getEntity().getAffiliateInstitutions_Id() != null) for(int i = 0; i < getEntity().getAffiliateInstitutions_Id().size(); i++ )
			{
				Institute dummy = new Institute();
				dummy.setId(getEntity().getAffiliateInstitutions_Id().get(i));
				dummy.setName( getEntity().getAffiliateInstitutions_Name().get(i) ); 
				dummyList.add(dummy);
			}   
			MrefInput<Institute> input = new MrefInput<Institute> ("Person_AffiliateInstitutions", org.molgenis.organization.Institute.class, dummyList);
			
			input.setLabel("Affliated Institutes");
			input.setDescription("Affliated Institutes");
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
		//OrcidPersonReference: Field(entity=Person, name=OrcidPersonReference, type=xref[OntologyTerm.id], xref_label='Identifier', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<Person> input = new XrefInput<Person>("Person_OrcidPersonReference", getEntity().getOrcidPersonReference());
			//create xref dummy object
			OntologyTerm dummy = null;
			if(getEntity().getOrcidPersonReference_Id() != null)
			{
			 	dummy = new OntologyTerm();
				dummy.setId(getEntity().getOrcidPersonReference_Id());
				dummy.setIdentifier( getEntity().getOrcidPersonReference_Identifier() ); 
			}
			XrefInput<OntologyTerm> input = new XrefInput<OntologyTerm>("Person_OrcidPersonReference", org.molgenis.observ.target.OntologyTerm.class, dummy);
			
			input.setLabel("OrcidPersonReference");
			input.setDescription("OrcidPersonReference");
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


