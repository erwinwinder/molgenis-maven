
/* File:        org.molgenis/model/Person.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.organization;

/**
 * Person: 

				Person represents one or more people involved with an Investigation.
				This may include authors on a paper, lab personnel or PIs. Person
				has last name, firstname, mid initial, address, contact and email. A
				Person role is included to represent how a Person is involved with
				an investigation. For submission to repository purposes an allowed
				value is 'submitter' and the term is present in the MGED Ontology,
				an alternative use could represent job title. An Example from
				ArrayExpress is E-MTAB-506
				<a href="ftp://ftp.ebi.ac.uk/pub/databases/microarray/data/experiment/TABM/E-TABM-506/E-TABM-506.idf.txt">
					ftp://ftp.ebi.ac.uk/pub/databases/microarray/data/experiment/TABM/E-TABM-506/E-TABM-506.idf.txt.
				</a>
				.
    <!-- From MIBBI : Name should either be of the person or the institutional role holding responsibility for the associated (meta)data. -->
    <br/>
				The FUGE equivalent to Person is FuGE::Person.
			
.
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "Person", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "Name" }), @javax.persistence.UniqueConstraint( columnNames={ "FirstName", "MidInitials", "LastName" } ) }
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.organization.db.PersonEntityListener.class})
public class Person extends org.molgenis.util.AbstractEntity implements org.molgenis.core.Autoid
{
	// fieldname constants
	public final static String ID = "id";
	public final static String NAME = "Name";
	public final static String TITLE = "Title";
	public final static String FIRSTNAME = "FirstName";
	public final static String MIDINITIALS = "MidInitials";
	public final static String LASTNAME = "LastName";
	public final static String EMAIL = "Email";
	public final static String PHONE = "Phone";
	public final static String PRIMARYAFFILATION = "PrimaryAffilation";
	public final static String PRIMARYAFFILATION_NAME = "PrimaryAffilation_name";
	public final static String AFFILIATEINSTITUTIONS = "AffiliateInstitutions";
	public final static String AFFILIATEINSTITUTIONS_NAME = "AffiliateInstitutions_name";
	public final static String ORCIDPERSONREFERENCE = "OrcidPersonReference";
	public final static String ORCIDPERSONREFERENCE_IDENTIFIER = "OrcidPersonReference_Identifier";
	
	//static methods
	/**
	 * Shorthand for db.query(Person.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Person> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Person.class);
	}
	
	/**
	 * Shorthand for db.find(Person.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Person> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Person.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Person findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Person> q = db.query(Person.class);
		q.eq(Person.ID, id);
		java.util.List<Person> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Person findByName(org.molgenis.framework.db.Database db, String name) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Person> q = db.query(Person.class);
		q.eq(Person.NAME, name);
		java.util.List<Person> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Person findByFirstNameMidInitialsLastName(org.molgenis.framework.db.Database db, String firstName, String midInitials, String lastName) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Person> q = db.query(Person.class);
		q.eq(Person.FIRSTNAME, firstName);q.eq(Person.MIDINITIALS, midInitials);q.eq(Person.LASTNAME, lastName);
		java.util.List<Person> result = q.find();
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


	//Name[type=string]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="Name", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="name")
	
				

	@javax.validation.constraints.NotNull
	private String name =  null;


	//An academic title, e.g. Prof.dr, PhD[type=string]
	@javax.persistence.Column(name="Title")
	@javax.xml.bind.annotation.XmlElement(name="title")
	
				

	private String title =  null;


	//First Name[type=string]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="FirstName")
	@javax.xml.bind.annotation.XmlElement(name="firstName")
	
				

	private String firstName =  null;


	//Mid Initials[type=string]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="MidInitials")
	@javax.xml.bind.annotation.XmlElement(name="midInitials")
	
				

	private String midInitials =  null;


	//Last Name[type=string]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="LastName")
	@javax.xml.bind.annotation.XmlElement(name="lastName")
	
				

	private String lastName =  null;


	//Email[type=email]
	@javax.persistence.Column(name="Email")
	@javax.xml.bind.annotation.XmlElement(name="email")
	
				

	private String email =  null;


	//The telephone number of the Contact including the suitable area codes.[type=string]
	@javax.persistence.Column(name="Phone")
	@javax.xml.bind.annotation.XmlElement(name="phone")
	
				

	private String phone =  null;


	//Affliations[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="PrimaryAffilation")   	
	
				

	private org.molgenis.organization.Institute primaryAffilation = null;
	@javax.persistence.Transient
	private Integer primaryAffilation_id = null;	
	@javax.persistence.Transient
	private String primaryAffilation_name = null;						


	//Affliated Institutes[type=mref]
    @javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="AffiliateInstitutions", insertable=true, updatable=true, nullable=true)
	@javax.persistence.JoinTable(name="Person_AffiliateInstitutions", 
			joinColumns=@javax.persistence.JoinColumn(name="Person"), inverseJoinColumns=@javax.persistence.JoinColumn(name="AffiliateInstitutions"))
	
				

	private java.util.List<org.molgenis.organization.Institute> affiliateInstitutions = new java.util.ArrayList<org.molgenis.organization.Institute>();
	@javax.persistence.Transient
	private java.util.List<Integer> affiliateInstitutions_id = new java.util.ArrayList<Integer>();		
	@javax.persistence.Transient
	private java.util.List<String> affiliateInstitutions_name = new java.util.ArrayList<String>();


	//OrcidPersonReference[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="OrcidPersonReference")   	
	
				

	private org.molgenis.observ.target.OntologyTerm orcidPersonReference = null;
	@javax.persistence.Transient
	private Integer orcidPersonReference_id = null;	
	@javax.persistence.Transient
	private String orcidPersonReference_Identifier = null;						

	//constructors
	public Person()
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
		
		this.name = name;
	}

	

	/**
	 * Get the An academic title, e.g. Prof.dr, PhD.
	 * @return title.
	 */
	public String getTitle()
	{
		return this.title;
	}
	
	@Deprecated
	public String getTitle(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the An academic title, e.g. Prof.dr, PhD.
	 * @param title
	 */
	public void setTitle( String title)
	{
		
		this.title = title;
	}

	

	/**
	 * Get the First Name.
	 * @return firstName.
	 */
	public String getFirstName()
	{
		return this.firstName;
	}
	
	@Deprecated
	public String getFirstName(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the First Name.
	 * @param firstName
	 */
	public void setFirstName( String firstName)
	{
		
		this.firstName = firstName;
	}

	

	/**
	 * Get the Mid Initials.
	 * @return midInitials.
	 */
	public String getMidInitials()
	{
		return this.midInitials;
	}
	
	@Deprecated
	public String getMidInitials(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Mid Initials.
	 * @param midInitials
	 */
	public void setMidInitials( String midInitials)
	{
		
		this.midInitials = midInitials;
	}

	

	/**
	 * Get the Last Name.
	 * @return lastName.
	 */
	public String getLastName()
	{
		return this.lastName;
	}
	
	@Deprecated
	public String getLastName(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Last Name.
	 * @param lastName
	 */
	public void setLastName( String lastName)
	{
		
		this.lastName = lastName;
	}

	

	/**
	 * Get the Email.
	 * @return email.
	 */
	public String getEmail()
	{
		return this.email;
	}
	
	@Deprecated
	public String getEmail(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Email.
	 * @param email
	 */
	public void setEmail( String email)
	{
		
		this.email = email;
	}

	

	/**
	 * Get the The telephone number of the Contact including the suitable area codes..
	 * @return phone.
	 */
	public String getPhone()
	{
		return this.phone;
	}
	
	@Deprecated
	public String getPhone(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the The telephone number of the Contact including the suitable area codes..
	 * @param phone
	 */
	public void setPhone( String phone)
	{
		
		this.phone = phone;
	}

	

	/**
	 * Get the Affliations.
	 * @return primaryAffilation.
	 */
	public org.molgenis.organization.Institute getPrimaryAffilation()
	{
		return this.primaryAffilation;
	}
	
	@Deprecated
	public org.molgenis.organization.Institute getPrimaryAffilation(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Affliations.
	 * @param primaryAffilation
	 */
	public void setPrimaryAffilation( org.molgenis.organization.Institute primaryAffilation)
	{
		
		this.primaryAffilation = primaryAffilation;
	}

	
	
	/**
	 * Set foreign key for field primaryAffilation.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setPrimaryAffilation_Id(Integer primaryAffilation_id)
	{
		this.primaryAffilation_id = primaryAffilation_id;
	}	

	public void setPrimaryAffilation(Integer primaryAffilation_id)
	{
		this.primaryAffilation_id = primaryAffilation_id;
	}
	
	public Integer getPrimaryAffilation_Id()
	{
		
		if(primaryAffilation != null) 
		{
			return primaryAffilation.getId();
		}
		else
		{
			return primaryAffilation_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference PrimaryAffilation to Institute.Id.
	 */
	public String getPrimaryAffilation_Name()
	{		
		//FIXME should we auto-load based on getPrimaryAffilation()?	
		if(primaryAffilation != null) {
			return primaryAffilation.getName();
		} else {
			return primaryAffilation_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference PrimaryAffilation to <a href="Institute.html#Id">Institute.Id</a>.
	 * Implies setPrimaryAffilation(null) until save
	 */
	public void setPrimaryAffilation_Name(String primaryAffilation_name)
	{
		this.primaryAffilation_name = primaryAffilation_name;
	}		
	 
	

	/**
	 * Get the Affliated Institutes.
	 * @return affiliateInstitutions.
	 */
	public java.util.List<org.molgenis.organization.Institute> getAffiliateInstitutions()
	{
		return this.affiliateInstitutions;
	}
	
	@Deprecated
	public java.util.List<org.molgenis.organization.Institute> getAffiliateInstitutions(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Affliated Institutes.
	 * @param affiliateInstitutions
	 */
	public void setAffiliateInstitutions( java.util.List<org.molgenis.organization.Institute> affiliateInstitutions)
	{
		
		this.affiliateInstitutions = affiliateInstitutions;
	}

	
	public void setAffiliateInstitutions_Id(Integer ... affiliateInstitutions)
	{
		this.setAffiliateInstitutions_Id(java.util.Arrays.asList(affiliateInstitutions));
	}	
	
	public void setAffiliateInstitutions(org.molgenis.organization.Institute ... affiliateInstitutions)
	{
		this.setAffiliateInstitutions(java.util.Arrays.asList(affiliateInstitutions));
	}	
	
	/**
	 * Set foreign key for field affiliateInstitutions.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setAffiliateInstitutions_Id(java.util.List<Integer> affiliateInstitutions_id)
	{
		this.affiliateInstitutions_id = affiliateInstitutions_id;
	}	
	
	public java.util.List<Integer> getAffiliateInstitutions_Id()
	{
		return affiliateInstitutions_id;
	}	
	
	/**
	 * Get a pretty label for cross reference AffiliateInstitutions to <a href="Institute.html#Id">Institute.Id</a>.
	 */
	public java.util.List<String> getAffiliateInstitutions_Name()
	{
		return affiliateInstitutions_name;
	}
	
	/**
	 * Update the foreign key AffiliateInstitutions
	 * This sets affiliateInstitutions to null until next database transaction.
	 */
	public void setAffiliateInstitutions_Name(java.util.List<String> affiliateInstitutions_name)
	{
		this.affiliateInstitutions_name = affiliateInstitutions_name;
	}		
	

	/**
	 * Get the OrcidPersonReference.
	 * @return orcidPersonReference.
	 */
	public org.molgenis.observ.target.OntologyTerm getOrcidPersonReference()
	{
		return this.orcidPersonReference;
	}
	
	@Deprecated
	public org.molgenis.observ.target.OntologyTerm getOrcidPersonReference(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the OrcidPersonReference.
	 * @param orcidPersonReference
	 */
	public void setOrcidPersonReference( org.molgenis.observ.target.OntologyTerm orcidPersonReference)
	{
		
		this.orcidPersonReference = orcidPersonReference;
	}

	
	
	/**
	 * Set foreign key for field orcidPersonReference.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setOrcidPersonReference_Id(Integer orcidPersonReference_id)
	{
		this.orcidPersonReference_id = orcidPersonReference_id;
	}	

	public void setOrcidPersonReference(Integer orcidPersonReference_id)
	{
		this.orcidPersonReference_id = orcidPersonReference_id;
	}
	
	public Integer getOrcidPersonReference_Id()
	{
		
		if(orcidPersonReference != null) 
		{
			return orcidPersonReference.getId();
		}
		else
		{
			return orcidPersonReference_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference OrcidPersonReference to OntologyTerm.Id.
	 */
	public String getOrcidPersonReference_Identifier()
	{		
		//FIXME should we auto-load based on getOrcidPersonReference()?	
		if(orcidPersonReference != null) {
			return orcidPersonReference.getIdentifier();
		} else {
			return orcidPersonReference_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference OrcidPersonReference to <a href="OntologyTerm.html#Id">OntologyTerm.Id</a>.
	 * Implies setOrcidPersonReference(null) until save
	 */
	public void setOrcidPersonReference_Identifier(String orcidPersonReference_Identifier)
	{
		this.orcidPersonReference_Identifier = orcidPersonReference_Identifier;
	}		
	 
	


	/**
	 * Generic getter. Get the property by using the name.
	 */
	public Object get(String name)
	{
		name = name.toLowerCase();
		if (name.toLowerCase().equals("id"))
			return getId();
		if (name.toLowerCase().equals("name"))
			return getName();
		if (name.toLowerCase().equals("title"))
			return getTitle();
		if (name.toLowerCase().equals("firstname"))
			return getFirstName();
		if (name.toLowerCase().equals("midinitials"))
			return getMidInitials();
		if (name.toLowerCase().equals("lastname"))
			return getLastName();
		if (name.toLowerCase().equals("email"))
			return getEmail();
		if (name.toLowerCase().equals("phone"))
			return getPhone();
		if (name.toLowerCase().equals("primaryaffilation"))
			return getPrimaryAffilation();
		if(name.toLowerCase().equals("primaryaffilation_id"))
			return getPrimaryAffilation_Id();
		if(name.toLowerCase().equals("primaryaffilation_name"))
			return getPrimaryAffilation_Name();
		if (name.toLowerCase().equals("affiliateinstitutions"))
			return getAffiliateInstitutions();
		if(name.toLowerCase().equals("affiliateinstitutions_id"))
			return getAffiliateInstitutions_Id();
		if(name.toLowerCase().equals("affiliateinstitutions_name"))
			return getAffiliateInstitutions_Name();
		if (name.toLowerCase().equals("orcidpersonreference"))
			return getOrcidPersonReference();
		if(name.toLowerCase().equals("orcidpersonreference_id"))
			return getOrcidPersonReference_Id();
		if(name.toLowerCase().equals("orcidpersonreference_identifier"))
			return getOrcidPersonReference_Identifier();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getName() == null) throw new org.molgenis.framework.db.DatabaseException("required field name is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.util.Tuple tuple, boolean strict )  throws Exception
	{
		//optimization :-(
		if(tuple instanceof org.molgenis.util.ResultSetTuple)
		{
				//set Id
			this.setId(tuple.getInt("id"));
			//set Name
			this.setName(tuple.getString("Name"));
			//set Title
			this.setTitle(tuple.getString("Title"));
			//set FirstName
			this.setFirstName(tuple.getString("FirstName"));
			//set MidInitials
			this.setMidInitials(tuple.getString("MidInitials"));
			//set LastName
			this.setLastName(tuple.getString("LastName"));
			//set Email
			this.setEmail(tuple.getString("Email"));
			//set Phone
			this.setPhone(tuple.getString("Phone"));
			//set PrimaryAffilation
			this.setPrimaryAffilation(tuple.getInt("PrimaryAffilation"));
			//set label name for xref field PrimaryAffilation
			this.setPrimaryAffilation_Name(tuple.getString("PrimaryAffilation_name"));	
			//mrefs can not be directly retrieved
			//set AffiliateInstitutions			
			//set OrcidPersonReference
			this.setOrcidPersonReference(tuple.getInt("OrcidPersonReference"));
			//set label Identifier for xref field OrcidPersonReference
			this.setOrcidPersonReference_Identifier(tuple.getString("OrcidPersonReference_Identifier"));	
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("Person_id") != null) this.setId(tuple.getInt("Person_id"));
			//set Name
			if( strict || tuple.getString("Name") != null) this.setName(tuple.getString("Name"));
			if( tuple.getString("Person_Name") != null) this.setName(tuple.getString("Person_Name"));
			//set Title
			if( strict || tuple.getString("Title") != null) this.setTitle(tuple.getString("Title"));
			if( tuple.getString("Person_Title") != null) this.setTitle(tuple.getString("Person_Title"));
			//set FirstName
			if( strict || tuple.getString("FirstName") != null) this.setFirstName(tuple.getString("FirstName"));
			if( tuple.getString("Person_FirstName") != null) this.setFirstName(tuple.getString("Person_FirstName"));
			//set MidInitials
			if( strict || tuple.getString("MidInitials") != null) this.setMidInitials(tuple.getString("MidInitials"));
			if( tuple.getString("Person_MidInitials") != null) this.setMidInitials(tuple.getString("Person_MidInitials"));
			//set LastName
			if( strict || tuple.getString("LastName") != null) this.setLastName(tuple.getString("LastName"));
			if( tuple.getString("Person_LastName") != null) this.setLastName(tuple.getString("Person_LastName"));
			//set Email
			if( strict || tuple.getString("Email") != null) this.setEmail(tuple.getString("Email"));
			if( tuple.getString("Person_Email") != null) this.setEmail(tuple.getString("Person_Email"));
			//set Phone
			if( strict || tuple.getString("Phone") != null) this.setPhone(tuple.getString("Phone"));
			if( tuple.getString("Person_Phone") != null) this.setPhone(tuple.getString("Person_Phone"));
			//set PrimaryAffilation
			if( strict || tuple.getInt("PrimaryAffilation_id") != null) this.setPrimaryAffilation(tuple.getInt("PrimaryAffilation_id"));
			if( tuple.getInt("Person_PrimaryAffilation_id") != null) this.setPrimaryAffilation(tuple.getInt("Person_PrimaryAffilation_id"));
			//alias of xref
			if( tuple.getObject("PrimaryAffilation") != null) this.setPrimaryAffilation(tuple.getInt("PrimaryAffilation"));
			if( tuple.getObject("Person_PrimaryAffilation") != null) this.setPrimaryAffilation(tuple.getInt("Person_PrimaryAffilation"));
			//set label for field PrimaryAffilation
			if( strict || tuple.getObject("PrimaryAffilation_name") != null) this.setPrimaryAffilation_Name(tuple.getString("PrimaryAffilation_name"));			
			if( tuple.getObject("Person_PrimaryAffilation_name") != null ) this.setPrimaryAffilation_Name(tuple.getString("Person_PrimaryAffilation_name"));		
			//set AffiliateInstitutions
			if( tuple.getObject("AffiliateInstitutions")!= null || tuple.getObject("Person_AffiliateInstitutions")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("AffiliateInstitutions");
				if(tuple.getObject("Person_AffiliateInstitutions")!= null) mrefs = tuple.getList("Person_AffiliateInstitutions");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setAffiliateInstitutions_Id( values );
			}
			//set labels name for mref field AffiliateInstitutions	
			if( tuple.getObject("AffiliateInstitutions_name")!= null || tuple.getObject("Person_AffiliateInstitutions_name")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("AffiliateInstitutions_name");
				if(tuple.getObject("Person_AffiliateInstitutions_name")!= null) mrefs = tuple.getList("Person_AffiliateInstitutions_name");
				
				if(mrefs != null) 
					for(Object ref: mrefs)
					{
						String[] refs = ref.toString().split("\\|");
						for(String r : refs) {
							values.add(r);	
						}						
					}							
				this.setAffiliateInstitutions_Name( values );			
			}	
			//set OrcidPersonReference
			if( strict || tuple.getInt("OrcidPersonReference_id") != null) this.setOrcidPersonReference(tuple.getInt("OrcidPersonReference_id"));
			if( tuple.getInt("Person_OrcidPersonReference_id") != null) this.setOrcidPersonReference(tuple.getInt("Person_OrcidPersonReference_id"));
			//alias of xref
			if( tuple.getObject("OrcidPersonReference") != null) this.setOrcidPersonReference(tuple.getInt("OrcidPersonReference"));
			if( tuple.getObject("Person_OrcidPersonReference") != null) this.setOrcidPersonReference(tuple.getInt("Person_OrcidPersonReference"));
			//set label for field OrcidPersonReference
			if( strict || tuple.getObject("OrcidPersonReference_Identifier") != null) this.setOrcidPersonReference_Identifier(tuple.getString("OrcidPersonReference_Identifier"));			
			if( tuple.getObject("Person_OrcidPersonReference_Identifier") != null ) this.setOrcidPersonReference_Identifier(tuple.getString("Person_OrcidPersonReference_Identifier"));		
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
		String result = "Person(";
		result+= "id='" + getId()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= "title='" + getTitle()+"' ";	
		result+= "firstName='" + getFirstName()+"' ";	
		result+= "midInitials='" + getMidInitials()+"' ";	
		result+= "lastName='" + getLastName()+"' ";	
		result+= "email='" + getEmail()+"' ";	
		result+= "phone='" + getPhone()+"' ";	
		result+= " primaryAffilation_id='" + getPrimaryAffilation_Id()+"' ";	
		result+= " primaryAffilation_name='" + getPrimaryAffilation_Name()+"' ";
		result+= " affiliateInstitutions_id='" + getAffiliateInstitutions_Id()+"' ";	
		result+= " affiliateInstitutions_name='" + getAffiliateInstitutions_Name()+"' ";
		result+= " orcidPersonReference_id='" + getOrcidPersonReference_Id()+"' ";	
		result+= " orcidPersonReference_identifier='" + getOrcidPersonReference_Identifier()+"' ";
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Person.
	 */
	public java.util.Vector<String> getFields(boolean skipAutoIds)
	{
		java.util.Vector<String> fields = new java.util.Vector<String>();
		if(!skipAutoIds)
		{
			fields.add("id");
		}
		{
			fields.add("name");
		}
		{
			fields.add("title");
		}
		{
			fields.add("firstName");
		}
		{
			fields.add("midInitials");
		}
		{
			fields.add("lastName");
		}
		{
			fields.add("email");
		}
		{
			fields.add("phone");
		}
		{
			fields.add("primaryAffilation_id");
		}
		fields.add("primaryAffilation_name");
		{
			fields.add("affiliateInstitutions_id");
		}
		fields.add("affiliateInstitutions_name");
		{
			fields.add("orcidPersonReference_id");
		}
		fields.add("orcidPersonReference_identifier");
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
		result.add("Name");
		return result;
	}

	@Deprecated
	public String getFields(String sep)
	{
		return (""
		+ "id" +sep
		+ "name" +sep
		+ "title" +sep
		+ "firstName" +sep
		+ "midInitials" +sep
		+ "lastName" +sep
		+ "email" +sep
		+ "phone" +sep
		+ "primaryAffilation" +sep
		+ "affiliateInstitutions" +sep
		+ "orcidPersonReference" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("primaryAffilation")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("affiliateInstitutions")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("orcidPersonReference")) {
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
		Person rhs = (Person) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
		//name
				.append(name, rhs.getName())
		//firstName
				.append(firstName, rhs.getFirstName())
		//midInitials
				.append(midInitials, rhs.getMidInitials())
		//lastName
				.append(lastName, rhs.getLastName())
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
				.append(name)
				.append(firstName)
				.append(midInitials)
				.append(lastName)
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
			Object valueO = getTitle();
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
			Object valueO = getFirstName();
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
			Object valueO = getMidInitials();
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
			Object valueO = getLastName();
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
			Object valueO = getEmail();
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
			Object valueO = getPhone();
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
			Object valueO = getPrimaryAffilation();
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
			Object valueO = getAffiliateInstitutions();
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
			Object valueO = getOrcidPersonReference();
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
	public Person create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Person e = new Person();
		e.set(tuple);
		return e;
	}
	
//3
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="contact"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.organization.Study> contactStudyCollection = new java.util.ArrayList<org.molgenis.organization.Study>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.organization.Study> getContactStudyCollection()
	{
            return contactStudyCollection;
	}

    public void setContactStudyCollection(java.util.Collection<org.molgenis.organization.Study> collection)
    {
        for (org.molgenis.organization.Study study : collection) {
            study.setContact(this);
        }
        contactStudyCollection = collection;
    }	
//3
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="researcher"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.organization.Contribution> researcherContributionCollection = new java.util.ArrayList<org.molgenis.organization.Contribution>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.organization.Contribution> getResearcherContributionCollection()
	{
            return researcherContributionCollection;
	}

    public void setResearcherContributionCollection(java.util.Collection<org.molgenis.organization.Contribution> collection)
    {
        for (org.molgenis.organization.Contribution contribution : collection) {
            contribution.setResearcher(this);
        }
        researcherContributionCollection = collection;
    }	

	
}

