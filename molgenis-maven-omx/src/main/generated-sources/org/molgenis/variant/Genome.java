
/* File:        org.molgenis/model/Genome.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.variant;

/**
 * Genome: .
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "Genome"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.variant.db.GenomeEntityListener.class})
public class Genome extends org.molgenis.observ.Characteristic implements org.molgenis.variant.BioSequence
{
	// fieldname constants
	public final static String RESIDUES = "residues";
	public final static String SEQLEN = "seqlen";
	public final static String SPECIES = "species";
	public final static String SPECIES_IDENTIFIER = "species_Identifier";
	public final static String ID = "id";
	
	//static methods
	/**
	 * Shorthand for db.query(Genome.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Genome> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Genome.class);
	}
	
	/**
	 * Shorthand for db.find(Genome.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Genome> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Genome.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Genome findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Genome> q = db.query(Genome.class);
		q.eq(Genome.ID, id);
		java.util.List<Genome> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Genome findByIdentifier(org.molgenis.framework.db.Database db, String identifier) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Genome> q = db.query(Genome.class);
		q.eq(Genome.IDENTIFIER, identifier);
		java.util.List<Genome> result = q.find();
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


	//species this genome belongs to.[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="species")   	
	
				

	private org.molgenis.observ.target.Species species = null;
	@javax.persistence.Transient
	private Integer species_id = null;	
	@javax.persistence.Transient
	private String species_Identifier = null;						


	//automatically generated internal id, only for internal use.[type=int]
	

	//constructors
	public Genome()
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
	 * Get the species this genome belongs to..
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
	 * Set the species this genome belongs to..
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
		if (name.toLowerCase().equals("species"))
			return getSpecies();
		if(name.toLowerCase().equals("species_id"))
			return getSpecies_Id();
		if(name.toLowerCase().equals("species_identifier"))
			return getSpecies_Identifier();
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
			//set Residues
			this.setResidues(tuple.getString("residues"));
			//set Seqlen
			this.setSeqlen(tuple.getInt("seqlen"));
			//set Species
			this.setSpecies(tuple.getInt("species"));
			//set label Identifier for xref field Species
			this.setSpecies_Identifier(tuple.getString("species_Identifier"));	
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("Genome_id") != null) this.setId(tuple.getInt("Genome_id"));
			//set Identifier
			if( strict || tuple.getString("Identifier") != null) this.setIdentifier(tuple.getString("Identifier"));
			if( tuple.getString("Genome_Identifier") != null) this.setIdentifier(tuple.getString("Genome_Identifier"));
			//set Name
			if( strict || tuple.getString("Name") != null) this.setName(tuple.getString("Name"));
			if( tuple.getString("Genome_Name") != null) this.setName(tuple.getString("Genome_Name"));
			//set __Type
			if( strict || tuple.getString("__Type") != null) this.set__Type(tuple.getString("__Type"));
			if( tuple.getString("Genome___Type") != null) this.set__Type(tuple.getString("Genome___Type"));
			//set Description
			if( strict || tuple.getString("description") != null) this.setDescription(tuple.getString("description"));
			if( tuple.getString("Genome_description") != null) this.setDescription(tuple.getString("Genome_description"));
			//set Residues
			if( strict || tuple.getString("residues") != null) this.setResidues(tuple.getString("residues"));
			if( tuple.getString("Genome_residues") != null) this.setResidues(tuple.getString("Genome_residues"));
			//set Seqlen
			if( strict || tuple.getInt("seqlen") != null) this.setSeqlen(tuple.getInt("seqlen"));
			if( tuple.getInt("Genome_seqlen") != null) this.setSeqlen(tuple.getInt("Genome_seqlen"));
			//set Species
			if( strict || tuple.getInt("species_id") != null) this.setSpecies(tuple.getInt("species_id"));
			if( tuple.getInt("Genome_species_id") != null) this.setSpecies(tuple.getInt("Genome_species_id"));
			//alias of xref
			if( tuple.getObject("species") != null) this.setSpecies(tuple.getInt("species"));
			if( tuple.getObject("Genome_species") != null) this.setSpecies(tuple.getInt("Genome_species"));
			//set label for field Species
			if( strict || tuple.getObject("species_Identifier") != null) this.setSpecies_Identifier(tuple.getString("species_Identifier"));			
			if( tuple.getObject("Genome_species_Identifier") != null ) this.setSpecies_Identifier(tuple.getString("Genome_species_Identifier"));		
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
		String result = "Genome(";
		result+= "id='" + getId()+"' ";	
		result+= "identifier='" + getIdentifier()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= "__Type='" + get__Type()+"' ";	
		result+= "description='" + getDescription()+"' ";	
		result+= "residues='" + getResidues()+"' ";	
		result+= "seqlen='" + getSeqlen()+"' ";	
		result+= " species_id='" + getSpecies_Id()+"' ";	
		result+= " species_identifier='" + getSpecies_Identifier()+"' ";
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Genome.
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
			fields.add("species_id");
		}
		fields.add("species_identifier");
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
		+ "species" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("species")) {
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
		Genome rhs = (Genome) obj;
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
			Object valueO = getSpecies();
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
	public Genome create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Genome e = new Genome();
		e.set(tuple);
		return e;
	}
	
//1
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="genome"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.variant.Chromosome> genomeChromosomeCollection = new java.util.ArrayList<org.molgenis.variant.Chromosome>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.variant.Chromosome> getGenomeChromosomeCollection()
	{
            return genomeChromosomeCollection;
	}

    public void setGenomeChromosomeCollection(java.util.Collection<org.molgenis.variant.Chromosome> collection)
    {
        for (org.molgenis.variant.Chromosome chromosome : collection) {
            chromosome.setGenome(this);
        }
        genomeChromosomeCollection = collection;
    }	

	
}

