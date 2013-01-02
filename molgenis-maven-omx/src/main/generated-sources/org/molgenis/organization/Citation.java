
/* File:        org.molgenis.omx/model/Citation.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.organization;

/**
 * Citation: 

				Citation of a document or data set. Publications have
				attributes of
				publications Authors and also DOI and Pubmed
				identifiers (when these
				are available). These are represented as
				OntologyTerms as in the
				MAGE-TAB model all 'xrefs' (cross
				references) for ontologies and
				accession numbers are handled
				generically. An example of a
				publication is available in an IDF file
				from ArrayExpress is
				experiment E-MTAB-506
				<a href="ftp://ftp.ebi.ac.uk/pub/databases/microarray/data/experiment/TABM/E-TABM-506/E-TABM-506.idf.txt">ftp://ftp.ebi.ac.uk/pub/databases/microarray/data/experiment/TABM/E-TABM-506/E-TABM-506.idf.txt
				</a>
				.
				<br/>
				The FuGE equivalent to Publication is FuGE::Bibliographic Reference.
			
.
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "Citation", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "Identifier" }), @javax.persistence.UniqueConstraint( columnNames={ "PubmedID" }), @javax.persistence.UniqueConstraint( columnNames={ "DOI" } ) }
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.organization.db.CitationEntityListener.class})
public class Citation extends org.molgenis.util.AbstractEntity implements org.molgenis.core.Identifiable
{
	// fieldname constants
	public final static String ID = "id";
	public final static String IDENTIFIER = "Identifier";
	public final static String NAME = "Name";
	public final static String PUBMEDID = "PubmedID";
	public final static String DOI = "DOI";
	public final static String ONTOLOGYTERMS = "ontologyTerms";
	public final static String ONTOLOGYTERMS_IDENTIFIER = "ontologyTerms_Identifier";
	public final static String AUTHORLIST = "authorList";
	public final static String TITLE = "Title";
	public final static String DESCRIPTION = "Description";
	public final static String STATUS = "Status";
	public final static String STATUS_IDENTIFIER = "Status_Identifier";
	
	//static methods
	/**
	 * Shorthand for db.query(Citation.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Citation> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Citation.class);
	}
	
	/**
	 * Shorthand for db.find(Citation.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Citation> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Citation.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Citation findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Citation> q = db.query(Citation.class);
		q.eq(Citation.ID, id);
		java.util.List<Citation> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Citation findByIdentifier(org.molgenis.framework.db.Database db, String identifier) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Citation> q = db.query(Citation.class);
		q.eq(Citation.IDENTIFIER, identifier);
		java.util.List<Citation> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Citation findByPubmedID(org.molgenis.framework.db.Database db, String pubmedID) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Citation> q = db.query(Citation.class);
		q.eq(Citation.PUBMEDID, pubmedID);
		java.util.List<Citation> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Citation findByDOI(org.molgenis.framework.db.Database db, String dOI) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Citation> q = db.query(Citation.class);
		q.eq(Citation.DOI, dOI);
		java.util.List<Citation> result = q.find();
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


	//Pubmed ID[type=string]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="PubmedID")
	@javax.xml.bind.annotation.XmlElement(name="pubmedID")
	
				

	private String pubmedID =  null;


	//Publication DOI[type=string]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="DOI")
	@javax.xml.bind.annotation.XmlElement(name="dOI")
	
				

	private String dOI =  null;


	//ontology terms such as MeSH[type=mref]
    @javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="ontologyTerms", insertable=true, updatable=true, nullable=true)
	@javax.persistence.JoinTable(name="Citation_ontologyTerms", 
			joinColumns=@javax.persistence.JoinColumn(name="Citation"), inverseJoinColumns=@javax.persistence.JoinColumn(name="ontologyTerms"))
	
				

	private java.util.List<org.molgenis.observ.target.OntologyTerm> ontologyTerms = new java.util.ArrayList<org.molgenis.observ.target.OntologyTerm>();
	@javax.persistence.Transient
	private java.util.List<Integer> ontologyTerms_id = new java.util.ArrayList<Integer>();		
	@javax.persistence.Transient
	private java.util.List<String> ontologyTerms_Identifier = new java.util.ArrayList<String>();


	//The names of the authors of the publication[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="authorList", length=16777216)
	
				

	private String authorList =  null;


	//The title of the Publication[type=string]
	@javax.persistence.Column(name="Title", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="title")
	
				

	@javax.validation.constraints.NotNull
	private String title =  null;


	//Description[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="Description", length=16777216, nullable=false)
	
				

	@javax.validation.constraints.NotNull
	private String description =  null;


	//The status of the Publication[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Status")   	
	
				

	private org.molgenis.observ.target.OntologyTerm status = null;
	@javax.persistence.Transient
	private Integer status_id = null;	
	@javax.persistence.Transient
	private String status_Identifier = null;						

	//constructors
	public Citation()
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
	 * Get the Pubmed ID.
	 * @return pubmedID.
	 */
	public String getPubmedID()
	{
		return this.pubmedID;
	}
	
	@Deprecated
	public String getPubmedID(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Pubmed ID.
	 * @param pubmedID
	 */
	public void setPubmedID( String pubmedID)
	{
		
		this.pubmedID = pubmedID;
	}

	

	/**
	 * Get the Publication DOI.
	 * @return dOI.
	 */
	public String getDOI()
	{
		return this.dOI;
	}
	
	@Deprecated
	public String getDOI(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Publication DOI.
	 * @param dOI
	 */
	public void setDOI( String dOI)
	{
		
		this.dOI = dOI;
	}

	

	/**
	 * Get the ontology terms such as MeSH.
	 * @return ontologyTerms.
	 */
	public java.util.List<org.molgenis.observ.target.OntologyTerm> getOntologyTerms()
	{
		return this.ontologyTerms;
	}
	
	@Deprecated
	public java.util.List<org.molgenis.observ.target.OntologyTerm> getOntologyTerms(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the ontology terms such as MeSH.
	 * @param ontologyTerms
	 */
	public void setOntologyTerms( java.util.List<org.molgenis.observ.target.OntologyTerm> ontologyTerms)
	{
		
		this.ontologyTerms = ontologyTerms;
	}

	
	public void setOntologyTerms_Id(Integer ... ontologyTerms)
	{
		this.setOntologyTerms_Id(java.util.Arrays.asList(ontologyTerms));
	}	
	
	public void setOntologyTerms(org.molgenis.observ.target.OntologyTerm ... ontologyTerms)
	{
		this.setOntologyTerms(java.util.Arrays.asList(ontologyTerms));
	}	
	
	/**
	 * Set foreign key for field ontologyTerms.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setOntologyTerms_Id(java.util.List<Integer> ontologyTerms_id)
	{
		this.ontologyTerms_id = ontologyTerms_id;
	}	
	
	public java.util.List<Integer> getOntologyTerms_Id()
	{
		return ontologyTerms_id;
	}	
	
	/**
	 * Get a pretty label for cross reference OntologyTerms to <a href="OntologyTerm.html#Id">OntologyTerm.Id</a>.
	 */
	public java.util.List<String> getOntologyTerms_Identifier()
	{
		return ontologyTerms_Identifier;
	}
	
	/**
	 * Update the foreign key OntologyTerms
	 * This sets ontologyTerms to null until next database transaction.
	 */
	public void setOntologyTerms_Identifier(java.util.List<String> ontologyTerms_Identifier)
	{
		this.ontologyTerms_Identifier = ontologyTerms_Identifier;
	}		
	

	/**
	 * Get the The names of the authors of the publication.
	 * @return authorList.
	 */
	public String getAuthorList()
	{
		return this.authorList;
	}
	
	@Deprecated
	public String getAuthorList(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the The names of the authors of the publication.
	 * @param authorList
	 */
	public void setAuthorList( String authorList)
	{
		
		this.authorList = authorList;
	}

	

	/**
	 * Get the The title of the Publication.
	 * @return title.
	 */
	public String getTitle()
	{
		return this.title;
	}
	
	@Deprecated
	public String getTitle(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the The title of the Publication.
	 * @param title
	 */
	public void setTitle( String title)
	{
		
		this.title = title;
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
		
		this.description = description;
	}

	

	/**
	 * Get the The status of the Publication.
	 * @return status.
	 */
	public org.molgenis.observ.target.OntologyTerm getStatus()
	{
		return this.status;
	}
	
	@Deprecated
	public org.molgenis.observ.target.OntologyTerm getStatus(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the The status of the Publication.
	 * @param status
	 */
	public void setStatus( org.molgenis.observ.target.OntologyTerm status)
	{
		
		this.status = status;
	}

	
	
	/**
	 * Set foreign key for field status.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setStatus_Id(Integer status_id)
	{
		this.status_id = status_id;
	}	

	public void setStatus(Integer status_id)
	{
		this.status_id = status_id;
	}
	
	public Integer getStatus_Id()
	{
		
		if(status != null) 
		{
			return status.getId();
		}
		else
		{
			return status_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference Status to OntologyTerm.Id.
	 */
	public String getStatus_Identifier()
	{		
		//FIXME should we auto-load based on getStatus()?	
		if(status != null) {
			return status.getIdentifier();
		} else {
			return status_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Status to <a href="OntologyTerm.html#Id">OntologyTerm.Id</a>.
	 * Implies setStatus(null) until save
	 */
	public void setStatus_Identifier(String status_Identifier)
	{
		this.status_Identifier = status_Identifier;
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
		if (name.toLowerCase().equals("pubmedid"))
			return getPubmedID();
		if (name.toLowerCase().equals("doi"))
			return getDOI();
		if (name.toLowerCase().equals("ontologyterms"))
			return getOntologyTerms();
		if(name.toLowerCase().equals("ontologyterms_id"))
			return getOntologyTerms_Id();
		if(name.toLowerCase().equals("ontologyterms_identifier"))
			return getOntologyTerms_Identifier();
		if (name.toLowerCase().equals("authorlist"))
			return getAuthorList();
		if (name.toLowerCase().equals("title"))
			return getTitle();
		if (name.toLowerCase().equals("description"))
			return getDescription();
		if (name.toLowerCase().equals("status"))
			return getStatus();
		if(name.toLowerCase().equals("status_id"))
			return getStatus_Id();
		if(name.toLowerCase().equals("status_identifier"))
			return getStatus_Identifier();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getIdentifier() == null) throw new org.molgenis.framework.db.DatabaseException("required field identifier is null");
		if(this.getName() == null) throw new org.molgenis.framework.db.DatabaseException("required field name is null");
		if(this.getTitle() == null) throw new org.molgenis.framework.db.DatabaseException("required field title is null");
		if(this.getDescription() == null) throw new org.molgenis.framework.db.DatabaseException("required field description is null");
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
			//set PubmedID
			this.setPubmedID(tuple.getString("PubmedID"));
			//set DOI
			this.setDOI(tuple.getString("DOI"));
			//mrefs can not be directly retrieved
			//set OntologyTerms			
			//set AuthorList
			this.setAuthorList(tuple.getString("authorList"));
			//set Title
			this.setTitle(tuple.getString("Title"));
			//set Description
			this.setDescription(tuple.getString("Description"));
			//set Status
			this.setStatus(tuple.getInt("Status"));
			//set label Identifier for xref field Status
			this.setStatus_Identifier(tuple.getString("Status_Identifier"));	
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("Citation_id") != null) this.setId(tuple.getInt("Citation_id"));
			//set Identifier
			if( strict || tuple.getString("Identifier") != null) this.setIdentifier(tuple.getString("Identifier"));
			if( tuple.getString("Citation_Identifier") != null) this.setIdentifier(tuple.getString("Citation_Identifier"));
			//set Name
			if( strict || tuple.getString("Name") != null) this.setName(tuple.getString("Name"));
			if( tuple.getString("Citation_Name") != null) this.setName(tuple.getString("Citation_Name"));
			//set PubmedID
			if( strict || tuple.getString("PubmedID") != null) this.setPubmedID(tuple.getString("PubmedID"));
			if( tuple.getString("Citation_PubmedID") != null) this.setPubmedID(tuple.getString("Citation_PubmedID"));
			//set DOI
			if( strict || tuple.getString("DOI") != null) this.setDOI(tuple.getString("DOI"));
			if( tuple.getString("Citation_DOI") != null) this.setDOI(tuple.getString("Citation_DOI"));
			//set OntologyTerms
			if( tuple.getObject("ontologyTerms")!= null || tuple.getObject("Citation_ontologyTerms")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("ontologyTerms");
				if(tuple.getObject("Citation_ontologyTerms")!= null) mrefs = tuple.getList("Citation_ontologyTerms");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setOntologyTerms_Id( values );
			}
			//set labels Identifier for mref field OntologyTerms	
			if( tuple.getObject("ontologyTerms_Identifier")!= null || tuple.getObject("Citation_ontologyTerms_Identifier")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("ontologyTerms_Identifier");
				if(tuple.getObject("Citation_ontologyTerms_Identifier")!= null) mrefs = tuple.getList("Citation_ontologyTerms_Identifier");
				
				if(mrefs != null) 
					for(Object ref: mrefs)
					{
						String[] refs = ref.toString().split("\\|");
						for(String r : refs) {
							values.add(r);	
						}						
					}							
				this.setOntologyTerms_Identifier( values );			
			}	
			//set AuthorList
			if( strict || tuple.getString("authorList") != null) this.setAuthorList(tuple.getString("authorList"));
			if( tuple.getString("Citation_authorList") != null) this.setAuthorList(tuple.getString("Citation_authorList"));
			//set Title
			if( strict || tuple.getString("Title") != null) this.setTitle(tuple.getString("Title"));
			if( tuple.getString("Citation_Title") != null) this.setTitle(tuple.getString("Citation_Title"));
			//set Description
			if( strict || tuple.getString("Description") != null) this.setDescription(tuple.getString("Description"));
			if( tuple.getString("Citation_Description") != null) this.setDescription(tuple.getString("Citation_Description"));
			//set Status
			if( strict || tuple.getInt("Status_id") != null) this.setStatus(tuple.getInt("Status_id"));
			if( tuple.getInt("Citation_Status_id") != null) this.setStatus(tuple.getInt("Citation_Status_id"));
			//alias of xref
			if( tuple.getObject("Status") != null) this.setStatus(tuple.getInt("Status"));
			if( tuple.getObject("Citation_Status") != null) this.setStatus(tuple.getInt("Citation_Status"));
			//set label for field Status
			if( strict || tuple.getObject("Status_Identifier") != null) this.setStatus_Identifier(tuple.getString("Status_Identifier"));			
			if( tuple.getObject("Citation_Status_Identifier") != null ) this.setStatus_Identifier(tuple.getString("Citation_Status_Identifier"));		
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
		String result = "Citation(";
		result+= "id='" + getId()+"' ";	
		result+= "identifier='" + getIdentifier()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= "pubmedID='" + getPubmedID()+"' ";	
		result+= "dOI='" + getDOI()+"' ";	
		result+= " ontologyTerms_id='" + getOntologyTerms_Id()+"' ";	
		result+= " ontologyTerms_identifier='" + getOntologyTerms_Identifier()+"' ";
		result+= "authorList='" + getAuthorList()+"' ";	
		result+= "title='" + getTitle()+"' ";	
		result+= "description='" + getDescription()+"' ";	
		result+= " status_id='" + getStatus_Id()+"' ";	
		result+= " status_identifier='" + getStatus_Identifier()+"' ";
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Citation.
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
			fields.add("pubmedID");
		}
		{
			fields.add("dOI");
		}
		{
			fields.add("ontologyTerms_id");
		}
		fields.add("ontologyTerms_identifier");
		{
			fields.add("authorList");
		}
		{
			fields.add("title");
		}
		{
			fields.add("description");
		}
		{
			fields.add("status_id");
		}
		fields.add("status_identifier");
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
		+ "pubmedID" +sep
		+ "dOI" +sep
		+ "ontologyTerms" +sep
		+ "authorList" +sep
		+ "title" +sep
		+ "description" +sep
		+ "status" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("ontologyTerms")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("status")) {
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
		Citation rhs = (Citation) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
		//identifier
				.append(identifier, rhs.getIdentifier())
		//pubmedID
				.append(pubmedID, rhs.getPubmedID())
		//dOI
				.append(dOI, rhs.getDOI())
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
				.append(pubmedID)
				.append(dOI)
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
			Object valueO = getPubmedID();
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
			Object valueO = getDOI();
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
			Object valueO = getOntologyTerms();
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
			Object valueO = getAuthorList();
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
			Object valueO = getTitle();
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
			Object valueO = getStatus();
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
	public Citation create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Citation e = new Citation();
		e.set(tuple);
		return e;
	}
	
//4
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="primaryCitation"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.gwascentral.StudyDetails> primaryCitationStudyDetailsCollection = new java.util.ArrayList<org.molgenis.gwascentral.StudyDetails>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.gwascentral.StudyDetails> getPrimaryCitationStudyDetailsCollection()
	{
            return primaryCitationStudyDetailsCollection;
	}

    public void setPrimaryCitationStudyDetailsCollection(java.util.Collection<org.molgenis.gwascentral.StudyDetails> collection)
    {
        for (org.molgenis.gwascentral.StudyDetails studyDetails : collection) {
            studyDetails.setPrimaryCitation(this);
        }
        primaryCitationStudyDetailsCollection = collection;
    }	
	//4
    @javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="otherCitations"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.gwascentral.StudyDetails> otherCitationsStudyDetailsCollection = new java.util.ArrayList<org.molgenis.gwascentral.StudyDetails>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.gwascentral.StudyDetails> getOtherCitationsStudyDetailsCollection()
	{
        return otherCitationsStudyDetailsCollection;
	}

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.gwascentral.StudyDetails> getOtherCitationsStudyDetailsCollection(org.molgenis.framework.db.Database db)
	{
        return getOtherCitationsStudyDetailsCollection();
	}

    public void setOtherCitationsStudyDetailsCollection(java.util.Collection<org.molgenis.gwascentral.StudyDetails> collection)
    {
    	otherCitationsStudyDetailsCollection.addAll(collection);
    }	

	
}

