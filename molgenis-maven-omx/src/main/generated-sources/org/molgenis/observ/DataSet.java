
/* File:        org.molgenis.omx/model/DataSet.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.observ;

/**
 * DataSet: Container for one or more observations that are measured
				using the same protocol and by the same performer(s). The dataset
				may be a file (having the same
				identifier) but in most cases it is a
				data table consisting of rows (Observation).

				This entity replaces
				ProtocolApplication.
			
.
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "DataSet"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.observ.db.DataSetEntityListener.class})
public class DataSet extends org.molgenis.observ.Characteristic 
{
	// fieldname constants
	public final static String PROTOCOLUSED = "ProtocolUsed";
	public final static String PROTOCOLUSED_IDENTIFIER = "ProtocolUsed_Identifier";
	public final static String STARTTIME = "startTime";
	public final static String ENDTIME = "endTime";
	public final static String ID = "id";
	
	//static methods
	/**
	 * Shorthand for db.query(DataSet.class).
	 */
	public static org.molgenis.framework.db.Query<? extends DataSet> query(org.molgenis.framework.db.Database db)
	{
		return db.query(DataSet.class);
	}
	
	/**
	 * Shorthand for db.find(DataSet.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends DataSet> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(DataSet.class, rules);
	}	
	
	/**
	 * 
	 */
	public static DataSet findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<DataSet> q = db.query(DataSet.class);
		q.eq(DataSet.ID, id);
		java.util.List<DataSet> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static DataSet findByIdentifier(org.molgenis.framework.db.Database db, String identifier) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<DataSet> q = db.query(DataSet.class);
		q.eq(DataSet.IDENTIFIER, identifier);
		java.util.List<DataSet> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//Reference to the protocol that is being used (if available)[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="ProtocolUsed")   	
	
				

	private org.molgenis.observ.Protocol protocolUsed = null;
	@javax.persistence.Transient
	private Integer protocolUsed_id = null;	
	@javax.persistence.Transient
	private String protocolUsed_Identifier = null;						


	//time when the protocol started.[type=datetime]
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@javax.persistence.Column(name="startTime", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="startTime")
	
				

	@javax.validation.constraints.NotNull
	private java.util.Date startTime =  new java.sql.Date(new java.util.Date().getTime());


	//(Optional) time when the protocol ended.[type=datetime]
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@javax.persistence.Column(name="endTime")
	@javax.xml.bind.annotation.XmlElement(name="endTime")
	
				

	private java.util.Date endTime =  new java.sql.Date(new java.util.Date().getTime());


	//automatically generated internal id, only for internal use.[type=int]
	

	//constructors
	public DataSet()
	{
		//set the type for a new instance
		set__Type(this.getClass().getSimpleName());
	
	}
	
	//getters and setters
	/**
	 * Get the Reference to the protocol that is being used (if available).
	 * @return protocolUsed.
	 */
	public org.molgenis.observ.Protocol getProtocolUsed()
	{
		return this.protocolUsed;
	}
	
	@Deprecated
	public org.molgenis.observ.Protocol getProtocolUsed(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Reference to the protocol that is being used (if available).
	 * @param protocolUsed
	 */
	public void setProtocolUsed( org.molgenis.observ.Protocol protocolUsed)
	{
		
		this.protocolUsed = protocolUsed;
	}

	
	
	/**
	 * Set foreign key for field protocolUsed.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setProtocolUsed_Id(Integer protocolUsed_id)
	{
		this.protocolUsed_id = protocolUsed_id;
	}	

	public void setProtocolUsed(Integer protocolUsed_id)
	{
		this.protocolUsed_id = protocolUsed_id;
	}
	
	public Integer getProtocolUsed_Id()
	{
		
		if(protocolUsed != null) 
		{
			return protocolUsed.getId();
		}
		else
		{
			return protocolUsed_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference ProtocolUsed to Protocol.Id.
	 */
	public String getProtocolUsed_Identifier()
	{		
		//FIXME should we auto-load based on getProtocolUsed()?	
		if(protocolUsed != null) {
			return protocolUsed.getIdentifier();
		} else {
			return protocolUsed_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference ProtocolUsed to <a href="Protocol.html#Id">Protocol.Id</a>.
	 * Implies setProtocolUsed(null) until save
	 */
	public void setProtocolUsed_Identifier(String protocolUsed_Identifier)
	{
		this.protocolUsed_Identifier = protocolUsed_Identifier;
	}		
	 
	

	/**
	 * Get the time when the protocol started..
	 * @return startTime.
	 */
	public java.util.Date getStartTime()
	{
		return this.startTime;
	}
	
	@Deprecated
	public java.util.Date getStartTime(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the time when the protocol started..
	 * @param startTime
	 */
	public void setStartTime( java.util.Date startTime)
	{
		
		this.startTime = startTime;
	}

	

	/**
	 * Get the (Optional) time when the protocol ended..
	 * @return endTime.
	 */
	public java.util.Date getEndTime()
	{
		return this.endTime;
	}
	
	@Deprecated
	public java.util.Date getEndTime(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the (Optional) time when the protocol ended..
	 * @param endTime
	 */
	public void setEndTime( java.util.Date endTime)
	{
		
		this.endTime = endTime;
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
		if (name.toLowerCase().equals("protocolused"))
			return getProtocolUsed();
		if(name.toLowerCase().equals("protocolused_id"))
			return getProtocolUsed_Id();
		if(name.toLowerCase().equals("protocolused_identifier"))
			return getProtocolUsed_Identifier();
		if (name.toLowerCase().equals("starttime"))
			return getStartTime();
		if (name.toLowerCase().equals("endtime"))
			return getEndTime();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getIdentifier() == null) throw new org.molgenis.framework.db.DatabaseException("required field identifier is null");
		if(this.getName() == null) throw new org.molgenis.framework.db.DatabaseException("required field name is null");
		if(this.get__Type() == null) throw new org.molgenis.framework.db.DatabaseException("required field __Type is null");
		if(this.getStartTime() == null) throw new org.molgenis.framework.db.DatabaseException("required field startTime is null");
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
			//set ProtocolUsed
			this.setProtocolUsed(tuple.getInt("ProtocolUsed"));
			//set label Identifier for xref field ProtocolUsed
			this.setProtocolUsed_Identifier(tuple.getString("ProtocolUsed_Identifier"));	
			//set StartTime
			this.setStartTime(tuple.getTimestamp("startTime"));
			//set EndTime
			this.setEndTime(tuple.getTimestamp("endTime"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("DataSet_id") != null) this.setId(tuple.getInt("DataSet_id"));
			//set Identifier
			if( strict || tuple.getString("Identifier") != null) this.setIdentifier(tuple.getString("Identifier"));
			if( tuple.getString("DataSet_Identifier") != null) this.setIdentifier(tuple.getString("DataSet_Identifier"));
			//set Name
			if( strict || tuple.getString("Name") != null) this.setName(tuple.getString("Name"));
			if( tuple.getString("DataSet_Name") != null) this.setName(tuple.getString("DataSet_Name"));
			//set __Type
			if( strict || tuple.getString("__Type") != null) this.set__Type(tuple.getString("__Type"));
			if( tuple.getString("DataSet___Type") != null) this.set__Type(tuple.getString("DataSet___Type"));
			//set Description
			if( strict || tuple.getString("description") != null) this.setDescription(tuple.getString("description"));
			if( tuple.getString("DataSet_description") != null) this.setDescription(tuple.getString("DataSet_description"));
			//set ProtocolUsed
			if( strict || tuple.getInt("ProtocolUsed_id") != null) this.setProtocolUsed(tuple.getInt("ProtocolUsed_id"));
			if( tuple.getInt("DataSet_ProtocolUsed_id") != null) this.setProtocolUsed(tuple.getInt("DataSet_ProtocolUsed_id"));
			//alias of xref
			if( tuple.getObject("ProtocolUsed") != null) this.setProtocolUsed(tuple.getInt("ProtocolUsed"));
			if( tuple.getObject("DataSet_ProtocolUsed") != null) this.setProtocolUsed(tuple.getInt("DataSet_ProtocolUsed"));
			//set label for field ProtocolUsed
			if( strict || tuple.getObject("ProtocolUsed_Identifier") != null) this.setProtocolUsed_Identifier(tuple.getString("ProtocolUsed_Identifier"));			
			if( tuple.getObject("DataSet_ProtocolUsed_Identifier") != null ) this.setProtocolUsed_Identifier(tuple.getString("DataSet_ProtocolUsed_Identifier"));		
			//set StartTime
			if( strict || tuple.getTimestamp("startTime") != null) this.setStartTime(tuple.getTimestamp("startTime"));
			if( tuple.getTimestamp("DataSet_startTime") != null) this.setStartTime(tuple.getTimestamp("DataSet_startTime"));
			//set EndTime
			if( strict || tuple.getTimestamp("endTime") != null) this.setEndTime(tuple.getTimestamp("endTime"));
			if( tuple.getTimestamp("DataSet_endTime") != null) this.setEndTime(tuple.getTimestamp("DataSet_endTime"));
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
		String result = "DataSet(";
		result+= "id='" + getId()+"' ";	
		result+= "identifier='" + getIdentifier()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= "__Type='" + get__Type()+"' ";	
		result+= "description='" + getDescription()+"' ";	
		result+= " protocolUsed_id='" + getProtocolUsed_Id()+"' ";	
		result+= " protocolUsed_identifier='" + getProtocolUsed_Identifier()+"' ";
		result+= "startTime='" + (getStartTime() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy, HH:mm:ss", java.util.Locale.US).format(getStartTime()))+"' ";
		result+= "startTime='" + (getStartTime() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy", java.util.Locale.US).format(getStartTime()))+"' ";		
		result+= "endTime='" + (getEndTime() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy, HH:mm:ss", java.util.Locale.US).format(getEndTime()))+"'";
		result+= "endTime='" + (getEndTime() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy", java.util.Locale.US).format(getEndTime()))+"'";		
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of DataSet.
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
			fields.add("protocolUsed_id");
		}
		fields.add("protocolUsed_identifier");
		{
			fields.add("startTime");
		}
		{
			fields.add("endTime");
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
		+ "protocolUsed" +sep
		+ "startTime" +sep
		+ "endTime" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("protocolUsed")) {
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
		DataSet rhs = (DataSet) obj;
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
			Object valueO = getProtocolUsed();
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
			Object valueO = getStartTime();
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
			Object valueO = getEndTime();
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
	public DataSet create(org.molgenis.util.Tuple tuple) throws Exception
	{
		DataSet e = new DataSet();
		e.set(tuple);
		return e;
	}
	
//4
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="partOfDataSet"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.observ.ObservationSet> partOfDataSetObservationSetCollection = new java.util.ArrayList<org.molgenis.observ.ObservationSet>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.observ.ObservationSet> getPartOfDataSetObservationSetCollection()
	{
            return partOfDataSetObservationSetCollection;
	}

    public void setPartOfDataSetObservationSetCollection(java.util.Collection<org.molgenis.observ.ObservationSet> collection)
    {
        for (org.molgenis.observ.ObservationSet observationSet : collection) {
            observationSet.setPartOfDataSet(this);
        }
        partOfDataSetObservationSetCollection = collection;
    }	
//4
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="dataSet"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.gwascentral.FrequencyCluster> dataSetFrequencyClusterCollection = new java.util.ArrayList<org.molgenis.gwascentral.FrequencyCluster>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.gwascentral.FrequencyCluster> getDataSetFrequencyClusterCollection()
	{
            return dataSetFrequencyClusterCollection;
	}

    public void setDataSetFrequencyClusterCollection(java.util.Collection<org.molgenis.gwascentral.FrequencyCluster> collection)
    {
        for (org.molgenis.gwascentral.FrequencyCluster frequencyCluster : collection) {
            frequencyCluster.setDataSet(this);
        }
        dataSetFrequencyClusterCollection = collection;
    }	
	//4
    @javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="dataSets"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.organization.Experiment> dataSetsExperimentCollection = new java.util.ArrayList<org.molgenis.organization.Experiment>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.organization.Experiment> getDataSetsExperimentCollection()
	{
        return dataSetsExperimentCollection;
	}

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.organization.Experiment> getDataSetsExperimentCollection(org.molgenis.framework.db.Database db)
	{
        return getDataSetsExperimentCollection();
	}

    public void setDataSetsExperimentCollection(java.util.Collection<org.molgenis.organization.Experiment> collection)
    {
    	dataSetsExperimentCollection.addAll(collection);
    }	

	
}

