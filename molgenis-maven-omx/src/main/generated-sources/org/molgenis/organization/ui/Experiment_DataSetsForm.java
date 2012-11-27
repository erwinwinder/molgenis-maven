
/* File:        Org.molgenis/html/Experiment_DataSets.java
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


import org.molgenis.observ.DataSet;
import org.molgenis.organization.Experiment;
import org.molgenis.organization.Experiment_DataSets;


/**
 * A HtmlForm that is preloaded with all inputs for entity Experiment_DataSets
 * @see EntityForm
 */
public class Experiment_DataSetsForm extends EntityForm<Experiment_DataSets>
{
	
	public Experiment_DataSetsForm()
	{
		super();
	}
	
	public Experiment_DataSetsForm(Experiment_DataSets entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<Experiment_DataSets> getEntityClass()
	{
		return Experiment_DataSets.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("DataSets");
		headers.add("Experiment");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Autoid: Field(entity=Experiment_DataSets, name=autoid, type=int, auto=true, nillable=false, readonly=false, default=null)
		{
			IntInput input = new IntInput("Experiment_DataSets_autoid",getEntity().getAutoid());
			
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
		//DataSets: Field(entity=Experiment_DataSets, name=DataSets, type=xref[DataSet.id], xref_label='Identifier', auto=false, nillable=false, readonly=false, default=null)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<Experiment_DataSets> input = new XrefInput<Experiment_DataSets>("Experiment_DataSets_DataSets", getEntity().getDataSets());
			//create xref dummy object
			DataSet dummy = null;
			if(getEntity().getDataSets_Id() != null)
			{
			 	dummy = new DataSet();
				dummy.setId(getEntity().getDataSets_Id());
				dummy.setIdentifier( getEntity().getDataSets_Identifier() ); 
			}
			XrefInput<DataSet> input = new XrefInput<DataSet>("Experiment_DataSets_DataSets", org.molgenis.observ.DataSet.class, dummy);
			
			input.setLabel("DataSets");
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
		//Experiment: Field(entity=Experiment_DataSets, name=Experiment, type=xref[Experiment.id], xref_label=, auto=false, nillable=false, readonly=false, default=null)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<Experiment_DataSets> input = new XrefInput<Experiment_DataSets>("Experiment_DataSets_Experiment", getEntity().getExperiment());
			//create xref dummy object
			Experiment dummy = null;
			if(getEntity().getExperiment_Id() != null)
			{
			 	dummy = new Experiment();
				dummy.setId(getEntity().getExperiment_Id());
				dummy.setIdentifier( getEntity().getExperiment_Identifier() ); 
			}
			XrefInput<Experiment> input = new XrefInput<Experiment>("Experiment_DataSets_Experiment", org.molgenis.organization.Experiment.class, dummy);
			
			input.setLabel("Experiment");
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


