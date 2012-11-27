
/* File:        org.molgenis/model/Ontology.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.observ.target;

/**
 * Ontology:  Ontology defines a reference to an ontology or
				controlled vocabulary from which well-defined and stable (ontology)
				terms can be obtained. Each Ontology should have a unique identifer,
				for instance: Gene Ontology, Mammalian Phenotype, Human Phenotype
				Ontology, Unified Medical Language System, Medical Subject Headings,
				etc. Also a abbreviation is required, for instance: GO, MP, HPO,
				UMLS, MeSH, etc. Use of existing ontologies/vocabularies is
				recommended to harmonize phenotypic feature and value descriptions.
				But one can also create a 'local' Ontology. The Ontology class maps
				to FuGE::Ontology, MAGE-TAB::TermSourceREF.
			
.
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "Ontology", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "Identifier" } ) }
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.observ.target.db.OntologyEntityListener.class})
public class Ontology extends org.molgenis.util.AbstractEntity implements org.molgenis.core.Identifiable
{
	// fieldname constants
	public final static String ID = "id";
	public final static String IDENTIFIER = "Identifier";
	public final static String NAME = "Name";
	public final static String ONTOLOGYACCESSION = "ontologyAccession";
	public final static String ONTOLOGYURI = "ontologyURI";
	
	//static methods
	/**
	 * Shorthand for db.query(Ontology.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Ontology> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Ontology.class);
	}
	
	/**
	 * Shorthand for db.find(Ontology.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Ontology> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Ontology.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Ontology findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Ontology> q = db.query(Ontology.class);
		q.eq(Ontology.ID, id);
		java.util.List<Ontology> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Ontology findByIdentifier(org.molgenis.framework.db.Database db, String identifier) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Ontology> q = db.query(Ontology.class);
		q.eq(Ontology.IDENTIFIER, identifier);
		java.util.List<Ontology> result = q.find();
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


	//A accession that uniquely identifies the ontology (typically an acronym). E.g. GO, MeSH, HPO.[type=string]
	@javax.persistence.Column(name="ontologyAccession")
	@javax.xml.bind.annotation.XmlElement(name="ontologyAccession")
	
				

	private String ontologyAccession =  null;


	//(Optional) A URI that references the location of the ontology.[type=hyperlink]
	@javax.persistence.Column(name="ontologyURI")
	@javax.xml.bind.annotation.XmlElement(name="ontologyURI")
	
				

	private String ontologyURI =  null;

	//constructors
	public Ontology()
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
	 * Get the A accession that uniquely identifies the ontology (typically an acronym). E.g. GO, MeSH, HPO..
	 * @return ontologyAccession.
	 */
	public String getOntologyAccession()
	{
		return this.ontologyAccession;
	}
	
	@Deprecated
	public String getOntologyAccession(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the A accession that uniquely identifies the ontology (typically an acronym). E.g. GO, MeSH, HPO..
	 * @param ontologyAccession
	 */
	public void setOntologyAccession( String ontologyAccession)
	{
		
		this.ontologyAccession = ontologyAccession;
	}

	

	/**
	 * Get the (Optional) A URI that references the location of the ontology..
	 * @return ontologyURI.
	 */
	public String getOntologyURI()
	{
		return this.ontologyURI;
	}
	
	@Deprecated
	public String getOntologyURI(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the (Optional) A URI that references the location of the ontology..
	 * @param ontologyURI
	 */
	public void setOntologyURI( String ontologyURI)
	{
		
		this.ontologyURI = ontologyURI;
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
		if (name.toLowerCase().equals("ontologyaccession"))
			return getOntologyAccession();
		if (name.toLowerCase().equals("ontologyuri"))
			return getOntologyURI();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getIdentifier() == null) throw new org.molgenis.framework.db.DatabaseException("required field identifier is null");
		if(this.getName() == null) throw new org.molgenis.framework.db.DatabaseException("required field name is null");
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
			//set OntologyAccession
			this.setOntologyAccession(tuple.getString("ontologyAccession"));
			//set OntologyURI
			this.setOntologyURI(tuple.getString("ontologyURI"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("Ontology_id") != null) this.setId(tuple.getInt("Ontology_id"));
			//set Identifier
			if( strict || tuple.getString("Identifier") != null) this.setIdentifier(tuple.getString("Identifier"));
			if( tuple.getString("Ontology_Identifier") != null) this.setIdentifier(tuple.getString("Ontology_Identifier"));
			//set Name
			if( strict || tuple.getString("Name") != null) this.setName(tuple.getString("Name"));
			if( tuple.getString("Ontology_Name") != null) this.setName(tuple.getString("Ontology_Name"));
			//set OntologyAccession
			if( strict || tuple.getString("ontologyAccession") != null) this.setOntologyAccession(tuple.getString("ontologyAccession"));
			if( tuple.getString("Ontology_ontologyAccession") != null) this.setOntologyAccession(tuple.getString("Ontology_ontologyAccession"));
			//set OntologyURI
			if( strict || tuple.getString("ontologyURI") != null) this.setOntologyURI(tuple.getString("ontologyURI"));
			if( tuple.getString("Ontology_ontologyURI") != null) this.setOntologyURI(tuple.getString("Ontology_ontologyURI"));
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
		String result = "Ontology(";
		result+= "id='" + getId()+"' ";	
		result+= "identifier='" + getIdentifier()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= "ontologyAccession='" + getOntologyAccession()+"' ";	
		result+= "ontologyURI='" + getOntologyURI()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Ontology.
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
			fields.add("ontologyAccession");
		}
		{
			fields.add("ontologyURI");
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
		+ "ontologyAccession" +sep
		+ "ontologyURI" 
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
		Ontology rhs = (Ontology) obj;
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
			Object valueO = getOntologyAccession();
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
			Object valueO = getOntologyURI();
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
	public Ontology create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Ontology e = new Ontology();
		e.set(tuple);
		return e;
	}
	
//1
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="ontology"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.observ.target.OntologyTerm> ontologyOntologyTermCollection = new java.util.ArrayList<org.molgenis.observ.target.OntologyTerm>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.observ.target.OntologyTerm> getOntologyOntologyTermCollection()
	{
            return ontologyOntologyTermCollection;
	}

    public void setOntologyOntologyTermCollection(java.util.Collection<org.molgenis.observ.target.OntologyTerm> collection)
    {
        for (org.molgenis.observ.target.OntologyTerm ontologyTerm : collection) {
            ontologyTerm.setOntology(this);
        }
        ontologyOntologyTermCollection = collection;
    }	

	
}

