
/* File:        org.molgenis/model/Authorizable.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.auth;

/**
 * Authorizable: Interface for row level security
.
 * @author MOLGENIS generator
 */
public interface Authorizable extends org.molgenis.util.Entity
{
	public org.molgenis.auth.MolgenisRole getCanRead();
	public void setCanRead(org.molgenis.auth.MolgenisRole canRead);
        public Integer getCanRead_Id();
        public void setCanRead_Id(Integer canRead);

	public String getCanRead_Name();
	public void setCanRead_Name(String canRead_name);
	public org.molgenis.auth.MolgenisRole getCanWrite();
	public void setCanWrite(org.molgenis.auth.MolgenisRole canWrite);
        public Integer getCanWrite_Id();
        public void setCanWrite_Id(Integer canWrite);

	public String getCanWrite_Name();
	public void setCanWrite_Name(String canWrite_name);
	public org.molgenis.auth.MolgenisRole getOwns();
	public void setOwns(org.molgenis.auth.MolgenisRole owns);
        public Integer getOwns_Id();
        public void setOwns_Id(Integer owns);

	public String getOwns_Name();
	public void setOwns_Name(String owns_name);
}

