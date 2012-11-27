
/* File:        org.molgenis/model/StudyDetails_otherCitations.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.gwascentral;

/**
 * StudyDetails_otherCitations: Link table for many-to-many relationship 'StudyDetails.otherCitations'..
 * @author MOLGENIS generator
 */
@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.gwascentral.db.StudyDetails_OtherCitationsEntityListener.class})
public class StudyDetails_OtherCitations extends org.molgenis.util.AbstractEntity 
{
	// fieldname constants
	public final static String AUTOID = "autoid";
	public final static String OTHERCITATIONS = "otherCitations";
	public final static String OTHERCITATIONS_IDENTIFIER = "otherCitations_Identifier";
	public final static String STUDYDETAILS = "StudyDetails";
	public final static String STUDYDETAILS_ID = "StudyDetails_id";
	
	//static methods
	/**
	 * Shorthand for db.query(StudyDetails_OtherCitations.class).
	 */
	public static org.molgenis.framework.db.Query<? extends StudyDetails_OtherCitations> query(org.molgenis.framework.db.Database db)
	{
		return db.query(StudyDetails_OtherCitations.class);
	}
	
	/**
	 * Shorthand for db.find(StudyDetails_OtherCitations.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends StudyDetails_OtherCitations> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(StudyDetails_OtherCitations.class, rules);
	}	
	
	/**
	 * 
	 */
	public static StudyDetails_OtherCitations findByAutoid(org.molgenis.framework.db.Database db, Integer autoid) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<StudyDetails_OtherCitations> q = db.query(StudyDetails_OtherCitations.class);
		q.eq(StudyDetails_OtherCitations.AUTOID, autoid);
		java.util.List<StudyDetails_OtherCitations> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static StudyDetails_OtherCitations findByOtherCitationsStudyDetails(org.molgenis.framework.db.Database db, Integer otherCitations, Integer studyDetails) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<StudyDetails_OtherCitations> q = db.query(StudyDetails_OtherCitations.class);
		q.eq(StudyDetails_OtherCitations.OTHERCITATIONS, otherCitations);q.eq(StudyDetails_OtherCitations.STUDYDETAILS, studyDetails);
		java.util.List<StudyDetails_OtherCitations> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//automatic id field to ensure ordering of mrefs[type=int]
    @javax.persistence.Id @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    @javax.persistence.Column(name="autoid", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="autoid")
	
	//@javax.validation.constraints.NotNull
	private Integer autoid =  null;


	//[type=xref]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="otherCitations", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.organization.Citation otherCitations = null;
	@javax.persistence.Transient
	private Integer otherCitations_id = null;	
	@javax.persistence.Transient
	private String otherCitations_Identifier = null;						


	//[type=xref]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="StudyDetails", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.gwascentral.StudyDetails studyDetails = null;
	@javax.persistence.Transient
	private Integer studyDetails_id = null;	

	//constructors
	public StudyDetails_OtherCitations()
	{
	
	}
	
	//getters and setters
	/**
	 * Get the automatic id field to ensure ordering of mrefs.
	 * @return autoid.
	 */
	public Integer getAutoid()
	{
		return this.autoid;
	}
	
	
	/**
	 * Set the automatic id field to ensure ordering of mrefs.
	 * @param autoid
	 */
	public void setAutoid( Integer autoid)
	{
		this.autoid = autoid;
	}

	

	/**
	 * Get the .
	 * @return otherCitations.
	 */
	public org.molgenis.organization.Citation getOtherCitations()
	{
		return this.otherCitations;
	}
	
