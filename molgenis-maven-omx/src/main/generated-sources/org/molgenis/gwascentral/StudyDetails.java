
/* File:        org.molgenis/model/StudyDetails.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.gwascentral;

/**
 * StudyDetails: .
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "StudyDetails", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "Study" } ) }
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.gwascentral.db.StudyDetailsEntityListener.class})
public class StudyDetails extends org.molgenis.util.AbstractEntity implements org.molgenis.core.Autoid
{
	// fieldname constants
	public final static String ID = "id";
	public final static String STUDY = "Study";
	public final static String STUDY_IDENTIFIER = "Study_Identifier";
	public final static String TITLE = "Title";
	public final static String SHORTNAME = "ShortName";
	public final static String STUDYABSTRACT = "StudyAbstract";
	public final static String VERSION = "Version";
	public final static String BACKGROUND = "Background";
	public final static String OBJECTIVES = "Objectives";
	public final static String KEYRESULTS = "KeyResults";
	public final static String CONCLUSIONS = "Conclusions";
	public final static String STUDYDESIGN = "StudyDesign";
	public final static String STUDYSIZEREASON = "StudySizeReason";
	public final static String STUDYPOWER = "StudyPower";
	public final static String SOURCESOFBIAS = "SourcesOfBias";
	public final static String LIMITATIONS = "Limitations";
	public final static String ACKNOWLEDGEMENTS = "Acknowledgements";
	public final static String PRIMARYCITATION = "primaryCitation";
	public final static String PRIMARYCITATION_IDENTIFIER = "primaryCitation_Identifier";
	public final static String OTHERCITATIONS = "otherCitations";
	public final static String OTHERCITATIONS_IDENTIFIER = "otherCitations_Identifier";
	public final static String ACCESSION = "Accession";
	
	//static methods
	/**
	 * Shorthand for db.query(StudyDetails.class).
	 */
	public static org.molgenis.framework.db.Query<? extends StudyDetails> query(org.molgenis.framework.db.Database db)
	{
		return db.query(StudyDetails.class);
	}
	
	/**
	 * Shorthand for db.find(StudyDetails.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends StudyDetails> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(StudyDetails.class, rules);
	}	
	
	/**
	 * 
	 */
	public static StudyDetails findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<StudyDetails> q = db.query(StudyDetails.class);
		q.eq(StudyDetails.ID, id);
		java.util.List<StudyDetails> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static StudyDetails findByStudy(org.molgenis.framework.db.Database db, Integer study) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<StudyDetails> q = db.query(StudyDetails.class);
		q.eq(StudyDetails.STUDY, study);
		java.util.List<StudyDetails> result = q.find();
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


	//Study[type=xref]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Study", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.organization.Study study = null;
	@javax.persistence.Transient
	private Integer study_id = null;	
	@javax.persistence.Transient
	private String study_Identifier = null;						


	//Nice title of the paper[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="Title", length=16777216)
	
				

	private String title =  null;


	//Shorthand name for layout[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="ShortName", length=16777216)
	
				

	private String shortName =  null;


	//Abstract[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="StudyAbstract", length=16777216, nullable=false)
	
				

	@javax.validation.constraints.NotNull
	private String studyAbstract =  null;


	//Accession version[type=string]
	@javax.persistence.Column(name="Version")
	@javax.xml.bind.annotation.XmlElement(name="version")
	
				

	private String version =  null;


	//Short piece of information describing why the study is taking place, e.g. risk factors for a population[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="Background", length=16777216)
	
				

	private String background =  null;


	//What this study aims to achieve[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="Objectives", length=16777216)
	
				

	private String objectives =  null;


	//Noticable results from this study[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="KeyResults", length=16777216)
	
				

	private String keyResults =  null;


	//Description of the conclusions drawn[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="Conclusions", length=16777216)
	
				

	private String conclusions =  null;


	//Study design[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="StudyDesign", length=16777216)
	
				

	private String studyDesign =  null;


	//Reason for study size[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="StudySizeReason", length=16777216)
	
				

	private String studySizeReason =  null;


	//Study power[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="StudyPower", length=16777216)
	
				

	private String studyPower =  null;


	//Sources of bias[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="SourcesOfBias", length=16777216)
	
				

	private String sourcesOfBias =  null;


	//Limitations[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="Limitations", length=16777216)
	
				

	private String limitations =  null;


	//Acknowledgements[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="Acknowledgements", length=16777216)
	
				

	private String acknowledgements =  null;


	//primaryCitation[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="primaryCitation")   	
	
				

	private org.molgenis.organization.Citation primaryCitation = null;
	@javax.persistence.Transient
	private Integer primaryCitation_id = null;	
	@javax.persistence.Transient
	private String primaryCitation_Identifier = null;						


	//Contact persons for this study[type=mref]
    @javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="otherCitations", insertable=true, updatable=true, nullable=true)
	@javax.persistence.JoinTable(name="StudyDetails_otherCitations", 
			joinColumns=@javax.persistence.JoinColumn(name="StudyDetails"), inverseJoinColumns=@javax.persistence.JoinColumn(name="otherCitations"))
	
				

	private java.util.List<org.molgenis.organization.Citation> otherCitations = new java.util.ArrayList<org.molgenis.organization.Citation>();
	@javax.persistence.Transient
	private java.util.List<Integer> otherCitations_id = new java.util.ArrayList<Integer>();		
	@javax.persistence.Transient
	private java.util.List<String> otherCitations_Identifier = new java.util.ArrayList<String>();


	//(Optional) URI or accession number to indicate source of Study. E.g. arrayexpress:M-EXP-2345[type=hyperlink]
	@javax.persistence.Column(name="Accession")
	@javax.xml.bind.annotation.XmlElement(name="accession")
	
				

	private String accession =  null;

	//constructors
	public StudyDetails()
	{
	
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
	 * Get the Study.
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
	 * Set the Study.
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
	 * Get the Nice title of the paper.
	 * @return title.
	 */
	public String getTitle()
	{
		return this.title;
	}
	
	@Deprecated
	public String getTitle(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Nice title of the paper.
	 * @param title
	 */
	public void setTitle( String title)
	{
		
		this.title = title;
	}

	

	/**
	 * Get the Shorthand name for layout.
	 * @return shortName.
	 */
	public String getShortName()
	{
		return this.shortName;
	}
	
	@Deprecated
	public String getShortName(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Shorthand name for layout.
	 * @param shortName
	 */
	public void setShortName( String shortName)
	{
		
		this.shortName = shortName;
	}

	

	/**
	 * Get the Abstract.
	 * @return studyAbstract.
	 */
	public String getStudyAbstract()
	{
		return this.studyAbstract;
	}
	
	@Deprecated
	public String getStudyAbstract(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Abstract.
	 * @param studyAbstract
	 */
	public void setStudyAbstract( String studyAbstract)
	{
		
		this.studyAbstract = studyAbstract;
	}

	

	/**
	 * Get the Accession version.
	 * @return version.
	 */
	public String getVersion()
	{
		return this.version;
	}
	
	@Deprecated
	public String getVersion(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Accession version.
	 * @param version
	 */
	public void setVersion( String version)
	{
		
		this.version = version;
	}

	

	/**
	 * Get the Short piece of information describing why the study is taking place, e.g. risk factors for a population.
	 * @return background.
	 */
	public String getBackground()
	{
		return this.background;
	}
	
	@Deprecated
	public String getBackground(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Short piece of information describing why the study is taking place, e.g. risk factors for a population.
	 * @param background
	 */
	public void setBackground( String background)
	{
		
		this.background = background;
	}

	

	/**
	 * Get the What this study aims to achieve.
	 * @return objectives.
	 */
	public String getObjectives()
	{
		return this.objectives;
	}
	
	@Deprecated
	public String getObjectives(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the What this study aims to achieve.
	 * @param objectives
	 */
	public void setObjectives( String objectives)
	{
		
		this.objectives = objectives;
	}

	

	/**
	 * Get the Noticable results from this study.
	 * @return keyResults.
	 */
	public String getKeyResults()
	{
		return this.keyResults;
	}
	
	@Deprecated
	public String getKeyResults(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Noticable results from this study.
	 * @param keyResults
	 */
	public void setKeyResults( String keyResults)
	{
		
		this.keyResults = keyResults;
	}

	

	/**
	 * Get the Description of the conclusions drawn.
	 * @return conclusions.
	 */
	public String getConclusions()
	{
		return this.conclusions;
	}
	
	@Deprecated
	public String getConclusions(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Description of the conclusions drawn.
	 * @param conclusions
	 */
	public void setConclusions( String conclusions)
	{
		
		this.conclusions = conclusions;
	}

	

	/**
	 * Get the Study design.
	 * @return studyDesign.
	 */
	public String getStudyDesign()
	{
		return this.studyDesign;
	}
	
	@Deprecated
	public String getStudyDesign(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Study design.
	 * @param studyDesign
	 */
	public void setStudyDesign( String studyDesign)
	{
		
		this.studyDesign = studyDesign;
	}

	

	/**
	 * Get the Reason for study size.
	 * @return studySizeReason.
	 */
	public String getStudySizeReason()
	{
		return this.studySizeReason;
	}
	
	@Deprecated
	public String getStudySizeReason(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Reason for study size.
	 * @param studySizeReason
	 */
	public void setStudySizeReason( String studySizeReason)
	{
		
		this.studySizeReason = studySizeReason;
	}

	

	/**
	 * Get the Study power.
	 * @return studyPower.
	 */
	public String getStudyPower()
	{
		return this.studyPower;
	}
	
	@Deprecated
	public String getStudyPower(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Study power.
	 * @param studyPower
	 */
	public void setStudyPower( String studyPower)
	{
		
		this.studyPower = studyPower;
	}

	

	/**
	 * Get the Sources of bias.
	 * @return sourcesOfBias.
	 */
	public String getSourcesOfBias()
	{
		return this.sourcesOfBias;
	}
	
	@Deprecated
	public String getSourcesOfBias(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Sources of bias.
	 * @param sourcesOfBias
	 */
	public void setSourcesOfBias( String sourcesOfBias)
	{
		
		this.sourcesOfBias = sourcesOfBias;
	}

	

	/**
	 * Get the Limitations.
	 * @return limitations.
	 */
	public String getLimitations()
	{
		return this.limitations;
	}
	
	@Deprecated
	public String getLimitations(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Limitations.
	 * @param limitations
	 */
	public void setLimitations( String limitations)
	{
		
		this.limitations = limitations;
	}

	

	/**
	 * Get the Acknowledgements.
	 * @return acknowledgements.
	 */
	public String getAcknowledgements()
	{
		return this.acknowledgements;
	}
	
	@Deprecated
	public String getAcknowledgements(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Acknowledgements.
	 * @param acknowledgements
	 */
	public void setAcknowledgements( String acknowledgements)
	{
		
		this.acknowledgements = acknowledgements;
	}

	

	/**
	 * Get the primaryCitation.
	 * @return primaryCitation.
	 */
	public org.molgenis.organization.Citation getPrimaryCitation()
	{
		return this.primaryCitation;
	}
	
	@Deprecated
	public org.molgenis.organization.Citation getPrimaryCitation(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the primaryCitation.
	 * @param primaryCitation
	 */
	public void setPrimaryCitation( org.molgenis.organization.Citation primaryCitation)
	{
		
		this.primaryCitation = primaryCitation;
	}

	
	
	/**
	 * Set foreign key for field primaryCitation.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setPrimaryCitation_Id(Integer primaryCitation_id)
	{
		this.primaryCitation_id = primaryCitation_id;
	}	

	public void setPrimaryCitation(Integer primaryCitation_id)
	{
		this.primaryCitation_id = primaryCitation_id;
	}
	
	public Integer getPrimaryCitation_Id()
	{
		
		if(primaryCitation != null) 
		{
			return primaryCitation.getId();
		}
		else
		{
			return primaryCitation_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference PrimaryCitation to Citation.Id.
	 */
	public String getPrimaryCitation_Identifier()
	{		
		//FIXME should we auto-load based on getPrimaryCitation()?	
		if(primaryCitation != null) {
			return primaryCitation.getIdentifier();
		} else {
			return primaryCitation_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference PrimaryCitation to <a href="Citation.html#Id">Citation.Id</a>.
	 * Implies setPrimaryCitation(null) until save
	 */
	public void setPrimaryCitation_Identifier(String primaryCitation_Identifier)
	{
		this.primaryCitation_Identifier = primaryCitation_Identifier;
	}		
	 
	

	/**
	 * Get the Contact persons for this study.
	 * @return otherCitations.
	 */
	public java.util.List<org.molgenis.organization.Citation> getOtherCitations()
	{
		return this.otherCitations;
	}
	
	@Deprecated
	public java.util.List<org.molgenis.organization.Citation> getOtherCitations(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Contact persons for this study.
	 * @param otherCitations
	 */
	public void setOtherCitations( java.util.List<org.molgenis.organization.Citation> otherCitations)
	{
		
		this.otherCitations = otherCitations;
	}

	
	public void setOtherCitations_Id(Integer ... otherCitations)
	{
		this.setOtherCitations_Id(java.util.Arrays.asList(otherCitations));
	}	
	
	public void setOtherCitations(org.molgenis.organization.Citation ... otherCitations)
	{
		this.setOtherCitations(java.util.Arrays.asList(otherCitations));
	}	
	
	/**
	 * Set foreign key for field otherCitations.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setOtherCitations_Id(java.util.List<Integer> otherCitations_id)
	{
		this.otherCitations_id = otherCitations_id;
	}	
	
	public java.util.List<Integer> getOtherCitations_Id()
	{
		return otherCitations_id;
	}	
	
	/**
	 * Get a pretty label for cross reference OtherCitations to <a href="Citation.html#Id">Citation.Id</a>.
	 */
	public java.util.List<String> getOtherCitations_Identifier()
	{
		return otherCitations_Identifier;
	}
	
	/**
	 * Update the foreign key OtherCitations
	 * This sets otherCitations to null until next database transaction.
	 */
	public void setOtherCitations_Identifier(java.util.List<String> otherCitations_Identifier)
	{
		this.otherCitations_Identifier = otherCitations_Identifier;
	}		
	

	/**
	 * Get the (Optional) URI or accession number to indicate source of Study. E.g. arrayexpress:M-EXP-2345.
	 * @return accession.
	 */
	public String getAccession()
	{
		return this.accession;
	}
	
	@Deprecated
	public String getAccession(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the (Optional) URI or accession number to indicate source of Study. E.g. arrayexpress:M-EXP-2345.
	 * @param accession
	 */
	public void setAccession( String accession)
	{
		
		this.accession = accession;
	}

	


	/**
	 * Generic getter. Get the property by using the name.
	 */
	public Object get(String name)
	{
		name = name.toLowerCase();
		if (name.toLowerCase().equals("id"))
			return getId();
		if (name.toLowerCase().equals("study"))
			return getStudy();
		if(name.toLowerCase().equals("study_id"))
			return getStudy_Id();
		if(name.toLowerCase().equals("study_identifier"))
			return getStudy_Identifier();
		if (name.toLowerCase().equals("title"))
			return getTitle();
		if (name.toLowerCase().equals("shortname"))
			return getShortName();
		if (name.toLowerCase().equals("studyabstract"))
			return getStudyAbstract();
		if (name.toLowerCase().equals("version"))
			return getVersion();
		if (name.toLowerCase().equals("background"))
			return getBackground();
		if (name.toLowerCase().equals("objectives"))
			return getObjectives();
		if (name.toLowerCase().equals("keyresults"))
			return getKeyResults();
		if (name.toLowerCase().equals("conclusions"))
			return getConclusions();
		if (name.toLowerCase().equals("studydesign"))
			return getStudyDesign();
		if (name.toLowerCase().equals("studysizereason"))
			return getStudySizeReason();
		if (name.toLowerCase().equals("studypower"))
			return getStudyPower();
		if (name.toLowerCase().equals("sourcesofbias"))
			return getSourcesOfBias();
		if (name.toLowerCase().equals("limitations"))
			return getLimitations();
		if (name.toLowerCase().equals("acknowledgements"))
			return getAcknowledgements();
		if (name.toLowerCase().equals("primarycitation"))
			return getPrimaryCitation();
		if(name.toLowerCase().equals("primarycitation_id"))
			return getPrimaryCitation_Id();
		if(name.toLowerCase().equals("primarycitation_identifier"))
			return getPrimaryCitation_Identifier();
		if (name.toLowerCase().equals("othercitations"))
			return getOtherCitations();
		if(name.toLowerCase().equals("othercitations_id"))
			return getOtherCitations_Id();
		if(name.toLowerCase().equals("othercitations_identifier"))
			return getOtherCitations_Identifier();
		if (name.toLowerCase().equals("accession"))
			return getAccession();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getStudy() == null) throw new org.molgenis.framework.db.DatabaseException("required field study is null");
		if(this.getStudyAbstract() == null) throw new org.molgenis.framework.db.DatabaseException("required field studyAbstract is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.util.Tuple tuple, boolean strict )  throws Exception
	{
		//optimization :-(
		if(tuple instanceof org.molgenis.util.ResultSetTuple)
		{
				//set Id
			this.setId(tuple.getInt("id"));
			//set Study
			this.setStudy(tuple.getInt("Study"));
			//set label Identifier for xref field Study
			this.setStudy_Identifier(tuple.getString("Study_Identifier"));	
			//set Title
			this.setTitle(tuple.getString("Title"));
			//set ShortName
			this.setShortName(tuple.getString("ShortName"));
			//set StudyAbstract
			this.setStudyAbstract(tuple.getString("StudyAbstract"));
			//set Version
			this.setVersion(tuple.getString("Version"));
			//set Background
			this.setBackground(tuple.getString("Background"));
			//set Objectives
			this.setObjectives(tuple.getString("Objectives"));
			//set KeyResults
			this.setKeyResults(tuple.getString("KeyResults"));
			//set Conclusions
			this.setConclusions(tuple.getString("Conclusions"));
			//set StudyDesign
			this.setStudyDesign(tuple.getString("StudyDesign"));
			//set StudySizeReason
			this.setStudySizeReason(tuple.getString("StudySizeReason"));
			//set StudyPower
			this.setStudyPower(tuple.getString("StudyPower"));
			//set SourcesOfBias
			this.setSourcesOfBias(tuple.getString("SourcesOfBias"));
			//set Limitations
			this.setLimitations(tuple.getString("Limitations"));
			//set Acknowledgements
			this.setAcknowledgements(tuple.getString("Acknowledgements"));
			//set PrimaryCitation
			this.setPrimaryCitation(tuple.getInt("primaryCitation"));
			//set label Identifier for xref field PrimaryCitation
			this.setPrimaryCitation_Identifier(tuple.getString("primaryCitation_Identifier"));	
			//mrefs can not be directly retrieved
			//set OtherCitations			
			//set Accession
			this.setAccession(tuple.getString("Accession"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("StudyDetails_id") != null) this.setId(tuple.getInt("StudyDetails_id"));
			//set Study
			if( strict || tuple.getInt("Study_id") != null) this.setStudy(tuple.getInt("Study_id"));
			if( tuple.getInt("StudyDetails_Study_id") != null) this.setStudy(tuple.getInt("StudyDetails_Study_id"));
			//alias of xref
			if( tuple.getObject("Study") != null) this.setStudy(tuple.getInt("Study"));
			if( tuple.getObject("StudyDetails_Study") != null) this.setStudy(tuple.getInt("StudyDetails_Study"));
			//set label for field Study
			if( strict || tuple.getObject("Study_Identifier") != null) this.setStudy_Identifier(tuple.getString("Study_Identifier"));			
			if( tuple.getObject("StudyDetails_Study_Identifier") != null ) this.setStudy_Identifier(tuple.getString("StudyDetails_Study_Identifier"));		
			//set Title
			if( strict || tuple.getString("Title") != null) this.setTitle(tuple.getString("Title"));
			if( tuple.getString("StudyDetails_Title") != null) this.setTitle(tuple.getString("StudyDetails_Title"));
			//set ShortName
			if( strict || tuple.getString("ShortName") != null) this.setShortName(tuple.getString("ShortName"));
			if( tuple.getString("StudyDetails_ShortName") != null) this.setShortName(tuple.getString("StudyDetails_ShortName"));
			//set StudyAbstract
			if( strict || tuple.getString("StudyAbstract") != null) this.setStudyAbstract(tuple.getString("StudyAbstract"));
			if( tuple.getString("StudyDetails_StudyAbstract") != null) this.setStudyAbstract(tuple.getString("StudyDetails_StudyAbstract"));
			//set Version
			if( strict || tuple.getString("Version") != null) this.setVersion(tuple.getString("Version"));
			if( tuple.getString("StudyDetails_Version") != null) this.setVersion(tuple.getString("StudyDetails_Version"));
			//set Background
			if( strict || tuple.getString("Background") != null) this.setBackground(tuple.getString("Background"));
			if( tuple.getString("StudyDetails_Background") != null) this.setBackground(tuple.getString("StudyDetails_Background"));
			//set Objectives
			if( strict || tuple.getString("Objectives") != null) this.setObjectives(tuple.getString("Objectives"));
			if( tuple.getString("StudyDetails_Objectives") != null) this.setObjectives(tuple.getString("StudyDetails_Objectives"));
			//set KeyResults
			if( strict || tuple.getString("KeyResults") != null) this.setKeyResults(tuple.getString("KeyResults"));
			if( tuple.getString("StudyDetails_KeyResults") != null) this.setKeyResults(tuple.getString("StudyDetails_KeyResults"));
			//set Conclusions
			if( strict || tuple.getString("Conclusions") != null) this.setConclusions(tuple.getString("Conclusions"));
			if( tuple.getString("StudyDetails_Conclusions") != null) this.setConclusions(tuple.getString("StudyDetails_Conclusions"));
			//set StudyDesign
			if( strict || tuple.getString("StudyDesign") != null) this.setStudyDesign(tuple.getString("StudyDesign"));
			if( tuple.getString("StudyDetails_StudyDesign") != null) this.setStudyDesign(tuple.getString("StudyDetails_StudyDesign"));
			//set StudySizeReason
			if( strict || tuple.getString("StudySizeReason") != null) this.setStudySizeReason(tuple.getString("StudySizeReason"));
			if( tuple.getString("StudyDetails_StudySizeReason") != null) this.setStudySizeReason(tuple.getString("StudyDetails_StudySizeReason"));
			//set StudyPower
			if( strict || tuple.getString("StudyPower") != null) this.setStudyPower(tuple.getString("StudyPower"));
			if( tuple.getString("StudyDetails_StudyPower") != null) this.setStudyPower(tuple.getString("StudyDetails_StudyPower"));
			//set SourcesOfBias
			if( strict || tuple.getString("SourcesOfBias") != null) this.setSourcesOfBias(tuple.getString("SourcesOfBias"));
			if( tuple.getString("StudyDetails_SourcesOfBias") != null) this.setSourcesOfBias(tuple.getString("StudyDetails_SourcesOfBias"));
			//set Limitations
			if( strict || tuple.getString("Limitations") != null) this.setLimitations(tuple.getString("Limitations"));
			if( tuple.getString("StudyDetails_Limitations") != null) this.setLimitations(tuple.getString("StudyDetails_Limitations"));
			//set Acknowledgements
			if( strict || tuple.getString("Acknowledgements") != null) this.setAcknowledgements(tuple.getString("Acknowledgements"));
			if( tuple.getString("StudyDetails_Acknowledgements") != null) this.setAcknowledgements(tuple.getString("StudyDetails_Acknowledgements"));
			//set PrimaryCitation
			if( strict || tuple.getInt("primaryCitation_id") != null) this.setPrimaryCitation(tuple.getInt("primaryCitation_id"));
			if( tuple.getInt("StudyDetails_primaryCitation_id") != null) this.setPrimaryCitation(tuple.getInt("StudyDetails_primaryCitation_id"));
			//alias of xref
			if( tuple.getObject("primaryCitation") != null) this.setPrimaryCitation(tuple.getInt("primaryCitation"));
			if( tuple.getObject("StudyDetails_primaryCitation") != null) this.setPrimaryCitation(tuple.getInt("StudyDetails_primaryCitation"));
			//set label for field PrimaryCitation
			if( strict || tuple.getObject("primaryCitation_Identifier") != null) this.setPrimaryCitation_Identifier(tuple.getString("primaryCitation_Identifier"));			
			if( tuple.getObject("StudyDetails_primaryCitation_Identifier") != null ) this.setPrimaryCitation_Identifier(tuple.getString("StudyDetails_primaryCitation_Identifier"));		
			//set OtherCitations
			if( tuple.getObject("otherCitations")!= null || tuple.getObject("StudyDetails_otherCitations")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("otherCitations");
				if(tuple.getObject("StudyDetails_otherCitations")!= null) mrefs = tuple.getList("StudyDetails_otherCitations");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setOtherCitations_Id( values );
			}
			//set labels Identifier for mref field OtherCitations	
			if( tuple.getObject("otherCitations_Identifier")!= null || tuple.getObject("StudyDetails_otherCitations_Identifier")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("otherCitations_Identifier");
				if(tuple.getObject("StudyDetails_otherCitations_Identifier")!= null) mrefs = tuple.getList("StudyDetails_otherCitations_Identifier");
				
				if(mrefs != null) 
					for(Object ref: mrefs)
					{
						String[] refs = ref.toString().split("\\|");
						for(String r : refs) {
							values.add(r);	
						}						
					}							
				this.setOtherCitations_Identifier( values );			
			}	
			//set Accession
			if( strict || tuple.getString("Accession") != null) this.setAccession(tuple.getString("Accession"));
			if( tuple.getString("StudyDetails_Accession") != null) this.setAccession(tuple.getString("StudyDetails_Accession"));
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
		String result = "StudyDetails(";
		result+= "id='" + getId()+"' ";	
		result+= " study_id='" + getStudy_Id()+"' ";	
		result+= " study_identifier='" + getStudy_Identifier()+"' ";
		result+= "title='" + getTitle()+"' ";	
		result+= "shortName='" + getShortName()+"' ";	
		result+= "studyAbstract='" + getStudyAbstract()+"' ";	
		result+= "version='" + getVersion()+"' ";	
		result+= "background='" + getBackground()+"' ";	
		result+= "objectives='" + getObjectives()+"' ";	
		result+= "keyResults='" + getKeyResults()+"' ";	
		result+= "conclusions='" + getConclusions()+"' ";	
		result+= "studyDesign='" + getStudyDesign()+"' ";	
		result+= "studySizeReason='" + getStudySizeReason()+"' ";	
		result+= "studyPower='" + getStudyPower()+"' ";	
		result+= "sourcesOfBias='" + getSourcesOfBias()+"' ";	
		result+= "limitations='" + getLimitations()+"' ";	
		result+= "acknowledgements='" + getAcknowledgements()+"' ";	
		result+= " primaryCitation_id='" + getPrimaryCitation_Id()+"' ";	
		result+= " primaryCitation_identifier='" + getPrimaryCitation_Identifier()+"' ";
		result+= " otherCitations_id='" + getOtherCitations_Id()+"' ";	
		result+= " otherCitations_identifier='" + getOtherCitations_Identifier()+"' ";
		result+= "accession='" + getAccession()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of StudyDetails.
	 */
	public java.util.Vector<String> getFields(boolean skipAutoIds)
	{
		java.util.Vector<String> fields = new java.util.Vector<String>();
		if(!skipAutoIds)
		{
			fields.add("id");
		}
		{
			fields.add("study_id");
		}
		fields.add("study_identifier");
		{
			fields.add("title");
		}
		{
			fields.add("shortName");
		}
		{
			fields.add("studyAbstract");
		}
		{
			fields.add("version");
		}
		{
			fields.add("background");
		}
		{
			fields.add("objectives");
		}
		{
			fields.add("keyResults");
		}
		{
			fields.add("conclusions");
		}
		{
			fields.add("studyDesign");
		}
		{
			fields.add("studySizeReason");
		}
		{
			fields.add("studyPower");
		}
		{
			fields.add("sourcesOfBias");
		}
		{
			fields.add("limitations");
		}
		{
			fields.add("acknowledgements");
		}
		{
			fields.add("primaryCitation_id");
		}
		fields.add("primaryCitation_identifier");
		{
			fields.add("otherCitations_id");
		}
		fields.add("otherCitations_identifier");
		{
			fields.add("accession");
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
		result.add("id");
		return result;
	}

	@Deprecated
	public String getFields(String sep)
	{
		return (""
		+ "id" +sep
		+ "study" +sep
		+ "title" +sep
		+ "shortName" +sep
		+ "studyAbstract" +sep
		+ "version" +sep
		+ "background" +sep
		+ "objectives" +sep
		+ "keyResults" +sep
		+ "conclusions" +sep
		+ "studyDesign" +sep
		+ "studySizeReason" +sep
		+ "studyPower" +sep
		+ "sourcesOfBias" +sep
		+ "limitations" +sep
		+ "acknowledgements" +sep
		+ "primaryCitation" +sep
		+ "otherCitations" +sep
		+ "accession" 
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
        if (fieldName.equalsIgnoreCase("primaryCitation")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("otherCitations")) {
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
		StudyDetails rhs = (StudyDetails) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
		//study
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
			Object valueO = getTitle();
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
			Object valueO = getShortName();
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
			Object valueO = getStudyAbstract();
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
			Object valueO = getVersion();
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
			Object valueO = getBackground();
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
			Object valueO = getObjectives();
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
			Object valueO = getKeyResults();
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
			Object valueO = getConclusions();
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
			Object valueO = getStudyDesign();
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
			Object valueO = getStudySizeReason();
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
			Object valueO = getStudyPower();
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
			Object valueO = getSourcesOfBias();
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
			Object valueO = getLimitations();
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
			Object valueO = getAcknowledgements();
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
			Object valueO = getPrimaryCitation();
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
			Object valueO = getOtherCitations();
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
			Object valueO = getAccession();
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
	public StudyDetails create(org.molgenis.util.Tuple tuple) throws Exception
	{
		StudyDetails e = new StudyDetails();
		e.set(tuple);
		return e;
	}
	

	
}

