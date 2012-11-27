
/* File:        org.molgenis/model/Protocol_subprotocols.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.observ;

/**
 * Protocol_subprotocols: Link table for many-to-many relationship 'Protocol.subprotocols'..
 * @author MOLGENIS generator
 */
@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.observ.db.Protocol_SubprotocolsEntityListener.class})
public class Protocol_Subprotocols extends org.molgenis.util.AbstractEntity 
{
	// fieldname constants
	public final static String AUTOID = "autoid";
	public final static String SUBPROTOCOLS = "subprotocols";
	public final static String SUBPROTOCOLS_IDENTIFIER = "subprotocols_Identifier";
	public final static String PROTOCOL = "Protocol";
	public final static String PROTOCOL_IDENTIFIER = "Protocol_Identifier";
	
	//static methods
	/**
	 * Shorthand for db.query(Protocol_Subprotocols.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Protocol_Subprotocols> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Protocol_Subprotocols.class);
	}
	
	/**
	 * Shorthand for db.find(Protocol_Subprotocols.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Protocol_Subprotocols> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Protocol_Subprotocols.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Protocol_Subprotocols findByAutoid(org.molgenis.framework.db.Database db, Integer autoid) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Protocol_Subprotocols> q = db.query(Protocol_Subprotocols.class);
		q.eq(Protocol_Subprotocols.AUTOID, autoid);
		java.util.List<Protocol_Subprotocols> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Protocol_Subprotocols findBySubprotocolsProtocol(org.molgenis.framework.db.Database db, Integer subprotocols, Integer protocol) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Protocol_Subprotocols> q = db.query(Protocol_Subprotocols.class);
		q.eq(Protocol_Subprotocols.SUBPROTOCOLS, subprotocols);q.eq(Protocol_Subprotocols.PROTOCOL, protocol);
		java.util.List<Protocol_Subprotocols> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//automatic id field to ensure ordering of mrefs[type=int]
    @javax.persistence.Id @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    @javax.persistence.Column(name="autoid", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="autoid")
	
	//@javax.validation.constraints.NotNull
	private Integer autoid =  null;


	//[type=xref]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="subprotocols", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.observ.Protocol subprotocols = null;
	@javax.persistence.Transient
	private Integer subprotocols_id = null;	
	@javax.persistence.Transient
	private String subprotocols_Identifier = null;						


	//[type=xref]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Protocol", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.observ.Protocol protocol = null;
	@javax.persistence.Transient
	private Integer protocol_id = null;	
	@javax.persistence.Transient
	private String protocol_Identifier = null;						

	//constructors
	public Protocol_Subprotocols()
	{
	
	}
	
	//getters and setters
	/**
	 * Get the automatic id field to ensure ordering of mrefs.
	 * @return autoid.
	 */
	public Integer getAutoid()
	{
		return this.autoid;
	}
	
	
	/**
	 * Set the automatic id field to ensure ordering of mrefs.
	 * @param autoid
	 */
	public void setAutoid( Integer autoid)
	{
		this.autoid = autoid;
	}

	

	/**
	 * Get the .
	 * @return subprotocols.
	 */
	public org.molgenis.observ.Protocol getSubprotocols()
	{
		return this.subprotocols;
	}
	
