
/* File:        org.molgenis/model/Investigation.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.gwascentral;

/**
 * Investigation: .
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "Investigation", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "Identifier" } ) }
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.gwascentral.db.InvestigationEntityListener.class})
public class Investigation extends org.molgenis.util.AbstractEntity implements org.molgenis.core.Identifiable
{
	// fieldname constants
	public final static String ID = "id";
	public final static String IDENTIFIER = "Identifier";
	public final static String NAME = "Name";
	public final static String TITLE = "Title";
	public final static String SHORTNAME = "ShortName";
	public final static String VERSION = "Version";
	public final static String BACKGROUND = "Background";
	
	//static methods
	/**
	 * Shorthand for db.query(Investigation.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Investigation> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Investigation.class);
	}
	
	/**
	 * Shorthand for db.find(Investigation.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Investigation> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Investigation.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Investigation findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Investigation> q = db.query(Investigation.class);
		q.eq(Investigation.ID, id);
		java.util.List<Investigation> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Investigation findByIdentifier(org.molgenis.framework.db.Database db, String identifier) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Investigation> q = db.query(Investigation.class);
		q.eq(Investigation.IDENTIFIER, identifier);
		java.util.List<Investigation> result = q.find();
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


	//Nice title of Investigation[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="Title", length=16777216)
	
				

	private String title =  null;


	//Shorthand name for layout[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="ShortName", length=16777216)
	
				

	private String shortName =  null;


	//Accession version[type=string]
	@javax.persistence.Column(name="Version")
	@javax.xml.bind.annotation.XmlElement(name="version")
	
				

	private String version =  null;


	//Short piece of information describing why the study is taking place, e.g. risk factors for a population[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="Background", length=16777216)
	
				

	private String background =  null;

	//constructors
	public Investigation()
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
	 * Get the Nice title of Investigation.
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
	 * Set the Nice title of Investigation.
	 * @param title
	 */
	public void setTitle( String title)
	{
		
		this.title = title;
	}

	

	/**
	 * Get the Shorthand name for layout.
	 * @return shortName.
	 */
	public String getShortName()
	{
		return this.shortName;
	}
	
	@Deprecated
	public String getShortName(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Shorthand name for layout.
	 * @param shortName
	 */
	public void setShortName( String shortName)
	{
		
		this.shortName = shortName;
	}

	

	/**
	 * Get the Accession version.
	 * @return version.
	 */
	public String getVersion()
	{
		return this.version;
	}
	
	@Deprecated
	public String getVersion(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Accession version.
	 * @param version
	 */
	public void setVersion( String version)
	{
		
		this.version = version;
	}

	

	/**
	 * Get the Short piece of information describing why the study is taking place, e.g. risk factors for a population.
	 * @return background.
	 */
	public String getBackground()
	{
		return this.background;
	}
	
	@Deprecated
	public String getBackground(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Short piece of information describing why the study is taking place, e.g. risk factors for a population.
	 * @param background
	 */
	public void setBackground( String background)
	{
		
		this.background = background;
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
		if (name.toLowerCase().equals("title"))
			return getTitle();
		if (name.toLowerCase().equals("shortname"))
			return getShortName();
		if (name.toLowerCase().equals("version"))
			return getVersion();
		if (name.toLowerCase().equals("background"))
			return getBackground();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getIdentifier() == null) throw new org.molgenis.framework.db.DatabaseException("required field identifier is null");
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
			//set Identifier
			this.setIdentifier(tuple.getString("Identifier"));
			//set Name
			this.setName(tuple.getString("Name"));
			//set Title
			this.setTitle(tuple.getString("Title"));
			//set ShortName
			this.setShortName(tuple.getString("ShortName"));
			//set Version
			this.setVersion(tuple.getString("Version"));
			//set Background
			this.setBackground(tuple.getString("Background"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("Investigation_id") != null) this.setId(tuple.getInt("Investigation_id"));
			//set Identifier
			if( strict || tuple.getString("Identifier") != null) this.setIdentifier(tuple.getString("Identifier"));
			if( tuple.getString("Investigation_Identifier") != null) this.setIdentifier(tuple.getString("Investigation_Identifier"));
			//set Name
			if( strict || tuple.getString("Name") != null) this.setName(tuple.getString("Name"));
			if( tuple.getString("Investigation_Name") != null) this.setName(tuple.getString("Investigation_Name"));
			//set Title
			if( strict || tuple.getString("Title") != null) this.setTitle(tuple.getString("Title"));
			if( tuple.getString("Investigation_Title") != null) this.setTitle(tuple.getString("Investigation_Title"));
			//set ShortName
			if( strict || tuple.getString("ShortName") != null) this.setShortName(tuple.getString("ShortName"));
			if( tuple.getString("Investigation_ShortName") != null) this.setShortName(tuple.getString("Investigation_ShortName"));
			//set Version
			if( strict || tuple.getString("Version") != null) this.setVersion(tuple.getString("Version"));
			if( tuple.getString("Investigation_Version") != null) this.setVersion(tuple.getString("Investigation_Version"));
			//set Background
			if( strict || tuple.getString("Background") != null) this.setBackground(tuple.getString("Background"));
			if( tuple.getString("Investigation_Background") != null) this.setBackground(tuple.getString("Investigation_Background"));
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
		String result = "Investigation(";
		result+= "id='" + getId()+"' ";	
		result+= "identifier='" + getIdentifier()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= "title='" + getTitle()+"' ";	
		result+= "shortName='" + getShortName()+"' ";	
		result+= "version='" + getVersion()+"' ";	
		result+= "background='" + getBackground()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Investigation.
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
			fields.add("title");
		}
		{
			fields.add("shortName");
		}
		{
			fields.add("version");
		}
		{
			fields.add("background");
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
		+ "title" +sep
		+ "shortName" +sep
		+ "version" +sep
		+ "background" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        
        return null;
    }	

	@Override
	public boolean equals(Object obj) {
   		if (obj == null) { return false; }
   		if (obj == this) { return true; }
   		if (obj.getClass() != getClass()) {
     		return false;
   		}
		Investigation rhs = (Investigation) obj;
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
			Object valueO = getShortName();
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
			Object valueO = getVersion();
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
			Object valueO = getBackground();
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
	public Investigation create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Investigation e = new Investigation();
		e.set(tuple);
		return e;
	}
	
//1
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="partOfInvestigation"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.organization.Study> partOfInvestigationStudyCollection = new java.util.ArrayList<org.molgenis.organization.Study>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.organization.Study> getPartOfInvestigationStudyCollection()
	{
            return partOfInvestigationStudyCollection;
	}

    public void setPartOfInvestigationStudyCollection(java.util.Collection<org.molgenis.organization.Study> collection)
    {
        for (org.molgenis.organization.Study study : collection) {
            study.setPartOfInvestigation(this);
        }
        partOfInvestigationStudyCollection = collection;
    }	

	
}

