
/* File:        org.molgenis.omx/model/MolgenisEntity.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.core;

/**
 * MolgenisEntity: Referenceable catalog of entity names, menus, forms and
				plugins.
			
.
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "MolgenisEntity", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "className" }), @javax.persistence.UniqueConstraint( columnNames={ "name", "type_" } ) }
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.core.db.MolgenisEntityEntityListener.class})
public class MolgenisEntity extends org.molgenis.util.AbstractEntity implements org.molgenis.core.Autoid
{
	// fieldname constants
	public final static String ID = "id";
	public final static String NAME = "name";
	public final static String TYPE_ = "type_";
	public final static String CLASSNAME = "className";
	
	//static methods
	/**
	 * Shorthand for db.query(MolgenisEntity.class).
	 */
	public static org.molgenis.framework.db.Query<? extends MolgenisEntity> query(org.molgenis.framework.db.Database db)
	{
		return db.query(MolgenisEntity.class);
	}
	
	/**
	 * Shorthand for db.find(MolgenisEntity.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends MolgenisEntity> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(MolgenisEntity.class, rules);
	}	
	
	/**
	 * 
	 */
	public static MolgenisEntity findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<MolgenisEntity> q = db.query(MolgenisEntity.class);
		q.eq(MolgenisEntity.ID, id);
		java.util.List<MolgenisEntity> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static MolgenisEntity findByClassName(org.molgenis.framework.db.Database db, String className) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<MolgenisEntity> q = db.query(MolgenisEntity.class);
		q.eq(MolgenisEntity.CLASSNAME, className);
		java.util.List<MolgenisEntity> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static MolgenisEntity findByNameType(org.molgenis.framework.db.Database db, String name, String type_) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<MolgenisEntity> q = db.query(MolgenisEntity.class);
		q.eq(MolgenisEntity.NAME, name);q.eq(MolgenisEntity.TYPE_, type_);
		java.util.List<MolgenisEntity> result = q.find();
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


	//Name of the entity[type=string]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="name", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="name")
	
				

	@javax.validation.constraints.NotNull
	private String name =  null;


	//Type of the entity[type=string]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="type_", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="type_")
	
				

	@javax.validation.constraints.NotNull
	private String type_ =  null;


	//Full name of the entity[type=string]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="className", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="className")
	
				

	@javax.validation.constraints.NotNull
	private String className =  null;

	//constructors
	public MolgenisEntity()
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
	 * Get the Name of the entity.
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
	 * Set the Name of the entity.
	 * @param name
	 */
	public void setName( String name)
	{
		
		this.name = name;
	}

	

	/**
	 * Get the Type of the entity.
	 * @return type_.
	 */
	public String getType()
	{
		return this.type_;
	}
	
	@Deprecated
	public String getType(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Type of the entity.
	 * @param type_
	 */
	public void setType( String type_)
	{
		
		this.type_ = type_;
	}

	

	/**
	 * Get the Full name of the entity.
	 * @return className.
	 */
	public String getClassName()
	{
		return this.className;
	}
	
	@Deprecated
	public String getClassName(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Full name of the entity.
	 * @param className
	 */
	public void setClassName( String className)
	{
		
		this.className = className;
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
		if (name.toLowerCase().equals("type_"))
			return getType();
		if (name.toLowerCase().equals("classname"))
			return getClassName();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getName() == null) throw new org.molgenis.framework.db.DatabaseException("required field name is null");
		if(this.getType() == null) throw new org.molgenis.framework.db.DatabaseException("required field type_ is null");
		if(this.getClassName() == null) throw new org.molgenis.framework.db.DatabaseException("required field className is null");
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
			this.setName(tuple.getString("name"));
			//set Type
			this.setType(tuple.getString("type_"));
			//set ClassName
			this.setClassName(tuple.getString("className"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("MolgenisEntity_id") != null) this.setId(tuple.getInt("MolgenisEntity_id"));
			//set Name
			if( strict || tuple.getString("name") != null) this.setName(tuple.getString("name"));
			if( tuple.getString("MolgenisEntity_name") != null) this.setName(tuple.getString("MolgenisEntity_name"));
			//set Type
			if( strict || tuple.getString("type_") != null) this.setType(tuple.getString("type_"));
			if( tuple.getString("MolgenisEntity_type_") != null) this.setType(tuple.getString("MolgenisEntity_type_"));
			//set ClassName
			if( strict || tuple.getString("className") != null) this.setClassName(tuple.getString("className"));
			if( tuple.getString("MolgenisEntity_className") != null) this.setClassName(tuple.getString("MolgenisEntity_className"));
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
		String result = "MolgenisEntity(";
		result+= "id='" + getId()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= "type_='" + getType()+"' ";	
		result+= "className='" + getClassName()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of MolgenisEntity.
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
			fields.add("type_");
		}
		{
			fields.add("className");
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
		result.add("className");
		return result;
	}

	@Deprecated
	public String getFields(String sep)
	{
		return (""
		+ "id" +sep
		+ "name" +sep
		+ "type_" +sep
		+ "className" 
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
		MolgenisEntity rhs = (MolgenisEntity) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
		//className
				.append(className, rhs.getClassName())
		//name
				.append(name, rhs.getName())
		//type_
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
				.append(className)
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
			Object valueO = getType();
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
			Object valueO = getClassName();
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
	public MolgenisEntity create(org.molgenis.util.Tuple tuple) throws Exception
	{
		MolgenisEntity e = new MolgenisEntity();
		e.set(tuple);
		return e;
	}
	
//1
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="entity"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.auth.MolgenisPermission> entityMolgenisPermissionCollection = new java.util.ArrayList<org.molgenis.auth.MolgenisPermission>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.auth.MolgenisPermission> getEntityMolgenisPermissionCollection()
	{
            return entityMolgenisPermissionCollection;
	}

    public void setEntityMolgenisPermissionCollection(java.util.Collection<org.molgenis.auth.MolgenisPermission> collection)
    {
        for (org.molgenis.auth.MolgenisPermission molgenisPermission : collection) {
            molgenisPermission.setEntity(this);
        }
        entityMolgenisPermissionCollection = collection;
    }	

	
}

