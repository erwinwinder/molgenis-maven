
/* File:        org.molgenis/model/MolgenisFile.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.core;

/**
 * MolgenisFile: 
				Helper entity to deal with files. Has a decorator to regulate
				storage and coupling to an Entity. Do not make abstract because of
				subtyping. This means the names of the subclasses will be used to
				distinguish MolgenisFiles and place them in the correct folders.
			
.
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "MolgenisFile", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "Identifier" }), @javax.persistence.UniqueConstraint( columnNames={ "Name" } ) }
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.core.db.MolgenisFileEntityListener.class})
public class MolgenisFile extends org.molgenis.util.AbstractEntity implements org.molgenis.core.Identifiable
{
	// fieldname constants
	public final static String ID = "id";
	public final static String IDENTIFIER = "Identifier";
	public final static String NAME = "Name";
	public final static String EXTENSION = "Extension";
	
	//static methods
	/**
	 * Shorthand for db.query(MolgenisFile.class).
	 */
	public static org.molgenis.framework.db.Query<? extends MolgenisFile> query(org.molgenis.framework.db.Database db)
	{
		return db.query(MolgenisFile.class);
	}
	
	/**
	 * Shorthand for db.find(MolgenisFile.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends MolgenisFile> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(MolgenisFile.class, rules);
	}	
	
	/**
	 * 
	 */
	public static MolgenisFile findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<MolgenisFile> q = db.query(MolgenisFile.class);
		q.eq(MolgenisFile.ID, id);
		java.util.List<MolgenisFile> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static MolgenisFile findByIdentifier(org.molgenis.framework.db.Database db, String identifier) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<MolgenisFile> q = db.query(MolgenisFile.class);
		q.eq(MolgenisFile.IDENTIFIER, identifier);
		java.util.List<MolgenisFile> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static MolgenisFile findByName(org.molgenis.framework.db.Database db, String name) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<MolgenisFile> q = db.query(MolgenisFile.class);
		q.eq(MolgenisFile.NAME, name);
		java.util.List<MolgenisFile> result = q.find();
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
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="Name", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="name")
	
				

	@javax.validation.constraints.NotNull
	private String name =  null;


	//The file extension. This will be mapped to MIME type at runtime. For example, a type 'png' will be served out as 'image/png'.[type=string]
	@javax.persistence.Column(name="Extension", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="extension")
	
				

	@javax.validation.constraints.NotNull
	private String extension =  null;

	//constructors
	public MolgenisFile()
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
	 * Get the The file extension. This will be mapped to MIME type at runtime. For example, a type 'png' will be served out as 'image/png'..
	 * @return extension.
	 */
	public String getExtension()
	{
		return this.extension;
	}
	
	@Deprecated
	public String getExtension(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the The file extension. This will be mapped to MIME type at runtime. For example, a type 'png' will be served out as 'image/png'..
	 * @param extension
	 */
	public void setExtension( String extension)
	{
		
		this.extension = extension;
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
		if (name.toLowerCase().equals("extension"))
			return getExtension();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getIdentifier() == null) throw new org.molgenis.framework.db.DatabaseException("required field identifier is null");
		if(this.getName() == null) throw new org.molgenis.framework.db.DatabaseException("required field name is null");
		if(this.getExtension() == null) throw new org.molgenis.framework.db.DatabaseException("required field extension is null");
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
			//set Extension
			this.setExtension(tuple.getString("Extension"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("MolgenisFile_id") != null) this.setId(tuple.getInt("MolgenisFile_id"));
			//set Identifier
			if( strict || tuple.getString("Identifier") != null) this.setIdentifier(tuple.getString("Identifier"));
			if( tuple.getString("MolgenisFile_Identifier") != null) this.setIdentifier(tuple.getString("MolgenisFile_Identifier"));
			//set Name
			if( strict || tuple.getString("Name") != null) this.setName(tuple.getString("Name"));
			if( tuple.getString("MolgenisFile_Name") != null) this.setName(tuple.getString("MolgenisFile_Name"));
			//set Extension
			if( strict || tuple.getString("Extension") != null) this.setExtension(tuple.getString("Extension"));
			if( tuple.getString("MolgenisFile_Extension") != null) this.setExtension(tuple.getString("MolgenisFile_Extension"));
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
		String result = "MolgenisFile(";
		result+= "id='" + getId()+"' ";	
		result+= "identifier='" + getIdentifier()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= "extension='" + getExtension()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of MolgenisFile.
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
			fields.add("extension");
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
		result.add("Name");
		return result;
	}

	@Deprecated
	public String getFields(String sep)
	{
		return (""
		+ "id" +sep
		+ "identifier" +sep
		+ "name" +sep
		+ "extension" 
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
		MolgenisFile rhs = (MolgenisFile) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
		//identifier
				.append(identifier, rhs.getIdentifier())
		//name
				.append(name, rhs.getName())
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
				.append(name)
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
			Object valueO = getExtension();
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
	public MolgenisFile create(org.molgenis.util.Tuple tuple) throws Exception
	{
		MolgenisFile e = new MolgenisFile();
		e.set(tuple);
		return e;
	}
	

	
}

