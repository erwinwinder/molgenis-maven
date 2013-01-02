
/* File:        org.molgenis.omx/model/Submission.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.organization;

/**
 * Submission: .
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "Submission", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "Identifier" } ) }
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.organization.db.SubmissionEntityListener.class})
public class Submission extends org.molgenis.util.AbstractEntity implements org.molgenis.core.Identifiable
{
	// fieldname constants
	public final static String ID = "id";
	public final static String IDENTIFIER = "Identifier";
	public final static String NAME = "Name";
	public final static String TIMECREATED = "TimeCreated";
	public final static String STUDY = "Study";
	public final static String STUDY_IDENTIFIER = "Study_Identifier";
	
	//static methods
	/**
	 * Shorthand for db.query(Submission.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Submission> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Submission.class);
	}
	
	/**
	 * Shorthand for db.find(Submission.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Submission> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Submission.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Submission findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Submission> q = db.query(Submission.class);
		q.eq(Submission.ID, id);
		java.util.List<Submission> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Submission findByIdentifier(org.molgenis.framework.db.Database db, String identifier) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Submission> q = db.query(Submission.class);
		q.eq(Submission.IDENTIFIER, identifier);
		java.util.List<Submission> result = q.find();
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


	//user supplied or automatically assigned (using a decorator) unique and short identifier, e.g. MA1234[type=string]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="Identifier", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="identifier")
	
				

	@javax.validation.constraints.NotNull
	private String identifier =  null;


	//human readible name, not necessary unique.[type=string]
	@javax.persistence.Column(name="Name", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="name")
	
				

	@javax.validation.constraints.NotNull
	private String name =  null;


	//Time created[type=datetime]
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@javax.persistence.Column(name="TimeCreated", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="timeCreated")
	
				

	@javax.validation.constraints.NotNull
	private java.util.Date timeCreated =  null;


	//Study[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Study", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.organization.Study study = null;
	@javax.persistence.Transient
	private Integer study_id = null;	
	@javax.persistence.Transient
	private String study_Identifier = null;						

	//constructors
	public Submission()
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
	 * Get the human readible name, not necessary unique..
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
	 * Set the human readible name, not necessary unique..
	 * @param name
	 */
	public void setName( String name)
	{
		
		this.name = name;
	}

	

	/**
	 * Get the Time created.
	 * @return timeCreated.
	 */
	public java.util.Date getTimeCreated()
	{
		return this.timeCreated;
	}
	
	@Deprecated
	public java.util.Date getTimeCreated(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Time created.
	 * @param timeCreated
	 */
	public void setTimeCreated( java.util.Date timeCreated)
	{
		
		this.timeCreated = timeCreated;
	}

	

	/**
	 * Get the Study.
	 * @return study.
	 */
	public org.molgenis.organization.Study getStudy()
	{
		return this.study;
	}
	
	@Deprecated
	public org.molgenis.organization.Study getStudy(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Study.
	 * @param study
	 */
	public void setStudy( org.molgenis.organization.Study study)
	{
		
		this.study = study;
	}

	
	
	/**
	 * Set foreign key for field study.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setStudy_Id(Integer study_id)
	{
		this.study_id = study_id;
	}	

	public void setStudy(Integer study_id)
	{
		this.study_id = study_id;
	}
	
	public Integer getStudy_Id()
	{
		
		if(study != null) 
		{
			return study.getId();
		}
		else
		{
			return study_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference Study to Study.Id.
	 */
	public String getStudy_Identifier()
	{		
		//FIXME should we auto-load based on getStudy()?	
		if(study != null) {
			return study.getIdentifier();
		} else {
			return study_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Study to <a href="Study.html#Id">Study.Id</a>.
	 * Implies setStudy(null) until save
	 */
	public void setStudy_Identifier(String study_Identifier)
	{
		this.study_Identifier = study_Identifier;
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
		if (name.toLowerCase().equals("timecreated"))
			return getTimeCreated();
		if (name.toLowerCase().equals("study"))
			return getStudy();
		if(name.toLowerCase().equals("study_id"))
			return getStudy_Id();
		if(name.toLowerCase().equals("study_identifier"))
			return getStudy_Identifier();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getIdentifier() == null) throw new org.molgenis.framework.db.DatabaseException("required field identifier is null");
		if(this.getName() == null) throw new org.molgenis.framework.db.DatabaseException("required field name is null");
		if(this.getTimeCreated() == null) throw new org.molgenis.framework.db.DatabaseException("required field timeCreated is null");
		if(this.getStudy() == null) throw new org.molgenis.framework.db.DatabaseException("required field study is null");
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
			//set TimeCreated
			this.setTimeCreated(tuple.getTimestamp("TimeCreated"));
			//set Study
			this.setStudy(tuple.getInt("Study"));
			//set label Identifier for xref field Study
			this.setStudy_Identifier(tuple.getString("Study_Identifier"));	
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("Submission_id") != null) this.setId(tuple.getInt("Submission_id"));
			//set Identifier
			if( strict || tuple.getString("Identifier") != null) this.setIdentifier(tuple.getString("Identifier"));
			if( tuple.getString("Submission_Identifier") != null) this.setIdentifier(tuple.getString("Submission_Identifier"));
			//set Name
			if( strict || tuple.getString("Name") != null) this.setName(tuple.getString("Name"));
			if( tuple.getString("Submission_Name") != null) this.setName(tuple.getString("Submission_Name"));
			//set TimeCreated
			if( strict || tuple.getTimestamp("TimeCreated") != null) this.setTimeCreated(tuple.getTimestamp("TimeCreated"));
			if( tuple.getTimestamp("Submission_TimeCreated") != null) this.setTimeCreated(tuple.getTimestamp("Submission_TimeCreated"));
			//set Study
			if( strict || tuple.getInt("Study_id") != null) this.setStudy(tuple.getInt("Study_id"));
			if( tuple.getInt("Submission_Study_id") != null) this.setStudy(tuple.getInt("Submission_Study_id"));
			//alias of xref
			if( tuple.getObject("Study") != null) this.setStudy(tuple.getInt("Study"));
			if( tuple.getObject("Submission_Study") != null) this.setStudy(tuple.getInt("Submission_Study"));
			//set label for field Study
			if( strict || tuple.getObject("Study_Identifier") != null) this.setStudy_Identifier(tuple.getString("Study_Identifier"));			
			if( tuple.getObject("Submission_Study_Identifier") != null ) this.setStudy_Identifier(tuple.getString("Submission_Study_Identifier"));		
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
		String result = "Submission(";
		result+= "id='" + getId()+"' ";	
		result+= "identifier='" + getIdentifier()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= "timeCreated='" + (getTimeCreated() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy, HH:mm:ss", java.util.Locale.US).format(getTimeCreated()))+"' ";
		result+= "timeCreated='" + (getTimeCreated() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy", java.util.Locale.US).format(getTimeCreated()))+"' ";		
		result+= " study_id='" + getStudy_Id()+"' ";	
		result+= " study_identifier='" + getStudy_Identifier()+"' ";
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Submission.
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
			fields.add("timeCreated");
		}
		{
			fields.add("study_id");
		}
		fields.add("study_identifier");
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
		+ "timeCreated" +sep
		+ "study" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("study")) {
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
		Submission rhs = (Submission) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
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
			Object valueO = getTimeCreated();
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
			Object valueO = getStudy();
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
	public Submission create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Submission e = new Submission();
		e.set(tuple);
		return e;
	}
	
//1
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="submission"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.organization.Contribution> submissionContributionCollection = new java.util.ArrayList<org.molgenis.organization.Contribution>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.organization.Contribution> getSubmissionContributionCollection()
	{
            return submissionContributionCollection;
	}

    public void setSubmissionContributionCollection(java.util.Collection<org.molgenis.organization.Contribution> collection)
    {
        for (org.molgenis.organization.Contribution contribution : collection) {
            contribution.setSubmission(this);
        }
        submissionContributionCollection = collection;
    }	

	
}

