
/* File:        org.molgenis.omx/model/Citation_ontologyTerms.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.organization;

/**
 * Citation_ontologyTerms: Link table for many-to-many relationship 'Citation.ontologyTerms'..
 * @author MOLGENIS generator
 */
@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.organization.db.Citation_OntologyTermsEntityListener.class})
public class Citation_OntologyTerms extends org.molgenis.util.AbstractEntity 
{
	// fieldname constants
	public final static String AUTOID = "autoid";
	public final static String ONTOLOGYTERMS = "ontologyTerms";
	public final static String ONTOLOGYTERMS_IDENTIFIER = "ontologyTerms_Identifier";
	public final static String CITATION = "Citation";
	public final static String CITATION_IDENTIFIER = "Citation_Identifier";
	
	//static methods
	/**
	 * Shorthand for db.query(Citation_OntologyTerms.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Citation_OntologyTerms> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Citation_OntologyTerms.class);
	}
	
	/**
	 * Shorthand for db.find(Citation_OntologyTerms.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Citation_OntologyTerms> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Citation_OntologyTerms.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Citation_OntologyTerms findByAutoid(org.molgenis.framework.db.Database db, Integer autoid) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Citation_OntologyTerms> q = db.query(Citation_OntologyTerms.class);
		q.eq(Citation_OntologyTerms.AUTOID, autoid);
		java.util.List<Citation_OntologyTerms> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Citation_OntologyTerms findByOntologyTermsCitation(org.molgenis.framework.db.Database db, Integer ontologyTerms, Integer citation) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Citation_OntologyTerms> q = db.query(Citation_OntologyTerms.class);
		q.eq(Citation_OntologyTerms.ONTOLOGYTERMS, ontologyTerms);q.eq(Citation_OntologyTerms.CITATION, citation);
		java.util.List<Citation_OntologyTerms> result = q.find();
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
    @javax.persistence.JoinColumn(name="ontologyTerms", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.observ.target.OntologyTerm ontologyTerms = null;
	@javax.persistence.Transient
	private Integer ontologyTerms_id = null;	
	@javax.persistence.Transient
	private String ontologyTerms_Identifier = null;						


	//[type=xref]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Citation", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.organization.Citation citation = null;
	@javax.persistence.Transient
	private Integer citation_id = null;	
	@javax.persistence.Transient
	private String citation_Identifier = null;						

	//constructors
	public Citation_OntologyTerms()
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
	 * @return ontologyTerms.
	 */
	public org.molgenis.observ.target.OntologyTerm getOntologyTerms()
	{
		return this.ontologyTerms;
	}
	
