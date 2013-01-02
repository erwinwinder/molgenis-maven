/* File:        Org.molgenis.omx/screen/investigation.java
 * Copyright:   GBIC 2000-2013, all rights reserved
 * Date:        January 2, 2013
 * 
 * generator:   org.molgenis.generators.ui.FormControllerGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
package org.molgenis.omx.ui;

// jdk
import java.util.Vector;
import java.util.ArrayList;

// molgenis
import org.molgenis.framework.ui.ScreenController;
import org.molgenis.framework.ui.FormModel;
import org.molgenis.framework.ui.FormController;

import org.molgenis.framework.ui.html.*;
import org.molgenis.framework.db.QueryRule.Operator;  
import org.molgenis.framework.db.DatabaseException;

import org.molgenis.observ.target.Individual;

import org.molgenis.observ.target.csv.IndividualCsvReader;

import org.molgenis.observ.target.ui.IndividualForm;



/**
 *
 */
public class InvestigationFormController extends FormController<Individual>
{
	private static final long serialVersionUID = 1L;
	
	public InvestigationFormController()
	{
		this(null);
	}
	
	public InvestigationFormController(ScreenController<?> parent)
	{
		super( "investigation", parent );
		getModel().setLabel("investigation");
		getModel().setLimit(10);
		
		

		getModel().setMode(FormModel.Mode.LIST_VIEW);
		getModel().setCsvReader(new IndividualCsvReader());




		getModel().addCommand(new org.molgenis.framework.ui.commands.AddXrefCommand("Individual_Mother", this, new Individual(), new IndividualForm()));
		getModel().addCommand(new org.molgenis.framework.ui.commands.AddXrefCommand("Individual_Father", this, new Individual(), new IndividualForm()));
	}
	
	@Override
	public HtmlForm getInputs(Individual entity, boolean newrecord)
	{
	
		IndividualForm form = new IndividualForm(entity);
		form.setNewRecord(newrecord);
		form.setReadonly(getModel().isReadonly());
		form.setHiddenColumns(getModel().getUserHiddenColumns());
		
		return form;
	}
	
	public void resetSystemHiddenColumns()
	{
		Vector<String> systemHiddenColumns = new Vector<String>();
		systemHiddenColumns.add("id");
		systemHiddenColumns.add("__Type");
        getModel().setSystemHiddenColumns(systemHiddenColumns);
	}

	@Override	
	public String getSearchField(String fieldName)
	{
		if(fieldName.equals("Mother")) return "Mother_Identifier";
		if(fieldName.equals("Father")) return "Father_Identifier";
		return fieldName;
	}	
	
	@Override
	public void resetCompactView()
	{
		ArrayList<String> compactView = new ArrayList<String>();
        getModel().setCompactView(compactView);
	}
	
	@Override
	public Class<Individual> getEntityClass()
	{
		return new IndividualForm().getEntityClass();
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		return new IndividualForm().getHeaders();
	}
}