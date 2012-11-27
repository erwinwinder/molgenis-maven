
/* File:        Org.molgenis/html/MolgenisEntity.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 26, 2012
 * 
 * generator:   org.molgenis.generators.ui.HtmlFormGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
package org.molgenis.core.ui;

// jdk
import java.util.Vector;
import java.util.List;
import java.util.ArrayList;


// molgenis
import org.molgenis.framework.ui.html.*;


import org.molgenis.core.MolgenisEntity;


/**
 * A HtmlForm that is preloaded with all inputs for entity MolgenisEntity
 * @see EntityForm
 */
public class MolgenisEntityForm extends EntityForm<MolgenisEntity>
{
	
	public MolgenisEntityForm()
	{
		super();
	}
	
	public MolgenisEntityForm(MolgenisEntity entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<MolgenisEntity> getEntityClass()
	{
		return MolgenisEntity.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("name");
		headers.add("type_");
		headers.add("className");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=MolgenisEntity, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("MolgenisEntity_id",getEntity().getId());
			
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
		//Name: Field(entity=MolgenisEntity, name=name, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("MolgenisEntity_name",getEntity().getName());
			
			input.setLabel("name");
			input.setDescription("Name of the entity");
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
		//Type: Field(entity=MolgenisEntity, name=type_, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("MolgenisEntity_type_",getEntity().getType());
			
			input.setLabel("type_");
			input.setDescription("Type of the entity");
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
		//ClassName: Field(entity=MolgenisEntity, name=className, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("MolgenisEntity_className",getEntity().getClassName());
			
			input.setLabel("className");
			input.setDescription("Full name of the entity");
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

		return inputs;
	}
}


