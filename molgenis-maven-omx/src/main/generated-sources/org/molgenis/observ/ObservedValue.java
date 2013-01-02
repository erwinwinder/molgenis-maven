
/* File:        org.molgenis.omx/model/ObservedValue.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.observ;

/**
 * ObservedValue: 
				Generic storage of values as part of one observation
				event. Values are atomatic observations,
				e.g.,
				length (feature) of
				individual 1 (valueset.target)
				= 179cm (value).
				Values can also be
				qualified by some characteristic,
				e.g., QTL
				p-value (feature)
				between
				phenotype 'leaf count'
				(characteristic) and
				marker 'PVV4'
				(valueset.target) =
				0.1^10+3 (value).
			
.
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "ObservedValue"
)


@javax.persistence.Inheritance(strategy=javax.persistence.InheritanceType.JOINED)
@javax.persistence.DiscriminatorColumn(name="DType", discriminatorType=javax.persistence.DiscriminatorType.STRING)
@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.observ.db.ObservedValueEntityListener.class})
public class ObservedValue extends org.molgenis.util.AbstractEntity implements org.molgenis.core.Autoid
{
	// fieldname constants
	public final static String ID = "id";
	public final static String __TYPE = "__Type";
	public final static String OBSERVATIONSET = "ObservationSet";
	public final static String OBSERVATIONSET_ID = "ObservationSet_id";
	public final static String FEATURE = "Feature";
	public final static String FEATURE_IDENTIFIER = "Feature_Identifier";
	public final static String CHARACTERISTIC = "Characteristic";
	public final static String CHARACTERISTIC_IDENTIFIER = "Characteristic_Identifier";
	public final static String VALUE = "Value";
	
	//static methods
	/**
	 * Shorthand for db.query(ObservedValue.class).
	 */
	public static org.molgenis.framework.db.Query<? extends ObservedValue> query(org.molgenis.framework.db.Database db)
	{
		return db.query(ObservedValue.class);
	}
	
	/**
	 * Shorthand for db.find(ObservedValue.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends ObservedValue> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(ObservedValue.class, rules);
	}	
	
	/**
	 * 
	 */
	public static ObservedValue findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<ObservedValue> q = db.query(ObservedValue.class);
		q.eq(ObservedValue.ID, id);
		java.util.List<ObservedValue> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//automatically generated internal id, only for internal use.[type=int]
    @javax.persistence.Id @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    @javax.persistence.Column(name="id", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="id")
	
	//@javax.validation.constraints.NotNull
	private Integer id =  null;


	//Subtypes have to be set to allow searching[type=enum]
	@javax.persistence.Column(name="DType", nullable=false)            
	@javax.xml.bind.annotation.XmlElement(name="__Type")
	
				

	@javax.validation.constraints.NotNull
	private String __Type =  null;
	@javax.persistence.Transient
	private String __Type_label = null;
	@javax.persistence.Transient
	private java.util.List<org.molgenis.util.ValueLabel> __Type_options = new java.util.ArrayList<org.molgenis.util.ValueLabel>();


	//Reference to the observation. For example a particular patient visit or the application of a microarray or the calculation of a QTL model[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="ObservationSet", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.observ.ObservationSet observationSet = null;
	@javax.persistence.Transient
	private Integer observationSet_id = null;	


	//References the ObservableFeature that this observation was made on. For example 'probe123'.[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Feature", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.observ.ObservableFeature feature = null;
	@javax.persistence.Transient
	private Integer feature_id = null;	
	@javax.persistence.Transient
	private String feature_Identifier = null;						


	//Is brother of [characteristic], or Average of [height][type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Characteristic")   	
	
				

	private org.molgenis.observ.Characteristic characteristic = null;
	@javax.persistence.Transient
	private Integer characteristic_id = null;	
	@javax.persistence.Transient
	private String characteristic_Identifier = null;						


	//The value observed[type=string]
	@javax.persistence.Column(name="Value")
	@javax.xml.bind.annotation.XmlElement(name="value")
	
				

	private String value =  null;

	//constructors
	public ObservedValue()
	{
		//set the type for a new instance
		set__Type(this.getClass().getSimpleName());
	
		//options for enum __Type
		__Type_options.add(new org.molgenis.util.ValueLabel("ObservedValue","ObservedValue"));
		__Type_options.add(new org.molgenis.util.ValueLabel("PhenotypeValue","PhenotypeValue"));
	}
	
	//getters and setters
	/**
	 * Get the automatically generated internal id, only for internal use..
	 * @return id.
	 */
	public Integer getId()
	{
		return this.id;
	}
	
	
	/**
	 * Set the automatically generated internal id, only for internal use..
	 * @param id
	 */
	public void setId( Integer id)
	{
		this.id = id;
	}

	

	/**
	 * Get the Subtypes have to be set to allow searching.
	 * @return __Type.
	 */
	public String get__Type()
	{
		return this.__Type;
	}
	
	@Deprecated
	public String get__Type(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Subtypes have to be set to allow searching.
	 * @param __Type
	 */
	public void set__Type( String __Type)
	{
		
		this.__Type = __Type;
	}

	
	/**
	 * Get tha label for enum __Type.
	 */
	public String get__TypeLabel()
	{
		return this.__Type_label;
	}
	
	/**
	 * __Type is enum. This method returns all available enum options.
	 */
	public java.util.List<org.molgenis.util.ValueLabel> get__TypeOptions()
	{
		return __Type_options;
	}	
	

	/**
	 * Get the Reference to the observation. For example a particular patient visit or the application of a microarray or the calculation of a QTL model.
	 * @return observationSet.
	 */
	public org.molgenis.observ.ObservationSet getObservationSet()
	{
		return this.observationSet;
	}
	
	@Deprecated
	public org.molgenis.observ.ObservationSet getObservationSet(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Reference to the observation. For example a particular patient visit or the application of a microarray or the calculation of a QTL model.
	 * @param observationSet
	 */
	public void setObservationSet( org.molgenis.observ.ObservationSet observationSet)
	{
		
		this.observationSet = observationSet;
	}

	
	
	/**
	 * Set foreign key for field observationSet.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setObservationSet_Id(Integer observationSet_id)
	{
		this.observationSet_id = observationSet_id;
	}	

	public void setObservationSet(Integer observationSet_id)
	{
		this.observationSet_id = observationSet_id;
	}
	
	public Integer getObservationSet_Id()
	{
		
		if(observationSet != null) 
		{
			return observationSet.getId();
		}
		else
		{
			return observationSet_id;
		}
	}	
	 
	 
	

	/**
	 * Get the References the ObservableFeature that this observation was made on. For example 'probe123'..
	 * @return feature.
	 */
	public org.molgenis.observ.ObservableFeature getFeature()
	{
		return this.feature;
	}
	
	@Deprecated
	public org.molgenis.observ.ObservableFeature getFeature(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the References the ObservableFeature that this observation was made on. For example 'probe123'..
	 * @param feature
	 */
	public void setFeature( org.molgenis.observ.ObservableFeature feature)
	{
		
		this.feature = feature;
	}

	
	
	/**
	 * Set foreign key for field feature.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setFeature_Id(Integer feature_id)
	{
		this.feature_id = feature_id;
	}	

	public void setFeature(Integer feature_id)
	{
		this.feature_id = feature_id;
	}
	
	public Integer getFeature_Id()
	{
		
		if(feature != null) 
		{
			return feature.getId();
		}
		else
		{
			return feature_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference Feature to ObservableFeature.Id.
	 */
	public String getFeature_Identifier()
	{		
		//FIXME should we auto-load based on getFeature()?	
		if(feature != null) {
			return feature.getIdentifier();
		} else {
			return feature_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Feature to <a href="ObservableFeature.html#Id">ObservableFeature.Id</a>.
	 * Implies setFeature(null) until save
	 */
	public void setFeature_Identifier(String feature_Identifier)
	{
		this.feature_Identifier = feature_Identifier;
	}		
	 
	

	/**
	 * Get the Is brother of [characteristic], or Average of [height].
	 * @return characteristic.
	 */
	public org.molgenis.observ.Characteristic getCharacteristic()
	{
		return this.characteristic;
	}
	
	@Deprecated
	public org.molgenis.observ.Characteristic getCharacteristic(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Is brother of [characteristic], or Average of [height].
	 * @param characteristic
	 */
	public void setCharacteristic( org.molgenis.observ.Characteristic characteristic)
	{
		
		this.characteristic = characteristic;
	}

	
	
	/**
	 * Set foreign key for field characteristic.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setCharacteristic_Id(Integer characteristic_id)
	{
		this.characteristic_id = characteristic_id;
	}	

	public void setCharacteristic(Integer characteristic_id)
	{
		this.characteristic_id = characteristic_id;
	}
	
	public Integer getCharacteristic_Id()
	{
		
		if(characteristic != null) 
		{
			return characteristic.getId();
		}
		else
		{
			return characteristic_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference Characteristic to Characteristic.Id.
	 */
	public String getCharacteristic_Identifier()
	{		
		//FIXME should we auto-load based on getCharacteristic()?	
		if(characteristic != null) {
			return characteristic.getIdentifier();
		} else {
			return characteristic_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Characteristic to <a href="Characteristic.html#Id">Characteristic.Id</a>.
	 * Implies setCharacteristic(null) until save
	 */
	public void setCharacteristic_Identifier(String characteristic_Identifier)
	{
		this.characteristic_Identifier = characteristic_Identifier;
	}		
	 
	

	/**
	 * Get the The value observed.
	 * @return value.
	 */
	public String getValue()
	{
		return this.value;
	}
	
	@Deprecated
	public String getValue(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the The value observed.
	 * @param value
	 */
	public void setValue( String value)
	{
		
		this.value = value;
	}

	


	/**
	 * Generic getter. Get the property by using the name.
	 */
	public Object get(String name)
	{
		name = name.toLowerCase();
		if (name.toLowerCase().equals("id"))
			return getId();
		if (name.toLowerCase().equals("__type"))
			return get__Type();
		if(name.toLowerCase().equals("__type_label"))
			return get__TypeLabel();
		if (name.toLowerCase().equals("observationset"))
			return getObservationSet();
		if(name.toLowerCase().equals("observationset_id"))
			return getObservationSet_Id();
		if (name.toLowerCase().equals("feature"))
			return getFeature();
		if(name.toLowerCase().equals("feature_id"))
			return getFeature_Id();
		if(name.toLowerCase().equals("feature_identifier"))
			return getFeature_Identifier();
		if (name.toLowerCase().equals("characteristic"))
			return getCharacteristic();
		if(name.toLowerCase().equals("characteristic_id"))
			return getCharacteristic_Id();
		if(name.toLowerCase().equals("characteristic_identifier"))
			return getCharacteristic_Identifier();
		if (name.toLowerCase().equals("value"))
			return getValue();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.get__Type() == null) throw new org.molgenis.framework.db.DatabaseException("required field __Type is null");
		if(this.getObservationSet() == null) throw new org.molgenis.framework.db.DatabaseException("required field observationSet is null");
		if(this.getFeature() == null) throw new org.molgenis.framework.db.DatabaseException("required field feature is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.util.Tuple tuple, boolean strict )  throws Exception
	{
		//optimization :-(
		if(tuple instanceof org.molgenis.util.ResultSetTuple)
		{
				//set Id
			this.setId(tuple.getInt("id"));
			//set __Type
			this.set__Type(tuple.getString("__Type"));
			//set ObservationSet
			this.setObservationSet(tuple.getInt("ObservationSet"));
			//set Feature
			this.setFeature(tuple.getInt("Feature"));
			//set label Identifier for xref field Feature
			this.setFeature_Identifier(tuple.getString("Feature_Identifier"));	
			//set Characteristic
			this.setCharacteristic(tuple.getInt("Characteristic"));
			//set label Identifier for xref field Characteristic
			this.setCharacteristic_Identifier(tuple.getString("Characteristic_Identifier"));	
			//set Value
			this.setValue(tuple.getString("Value"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("ObservedValue_id") != null) this.setId(tuple.getInt("ObservedValue_id"));
			//set __Type
			if( strict || tuple.getString("__Type") != null) this.set__Type(tuple.getString("__Type"));
			if( tuple.getString("ObservedValue___Type") != null) this.set__Type(tuple.getString("ObservedValue___Type"));
			//set ObservationSet
			if( strict || tuple.getInt("ObservationSet_id") != null) this.setObservationSet(tuple.getInt("ObservationSet_id"));
			if( tuple.getInt("ObservedValue_ObservationSet_id") != null) this.setObservationSet(tuple.getInt("ObservedValue_ObservationSet_id"));
			//alias of xref
			if( tuple.getObject("ObservationSet") != null) this.setObservationSet(tuple.getInt("ObservationSet"));
			if( tuple.getObject("ObservedValue_ObservationSet") != null) this.setObservationSet(tuple.getInt("ObservedValue_ObservationSet"));
			//set label for field ObservationSet
			//set Feature
			if( strict || tuple.getInt("Feature_id") != null) this.setFeature(tuple.getInt("Feature_id"));
			if( tuple.getInt("ObservedValue_Feature_id") != null) this.setFeature(tuple.getInt("ObservedValue_Feature_id"));
			//alias of xref
			if( tuple.getObject("Feature") != null) this.setFeature(tuple.getInt("Feature"));
			if( tuple.getObject("ObservedValue_Feature") != null) this.setFeature(tuple.getInt("ObservedValue_Feature"));
			//set label for field Feature
			if( strict || tuple.getObject("Feature_Identifier") != null) this.setFeature_Identifier(tuple.getString("Feature_Identifier"));			
			if( tuple.getObject("ObservedValue_Feature_Identifier") != null ) this.setFeature_Identifier(tuple.getString("ObservedValue_Feature_Identifier"));		
			//set Characteristic
			if( strict || tuple.getInt("Characteristic_id") != null) this.setCharacteristic(tuple.getInt("Characteristic_id"));
			if( tuple.getInt("ObservedValue_Characteristic_id") != null) this.setCharacteristic(tuple.getInt("ObservedValue_Characteristic_id"));
			//alias of xref
			if( tuple.getObject("Characteristic") != null) this.setCharacteristic(tuple.getInt("Characteristic"));
			if( tuple.getObject("ObservedValue_Characteristic") != null) this.setCharacteristic(tuple.getInt("ObservedValue_Characteristic"));
			//set label for field Characteristic
			if( strict || tuple.getObject("Characteristic_Identifier") != null) this.setCharacteristic_Identifier(tuple.getString("Characteristic_Identifier"));			
			if( tuple.getObject("ObservedValue_Characteristic_Identifier") != null ) this.setCharacteristic_Identifier(tuple.getString("ObservedValue_Characteristic_Identifier"));		
			//set Value
			if( strict || tuple.getString("Value") != null) this.setValue(tuple.getString("Value"));
			if( tuple.getString("ObservedValue_Value") != null) this.setValue(tuple.getString("ObservedValue_Value"));
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
		String result = "ObservedValue(";
		result+= "id='" + getId()+"' ";	
		result+= "__Type='" + get__Type()+"' ";	
		result+= " observationSet_id='" + getObservationSet_Id()+"' ";	
		result+= " feature_id='" + getFeature_Id()+"' ";	
		result+= " feature_identifier='" + getFeature_Identifier()+"' ";
		result+= " characteristic_id='" + getCharacteristic_Id()+"' ";	
		result+= " characteristic_identifier='" + getCharacteristic_Identifier()+"' ";
		result+= "value='" + getValue()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of ObservedValue.
	 */
	public java.util.Vector<String> getFields(boolean skipAutoIds)
	{
		java.util.Vector<String> fields = new java.util.Vector<String>();
		if(!skipAutoIds)
		{
			fields.add("id");
		}
		{
			fields.add("__Type");
		}
		{
			fields.add("observationSet_id");
		}
		{
			fields.add("feature_id");
		}
		fields.add("feature_identifier");
		{
			fields.add("characteristic_id");
		}
		fields.add("characteristic_identifier");
		{
			fields.add("value");
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
		result.add("id");
		return result;
	}

	@Deprecated
	public String getFields(String sep)
	{
		return (""
		+ "id" +sep
		+ "__Type" +sep
		+ "observationSet" +sep
		+ "feature" +sep
		+ "characteristic" +sep
		+ "value" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("observationSet")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("feature")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("characteristic")) {
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
		ObservedValue rhs = (ObservedValue) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
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
			Object valueO = getObservationSet();
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
			Object valueO = getFeature();
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
			Object valueO = getCharacteristic();
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
			Object valueO = getValue();
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
	public ObservedValue create(org.molgenis.util.Tuple tuple) throws Exception
	{
		ObservedValue e = new ObservedValue();
		e.set(tuple);
		return e;
	}
	

	
}

