
/* File:        org.molgenis/model/MolgenisUser.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.auth;

/**
 * MolgenisUser: Anyone who can login
.
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "MolgenisUser", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "username" } ) }
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.auth.db.MolgenisUserEntityListener.class})
public class MolgenisUser extends org.molgenis.util.AbstractEntity implements org.molgenis.core.Autoid
{
	// fieldname constants
	public final static String ID = "id";
	public final static String USERNAME = "username";
	public final static String PASSWORD_ = "password_";
	public final static String ACTIVATIONCODE = "activationCode";
	public final static String ACTIVE = "active";
	public final static String SUPERUSER = "superuser";
	
	//static methods
	/**
	 * Shorthand for db.query(MolgenisUser.class).
	 */
	public static org.molgenis.framework.db.Query<? extends MolgenisUser> query(org.molgenis.framework.db.Database db)
	{
		return db.query(MolgenisUser.class);
	}
	
	/**
	 * Shorthand for db.find(MolgenisUser.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends MolgenisUser> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(MolgenisUser.class, rules);
	}	
	
	/**
	 * 
	 */
	public static MolgenisUser findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<MolgenisUser> q = db.query(MolgenisUser.class);
		q.eq(MolgenisUser.ID, id);
		java.util.List<MolgenisUser> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static MolgenisUser findByUsername(org.molgenis.framework.db.Database db, String username) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<MolgenisUser> q = db.query(MolgenisUser.class);
		q.eq(MolgenisUser.USERNAME, username);
		java.util.List<MolgenisUser> result = q.find();
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


	//username[type=string]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="username", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="username")
	
				

	@javax.validation.constraints.NotNull
	private String username =  null;


	//big fixme: password type[type=string]
	@javax.persistence.Column(name="password_", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="password_")
	
				

	@javax.validation.constraints.NotNull
	private String password_ =  "secret";


	//Used as alternative authentication mechanism to verify user email and/or if user has lost password.[type=string]
	@javax.persistence.Column(name="activationCode")
	@javax.xml.bind.annotation.XmlElement(name="activationCode")
	
				

	private String activationCode =  null;


	//Boolean to indicate if this account can be used to login[type=bool]
	@javax.persistence.Column(name="active", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="active")
	
				

	@javax.validation.constraints.NotNull
	private Boolean active =  false;


	//superuser[type=bool]
	@javax.persistence.Column(name="superuser", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="superuser")
	
				

	@javax.validation.constraints.NotNull
	private Boolean superuser =  false;

	//constructors
	public MolgenisUser()
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
	 * Get the username.
	 * @return username.
	 */
	public String getUsername()
	{
		return this.username;
	}
	
	@Deprecated
	public String getUsername(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the username.
	 * @param username
	 */
	public void setUsername( String username)
	{
		
		this.username = username;
	}

	

	/**
	 * Get the big fixme: password type.
	 * @return password_.
	 */
	public String getPassword()
	{
		return this.password_;
	}
	
	@Deprecated
	public String getPassword(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the big fixme: password type.
	 * @param password_
	 */
	public void setPassword( String password_)
	{
		
		this.password_ = password_;
	}

	

	/**
	 * Get the Used as alternative authentication mechanism to verify user email and/or if user has lost password..
	 * @return activationCode.
	 */
	public String getActivationCode()
	{
		return this.activationCode;
	}
	
	@Deprecated
	public String getActivationCode(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Used as alternative authentication mechanism to verify user email and/or if user has lost password..
	 * @param activationCode
	 */
	public void setActivationCode( String activationCode)
	{
		
		this.activationCode = activationCode;
	}

	

	/**
	 * Get the Boolean to indicate if this account can be used to login.
	 * @return active.
	 */
	public Boolean getActive()
	{
		return this.active;
	}
	
	@Deprecated
	public Boolean getActive(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Boolean to indicate if this account can be used to login.
	 * @param active
	 */
	public void setActive( Boolean active)
	{
		
		this.active = active;
	}

	

	/**
	 * Get the superuser.
	 * @return superuser.
	 */
	public Boolean getSuperuser()
	{
		return this.superuser;
	}
	
	@Deprecated
	public Boolean getSuperuser(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the superuser.
	 * @param superuser
	 */
	public void setSuperuser( Boolean superuser)
	{
		
		this.superuser = superuser;
	}

	


	/**
	 * Generic getter. Get the property by using the name.
	 */
	public Object get(String name)
	{
		name = name.toLowerCase();
		if (name.toLowerCase().equals("id"))
			return getId();
		if (name.toLowerCase().equals("username"))
			return getUsername();
		if (name.toLowerCase().equals("password_"))
			return getPassword();
		if (name.toLowerCase().equals("activationcode"))
			return getActivationCode();
		if (name.toLowerCase().equals("active"))
			return getActive();
		if (name.toLowerCase().equals("superuser"))
			return getSuperuser();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getUsername() == null) throw new org.molgenis.framework.db.DatabaseException("required field username is null");
		if(this.getPassword() == null) throw new org.molgenis.framework.db.DatabaseException("required field password_ is null");
		if(this.getActive() == null) throw new org.molgenis.framework.db.DatabaseException("required field active is null");
		if(this.getSuperuser() == null) throw new org.molgenis.framework.db.DatabaseException("required field superuser is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.util.Tuple tuple, boolean strict )  throws Exception
	{
		//optimization :-(
		if(tuple instanceof org.molgenis.util.ResultSetTuple)
		{
				//set Id
			this.setId(tuple.getInt("id"));
			//set Username
			this.setUsername(tuple.getString("username"));
			//set Password
			this.setPassword(tuple.getString("password_"));
			//set ActivationCode
			this.setActivationCode(tuple.getString("activationCode"));
			//set Active
			this.setActive(tuple.getBoolean("active"));
			//set Superuser
			this.setSuperuser(tuple.getBoolean("superuser"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("MolgenisUser_id") != null) this.setId(tuple.getInt("MolgenisUser_id"));
			//set Username
			if( strict || tuple.getString("username") != null) this.setUsername(tuple.getString("username"));
			if( tuple.getString("MolgenisUser_username") != null) this.setUsername(tuple.getString("MolgenisUser_username"));
			//set Password
			if( strict || tuple.getString("password_") != null) this.setPassword(tuple.getString("password_"));
			if( tuple.getString("MolgenisUser_password_") != null) this.setPassword(tuple.getString("MolgenisUser_password_"));
			//set ActivationCode
			if( strict || tuple.getString("activationCode") != null) this.setActivationCode(tuple.getString("activationCode"));
			if( tuple.getString("MolgenisUser_activationCode") != null) this.setActivationCode(tuple.getString("MolgenisUser_activationCode"));
			//set Active
			if( strict || tuple.getBoolean("active") != null) this.setActive(tuple.getBoolean("active"));
			if( tuple.getBoolean("MolgenisUser_active") != null) this.setActive(tuple.getBoolean("MolgenisUser_active"));
			//set Superuser
			if( strict || tuple.getBoolean("superuser") != null) this.setSuperuser(tuple.getBoolean("superuser"));
			if( tuple.getBoolean("MolgenisUser_superuser") != null) this.setSuperuser(tuple.getBoolean("MolgenisUser_superuser"));
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
		String result = "MolgenisUser(";
		result+= "id='" + getId()+"' ";	
		result+= "username='" + getUsername()+"' ";	
		result+= "password_='" + getPassword()+"' ";	
		result+= "activationCode='" + getActivationCode()+"' ";	
		result+= "active='" + getActive()+"' ";	
		result+= "superuser='" + getSuperuser()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of MolgenisUser.
	 */
	public java.util.Vector<String> getFields(boolean skipAutoIds)
	{
		java.util.Vector<String> fields = new java.util.Vector<String>();
		if(!skipAutoIds)
		{
			fields.add("id");
		}
		{
			fields.add("username");
		}
		{
			fields.add("password_");
		}
		{
			fields.add("activationCode");
		}
		{
			fields.add("active");
		}
		{
			fields.add("superuser");
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
		result.add("username");
		return result;
	}

	@Deprecated
	public String getFields(String sep)
	{
		return (""
		+ "id" +sep
		+ "username" +sep
		+ "password_" +sep
		+ "activationCode" +sep
		+ "active" +sep
		+ "superuser" 
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
		MolgenisUser rhs = (MolgenisUser) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
		//username
				.append(username, rhs.getUsername())
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
				.append(username)
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
			Object valueO = getUsername();
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
			Object valueO = getPassword();
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
			Object valueO = getActivationCode();
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
			Object valueO = getActive();
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
			Object valueO = getSuperuser();
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
	public MolgenisUser create(org.molgenis.util.Tuple tuple) throws Exception
	{
		MolgenisUser e = new MolgenisUser();
		e.set(tuple);
		return e;
	}
	

	
}

