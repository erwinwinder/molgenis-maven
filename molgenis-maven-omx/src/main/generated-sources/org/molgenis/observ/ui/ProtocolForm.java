
/* File:        Org.molgenis.omx/html/Protocol.java
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


import org.molgenis.observ.target.OntologyTerm;
import org.molgenis.observ.Protocol;
import org.molgenis.observ.ObservableFeature;


/**
 * A HtmlForm that is preloaded with all inputs for entity Protocol
 * @see EntityForm
 */
public class ProtocolForm extends EntityForm<Protocol>
{
	
	public ProtocolForm()
	{
		super();
	}
	
	public ProtocolForm(Protocol entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<Protocol> getEntityClass()
	{
		return Protocol.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("Identifier");
		headers.add("Name");
		headers.add("description");
		headers.add("ProtocolType");
		headers.add("subprotocols");
		headers.add("Features");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=Protocol, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("Protocol_id",getEntity().getId());
			
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
			StringInput input = new StringInput("Protocol_Identifier",getEntity().getIdentifier());
			
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
			StringInput input = new StringInput("Protocol_Name",getEntity().getName());
			
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
			EnumInput input = new EnumInput("Protocol___Type",getEntity().get__Type());
			
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
			TextInput input = new TextInput("Protocol_description",getEntity().getDescription());
			
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
		//ProtocolType: Field(entity=Protocol, name=ProtocolType, type=xref[OntologyTerm.id], xref_label='Identifier', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<Protocol> input = new XrefInput<Protocol>("Protocol_ProtocolType", getEntity().getProtocolType());
			//create xref dummy object
			OntologyTerm dummy = null;
			if(getEntity().getProtocolType_Id() != null)
			{
			 	dummy = new OntologyTerm();
				dummy.setId(getEntity().getProtocolType_Id());
				dummy.setIdentifier( getEntity().getProtocolType_Identifier() ); 
			}
			XrefInput<OntologyTerm> input = new XrefInput<OntologyTerm>("Protocol_ProtocolType", org.molgenis.observ.target.OntologyTerm.class, dummy);
			
			input.setLabel("ProtocolType");
			input.setDescription("classification of protocol");
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
		//Subprotocols: Field(entity=Protocol, name=subprotocols, type=mref[Protocol.id], mref_name=Protocol_subprotocols, mref_localid=Protocol, mref_remoteid=subprotocols, xref_label='Identifier', auto=false, nillable=true, readonly=false, default=)
		{
			//TODO: when we have JPA this should become:
			//MrefInput input = new MrefInput("Protocol_subprotocols", getEntity().getSubprotocols());
			//create xref dummy list of references
			List<Protocol> dummyList = new ArrayList<Protocol>();
			if(getEntity().getSubprotocols_Id() != null) for(int i = 0; i < getEntity().getSubprotocols_Id().size(); i++ )
			{
				Protocol dummy = new Protocol();
				dummy.setId(getEntity().getSubprotocols_Id().get(i));
				dummy.setIdentifier( getEntity().getSubprotocols_Identifier().get(i) ); 
				dummyList.add(dummy);
			}   
			MrefInput<Protocol> input = new MrefInput<Protocol> ("Protocol_subprotocols", org.molgenis.observ.Protocol.class, dummyList);
			
			input.setLabel("subprotocols");
			input.setDescription("Subprotocols of this protocol");
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
		//Features: Field(entity=Protocol, name=Features, type=mref[ObservableFeature.id], mref_name=Protocol_Features, mref_localid=Protocol, mref_remoteid=Features, xref_label='Identifier', auto=false, nillable=true, readonly=false, default=)
		{
			//TODO: when we have JPA this should become:
			//MrefInput input = new MrefInput("Protocol_Features", getEntity().getFeatures());
			//create xref dummy list of references
			List<ObservableFeature> dummyList = new ArrayList<ObservableFeature>();
			if(getEntity().getFeatures_Id() != null) for(int i = 0; i < getEntity().getFeatures_Id().size(); i++ )
			{
				ObservableFeature dummy = new ObservableFeature();
				dummy.setId(getEntity().getFeatures_Id().get(i));
				dummy.setIdentifier( getEntity().getFeatures_Identifier().get(i) ); 
				dummyList.add(dummy);
			}   
			MrefInput<ObservableFeature> input = new MrefInput<ObservableFeature> ("Protocol_Features", org.molgenis.observ.ObservableFeature.class, dummyList);
			
			input.setLabel("Features");
			input.setDescription("parameters (in/out) that are used or produced by this protocol.");
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


