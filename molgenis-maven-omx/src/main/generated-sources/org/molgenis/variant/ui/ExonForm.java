
/* File:        Org.molgenis.omx/html/Exon.java
 * Copyright:   GBIC 2000-2013, all rights reserved
 * Date:        January 2, 2013
 * 
 * generator:   org.molgenis.generators.ui.HtmlFormGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
package org.molgenis.variant.ui;

// jdk
import java.util.Vector;
import java.util.List;
import java.util.ArrayList;


// molgenis
import org.molgenis.framework.ui.html.*;


import org.molgenis.variant.Gene;
import org.molgenis.variant.Chromosome;
import org.molgenis.variant.Exon;


/**
 * A HtmlForm that is preloaded with all inputs for entity Exon
 * @see EntityForm
 */
public class ExonForm extends EntityForm<Exon>
{
	
	public ExonForm()
	{
		super();
	}
	
	public ExonForm(Exon entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<Exon> getEntityClass()
	{
		return Exon.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("Identifier");
		headers.add("Name");
		headers.add("description");
		headers.add("cdna");
		headers.add("cdna_start");
		headers.add("cdna_end");
		headers.add("gdna");
		headers.add("gdna_start");
		headers.add("gdna_end");
		headers.add("isIntron");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=Exon, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("Exon_id",getEntity().getId());
			
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
			StringInput input = new StringInput("Exon_Identifier",getEntity().getIdentifier());
			
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
			StringInput input = new StringInput("Exon_Name",getEntity().getName());
			
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
			EnumInput input = new EnumInput("Exon___Type",getEntity().get__Type());
			
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
			TextInput input = new TextInput("Exon_description",getEntity().getDescription());
			
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
		//Cdna: Field(entity=Exon, name=cdna, type=xref[Gene.id], xref_label='Identifier', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<Exon> input = new XrefInput<Exon>("Exon_cdna", getEntity().getCdna());
			//create xref dummy object
			Gene dummy = null;
			if(getEntity().getCdna_Id() != null)
			{
			 	dummy = new Gene();
				dummy.setId(getEntity().getCdna_Id());
				dummy.setIdentifier( getEntity().getCdna_Identifier() ); 
			}
			XrefInput<Gene> input = new XrefInput<Gene>("Exon_cdna", org.molgenis.variant.Gene.class, dummy);
			
			input.setLabel("cdna");
			input.setDescription("The gene this element lies on.");
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
		//Cdna_Start: Field(entity=Exon, name=cdna_start, type=int, auto=false, nillable=true, readonly=false, default=)
		{
			IntInput input = new IntInput("Exon_cdna_start",getEntity().getCdna_Start());
			
			input.setLabel("cdna_start");
			input.setDescription("Start position on cDNA sequence.");
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
		//Cdna_End: Field(entity=Exon, name=cdna_end, type=int, auto=false, nillable=true, readonly=false, default=)
		{
			IntInput input = new IntInput("Exon_cdna_end",getEntity().getCdna_End());
			
			input.setLabel("cdna_end");
			input.setDescription("End position on cDNA sequence.");
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
		//Gdna: Field(entity=Exon, name=gdna, type=xref[Chromosome.id], xref_label='Identifier', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<Exon> input = new XrefInput<Exon>("Exon_gdna", getEntity().getGdna());
			//create xref dummy object
			Chromosome dummy = null;
			if(getEntity().getGdna_Id() != null)
			{
			 	dummy = new Chromosome();
				dummy.setId(getEntity().getGdna_Id());
				dummy.setIdentifier( getEntity().getGdna_Identifier() ); 
			}
			XrefInput<Chromosome> input = new XrefInput<Chromosome>("Exon_gdna", org.molgenis.variant.Chromosome.class, dummy);
			
			input.setLabel("gdna");
			input.setDescription("The genome this element lies on.");
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
		//Gdna_Start: Field(entity=Exon, name=gdna_start, type=int, auto=false, nillable=true, readonly=false, default=)
		{
			IntInput input = new IntInput("Exon_gdna_start",getEntity().getGdna_Start());
			
			input.setLabel("gdna_start");
			input.setDescription("Start position on genomic sequence.");
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
		//Gdna_End: Field(entity=Exon, name=gdna_end, type=int, auto=false, nillable=true, readonly=false, default=)
		{
			IntInput input = new IntInput("Exon_gdna_end",getEntity().getGdna_End());
			
			input.setLabel("gdna_end");
			input.setDescription("End position on genomic sequence.");
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
		//IsIntron: Field(entity=Exon, name=isIntron, type=bool, auto=false, nillable=false, readonly=false, default=)
		{
			BoolInput input = new BoolInput("Exon_isIntron",getEntity().getIsIntron());
			
			input.setLabel("isIntron");
			input.setDescription("Is this exon actually an intron?");
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


