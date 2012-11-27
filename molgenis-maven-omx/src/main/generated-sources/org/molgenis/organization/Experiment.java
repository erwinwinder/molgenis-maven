
/* File:        org.molgenis/model/Experiment.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.organization;

/**
 * Experiment: .
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "Experiment", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "Identifier" } ) }
)


@javax.persistence.Inheritance(strategy=javax.persistence.InheritanceType.JOINED)
@javax.persistence.DiscriminatorColumn(name="DType", discriminatorType=javax.persistence.DiscriminatorType.STRING)
@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.organization.db.ExperimentEntityListener.class})
public class Experiment extends org.molgenis.util.AbstractEntity implements org.molgenis.core.Identifiable
{
	// fieldname constants
	public final static String ID = "id";
	public final static String IDENTIFIER = "Identifier";
	public final static String NAME = "Name";
	public final static String __TYPE = "__Type";
	public final static String STUDY = "Study";
	public final static String STUDY_IDENTIFIER = "Study_Identifier";
	public final static String DESIGN = "Design";
	public final static String EXPERIMENTTYPE = "ExperimentType";
	public final static String EXPERIMENTTYPE_IDENTIFIER = "ExperimentType_Identifier";
	public final static String TOTALMARKERSTESTED = "TotalMarkersTested";
	public final static String TOTALMARKERSIMPORTED = "TotalMarkersImported";
	public final static String OBJECTIVE = "Objective";
	public final static String OUTCOME = "Outcome";
	public final static String COMMENTS = "Comments";
	public final static String INDIVIDUALDATASTATEMENT = "IndividualDataStatement";
	public final static String TIMECREATED = "TimeCreated";
	public final static String ASSAYEDPANELS = "AssayedPanels";
	public final static String ASSAYEDPANELS_IDENTIFIER = "AssayedPanels_Identifier";
	public final static String DATASETS = "DataSets";
	public final static String DATASETS_IDENTIFIER = "DataSets_Identifier";
	
	//static methods
	/**
	 * Shorthand for db.query(Experiment.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Experiment> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Experiment.class);
	}
	
	/**
	 * Shorthand for db.find(Experiment.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Experiment> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Experiment.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Experiment findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Experiment> q = db.query(Experiment.class);
		q.eq(Experiment.ID, id);
		java.util.List<Experiment> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Experiment findByIdentifier(org.molgenis.framework.db.Database db, String identifier) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Experiment> q = db.query(Experiment.class);
		q.eq(Experiment.IDENTIFIER, identifier);
		java.util.List<Experiment> result = q.find();
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


	//Subtypes have to be set to allow searching[type=enum]
	@javax.persistence.Column(name="DType", nullable=false)            
	@javax.xml.bind.annotation.XmlElement(name="__Type")
	
				

	@javax.validation.constraints.NotNull
	private String __Type =  null;
	@javax.persistence.Transient
	private String __Type_label = null;
	@javax.persistence.Transient
	private java.util.List<org.molgenis.util.ValueLabel> __Type_options = new java.util.ArrayList<org.molgenis.util.ValueLabel>();


	//Part of Study.[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Study", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.organization.Study study = null;
	@javax.persistence.Transient
	private Integer study_id = null;	
	@javax.persistence.Transient
	private String study_Identifier = null;						


	//Design[type=string]
	@javax.persistence.Column(name="Design")
	@javax.xml.bind.annotation.XmlElement(name="design")
	
				

	private String design =  null;


	//Experiment type. E.g. 'case-control'.[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="ExperimentType", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.observ.target.OntologyTerm experimentType = null;
	@javax.persistence.Transient
	private Integer experimentType_id = null;	
	@javax.persistence.Transient
	private String experimentType_Identifier = null;						


	//Total markers tested[type=int]
	@javax.persistence.Column(name="TotalMarkersTested")
	@javax.xml.bind.annotation.XmlElement(name="totalMarkersTested")
	
				

	private Integer totalMarkersTested =  null;


	//Total markers imported[type=int]
	@javax.persistence.Column(name="TotalMarkersImported")
	@javax.xml.bind.annotation.XmlElement(name="totalMarkersImported")
	
				

	private Integer totalMarkersImported =  null;


	//Objective[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="Objective", length=16777216)
	
				

	private String objective =  null;


	//Outcome[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="Outcome", length=16777216)
	
				

	private String outcome =  null;


	//Comments[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="Comments", length=16777216)
	
				

	private String comments =  null;


	//Individual data statement[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="IndividualDataStatement", length=16777216)
	
				

	private String individualDataStatement =  "Access to individual-level data must be made to the study authors";


	//Time created[type=datetime]
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@javax.persistence.Column(name="TimeCreated", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="timeCreated")
	
				

	@javax.validation.constraints.NotNull
	private java.util.Date timeCreated =  null;


	//Assayed panels[type=mref]
    @javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="AssayedPanels", insertable=true, updatable=true, nullable=false)
	@javax.persistence.JoinTable(name="Experiment_AssayedPanels", 
			joinColumns=@javax.persistence.JoinColumn(name="Experiment"), inverseJoinColumns=@javax.persistence.JoinColumn(name="AssayedPanels"))
	
				

	@javax.validation.constraints.NotNull
	private java.util.List<org.molgenis.observ.target.Panel> assayedPanels = new java.util.ArrayList<org.molgenis.observ.target.Panel>();
	@javax.persistence.Transient
	private java.util.List<Integer> assayedPanels_id = new java.util.ArrayList<Integer>();		
	@javax.persistence.Transient
	private java.util.List<String> assayedPanels_Identifier = new java.util.ArrayList<String>();


	//DataSets that were input/output of this experiment.[type=mref]
    @javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="DataSets", insertable=true, updatable=true, nullable=false)
	@javax.persistence.JoinTable(name="Experiment_DataSets", 
			joinColumns=@javax.persistence.JoinColumn(name="Experiment"), inverseJoinColumns=@javax.persistence.JoinColumn(name="DataSets"))
	
				

	@javax.validation.constraints.NotNull
	private java.util.List<org.molgenis.observ.DataSet> dataSets = new java.util.ArrayList<org.molgenis.observ.DataSet>();
	@javax.persistence.Transient
	private java.util.List<Integer> dataSets_id = new java.util.ArrayList<Integer>();		
	@javax.persistence.Transient
	private java.util.List<String> dataSets_Identifier = new java.util.ArrayList<String>();

	//constructors
	public Experiment()
	{
		//set the type for a new instance
		set__Type(this.getClass().getSimpleName());
	
		//options for enum __Type
		__Type_options.add(new org.molgenis.util.ValueLabel("Experiment","Experiment"));
		__Type_options.add(new org.molgenis.util.ValueLabel("GWASExperiment","GWASExperiment"));
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
	 * Get the Subtypes have to be set to allow searching.
	 * @return __Type.
	 */
	public String get__Type()
	{
		return this.__Type;
	}
	
	@Deprecated
	public String get__Type(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Subtypes have to be set to allow searching.
	 * @param __Type
	 */
	public void set__Type( String __Type)
	{
		
		this.__Type = __Type;
	}

	
	/**
	 * Get tha label for enum __Type.
	 */
	public String get__TypeLabel()
	{
		return this.__Type_label;
	}
	
	/**
	 * __Type is enum. This method returns all available enum options.
	 */
	public java.util.List<org.molgenis.util.ValueLabel> get__TypeOptions()
	{
		return __Type_options;
	}	
	

	/**
	 * Get the Part of Study..
	 * @return study.
	 */
	public org.molgenis.organization.Study getStudy()
	{
		return this.study;
	}
	
	@Deprecated
	public org.molgenis.organization.Study getStudy(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Part of Study..
	 * @param study
	 */
	public void setStudy( org.molgenis.organization.Study study)
	{
		
		this.study = study;
	}

	
	
	/**
	 * Set foreign key for field study.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setStudy_Id(Integer study_id)
	{
		this.study_id = study_id;
	}	

	public void setStudy(Integer study_id)
	{
		this.study_id = study_id;
	}
	
	public Integer getStudy_Id()
	{
		
		if(study != null) 
		{
			return study.getId();
		}
		else
		{
			return study_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference Study to Study.Id.
	 */
	public String getStudy_Identifier()
	{		
		//FIXME should we auto-load based on getStudy()?	
		if(study != null) {
			return study.getIdentifier();
		} else {
			return study_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Study to <a href="Study.html#Id">Study.Id</a>.
	 * Implies setStudy(null) until save
	 */
	public void setStudy_Identifier(String study_Identifier)
	{
		this.study_Identifier = study_Identifier;
	}		
	 
	

	/**
	 * Get the Design.
	 * @return design.
	 */
	public String getDesign()
	{
		return this.design;
	}
	
	@Deprecated
	public String getDesign(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Design.
	 * @param design
	 */
	public void setDesign( String design)
	{
		
		this.design = design;
	}

	

	/**
	 * Get the Experiment type. E.g. 'case-control'..
	 * @return experimentType.
	 */
	public org.molgenis.observ.target.OntologyTerm getExperimentType()
	{
		return this.experimentType;
	}
	
	@Deprecated
	public org.molgenis.observ.target.OntologyTerm getExperimentType(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Experiment type. E.g. 'case-control'..
	 * @param experimentType
	 */
	public void setExperimentType( org.molgenis.observ.target.OntologyTerm experimentType)
	{
		
		this.experimentType = experimentType;
	}

	
	
	/**
	 * Set foreign key for field experimentType.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setExperimentType_Id(Integer experimentType_id)
	{
		this.experimentType_id = experimentType_id;
	}	

	public void setExperimentType(Integer experimentType_id)
	{
		this.experimentType_id = experimentType_id;
	}
	
	public Integer getExperimentType_Id()
	{
		
		if(experimentType != null) 
		{
			return experimentType.getId();
		}
		else
		{
			return experimentType_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference ExperimentType to OntologyTerm.Id.
	 */
	public String getExperimentType_Identifier()
	{		
		//FIXME should we auto-load based on getExperimentType()?	
		if(experimentType != null) {
			return experimentType.getIdentifier();
		} else {
			return experimentType_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference ExperimentType to <a href="OntologyTerm.html#Id">OntologyTerm.Id</a>.
	 * Implies setExperimentType(null) until save
	 */
	public void setExperimentType_Identifier(String experimentType_Identifier)
	{
		this.experimentType_Identifier = experimentType_Identifier;
	}		
	 
	

	/**
	 * Get the Total markers tested.
	 * @return totalMarkersTested.
	 */
	public Integer getTotalMarkersTested()
	{
		return this.totalMarkersTested;
	}
	
	@Deprecated
	public Integer getTotalMarkersTested(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Total markers tested.
	 * @param totalMarkersTested
	 */
	public void setTotalMarkersTested( Integer totalMarkersTested)
	{
		
		this.totalMarkersTested = totalMarkersTested;
	}

	

	/**
	 * Get the Total markers imported.
	 * @return totalMarkersImported.
	 */
	public Integer getTotalMarkersImported()
	{
		return this.totalMarkersImported;
	}
	
	@Deprecated
	public Integer getTotalMarkersImported(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Total markers imported.
	 * @param totalMarkersImported
	 */
	public void setTotalMarkersImported( Integer totalMarkersImported)
	{
		
		this.totalMarkersImported = totalMarkersImported;
	}

	

	/**
	 * Get the Objective.
	 * @return objective.
	 */
	public String getObjective()
	{
		return this.objective;
	}
	
	@Deprecated
	public String getObjective(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Objective.
	 * @param objective
	 */
	public void setObjective( String objective)
	{
		
		this.objective = objective;
	}

	

	/**
	 * Get the Outcome.
	 * @return outcome.
	 */
	public String getOutcome()
	{
		return this.outcome;
	}
	
	@Deprecated
	public String getOutcome(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Outcome.
	 * @param outcome
	 */
	public void setOutcome( String outcome)
	{
		
		this.outcome = outcome;
	}

	

	/**
	 * Get the Comments.
	 * @return comments.
	 */
	public String getComments()
	{
		return this.comments;
	}
	
	@Deprecated
	public String getComments(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Comments.
	 * @param comments
	 */
	public void setComments( String comments)
	{
		
		this.comments = comments;
	}

	

	/**
	 * Get the Individual data statement.
	 * @return individualDataStatement.
	 */
	public String getIndividualDataStatement()
	{
		return this.individualDataStatement;
	}
	
	@Deprecated
	public String getIndividualDataStatement(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Individual data statement.
	 * @param individualDataStatement
	 */
	public void setIndividualDataStatement( String individualDataStatement)
	{
		
		this.individualDataStatement = individualDataStatement;
	}

	

	/**
	 * Get the Time created.
	 * @return timeCreated.
	 */
	public java.util.Date getTimeCreated()
	{
		return this.timeCreated;
	}
	
	@Deprecated
	public java.util.Date getTimeCreated(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Time created.
	 * @param timeCreated
	 */
	public void setTimeCreated( java.util.Date timeCreated)
	{
		
		this.timeCreated = timeCreated;
	}

	

	/**
	 * Get the Assayed panels.
	 * @return assayedPanels.
	 */
	public java.util.List<org.molgenis.observ.target.Panel> getAssayedPanels()
	{
		return this.assayedPanels;
	}
	
	@Deprecated
	public java.util.List<org.molgenis.observ.target.Panel> getAssayedPanels(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Assayed panels.
	 * @param assayedPanels
	 */
	public void setAssayedPanels( java.util.List<org.molgenis.observ.target.Panel> assayedPanels)
	{
		
		this.assayedPanels = assayedPanels;
	}

	
	public void setAssayedPanels_Id(Integer ... assayedPanels)
	{
		this.setAssayedPanels_Id(java.util.Arrays.asList(assayedPanels));
	}	
	
	public void setAssayedPanels(org.molgenis.observ.target.Panel ... assayedPanels)
	{
		this.setAssayedPanels(java.util.Arrays.asList(assayedPanels));
	}	
	
	/**
	 * Set foreign key for field assayedPanels.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setAssayedPanels_Id(java.util.List<Integer> assayedPanels_id)
	{
		this.assayedPanels_id = assayedPanels_id;
	}	
	
	public java.util.List<Integer> getAssayedPanels_Id()
	{
		return assayedPanels_id;
	}	
	
	/**
	 * Get a pretty label for cross reference AssayedPanels to <a href="Panel.html#Id">Panel.Id</a>.
	 */
	public java.util.List<String> getAssayedPanels_Identifier()
	{
		return assayedPanels_Identifier;
	}
	
	/**
	 * Update the foreign key AssayedPanels
	 * This sets assayedPanels to null until next database transaction.
	 */
	public void setAssayedPanels_Identifier(java.util.List<String> assayedPanels_Identifier)
	{
		this.assayedPanels_Identifier = assayedPanels_Identifier;
	}		
	

	/**
	 * Get the DataSets that were input/output of this experiment..
	 * @return dataSets.
	 */
	public java.util.List<org.molgenis.observ.DataSet> getDataSets()
	{
		return this.dataSets;
	}
	
	@Deprecated
	public java.util.List<org.molgenis.observ.DataSet> getDataSets(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the DataSets that were input/output of this experiment..
	 * @param dataSets
	 */
	public void setDataSets( java.util.List<org.molgenis.observ.DataSet> dataSets)
	{
		
		this.dataSets = dataSets;
	}

	
	public void setDataSets_Id(Integer ... dataSets)
	{
		this.setDataSets_Id(java.util.Arrays.asList(dataSets));
	}	
	
	public void setDataSets(org.molgenis.observ.DataSet ... dataSets)
	{
		this.setDataSets(java.util.Arrays.asList(dataSets));
	}	
	
	/**
	 * Set foreign key for field dataSets.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setDataSets_Id(java.util.List<Integer> dataSets_id)
	{
		this.dataSets_id = dataSets_id;
	}	
	
	public java.util.List<Integer> getDataSets_Id()
	{
		return dataSets_id;
	}	
	
	/**
	 * Get a pretty label for cross reference DataSets to <a href="DataSet.html#Id">DataSet.Id</a>.
	 */
	public java.util.List<String> getDataSets_Identifier()
	{
		return dataSets_Identifier;
	}
	
	/**
	 * Update the foreign key DataSets
	 * This sets dataSets to null until next database transaction.
	 */
	public void setDataSets_Identifier(java.util.List<String> dataSets_Identifier)
	{
		this.dataSets_Identifier = dataSets_Identifier;
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
		if (name.toLowerCase().equals("study"))
			return getStudy();
		if(name.toLowerCase().equals("study_id"))
			return getStudy_Id();
		if(name.toLowerCase().equals("study_identifier"))
			return getStudy_Identifier();
		if (name.toLowerCase().equals("design"))
			return getDesign();
		if (name.toLowerCase().equals("experimenttype"))
			return getExperimentType();
		if(name.toLowerCase().equals("experimenttype_id"))
			return getExperimentType_Id();
		if(name.toLowerCase().equals("experimenttype_identifier"))
			return getExperimentType_Identifier();
		if (name.toLowerCase().equals("totalmarkerstested"))
			return getTotalMarkersTested();
		if (name.toLowerCase().equals("totalmarkersimported"))
			return getTotalMarkersImported();
		if (name.toLowerCase().equals("objective"))
			return getObjective();
		if (name.toLowerCase().equals("outcome"))
			return getOutcome();
		if (name.toLowerCase().equals("comments"))
			return getComments();
		if (name.toLowerCase().equals("individualdatastatement"))
			return getIndividualDataStatement();
		if (name.toLowerCase().equals("timecreated"))
			return getTimeCreated();
		if (name.toLowerCase().equals("assayedpanels"))
			return getAssayedPanels();
		if(name.toLowerCase().equals("assayedpanels_id"))
			return getAssayedPanels_Id();
		if(name.toLowerCase().equals("assayedpanels_identifier"))
			return getAssayedPanels_Identifier();
		if (name.toLowerCase().equals("datasets"))
			return getDataSets();
		if(name.toLowerCase().equals("datasets_id"))
			return getDataSets_Id();
		if(name.toLowerCase().equals("datasets_identifier"))
			return getDataSets_Identifier();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getIdentifier() == null) throw new org.molgenis.framework.db.DatabaseException("required field identifier is null");
		if(this.getName() == null) throw new org.molgenis.framework.db.DatabaseException("required field name is null");
		if(this.get__Type() == null) throw new org.molgenis.framework.db.DatabaseException("required field __Type is null");
		if(this.getStudy() == null) throw new org.molgenis.framework.db.DatabaseException("required field study is null");
		if(this.getExperimentType() == null) throw new org.molgenis.framework.db.DatabaseException("required field experimentType is null");
		if(this.getTimeCreated() == null) throw new org.molgenis.framework.db.DatabaseException("required field timeCreated is null");
		if(this.getAssayedPanels() == null) throw new org.molgenis.framework.db.DatabaseException("required field assayedPanels is null");
		if(this.getDataSets() == null) throw new org.molgenis.framework.db.DatabaseException("required field dataSets is null");
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
			//set Study
			this.setStudy(tuple.getInt("Study"));
			//set label Identifier for xref field Study
			this.setStudy_Identifier(tuple.getString("Study_Identifier"));	
			//set Design
			this.setDesign(tuple.getString("Design"));
			//set ExperimentType
			this.setExperimentType(tuple.getInt("ExperimentType"));
			//set label Identifier for xref field ExperimentType
			this.setExperimentType_Identifier(tuple.getString("ExperimentType_Identifier"));	
			//set TotalMarkersTested
			this.setTotalMarkersTested(tuple.getInt("TotalMarkersTested"));
			//set TotalMarkersImported
			this.setTotalMarkersImported(tuple.getInt("TotalMarkersImported"));
			//set Objective
			this.setObjective(tuple.getString("Objective"));
			//set Outcome
			this.setOutcome(tuple.getString("Outcome"));
			//set Comments
			this.setComments(tuple.getString("Comments"));
			//set IndividualDataStatement
			this.setIndividualDataStatement(tuple.getString("IndividualDataStatement"));
			//set TimeCreated
			this.setTimeCreated(tuple.getTimestamp("TimeCreated"));
			//mrefs can not be directly retrieved
			//set AssayedPanels			
			//mrefs can not be directly retrieved
			//set DataSets			
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("Experiment_id") != null) this.setId(tuple.getInt("Experiment_id"));
			//set Identifier
			if( strict || tuple.getString("Identifier") != null) this.setIdentifier(tuple.getString("Identifier"));
			if( tuple.getString("Experiment_Identifier") != null) this.setIdentifier(tuple.getString("Experiment_Identifier"));
			//set Name
			if( strict || tuple.getString("Name") != null) this.setName(tuple.getString("Name"));
			if( tuple.getString("Experiment_Name") != null) this.setName(tuple.getString("Experiment_Name"));
			//set __Type
			if( strict || tuple.getString("__Type") != null) this.set__Type(tuple.getString("__Type"));
			if( tuple.getString("Experiment___Type") != null) this.set__Type(tuple.getString("Experiment___Type"));
			//set Study
			if( strict || tuple.getInt("Study_id") != null) this.setStudy(tuple.getInt("Study_id"));
			if( tuple.getInt("Experiment_Study_id") != null) this.setStudy(tuple.getInt("Experiment_Study_id"));
			//alias of xref
			if( tuple.getObject("Study") != null) this.setStudy(tuple.getInt("Study"));
			if( tuple.getObject("Experiment_Study") != null) this.setStudy(tuple.getInt("Experiment_Study"));
			//set label for field Study
			if( strict || tuple.getObject("Study_Identifier") != null) this.setStudy_Identifier(tuple.getString("Study_Identifier"));			
			if( tuple.getObject("Experiment_Study_Identifier") != null ) this.setStudy_Identifier(tuple.getString("Experiment_Study_Identifier"));		
			//set Design
			if( strict || tuple.getString("Design") != null) this.setDesign(tuple.getString("Design"));
			if( tuple.getString("Experiment_Design") != null) this.setDesign(tuple.getString("Experiment_Design"));
			//set ExperimentType
			if( strict || tuple.getInt("ExperimentType_id") != null) this.setExperimentType(tuple.getInt("ExperimentType_id"));
			if( tuple.getInt("Experiment_ExperimentType_id") != null) this.setExperimentType(tuple.getInt("Experiment_ExperimentType_id"));
			//alias of xref
			if( tuple.getObject("ExperimentType") != null) this.setExperimentType(tuple.getInt("ExperimentType"));
			if( tuple.getObject("Experiment_ExperimentType") != null) this.setExperimentType(tuple.getInt("Experiment_ExperimentType"));
			//set label for field ExperimentType
			if( strict || tuple.getObject("ExperimentType_Identifier") != null) this.setExperimentType_Identifier(tuple.getString("ExperimentType_Identifier"));			
			if( tuple.getObject("Experiment_ExperimentType_Identifier") != null ) this.setExperimentType_Identifier(tuple.getString("Experiment_ExperimentType_Identifier"));		
			//set TotalMarkersTested
			if( strict || tuple.getInt("TotalMarkersTested") != null) this.setTotalMarkersTested(tuple.getInt("TotalMarkersTested"));
			if( tuple.getInt("Experiment_TotalMarkersTested") != null) this.setTotalMarkersTested(tuple.getInt("Experiment_TotalMarkersTested"));
			//set TotalMarkersImported
			if( strict || tuple.getInt("TotalMarkersImported") != null) this.setTotalMarkersImported(tuple.getInt("TotalMarkersImported"));
			if( tuple.getInt("Experiment_TotalMarkersImported") != null) this.setTotalMarkersImported(tuple.getInt("Experiment_TotalMarkersImported"));
			//set Objective
			if( strict || tuple.getString("Objective") != null) this.setObjective(tuple.getString("Objective"));
			if( tuple.getString("Experiment_Objective") != null) this.setObjective(tuple.getString("Experiment_Objective"));
			//set Outcome
			if( strict || tuple.getString("Outcome") != null) this.setOutcome(tuple.getString("Outcome"));
			if( tuple.getString("Experiment_Outcome") != null) this.setOutcome(tuple.getString("Experiment_Outcome"));
			//set Comments
			if( strict || tuple.getString("Comments") != null) this.setComments(tuple.getString("Comments"));
			if( tuple.getString("Experiment_Comments") != null) this.setComments(tuple.getString("Experiment_Comments"));
			//set IndividualDataStatement
			if( strict || tuple.getString("IndividualDataStatement") != null) this.setIndividualDataStatement(tuple.getString("IndividualDataStatement"));
			if( tuple.getString("Experiment_IndividualDataStatement") != null) this.setIndividualDataStatement(tuple.getString("Experiment_IndividualDataStatement"));
			//set TimeCreated
			if( strict || tuple.getTimestamp("TimeCreated") != null) this.setTimeCreated(tuple.getTimestamp("TimeCreated"));
			if( tuple.getTimestamp("Experiment_TimeCreated") != null) this.setTimeCreated(tuple.getTimestamp("Experiment_TimeCreated"));
			//set AssayedPanels
			if( tuple.getObject("AssayedPanels")!= null || tuple.getObject("Experiment_AssayedPanels")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("AssayedPanels");
				if(tuple.getObject("Experiment_AssayedPanels")!= null) mrefs = tuple.getList("Experiment_AssayedPanels");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setAssayedPanels_Id( values );
			}
			//set labels Identifier for mref field AssayedPanels	
			if( tuple.getObject("AssayedPanels_Identifier")!= null || tuple.getObject("Experiment_AssayedPanels_Identifier")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("AssayedPanels_Identifier");
				if(tuple.getObject("Experiment_AssayedPanels_Identifier")!= null) mrefs = tuple.getList("Experiment_AssayedPanels_Identifier");
				
				if(mrefs != null) 
					for(Object ref: mrefs)
					{
						String[] refs = ref.toString().split("\\|");
						for(String r : refs) {
							values.add(r);	
						}						
					}							
				this.setAssayedPanels_Identifier( values );			
			}	
			//set DataSets
			if( tuple.getObject("DataSets")!= null || tuple.getObject("Experiment_DataSets")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("DataSets");
				if(tuple.getObject("Experiment_DataSets")!= null) mrefs = tuple.getList("Experiment_DataSets");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setDataSets_Id( values );
			}
			//set labels Identifier for mref field DataSets	
			if( tuple.getObject("DataSets_Identifier")!= null || tuple.getObject("Experiment_DataSets_Identifier")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("DataSets_Identifier");
				if(tuple.getObject("Experiment_DataSets_Identifier")!= null) mrefs = tuple.getList("Experiment_DataSets_Identifier");
				
				if(mrefs != null) 
					for(Object ref: mrefs)
					{
						String[] refs = ref.toString().split("\\|");
						for(String r : refs) {
							values.add(r);	
						}						
					}							
				this.setDataSets_Identifier( values );			
			}	
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
		String result = "Experiment(";
		result+= "id='" + getId()+"' ";	
		result+= "identifier='" + getIdentifier()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= "__Type='" + get__Type()+"' ";	
		result+= " study_id='" + getStudy_Id()+"' ";	
		result+= " study_identifier='" + getStudy_Identifier()+"' ";
		result+= "design='" + getDesign()+"' ";	
		result+= " experimentType_id='" + getExperimentType_Id()+"' ";	
		result+= " experimentType_identifier='" + getExperimentType_Identifier()+"' ";
		result+= "totalMarkersTested='" + getTotalMarkersTested()+"' ";	
		result+= "totalMarkersImported='" + getTotalMarkersImported()+"' ";	
		result+= "objective='" + getObjective()+"' ";	
		result+= "outcome='" + getOutcome()+"' ";	
		result+= "comments='" + getComments()+"' ";	
		result+= "individualDataStatement='" + getIndividualDataStatement()+"' ";	
		result+= "timeCreated='" + (getTimeCreated() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy, HH:mm:ss", java.util.Locale.US).format(getTimeCreated()))+"' ";
		result+= "timeCreated='" + (getTimeCreated() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy", java.util.Locale.US).format(getTimeCreated()))+"' ";		
		result+= " assayedPanels_id='" + getAssayedPanels_Id()+"' ";	
		result+= " assayedPanels_identifier='" + getAssayedPanels_Identifier()+"' ";
		result+= " dataSets_id='" + getDataSets_Id()+"' ";	
		result+= " dataSets_identifier='" + getDataSets_Identifier()+"' ";
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Experiment.
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
			fields.add("study_id");
		}
		fields.add("study_identifier");
		{
			fields.add("design");
		}
		{
			fields.add("experimentType_id");
		}
		fields.add("experimentType_identifier");
		{
			fields.add("totalMarkersTested");
		}
		{
			fields.add("totalMarkersImported");
		}
		{
			fields.add("objective");
		}
		{
			fields.add("outcome");
		}
		{
			fields.add("comments");
		}
		{
			fields.add("individualDataStatement");
		}
		{
			fields.add("timeCreated");
		}
		{
			fields.add("assayedPanels_id");
		}
		fields.add("assayedPanels_identifier");
		{
			fields.add("dataSets_id");
		}
		fields.add("dataSets_identifier");
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
		+ "study" +sep
		+ "design" +sep
		+ "experimentType" +sep
		+ "totalMarkersTested" +sep
		+ "totalMarkersImported" +sep
		+ "objective" +sep
		+ "outcome" +sep
		+ "comments" +sep
		+ "individualDataStatement" +sep
		+ "timeCreated" +sep
		+ "assayedPanels" +sep
		+ "dataSets" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("study")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("experimentType")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("assayedPanels")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("dataSets")) {
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
		Experiment rhs = (Experiment) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
		//identifier
				.append(identifier, rhs.getIdentifier())
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
			Object valueO = getStudy();
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
			Object valueO = getDesign();
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
			Object valueO = getExperimentType();
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
			Object valueO = getTotalMarkersTested();
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
			Object valueO = getTotalMarkersImported();
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
			Object valueO = getObjective();
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
			Object valueO = getOutcome();
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
			Object valueO = getComments();
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
			Object valueO = getIndividualDataStatement();
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
			Object valueO = getTimeCreated();
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
			Object valueO = getDataSets();
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
	public Experiment create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Experiment e = new Experiment();
		e.set(tuple);
		return e;
	}
	
//3
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="experimentID"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.gwascentral.UsedMarkerSet> experimentIDUsedMarkerSetCollection = new java.util.ArrayList<org.molgenis.gwascentral.UsedMarkerSet>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.gwascentral.UsedMarkerSet> getExperimentIDUsedMarkerSetCollection()
	{
            return experimentIDUsedMarkerSetCollection;
	}

    public void setExperimentIDUsedMarkerSetCollection(java.util.Collection<org.molgenis.gwascentral.UsedMarkerSet> collection)
    {
        for (org.molgenis.gwascentral.UsedMarkerSet usedMarkerSet : collection) {
            usedMarkerSet.setExperimentID(this);
        }
        experimentIDUsedMarkerSetCollection = collection;
    }	

	
}

