
/* File:        org.molgenis.omx/model/Protein.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.variant;

/**
 * Protein: Serves as a view on SequencesCharacteristics that are
				proteins / aa.
			
.
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "Protein"
)

@org.hibernate.annotations.Table(appliesTo="Protein", indexes={
    @org.hibernate.annotations.Index(name="cdna_start", columnNames={
	"cdna_start"
    })
})

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.variant.db.ProteinEntityListener.class})
public class Protein extends org.molgenis.observ.Characteristic implements org.molgenis.variant.CdnaPosition, org.molgenis.variant.BioSequence
{
	// fieldname constants
	public final static String CDNA = "cdna";
	public final static String CDNA_IDENTIFIER = "cdna_Identifier";
	public final static String CDNA_START = "cdna_start";
	public final static String CDNA_END = "cdna_end";
	public final static String RESIDUES = "residues";
	public final static String SEQLEN = "seqlen";
	public final static String ID = "id";
	
	//static methods
	/**
	 * Shorthand for db.query(Protein.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Protein> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Protein.class);
	}
	
	/**
	 * Shorthand for db.find(Protein.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Protein> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Protein.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Protein findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Protein> q = db.query(Protein.class);
		q.eq(Protein.ID, id);
		java.util.List<Protein> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Protein findByIdentifier(org.molgenis.framework.db.Database db, String identifier) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Protein> q = db.query(Protein.class);
		q.eq(Protein.IDENTIFIER, identifier);
		java.util.List<Protein> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


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


	//A sequence of alphabetic characters representing biological residues (nucleic acids, amino acids). This column does not need to be manifested for all features; it is optional for features such as exons where the residues can be derived from the featureloc. It is recommended that the value for this column be manifested for features which may may non-contiguous sublocations (e.g. transcripts), since derivation at query time is non-trivial. For expressed sequence, the DNA sequence should be used rather than the RNA sequence.[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="residues", length=16777216)
	
				

	private String residues =  null;


	//The length of the residue feature. See column:residues. This column is partially redundant with the residues column, and also with featureloc. This column is required because the location may be unknown and the residue sequence may not be manifested, yet it may be desirable to store and query the length of the feature. The seqlen should always be manifested where the length of the sequence is known.[type=int]
	@javax.persistence.Column(name="seqlen")
	@javax.xml.bind.annotation.XmlElement(name="seqlen")
	
				

	private Integer seqlen =  null;


	//automatically generated internal id, only for internal use.[type=int]
	

	//constructors
	public Protein()
	{
		//set the type for a new instance
		set__Type(this.getClass().getSimpleName());
	
	}
	
	//getters and setters
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
		if (name.toLowerCase().equals("residues"))
			return getResidues();
		if (name.toLowerCase().equals("seqlen"))
			return getSeqlen();
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
			//set Description
			this.setDescription(tuple.getString("description"));
			//set Cdna
			this.setCdna(tuple.getInt("cdna"));
			//set label Identifier for xref field Cdna
			this.setCdna_Identifier(tuple.getString("cdna_Identifier"));	
			//set Cdna_Start
			this.setCdna_Start(tuple.getInt("cdna_start"));
			//set Cdna_End
			this.setCdna_End(tuple.getInt("cdna_end"));
			//set Residues
			this.setResidues(tuple.getString("residues"));
			//set Seqlen
			this.setSeqlen(tuple.getInt("seqlen"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("Protein_id") != null) this.setId(tuple.getInt("Protein_id"));
			//set Identifier
			if( strict || tuple.getString("Identifier") != null) this.setIdentifier(tuple.getString("Identifier"));
			if( tuple.getString("Protein_Identifier") != null) this.setIdentifier(tuple.getString("Protein_Identifier"));
			//set Name
			if( strict || tuple.getString("Name") != null) this.setName(tuple.getString("Name"));
			if( tuple.getString("Protein_Name") != null) this.setName(tuple.getString("Protein_Name"));
			//set __Type
			if( strict || tuple.getString("__Type") != null) this.set__Type(tuple.getString("__Type"));
			if( tuple.getString("Protein___Type") != null) this.set__Type(tuple.getString("Protein___Type"));
			//set Description
			if( strict || tuple.getString("description") != null) this.setDescription(tuple.getString("description"));
			if( tuple.getString("Protein_description") != null) this.setDescription(tuple.getString("Protein_description"));
			//set Cdna
			if( strict || tuple.getInt("cdna_id") != null) this.setCdna(tuple.getInt("cdna_id"));
			if( tuple.getInt("Protein_cdna_id") != null) this.setCdna(tuple.getInt("Protein_cdna_id"));
			//alias of xref
			if( tuple.getObject("cdna") != null) this.setCdna(tuple.getInt("cdna"));
			if( tuple.getObject("Protein_cdna") != null) this.setCdna(tuple.getInt("Protein_cdna"));
			//set label for field Cdna
			if( strict || tuple.getObject("cdna_Identifier") != null) this.setCdna_Identifier(tuple.getString("cdna_Identifier"));			
			if( tuple.getObject("Protein_cdna_Identifier") != null ) this.setCdna_Identifier(tuple.getString("Protein_cdna_Identifier"));		
			//set Cdna_Start
			if( strict || tuple.getInt("cdna_start") != null) this.setCdna_Start(tuple.getInt("cdna_start"));
			if( tuple.getInt("Protein_cdna_start") != null) this.setCdna_Start(tuple.getInt("Protein_cdna_start"));
			//set Cdna_End
			if( strict || tuple.getInt("cdna_end") != null) this.setCdna_End(tuple.getInt("cdna_end"));
			if( tuple.getInt("Protein_cdna_end") != null) this.setCdna_End(tuple.getInt("Protein_cdna_end"));
			//set Residues
			if( strict || tuple.getString("residues") != null) this.setResidues(tuple.getString("residues"));
			if( tuple.getString("Protein_residues") != null) this.setResidues(tuple.getString("Protein_residues"));
			//set Seqlen
			if( strict || tuple.getInt("seqlen") != null) this.setSeqlen(tuple.getInt("seqlen"));
			if( tuple.getInt("Protein_seqlen") != null) this.setSeqlen(tuple.getInt("Protein_seqlen"));
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
		String result = "Protein(";
		result+= "id='" + getId()+"' ";	
		result+= "identifier='" + getIdentifier()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= "__Type='" + get__Type()+"' ";	
		result+= "description='" + getDescription()+"' ";	
		result+= " cdna_id='" + getCdna_Id()+"' ";	
		result+= " cdna_identifier='" + getCdna_Identifier()+"' ";
		result+= "cdna_start='" + getCdna_Start()+"' ";	
		result+= "cdna_end='" + getCdna_End()+"' ";	
		result+= "residues='" + getResidues()+"' ";	
		result+= "seqlen='" + getSeqlen()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Protein.
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
			fields.add("residues");
		}
		{
			fields.add("seqlen");
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
		+ "cdna" +sep
		+ "cdna_start" +sep
		+ "cdna_end" +sep
		+ "residues" +sep
		+ "seqlen" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("cdna")) {
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
		Protein rhs = (Protein) obj;
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
			out.write(valueS);
		}
		return out.toString();
	}
	
	@Override
	public Protein create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Protein e = new Protein();
		e.set(tuple);
		return e;
	}
	
//2
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="aa"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.variant.Variant> aaVariantCollection = new java.util.ArrayList<org.molgenis.variant.Variant>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.variant.Variant> getAaVariantCollection()
	{
            return aaVariantCollection;
	}

    public void setAaVariantCollection(java.util.Collection<org.molgenis.variant.Variant> collection)
    {
        for (org.molgenis.variant.Variant variant : collection) {
            variant.setAa(this);
        }
        aaVariantCollection = collection;
    }	

	
}

