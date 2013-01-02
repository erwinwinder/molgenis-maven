
/* File:        org.molgenis.omx/model/UsedMarkerSet.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.gwascentral;

/**
 * UsedMarkerSet: .
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "UsedMarkerSet", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "ExperimentID", "MarkerIdentifier" } ) }
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.gwascentral.db.UsedMarkerSetEntityListener.class})
public class UsedMarkerSet extends org.molgenis.observ.ObservableFeature 
{
	// fieldname constants
	public final static String EXPERIMENTID = "ExperimentID";
	public final static String EXPERIMENTID_IDENTIFIER = "ExperimentID_Identifier";
	public final static String MARKERIDENTIFIER = "MarkerIdentifier";
	public final static String ID = "id";
	
	//static methods
	/**
	 * Shorthand for db.query(UsedMarkerSet.class).
	 */
	public static org.molgenis.framework.db.Query<? extends UsedMarkerSet> query(org.molgenis.framework.db.Database db)
	{
		return db.query(UsedMarkerSet.class);
	}
	
	/**
	 * Shorthand for db.find(UsedMarkerSet.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends UsedMarkerSet> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(UsedMarkerSet.class, rules);
	}	
	
	/**
	 * 
	 */
	public static UsedMarkerSet findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<UsedMarkerSet> q = db.query(UsedMarkerSet.class);
		q.eq(UsedMarkerSet.ID, id);
		java.util.List<UsedMarkerSet> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static UsedMarkerSet findByIdentifier(org.molgenis.framework.db.Database db, String identifier) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<UsedMarkerSet> q = db.query(UsedMarkerSet.class);
		q.eq(UsedMarkerSet.IDENTIFIER, identifier);
		java.util.List<UsedMarkerSet> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static UsedMarkerSet findByExperimentIDMarkerIdentifier(org.molgenis.framework.db.Database db, Integer experimentID, String markerIdentifier) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<UsedMarkerSet> q = db.query(UsedMarkerSet.class);
		q.eq(UsedMarkerSet.EXPERIMENTID, experimentID);q.eq(UsedMarkerSet.MARKERIDENTIFIER, markerIdentifier);
		java.util.List<UsedMarkerSet> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//Experiment ID[type=xref]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="ExperimentID")   	
	
				

	private org.molgenis.organization.Experiment experimentID = null;
	@javax.persistence.Transient
	private Integer experimentID_id = null;	
	@javax.persistence.Transient
	private String experimentID_Identifier = null;						


	//Marker identifier[type=string]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="MarkerIdentifier")
	@javax.xml.bind.annotation.XmlElement(name="markerIdentifier")
	
				

	private String markerIdentifier =  null;


	//automatically generated internal id, only for internal use.[type=int]
	

	//constructors
	public UsedMarkerSet()
	{
		//set the type for a new instance
		set__Type(this.getClass().getSimpleName());
	
	}
	
	//getters and setters
	/**
	 * Get the Experiment ID.
	 * @return experimentID.
	 */
	public org.molgenis.organization.Experiment getExperimentID()
	{
		return this.experimentID;
	}
	
	@Deprecated
	public org.molgenis.organization.Experiment getExperimentID(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Experiment ID.
	 * @param experimentID
	 */
	public void setExperimentID( org.molgenis.organization.Experiment experimentID)
	{
		
		this.experimentID = experimentID;
	}

	
	
	/**
	 * Set foreign key for field experimentID.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setExperimentID_Id(Integer experimentID_id)
	{
		this.experimentID_id = experimentID_id;
	}	

	public void setExperimentID(Integer experimentID_id)
	{
		this.experimentID_id = experimentID_id;
	}
	
	public Integer getExperimentID_Id()
	{
		
		if(experimentID != null) 
		{
			return experimentID.getId();
		}
		else
		{
			return experimentID_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference ExperimentID to Experiment.Id.
	 */
	public String getExperimentID_Identifier()
	{		
		//FIXME should we auto-load based on getExperimentID()?	
		if(experimentID != null) {
			return experimentID.getIdentifier();
		} else {
			return experimentID_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference ExperimentID to <a href="Experiment.html#Id">Experiment.Id</a>.
	 * Implies setExperimentID(null) until save
	 */
	public void setExperimentID_Identifier(String experimentID_Identifier)
	{
		this.experimentID_Identifier = experimentID_Identifier;
	}		
	 
	

	/**
	 * Get the Marker identifier.
	 * @return markerIdentifier.
	 */
	public String getMarkerIdentifier()
	{
		return this.markerIdentifier;
	}
	
	@Deprecated
	public String getMarkerIdentifier(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Marker identifier.
	 * @param markerIdentifier
	 */
	public void setMarkerIdentifier( String markerIdentifier)
	{
		
		this.markerIdentifier = markerIdentifier;
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
		if (name.toLowerCase().equals("experimentid"))
			return getExperimentID();
		if(name.toLowerCase().equals("experimentid_id"))
			return getExperimentID_Id();
		if(name.toLowerCase().equals("experimentid_identifier"))
			return getExperimentID_Identifier();
		if (name.toLowerCase().equals("markeridentifier"))
			return getMarkerIdentifier();
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
			//set ExperimentID
			this.setExperimentID(tuple.getInt("ExperimentID"));
			//set label Identifier for xref field ExperimentID
			this.setExperimentID_Identifier(tuple.getString("ExperimentID_Identifier"));	
			//set MarkerIdentifier
			this.setMarkerIdentifier(tuple.getString("MarkerIdentifier"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("UsedMarkerSet_id") != null) this.setId(tuple.getInt("UsedMarkerSet_id"));
			//set Identifier
			if( strict || tuple.getString("Identifier") != null) this.setIdentifier(tuple.getString("Identifier"));
			if( tuple.getString("UsedMarkerSet_Identifier") != null) this.setIdentifier(tuple.getString("UsedMarkerSet_Identifier"));
			//set Name
			if( strict || tuple.getString("Name") != null) this.setName(tuple.getString("Name"));
			if( tuple.getString("UsedMarkerSet_Name") != null) this.setName(tuple.getString("UsedMarkerSet_Name"));
			//set __Type
			if( strict || tuple.getString("__Type") != null) this.set__Type(tuple.getString("__Type"));
			if( tuple.getString("UsedMarkerSet___Type") != null) this.set__Type(tuple.getString("UsedMarkerSet___Type"));
			//set Description
			if( strict || tuple.getString("description") != null) this.setDescription(tuple.getString("description"));
			if( tuple.getString("UsedMarkerSet_description") != null) this.setDescription(tuple.getString("UsedMarkerSet_description"));
			//set Unit
			if( strict || tuple.getInt("unit_id") != null) this.setUnit(tuple.getInt("unit_id"));
			if( tuple.getInt("UsedMarkerSet_unit_id") != null) this.setUnit(tuple.getInt("UsedMarkerSet_unit_id"));
			//alias of xref
			if( tuple.getObject("unit") != null) this.setUnit(tuple.getInt("unit"));
			if( tuple.getObject("UsedMarkerSet_unit") != null) this.setUnit(tuple.getInt("UsedMarkerSet_unit"));
			//set label for field Unit
			if( strict || tuple.getObject("unit_Identifier") != null) this.setUnit_Identifier(tuple.getString("unit_Identifier"));			
			if( tuple.getObject("UsedMarkerSet_unit_Identifier") != null ) this.setUnit_Identifier(tuple.getString("UsedMarkerSet_unit_Identifier"));		
			//set DataType
			if( strict || tuple.getString("dataType") != null) this.setDataType(tuple.getString("dataType"));
			if( tuple.getString("UsedMarkerSet_dataType") != null) this.setDataType(tuple.getString("UsedMarkerSet_dataType"));
			//set Temporal
			if( strict || tuple.getBoolean("temporal") != null) this.setTemporal(tuple.getBoolean("temporal"));
			if( tuple.getBoolean("UsedMarkerSet_temporal") != null) this.setTemporal(tuple.getBoolean("UsedMarkerSet_temporal"));
			//set ExperimentID
			if( strict || tuple.getInt("ExperimentID_id") != null) this.setExperimentID(tuple.getInt("ExperimentID_id"));
			if( tuple.getInt("UsedMarkerSet_ExperimentID_id") != null) this.setExperimentID(tuple.getInt("UsedMarkerSet_ExperimentID_id"));
			//alias of xref
			if( tuple.getObject("ExperimentID") != null) this.setExperimentID(tuple.getInt("ExperimentID"));
			if( tuple.getObject("UsedMarkerSet_ExperimentID") != null) this.setExperimentID(tuple.getInt("UsedMarkerSet_ExperimentID"));
			//set label for field ExperimentID
			if( strict || tuple.getObject("ExperimentID_Identifier") != null) this.setExperimentID_Identifier(tuple.getString("ExperimentID_Identifier"));			
			if( tuple.getObject("UsedMarkerSet_ExperimentID_Identifier") != null ) this.setExperimentID_Identifier(tuple.getString("UsedMarkerSet_ExperimentID_Identifier"));		
			//set MarkerIdentifier
			if( strict || tuple.getString("MarkerIdentifier") != null) this.setMarkerIdentifier(tuple.getString("MarkerIdentifier"));
			if( tuple.getString("UsedMarkerSet_MarkerIdentifier") != null) this.setMarkerIdentifier(tuple.getString("UsedMarkerSet_MarkerIdentifier"));
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
		String result = "UsedMarkerSet(";
		result+= "id='" + getId()+"' ";	
		result+= "identifier='" + getIdentifier()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= "__Type='" + get__Type()+"' ";	
		result+= "description='" + getDescription()+"' ";	
		result+= " unit_id='" + getUnit_Id()+"' ";	
		result+= " unit_identifier='" + getUnit_Identifier()+"' ";
		result+= "dataType='" + getDataType()+"' ";	
		result+= "temporal='" + getTemporal()+"' ";	
		result+= " experimentID_id='" + getExperimentID_Id()+"' ";	
		result+= " experimentID_identifier='" + getExperimentID_Identifier()+"' ";
		result+= "markerIdentifier='" + getMarkerIdentifier()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of UsedMarkerSet.
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
		{
			fields.add("experimentID_id");
		}
		fields.add("experimentID_identifier");
		{
			fields.add("markerIdentifier");
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
		+ "temporal" +sep
		+ "experimentID" +sep
		+ "markerIdentifier" 
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
        if (fieldName.equalsIgnoreCase("experimentID")) {
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
		UsedMarkerSet rhs = (UsedMarkerSet) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
             	.appendSuper(super.equals(obj))
		//experimentID
		//markerIdentifier
				.append(markerIdentifier, rhs.getMarkerIdentifier())
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
				.append(markerIdentifier)
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
			out.write(valueS+sep);
		}
		{
			Object valueO = getExperimentID();
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
			Object valueO = getMarkerIdentifier();
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
	public UsedMarkerSet create(org.molgenis.util.Tuple tuple) throws Exception
	{
		UsedMarkerSet e = new UsedMarkerSet();
		e.set(tuple);
		return e;
	}
	
//3
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="usedMarkerSet"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.gwascentral.FrequencyCluster> usedMarkerSetFrequencyClusterCollection = new java.util.ArrayList<org.molgenis.gwascentral.FrequencyCluster>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.gwascentral.FrequencyCluster> getUsedMarkerSetFrequencyClusterCollection()
	{
            return usedMarkerSetFrequencyClusterCollection;
	}

    public void setUsedMarkerSetFrequencyClusterCollection(java.util.Collection<org.molgenis.gwascentral.FrequencyCluster> collection)
    {
        for (org.molgenis.gwascentral.FrequencyCluster frequencyCluster : collection) {
            frequencyCluster.setUsedMarkerSet(this);
        }
        usedMarkerSetFrequencyClusterCollection = collection;
    }	
//3
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="usedmarkersetID"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.gwascentral.Significance> usedmarkersetIDSignificanceCollection = new java.util.ArrayList<org.molgenis.gwascentral.Significance>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.gwascentral.Significance> getUsedmarkersetIDSignificanceCollection()
	{
            return usedmarkersetIDSignificanceCollection;
	}

    public void setUsedmarkersetIDSignificanceCollection(java.util.Collection<org.molgenis.gwascentral.Significance> collection)
    {
        for (org.molgenis.gwascentral.Significance significance : collection) {
            significance.setUsedmarkersetID(this);
        }
        usedmarkersetIDSignificanceCollection = collection;
    }	
//3
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="usedMarkerSetID"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.gwascentral.EffectSize> usedMarkerSetIDEffectSizeCollection = new java.util.ArrayList<org.molgenis.gwascentral.EffectSize>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.gwascentral.EffectSize> getUsedMarkerSetIDEffectSizeCollection()
	{
            return usedMarkerSetIDEffectSizeCollection;
	}

    public void setUsedMarkerSetIDEffectSizeCollection(java.util.Collection<org.molgenis.gwascentral.EffectSize> collection)
    {
        for (org.molgenis.gwascentral.EffectSize effectSize : collection) {
            effectSize.setUsedMarkerSetID(this);
        }
        usedMarkerSetIDEffectSizeCollection = collection;
    }	

	
}

