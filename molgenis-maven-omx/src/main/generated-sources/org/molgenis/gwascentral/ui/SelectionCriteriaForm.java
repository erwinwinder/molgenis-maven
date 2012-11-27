
/* File:        Org.molgenis/html/SelectionCriteria.java
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


import org.molgenis.observ.target.Panel;
import org.molgenis.gwascentral.SelectionCriteria;


/**
 * A HtmlForm that is preloaded with all inputs for entity SelectionCriteria
 * @see EntityForm
 */
public class SelectionCriteriaForm extends EntityForm<SelectionCriteria>
{
	
	public SelectionCriteriaForm()
	{
		super();
	}
	
	public SelectionCriteriaForm(SelectionCriteria entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<SelectionCriteria> getEntityClass()
	{
		return SelectionCriteria.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("SourcePanel");
		headers.add("TargetPanel");
		headers.add("NumberOfIndividuals");
		headers.add("Details");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=SelectionCriteria, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("SelectionCriteria_id",getEntity().getId());
			
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
		//SourcePanel: Field(entity=SelectionCriteria, name=SourcePanel, type=xref[Panel.id], xref_label='Identifier', auto=false, nillable=false, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<SelectionCriteria> input = new XrefInput<SelectionCriteria>("SelectionCriteria_SourcePanel", getEntity().getSourcePanel());
			//create xref dummy object
			Panel dummy = null;
			if(getEntity().getSourcePanel_Id() != null)
			{
			 	dummy = new Panel();
				dummy.setId(getEntity().getSourcePanel_Id());
				dummy.setIdentifier( getEntity().getSourcePanel_Identifier() ); 
			}
			XrefInput<Panel> input = new XrefInput<Panel>("SelectionCriteria_SourcePanel", org.molgenis.observ.target.Panel.class, dummy);
			
			input.setLabel("SourcePanel");
			input.setDescription("SourcePanel");
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
		//TargetPanel: Field(entity=SelectionCriteria, name=TargetPanel, type=xref[Panel.id], xref_label='Identifier', auto=false, nillable=false, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<SelectionCriteria> input = new XrefInput<SelectionCriteria>("SelectionCriteria_TargetPanel", getEntity().getTargetPanel());
			//create xref dummy object
			Panel dummy = null;
			if(getEntity().getTargetPanel_Id() != null)
			{
			 	dummy = new Panel();
				dummy.setId(getEntity().getTargetPanel_Id());
				dummy.setIdentifier( getEntity().getTargetPanel_Identifier() ); 
			}
			XrefInput<Panel> input = new XrefInput<Panel>("SelectionCriteria_TargetPanel", org.molgenis.observ.target.Panel.class, dummy);
			
			input.setLabel("TargetPanel");
			input.setDescription("TargetPanel");
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
		//NumberOfIndividuals: Field(entity=SelectionCriteria, name=NumberOfIndividuals, type=int, auto=false, nillable=false, readonly=false, default=)
		{
			IntInput input = new IntInput("SelectionCriteria_NumberOfIndividuals",getEntity().getNumberOfIndividuals());
			
			input.setLabel("NumberOfIndividuals");
			input.setDescription("NumberOfIndividuals");
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
		//Details: Field(entity=SelectionCriteria, name=Details, type=text, auto=false, nillable=false, readonly=false, default=)
		{
			TextInput input = new TextInput("SelectionCriteria_Details",getEntity().getDetails());
			
			input.setLabel("Details");
			input.setDescription("Details");
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


