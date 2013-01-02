
/* File:        org.molgenis.omx/model/Exon.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.variant;

/**
 * Exon: Serves as a view on SequenceCharacteristics that are
				exons or introns.
			
.
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "Exon"
)

@org.hibernate.annotations.Table(appliesTo="Exon", indexes={
    @org.hibernate.annotations.Index(name="isIntron", columnNames={
	"isIntron"
    }),
    @org.hibernate.annotations.Index(name="cdna_start", columnNames={
	"cdna_start"
    }),
    @org.hibernate.annotations.Index(name="gdna_start", columnNames={
	"gdna_start"
    })
})

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.variant.db.ExonEntityListener.class})
public class Exon extends org.molgenis.observ.Characteristic implements org.molgenis.variant.CdnaPosition, org.molgenis.variant.GdnaPosition
{
	// fieldname constants
	public final static String CDNA = "cdna";
	public final static String CDNA_IDENTIFIER = "cdna_Identifier";
	public final static String CDNA_START = "cdna_start";
	public final static String CDNA_END = "cdna_end";
	public final static String GDNA = "gdna";
	public final static String GDNA_IDENTIFIER = "gdna_Identifier";
	public final static String GDNA_START = "gdna_start";
	public final static String GDNA_END = "gdna_end";
	public final static String ISINTRON = "isIntron";
	public final static String ID = "id";
	
	//static methods
	/**
	 * Shorthand for db.query(Exon.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Exon> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Exon.class);
	}
	
	/**
	 * Shorthand for db.find(Exon.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Exon> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Exon.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Exon findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Exon> q = db.query(Exon.class);
		q.eq(Exon.ID, id);
		java.util.List<Exon> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Exon findByIdentifier(org.molgenis.framework.db.Database db, String identifier) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Exon> q = db.query(Exon.class);
		q.eq(Exon.IDENTIFIER, identifier);
		java.util.List<Exon> result = q.find();
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


	//Is this exon actually an intron?[type=bool]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="isIntron", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="isIntron")
	
				

	@javax.validation.constraints.NotNull
	private Boolean isIntron =  null;


	//automatically generated internal id, only for internal use.[type=int]
	

	//constructors
	public Exon()
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
	 * Get the Is this exon actually an intron?.
	 * @return isIntron.
	 */
	public Boolean getIsIntron()
	{
		return this.isIntron;
	}
	
	@Deprecated
	public Boolean getIsIntron(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Is this exon actually an intron?.
	 * @param isIntron
	 */
	public void setIsIntron( Boolean isIntron)
	{
		
		this.isIntron = isIntron;
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
		if (name.toLowerCase().equals("isintron"))
			return getIsIntron();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getIdentifier() == null) throw new org.molgenis.framework.db.DatabaseException("required field identifier is null");
		if(this.getName() == null) throw new org.molgenis.framework.db.DatabaseException("required field name is null");
		if(this.get__Type() == null) throw new org.molgenis.framework.db.DatabaseException("required field __Type is null");
		if(this.getIsIntron() == null) throw new org.molgenis.framework.db.DatabaseException("required field isIntron is null");
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
			//set Gdna
			this.setGdna(tuple.getInt("gdna"));
			//set label Identifier for xref field Gdna
			this.setGdna_Identifier(tuple.getString("gdna_Identifier"));	
			//set Gdna_Start
			this.setGdna_Start(tuple.getInt("gdna_start"));
			//set Gdna_End
			this.setGdna_End(tuple.getInt("gdna_end"));
			//set IsIntron
			this.setIsIntron(tuple.getBoolean("isIntron"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("Exon_id") != null) this.setId(tuple.getInt("Exon_id"));
			//set Identifier
			if( strict || tuple.getString("Identifier") != null) this.setIdentifier(tuple.getString("Identifier"));
			if( tuple.getString("Exon_Identifier") != null) this.setIdentifier(tuple.getString("Exon_Identifier"));
			//set Name
			if( strict || tuple.getString("Name") != null) this.setName(tuple.getString("Name"));
			if( tuple.getString("Exon_Name") != null) this.setName(tuple.getString("Exon_Name"));
			//set __Type
			if( strict || tuple.getString("__Type") != null) this.set__Type(tuple.getString("__Type"));
			if( tuple.getString("Exon___Type") != null) this.set__Type(tuple.getString("Exon___Type"));
			//set Description
			if( strict || tuple.getString("description") != null) this.setDescription(tuple.getString("description"));
			if( tuple.getString("Exon_description") != null) this.setDescription(tuple.getString("Exon_description"));
			//set Cdna
			if( strict || tuple.getInt("cdna_id") != null) this.setCdna(tuple.getInt("cdna_id"));
			if( tuple.getInt("Exon_cdna_id") != null) this.setCdna(tuple.getInt("Exon_cdna_id"));
			//alias of xref
			if( tuple.getObject("cdna") != null) this.setCdna(tuple.getInt("cdna"));
			if( tuple.getObject("Exon_cdna") != null) this.setCdna(tuple.getInt("Exon_cdna"));
			//set label for field Cdna
			if( strict || tuple.getObject("cdna_Identifier") != null) this.setCdna_Identifier(tuple.getString("cdna_Identifier"));			
			if( tuple.getObject("Exon_cdna_Identifier") != null ) this.setCdna_Identifier(tuple.getString("Exon_cdna_Identifier"));		
			//set Cdna_Start
			if( strict || tuple.getInt("cdna_start") != null) this.setCdna_Start(tuple.getInt("cdna_start"));
			if( tuple.getInt("Exon_cdna_start") != null) this.setCdna_Start(tuple.getInt("Exon_cdna_start"));
			//set Cdna_End
			if( strict || tuple.getInt("cdna_end") != null) this.setCdna_End(tuple.getInt("cdna_end"));
			if( tuple.getInt("Exon_cdna_end") != null) this.setCdna_End(tuple.getInt("Exon_cdna_end"));
			//set Gdna
			if( strict || tuple.getInt("gdna_id") != null) this.setGdna(tuple.getInt("gdna_id"));
			if( tuple.getInt("Exon_gdna_id") != null) this.setGdna(tuple.getInt("Exon_gdna_id"));
			//alias of xref
			if( tuple.getObject("gdna") != null) this.setGdna(tuple.getInt("gdna"));
			if( tuple.getObject("Exon_gdna") != null) this.setGdna(tuple.getInt("Exon_gdna"));
			//set label for field Gdna
			if( strict || tuple.getObject("gdna_Identifier") != null) this.setGdna_Identifier(tuple.getString("gdna_Identifier"));			
			if( tuple.getObject("Exon_gdna_Identifier") != null ) this.setGdna_Identifier(tuple.getString("Exon_gdna_Identifier"));		
			//set Gdna_Start
			if( strict || tuple.getInt("gdna_start") != null) this.setGdna_Start(tuple.getInt("gdna_start"));
			if( tuple.getInt("Exon_gdna_start") != null) this.setGdna_Start(tuple.getInt("Exon_gdna_start"));
			//set Gdna_End
			if( strict || tuple.getInt("gdna_end") != null) this.setGdna_End(tuple.getInt("gdna_end"));
			if( tuple.getInt("Exon_gdna_end") != null) this.setGdna_End(tuple.getInt("Exon_gdna_end"));
			//set IsIntron
			if( strict || tuple.getBoolean("isIntron") != null) this.setIsIntron(tuple.getBoolean("isIntron"));
			if( tuple.getBoolean("Exon_isIntron") != null) this.setIsIntron(tuple.getBoolean("Exon_isIntron"));
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
		String result = "Exon(";
		result+= "id='" + getId()+"' ";	
		result+= "identifier='" + getIdentifier()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= "__Type='" + get__Type()+"' ";	
		result+= "description='" + getDescription()+"' ";	
		result+= " cdna_id='" + getCdna_Id()+"' ";	
		result+= " cdna_identifier='" + getCdna_Identifier()+"' ";
		result+= "cdna_start='" + getCdna_Start()+"' ";	
		result+= "cdna_end='" + getCdna_End()+"' ";	
		result+= " gdna_id='" + getGdna_Id()+"' ";	
		result+= " gdna_identifier='" + getGdna_Identifier()+"' ";
		result+= "gdna_start='" + getGdna_Start()+"' ";	
		result+= "gdna_end='" + getGdna_End()+"' ";	
		result+= "isIntron='" + getIsIntron()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Exon.
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
			fields.add("isIntron");
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
		+ "gdna" +sep
		+ "gdna_start" +sep
		+ "gdna_end" +sep
		+ "isIntron" 
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
		Exon rhs = (Exon) obj;
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
			Object valueO = getIsIntron();
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
	public Exon create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Exon e = new Exon();
		e.set(tuple);
		return e;
	}
	

	
}

