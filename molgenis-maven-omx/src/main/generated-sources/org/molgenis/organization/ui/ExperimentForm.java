
/* File:        Org.molgenis/html/Experiment.java
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
import org.molgenis.observ.target.OntologyTerm;
import org.molgenis.observ.target.Panel;
import org.molgenis.observ.DataSet;
import org.molgenis.organization.Experiment;


/**
 * A HtmlForm that is preloaded with all inputs for entity Experiment
 * @see EntityForm
 */
public class ExperimentForm extends EntityForm<Experiment>
{
	
	public ExperimentForm()
	{
		super();
	}
	
	public ExperimentForm(Experiment entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<Experiment> getEntityClass()
	{
		return Experiment.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("Identifier");
		headers.add("Name");
		headers.add("Study");
		headers.add("Design");
		headers.add("Experiment type. E.g. 'case-control'.");
		headers.add("Total markers tested");
		headers.add("Total markers imported");
		headers.add("Objective");
		headers.add("Outcome");
		headers.add("Comments");
		headers.add("Individual data statement");
		headers.add("Time created");
		headers.add("Assayed panels");
		headers.add("DataSets");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=Experiment, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("Experiment_id",getEntity().getId());
			
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
		//Identifier: Field(entity=Experiment, name=Identifier, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("Experiment_Identifier",getEntity().getIdentifier());
			
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
		//Name: Field(entity=Experiment, name=Name, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("Experiment_Name",getEntity().getName());
			
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
		//__Type: Field(entity=Experiment, name=__Type, type=enum, auto=true, nillable=false, readonly=true, default=null, enum_options=[Experiment, GWASExperiment])
		{
			EnumInput input = new EnumInput("Experiment___Type",getEntity().get__Type());
			
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
		//Study: Field(entity=Experiment, name=Study, type=xref[Study.id], xref_label='Identifier', auto=false, nillable=false, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<Experiment> input = new XrefInput<Experiment>("Experiment_Study", getEntity().getStudy());
			//create xref dummy object
			Study dummy = null;
			if(getEntity().getStudy_Id() != null)
			{
			 	dummy = new Study();
				dummy.setId(getEntity().getStudy_Id());
				dummy.setIdentifier( getEntity().getStudy_Identifier() ); 
			}
			XrefInput<Study> input = new XrefInput<Study>("Experiment_Study", org.molgenis.organization.Study.class, dummy);
			
			input.setLabel("Study");
			input.setDescription("Part of Study.");
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
		//Design: Field(entity=Experiment, name=Design, type=string[50], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("Experiment_Design",getEntity().getDesign());
			
			input.setLabel("Design");
			input.setDescription("Design");
			input.setNillable(true);
			input.setSize(50);
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
		//ExperimentType: Field(entity=Experiment, name=ExperimentType, type=xref[OntologyTerm.id], xref_label='Identifier', auto=false, nillable=false, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<Experiment> input = new XrefInput<Experiment>("Experiment_ExperimentType", getEntity().getExperimentType());
			//create xref dummy object
			OntologyTerm dummy = null;
			if(getEntity().getExperimentType_Id() != null)
			{
			 	dummy = new OntologyTerm();
				dummy.setId(getEntity().getExperimentType_Id());
				dummy.setIdentifier( getEntity().getExperimentType_Identifier() ); 
			}
			XrefInput<OntologyTerm> input = new XrefInput<OntologyTerm>("Experiment_ExperimentType", org.molgenis.observ.target.OntologyTerm.class, dummy);
			
			input.setLabel("Experiment type. E.g. 'case-control'.");
			input.setDescription("Experiment type. E.g. &apos;case-control&apos;.");
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
		//TotalMarkersTested: Field(entity=Experiment, name=TotalMarkersTested, type=int, auto=false, nillable=true, readonly=false, default=)
		{
			IntInput input = new IntInput("Experiment_TotalMarkersTested",getEntity().getTotalMarkersTested());
			
			input.setLabel("Total markers tested");
			input.setDescription("Total markers tested");
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
		//TotalMarkersImported: Field(entity=Experiment, name=TotalMarkersImported, type=int, auto=false, nillable=true, readonly=true, default=)
		{
			IntInput input = new IntInput("Experiment_TotalMarkersImported",getEntity().getTotalMarkersImported());
			
			input.setLabel("Total markers imported");
			input.setDescription("Total markers imported");
			input.setNillable(true);
			//FIXME: this should be moved to login?
			//readonly, except when new record without default, unless whole entity is readonly
			if( !(isNewRecord() && "".equals(input.getValue())) || getEntity().isReadonly()) input.setReadonly(true); 
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
		//Objective: Field(entity=Experiment, name=Objective, type=text, auto=false, nillable=true, readonly=false, default=)
		{
			TextInput input = new TextInput("Experiment_Objective",getEntity().getObjective());
			
			input.setLabel("Objective");
			input.setDescription("Objective");
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
		//Outcome: Field(entity=Experiment, name=Outcome, type=text, auto=false, nillable=true, readonly=false, default=)
		{
			TextInput input = new TextInput("Experiment_Outcome",getEntity().getOutcome());
			
			input.setLabel("Outcome");
			input.setDescription("Outcome");
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
		//Comments: Field(entity=Experiment, name=Comments, type=text, auto=false, nillable=true, readonly=false, default=)
		{
			TextInput input = new TextInput("Experiment_Comments",getEntity().getComments());
			
			input.setLabel("Comments");
			input.setDescription("Comments");
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
		//IndividualDataStatement: Field(entity=Experiment, name=IndividualDataStatement, type=text, auto=false, nillable=true, readonly=false, default=Access to individual-level data must be made to the study authors)
		{
			TextInput input = new TextInput("Experiment_IndividualDataStatement",getEntity().getIndividualDataStatement());
			
			input.setLabel("Individual data statement");
			input.setDescription("Individual data statement");
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
		//TimeCreated: Field(entity=Experiment, name=TimeCreated, type=datetime, auto=false, nillable=false, readonly=true, default=)
		{
			DatetimeInput input = new DatetimeInput("Experiment_TimeCreated",getEntity().getTimeCreated());
			
			input.setLabel("Time created");
			input.setDescription("Time created");
			input.setNillable(false);
			//FIXME: this should be moved to login?
			//readonly, except when new record without default, unless whole entity is readonly
			if( !(isNewRecord() && "".equals(input.getValue())) || getEntity().isReadonly()) input.setReadonly(true); 
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
		//AssayedPanels: Field(entity=Experiment, name=AssayedPanels, type=mref[Panel.id], mref_name=Experiment_AssayedPanels, mref_localid=Experiment, mref_remoteid=AssayedPanels, xref_label='Identifier', auto=false, nillable=false, readonly=false, default=)
		{
			//TODO: when we have JPA this should become:
			//MrefInput input = new MrefInput("Experiment_AssayedPanels", getEntity().getAssayedPanels());
			//create xref dummy list of references
			List<Panel> dummyList = new ArrayList<Panel>();
			if(getEntity().getAssayedPanels_Id() != null) for(int i = 0; i < getEntity().getAssayedPanels_Id().size(); i++ )
			{
				Panel dummy = new Panel();
				dummy.setId(getEntity().getAssayedPanels_Id().get(i));
				dummy.setIdentifier( getEntity().getAssayedPanels_Identifier().get(i) ); 
				dummyList.add(dummy);
			}   
			MrefInput<Panel> input = new MrefInput<Panel> ("Experiment_AssayedPanels", org.molgenis.observ.target.Panel.class, dummyList);
			
			input.setLabel("Assayed panels");
			input.setDescription("Assayed panels");
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
		//DataSets: Field(entity=Experiment, name=DataSets, type=mref[DataSet.id], mref_name=Experiment_DataSets, mref_localid=Experiment, mref_remoteid=DataSets, xref_label='Identifier', auto=false, nillable=false, readonly=false, default=)
		{
			//TODO: when we have JPA this should become:
			//MrefInput input = new MrefInput("Experiment_DataSets", getEntity().getDataSets());
			//create xref dummy list of references
			List<DataSet> dummyList = new ArrayList<DataSet>();
			if(getEntity().getDataSets_Id() != null) for(int i = 0; i < getEntity().getDataSets_Id().size(); i++ )
			{
				DataSet dummy = new DataSet();
				dummy.setId(getEntity().getDataSets_Id().get(i));
				dummy.setIdentifier( getEntity().getDataSets_Identifier().get(i) ); 
				dummyList.add(dummy);
			}   
			MrefInput<DataSet> input = new MrefInput<DataSet> ("Experiment_DataSets", org.molgenis.observ.DataSet.class, dummyList);
			
			input.setLabel("DataSets");
			input.setDescription("DataSets that were input/output of this experiment.");
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


