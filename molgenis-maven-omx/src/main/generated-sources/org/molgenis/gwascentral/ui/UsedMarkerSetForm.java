
/* File:        Org.molgenis/html/UsedMarkerSet.java
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


import org.molgenis.observ.target.OntologyTerm;
import org.molgenis.organization.Experiment;
import org.molgenis.gwascentral.UsedMarkerSet;


/**
 * A HtmlForm that is preloaded with all inputs for entity UsedMarkerSet
 * @see EntityForm
 */
public class UsedMarkerSetForm extends EntityForm<UsedMarkerSet>
{
	
	public UsedMarkerSetForm()
	{
		super();
	}
	
	public UsedMarkerSetForm(UsedMarkerSet entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<UsedMarkerSet> getEntityClass()
	{
		return UsedMarkerSet.class;
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
		headers.add("Experiment ID");
		headers.add("Marker identifier");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=UsedMarkerSet, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("UsedMarkerSet_id",getEntity().getId());
			
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
			StringInput input = new StringInput("UsedMarkerSet_Identifier",getEntity().getIdentifier());
			
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
			StringInput input = new StringInput("UsedMarkerSet_Name",getEntity().getName());
			
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
			EnumInput input = new EnumInput("UsedMarkerSet___Type",getEntity().get__Type());
			
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
			TextInput input = new TextInput("UsedMarkerSet_description",getEntity().getDescription());
			
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
			//XrefInput<UsedMarkerSet> input = new XrefInput<UsedMarkerSet>("UsedMarkerSet_unit", getEntity().getUnit());
			//create xref dummy object
			OntologyTerm dummy = null;
			if(getEntity().getUnit_Id() != null)
			{
			 	dummy = new OntologyTerm();
				dummy.setId(getEntity().getUnit_Id());
				dummy.setIdentifier( getEntity().getUnit_Identifier() ); 
			}
			XrefInput<OntologyTerm> input = new XrefInput<OntologyTerm>("UsedMarkerSet_unit", org.molgenis.observ.target.OntologyTerm.class, dummy);
			
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
			EnumInput input = new EnumInput("UsedMarkerSet_dataType",getEntity().getDataType());
			
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
			BoolInput input = new BoolInput("UsedMarkerSet_temporal",getEntity().getTemporal());
			
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
		//ExperimentID: Field(entity=UsedMarkerSet, name=ExperimentID, type=xref[Experiment.id], xref_label='Identifier', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<UsedMarkerSet> input = new XrefInput<UsedMarkerSet>("UsedMarkerSet_ExperimentID", getEntity().getExperimentID());
			//create xref dummy object
			Experiment dummy = null;
			if(getEntity().getExperimentID_Id() != null)
			{
			 	dummy = new Experiment();
				dummy.setId(getEntity().getExperimentID_Id());
				dummy.setIdentifier( getEntity().getExperimentID_Identifier() ); 
			}
			XrefInput<Experiment> input = new XrefInput<Experiment>("UsedMarkerSet_ExperimentID", org.molgenis.organization.Experiment.class, dummy);
			
			input.setLabel("Experiment ID");
			input.setDescription("Experiment ID");
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
		//MarkerIdentifier: Field(entity=UsedMarkerSet, name=MarkerIdentifier, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("UsedMarkerSet_MarkerIdentifier",getEntity().getMarkerIdentifier());
			
			input.setLabel("Marker identifier");
			input.setDescription("Marker identifier");
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


