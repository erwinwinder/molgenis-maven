
/* File:        org.molgenis.omx/model/Gene.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.variant;

/**
 * Gene: Serves as a view on SequenceCharacteristics that are
				genes / cdna
			
.
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "Gene"
)

@org.hibernate.annotations.Table(appliesTo="Gene", indexes={
    @org.hibernate.annotations.Index(name="gdna_start", columnNames={
	"gdna_start"
    })
})

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.variant.db.GeneEntityListener.class})
public class Gene extends org.molgenis.observ.Characteristic implements org.molgenis.variant.GdnaPosition, org.molgenis.variant.BioSequence
{
	// fieldname constants
	public final static String GDNA = "gdna";
	public final static String GDNA_IDENTIFIER = "gdna_Identifier";
	public final static String GDNA_START = "gdna_start";
	public final static String GDNA_END = "gdna_end";
	public final static String RESIDUES = "residues";
	public final static String SEQLEN = "seqlen";
	public final static String STRAND = "strand";
	public final static String ID = "id";
	
	//static methods
	/**
	 * Shorthand for db.query(Gene.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Gene> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Gene.class);
	}
	
	/**
	 * Shorthand for db.find(Gene.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Gene> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Gene.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Gene findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Gene> q = db.query(Gene.class);
		q.eq(Gene.ID, id);
		java.util.List<Gene> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Gene findByIdentifier(org.molgenis.framework.db.Database db, String identifier) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Gene> q = db.query(Gene.class);
		q.eq(Gene.IDENTIFIER, identifier);
		java.util.List<Gene> result = q.find();
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


	//A sequence of alphabetic characters representing biological residues (nucleic acids, amino acids). This column does not need to be manifested for all features; it is optional for features such as exons where the residues can be derived from the featureloc. It is recommended that the value for this column be manifested for features which may may non-contiguous sublocations (e.g. transcripts), since derivation at query time is non-trivial. For expressed sequence, the DNA sequence should be used rather than the RNA sequence.[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="residues", length=16777216)
	
				

	private String residues =  null;


	//The length of the residue feature. See column:residues. This column is partially redundant with the residues column, and also with featureloc. This column is required because the location may be unknown and the residue sequence may not be manifested, yet it may be desirable to store and query the length of the feature. The seqlen should always be manifested where the length of the sequence is known.[type=int]
	@javax.persistence.Column(name="seqlen")
	@javax.xml.bind.annotation.XmlElement(name="seqlen")
	
				

	private Integer seqlen =  null;


	//The orientation/directionality of the location. Should be 0, -1 or +1.[type=enum]
	@javax.persistence.Column(name="strand", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="strand")
	
				

	@javax.validation.constraints.NotNull
	private String strand =  null;
	@javax.persistence.Transient
	private String strand_label = null;
	@javax.persistence.Transient
	private java.util.List<org.molgenis.util.ValueLabel> strand_options = new java.util.ArrayList<org.molgenis.util.ValueLabel>();


	//automatically generated internal id, only for internal use.[type=int]
	

	//constructors
	public Gene()
	{
		//set the type for a new instance
		set__Type(this.getClass().getSimpleName());
	
		//options for enum Strand
		strand_options.add(new org.molgenis.util.ValueLabel("0","0"));
		strand_options.add(new org.molgenis.util.ValueLabel("-1","-1"));
		strand_options.add(new org.molgenis.util.ValueLabel("+1","+1"));
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
	 * Get the The orientation/directionality of the location. Should be 0, -1 or +1..
	 * @return strand.
	 */
	public String getStrand()
	{
		return this.strand;
	}
	
	@Deprecated
	public String getStrand(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the The orientation/directionality of the location. Should be 0, -1 or +1..
	 * @param strand
	 */
	public void setStrand( String strand)
	{
		
		this.strand = strand;
	}

	
	/**
	 * Get tha label for enum Strand.
	 */
	public String getStrandLabel()
	{
		return this.strand_label;
	}
	
	/**
	 * Strand is enum. This method returns all available enum options.
	 */
	public java.util.List<org.molgenis.util.ValueLabel> getStrandOptions()
	{
		return strand_options;
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
		if (name.toLowerCase().equals("residues"))
			return getResidues();
		if (name.toLowerCase().equals("seqlen"))
			return getSeqlen();
		if (name.toLowerCase().equals("strand"))
			return getStrand();
		if(name.toLowerCase().equals("strand_label"))
			return getStrandLabel();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getIdentifier() == null) throw new org.molgenis.framework.db.DatabaseException("required field identifier is null");
		if(this.getName() == null) throw new org.molgenis.framework.db.DatabaseException("required field name is null");
		if(this.get__Type() == null) throw new org.molgenis.framework.db.DatabaseException("required field __Type is null");
		if(this.getStrand() == null) throw new org.molgenis.framework.db.DatabaseException("required field strand is null");
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
			//set Residues
			this.setResidues(tuple.getString("residues"));
			//set Seqlen
			this.setSeqlen(tuple.getInt("seqlen"));
			//set Strand
			this.setStrand(tuple.getString("strand"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("Gene_id") != null) this.setId(tuple.getInt("Gene_id"));
			//set Identifier
			if( strict || tuple.getString("Identifier") != null) this.setIdentifier(tuple.getString("Identifier"));
			if( tuple.getString("Gene_Identifier") != null) this.setIdentifier(tuple.getString("Gene_Identifier"));
			//set Name
			if( strict || tuple.getString("Name") != null) this.setName(tuple.getString("Name"));
			if( tuple.getString("Gene_Name") != null) this.setName(tuple.getString("Gene_Name"));
			//set __Type
			if( strict || tuple.getString("__Type") != null) this.set__Type(tuple.getString("__Type"));
			if( tuple.getString("Gene___Type") != null) this.set__Type(tuple.getString("Gene___Type"));
			//set Description
			if( strict || tuple.getString("description") != null) this.setDescription(tuple.getString("description"));
			if( tuple.getString("Gene_description") != null) this.setDescription(tuple.getString("Gene_description"));
			//set Gdna
			if( strict || tuple.getInt("gdna_id") != null) this.setGdna(tuple.getInt("gdna_id"));
			if( tuple.getInt("Gene_gdna_id") != null) this.setGdna(tuple.getInt("Gene_gdna_id"));
			//alias of xref
			if( tuple.getObject("gdna") != null) this.setGdna(tuple.getInt("gdna"));
			if( tuple.getObject("Gene_gdna") != null) this.setGdna(tuple.getInt("Gene_gdna"));
			//set label for field Gdna
			if( strict || tuple.getObject("gdna_Identifier") != null) this.setGdna_Identifier(tuple.getString("gdna_Identifier"));			
			if( tuple.getObject("Gene_gdna_Identifier") != null ) this.setGdna_Identifier(tuple.getString("Gene_gdna_Identifier"));		
			//set Gdna_Start
			if( strict || tuple.getInt("gdna_start") != null) this.setGdna_Start(tuple.getInt("gdna_start"));
			if( tuple.getInt("Gene_gdna_start") != null) this.setGdna_Start(tuple.getInt("Gene_gdna_start"));
			//set Gdna_End
			if( strict || tuple.getInt("gdna_end") != null) this.setGdna_End(tuple.getInt("gdna_end"));
			if( tuple.getInt("Gene_gdna_end") != null) this.setGdna_End(tuple.getInt("Gene_gdna_end"));
			//set Residues
			if( strict || tuple.getString("residues") != null) this.setResidues(tuple.getString("residues"));
			if( tuple.getString("Gene_residues") != null) this.setResidues(tuple.getString("Gene_residues"));
			//set Seqlen
			if( strict || tuple.getInt("seqlen") != null) this.setSeqlen(tuple.getInt("seqlen"));
			if( tuple.getInt("Gene_seqlen") != null) this.setSeqlen(tuple.getInt("Gene_seqlen"));
			//set Strand
			if( strict || tuple.getString("strand") != null) this.setStrand(tuple.getString("strand"));
			if( tuple.getString("Gene_strand") != null) this.setStrand(tuple.getString("Gene_strand"));
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
		String result = "Gene(";
		result+= "id='" + getId()+"' ";	
		result+= "identifier='" + getIdentifier()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= "__Type='" + get__Type()+"' ";	
		result+= "description='" + getDescription()+"' ";	
		result+= " gdna_id='" + getGdna_Id()+"' ";	
		result+= " gdna_identifier='" + getGdna_Identifier()+"' ";
		result+= "gdna_start='" + getGdna_Start()+"' ";	
		result+= "gdna_end='" + getGdna_End()+"' ";	
		result+= "residues='" + getResidues()+"' ";	
		result+= "seqlen='" + getSeqlen()+"' ";	
		result+= "strand='" + getStrand()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Gene.
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
			fields.add("residues");
		}
		{
			fields.add("seqlen");
		}
		{
			fields.add("strand");
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
		+ "gdna" +sep
		+ "gdna_start" +sep
		+ "gdna_end" +sep
		+ "residues" +sep
		+ "seqlen" +sep
		+ "strand" 
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
        
        return null;
    }	

	@Override
	public boolean equals(Object obj) {
   		if (obj == null) { return false; }
   		if (obj == this) { return true; }
   		if (obj.getClass() != getClass()) {
     		return false;
   		}
		Gene rhs = (Gene) obj;
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
			Object valueO = getStrand();
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
	public Gene create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Gene e = new Gene();
		e.set(tuple);
		return e;
	}
	
//5
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="cdna"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.variant.Protein> cdnaProteinCollection = new java.util.ArrayList<org.molgenis.variant.Protein>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.variant.Protein> getCdnaProteinCollection()
	{
            return cdnaProteinCollection;
	}

    public void setCdnaProteinCollection(java.util.Collection<org.molgenis.variant.Protein> collection)
    {
        for (org.molgenis.variant.Protein protein : collection) {
            protein.setCdna(this);
        }
        cdnaProteinCollection = collection;
    }	
//5
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="cdna"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.variant.ProteinDomain> cdnaProteinDomainCollection = new java.util.ArrayList<org.molgenis.variant.ProteinDomain>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.variant.ProteinDomain> getCdnaProteinDomainCollection()
	{
            return cdnaProteinDomainCollection;
	}

    public void setCdnaProteinDomainCollection(java.util.Collection<org.molgenis.variant.ProteinDomain> collection)
    {
        for (org.molgenis.variant.ProteinDomain proteinDomain : collection) {
            proteinDomain.setCdna(this);
        }
        cdnaProteinDomainCollection = collection;
    }	
//5
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="cdna"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.variant.Exon> cdnaExonCollection = new java.util.ArrayList<org.molgenis.variant.Exon>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.variant.Exon> getCdnaExonCollection()
	{
            return cdnaExonCollection;
	}

    public void setCdnaExonCollection(java.util.Collection<org.molgenis.variant.Exon> collection)
    {
        for (org.molgenis.variant.Exon exon : collection) {
            exon.setCdna(this);
        }
        cdnaExonCollection = collection;
    }	
//5
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="cdna"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.variant.Variant> cdnaVariantCollection = new java.util.ArrayList<org.molgenis.variant.Variant>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.variant.Variant> getCdnaVariantCollection()
	{
            return cdnaVariantCollection;
	}

    public void setCdnaVariantCollection(java.util.Collection<org.molgenis.variant.Variant> collection)
    {
        for (org.molgenis.variant.Variant variant : collection) {
            variant.setCdna(this);
        }
        cdnaVariantCollection = collection;
    }	

	
}

