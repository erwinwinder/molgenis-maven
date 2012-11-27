
/* File:        org.molgenis/model/SelectionCriteria.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.gwascentral;

/**
 * SelectionCriteria: Create relationships between panels, founder panels,
				such as overlap,
				selection criteria, getting assayed panel from a
				sample panel, etc.
			
.
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "SelectionCriteria"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.gwascentral.db.SelectionCriteriaEntityListener.class})
public class SelectionCriteria extends org.molgenis.util.AbstractEntity implements org.molgenis.core.Autoid
{
	// fieldname constants
	public final static String ID = "id";
	public final static String SOURCEPANEL = "SourcePanel";
	public final static String SOURCEPANEL_IDENTIFIER = "SourcePanel_Identifier";
	public final static String TARGETPANEL = "TargetPanel";
	public final static String TARGETPANEL_IDENTIFIER = "TargetPanel_Identifier";
	public final static String NUMBEROFINDIVIDUALS = "NumberOfIndividuals";
	public final static String DETAILS = "Details";
	
	//static methods
	/**
	 * Shorthand for db.query(SelectionCriteria.class).
	 */
	public static org.molgenis.framework.db.Query<? extends SelectionCriteria> query(org.molgenis.framework.db.Database db)
	{
		return db.query(SelectionCriteria.class);
	}
	
	/**
	 * Shorthand for db.find(SelectionCriteria.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends SelectionCriteria> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(SelectionCriteria.class, rules);
	}	
	
	/**
	 * 
	 */
	public static SelectionCriteria findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<SelectionCriteria> q = db.query(SelectionCriteria.class);
		q.eq(SelectionCriteria.ID, id);
		java.util.List<SelectionCriteria> result = q.find();
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


	//SourcePanel[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="SourcePanel", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.observ.target.Panel sourcePanel = null;
	@javax.persistence.Transient
	private Integer sourcePanel_id = null;	
	@javax.persistence.Transient
	private String sourcePanel_Identifier = null;						


	//TargetPanel[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="TargetPanel", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.observ.target.Panel targetPanel = null;
	@javax.persistence.Transient
	private Integer targetPanel_id = null;	
	@javax.persistence.Transient
	private String targetPanel_Identifier = null;						


	//NumberOfIndividuals[type=int]
	@javax.persistence.Column(name="NumberOfIndividuals", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="numberOfIndividuals")
	
				

	@javax.validation.constraints.NotNull
	private Integer numberOfIndividuals =  null;


	//Details[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="Details", length=16777216, nullable=false)
	
				

	@javax.validation.constraints.NotNull
	private String details =  null;

	//constructors
	public SelectionCriteria()
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
	 * Get the SourcePanel.
	 * @return sourcePanel.
	 */
	public org.molgenis.observ.target.Panel getSourcePanel()
	{
		return this.sourcePanel;
	}
	
	@Deprecated
	public org.molgenis.observ.target.Panel getSourcePanel(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the SourcePanel.
	 * @param sourcePanel
	 */
	public void setSourcePanel( org.molgenis.observ.target.Panel sourcePanel)
	{
		
		this.sourcePanel = sourcePanel;
	}

	
	
	/**
	 * Set foreign key for field sourcePanel.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setSourcePanel_Id(Integer sourcePanel_id)
	{
		this.sourcePanel_id = sourcePanel_id;
	}	

	public void setSourcePanel(Integer sourcePanel_id)
	{
		this.sourcePanel_id = sourcePanel_id;
	}
	
	public Integer getSourcePanel_Id()
	{
		
		if(sourcePanel != null) 
		{
			return sourcePanel.getId();
		}
		else
		{
			return sourcePanel_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference SourcePanel to Panel.Id.
	 */
	public String getSourcePanel_Identifier()
	{		
		//FIXME should we auto-load based on getSourcePanel()?	
		if(sourcePanel != null) {
			return sourcePanel.getIdentifier();
		} else {
			return sourcePanel_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference SourcePanel to <a href="Panel.html#Id">Panel.Id</a>.
	 * Implies setSourcePanel(null) until save
	 */
	public void setSourcePanel_Identifier(String sourcePanel_Identifier)
	{
		this.sourcePanel_Identifier = sourcePanel_Identifier;
	}		
	 
	

	/**
	 * Get the TargetPanel.
	 * @return targetPanel.
	 */
	public org.molgenis.observ.target.Panel getTargetPanel()
	{
		return this.targetPanel;
	}
	
	@Deprecated
	public org.molgenis.observ.target.Panel getTargetPanel(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the TargetPanel.
	 * @param targetPanel
	 */
	public void setTargetPanel( org.molgenis.observ.target.Panel targetPanel)
	{
		
		this.targetPanel = targetPanel;
	}

	
	
	/**
	 * Set foreign key for field targetPanel.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setTargetPanel_Id(Integer targetPanel_id)
	{
		this.targetPanel_id = targetPanel_id;
	}	

	public void setTargetPanel(Integer targetPanel_id)
	{
		this.targetPanel_id = targetPanel_id;
	}
	
	public Integer getTargetPanel_Id()
	{
		
		if(targetPanel != null) 
		{
			return targetPanel.getId();
		}
		else
		{
			return targetPanel_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference TargetPanel to Panel.Id.
	 */
	public String getTargetPanel_Identifier()
	{		
		//FIXME should we auto-load based on getTargetPanel()?	
		if(targetPanel != null) {
			return targetPanel.getIdentifier();
		} else {
			return targetPanel_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference TargetPanel to <a href="Panel.html#Id">Panel.Id</a>.
	 * Implies setTargetPanel(null) until save
	 */
	public void setTargetPanel_Identifier(String targetPanel_Identifier)
	{
		this.targetPanel_Identifier = targetPanel_Identifier;
	}		
	 
	

	/**
	 * Get the NumberOfIndividuals.
	 * @return numberOfIndividuals.
	 */
	public Integer getNumberOfIndividuals()
	{
		return this.numberOfIndividuals;
	}
	
	@Deprecated
	public Integer getNumberOfIndividuals(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the NumberOfIndividuals.
	 * @param numberOfIndividuals
	 */
	public void setNumberOfIndividuals( Integer numberOfIndividuals)
	{
		
		this.numberOfIndividuals = numberOfIndividuals;
	}

	

	/**
	 * Get the Details.
	 * @return details.
	 */
	public String getDetails()
	{
		return this.details;
	}
	
	@Deprecated
	public String getDetails(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Details.
	 * @param details
	 */
	public void setDetails( String details)
	{
		
		this.details = details;
	}

	


	/**
	 * Generic getter. Get the property by using the name.
	 */
	public Object get(String name)
	{
		name = name.toLowerCase();
		if (name.toLowerCase().equals("id"))
			return getId();
		if (name.toLowerCase().equals("sourcepanel"))
			return getSourcePanel();
		if(name.toLowerCase().equals("sourcepanel_id"))
			return getSourcePanel_Id();
		if(name.toLowerCase().equals("sourcepanel_identifier"))
			return getSourcePanel_Identifier();
		if (name.toLowerCase().equals("targetpanel"))
			return getTargetPanel();
		if(name.toLowerCase().equals("targetpanel_id"))
			return getTargetPanel_Id();
		if(name.toLowerCase().equals("targetpanel_identifier"))
			return getTargetPanel_Identifier();
		if (name.toLowerCase().equals("numberofindividuals"))
			return getNumberOfIndividuals();
		if (name.toLowerCase().equals("details"))
			return getDetails();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getSourcePanel() == null) throw new org.molgenis.framework.db.DatabaseException("required field sourcePanel is null");
		if(this.getTargetPanel() == null) throw new org.molgenis.framework.db.DatabaseException("required field targetPanel is null");
		if(this.getNumberOfIndividuals() == null) throw new org.molgenis.framework.db.DatabaseException("required field numberOfIndividuals is null");
		if(this.getDetails() == null) throw new org.molgenis.framework.db.DatabaseException("required field details is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.util.Tuple tuple, boolean strict )  throws Exception
	{
		//optimization :-(
		if(tuple instanceof org.molgenis.util.ResultSetTuple)
		{
				//set Id
			this.setId(tuple.getInt("id"));
			//set SourcePanel
			this.setSourcePanel(tuple.getInt("SourcePanel"));
			//set label Identifier for xref field SourcePanel
			this.setSourcePanel_Identifier(tuple.getString("SourcePanel_Identifier"));	
			//set TargetPanel
			this.setTargetPanel(tuple.getInt("TargetPanel"));
			//set label Identifier for xref field TargetPanel
			this.setTargetPanel_Identifier(tuple.getString("TargetPanel_Identifier"));	
			//set NumberOfIndividuals
			this.setNumberOfIndividuals(tuple.getInt("NumberOfIndividuals"));
			//set Details
			this.setDetails(tuple.getString("Details"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("SelectionCriteria_id") != null) this.setId(tuple.getInt("SelectionCriteria_id"));
			//set SourcePanel
			if( strict || tuple.getInt("SourcePanel_id") != null) this.setSourcePanel(tuple.getInt("SourcePanel_id"));
			if( tuple.getInt("SelectionCriteria_SourcePanel_id") != null) this.setSourcePanel(tuple.getInt("SelectionCriteria_SourcePanel_id"));
			//alias of xref
			if( tuple.getObject("SourcePanel") != null) this.setSourcePanel(tuple.getInt("SourcePanel"));
			if( tuple.getObject("SelectionCriteria_SourcePanel") != null) this.setSourcePanel(tuple.getInt("SelectionCriteria_SourcePanel"));
			//set label for field SourcePanel
			if( strict || tuple.getObject("SourcePanel_Identifier") != null) this.setSourcePanel_Identifier(tuple.getString("SourcePanel_Identifier"));			
			if( tuple.getObject("SelectionCriteria_SourcePanel_Identifier") != null ) this.setSourcePanel_Identifier(tuple.getString("SelectionCriteria_SourcePanel_Identifier"));		
			//set TargetPanel
			if( strict || tuple.getInt("TargetPanel_id") != null) this.setTargetPanel(tuple.getInt("TargetPanel_id"));
			if( tuple.getInt("SelectionCriteria_TargetPanel_id") != null) this.setTargetPanel(tuple.getInt("SelectionCriteria_TargetPanel_id"));
			//alias of xref
			if( tuple.getObject("TargetPanel") != null) this.setTargetPanel(tuple.getInt("TargetPanel"));
			if( tuple.getObject("SelectionCriteria_TargetPanel") != null) this.setTargetPanel(tuple.getInt("SelectionCriteria_TargetPanel"));
			//set label for field TargetPanel
			if( strict || tuple.getObject("TargetPanel_Identifier") != null) this.setTargetPanel_Identifier(tuple.getString("TargetPanel_Identifier"));			
			if( tuple.getObject("SelectionCriteria_TargetPanel_Identifier") != null ) this.setTargetPanel_Identifier(tuple.getString("SelectionCriteria_TargetPanel_Identifier"));		
			//set NumberOfIndividuals
			if( strict || tuple.getInt("NumberOfIndividuals") != null) this.setNumberOfIndividuals(tuple.getInt("NumberOfIndividuals"));
			if( tuple.getInt("SelectionCriteria_NumberOfIndividuals") != null) this.setNumberOfIndividuals(tuple.getInt("SelectionCriteria_NumberOfIndividuals"));
			//set Details
			if( strict || tuple.getString("Details") != null) this.setDetails(tuple.getString("Details"));
			if( tuple.getString("SelectionCriteria_Details") != null) this.setDetails(tuple.getString("SelectionCriteria_Details"));
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
		String result = "SelectionCriteria(";
		result+= "id='" + getId()+"' ";	
		result+= " sourcePanel_id='" + getSourcePanel_Id()+"' ";	
		result+= " sourcePanel_identifier='" + getSourcePanel_Identifier()+"' ";
		result+= " targetPanel_id='" + getTargetPanel_Id()+"' ";	
		result+= " targetPanel_identifier='" + getTargetPanel_Identifier()+"' ";
		result+= "numberOfIndividuals='" + getNumberOfIndividuals()+"' ";	
		result+= "details='" + getDetails()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of SelectionCriteria.
	 */
	public java.util.Vector<String> getFields(boolean skipAutoIds)
	{
		java.util.Vector<String> fields = new java.util.Vector<String>();
		if(!skipAutoIds)
		{
			fields.add("id");
		}
		{
			fields.add("sourcePanel_id");
		}
		fields.add("sourcePanel_identifier");
		{
			fields.add("targetPanel_id");
		}
		fields.add("targetPanel_identifier");
		{
			fields.add("numberOfIndividuals");
		}
		{
			fields.add("details");
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
		+ "sourcePanel" +sep
		+ "targetPanel" +sep
		+ "numberOfIndividuals" +sep
		+ "details" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("sourcePanel")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("targetPanel")) {
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
		SelectionCriteria rhs = (SelectionCriteria) obj;
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
			Object valueO = getSourcePanel();
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
			Object valueO = getTargetPanel();
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
			Object valueO = getNumberOfIndividuals();
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
			Object valueO = getDetails();
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
	public SelectionCriteria create(org.molgenis.util.Tuple tuple) throws Exception
	{
		SelectionCriteria e = new SelectionCriteria();
		e.set(tuple);
		return e;
	}
	

	
}