	@Deprecated
	public org.molgenis.observ.target.OntologyTerm getOntologyTerms(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the .
	 * @param ontologyTerms
	 */
	public void setOntologyTerms( org.molgenis.observ.target.OntologyTerm ontologyTerms)
	{
		
		this.ontologyTerms = ontologyTerms;
	}

	
	
	/**
	 * Set foreign key for field ontologyTerms.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setOntologyTerms_Id(Integer ontologyTerms_id)
	{
		this.ontologyTerms_id = ontologyTerms_id;
	}	

	public void setOntologyTerms(Integer ontologyTerms_id)
	{
		this.ontologyTerms_id = ontologyTerms_id;
	}
	
	public Integer getOntologyTerms_Id()
	{
		
		if(ontologyTerms != null) 
		{
			return ontologyTerms.getId();
		}
		else
		{
			return ontologyTerms_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference OntologyTerms to OntologyTerm.Id.
	 */
	public String getOntologyTerms_Identifier()
	{		
		//FIXME should we auto-load based on getOntologyTerms()?	
		if(ontologyTerms != null) {
			return ontologyTerms.getIdentifier();
		} else {
			return ontologyTerms_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference OntologyTerms to <a href="OntologyTerm.html#Id">OntologyTerm.Id</a>.
	 * Implies setOntologyTerms(null) until save
	 */
	public void setOntologyTerms_Identifier(String ontologyTerms_Identifier)
	{
		this.ontologyTerms_Identifier = ontologyTerms_Identifier;
	}		
	 
	

	/**
	 * Get the .
	 * @return citation.
	 */
	public org.molgenis.organization.Citation getCitation()
	{
		return this.citation;
	}
	
	@Deprecated
	public org.molgenis.organization.Citation getCitation(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the .
	 * @param citation
	 */
	public void setCitation( org.molgenis.organization.Citation citation)
	{
		
		this.citation = citation;
	}

	
	
	/**
	 * Set foreign key for field citation.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setCitation_Id(Integer citation_id)
	{
		this.citation_id = citation_id;
	}	

	public void setCitation(Integer citation_id)
	{
		this.citation_id = citation_id;
	}
	
	public Integer getCitation_Id()
	{
		
		if(citation != null) 
		{
			return citation.getId();
		}
		else
		{
			return citation_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference Citation to Citation.Id.
	 */
	public String getCitation_Identifier()
	{		
		//FIXME should we auto-load based on getCitation()?	
		if(citation != null) {
			return citation.getIdentifier();
		} else {
			return citation_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Citation to <a href="Citation.html#Id">Citation.Id</a>.
	 * Implies setCitation(null) until save
	 */
	public void setCitation_Identifier(String citation_Identifier)
	{
		this.citation_Identifier = citation_Identifier;
	}		
	 
	


	/**
	 * Generic getter. Get the property by using the name.
	 */
	public Object get(String name)
	{
		name = name.toLowerCase();
		if (name.toLowerCase().equals("autoid"))
			return getAutoid();
		if (name.toLowerCase().equals("ontologyterms"))
			return getOntologyTerms();
		if(name.toLowerCase().equals("ontologyterms_id"))
			return getOntologyTerms_Id();
		if(name.toLowerCase().equals("ontologyterms_identifier"))
			return getOntologyTerms_Identifier();
		if (name.toLowerCase().equals("citation"))
			return getCitation();
		if(name.toLowerCase().equals("citation_id"))
			return getCitation_Id();
		if(name.toLowerCase().equals("citation_identifier"))
			return getCitation_Identifier();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getAutoid() == null) throw new org.molgenis.framework.db.DatabaseException("required field autoid is null");
		if(this.getOntologyTerms() == null) throw new org.molgenis.framework.db.DatabaseException("required field ontologyTerms is null");
		if(this.getCitation() == null) throw new org.molgenis.framework.db.DatabaseException("required field citation is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.util.Tuple tuple, boolean strict )  throws Exception
	{
		//optimization :-(
		if(tuple instanceof org.molgenis.util.ResultSetTuple)
		{
				//set Autoid
			this.setAutoid(tuple.getInt("autoid"));
			//set OntologyTerms
			this.setOntologyTerms(tuple.getInt("ontologyTerms"));
			//set label Identifier for xref field OntologyTerms
			this.setOntologyTerms_Identifier(tuple.getString("ontologyTerms_Identifier"));	
			//set Citation
			this.setCitation(tuple.getInt("Citation"));
			//set label Identifier for xref field Citation
			this.setCitation_Identifier(tuple.getString("Citation_Identifier"));	
		}
		else if(tuple != null)
		{
			//set Autoid
			if( strict || tuple.getInt("autoid") != null) this.setAutoid(tuple.getInt("autoid"));
			if( tuple.getInt("Citation_ontologyTerms_autoid") != null) this.setAutoid(tuple.getInt("Citation_ontologyTerms_autoid"));
			//set OntologyTerms
			if( strict || tuple.getInt("ontologyTerms_id") != null) this.setOntologyTerms(tuple.getInt("ontologyTerms_id"));
			if( tuple.getInt("Citation_ontologyTerms_ontologyTerms_id") != null) this.setOntologyTerms(tuple.getInt("Citation_ontologyTerms_ontologyTerms_id"));
			//alias of xref
			if( tuple.getObject("ontologyTerms") != null) this.setOntologyTerms(tuple.getInt("ontologyTerms"));
			if( tuple.getObject("Citation_ontologyTerms_ontologyTerms") != null) this.setOntologyTerms(tuple.getInt("Citation_ontologyTerms_ontologyTerms"));
			//set label for field OntologyTerms
			if( strict || tuple.getObject("ontologyTerms_Identifier") != null) this.setOntologyTerms_Identifier(tuple.getString("ontologyTerms_Identifier"));			
			if( tuple.getObject("Citation_ontologyTerms_ontologyTerms_Identifier") != null ) this.setOntologyTerms_Identifier(tuple.getString("Citation_ontologyTerms_ontologyTerms_Identifier"));		
			//set Citation
			if( strict || tuple.getInt("Citation_id") != null) this.setCitation(tuple.getInt("Citation_id"));
			if( tuple.getInt("Citation_ontologyTerms_Citation_id") != null) this.setCitation(tuple.getInt("Citation_ontologyTerms_Citation_id"));
			//alias of xref
			if( tuple.getObject("Citation") != null) this.setCitation(tuple.getInt("Citation"));
			if( tuple.getObject("Citation_ontologyTerms_Citation") != null) this.setCitation(tuple.getInt("Citation_ontologyTerms_Citation"));
			//set label for field Citation
			if( strict || tuple.getObject("Citation_Identifier") != null) this.setCitation_Identifier(tuple.getString("Citation_Identifier"));			
			if( tuple.getObject("Citation_ontologyTerms_Citation_Identifier") != null ) this.setCitation_Identifier(tuple.getString("Citation_ontologyTerms_Citation_Identifier"));		
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
		String result = "Citation_OntologyTerms(";
		result+= "autoid='" + getAutoid()+"' ";	
		result+= " ontologyTerms_id='" + getOntologyTerms_Id()+"' ";	
		result+= " ontologyTerms_identifier='" + getOntologyTerms_Identifier()+"' ";
		result+= " citation_id='" + getCitation_Id()+"' ";	
		result+= " citation_identifier='" + getCitation_Identifier()+"' ";
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Citation_OntologyTerms.
	 */
	public java.util.Vector<String> getFields(boolean skipAutoIds)
	{
		java.util.Vector<String> fields = new java.util.Vector<String>();
		if(!skipAutoIds)
		{
			fields.add("autoid");
		}
		{
			fields.add("ontologyTerms_id");
		}
		fields.add("ontologyTerms_identifier");
		{
			fields.add("citation_id");
		}
		fields.add("citation_identifier");
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
		result.add("ontologyTerms");
		result.add("Citation");
		return result;
	}

	@Deprecated
	public String getFields(String sep)
	{
		return (""
		+ "autoid" +sep
		+ "ontologyTerms" +sep
		+ "citation" 
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
        if (fieldName.equalsIgnoreCase("citation")) {
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
		Citation_OntologyTerms rhs = (Citation_OntologyTerms) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
		//ontologyTerms
		//citation
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
			Object valueO = getCitation();
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
	public Citation_OntologyTerms create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Citation_OntologyTerms e = new Citation_OntologyTerms();
		e.set(tuple);
		return e;
	}
	

	
}

