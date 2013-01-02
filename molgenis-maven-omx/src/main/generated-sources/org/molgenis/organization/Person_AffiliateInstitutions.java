
/* File:        org.molgenis.omx/model/Person_AffiliateInstitutions.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.organization;

/**
 * Person_AffiliateInstitutions: Link table for many-to-many relationship 'Person.AffiliateInstitutions'..
 * @author MOLGENIS generator
 */
@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.organization.db.Person_AffiliateInstitutionsEntityListener.class})
public class Person_AffiliateInstitutions extends org.molgenis.util.AbstractEntity 
{
	// fieldname constants
	public final static String AUTOID = "autoid";
	public final static String AFFILIATEINSTITUTIONS = "AffiliateInstitutions";
	public final static String AFFILIATEINSTITUTIONS_NAME = "AffiliateInstitutions_name";
	public final static String PERSON = "Person";
	public final static String PERSON_NAME = "Person_Name";
	
	//static methods
	/**
	 * Shorthand for db.query(Person_AffiliateInstitutions.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Person_AffiliateInstitutions> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Person_AffiliateInstitutions.class);
	}
	
	/**
	 * Shorthand for db.find(Person_AffiliateInstitutions.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Person_AffiliateInstitutions> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Person_AffiliateInstitutions.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Person_AffiliateInstitutions findByAutoid(org.molgenis.framework.db.Database db, Integer autoid) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Person_AffiliateInstitutions> q = db.query(Person_AffiliateInstitutions.class);
		q.eq(Person_AffiliateInstitutions.AUTOID, autoid);
		java.util.List<Person_AffiliateInstitutions> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Person_AffiliateInstitutions findByAffiliateInstitutionsPerson(org.molgenis.framework.db.Database db, Integer affiliateInstitutions, Integer person) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Person_AffiliateInstitutions> q = db.query(Person_AffiliateInstitutions.class);
		q.eq(Person_AffiliateInstitutions.AFFILIATEINSTITUTIONS, affiliateInstitutions);q.eq(Person_AffiliateInstitutions.PERSON, person);
		java.util.List<Person_AffiliateInstitutions> result = q.find();
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
    @javax.persistence.JoinColumn(name="AffiliateInstitutions", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.organization.Institute affiliateInstitutions = null;
	@javax.persistence.Transient
	private Integer affiliateInstitutions_id = null;	
	@javax.persistence.Transient
	private String affiliateInstitutions_name = null;						


	//[type=xref]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Person", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.organization.Person person = null;
	@javax.persistence.Transient
	private Integer person_id = null;	
	@javax.persistence.Transient
	private String person_Name = null;						

	//constructors
	public Person_AffiliateInstitutions()
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
	 * @return affiliateInstitutions.
	 */
	public org.molgenis.organization.Institute getAffiliateInstitutions()
	{
		return this.affiliateInstitutions;
	}
	
