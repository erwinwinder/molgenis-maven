
/* File:        org.molgenis/model/MolgenisRoleGroupLink.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.auth;

/**
 * MolgenisRoleGroupLink: .
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "MolgenisRoleGroupLink", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "Identifier" } ) }
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.auth.db.MolgenisRoleGroupLinkEntityListener.class})
public class MolgenisRoleGroupLink extends org.molgenis.util.AbstractEntity implements org.molgenis.core.Identifiable
{
	// fieldname constants
	public final static String ID = "id";
	public final static String IDENTIFIER = "Identifier";
	public final static String NAME = "Name";
	public final static String GROUP_ = "group_";
	public final static String GROUP__NAME = "group__name";
	public final static String ROLE_ = "role_";
	public final static String ROLE__NAME = "role__name";
	
	//static methods
	/**
	 * Shorthand for db.query(MolgenisRoleGroupLink.class).
	 */
	public static org.molgenis.framework.db.Query<? extends MolgenisRoleGroupLink> query(org.molgenis.framework.db.Database db)
	{
		return db.query(MolgenisRoleGroupLink.class);
	}
	
	/**
	 * Shorthand for db.find(MolgenisRoleGroupLink.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends MolgenisRoleGroupLink> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(MolgenisRoleGroupLink.class, rules);
	}	
	
	/**
	 * 
	 */
	public static MolgenisRoleGroupLink findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<MolgenisRoleGroupLink> q = db.query(MolgenisRoleGroupLink.class);
		q.eq(MolgenisRoleGroupLink.ID, id);
		java.util.List<MolgenisRoleGroupLink> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static MolgenisRoleGroupLink findByIdentifier(org.molgenis.framework.db.Database db, String identifier) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<MolgenisRoleGroupLink> q = db.query(MolgenisRoleGroupLink.class);
		q.eq(MolgenisRoleGroupLink.IDENTIFIER, identifier);
		java.util.List<MolgenisRoleGroupLink> result = q.find();
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


	//group_[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="group_", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.auth.MolgenisGroup group_ = null;
	@javax.persistence.Transient
	private Integer group__id = null;	
	@javax.persistence.Transient
	private String group__name = null;						


	//role_[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="role_", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.auth.MolgenisRole role_ = null;
	@javax.persistence.Transient
	private Integer role__id = null;	
	@javax.persistence.Transient
	private String role__name = null;						

	//constructors
	public MolgenisRoleGroupLink()
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
	 * Get the group_.
	 * @return group_.
	 */
	public org.molgenis.auth.MolgenisGroup getGroup()
	{
		return this.group_;
	}
	
	@Deprecated
	public org.molgenis.auth.MolgenisGroup getGroup(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the group_.
	 * @param group_
	 */
	public void setGroup( org.molgenis.auth.MolgenisGroup group_)
	{
		
		this.group_ = group_;
	}

	
	
	/**
	 * Set foreign key for field group_.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setGroup_Id(Integer group__id)
	{
		this.group__id = group__id;
	}	

	public void setGroup(Integer group__id)
	{
		this.group__id = group__id;
	}
	
	public Integer getGroup_Id()
	{
		
		if(group_ != null) 
		{
			return group_.getId();
		}
		else
		{
			return group__id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference Group to MolgenisGroup.Id.
	 */
	public String getGroup_Name()
	{		
		//FIXME should we auto-load based on getGroup()?	
		if(group_ != null) {
			return group_.getName();
		} else {
			return group__name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Group to <a href="MolgenisGroup.html#Id">MolgenisGroup.Id</a>.
	 * Implies setGroup(null) until save
	 */
	public void setGroup_Name(String group__name)
	{
		this.group__name = group__name;
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
		if (name.toLowerCase().equals("group_"))
			return getGroup();
		if(name.toLowerCase().equals("group__id"))
			return getGroup_Id();
		if(name.toLowerCase().equals("group__name"))
			return getGroup_Name();
		if (name.toLowerCase().equals("role_"))
			return getRole();
		if(name.toLowerCase().equals("role__id"))
			return getRole_Id();
		if(name.toLowerCase().equals("role__name"))
			return getRole_Name();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getIdentifier() == null) throw new org.molgenis.framework.db.DatabaseException("required field identifier is null");
		if(this.getName() == null) throw new org.molgenis.framework.db.DatabaseException("required field name is null");
		if(this.getGroup() == null) throw new org.molgenis.framework.db.DatabaseException("required field group_ is null");
		if(this.getRole() == null) throw new org.molgenis.framework.db.DatabaseException("required field role_ is null");
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
			//set Group
			this.setGroup(tuple.getInt("group_"));
			//set label name for xref field Group
			this.setGroup_Name(tuple.getString("group__name"));	
			//set Role
			this.setRole(tuple.getInt("role_"));
			//set label name for xref field Role
			this.setRole_Name(tuple.getString("role__name"));	
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("MolgenisRoleGroupLink_id") != null) this.setId(tuple.getInt("MolgenisRoleGroupLink_id"));
			//set Identifier
			if( strict || tuple.getString("Identifier") != null) this.setIdentifier(tuple.getString("Identifier"));
			if( tuple.getString("MolgenisRoleGroupLink_Identifier") != null) this.setIdentifier(tuple.getString("MolgenisRoleGroupLink_Identifier"));
			//set Name
			if( strict || tuple.getString("Name") != null) this.setName(tuple.getString("Name"));
			if( tuple.getString("MolgenisRoleGroupLink_Name") != null) this.setName(tuple.getString("MolgenisRoleGroupLink_Name"));
			//set Group
			if( strict || tuple.getInt("group__id") != null) this.setGroup(tuple.getInt("group__id"));
			if( tuple.getInt("MolgenisRoleGroupLink_group__id") != null) this.setGroup(tuple.getInt("MolgenisRoleGroupLink_group__id"));
			//alias of xref
			if( tuple.getObject("group_") != null) this.setGroup(tuple.getInt("group_"));
			if( tuple.getObject("MolgenisRoleGroupLink_group_") != null) this.setGroup(tuple.getInt("MolgenisRoleGroupLink_group_"));
			//set label for field Group
			if( strict || tuple.getObject("group__name") != null) this.setGroup_Name(tuple.getString("group__name"));			
			if( tuple.getObject("MolgenisRoleGroupLink_group__name") != null ) this.setGroup_Name(tuple.getString("MolgenisRoleGroupLink_group__name"));		
			//set Role
			if( strict || tuple.getInt("role__id") != null) this.setRole(tuple.getInt("role__id"));
			if( tuple.getInt("MolgenisRoleGroupLink_role__id") != null) this.setRole(tuple.getInt("MolgenisRoleGroupLink_role__id"));
			//alias of xref
			if( tuple.getObject("role_") != null) this.setRole(tuple.getInt("role_"));
			if( tuple.getObject("MolgenisRoleGroupLink_role_") != null) this.setRole(tuple.getInt("MolgenisRoleGroupLink_role_"));
			//set label for field Role
			if( strict || tuple.getObject("role__name") != null) this.setRole_Name(tuple.getString("role__name"));			
			if( tuple.getObject("MolgenisRoleGroupLink_role__name") != null ) this.setRole_Name(tuple.getString("MolgenisRoleGroupLink_role__name"));		
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
		String result = "MolgenisRoleGroupLink(";
		result+= "id='" + getId()+"' ";	
		result+= "identifier='" + getIdentifier()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= " group__id='" + getGroup_Id()+"' ";	
		result+= " group__name='" + getGroup_Name()+"' ";
		result+= " role__id='" + getRole_Id()+"' ";	
		result+= " role__name='" + getRole_Name()+"' ";
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of MolgenisRoleGroupLink.
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
			fields.add("group__id");
		}
		fields.add("group__name");
		{
			fields.add("role__id");
		}
		fields.add("role__name");
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
		+ "group_" +sep
		+ "role_" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("group_")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("role_")) {
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
		MolgenisRoleGroupLink rhs = (MolgenisRoleGroupLink) obj;
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
			Object valueO = getGroup();
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
			out.write(valueS);
		}
		return out.toString();
	}
	
	@Override
	public MolgenisRoleGroupLink create(org.molgenis.util.Tuple tuple) throws Exception
	{
		MolgenisRoleGroupLink e = new MolgenisRoleGroupLink();
		e.set(tuple);
		return e;
	}
	

	
}

