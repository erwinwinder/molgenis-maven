
/* File:        org.molgenis/model/CdnaPosition.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.variant;

/**
 * CdnaPosition: .
 * @author MOLGENIS generator
 */
public interface CdnaPosition extends org.molgenis.util.Entity
{
	public org.molgenis.variant.Gene getCdna();
	public void setCdna(org.molgenis.variant.Gene cdna);
        public Integer getCdna_Id();
        public void setCdna_Id(Integer cdna);

	public String getCdna_Identifier();
	public void setCdna_Identifier(String cdna_Identifier);
	public Integer getCdna_Start();
	public void setCdna_Start(Integer cdna_start);
	public Integer getCdna_End();
	public void setCdna_End(Integer cdna_end);
}

