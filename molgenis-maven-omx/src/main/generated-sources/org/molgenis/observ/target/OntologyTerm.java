
/* File:        org.molgenis/model/OntologyTerm.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.observ.target;

/**
 * OntologyTerm: 
				OntologyTerm defines a single entry (term) from an
				ontology or a controlled vocabulary (defined by Ontology). The
				identifier is the ontology term is unique. E.g. 'NCI:Antigen Gene'.
				Other data entities can reference to this OntologyTerm to harmonize
				naming of concepts. If no suitable ontology term exists then one can
				define new terms locally (in which case there is no formal accession
				for the term limiting its use for cross-Investigation queries).
			
.
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "OntologyTerm", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "Identifier" }), @javax.persistence.UniqueConstraint( columnNames={ "ontology", "termAccession" } ) }
)


@javax.persistence.Inheritance(strategy=javax.persistence.InheritanceType.JOINED)
@javax.persistence.DiscriminatorColumn(name="DType", discriminatorType=javax.persistence.DiscriminatorType.STRING)
@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.observ.target.db.OntologyTermEntityListener.class})
public class OntologyTerm extends org.molgenis.util.AbstractEntity implements org.molgenis.core.Identifiable
{
	// fieldname constants
	public final static String ID = "id";
	public final static String IDENTIFIER = "Identifier";
	public final static String NAME = "Name";
	public final static String __TYPE = "__Type";
	public final static String ONTOLOGY = "ontology";
	public final static String ONTOLOGY_IDENTIFIER = "ontology_Identifier";
	public final static String TERMACCESSION = "termAccession";
	public final static String DEFINITION = "definition";
	
	//static methods
	/**
	 * Shorthand for db.query(OntologyTerm.class).
	 */
	public static org.molgenis.framework.db.Query<? extends OntologyTerm> query(org.molgenis.framework.db.Database db)
	{
		return db.query(OntologyTerm.class);
	}
	
	/**
	 * Shorthand for db.find(OntologyTerm.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends OntologyTerm> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(OntologyTerm.class, rules);
	}	
	
	/**
	 * 
	 */
	public static OntologyTerm findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<OntologyTerm> q = db.query(OntologyTerm.class);
		q.eq(OntologyTerm.ID, id);
		java.util.List<OntologyTerm> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static OntologyTerm findByIdentifier(org.molgenis.framework.db.Database db, String identifier) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<OntologyTerm> q = db.query(OntologyTerm.class);
		q.eq(OntologyTerm.IDENTIFIER, identifier);
		java.util.List<OntologyTerm> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static OntologyTerm findByOntologyTermAccession(org.molgenis.framework.db.Database db, Integer ontology, String termAccession) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<OntologyTerm> q = db.query(OntologyTerm.class);
		q.eq(OntologyTerm.ONTOLOGY, ontology);q.eq(OntologyTerm.TERMACCESSION, termAccession);
		java.util.List<OntologyTerm> result = q.find();
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


	//Subtypes have to be set to allow searching[type=enum]
	@javax.persistence.Column(name="DType", nullable=false)            
	@javax.xml.bind.annotation.XmlElement(name="__Type")
	
				

	@javax.validation.constraints.NotNull
	private String __Type =  null;
	@javax.persistence.Transient
	private String __Type_label = null;
	@javax.persistence.Transient
	private java.util.List<org.molgenis.util.ValueLabel> __Type_options = new java.util.ArrayList<org.molgenis.util.ValueLabel>();


	//(Optional) The source ontology or controlled vocabulary list that ontology terms have been obtained from.[type=xref]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="ontology")   	
	
				

	private org.molgenis.observ.target.Ontology ontology = null;
	@javax.persistence.Transient
	private Integer ontology_id = null;	
	@javax.persistence.Transient
	private String ontology_Identifier = null;						


	//(Optional) The accession number assigned to the ontology term in its source ontology. If empty it is assumed to be a locally defined term.[type=string]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="termAccession")
	@javax.xml.bind.annotation.XmlElement(name="termAccession")
	
				

	private String termAccession =  null;


	//(Optional) The definition of the term.[type=string]
	@javax.persistence.Column(name="definition")
	@javax.xml.bind.annotation.XmlElement(name="definition")
	
				

	private String definition =  null;

	//constructors
	public OntologyTerm()
	{
		//set the type for a new instance
		set__Type(this.getClass().getSimpleName());
	
		//options for enum __Type
		__Type_options.add(new org.molgenis.util.ValueLabel("OntologyTerm","OntologyTerm"));
		__Type_options.add(new org.molgenis.util.ValueLabel("Species","Species"));
		__Type_options.add(new org.molgenis.util.ValueLabel("Accession","Accession"));
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
	 * Get the Subtypes have to be set to allow searching.
	 * @return __Type.
	 */
	public String get__Type()
	{
		return this.__Type;
	}
	
	@Deprecated
	public String get__Type(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Subtypes have to be set to allow searching.
	 * @param __Type
	 */
	public void set__Type( String __Type)
	{
		
		this.__Type = __Type;
	}

	
	/**
	 * Get tha label for enum __Type.
	 */
	public String get__TypeLabel()
	{
		return this.__Type_label;
	}
	
	/**
	 * __Type is enum. This method returns all available enum options.
	 */
	public java.util.List<org.molgenis.util.ValueLabel> get__TypeOptions()
	{
		return __Type_options;
	}	
	

	/**
	 * Get the (Optional) The source ontology or controlled vocabulary list that ontology terms have been obtained from..
	 * @return ontology.
	 */
	public org.molgenis.observ.target.Ontology getOntology()
	{
		return this.ontology;
	}
	
	@Deprecated
	public org.molgenis.observ.target.Ontology getOntology(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the (Optional) The source ontology or controlled vocabulary list that ontology terms have been obtained from..
	 * @param ontology
	 */
	public void setOntology( org.molgenis.observ.target.Ontology ontology)
	{
		
		this.ontology = ontology;
	}

	
	
	/**
	 * Set foreign key for field ontology.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setOntology_Id(Integer ontology_id)
	{
		this.ontology_id = ontology_id;
	}	

	public void setOntology(Integer ontology_id)
	{
		this.ontology_id = ontology_id;
	}
	
	public Integer getOntology_Id()
	{
		
		if(ontology != null) 
		{
			return ontology.getId();
		}
		else
		{
			return ontology_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference Ontology to Ontology.Id.
	 */
	public String getOntology_Identifier()
	{		
		//FIXME should we auto-load based on getOntology()?	
		if(ontology != null) {
			return ontology.getIdentifier();
		} else {
			return ontology_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Ontology to <a href="Ontology.html#Id">Ontology.Id</a>.
	 * Implies setOntology(null) until save
	 */
	public void setOntology_Identifier(String ontology_Identifier)
	{
		this.ontology_Identifier = ontology_Identifier;
	}		
	 
	

	/**
	 * Get the (Optional) The accession number assigned to the ontology term in its source ontology. If empty it is assumed to be a locally defined term..
	 * @return termAccession.
	 */
	public String getTermAccession()
	{
		return this.termAccession;
	}
	
	@Deprecated
	public String getTermAccession(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the (Optional) The accession number assigned to the ontology term in its source ontology. If empty it is assumed to be a locally defined term..
	 * @param termAccession
	 */
	public void setTermAccession( String termAccession)
	{
		
		this.termAccession = termAccession;
	}

	

	/**
	 * Get the (Optional) The definition of the term..
	 * @return definition.
	 */
	public String getDefinition()
	{
		return this.definition;
	}
	
	@Deprecated
	public String getDefinition(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the (Optional) The definition of the term..
	 * @param definition
	 */
	public void setDefinition( String definition)
	{
		
		this.definition = definition;
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
		if (name.toLowerCase().equals("ontology"))
			return getOntology();
		if(name.toLowerCase().equals("ontology_id"))
			return getOntology_Id();
		if(name.toLowerCase().equals("ontology_identifier"))
			return getOntology_Identifier();
		if (name.toLowerCase().equals("termaccession"))
			return getTermAccession();
		if (name.toLowerCase().equals("definition"))
			return getDefinition();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getIdentifier() == null) throw new org.molgenis.framework.db.DatabaseException("required field identifier is null");
		if(this.getName() == null) throw new org.molgenis.framework.db.DatabaseException("required field name is null");
		if(this.get__Type() == null) throw new org.molgenis.framework.db.DatabaseException("required field __Type is null");
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
			//set Ontology
			this.setOntology(tuple.getInt("ontology"));
			//set label Identifier for xref field Ontology
			this.setOntology_Identifier(tuple.getString("ontology_Identifier"));	
			//set TermAccession
			this.setTermAccession(tuple.getString("termAccession"));
			//set Definition
			this.setDefinition(tuple.getString("definition"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("OntologyTerm_id") != null) this.setId(tuple.getInt("OntologyTerm_id"));
			//set Identifier
			if( strict || tuple.getString("Identifier") != null) this.setIdentifier(tuple.getString("Identifier"));
			if( tuple.getString("OntologyTerm_Identifier") != null) this.setIdentifier(tuple.getString("OntologyTerm_Identifier"));
			//set Name
			if( strict || tuple.getString("Name") != null) this.setName(tuple.getString("Name"));
			if( tuple.getString("OntologyTerm_Name") != null) this.setName(tuple.getString("OntologyTerm_Name"));
			//set __Type
			if( strict || tuple.getString("__Type") != null) this.set__Type(tuple.getString("__Type"));
			if( tuple.getString("OntologyTerm___Type") != null) this.set__Type(tuple.getString("OntologyTerm___Type"));
			//set Ontology
			if( strict || tuple.getInt("ontology_id") != null) this.setOntology(tuple.getInt("ontology_id"));
			if( tuple.getInt("OntologyTerm_ontology_id") != null) this.setOntology(tuple.getInt("OntologyTerm_ontology_id"));
			//alias of xref
			if( tuple.getObject("ontology") != null) this.setOntology(tuple.getInt("ontology"));
			if( tuple.getObject("OntologyTerm_ontology") != null) this.setOntology(tuple.getInt("OntologyTerm_ontology"));
			//set label for field Ontology
			if( strict || tuple.getObject("ontology_Identifier") != null) this.setOntology_Identifier(tuple.getString("ontology_Identifier"));			
			if( tuple.getObject("OntologyTerm_ontology_Identifier") != null ) this.setOntology_Identifier(tuple.getString("OntologyTerm_ontology_Identifier"));		
			//set TermAccession
			if( strict || tuple.getString("termAccession") != null) this.setTermAccession(tuple.getString("termAccession"));
			if( tuple.getString("OntologyTerm_termAccession") != null) this.setTermAccession(tuple.getString("OntologyTerm_termAccession"));
			//set Definition
			if( strict || tuple.getString("definition") != null) this.setDefinition(tuple.getString("definition"));
			if( tuple.getString("OntologyTerm_definition") != null) this.setDefinition(tuple.getString("OntologyTerm_definition"));
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
		String result = "OntologyTerm(";
		result+= "id='" + getId()+"' ";	
		result+= "identifier='" + getIdentifier()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= "__Type='" + get__Type()+"' ";	
		result+= " ontology_id='" + getOntology_Id()+"' ";	
		result+= " ontology_identifier='" + getOntology_Identifier()+"' ";
		result+= "termAccession='" + getTermAccession()+"' ";	
		result+= "definition='" + getDefinition()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of OntologyTerm.
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
			fields.add("ontology_id");
		}
		fields.add("ontology_identifier");
		{
			fields.add("termAccession");
		}
		{
			fields.add("definition");
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
		+ "ontology" +sep
		+ "termAccession" +sep
		+ "definition" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("ontology")) {
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
		OntologyTerm rhs = (OntologyTerm) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
		//identifier
				.append(identifier, rhs.getIdentifier())
		//ontology
		//termAccession
				.append(termAccession, rhs.getTermAccession())
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
				.append(termAccession)
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
			Object valueO = getOntology();
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
			Object valueO = getTermAccession();
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
			Object valueO = getDefinition();
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
	public OntologyTerm create(org.molgenis.util.Tuple tuple) throws Exception
	{
		OntologyTerm e = new OntologyTerm();
		e.set(tuple);
		return e;
	}
	
//10
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="unit"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.observ.ObservableFeature> unitObservableFeatureCollection = new java.util.ArrayList<org.molgenis.observ.ObservableFeature>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.observ.ObservableFeature> getUnitObservableFeatureCollection()
	{
            return unitObservableFeatureCollection;
	}

    public void setUnitObservableFeatureCollection(java.util.Collection<org.molgenis.observ.ObservableFeature> collection)
    {
        for (org.molgenis.observ.ObservableFeature observableFeature : collection) {
            observableFeature.setUnit(this);
        }
        unitObservableFeatureCollection = collection;
    }	
//10
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="protocolType"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.observ.Protocol> protocolTypeProtocolCollection = new java.util.ArrayList<org.molgenis.observ.Protocol>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.observ.Protocol> getProtocolTypeProtocolCollection()
	{
            return protocolTypeProtocolCollection;
	}

    public void setProtocolTypeProtocolCollection(java.util.Collection<org.molgenis.observ.Protocol> collection)
    {
        for (org.molgenis.observ.Protocol protocol : collection) {
            protocol.setProtocolType(this);
        }
        protocolTypeProtocolCollection = collection;
    }	
//10
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="panelType"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.observ.target.Panel> panelTypePanelCollection = new java.util.ArrayList<org.molgenis.observ.target.Panel>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.observ.target.Panel> getPanelTypePanelCollection()
	{
            return panelTypePanelCollection;
	}

    public void setPanelTypePanelCollection(java.util.Collection<org.molgenis.observ.target.Panel> collection)
    {
        for (org.molgenis.observ.target.Panel panel : collection) {
            panel.setPanelType(this);
        }
        panelTypePanelCollection = collection;
    }	
//10
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="variantType"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.variant.Variant> variantTypeVariantCollection = new java.util.ArrayList<org.molgenis.variant.Variant>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.variant.Variant> getVariantTypeVariantCollection()
	{
            return variantTypeVariantCollection;
	}

    public void setVariantTypeVariantCollection(java.util.Collection<org.molgenis.variant.Variant> collection)
    {
        for (org.molgenis.variant.Variant variant : collection) {
            variant.setVariantType(this);
        }
        variantTypeVariantCollection = collection;
    }	
//10
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="experimentType"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.organization.Experiment> experimentTypeExperimentCollection = new java.util.ArrayList<org.molgenis.organization.Experiment>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.organization.Experiment> getExperimentTypeExperimentCollection()
	{
            return experimentTypeExperimentCollection;
	}

    public void setExperimentTypeExperimentCollection(java.util.Collection<org.molgenis.organization.Experiment> collection)
    {
        for (org.molgenis.organization.Experiment experiment : collection) {
            experiment.setExperimentType(this);
        }
        experimentTypeExperimentCollection = collection;
    }	
//10
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="orcidPersonReference"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.organization.Person> orcidPersonReferencePersonCollection = new java.util.ArrayList<org.molgenis.organization.Person>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.organization.Person> getOrcidPersonReferencePersonCollection()
	{
            return orcidPersonReferencePersonCollection;
	}

    public void setOrcidPersonReferencePersonCollection(java.util.Collection<org.molgenis.organization.Person> collection)
    {
        for (org.molgenis.organization.Person person : collection) {
            person.setOrcidPersonReference(this);
        }
        orcidPersonReferencePersonCollection = collection;
    }	
//10
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="status"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.organization.Citation> statusCitationCollection = new java.util.ArrayList<org.molgenis.organization.Citation>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.organization.Citation> getStatusCitationCollection()
	{
            return statusCitationCollection;
	}

    public void setStatusCitationCollection(java.util.Collection<org.molgenis.organization.Citation> collection)
    {
        for (org.molgenis.organization.Citation citation : collection) {
            citation.setStatus(this);
        }
        statusCitationCollection = collection;
    }	
//10
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="centralIdentifier"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.gwascentral.SamplePanel> centralIdentifierSamplePanelCollection = new java.util.ArrayList<org.molgenis.gwascentral.SamplePanel>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.gwascentral.SamplePanel> getCentralIdentifierSamplePanelCollection()
	{
            return centralIdentifierSamplePanelCollection;
	}

    public void setCentralIdentifierSamplePanelCollection(java.util.Collection<org.molgenis.gwascentral.SamplePanel> collection)
    {
        for (org.molgenis.gwascentral.SamplePanel samplePanel : collection) {
            samplePanel.setCentralIdentifier(this);
        }
        centralIdentifierSamplePanelCollection = collection;
    }	
	//10
    @javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="ontologyTerms"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.organization.Citation> ontologyTermsCitationCollection = new java.util.ArrayList<org.molgenis.organization.Citation>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.organization.Citation> getOntologyTermsCitationCollection()
	{
        return ontologyTermsCitationCollection;
	}

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.organization.Citation> getOntologyTermsCitationCollection(org.molgenis.framework.db.Database db)
	{
        return getOntologyTermsCitationCollection();
	}

    public void setOntologyTermsCitationCollection(java.util.Collection<org.molgenis.organization.Citation> collection)
    {
    	ontologyTermsCitationCollection.addAll(collection);
    }	

	
}

