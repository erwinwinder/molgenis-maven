
/* File:        org.molgenis/model/Panel.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.observ.target;

/**
 * Panel: The Panel class defines groups of individuals based on
				cohort design, case/controls, families, etc. For instance:
				'LifeLines
				cohort', 'middle aged man', 'recombinant mouse inbred Line
				dba x b6'
				or 'Smith family'. A Panel can act as a single
				ObservationTarget.
				For example: average height (Measurement) in the
				LifeLines cohort
				(Panel) is 174cm (ObservedValue). The Panel class
				maps to XGAP:Strain and PaGE:Panel
				classes. In METABASE this is
				assumed there is one panel per study.
			
.
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "Panel"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.observ.target.db.PanelEntityListener.class})
public class Panel extends org.molgenis.observ.ObservationTarget 
{
	// fieldname constants
	public final static String PANELTYPE = "PanelType";
	public final static String PANELTYPE_IDENTIFIER = "PanelType_Identifier";
	public final static String NUMBEROFINDIVIDUALS = "NumberOfIndividuals";
	public final static String SPECIES = "Species";
	public final static String SPECIES_IDENTIFIER = "Species_Identifier";
	public final static String INDIVIDUALS = "Individuals";
	public final static String INDIVIDUALS_IDENTIFIER = "Individuals_Identifier";
	public final static String ID = "id";
	
	//static methods
	/**
	 * Shorthand for db.query(Panel.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Panel> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Panel.class);
	}
	
	/**
	 * Shorthand for db.find(Panel.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Panel> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Panel.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Panel findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Panel> q = db.query(Panel.class);
		q.eq(Panel.ID, id);
		java.util.List<Panel> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Panel findByIdentifier(org.molgenis.framework.db.Database db, String identifier) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Panel> q = db.query(Panel.class);
		q.eq(Panel.IDENTIFIER, identifier);
		java.util.List<Panel> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//Indicate the type of Panel (example: Sample panel, AssayedPanel, Natural=wild type, Parental=parents of a cross, F1=First generation of cross, RCC=Recombinant congenic, CSS=chromosome substitution)[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="PanelType")   	
	
				

	private org.molgenis.observ.target.OntologyTerm panelType = null;
	@javax.persistence.Transient
	private Integer panelType_id = null;	
	@javax.persistence.Transient
	private String panelType_Identifier = null;						


	//NumberOfIndividuals[type=int]
	@javax.persistence.Column(name="NumberOfIndividuals", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="numberOfIndividuals")
	
				

	@javax.validation.constraints.NotNull
	private Integer numberOfIndividuals =  null;


	//The species this panel is an instance of/part of/extracted from.[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Species")   	
	
				

	private org.molgenis.observ.target.Species species = null;
	@javax.persistence.Transient
	private Integer species_id = null;	
	@javax.persistence.Transient
	private String species_Identifier = null;						


	//The list of individuals in this panel[type=mref]
    @javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Individuals", insertable=true, updatable=true, nullable=true)
	@javax.persistence.JoinTable(name="Panel_Individuals", 
			joinColumns=@javax.persistence.JoinColumn(name="Panel"), inverseJoinColumns=@javax.persistence.JoinColumn(name="Individuals"))
	
				

	private java.util.List<org.molgenis.observ.target.Individual> individuals = new java.util.ArrayList<org.molgenis.observ.target.Individual>();
	@javax.persistence.Transient
	private java.util.List<Integer> individuals_id = new java.util.ArrayList<Integer>();		
	@javax.persistence.Transient
	private java.util.List<String> individuals_Identifier = new java.util.ArrayList<String>();


	//automatically generated internal id, only for internal use.[type=int]
	

	//constructors
	public Panel()
	{
		//set the type for a new instance
		set__Type(this.getClass().getSimpleName());
	
	}
	
	//getters and setters
	/**
	 * Get the Indicate the type of Panel (example: Sample panel, AssayedPanel, Natural=wild type, Parental=parents of a cross, F1=First generation of cross, RCC=Recombinant congenic, CSS=chromosome substitution).
	 * @return panelType.
	 */
	public org.molgenis.observ.target.OntologyTerm getPanelType()
	{
		return this.panelType;
	}
	
	@Deprecated
	public org.molgenis.observ.target.OntologyTerm getPanelType(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Indicate the type of Panel (example: Sample panel, AssayedPanel, Natural=wild type, Parental=parents of a cross, F1=First generation of cross, RCC=Recombinant congenic, CSS=chromosome substitution).
	 * @param panelType
	 */
	public void setPanelType( org.molgenis.observ.target.OntologyTerm panelType)
	{
		
		this.panelType = panelType;
	}

	
	
	/**
	 * Set foreign key for field panelType.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setPanelType_Id(Integer panelType_id)
	{
		this.panelType_id = panelType_id;
	}	

	public void setPanelType(Integer panelType_id)
	{
		this.panelType_id = panelType_id;
	}
	
	public Integer getPanelType_Id()
	{
		
		if(panelType != null) 
		{
			return panelType.getId();
		}
		else
		{
			return panelType_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference PanelType to OntologyTerm.Id.
	 */
	public String getPanelType_Identifier()
	{		
		//FIXME should we auto-load based on getPanelType()?	
		if(panelType != null) {
			return panelType.getIdentifier();
		} else {
			return panelType_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference PanelType to <a href="OntologyTerm.html#Id">OntologyTerm.Id</a>.
	 * Implies setPanelType(null) until save
	 */
	public void setPanelType_Identifier(String panelType_Identifier)
	{
		this.panelType_Identifier = panelType_Identifier;
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
	 * Get the The species this panel is an instance of/part of/extracted from..
	 * @return species.
	 */
	public org.molgenis.observ.target.Species getSpecies()
	{
		return this.species;
	}
	
	@Deprecated
	public org.molgenis.observ.target.Species getSpecies(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the The species this panel is an instance of/part of/extracted from..
	 * @param species
	 */
	public void setSpecies( org.molgenis.observ.target.Species species)
	{
		
		this.species = species;
	}

	
	
	/**
	 * Set foreign key for field species.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setSpecies_Id(Integer species_id)
	{
		this.species_id = species_id;
	}	

	public void setSpecies(Integer species_id)
	{
		this.species_id = species_id;
	}
	
	public Integer getSpecies_Id()
	{
		
		if(species != null) 
		{
			return species.getId();
		}
		else
		{
			return species_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference Species to Species.Id.
	 */
	public String getSpecies_Identifier()
	{		
		//FIXME should we auto-load based on getSpecies()?	
		if(species != null) {
			return species.getIdentifier();
		} else {
			return species_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Species to <a href="Species.html#Id">Species.Id</a>.
	 * Implies setSpecies(null) until save
	 */
	public void setSpecies_Identifier(String species_Identifier)
	{
		this.species_Identifier = species_Identifier;
	}		
	 
	

	/**
	 * Get the The list of individuals in this panel.
	 * @return individuals.
	 */
	public java.util.List<org.molgenis.observ.target.Individual> getIndividuals()
	{
		return this.individuals;
	}
	
	@Deprecated
	public java.util.List<org.molgenis.observ.target.Individual> getIndividuals(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the The list of individuals in this panel.
	 * @param individuals
	 */
	public void setIndividuals( java.util.List<org.molgenis.observ.target.Individual> individuals)
	{
		
		this.individuals = individuals;
	}

	
	public void setIndividuals_Id(Integer ... individuals)
	{
		this.setIndividuals_Id(java.util.Arrays.asList(individuals));
	}	
	
	public void setIndividuals(org.molgenis.observ.target.Individual ... individuals)
	{
		this.setIndividuals(java.util.Arrays.asList(individuals));
	}	
	
	/**
	 * Set foreign key for field individuals.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setIndividuals_Id(java.util.List<Integer> individuals_id)
	{
		this.individuals_id = individuals_id;
	}	
	
	public java.util.List<Integer> getIndividuals_Id()
	{
		return individuals_id;
	}	
	
	/**
	 * Get a pretty label for cross reference Individuals to <a href="Individual.html#Id">Individual.Id</a>.
	 */
	public java.util.List<String> getIndividuals_Identifier()
	{
		return individuals_Identifier;
	}
	
	/**
	 * Update the foreign key Individuals
	 * This sets individuals to null until next database transaction.
	 */
	public void setIndividuals_Identifier(java.util.List<String> individuals_Identifier)
	{
		this.individuals_Identifier = individuals_Identifier;
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
		if (name.toLowerCase().equals("paneltype"))
			return getPanelType();
		if(name.toLowerCase().equals("paneltype_id"))
			return getPanelType_Id();
		if(name.toLowerCase().equals("paneltype_identifier"))
			return getPanelType_Identifier();
		if (name.toLowerCase().equals("numberofindividuals"))
			return getNumberOfIndividuals();
		if (name.toLowerCase().equals("species"))
			return getSpecies();
		if(name.toLowerCase().equals("species_id"))
			return getSpecies_Id();
		if(name.toLowerCase().equals("species_identifier"))
			return getSpecies_Identifier();
		if (name.toLowerCase().equals("individuals"))
			return getIndividuals();
		if(name.toLowerCase().equals("individuals_id"))
			return getIndividuals_Id();
		if(name.toLowerCase().equals("individuals_identifier"))
			return getIndividuals_Identifier();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getIdentifier() == null) throw new org.molgenis.framework.db.DatabaseException("required field identifier is null");
		if(this.getName() == null) throw new org.molgenis.framework.db.DatabaseException("required field name is null");
		if(this.get__Type() == null) throw new org.molgenis.framework.db.DatabaseException("required field __Type is null");
		if(this.getNumberOfIndividuals() == null) throw new org.molgenis.framework.db.DatabaseException("required field numberOfIndividuals is null");
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
			//set PanelType
			this.setPanelType(tuple.getInt("PanelType"));
			//set label Identifier for xref field PanelType
			this.setPanelType_Identifier(tuple.getString("PanelType_Identifier"));	
			//set NumberOfIndividuals
			this.setNumberOfIndividuals(tuple.getInt("NumberOfIndividuals"));
			//set Species
			this.setSpecies(tuple.getInt("Species"));
			//set label Identifier for xref field Species
			this.setSpecies_Identifier(tuple.getString("Species_Identifier"));	
			//mrefs can not be directly retrieved
			//set Individuals			
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("Panel_id") != null) this.setId(tuple.getInt("Panel_id"));
			//set Identifier
			if( strict || tuple.getString("Identifier") != null) this.setIdentifier(tuple.getString("Identifier"));
			if( tuple.getString("Panel_Identifier") != null) this.setIdentifier(tuple.getString("Panel_Identifier"));
			//set Name
			if( strict || tuple.getString("Name") != null) this.setName(tuple.getString("Name"));
			if( tuple.getString("Panel_Name") != null) this.setName(tuple.getString("Panel_Name"));
			//set __Type
			if( strict || tuple.getString("__Type") != null) this.set__Type(tuple.getString("__Type"));
			if( tuple.getString("Panel___Type") != null) this.set__Type(tuple.getString("Panel___Type"));
			//set Description
			if( strict || tuple.getString("description") != null) this.setDescription(tuple.getString("description"));
			if( tuple.getString("Panel_description") != null) this.setDescription(tuple.getString("Panel_description"));
			//set PanelType
			if( strict || tuple.getInt("PanelType_id") != null) this.setPanelType(tuple.getInt("PanelType_id"));
			if( tuple.getInt("Panel_PanelType_id") != null) this.setPanelType(tuple.getInt("Panel_PanelType_id"));
			//alias of xref
			if( tuple.getObject("PanelType") != null) this.setPanelType(tuple.getInt("PanelType"));
			if( tuple.getObject("Panel_PanelType") != null) this.setPanelType(tuple.getInt("Panel_PanelType"));
			//set label for field PanelType
			if( strict || tuple.getObject("PanelType_Identifier") != null) this.setPanelType_Identifier(tuple.getString("PanelType_Identifier"));			
			if( tuple.getObject("Panel_PanelType_Identifier") != null ) this.setPanelType_Identifier(tuple.getString("Panel_PanelType_Identifier"));		
			//set NumberOfIndividuals
			if( strict || tuple.getInt("NumberOfIndividuals") != null) this.setNumberOfIndividuals(tuple.getInt("NumberOfIndividuals"));
			if( tuple.getInt("Panel_NumberOfIndividuals") != null) this.setNumberOfIndividuals(tuple.getInt("Panel_NumberOfIndividuals"));
			//set Species
			if( strict || tuple.getInt("Species_id") != null) this.setSpecies(tuple.getInt("Species_id"));
			if( tuple.getInt("Panel_Species_id") != null) this.setSpecies(tuple.getInt("Panel_Species_id"));
			//alias of xref
			if( tuple.getObject("Species") != null) this.setSpecies(tuple.getInt("Species"));
			if( tuple.getObject("Panel_Species") != null) this.setSpecies(tuple.getInt("Panel_Species"));
			//set label for field Species
			if( strict || tuple.getObject("Species_Identifier") != null) this.setSpecies_Identifier(tuple.getString("Species_Identifier"));			
			if( tuple.getObject("Panel_Species_Identifier") != null ) this.setSpecies_Identifier(tuple.getString("Panel_Species_Identifier"));		
			//set Individuals
			if( tuple.getObject("Individuals")!= null || tuple.getObject("Panel_Individuals")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("Individuals");
				if(tuple.getObject("Panel_Individuals")!= null) mrefs = tuple.getList("Panel_Individuals");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setIndividuals_Id( values );
			}
			//set labels Identifier for mref field Individuals	
			if( tuple.getObject("Individuals_Identifier")!= null || tuple.getObject("Panel_Individuals_Identifier")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("Individuals_Identifier");
				if(tuple.getObject("Panel_Individuals_Identifier")!= null) mrefs = tuple.getList("Panel_Individuals_Identifier");
				
				if(mrefs != null) 
					for(Object ref: mrefs)
					{
						String[] refs = ref.toString().split("\\|");
						for(String r : refs) {
							values.add(r);	
						}						
					}							
				this.setIndividuals_Identifier( values );			
			}	
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
		String result = "Panel(";
		result+= "id='" + getId()+"' ";	
		result+= "identifier='" + getIdentifier()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= "__Type='" + get__Type()+"' ";	
		result+= "description='" + getDescription()+"' ";	
		result+= " panelType_id='" + getPanelType_Id()+"' ";	
		result+= " panelType_identifier='" + getPanelType_Identifier()+"' ";
		result+= "numberOfIndividuals='" + getNumberOfIndividuals()+"' ";	
		result+= " species_id='" + getSpecies_Id()+"' ";	
		result+= " species_identifier='" + getSpecies_Identifier()+"' ";
		result+= " individuals_id='" + getIndividuals_Id()+"' ";	
		result+= " individuals_identifier='" + getIndividuals_Identifier()+"' ";
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Panel.
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
			fields.add("panelType_id");
		}
		fields.add("panelType_identifier");
		{
			fields.add("numberOfIndividuals");
		}
		{
			fields.add("species_id");
		}
		fields.add("species_identifier");
		{
			fields.add("individuals_id");
		}
		fields.add("individuals_identifier");
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
		+ "panelType" +sep
		+ "numberOfIndividuals" +sep
		+ "species" +sep
		+ "individuals" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("panelType")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("species")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("individuals")) {
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
		Panel rhs = (Panel) obj;
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
			Object valueO = getPanelType();
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
			Object valueO = getSpecies();
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
			out.write(valueS);
		}
		return out.toString();
	}
	
	@Override
	public Panel create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Panel e = new Panel();
		e.set(tuple);
		return e;
	}
	
//7
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="currentPanel"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.observ.target.PanelSource> currentPanelPanelSourceCollection = new java.util.ArrayList<org.molgenis.observ.target.PanelSource>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.observ.target.PanelSource> getCurrentPanelPanelSourceCollection()
	{
            return currentPanelPanelSourceCollection;
	}

    public void setCurrentPanelPanelSourceCollection(java.util.Collection<org.molgenis.observ.target.PanelSource> collection)
    {
        for (org.molgenis.observ.target.PanelSource panelSource : collection) {
            panelSource.setCurrentPanel(this);
        }
        currentPanelPanelSourceCollection = collection;
    }	
//7
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="sourcePanel"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.observ.target.PanelSource> sourcePanelPanelSourceCollection = new java.util.ArrayList<org.molgenis.observ.target.PanelSource>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.observ.target.PanelSource> getSourcePanelPanelSourceCollection()
	{
            return sourcePanelPanelSourceCollection;
	}

    public void setSourcePanelPanelSourceCollection(java.util.Collection<org.molgenis.observ.target.PanelSource> collection)
    {
        for (org.molgenis.observ.target.PanelSource panelSource : collection) {
            panelSource.setSourcePanel(this);
        }
        sourcePanelPanelSourceCollection = collection;
    }	
//7
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="sourcePanel"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.gwascentral.SelectionCriteria> sourcePanelSelectionCriteriaCollection = new java.util.ArrayList<org.molgenis.gwascentral.SelectionCriteria>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.gwascentral.SelectionCriteria> getSourcePanelSelectionCriteriaCollection()
	{
            return sourcePanelSelectionCriteriaCollection;
	}

    public void setSourcePanelSelectionCriteriaCollection(java.util.Collection<org.molgenis.gwascentral.SelectionCriteria> collection)
    {
        for (org.molgenis.gwascentral.SelectionCriteria selectionCriteria : collection) {
            selectionCriteria.setSourcePanel(this);
        }
        sourcePanelSelectionCriteriaCollection = collection;
    }	
//7
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="targetPanel"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.gwascentral.SelectionCriteria> targetPanelSelectionCriteriaCollection = new java.util.ArrayList<org.molgenis.gwascentral.SelectionCriteria>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.gwascentral.SelectionCriteria> getTargetPanelSelectionCriteriaCollection()
	{
            return targetPanelSelectionCriteriaCollection;
	}

    public void setTargetPanelSelectionCriteriaCollection(java.util.Collection<org.molgenis.gwascentral.SelectionCriteria> collection)
    {
        for (org.molgenis.gwascentral.SelectionCriteria selectionCriteria : collection) {
            selectionCriteria.setTargetPanel(this);
        }
        targetPanelSelectionCriteriaCollection = collection;
    }	
	//7
    @javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="assayedPanels"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.organization.Experiment> assayedPanelsExperimentCollection = new java.util.ArrayList<org.molgenis.organization.Experiment>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.organization.Experiment> getAssayedPanelsExperimentCollection()
	{
        return assayedPanelsExperimentCollection;
	}

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.organization.Experiment> getAssayedPanelsExperimentCollection(org.molgenis.framework.db.Database db)
	{
        return getAssayedPanelsExperimentCollection();
	}

    public void setAssayedPanelsExperimentCollection(java.util.Collection<org.molgenis.organization.Experiment> collection)
    {
    	assayedPanelsExperimentCollection.addAll(collection);
    }	

	
}

