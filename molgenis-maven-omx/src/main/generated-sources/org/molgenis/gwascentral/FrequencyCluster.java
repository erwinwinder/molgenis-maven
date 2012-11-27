
/* File:        org.molgenis/model/FrequencyCluster.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.gwascentral;

/**
 * FrequencyCluster: .
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "FrequencyCluster"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.gwascentral.db.FrequencyClusterEntityListener.class})
public class FrequencyCluster extends org.molgenis.observ.DataSet 
{
	// fieldname constants
	public final static String DATASET = "DataSet";
	public final static String DATASET_IDENTIFIER = "DataSet_Identifier";
	public final static String USEDMARKERSET = "UsedMarkerSet";
	public final static String USEDMARKERSET_IDENTIFIER = "UsedMarkerSet_Identifier";
	public final static String MARKERID = "MarkerID";
	public final static String NUMBEROFGENOTYPEDSAMPLES = "NumberOfGenotypedSamples";
	public final static String PVALUEHWE = "PValueHWE";
	public final static String UNADJUSTEDPVALUE = "UnadjustedPValue";
	public final static String ODDSRATIOSTATEMENT = "OddsRatioStatement";
	public final static String ATTRIBUTABLERISKSTATEMENT = "AttributableRiskStatement";
	public final static String ID = "id";
	
	//static methods
	/**
	 * Shorthand for db.query(FrequencyCluster.class).
	 */
	public static org.molgenis.framework.db.Query<? extends FrequencyCluster> query(org.molgenis.framework.db.Database db)
	{
		return db.query(FrequencyCluster.class);
	}
	
	/**
	 * Shorthand for db.find(FrequencyCluster.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends FrequencyCluster> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(FrequencyCluster.class, rules);
	}	
	
	/**
	 * 
	 */
	public static FrequencyCluster findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<FrequencyCluster> q = db.query(FrequencyCluster.class);
		q.eq(FrequencyCluster.ID, id);
		java.util.List<FrequencyCluster> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static FrequencyCluster findByIdentifier(org.molgenis.framework.db.Database db, String identifier) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<FrequencyCluster> q = db.query(FrequencyCluster.class);
		q.eq(FrequencyCluster.IDENTIFIER, identifier);
		java.util.List<FrequencyCluster> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//Result set identifier[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="DataSet")   	
	
				

	private org.molgenis.observ.DataSet dataSet = null;
	@javax.persistence.Transient
	private Integer dataSet_id = null;	
	@javax.persistence.Transient
	private String dataSet_Identifier = null;						


	//Used marker set ID[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="UsedMarkerSet", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.gwascentral.UsedMarkerSet usedMarkerSet = null;
	@javax.persistence.Transient
	private Integer usedMarkerSet_id = null;	
	@javax.persistence.Transient
	private String usedMarkerSet_Identifier = null;						


	//Marker ID[type=int]
	@javax.persistence.Column(name="MarkerID", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="markerID")
	
				

	@javax.validation.constraints.NotNull
	private Integer markerID =  null;


	//Number of genotyped samples[type=int]
	@javax.persistence.Column(name="NumberOfGenotypedSamples", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="numberOfGenotypedSamples")
	
				

	@javax.validation.constraints.NotNull
	private Integer numberOfGenotypedSamples =  null;


	//P-value HWE[type=decimal]
	@javax.persistence.Column(name="PValueHWE")
	@javax.xml.bind.annotation.XmlElement(name="pValueHWE")
	
				

	private Double pValueHWE =  null;


	//Unadjusted p-value[type=decimal]
	@javax.persistence.Column(name="UnadjustedPValue")
	@javax.xml.bind.annotation.XmlElement(name="unadjustedPValue")
	
				

	private Double unadjustedPValue =  null;


	//Odds ratio statement[type=string]
	@javax.persistence.Column(name="OddsRatioStatement")
	@javax.xml.bind.annotation.XmlElement(name="oddsRatioStatement")
	
				

	private String oddsRatioStatement =  null;


	//Attributable risk statement[type=string]
	@javax.persistence.Column(name="AttributableRiskStatement")
	@javax.xml.bind.annotation.XmlElement(name="attributableRiskStatement")
	
				

	private String attributableRiskStatement =  null;


	//automatically generated internal id, only for internal use.[type=int]
	

	//constructors
	public FrequencyCluster()
	{
		//set the type for a new instance
		set__Type(this.getClass().getSimpleName());
	
	}
	
	//getters and setters
	/**
	 * Get the Result set identifier.
	 * @return dataSet.
	 */
	public org.molgenis.observ.DataSet getDataSet()
	{
		return this.dataSet;
	}
	
	@Deprecated
	public org.molgenis.observ.DataSet getDataSet(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Result set identifier.
	 * @param dataSet
	 */
	public void setDataSet( org.molgenis.observ.DataSet dataSet)
	{
		
		this.dataSet = dataSet;
	}

	
	
	/**
	 * Set foreign key for field dataSet.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setDataSet_Id(Integer dataSet_id)
	{
		this.dataSet_id = dataSet_id;
	}	

	public void setDataSet(Integer dataSet_id)
	{
		this.dataSet_id = dataSet_id;
	}
	
	public Integer getDataSet_Id()
	{
		
		if(dataSet != null) 
		{
			return dataSet.getId();
		}
		else
		{
			return dataSet_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference DataSet to DataSet.Id.
	 */
	public String getDataSet_Identifier()
	{		
		//FIXME should we auto-load based on getDataSet()?	
		if(dataSet != null) {
			return dataSet.getIdentifier();
		} else {
			return dataSet_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference DataSet to <a href="DataSet.html#Id">DataSet.Id</a>.
	 * Implies setDataSet(null) until save
	 */
	public void setDataSet_Identifier(String dataSet_Identifier)
	{
		this.dataSet_Identifier = dataSet_Identifier;
	}		
	 
	

	/**
	 * Get the Used marker set ID.
	 * @return usedMarkerSet.
	 */
	public org.molgenis.gwascentral.UsedMarkerSet getUsedMarkerSet()
	{
		return this.usedMarkerSet;
	}
	
	@Deprecated
	public org.molgenis.gwascentral.UsedMarkerSet getUsedMarkerSet(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Used marker set ID.
	 * @param usedMarkerSet
	 */
	public void setUsedMarkerSet( org.molgenis.gwascentral.UsedMarkerSet usedMarkerSet)
	{
		
		this.usedMarkerSet = usedMarkerSet;
	}

	
	
	/**
	 * Set foreign key for field usedMarkerSet.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setUsedMarkerSet_Id(Integer usedMarkerSet_id)
	{
		this.usedMarkerSet_id = usedMarkerSet_id;
	}	

	public void setUsedMarkerSet(Integer usedMarkerSet_id)
	{
		this.usedMarkerSet_id = usedMarkerSet_id;
	}
	
	public Integer getUsedMarkerSet_Id()
	{
		
		if(usedMarkerSet != null) 
		{
			return usedMarkerSet.getId();
		}
		else
		{
			return usedMarkerSet_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference UsedMarkerSet to UsedMarkerSet.Id.
	 */
	public String getUsedMarkerSet_Identifier()
	{		
		//FIXME should we auto-load based on getUsedMarkerSet()?	
		if(usedMarkerSet != null) {
			return usedMarkerSet.getIdentifier();
		} else {
			return usedMarkerSet_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference UsedMarkerSet to <a href="UsedMarkerSet.html#Id">UsedMarkerSet.Id</a>.
	 * Implies setUsedMarkerSet(null) until save
	 */
	public void setUsedMarkerSet_Identifier(String usedMarkerSet_Identifier)
	{
		this.usedMarkerSet_Identifier = usedMarkerSet_Identifier;
	}		
	 
	

	/**
	 * Get the Marker ID.
	 * @return markerID.
	 */
	public Integer getMarkerID()
	{
		return this.markerID;
	}
	
	@Deprecated
	public Integer getMarkerID(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Marker ID.
	 * @param markerID
	 */
	public void setMarkerID( Integer markerID)
	{
		
		this.markerID = markerID;
	}

	

	/**
	 * Get the Number of genotyped samples.
	 * @return numberOfGenotypedSamples.
	 */
	public Integer getNumberOfGenotypedSamples()
	{
		return this.numberOfGenotypedSamples;
	}
	
	@Deprecated
	public Integer getNumberOfGenotypedSamples(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Number of genotyped samples.
	 * @param numberOfGenotypedSamples
	 */
	public void setNumberOfGenotypedSamples( Integer numberOfGenotypedSamples)
	{
		
		this.numberOfGenotypedSamples = numberOfGenotypedSamples;
	}

	

	/**
	 * Get the P-value HWE.
	 * @return pValueHWE.
	 */
	public Double getPValueHWE()
	{
		return this.pValueHWE;
	}
	
	@Deprecated
	public Double getPValueHWE(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the P-value HWE.
	 * @param pValueHWE
	 */
	public void setPValueHWE( Double pValueHWE)
	{
		
		this.pValueHWE = pValueHWE;
	}

	

	/**
	 * Get the Unadjusted p-value.
	 * @return unadjustedPValue.
	 */
	public Double getUnadjustedPValue()
	{
		return this.unadjustedPValue;
	}
	
	@Deprecated
	public Double getUnadjustedPValue(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Unadjusted p-value.
	 * @param unadjustedPValue
	 */
	public void setUnadjustedPValue( Double unadjustedPValue)
	{
		
		this.unadjustedPValue = unadjustedPValue;
	}

	

	/**
	 * Get the Odds ratio statement.
	 * @return oddsRatioStatement.
	 */
	public String getOddsRatioStatement()
	{
		return this.oddsRatioStatement;
	}
	
	@Deprecated
	public String getOddsRatioStatement(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Odds ratio statement.
	 * @param oddsRatioStatement
	 */
	public void setOddsRatioStatement( String oddsRatioStatement)
	{
		
		this.oddsRatioStatement = oddsRatioStatement;
	}

	

	/**
	 * Get the Attributable risk statement.
	 * @return attributableRiskStatement.
	 */
	public String getAttributableRiskStatement()
	{
		return this.attributableRiskStatement;
	}
	
	@Deprecated
	public String getAttributableRiskStatement(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Attributable risk statement.
	 * @param attributableRiskStatement
	 */
	public void setAttributableRiskStatement( String attributableRiskStatement)
	{
		
		this.attributableRiskStatement = attributableRiskStatement;
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
		if (name.toLowerCase().equals("dataset"))
			return getDataSet();
		if(name.toLowerCase().equals("dataset_id"))
			return getDataSet_Id();
		if(name.toLowerCase().equals("dataset_identifier"))
			return getDataSet_Identifier();
		if (name.toLowerCase().equals("usedmarkerset"))
			return getUsedMarkerSet();
		if(name.toLowerCase().equals("usedmarkerset_id"))
			return getUsedMarkerSet_Id();
		if(name.toLowerCase().equals("usedmarkerset_identifier"))
			return getUsedMarkerSet_Identifier();
		if (name.toLowerCase().equals("markerid"))
			return getMarkerID();
		if (name.toLowerCase().equals("numberofgenotypedsamples"))
			return getNumberOfGenotypedSamples();
		if (name.toLowerCase().equals("pvaluehwe"))
			return getPValueHWE();
		if (name.toLowerCase().equals("unadjustedpvalue"))
			return getUnadjustedPValue();
		if (name.toLowerCase().equals("oddsratiostatement"))
			return getOddsRatioStatement();
		if (name.toLowerCase().equals("attributableriskstatement"))
			return getAttributableRiskStatement();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getIdentifier() == null) throw new org.molgenis.framework.db.DatabaseException("required field identifier is null");
		if(this.getName() == null) throw new org.molgenis.framework.db.DatabaseException("required field name is null");
		if(this.get__Type() == null) throw new org.molgenis.framework.db.DatabaseException("required field __Type is null");
		if(this.getStartTime() == null) throw new org.molgenis.framework.db.DatabaseException("required field startTime is null");
		if(this.getUsedMarkerSet() == null) throw new org.molgenis.framework.db.DatabaseException("required field usedMarkerSet is null");
		if(this.getMarkerID() == null) throw new org.molgenis.framework.db.DatabaseException("required field markerID is null");
		if(this.getNumberOfGenotypedSamples() == null) throw new org.molgenis.framework.db.DatabaseException("required field numberOfGenotypedSamples is null");
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
			//set DataSet
			this.setDataSet(tuple.getInt("DataSet"));
			//set label Identifier for xref field DataSet
			this.setDataSet_Identifier(tuple.getString("DataSet_Identifier"));	
			//set UsedMarkerSet
			this.setUsedMarkerSet(tuple.getInt("UsedMarkerSet"));
			//set label Identifier for xref field UsedMarkerSet
			this.setUsedMarkerSet_Identifier(tuple.getString("UsedMarkerSet_Identifier"));	
			//set MarkerID
			this.setMarkerID(tuple.getInt("MarkerID"));
			//set NumberOfGenotypedSamples
			this.setNumberOfGenotypedSamples(tuple.getInt("NumberOfGenotypedSamples"));
			//set PValueHWE
			this.setPValueHWE(tuple.getDouble("PValueHWE"));
			//set UnadjustedPValue
			this.setUnadjustedPValue(tuple.getDouble("UnadjustedPValue"));
			//set OddsRatioStatement
			this.setOddsRatioStatement(tuple.getString("OddsRatioStatement"));
			//set AttributableRiskStatement
			this.setAttributableRiskStatement(tuple.getString("AttributableRiskStatement"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("FrequencyCluster_id") != null) this.setId(tuple.getInt("FrequencyCluster_id"));
			//set Identifier
			if( strict || tuple.getString("Identifier") != null) this.setIdentifier(tuple.getString("Identifier"));
			if( tuple.getString("FrequencyCluster_Identifier") != null) this.setIdentifier(tuple.getString("FrequencyCluster_Identifier"));
			//set Name
			if( strict || tuple.getString("Name") != null) this.setName(tuple.getString("Name"));
			if( tuple.getString("FrequencyCluster_Name") != null) this.setName(tuple.getString("FrequencyCluster_Name"));
			//set __Type
			if( strict || tuple.getString("__Type") != null) this.set__Type(tuple.getString("__Type"));
			if( tuple.getString("FrequencyCluster___Type") != null) this.set__Type(tuple.getString("FrequencyCluster___Type"));
			//set Description
			if( strict || tuple.getString("description") != null) this.setDescription(tuple.getString("description"));
			if( tuple.getString("FrequencyCluster_description") != null) this.setDescription(tuple.getString("FrequencyCluster_description"));
			//set ProtocolUsed
			if( strict || tuple.getInt("ProtocolUsed_id") != null) this.setProtocolUsed(tuple.getInt("ProtocolUsed_id"));
			if( tuple.getInt("FrequencyCluster_ProtocolUsed_id") != null) this.setProtocolUsed(tuple.getInt("FrequencyCluster_ProtocolUsed_id"));
			//alias of xref
			if( tuple.getObject("ProtocolUsed") != null) this.setProtocolUsed(tuple.getInt("ProtocolUsed"));
			if( tuple.getObject("FrequencyCluster_ProtocolUsed") != null) this.setProtocolUsed(tuple.getInt("FrequencyCluster_ProtocolUsed"));
			//set label for field ProtocolUsed
			if( strict || tuple.getObject("ProtocolUsed_Identifier") != null) this.setProtocolUsed_Identifier(tuple.getString("ProtocolUsed_Identifier"));			
			if( tuple.getObject("FrequencyCluster_ProtocolUsed_Identifier") != null ) this.setProtocolUsed_Identifier(tuple.getString("FrequencyCluster_ProtocolUsed_Identifier"));		
			//set StartTime
			if( strict || tuple.getTimestamp("startTime") != null) this.setStartTime(tuple.getTimestamp("startTime"));
			if( tuple.getTimestamp("FrequencyCluster_startTime") != null) this.setStartTime(tuple.getTimestamp("FrequencyCluster_startTime"));
			//set EndTime
			if( strict || tuple.getTimestamp("endTime") != null) this.setEndTime(tuple.getTimestamp("endTime"));
			if( tuple.getTimestamp("FrequencyCluster_endTime") != null) this.setEndTime(tuple.getTimestamp("FrequencyCluster_endTime"));
			//set DataSet
			if( strict || tuple.getInt("DataSet_id") != null) this.setDataSet(tuple.getInt("DataSet_id"));
			if( tuple.getInt("FrequencyCluster_DataSet_id") != null) this.setDataSet(tuple.getInt("FrequencyCluster_DataSet_id"));
			//alias of xref
			if( tuple.getObject("DataSet") != null) this.setDataSet(tuple.getInt("DataSet"));
			if( tuple.getObject("FrequencyCluster_DataSet") != null) this.setDataSet(tuple.getInt("FrequencyCluster_DataSet"));
			//set label for field DataSet
			if( strict || tuple.getObject("DataSet_Identifier") != null) this.setDataSet_Identifier(tuple.getString("DataSet_Identifier"));			
			if( tuple.getObject("FrequencyCluster_DataSet_Identifier") != null ) this.setDataSet_Identifier(tuple.getString("FrequencyCluster_DataSet_Identifier"));		
			//set UsedMarkerSet
			if( strict || tuple.getInt("UsedMarkerSet_id") != null) this.setUsedMarkerSet(tuple.getInt("UsedMarkerSet_id"));
			if( tuple.getInt("FrequencyCluster_UsedMarkerSet_id") != null) this.setUsedMarkerSet(tuple.getInt("FrequencyCluster_UsedMarkerSet_id"));
			//alias of xref
			if( tuple.getObject("UsedMarkerSet") != null) this.setUsedMarkerSet(tuple.getInt("UsedMarkerSet"));
			if( tuple.getObject("FrequencyCluster_UsedMarkerSet") != null) this.setUsedMarkerSet(tuple.getInt("FrequencyCluster_UsedMarkerSet"));
			//set label for field UsedMarkerSet
			if( strict || tuple.getObject("UsedMarkerSet_Identifier") != null) this.setUsedMarkerSet_Identifier(tuple.getString("UsedMarkerSet_Identifier"));			
			if( tuple.getObject("FrequencyCluster_UsedMarkerSet_Identifier") != null ) this.setUsedMarkerSet_Identifier(tuple.getString("FrequencyCluster_UsedMarkerSet_Identifier"));		
			//set MarkerID
			if( strict || tuple.getInt("MarkerID") != null) this.setMarkerID(tuple.getInt("MarkerID"));
			if( tuple.getInt("FrequencyCluster_MarkerID") != null) this.setMarkerID(tuple.getInt("FrequencyCluster_MarkerID"));
			//set NumberOfGenotypedSamples
			if( strict || tuple.getInt("NumberOfGenotypedSamples") != null) this.setNumberOfGenotypedSamples(tuple.getInt("NumberOfGenotypedSamples"));
			if( tuple.getInt("FrequencyCluster_NumberOfGenotypedSamples") != null) this.setNumberOfGenotypedSamples(tuple.getInt("FrequencyCluster_NumberOfGenotypedSamples"));
			//set PValueHWE
			if( strict || tuple.getDouble("PValueHWE") != null) this.setPValueHWE(tuple.getDouble("PValueHWE"));
			if( tuple.getDouble("FrequencyCluster_PValueHWE") != null) this.setPValueHWE(tuple.getDouble("FrequencyCluster_PValueHWE"));
			//set UnadjustedPValue
			if( strict || tuple.getDouble("UnadjustedPValue") != null) this.setUnadjustedPValue(tuple.getDouble("UnadjustedPValue"));
			if( tuple.getDouble("FrequencyCluster_UnadjustedPValue") != null) this.setUnadjustedPValue(tuple.getDouble("FrequencyCluster_UnadjustedPValue"));
			//set OddsRatioStatement
			if( strict || tuple.getString("OddsRatioStatement") != null) this.setOddsRatioStatement(tuple.getString("OddsRatioStatement"));
			if( tuple.getString("FrequencyCluster_OddsRatioStatement") != null) this.setOddsRatioStatement(tuple.getString("FrequencyCluster_OddsRatioStatement"));
			//set AttributableRiskStatement
			if( strict || tuple.getString("AttributableRiskStatement") != null) this.setAttributableRiskStatement(tuple.getString("AttributableRiskStatement"));
			if( tuple.getString("FrequencyCluster_AttributableRiskStatement") != null) this.setAttributableRiskStatement(tuple.getString("FrequencyCluster_AttributableRiskStatement"));
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
		String result = "FrequencyCluster(";
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
		result+= " dataSet_id='" + getDataSet_Id()+"' ";	
		result+= " dataSet_identifier='" + getDataSet_Identifier()+"' ";
		result+= " usedMarkerSet_id='" + getUsedMarkerSet_Id()+"' ";	
		result+= " usedMarkerSet_identifier='" + getUsedMarkerSet_Identifier()+"' ";
		result+= "markerID='" + getMarkerID()+"' ";	
		result+= "numberOfGenotypedSamples='" + getNumberOfGenotypedSamples()+"' ";	
		result+= "pValueHWE='" + getPValueHWE()+"' ";	
		result+= "unadjustedPValue='" + getUnadjustedPValue()+"' ";	
		result+= "oddsRatioStatement='" + getOddsRatioStatement()+"' ";	
		result+= "attributableRiskStatement='" + getAttributableRiskStatement()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of FrequencyCluster.
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
			fields.add("dataSet_id");
		}
		fields.add("dataSet_identifier");
		{
			fields.add("usedMarkerSet_id");
		}
		fields.add("usedMarkerSet_identifier");
		{
			fields.add("markerID");
		}
		{
			fields.add("numberOfGenotypedSamples");
		}
		{
			fields.add("pValueHWE");
		}
		{
			fields.add("unadjustedPValue");
		}
		{
			fields.add("oddsRatioStatement");
		}
		{
			fields.add("attributableRiskStatement");
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
		+ "dataSet" +sep
		+ "usedMarkerSet" +sep
		+ "markerID" +sep
		+ "numberOfGenotypedSamples" +sep
		+ "pValueHWE" +sep
		+ "unadjustedPValue" +sep
		+ "oddsRatioStatement" +sep
		+ "attributableRiskStatement" 
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
        if (fieldName.equalsIgnoreCase("dataSet")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("usedMarkerSet")) {
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
		FrequencyCluster rhs = (FrequencyCluster) obj;
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
			Object valueO = getDataSet();
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
			Object valueO = getUsedMarkerSet();
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
			Object valueO = getMarkerID();
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
			Object valueO = getNumberOfGenotypedSamples();
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
			Object valueO = getPValueHWE();
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
			Object valueO = getOddsRatioStatement();
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
			Object valueO = getAttributableRiskStatement();
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
	public FrequencyCluster create(org.molgenis.util.Tuple tuple) throws Exception
	{
		FrequencyCluster e = new FrequencyCluster();
		e.set(tuple);
		return e;
	}
	
//2
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="frequencyCluster"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.gwascentral.GenotypeFrequency> frequencyClusterGenotypeFrequencyCollection = new java.util.ArrayList<org.molgenis.gwascentral.GenotypeFrequency>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.gwascentral.GenotypeFrequency> getFrequencyClusterGenotypeFrequencyCollection()
	{
            return frequencyClusterGenotypeFrequencyCollection;
	}

    public void setFrequencyClusterGenotypeFrequencyCollection(java.util.Collection<org.molgenis.gwascentral.GenotypeFrequency> collection)
    {
        for (org.molgenis.gwascentral.GenotypeFrequency genotypeFrequency : collection) {
            genotypeFrequency.setFrequencyCluster(this);
        }
        frequencyClusterGenotypeFrequencyCollection = collection;
    }	
//2
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="frequencyCluster"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.gwascentral.AlleleFrequency> frequencyClusterAlleleFrequencyCollection = new java.util.ArrayList<org.molgenis.gwascentral.AlleleFrequency>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.gwascentral.AlleleFrequency> getFrequencyClusterAlleleFrequencyCollection()
	{
            return frequencyClusterAlleleFrequencyCollection;
	}

    public void setFrequencyClusterAlleleFrequencyCollection(java.util.Collection<org.molgenis.gwascentral.AlleleFrequency> collection)
    {
        for (org.molgenis.gwascentral.AlleleFrequency alleleFrequency : collection) {
            alleleFrequency.setFrequencyCluster(this);
        }
        frequencyClusterAlleleFrequencyCollection = collection;
    }	

	
}

