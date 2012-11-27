
/* File:        org.molgenis/model/Panel_Individuals.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.observ.target;

/**
 * Panel_Individuals: Link table for many-to-many relationship 'Panel.Individuals'..
 * @author MOLGENIS generator
 */
@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.observ.target.db.Panel_IndividualsEntityListener.class})
public class Panel_Individuals extends org.molgenis.util.AbstractEntity 
{
	// fieldname constants
	public final static String AUTOID = "autoid";
	public final static String INDIVIDUALS = "Individuals";
	public final static String INDIVIDUALS_IDENTIFIER = "Individuals_Identifier";
	public final static String PANEL = "Panel";
	public final static String PANEL_IDENTIFIER = "Panel_Identifier";
	
	//static methods
	/**
	 * Shorthand for db.query(Panel_Individuals.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Panel_Individuals> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Panel_Individuals.class);
	}
	
	/**
	 * Shorthand for db.find(Panel_Individuals.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Panel_Individuals> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Panel_Individuals.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Panel_Individuals findByAutoid(org.molgenis.framework.db.Database db, Integer autoid) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Panel_Individuals> q = db.query(Panel_Individuals.class);
		q.eq(Panel_Individuals.AUTOID, autoid);
		java.util.List<Panel_Individuals> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Panel_Individuals findByIndividualsPanel(org.molgenis.framework.db.Database db, Integer individuals, Integer panel) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Panel_Individuals> q = db.query(Panel_Individuals.class);
		q.eq(Panel_Individuals.INDIVIDUALS, individuals);q.eq(Panel_Individuals.PANEL, panel);
		java.util.List<Panel_Individuals> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//automatic id field to ensure ordering of mrefs[type=int]
    @javax.persistence.Id @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    @javax.persistence.Column(name="autoid", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="autoid")
	
	//@javax.validation.constraints.NotNull
	private Integer autoid =  null;


	//[type=xref]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Individuals", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.observ.target.Individual individuals = null;
	@javax.persistence.Transient
	private Integer individuals_id = null;	
	@javax.persistence.Transient
	private String individuals_Identifier = null;						


	//[type=xref]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Panel", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.observ.target.Panel panel = null;
	@javax.persistence.Transient
	private Integer panel_id = null;	
	@javax.persistence.Transient
	private String panel_Identifier = null;						

	//constructors
	public Panel_Individuals()
	{
	
	}
	
	//getters and setters
	/**
	 * Get the automatic id field to ensure ordering of mrefs.
	 * @return autoid.
	 */
	public Integer getAutoid()
	{
		return this.autoid;
	}
	
	
	/**
	 * Set the automatic id field to ensure ordering of mrefs.
	 * @param autoid
	 */
	public void setAutoid( Integer autoid)
	{
		this.autoid = autoid;
	}

	

	/**
	 * Get the .
	 * @return individuals.
	 */
	public org.molgenis.observ.target.Individual getIndividuals()
	{
		return this.individuals;
	}
	
