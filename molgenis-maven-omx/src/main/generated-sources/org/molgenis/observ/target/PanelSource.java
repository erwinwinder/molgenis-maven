
/* File:        org.molgenis/model/PanelSource.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.observ.target;

/**
 * PanelSource: PanelSources is partOf Panel to define how panels are
				related panels, founder panels,
				such as overlap,
				selection criteria,
				getting assayed panel from a
				sample panel, etc.
			
.
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "PanelSource"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.observ.target.db.PanelSourceEntityListener.class})
public class PanelSource extends org.molgenis.util.AbstractEntity implements org.molgenis.core.Autoid
{
	// fieldname constants
	public final static String ID = "id";
	public final static String CURRENTPANEL = "CurrentPanel";
	public final static String CURRENTPANEL_IDENTIFIER = "CurrentPanel_Identifier";
	public final static String SOURCEPANEL = "SourcePanel";
	public final static String SOURCEPANEL_IDENTIFIER = "SourcePanel_Identifier";
	public final static String NUMBEROFINDIVIDUALS = "NumberOfIndividuals";
	public final static String SELECTIONCRITERIA = "SelectionCriteria";
	
	//static methods
	/**
	 * Shorthand for db.query(PanelSource.class).
	 */
	public static org.molgenis.framework.db.Query<? extends PanelSource> query(org.molgenis.framework.db.Database db)
	{
		return db.query(PanelSource.class);
	}
	
	/**
	 * Shorthand for db.find(PanelSource.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends PanelSource> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(PanelSource.class, rules);
	}	
	
	/**
	 * 
	 */
	public static PanelSource findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<PanelSource> q = db.query(PanelSource.class);
		q.eq(PanelSource.ID, id);
		java.util.List<PanelSource> result = q.find();
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


	//Panel for which these sources are defined.[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="CurrentPanel", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.observ.target.Panel currentPanel = null;
	@javax.persistence.Transient
	private Integer currentPanel_id = null;	
	@javax.persistence.Transient
	private String currentPanel_Identifier = null;						


	//Source that contributed individuals to current panel[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="SourcePanel", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.observ.target.Panel sourcePanel = null;
	@javax.persistence.Transient
	private Integer sourcePanel_id = null;	
	@javax.persistence.Transient
	private String sourcePanel_Identifier = null;						


	//Number of individuals lifted over from this source[type=int]
	@javax.persistence.Column(name="NumberOfIndividuals")
	@javax.xml.bind.annotation.XmlElement(name="numberOfIndividuals")
	
				

	private Integer numberOfIndividuals =  null;


	//Inclusion/exclusion criteria used to select these individuals from source into current panel[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="SelectionCriteria", length=16777216, nullable=false)
	
				

	@javax.validation.constraints.NotNull
	private String selectionCriteria =  null;

	//constructors
	public PanelSource()
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
	 * Get the Panel for which these sources are defined..
	 * @return currentPanel.
	 */
	public org.molgenis.observ.target.Panel getCurrentPanel()
	{
		return this.currentPanel;
	}
	
	@Deprecated
	public org.molgenis.observ.target.Panel getCurrentPanel(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Panel for which these sources are defined..
	 * @param currentPanel
	 */
	public void setCurrentPanel( org.molgenis.observ.target.Panel currentPanel)
	{
		
		this.currentPanel = currentPanel;
	}

	
	
	/**
	 * Set foreign key for field currentPanel.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setCurrentPanel_Id(Integer currentPanel_id)
	{
		this.currentPanel_id = currentPanel_id;
	}	

	public void setCurrentPanel(Integer currentPanel_id)
	{
		this.currentPanel_id = currentPanel_id;
	}
	
	public Integer getCurrentPanel_Id()
	{
		
		if(currentPanel != null) 
		{
			return currentPanel.getId();
		}
		else
		{
			return currentPanel_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference CurrentPanel to Panel.Id.
	 */
	public String getCurrentPanel_Identifier()
	{		
		//FIXME should we auto-load based on getCurrentPanel()?	
		if(currentPanel != null) {
			return currentPanel.getIdentifier();
		} else {
			return currentPanel_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference CurrentPanel to <a href="Panel.html#Id">Panel.Id</a>.
	 * Implies setCurrentPanel(null) until save
	 */
	public void setCurrentPanel_Identifier(String currentPanel_Identifier)
	{
		this.currentPanel_Identifier = currentPanel_Identifier;
	}		
	 
	

	/**
	 * Get the Source that contributed individuals to current panel.
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
	 * Set the Source that contributed individuals to current panel.
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
	 * Get the Number of individuals lifted over from this source.
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
	 * Set the Number of individuals lifted over from this source.
	 * @param numberOfIndividuals
	 */
	public void setNumberOfIndividuals( Integer numberOfIndividuals)
	{
		
		this.numberOfIndividuals = numberOfIndividuals;
	}

	

	/**
	 * Get the Inclusion/exclusion criteria used to select these individuals from source into current panel.
	 * @return selectionCriteria.
	 */
	public String getSelectionCriteria()
	{
		return this.selectionCriteria;
	}
	
	@Deprecated
	public String getSelectionCriteria(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Inclusion/exclusion criteria used to select these individuals from source into current panel.
	 * @param selectionCriteria
	 */
	public void setSelectionCriteria( String selectionCriteria)
	{
		
		this.selectionCriteria = selectionCriteria;
	}

	


	/**
	 * Generic getter. Get the property by using the name.
	 */
	public Object get(String name)
	{
		name = name.toLowerCase();
		if (name.toLowerCase().equals("id"))
			return getId();
		if (name.toLowerCase().equals("currentpanel"))
			return getCurrentPanel();
		if(name.toLowerCase().equals("currentpanel_id"))
			return getCurrentPanel_Id();
		if(name.toLowerCase().equals("currentpanel_identifier"))
			return getCurrentPanel_Identifier();
		if (name.toLowerCase().equals("sourcepanel"))
			return getSourcePanel();
		if(name.toLowerCase().equals("sourcepanel_id"))
			return getSourcePanel_Id();
		if(name.toLowerCase().equals("sourcepanel_identifier"))
			return getSourcePanel_Identifier();
		if (name.toLowerCase().equals("numberofindividuals"))
			return getNumberOfIndividuals();
		if (name.toLowerCase().equals("selectioncriteria"))
			return getSelectionCriteria();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getCurrentPanel() == null) throw new org.molgenis.framework.db.DatabaseException("required field currentPanel is null");
		if(this.getSourcePanel() == null) throw new org.molgenis.framework.db.DatabaseException("required field sourcePanel is null");
		if(this.getSelectionCriteria() == null) throw new org.molgenis.framework.db.DatabaseException("required field selectionCriteria is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.util.Tuple tuple, boolean strict )  throws Exception
	{
		//optimization :-(
		if(tuple instanceof org.molgenis.util.ResultSetTuple)
		{
				//set Id
			this.setId(tuple.getInt("id"));
			//set CurrentPanel
			this.setCurrentPanel(tuple.getInt("CurrentPanel"));
			//set label Identifier for xref field CurrentPanel
			this.setCurrentPanel_Identifier(tuple.getString("CurrentPanel_Identifier"));	
			//set SourcePanel
			this.setSourcePanel(tuple.getInt("SourcePanel"));
			//set label Identifier for xref field SourcePanel
			this.setSourcePanel_Identifier(tuple.getString("SourcePanel_Identifier"));	
			//set NumberOfIndividuals
			this.setNumberOfIndividuals(tuple.getInt("NumberOfIndividuals"));
			//set SelectionCriteria
			this.setSelectionCriteria(tuple.getString("SelectionCriteria"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("PanelSource_id") != null) this.setId(tuple.getInt("PanelSource_id"));
			//set CurrentPanel
			if( strict || tuple.getInt("CurrentPanel_id") != null) this.setCurrentPanel(tuple.getInt("CurrentPanel_id"));
			if( tuple.getInt("PanelSource_CurrentPanel_id") != null) this.setCurrentPanel(tuple.getInt("PanelSource_CurrentPanel_id"));
			//alias of xref
			if( tuple.getObject("CurrentPanel") != null) this.setCurrentPanel(tuple.getInt("CurrentPanel"));
			if( tuple.getObject("PanelSource_CurrentPanel") != null) this.setCurrentPanel(tuple.getInt("PanelSource_CurrentPanel"));
			//set label for field CurrentPanel
			if( strict || tuple.getObject("CurrentPanel_Identifier") != null) this.setCurrentPanel_Identifier(tuple.getString("CurrentPanel_Identifier"));			
			if( tuple.getObject("PanelSource_CurrentPanel_Identifier") != null ) this.setCurrentPanel_Identifier(tuple.getString("PanelSource_CurrentPanel_Identifier"));		
			//set SourcePanel
			if( strict || tuple.getInt("SourcePanel_id") != null) this.setSourcePanel(tuple.getInt("SourcePanel_id"));
			if( tuple.getInt("PanelSource_SourcePanel_id") != null) this.setSourcePanel(tuple.getInt("PanelSource_SourcePanel_id"));
			//alias of xref
			if( tuple.getObject("SourcePanel") != null) this.setSourcePanel(tuple.getInt("SourcePanel"));
			if( tuple.getObject("PanelSource_SourcePanel") != null) this.setSourcePanel(tuple.getInt("PanelSource_SourcePanel"));
			//set label for field SourcePanel
			if( strict || tuple.getObject("SourcePanel_Identifier") != null) this.setSourcePanel_Identifier(tuple.getString("SourcePanel_Identifier"));			
			if( tuple.getObject("PanelSource_SourcePanel_Identifier") != null ) this.setSourcePanel_Identifier(tuple.getString("PanelSource_SourcePanel_Identifier"));		
			//set NumberOfIndividuals
			if( strict || tuple.getInt("NumberOfIndividuals") != null) this.setNumberOfIndividuals(tuple.getInt("NumberOfIndividuals"));
			if( tuple.getInt("PanelSource_NumberOfIndividuals") != null) this.setNumberOfIndividuals(tuple.getInt("PanelSource_NumberOfIndividuals"));
			//set SelectionCriteria
			if( strict || tuple.getString("SelectionCriteria") != null) this.setSelectionCriteria(tuple.getString("SelectionCriteria"));
			if( tuple.getString("PanelSource_SelectionCriteria") != null) this.setSelectionCriteria(tuple.getString("PanelSource_SelectionCriteria"));
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
		String result = "PanelSource(";
		result+= "id='" + getId()+"' ";	
		result+= " currentPanel_id='" + getCurrentPanel_Id()+"' ";	
		result+= " currentPanel_identifier='" + getCurrentPanel_Identifier()+"' ";
		result+= " sourcePanel_id='" + getSourcePanel_Id()+"' ";	
		result+= " sourcePanel_identifier='" + getSourcePanel_Identifier()+"' ";
		result+= "numberOfIndividuals='" + getNumberOfIndividuals()+"' ";	
		result+= "selectionCriteria='" + getSelectionCriteria()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of PanelSource.
	 */
	public java.util.Vector<String> getFields(boolean skipAutoIds)
	{
		java.util.Vector<String> fields = new java.util.Vector<String>();
		if(!skipAutoIds)
		{
			fields.add("id");
		}
		{
			fields.add("currentPanel_id");
		}
		fields.add("currentPanel_identifier");
		{
			fields.add("sourcePanel_id");
		}
		fields.add("sourcePanel_identifier");
		{
			fields.add("numberOfIndividuals");
		}
		{
			fields.add("selectionCriteria");
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
		+ "currentPanel" +sep
		+ "sourcePanel" +sep
		+ "numberOfIndividuals" +sep
		+ "selectionCriteria" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("currentPanel")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("sourcePanel")) {
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
		PanelSource rhs = (PanelSource) obj;
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
			Object valueO = getCurrentPanel();
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
			Object valueO = getSelectionCriteria();
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
	public PanelSource create(org.molgenis.util.Tuple tuple) throws Exception
	{
		PanelSource e = new PanelSource();
		e.set(tuple);
		return e;
	}
	

	
}

