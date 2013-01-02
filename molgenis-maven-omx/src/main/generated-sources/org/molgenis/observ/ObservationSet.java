
/* File:        org.molgenis.omx/model/ObservationSet.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.observ;

/**
 * ObservationSet: In practice: Observation is one row within a DataSet.
			
.
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "ObservationSet", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "partOfDataSet", "Target", "Time" } ) }
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.observ.db.ObservationSetEntityListener.class})
public class ObservationSet extends org.molgenis.util.AbstractEntity implements org.molgenis.core.Autoid
{
	// fieldname constants
	public final static String ID = "id";
	public final static String PARTOFDATASET = "partOfDataSet";
	public final static String PARTOFDATASET_IDENTIFIER = "partOfDataSet_Identifier";
	public final static String TARGET = "Target";
	public final static String TARGET_IDENTIFIER = "Target_Identifier";
	public final static String TIME = "Time";
	
	//static methods
	/**
	 * Shorthand for db.query(ObservationSet.class).
	 */
	public static org.molgenis.framework.db.Query<? extends ObservationSet> query(org.molgenis.framework.db.Database db)
	{
		return db.query(ObservationSet.class);
	}
	
	/**
	 * Shorthand for db.find(ObservationSet.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends ObservationSet> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(ObservationSet.class, rules);
	}	
	
	/**
	 * 
	 */
	public static ObservationSet findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<ObservationSet> q = db.query(ObservationSet.class);
		q.eq(ObservationSet.ID, id);
		java.util.List<ObservationSet> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static ObservationSet findByPartOfDataSetTargetTime(org.molgenis.framework.db.Database db, Integer partOfDataSet, Integer target, java.util.Date time) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<ObservationSet> q = db.query(ObservationSet.class);
		q.eq(ObservationSet.PARTOFDATASET, partOfDataSet);q.eq(ObservationSet.TARGET, target);q.eq(ObservationSet.TIME, time);
		java.util.List<ObservationSet> result = q.find();
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


	//DataSet this ValueSet is part of.[type=xref]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="partOfDataSet", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.observ.DataSet partOfDataSet = null;
	@javax.persistence.Transient
	private Integer partOfDataSet_id = null;	
	@javax.persistence.Transient
	private String partOfDataSet_Identifier = null;						


	//References the target for which this data was recorded. For example 'individual1'.[type=xref]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Target", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.observ.Characteristic target = null;
	@javax.persistence.Transient
	private Integer target_id = null;	
	@javax.persistence.Transient
	private String target_Identifier = null;						


	//Time of this observationSet[type=datetime]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@javax.persistence.Column(name="Time")
	@javax.xml.bind.annotation.XmlElement(name="time")
	
				

	private java.util.Date time =  null;

	//constructors
	public ObservationSet()
	{
	
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
	 * Get the DataSet this ValueSet is part of..
	 * @return partOfDataSet.
	 */
	public org.molgenis.observ.DataSet getPartOfDataSet()
	{
		return this.partOfDataSet;
	}
	
	@Deprecated
	public org.molgenis.observ.DataSet getPartOfDataSet(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the DataSet this ValueSet is part of..
	 * @param partOfDataSet
	 */
	public void setPartOfDataSet( org.molgenis.observ.DataSet partOfDataSet)
	{
		
		this.partOfDataSet = partOfDataSet;
	}

	
	
	/**
	 * Set foreign key for field partOfDataSet.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setPartOfDataSet_Id(Integer partOfDataSet_id)
	{
		this.partOfDataSet_id = partOfDataSet_id;
	}	

	public void setPartOfDataSet(Integer partOfDataSet_id)
	{
		this.partOfDataSet_id = partOfDataSet_id;
	}
	
	public Integer getPartOfDataSet_Id()
	{
		
		if(partOfDataSet != null) 
		{
			return partOfDataSet.getId();
		}
		else
		{
			return partOfDataSet_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference PartOfDataSet to DataSet.Id.
	 */
	public String getPartOfDataSet_Identifier()
	{		
		//FIXME should we auto-load based on getPartOfDataSet()?	
		if(partOfDataSet != null) {
			return partOfDataSet.getIdentifier();
		} else {
			return partOfDataSet_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference PartOfDataSet to <a href="DataSet.html#Id">DataSet.Id</a>.
	 * Implies setPartOfDataSet(null) until save
	 */
	public void setPartOfDataSet_Identifier(String partOfDataSet_Identifier)
	{
		this.partOfDataSet_Identifier = partOfDataSet_Identifier;
	}		
	 
	

	/**
	 * Get the References the target for which this data was recorded. For example 'individual1'..
	 * @return target.
	 */
	public org.molgenis.observ.Characteristic getTarget()
	{
		return this.target;
	}
	
	@Deprecated
	public org.molgenis.observ.Characteristic getTarget(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the References the target for which this data was recorded. For example 'individual1'..
	 * @param target
	 */
	public void setTarget( org.molgenis.observ.Characteristic target)
	{
		
		this.target = target;
	}

	
	
	/**
	 * Set foreign key for field target.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setTarget_Id(Integer target_id)
	{
		this.target_id = target_id;
	}	

	public void setTarget(Integer target_id)
	{
		this.target_id = target_id;
	}
	
	public Integer getTarget_Id()
	{
		
		if(target != null) 
		{
			return target.getId();
		}
		else
		{
			return target_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference Target to Characteristic.Id.
	 */
	public String getTarget_Identifier()
	{		
		//FIXME should we auto-load based on getTarget()?	
		if(target != null) {
			return target.getIdentifier();
		} else {
			return target_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Target to <a href="Characteristic.html#Id">Characteristic.Id</a>.
	 * Implies setTarget(null) until save
	 */
	public void setTarget_Identifier(String target_Identifier)
	{
		this.target_Identifier = target_Identifier;
	}		
	 
	

	/**
	 * Get the Time of this observationSet.
	 * @return time.
	 */
	public java.util.Date getTime()
	{
		return this.time;
	}
	
	@Deprecated
	public java.util.Date getTime(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Time of this observationSet.
	 * @param time
	 */
	public void setTime( java.util.Date time)
	{
		
		this.time = time;
	}

	


	/**
	 * Generic getter. Get the property by using the name.
	 */
	public Object get(String name)
	{
		name = name.toLowerCase();
		if (name.toLowerCase().equals("id"))
			return getId();
		if (name.toLowerCase().equals("partofdataset"))
			return getPartOfDataSet();
		if(name.toLowerCase().equals("partofdataset_id"))
			return getPartOfDataSet_Id();
		if(name.toLowerCase().equals("partofdataset_identifier"))
			return getPartOfDataSet_Identifier();
		if (name.toLowerCase().equals("target"))
			return getTarget();
		if(name.toLowerCase().equals("target_id"))
			return getTarget_Id();
		if(name.toLowerCase().equals("target_identifier"))
			return getTarget_Identifier();
		if (name.toLowerCase().equals("time"))
			return getTime();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getPartOfDataSet() == null) throw new org.molgenis.framework.db.DatabaseException("required field partOfDataSet is null");
		if(this.getTarget() == null) throw new org.molgenis.framework.db.DatabaseException("required field target is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.util.Tuple tuple, boolean strict )  throws Exception
	{
		//optimization :-(
		if(tuple instanceof org.molgenis.util.ResultSetTuple)
		{
				//set Id
			this.setId(tuple.getInt("id"));
			//set PartOfDataSet
			this.setPartOfDataSet(tuple.getInt("partOfDataSet"));
			//set label Identifier for xref field PartOfDataSet
			this.setPartOfDataSet_Identifier(tuple.getString("partOfDataSet_Identifier"));	
			//set Target
			this.setTarget(tuple.getInt("Target"));
			//set label Identifier for xref field Target
			this.setTarget_Identifier(tuple.getString("Target_Identifier"));	
			//set Time
			this.setTime(tuple.getTimestamp("Time"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("ObservationSet_id") != null) this.setId(tuple.getInt("ObservationSet_id"));
			//set PartOfDataSet
			if( strict || tuple.getInt("partOfDataSet_id") != null) this.setPartOfDataSet(tuple.getInt("partOfDataSet_id"));
			if( tuple.getInt("ObservationSet_partOfDataSet_id") != null) this.setPartOfDataSet(tuple.getInt("ObservationSet_partOfDataSet_id"));
			//alias of xref
			if( tuple.getObject("partOfDataSet") != null) this.setPartOfDataSet(tuple.getInt("partOfDataSet"));
			if( tuple.getObject("ObservationSet_partOfDataSet") != null) this.setPartOfDataSet(tuple.getInt("ObservationSet_partOfDataSet"));
			//set label for field PartOfDataSet
			if( strict || tuple.getObject("partOfDataSet_Identifier") != null) this.setPartOfDataSet_Identifier(tuple.getString("partOfDataSet_Identifier"));			
			if( tuple.getObject("ObservationSet_partOfDataSet_Identifier") != null ) this.setPartOfDataSet_Identifier(tuple.getString("ObservationSet_partOfDataSet_Identifier"));		
			//set Target
			if( strict || tuple.getInt("Target_id") != null) this.setTarget(tuple.getInt("Target_id"));
			if( tuple.getInt("ObservationSet_Target_id") != null) this.setTarget(tuple.getInt("ObservationSet_Target_id"));
			//alias of xref
			if( tuple.getObject("Target") != null) this.setTarget(tuple.getInt("Target"));
			if( tuple.getObject("ObservationSet_Target") != null) this.setTarget(tuple.getInt("ObservationSet_Target"));
			//set label for field Target
			if( strict || tuple.getObject("Target_Identifier") != null) this.setTarget_Identifier(tuple.getString("Target_Identifier"));			
			if( tuple.getObject("ObservationSet_Target_Identifier") != null ) this.setTarget_Identifier(tuple.getString("ObservationSet_Target_Identifier"));		
			//set Time
			if( strict || tuple.getTimestamp("Time") != null) this.setTime(tuple.getTimestamp("Time"));
			if( tuple.getTimestamp("ObservationSet_Time") != null) this.setTime(tuple.getTimestamp("ObservationSet_Time"));
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
		String result = "ObservationSet(";
		result+= "id='" + getId()+"' ";	
		result+= " partOfDataSet_id='" + getPartOfDataSet_Id()+"' ";	
		result+= " partOfDataSet_identifier='" + getPartOfDataSet_Identifier()+"' ";
		result+= " target_id='" + getTarget_Id()+"' ";	
		result+= " target_identifier='" + getTarget_Identifier()+"' ";
		result+= "time='" + (getTime() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy, HH:mm:ss", java.util.Locale.US).format(getTime()))+"'";
		result+= "time='" + (getTime() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy", java.util.Locale.US).format(getTime()))+"'";		
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of ObservationSet.
	 */
	public java.util.Vector<String> getFields(boolean skipAutoIds)
	{
		java.util.Vector<String> fields = new java.util.Vector<String>();
		if(!skipAutoIds)
		{
			fields.add("id");
		}
		{
			fields.add("partOfDataSet_id");
		}
		fields.add("partOfDataSet_identifier");
		{
			fields.add("target_id");
		}
		fields.add("target_identifier");
		{
			fields.add("time");
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
		+ "partOfDataSet" +sep
		+ "target" +sep
		+ "time" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("partOfDataSet")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("target")) {
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
		ObservationSet rhs = (ObservationSet) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
		//partOfDataSet
		//target
		//time
				.append(time, rhs.getTime())
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
				.append(time)
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
			Object valueO = getPartOfDataSet();
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
			Object valueO = getTarget();
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
			Object valueO = getTime();
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
	public ObservationSet create(org.molgenis.util.Tuple tuple) throws Exception
	{
		ObservationSet e = new ObservationSet();
		e.set(tuple);
		return e;
	}
	
//1
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="observationSet"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.observ.ObservedValue> observationSetObservedValueCollection = new java.util.ArrayList<org.molgenis.observ.ObservedValue>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.observ.ObservedValue> getObservationSetObservedValueCollection()
	{
            return observationSetObservedValueCollection;
	}

    public void setObservationSetObservedValueCollection(java.util.Collection<org.molgenis.observ.ObservedValue> collection)
    {
        for (org.molgenis.observ.ObservedValue observedValue : collection) {
            observedValue.setObservationSet(this);
        }
        observationSetObservedValueCollection = collection;
    }	

	
}

