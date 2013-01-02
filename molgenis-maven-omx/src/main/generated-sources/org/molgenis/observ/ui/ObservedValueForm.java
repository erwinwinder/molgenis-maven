
/* File:        Org.molgenis.omx/html/ObservedValue.java
 * Copyright:   GBIC 2000-2013, all rights reserved
 * Date:        January 2, 2013
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


import org.molgenis.observ.ObservationSet;
import org.molgenis.observ.ObservableFeature;
import org.molgenis.observ.Characteristic;
import org.molgenis.observ.ObservedValue;


/**
 * A HtmlForm that is preloaded with all inputs for entity ObservedValue
 * @see EntityForm
 */
public class ObservedValueForm extends EntityForm<ObservedValue>
{
	
	public ObservedValueForm()
	{
		super();
	}
	
	public ObservedValueForm(ObservedValue entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<ObservedValue> getEntityClass()
	{
		return ObservedValue.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("ObservationSet");
		headers.add("Feature");
		headers.add("Characteristic");
		headers.add("Value");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=ObservedValue, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("ObservedValue_id",getEntity().getId());
			
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
		//__Type: Field(entity=ObservedValue, name=__Type, type=enum, auto=true, nillable=false, readonly=true, default=null, enum_options=[ObservedValue, PhenotypeValue])
		{
			EnumInput input = new EnumInput("ObservedValue___Type",getEntity().get__Type());
			
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
		//ObservationSet: Field(entity=ObservedValue, name=ObservationSet, type=xref[ObservationSet.id], xref_label='id', auto=false, nillable=false, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<ObservedValue> input = new XrefInput<ObservedValue>("ObservedValue_ObservationSet", getEntity().getObservationSet());
			//create xref dummy object
			ObservationSet dummy = null;
			if(getEntity().getObservationSet_Id() != null)
			{
			 	dummy = new ObservationSet();
				dummy.setId(getEntity().getObservationSet_Id());
			}
			XrefInput<ObservationSet> input = new XrefInput<ObservationSet>("ObservedValue_ObservationSet", org.molgenis.observ.ObservationSet.class, dummy);
			
			input.setLabel("ObservationSet");
			input.setDescription("Reference to the observation. For example a particular patient visit or the application of a microarray or the calculation of a QTL model");
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
		//Feature: Field(entity=ObservedValue, name=Feature, type=xref[ObservableFeature.id], xref_label='Identifier', auto=false, nillable=false, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<ObservedValue> input = new XrefInput<ObservedValue>("ObservedValue_Feature", getEntity().getFeature());
			//create xref dummy object
			ObservableFeature dummy = null;
			if(getEntity().getFeature_Id() != null)
			{
			 	dummy = new ObservableFeature();
				dummy.setId(getEntity().getFeature_Id());
				dummy.setIdentifier( getEntity().getFeature_Identifier() ); 
			}
			XrefInput<ObservableFeature> input = new XrefInput<ObservableFeature>("ObservedValue_Feature", org.molgenis.observ.ObservableFeature.class, dummy);
			
			input.setLabel("Feature");
			input.setDescription("References the ObservableFeature that this observation was made on. For example &apos;probe123&apos;.");
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
		//Characteristic: Field(entity=ObservedValue, name=Characteristic, type=xref[Characteristic.id], xref_label='Identifier', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<ObservedValue> input = new XrefInput<ObservedValue>("ObservedValue_Characteristic", getEntity().getCharacteristic());
			//create xref dummy object
			Characteristic dummy = null;
			if(getEntity().getCharacteristic_Id() != null)
			{
			 	dummy = new Characteristic();
				dummy.setId(getEntity().getCharacteristic_Id());
				dummy.setIdentifier( getEntity().getCharacteristic_Identifier() ); 
			}
			XrefInput<Characteristic> input = new XrefInput<Characteristic>("ObservedValue_Characteristic", org.molgenis.observ.Characteristic.class, dummy);
			
			input.setLabel("Characteristic");
			input.setDescription("Is brother of [characteristic], or Average of [height]");
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
		//Value: Field(entity=ObservedValue, name=Value, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("ObservedValue_Value",getEntity().getValue());
			
			input.setLabel("Value");
			input.setDescription("The value observed");
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

		return inputs;
	}
}


