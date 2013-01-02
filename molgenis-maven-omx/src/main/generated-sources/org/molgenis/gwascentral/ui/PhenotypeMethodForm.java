
/* File:        Org.molgenis.omx/html/PhenotypeMethod.java
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
import org.molgenis.organization.Study;
import org.molgenis.gwascentral.PhenotypeProperty;
import org.molgenis.gwascentral.PhenotypeMethod;


/**
 * A HtmlForm that is preloaded with all inputs for entity PhenotypeMethod
 * @see EntityForm
 */
public class PhenotypeMethodForm extends EntityForm<PhenotypeMethod>
{
	
	public PhenotypeMethodForm()
	{
		super();
	}
	
	public PhenotypeMethodForm(PhenotypeMethod entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<PhenotypeMethod> getEntityClass()
	{
		return PhenotypeMethod.class;
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
		headers.add("Study identifier");
		headers.add("Phenotype property name");
		headers.add("Sample");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=PhenotypeMethod, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("PhenotypeMethod_id",getEntity().getId());
			
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
		//Identifier: Field(entity=PhenotypeMethod, name=Identifier, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("PhenotypeMethod_Identifier",getEntity().getIdentifier());
			
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
		//Name: Field(entity=PhenotypeMethod, name=Name, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("PhenotypeMethod_Name",getEntity().getName());
			
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
		//__Type: Field(entity=Characteristic, name=__Type, type=enum, auto=true, nillable=false, readonly=true, default=null, enum_options=[Characteristic, Individual, SamplePanel, AssayedPanel, Panel, ObservationTarget, PhenotypeProperty, UsedMarkerSet, ObservableFeature, Category, Protocol, FrequencyCluster, GenotypeFrequency, AlleleFrequency, PhenotypeMethod, Significance, EffectSize, DataSet, Genome, Chromosome, Gene, Protein, ProteinDomain, Exon, Variant])
		{
			EnumInput input = new EnumInput("PhenotypeMethod___Type",getEntity().get__Type());
			
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
			TextInput input = new TextInput("PhenotypeMethod_description",getEntity().getDescription());
			
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
			//XrefInput<PhenotypeMethod> input = new XrefInput<PhenotypeMethod>("PhenotypeMethod_ProtocolUsed", getEntity().getProtocolUsed());
			//create xref dummy object
			Protocol dummy = null;
			if(getEntity().getProtocolUsed_Id() != null)
			{
			 	dummy = new Protocol();
				dummy.setId(getEntity().getProtocolUsed_Id());
				dummy.setIdentifier( getEntity().getProtocolUsed_Identifier() ); 
			}
			XrefInput<Protocol> input = new XrefInput<Protocol>("PhenotypeMethod_ProtocolUsed", org.molgenis.observ.Protocol.class, dummy);
			
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
			DatetimeInput input = new DatetimeInput("PhenotypeMethod_startTime",getEntity().getStartTime());
			
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
			DatetimeInput input = new DatetimeInput("PhenotypeMethod_endTime",getEntity().getEndTime());
			
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
		//StudyID: Field(entity=PhenotypeMethod, name=StudyID, type=xref[Study.id], xref_label='Identifier', auto=false, nillable=false, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<PhenotypeMethod> input = new XrefInput<PhenotypeMethod>("PhenotypeMethod_StudyID", getEntity().getStudyID());
			//create xref dummy object
			Study dummy = null;
			if(getEntity().getStudyID_Id() != null)
			{
			 	dummy = new Study();
				dummy.setId(getEntity().getStudyID_Id());
				dummy.setIdentifier( getEntity().getStudyID_Identifier() ); 
			}
			XrefInput<Study> input = new XrefInput<Study>("PhenotypeMethod_StudyID", org.molgenis.organization.Study.class, dummy);
			
			input.setLabel("Study identifier");
			input.setDescription("Points to study that this method came in");
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
		//PhenotypePropertyID: Field(entity=PhenotypeMethod, name=PhenotypePropertyID, type=xref[PhenotypeProperty.id], xref_label='Identifier', auto=false, nillable=false, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<PhenotypeMethod> input = new XrefInput<PhenotypeMethod>("PhenotypeMethod_PhenotypePropertyID", getEntity().getPhenotypePropertyID());
			//create xref dummy object
			PhenotypeProperty dummy = null;
			if(getEntity().getPhenotypePropertyID_Id() != null)
			{
			 	dummy = new PhenotypeProperty();
				dummy.setId(getEntity().getPhenotypePropertyID_Id());
				dummy.setIdentifier( getEntity().getPhenotypePropertyID_Identifier() ); 
			}
			XrefInput<PhenotypeProperty> input = new XrefInput<PhenotypeProperty>("PhenotypeMethod_PhenotypePropertyID", org.molgenis.gwascentral.PhenotypeProperty.class, dummy);
			
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
		//Sample: Field(entity=PhenotypeMethod, name=Sample, type=string[100], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("PhenotypeMethod_Sample",getEntity().getSample());
			
			input.setLabel("Sample");
			input.setDescription("Biological system or sample type being assessed");
			input.setNillable(true);
			input.setSize(100);
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


