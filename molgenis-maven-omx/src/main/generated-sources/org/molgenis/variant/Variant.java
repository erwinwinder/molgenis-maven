
/* File:        org.molgenis/model/Variant.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.variant;

/**
 * Variant: Convenient entity to define in one place variants on
				gdna, cdna and aa level.
			
.
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "Variant"
)

@org.hibernate.annotations.Table(appliesTo="Variant", indexes={
    @org.hibernate.annotations.Index(name="gdna_notation", columnNames={
	"gdna_notation"
    }),
    @org.hibernate.annotations.Index(name="cdna_notation", columnNames={
	"cdna_notation"
    }),
    @org.hibernate.annotations.Index(name="aa_notation", columnNames={
	"aa_notation"
    }),
    @org.hibernate.annotations.Index(name="gdna_start", columnNames={
	"gdna_start"
    }),
    @org.hibernate.annotations.Index(name="cdna_start", columnNames={
	"cdna_start"
    }),
    @org.hibernate.annotations.Index(name="aa_start", columnNames={
	"aa_start"
    })
})

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.variant.db.VariantEntityListener.class})
public class Variant extends org.molgenis.observ.Characteristic implements org.molgenis.variant.GdnaPosition, org.molgenis.variant.CdnaPosition, org.molgenis.variant.AaPosition
{
	// fieldname constants
	public final static String GDNA = "gdna";
	public final static String GDNA_IDENTIFIER = "gdna_Identifier";
	public final static String GDNA_START = "gdna_start";
	public final static String GDNA_END = "gdna_end";
	public final static String CDNA = "cdna";
	public final static String CDNA_IDENTIFIER = "cdna_Identifier";
	public final static String CDNA_START = "cdna_start";
	public final static String CDNA_END = "cdna_end";
	public final static String AA = "aa";
	public final static String AA_IDENTIFIER = "aa_Identifier";
	public final static String AA_START = "aa_start";
	public final static String AA_END = "aa_end";
	public final static String GDNA_NOTATION = "gdna_notation";
	public final static String CDNA_NOTATION = "cdna_notation";
	public final static String AA_NOTATION = "aa_notation";
	public final static String VARIANTTYPE = "variantType";
	public final static String VARIANTTYPE_IDENTIFIER = "variantType_Identifier";
	public final static String ID = "id";
	
	//static methods
	/**
	 * Shorthand for db.query(Variant.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Variant> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Variant.class);
	}
	
	/**
	 * Shorthand for db.find(Variant.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Variant> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Variant.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Variant findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Variant> q = db.query(Variant.class);
		q.eq(Variant.ID, id);
		java.util.List<Variant> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Variant findByIdentifier(org.molgenis.framework.db.Database db, String identifier) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Variant> q = db.query(Variant.class);
		q.eq(Variant.IDENTIFIER, identifier);
		java.util.List<Variant> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//The genome this element lies on.[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="gdna")   	
	
				

	private org.molgenis.variant.Chromosome gdna = null;
	@javax.persistence.Transient
	private Integer gdna_id = null;	
	@javax.persistence.Transient
	private String gdna_Identifier = null;						


	//Start position on genomic sequence.[type=int]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="gdna_start")
	@javax.xml.bind.annotation.XmlElement(name="gdna_start")
	
				

	private Integer gdna_start =  null;


	//End position on genomic sequence.[type=int]
	@javax.persistence.Column(name="gdna_end")
	@javax.xml.bind.annotation.XmlElement(name="gdna_end")
	
				

	private Integer gdna_end =  null;


	//The gene this element lies on.[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="cdna")   	
	
				

	private org.molgenis.variant.Gene cdna = null;
	@javax.persistence.Transient
	private Integer cdna_id = null;	
	@javax.persistence.Transient
	private String cdna_Identifier = null;						


	//Start position on cDNA sequence.[type=int]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="cdna_start")
	@javax.xml.bind.annotation.XmlElement(name="cdna_start")
	
				

	private Integer cdna_start =  null;


	//End position on cDNA sequence.[type=int]
	@javax.persistence.Column(name="cdna_end")
	@javax.xml.bind.annotation.XmlElement(name="cdna_end")
	
				

	private Integer cdna_end =  null;


	//The protein sequence this element lies on.[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="aa")   	
	
				

	private org.molgenis.variant.Protein aa = null;
	@javax.persistence.Transient
	private Integer aa_id = null;	
	@javax.persistence.Transient
	private String aa_Identifier = null;						


	//Start position on amino acid sequence.[type=int]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="aa_start")
	@javax.xml.bind.annotation.XmlElement(name="aa_start")
	
				

	private Integer aa_start =  null;


	//End position on amino acid sequence.[type=int]
	@javax.persistence.Column(name="aa_end")
	@javax.xml.bind.annotation.XmlElement(name="aa_end")
	
				

	private Integer aa_end =  null;


	//gDNA notation of the variant, e.g. g.1234567C>T[type=string]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="gdna_notation", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="gdna_notation")
	
				

	@javax.validation.constraints.NotNull
	private String gdna_notation =  null;


	//cDNA notation of the variant, e.g. c.123C>T[type=string]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="cdna_notation", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="cdna_notation")
	
				

	@javax.validation.constraints.NotNull
	private String cdna_notation =  null;


	//Aa notation of the variant, e.g. p.Ser123ArgfsX12[type=string]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="aa_notation")
	@javax.xml.bind.annotation.XmlElement(name="aa_notation")
	
				

	private String aa_notation =  null;


	//Type of the variant.[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="variantType")   	
	
				

	private org.molgenis.observ.target.OntologyTerm variantType = null;
	@javax.persistence.Transient
	private Integer variantType_id = null;	
	@javax.persistence.Transient
	private String variantType_Identifier = null;						


	//automatically generated internal id, only for internal use.[type=int]
	

	//constructors
	public Variant()
	{
		//set the type for a new instance
		set__Type(this.getClass().getSimpleName());
	
	}
	
	//getters and setters
	/**
	 * Get the The genome this element lies on..
	 * @return gdna.
	 */
	public org.molgenis.variant.Chromosome getGdna()
	{
		return this.gdna;
	}
	
	@Deprecated
	public org.molgenis.variant.Chromosome getGdna(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the The genome this element lies on..
	 * @param gdna
	 */
	public void setGdna( org.molgenis.variant.Chromosome gdna)
	{
		
		this.gdna = gdna;
	}

	
	
	/**
	 * Set foreign key for field gdna.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setGdna_Id(Integer gdna_id)
	{
		this.gdna_id = gdna_id;
	}	

	public void setGdna(Integer gdna_id)
	{
		this.gdna_id = gdna_id;
	}
	
	public Integer getGdna_Id()
	{
		
		if(gdna != null) 
		{
			return gdna.getId();
		}
		else
		{
			return gdna_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference Gdna to Chromosome.Id.
	 */
	public String getGdna_Identifier()
	{		
		//FIXME should we auto-load based on getGdna()?	
		if(gdna != null) {
			return gdna.getIdentifier();
		} else {
			return gdna_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Gdna to <a href="Chromosome.html#Id">Chromosome.Id</a>.
	 * Implies setGdna(null) until save
	 */
	public void setGdna_Identifier(String gdna_Identifier)
	{
		this.gdna_Identifier = gdna_Identifier;
	}		
	 
	

	/**
	 * Get the Start position on genomic sequence..
	 * @return gdna_start.
	 */
	public Integer getGdna_Start()
	{
		return this.gdna_start;
	}
	
	@Deprecated
	public Integer getGdna_Start(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Start position on genomic sequence..
	 * @param gdna_start
	 */
	public void setGdna_Start( Integer gdna_start)
	{
		
		this.gdna_start = gdna_start;
	}

	

	/**
	 * Get the End position on genomic sequence..
	 * @return gdna_end.
	 */
	public Integer getGdna_End()
	{
		return this.gdna_end;
	}
	
	@Deprecated
	public Integer getGdna_End(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the End position on genomic sequence..
	 * @param gdna_end
	 */
	public void setGdna_End( Integer gdna_end)
	{
		
		this.gdna_end = gdna_end;
	}

	

	/**
	 * Get the The gene this element lies on..
	 * @return cdna.
	 */
	public org.molgenis.variant.Gene getCdna()
	{
		return this.cdna;
	}
	
	@Deprecated
	public org.molgenis.variant.Gene getCdna(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the The gene this element lies on..
	 * @param cdna
	 */
	public void setCdna( org.molgenis.variant.Gene cdna)
	{
		
		this.cdna = cdna;
	}

	
	
	/**
	 * Set foreign key for field cdna.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setCdna_Id(Integer cdna_id)
	{
		this.cdna_id = cdna_id;
	}	

	public void setCdna(Integer cdna_id)
	{
		this.cdna_id = cdna_id;
	}
	
	public Integer getCdna_Id()
	{
		
		if(cdna != null) 
		{
			return cdna.getId();
		}
		else
		{
			return cdna_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference Cdna to Gene.Id.
	 */
	public String getCdna_Identifier()
	{		
		//FIXME should we auto-load based on getCdna()?	
		if(cdna != null) {
			return cdna.getIdentifier();
		} else {
			return cdna_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Cdna to <a href="Gene.html#Id">Gene.Id</a>.
	 * Implies setCdna(null) until save
	 */
	public void setCdna_Identifier(String cdna_Identifier)
	{
		this.cdna_Identifier = cdna_Identifier;
	}		
	 
	

	/**
	 * Get the Start position on cDNA sequence..
	 * @return cdna_start.
	 */
	public Integer getCdna_Start()
	{
		return this.cdna_start;
	}
	
	@Deprecated
	public Integer getCdna_Start(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Start position on cDNA sequence..
	 * @param cdna_start
	 */
	public void setCdna_Start( Integer cdna_start)
	{
		
		this.cdna_start = cdna_start;
	}

	

	/**
	 * Get the End position on cDNA sequence..
	 * @return cdna_end.
	 */
	public Integer getCdna_End()
	{
		return this.cdna_end;
	}
	
	@Deprecated
	public Integer getCdna_End(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the End position on cDNA sequence..
	 * @param cdna_end
	 */
	public void setCdna_End( Integer cdna_end)
	{
		
		this.cdna_end = cdna_end;
	}

	

	/**
	 * Get the The protein sequence this element lies on..
	 * @return aa.
	 */
	public org.molgenis.variant.Protein getAa()
	{
		return this.aa;
	}
	
	@Deprecated
	public org.molgenis.variant.Protein getAa(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the The protein sequence this element lies on..
	 * @param aa
	 */
	public void setAa( org.molgenis.variant.Protein aa)
	{
		
		this.aa = aa;
	}

	
	
	/**
	 * Set foreign key for field aa.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setAa_Id(Integer aa_id)
	{
		this.aa_id = aa_id;
	}	

	public void setAa(Integer aa_id)
	{
		this.aa_id = aa_id;
	}
	
	public Integer getAa_Id()
	{
		
		if(aa != null) 
		{
			return aa.getId();
		}
		else
		{
			return aa_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference Aa to Protein.Id.
	 */
	public String getAa_Identifier()
	{		
		//FIXME should we auto-load based on getAa()?	
		if(aa != null) {
			return aa.getIdentifier();
		} else {
			return aa_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Aa to <a href="Protein.html#Id">Protein.Id</a>.
	 * Implies setAa(null) until save
	 */
	public void setAa_Identifier(String aa_Identifier)
	{
		this.aa_Identifier = aa_Identifier;
	}		
	 
	

	/**
	 * Get the Start position on amino acid sequence..
	 * @return aa_start.
	 */
	public Integer getAa_Start()
	{
		return this.aa_start;
	}
	
	@Deprecated
	public Integer getAa_Start(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Start position on amino acid sequence..
	 * @param aa_start
	 */
	public void setAa_Start( Integer aa_start)
	{
		
		this.aa_start = aa_start;
	}

	

	/**
	 * Get the End position on amino acid sequence..
	 * @return aa_end.
	 */
	public Integer getAa_End()
	{
		return this.aa_end;
	}
	
	@Deprecated
	public Integer getAa_End(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the End position on amino acid sequence..
	 * @param aa_end
	 */
	public void setAa_End( Integer aa_end)
	{
		
		this.aa_end = aa_end;
	}

	

	/**
	 * Get the gDNA notation of the variant, e.g. g.1234567C>T.
	 * @return gdna_notation.
	 */
	public String getGdna_Notation()
	{
		return this.gdna_notation;
	}
	
	@Deprecated
	public String getGdna_Notation(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the gDNA notation of the variant, e.g. g.1234567C>T.
	 * @param gdna_notation
	 */
	public void setGdna_Notation( String gdna_notation)
	{
		
		this.gdna_notation = gdna_notation;
	}

	

	/**
	 * Get the cDNA notation of the variant, e.g. c.123C>T.
	 * @return cdna_notation.
	 */
	public String getCdna_Notation()
	{
		return this.cdna_notation;
	}
	
	@Deprecated
	public String getCdna_Notation(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the cDNA notation of the variant, e.g. c.123C>T.
	 * @param cdna_notation
	 */
	public void setCdna_Notation( String cdna_notation)
	{
		
		this.cdna_notation = cdna_notation;
	}

	

	/**
	 * Get the Aa notation of the variant, e.g. p.Ser123ArgfsX12.
	 * @return aa_notation.
	 */
	public String getAa_Notation()
	{
		return this.aa_notation;
	}
	
	@Deprecated
	public String getAa_Notation(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Aa notation of the variant, e.g. p.Ser123ArgfsX12.
	 * @param aa_notation
	 */
	public void setAa_Notation( String aa_notation)
	{
		
		this.aa_notation = aa_notation;
	}

	

	/**
	 * Get the Type of the variant..
	 * @return variantType.
	 */
	public org.molgenis.observ.target.OntologyTerm getVariantType()
	{
		return this.variantType;
	}
	
	@Deprecated
	public org.molgenis.observ.target.OntologyTerm getVariantType(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Type of the variant..
	 * @param variantType
	 */
	public void setVariantType( org.molgenis.observ.target.OntologyTerm variantType)
	{
		
		this.variantType = variantType;
	}

	
	
	/**
	 * Set foreign key for field variantType.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setVariantType_Id(Integer variantType_id)
	{
		this.variantType_id = variantType_id;
	}	

	public void setVariantType(Integer variantType_id)
	{
		this.variantType_id = variantType_id;
	}
	
	public Integer getVariantType_Id()
	{
		
		if(variantType != null) 
		{
			return variantType.getId();
		}
		else
		{
			return variantType_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference VariantType to OntologyTerm.Id.
	 */
	public String getVariantType_Identifier()
	{		
		//FIXME should we auto-load based on getVariantType()?	
		if(variantType != null) {
			return variantType.getIdentifier();
		} else {
			return variantType_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference VariantType to <a href="OntologyTerm.html#Id">OntologyTerm.Id</a>.
	 * Implies setVariantType(null) until save
	 */
	public void setVariantType_Identifier(String variantType_Identifier)
	{
		this.variantType_Identifier = variantType_Identifier;
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
		if (name.toLowerCase().equals("gdna"))
			return getGdna();
		if(name.toLowerCase().equals("gdna_id"))
			return getGdna_Id();
		if(name.toLowerCase().equals("gdna_identifier"))
			return getGdna_Identifier();
		if (name.toLowerCase().equals("gdna_start"))
			return getGdna_Start();
		if (name.toLowerCase().equals("gdna_end"))
			return getGdna_End();
		if (name.toLowerCase().equals("cdna"))
			return getCdna();
		if(name.toLowerCase().equals("cdna_id"))
			return getCdna_Id();
		if(name.toLowerCase().equals("cdna_identifier"))
			return getCdna_Identifier();
		if (name.toLowerCase().equals("cdna_start"))
			return getCdna_Start();
		if (name.toLowerCase().equals("cdna_end"))
			return getCdna_End();
		if (name.toLowerCase().equals("aa"))
			return getAa();
		if(name.toLowerCase().equals("aa_id"))
			return getAa_Id();
		if(name.toLowerCase().equals("aa_identifier"))
			return getAa_Identifier();
		if (name.toLowerCase().equals("aa_start"))
			return getAa_Start();
		if (name.toLowerCase().equals("aa_end"))
			return getAa_End();
		if (name.toLowerCase().equals("gdna_notation"))
			return getGdna_Notation();
		if (name.toLowerCase().equals("cdna_notation"))
			return getCdna_Notation();
		if (name.toLowerCase().equals("aa_notation"))
			return getAa_Notation();
		if (name.toLowerCase().equals("varianttype"))
			return getVariantType();
		if(name.toLowerCase().equals("varianttype_id"))
			return getVariantType_Id();
		if(name.toLowerCase().equals("varianttype_identifier"))
			return getVariantType_Identifier();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getIdentifier() == null) throw new org.molgenis.framework.db.DatabaseException("required field identifier is null");
		if(this.getName() == null) throw new org.molgenis.framework.db.DatabaseException("required field name is null");
		if(this.get__Type() == null) throw new org.molgenis.framework.db.DatabaseException("required field __Type is null");
		if(this.getGdna_Notation() == null) throw new org.molgenis.framework.db.DatabaseException("required field gdna_notation is null");
		if(this.getCdna_Notation() == null) throw new org.molgenis.framework.db.DatabaseException("required field cdna_notation is null");
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
			//set Gdna
			this.setGdna(tuple.getInt("gdna"));
			//set label Identifier for xref field Gdna
			this.setGdna_Identifier(tuple.getString("gdna_Identifier"));	
			//set Gdna_Start
			this.setGdna_Start(tuple.getInt("gdna_start"));
			//set Gdna_End
			this.setGdna_End(tuple.getInt("gdna_end"));
			//set Cdna
			this.setCdna(tuple.getInt("cdna"));
			//set label Identifier for xref field Cdna
			this.setCdna_Identifier(tuple.getString("cdna_Identifier"));	
			//set Cdna_Start
			this.setCdna_Start(tuple.getInt("cdna_start"));
			//set Cdna_End
			this.setCdna_End(tuple.getInt("cdna_end"));
			//set Aa
			this.setAa(tuple.getInt("aa"));
			//set label Identifier for xref field Aa
			this.setAa_Identifier(tuple.getString("aa_Identifier"));	
			//set Aa_Start
			this.setAa_Start(tuple.getInt("aa_start"));
			//set Aa_End
			this.setAa_End(tuple.getInt("aa_end"));
			//set Gdna_Notation
			this.setGdna_Notation(tuple.getString("gdna_notation"));
			//set Cdna_Notation
			this.setCdna_Notation(tuple.getString("cdna_notation"));
			//set Aa_Notation
			this.setAa_Notation(tuple.getString("aa_notation"));
			//set VariantType
			this.setVariantType(tuple.getInt("variantType"));
			//set label Identifier for xref field VariantType
			this.setVariantType_Identifier(tuple.getString("variantType_Identifier"));	
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("Variant_id") != null) this.setId(tuple.getInt("Variant_id"));
			//set Identifier
			if( strict || tuple.getString("Identifier") != null) this.setIdentifier(tuple.getString("Identifier"));
			if( tuple.getString("Variant_Identifier") != null) this.setIdentifier(tuple.getString("Variant_Identifier"));
			//set Name
			if( strict || tuple.getString("Name") != null) this.setName(tuple.getString("Name"));
			if( tuple.getString("Variant_Name") != null) this.setName(tuple.getString("Variant_Name"));
			//set __Type
			if( strict || tuple.getString("__Type") != null) this.set__Type(tuple.getString("__Type"));
			if( tuple.getString("Variant___Type") != null) this.set__Type(tuple.getString("Variant___Type"));
			//set Description
			if( strict || tuple.getString("description") != null) this.setDescription(tuple.getString("description"));
			if( tuple.getString("Variant_description") != null) this.setDescription(tuple.getString("Variant_description"));
			//set Gdna
			if( strict || tuple.getInt("gdna_id") != null) this.setGdna(tuple.getInt("gdna_id"));
			if( tuple.getInt("Variant_gdna_id") != null) this.setGdna(tuple.getInt("Variant_gdna_id"));
			//alias of xref
			if( tuple.getObject("gdna") != null) this.setGdna(tuple.getInt("gdna"));
			if( tuple.getObject("Variant_gdna") != null) this.setGdna(tuple.getInt("Variant_gdna"));
			//set label for field Gdna
			if( strict || tuple.getObject("gdna_Identifier") != null) this.setGdna_Identifier(tuple.getString("gdna_Identifier"));			
			if( tuple.getObject("Variant_gdna_Identifier") != null ) this.setGdna_Identifier(tuple.getString("Variant_gdna_Identifier"));		
			//set Gdna_Start
			if( strict || tuple.getInt("gdna_start") != null) this.setGdna_Start(tuple.getInt("gdna_start"));
			if( tuple.getInt("Variant_gdna_start") != null) this.setGdna_Start(tuple.getInt("Variant_gdna_start"));
			//set Gdna_End
			if( strict || tuple.getInt("gdna_end") != null) this.setGdna_End(tuple.getInt("gdna_end"));
			if( tuple.getInt("Variant_gdna_end") != null) this.setGdna_End(tuple.getInt("Variant_gdna_end"));
			//set Cdna
			if( strict || tuple.getInt("cdna_id") != null) this.setCdna(tuple.getInt("cdna_id"));
			if( tuple.getInt("Variant_cdna_id") != null) this.setCdna(tuple.getInt("Variant_cdna_id"));
			//alias of xref
			if( tuple.getObject("cdna") != null) this.setCdna(tuple.getInt("cdna"));
			if( tuple.getObject("Variant_cdna") != null) this.setCdna(tuple.getInt("Variant_cdna"));
			//set label for field Cdna
			if( strict || tuple.getObject("cdna_Identifier") != null) this.setCdna_Identifier(tuple.getString("cdna_Identifier"));			
			if( tuple.getObject("Variant_cdna_Identifier") != null ) this.setCdna_Identifier(tuple.getString("Variant_cdna_Identifier"));		
			//set Cdna_Start
			if( strict || tuple.getInt("cdna_start") != null) this.setCdna_Start(tuple.getInt("cdna_start"));
			if( tuple.getInt("Variant_cdna_start") != null) this.setCdna_Start(tuple.getInt("Variant_cdna_start"));
			//set Cdna_End
			if( strict || tuple.getInt("cdna_end") != null) this.setCdna_End(tuple.getInt("cdna_end"));
			if( tuple.getInt("Variant_cdna_end") != null) this.setCdna_End(tuple.getInt("Variant_cdna_end"));
			//set Aa
			if( strict || tuple.getInt("aa_id") != null) this.setAa(tuple.getInt("aa_id"));
			if( tuple.getInt("Variant_aa_id") != null) this.setAa(tuple.getInt("Variant_aa_id"));
			//alias of xref
			if( tuple.getObject("aa") != null) this.setAa(tuple.getInt("aa"));
			if( tuple.getObject("Variant_aa") != null) this.setAa(tuple.getInt("Variant_aa"));
			//set label for field Aa
			if( strict || tuple.getObject("aa_Identifier") != null) this.setAa_Identifier(tuple.getString("aa_Identifier"));			
			if( tuple.getObject("Variant_aa_Identifier") != null ) this.setAa_Identifier(tuple.getString("Variant_aa_Identifier"));		
			//set Aa_Start
			if( strict || tuple.getInt("aa_start") != null) this.setAa_Start(tuple.getInt("aa_start"));
			if( tuple.getInt("Variant_aa_start") != null) this.setAa_Start(tuple.getInt("Variant_aa_start"));
			//set Aa_End
			if( strict || tuple.getInt("aa_end") != null) this.setAa_End(tuple.getInt("aa_end"));
			if( tuple.getInt("Variant_aa_end") != null) this.setAa_End(tuple.getInt("Variant_aa_end"));
			//set Gdna_Notation
			if( strict || tuple.getString("gdna_notation") != null) this.setGdna_Notation(tuple.getString("gdna_notation"));
			if( tuple.getString("Variant_gdna_notation") != null) this.setGdna_Notation(tuple.getString("Variant_gdna_notation"));
			//set Cdna_Notation
			if( strict || tuple.getString("cdna_notation") != null) this.setCdna_Notation(tuple.getString("cdna_notation"));
			if( tuple.getString("Variant_cdna_notation") != null) this.setCdna_Notation(tuple.getString("Variant_cdna_notation"));
			//set Aa_Notation
			if( strict || tuple.getString("aa_notation") != null) this.setAa_Notation(tuple.getString("aa_notation"));
			if( tuple.getString("Variant_aa_notation") != null) this.setAa_Notation(tuple.getString("Variant_aa_notation"));
			//set VariantType
			if( strict || tuple.getInt("variantType_id") != null) this.setVariantType(tuple.getInt("variantType_id"));
			if( tuple.getInt("Variant_variantType_id") != null) this.setVariantType(tuple.getInt("Variant_variantType_id"));
			//alias of xref
			if( tuple.getObject("variantType") != null) this.setVariantType(tuple.getInt("variantType"));
			if( tuple.getObject("Variant_variantType") != null) this.setVariantType(tuple.getInt("Variant_variantType"));
			//set label for field VariantType
			if( strict || tuple.getObject("variantType_Identifier") != null) this.setVariantType_Identifier(tuple.getString("variantType_Identifier"));			
			if( tuple.getObject("Variant_variantType_Identifier") != null ) this.setVariantType_Identifier(tuple.getString("Variant_variantType_Identifier"));		
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
		String result = "Variant(";
		result+= "id='" + getId()+"' ";	
		result+= "identifier='" + getIdentifier()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= "__Type='" + get__Type()+"' ";	
		result+= "description='" + getDescription()+"' ";	
		result+= " gdna_id='" + getGdna_Id()+"' ";	
		result+= " gdna_identifier='" + getGdna_Identifier()+"' ";
		result+= "gdna_start='" + getGdna_Start()+"' ";	
		result+= "gdna_end='" + getGdna_End()+"' ";	
		result+= " cdna_id='" + getCdna_Id()+"' ";	
		result+= " cdna_identifier='" + getCdna_Identifier()+"' ";
		result+= "cdna_start='" + getCdna_Start()+"' ";	
		result+= "cdna_end='" + getCdna_End()+"' ";	
		result+= " aa_id='" + getAa_Id()+"' ";	
		result+= " aa_identifier='" + getAa_Identifier()+"' ";
		result+= "aa_start='" + getAa_Start()+"' ";	
		result+= "aa_end='" + getAa_End()+"' ";	
		result+= "gdna_notation='" + getGdna_Notation()+"' ";	
		result+= "cdna_notation='" + getCdna_Notation()+"' ";	
		result+= "aa_notation='" + getAa_Notation()+"' ";	
		result+= " variantType_id='" + getVariantType_Id()+"' ";	
		result+= " variantType_identifier='" + getVariantType_Identifier()+"' ";
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Variant.
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
			fields.add("gdna_id");
		}
		fields.add("gdna_identifier");
		{
			fields.add("gdna_start");
		}
		{
			fields.add("gdna_end");
		}
		{
			fields.add("cdna_id");
		}
		fields.add("cdna_identifier");
		{
			fields.add("cdna_start");
		}
		{
			fields.add("cdna_end");
		}
		{
			fields.add("aa_id");
		}
		fields.add("aa_identifier");
		{
			fields.add("aa_start");
		}
		{
			fields.add("aa_end");
		}
		{
			fields.add("gdna_notation");
		}
		{
			fields.add("cdna_notation");
		}
		{
			fields.add("aa_notation");
		}
		{
			fields.add("variantType_id");
		}
		fields.add("variantType_identifier");
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
		+ "gdna" +sep
		+ "gdna_start" +sep
		+ "gdna_end" +sep
		+ "cdna" +sep
		+ "cdna_start" +sep
		+ "cdna_end" +sep
		+ "aa" +sep
		+ "aa_start" +sep
		+ "aa_end" +sep
		+ "gdna_notation" +sep
		+ "cdna_notation" +sep
		+ "aa_notation" +sep
		+ "variantType" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("gdna")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("cdna")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("aa")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("variantType")) {
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
		Variant rhs = (Variant) obj;
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
			Object valueO = getGdna();
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
			Object valueO = getGdna_Start();
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
			Object valueO = getGdna_End();
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
			Object valueO = getCdna();
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
			Object valueO = getCdna_Start();
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
			Object valueO = getCdna_End();
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
			Object valueO = getAa();
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
			Object valueO = getAa_Start();
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
			Object valueO = getAa_End();
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
			Object valueO = getGdna_Notation();
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
			Object valueO = getCdna_Notation();
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
			Object valueO = getAa_Notation();
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
			Object valueO = getVariantType();
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
	public Variant create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Variant e = new Variant();
		e.set(tuple);
		return e;
	}
	

	
}

