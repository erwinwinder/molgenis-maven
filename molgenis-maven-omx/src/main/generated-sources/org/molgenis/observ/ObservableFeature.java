
/* File:        org.molgenis.omx/model/ObservableFeature.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.observ;

/**
 * ObservableFeature: 
				ObservableFeature defines anything that can be observed.
				<p/>
				In other words, ObservableFeature are the
				questions asked, e.g. 'What
				is Height?', 'What is Systolic blood
				pressure?', or 'Has blue eyes?'.
				<p/>
				Some questions may
				be repeated for multiple characteristics. For
				example 'What is [MarkerAllele]
				observed?' can be applied to all
				elements of a MarkerSet, and 'What
				is [medicin codes] uses' can be
				applied to a set of Medicine codes. This can be specified using the
				measuredCharacteristic field.
				<p/>
				The identifier of ObservableFeature is globally
				unique. It is
				recommended that
				each
				ObservableFeature is named
				according to a
				well-defined ontology
				term or database accession.
			
.
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "ObservableFeature"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.observ.db.ObservableFeatureEntityListener.class})
public class ObservableFeature extends org.molgenis.observ.Characteristic 
{
	// fieldname constants
	public final static String UNIT = "unit";
	public final static String UNIT_IDENTIFIER = "unit_Identifier";
	public final static String DATATYPE = "dataType";
	public final static String TEMPORAL = "temporal";
	public final static String ID = "id";
	
	//static methods
	/**
	 * Shorthand for db.query(ObservableFeature.class).
	 */
	public static org.molgenis.framework.db.Query<? extends ObservableFeature> query(org.molgenis.framework.db.Database db)
	{
		return db.query(ObservableFeature.class);
	}
	
	/**
	 * Shorthand for db.find(ObservableFeature.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends ObservableFeature> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(ObservableFeature.class, rules);
	}	
	
	/**
	 * 
	 */
	public static ObservableFeature findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<ObservableFeature> q = db.query(ObservableFeature.class);
		q.eq(ObservableFeature.ID, id);
		java.util.List<ObservableFeature> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static ObservableFeature findByIdentifier(org.molgenis.framework.db.Database db, String identifier) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<ObservableFeature> q = db.query(ObservableFeature.class);
		q.eq(ObservableFeature.IDENTIFIER, identifier);
		java.util.List<ObservableFeature> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//(Optional) Reference to the well-defined measurement unit used to observe this feature       (if feature is that concrete). E.g. mmHg[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="unit")   	
	
				

	private org.molgenis.observ.target.OntologyTerm unit = null;
	@javax.persistence.Transient
	private Integer unit_id = null;	
	@javax.persistence.Transient
	private String unit_Identifier = null;						


	//(Optional) Reference to the technical data type. E.g. 'int'[type=enum]
	@javax.persistence.Column(name="dataType", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="dataType")
	
				

	@javax.validation.constraints.NotNull
	private String dataType =  "string";
	@javax.persistence.Transient
	private String dataType_label = null;
	@javax.persistence.Transient
	private java.util.List<org.molgenis.util.ValueLabel> dataType_options = new java.util.ArrayList<org.molgenis.util.ValueLabel>();


	//Whether this feature is time dependent and can have different values when measured       on different times (e.g. weight, temporal=true) or generally only measured once (e.g. birth date,       temporal=false)[type=bool]
	@javax.persistence.Column(name="temporal", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="temporal")
	
				

	@javax.validation.constraints.NotNull
	private Boolean temporal =  false;


	//automatically generated internal id, only for internal use.[type=int]
	

	//constructors
	public ObservableFeature()
	{
		//set the type for a new instance
		set__Type(this.getClass().getSimpleName());
	
		//options for enum DataType
		dataType_options.add(new org.molgenis.util.ValueLabel("xref","xref"));
		dataType_options.add(new org.molgenis.util.ValueLabel("string","string"));
		dataType_options.add(new org.molgenis.util.ValueLabel("categorical","categorical"));
		dataType_options.add(new org.molgenis.util.ValueLabel("nominal","nominal"));
		dataType_options.add(new org.molgenis.util.ValueLabel("ordinal","ordinal"));
		dataType_options.add(new org.molgenis.util.ValueLabel("date","date"));
		dataType_options.add(new org.molgenis.util.ValueLabel("datetime","datetime"));
		dataType_options.add(new org.molgenis.util.ValueLabel("int","int"));
		dataType_options.add(new org.molgenis.util.ValueLabel("code","code"));
		dataType_options.add(new org.molgenis.util.ValueLabel("image","image"));
		dataType_options.add(new org.molgenis.util.ValueLabel("decimal","decimal"));
		dataType_options.add(new org.molgenis.util.ValueLabel("bool","bool"));
		dataType_options.add(new org.molgenis.util.ValueLabel("file","file"));
		dataType_options.add(new org.molgenis.util.ValueLabel("log","log"));
		dataType_options.add(new org.molgenis.util.ValueLabel("data","data"));
		dataType_options.add(new org.molgenis.util.ValueLabel("exe","exe"));
	}
	
	//getters and setters
	/**
	 * Get the (Optional) Reference to the well-defined measurement unit used to observe this feature       (if feature is that concrete). E.g. mmHg.
	 * @return unit.
	 */
	public org.molgenis.observ.target.OntologyTerm getUnit()
	{
		return this.unit;
	}
	
	@Deprecated
	public org.molgenis.observ.target.OntologyTerm getUnit(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the (Optional) Reference to the well-defined measurement unit used to observe this feature       (if feature is that concrete). E.g. mmHg.
	 * @param unit
	 */
	public void setUnit( org.molgenis.observ.target.OntologyTerm unit)
	{
		
		this.unit = unit;
	}

	
	
	/**
	 * Set foreign key for field unit.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setUnit_Id(Integer unit_id)
	{
		this.unit_id = unit_id;
	}	

	public void setUnit(Integer unit_id)
	{
		this.unit_id = unit_id;
	}
	
	public Integer getUnit_Id()
	{
		
		if(unit != null) 
		{
			return unit.getId();
		}
		else
		{
			return unit_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference Unit to OntologyTerm.Id.
	 */
	public String getUnit_Identifier()
	{		
		//FIXME should we auto-load based on getUnit()?	
		if(unit != null) {
			return unit.getIdentifier();
		} else {
			return unit_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Unit to <a href="OntologyTerm.html#Id">OntologyTerm.Id</a>.
	 * Implies setUnit(null) until save
	 */
	public void setUnit_Identifier(String unit_Identifier)
	{
		this.unit_Identifier = unit_Identifier;
	}		
	 
	

	/**
	 * Get the (Optional) Reference to the technical data type. E.g. 'int'.
	 * @return dataType.
	 */
	public String getDataType()
	{
		return this.dataType;
	}
	
	@Deprecated
	public String getDataType(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the (Optional) Reference to the technical data type. E.g. 'int'.
	 * @param dataType
	 */
	public void setDataType( String dataType)
	{
		
		this.dataType = dataType;
	}

	
	/**
	 * Get tha label for enum DataType.
	 */
	public String getDataTypeLabel()
	{
		return this.dataType_label;
	}
	
	/**
	 * DataType is enum. This method returns all available enum options.
	 */
	public java.util.List<org.molgenis.util.ValueLabel> getDataTypeOptions()
	{
		return dataType_options;
	}	
	

	/**
	 * Get the Whether this feature is time dependent and can have different values when measured       on different times (e.g. weight, temporal=true) or generally only measured once (e.g. birth date,       temporal=false).
	 * @return temporal.
	 */
	public Boolean getTemporal()
	{
		return this.temporal;
	}
	
	@Deprecated
	public Boolean getTemporal(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Whether this feature is time dependent and can have different values when measured       on different times (e.g. weight, temporal=true) or generally only measured once (e.g. birth date,       temporal=false).
	 * @param temporal
	 */
	public void setTemporal( Boolean temporal)
	{
		
		this.temporal = temporal;
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
		if(this.getName() == null) throw new org.molgenis.framework.db.DatabaseException("required field name is null");
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
			if( tuple.getInt("ObservableFeature_id") != null) this.setId(tuple.getInt("ObservableFeature_id"));
			//set Identifier
			if( strict || tuple.getString("Identifier") != null) this.setIdentifier(tuple.getString("Identifier"));
			if( tuple.getString("ObservableFeature_Identifier") != null) this.setIdentifier(tuple.getString("ObservableFeature_Identifier"));
			//set Name
			if( strict || tuple.getString("Name") != null) this.setName(tuple.getString("Name"));
			if( tuple.getString("ObservableFeature_Name") != null) this.setName(tuple.getString("ObservableFeature_Name"));
			//set __Type
			if( strict || tuple.getString("__Type") != null) this.set__Type(tuple.getString("__Type"));
			if( tuple.getString("ObservableFeature___Type") != null) this.set__Type(tuple.getString("ObservableFeature___Type"));
			//set Description
			if( strict || tuple.getString("description") != null) this.setDescription(tuple.getString("description"));
			if( tuple.getString("ObservableFeature_description") != null) this.setDescription(tuple.getString("ObservableFeature_description"));
			//set Unit
			if( strict || tuple.getInt("unit_id") != null) this.setUnit(tuple.getInt("unit_id"));
			if( tuple.getInt("ObservableFeature_unit_id") != null) this.setUnit(tuple.getInt("ObservableFeature_unit_id"));
			//alias of xref
			if( tuple.getObject("unit") != null) this.setUnit(tuple.getInt("unit"));
			if( tuple.getObject("ObservableFeature_unit") != null) this.setUnit(tuple.getInt("ObservableFeature_unit"));
			//set label for field Unit
			if( strict || tuple.getObject("unit_Identifier") != null) this.setUnit_Identifier(tuple.getString("unit_Identifier"));			
			if( tuple.getObject("ObservableFeature_unit_Identifier") != null ) this.setUnit_Identifier(tuple.getString("ObservableFeature_unit_Identifier"));		
			//set DataType
			if( strict || tuple.getString("dataType") != null) this.setDataType(tuple.getString("dataType"));
			if( tuple.getString("ObservableFeature_dataType") != null) this.setDataType(tuple.getString("ObservableFeature_dataType"));
			//set Temporal
			if( strict || tuple.getBoolean("temporal") != null) this.setTemporal(tuple.getBoolean("temporal"));
			if( tuple.getBoolean("ObservableFeature_temporal") != null) this.setTemporal(tuple.getBoolean("ObservableFeature_temporal"));
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
		String result = "ObservableFeature(";
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
	 * Get the names of all public properties of ObservableFeature.
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
		ObservableFeature rhs = (ObservableFeature) obj;
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
	public ObservableFeature create(org.molgenis.util.Tuple tuple) throws Exception
	{
		ObservableFeature e = new ObservableFeature();
		e.set(tuple);
		return e;
	}
	
//4
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="observableFeature"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.observ.Category> observableFeatureCategoryCollection = new java.util.ArrayList<org.molgenis.observ.Category>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.observ.Category> getObservableFeatureCategoryCollection()
	{
            return observableFeatureCategoryCollection;
	}

    public void setObservableFeatureCategoryCollection(java.util.Collection<org.molgenis.observ.Category> collection)
    {
        for (org.molgenis.observ.Category category : collection) {
            category.setObservableFeature(this);
        }
        observableFeatureCategoryCollection = collection;
    }	
//4
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="feature"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.observ.ObservedValue> featureObservedValueCollection = new java.util.ArrayList<org.molgenis.observ.ObservedValue>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.observ.ObservedValue> getFeatureObservedValueCollection()
	{
            return featureObservedValueCollection;
	}

    public void setFeatureObservedValueCollection(java.util.Collection<org.molgenis.observ.ObservedValue> collection)
    {
        for (org.molgenis.observ.ObservedValue observedValue : collection) {
            observedValue.setFeature(this);
        }
        featureObservedValueCollection = collection;
    }	
	//4
    @javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="features"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.observ.Protocol> featuresProtocolCollection = new java.util.ArrayList<org.molgenis.observ.Protocol>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.observ.Protocol> getFeaturesProtocolCollection()
	{
        return featuresProtocolCollection;
	}

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.observ.Protocol> getFeaturesProtocolCollection(org.molgenis.framework.db.Database db)
	{
        return getFeaturesProtocolCollection();
	}

    public void setFeaturesProtocolCollection(java.util.Collection<org.molgenis.observ.Protocol> collection)
    {
    	featuresProtocolCollection.addAll(collection);
    }	

	
}

