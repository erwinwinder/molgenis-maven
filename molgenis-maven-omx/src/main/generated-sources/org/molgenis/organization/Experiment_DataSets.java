
/* File:        org.molgenis/model/Experiment_DataSets.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.organization;

/**
 * Experiment_DataSets: Link table for many-to-many relationship 'Experiment.DataSets'..
 * @author MOLGENIS generator
 */
@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.organization.db.Experiment_DataSetsEntityListener.class})
public class Experiment_DataSets extends org.molgenis.util.AbstractEntity 
{
	// fieldname constants
	public final static String AUTOID = "autoid";
	public final static String DATASETS = "DataSets";
	public final static String DATASETS_IDENTIFIER = "DataSets_Identifier";
	public final static String EXPERIMENT = "Experiment";
	public final static String EXPERIMENT_IDENTIFIER = "Experiment_Identifier";
	
	//static methods
	/**
	 * Shorthand for db.query(Experiment_DataSets.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Experiment_DataSets> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Experiment_DataSets.class);
	}
	
	/**
	 * Shorthand for db.find(Experiment_DataSets.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Experiment_DataSets> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Experiment_DataSets.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Experiment_DataSets findByAutoid(org.molgenis.framework.db.Database db, Integer autoid) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Experiment_DataSets> q = db.query(Experiment_DataSets.class);
		q.eq(Experiment_DataSets.AUTOID, autoid);
		java.util.List<Experiment_DataSets> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Experiment_DataSets findByDataSetsExperiment(org.molgenis.framework.db.Database db, Integer dataSets, Integer experiment) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Experiment_DataSets> q = db.query(Experiment_DataSets.class);
		q.eq(Experiment_DataSets.DATASETS, dataSets);q.eq(Experiment_DataSets.EXPERIMENT, experiment);
		java.util.List<Experiment_DataSets> result = q.find();
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
    @javax.persistence.JoinColumn(name="DataSets", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.observ.DataSet dataSets = null;
	@javax.persistence.Transient
	private Integer dataSets_id = null;	
	@javax.persistence.Transient
	private String dataSets_Identifier = null;						


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
	public Experiment_DataSets()
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
	 * @return dataSets.
	 */
	public org.molgenis.observ.DataSet getDataSets()
	{
		return this.dataSets;
	}
	
