
/* File:        Org.molgenis.omx/html/Variant.java
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


import org.molgenis.variant.Chromosome;
import org.molgenis.variant.Gene;
import org.molgenis.variant.Protein;
import org.molgenis.observ.target.OntologyTerm;
import org.molgenis.variant.Variant;


/**
 * A HtmlForm that is preloaded with all inputs for entity Variant
 * @see EntityForm
 */
public class VariantForm extends EntityForm<Variant>
{
	
	public VariantForm()
	{
		super();
	}
	
	public VariantForm(Variant entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<Variant> getEntityClass()
	{
		return Variant.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("Identifier");
		headers.add("Name");
		headers.add("description");
		headers.add("gdna");
		headers.add("gdna_start");
		headers.add("gdna_end");
		headers.add("cdna");
		headers.add("cdna_start");
		headers.add("cdna_end");
		headers.add("aa");
		headers.add("aa_start");
		headers.add("aa_end");
		headers.add("gdna_notation");
		headers.add("cdna_notation");
		headers.add("aa_notation");
		headers.add("variantType");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=Variant, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("Variant_id",getEntity().getId());
			
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
			StringInput input = new StringInput("Variant_Identifier",getEntity().getIdentifier());
			
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
			StringInput input = new StringInput("Variant_Name",getEntity().getName());
			
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
			EnumInput input = new EnumInput("Variant___Type",getEntity().get__Type());
			
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
			TextInput input = new TextInput("Variant_description",getEntity().getDescription());
			
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
		//Gdna: Field(entity=Variant, name=gdna, type=xref[Chromosome.id], xref_label='Identifier', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<Variant> input = new XrefInput<Variant>("Variant_gdna", getEntity().getGdna());
			//create xref dummy object
			Chromosome dummy = null;
			if(getEntity().getGdna_Id() != null)
			{
			 	dummy = new Chromosome();
				dummy.setId(getEntity().getGdna_Id());
				dummy.setIdentifier( getEntity().getGdna_Identifier() ); 
			}
			XrefInput<Chromosome> input = new XrefInput<Chromosome>("Variant_gdna", org.molgenis.variant.Chromosome.class, dummy);
			
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
		//Gdna_Start: Field(entity=Variant, name=gdna_start, type=int, auto=false, nillable=true, readonly=false, default=)
		{
			IntInput input = new IntInput("Variant_gdna_start",getEntity().getGdna_Start());
			
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
		//Gdna_End: Field(entity=Variant, name=gdna_end, type=int, auto=false, nillable=true, readonly=false, default=)
		{
			IntInput input = new IntInput("Variant_gdna_end",getEntity().getGdna_End());
			
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
		//Cdna: Field(entity=Variant, name=cdna, type=xref[Gene.id], xref_label='Identifier', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<Variant> input = new XrefInput<Variant>("Variant_cdna", getEntity().getCdna());
			//create xref dummy object
			Gene dummy = null;
			if(getEntity().getCdna_Id() != null)
			{
			 	dummy = new Gene();
				dummy.setId(getEntity().getCdna_Id());
				dummy.setIdentifier( getEntity().getCdna_Identifier() ); 
			}
			XrefInput<Gene> input = new XrefInput<Gene>("Variant_cdna", org.molgenis.variant.Gene.class, dummy);
			
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
		//Cdna_Start: Field(entity=Variant, name=cdna_start, type=int, auto=false, nillable=true, readonly=false, default=)
		{
			IntInput input = new IntInput("Variant_cdna_start",getEntity().getCdna_Start());
			
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
		//Cdna_End: Field(entity=Variant, name=cdna_end, type=int, auto=false, nillable=true, readonly=false, default=)
		{
			IntInput input = new IntInput("Variant_cdna_end",getEntity().getCdna_End());
			
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
		//Aa: Field(entity=Variant, name=aa, type=xref[Protein.id], xref_label='Identifier', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<Variant> input = new XrefInput<Variant>("Variant_aa", getEntity().getAa());
			//create xref dummy object
			Protein dummy = null;
			if(getEntity().getAa_Id() != null)
			{
			 	dummy = new Protein();
				dummy.setId(getEntity().getAa_Id());
				dummy.setIdentifier( getEntity().getAa_Identifier() ); 
			}
			XrefInput<Protein> input = new XrefInput<Protein>("Variant_aa", org.molgenis.variant.Protein.class, dummy);
			
			input.setLabel("aa");
			input.setDescription("The protein sequence this element lies on.");
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
		//Aa_Start: Field(entity=Variant, name=aa_start, type=int, auto=false, nillable=true, readonly=false, default=)
		{
			IntInput input = new IntInput("Variant_aa_start",getEntity().getAa_Start());
			
			input.setLabel("aa_start");
			input.setDescription("Start position on amino acid sequence.");
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
		//Aa_End: Field(entity=Variant, name=aa_end, type=int, auto=false, nillable=true, readonly=false, default=)
		{
			IntInput input = new IntInput("Variant_aa_end",getEntity().getAa_End());
			
			input.setLabel("aa_end");
			input.setDescription("End position on amino acid sequence.");
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
		//Gdna_Notation: Field(entity=Variant, name=gdna_notation, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("Variant_gdna_notation",getEntity().getGdna_Notation());
			
			input.setLabel("gdna_notation");
			input.setDescription("gDNA notation of the variant, e.g. g.1234567C&gt;T");
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
		//Cdna_Notation: Field(entity=Variant, name=cdna_notation, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("Variant_cdna_notation",getEntity().getCdna_Notation());
			
			input.setLabel("cdna_notation");
			input.setDescription("cDNA notation of the variant, e.g. c.123C&gt;T");
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
		//Aa_Notation: Field(entity=Variant, name=aa_notation, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("Variant_aa_notation",getEntity().getAa_Notation());
			
			input.setLabel("aa_notation");
			input.setDescription("Aa notation of the variant, e.g. p.Ser123ArgfsX12");
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
		//VariantType: Field(entity=Variant, name=variantType, type=xref[OntologyTerm.id], xref_label='Identifier', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<Variant> input = new XrefInput<Variant>("Variant_variantType", getEntity().getVariantType());
			//create xref dummy object
			OntologyTerm dummy = null;
			if(getEntity().getVariantType_Id() != null)
			{
			 	dummy = new OntologyTerm();
				dummy.setId(getEntity().getVariantType_Id());
				dummy.setIdentifier( getEntity().getVariantType_Identifier() ); 
			}
			XrefInput<OntologyTerm> input = new XrefInput<OntologyTerm>("Variant_variantType", org.molgenis.observ.target.OntologyTerm.class, dummy);
			
			input.setLabel("variantType");
			input.setDescription("Type of the variant.");
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


