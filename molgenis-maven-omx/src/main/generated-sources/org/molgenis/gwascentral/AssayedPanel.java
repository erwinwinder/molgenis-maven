
/* File:        org.molgenis/model/AssayedPanel.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.gwascentral;

/**
 * AssayedPanel: .
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "AssayedPanel", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "Identifier" } ) }
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.gwascentral.db.AssayedPanelEntityListener.class})
public class AssayedPanel extends org.molgenis.observ.target.Panel implements org.molgenis.core.Identifiable
{
	// fieldname constants
	public final static String ID = "id";
	public final static String IDENTIFIER = "Identifier";
	public final static String NAME = "Name";
	public final static String DESCRIPTION = "Description";
	public final static String TOTALNUMBEROFINDIVIDUALS = "TotalNumberOfIndividuals";
	public final static String NUMBEROFSEXMALE = "NumberOfSexMale";
	public final static String NUMBEROFSEXFEMALE = "NumberOfSexFemale";
	public final static String NUMBEROFSEXUNKNOWN = "NumberOfSexUnknown";
	public final static String NUMBEROFPROBANDS = "NumberOfProbands";
	public final static String NUMBEROFPARENTS = "NumberOfParents";
	
	//static methods
	/**
	 * Shorthand for db.query(AssayedPanel.class).
	 */
	public static org.molgenis.framework.db.Query<? extends AssayedPanel> query(org.molgenis.framework.db.Database db)
	{
		return db.query(AssayedPanel.class);
	}
	
	/**
	 * Shorthand for db.find(AssayedPanel.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends AssayedPanel> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(AssayedPanel.class, rules);
	}	
	
	/**
	 * 
	 */
	public static AssayedPanel findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<AssayedPanel> q = db.query(AssayedPanel.class);
		q.eq(AssayedPanel.ID, id);
		java.util.List<AssayedPanel> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static AssayedPanel findByIdentifier(org.molgenis.framework.db.Database db, String identifier) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<AssayedPanel> q = db.query(AssayedPanel.class);
		q.eq(AssayedPanel.IDENTIFIER, identifier);
		java.util.List<AssayedPanel> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//automatically generated internal id, only for internal use.[type=int]
	


	//user supplied or automatically assigned (using a decorator) unique and short identifier, e.g. MA1234[type=string]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="Identifier", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="identifier")
	
				

	@javax.validation.constraints.NotNull
	private String identifier =  null;


	//Name[type=string]
	@javax.persistence.Column(name="Name")
	@javax.xml.bind.annotation.XmlElement(name="name")
	
				

	private String name =  null;


	//Description[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="Description", length=16777216)
	
				

	private String description =  null;


	//*...but required for association datasets[type=int]
	@javax.persistence.Column(name="TotalNumberOfIndividuals")
	@javax.xml.bind.annotation.XmlElement(name="totalNumberOfIndividuals")
	
				

	private Integer totalNumberOfIndividuals =  null;


	//Number of males[type=int]
	@javax.persistence.Column(name="NumberOfSexMale")
	@javax.xml.bind.annotation.XmlElement(name="numberOfSexMale")
	
				

	private Integer numberOfSexMale =  null;


	//Number of females[type=int]
	@javax.persistence.Column(name="NumberOfSexFemale")
	@javax.xml.bind.annotation.XmlElement(name="numberOfSexFemale")
	
				

	private Integer numberOfSexFemale =  null;


	//Number of unknown sex[type=int]
	@javax.persistence.Column(name="NumberOfSexUnknown")
	@javax.xml.bind.annotation.XmlElement(name="numberOfSexUnknown")
	
				

	private Integer numberOfSexUnknown =  null;


	//field used only if Composition = 'Trios'[type=int]
	@javax.persistence.Column(name="NumberOfProbands")
	@javax.xml.bind.annotation.XmlElement(name="numberOfProbands")
	
				

	private Integer numberOfProbands =  null;


	//field used only if Composition = 'Trios'[type=int]
	@javax.persistence.Column(name="NumberOfParents")
	@javax.xml.bind.annotation.XmlElement(name="numberOfParents")
	
				

	private Integer numberOfParents =  null;

	//constructors
	public AssayedPanel()
	{
		//set the type for a new instance
		set__Type(this.getClass().getSimpleName());
	
	}
	
	//getters and setters
	

	

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
				//hack to solve problem with variable hidden in supertype
				super.setIdentifier(identifier);
				//2222hack to solve problem with variable hidden in supertype
				super.setIdentifier(identifier);
		
		this.identifier = identifier;
	}

	

	/**
	 * Get the Name.
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
	 * Set the Name.
	 * @param name
	 */
	public void setName( String name)
	{
				//hack to solve problem with variable hidden in supertype
				super.setName(name);
				//2222hack to solve problem with variable hidden in supertype
				super.setName(name);
		
		this.name = name;
	}

	

	/**
	 * Get the Description.
	 * @return description.
	 */
	public String getDescription()
	{
		return this.description;
	}
	
	@Deprecated
	public String getDescription(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Description.
	 * @param description
	 */
	public void setDescription( String description)
	{
				//2222hack to solve problem with variable hidden in supertype
				super.setDescription(description);
		
		this.description = description;
	}

	

	/**
	 * Get the *...but required for association datasets.
	 * @return totalNumberOfIndividuals.
	 */
	public Integer getTotalNumberOfIndividuals()
	{
		return this.totalNumberOfIndividuals;
	}
	
	@Deprecated
	public Integer getTotalNumberOfIndividuals(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the *...but required for association datasets.
	 * @param totalNumberOfIndividuals
	 */
	public void setTotalNumberOfIndividuals( Integer totalNumberOfIndividuals)
	{
		
		this.totalNumberOfIndividuals = totalNumberOfIndividuals;
	}

	

	/**
	 * Get the Number of males.
	 * @return numberOfSexMale.
	 */
	public Integer getNumberOfSexMale()
	{
		return this.numberOfSexMale;
	}
	
	@Deprecated
	public Integer getNumberOfSexMale(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Number of males.
	 * @param numberOfSexMale
	 */
	public void setNumberOfSexMale( Integer numberOfSexMale)
	{
		
		this.numberOfSexMale = numberOfSexMale;
	}

	

	/**
	 * Get the Number of females.
	 * @return numberOfSexFemale.
	 */
	public Integer getNumberOfSexFemale()
	{
		return this.numberOfSexFemale;
	}
	
	@Deprecated
	public Integer getNumberOfSexFemale(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Number of females.
	 * @param numberOfSexFemale
	 */
	public void setNumberOfSexFemale( Integer numberOfSexFemale)
	{
		
		this.numberOfSexFemale = numberOfSexFemale;
	}

	

	/**
	 * Get the Number of unknown sex.
	 * @return numberOfSexUnknown.
	 */
	public Integer getNumberOfSexUnknown()
	{
		return this.numberOfSexUnknown;
	}
	
	@Deprecated
	public Integer getNumberOfSexUnknown(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Number of unknown sex.
	 * @param numberOfSexUnknown
	 */
	public void setNumberOfSexUnknown( Integer numberOfSexUnknown)
	{
		
		this.numberOfSexUnknown = numberOfSexUnknown;
	}

	

	/**
	 * Get the field used only if Composition = 'Trios'.
	 * @return numberOfProbands.
	 */
	public Integer getNumberOfProbands()
	{
		return this.numberOfProbands;
	}
	
	@Deprecated
	public Integer getNumberOfProbands(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the field used only if Composition = 'Trios'.
	 * @param numberOfProbands
	 */
	public void setNumberOfProbands( Integer numberOfProbands)
	{
		
		this.numberOfProbands = numberOfProbands;
	}

	

	/**
	 * Get the field used only if Composition = 'Trios'.
	 * @return numberOfParents.
	 */
	public Integer getNumberOfParents()
	{
		return this.numberOfParents;
	}
	
	@Deprecated
	public Integer getNumberOfParents(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the field used only if Composition = 'Trios'.
	 * @param numberOfParents
	 */
	public void setNumberOfParents( Integer numberOfParents)
	{
		
		this.numberOfParents = numberOfParents;
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
		if (name.toLowerCase().equals("totalnumberofindividuals"))
			return getTotalNumberOfIndividuals();
		if (name.toLowerCase().equals("numberofsexmale"))
			return getNumberOfSexMale();
		if (name.toLowerCase().equals("numberofsexfemale"))
			return getNumberOfSexFemale();
		if (name.toLowerCase().equals("numberofsexunknown"))
			return getNumberOfSexUnknown();
		if (name.toLowerCase().equals("numberofprobands"))
			return getNumberOfProbands();
		if (name.toLowerCase().equals("numberofparents"))
			return getNumberOfParents();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getIdentifier() == null) throw new org.molgenis.framework.db.DatabaseException("required field identifier is null");
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
			this.setDescription(tuple.getString("Description"));
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
			//set TotalNumberOfIndividuals
			this.setTotalNumberOfIndividuals(tuple.getInt("TotalNumberOfIndividuals"));
			//set NumberOfSexMale
			this.setNumberOfSexMale(tuple.getInt("NumberOfSexMale"));
			//set NumberOfSexFemale
			this.setNumberOfSexFemale(tuple.getInt("NumberOfSexFemale"));
			//set NumberOfSexUnknown
			this.setNumberOfSexUnknown(tuple.getInt("NumberOfSexUnknown"));
			//set NumberOfProbands
			this.setNumberOfProbands(tuple.getInt("NumberOfProbands"));
			//set NumberOfParents
			this.setNumberOfParents(tuple.getInt("NumberOfParents"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("AssayedPanel_id") != null) this.setId(tuple.getInt("AssayedPanel_id"));
			//set Identifier
			if( strict || tuple.getString("Identifier") != null) this.setIdentifier(tuple.getString("Identifier"));
			if( tuple.getString("AssayedPanel_Identifier") != null) this.setIdentifier(tuple.getString("AssayedPanel_Identifier"));
			//set Name
			if( strict || tuple.getString("Name") != null) this.setName(tuple.getString("Name"));
			if( tuple.getString("AssayedPanel_Name") != null) this.setName(tuple.getString("AssayedPanel_Name"));
			//set __Type
			if( strict || tuple.getString("__Type") != null) this.set__Type(tuple.getString("__Type"));
			if( tuple.getString("AssayedPanel___Type") != null) this.set__Type(tuple.getString("AssayedPanel___Type"));
			//set Description
			if( strict || tuple.getString("Description") != null) this.setDescription(tuple.getString("Description"));
			if( tuple.getString("AssayedPanel_Description") != null) this.setDescription(tuple.getString("AssayedPanel_Description"));
			//set PanelType
			if( strict || tuple.getInt("PanelType_id") != null) this.setPanelType(tuple.getInt("PanelType_id"));
			if( tuple.getInt("AssayedPanel_PanelType_id") != null) this.setPanelType(tuple.getInt("AssayedPanel_PanelType_id"));
			//alias of xref
			if( tuple.getObject("PanelType") != null) this.setPanelType(tuple.getInt("PanelType"));
			if( tuple.getObject("AssayedPanel_PanelType") != null) this.setPanelType(tuple.getInt("AssayedPanel_PanelType"));
			//set label for field PanelType
			if( strict || tuple.getObject("PanelType_Identifier") != null) this.setPanelType_Identifier(tuple.getString("PanelType_Identifier"));			
			if( tuple.getObject("AssayedPanel_PanelType_Identifier") != null ) this.setPanelType_Identifier(tuple.getString("AssayedPanel_PanelType_Identifier"));		
			//set NumberOfIndividuals
			if( strict || tuple.getInt("NumberOfIndividuals") != null) this.setNumberOfIndividuals(tuple.getInt("NumberOfIndividuals"));
			if( tuple.getInt("AssayedPanel_NumberOfIndividuals") != null) this.setNumberOfIndividuals(tuple.getInt("AssayedPanel_NumberOfIndividuals"));
			//set Species
			if( strict || tuple.getInt("Species_id") != null) this.setSpecies(tuple.getInt("Species_id"));
			if( tuple.getInt("AssayedPanel_Species_id") != null) this.setSpecies(tuple.getInt("AssayedPanel_Species_id"));
			//alias of xref
			if( tuple.getObject("Species") != null) this.setSpecies(tuple.getInt("Species"));
			if( tuple.getObject("AssayedPanel_Species") != null) this.setSpecies(tuple.getInt("AssayedPanel_Species"));
			//set label for field Species
			if( strict || tuple.getObject("Species_Identifier") != null) this.setSpecies_Identifier(tuple.getString("Species_Identifier"));			
			if( tuple.getObject("AssayedPanel_Species_Identifier") != null ) this.setSpecies_Identifier(tuple.getString("AssayedPanel_Species_Identifier"));		
			//set Individuals
			if( tuple.getObject("Individuals")!= null || tuple.getObject("AssayedPanel_Individuals")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("Individuals");
				if(tuple.getObject("AssayedPanel_Individuals")!= null) mrefs = tuple.getList("AssayedPanel_Individuals");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setIndividuals_Id( values );
			}
			//set labels Identifier for mref field Individuals	
			if( tuple.getObject("Individuals_Identifier")!= null || tuple.getObject("AssayedPanel_Individuals_Identifier")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("Individuals_Identifier");
				if(tuple.getObject("AssayedPanel_Individuals_Identifier")!= null) mrefs = tuple.getList("AssayedPanel_Individuals_Identifier");
				
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
			//set TotalNumberOfIndividuals
			if( strict || tuple.getInt("TotalNumberOfIndividuals") != null) this.setTotalNumberOfIndividuals(tuple.getInt("TotalNumberOfIndividuals"));
			if( tuple.getInt("AssayedPanel_TotalNumberOfIndividuals") != null) this.setTotalNumberOfIndividuals(tuple.getInt("AssayedPanel_TotalNumberOfIndividuals"));
			//set NumberOfSexMale
			if( strict || tuple.getInt("NumberOfSexMale") != null) this.setNumberOfSexMale(tuple.getInt("NumberOfSexMale"));
			if( tuple.getInt("AssayedPanel_NumberOfSexMale") != null) this.setNumberOfSexMale(tuple.getInt("AssayedPanel_NumberOfSexMale"));
			//set NumberOfSexFemale
			if( strict || tuple.getInt("NumberOfSexFemale") != null) this.setNumberOfSexFemale(tuple.getInt("NumberOfSexFemale"));
			if( tuple.getInt("AssayedPanel_NumberOfSexFemale") != null) this.setNumberOfSexFemale(tuple.getInt("AssayedPanel_NumberOfSexFemale"));
			//set NumberOfSexUnknown
			if( strict || tuple.getInt("NumberOfSexUnknown") != null) this.setNumberOfSexUnknown(tuple.getInt("NumberOfSexUnknown"));
			if( tuple.getInt("AssayedPanel_NumberOfSexUnknown") != null) this.setNumberOfSexUnknown(tuple.getInt("AssayedPanel_NumberOfSexUnknown"));
			//set NumberOfProbands
			if( strict || tuple.getInt("NumberOfProbands") != null) this.setNumberOfProbands(tuple.getInt("NumberOfProbands"));
			if( tuple.getInt("AssayedPanel_NumberOfProbands") != null) this.setNumberOfProbands(tuple.getInt("AssayedPanel_NumberOfProbands"));
			//set NumberOfParents
			if( strict || tuple.getInt("NumberOfParents") != null) this.setNumberOfParents(tuple.getInt("NumberOfParents"));
			if( tuple.getInt("AssayedPanel_NumberOfParents") != null) this.setNumberOfParents(tuple.getInt("AssayedPanel_NumberOfParents"));
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
		String result = "AssayedPanel(";
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
		result+= "totalNumberOfIndividuals='" + getTotalNumberOfIndividuals()+"' ";	
		result+= "numberOfSexMale='" + getNumberOfSexMale()+"' ";	
		result+= "numberOfSexFemale='" + getNumberOfSexFemale()+"' ";	
		result+= "numberOfSexUnknown='" + getNumberOfSexUnknown()+"' ";	
		result+= "numberOfProbands='" + getNumberOfProbands()+"' ";	
		result+= "numberOfParents='" + getNumberOfParents()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of AssayedPanel.
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
		{
			fields.add("totalNumberOfIndividuals");
		}
		{
			fields.add("numberOfSexMale");
		}
		{
			fields.add("numberOfSexFemale");
		}
		{
			fields.add("numberOfSexUnknown");
		}
		{
			fields.add("numberOfProbands");
		}
		{
			fields.add("numberOfParents");
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
		+ "panelType" +sep
		+ "numberOfIndividuals" +sep
		+ "species" +sep
		+ "individuals" +sep
		+ "totalNumberOfIndividuals" +sep
		+ "numberOfSexMale" +sep
		+ "numberOfSexFemale" +sep
		+ "numberOfSexUnknown" +sep
		+ "numberOfProbands" +sep
		+ "numberOfParents" 
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
		AssayedPanel rhs = (AssayedPanel) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
             	.appendSuper(super.equals(obj))
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
             	.appendSuper(super.hashCode())
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
			out.write(valueS+sep);
		}
		{
			Object valueO = getTotalNumberOfIndividuals();
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
			Object valueO = getNumberOfSexMale();
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
			Object valueO = getNumberOfSexFemale();
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
			Object valueO = getNumberOfSexUnknown();
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
			Object valueO = getNumberOfProbands();
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
			Object valueO = getNumberOfParents();
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
	public AssayedPanel create(org.molgenis.util.Tuple tuple) throws Exception
	{
		AssayedPanel e = new AssayedPanel();
		e.set(tuple);
		return e;
	}
	

	
}

