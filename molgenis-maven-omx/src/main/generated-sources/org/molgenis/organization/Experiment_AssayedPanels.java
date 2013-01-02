
/* File:        org.molgenis.omx/model/Experiment_AssayedPanels.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.organization;

/**
 * Experiment_AssayedPanels: Link table for many-to-many relationship 'Experiment.AssayedPanels'..
 * @author MOLGENIS generator
 */
@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.organization.db.Experiment_AssayedPanelsEntityListener.class})
public class Experiment_AssayedPanels extends org.molgenis.util.AbstractEntity 
{
	// fieldname constants
	public final static String AUTOID = "autoid";
	public final static String ASSAYEDPANELS = "AssayedPanels";
	public final static String ASSAYEDPANELS_IDENTIFIER = "AssayedPanels_Identifier";
	public final static String EXPERIMENT = "Experiment";
	public final static String EXPERIMENT_IDENTIFIER = "Experiment_Identifier";
	
	//static methods
	/**
	 * Shorthand for db.query(Experiment_AssayedPanels.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Experiment_AssayedPanels> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Experiment_AssayedPanels.class);
	}
	
	/**
	 * Shorthand for db.find(Experiment_AssayedPanels.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Experiment_AssayedPanels> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Experiment_AssayedPanels.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Experiment_AssayedPanels findByAutoid(org.molgenis.framework.db.Database db, Integer autoid) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Experiment_AssayedPanels> q = db.query(Experiment_AssayedPanels.class);
		q.eq(Experiment_AssayedPanels.AUTOID, autoid);
		java.util.List<Experiment_AssayedPanels> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Experiment_AssayedPanels findByAssayedPanelsExperiment(org.molgenis.framework.db.Database db, Integer assayedPanels, Integer experiment) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Experiment_AssayedPanels> q = db.query(Experiment_AssayedPanels.class);
		q.eq(Experiment_AssayedPanels.ASSAYEDPANELS, assayedPanels);q.eq(Experiment_AssayedPanels.EXPERIMENT, experiment);
		java.util.List<Experiment_AssayedPanels> result = q.find();
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
    @javax.persistence.JoinColumn(name="AssayedPanels", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.observ.target.Panel assayedPanels = null;
	@javax.persistence.Transient
	private Integer assayedPanels_id = null;	
	@javax.persistence.Transient
	private String assayedPanels_Identifier = null;						


	//[type=xref]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Experiment", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.organization.Experiment experiment = null;
	@javax.persistence.Transient
	private Integer experiment_id = null;	
	@javax.persistence.Transient
	private String experiment_Identifier = null;						

	//constructors
	public Experiment_AssayedPanels()
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
	 * @return assayedPanels.
	 */
	public org.molgenis.observ.target.Panel getAssayedPanels()
	{
		return this.assayedPanels;
	}
	
