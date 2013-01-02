
/* File:        org.molgenis.omx/model/MolgenisPermission.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.auth;

/**
 * MolgenisPermission: .
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "MolgenisPermission"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.auth.db.MolgenisPermissionEntityListener.class})
public class MolgenisPermission extends org.molgenis.util.AbstractEntity implements org.molgenis.core.Autoid
{
	// fieldname constants
	public final static String ID = "id";
	public final static String ROLE_ = "role_";
	public final static String ROLE__NAME = "role__name";
	public final static String ENTITY = "entity";
	public final static String ENTITY_CLASSNAME = "entity_className";
	public final static String PERMISSION = "permission";
	
	//static methods
	/**
	 * Shorthand for db.query(MolgenisPermission.class).
	 */
	public static org.molgenis.framework.db.Query<? extends MolgenisPermission> query(org.molgenis.framework.db.Database db)
	{
		return db.query(MolgenisPermission.class);
	}
	
	/**
	 * Shorthand for db.find(MolgenisPermission.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends MolgenisPermission> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(MolgenisPermission.class, rules);
	}	
	
	/**
	 * 
	 */
	public static MolgenisPermission findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<MolgenisPermission> q = db.query(MolgenisPermission.class);
		q.eq(MolgenisPermission.ID, id);
		java.util.List<MolgenisPermission> result = q.find();
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


	//role_[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="role_", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.auth.MolgenisRole role_ = null;
	@javax.persistence.Transient
	private Integer role__id = null;	
	@javax.persistence.Transient
	private String role__name = null;						


	//entity[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="entity", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.core.MolgenisEntity entity = null;
	@javax.persistence.Transient
	private Integer entity_id = null;	
	@javax.persistence.Transient
	private String entity_className = null;						


	//permission[type=enum]
	@javax.persistence.Column(name="permission", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="permission")
	
				

	@javax.validation.constraints.NotNull
	private String permission =  null;
	@javax.persistence.Transient
	private String permission_label = null;
	@javax.persistence.Transient
	private java.util.List<org.molgenis.util.ValueLabel> permission_options = new java.util.ArrayList<org.molgenis.util.ValueLabel>();

	//constructors
	public MolgenisPermission()
	{
	
		//options for enum Permission
		permission_options.add(new org.molgenis.util.ValueLabel("read","read"));
		permission_options.add(new org.molgenis.util.ValueLabel("write","write"));
		permission_options.add(new org.molgenis.util.ValueLabel("own","own"));
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
	 * Get the role_.
	 * @return role_.
	 */
	public org.molgenis.auth.MolgenisRole getRole()
	{
		return this.role_;
	}
	
	@Deprecated
	public org.molgenis.auth.MolgenisRole getRole(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the role_.
	 * @param role_
	 */
	public void setRole( org.molgenis.auth.MolgenisRole role_)
	{
		
		this.role_ = role_;
	}

	
	
	/**
	 * Set foreign key for field role_.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setRole_Id(Integer role__id)
	{
		this.role__id = role__id;
	}	

	public void setRole(Integer role__id)
	{
		this.role__id = role__id;
	}
	
	public Integer getRole_Id()
	{
		
		if(role_ != null) 
		{
			return role_.getId();
		}
		else
		{
			return role__id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference Role to MolgenisRole.Id.
	 */
	public String getRole_Name()
	{		
		//FIXME should we auto-load based on getRole()?	
		if(role_ != null) {
			return role_.getName();
		} else {
			return role__name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Role to <a href="MolgenisRole.html#Id">MolgenisRole.Id</a>.
	 * Implies setRole(null) until save
	 */
	public void setRole_Name(String role__name)
	{
		this.role__name = role__name;
	}		
	 
	

	/**
	 * Get the entity.
	 * @return entity.
	 */
	public org.molgenis.core.MolgenisEntity getEntity()
	{
		return this.entity;
	}
	
	@Deprecated
	public org.molgenis.core.MolgenisEntity getEntity(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the entity.
	 * @param entity
	 */
	public void setEntity( org.molgenis.core.MolgenisEntity entity)
	{
		
		this.entity = entity;
	}

	
	
	/**
	 * Set foreign key for field entity.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setEntity_Id(Integer entity_id)
	{
		this.entity_id = entity_id;
	}	

	public void setEntity(Integer entity_id)
	{
		this.entity_id = entity_id;
	}
	
	public Integer getEntity_Id()
	{
		
		if(entity != null) 
		{
			return entity.getId();
		}
		else
		{
			return entity_id;
		}
	}	
	 
	/**
	 * Get a pretty label className for cross reference Entity to MolgenisEntity.Id.
	 */
	public String getEntity_ClassName()
	{		
		//FIXME should we auto-load based on getEntity()?	
		if(entity != null) {
			return entity.getClassName();
		} else {
			return entity_className;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Entity to <a href="MolgenisEntity.html#Id">MolgenisEntity.Id</a>.
	 * Implies setEntity(null) until save
	 */
	public void setEntity_ClassName(String entity_className)
	{
		this.entity_className = entity_className;
	}		
	 
	

	/**
	 * Get the permission.
	 * @return permission.
	 */
	public String getPermission()
	{
		return this.permission;
	}
	
	@Deprecated
	public String getPermission(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the permission.
	 * @param permission
	 */
	public void setPermission( String permission)
	{
		
		this.permission = permission;
	}

	
	/**
	 * Get tha label for enum Permission.
	 */
	public String getPermissionLabel()
	{
		return this.permission_label;
	}
	
	/**
	 * Permission is enum. This method returns all available enum options.
	 */
	public java.util.List<org.molgenis.util.ValueLabel> getPermissionOptions()
	{
		return permission_options;
	}	
	


	/**
	 * Generic getter. Get the property by using the name.
	 */
	public Object get(String name)
	{
		name = name.toLowerCase();
		if (name.toLowerCase().equals("id"))
			return getId();
		if (name.toLowerCase().equals("role_"))
			return getRole();
		if(name.toLowerCase().equals("role__id"))
			return getRole_Id();
		if(name.toLowerCase().equals("role__name"))
			return getRole_Name();
		if (name.toLowerCase().equals("entity"))
			return getEntity();
		if(name.toLowerCase().equals("entity_id"))
			return getEntity_Id();
		if(name.toLowerCase().equals("entity_classname"))
			return getEntity_ClassName();
		if (name.toLowerCase().equals("permission"))
			return getPermission();
		if(name.toLowerCase().equals("permission_label"))
			return getPermissionLabel();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getRole() == null) throw new org.molgenis.framework.db.DatabaseException("required field role_ is null");
		if(this.getEntity() == null) throw new org.molgenis.framework.db.DatabaseException("required field entity is null");
		if(this.getPermission() == null) throw new org.molgenis.framework.db.DatabaseException("required field permission is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.util.Tuple tuple, boolean strict )  throws Exception
	{
		//optimization :-(
		if(tuple instanceof org.molgenis.util.ResultSetTuple)
		{
				//set Id
			this.setId(tuple.getInt("id"));
			//set Role
			this.setRole(tuple.getInt("role_"));
			//set label name for xref field Role
			this.setRole_Name(tuple.getString("role__name"));	
			//set Entity
			this.setEntity(tuple.getInt("entity"));
			//set label className for xref field Entity
			this.setEntity_ClassName(tuple.getString("entity_className"));	
			//set Permission
			this.setPermission(tuple.getString("permission"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("MolgenisPermission_id") != null) this.setId(tuple.getInt("MolgenisPermission_id"));
			//set Role
			if( strict || tuple.getInt("role__id") != null) this.setRole(tuple.getInt("role__id"));
			if( tuple.getInt("MolgenisPermission_role__id") != null) this.setRole(tuple.getInt("MolgenisPermission_role__id"));
			//alias of xref
			if( tuple.getObject("role_") != null) this.setRole(tuple.getInt("role_"));
			if( tuple.getObject("MolgenisPermission_role_") != null) this.setRole(tuple.getInt("MolgenisPermission_role_"));
			//set label for field Role
			if( strict || tuple.getObject("role__name") != null) this.setRole_Name(tuple.getString("role__name"));			
			if( tuple.getObject("MolgenisPermission_role__name") != null ) this.setRole_Name(tuple.getString("MolgenisPermission_role__name"));		
			//set Entity
			if( strict || tuple.getInt("entity_id") != null) this.setEntity(tuple.getInt("entity_id"));
			if( tuple.getInt("MolgenisPermission_entity_id") != null) this.setEntity(tuple.getInt("MolgenisPermission_entity_id"));
			//alias of xref
			if( tuple.getObject("entity") != null) this.setEntity(tuple.getInt("entity"));
			if( tuple.getObject("MolgenisPermission_entity") != null) this.setEntity(tuple.getInt("MolgenisPermission_entity"));
			//set label for field Entity
			if( strict || tuple.getObject("entity_className") != null) this.setEntity_ClassName(tuple.getString("entity_className"));			
			if( tuple.getObject("MolgenisPermission_entity_className") != null ) this.setEntity_ClassName(tuple.getString("MolgenisPermission_entity_className"));		
			//set Permission
			if( strict || tuple.getString("permission") != null) this.setPermission(tuple.getString("permission"));
			if( tuple.getString("MolgenisPermission_permission") != null) this.setPermission(tuple.getString("MolgenisPermission_permission"));
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
		String result = "MolgenisPermission(";
		result+= "id='" + getId()+"' ";	
		result+= " role__id='" + getRole_Id()+"' ";	
		result+= " role__name='" + getRole_Name()+"' ";
		result+= " entity_id='" + getEntity_Id()+"' ";	
		result+= " entity_className='" + getEntity_ClassName()+"' ";
		result+= "permission='" + getPermission()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of MolgenisPermission.
	 */
	public java.util.Vector<String> getFields(boolean skipAutoIds)
	{
		java.util.Vector<String> fields = new java.util.Vector<String>();
		if(!skipAutoIds)
		{
			fields.add("id");
		}
		{
			fields.add("role__id");
		}
		fields.add("role__name");
		{
			fields.add("entity_id");
		}
		fields.add("entity_className");
		{
			fields.add("permission");
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
		result.add("id");
		return result;
	}

	@Deprecated
	public String getFields(String sep)
	{
		return (""
		+ "id" +sep
		+ "role_" +sep
		+ "entity" +sep
		+ "permission" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("role_")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("entity")) {
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
		MolgenisPermission rhs = (MolgenisPermission) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
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
			Object valueO = getRole();
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
			Object valueO = getEntity();
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
			Object valueO = getPermission();
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
	public MolgenisPermission create(org.molgenis.util.Tuple tuple) throws Exception
	{
		MolgenisPermission e = new MolgenisPermission();
		e.set(tuple);
		return e;
	}
	

	
}

