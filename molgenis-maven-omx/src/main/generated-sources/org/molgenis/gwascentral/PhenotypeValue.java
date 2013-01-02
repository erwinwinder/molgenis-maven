
/* File:        org.molgenis.omx/model/PhenotypeValue.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.gwascentral;

/**
 * PhenotypeValue: .
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "PhenotypeValue", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "Identifier" } ) }
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.gwascentral.db.PhenotypeValueEntityListener.class})
public class PhenotypeValue extends org.molgenis.observ.ObservedValue implements org.molgenis.core.Identifiable
{
	// fieldname constants
	public final static String ID = "id";
	public final static String IDENTIFIER = "Identifier";
	public final static String NAME = "Name";
	public final static String PHENOTYPEPROPERTYID = "PhenotypePropertyID";
	public final static String PHENOTYPEPROPERTYID_IDENTIFIER = "PhenotypePropertyID_Identifier";
	public final static String VALUE = "Value";
	public final static String VALUERANK = "ValueRank";
	public final static String VALUEISMEAN = "ValueIsMean";
	public final static String STD = "STD";
	public final static String MIN = "Min";
	public final static String MAX = "Max";
	
	//static methods
	/**
	 * Shorthand for db.query(PhenotypeValue.class).
	 */
	public static org.molgenis.framework.db.Query<? extends PhenotypeValue> query(org.molgenis.framework.db.Database db)
	{
		return db.query(PhenotypeValue.class);
	}
	
	/**
	 * Shorthand for db.find(PhenotypeValue.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends PhenotypeValue> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(PhenotypeValue.class, rules);
	}	
	
	/**
	 * 
	 */
	public static PhenotypeValue findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<PhenotypeValue> q = db.query(PhenotypeValue.class);
		q.eq(PhenotypeValue.ID, id);
		java.util.List<PhenotypeValue> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static PhenotypeValue findByIdentifier(org.molgenis.framework.db.Database db, String identifier) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<PhenotypeValue> q = db.query(PhenotypeValue.class);
		q.eq(PhenotypeValue.IDENTIFIER, identifier);
		java.util.List<PhenotypeValue> result = q.find();
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


	//Name[type=string]
	@javax.persistence.Column(name="Name")
	@javax.xml.bind.annotation.XmlElement(name="name")
	
				

	private String name =  null;


	//Phenotype property name[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="PhenotypePropertyID", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.gwascentral.PhenotypeProperty phenotypePropertyID = null;
	@javax.persistence.Transient
	private Integer phenotypePropertyID_id = null;	
	@javax.persistence.Transient
	private String phenotypePropertyID_Identifier = null;						


	//Value[type=string]
	@javax.persistence.Column(name="Value", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="value")
	
				

	@javax.validation.constraints.NotNull
	private String value =  null;


	//Value Rank[type=string]
	@javax.persistence.Column(name="ValueRank", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="valueRank")
	
				

	@javax.validation.constraints.NotNull
	private String valueRank =  null;


	//Value is mean[type=string]
	@javax.persistence.Column(name="ValueIsMean", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="valueIsMean")
	
				

	@javax.validation.constraints.NotNull
	private String valueIsMean =  null;


	//Standard Deviation[type=string]
	@javax.persistence.Column(name="STD", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="sTD")
	
				

	@javax.validation.constraints.NotNull
	private String sTD =  null;


	//Minimum value[type=string]
	@javax.persistence.Column(name="Min", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="min")
	
				

	@javax.validation.constraints.NotNull
	private String min =  null;


	//Maximum value[type=string]
	@javax.persistence.Column(name="Max", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="max")
	
				

	@javax.validation.constraints.NotNull
	private String max =  null;

	//constructors
	public PhenotypeValue()
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
		
		this.identifier = identifier;
	}

	

	/**
	 * Get the Name.
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
	 * Set the Name.
	 * @param name
	 */
	public void setName( String name)
	{
		
		this.name = name;
	}

	

	/**
	 * Get the Phenotype property name.
	 * @return phenotypePropertyID.
	 */
	public org.molgenis.gwascentral.PhenotypeProperty getPhenotypePropertyID()
	{
		return this.phenotypePropertyID;
	}
	
	@Deprecated
	public org.molgenis.gwascentral.PhenotypeProperty getPhenotypePropertyID(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Phenotype property name.
	 * @param phenotypePropertyID
	 */
	public void setPhenotypePropertyID( org.molgenis.gwascentral.PhenotypeProperty phenotypePropertyID)
	{
		
		this.phenotypePropertyID = phenotypePropertyID;
	}

	
	
	/**
	 * Set foreign key for field phenotypePropertyID.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setPhenotypePropertyID_Id(Integer phenotypePropertyID_id)
	{
		this.phenotypePropertyID_id = phenotypePropertyID_id;
	}	

	public void setPhenotypePropertyID(Integer phenotypePropertyID_id)
	{
		this.phenotypePropertyID_id = phenotypePropertyID_id;
	}
	
	public Integer getPhenotypePropertyID_Id()
	{
		
		if(phenotypePropertyID != null) 
		{
			return phenotypePropertyID.getId();
		}
		else
		{
			return phenotypePropertyID_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference PhenotypePropertyID to PhenotypeProperty.Id.
	 */
	public String getPhenotypePropertyID_Identifier()
	{		
		//FIXME should we auto-load based on getPhenotypePropertyID()?	
		if(phenotypePropertyID != null) {
			return phenotypePropertyID.getIdentifier();
		} else {
			return phenotypePropertyID_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference PhenotypePropertyID to <a href="PhenotypeProperty.html#Id">PhenotypeProperty.Id</a>.
	 * Implies setPhenotypePropertyID(null) until save
	 */
	public void setPhenotypePropertyID_Identifier(String phenotypePropertyID_Identifier)
	{
		this.phenotypePropertyID_Identifier = phenotypePropertyID_Identifier;
	}		
	 
	

	/**
	 * Get the Value.
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
	 * Set the Value.
	 * @param value
	 */
	public void setValue( String value)
	{
				//hack to solve problem with variable hidden in supertype
				super.setValue(value);
				//2222hack to solve problem with variable hidden in supertype
				super.setValue(value);
		
		this.value = value;
	}

	

	/**
	 * Get the Value Rank.
	 * @return valueRank.
	 */
	public String getValueRank()
	{
		return this.valueRank;
	}
	
	@Deprecated
	public String getValueRank(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Value Rank.
	 * @param valueRank
	 */
	public void setValueRank( String valueRank)
	{
		
		this.valueRank = valueRank;
	}

	

	/**
	 * Get the Value is mean.
	 * @return valueIsMean.
	 */
	public String getValueIsMean()
	{
		return this.valueIsMean;
	}
	
	@Deprecated
	public String getValueIsMean(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Value is mean.
	 * @param valueIsMean
	 */
	public void setValueIsMean( String valueIsMean)
	{
		
		this.valueIsMean = valueIsMean;
	}

	

	/**
	 * Get the Standard Deviation.
	 * @return sTD.
	 */
	public String getSTD()
	{
		return this.sTD;
	}
	
	@Deprecated
	public String getSTD(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Standard Deviation.
	 * @param sTD
	 */
	public void setSTD( String sTD)
	{
		
		this.sTD = sTD;
	}

	

	/**
	 * Get the Minimum value.
	 * @return min.
	 */
	public String getMin()
	{
		return this.min;
	}
	
	@Deprecated
	public String getMin(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Minimum value.
	 * @param min
	 */
	public void setMin( String min)
	{
		
		this.min = min;
	}

	

	/**
	 * Get the Maximum value.
	 * @return max.
	 */
	public String getMax()
	{
		return this.max;
	}
	
	@Deprecated
	public String getMax(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Maximum value.
	 * @param max
	 */
	public void setMax( String max)
	{
		
		this.max = max;
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
		if (name.toLowerCase().equals("identifier"))
			return getIdentifier();
		if (name.toLowerCase().equals("name"))
			return getName();
		if (name.toLowerCase().equals("phenotypepropertyid"))
			return getPhenotypePropertyID();
		if(name.toLowerCase().equals("phenotypepropertyid_id"))
			return getPhenotypePropertyID_Id();
		if(name.toLowerCase().equals("phenotypepropertyid_identifier"))
			return getPhenotypePropertyID_Identifier();
		if (name.toLowerCase().equals("valuerank"))
			return getValueRank();
		if (name.toLowerCase().equals("valueismean"))
			return getValueIsMean();
		if (name.toLowerCase().equals("std"))
			return getSTD();
		if (name.toLowerCase().equals("min"))
			return getMin();
		if (name.toLowerCase().equals("max"))
			return getMax();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.get__Type() == null) throw new org.molgenis.framework.db.DatabaseException("required field __Type is null");
		if(this.getObservationSet() == null) throw new org.molgenis.framework.db.DatabaseException("required field observationSet is null");
		if(this.getFeature() == null) throw new org.molgenis.framework.db.DatabaseException("required field feature is null");
		if(this.getValue() == null) throw new org.molgenis.framework.db.DatabaseException("required field value is null");
		if(this.getIdentifier() == null) throw new org.molgenis.framework.db.DatabaseException("required field identifier is null");
		if(this.getPhenotypePropertyID() == null) throw new org.molgenis.framework.db.DatabaseException("required field phenotypePropertyID is null");
		if(this.getValueRank() == null) throw new org.molgenis.framework.db.DatabaseException("required field valueRank is null");
		if(this.getValueIsMean() == null) throw new org.molgenis.framework.db.DatabaseException("required field valueIsMean is null");
		if(this.getSTD() == null) throw new org.molgenis.framework.db.DatabaseException("required field sTD is null");
		if(this.getMin() == null) throw new org.molgenis.framework.db.DatabaseException("required field min is null");
		if(this.getMax() == null) throw new org.molgenis.framework.db.DatabaseException("required field max is null");
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
			//set Identifier
			this.setIdentifier(tuple.getString("Identifier"));
			//set Name
			this.setName(tuple.getString("Name"));
			//set PhenotypePropertyID
			this.setPhenotypePropertyID(tuple.getInt("PhenotypePropertyID"));
			//set label Identifier for xref field PhenotypePropertyID
			this.setPhenotypePropertyID_Identifier(tuple.getString("PhenotypePropertyID_Identifier"));	
			//set ValueRank
			this.setValueRank(tuple.getString("ValueRank"));
			//set ValueIsMean
			this.setValueIsMean(tuple.getString("ValueIsMean"));
			//set STD
			this.setSTD(tuple.getString("STD"));
			//set Min
			this.setMin(tuple.getString("Min"));
			//set Max
			this.setMax(tuple.getString("Max"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("PhenotypeValue_id") != null) this.setId(tuple.getInt("PhenotypeValue_id"));
			//set __Type
			if( strict || tuple.getString("__Type") != null) this.set__Type(tuple.getString("__Type"));
			if( tuple.getString("PhenotypeValue___Type") != null) this.set__Type(tuple.getString("PhenotypeValue___Type"));
			//set ObservationSet
			if( strict || tuple.getInt("ObservationSet_id") != null) this.setObservationSet(tuple.getInt("ObservationSet_id"));
			if( tuple.getInt("PhenotypeValue_ObservationSet_id") != null) this.setObservationSet(tuple.getInt("PhenotypeValue_ObservationSet_id"));
			//alias of xref
			if( tuple.getObject("ObservationSet") != null) this.setObservationSet(tuple.getInt("ObservationSet"));
			if( tuple.getObject("PhenotypeValue_ObservationSet") != null) this.setObservationSet(tuple.getInt("PhenotypeValue_ObservationSet"));
			//set label for field ObservationSet
			//set Feature
			if( strict || tuple.getInt("Feature_id") != null) this.setFeature(tuple.getInt("Feature_id"));
			if( tuple.getInt("PhenotypeValue_Feature_id") != null) this.setFeature(tuple.getInt("PhenotypeValue_Feature_id"));
			//alias of xref
			if( tuple.getObject("Feature") != null) this.setFeature(tuple.getInt("Feature"));
			if( tuple.getObject("PhenotypeValue_Feature") != null) this.setFeature(tuple.getInt("PhenotypeValue_Feature"));
			//set label for field Feature
			if( strict || tuple.getObject("Feature_Identifier") != null) this.setFeature_Identifier(tuple.getString("Feature_Identifier"));			
			if( tuple.getObject("PhenotypeValue_Feature_Identifier") != null ) this.setFeature_Identifier(tuple.getString("PhenotypeValue_Feature_Identifier"));		
			//set Characteristic
			if( strict || tuple.getInt("Characteristic_id") != null) this.setCharacteristic(tuple.getInt("Characteristic_id"));
			if( tuple.getInt("PhenotypeValue_Characteristic_id") != null) this.setCharacteristic(tuple.getInt("PhenotypeValue_Characteristic_id"));
			//alias of xref
			if( tuple.getObject("Characteristic") != null) this.setCharacteristic(tuple.getInt("Characteristic"));
			if( tuple.getObject("PhenotypeValue_Characteristic") != null) this.setCharacteristic(tuple.getInt("PhenotypeValue_Characteristic"));
			//set label for field Characteristic
			if( strict || tuple.getObject("Characteristic_Identifier") != null) this.setCharacteristic_Identifier(tuple.getString("Characteristic_Identifier"));			
			if( tuple.getObject("PhenotypeValue_Characteristic_Identifier") != null ) this.setCharacteristic_Identifier(tuple.getString("PhenotypeValue_Characteristic_Identifier"));		
			//set Value
			if( strict || tuple.getString("Value") != null) this.setValue(tuple.getString("Value"));
			if( tuple.getString("PhenotypeValue_Value") != null) this.setValue(tuple.getString("PhenotypeValue_Value"));
			//set Identifier
			if( strict || tuple.getString("Identifier") != null) this.setIdentifier(tuple.getString("Identifier"));
			if( tuple.getString("PhenotypeValue_Identifier") != null) this.setIdentifier(tuple.getString("PhenotypeValue_Identifier"));
			//set Name
			if( strict || tuple.getString("Name") != null) this.setName(tuple.getString("Name"));
			if( tuple.getString("PhenotypeValue_Name") != null) this.setName(tuple.getString("PhenotypeValue_Name"));
			//set PhenotypePropertyID
			if( strict || tuple.getInt("PhenotypePropertyID_id") != null) this.setPhenotypePropertyID(tuple.getInt("PhenotypePropertyID_id"));
			if( tuple.getInt("PhenotypeValue_PhenotypePropertyID_id") != null) this.setPhenotypePropertyID(tuple.getInt("PhenotypeValue_PhenotypePropertyID_id"));
			//alias of xref
			if( tuple.getObject("PhenotypePropertyID") != null) this.setPhenotypePropertyID(tuple.getInt("PhenotypePropertyID"));
			if( tuple.getObject("PhenotypeValue_PhenotypePropertyID") != null) this.setPhenotypePropertyID(tuple.getInt("PhenotypeValue_PhenotypePropertyID"));
			//set label for field PhenotypePropertyID
			if( strict || tuple.getObject("PhenotypePropertyID_Identifier") != null) this.setPhenotypePropertyID_Identifier(tuple.getString("PhenotypePropertyID_Identifier"));			
			if( tuple.getObject("PhenotypeValue_PhenotypePropertyID_Identifier") != null ) this.setPhenotypePropertyID_Identifier(tuple.getString("PhenotypeValue_PhenotypePropertyID_Identifier"));		
			//set ValueRank
			if( strict || tuple.getString("ValueRank") != null) this.setValueRank(tuple.getString("ValueRank"));
			if( tuple.getString("PhenotypeValue_ValueRank") != null) this.setValueRank(tuple.getString("PhenotypeValue_ValueRank"));
			//set ValueIsMean
			if( strict || tuple.getString("ValueIsMean") != null) this.setValueIsMean(tuple.getString("ValueIsMean"));
			if( tuple.getString("PhenotypeValue_ValueIsMean") != null) this.setValueIsMean(tuple.getString("PhenotypeValue_ValueIsMean"));
			//set STD
			if( strict || tuple.getString("STD") != null) this.setSTD(tuple.getString("STD"));
			if( tuple.getString("PhenotypeValue_STD") != null) this.setSTD(tuple.getString("PhenotypeValue_STD"));
			//set Min
			if( strict || tuple.getString("Min") != null) this.setMin(tuple.getString("Min"));
			if( tuple.getString("PhenotypeValue_Min") != null) this.setMin(tuple.getString("PhenotypeValue_Min"));
			//set Max
			if( strict || tuple.getString("Max") != null) this.setMax(tuple.getString("Max"));
			if( tuple.getString("PhenotypeValue_Max") != null) this.setMax(tuple.getString("PhenotypeValue_Max"));
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
		String result = "PhenotypeValue(";
		result+= "id='" + getId()+"' ";	
		result+= "__Type='" + get__Type()+"' ";	
		result+= " observationSet_id='" + getObservationSet_Id()+"' ";	
		result+= " feature_id='" + getFeature_Id()+"' ";	
		result+= " feature_identifier='" + getFeature_Identifier()+"' ";
		result+= " characteristic_id='" + getCharacteristic_Id()+"' ";	
		result+= " characteristic_identifier='" + getCharacteristic_Identifier()+"' ";
		result+= "value='" + getValue()+"' ";	
		result+= "identifier='" + getIdentifier()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= " phenotypePropertyID_id='" + getPhenotypePropertyID_Id()+"' ";	
		result+= " phenotypePropertyID_identifier='" + getPhenotypePropertyID_Identifier()+"' ";
		result+= "valueRank='" + getValueRank()+"' ";	
		result+= "valueIsMean='" + getValueIsMean()+"' ";	
		result+= "sTD='" + getSTD()+"' ";	
		result+= "min='" + getMin()+"' ";	
		result+= "max='" + getMax()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of PhenotypeValue.
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
		{
			fields.add("identifier");
		}
		{
			fields.add("name");
		}
		{
			fields.add("phenotypePropertyID_id");
		}
		fields.add("phenotypePropertyID_identifier");
		{
			fields.add("valueRank");
		}
		{
			fields.add("valueIsMean");
		}
		{
			fields.add("sTD");
		}
		{
			fields.add("min");
		}
		{
			fields.add("max");
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
		+ "value" +sep
		+ "identifier" +sep
		+ "name" +sep
		+ "phenotypePropertyID" +sep
		+ "valueRank" +sep
		+ "valueIsMean" +sep
		+ "sTD" +sep
		+ "min" +sep
		+ "max" 
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
        if (fieldName.equalsIgnoreCase("phenotypePropertyID")) {
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
		PhenotypeValue rhs = (PhenotypeValue) obj;
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
			Object valueO = getPhenotypePropertyID();
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
			Object valueO = getValueRank();
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
			Object valueO = getValueIsMean();
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
			Object valueO = getSTD();
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
			Object valueO = getMin();
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
			Object valueO = getMax();
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
	public PhenotypeValue create(org.molgenis.util.Tuple tuple) throws Exception
	{
		PhenotypeValue e = new PhenotypeValue();
		e.set(tuple);
		return e;
	}
	

	
}

