
/* File:        Org.molgenis/html/StudyDetails.java
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


import org.molgenis.organization.Study;
import org.molgenis.organization.Citation;
import org.molgenis.gwascentral.StudyDetails;


/**
 * A HtmlForm that is preloaded with all inputs for entity StudyDetails
 * @see EntityForm
 */
public class StudyDetailsForm extends EntityForm<StudyDetails>
{
	
	public StudyDetailsForm()
	{
		super();
	}
	
	public StudyDetailsForm(StudyDetails entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<StudyDetails> getEntityClass()
	{
		return StudyDetails.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("Study");
		headers.add("Title");
		headers.add("ShortName");
		headers.add("Abstract");
		headers.add("Accession version");
		headers.add("Background");
		headers.add("Objectives");
		headers.add("Key results");
		headers.add("Conclusions");
		headers.add("Study design");
		headers.add("Reason for study size");
		headers.add("Study power");
		headers.add("Sources of bias");
		headers.add("Limitations");
		headers.add("Acknowledgements");
		headers.add("primaryCitation");
		headers.add("otherCitations");
		headers.add("Accession");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=StudyDetails, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("StudyDetails_id",getEntity().getId());
			
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
		//Study: Field(entity=StudyDetails, name=Study, type=xref[Study.id], xref_label='Identifier', auto=false, nillable=false, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<StudyDetails> input = new XrefInput<StudyDetails>("StudyDetails_Study", getEntity().getStudy());
			//create xref dummy object
			Study dummy = null;
			if(getEntity().getStudy_Id() != null)
			{
			 	dummy = new Study();
				dummy.setId(getEntity().getStudy_Id());
				dummy.setIdentifier( getEntity().getStudy_Identifier() ); 
			}
			XrefInput<Study> input = new XrefInput<Study>("StudyDetails_Study", org.molgenis.organization.Study.class, dummy);
			
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
		//Title: Field(entity=StudyDetails, name=Title, type=text, auto=false, nillable=true, readonly=false, default=)
		{
			TextInput input = new TextInput("StudyDetails_Title",getEntity().getTitle());
			
			input.setLabel("Title");
			input.setDescription("Nice title of the paper");
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
		//ShortName: Field(entity=StudyDetails, name=ShortName, type=text, auto=false, nillable=true, readonly=false, default=)
		{
			TextInput input = new TextInput("StudyDetails_ShortName",getEntity().getShortName());
			
			input.setLabel("ShortName");
			input.setDescription("Shorthand name for layout");
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
		//StudyAbstract: Field(entity=StudyDetails, name=StudyAbstract, type=text, auto=false, nillable=false, readonly=false, default=)
		{
			TextInput input = new TextInput("StudyDetails_StudyAbstract",getEntity().getStudyAbstract());
			
			input.setLabel("Abstract");
			input.setDescription("Abstract");
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
		//Version: Field(entity=StudyDetails, name=Version, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("StudyDetails_Version",getEntity().getVersion());
			
			input.setLabel("Accession version");
			input.setDescription("Accession version");
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
		//Background: Field(entity=StudyDetails, name=Background, type=text, auto=false, nillable=true, readonly=false, default=)
		{
			TextInput input = new TextInput("StudyDetails_Background",getEntity().getBackground());
			
			input.setLabel("Background");
			input.setDescription("Short piece of information describing why the study is taking place, e.g. risk factors for a population");
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
		//Objectives: Field(entity=StudyDetails, name=Objectives, type=text, auto=false, nillable=true, readonly=false, default=)
		{
			TextInput input = new TextInput("StudyDetails_Objectives",getEntity().getObjectives());
			
			input.setLabel("Objectives");
			input.setDescription("What this study aims to achieve");
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
		//KeyResults: Field(entity=StudyDetails, name=KeyResults, type=text, auto=false, nillable=true, readonly=false, default=)
		{
			TextInput input = new TextInput("StudyDetails_KeyResults",getEntity().getKeyResults());
			
			input.setLabel("Key results");
			input.setDescription("Noticable results from this study");
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
		//Conclusions: Field(entity=StudyDetails, name=Conclusions, type=text, auto=false, nillable=true, readonly=false, default=)
		{
			TextInput input = new TextInput("StudyDetails_Conclusions",getEntity().getConclusions());
			
			input.setLabel("Conclusions");
			input.setDescription("Description of the conclusions drawn");
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
		//StudyDesign: Field(entity=StudyDetails, name=StudyDesign, type=text, auto=false, nillable=true, readonly=false, default=)
		{
			TextInput input = new TextInput("StudyDetails_StudyDesign",getEntity().getStudyDesign());
			
			input.setLabel("Study design");
			input.setDescription("Study design");
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
		//StudySizeReason: Field(entity=StudyDetails, name=StudySizeReason, type=text, auto=false, nillable=true, readonly=false, default=)
		{
			TextInput input = new TextInput("StudyDetails_StudySizeReason",getEntity().getStudySizeReason());
			
			input.setLabel("Reason for study size");
			input.setDescription("Reason for study size");
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
		//StudyPower: Field(entity=StudyDetails, name=StudyPower, type=text, auto=false, nillable=true, readonly=false, default=)
		{
			TextInput input = new TextInput("StudyDetails_StudyPower",getEntity().getStudyPower());
			
			input.setLabel("Study power");
			input.setDescription("Study power");
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
		//SourcesOfBias: Field(entity=StudyDetails, name=SourcesOfBias, type=text, auto=false, nillable=true, readonly=false, default=)
		{
			TextInput input = new TextInput("StudyDetails_SourcesOfBias",getEntity().getSourcesOfBias());
			
			input.setLabel("Sources of bias");
			input.setDescription("Sources of bias");
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
		//Limitations: Field(entity=StudyDetails, name=Limitations, type=text, auto=false, nillable=true, readonly=false, default=)
		{
			TextInput input = new TextInput("StudyDetails_Limitations",getEntity().getLimitations());
			
			input.setLabel("Limitations");
			input.setDescription("Limitations");
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
		//Acknowledgements: Field(entity=StudyDetails, name=Acknowledgements, type=text, auto=false, nillable=true, readonly=false, default=)
		{
			TextInput input = new TextInput("StudyDetails_Acknowledgements",getEntity().getAcknowledgements());
			
			input.setLabel("Acknowledgements");
			input.setDescription("Acknowledgements");
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
		//PrimaryCitation: Field(entity=StudyDetails, name=primaryCitation, type=xref[Citation.id], xref_label='Identifier', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<StudyDetails> input = new XrefInput<StudyDetails>("StudyDetails_primaryCitation", getEntity().getPrimaryCitation());
			//create xref dummy object
			Citation dummy = null;
			if(getEntity().getPrimaryCitation_Id() != null)
			{
			 	dummy = new Citation();
				dummy.setId(getEntity().getPrimaryCitation_Id());
				dummy.setIdentifier( getEntity().getPrimaryCitation_Identifier() ); 
			}
			XrefInput<Citation> input = new XrefInput<Citation>("StudyDetails_primaryCitation", org.molgenis.organization.Citation.class, dummy);
			
			input.setLabel("primaryCitation");
			input.setDescription("primaryCitation");
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
		//OtherCitations: Field(entity=StudyDetails, name=otherCitations, type=mref[Citation.id], mref_name=StudyDetails_otherCitations, mref_localid=StudyDetails, mref_remoteid=otherCitations, xref_label='Identifier', auto=false, nillable=true, readonly=false, default=)
		{
			//TODO: when we have JPA this should become:
			//MrefInput input = new MrefInput("StudyDetails_otherCitations", getEntity().getOtherCitations());
			//create xref dummy list of references
			List<Citation> dummyList = new ArrayList<Citation>();
			if(getEntity().getOtherCitations_Id() != null) for(int i = 0; i < getEntity().getOtherCitations_Id().size(); i++ )
			{
				Citation dummy = new Citation();
				dummy.setId(getEntity().getOtherCitations_Id().get(i));
				dummy.setIdentifier( getEntity().getOtherCitations_Identifier().get(i) ); 
				dummyList.add(dummy);
			}   
			MrefInput<Citation> input = new MrefInput<Citation> ("StudyDetails_otherCitations", org.molgenis.organization.Citation.class, dummyList);
			
			input.setLabel("otherCitations");
			input.setDescription("Contact persons for this study");
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
		//Accession: Field(entity=StudyDetails, name=Accession, type=hyperlink, auto=false, nillable=true, readonly=false, default=)
		{
			HyperlinkInput input = new HyperlinkInput("StudyDetails_Accession",getEntity().getAccession());
			
			input.setLabel("Accession");
			input.setDescription("(Optional) URI or accession number to indicate source of Study. E.g. arrayexpress:M-EXP-2345");
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


