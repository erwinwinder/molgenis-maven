
/* File:        Org.molgenis/html/MolgenisRoleGroupLink.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 26, 2012
 * 
 * generator:   org.molgenis.generators.ui.HtmlFormGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
package org.molgenis.auth.ui;

// jdk
import java.util.Vector;
import java.util.List;
import java.util.ArrayList;


// molgenis
import org.molgenis.framework.ui.html.*;


import org.molgenis.auth.MolgenisGroup;
import org.molgenis.auth.MolgenisRole;
import org.molgenis.auth.MolgenisRoleGroupLink;


/**
 * A HtmlForm that is preloaded with all inputs for entity MolgenisRoleGroupLink
 * @see EntityForm
 */
public class MolgenisRoleGroupLinkForm extends EntityForm<MolgenisRoleGroupLink>
{
	
	public MolgenisRoleGroupLinkForm()
	{
		super();
	}
	
	public MolgenisRoleGroupLinkForm(MolgenisRoleGroupLink entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<MolgenisRoleGroupLink> getEntityClass()
	{
		return MolgenisRoleGroupLink.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("Identifier");
		headers.add("Name");
		headers.add("group_");
		headers.add("role_");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=MolgenisRoleGroupLink, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("MolgenisRoleGroupLink_id",getEntity().getId());
			
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
		//Identifier: Field(entity=MolgenisRoleGroupLink, name=Identifier, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("MolgenisRoleGroupLink_Identifier",getEntity().getIdentifier());
			
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
		//Name: Field(entity=MolgenisRoleGroupLink, name=Name, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("MolgenisRoleGroupLink_Name",getEntity().getName());
			
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
		//Group: Field(entity=MolgenisRoleGroupLink, name=group_, type=xref[MolgenisGroup.id], xref_label='name', auto=false, nillable=false, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<MolgenisRoleGroupLink> input = new XrefInput<MolgenisRoleGroupLink>("MolgenisRoleGroupLink_group_", getEntity().getGroup());
			//create xref dummy object
			MolgenisGroup dummy = null;
			if(getEntity().getGroup_Id() != null)
			{
			 	dummy = new MolgenisGroup();
				dummy.setId(getEntity().getGroup_Id());
				dummy.setName( getEntity().getGroup_Name() ); 
			}
			XrefInput<MolgenisGroup> input = new XrefInput<MolgenisGroup>("MolgenisRoleGroupLink_group_", org.molgenis.auth.MolgenisGroup.class, dummy);
			
			input.setLabel("group_");
			input.setDescription("group_");
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
		//Role: Field(entity=MolgenisRoleGroupLink, name=role_, type=xref[MolgenisRole.id], xref_label='name', auto=false, nillable=false, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<MolgenisRoleGroupLink> input = new XrefInput<MolgenisRoleGroupLink>("MolgenisRoleGroupLink_role_", getEntity().getRole());
			//create xref dummy object
			MolgenisRole dummy = null;
			if(getEntity().getRole_Id() != null)
			{
			 	dummy = new MolgenisRole();
				dummy.setId(getEntity().getRole_Id());
				dummy.setName( getEntity().getRole_Name() ); 
			}
			XrefInput<MolgenisRole> input = new XrefInput<MolgenisRole>("MolgenisRoleGroupLink_role_", org.molgenis.auth.MolgenisRole.class, dummy);
			
			input.setLabel("role_");
			input.setDescription("role_");
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


