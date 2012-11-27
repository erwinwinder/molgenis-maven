
/* File:        org.molgenis/model/AaPosition.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.variant;

/**
 * AaPosition: Having aa position
.
 * @author MOLGENIS generator
 */
public interface AaPosition extends org.molgenis.util.Entity
{
	public org.molgenis.variant.Protein getAa();
	public void setAa(org.molgenis.variant.Protein aa);
        public Integer getAa_Id();
        public void setAa_Id(Integer aa);

	public String getAa_Identifier();
	public void setAa_Identifier(String aa_Identifier);
	public Integer getAa_Start();
	public void setAa_Start(Integer aa_start);
	public Integer getAa_End();
	public void setAa_End(Integer aa_end);
}