	@Deprecated
	public org.molgenis.organization.Institute getAffiliateInstitutions(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the .
	 * @param affiliateInstitutions
	 */
	public void setAffiliateInstitutions( org.molgenis.organization.Institute affiliateInstitutions)
	{
		
		this.affiliateInstitutions = affiliateInstitutions;
	}

	
	
	/**
	 * Set foreign key for field affiliateInstitutions.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setAffiliateInstitutions_Id(Integer affiliateInstitutions_id)
	{
		this.affiliateInstitutions_id = affiliateInstitutions_id;
	}	

	public void setAffiliateInstitutions(Integer affiliateInstitutions_id)
	{
		this.affiliateInstitutions_id = affiliateInstitutions_id;
	}
	
	public Integer getAffiliateInstitutions_Id()
	{
		
		if(affiliateInstitutions != null) 
		{
			return affiliateInstitutions.getId();
		}
		else
		{
			return affiliateInstitutions_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference AffiliateInstitutions to Institute.Id.
	 */
	public String getAffiliateInstitutions_Name()
	{		
		//FIXME should we auto-load based on getAffiliateInstitutions()?	
		if(affiliateInstitutions != null) {
			return affiliateInstitutions.getName();
		} else {
			return affiliateInstitutions_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference AffiliateInstitutions to <a href="Institute.html#Id">Institute.Id</a>.
	 * Implies setAffiliateInstitutions(null) until save
	 */
	public void setAffiliateInstitutions_Name(String affiliateInstitutions_name)
	{
		this.affiliateInstitutions_name = affiliateInstitutions_name;
	}		
	 
	

	/**
	 * Get the .
	 * @return person.
	 */
	public org.molgenis.organization.Person getPerson()
	{
		return this.person;
	}
	
	@Deprecated
	public org.molgenis.organization.Person getPerson(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the .
	 * @param person
	 */
	public void setPerson( org.molgenis.organization.Person person)
	{
		
		this.person = person;
	}

	
	
	/**
	 * Set foreign key for field person.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setPerson_Id(Integer person_id)
	{
		this.person_id = person_id;
	}	

	public void setPerson(Integer person_id)
	{
		this.person_id = person_id;
	}
	
	public Integer getPerson_Id()
	{
		
		if(person != null) 
		{
			return person.getId();
		}
		else
		{
			return person_id;
		}
	}	
	 
	/**
	 * Get a pretty label Name for cross reference Person to Person.Id.
	 */
	public String getPerson_Name()
	{		
		//FIXME should we auto-load based on getPerson()?	
		if(person != null) {
			return person.getName();
		} else {
			return person_Name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Person to <a href="Person.html#Id">Person.Id</a>.
	 * Implies setPerson(null) until save
	 */
	public void setPerson_Name(String person_Name)
	{
		this.person_Name = person_Name;
	}		
	 
	


	/**
	 * Generic getter. Get the property by using the name.
	 */
	public Object get(String name)
	{
		name = name.toLowerCase();
		if (name.toLowerCase().equals("autoid"))
			return getAutoid();
		if (name.toLowerCase().equals("affiliateinstitutions"))
			return getAffiliateInstitutions();
		if(name.toLowerCase().equals("affiliateinstitutions_id"))
			return getAffiliateInstitutions_Id();
		if(name.toLowerCase().equals("affiliateinstitutions_name"))
			return getAffiliateInstitutions_Name();
		if (name.toLowerCase().equals("person"))
			return getPerson();
		if(name.toLowerCase().equals("person_id"))
			return getPerson_Id();
		if(name.toLowerCase().equals("person_name"))
			return getPerson_Name();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getAutoid() == null) throw new org.molgenis.framework.db.DatabaseException("required field autoid is null");
		if(this.getAffiliateInstitutions() == null) throw new org.molgenis.framework.db.DatabaseException("required field affiliateInstitutions is null");
		if(this.getPerson() == null) throw new org.molgenis.framework.db.DatabaseException("required field person is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.util.Tuple tuple, boolean strict )  throws Exception
	{
		//optimization :-(
		if(tuple instanceof org.molgenis.util.ResultSetTuple)
		{
				//set Autoid
			this.setAutoid(tuple.getInt("autoid"));
			//set AffiliateInstitutions
			this.setAffiliateInstitutions(tuple.getInt("AffiliateInstitutions"));
			//set label name for xref field AffiliateInstitutions
			this.setAffiliateInstitutions_Name(tuple.getString("AffiliateInstitutions_name"));	
			//set Person
			this.setPerson(tuple.getInt("Person"));
			//set label Name for xref field Person
			this.setPerson_Name(tuple.getString("Person_Name"));	
		}
		else if(tuple != null)
		{
			//set Autoid
			if( strict || tuple.getInt("autoid") != null) this.setAutoid(tuple.getInt("autoid"));
			if( tuple.getInt("Person_AffiliateInstitutions_autoid") != null) this.setAutoid(tuple.getInt("Person_AffiliateInstitutions_autoid"));
			//set AffiliateInstitutions
			if( strict || tuple.getInt("AffiliateInstitutions_id") != null) this.setAffiliateInstitutions(tuple.getInt("AffiliateInstitutions_id"));
			if( tuple.getInt("Person_AffiliateInstitutions_AffiliateInstitutions_id") != null) this.setAffiliateInstitutions(tuple.getInt("Person_AffiliateInstitutions_AffiliateInstitutions_id"));
			//alias of xref
			if( tuple.getObject("AffiliateInstitutions") != null) this.setAffiliateInstitutions(tuple.getInt("AffiliateInstitutions"));
			if( tuple.getObject("Person_AffiliateInstitutions_AffiliateInstitutions") != null) this.setAffiliateInstitutions(tuple.getInt("Person_AffiliateInstitutions_AffiliateInstitutions"));
			//set label for field AffiliateInstitutions
			if( strict || tuple.getObject("AffiliateInstitutions_name") != null) this.setAffiliateInstitutions_Name(tuple.getString("AffiliateInstitutions_name"));			
			if( tuple.getObject("Person_AffiliateInstitutions_AffiliateInstitutions_name") != null ) this.setAffiliateInstitutions_Name(tuple.getString("Person_AffiliateInstitutions_AffiliateInstitutions_name"));		
			//set Person
			if( strict || tuple.getInt("Person_id") != null) this.setPerson(tuple.getInt("Person_id"));
			if( tuple.getInt("Person_AffiliateInstitutions_Person_id") != null) this.setPerson(tuple.getInt("Person_AffiliateInstitutions_Person_id"));
			//alias of xref
			if( tuple.getObject("Person") != null) this.setPerson(tuple.getInt("Person"));
			if( tuple.getObject("Person_AffiliateInstitutions_Person") != null) this.setPerson(tuple.getInt("Person_AffiliateInstitutions_Person"));
			//set label for field Person
			if( strict || tuple.getObject("Person_Name") != null) this.setPerson_Name(tuple.getString("Person_Name"));			
			if( tuple.getObject("Person_AffiliateInstitutions_Person_Name") != null ) this.setPerson_Name(tuple.getString("Person_AffiliateInstitutions_Person_Name"));		
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
		String result = "Person_AffiliateInstitutions(";
		result+= "autoid='" + getAutoid()+"' ";	
		result+= " affiliateInstitutions_id='" + getAffiliateInstitutions_Id()+"' ";	
		result+= " affiliateInstitutions_name='" + getAffiliateInstitutions_Name()+"' ";
		result+= " person_id='" + getPerson_Id()+"' ";	
		result+= " person_name='" + getPerson_Name()+"' ";
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Person_AffiliateInstitutions.
	 */
	public java.util.Vector<String> getFields(boolean skipAutoIds)
	{
		java.util.Vector<String> fields = new java.util.Vector<String>();
		if(!skipAutoIds)
		{
			fields.add("autoid");
		}
		{
			fields.add("affiliateInstitutions_id");
		}
		fields.add("affiliateInstitutions_name");
		{
			fields.add("person_id");
		}
		fields.add("person_name");
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
		result.add("AffiliateInstitutions");
		result.add("Person");
		return result;
	}

	@Deprecated
	public String getFields(String sep)
	{
		return (""
		+ "autoid" +sep
		+ "affiliateInstitutions" +sep
		+ "person" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("affiliateInstitutions")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("person")) {
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
		Person_AffiliateInstitutions rhs = (Person_AffiliateInstitutions) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
		//affiliateInstitutions
		//person
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
			Object valueO = getPerson();
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
	public Person_AffiliateInstitutions create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Person_AffiliateInstitutions e = new Person_AffiliateInstitutions();
		e.set(tuple);
		return e;
	}
	

	
}

