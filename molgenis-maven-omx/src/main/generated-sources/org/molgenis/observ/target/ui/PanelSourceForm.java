
/* File:        Org.molgenis/html/PanelSource.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 26, 2012
 * 
 * generator:   org.molgenis.generators.ui.HtmlFormGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
package org.molgenis.observ.target.ui;

// jdk
import java.util.Vector;
import java.util.List;
import java.util.ArrayList;


// molgenis
import org.molgenis.framework.ui.html.*;


import org.molgenis.observ.target.Panel;
import org.molgenis.observ.target.PanelSource;


/**
 * A HtmlForm that is preloaded with all inputs for entity PanelSource
 * @see EntityForm
 */
public class PanelSourceForm extends EntityForm<PanelSource>
{
	
	public PanelSourceForm()
	{
		super();
	}
	
	public PanelSourceForm(PanelSource entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<PanelSource> getEntityClass()
	{
		return PanelSource.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("CurrentPanel");
		headers.add("SourcePanel");
		headers.add("NumberOfIndividuals");
		headers.add("SelectionCriteria");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=PanelSource, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("PanelSource_id",getEntity().getId());
			
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
		//CurrentPanel: Field(entity=PanelSource, name=CurrentPanel, type=xref[Panel.id], xref_label='Identifier', auto=false, nillable=false, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<PanelSource> input = new XrefInput<PanelSource>("PanelSource_CurrentPanel", getEntity().getCurrentPanel());
			//create xref dummy object
			Panel dummy = null;
			if(getEntity().getCurrentPanel_Id() != null)
			{
			 	dummy = new Panel();
				dummy.setId(getEntity().getCurrentPanel_Id());
				dummy.setIdentifier( getEntity().getCurrentPanel_Identifier() ); 
			}
			XrefInput<Panel> input = new XrefInput<Panel>("PanelSource_CurrentPanel", org.molgenis.observ.target.Panel.class, dummy);
			
			input.setLabel("CurrentPanel");
			input.setDescription("Panel for which these sources are defined.");
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
		//SourcePanel: Field(entity=PanelSource, name=SourcePanel, type=xref[Panel.id], xref_label='Identifier', auto=false, nillable=false, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<PanelSource> input = new XrefInput<PanelSource>("PanelSource_SourcePanel", getEntity().getSourcePanel());
			//create xref dummy object
			Panel dummy = null;
			if(getEntity().getSourcePanel_Id() != null)
			{
			 	dummy = new Panel();
				dummy.setId(getEntity().getSourcePanel_Id());
				dummy.setIdentifier( getEntity().getSourcePanel_Identifier() ); 
			}
			XrefInput<Panel> input = new XrefInput<Panel>("PanelSource_SourcePanel", org.molgenis.observ.target.Panel.class, dummy);
			
			input.setLabel("SourcePanel");
			input.setDescription("Source that contributed individuals to current panel");
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
		//NumberOfIndividuals: Field(entity=PanelSource, name=NumberOfIndividuals, type=int, auto=false, nillable=true, readonly=false, default=)
		{
			IntInput input = new IntInput("PanelSource_NumberOfIndividuals",getEntity().getNumberOfIndividuals());
			
			input.setLabel("NumberOfIndividuals");
			input.setDescription("Number of individuals lifted over from this source");
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
		//SelectionCriteria: Field(entity=PanelSource, name=SelectionCriteria, type=text, auto=false, nillable=false, readonly=false, default=)
		{
			TextInput input = new TextInput("PanelSource_SelectionCriteria",getEntity().getSelectionCriteria());
			
			input.setLabel("SelectionCriteria");
			input.setDescription("Inclusion/exclusion criteria used to select these individuals from source into current panel");
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


