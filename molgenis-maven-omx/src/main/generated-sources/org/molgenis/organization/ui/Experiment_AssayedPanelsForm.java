
/* File:        Org.molgenis/html/Experiment_AssayedPanels.java
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


import org.molgenis.observ.target.Panel;
import org.molgenis.organization.Experiment;
import org.molgenis.organization.Experiment_AssayedPanels;


/**
 * A HtmlForm that is preloaded with all inputs for entity Experiment_AssayedPanels
 * @see EntityForm
 */
public class Experiment_AssayedPanelsForm extends EntityForm<Experiment_AssayedPanels>
{
	
	public Experiment_AssayedPanelsForm()
	{
		super();
	}
	
	public Experiment_AssayedPanelsForm(Experiment_AssayedPanels entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<Experiment_AssayedPanels> getEntityClass()
	{
		return Experiment_AssayedPanels.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("AssayedPanels");
		headers.add("Experiment");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Autoid: Field(entity=Experiment_AssayedPanels, name=autoid, type=int, auto=true, nillable=false, readonly=false, default=null)
		{
			IntInput input = new IntInput("Experiment_AssayedPanels_autoid",getEntity().getAutoid());
			
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
		//AssayedPanels: Field(entity=Experiment_AssayedPanels, name=AssayedPanels, type=xref[Panel.id], xref_label='Identifier', auto=false, nillable=false, readonly=false, default=null)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<Experiment_AssayedPanels> input = new XrefInput<Experiment_AssayedPanels>("Experiment_AssayedPanels_AssayedPanels", getEntity().getAssayedPanels());
			//create xref dummy object
			Panel dummy = null;
			if(getEntity().getAssayedPanels_Id() != null)
			{
			 	dummy = new Panel();
				dummy.setId(getEntity().getAssayedPanels_Id());
				dummy.setIdentifier( getEntity().getAssayedPanels_Identifier() ); 
			}
			XrefInput<Panel> input = new XrefInput<Panel>("Experiment_AssayedPanels_AssayedPanels", org.molgenis.observ.target.Panel.class, dummy);
			
			input.setLabel("AssayedPanels");
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
		//Experiment: Field(entity=Experiment_AssayedPanels, name=Experiment, type=xref[Experiment.id], xref_label=, auto=false, nillable=false, readonly=false, default=null)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<Experiment_AssayedPanels> input = new XrefInput<Experiment_AssayedPanels>("Experiment_AssayedPanels_Experiment", getEntity().getExperiment());
			//create xref dummy object
			Experiment dummy = null;
			if(getEntity().getExperiment_Id() != null)
			{
			 	dummy = new Experiment();
				dummy.setId(getEntity().getExperiment_Id());
				dummy.setIdentifier( getEntity().getExperiment_Identifier() ); 
			}
			XrefInput<Experiment> input = new XrefInput<Experiment>("Experiment_AssayedPanels_Experiment", org.molgenis.organization.Experiment.class, dummy);
			
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