	@Deprecated
	public org.molgenis.observ.target.Individual getIndividuals(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the .
	 * @param individuals
	 */
	public void setIndividuals( org.molgenis.observ.target.Individual individuals)
	{
		
		this.individuals = individuals;
	}

	
	
	/**
	 * Set foreign key for field individuals.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setIndividuals_Id(Integer individuals_id)
	{
		this.individuals_id = individuals_id;
	}	

	public void setIndividuals(Integer individuals_id)
	{
		this.individuals_id = individuals_id;
	}
	
	public Integer getIndividuals_Id()
	{
		
		if(individuals != null) 
		{
			return individuals.getId();
		}
		else
		{
			return individuals_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference Individuals to Individual.Id.
	 */
	public String getIndividuals_Identifier()
	{		
		//FIXME should we auto-load based on getIndividuals()?	
		if(individuals != null) {
			return individuals.getIdentifier();
		} else {
			return individuals_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Individuals to <a href="Individual.html#Id">Individual.Id</a>.
	 * Implies setIndividuals(null) until save
	 */
	public void setIndividuals_Identifier(String individuals_Identifier)
	{
		this.individuals_Identifier = individuals_Identifier;
	}		
	 
	

	/**
	 * Get the .
	 * @return panel.
	 */
	public org.molgenis.observ.target.Panel getPanel()
	{
		return this.panel;
	}
	
	@Deprecated
	public org.molgenis.observ.target.Panel getPanel(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the .
	 * @param panel
	 */
	public void setPanel( org.molgenis.observ.target.Panel panel)
	{
		
		this.panel = panel;
	}

	
	
	/**
	 * Set foreign key for field panel.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setPanel_Id(Integer panel_id)
	{
		this.panel_id = panel_id;
	}	

	public void setPanel(Integer panel_id)
	{
		this.panel_id = panel_id;
	}
	
	public Integer getPanel_Id()
	{
		
		if(panel != null) 
		{
			return panel.getId();
		}
		else
		{
			return panel_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference Panel to Panel.Id.
	 */
	public String getPanel_Identifier()
	{		
		//FIXME should we auto-load based on getPanel()?	
		if(panel != null) {
			return panel.getIdentifier();
		} else {
			return panel_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Panel to <a href="Panel.html#Id">Panel.Id</a>.
	 * Implies setPanel(null) until save
	 */
	public void setPanel_Identifier(String panel_Identifier)
	{
		this.panel_Identifier = panel_Identifier;
	}		
	 
	


	/**
	 * Generic getter. Get the property by using the name.
	 */
	public Object get(String name)
	{
		name = name.toLowerCase();
		if (name.toLowerCase().equals("autoid"))
			return getAutoid();
		if (name.toLowerCase().equals("individuals"))
			return getIndividuals();
		if(name.toLowerCase().equals("individuals_id"))
			return getIndividuals_Id();
		if(name.toLowerCase().equals("individuals_identifier"))
			return getIndividuals_Identifier();
		if (name.toLowerCase().equals("panel"))
			return getPanel();
		if(name.toLowerCase().equals("panel_id"))
			return getPanel_Id();
		if(name.toLowerCase().equals("panel_identifier"))
			return getPanel_Identifier();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getAutoid() == null) throw new org.molgenis.framework.db.DatabaseException("required field autoid is null");
		if(this.getIndividuals() == null) throw new org.molgenis.framework.db.DatabaseException("required field individuals is null");
		if(this.getPanel() == null) throw new org.molgenis.framework.db.DatabaseException("required field panel is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.util.Tuple tuple, boolean strict )  throws Exception
	{
		//optimization :-(
		if(tuple instanceof org.molgenis.util.ResultSetTuple)
		{
				//set Autoid
			this.setAutoid(tuple.getInt("autoid"));
			//set Individuals
			this.setIndividuals(tuple.getInt("Individuals"));
			//set label Identifier for xref field Individuals
			this.setIndividuals_Identifier(tuple.getString("Individuals_Identifier"));	
			//set Panel
			this.setPanel(tuple.getInt("Panel"));
			//set label Identifier for xref field Panel
			this.setPanel_Identifier(tuple.getString("Panel_Identifier"));	
		}
		else if(tuple != null)
		{
			//set Autoid
			if( strict || tuple.getInt("autoid") != null) this.setAutoid(tuple.getInt("autoid"));
			if( tuple.getInt("Panel_Individuals_autoid") != null) this.setAutoid(tuple.getInt("Panel_Individuals_autoid"));
			//set Individuals
			if( strict || tuple.getInt("Individuals_id") != null) this.setIndividuals(tuple.getInt("Individuals_id"));
			if( tuple.getInt("Panel_Individuals_Individuals_id") != null) this.setIndividuals(tuple.getInt("Panel_Individuals_Individuals_id"));
			//alias of xref
			if( tuple.getObject("Individuals") != null) this.setIndividuals(tuple.getInt("Individuals"));
			if( tuple.getObject("Panel_Individuals_Individuals") != null) this.setIndividuals(tuple.getInt("Panel_Individuals_Individuals"));
			//set label for field Individuals
			if( strict || tuple.getObject("Individuals_Identifier") != null) this.setIndividuals_Identifier(tuple.getString("Individuals_Identifier"));			
			if( tuple.getObject("Panel_Individuals_Individuals_Identifier") != null ) this.setIndividuals_Identifier(tuple.getString("Panel_Individuals_Individuals_Identifier"));		
			//set Panel
			if( strict || tuple.getInt("Panel_id") != null) this.setPanel(tuple.getInt("Panel_id"));
			if( tuple.getInt("Panel_Individuals_Panel_id") != null) this.setPanel(tuple.getInt("Panel_Individuals_Panel_id"));
			//alias of xref
			if( tuple.getObject("Panel") != null) this.setPanel(tuple.getInt("Panel"));
			if( tuple.getObject("Panel_Individuals_Panel") != null) this.setPanel(tuple.getInt("Panel_Individuals_Panel"));
			//set label for field Panel
			if( strict || tuple.getObject("Panel_Identifier") != null) this.setPanel_Identifier(tuple.getString("Panel_Identifier"));			
			if( tuple.getObject("Panel_Individuals_Panel_Identifier") != null ) this.setPanel_Identifier(tuple.getString("Panel_Individuals_Panel_Identifier"));		
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
		String result = "Panel_Individuals(";
		result+= "autoid='" + getAutoid()+"' ";	
		result+= " individuals_id='" + getIndividuals_Id()+"' ";	
		result+= " individuals_identifier='" + getIndividuals_Identifier()+"' ";
		result+= " panel_id='" + getPanel_Id()+"' ";	
		result+= " panel_identifier='" + getPanel_Identifier()+"' ";
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Panel_Individuals.
	 */
	public java.util.Vector<String> getFields(boolean skipAutoIds)
	{
		java.util.Vector<String> fields = new java.util.Vector<String>();
		if(!skipAutoIds)
		{
			fields.add("autoid");
		}
		{
			fields.add("individuals_id");
		}
		fields.add("individuals_identifier");
		{
			fields.add("panel_id");
		}
		fields.add("panel_identifier");
		return fields;
	}	

	public java.util.Vector<String> getFields()
	{
		return getFields(false);
	}

	@Override
	public String getIdField()
	{
		return "autoid";
	}
	

	
	@Override
	public java.util.List<String> getLabelFields()
	{
		java.util.List<String> result = new java.util.ArrayList<String>();
		result.add("Individuals");
		result.add("Panel");
		return result;
	}

	@Deprecated
	public String getFields(String sep)
	{
		return (""
		+ "autoid" +sep
		+ "individuals" +sep
		+ "panel" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("individuals")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("panel")) {
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
		Panel_Individuals rhs = (Panel_Individuals) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
		//individuals
		//panel
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
			Object valueO = getAutoid();
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
			Object valueO = getIndividuals();
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
			Object valueO = getPanel();
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
	public Panel_Individuals create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Panel_Individuals e = new Panel_Individuals();
		e.set(tuple);
		return e;
	}
	

	
}

