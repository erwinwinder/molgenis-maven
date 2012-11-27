
/* File:        org.molgenis/model/Identifiable.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.core;

/**
 * Identifiable: This interface assigns an automatic 'id', globally
				unique identifier
				'identifier' field, and possibly not unique 'name'
				to all entities that implement it.
			
.
 * @author MOLGENIS generator
 */
public interface Identifiable extends  org.molgenis.core.Autoid
{
	public Integer getId();
	public void setId(Integer id);
	public String getIdentifier();
	public void setIdentifier(String identifier);
	public String getName();
	public void setName(String name);
}

