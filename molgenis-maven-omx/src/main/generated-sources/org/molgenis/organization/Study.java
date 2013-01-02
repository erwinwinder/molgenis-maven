
/* File:        org.molgenis.omx/model/Study.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.organization;

/**
 * Study: Investigation defines self-contained units of study. For
				example: Framingham study. Optionally a description and an accession
				to a data source can be provided. Each Investigation has a unique
				identifier.
			
.
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "Study", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "Identifier" } ) }
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.organization.db.StudyEntityListener.class})
public class Study extends org.molgenis.util.AbstractEntity implements org.molgenis.core.Identifiable
{
	// fieldname constants
	public final static String ID = "id";
	public final static String IDENTIFIER = "Identifier";
	public final static String NAME = "Name";
	public final static String DESCRIPTION = "Description";
	public final static String STARTDATE = "StartDate";
	public final static String UPDATEDATE = "UpdateDate";
	public final static String ENDDATE = "EndDate";
	public final static String CONTACT = "Contact";
	public final static String CONTACT_NAME = "Contact_Name";
	public final static String PARTOFINVESTIGATION = "PartOfInvestigation";
	public final static String PARTOFINVESTIGATION_IDENTIFIER = "PartOfInvestigation_Identifier";
	
	//static methods
	/**
	 * Shorthand for db.query(Study.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Study> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Study.class);
	}
	
	/**
	 * Shorthand for db.find(Study.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Study> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Study.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Study findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Study> q = db.query(Study.class);
		q.eq(Study.ID, id);
		java.util.List<Study> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Study findByIdentifier(org.molgenis.framework.db.Database db, String identifier) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Study> q = db.query(Study.class);
		q.eq(Study.IDENTIFIER, identifier);
		java.util.List<Study> result = q.find();
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


	//(Optional)      Rudimentary meta data about the Investigation[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="Description", length=16777216)
	
				

	private String description =  null;


	//The start point of the study.[type=datetime]
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@javax.persistence.Column(name="StartDate")
	@javax.xml.bind.annotation.XmlElement(name="startDate")
	
				

	private java.util.Date startDate =  new java.sql.Date(new java.util.Date().getTime());


	//Last time the investigation was modified[type=datetime]
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@javax.persistence.Column(name="UpdateDate", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="updateDate")
	
				

	@javax.validation.constraints.NotNull
	private java.util.Date updateDate =  new java.sql.Date(new java.util.Date().getTime());


	//The end point of the study.[type=datetime]
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@javax.persistence.Column(name="EndDate")
	@javax.xml.bind.annotation.XmlElement(name="endDate")
	
				

	private java.util.Date endDate =  null;


	//Primary contact person for this study[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Contact")   	
	
				

	private org.molgenis.organization.Person contact = null;
	@javax.persistence.Transient
	private Integer contact_id = null;	
	@javax.persistence.Transient
	private String contact_Name = null;						


	//xref to the investigation the study is part of[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="PartOfInvestigation", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.gwascentral.Investigation partOfInvestigation = null;
	@javax.persistence.Transient
	private Integer partOfInvestigation_id = null;	
	@javax.persistence.Transient
	private String partOfInvestigation_Identifier = null;						

	//constructors
	public Study()
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
	 * Get the (Optional)      Rudimentary meta data about the Investigation.
	 * @return description.
	 */
	public String getDescription()
	{
		return this.description;
	}
	
	@Deprecated
	public String getDescription(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the (Optional)      Rudimentary meta data about the Investigation.
	 * @param description
	 */
	public void setDescription( String description)
	{
		
		this.description = description;
	}

	

	/**
	 * Get the The start point of the study..
	 * @return startDate.
	 */
	public java.util.Date getStartDate()
	{
		return this.startDate;
	}
	
	@Deprecated
	public java.util.Date getStartDate(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the The start point of the study..
	 * @param startDate
	 */
	public void setStartDate( java.util.Date startDate)
	{
		
		this.startDate = startDate;
	}

	

	/**
	 * Get the Last time the investigation was modified.
	 * @return updateDate.
	 */
	public java.util.Date getUpdateDate()
	{
		return this.updateDate;
	}
	
	@Deprecated
	public java.util.Date getUpdateDate(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Last time the investigation was modified.
	 * @param updateDate
	 */
	public void setUpdateDate( java.util.Date updateDate)
	{
		
		this.updateDate = updateDate;
	}

	

	/**
	 * Get the The end point of the study..
	 * @return endDate.
	 */
	public java.util.Date getEndDate()
	{
		return this.endDate;
	}
	
	@Deprecated
	public java.util.Date getEndDate(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the The end point of the study..
	 * @param endDate
	 */
	public void setEndDate( java.util.Date endDate)
	{
		
		this.endDate = endDate;
	}

	

	/**
	 * Get the Primary contact person for this study.
	 * @return contact.
	 */
	public org.molgenis.organization.Person getContact()
	{
		return this.contact;
	}
	
	@Deprecated
	public org.molgenis.organization.Person getContact(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Primary contact person for this study.
	 * @param contact
	 */
	public void setContact( org.molgenis.organization.Person contact)
	{
		
		this.contact = contact;
	}

	
	
	/**
	 * Set foreign key for field contact.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setContact_Id(Integer contact_id)
	{
		this.contact_id = contact_id;
	}	

	public void setContact(Integer contact_id)
	{
		this.contact_id = contact_id;
	}
	
	public Integer getContact_Id()
	{
		
		if(contact != null) 
		{
			return contact.getId();
		}
		else
		{
			return contact_id;
		}
	}	
	 
	/**
	 * Get a pretty label Name for cross reference Contact to Person.Id.
	 */
	public String getContact_Name()
	{		
		//FIXME should we auto-load based on getContact()?	
		if(contact != null) {
			return contact.getName();
		} else {
			return contact_Name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Contact to <a href="Person.html#Id">Person.Id</a>.
	 * Implies setContact(null) until save
	 */
	public void setContact_Name(String contact_Name)
	{
		this.contact_Name = contact_Name;
	}		
	 
	

	/**
	 * Get the xref to the investigation the study is part of.
	 * @return partOfInvestigation.
	 */
	public org.molgenis.gwascentral.Investigation getPartOfInvestigation()
	{
		return this.partOfInvestigation;
	}
	
	@Deprecated
	public org.molgenis.gwascentral.Investigation getPartOfInvestigation(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the xref to the investigation the study is part of.
	 * @param partOfInvestigation
	 */
	public void setPartOfInvestigation( org.molgenis.gwascentral.Investigation partOfInvestigation)
	{
		
		this.partOfInvestigation = partOfInvestigation;
	}

	
	
	/**
	 * Set foreign key for field partOfInvestigation.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setPartOfInvestigation_Id(Integer partOfInvestigation_id)
	{
		this.partOfInvestigation_id = partOfInvestigation_id;
	}	

	public void setPartOfInvestigation(Integer partOfInvestigation_id)
	{
		this.partOfInvestigation_id = partOfInvestigation_id;
	}
	
	public Integer getPartOfInvestigation_Id()
	{
		
		if(partOfInvestigation != null) 
		{
			return partOfInvestigation.getId();
		}
		else
		{
			return partOfInvestigation_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference PartOfInvestigation to Investigation.Id.
	 */
	public String getPartOfInvestigation_Identifier()
	{		
		//FIXME should we auto-load based on getPartOfInvestigation()?	
		if(partOfInvestigation != null) {
			return partOfInvestigation.getIdentifier();
		} else {
			return partOfInvestigation_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference PartOfInvestigation to <a href="Investigation.html#Id">Investigation.Id</a>.
	 * Implies setPartOfInvestigation(null) until save
	 */
	public void setPartOfInvestigation_Identifier(String partOfInvestigation_Identifier)
	{
		this.partOfInvestigation_Identifier = partOfInvestigation_Identifier;
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
		if (name.toLowerCase().equals("description"))
			return getDescription();
		if (name.toLowerCase().equals("startdate"))
			return getStartDate();
		if (name.toLowerCase().equals("updatedate"))
			return getUpdateDate();
		if (name.toLowerCase().equals("enddate"))
			return getEndDate();
		if (name.toLowerCase().equals("contact"))
			return getContact();
		if(name.toLowerCase().equals("contact_id"))
			return getContact_Id();
		if(name.toLowerCase().equals("contact_name"))
			return getContact_Name();
		if (name.toLowerCase().equals("partofinvestigation"))
			return getPartOfInvestigation();
		if(name.toLowerCase().equals("partofinvestigation_id"))
			return getPartOfInvestigation_Id();
		if(name.toLowerCase().equals("partofinvestigation_identifier"))
			return getPartOfInvestigation_Identifier();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getIdentifier() == null) throw new org.molgenis.framework.db.DatabaseException("required field identifier is null");
		if(this.getName() == null) throw new org.molgenis.framework.db.DatabaseException("required field name is null");
		if(this.getUpdateDate() == null) throw new org.molgenis.framework.db.DatabaseException("required field updateDate is null");
		if(this.getPartOfInvestigation() == null) throw new org.molgenis.framework.db.DatabaseException("required field partOfInvestigation is null");
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
			//set Description
			this.setDescription(tuple.getString("Description"));
			//set StartDate
			this.setStartDate(tuple.getTimestamp("StartDate"));
			//set UpdateDate
			this.setUpdateDate(tuple.getTimestamp("UpdateDate"));
			//set EndDate
			this.setEndDate(tuple.getTimestamp("EndDate"));
			//set Contact
			this.setContact(tuple.getInt("Contact"));
			//set label Name for xref field Contact
			this.setContact_Name(tuple.getString("Contact_Name"));	
			//set PartOfInvestigation
			this.setPartOfInvestigation(tuple.getInt("PartOfInvestigation"));
			//set label Identifier for xref field PartOfInvestigation
			this.setPartOfInvestigation_Identifier(tuple.getString("PartOfInvestigation_Identifier"));	
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("Study_id") != null) this.setId(tuple.getInt("Study_id"));
			//set Identifier
			if( strict || tuple.getString("Identifier") != null) this.setIdentifier(tuple.getString("Identifier"));
			if( tuple.getString("Study_Identifier") != null) this.setIdentifier(tuple.getString("Study_Identifier"));
			//set Name
			if( strict || tuple.getString("Name") != null) this.setName(tuple.getString("Name"));
			if( tuple.getString("Study_Name") != null) this.setName(tuple.getString("Study_Name"));
			//set Description
			if( strict || tuple.getString("Description") != null) this.setDescription(tuple.getString("Description"));
			if( tuple.getString("Study_Description") != null) this.setDescription(tuple.getString("Study_Description"));
			//set StartDate
			if( strict || tuple.getTimestamp("StartDate") != null) this.setStartDate(tuple.getTimestamp("StartDate"));
			if( tuple.getTimestamp("Study_StartDate") != null) this.setStartDate(tuple.getTimestamp("Study_StartDate"));
			//set UpdateDate
			if( strict || tuple.getTimestamp("UpdateDate") != null) this.setUpdateDate(tuple.getTimestamp("UpdateDate"));
			if( tuple.getTimestamp("Study_UpdateDate") != null) this.setUpdateDate(tuple.getTimestamp("Study_UpdateDate"));
			//set EndDate
			if( strict || tuple.getTimestamp("EndDate") != null) this.setEndDate(tuple.getTimestamp("EndDate"));
			if( tuple.getTimestamp("Study_EndDate") != null) this.setEndDate(tuple.getTimestamp("Study_EndDate"));
			//set Contact
			if( strict || tuple.getInt("Contact_id") != null) this.setContact(tuple.getInt("Contact_id"));
			if( tuple.getInt("Study_Contact_id") != null) this.setContact(tuple.getInt("Study_Contact_id"));
			//alias of xref
			if( tuple.getObject("Contact") != null) this.setContact(tuple.getInt("Contact"));
			if( tuple.getObject("Study_Contact") != null) this.setContact(tuple.getInt("Study_Contact"));
			//set label for field Contact
			if( strict || tuple.getObject("Contact_Name") != null) this.setContact_Name(tuple.getString("Contact_Name"));			
			if( tuple.getObject("Study_Contact_Name") != null ) this.setContact_Name(tuple.getString("Study_Contact_Name"));		
			//set PartOfInvestigation
			if( strict || tuple.getInt("PartOfInvestigation_id") != null) this.setPartOfInvestigation(tuple.getInt("PartOfInvestigation_id"));
			if( tuple.getInt("Study_PartOfInvestigation_id") != null) this.setPartOfInvestigation(tuple.getInt("Study_PartOfInvestigation_id"));
			//alias of xref
			if( tuple.getObject("PartOfInvestigation") != null) this.setPartOfInvestigation(tuple.getInt("PartOfInvestigation"));
			if( tuple.getObject("Study_PartOfInvestigation") != null) this.setPartOfInvestigation(tuple.getInt("Study_PartOfInvestigation"));
			//set label for field PartOfInvestigation
			if( strict || tuple.getObject("PartOfInvestigation_Identifier") != null) this.setPartOfInvestigation_Identifier(tuple.getString("PartOfInvestigation_Identifier"));			
			if( tuple.getObject("Study_PartOfInvestigation_Identifier") != null ) this.setPartOfInvestigation_Identifier(tuple.getString("Study_PartOfInvestigation_Identifier"));		
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
		String result = "Study(";
		result+= "id='" + getId()+"' ";	
		result+= "identifier='" + getIdentifier()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= "description='" + getDescription()+"' ";	
		result+= "startDate='" + (getStartDate() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy, HH:mm:ss", java.util.Locale.US).format(getStartDate()))+"' ";
		result+= "startDate='" + (getStartDate() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy", java.util.Locale.US).format(getStartDate()))+"' ";		
		result+= "updateDate='" + (getUpdateDate() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy, HH:mm:ss", java.util.Locale.US).format(getUpdateDate()))+"' ";
		result+= "updateDate='" + (getUpdateDate() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy", java.util.Locale.US).format(getUpdateDate()))+"' ";		
		result+= "endDate='" + (getEndDate() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy, HH:mm:ss", java.util.Locale.US).format(getEndDate()))+"' ";
		result+= "endDate='" + (getEndDate() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy", java.util.Locale.US).format(getEndDate()))+"' ";		
		result+= " contact_id='" + getContact_Id()+"' ";	
		result+= " contact_name='" + getContact_Name()+"' ";
		result+= " partOfInvestigation_id='" + getPartOfInvestigation_Id()+"' ";	
		result+= " partOfInvestigation_identifier='" + getPartOfInvestigation_Identifier()+"' ";
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Study.
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
			fields.add("description");
		}
		{
			fields.add("startDate");
		}
		{
			fields.add("updateDate");
		}
		{
			fields.add("endDate");
		}
		{
			fields.add("contact_id");
		}
		fields.add("contact_name");
		{
			fields.add("partOfInvestigation_id");
		}
		fields.add("partOfInvestigation_identifier");
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
		+ "description" +sep
		+ "startDate" +sep
		+ "updateDate" +sep
		+ "endDate" +sep
		+ "contact" +sep
		+ "partOfInvestigation" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("contact")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("partOfInvestigation")) {
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
		Study rhs = (Study) obj;
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
			Object valueO = getStartDate();
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
			Object valueO = getUpdateDate();
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
			Object valueO = getEndDate();
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
			Object valueO = getContact();
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
			Object valueO = getPartOfInvestigation();
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
	public Study create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Study e = new Study();
		e.set(tuple);
		return e;
	}
	
//4
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="study"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.organization.Experiment> studyExperimentCollection = new java.util.ArrayList<org.molgenis.organization.Experiment>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.organization.Experiment> getStudyExperimentCollection()
	{
            return studyExperimentCollection;
	}

    public void setStudyExperimentCollection(java.util.Collection<org.molgenis.organization.Experiment> collection)
    {
        for (org.molgenis.organization.Experiment experiment : collection) {
            experiment.setStudy(this);
        }
        studyExperimentCollection = collection;
    }	
//4
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="study"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.organization.Submission> studySubmissionCollection = new java.util.ArrayList<org.molgenis.organization.Submission>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.organization.Submission> getStudySubmissionCollection()
	{
            return studySubmissionCollection;
	}

    public void setStudySubmissionCollection(java.util.Collection<org.molgenis.organization.Submission> collection)
    {
        for (org.molgenis.organization.Submission submission : collection) {
            submission.setStudy(this);
        }
        studySubmissionCollection = collection;
    }	
//4
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="study"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.gwascentral.StudyDetails> studyStudyDetailsCollection = new java.util.ArrayList<org.molgenis.gwascentral.StudyDetails>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.gwascentral.StudyDetails> getStudyStudyDetailsCollection()
	{
            return studyStudyDetailsCollection;
	}

    public void setStudyStudyDetailsCollection(java.util.Collection<org.molgenis.gwascentral.StudyDetails> collection)
    {
        for (org.molgenis.gwascentral.StudyDetails studyDetails : collection) {
            studyDetails.setStudy(this);
        }
        studyStudyDetailsCollection = collection;
    }	
//4
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="studyID"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.gwascentral.PhenotypeMethod> studyIDPhenotypeMethodCollection = new java.util.ArrayList<org.molgenis.gwascentral.PhenotypeMethod>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.gwascentral.PhenotypeMethod> getStudyIDPhenotypeMethodCollection()
	{
            return studyIDPhenotypeMethodCollection;
	}

    public void setStudyIDPhenotypeMethodCollection(java.util.Collection<org.molgenis.gwascentral.PhenotypeMethod> collection)
    {
        for (org.molgenis.gwascentral.PhenotypeMethod phenotypeMethod : collection) {
            phenotypeMethod.setStudyID(this);
        }
        studyIDPhenotypeMethodCollection = collection;
    }	

	
}

