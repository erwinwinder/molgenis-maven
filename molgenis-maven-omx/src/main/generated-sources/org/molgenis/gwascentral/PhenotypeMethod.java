
/* File:        org.molgenis/model/PhenotypeMethod.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.gwascentral;

/**
 * PhenotypeMethod: .
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "PhenotypeMethod", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "Identifier" } ) }
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.gwascentral.db.PhenotypeMethodEntityListener.class})
public class PhenotypeMethod extends org.molgenis.observ.DataSet implements org.molgenis.core.Identifiable
{
	// fieldname constants
	public final static String ID = "id";
	public final static String IDENTIFIER = "Identifier";
	public final static String NAME = "Name";
	public final static String STUDYID = "StudyID";
	public final static String STUDYID_IDENTIFIER = "StudyID_Identifier";
	public final static String PHENOTYPEPROPERTYID = "PhenotypePropertyID";
	public final static String PHENOTYPEPROPERTYID_IDENTIFIER = "PhenotypePropertyID_Identifier";
	public final static String SAMPLE = "Sample";
	
	//static methods
	/**
	 * Shorthand for db.query(PhenotypeMethod.class).
	 */
	public static org.molgenis.framework.db.Query<? extends PhenotypeMethod> query(org.molgenis.framework.db.Database db)
	{
		return db.query(PhenotypeMethod.class);
	}
	
	/**
	 * Shorthand for db.find(PhenotypeMethod.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends PhenotypeMethod> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(PhenotypeMethod.class, rules);
	}	
	
	/**
	 * 
	 */
	public static PhenotypeMethod findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<PhenotypeMethod> q = db.query(PhenotypeMethod.class);
		q.eq(PhenotypeMethod.ID, id);
		java.util.List<PhenotypeMethod> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static PhenotypeMethod findByIdentifier(org.molgenis.framework.db.Database db, String identifier) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<PhenotypeMethod> q = db.query(PhenotypeMethod.class);
		q.eq(PhenotypeMethod.IDENTIFIER, identifier);
		java.util.List<PhenotypeMethod> result = q.find();
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


	//Points to study that this method came in[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="StudyID", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.organization.Study studyID = null;
	@javax.persistence.Transient
	private Integer studyID_id = null;	
	@javax.persistence.Transient
	private String studyID_Identifier = null;						


	//Phenotype property name[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="PhenotypePropertyID", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.gwascentral.PhenotypeProperty phenotypePropertyID = null;
	@javax.persistence.Transient
	private Integer phenotypePropertyID_id = null;	
	@javax.persistence.Transient
	private String phenotypePropertyID_Identifier = null;						


	//Biological system or sample type being assessed[type=string]
	@javax.persistence.Column(name="Sample")
	@javax.xml.bind.annotation.XmlElement(name="sample")
	
				

	private String sample =  null;

	//constructors
	public PhenotypeMethod()
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
				//hack to solve problem with variable hidden in supertype
				super.setIdentifier(identifier);
				//2222hack to solve problem with variable hidden in supertype
				super.setIdentifier(identifier);
		
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
				//hack to solve problem with variable hidden in supertype
				super.setName(name);
				//2222hack to solve problem with variable hidden in supertype
				super.setName(name);
		
		this.name = name;
	}

	

	/**
	 * Get the Points to study that this method came in.
	 * @return studyID.
	 */
	public org.molgenis.organization.Study getStudyID()
	{
		return this.studyID;
	}
	
	@Deprecated
	public org.molgenis.organization.Study getStudyID(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Points to study that this method came in.
	 * @param studyID
	 */
	public void setStudyID( org.molgenis.organization.Study studyID)
	{
		
		this.studyID = studyID;
	}

	
	
	/**
	 * Set foreign key for field studyID.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setStudyID_Id(Integer studyID_id)
	{
		this.studyID_id = studyID_id;
	}	

	public void setStudyID(Integer studyID_id)
	{
		this.studyID_id = studyID_id;
	}
	
	public Integer getStudyID_Id()
	{
		
		if(studyID != null) 
		{
			return studyID.getId();
		}
		else
		{
			return studyID_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference StudyID to Study.Id.
	 */
	public String getStudyID_Identifier()
	{		
		//FIXME should we auto-load based on getStudyID()?	
		if(studyID != null) {
			return studyID.getIdentifier();
		} else {
			return studyID_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference StudyID to <a href="Study.html#Id">Study.Id</a>.
	 * Implies setStudyID(null) until save
	 */
	public void setStudyID_Identifier(String studyID_Identifier)
	{
		this.studyID_Identifier = studyID_Identifier;
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
	 * Get the Biological system or sample type being assessed.
	 * @return sample.
	 */
	public String getSample()
	{
		return this.sample;
	}
	
	@Deprecated
	public String getSample(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Biological system or sample type being assessed.
	 * @param sample
	 */
	public void setSample( String sample)
	{
		
		this.sample = sample;
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
		if (name.toLowerCase().equals("studyid"))
			return getStudyID();
		if(name.toLowerCase().equals("studyid_id"))
			return getStudyID_Id();
		if(name.toLowerCase().equals("studyid_identifier"))
			return getStudyID_Identifier();
		if (name.toLowerCase().equals("phenotypepropertyid"))
			return getPhenotypePropertyID();
		if(name.toLowerCase().equals("phenotypepropertyid_id"))
			return getPhenotypePropertyID_Id();
		if(name.toLowerCase().equals("phenotypepropertyid_identifier"))
			return getPhenotypePropertyID_Identifier();
		if (name.toLowerCase().equals("sample"))
			return getSample();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getIdentifier() == null) throw new org.molgenis.framework.db.DatabaseException("required field identifier is null");
		if(this.get__Type() == null) throw new org.molgenis.framework.db.DatabaseException("required field __Type is null");
		if(this.getStartTime() == null) throw new org.molgenis.framework.db.DatabaseException("required field startTime is null");
		if(this.getStudyID() == null) throw new org.molgenis.framework.db.DatabaseException("required field studyID is null");
		if(this.getPhenotypePropertyID() == null) throw new org.molgenis.framework.db.DatabaseException("required field phenotypePropertyID is null");
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
			//set StudyID
			this.setStudyID(tuple.getInt("StudyID"));
			//set label Identifier for xref field StudyID
			this.setStudyID_Identifier(tuple.getString("StudyID_Identifier"));	
			//set PhenotypePropertyID
			this.setPhenotypePropertyID(tuple.getInt("PhenotypePropertyID"));
			//set label Identifier for xref field PhenotypePropertyID
			this.setPhenotypePropertyID_Identifier(tuple.getString("PhenotypePropertyID_Identifier"));	
			//set Sample
			this.setSample(tuple.getString("Sample"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("PhenotypeMethod_id") != null) this.setId(tuple.getInt("PhenotypeMethod_id"));
			//set Identifier
			if( strict || tuple.getString("Identifier") != null) this.setIdentifier(tuple.getString("Identifier"));
			if( tuple.getString("PhenotypeMethod_Identifier") != null) this.setIdentifier(tuple.getString("PhenotypeMethod_Identifier"));
			//set Name
			if( strict || tuple.getString("Name") != null) this.setName(tuple.getString("Name"));
			if( tuple.getString("PhenotypeMethod_Name") != null) this.setName(tuple.getString("PhenotypeMethod_Name"));
			//set __Type
			if( strict || tuple.getString("__Type") != null) this.set__Type(tuple.getString("__Type"));
			if( tuple.getString("PhenotypeMethod___Type") != null) this.set__Type(tuple.getString("PhenotypeMethod___Type"));
			//set Description
			if( strict || tuple.getString("description") != null) this.setDescription(tuple.getString("description"));
			if( tuple.getString("PhenotypeMethod_description") != null) this.setDescription(tuple.getString("PhenotypeMethod_description"));
			//set ProtocolUsed
			if( strict || tuple.getInt("ProtocolUsed_id") != null) this.setProtocolUsed(tuple.getInt("ProtocolUsed_id"));
			if( tuple.getInt("PhenotypeMethod_ProtocolUsed_id") != null) this.setProtocolUsed(tuple.getInt("PhenotypeMethod_ProtocolUsed_id"));
			//alias of xref
			if( tuple.getObject("ProtocolUsed") != null) this.setProtocolUsed(tuple.getInt("ProtocolUsed"));
			if( tuple.getObject("PhenotypeMethod_ProtocolUsed") != null) this.setProtocolUsed(tuple.getInt("PhenotypeMethod_ProtocolUsed"));
			//set label for field ProtocolUsed
			if( strict || tuple.getObject("ProtocolUsed_Identifier") != null) this.setProtocolUsed_Identifier(tuple.getString("ProtocolUsed_Identifier"));			
			if( tuple.getObject("PhenotypeMethod_ProtocolUsed_Identifier") != null ) this.setProtocolUsed_Identifier(tuple.getString("PhenotypeMethod_ProtocolUsed_Identifier"));		
			//set StartTime
			if( strict || tuple.getTimestamp("startTime") != null) this.setStartTime(tuple.getTimestamp("startTime"));
			if( tuple.getTimestamp("PhenotypeMethod_startTime") != null) this.setStartTime(tuple.getTimestamp("PhenotypeMethod_startTime"));
			//set EndTime
			if( strict || tuple.getTimestamp("endTime") != null) this.setEndTime(tuple.getTimestamp("endTime"));
			if( tuple.getTimestamp("PhenotypeMethod_endTime") != null) this.setEndTime(tuple.getTimestamp("PhenotypeMethod_endTime"));
			//set StudyID
			if( strict || tuple.getInt("StudyID_id") != null) this.setStudyID(tuple.getInt("StudyID_id"));
			if( tuple.getInt("PhenotypeMethod_StudyID_id") != null) this.setStudyID(tuple.getInt("PhenotypeMethod_StudyID_id"));
			//alias of xref
			if( tuple.getObject("StudyID") != null) this.setStudyID(tuple.getInt("StudyID"));
			if( tuple.getObject("PhenotypeMethod_StudyID") != null) this.setStudyID(tuple.getInt("PhenotypeMethod_StudyID"));
			//set label for field StudyID
			if( strict || tuple.getObject("StudyID_Identifier") != null) this.setStudyID_Identifier(tuple.getString("StudyID_Identifier"));			
			if( tuple.getObject("PhenotypeMethod_StudyID_Identifier") != null ) this.setStudyID_Identifier(tuple.getString("PhenotypeMethod_StudyID_Identifier"));		
			//set PhenotypePropertyID
			if( strict || tuple.getInt("PhenotypePropertyID_id") != null) this.setPhenotypePropertyID(tuple.getInt("PhenotypePropertyID_id"));
			if( tuple.getInt("PhenotypeMethod_PhenotypePropertyID_id") != null) this.setPhenotypePropertyID(tuple.getInt("PhenotypeMethod_PhenotypePropertyID_id"));
			//alias of xref
			if( tuple.getObject("PhenotypePropertyID") != null) this.setPhenotypePropertyID(tuple.getInt("PhenotypePropertyID"));
			if( tuple.getObject("PhenotypeMethod_PhenotypePropertyID") != null) this.setPhenotypePropertyID(tuple.getInt("PhenotypeMethod_PhenotypePropertyID"));
			//set label for field PhenotypePropertyID
			if( strict || tuple.getObject("PhenotypePropertyID_Identifier") != null) this.setPhenotypePropertyID_Identifier(tuple.getString("PhenotypePropertyID_Identifier"));			
			if( tuple.getObject("PhenotypeMethod_PhenotypePropertyID_Identifier") != null ) this.setPhenotypePropertyID_Identifier(tuple.getString("PhenotypeMethod_PhenotypePropertyID_Identifier"));		
			//set Sample
			if( strict || tuple.getString("Sample") != null) this.setSample(tuple.getString("Sample"));
			if( tuple.getString("PhenotypeMethod_Sample") != null) this.setSample(tuple.getString("PhenotypeMethod_Sample"));
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
		String result = "PhenotypeMethod(";
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
		result+= " studyID_id='" + getStudyID_Id()+"' ";	
		result+= " studyID_identifier='" + getStudyID_Identifier()+"' ";
		result+= " phenotypePropertyID_id='" + getPhenotypePropertyID_Id()+"' ";	
		result+= " phenotypePropertyID_identifier='" + getPhenotypePropertyID_Identifier()+"' ";
		result+= "sample='" + getSample()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of PhenotypeMethod.
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
			fields.add("studyID_id");
		}
		fields.add("studyID_identifier");
		{
			fields.add("phenotypePropertyID_id");
		}
		fields.add("phenotypePropertyID_identifier");
		{
			fields.add("sample");
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
		+ "studyID" +sep
		+ "phenotypePropertyID" +sep
		+ "sample" 
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
        if (fieldName.equalsIgnoreCase("studyID")) {
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
		PhenotypeMethod rhs = (PhenotypeMethod) obj;
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
			Object valueO = getStudyID();
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
			Object valueO = getSample();
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
	public PhenotypeMethod create(org.molgenis.util.Tuple tuple) throws Exception
	{
		PhenotypeMethod e = new PhenotypeMethod();
		e.set(tuple);
		return e;
	}
	

	
}

