
/* File:        Org.molgenis/html/ObservationSet.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 26, 2012
 * 
 * generator:   org.molgenis.generators.ui.HtmlFormGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
package org.molgenis.observ.ui;

// jdk
import java.util.Vector;
import java.util.List;
import java.util.ArrayList;


// molgenis
import org.molgenis.framework.ui.html.*;


import org.molgenis.observ.DataSet;
import org.molgenis.observ.Characteristic;
import org.molgenis.observ.ObservationSet;


/**
 * A HtmlForm that is preloaded with all inputs for entity ObservationSet
 * @see EntityForm
 */
public class ObservationSetForm extends EntityForm<ObservationSet>
{
	
	public ObservationSetForm()
	{
		super();
	}
	
	public ObservationSetForm(ObservationSet entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<ObservationSet> getEntityClass()
	{
		return ObservationSet.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("partOfDataSet");
		headers.add("Target");
		headers.add("Time");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=ObservationSet, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("ObservationSet_id",getEntity().getId());
			
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
		//PartOfDataSet: Field(entity=ObservationSet, name=partOfDataSet, type=xref[DataSet.id], xref_label='Identifier', auto=false, nillable=false, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<ObservationSet> input = new XrefInput<ObservationSet>("ObservationSet_partOfDataSet", getEntity().getPartOfDataSet());
			//create xref dummy object
			DataSet dummy = null;
			if(getEntity().getPartOfDataSet_Id() != null)
			{
			 	dummy = new DataSet();
				dummy.setId(getEntity().getPartOfDataSet_Id());
				dummy.setIdentifier( getEntity().getPartOfDataSet_Identifier() ); 
			}
			XrefInput<DataSet> input = new XrefInput<DataSet>("ObservationSet_partOfDataSet", org.molgenis.observ.DataSet.class, dummy);
			
			input.setLabel("partOfDataSet");
			input.setDescription("DataSet this ValueSet is part of.");
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
		//Target: Field(entity=ObservationSet, name=Target, type=xref[Characteristic.id], xref_label='Identifier', auto=false, nillable=false, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<ObservationSet> input = new XrefInput<ObservationSet>("ObservationSet_Target", getEntity().getTarget());
			//create xref dummy object
			Characteristic dummy = null;
			if(getEntity().getTarget_Id() != null)
			{
			 	dummy = new Characteristic();
				dummy.setId(getEntity().getTarget_Id());
				dummy.setIdentifier( getEntity().getTarget_Identifier() ); 
			}
			XrefInput<Characteristic> input = new XrefInput<Characteristic>("ObservationSet_Target", org.molgenis.observ.Characteristic.class, dummy);
			
			input.setLabel("Target");
			input.setDescription("References the target for which this data was recorded. For example &apos;individual1&apos;.");
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
		//Time: Field(entity=ObservationSet, name=Time, type=datetime, auto=false, nillable=true, readonly=false, default=)
		{
			DatetimeInput input = new DatetimeInput("ObservationSet_Time",getEntity().getTime());
			
			input.setLabel("Time");
			input.setDescription("Time of this observationSet");
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


