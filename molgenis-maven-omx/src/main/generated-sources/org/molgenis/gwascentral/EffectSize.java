
/* File:        org.molgenis/model/EffectSize.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.gwascentral;

/**
 * EffectSize: .
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "EffectSize"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.gwascentral.db.EffectSizeEntityListener.class})
public class EffectSize extends org.molgenis.observ.DataSet 
{
	// fieldname constants
	public final static String USEDMARKERSETID = "UsedMarkerSetID";
	public final static String USEDMARKERSETID_IDENTIFIER = "UsedMarkerSetID_Identifier";
	public final static String LOWER95BOUND = "Lower95Bound";
	public final static String UPPER95BOUND = "Upper95Bound";
	public final static String STDERROR = "StdError";
	public final static String ID = "id";
	
	//static methods
	/**
	 * Shorthand for db.query(EffectSize.class).
	 */
	public static org.molgenis.framework.db.Query<? extends EffectSize> query(org.molgenis.framework.db.Database db)
	{
		return db.query(EffectSize.class);
	}
	
	/**
	 * Shorthand for db.find(EffectSize.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends EffectSize> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(EffectSize.class, rules);
	}	
	
	/**
	 * 
	 */
	public static EffectSize findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<EffectSize> q = db.query(EffectSize.class);
		q.eq(EffectSize.ID, id);
		java.util.List<EffectSize> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static EffectSize findByIdentifier(org.molgenis.framework.db.Database db, String identifier) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<EffectSize> q = db.query(EffectSize.class);
		q.eq(EffectSize.IDENTIFIER, identifier);
		java.util.List<EffectSize> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//Used Marker ID[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="UsedMarkerSetID")   	
	
				

	private org.molgenis.gwascentral.UsedMarkerSet usedMarkerSetID = null;
	@javax.persistence.Transient
	private Integer usedMarkerSetID_id = null;	
	@javax.persistence.Transient
	private String usedMarkerSetID_Identifier = null;						


	//Lower95Bound[type=decimal]
	@javax.persistence.Column(name="Lower95Bound", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="lower95Bound")
	
				

	@javax.validation.constraints.NotNull
	private Double lower95Bound =  null;


	//Upper95Bound[type=decimal]
	@javax.persistence.Column(name="Upper95Bound", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="upper95Bound")
	
				

	@javax.validation.constraints.NotNull
	private Double upper95Bound =  null;


	//StdError[type=decimal]
	@javax.persistence.Column(name="StdError", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="stdError")
	
				

	@javax.validation.constraints.NotNull
	private Double stdError =  null;


	//automatically generated internal id, only for internal use.[type=int]
	

	//constructors
	public EffectSize()
	{
		//set the type for a new instance
		set__Type(this.getClass().getSimpleName());
	
	}
	
	//getters and setters
	/**
	 * Get the Used Marker ID.
	 * @return usedMarkerSetID.
	 */
	public org.molgenis.gwascentral.UsedMarkerSet getUsedMarkerSetID()
	{
		return this.usedMarkerSetID;
	}
	
	@Deprecated
	public org.molgenis.gwascentral.UsedMarkerSet getUsedMarkerSetID(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Used Marker ID.
	 * @param usedMarkerSetID
	 */
	public void setUsedMarkerSetID( org.molgenis.gwascentral.UsedMarkerSet usedMarkerSetID)
	{
		
		this.usedMarkerSetID = usedMarkerSetID;
	}

	
	
	/**
	 * Set foreign key for field usedMarkerSetID.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setUsedMarkerSetID_Id(Integer usedMarkerSetID_id)
	{
		this.usedMarkerSetID_id = usedMarkerSetID_id;
	}	

	public void setUsedMarkerSetID(Integer usedMarkerSetID_id)
	{
		this.usedMarkerSetID_id = usedMarkerSetID_id;
	}
	
	public Integer getUsedMarkerSetID_Id()
	{
		
		if(usedMarkerSetID != null) 
		{
			return usedMarkerSetID.getId();
		}
		else
		{
			return usedMarkerSetID_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference UsedMarkerSetID to UsedMarkerSet.Id.
	 */
	public String getUsedMarkerSetID_Identifier()
	{		
		//FIXME should we auto-load based on getUsedMarkerSetID()?	
		if(usedMarkerSetID != null) {
			return usedMarkerSetID.getIdentifier();
		} else {
			return usedMarkerSetID_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference UsedMarkerSetID to <a href="UsedMarkerSet.html#Id">UsedMarkerSet.Id</a>.
	 * Implies setUsedMarkerSetID(null) until save
	 */
	public void setUsedMarkerSetID_Identifier(String usedMarkerSetID_Identifier)
	{
		this.usedMarkerSetID_Identifier = usedMarkerSetID_Identifier;
	}		
	 
	

	/**
	 * Get the Lower95Bound.
	 * @return lower95Bound.
	 */
	public Double getLower95Bound()
	{
		return this.lower95Bound;
	}
	
	@Deprecated
	public Double getLower95Bound(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Lower95Bound.
	 * @param lower95Bound
	 */
	public void setLower95Bound( Double lower95Bound)
	{
		
		this.lower95Bound = lower95Bound;
	}

	

	/**
	 * Get the Upper95Bound.
	 * @return upper95Bound.
	 */
	public Double getUpper95Bound()
	{
		return this.upper95Bound;
	}
	
	@Deprecated
	public Double getUpper95Bound(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Upper95Bound.
	 * @param upper95Bound
	 */
	public void setUpper95Bound( Double upper95Bound)
	{
		
		this.upper95Bound = upper95Bound;
	}

	

	/**
	 * Get the StdError.
	 * @return stdError.
	 */
	public Double getStdError()
	{
		return this.stdError;
	}
	
	@Deprecated
	public Double getStdError(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the StdError.
	 * @param stdError
	 */
	public void setStdError( Double stdError)
	{
		
		this.stdError = stdError;
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
			return getUsedMarkerSetID();
		if(name.toLowerCase().equals("usedmarkersetid_id"))
			return getUsedMarkerSetID_Id();
		if(name.toLowerCase().equals("usedmarkersetid_identifier"))
			return getUsedMarkerSetID_Identifier();
		if (name.toLowerCase().equals("lower95bound"))
			return getLower95Bound();
		if (name.toLowerCase().equals("upper95bound"))
			return getUpper95Bound();
		if (name.toLowerCase().equals("stderror"))
			return getStdError();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getIdentifier() == null) throw new org.molgenis.framework.db.DatabaseException("required field identifier is null");
		if(this.getName() == null) throw new org.molgenis.framework.db.DatabaseException("required field name is null");
		if(this.get__Type() == null) throw new org.molgenis.framework.db.DatabaseException("required field __Type is null");
		if(this.getStartTime() == null) throw new org.molgenis.framework.db.DatabaseException("required field startTime is null");
		if(this.getLower95Bound() == null) throw new org.molgenis.framework.db.DatabaseException("required field lower95Bound is null");
		if(this.getUpper95Bound() == null) throw new org.molgenis.framework.db.DatabaseException("required field upper95Bound is null");
		if(this.getStdError() == null) throw new org.molgenis.framework.db.DatabaseException("required field stdError is null");
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
			//set UsedMarkerSetID
			this.setUsedMarkerSetID(tuple.getInt("UsedMarkerSetID"));
			//set label Identifier for xref field UsedMarkerSetID
			this.setUsedMarkerSetID_Identifier(tuple.getString("UsedMarkerSetID_Identifier"));	
			//set Lower95Bound
			this.setLower95Bound(tuple.getDouble("Lower95Bound"));
			//set Upper95Bound
			this.setUpper95Bound(tuple.getDouble("Upper95Bound"));
			//set StdError
			this.setStdError(tuple.getDouble("StdError"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("EffectSize_id") != null) this.setId(tuple.getInt("EffectSize_id"));
			//set Identifier
			if( strict || tuple.getString("Identifier") != null) this.setIdentifier(tuple.getString("Identifier"));
			if( tuple.getString("EffectSize_Identifier") != null) this.setIdentifier(tuple.getString("EffectSize_Identifier"));
			//set Name
			if( strict || tuple.getString("Name") != null) this.setName(tuple.getString("Name"));
			if( tuple.getString("EffectSize_Name") != null) this.setName(tuple.getString("EffectSize_Name"));
			//set __Type
			if( strict || tuple.getString("__Type") != null) this.set__Type(tuple.getString("__Type"));
			if( tuple.getString("EffectSize___Type") != null) this.set__Type(tuple.getString("EffectSize___Type"));
			//set Description
			if( strict || tuple.getString("description") != null) this.setDescription(tuple.getString("description"));
			if( tuple.getString("EffectSize_description") != null) this.setDescription(tuple.getString("EffectSize_description"));
			//set ProtocolUsed
			if( strict || tuple.getInt("ProtocolUsed_id") != null) this.setProtocolUsed(tuple.getInt("ProtocolUsed_id"));
			if( tuple.getInt("EffectSize_ProtocolUsed_id") != null) this.setProtocolUsed(tuple.getInt("EffectSize_ProtocolUsed_id"));
			//alias of xref
			if( tuple.getObject("ProtocolUsed") != null) this.setProtocolUsed(tuple.getInt("ProtocolUsed"));
			if( tuple.getObject("EffectSize_ProtocolUsed") != null) this.setProtocolUsed(tuple.getInt("EffectSize_ProtocolUsed"));
			//set label for field ProtocolUsed
			if( strict || tuple.getObject("ProtocolUsed_Identifier") != null) this.setProtocolUsed_Identifier(tuple.getString("ProtocolUsed_Identifier"));			
			if( tuple.getObject("EffectSize_ProtocolUsed_Identifier") != null ) this.setProtocolUsed_Identifier(tuple.getString("EffectSize_ProtocolUsed_Identifier"));		
			//set StartTime
			if( strict || tuple.getTimestamp("startTime") != null) this.setStartTime(tuple.getTimestamp("startTime"));
			if( tuple.getTimestamp("EffectSize_startTime") != null) this.setStartTime(tuple.getTimestamp("EffectSize_startTime"));
			//set EndTime
			if( strict || tuple.getTimestamp("endTime") != null) this.setEndTime(tuple.getTimestamp("endTime"));
			if( tuple.getTimestamp("EffectSize_endTime") != null) this.setEndTime(tuple.getTimestamp("EffectSize_endTime"));
			//set UsedMarkerSetID
			if( strict || tuple.getInt("UsedMarkerSetID_id") != null) this.setUsedMarkerSetID(tuple.getInt("UsedMarkerSetID_id"));
			if( tuple.getInt("EffectSize_UsedMarkerSetID_id") != null) this.setUsedMarkerSetID(tuple.getInt("EffectSize_UsedMarkerSetID_id"));
			//alias of xref
			if( tuple.getObject("UsedMarkerSetID") != null) this.setUsedMarkerSetID(tuple.getInt("UsedMarkerSetID"));
			if( tuple.getObject("EffectSize_UsedMarkerSetID") != null) this.setUsedMarkerSetID(tuple.getInt("EffectSize_UsedMarkerSetID"));
			//set label for field UsedMarkerSetID
			if( strict || tuple.getObject("UsedMarkerSetID_Identifier") != null) this.setUsedMarkerSetID_Identifier(tuple.getString("UsedMarkerSetID_Identifier"));			
			if( tuple.getObject("EffectSize_UsedMarkerSetID_Identifier") != null ) this.setUsedMarkerSetID_Identifier(tuple.getString("EffectSize_UsedMarkerSetID_Identifier"));		
			//set Lower95Bound
			if( strict || tuple.getDouble("Lower95Bound") != null) this.setLower95Bound(tuple.getDouble("Lower95Bound"));
			if( tuple.getDouble("EffectSize_Lower95Bound") != null) this.setLower95Bound(tuple.getDouble("EffectSize_Lower95Bound"));
			//set Upper95Bound
			if( strict || tuple.getDouble("Upper95Bound") != null) this.setUpper95Bound(tuple.getDouble("Upper95Bound"));
			if( tuple.getDouble("EffectSize_Upper95Bound") != null) this.setUpper95Bound(tuple.getDouble("EffectSize_Upper95Bound"));
			//set StdError
			if( strict || tuple.getDouble("StdError") != null) this.setStdError(tuple.getDouble("StdError"));
			if( tuple.getDouble("EffectSize_StdError") != null) this.setStdError(tuple.getDouble("EffectSize_StdError"));
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
		String result = "EffectSize(";
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
		result+= " usedMarkerSetID_id='" + getUsedMarkerSetID_Id()+"' ";	
		result+= " usedMarkerSetID_identifier='" + getUsedMarkerSetID_Identifier()+"' ";
		result+= "lower95Bound='" + getLower95Bound()+"' ";	
		result+= "upper95Bound='" + getUpper95Bound()+"' ";	
		result+= "stdError='" + getStdError()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of EffectSize.
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
			fields.add("usedMarkerSetID_id");
		}
		fields.add("usedMarkerSetID_identifier");
		{
			fields.add("lower95Bound");
		}
		{
			fields.add("upper95Bound");
		}
		{
			fields.add("stdError");
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
		+ "usedMarkerSetID" +sep
		+ "lower95Bound" +sep
		+ "upper95Bound" +sep
		+ "stdError" 
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
        if (fieldName.equalsIgnoreCase("usedMarkerSetID")) {
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
		EffectSize rhs = (EffectSize) obj;
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
			Object valueO = getUsedMarkerSetID();
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
			Object valueO = getLower95Bound();
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
			Object valueO = getUpper95Bound();
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
			Object valueO = getStdError();
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
	public EffectSize create(org.molgenis.util.Tuple tuple) throws Exception
	{
		EffectSize e = new EffectSize();
		e.set(tuple);
		return e;
	}
	

	
}

