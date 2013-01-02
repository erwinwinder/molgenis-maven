
/* File:        org.molgenis.omx/model/Significance.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.gwascentral;

/**
 * Significance: .
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "Significance"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.gwascentral.db.SignificanceEntityListener.class})
public class Significance extends org.molgenis.observ.DataSet implements org.molgenis.core.Autoid
{
	// fieldname constants
	public final static String ID = "id";
	public final static String USEDMARKERSETID = "UsedmarkersetID";
	public final static String USEDMARKERSETID_IDENTIFIER = "UsedmarkersetID_Identifier";
	public final static String NEGLOGPVALUE = "NegLogPValue";
	public final static String UNADJUSTEDPVALUE = "UnadjustedPValue";
	public final static String ADJUSTEDPVALUE = "AdjustedPValue";
	
	//static methods
	/**
	 * Shorthand for db.query(Significance.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Significance> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Significance.class);
	}
	
	/**
	 * Shorthand for db.find(Significance.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Significance> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Significance.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Significance findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Significance> q = db.query(Significance.class);
		q.eq(Significance.ID, id);
		java.util.List<Significance> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Significance findByIdentifier(org.molgenis.framework.db.Database db, String identifier) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Significance> q = db.query(Significance.class);
		q.eq(Significance.IDENTIFIER, identifier);
		java.util.List<Significance> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//automatically generated internal id, only for internal use.[type=int]
	


	//Used marker set ID[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="UsedmarkersetID", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.gwascentral.UsedMarkerSet usedmarkersetID = null;
	@javax.persistence.Transient
	private Integer usedmarkersetID_id = null;	
	@javax.persistence.Transient
	private String usedmarkersetID_Identifier = null;						


	//Negative log p-value[type=decimal]
	@javax.persistence.Column(name="NegLogPValue")
	@javax.xml.bind.annotation.XmlElement(name="negLogPValue")
	
				

	private Double negLogPValue =  null;


	//Unadjusted p-value[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="UnadjustedPValue", length=16777216)
	
				

	private String unadjustedPValue =  null;


	//Adjusted p-value[type=decimal]
	@javax.persistence.Column(name="AdjustedPValue")
	@javax.xml.bind.annotation.XmlElement(name="adjustedPValue")
	
				

	private Double adjustedPValue =  null;

	//constructors
	public Significance()
	{
		//set the type for a new instance
		set__Type(this.getClass().getSimpleName());
	
	}
	
	//getters and setters
	

	

	/**
	 * Get the Used marker set ID.
	 * @return usedmarkersetID.
	 */
	public org.molgenis.gwascentral.UsedMarkerSet getUsedmarkersetID()
	{
		return this.usedmarkersetID;
	}
	
	@Deprecated
	public org.molgenis.gwascentral.UsedMarkerSet getUsedmarkersetID(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Used marker set ID.
	 * @param usedmarkersetID
	 */
	public void setUsedmarkersetID( org.molgenis.gwascentral.UsedMarkerSet usedmarkersetID)
	{
		
		this.usedmarkersetID = usedmarkersetID;
	}

	
	
	/**
	 * Set foreign key for field usedmarkersetID.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setUsedmarkersetID_Id(Integer usedmarkersetID_id)
	{
		this.usedmarkersetID_id = usedmarkersetID_id;
	}	

	public void setUsedmarkersetID(Integer usedmarkersetID_id)
	{
		this.usedmarkersetID_id = usedmarkersetID_id;
	}
	
	public Integer getUsedmarkersetID_Id()
	{
		
		if(usedmarkersetID != null) 
		{
			return usedmarkersetID.getId();
		}
		else
		{
			return usedmarkersetID_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference UsedmarkersetID to UsedMarkerSet.Id.
	 */
	public String getUsedmarkersetID_Identifier()
	{		
		//FIXME should we auto-load based on getUsedmarkersetID()?	
		if(usedmarkersetID != null) {
			return usedmarkersetID.getIdentifier();
		} else {
			return usedmarkersetID_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference UsedmarkersetID to <a href="UsedMarkerSet.html#Id">UsedMarkerSet.Id</a>.
	 * Implies setUsedmarkersetID(null) until save
	 */
	public void setUsedmarkersetID_Identifier(String usedmarkersetID_Identifier)
	{
		this.usedmarkersetID_Identifier = usedmarkersetID_Identifier;
	}		
	 
	

	/**
	 * Get the Negative log p-value.
	 * @return negLogPValue.
	 */
	public Double getNegLogPValue()
	{
		return this.negLogPValue;
	}
	
	@Deprecated
	public Double getNegLogPValue(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Negative log p-value.
	 * @param negLogPValue
	 */
	public void setNegLogPValue( Double negLogPValue)
	{
		
		this.negLogPValue = negLogPValue;
	}

	

	/**
	 * Get the Unadjusted p-value.
	 * @return unadjustedPValue.
	 */
	public String getUnadjustedPValue()
	{
		return this.unadjustedPValue;
	}
	
	@Deprecated
	public String getUnadjustedPValue(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Unadjusted p-value.
	 * @param unadjustedPValue
	 */
	public void setUnadjustedPValue( String unadjustedPValue)
	{
		
		this.unadjustedPValue = unadjustedPValue;
	}

	

	/**
	 * Get the Adjusted p-value.
	 * @return adjustedPValue.
	 */
	public Double getAdjustedPValue()
	{
		return this.adjustedPValue;
	}
	
	@Deprecated
	public Double getAdjustedPValue(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Adjusted p-value.
	 * @param adjustedPValue
	 */
	public void setAdjustedPValue( Double adjustedPValue)
	{
		
		this.adjustedPValue = adjustedPValue;
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
		if (name.toLowerCase().equals("usedmarkersetid"))
			return getUsedmarkersetID();
		if(name.toLowerCase().equals("usedmarkersetid_id"))
			return getUsedmarkersetID_Id();
		if(name.toLowerCase().equals("usedmarkersetid_identifier"))
			return getUsedmarkersetID_Identifier();
		if (name.toLowerCase().equals("neglogpvalue"))
			return getNegLogPValue();
		if (name.toLowerCase().equals("unadjustedpvalue"))
			return getUnadjustedPValue();
		if (name.toLowerCase().equals("adjustedpvalue"))
			return getAdjustedPValue();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getIdentifier() == null) throw new org.molgenis.framework.db.DatabaseException("required field identifier is null");
		if(this.getName() == null) throw new org.molgenis.framework.db.DatabaseException("required field name is null");
		if(this.get__Type() == null) throw new org.molgenis.framework.db.DatabaseException("required field __Type is null");
		if(this.getStartTime() == null) throw new org.molgenis.framework.db.DatabaseException("required field startTime is null");
		if(this.getUsedmarkersetID() == null) throw new org.molgenis.framework.db.DatabaseException("required field usedmarkersetID is null");
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
			//set UsedmarkersetID
			this.setUsedmarkersetID(tuple.getInt("UsedmarkersetID"));
			//set label Identifier for xref field UsedmarkersetID
			this.setUsedmarkersetID_Identifier(tuple.getString("UsedmarkersetID_Identifier"));	
			//set NegLogPValue
			this.setNegLogPValue(tuple.getDouble("NegLogPValue"));
			//set UnadjustedPValue
			this.setUnadjustedPValue(tuple.getString("UnadjustedPValue"));
			//set AdjustedPValue
			this.setAdjustedPValue(tuple.getDouble("AdjustedPValue"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("Significance_id") != null) this.setId(tuple.getInt("Significance_id"));
			//set Identifier
			if( strict || tuple.getString("Identifier") != null) this.setIdentifier(tuple.getString("Identifier"));
			if( tuple.getString("Significance_Identifier") != null) this.setIdentifier(tuple.getString("Significance_Identifier"));
			//set Name
			if( strict || tuple.getString("Name") != null) this.setName(tuple.getString("Name"));
			if( tuple.getString("Significance_Name") != null) this.setName(tuple.getString("Significance_Name"));
			//set __Type
			if( strict || tuple.getString("__Type") != null) this.set__Type(tuple.getString("__Type"));
			if( tuple.getString("Significance___Type") != null) this.set__Type(tuple.getString("Significance___Type"));
			//set Description
			if( strict || tuple.getString("description") != null) this.setDescription(tuple.getString("description"));
			if( tuple.getString("Significance_description") != null) this.setDescription(tuple.getString("Significance_description"));
			//set ProtocolUsed
			if( strict || tuple.getInt("ProtocolUsed_id") != null) this.setProtocolUsed(tuple.getInt("ProtocolUsed_id"));
			if( tuple.getInt("Significance_ProtocolUsed_id") != null) this.setProtocolUsed(tuple.getInt("Significance_ProtocolUsed_id"));
			//alias of xref
			if( tuple.getObject("ProtocolUsed") != null) this.setProtocolUsed(tuple.getInt("ProtocolUsed"));
			if( tuple.getObject("Significance_ProtocolUsed") != null) this.setProtocolUsed(tuple.getInt("Significance_ProtocolUsed"));
			//set label for field ProtocolUsed
			if( strict || tuple.getObject("ProtocolUsed_Identifier") != null) this.setProtocolUsed_Identifier(tuple.getString("ProtocolUsed_Identifier"));			
			if( tuple.getObject("Significance_ProtocolUsed_Identifier") != null ) this.setProtocolUsed_Identifier(tuple.getString("Significance_ProtocolUsed_Identifier"));		
			//set StartTime
			if( strict || tuple.getTimestamp("startTime") != null) this.setStartTime(tuple.getTimestamp("startTime"));
			if( tuple.getTimestamp("Significance_startTime") != null) this.setStartTime(tuple.getTimestamp("Significance_startTime"));
			//set EndTime
			if( strict || tuple.getTimestamp("endTime") != null) this.setEndTime(tuple.getTimestamp("endTime"));
			if( tuple.getTimestamp("Significance_endTime") != null) this.setEndTime(tuple.getTimestamp("Significance_endTime"));
			//set UsedmarkersetID
			if( strict || tuple.getInt("UsedmarkersetID_id") != null) this.setUsedmarkersetID(tuple.getInt("UsedmarkersetID_id"));
			if( tuple.getInt("Significance_UsedmarkersetID_id") != null) this.setUsedmarkersetID(tuple.getInt("Significance_UsedmarkersetID_id"));
			//alias of xref
			if( tuple.getObject("UsedmarkersetID") != null) this.setUsedmarkersetID(tuple.getInt("UsedmarkersetID"));
			if( tuple.getObject("Significance_UsedmarkersetID") != null) this.setUsedmarkersetID(tuple.getInt("Significance_UsedmarkersetID"));
			//set label for field UsedmarkersetID
			if( strict || tuple.getObject("UsedmarkersetID_Identifier") != null) this.setUsedmarkersetID_Identifier(tuple.getString("UsedmarkersetID_Identifier"));			
			if( tuple.getObject("Significance_UsedmarkersetID_Identifier") != null ) this.setUsedmarkersetID_Identifier(tuple.getString("Significance_UsedmarkersetID_Identifier"));		
			//set NegLogPValue
			if( strict || tuple.getDouble("NegLogPValue") != null) this.setNegLogPValue(tuple.getDouble("NegLogPValue"));
			if( tuple.getDouble("Significance_NegLogPValue") != null) this.setNegLogPValue(tuple.getDouble("Significance_NegLogPValue"));
			//set UnadjustedPValue
			if( strict || tuple.getString("UnadjustedPValue") != null) this.setUnadjustedPValue(tuple.getString("UnadjustedPValue"));
			if( tuple.getString("Significance_UnadjustedPValue") != null) this.setUnadjustedPValue(tuple.getString("Significance_UnadjustedPValue"));
			//set AdjustedPValue
			if( strict || tuple.getDouble("AdjustedPValue") != null) this.setAdjustedPValue(tuple.getDouble("AdjustedPValue"));
			if( tuple.getDouble("Significance_AdjustedPValue") != null) this.setAdjustedPValue(tuple.getDouble("Significance_AdjustedPValue"));
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
		String result = "Significance(";
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
		result+= " usedmarkersetID_id='" + getUsedmarkersetID_Id()+"' ";	
		result+= " usedmarkersetID_identifier='" + getUsedmarkersetID_Identifier()+"' ";
		result+= "negLogPValue='" + getNegLogPValue()+"' ";	
		result+= "unadjustedPValue='" + getUnadjustedPValue()+"' ";	
		result+= "adjustedPValue='" + getAdjustedPValue()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Significance.
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
			fields.add("usedmarkersetID_id");
		}
		fields.add("usedmarkersetID_identifier");
		{
			fields.add("negLogPValue");
		}
		{
			fields.add("unadjustedPValue");
		}
		{
			fields.add("adjustedPValue");
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
		+ "usedmarkersetID" +sep
		+ "negLogPValue" +sep
		+ "unadjustedPValue" +sep
		+ "adjustedPValue" 
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
        if (fieldName.equalsIgnoreCase("usedmarkersetID")) {
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
		Significance rhs = (Significance) obj;
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
			Object valueO = getUsedmarkersetID();
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
			Object valueO = getNegLogPValue();
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
			Object valueO = getUnadjustedPValue();
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
			Object valueO = getAdjustedPValue();
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
	public Significance create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Significance e = new Significance();
		e.set(tuple);
		return e;
	}
	

	
}

