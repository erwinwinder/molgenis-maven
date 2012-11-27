
/* File:        Org.molgenis/html/GenotypeFrequency.java
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


import org.molgenis.observ.Protocol;
import org.molgenis.gwascentral.FrequencyCluster;
import org.molgenis.gwascentral.GenotypeFrequency;


/**
 * A HtmlForm that is preloaded with all inputs for entity GenotypeFrequency
 * @see EntityForm
 */
public class GenotypeFrequencyForm extends EntityForm<GenotypeFrequency>
{
	
	public GenotypeFrequencyForm()
	{
		super();
	}
	
	public GenotypeFrequencyForm(GenotypeFrequency entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<GenotypeFrequency> getEntityClass()
	{
		return GenotypeFrequency.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("Identifier");
		headers.add("Name");
		headers.add("description");
		headers.add("ProtocolUsed");
		headers.add("startTime");
		headers.add("endTime");
		headers.add("Frequency cluster ID");
		headers.add("Genotype combo");
		headers.add("Frequency as proportion");
		headers.add("Number of samples with genotype");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=GenotypeFrequency, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("GenotypeFrequency_id",getEntity().getId());
			
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
			StringInput input = new StringInput("GenotypeFrequency_Identifier",getEntity().getIdentifier());
			
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
			StringInput input = new StringInput("GenotypeFrequency_Name",getEntity().getName());
			
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
			EnumInput input = new EnumInput("GenotypeFrequency___Type",getEntity().get__Type());
			
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
			TextInput input = new TextInput("GenotypeFrequency_description",getEntity().getDescription());
			
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
		//ProtocolUsed: Field(entity=DataSet, name=ProtocolUsed, type=xref[Protocol.id], xref_label='Identifier', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<GenotypeFrequency> input = new XrefInput<GenotypeFrequency>("GenotypeFrequency_ProtocolUsed", getEntity().getProtocolUsed());
			//create xref dummy object
			Protocol dummy = null;
			if(getEntity().getProtocolUsed_Id() != null)
			{
			 	dummy = new Protocol();
				dummy.setId(getEntity().getProtocolUsed_Id());
				dummy.setIdentifier( getEntity().getProtocolUsed_Identifier() ); 
			}
			XrefInput<Protocol> input = new XrefInput<Protocol>("GenotypeFrequency_ProtocolUsed", org.molgenis.observ.Protocol.class, dummy);
			
			input.setLabel("ProtocolUsed");
			input.setDescription("Reference to the protocol that is being used (if available)");
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
		//StartTime: Field(entity=DataSet, name=startTime, type=datetime, auto=true, nillable=false, readonly=false, default=)
		{
			DatetimeInput input = new DatetimeInput("GenotypeFrequency_startTime",getEntity().getStartTime());
			
			input.setLabel("startTime");
			input.setDescription("time when the protocol started.");
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
		//EndTime: Field(entity=DataSet, name=endTime, type=datetime, auto=true, nillable=true, readonly=false, default=)
		{
			DatetimeInput input = new DatetimeInput("GenotypeFrequency_endTime",getEntity().getEndTime());
			
			input.setLabel("endTime");
			input.setDescription("(Optional) time when the protocol ended.");
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
		//FrequencyCluster: Field(entity=GenotypeFrequency, name=FrequencyCluster, type=xref[FrequencyCluster.id], xref_label='Identifier', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<GenotypeFrequency> input = new XrefInput<GenotypeFrequency>("GenotypeFrequency_FrequencyCluster", getEntity().getFrequencyCluster());
			//create xref dummy object
			FrequencyCluster dummy = null;
			if(getEntity().getFrequencyCluster_Id() != null)
			{
			 	dummy = new FrequencyCluster();
				dummy.setId(getEntity().getFrequencyCluster_Id());
				dummy.setIdentifier( getEntity().getFrequencyCluster_Identifier() ); 
			}
			XrefInput<FrequencyCluster> input = new XrefInput<FrequencyCluster>("GenotypeFrequency_FrequencyCluster", org.molgenis.gwascentral.FrequencyCluster.class, dummy);
			
			input.setLabel("Frequency cluster ID");
			input.setDescription("Frequency cluster ID");
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
		//GenotypeCombo: Field(entity=GenotypeFrequency, name=GenotypeCombo, type=text, auto=false, nillable=true, readonly=false, default=)
		{
			TextInput input = new TextInput("GenotypeFrequency_GenotypeCombo",getEntity().getGenotypeCombo());
			
			input.setLabel("Genotype combo");
			input.setDescription("Genotype combo");
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
		//FrequencyAsProportion: Field(entity=GenotypeFrequency, name=FrequencyAsProportion, type=decimal, auto=false, nillable=false, readonly=false, default=)
		{
			DecimalInput input = new DecimalInput("GenotypeFrequency_FrequencyAsProportion",getEntity().getFrequencyAsProportion());
			
			input.setLabel("Frequency as proportion");
			input.setDescription("Frequency as proportion");
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
		//NumberSamplesWithGenotype: Field(entity=GenotypeFrequency, name=NumberSamplesWithGenotype, type=int, auto=false, nillable=true, readonly=false, default=)
		{
			IntInput input = new IntInput("GenotypeFrequency_NumberSamplesWithGenotype",getEntity().getNumberSamplesWithGenotype());
			
			input.setLabel("Number of samples with genotype");
			input.setDescription("Number of samples with genotype");
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


