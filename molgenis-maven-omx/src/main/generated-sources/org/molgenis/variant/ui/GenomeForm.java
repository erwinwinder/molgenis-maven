
/* File:        Org.molgenis/html/Genome.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 26, 2012
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


import org.molgenis.observ.target.Species;
import org.molgenis.variant.Genome;


/**
 * A HtmlForm that is preloaded with all inputs for entity Genome
 * @see EntityForm
 */
public class GenomeForm extends EntityForm<Genome>
{
	
	public GenomeForm()
	{
		super();
	}
	
	public GenomeForm(Genome entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<Genome> getEntityClass()
	{
		return Genome.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("Identifier");
		headers.add("Name");
		headers.add("description");
		headers.add("residues");
		headers.add("seqlen");
		headers.add("species");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=Genome, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("Genome_id",getEntity().getId());
			
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
			StringInput input = new StringInput("Genome_Identifier",getEntity().getIdentifier());
			
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
			StringInput input = new StringInput("Genome_Name",getEntity().getName());
			
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
			EnumInput input = new EnumInput("Genome___Type",getEntity().get__Type());
			
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
			TextInput input = new TextInput("Genome_description",getEntity().getDescription());
			
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
		//Residues: Field(entity=Genome, name=residues, type=text, auto=false, nillable=true, readonly=false, default=)
		{
			TextInput input = new TextInput("Genome_residues",getEntity().getResidues());
			
			input.setLabel("residues");
			input.setDescription("A sequence of alphabetic characters representing biological residues (nucleic acids, amino acids). This column does not need to be manifested for all features; it is optional for features such as exons where the residues can be derived from the featureloc. It is recommended that the value for this column be manifested for features which may may non-contiguous sublocations (e.g. transcripts), since derivation at query time is non-trivial. For expressed sequence, the DNA sequence should be used rather than the RNA sequence.");
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
		//Seqlen: Field(entity=Genome, name=seqlen, type=int, auto=false, nillable=true, readonly=false, default=)
		{
			IntInput input = new IntInput("Genome_seqlen",getEntity().getSeqlen());
			
			input.setLabel("seqlen");
			input.setDescription("The length of the residue feature. See column:residues. This column is partially redundant with the residues column, and also with featureloc. This column is required because the location may be unknown and the residue sequence may not be manifested, yet it may be desirable to store and query the length of the feature. The seqlen should always be manifested where the length of the sequence is known.");
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
		//Species: Field(entity=Genome, name=species, type=xref[Species.id], xref_label='Identifier', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<Genome> input = new XrefInput<Genome>("Genome_species", getEntity().getSpecies());
			//create xref dummy object
			Species dummy = null;
			if(getEntity().getSpecies_Id() != null)
			{
			 	dummy = new Species();
				dummy.setId(getEntity().getSpecies_Id());
				dummy.setIdentifier( getEntity().getSpecies_Identifier() ); 
			}
			XrefInput<Species> input = new XrefInput<Species>("Genome_species", org.molgenis.observ.target.Species.class, dummy);
			
			input.setLabel("species");
			input.setDescription("species this genome belongs to.");
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


