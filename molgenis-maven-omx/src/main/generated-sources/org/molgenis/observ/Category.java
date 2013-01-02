
/* File:        org.molgenis.omx/model/Category.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.observ;

/**
 * Category: Category is partOf ObservableFeature to define
				categories for an
				ObservableFeature, such as the categorical
				answer codes that are often used in Questionaires. 
				For example the ObservableFeature 'sex' has
				{code_string = 1, label=male} and {code_string
				= 2, label=female}.
				Category can be linked to well-defined
				ontology terms via the
				ontologyReference. Category
				extends
				ObservationElement such that it
				can be referenced by
				ObservedValue.value.
				The Category class maps to
				METABASE::Category
			
.
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "Category"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.observ.db.CategoryEntityListener.class})
public class Category extends org.molgenis.observ.Characteristic 
{
	// fieldname constants
	public final static String OBSERVABLEFEATURE = "observableFeature";
	public final static String OBSERVABLEFEATURE_IDENTIFIER = "observableFeature_Identifier";
	public final static String VALUECODE = "valueCode";
	public final static String ISMISSING = "isMissing";
	public final static String ID = "id";
	
	//static methods
	/**
	 * Shorthand for db.query(Category.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Category> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Category.class);
	}
	
	/**
	 * Shorthand for db.find(Category.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Category> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Category.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Category findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Category> q = db.query(Category.class);
		q.eq(Category.ID, id);
		java.util.List<Category> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Category findByIdentifier(org.molgenis.framework.db.Database db, String identifier) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Category> q = db.query(Category.class);
		q.eq(Category.IDENTIFIER, identifier);
		java.util.List<Category> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//The Measurement these permitted values are part of.[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="observableFeature", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.observ.ObservableFeature observableFeature = null;
	@javax.persistence.Transient
	private Integer observableFeature_id = null;	
	@javax.persistence.Transient
	private String observableFeature_Identifier = null;						


	//The value used to store this category in ObservedValue. For example '1', '2'.[type=string]
	@javax.persistence.Column(name="valueCode", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="valueCode")
	
				

	@javax.validation.constraints.NotNull
	private String valueCode =  null;


	//whether this value should be treated as missing value.[type=bool]
	@javax.persistence.Column(name="isMissing", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="isMissing")
	
				

	@javax.validation.constraints.NotNull
	private Boolean isMissing =  false;


	//automatically generated internal id, only for internal use.[type=int]
	

	//constructors
	public Category()
	{
		//set the type for a new instance
		set__Type(this.getClass().getSimpleName());
	
	}
	
	//getters and setters
	/**
	 * Get the The Measurement these permitted values are part of..
	 * @return observableFeature.
	 */
	public org.molgenis.observ.ObservableFeature getObservableFeature()
	{
		return this.observableFeature;
	}
	
	@Deprecated
	public org.molgenis.observ.ObservableFeature getObservableFeature(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the The Measurement these permitted values are part of..
	 * @param observableFeature
	 */
	public void setObservableFeature( org.molgenis.observ.ObservableFeature observableFeature)
	{
		
		this.observableFeature = observableFeature;
	}

	
	
	/**
	 * Set foreign key for field observableFeature.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setObservableFeature_Id(Integer observableFeature_id)
	{
		this.observableFeature_id = observableFeature_id;
	}	

	public void setObservableFeature(Integer observableFeature_id)
	{
		this.observableFeature_id = observableFeature_id;
	}
	
	public Integer getObservableFeature_Id()
	{
		
		if(observableFeature != null) 
		{
			return observableFeature.getId();
		}
		else
		{
			return observableFeature_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference ObservableFeature to ObservableFeature.Id.
	 */
	public String getObservableFeature_Identifier()
	{		
		//FIXME should we auto-load based on getObservableFeature()?	
		if(observableFeature != null) {
			return observableFeature.getIdentifier();
		} else {
			return observableFeature_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference ObservableFeature to <a href="ObservableFeature.html#Id">ObservableFeature.Id</a>.
	 * Implies setObservableFeature(null) until save
	 */
	public void setObservableFeature_Identifier(String observableFeature_Identifier)
	{
		this.observableFeature_Identifier = observableFeature_Identifier;
	}		
	 
	

	/**
	 * Get the The value used to store this category in ObservedValue. For example '1', '2'..
	 * @return valueCode.
	 */
	public String getValueCode()
	{
		return this.valueCode;
	}
	
	@Deprecated
	public String getValueCode(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the The value used to store this category in ObservedValue. For example '1', '2'..
	 * @param valueCode
	 */
	public void setValueCode( String valueCode)
	{
		
		this.valueCode = valueCode;
	}

	

	/**
	 * Get the whether this value should be treated as missing value..
	 * @return isMissing.
	 */
	public Boolean getIsMissing()
	{
		return this.isMissing;
	}
	
	@Deprecated
	public Boolean getIsMissing(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the whether this value should be treated as missing value..
	 * @param isMissing
	 */
	public void setIsMissing( Boolean isMissing)
	{
		
		this.isMissing = isMissing;
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
		if (name.toLowerCase().equals("observablefeature"))
			return getObservableFeature();
		if(name.toLowerCase().equals("observablefeature_id"))
			return getObservableFeature_Id();
		if(name.toLowerCase().equals("observablefeature_identifier"))
			return getObservableFeature_Identifier();
		if (name.toLowerCase().equals("valuecode"))
			return getValueCode();
		if (name.toLowerCase().equals("ismissing"))
			return getIsMissing();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getIdentifier() == null) throw new org.molgenis.framework.db.DatabaseException("required field identifier is null");
		if(this.getName() == null) throw new org.molgenis.framework.db.DatabaseException("required field name is null");
		if(this.get__Type() == null) throw new org.molgenis.framework.db.DatabaseException("required field __Type is null");
		if(this.getObservableFeature() == null) throw new org.molgenis.framework.db.DatabaseException("required field observableFeature is null");
		if(this.getValueCode() == null) throw new org.molgenis.framework.db.DatabaseException("required field valueCode is null");
		if(this.getIsMissing() == null) throw new org.molgenis.framework.db.DatabaseException("required field isMissing is null");
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
			//set ObservableFeature
			this.setObservableFeature(tuple.getInt("observableFeature"));
			//set label Identifier for xref field ObservableFeature
			this.setObservableFeature_Identifier(tuple.getString("observableFeature_Identifier"));	
			//set ValueCode
			this.setValueCode(tuple.getString("valueCode"));
			//set IsMissing
			this.setIsMissing(tuple.getBoolean("isMissing"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("Category_id") != null) this.setId(tuple.getInt("Category_id"));
			//set Identifier
			if( strict || tuple.getString("Identifier") != null) this.setIdentifier(tuple.getString("Identifier"));
			if( tuple.getString("Category_Identifier") != null) this.setIdentifier(tuple.getString("Category_Identifier"));
			//set Name
			if( strict || tuple.getString("Name") != null) this.setName(tuple.getString("Name"));
			if( tuple.getString("Category_Name") != null) this.setName(tuple.getString("Category_Name"));
			//set __Type
			if( strict || tuple.getString("__Type") != null) this.set__Type(tuple.getString("__Type"));
			if( tuple.getString("Category___Type") != null) this.set__Type(tuple.getString("Category___Type"));
			//set Description
			if( strict || tuple.getString("description") != null) this.setDescription(tuple.getString("description"));
			if( tuple.getString("Category_description") != null) this.setDescription(tuple.getString("Category_description"));
			//set ObservableFeature
			if( strict || tuple.getInt("observableFeature_id") != null) this.setObservableFeature(tuple.getInt("observableFeature_id"));
			if( tuple.getInt("Category_observableFeature_id") != null) this.setObservableFeature(tuple.getInt("Category_observableFeature_id"));
			//alias of xref
			if( tuple.getObject("observableFeature") != null) this.setObservableFeature(tuple.getInt("observableFeature"));
			if( tuple.getObject("Category_observableFeature") != null) this.setObservableFeature(tuple.getInt("Category_observableFeature"));
			//set label for field ObservableFeature
			if( strict || tuple.getObject("observableFeature_Identifier") != null) this.setObservableFeature_Identifier(tuple.getString("observableFeature_Identifier"));			
			if( tuple.getObject("Category_observableFeature_Identifier") != null ) this.setObservableFeature_Identifier(tuple.getString("Category_observableFeature_Identifier"));		
			//set ValueCode
			if( strict || tuple.getString("valueCode") != null) this.setValueCode(tuple.getString("valueCode"));
			if( tuple.getString("Category_valueCode") != null) this.setValueCode(tuple.getString("Category_valueCode"));
			//set IsMissing
			if( strict || tuple.getBoolean("isMissing") != null) this.setIsMissing(tuple.getBoolean("isMissing"));
			if( tuple.getBoolean("Category_isMissing") != null) this.setIsMissing(tuple.getBoolean("Category_isMissing"));
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
		String result = "Category(";
		result+= "id='" + getId()+"' ";	
		result+= "identifier='" + getIdentifier()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= "__Type='" + get__Type()+"' ";	
		result+= "description='" + getDescription()+"' ";	
		result+= " observableFeature_id='" + getObservableFeature_Id()+"' ";	
		result+= " observableFeature_identifier='" + getObservableFeature_Identifier()+"' ";
		result+= "valueCode='" + getValueCode()+"' ";	
		result+= "isMissing='" + getIsMissing()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Category.
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
			fields.add("observableFeature_id");
		}
		fields.add("observableFeature_identifier");
		{
			fields.add("valueCode");
		}
		{
			fields.add("isMissing");
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
		+ "__Type" +sep
		+ "description" +sep
		+ "observableFeature" +sep
		+ "valueCode" +sep
		+ "isMissing" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("observableFeature")) {
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
		Category rhs = (Category) obj;
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
			Object valueO = getObservableFeature();
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
			Object valueO = getValueCode();
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
			Object valueO = getIsMissing();
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
	public Category create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Category e = new Category();
		e.set(tuple);
		return e;
	}
	

	
}

