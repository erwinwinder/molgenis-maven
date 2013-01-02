
/* File:        org.molgenis.omx/model/PhenotypeProperty.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.gwascentral;

/**
 * PhenotypeProperty: .
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "PhenotypeProperty", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "Identifier" } ) }
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.gwascentral.db.PhenotypePropertyEntityListener.class})
public class PhenotypeProperty extends org.molgenis.observ.ObservableFeature implements org.molgenis.core.Identifiable
{
	// fieldname constants
	public final static String ID = "id";
	public final static String IDENTIFIER = "Identifier";
	public final static String NAME = "Name";
	
	//static methods
	/**
	 * Shorthand for db.query(PhenotypeProperty.class).
	 */
	public static org.molgenis.framework.db.Query<? extends PhenotypeProperty> query(org.molgenis.framework.db.Database db)
	{
		return db.query(PhenotypeProperty.class);
	}
	
	/**
	 * Shorthand for db.find(PhenotypeProperty.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends PhenotypeProperty> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(PhenotypeProperty.class, rules);
	}	
	
	/**
	 * 
	 */
	public static PhenotypeProperty findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<PhenotypeProperty> q = db.query(PhenotypeProperty.class);
		q.eq(PhenotypeProperty.ID, id);
		java.util.List<PhenotypeProperty> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static PhenotypeProperty findByIdentifier(org.molgenis.framework.db.Database db, String identifier) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<PhenotypeProperty> q = db.query(PhenotypeProperty.class);
		q.eq(PhenotypeProperty.IDENTIFIER, identifier);
		java.util.List<PhenotypeProperty> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//automatically generated internal id, only for internal use.[type=int]
	


	//user supplied or automatically assigned (using a decorator) unique and short identifier, e.g. MA1234[type=string]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="Identifier", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="identifier")
	
				

	@javax.validation.constraints.NotNull
	private String identifier =  null;


	//Phenotype Property[type=string]
	@javax.persistence.Column(name="Name")
	@javax.xml.bind.annotation.XmlElement(name="name")
	
				

	private String name =  null;

	//constructors
	public PhenotypeProperty()
	{
		//set the type for a new instance
		set__Type(this.getClass().getSimpleName());
	
	}
	
	//getters and setters
	

	

	/**
	 * Get the user supplied or automatically assigned (using a decorator) unique and short identifier, e.g. MA1234.
	 * @return identifier.
	 */
	public String getIdentifier()
	{
		return this.identifier;
	}
	
	@Deprecated
	public String getIdentifier(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the user supplied or automatically assigned (using a decorator) unique and short identifier, e.g. MA1234.
	 * @param identifier
	 */
	public void setIdentifier( String identifier)
	{
				//hack to solve problem with variable hidden in supertype
				super.setIdentifier(identifier);
				//2222hack to solve problem with variable hidden in supertype
				super.setIdentifier(identifier);
		
		this.identifier = identifier;
	}

	

	/**
	 * Get the Phenotype Property.
	 * @return name.
	 */
	public String getName()
	{
		return this.name;
	}
	
	@Deprecated
	public String getName(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Phenotype Property.
	 * @param name
	 */
	public void setName( String name)
	{
				//hack to solve problem with variable hidden in supertype
				super.setName(name);
				//2222hack to solve problem with variable hidden in supertype
				super.setName(name);
		
		this.name = name;
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
		if (name.toLowerCase().equals("unit"))
			return getUnit();
		if(name.toLowerCase().equals("unit_id"))
			return getUnit_Id();
		if(name.toLowerCase().equals("unit_identifier"))
			return getUnit_Identifier();
		if (name.toLowerCase().equals("datatype"))
			return getDataType();
		if(name.toLowerCase().equals("datatype_label"))
			return getDataTypeLabel();
		if (name.toLowerCase().equals("temporal"))
			return getTemporal();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getIdentifier() == null) throw new org.molgenis.framework.db.DatabaseException("required field identifier is null");
		if(this.get__Type() == null) throw new org.molgenis.framework.db.DatabaseException("required field __Type is null");
		if(this.getDataType() == null) throw new org.molgenis.framework.db.DatabaseException("required field dataType is null");
		if(this.getTemporal() == null) throw new org.molgenis.framework.db.DatabaseException("required field temporal is null");
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
			//set Unit
			this.setUnit(tuple.getInt("unit"));
			//set label Identifier for xref field Unit
			this.setUnit_Identifier(tuple.getString("unit_Identifier"));	
			//set DataType
			this.setDataType(tuple.getString("dataType"));
			//set Temporal
			this.setTemporal(tuple.getBoolean("temporal"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("PhenotypeProperty_id") != null) this.setId(tuple.getInt("PhenotypeProperty_id"));
			//set Identifier
			if( strict || tuple.getString("Identifier") != null) this.setIdentifier(tuple.getString("Identifier"));
			if( tuple.getString("PhenotypeProperty_Identifier") != null) this.setIdentifier(tuple.getString("PhenotypeProperty_Identifier"));
			//set Name
			if( strict || tuple.getString("Name") != null) this.setName(tuple.getString("Name"));
			if( tuple.getString("PhenotypeProperty_Name") != null) this.setName(tuple.getString("PhenotypeProperty_Name"));
			//set __Type
			if( strict || tuple.getString("__Type") != null) this.set__Type(tuple.getString("__Type"));
			if( tuple.getString("PhenotypeProperty___Type") != null) this.set__Type(tuple.getString("PhenotypeProperty___Type"));
			//set Description
			if( strict || tuple.getString("description") != null) this.setDescription(tuple.getString("description"));
			if( tuple.getString("PhenotypeProperty_description") != null) this.setDescription(tuple.getString("PhenotypeProperty_description"));
			//set Unit
			if( strict || tuple.getInt("unit_id") != null) this.setUnit(tuple.getInt("unit_id"));
			if( tuple.getInt("PhenotypeProperty_unit_id") != null) this.setUnit(tuple.getInt("PhenotypeProperty_unit_id"));
			//alias of xref
			if( tuple.getObject("unit") != null) this.setUnit(tuple.getInt("unit"));
			if( tuple.getObject("PhenotypeProperty_unit") != null) this.setUnit(tuple.getInt("PhenotypeProperty_unit"));
			//set label for field Unit
			if( strict || tuple.getObject("unit_Identifier") != null) this.setUnit_Identifier(tuple.getString("unit_Identifier"));			
			if( tuple.getObject("PhenotypeProperty_unit_Identifier") != null ) this.setUnit_Identifier(tuple.getString("PhenotypeProperty_unit_Identifier"));		
			//set DataType
			if( strict || tuple.getString("dataType") != null) this.setDataType(tuple.getString("dataType"));
			if( tuple.getString("PhenotypeProperty_dataType") != null) this.setDataType(tuple.getString("PhenotypeProperty_dataType"));
			//set Temporal
			if( strict || tuple.getBoolean("temporal") != null) this.setTemporal(tuple.getBoolean("temporal"));
			if( tuple.getBoolean("PhenotypeProperty_temporal") != null) this.setTemporal(tuple.getBoolean("PhenotypeProperty_temporal"));
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
		String result = "PhenotypeProperty(";
		result+= "id='" + getId()+"' ";	
		result+= "identifier='" + getIdentifier()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= "__Type='" + get__Type()+"' ";	
		result+= "description='" + getDescription()+"' ";	
		result+= " unit_id='" + getUnit_Id()+"' ";	
		result+= " unit_identifier='" + getUnit_Identifier()+"' ";
		result+= "dataType='" + getDataType()+"' ";	
		result+= "temporal='" + getTemporal()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of PhenotypeProperty.
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
			fields.add("unit_id");
		}
		fields.add("unit_identifier");
		{
			fields.add("dataType");
		}
		{
			fields.add("temporal");
		}
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
		+ "unit" +sep
		+ "dataType" +sep
		+ "temporal" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("unit")) {
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
		PhenotypeProperty rhs = (PhenotypeProperty) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
             	.appendSuper(super.equals(obj))
		//identifier
				.append(identifier, rhs.getIdentifier())
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
				.append(identifier)
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
			Object valueO = getUnit();
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
			Object valueO = getDataType();
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
			Object valueO = getTemporal();
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
	public PhenotypeProperty create(org.molgenis.util.Tuple tuple) throws Exception
	{
		PhenotypeProperty e = new PhenotypeProperty();
		e.set(tuple);
		return e;
	}
	
//2
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="phenotypePropertyID"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.gwascentral.PhenotypeMethod> phenotypePropertyIDPhenotypeMethodCollection = new java.util.ArrayList<org.molgenis.gwascentral.PhenotypeMethod>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.gwascentral.PhenotypeMethod> getPhenotypePropertyIDPhenotypeMethodCollection()
	{
            return phenotypePropertyIDPhenotypeMethodCollection;
	}

    public void setPhenotypePropertyIDPhenotypeMethodCollection(java.util.Collection<org.molgenis.gwascentral.PhenotypeMethod> collection)
    {
        for (org.molgenis.gwascentral.PhenotypeMethod phenotypeMethod : collection) {
            phenotypeMethod.setPhenotypePropertyID(this);
        }
        phenotypePropertyIDPhenotypeMethodCollection = collection;
    }	
//2
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="phenotypePropertyID"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.gwascentral.PhenotypeValue> phenotypePropertyIDPhenotypeValueCollection = new java.util.ArrayList<org.molgenis.gwascentral.PhenotypeValue>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.gwascentral.PhenotypeValue> getPhenotypePropertyIDPhenotypeValueCollection()
	{
            return phenotypePropertyIDPhenotypeValueCollection;
	}

    public void setPhenotypePropertyIDPhenotypeValueCollection(java.util.Collection<org.molgenis.gwascentral.PhenotypeValue> collection)
    {
        for (org.molgenis.gwascentral.PhenotypeValue phenotypeValue : collection) {
            phenotypeValue.setPhenotypePropertyID(this);
        }
        phenotypePropertyIDPhenotypeValueCollection = collection;
    }	

	
}

