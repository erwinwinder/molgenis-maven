
/* File:        org.molgenis.omx/model/Individual.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.observ.target;

/**
 * Individual:  The Individuals class defines the subjects that are
				used
				as observation target. The Individual class maps to
				XGAP:Individual
				and PaGE:Individual. Groups of individuals can be
				defined via
				Panel.
			
.
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "Individual"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.observ.target.db.IndividualEntityListener.class})
public class Individual extends org.molgenis.observ.ObservationTarget 
{
	// fieldname constants
	public final static String MOTHER = "Mother";
	public final static String MOTHER_IDENTIFIER = "Mother_Identifier";
	public final static String FATHER = "Father";
	public final static String FATHER_IDENTIFIER = "Father_Identifier";
	public final static String ID = "id";
	
	//static methods
	/**
	 * Shorthand for db.query(Individual.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Individual> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Individual.class);
	}
	
	/**
	 * Shorthand for db.find(Individual.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Individual> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Individual.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Individual findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Individual> q = db.query(Individual.class);
		q.eq(Individual.ID, id);
		java.util.List<Individual> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Individual findByIdentifier(org.molgenis.framework.db.Database db, String identifier) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Individual> q = db.query(Individual.class);
		q.eq(Individual.IDENTIFIER, identifier);
		java.util.List<Individual> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//Refers to the mother of the individual.[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Mother")   	
	
				

	private org.molgenis.observ.target.Individual mother = null;
	@javax.persistence.Transient
	private Integer mother_id = null;	
	@javax.persistence.Transient
	private String mother_Identifier = null;						


	//Refers to the father of the individual.[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Father")   	
	
				

	private org.molgenis.observ.target.Individual father = null;
	@javax.persistence.Transient
	private Integer father_id = null;	
	@javax.persistence.Transient
	private String father_Identifier = null;						


	//automatically generated internal id, only for internal use.[type=int]
	

	//constructors
	public Individual()
	{
		//set the type for a new instance
		set__Type(this.getClass().getSimpleName());
	
	}
	
	//getters and setters
	/**
	 * Get the Refers to the mother of the individual..
	 * @return mother.
	 */
	public org.molgenis.observ.target.Individual getMother()
	{
		return this.mother;
	}
	
	@Deprecated
	public org.molgenis.observ.target.Individual getMother(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Refers to the mother of the individual..
	 * @param mother
	 */
	public void setMother( org.molgenis.observ.target.Individual mother)
	{
		
		this.mother = mother;
	}

	
	
	/**
	 * Set foreign key for field mother.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setMother_Id(Integer mother_id)
	{
		this.mother_id = mother_id;
	}	

	public void setMother(Integer mother_id)
	{
		this.mother_id = mother_id;
	}
	
	public Integer getMother_Id()
	{
		
		if(mother != null) 
		{
			return mother.getId();
		}
		else
		{
			return mother_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference Mother to Individual.Id.
	 */
	public String getMother_Identifier()
	{		
		//FIXME should we auto-load based on getMother()?	
		if(mother != null) {
			return mother.getIdentifier();
		} else {
			return mother_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Mother to <a href="Individual.html#Id">Individual.Id</a>.
	 * Implies setMother(null) until save
	 */
	public void setMother_Identifier(String mother_Identifier)
	{
		this.mother_Identifier = mother_Identifier;
	}		
	 
	

	/**
	 * Get the Refers to the father of the individual..
	 * @return father.
	 */
	public org.molgenis.observ.target.Individual getFather()
	{
		return this.father;
	}
	
	@Deprecated
	public org.molgenis.observ.target.Individual getFather(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Refers to the father of the individual..
	 * @param father
	 */
	public void setFather( org.molgenis.observ.target.Individual father)
	{
		
		this.father = father;
	}

	
	
	/**
	 * Set foreign key for field father.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setFather_Id(Integer father_id)
	{
		this.father_id = father_id;
	}	

	public void setFather(Integer father_id)
	{
		this.father_id = father_id;
	}
	
	public Integer getFather_Id()
	{
		
		if(father != null) 
		{
			return father.getId();
		}
		else
		{
			return father_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference Father to Individual.Id.
	 */
	public String getFather_Identifier()
	{		
		//FIXME should we auto-load based on getFather()?	
		if(father != null) {
			return father.getIdentifier();
		} else {
			return father_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Father to <a href="Individual.html#Id">Individual.Id</a>.
	 * Implies setFather(null) until save
	 */
	public void setFather_Identifier(String father_Identifier)
	{
		this.father_Identifier = father_Identifier;
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
		if (name.toLowerCase().equals("mother"))
			return getMother();
		if(name.toLowerCase().equals("mother_id"))
			return getMother_Id();
		if(name.toLowerCase().equals("mother_identifier"))
			return getMother_Identifier();
		if (name.toLowerCase().equals("father"))
			return getFather();
		if(name.toLowerCase().equals("father_id"))
			return getFather_Id();
		if(name.toLowerCase().equals("father_identifier"))
			return getFather_Identifier();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getIdentifier() == null) throw new org.molgenis.framework.db.DatabaseException("required field identifier is null");
		if(this.getName() == null) throw new org.molgenis.framework.db.DatabaseException("required field name is null");
		if(this.get__Type() == null) throw new org.molgenis.framework.db.DatabaseException("required field __Type is null");
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
			//set Mother
			this.setMother(tuple.getInt("Mother"));
			//set label Identifier for xref field Mother
			this.setMother_Identifier(tuple.getString("Mother_Identifier"));	
			//set Father
			this.setFather(tuple.getInt("Father"));
			//set label Identifier for xref field Father
			this.setFather_Identifier(tuple.getString("Father_Identifier"));	
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("Individual_id") != null) this.setId(tuple.getInt("Individual_id"));
			//set Identifier
			if( strict || tuple.getString("Identifier") != null) this.setIdentifier(tuple.getString("Identifier"));
			if( tuple.getString("Individual_Identifier") != null) this.setIdentifier(tuple.getString("Individual_Identifier"));
			//set Name
			if( strict || tuple.getString("Name") != null) this.setName(tuple.getString("Name"));
			if( tuple.getString("Individual_Name") != null) this.setName(tuple.getString("Individual_Name"));
			//set __Type
			if( strict || tuple.getString("__Type") != null) this.set__Type(tuple.getString("__Type"));
			if( tuple.getString("Individual___Type") != null) this.set__Type(tuple.getString("Individual___Type"));
			//set Description
			if( strict || tuple.getString("description") != null) this.setDescription(tuple.getString("description"));
			if( tuple.getString("Individual_description") != null) this.setDescription(tuple.getString("Individual_description"));
			//set Mother
			if( strict || tuple.getInt("Mother_id") != null) this.setMother(tuple.getInt("Mother_id"));
			if( tuple.getInt("Individual_Mother_id") != null) this.setMother(tuple.getInt("Individual_Mother_id"));
			//alias of xref
			if( tuple.getObject("Mother") != null) this.setMother(tuple.getInt("Mother"));
			if( tuple.getObject("Individual_Mother") != null) this.setMother(tuple.getInt("Individual_Mother"));
			//set label for field Mother
			if( strict || tuple.getObject("Mother_Identifier") != null) this.setMother_Identifier(tuple.getString("Mother_Identifier"));			
			if( tuple.getObject("Individual_Mother_Identifier") != null ) this.setMother_Identifier(tuple.getString("Individual_Mother_Identifier"));		
			//set Father
			if( strict || tuple.getInt("Father_id") != null) this.setFather(tuple.getInt("Father_id"));
			if( tuple.getInt("Individual_Father_id") != null) this.setFather(tuple.getInt("Individual_Father_id"));
			//alias of xref
			if( tuple.getObject("Father") != null) this.setFather(tuple.getInt("Father"));
			if( tuple.getObject("Individual_Father") != null) this.setFather(tuple.getInt("Individual_Father"));
			//set label for field Father
			if( strict || tuple.getObject("Father_Identifier") != null) this.setFather_Identifier(tuple.getString("Father_Identifier"));			
			if( tuple.getObject("Individual_Father_Identifier") != null ) this.setFather_Identifier(tuple.getString("Individual_Father_Identifier"));		
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
		String result = "Individual(";
		result+= "id='" + getId()+"' ";	
		result+= "identifier='" + getIdentifier()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= "__Type='" + get__Type()+"' ";	
		result+= "description='" + getDescription()+"' ";	
		result+= " mother_id='" + getMother_Id()+"' ";	
		result+= " mother_identifier='" + getMother_Identifier()+"' ";
		result+= " father_id='" + getFather_Id()+"' ";	
		result+= " father_identifier='" + getFather_Identifier()+"' ";
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Individual.
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
			fields.add("mother_id");
		}
		fields.add("mother_identifier");
		{
			fields.add("father_id");
		}
		fields.add("father_identifier");
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
		+ "mother" +sep
		+ "father" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("mother")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("father")) {
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
		Individual rhs = (Individual) obj;
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
			Object valueO = getMother();
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
			Object valueO = getFather();
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
	public Individual create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Individual e = new Individual();
		e.set(tuple);
		return e;
	}
	
//4
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="mother"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.observ.target.Individual> motherIndividualCollection = new java.util.ArrayList<org.molgenis.observ.target.Individual>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.observ.target.Individual> getMotherIndividualCollection()
	{
            return motherIndividualCollection;
	}

    public void setMotherIndividualCollection(java.util.Collection<org.molgenis.observ.target.Individual> collection)
    {
        for (org.molgenis.observ.target.Individual individual : collection) {
            individual.setMother(this);
        }
        motherIndividualCollection = collection;
    }	
//4
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="father"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.observ.target.Individual> fatherIndividualCollection = new java.util.ArrayList<org.molgenis.observ.target.Individual>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.observ.target.Individual> getFatherIndividualCollection()
	{
            return fatherIndividualCollection;
	}

    public void setFatherIndividualCollection(java.util.Collection<org.molgenis.observ.target.Individual> collection)
    {
        for (org.molgenis.observ.target.Individual individual : collection) {
            individual.setFather(this);
        }
        fatherIndividualCollection = collection;
    }	
	//4
    @javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="individuals"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.observ.target.Panel> individualsPanelCollection = new java.util.ArrayList<org.molgenis.observ.target.Panel>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.observ.target.Panel> getIndividualsPanelCollection()
	{
        return individualsPanelCollection;
	}

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.observ.target.Panel> getIndividualsPanelCollection(org.molgenis.framework.db.Database db)
	{
        return getIndividualsPanelCollection();
	}

    public void setIndividualsPanelCollection(java.util.Collection<org.molgenis.observ.target.Panel> collection)
    {
    	individualsPanelCollection.addAll(collection);
    }	

	
}