	@Deprecated
	public org.molgenis.observ.DataSet getDataSets(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the .
	 * @param dataSets
	 */
	public void setDataSets( org.molgenis.observ.DataSet dataSets)
	{
		
		this.dataSets = dataSets;
	}

	
	
	/**
	 * Set foreign key for field dataSets.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setDataSets_Id(Integer dataSets_id)
	{
		this.dataSets_id = dataSets_id;
	}	

	public void setDataSets(Integer dataSets_id)
	{
		this.dataSets_id = dataSets_id;
	}
	
	public Integer getDataSets_Id()
	{
		
		if(dataSets != null) 
		{
			return dataSets.getId();
		}
		else
		{
			return dataSets_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference DataSets to DataSet.Id.
	 */
	public String getDataSets_Identifier()
	{		
		//FIXME should we auto-load based on getDataSets()?	
		if(dataSets != null) {
			return dataSets.getIdentifier();
		} else {
			return dataSets_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference DataSets to <a href="DataSet.html#Id">DataSet.Id</a>.
	 * Implies setDataSets(null) until save
	 */
	public void setDataSets_Identifier(String dataSets_Identifier)
	{
		this.dataSets_Identifier = dataSets_Identifier;
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
		if (name.toLowerCase().equals("datasets"))
			return getDataSets();
		if(name.toLowerCase().equals("datasets_id"))
			return getDataSets_Id();
		if(name.toLowerCase().equals("datasets_identifier"))
			return getDataSets_Identifier();
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
		if(this.getDataSets() == null) throw new org.molgenis.framework.db.DatabaseException("required field dataSets is null");
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
			//set DataSets
			this.setDataSets(tuple.getInt("DataSets"));
			//set label Identifier for xref field DataSets
			this.setDataSets_Identifier(tuple.getString("DataSets_Identifier"));	
			//set Experiment
			this.setExperiment(tuple.getInt("Experiment"));
			//set label Identifier for xref field Experiment
			this.setExperiment_Identifier(tuple.getString("Experiment_Identifier"));	
		}
		else if(tuple != null)
		{
			//set Autoid
			if( strict || tuple.getInt("autoid") != null) this.setAutoid(tuple.getInt("autoid"));
			if( tuple.getInt("Experiment_DataSets_autoid") != null) this.setAutoid(tuple.getInt("Experiment_DataSets_autoid"));
			//set DataSets
			if( strict || tuple.getInt("DataSets_id") != null) this.setDataSets(tuple.getInt("DataSets_id"));
			if( tuple.getInt("Experiment_DataSets_DataSets_id") != null) this.setDataSets(tuple.getInt("Experiment_DataSets_DataSets_id"));
			//alias of xref
			if( tuple.getObject("DataSets") != null) this.setDataSets(tuple.getInt("DataSets"));
			if( tuple.getObject("Experiment_DataSets_DataSets") != null) this.setDataSets(tuple.getInt("Experiment_DataSets_DataSets"));
			//set label for field DataSets
			if( strict || tuple.getObject("DataSets_Identifier") != null) this.setDataSets_Identifier(tuple.getString("DataSets_Identifier"));			
			if( tuple.getObject("Experiment_DataSets_DataSets_Identifier") != null ) this.setDataSets_Identifier(tuple.getString("Experiment_DataSets_DataSets_Identifier"));		
			//set Experiment
			if( strict || tuple.getInt("Experiment_id") != null) this.setExperiment(tuple.getInt("Experiment_id"));
			if( tuple.getInt("Experiment_DataSets_Experiment_id") != null) this.setExperiment(tuple.getInt("Experiment_DataSets_Experiment_id"));
			//alias of xref
			if( tuple.getObject("Experiment") != null) this.setExperiment(tuple.getInt("Experiment"));
			if( tuple.getObject("Experiment_DataSets_Experiment") != null) this.setExperiment(tuple.getInt("Experiment_DataSets_Experiment"));
			//set label for field Experiment
			if( strict || tuple.getObject("Experiment_Identifier") != null) this.setExperiment_Identifier(tuple.getString("Experiment_Identifier"));			
			if( tuple.getObject("Experiment_DataSets_Experiment_Identifier") != null ) this.setExperiment_Identifier(tuple.getString("Experiment_DataSets_Experiment_Identifier"));		
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
		String result = "Experiment_DataSets(";
		result+= "autoid='" + getAutoid()+"' ";	
		result+= " dataSets_id='" + getDataSets_Id()+"' ";	
		result+= " dataSets_identifier='" + getDataSets_Identifier()+"' ";
		result+= " experiment_id='" + getExperiment_Id()+"' ";	
		result+= " experiment_identifier='" + getExperiment_Identifier()+"' ";
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Experiment_DataSets.
	 */
	public java.util.Vector<String> getFields(boolean skipAutoIds)
	{
		java.util.Vector<String> fields = new java.util.Vector<String>();
		if(!skipAutoIds)
		{
			fields.add("autoid");
		}
		{
			fields.add("dataSets_id");
		}
		fields.add("dataSets_identifier");
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
		result.add("DataSets");
		result.add("Experiment");
		return result;
	}

	@Deprecated
	public String getFields(String sep)
	{
		return (""
		+ "autoid" +sep
		+ "dataSets" +sep
		+ "experiment" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("dataSets")) {
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
		Experiment_DataSets rhs = (Experiment_DataSets) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
		//dataSets
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
			Object valueO = getDataSets();
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
	public Experiment_DataSets create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Experiment_DataSets e = new Experiment_DataSets();
		e.set(tuple);
		return e;
	}
	

	
}