	@Deprecated
	public org.molgenis.observ.target.Panel getAssayedPanels(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the .
	 * @param assayedPanels
	 */
	public void setAssayedPanels( org.molgenis.observ.target.Panel assayedPanels)
	{
		
		this.assayedPanels = assayedPanels;
	}

	
	
	/**
	 * Set foreign key for field assayedPanels.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setAssayedPanels_Id(Integer assayedPanels_id)
	{
		this.assayedPanels_id = assayedPanels_id;
	}	

	public void setAssayedPanels(Integer assayedPanels_id)
	{
		this.assayedPanels_id = assayedPanels_id;
	}
	
	public Integer getAssayedPanels_Id()
	{
		
		if(assayedPanels != null) 
		{
			return assayedPanels.getId();
		}
		else
		{
			return assayedPanels_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference AssayedPanels to Panel.Id.
	 */
	public String getAssayedPanels_Identifier()
	{		
		//FIXME should we auto-load based on getAssayedPanels()?	
		if(assayedPanels != null) {
			return assayedPanels.getIdentifier();
		} else {
			return assayedPanels_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference AssayedPanels to <a href="Panel.html#Id">Panel.Id</a>.
	 * Implies setAssayedPanels(null) until save
	 */
	public void setAssayedPanels_Identifier(String assayedPanels_Identifier)
	{
		this.assayedPanels_Identifier = assayedPanels_Identifier;
	}		
	 
	

	/**
	 * Get the .
	 * @return experiment.
	 */
	public org.molgenis.organization.Experiment getExperiment()
	{
		return this.experiment;
	}
	
	@Deprecated
	public org.molgenis.organization.Experiment getExperiment(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the .
	 * @param experiment
	 */
	public void setExperiment( org.molgenis.organization.Experiment experiment)
	{
		
		this.experiment = experiment;
	}

	
	
	/**
	 * Set foreign key for field experiment.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setExperiment_Id(Integer experiment_id)
	{
		this.experiment_id = experiment_id;
	}	

	public void setExperiment(Integer experiment_id)
	{
		this.experiment_id = experiment_id;
	}
	
	public Integer getExperiment_Id()
	{
		
		if(experiment != null) 
		{
			return experiment.getId();
		}
		else
		{
			return experiment_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference Experiment to Experiment.Id.
	 */
	public String getExperiment_Identifier()
	{		
		//FIXME should we auto-load based on getExperiment()?	
		if(experiment != null) {
			return experiment.getIdentifier();
		} else {
			return experiment_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Experiment to <a href="Experiment.html#Id">Experiment.Id</a>.
	 * Implies setExperiment(null) until save
	 */
	public void setExperiment_Identifier(String experiment_Identifier)
	{
		this.experiment_Identifier = experiment_Identifier;
	}		
	 
	


	/**
	 * Generic getter. Get the property by using the name.
	 */
	public Object get(String name)
	{
		name = name.toLowerCase();
		if (name.toLowerCase().equals("autoid"))
			return getAutoid();
		if (name.toLowerCase().equals("assayedpanels"))
			return getAssayedPanels();
		if(name.toLowerCase().equals("assayedpanels_id"))
			return getAssayedPanels_Id();
		if(name.toLowerCase().equals("assayedpanels_identifier"))
			return getAssayedPanels_Identifier();
		if (name.toLowerCase().equals("experiment"))
			return getExperiment();
		if(name.toLowerCase().equals("experiment_id"))
			return getExperiment_Id();
		if(name.toLowerCase().equals("experiment_identifier"))
			return getExperiment_Identifier();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getAutoid() == null) throw new org.molgenis.framework.db.DatabaseException("required field autoid is null");
		if(this.getAssayedPanels() == null) throw new org.molgenis.framework.db.DatabaseException("required field assayedPanels is null");
		if(this.getExperiment() == null) throw new org.molgenis.framework.db.DatabaseException("required field experiment is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.util.Tuple tuple, boolean strict )  throws Exception
	{
		//optimization :-(
		if(tuple instanceof org.molgenis.util.ResultSetTuple)
		{
				//set Autoid
			this.setAutoid(tuple.getInt("autoid"));
			//set AssayedPanels
			this.setAssayedPanels(tuple.getInt("AssayedPanels"));
			//set label Identifier for xref field AssayedPanels
			this.setAssayedPanels_Identifier(tuple.getString("AssayedPanels_Identifier"));	
			//set Experiment
			this.setExperiment(tuple.getInt("Experiment"));
			//set label Identifier for xref field Experiment
			this.setExperiment_Identifier(tuple.getString("Experiment_Identifier"));	
		}
		else if(tuple != null)
		{
			//set Autoid
			if( strict || tuple.getInt("autoid") != null) this.setAutoid(tuple.getInt("autoid"));
			if( tuple.getInt("Experiment_AssayedPanels_autoid") != null) this.setAutoid(tuple.getInt("Experiment_AssayedPanels_autoid"));
			//set AssayedPanels
			if( strict || tuple.getInt("AssayedPanels_id") != null) this.setAssayedPanels(tuple.getInt("AssayedPanels_id"));
			if( tuple.getInt("Experiment_AssayedPanels_AssayedPanels_id") != null) this.setAssayedPanels(tuple.getInt("Experiment_AssayedPanels_AssayedPanels_id"));
			//alias of xref
			if( tuple.getObject("AssayedPanels") != null) this.setAssayedPanels(tuple.getInt("AssayedPanels"));
			if( tuple.getObject("Experiment_AssayedPanels_AssayedPanels") != null) this.setAssayedPanels(tuple.getInt("Experiment_AssayedPanels_AssayedPanels"));
			//set label for field AssayedPanels
			if( strict || tuple.getObject("AssayedPanels_Identifier") != null) this.setAssayedPanels_Identifier(tuple.getString("AssayedPanels_Identifier"));			
			if( tuple.getObject("Experiment_AssayedPanels_AssayedPanels_Identifier") != null ) this.setAssayedPanels_Identifier(tuple.getString("Experiment_AssayedPanels_AssayedPanels_Identifier"));		
			//set Experiment
			if( strict || tuple.getInt("Experiment_id") != null) this.setExperiment(tuple.getInt("Experiment_id"));
			if( tuple.getInt("Experiment_AssayedPanels_Experiment_id") != null) this.setExperiment(tuple.getInt("Experiment_AssayedPanels_Experiment_id"));
			//alias of xref
			if( tuple.getObject("Experiment") != null) this.setExperiment(tuple.getInt("Experiment"));
			if( tuple.getObject("Experiment_AssayedPanels_Experiment") != null) this.setExperiment(tuple.getInt("Experiment_AssayedPanels_Experiment"));
			//set label for field Experiment
			if( strict || tuple.getObject("Experiment_Identifier") != null) this.setExperiment_Identifier(tuple.getString("Experiment_Identifier"));			
			if( tuple.getObject("Experiment_AssayedPanels_Experiment_Identifier") != null ) this.setExperiment_Identifier(tuple.getString("Experiment_AssayedPanels_Experiment_Identifier"));		
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
		String result = "Experiment_AssayedPanels(";
		result+= "autoid='" + getAutoid()+"' ";	
		result+= " assayedPanels_id='" + getAssayedPanels_Id()+"' ";	
		result+= " assayedPanels_identifier='" + getAssayedPanels_Identifier()+"' ";
		result+= " experiment_id='" + getExperiment_Id()+"' ";	
		result+= " experiment_identifier='" + getExperiment_Identifier()+"' ";
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Experiment_AssayedPanels.
	 */
	public java.util.Vector<String> getFields(boolean skipAutoIds)
	{
		java.util.Vector<String> fields = new java.util.Vector<String>();
		if(!skipAutoIds)
		{
			fields.add("autoid");
		}
		{
			fields.add("assayedPanels_id");
		}
		fields.add("assayedPanels_identifier");
		{
			fields.add("experiment_id");
		}
		fields.add("experiment_identifier");
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
		result.add("AssayedPanels");
		result.add("Experiment");
		return result;
	}

	@Deprecated
	public String getFields(String sep)
	{
		return (""
		+ "autoid" +sep
		+ "assayedPanels" +sep
		+ "experiment" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("assayedPanels")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("experiment")) {
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
		Experiment_AssayedPanels rhs = (Experiment_AssayedPanels) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
		//assayedPanels
		//experiment
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
			Object valueO = getAssayedPanels();
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
			Object valueO = getExperiment();
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
	public Experiment_AssayedPanels create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Experiment_AssayedPanels e = new Experiment_AssayedPanels();
		e.set(tuple);
		return e;
	}
	

	
}