	@Deprecated
	public org.molgenis.organization.Citation getOtherCitations(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the .
	 * @param otherCitations
	 */
	public void setOtherCitations( org.molgenis.organization.Citation otherCitations)
	{
		
		this.otherCitations = otherCitations;
	}

	
	
	/**
	 * Set foreign key for field otherCitations.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setOtherCitations_Id(Integer otherCitations_id)
	{
		this.otherCitations_id = otherCitations_id;
	}	

	public void setOtherCitations(Integer otherCitations_id)
	{
		this.otherCitations_id = otherCitations_id;
	}
	
	public Integer getOtherCitations_Id()
	{
		
		if(otherCitations != null) 
		{
			return otherCitations.getId();
		}
		else
		{
			return otherCitations_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference OtherCitations to Citation.Id.
	 */
	public String getOtherCitations_Identifier()
	{		
		//FIXME should we auto-load based on getOtherCitations()?	
		if(otherCitations != null) {
			return otherCitations.getIdentifier();
		} else {
			return otherCitations_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference OtherCitations to <a href="Citation.html#Id">Citation.Id</a>.
	 * Implies setOtherCitations(null) until save
	 */
	public void setOtherCitations_Identifier(String otherCitations_Identifier)
	{
		this.otherCitations_Identifier = otherCitations_Identifier;
	}		
	 
	

	/**
	 * Get the .
	 * @return studyDetails.
	 */
	public org.molgenis.gwascentral.StudyDetails getStudyDetails()
	{
		return this.studyDetails;
	}
	
	@Deprecated
	public org.molgenis.gwascentral.StudyDetails getStudyDetails(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the .
	 * @param studyDetails
	 */
	public void setStudyDetails( org.molgenis.gwascentral.StudyDetails studyDetails)
	{
		
		this.studyDetails = studyDetails;
	}

	
	
	/**
	 * Set foreign key for field studyDetails.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setStudyDetails_Id(Integer studyDetails_id)
	{
		this.studyDetails_id = studyDetails_id;
	}	

	public void setStudyDetails(Integer studyDetails_id)
	{
		this.studyDetails_id = studyDetails_id;
	}
	
	public Integer getStudyDetails_Id()
	{
		
		if(studyDetails != null) 
		{
			return studyDetails.getId();
		}
		else
		{
			return studyDetails_id;
		}
	}	
	 
	 
	


	/**
	 * Generic getter. Get the property by using the name.
	 */
	public Object get(String name)
	{
		name = name.toLowerCase();
		if (name.toLowerCase().equals("autoid"))
			return getAutoid();
		if (name.toLowerCase().equals("othercitations"))
			return getOtherCitations();
		if(name.toLowerCase().equals("othercitations_id"))
			return getOtherCitations_Id();
		if(name.toLowerCase().equals("othercitations_identifier"))
			return getOtherCitations_Identifier();
		if (name.toLowerCase().equals("studydetails"))
			return getStudyDetails();
		if(name.toLowerCase().equals("studydetails_id"))
			return getStudyDetails_Id();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getAutoid() == null) throw new org.molgenis.framework.db.DatabaseException("required field autoid is null");
		if(this.getOtherCitations() == null) throw new org.molgenis.framework.db.DatabaseException("required field otherCitations is null");
		if(this.getStudyDetails() == null) throw new org.molgenis.framework.db.DatabaseException("required field studyDetails is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.util.Tuple tuple, boolean strict )  throws Exception
	{
		//optimization :-(
		if(tuple instanceof org.molgenis.util.ResultSetTuple)
		{
				//set Autoid
			this.setAutoid(tuple.getInt("autoid"));
			//set OtherCitations
			this.setOtherCitations(tuple.getInt("otherCitations"));
			//set label Identifier for xref field OtherCitations
			this.setOtherCitations_Identifier(tuple.getString("otherCitations_Identifier"));	
			//set StudyDetails
			this.setStudyDetails(tuple.getInt("StudyDetails"));
		}
		else if(tuple != null)
		{
			//set Autoid
			if( strict || tuple.getInt("autoid") != null) this.setAutoid(tuple.getInt("autoid"));
			if( tuple.getInt("StudyDetails_otherCitations_autoid") != null) this.setAutoid(tuple.getInt("StudyDetails_otherCitations_autoid"));
			//set OtherCitations
			if( strict || tuple.getInt("otherCitations_id") != null) this.setOtherCitations(tuple.getInt("otherCitations_id"));
			if( tuple.getInt("StudyDetails_otherCitations_otherCitations_id") != null) this.setOtherCitations(tuple.getInt("StudyDetails_otherCitations_otherCitations_id"));
			//alias of xref
			if( tuple.getObject("otherCitations") != null) this.setOtherCitations(tuple.getInt("otherCitations"));
			if( tuple.getObject("StudyDetails_otherCitations_otherCitations") != null) this.setOtherCitations(tuple.getInt("StudyDetails_otherCitations_otherCitations"));
			//set label for field OtherCitations
			if( strict || tuple.getObject("otherCitations_Identifier") != null) this.setOtherCitations_Identifier(tuple.getString("otherCitations_Identifier"));			
			if( tuple.getObject("StudyDetails_otherCitations_otherCitations_Identifier") != null ) this.setOtherCitations_Identifier(tuple.getString("StudyDetails_otherCitations_otherCitations_Identifier"));		
			//set StudyDetails
			if( strict || tuple.getInt("StudyDetails_id") != null) this.setStudyDetails(tuple.getInt("StudyDetails_id"));
			if( tuple.getInt("StudyDetails_otherCitations_StudyDetails_id") != null) this.setStudyDetails(tuple.getInt("StudyDetails_otherCitations_StudyDetails_id"));
			//alias of xref
			if( tuple.getObject("StudyDetails") != null) this.setStudyDetails(tuple.getInt("StudyDetails"));
			if( tuple.getObject("StudyDetails_otherCitations_StudyDetails") != null) this.setStudyDetails(tuple.getInt("StudyDetails_otherCitations_StudyDetails"));
			//set label for field StudyDetails
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
		String result = "StudyDetails_OtherCitations(";
		result+= "autoid='" + getAutoid()+"' ";	
		result+= " otherCitations_id='" + getOtherCitations_Id()+"' ";	
		result+= " otherCitations_identifier='" + getOtherCitations_Identifier()+"' ";
		result+= " studyDetails_id='" + getStudyDetails_Id()+"' ";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of StudyDetails_OtherCitations.
	 */
	public java.util.Vector<String> getFields(boolean skipAutoIds)
	{
		java.util.Vector<String> fields = new java.util.Vector<String>();
		if(!skipAutoIds)
		{
			fields.add("autoid");
		}
		{
			fields.add("otherCitations_id");
		}
		fields.add("otherCitations_identifier");
		{
			fields.add("studyDetails_id");
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
		return "autoid";
	}
	

	
	@Override
	public java.util.List<String> getLabelFields()
	{
		java.util.List<String> result = new java.util.ArrayList<String>();
		result.add("otherCitations");
		result.add("StudyDetails");
		return result;
	}

	@Deprecated
	public String getFields(String sep)
	{
		return (""
		+ "autoid" +sep
		+ "otherCitations" +sep
		+ "studyDetails" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("otherCitations")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("studyDetails")) {
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
		StudyDetails_OtherCitations rhs = (StudyDetails_OtherCitations) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
		//otherCitations
		//studyDetails
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
			Object valueO = getAutoid();
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
			Object valueO = getOtherCitations();
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
			Object valueO = getStudyDetails();
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
	public StudyDetails_OtherCitations create(org.molgenis.util.Tuple tuple) throws Exception
	{
		StudyDetails_OtherCitations e = new StudyDetails_OtherCitations();
		e.set(tuple);
		return e;
	}
	

	
}

