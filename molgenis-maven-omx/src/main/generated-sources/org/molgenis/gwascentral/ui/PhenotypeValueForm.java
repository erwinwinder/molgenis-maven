
/* File:        Org.molgenis.omx/html/PhenotypeValue.java
 * Copyright:   GBIC 2000-2013, all rights reserved
 * Date:        January 2, 2013
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


import org.molgenis.observ.ObservationSet;
import org.molgenis.observ.ObservableFeature;
import org.molgenis.observ.Characteristic;
import org.molgenis.gwascentral.PhenotypeProperty;
import org.molgenis.gwascentral.PhenotypeValue;


/**
 * A HtmlForm that is preloaded with all inputs for entity PhenotypeValue
 * @see EntityForm
 */
public class PhenotypeValueForm extends EntityForm<PhenotypeValue>
{
	
	public PhenotypeValueForm()
	{
		super();
	}
	
	public PhenotypeValueForm(PhenotypeValue entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<PhenotypeValue> getEntityClass()
	{
		return PhenotypeValue.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("ObservationSet");
		headers.add("Feature");
		headers.add("Characteristic");
		headers.add("Value");
		headers.add("Identifier");
		headers.add("Name");
		headers.add("Phenotype property name");
		headers.add("Value Rank");
		headers.add("Value is mean");
		headers.add("Standard Deviation");
		headers.add("Minimum value");
		headers.add("Maximum value");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=PhenotypeValue, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("PhenotypeValue_id",getEntity().getId());
			
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
			EnumInput input = new EnumInput("PhenotypeValue___Type",getEntity().get__Type());
			
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
			//XrefInput<PhenotypeValue> input = new XrefInput<PhenotypeValue>("PhenotypeValue_ObservationSet", getEntity().getObservationSet());
			//create xref dummy object
			ObservationSet dummy = null;
			if(getEntity().getObservationSet_Id() != null)
			{
			 	dummy = new ObservationSet();
				dummy.setId(getEntity().getObservationSet_Id());
			}
			XrefInput<ObservationSet> input = new XrefInput<ObservationSet>("PhenotypeValue_ObservationSet", org.molgenis.observ.ObservationSet.class, dummy);
			
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
			//XrefInput<PhenotypeValue> input = new XrefInput<PhenotypeValue>("PhenotypeValue_Feature", getEntity().getFeature());
			//create xref dummy object
			ObservableFeature dummy = null;
			if(getEntity().getFeature_Id() != null)
			{
			 	dummy = new ObservableFeature();
				dummy.setId(getEntity().getFeature_Id());
				dummy.setIdentifier( getEntity().getFeature_Identifier() ); 
			}
			XrefInput<ObservableFeature> input = new XrefInput<ObservableFeature>("PhenotypeValue_Feature", org.molgenis.observ.ObservableFeature.class, dummy);
			
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
			//XrefInput<PhenotypeValue> input = new XrefInput<PhenotypeValue>("PhenotypeValue_Characteristic", getEntity().getCharacteristic());
			//create xref dummy object
			Characteristic dummy = null;
			if(getEntity().getCharacteristic_Id() != null)
			{
			 	dummy = new Characteristic();
				dummy.setId(getEntity().getCharacteristic_Id());
				dummy.setIdentifier( getEntity().getCharacteristic_Identifier() ); 
			}
			XrefInput<Characteristic> input = new XrefInput<Characteristic>("PhenotypeValue_Characteristic", org.molgenis.observ.Characteristic.class, dummy);
			
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
		//Value: Field(entity=PhenotypeValue, name=Value, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("PhenotypeValue_Value",getEntity().getValue());
			
			input.setLabel("Value");
			input.setDescription("Value");
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
		//Identifier: Field(entity=PhenotypeValue, name=Identifier, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("PhenotypeValue_Identifier",getEntity().getIdentifier());
			
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
		//Name: Field(entity=PhenotypeValue, name=Name, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("PhenotypeValue_Name",getEntity().getName());
			
			input.setLabel("Name");
			input.setDescription("Name");
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
		//PhenotypePropertyID: Field(entity=PhenotypeValue, name=PhenotypePropertyID, type=xref[PhenotypeProperty.id], xref_label='Identifier', auto=false, nillable=false, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<PhenotypeValue> input = new XrefInput<PhenotypeValue>("PhenotypeValue_PhenotypePropertyID", getEntity().getPhenotypePropertyID());
			//create xref dummy object
			PhenotypeProperty dummy = null;
			if(getEntity().getPhenotypePropertyID_Id() != null)
			{
			 	dummy = new PhenotypeProperty();
				dummy.setId(getEntity().getPhenotypePropertyID_Id());
				dummy.setIdentifier( getEntity().getPhenotypePropertyID_Identifier() ); 
			}
			XrefInput<PhenotypeProperty> input = new XrefInput<PhenotypeProperty>("PhenotypeValue_PhenotypePropertyID", org.molgenis.gwascentral.PhenotypeProperty.class, dummy);
			
			input.setLabel("Phenotype property name");
			input.setDescription("Phenotype property name");
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
		//ValueRank: Field(entity=PhenotypeValue, name=ValueRank, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("PhenotypeValue_ValueRank",getEntity().getValueRank());
			
			input.setLabel("Value Rank");
			input.setDescription("Value Rank");
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
		//ValueIsMean: Field(entity=PhenotypeValue, name=ValueIsMean, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("PhenotypeValue_ValueIsMean",getEntity().getValueIsMean());
			
			input.setLabel("Value is mean");
			input.setDescription("Value is mean");
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
		//STD: Field(entity=PhenotypeValue, name=STD, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("PhenotypeValue_STD",getEntity().getSTD());
			
			input.setLabel("Standard Deviation");
			input.setDescription("Standard Deviation");
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
		//Min: Field(entity=PhenotypeValue, name=Min, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("PhenotypeValue_Min",getEntity().getMin());
			
			input.setLabel("Minimum value");
			input.setDescription("Minimum value");
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
		//Max: Field(entity=PhenotypeValue, name=Max, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("PhenotypeValue_Max",getEntity().getMax());
			
			input.setLabel("Maximum value");
			input.setDescription("Maximum value");
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

		return inputs;
	}
}


