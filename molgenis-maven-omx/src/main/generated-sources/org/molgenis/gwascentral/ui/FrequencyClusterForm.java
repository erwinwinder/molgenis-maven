
/* File:        Org.molgenis.omx/html/FrequencyCluster.java
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
import org.molgenis.observ.DataSet;
import org.molgenis.gwascentral.UsedMarkerSet;
import org.molgenis.gwascentral.FrequencyCluster;


/**
 * A HtmlForm that is preloaded with all inputs for entity FrequencyCluster
 * @see EntityForm
 */
public class FrequencyClusterForm extends EntityForm<FrequencyCluster>
{
	
	public FrequencyClusterForm()
	{
		super();
	}
	
	public FrequencyClusterForm(FrequencyCluster entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<FrequencyCluster> getEntityClass()
	{
		return FrequencyCluster.class;
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
		headers.add("Result set identifier");
		headers.add("Used marker set ID");
		headers.add("Marker ID");
		headers.add("Number of genotyped samples");
		headers.add("P-value HWE");
		headers.add("Unadjusted p-value");
		headers.add("Odds ratio statement");
		headers.add("Attributable risk statement");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=FrequencyCluster, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("FrequencyCluster_id",getEntity().getId());
			
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
			StringInput input = new StringInput("FrequencyCluster_Identifier",getEntity().getIdentifier());
			
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
			StringInput input = new StringInput("FrequencyCluster_Name",getEntity().getName());
			
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
			EnumInput input = new EnumInput("FrequencyCluster___Type",getEntity().get__Type());
			
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
			TextInput input = new TextInput("FrequencyCluster_description",getEntity().getDescription());
			
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
			//XrefInput<FrequencyCluster> input = new XrefInput<FrequencyCluster>("FrequencyCluster_ProtocolUsed", getEntity().getProtocolUsed());
			//create xref dummy object
			Protocol dummy = null;
			if(getEntity().getProtocolUsed_Id() != null)
			{
			 	dummy = new Protocol();
				dummy.setId(getEntity().getProtocolUsed_Id());
				dummy.setIdentifier( getEntity().getProtocolUsed_Identifier() ); 
			}
			XrefInput<Protocol> input = new XrefInput<Protocol>("FrequencyCluster_ProtocolUsed", org.molgenis.observ.Protocol.class, dummy);
			
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
			DatetimeInput input = new DatetimeInput("FrequencyCluster_startTime",getEntity().getStartTime());
			
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
			DatetimeInput input = new DatetimeInput("FrequencyCluster_endTime",getEntity().getEndTime());
			
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
		//DataSet: Field(entity=FrequencyCluster, name=DataSet, type=xref[DataSet.id], xref_label='Identifier', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<FrequencyCluster> input = new XrefInput<FrequencyCluster>("FrequencyCluster_DataSet", getEntity().getDataSet());
			//create xref dummy object
			DataSet dummy = null;
			if(getEntity().getDataSet_Id() != null)
			{
			 	dummy = new DataSet();
				dummy.setId(getEntity().getDataSet_Id());
				dummy.setIdentifier( getEntity().getDataSet_Identifier() ); 
			}
			XrefInput<DataSet> input = new XrefInput<DataSet>("FrequencyCluster_DataSet", org.molgenis.observ.DataSet.class, dummy);
			
			input.setLabel("Result set identifier");
			input.setDescription("Result set identifier");
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
		//UsedMarkerSet: Field(entity=FrequencyCluster, name=UsedMarkerSet, type=xref[UsedMarkerSet.id], xref_label='Identifier', auto=false, nillable=false, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<FrequencyCluster> input = new XrefInput<FrequencyCluster>("FrequencyCluster_UsedMarkerSet", getEntity().getUsedMarkerSet());
			//create xref dummy object
			UsedMarkerSet dummy = null;
			if(getEntity().getUsedMarkerSet_Id() != null)
			{
			 	dummy = new UsedMarkerSet();
				dummy.setId(getEntity().getUsedMarkerSet_Id());
				dummy.setIdentifier( getEntity().getUsedMarkerSet_Identifier() ); 
			}
			XrefInput<UsedMarkerSet> input = new XrefInput<UsedMarkerSet>("FrequencyCluster_UsedMarkerSet", org.molgenis.gwascentral.UsedMarkerSet.class, dummy);
			
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
		//MarkerID: Field(entity=FrequencyCluster, name=MarkerID, type=int, auto=false, nillable=false, readonly=false, default=)
		{
			IntInput input = new IntInput("FrequencyCluster_MarkerID",getEntity().getMarkerID());
			
			input.setLabel("Marker ID");
			input.setDescription("Marker ID");
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
		//NumberOfGenotypedSamples: Field(entity=FrequencyCluster, name=NumberOfGenotypedSamples, type=int, auto=false, nillable=false, readonly=false, default=)
		{
			IntInput input = new IntInput("FrequencyCluster_NumberOfGenotypedSamples",getEntity().getNumberOfGenotypedSamples());
			
			input.setLabel("Number of genotyped samples");
			input.setDescription("Number of genotyped samples");
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
		//PValueHWE: Field(entity=FrequencyCluster, name=PValueHWE, type=decimal, auto=false, nillable=true, readonly=false, default=)
		{
			DecimalInput input = new DecimalInput("FrequencyCluster_PValueHWE",getEntity().getPValueHWE());
			
			input.setLabel("P-value HWE");
			input.setDescription("P-value HWE");
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
		//UnadjustedPValue: Field(entity=FrequencyCluster, name=UnadjustedPValue, type=decimal, auto=false, nillable=true, readonly=false, default=)
		{
			DecimalInput input = new DecimalInput("FrequencyCluster_UnadjustedPValue",getEntity().getUnadjustedPValue());
			
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
		//OddsRatioStatement: Field(entity=FrequencyCluster, name=OddsRatioStatement, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("FrequencyCluster_OddsRatioStatement",getEntity().getOddsRatioStatement());
			
			input.setLabel("Odds ratio statement");
			input.setDescription("Odds ratio statement");
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
		//AttributableRiskStatement: Field(entity=FrequencyCluster, name=AttributableRiskStatement, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("FrequencyCluster_AttributableRiskStatement",getEntity().getAttributableRiskStatement());
			
			input.setLabel("Attributable risk statement");
			input.setDescription("Attributable risk statement");
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


