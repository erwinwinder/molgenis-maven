
/* File:        Org.molgenis.omx/html/Significance.java
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


import org.molgenis.observ.Protocol;
import org.molgenis.gwascentral.UsedMarkerSet;
import org.molgenis.gwascentral.Significance;


/**
 * A HtmlForm that is preloaded with all inputs for entity Significance
 * @see EntityForm
 */
public class SignificanceForm extends EntityForm<Significance>
{
	
	public SignificanceForm()
	{
		super();
	}
	
	public SignificanceForm(Significance entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<Significance> getEntityClass()
	{
		return Significance.class;
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
		headers.add("Used marker set ID");
		headers.add("Negative log p-value");
		headers.add("Unadjusted p-value");
		headers.add("Adjusted p-value");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=Significance, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("Significance_id",getEntity().getId());
			
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
			StringInput input = new StringInput("Significance_Identifier",getEntity().getIdentifier());
			
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
			StringInput input = new StringInput("Significance_Name",getEntity().getName());
			
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
			EnumInput input = new EnumInput("Significance___Type",getEntity().get__Type());
			
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
			TextInput input = new TextInput("Significance_description",getEntity().getDescription());
			
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
			//XrefInput<Significance> input = new XrefInput<Significance>("Significance_ProtocolUsed", getEntity().getProtocolUsed());
			//create xref dummy object
			Protocol dummy = null;
			if(getEntity().getProtocolUsed_Id() != null)
			{
			 	dummy = new Protocol();
				dummy.setId(getEntity().getProtocolUsed_Id());
				dummy.setIdentifier( getEntity().getProtocolUsed_Identifier() ); 
			}
			XrefInput<Protocol> input = new XrefInput<Protocol>("Significance_ProtocolUsed", org.molgenis.observ.Protocol.class, dummy);
			
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
			DatetimeInput input = new DatetimeInput("Significance_startTime",getEntity().getStartTime());
			
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
			DatetimeInput input = new DatetimeInput("Significance_endTime",getEntity().getEndTime());
			
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
		//UsedmarkersetID: Field(entity=Significance, name=UsedmarkersetID, type=xref[UsedMarkerSet.id], xref_label='Identifier', auto=false, nillable=false, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<Significance> input = new XrefInput<Significance>("Significance_UsedmarkersetID", getEntity().getUsedmarkersetID());
			//create xref dummy object
			UsedMarkerSet dummy = null;
			if(getEntity().getUsedmarkersetID_Id() != null)
			{
			 	dummy = new UsedMarkerSet();
				dummy.setId(getEntity().getUsedmarkersetID_Id());
				dummy.setIdentifier( getEntity().getUsedmarkersetID_Identifier() ); 
			}
			XrefInput<UsedMarkerSet> input = new XrefInput<UsedMarkerSet>("Significance_UsedmarkersetID", org.molgenis.gwascentral.UsedMarkerSet.class, dummy);
			
			input.setLabel("Used marker set ID");
			input.setDescription("Used marker set ID");
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
		//NegLogPValue: Field(entity=Significance, name=NegLogPValue, type=decimal, auto=false, nillable=true, readonly=false, default=)
		{
			DecimalInput input = new DecimalInput("Significance_NegLogPValue",getEntity().getNegLogPValue());
			
			input.setLabel("Negative log p-value");
			input.setDescription("Negative log p-value");
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
		//UnadjustedPValue: Field(entity=Significance, name=UnadjustedPValue, type=text, auto=false, nillable=true, readonly=false, default=)
		{
			TextInput input = new TextInput("Significance_UnadjustedPValue",getEntity().getUnadjustedPValue());
			
			input.setLabel("Unadjusted p-value");
			input.setDescription("Unadjusted p-value");
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
		//AdjustedPValue: Field(entity=Significance, name=AdjustedPValue, type=decimal, auto=false, nillable=true, readonly=false, default=)
		{
			DecimalInput input = new DecimalInput("Significance_AdjustedPValue",getEntity().getAdjustedPValue());
			
			input.setLabel("Adjusted p-value");
			input.setDescription("Adjusted p-value");
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


