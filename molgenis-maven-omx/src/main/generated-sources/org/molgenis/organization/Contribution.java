
/* File:        org.molgenis.omx/model/Contribution.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.organization;

/**
 * Contribution: A contribution describes the part a Person has
				contributed to a Contributable item.
			
.
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "Contribution", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "Identifier" } ) }
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.organization.db.ContributionEntityListener.class})
public class Contribution extends org.molgenis.util.AbstractEntity implements org.molgenis.core.Identifiable
{
	// fieldname constants
	public final static String ID = "id";
	public final static String IDENTIFIER = "Identifier";
	public final static String NAME = "Name";
	public final static String RESEARCHER = "Researcher";
	public final static String RESEARCHER_NAME = "Researcher_Name";
	public final static String SUBMISSION = "Submission";
	public final static String SUBMISSION_IDENTIFIER = "Submission_Identifier";
	public final static String ISSUBMITTER = "IsSubmitter";
	public final static String ISAUTHOR = "IsAuthor";
	public final static String ISSOURCE = "IsSource";
	
	//static methods
	/**
	 * Shorthand for db.query(Contribution.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Contribution> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Contribution.class);
	}
	
	/**
	 * Shorthand for db.find(Contribution.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Contribution> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Contribution.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Contribution findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Contribution> q = db.query(Contribution.class);
		q.eq(Contribution.ID, id);
		java.util.List<Contribution> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Contribution findByIdentifier(org.molgenis.framework.db.Database db, String identifier) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Contribution> q = db.query(Contribution.class);
		q.eq(Contribution.IDENTIFIER, identifier);
		java.util.List<Contribution> result = q.find();
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


	//The person involved[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Researcher", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.organization.Person researcher = null;
	@javax.persistence.Transient
	private Integer researcher_id = null;	
	@javax.persistence.Transient
	private String researcher_Name = null;						


	//The submission contributed to.[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Submission", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.organization.Submission submission = null;
	@javax.persistence.Transient
	private Integer submission_id = null;	
	@javax.persistence.Transient
	private String submission_Identifier = null;						


	//Submitter?[type=enum]
	@javax.persistence.Column(name="IsSubmitter", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="isSubmitter")
	
				

	@javax.validation.constraints.NotNull
	private String isSubmitter =  null;
	@javax.persistence.Transient
	private String isSubmitter_label = null;
	@javax.persistence.Transient
	private java.util.List<org.molgenis.util.ValueLabel> isSubmitter_options = new java.util.ArrayList<org.molgenis.util.ValueLabel>();


	//Author?[type=enum]
	@javax.persistence.Column(name="IsAuthor", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="isAuthor")
	
				

	@javax.validation.constraints.NotNull
	private String isAuthor =  null;
	@javax.persistence.Transient
	private String isAuthor_label = null;
	@javax.persistence.Transient
	private java.util.List<org.molgenis.util.ValueLabel> isAuthor_options = new java.util.ArrayList<org.molgenis.util.ValueLabel>();


	//Source?[type=enum]
	@javax.persistence.Column(name="IsSource", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="isSource")
	
				

	@javax.validation.constraints.NotNull
	private String isSource =  null;
	@javax.persistence.Transient
	private String isSource_label = null;
	@javax.persistence.Transient
	private java.util.List<org.molgenis.util.ValueLabel> isSource_options = new java.util.ArrayList<org.molgenis.util.ValueLabel>();

	//constructors
	public Contribution()
	{
	
		//options for enum IsSubmitter
		isSubmitter_options.add(new org.molgenis.util.ValueLabel("yes","yes"));
		isSubmitter_options.add(new org.molgenis.util.ValueLabel("no","no"));
		//options for enum IsAuthor
		isAuthor_options.add(new org.molgenis.util.ValueLabel("yes","yes"));
		isAuthor_options.add(new org.molgenis.util.ValueLabel("no","no"));
		//options for enum IsSource
		isSource_options.add(new org.molgenis.util.ValueLabel("yes","yes"));
		isSource_options.add(new org.molgenis.util.ValueLabel("no","no"));
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
	 * Get the The person involved.
	 * @return researcher.
	 */
	public org.molgenis.organization.Person getResearcher()
	{
		return this.researcher;
	}
	
	@Deprecated
	public org.molgenis.organization.Person getResearcher(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the The person involved.
	 * @param researcher
	 */
	public void setResearcher( org.molgenis.organization.Person researcher)
	{
		
		this.researcher = researcher;
	}

	
	
	/**
	 * Set foreign key for field researcher.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setResearcher_Id(Integer researcher_id)
	{
		this.researcher_id = researcher_id;
	}	

	public void setResearcher(Integer researcher_id)
	{
		this.researcher_id = researcher_id;
	}
	
	public Integer getResearcher_Id()
	{
		
		if(researcher != null) 
		{
			return researcher.getId();
		}
		else
		{
			return researcher_id;
		}
	}	
	 
	/**
	 * Get a pretty label Name for cross reference Researcher to Person.Id.
	 */
	public String getResearcher_Name()
	{		
		//FIXME should we auto-load based on getResearcher()?	
		if(researcher != null) {
			return researcher.getName();
		} else {
			return researcher_Name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Researcher to <a href="Person.html#Id">Person.Id</a>.
	 * Implies setResearcher(null) until save
	 */
	public void setResearcher_Name(String researcher_Name)
	{
		this.researcher_Name = researcher_Name;
	}		
	 
	

	/**
	 * Get the The submission contributed to..
	 * @return submission.
	 */
	public org.molgenis.organization.Submission getSubmission()
	{
		return this.submission;
	}
	
	@Deprecated
	public org.molgenis.organization.Submission getSubmission(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the The submission contributed to..
	 * @param submission
	 */
	public void setSubmission( org.molgenis.organization.Submission submission)
	{
		
		this.submission = submission;
	}

	
	
	/**
	 * Set foreign key for field submission.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setSubmission_Id(Integer submission_id)
	{
		this.submission_id = submission_id;
	}	

	public void setSubmission(Integer submission_id)
	{
		this.submission_id = submission_id;
	}
	
	public Integer getSubmission_Id()
	{
		
		if(submission != null) 
		{
			return submission.getId();
		}
		else
		{
			return submission_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference Submission to Submission.Id.
	 */
	public String getSubmission_Identifier()
	{		
		//FIXME should we auto-load based on getSubmission()?	
		if(submission != null) {
			return submission.getIdentifier();
		} else {
			return submission_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Submission to <a href="Submission.html#Id">Submission.Id</a>.
	 * Implies setSubmission(null) until save
	 */
	public void setSubmission_Identifier(String submission_Identifier)
	{
		this.submission_Identifier = submission_Identifier;
	}		
	 
	

	/**
	 * Get the Submitter?.
	 * @return isSubmitter.
	 */
	public String getIsSubmitter()
	{
		return this.isSubmitter;
	}
	
	@Deprecated
	public String getIsSubmitter(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Submitter?.
	 * @param isSubmitter
	 */
	public void setIsSubmitter( String isSubmitter)
	{
		
		this.isSubmitter = isSubmitter;
	}

	
	/**
	 * Get tha label for enum IsSubmitter.
	 */
	public String getIsSubmitterLabel()
	{
		return this.isSubmitter_label;
	}
	
	/**
	 * IsSubmitter is enum. This method returns all available enum options.
	 */
	public java.util.List<org.molgenis.util.ValueLabel> getIsSubmitterOptions()
	{
		return isSubmitter_options;
	}	
	

	/**
	 * Get the Author?.
	 * @return isAuthor.
	 */
	public String getIsAuthor()
	{
		return this.isAuthor;
	}
	
	@Deprecated
	public String getIsAuthor(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Author?.
	 * @param isAuthor
	 */
	public void setIsAuthor( String isAuthor)
	{
		
		this.isAuthor = isAuthor;
	}

	
	/**
	 * Get tha label for enum IsAuthor.
	 */
	public String getIsAuthorLabel()
	{
		return this.isAuthor_label;
	}
	
	/**
	 * IsAuthor is enum. This method returns all available enum options.
	 */
	public java.util.List<org.molgenis.util.ValueLabel> getIsAuthorOptions()
	{
		return isAuthor_options;
	}	
	

	/**
	 * Get the Source?.
	 * @return isSource.
	 */
	public String getIsSource()
	{
		return this.isSource;
	}
	
	@Deprecated
	public String getIsSource(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Source?.
	 * @param isSource
	 */
	public void setIsSource( String isSource)
	{
		
		this.isSource = isSource;
	}

	
	/**
	 * Get tha label for enum IsSource.
	 */
	public String getIsSourceLabel()
	{
		return this.isSource_label;
	}
	
	/**
	 * IsSource is enum. This method returns all available enum options.
	 */
	public java.util.List<org.molgenis.util.ValueLabel> getIsSourceOptions()
	{
		return isSource_options;
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
		if (name.toLowerCase().equals("researcher"))
			return getResearcher();
		if(name.toLowerCase().equals("researcher_id"))
			return getResearcher_Id();
		if(name.toLowerCase().equals("researcher_name"))
			return getResearcher_Name();
		if (name.toLowerCase().equals("submission"))
			return getSubmission();
		if(name.toLowerCase().equals("submission_id"))
			return getSubmission_Id();
		if(name.toLowerCase().equals("submission_identifier"))
			return getSubmission_Identifier();
		if (name.toLowerCase().equals("issubmitter"))
			return getIsSubmitter();
		if(name.toLowerCase().equals("issubmitter_label"))
			return getIsSubmitterLabel();
		if (name.toLowerCase().equals("isauthor"))
			return getIsAuthor();
		if(name.toLowerCase().equals("isauthor_label"))
			return getIsAuthorLabel();
		if (name.toLowerCase().equals("issource"))
			return getIsSource();
		if(name.toLowerCase().equals("issource_label"))
			return getIsSourceLabel();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getIdentifier() == null) throw new org.molgenis.framework.db.DatabaseException("required field identifier is null");
		if(this.getName() == null) throw new org.molgenis.framework.db.DatabaseException("required field name is null");
		if(this.getResearcher() == null) throw new org.molgenis.framework.db.DatabaseException("required field researcher is null");
		if(this.getSubmission() == null) throw new org.molgenis.framework.db.DatabaseException("required field submission is null");
		if(this.getIsSubmitter() == null) throw new org.molgenis.framework.db.DatabaseException("required field isSubmitter is null");
		if(this.getIsAuthor() == null) throw new org.molgenis.framework.db.DatabaseException("required field isAuthor is null");
		if(this.getIsSource() == null) throw new org.molgenis.framework.db.DatabaseException("required field isSource is null");
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
			//set Researcher
			this.setResearcher(tuple.getInt("Researcher"));
			//set label Name for xref field Researcher
			this.setResearcher_Name(tuple.getString("Researcher_Name"));	
			//set Submission
			this.setSubmission(tuple.getInt("Submission"));
			//set label Identifier for xref field Submission
			this.setSubmission_Identifier(tuple.getString("Submission_Identifier"));	
			//set IsSubmitter
			this.setIsSubmitter(tuple.getString("IsSubmitter"));
			//set IsAuthor
			this.setIsAuthor(tuple.getString("IsAuthor"));
			//set IsSource
			this.setIsSource(tuple.getString("IsSource"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("Contribution_id") != null) this.setId(tuple.getInt("Contribution_id"));
			//set Identifier
			if( strict || tuple.getString("Identifier") != null) this.setIdentifier(tuple.getString("Identifier"));
			if( tuple.getString("Contribution_Identifier") != null) this.setIdentifier(tuple.getString("Contribution_Identifier"));
			//set Name
			if( strict || tuple.getString("Name") != null) this.setName(tuple.getString("Name"));
			if( tuple.getString("Contribution_Name") != null) this.setName(tuple.getString("Contribution_Name"));
			//set Researcher
			if( strict || tuple.getInt("Researcher_id") != null) this.setResearcher(tuple.getInt("Researcher_id"));
			if( tuple.getInt("Contribution_Researcher_id") != null) this.setResearcher(tuple.getInt("Contribution_Researcher_id"));
			//alias of xref
			if( tuple.getObject("Researcher") != null) this.setResearcher(tuple.getInt("Researcher"));
			if( tuple.getObject("Contribution_Researcher") != null) this.setResearcher(tuple.getInt("Contribution_Researcher"));
			//set label for field Researcher
			if( strict || tuple.getObject("Researcher_Name") != null) this.setResearcher_Name(tuple.getString("Researcher_Name"));			
			if( tuple.getObject("Contribution_Researcher_Name") != null ) this.setResearcher_Name(tuple.getString("Contribution_Researcher_Name"));		
			//set Submission
			if( strict || tuple.getInt("Submission_id") != null) this.setSubmission(tuple.getInt("Submission_id"));
			if( tuple.getInt("Contribution_Submission_id") != null) this.setSubmission(tuple.getInt("Contribution_Submission_id"));
			//alias of xref
			if( tuple.getObject("Submission") != null) this.setSubmission(tuple.getInt("Submission"));
			if( tuple.getObject("Contribution_Submission") != null) this.setSubmission(tuple.getInt("Contribution_Submission"));
			//set label for field Submission
			if( strict || tuple.getObject("Submission_Identifier") != null) this.setSubmission_Identifier(tuple.getString("Submission_Identifier"));			
			if( tuple.getObject("Contribution_Submission_Identifier") != null ) this.setSubmission_Identifier(tuple.getString("Contribution_Submission_Identifier"));		
			//set IsSubmitter
			if( strict || tuple.getString("IsSubmitter") != null) this.setIsSubmitter(tuple.getString("IsSubmitter"));
			if( tuple.getString("Contribution_IsSubmitter") != null) this.setIsSubmitter(tuple.getString("Contribution_IsSubmitter"));
			//set IsAuthor
			if( strict || tuple.getString("IsAuthor") != null) this.setIsAuthor(tuple.getString("IsAuthor"));
			if( tuple.getString("Contribution_IsAuthor") != null) this.setIsAuthor(tuple.getString("Contribution_IsAuthor"));
			//set IsSource
			if( strict || tuple.getString("IsSource") != null) this.setIsSource(tuple.getString("IsSource"));
			if( tuple.getString("Contribution_IsSource") != null) this.setIsSource(tuple.getString("Contribution_IsSource"));
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
		String result = "Contribution(";
		result+= "id='" + getId()+"' ";	
		result+= "identifier='" + getIdentifier()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= " researcher_id='" + getResearcher_Id()+"' ";	
		result+= " researcher_name='" + getResearcher_Name()+"' ";
		result+= " submission_id='" + getSubmission_Id()+"' ";	
		result+= " submission_identifier='" + getSubmission_Identifier()+"' ";
		result+= "isSubmitter='" + getIsSubmitter()+"' ";	
		result+= "isAuthor='" + getIsAuthor()+"' ";	
		result+= "isSource='" + getIsSource()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Contribution.
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
			fields.add("researcher_id");
		}
		fields.add("researcher_name");
		{
			fields.add("submission_id");
		}
		fields.add("submission_identifier");
		{
			fields.add("isSubmitter");
		}
		{
			fields.add("isAuthor");
		}
		{
			fields.add("isSource");
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
		+ "researcher" +sep
		+ "submission" +sep
		+ "isSubmitter" +sep
		+ "isAuthor" +sep
		+ "isSource" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("researcher")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("submission")) {
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
		Contribution rhs = (Contribution) obj;
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
			Object valueO = getResearcher();
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
			Object valueO = getSubmission();
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
			Object valueO = getIsSubmitter();
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
			Object valueO = getIsAuthor();
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
			Object valueO = getIsSource();
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
	public Contribution create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Contribution e = new Contribution();
		e.set(tuple);
		return e;
	}
	

	
}