	@Deprecated
	public org.molgenis.observ.Protocol getSubprotocols(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the .
	 * @param subprotocols
	 */
	public void setSubprotocols( org.molgenis.observ.Protocol subprotocols)
	{
		
		this.subprotocols = subprotocols;
	}

	
	
	/**
	 * Set foreign key for field subprotocols.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setSubprotocols_Id(Integer subprotocols_id)
	{
		this.subprotocols_id = subprotocols_id;
	}	

	public void setSubprotocols(Integer subprotocols_id)
	{
		this.subprotocols_id = subprotocols_id;
	}
	
	public Integer getSubprotocols_Id()
	{
		
		if(subprotocols != null) 
		{
			return subprotocols.getId();
		}
		else
		{
			return subprotocols_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference Subprotocols to Protocol.Id.
	 */
	public String getSubprotocols_Identifier()
	{		
		//FIXME should we auto-load based on getSubprotocols()?	
		if(subprotocols != null) {
			return subprotocols.getIdentifier();
		} else {
			return subprotocols_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Subprotocols to <a href="Protocol.html#Id">Protocol.Id</a>.
	 * Implies setSubprotocols(null) until save
	 */
	public void setSubprotocols_Identifier(String subprotocols_Identifier)
	{
		this.subprotocols_Identifier = subprotocols_Identifier;
	}		
	 
	

	/**
	 * Get the .
	 * @return protocol.
	 */
	public org.molgenis.observ.Protocol getProtocol()
	{
		return this.protocol;
	}
	
	@Deprecated
	public org.molgenis.observ.Protocol getProtocol(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the .
	 * @param protocol
	 */
	public void setProtocol( org.molgenis.observ.Protocol protocol)
	{
		
		this.protocol = protocol;
	}

	
	
	/**
	 * Set foreign key for field protocol.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setProtocol_Id(Integer protocol_id)
	{
		this.protocol_id = protocol_id;
	}	

	public void setProtocol(Integer protocol_id)
	{
		this.protocol_id = protocol_id;
	}
	
	public Integer getProtocol_Id()
	{
		
		if(protocol != null) 
		{
			return protocol.getId();
		}
		else
		{
			return protocol_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference Protocol to Protocol.Id.
	 */
	public String getProtocol_Identifier()
	{		
		//FIXME should we auto-load based on getProtocol()?	
		if(protocol != null) {
			return protocol.getIdentifier();
		} else {
			return protocol_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Protocol to <a href="Protocol.html#Id">Protocol.Id</a>.
	 * Implies setProtocol(null) until save
	 */
	public void setProtocol_Identifier(String protocol_Identifier)
	{
		this.protocol_Identifier = protocol_Identifier;
	}		
	 
	


	/**
	 * Generic getter. Get the property by using the name.
	 */
	public Object get(String name)
	{
		name = name.toLowerCase();
		if (name.toLowerCase().equals("autoid"))
			return getAutoid();
		if (name.toLowerCase().equals("subprotocols"))
			return getSubprotocols();
		if(name.toLowerCase().equals("subprotocols_id"))
			return getSubprotocols_Id();
		if(name.toLowerCase().equals("subprotocols_identifier"))
			return getSubprotocols_Identifier();
		if (name.toLowerCase().equals("protocol"))
			return getProtocol();
		if(name.toLowerCase().equals("protocol_id"))
			return getProtocol_Id();
		if(name.toLowerCase().equals("protocol_identifier"))
			return getProtocol_Identifier();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getAutoid() == null) throw new org.molgenis.framework.db.DatabaseException("required field autoid is null");
		if(this.getSubprotocols() == null) throw new org.molgenis.framework.db.DatabaseException("required field subprotocols is null");
		if(this.getProtocol() == null) throw new org.molgenis.framework.db.DatabaseException("required field protocol is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.util.Tuple tuple, boolean strict )  throws Exception
	{
		//optimization :-(
		if(tuple instanceof org.molgenis.util.ResultSetTuple)
		{
				//set Autoid
			this.setAutoid(tuple.getInt("autoid"));
			//set Subprotocols
			this.setSubprotocols(tuple.getInt("subprotocols"));
			//set label Identifier for xref field Subprotocols
			this.setSubprotocols_Identifier(tuple.getString("subprotocols_Identifier"));	
			//set Protocol
			this.setProtocol(tuple.getInt("Protocol"));
			//set label Identifier for xref field Protocol
			this.setProtocol_Identifier(tuple.getString("Protocol_Identifier"));	
		}
		else if(tuple != null)
		{
			//set Autoid
			if( strict || tuple.getInt("autoid") != null) this.setAutoid(tuple.getInt("autoid"));
			if( tuple.getInt("Protocol_subprotocols_autoid") != null) this.setAutoid(tuple.getInt("Protocol_subprotocols_autoid"));
			//set Subprotocols
			if( strict || tuple.getInt("subprotocols_id") != null) this.setSubprotocols(tuple.getInt("subprotocols_id"));
			if( tuple.getInt("Protocol_subprotocols_subprotocols_id") != null) this.setSubprotocols(tuple.getInt("Protocol_subprotocols_subprotocols_id"));
			//alias of xref
			if( tuple.getObject("subprotocols") != null) this.setSubprotocols(tuple.getInt("subprotocols"));
			if( tuple.getObject("Protocol_subprotocols_subprotocols") != null) this.setSubprotocols(tuple.getInt("Protocol_subprotocols_subprotocols"));
			//set label for field Subprotocols
			if( strict || tuple.getObject("subprotocols_Identifier") != null) this.setSubprotocols_Identifier(tuple.getString("subprotocols_Identifier"));			
			if( tuple.getObject("Protocol_subprotocols_subprotocols_Identifier") != null ) this.setSubprotocols_Identifier(tuple.getString("Protocol_subprotocols_subprotocols_Identifier"));		
			//set Protocol
			if( strict || tuple.getInt("Protocol_id") != null) this.setProtocol(tuple.getInt("Protocol_id"));
			if( tuple.getInt("Protocol_subprotocols_Protocol_id") != null) this.setProtocol(tuple.getInt("Protocol_subprotocols_Protocol_id"));
			//alias of xref
			if( tuple.getObject("Protocol") != null) this.setProtocol(tuple.getInt("Protocol"));
			if( tuple.getObject("Protocol_subprotocols_Protocol") != null) this.setProtocol(tuple.getInt("Protocol_subprotocols_Protocol"));
			//set label for field Protocol
			if( strict || tuple.getObject("Protocol_Identifier") != null) this.setProtocol_Identifier(tuple.getString("Protocol_Identifier"));			
			if( tuple.getObject("Protocol_subprotocols_Protocol_Identifier") != null ) this.setProtocol_Identifier(tuple.getString("Protocol_subprotocols_Protocol_Identifier"));		
		}
		//org.apache.log4j.Logger.getLogger("test").debug("set "+this);
	}
	
	
	
	

	@Override
	public String toString()
	{
		return this.toString(false);
	}
	
	public String toString(boolean verbose)
	{
		String result = "Protocol_Subprotocols(";
		result+= "autoid='" + getAutoid()+"' ";	
		result+= " subprotocols_id='" + getSubprotocols_Id()+"' ";	
		result+= " subprotocols_identifier='" + getSubprotocols_Identifier()+"' ";
		result+= " protocol_id='" + getProtocol_Id()+"' ";	
		result+= " protocol_identifier='" + getProtocol_Identifier()+"' ";
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Protocol_Subprotocols.
	 */
	public java.util.Vector<String> getFields(boolean skipAutoIds)
	{
		java.util.Vector<String> fields = new java.util.Vector<String>();
		if(!skipAutoIds)
		{
			fields.add("autoid");
		}
		{
			fields.add("subprotocols_id");
		}
		fields.add("subprotocols_identifier");
		{
			fields.add("protocol_id");
		}
		fields.add("protocol_identifier");
		return fields;
	}	

	public java.util.Vector<String> getFields()
	{
		return getFields(false);
	}

	@Override
	public String getIdField()
	{
		return "autoid";
	}
	

	
	@Override
	public java.util.List<String> getLabelFields()
	{
		java.util.List<String> result = new java.util.ArrayList<String>();
		result.add("subprotocols");
		result.add("Protocol");
		return result;
	}

	@Deprecated
	public String getFields(String sep)
	{
		return (""
		+ "autoid" +sep
		+ "subprotocols" +sep
		+ "protocol" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("subprotocols")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("protocol")) {
            return "id";
        }
        
        return null;
    }	

	@Override
	public boolean equals(Object obj) {
   		if (obj == null) { return false; }
   		if (obj == this) { return true; }
   		if (obj.getClass() != getClass()) {
     		return false;
   		}
		Protocol_Subprotocols rhs = (Protocol_Subprotocols) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
		//subprotocols
		//protocol
                .isEquals();
  	}

  	@Override
    public int hashCode() {
    	int firstNumber = this.getClass().getName().hashCode();
    	int secondNumber = this.getClass().getSimpleName().hashCode();
    	if(firstNumber % 2 == 0) {
    	  firstNumber += 1;
    	}
    	if(secondNumber % 2 == 0) {
    		secondNumber += 1;
    	}
    
		return new org.apache.commons.lang.builder.HashCodeBuilder(firstNumber, secondNumber)
   			.toHashCode();
    }  	
  	


	@Deprecated
	public String getValues(String sep)
	{
		java.io.StringWriter out = new java.io.StringWriter();
		{
			Object valueO = getAutoid();
			String valueS;
			if (valueO != null)
				valueS = valueO.toString();
			else 
				valueS = "";
			valueS = valueS.replaceAll("\r\n"," ").replaceAll("\n"," ").replaceAll("\r"," ");
			valueS = valueS.replaceAll("\t"," ").replaceAll(sep," ");
			out.write(valueS+sep);
		}
		{
			Object valueO = getSubprotocols();
			String valueS;
			if (valueO != null)
				valueS = valueO.toString();
			else 
				valueS = "";
			valueS = valueS.replaceAll("\r\n"," ").replaceAll("\n"," ").replaceAll("\r"," ");
			valueS = valueS.replaceAll("\t"," ").replaceAll(sep," ");
			out.write(valueS+sep);
		}
		{
			Object valueO = getProtocol();
			String valueS;
			if (valueO != null)
				valueS = valueO.toString();
			else 
				valueS = "";
			valueS = valueS.replaceAll("\r\n"," ").replaceAll("\n"," ").replaceAll("\r"," ");
			valueS = valueS.replaceAll("\t"," ").replaceAll(sep," ");
			out.write(valueS);
		}
		return out.toString();
	}
	
	@Override
	public Protocol_Subprotocols create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Protocol_Subprotocols e = new Protocol_Subprotocols();
		e.set(tuple);
		return e;
	}
	

	
}

