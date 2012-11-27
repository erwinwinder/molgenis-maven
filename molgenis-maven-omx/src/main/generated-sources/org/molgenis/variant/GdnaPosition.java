
/* File:        org.molgenis/model/GdnaPosition.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.variant;

/**
 * GdnaPosition: Having gDNA position
.
 * @author MOLGENIS generator
 */
public interface GdnaPosition extends org.molgenis.util.Entity
{
	public org.molgenis.variant.Chromosome getGdna();
	public void setGdna(org.molgenis.variant.Chromosome gdna);
        public Integer getGdna_Id();
        public void setGdna_Id(Integer gdna);

	public String getGdna_Identifier();
	public void setGdna_Identifier(String gdna_Identifier);
	public Integer getGdna_Start();
	public void setGdna_Start(Integer gdna_start);
	public Integer getGdna_End();
	public void setGdna_End(Integer gdna_end);
}

