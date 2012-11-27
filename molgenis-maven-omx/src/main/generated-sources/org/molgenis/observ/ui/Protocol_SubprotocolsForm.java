
/* File:        Org.molgenis/html/Protocol_subprotocols.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 26, 2012
 * 
 * generator:   org.molgenis.generators.ui.HtmlFormGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
package org.molgenis.observ.ui;

// jdk
import java.util.Vector;
import java.util.List;
import java.util.ArrayList;


// molgenis
import org.molgenis.framework.ui.html.*;


import org.molgenis.observ.Protocol;
import org.molgenis.observ.Protocol_Subprotocols;


/**
 * A HtmlForm that is preloaded with all inputs for entity Protocol_Subprotocols
 * @see EntityForm
 */
public class Protocol_SubprotocolsForm extends EntityForm<Protocol_Subprotocols>
{
	
	public Protocol_SubprotocolsForm()
	{
		super();
	}
	
	public Protocol_SubprotocolsForm(Protocol_Subprotocols entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<Protocol_Subprotocols> getEntityClass()
	{
		return Protocol_Subprotocols.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("subprotocols");
		headers.add("Protocol");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Autoid: Field(entity=Protocol_subprotocols, name=autoid, type=int, auto=true, nillable=false, readonly=false, default=null)
		{
			IntInput input = new IntInput("Protocol_subprotocols_autoid",getEntity().getAutoid());
			
			input.setLabel("autoid");
			input.setDescription("automatic id field to ensure ordering of mrefs");
			input.setNillable(false);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			input.setHidden(!isNewRecord());
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//Subprotocols: Field(entity=Protocol_subprotocols, name=subprotocols, type=xref[Protocol.id], xref_label='Identifier', auto=false, nillable=false, readonly=false, default=null)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<Protocol_Subprotocols> input = new XrefInput<Protocol_Subprotocols>("Protocol_subprotocols_subprotocols", getEntity().getSubprotocols());
			//create xref dummy object
			Protocol dummy = null;
			if(getEntity().getSubprotocols_Id() != null)
			{
			 	dummy = new Protocol();
				dummy.setId(getEntity().getSubprotocols_Id());
				dummy.setIdentifier( getEntity().getSubprotocols_Identifier() ); 
			}
			XrefInput<Protocol> input = new XrefInput<Protocol>("Protocol_subprotocols_subprotocols", org.molgenis.observ.Protocol.class, dummy);
			
			input.setLabel("subprotocols");
			input.setDescription("");
			input.setNillable(false);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(!isNewRecord());
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//Protocol: Field(entity=Protocol_subprotocols, name=Protocol, type=xref[Protocol.id], xref_label=, auto=false, nillable=false, readonly=false, default=null)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput<Protocol_Subprotocols> input = new XrefInput<Protocol_Subprotocols>("Protocol_subprotocols_Protocol", getEntity().getProtocol());
			//create xref dummy object
			Protocol dummy = null;
			if(getEntity().getProtocol_Id() != null)
			{
			 	dummy = new Protocol();
				dummy.setId(getEntity().getProtocol_Id());
				dummy.setIdentifier( getEntity().getProtocol_Identifier() ); 
			}
			XrefInput<Protocol> input = new XrefInput<Protocol>("Protocol_subprotocols_Protocol", org.molgenis.observ.Protocol.class, dummy);
			
			input.setLabel("Protocol");
			input.setDescription("");
			input.setNillable(false);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(!isNewRecord());
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


