
/* File:        Org.molgenis/html/ObservableFeature.java
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


import org.molgenis.observ.target.OntologyTerm;
import org.molgenis.observ.ObservableFeature;


/**
 * A HtmlForm that is preloaded with all inputs for entity ObservableFeature
 * @see EntityForm
 */
public class ObservableFeatureForm extends EntityForm<ObservableFeature>
{
	
	public ObservableFeatureForm()
	{
		super();
	}
	
	public ObservableFeatureForm(ObservableFeature entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<ObservableFeature> getEntityClass()
	{
		return ObservableFeature.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("Identifier");
		headers.add("Name");
		headers.add("description");
		headers.add("unit");
		headers.add("dataType");
		headers.add("temporal");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=ObservableFeature, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("ObservableFeature_id",getEntity().getId());
			
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
		//Identifier: Field(entity=Characteristic, name=Identifier, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("ObservableFeature_Identifier",getEntity().getIdentifier());
			
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
		//Name: Field(entity=Characteristic, name=Name, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("ObservableFeature_Name",getEntity().getName());
			
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
		//__Type: Field(entity=Characteristic, name=__Type, type=enum, auto=true, nillable=false, readonly=true, default=null, enum_options=[Characteristic, Individual, SamplePanel, AssayedPanel, Panel, ObservationTarget, PhenotypeProperty, UsedMarkerSet, ObservableFeature, Category, Protocol, FrequencyCluster, GenotypeFrequency, AlleleFrequency, PhenotypeMethod, Significance, EffectSize, DataSet, Genome, Chromosome, Gene, Protein, ProteinDomain, Exon, Variant])
		{
			EnumInput input = new EnumInput("ObservableFeature___Type",getEntity().get__Type());
			
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
		//Description: Field(entity=Characteristic, name=description, type=text, auto=false, nillable=true, readonly=false, default=)
		{
			TextInput input = new TextInput("ObservableFeature_description",getEntity().getDescription());
			
			input.setLabel("description");
			input.setDescription("(Optional) Rudimentary meta data about the observable feature. Use of ontology       terms references to establish unambigious descriptions is recommended");
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
		//Unit: Field(entity=ObservableFeature, name=unit, type=xref[OntologyTerm.id], xref_label='Identifier', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<ObservableFeature> input = new XrefInput<ObservableFeature>("ObservableFeature_unit", getEntity().getUnit());
			//create xref dummy object
			OntologyTerm dummy = null;
			if(getEntity().getUnit_Id() != null)
			{
			 	dummy = new OntologyTerm();
				dummy.setId(getEntity().getUnit_Id());
				dummy.setIdentifier( getEntity().getUnit_Identifier() ); 
			}
			XrefInput<OntologyTerm> input = new XrefInput<OntologyTerm>("ObservableFeature_unit", org.molgenis.observ.target.OntologyTerm.class, dummy);
			
			input.setLabel("unit");
			input.setDescription("(Optional) Reference to the well-defined measurement unit used to observe this feature       (if feature is that concrete). E.g. mmHg");
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
		//DataType: Field(entity=ObservableFeature, name=dataType, type=enum, auto=false, nillable=false, readonly=false, default=string, enum_options=[xref, string, categorical, nominal, ordinal, date, datetime, int, code, image, decimal, bool, file, log, data, exe])
		{
			EnumInput input = new EnumInput("ObservableFeature_dataType",getEntity().getDataType());
			
			input.setLabel("dataType");
			input.setDescription("(Optional) Reference to the technical data type. E.g. &apos;int&apos;");
			input.setNillable(false);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			input.setOptions(getEntity().getDataTypeOptions());
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
		//Temporal: Field(entity=ObservableFeature, name=temporal, type=bool, auto=false, nillable=false, readonly=false, default=false)
		{
			BoolInput input = new BoolInput("ObservableFeature_temporal",getEntity().getTemporal());
			
			input.setLabel("temporal");
			input.setDescription("Whether this feature is time dependent and can have different values when measured       on different times (e.g. weight, temporal=true) or generally only measured once (e.g. birth date,       temporal=false)");
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


