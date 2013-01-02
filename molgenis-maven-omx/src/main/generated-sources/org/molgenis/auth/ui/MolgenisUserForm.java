
/* File:        Org.molgenis.omx/html/MolgenisUser.java
 * Copyright:   GBIC 2000-2013, all rights reserved
 * Date:        January 2, 2013
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


import org.molgenis.auth.MolgenisUser;


/**
 * A HtmlForm that is preloaded with all inputs for entity MolgenisUser
 * @see EntityForm
 */
public class MolgenisUserForm extends EntityForm<MolgenisUser>
{
	
	public MolgenisUserForm()
	{
		super();
	}
	
	public MolgenisUserForm(MolgenisUser entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<MolgenisUser> getEntityClass()
	{
		return MolgenisUser.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("username");
		headers.add("password_");
		headers.add("activationCode");
		headers.add("active");
		headers.add("superuser");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=MolgenisUser, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("MolgenisUser_id",getEntity().getId());
			
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
		//Username: Field(entity=MolgenisUser, name=username, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("MolgenisUser_username",getEntity().getUsername());
			
			input.setLabel("username");
			input.setDescription("username");
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
		//Password: Field(entity=MolgenisUser, name=password_, type=string[255], auto=false, nillable=false, readonly=false, default=secret)
		{
			StringInput input = new StringInput("MolgenisUser_password_",getEntity().getPassword());
			
			input.setLabel("password_");
			input.setDescription("big fixme: password type");
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
		//ActivationCode: Field(entity=MolgenisUser, name=activationCode, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("MolgenisUser_activationCode",getEntity().getActivationCode());
			
			input.setLabel("activationCode");
			input.setDescription("Used as alternative authentication mechanism to verify user email and/or if user has lost password.");
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
		//Active: Field(entity=MolgenisUser, name=active, type=bool, auto=false, nillable=false, readonly=false, default=false)
		{
			BoolInput input = new BoolInput("MolgenisUser_active",getEntity().getActive());
			
			input.setLabel("active");
			input.setDescription("Boolean to indicate if this account can be used to login");
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
		//Superuser: Field(entity=MolgenisUser, name=superuser, type=bool, auto=false, nillable=false, readonly=false, default=false)
		{
			BoolInput input = new BoolInput("MolgenisUser_superuser",getEntity().getSuperuser());
			
			input.setLabel("superuser");
			input.setDescription("superuser");
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


