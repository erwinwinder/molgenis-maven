
/* File:        Org.molgenis/html/MolgenisPermission.java
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


import org.molgenis.auth.MolgenisRole;
import org.molgenis.core.MolgenisEntity;
import org.molgenis.auth.MolgenisPermission;


/**
 * A HtmlForm that is preloaded with all inputs for entity MolgenisPermission
 * @see EntityForm
 */
public class MolgenisPermissionForm extends EntityForm<MolgenisPermission>
{
	
	public MolgenisPermissionForm()
	{
		super();
	}
	
	public MolgenisPermissionForm(MolgenisPermission entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<MolgenisPermission> getEntityClass()
	{
		return MolgenisPermission.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("role_");
		headers.add("entity");
		headers.add("permission");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=MolgenisPermission, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("MolgenisPermission_id",getEntity().getId());
			
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
		//Role: Field(entity=MolgenisPermission, name=role_, type=xref[MolgenisRole.id], xref_label='name', auto=false, nillable=false, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<MolgenisPermission> input = new XrefInput<MolgenisPermission>("MolgenisPermission_role_", getEntity().getRole());
			//create xref dummy object
			MolgenisRole dummy = null;
			if(getEntity().getRole_Id() != null)
			{
			 	dummy = new MolgenisRole();
				dummy.setId(getEntity().getRole_Id());
				dummy.setName( getEntity().getRole_Name() ); 
			}
			XrefInput<MolgenisRole> input = new XrefInput<MolgenisRole>("MolgenisPermission_role_", org.molgenis.auth.MolgenisRole.class, dummy);
			
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
		//Entity: Field(entity=MolgenisPermission, name=entity, type=xref[MolgenisEntity.id], xref_label='className', auto=false, nillable=false, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<MolgenisPermission> input = new XrefInput<MolgenisPermission>("MolgenisPermission_entity", getEntity().getEntity());
			//create xref dummy object
			MolgenisEntity dummy = null;
			if(getEntity().getEntity_Id() != null)
			{
			 	dummy = new MolgenisEntity();
				dummy.setId(getEntity().getEntity_Id());
				dummy.setClassName( getEntity().getEntity_ClassName() ); 
			}
			XrefInput<MolgenisEntity> input = new XrefInput<MolgenisEntity>("MolgenisPermission_entity", org.molgenis.core.MolgenisEntity.class, dummy);
			
			input.setLabel("entity");
			input.setDescription("entity");
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
		//Permission: Field(entity=MolgenisPermission, name=permission, type=enum, auto=false, nillable=false, readonly=false, default=, enum_options=[read, write, own])
		{
			EnumInput input = new EnumInput("MolgenisPermission_permission",getEntity().getPermission());
			
			input.setLabel("permission");
			input.setDescription("permission");
			input.setNillable(false);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			input.setOptions(getEntity().getPermissionOptions());
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


