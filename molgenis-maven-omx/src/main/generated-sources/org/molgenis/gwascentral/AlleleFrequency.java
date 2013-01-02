
/* File:        org.molgenis.omx/model/AlleleFrequency.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.gwascentral;

/**
 * AlleleFrequency: .
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "AlleleFrequency"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.gwascentral.db.AlleleFrequencyEntityListener.class})
public class AlleleFrequency extends org.molgenis.observ.DataSet 
{
	// fieldname constants
	public final static String FREQUENCYCLUSTER = "FrequencyCluster";
	public final static String FREQUENCYCLUSTER_IDENTIFIER = "FrequencyCluster_Identifier";
	public final static String ALLELECOMBO = "AlleleCombo";
	public final static String FREQUENCYASPROPORTION = "FrequencyAsProportion";
	public final static String ID = "id";
	
	//static methods
	/**
	 * Shorthand for db.query(AlleleFrequency.class).
	 */
	public static org.molgenis.framework.db.Query<? extends AlleleFrequency> query(org.molgenis.framework.db.Database db)
	{
		return db.query(AlleleFrequency.class);
	}
	
	/**
	 * Shorthand for db.find(AlleleFrequency.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends AlleleFrequency> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(AlleleFrequency.class, rules);
	}	
	
	/**
	 * 
	 */
	public static AlleleFrequency findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<AlleleFrequency> q = db.query(AlleleFrequency.class);
		q.eq(AlleleFrequency.ID, id);
		java.util.List<AlleleFrequency> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static AlleleFrequency findByIdentifier(org.molgenis.framework.db.Database db, String identifier) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<AlleleFrequency> q = db.query(AlleleFrequency.class);
		q.eq(AlleleFrequency.IDENTIFIER, identifier);
		java.util.List<AlleleFrequency> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//Frequency cluster ID[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="FrequencyCluster")   	
	
				

	private org.molgenis.gwascentral.FrequencyCluster frequencyCluster = null;
	@javax.persistence.Transient
	private Integer frequencyCluster_id = null;	
	@javax.persistence.Transient
	private String frequencyCluster_Identifier = null;						


	//Allele combo[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="AlleleCombo", length=16777216)
	
				

	private String alleleCombo =  null;


	//Frequency as proportion[type=decimal]
	@javax.persistence.Column(name="FrequencyAsProportion", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="frequencyAsProportion")
	
				

	@javax.validation.constraints.NotNull
	private Double frequencyAsProportion =  null;


	//automatically generated internal id, only for internal use.[type=int]
	

	//constructors
	public AlleleFrequency()
	{
		//set the type for a new instance
		set__Type(this.getClass().getSimpleName());
	
	}
	
	//getters and setters
	/**
	 * Get the Frequency cluster ID.
	 * @return frequencyCluster.
	 */
	public org.molgenis.gwascentral.FrequencyCluster getFrequencyCluster()
	{
		return this.frequencyCluster;
	}
	
	@Deprecated
	public org.molgenis.gwascentral.FrequencyCluster getFrequencyCluster(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Frequency cluster ID.
	 * @param frequencyCluster
	 */
	public void setFrequencyCluster( org.molgenis.gwascentral.FrequencyCluster frequencyCluster)
	{
		
		this.frequencyCluster = frequencyCluster;
	}

	
	
	/**
	 * Set foreign key for field frequencyCluster.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setFrequencyCluster_Id(Integer frequencyCluster_id)
	{
		this.frequencyCluster_id = frequencyCluster_id;
	}	

	public void setFrequencyCluster(Integer frequencyCluster_id)
	{
		this.frequencyCluster_id = frequencyCluster_id;
	}
	
	public Integer getFrequencyCluster_Id()
	{
		
		if(frequencyCluster != null) 
		{
			return frequencyCluster.getId();
		}
		else
		{
			return frequencyCluster_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference FrequencyCluster to FrequencyCluster.Id.
	 */
	public String getFrequencyCluster_Identifier()
	{		
		//FIXME should we auto-load based on getFrequencyCluster()?	
		if(frequencyCluster != null) {
			return frequencyCluster.getIdentifier();
		} else {
			return frequencyCluster_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference FrequencyCluster to <a href="FrequencyCluster.html#Id">FrequencyCluster.Id</a>.
	 * Implies setFrequencyCluster(null) until save
	 */
	public void setFrequencyCluster_Identifier(String frequencyCluster_Identifier)
	{
		this.frequencyCluster_Identifier = frequencyCluster_Identifier;
	}		
	 
	

	/**
	 * Get the Allele combo.
	 * @return alleleCombo.
	 */
	public String getAlleleCombo()
	{
		return this.alleleCombo;
	}
	
	@Deprecated
	public String getAlleleCombo(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Allele combo.
	 * @param alleleCombo
	 */
	public void setAlleleCombo( String alleleCombo)
	{
		
		this.alleleCombo = alleleCombo;
	}

	

	/**
	 * Get the Frequency as proportion.
	 * @return frequencyAsProportion.
	 */
	public Double getFrequencyAsProportion()
	{
		return this.frequencyAsProportion;
	}
	
	@Deprecated
	public Double getFrequencyAsProportion(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Frequency as proportion.
	 * @param frequencyAsProportion
	 */
	public void setFrequencyAsProportion( Double frequencyAsProportion)
	{
		
		this.frequencyAsProportion = frequencyAsProportion;
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
		if (name.toLowerCase().equals("frequencycluster"))
			return getFrequencyCluster();
		if(name.toLowerCase().equals("frequencycluster_id"))
			return getFrequencyCluster_Id();
		if(name.toLowerCase().equals("frequencycluster_identifier"))
			return getFrequencyCluster_Identifier();
		if (name.toLowerCase().equals("allelecombo"))
			return getAlleleCombo();
		if (name.toLowerCase().equals("frequencyasproportion"))
			return getFrequencyAsProportion();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getIdentifier() == null) throw new org.molgenis.framework.db.DatabaseException("required field identifier is null");
		if(this.getName() == null) throw new org.molgenis.framework.db.DatabaseException("required field name is null");
		if(this.get__Type() == null) throw new org.molgenis.framework.db.DatabaseException("required field __Type is null");
		if(this.getStartTime() == null) throw new org.molgenis.framework.db.DatabaseException("required field startTime is null");
		if(this.getFrequencyAsProportion() == null) throw new org.molgenis.framework.db.DatabaseException("required field frequencyAsProportion is null");
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
			//set FrequencyCluster
			this.setFrequencyCluster(tuple.getInt("FrequencyCluster"));
			//set label Identifier for xref field FrequencyCluster
			this.setFrequencyCluster_Identifier(tuple.getString("FrequencyCluster_Identifier"));	
			//set AlleleCombo
			this.setAlleleCombo(tuple.getString("AlleleCombo"));
			//set FrequencyAsProportion
			this.setFrequencyAsProportion(tuple.getDouble("FrequencyAsProportion"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("AlleleFrequency_id") != null) this.setId(tuple.getInt("AlleleFrequency_id"));
			//set Identifier
			if( strict || tuple.getString("Identifier") != null) this.setIdentifier(tuple.getString("Identifier"));
			if( tuple.getString("AlleleFrequency_Identifier") != null) this.setIdentifier(tuple.getString("AlleleFrequency_Identifier"));
			//set Name
			if( strict || tuple.getString("Name") != null) this.setName(tuple.getString("Name"));
			if( tuple.getString("AlleleFrequency_Name") != null) this.setName(tuple.getString("AlleleFrequency_Name"));
			//set __Type
			if( strict || tuple.getString("__Type") != null) this.set__Type(tuple.getString("__Type"));
			if( tuple.getString("AlleleFrequency___Type") != null) this.set__Type(tuple.getString("AlleleFrequency___Type"));
			//set Description
			if( strict || tuple.getString("description") != null) this.setDescription(tuple.getString("description"));
			if( tuple.getString("AlleleFrequency_description") != null) this.setDescription(tuple.getString("AlleleFrequency_description"));
			//set ProtocolUsed
			if( strict || tuple.getInt("ProtocolUsed_id") != null) this.setProtocolUsed(tuple.getInt("ProtocolUsed_id"));
			if( tuple.getInt("AlleleFrequency_ProtocolUsed_id") != null) this.setProtocolUsed(tuple.getInt("AlleleFrequency_ProtocolUsed_id"));
			//alias of xref
			if( tuple.getObject("ProtocolUsed") != null) this.setProtocolUsed(tuple.getInt("ProtocolUsed"));
			if( tuple.getObject("AlleleFrequency_ProtocolUsed") != null) this.setProtocolUsed(tuple.getInt("AlleleFrequency_ProtocolUsed"));
			//set label for field ProtocolUsed
			if( strict || tuple.getObject("ProtocolUsed_Identifier") != null) this.setProtocolUsed_Identifier(tuple.getString("ProtocolUsed_Identifier"));			
			if( tuple.getObject("AlleleFrequency_ProtocolUsed_Identifier") != null ) this.setProtocolUsed_Identifier(tuple.getString("AlleleFrequency_ProtocolUsed_Identifier"));		
			//set StartTime
			if( strict || tuple.getTimestamp("startTime") != null) this.setStartTime(tuple.getTimestamp("startTime"));
			if( tuple.getTimestamp("AlleleFrequency_startTime") != null) this.setStartTime(tuple.getTimestamp("AlleleFrequency_startTime"));
			//set EndTime
			if( strict || tuple.getTimestamp("endTime") != null) this.setEndTime(tuple.getTimestamp("endTime"));
			if( tuple.getTimestamp("AlleleFrequency_endTime") != null) this.setEndTime(tuple.getTimestamp("AlleleFrequency_endTime"));
			//set FrequencyCluster
			if( strict || tuple.getInt("FrequencyCluster_id") != null) this.setFrequencyCluster(tuple.getInt("FrequencyCluster_id"));
			if( tuple.getInt("AlleleFrequency_FrequencyCluster_id") != null) this.setFrequencyCluster(tuple.getInt("AlleleFrequency_FrequencyCluster_id"));
			//alias of xref
			if( tuple.getObject("FrequencyCluster") != null) this.setFrequencyCluster(tuple.getInt("FrequencyCluster"));
			if( tuple.getObject("AlleleFrequency_FrequencyCluster") != null) this.setFrequencyCluster(tuple.getInt("AlleleFrequency_FrequencyCluster"));
			//set label for field FrequencyCluster
			if( strict || tuple.getObject("FrequencyCluster_Identifier") != null) this.setFrequencyCluster_Identifier(tuple.getString("FrequencyCluster_Identifier"));			
			if( tuple.getObject("AlleleFrequency_FrequencyCluster_Identifier") != null ) this.setFrequencyCluster_Identifier(tuple.getString("AlleleFrequency_FrequencyCluster_Identifier"));		
			//set AlleleCombo
			if( strict || tuple.getString("AlleleCombo") != null) this.setAlleleCombo(tuple.getString("AlleleCombo"));
			if( tuple.getString("AlleleFrequency_AlleleCombo") != null) this.setAlleleCombo(tuple.getString("AlleleFrequency_AlleleCombo"));
			//set FrequencyAsProportion
			if( strict || tuple.getDouble("FrequencyAsProportion") != null) this.setFrequencyAsProportion(tuple.getDouble("FrequencyAsProportion"));
			if( tuple.getDouble("AlleleFrequency_FrequencyAsProportion") != null) this.setFrequencyAsProportion(tuple.getDouble("AlleleFrequency_FrequencyAsProportion"));
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
		String result = "AlleleFrequency(";
		result+= "id='" + getId()+"' ";	
		result+= "identifier='" + getIdentifier()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= "__Type='" + get__Type()+"' ";	
		result+= "description='" + getDescription()+"' ";	
		result+= " protocolUsed_id='" + getProtocolUsed_Id()+"' ";	
		result+= " protocolUsed_identifier='" + getProtocolUsed_Identifier()+"' ";
		result+= "startTime='" + (getStartTime() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy, HH:mm:ss", java.util.Locale.US).format(getStartTime()))+"' ";
		result+= "startTime='" + (getStartTime() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy", java.util.Locale.US).format(getStartTime()))+"' ";		
		result+= "endTime='" + (getEndTime() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy, HH:mm:ss", java.util.Locale.US).format(getEndTime()))+"' ";
		result+= "endTime='" + (getEndTime() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy", java.util.Locale.US).format(getEndTime()))+"' ";		
		result+= " frequencyCluster_id='" + getFrequencyCluster_Id()+"' ";	
		result+= " frequencyCluster_identifier='" + getFrequencyCluster_Identifier()+"' ";
		result+= "alleleCombo='" + getAlleleCombo()+"' ";	
		result+= "frequencyAsProportion='" + getFrequencyAsProportion()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of AlleleFrequency.
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
		{
			fields.add("frequencyCluster_id");
		}
		fields.add("frequencyCluster_identifier");
		{
			fields.add("alleleCombo");
		}
		{
			fields.add("frequencyAsProportion");
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
		+ "endTime" +sep
		+ "frequencyCluster" +sep
		+ "alleleCombo" +sep
		+ "frequencyAsProportion" 
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
        if (fieldName.equalsIgnoreCase("frequencyCluster")) {
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
		AlleleFrequency rhs = (AlleleFrequency) obj;
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
			out.write(valueS+sep);
		}
		{
			Object valueO = getFrequencyCluster();
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
			Object valueO = getAlleleCombo();
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
			Object valueO = getFrequencyAsProportion();
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
	public AlleleFrequency create(org.molgenis.util.Tuple tuple) throws Exception
	{
		AlleleFrequency e = new AlleleFrequency();
		e.set(tuple);
		return e;
	}
	

	
}

