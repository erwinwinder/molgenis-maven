
/* File:        org.molgenis/model/Chromosome.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.variant;

/**
 * Chromosome: Example: b37:chr1.
.
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "Chromosome"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.variant.db.ChromosomeEntityListener.class})
public class Chromosome extends org.molgenis.observ.Characteristic implements org.molgenis.variant.BioSequence
{
	// fieldname constants
	public final static String RESIDUES = "residues";
	public final static String SEQLEN = "seqlen";
	public final static String GENOME = "genome";
	public final static String GENOME_IDENTIFIER = "genome_Identifier";
	public final static String ORDERNR = "orderNr";
	public final static String ISAUTOSOMAL = "isAutosomal";
	public final static String ID = "id";
	
	//static methods
	/**
	 * Shorthand for db.query(Chromosome.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Chromosome> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Chromosome.class);
	}
	
	/**
	 * Shorthand for db.find(Chromosome.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Chromosome> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Chromosome.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Chromosome findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Chromosome> q = db.query(Chromosome.class);
		q.eq(Chromosome.ID, id);
		java.util.List<Chromosome> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Chromosome findByIdentifier(org.molgenis.framework.db.Database db, String identifier) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Chromosome> q = db.query(Chromosome.class);
		q.eq(Chromosome.IDENTIFIER, identifier);
		java.util.List<Chromosome> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//A sequence of alphabetic characters representing biological residues (nucleic acids, amino acids). This column does not need to be manifested for all features; it is optional for features such as exons where the residues can be derived from the featureloc. It is recommended that the value for this column be manifested for features which may may non-contiguous sublocations (e.g. transcripts), since derivation at query time is non-trivial. For expressed sequence, the DNA sequence should be used rather than the RNA sequence.[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="residues", length=16777216)
	
				

	private String residues =  null;


	//The length of the residue feature. See column:residues. This column is partially redundant with the residues column, and also with featureloc. This column is required because the location may be unknown and the residue sequence may not be manifested, yet it may be desirable to store and query the length of the feature. The seqlen should always be manifested where the length of the sequence is known.[type=int]
	@javax.persistence.Column(name="seqlen")
	@javax.xml.bind.annotation.XmlElement(name="seqlen")
	
				

	private Integer seqlen =  null;


	//genome[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="genome", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.variant.Genome genome = null;
	@javax.persistence.Transient
	private Integer genome_id = null;	
	@javax.persistence.Transient
	private String genome_Identifier = null;						


	//orderNr[type=int]
	@javax.persistence.Column(name="orderNr", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="orderNr")
	
				

	@javax.validation.constraints.NotNull
	private Integer orderNr =  null;


	//Is 'yes' when number of chromosomes is equal in male and female individuals, i.e., if not a sex chromosome.[type=bool]
	@javax.persistence.Column(name="isAutosomal", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="isAutosomal")
	
				

	@javax.validation.constraints.NotNull
	private Boolean isAutosomal =  null;


	//automatically generated internal id, only for internal use.[type=int]
	

	//constructors
	public Chromosome()
	{
		//set the type for a new instance
		set__Type(this.getClass().getSimpleName());
	
	}
	
	//getters and setters
	/**
	 * Get the A sequence of alphabetic characters representing biological residues (nucleic acids, amino acids). This column does not need to be manifested for all features; it is optional for features such as exons where the residues can be derived from the featureloc. It is recommended that the value for this column be manifested for features which may may non-contiguous sublocations (e.g. transcripts), since derivation at query time is non-trivial. For expressed sequence, the DNA sequence should be used rather than the RNA sequence..
	 * @return residues.
	 */
	public String getResidues()
	{
		return this.residues;
	}
	
	@Deprecated
	public String getResidues(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the A sequence of alphabetic characters representing biological residues (nucleic acids, amino acids). This column does not need to be manifested for all features; it is optional for features such as exons where the residues can be derived from the featureloc. It is recommended that the value for this column be manifested for features which may may non-contiguous sublocations (e.g. transcripts), since derivation at query time is non-trivial. For expressed sequence, the DNA sequence should be used rather than the RNA sequence..
	 * @param residues
	 */
	public void setResidues( String residues)
	{
		
		this.residues = residues;
	}

	

	/**
	 * Get the The length of the residue feature. See column:residues. This column is partially redundant with the residues column, and also with featureloc. This column is required because the location may be unknown and the residue sequence may not be manifested, yet it may be desirable to store and query the length of the feature. The seqlen should always be manifested where the length of the sequence is known..
	 * @return seqlen.
	 */
	public Integer getSeqlen()
	{
		return this.seqlen;
	}
	
	@Deprecated
	public Integer getSeqlen(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the The length of the residue feature. See column:residues. This column is partially redundant with the residues column, and also with featureloc. This column is required because the location may be unknown and the residue sequence may not be manifested, yet it may be desirable to store and query the length of the feature. The seqlen should always be manifested where the length of the sequence is known..
	 * @param seqlen
	 */
	public void setSeqlen( Integer seqlen)
	{
		
		this.seqlen = seqlen;
	}

	

	/**
	 * Get the genome.
	 * @return genome.
	 */
	public org.molgenis.variant.Genome getGenome()
	{
		return this.genome;
	}
	
	@Deprecated
	public org.molgenis.variant.Genome getGenome(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the genome.
	 * @param genome
	 */
	public void setGenome( org.molgenis.variant.Genome genome)
	{
		
		this.genome = genome;
	}

	
	
	/**
	 * Set foreign key for field genome.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setGenome_Id(Integer genome_id)
	{
		this.genome_id = genome_id;
	}	

	public void setGenome(Integer genome_id)
	{
		this.genome_id = genome_id;
	}
	
	public Integer getGenome_Id()
	{
		
		if(genome != null) 
		{
			return genome.getId();
		}
		else
		{
			return genome_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference Genome to Genome.Id.
	 */
	public String getGenome_Identifier()
	{		
		//FIXME should we auto-load based on getGenome()?	
		if(genome != null) {
			return genome.getIdentifier();
		} else {
			return genome_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Genome to <a href="Genome.html#Id">Genome.Id</a>.
	 * Implies setGenome(null) until save
	 */
	public void setGenome_Identifier(String genome_Identifier)
	{
		this.genome_Identifier = genome_Identifier;
	}		
	 
	

	/**
	 * Get the orderNr.
	 * @return orderNr.
	 */
	public Integer getOrderNr()
	{
		return this.orderNr;
	}
	
	@Deprecated
	public Integer getOrderNr(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the orderNr.
	 * @param orderNr
	 */
	public void setOrderNr( Integer orderNr)
	{
		
		this.orderNr = orderNr;
	}

	

	/**
	 * Get the Is 'yes' when number of chromosomes is equal in male and female individuals, i.e., if not a sex chromosome..
	 * @return isAutosomal.
	 */
	public Boolean getIsAutosomal()
	{
		return this.isAutosomal;
	}
	
	@Deprecated
	public Boolean getIsAutosomal(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Is 'yes' when number of chromosomes is equal in male and female individuals, i.e., if not a sex chromosome..
	 * @param isAutosomal
	 */
	public void setIsAutosomal( Boolean isAutosomal)
	{
		
		this.isAutosomal = isAutosomal;
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
		if (name.toLowerCase().equals("residues"))
			return getResidues();
		if (name.toLowerCase().equals("seqlen"))
			return getSeqlen();
		if (name.toLowerCase().equals("genome"))
			return getGenome();
		if(name.toLowerCase().equals("genome_id"))
			return getGenome_Id();
		if(name.toLowerCase().equals("genome_identifier"))
			return getGenome_Identifier();
		if (name.toLowerCase().equals("ordernr"))
			return getOrderNr();
		if (name.toLowerCase().equals("isautosomal"))
			return getIsAutosomal();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getIdentifier() == null) throw new org.molgenis.framework.db.DatabaseException("required field identifier is null");
		if(this.getName() == null) throw new org.molgenis.framework.db.DatabaseException("required field name is null");
		if(this.get__Type() == null) throw new org.molgenis.framework.db.DatabaseException("required field __Type is null");
		if(this.getGenome() == null) throw new org.molgenis.framework.db.DatabaseException("required field genome is null");
		if(this.getOrderNr() == null) throw new org.molgenis.framework.db.DatabaseException("required field orderNr is null");
		if(this.getIsAutosomal() == null) throw new org.molgenis.framework.db.DatabaseException("required field isAutosomal is null");
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
			//set Residues
			this.setResidues(tuple.getString("residues"));
			//set Seqlen
			this.setSeqlen(tuple.getInt("seqlen"));
			//set Genome
			this.setGenome(tuple.getInt("genome"));
			//set label Identifier for xref field Genome
			this.setGenome_Identifier(tuple.getString("genome_Identifier"));	
			//set OrderNr
			this.setOrderNr(tuple.getInt("orderNr"));
			//set IsAutosomal
			this.setIsAutosomal(tuple.getBoolean("isAutosomal"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("Chromosome_id") != null) this.setId(tuple.getInt("Chromosome_id"));
			//set Identifier
			if( strict || tuple.getString("Identifier") != null) this.setIdentifier(tuple.getString("Identifier"));
			if( tuple.getString("Chromosome_Identifier") != null) this.setIdentifier(tuple.getString("Chromosome_Identifier"));
			//set Name
			if( strict || tuple.getString("Name") != null) this.setName(tuple.getString("Name"));
			if( tuple.getString("Chromosome_Name") != null) this.setName(tuple.getString("Chromosome_Name"));
			//set __Type
			if( strict || tuple.getString("__Type") != null) this.set__Type(tuple.getString("__Type"));
			if( tuple.getString("Chromosome___Type") != null) this.set__Type(tuple.getString("Chromosome___Type"));
			//set Description
			if( strict || tuple.getString("description") != null) this.setDescription(tuple.getString("description"));
			if( tuple.getString("Chromosome_description") != null) this.setDescription(tuple.getString("Chromosome_description"));
			//set Residues
			if( strict || tuple.getString("residues") != null) this.setResidues(tuple.getString("residues"));
			if( tuple.getString("Chromosome_residues") != null) this.setResidues(tuple.getString("Chromosome_residues"));
			//set Seqlen
			if( strict || tuple.getInt("seqlen") != null) this.setSeqlen(tuple.getInt("seqlen"));
			if( tuple.getInt("Chromosome_seqlen") != null) this.setSeqlen(tuple.getInt("Chromosome_seqlen"));
			//set Genome
			if( strict || tuple.getInt("genome_id") != null) this.setGenome(tuple.getInt("genome_id"));
			if( tuple.getInt("Chromosome_genome_id") != null) this.setGenome(tuple.getInt("Chromosome_genome_id"));
			//alias of xref
			if( tuple.getObject("genome") != null) this.setGenome(tuple.getInt("genome"));
			if( tuple.getObject("Chromosome_genome") != null) this.setGenome(tuple.getInt("Chromosome_genome"));
			//set label for field Genome
			if( strict || tuple.getObject("genome_Identifier") != null) this.setGenome_Identifier(tuple.getString("genome_Identifier"));			
			if( tuple.getObject("Chromosome_genome_Identifier") != null ) this.setGenome_Identifier(tuple.getString("Chromosome_genome_Identifier"));		
			//set OrderNr
			if( strict || tuple.getInt("orderNr") != null) this.setOrderNr(tuple.getInt("orderNr"));
			if( tuple.getInt("Chromosome_orderNr") != null) this.setOrderNr(tuple.getInt("Chromosome_orderNr"));
			//set IsAutosomal
			if( strict || tuple.getBoolean("isAutosomal") != null) this.setIsAutosomal(tuple.getBoolean("isAutosomal"));
			if( tuple.getBoolean("Chromosome_isAutosomal") != null) this.setIsAutosomal(tuple.getBoolean("Chromosome_isAutosomal"));
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
		String result = "Chromosome(";
		result+= "id='" + getId()+"' ";	
		result+= "identifier='" + getIdentifier()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= "__Type='" + get__Type()+"' ";	
		result+= "description='" + getDescription()+"' ";	
		result+= "residues='" + getResidues()+"' ";	
		result+= "seqlen='" + getSeqlen()+"' ";	
		result+= " genome_id='" + getGenome_Id()+"' ";	
		result+= " genome_identifier='" + getGenome_Identifier()+"' ";
		result+= "orderNr='" + getOrderNr()+"' ";	
		result+= "isAutosomal='" + getIsAutosomal()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Chromosome.
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
			fields.add("residues");
		}
		{
			fields.add("seqlen");
		}
		{
			fields.add("genome_id");
		}
		fields.add("genome_identifier");
		{
			fields.add("orderNr");
		}
		{
			fields.add("isAutosomal");
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
		+ "residues" +sep
		+ "seqlen" +sep
		+ "genome" +sep
		+ "orderNr" +sep
		+ "isAutosomal" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("genome")) {
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
		Chromosome rhs = (Chromosome) obj;
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
			Object valueO = getResidues();
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
			Object valueO = getSeqlen();
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
			Object valueO = getGenome();
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
			Object valueO = getOrderNr();
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
			Object valueO = getIsAutosomal();
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
	public Chromosome create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Chromosome e = new Chromosome();
		e.set(tuple);
		return e;
	}
	
//5
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="gdna"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.variant.Gene> gdnaGeneCollection = new java.util.ArrayList<org.molgenis.variant.Gene>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.variant.Gene> getGdnaGeneCollection()
	{
            return gdnaGeneCollection;
	}

    public void setGdnaGeneCollection(java.util.Collection<org.molgenis.variant.Gene> collection)
    {
        for (org.molgenis.variant.Gene gene : collection) {
            gene.setGdna(this);
        }
        gdnaGeneCollection = collection;
    }	
//5
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="gdna"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.variant.ProteinDomain> gdnaProteinDomainCollection = new java.util.ArrayList<org.molgenis.variant.ProteinDomain>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.variant.ProteinDomain> getGdnaProteinDomainCollection()
	{
            return gdnaProteinDomainCollection;
	}

    public void setGdnaProteinDomainCollection(java.util.Collection<org.molgenis.variant.ProteinDomain> collection)
    {
        for (org.molgenis.variant.ProteinDomain proteinDomain : collection) {
            proteinDomain.setGdna(this);
        }
        gdnaProteinDomainCollection = collection;
    }	
//5
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="gdna"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.variant.Exon> gdnaExonCollection = new java.util.ArrayList<org.molgenis.variant.Exon>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.variant.Exon> getGdnaExonCollection()
	{
            return gdnaExonCollection;
	}

    public void setGdnaExonCollection(java.util.Collection<org.molgenis.variant.Exon> collection)
    {
        for (org.molgenis.variant.Exon exon : collection) {
            exon.setGdna(this);
        }
        gdnaExonCollection = collection;
    }	
//5
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="gdna"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.variant.Variant> gdnaVariantCollection = new java.util.ArrayList<org.molgenis.variant.Variant>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.variant.Variant> getGdnaVariantCollection()
	{
            return gdnaVariantCollection;
	}

    public void setGdnaVariantCollection(java.util.Collection<org.molgenis.variant.Variant> collection)
    {
        for (org.molgenis.variant.Variant variant : collection) {
            variant.setGdna(this);
        }
        gdnaVariantCollection = collection;
    }	

	
}

