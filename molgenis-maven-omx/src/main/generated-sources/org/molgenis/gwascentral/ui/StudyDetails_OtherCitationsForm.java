
/* File:        Org.molgenis/html/StudyDetails_otherCitations.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 26, 2012
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


import org.molgenis.organization.Citation;
import org.molgenis.gwascentral.StudyDetails;
import org.molgenis.gwascentral.StudyDetails_OtherCitations;


/**
 * A HtmlForm that is preloaded with all inputs for entity StudyDetails_OtherCitations
 * @see EntityForm
 */
public class StudyDetails_OtherCitationsForm extends EntityForm<StudyDetails_OtherCitations>
{
	
	public StudyDetails_OtherCitationsForm()
	{
		super();
	}
	
	public StudyDetails_OtherCitationsForm(StudyDetails_OtherCitations entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<StudyDetails_OtherCitations> getEntityClass()
	{
		return StudyDetails_OtherCitations.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("otherCitations");
		headers.add("StudyDetails");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Autoid: Field(entity=StudyDetails_otherCitations, name=autoid, type=int, auto=true, nillable=false, readonly=false, default=null)
		{
			IntInput input = new IntInput("StudyDetails_otherCitations_autoid",getEntity().getAutoid());
			
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
		//OtherCitations: Field(entity=StudyDetails_otherCitations, name=otherCitations, type=xref[Citation.id], xref_label='Identifier', auto=false, nillable=false, readonly=false, default=null)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<StudyDetails_OtherCitations> input = new XrefInput<StudyDetails_OtherCitations>("StudyDetails_otherCitations_otherCitations", getEntity().getOtherCitations());
			//create xref dummy object
			Citation dummy = null;
			if(getEntity().getOtherCitations_Id() != null)
			{
			 	dummy = new Citation();
				dummy.setId(getEntity().getOtherCitations_Id());
				dummy.setIdentifier( getEntity().getOtherCitations_Identifier() ); 
			}
			XrefInput<Citation> input = new XrefInput<Citation>("StudyDetails_otherCitations_otherCitations", org.molgenis.organization.Citation.class, dummy);
			
			input.setLabel("otherCitations");
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
		//StudyDetails: Field(entity=StudyDetails_otherCitations, name=StudyDetails, type=xref[StudyDetails.id], xref_label='id', auto=false, nillable=false, readonly=false, default=null)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<StudyDetails_OtherCitations> input = new XrefInput<StudyDetails_OtherCitations>("StudyDetails_otherCitations_StudyDetails", getEntity().getStudyDetails());
			//create xref dummy object
			StudyDetails dummy = null;
			if(getEntity().getStudyDetails_Id() != null)
			{
			 	dummy = new StudyDetails();
				dummy.setId(getEntity().getStudyDetails_Id());
			}
			XrefInput<StudyDetails> input = new XrefInput<StudyDetails>("StudyDetails_otherCitations_StudyDetails", org.molgenis.gwascentral.StudyDetails.class, dummy);
			
			input.setLabel("StudyDetails");
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


