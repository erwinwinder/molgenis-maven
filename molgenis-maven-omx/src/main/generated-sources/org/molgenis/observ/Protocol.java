
/* File:        org.molgenis/model/Protocol.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.observ;

/**
 * Protocol: 
				The Protocol class defines parameterizable descriptions
				of
				(analysis)methods. Examples of protocols are: Questionaires, SOPs,
				Assay platforms, Statistical analyses, etc.
				Each protocol has a
				unique identifier.
				Protocol has an association to OntologyTerm to
				represent the type of
				protocol.
			
.
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "Protocol"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.observ.db.ProtocolEntityListener.class})
public class Protocol extends org.molgenis.observ.Characteristic 
{
	// fieldname constants
	public final static String PROTOCOLTYPE = "ProtocolType";
	public final static String PROTOCOLTYPE_IDENTIFIER = "ProtocolType_Identifier";
	public final static String SUBPROTOCOLS = "subprotocols";
	public final static String SUBPROTOCOLS_IDENTIFIER = "subprotocols_Identifier";
	public final static String FEATURES = "Features";
	public final static String FEATURES_IDENTIFIER = "Features_Identifier";
	public final static String ID = "id";
	
	//static methods
	/**
	 * Shorthand for db.query(Protocol.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Protocol> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Protocol.class);
	}
	
	/**
	 * Shorthand for db.find(Protocol.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Protocol> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Protocol.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Protocol findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Protocol> q = db.query(Protocol.class);
		q.eq(Protocol.ID, id);
		java.util.List<Protocol> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Protocol findByIdentifier(org.molgenis.framework.db.Database db, String identifier) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Protocol> q = db.query(Protocol.class);
		q.eq(Protocol.IDENTIFIER, identifier);
		java.util.List<Protocol> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//classification of protocol[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="ProtocolType")   	
	
				

	private org.molgenis.observ.target.OntologyTerm protocolType = null;
	@javax.persistence.Transient
	private Integer protocolType_id = null;	
	@javax.persistence.Transient
	private String protocolType_Identifier = null;						


	//Subprotocols of this protocol[type=mref]
    @javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="subprotocols", insertable=true, updatable=true, nullable=true)
	@javax.persistence.JoinTable(name="Protocol_subprotocols", 
			joinColumns=@javax.persistence.JoinColumn(name="Protocol"), inverseJoinColumns=@javax.persistence.JoinColumn(name="subprotocols"))
	
				

	private java.util.List<org.molgenis.observ.Protocol> subprotocols = new java.util.ArrayList<org.molgenis.observ.Protocol>();
	@javax.persistence.Transient
	private java.util.List<Integer> subprotocols_id = new java.util.ArrayList<Integer>();		
	@javax.persistence.Transient
	private java.util.List<String> subprotocols_Identifier = new java.util.ArrayList<String>();


	//parameters (in/out) that are used or produced by this protocol.[type=mref]
    @javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Features", insertable=true, updatable=true, nullable=true)
	@javax.persistence.JoinTable(name="Protocol_Features", 
			joinColumns=@javax.persistence.JoinColumn(name="Protocol"), inverseJoinColumns=@javax.persistence.JoinColumn(name="Features"))
	
				

	private java.util.List<org.molgenis.observ.ObservableFeature> features = new java.util.ArrayList<org.molgenis.observ.ObservableFeature>();
	@javax.persistence.Transient
	private java.util.List<Integer> features_id = new java.util.ArrayList<Integer>();		
	@javax.persistence.Transient
	private java.util.List<String> features_Identifier = new java.util.ArrayList<String>();


	//automatically generated internal id, only for internal use.[type=int]
	

	//constructors
	public Protocol()
	{
		//set the type for a new instance
		set__Type(this.getClass().getSimpleName());
	
	}
	
	//getters and setters
	/**
	 * Get the classification of protocol.
	 * @return protocolType.
	 */
	public org.molgenis.observ.target.OntologyTerm getProtocolType()
	{
		return this.protocolType;
	}
	
	@Deprecated
	public org.molgenis.observ.target.OntologyTerm getProtocolType(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the classification of protocol.
	 * @param protocolType
	 */
	public void setProtocolType( org.molgenis.observ.target.OntologyTerm protocolType)
	{
		
		this.protocolType = protocolType;
	}

	
	
	/**
	 * Set foreign key for field protocolType.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setProtocolType_Id(Integer protocolType_id)
	{
		this.protocolType_id = protocolType_id;
	}	

	public void setProtocolType(Integer protocolType_id)
	{
		this.protocolType_id = protocolType_id;
	}
	
	public Integer getProtocolType_Id()
	{
		
		if(protocolType != null) 
		{
			return protocolType.getId();
		}
		else
		{
			return protocolType_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference ProtocolType to OntologyTerm.Id.
	 */
	public String getProtocolType_Identifier()
	{		
		//FIXME should we auto-load based on getProtocolType()?	
		if(protocolType != null) {
			return protocolType.getIdentifier();
		} else {
			return protocolType_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference ProtocolType to <a href="OntologyTerm.html#Id">OntologyTerm.Id</a>.
	 * Implies setProtocolType(null) until save
	 */
	public void setProtocolType_Identifier(String protocolType_Identifier)
	{
		this.protocolType_Identifier = protocolType_Identifier;
	}		
	 
	

	/**
	 * Get the Subprotocols of this protocol.
	 * @return subprotocols.
	 */
	public java.util.List<org.molgenis.observ.Protocol> getSubprotocols()
	{
		return this.subprotocols;
	}
	
	@Deprecated
	public java.util.List<org.molgenis.observ.Protocol> getSubprotocols(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Subprotocols of this protocol.
	 * @param subprotocols
	 */
	public void setSubprotocols( java.util.List<org.molgenis.observ.Protocol> subprotocols)
	{
		
		this.subprotocols = subprotocols;
	}

	
	public void setSubprotocols_Id(Integer ... subprotocols)
	{
		this.setSubprotocols_Id(java.util.Arrays.asList(subprotocols));
	}	
	
	public void setSubprotocols(org.molgenis.observ.Protocol ... subprotocols)
	{
		this.setSubprotocols(java.util.Arrays.asList(subprotocols));
	}	
	
	/**
	 * Set foreign key for field subprotocols.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setSubprotocols_Id(java.util.List<Integer> subprotocols_id)
	{
		this.subprotocols_id = subprotocols_id;
	}	
	
	public java.util.List<Integer> getSubprotocols_Id()
	{
		return subprotocols_id;
	}	
	
	/**
	 * Get a pretty label for cross reference Subprotocols to <a href="Protocol.html#Id">Protocol.Id</a>.
	 */
	public java.util.List<String> getSubprotocols_Identifier()
	{
		return subprotocols_Identifier;
	}
	
	/**
	 * Update the foreign key Subprotocols
	 * This sets subprotocols to null until next database transaction.
	 */
	public void setSubprotocols_Identifier(java.util.List<String> subprotocols_Identifier)
	{
		this.subprotocols_Identifier = subprotocols_Identifier;
	}		
	

	/**
	 * Get the parameters (in/out) that are used or produced by this protocol..
	 * @return features.
	 */
	public java.util.List<org.molgenis.observ.ObservableFeature> getFeatures()
	{
		return this.features;
	}
	
	@Deprecated
	public java.util.List<org.molgenis.observ.ObservableFeature> getFeatures(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the parameters (in/out) that are used or produced by this protocol..
	 * @param features
	 */
	public void setFeatures( java.util.List<org.molgenis.observ.ObservableFeature> features)
	{
		
		this.features = features;
	}

	
	public void setFeatures_Id(Integer ... features)
	{
		this.setFeatures_Id(java.util.Arrays.asList(features));
	}	
	
	public void setFeatures(org.molgenis.observ.ObservableFeature ... features)
	{
		this.setFeatures(java.util.Arrays.asList(features));
	}	
	
	/**
	 * Set foreign key for field features.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setFeatures_Id(java.util.List<Integer> features_id)
	{
		this.features_id = features_id;
	}	
	
	public java.util.List<Integer> getFeatures_Id()
	{
		return features_id;
	}	
	
	/**
	 * Get a pretty label for cross reference Features to <a href="ObservableFeature.html#Id">ObservableFeature.Id</a>.
	 */
	public java.util.List<String> getFeatures_Identifier()
	{
		return features_Identifier;
	}
	
	/**
	 * Update the foreign key Features
	 * This sets features to null until next database transaction.
	 */
	public void setFeatures_Identifier(java.util.List<String> features_Identifier)
	{
		this.features_Identifier = features_Identifier;
	}		
	

	

	


	/**
	 * Generic getter. Get the property by using the name.
	 */
	public Object get(String name)
	{
		name = name.toLowerCase();
		if (name.toLowerCase().equals("id"))
			return getId();
		if (name.toLowerCase().equals("identifier"))
			return getIdentifier();
		if (name.toLowerCase().equals("name"))
			return getName();
		if (name.toLowerCase().equals("__type"))
			return get__Type();
		if(name.toLowerCase().equals("__type_label"))
			return get__TypeLabel();
		if (name.toLowerCase().equals("description"))
			return getDescription();
		if (name.toLowerCase().equals("protocoltype"))
			return getProtocolType();
		if(name.toLowerCase().equals("protocoltype_id"))
			return getProtocolType_Id();
		if(name.toLowerCase().equals("protocoltype_identifier"))
			return getProtocolType_Identifier();
		if (name.toLowerCase().equals("subprotocols"))
			return getSubprotocols();
		if(name.toLowerCase().equals("subprotocols_id"))
			return getSubprotocols_Id();
		if(name.toLowerCase().equals("subprotocols_identifier"))
			return getSubprotocols_Identifier();
		if (name.toLowerCase().equals("features"))
			return getFeatures();
		if(name.toLowerCase().equals("features_id"))
			return getFeatures_Id();
		if(name.toLowerCase().equals("features_identifier"))
			return getFeatures_Identifier();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getIdentifier() == null) throw new org.molgenis.framework.db.DatabaseException("required field identifier is null");
		if(this.getName() == null) throw new org.molgenis.framework.db.DatabaseException("required field name is null");
		if(this.get__Type() == null) throw new org.molgenis.framework.db.DatabaseException("required field __Type is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.util.Tuple tuple, boolean strict )  throws Exception
	{
		//optimization :-(
		if(tuple instanceof org.molgenis.util.ResultSetTuple)
		{
				//set Id
			this.setId(tuple.getInt("id"));
			//set Identifier
			this.setIdentifier(tuple.getString("Identifier"));
			//set Name
			this.setName(tuple.getString("Name"));
			//set __Type
			this.set__Type(tuple.getString("__Type"));
			//set Description
			this.setDescription(tuple.getString("description"));
			//set ProtocolType
			this.setProtocolType(tuple.getInt("ProtocolType"));
			//set label Identifier for xref field ProtocolType
			this.setProtocolType_Identifier(tuple.getString("ProtocolType_Identifier"));	
			//mrefs can not be directly retrieved
			//set Subprotocols			
			//mrefs can not be directly retrieved
			//set Features			
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("Protocol_id") != null) this.setId(tuple.getInt("Protocol_id"));
			//set Identifier
			if( strict || tuple.getString("Identifier") != null) this.setIdentifier(tuple.getString("Identifier"));
			if( tuple.getString("Protocol_Identifier") != null) this.setIdentifier(tuple.getString("Protocol_Identifier"));
			//set Name
			if( strict || tuple.getString("Name") != null) this.setName(tuple.getString("Name"));
			if( tuple.getString("Protocol_Name") != null) this.setName(tuple.getString("Protocol_Name"));
			//set __Type
			if( strict || tuple.getString("__Type") != null) this.set__Type(tuple.getString("__Type"));
			if( tuple.getString("Protocol___Type") != null) this.set__Type(tuple.getString("Protocol___Type"));
			//set Description
			if( strict || tuple.getString("description") != null) this.setDescription(tuple.getString("description"));
			if( tuple.getString("Protocol_description") != null) this.setDescription(tuple.getString("Protocol_description"));
			//set ProtocolType
			if( strict || tuple.getInt("ProtocolType_id") != null) this.setProtocolType(tuple.getInt("ProtocolType_id"));
			if( tuple.getInt("Protocol_ProtocolType_id") != null) this.setProtocolType(tuple.getInt("Protocol_ProtocolType_id"));
			//alias of xref
			if( tuple.getObject("ProtocolType") != null) this.setProtocolType(tuple.getInt("ProtocolType"));
			if( tuple.getObject("Protocol_ProtocolType") != null) this.setProtocolType(tuple.getInt("Protocol_ProtocolType"));
			//set label for field ProtocolType
			if( strict || tuple.getObject("ProtocolType_Identifier") != null) this.setProtocolType_Identifier(tuple.getString("ProtocolType_Identifier"));			
			if( tuple.getObject("Protocol_ProtocolType_Identifier") != null ) this.setProtocolType_Identifier(tuple.getString("Protocol_ProtocolType_Identifier"));		
			//set Subprotocols
			if( tuple.getObject("subprotocols")!= null || tuple.getObject("Protocol_subprotocols")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("subprotocols");
				if(tuple.getObject("Protocol_subprotocols")!= null) mrefs = tuple.getList("Protocol_subprotocols");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setSubprotocols_Id( values );
			}
			//set labels Identifier for mref field Subprotocols	
			if( tuple.getObject("subprotocols_Identifier")!= null || tuple.getObject("Protocol_subprotocols_Identifier")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("subprotocols_Identifier");
				if(tuple.getObject("Protocol_subprotocols_Identifier")!= null) mrefs = tuple.getList("Protocol_subprotocols_Identifier");
				
				if(mrefs != null) 
					for(Object ref: mrefs)
					{
						String[] refs = ref.toString().split("\\|");
						for(String r : refs) {
							values.add(r);	
						}						
					}							
				this.setSubprotocols_Identifier( values );			
			}	
			//set Features
			if( tuple.getObject("Features")!= null || tuple.getObject("Protocol_Features")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("Features");
				if(tuple.getObject("Protocol_Features")!= null) mrefs = tuple.getList("Protocol_Features");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setFeatures_Id( values );
			}
			//set labels Identifier for mref field Features	
			if( tuple.getObject("Features_Identifier")!= null || tuple.getObject("Protocol_Features_Identifier")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("Features_Identifier");
				if(tuple.getObject("Protocol_Features_Identifier")!= null) mrefs = tuple.getList("Protocol_Features_Identifier");
				
				if(mrefs != null) 
					for(Object ref: mrefs)
					{
						String[] refs = ref.toString().split("\\|");
						for(String r : refs) {
							values.add(r);	
						}						
					}							
				this.setFeatures_Identifier( values );			
			}	
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
		String result = "Protocol(";
		result+= "id='" + getId()+"' ";	
		result+= "identifier='" + getIdentifier()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= "__Type='" + get__Type()+"' ";	
		result+= "description='" + getDescription()+"' ";	
		result+= " protocolType_id='" + getProtocolType_Id()+"' ";	
		result+= " protocolType_identifier='" + getProtocolType_Identifier()+"' ";
		result+= " subprotocols_id='" + getSubprotocols_Id()+"' ";	
		result+= " subprotocols_identifier='" + getSubprotocols_Identifier()+"' ";
		result+= " features_id='" + getFeatures_Id()+"' ";	
		result+= " features_identifier='" + getFeatures_Identifier()+"' ";
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Protocol.
	 */
	public java.util.Vector<String> getFields(boolean skipAutoIds)
	{
		java.util.Vector<String> fields = new java.util.Vector<String>();
		if(!skipAutoIds)
		{
			fields.add("id");
		}
		{
			fields.add("identifier");
		}
		{
			fields.add("name");
		}
		{
			fields.add("__Type");
		}
		{
			fields.add("description");
		}
		{
			fields.add("protocolType_id");
		}
		fields.add("protocolType_identifier");
		{
			fields.add("subprotocols_id");
		}
		fields.add("subprotocols_identifier");
		{
			fields.add("features_id");
		}
		fields.add("features_identifier");
		return fields;
	}	

	public java.util.Vector<String> getFields()
	{
		return getFields(false);
	}

	@Override
	public String getIdField()
	{
		return "id";
	}
	

	
	@Override
	public java.util.List<String> getLabelFields()
	{
		java.util.List<String> result = new java.util.ArrayList<String>();
		result.add("Identifier");
		return result;
	}

	@Deprecated
	public String getFields(String sep)
	{
		return (""
		+ "id" +sep
		+ "identifier" +sep
		+ "name" +sep
		+ "__Type" +sep
		+ "description" +sep
		+ "protocolType" +sep
		+ "subprotocols" +sep
		+ "features" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("protocolType")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("subprotocols")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("features")) {
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
		Protocol rhs = (Protocol) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
             	.appendSuper(super.equals(obj))
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
             	.appendSuper(super.hashCode())
   			.toHashCode();
    }  	
  	


	@Deprecated
	public String getValues(String sep)
	{
		java.io.StringWriter out = new java.io.StringWriter();
		{
			Object valueO = getId();
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
			Object valueO = getIdentifier();
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
			Object valueO = getName();
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
			Object valueO = get__Type();
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
			Object valueO = getDescription();
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
			Object valueO = getProtocolType();
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
			Object valueO = getFeatures();
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
	public Protocol create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Protocol e = new Protocol();
		e.set(tuple);
		return e;
	}
	
//5
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="protocolUsed"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.observ.DataSet> protocolUsedDataSetCollection = new java.util.ArrayList<org.molgenis.observ.DataSet>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.observ.DataSet> getProtocolUsedDataSetCollection()
	{
            return protocolUsedDataSetCollection;
	}

    public void setProtocolUsedDataSetCollection(java.util.Collection<org.molgenis.observ.DataSet> collection)
    {
        for (org.molgenis.observ.DataSet dataSet : collection) {
            dataSet.setProtocolUsed(this);
        }
        protocolUsedDataSetCollection = collection;
    }	
	//5
    @javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="subprotocols"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.observ.Protocol> subprotocolsProtocolCollection = new java.util.ArrayList<org.molgenis.observ.Protocol>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.observ.Protocol> getSubprotocolsProtocolCollection()
	{
        return subprotocolsProtocolCollection;
	}

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.observ.Protocol> getSubprotocolsProtocolCollection(org.molgenis.framework.db.Database db)
	{
        return getSubprotocolsProtocolCollection();
	}

    public void setSubprotocolsProtocolCollection(java.util.Collection<org.molgenis.observ.Protocol> collection)
    {
    	subprotocolsProtocolCollection.addAll(collection);
    }	

	
}

