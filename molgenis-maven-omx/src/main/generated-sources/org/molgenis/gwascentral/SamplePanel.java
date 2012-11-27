
/* File:        org.molgenis/model/SamplePanel.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.gwascentral;

/**
 * SamplePanel: .
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "SamplePanel", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "Identifier" } ) }
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.gwascentral.db.SamplePanelEntityListener.class})
public class SamplePanel extends org.molgenis.observ.target.Panel implements org.molgenis.core.Identifiable
{
	// fieldname constants
	public final static String ID = "id";
	public final static String IDENTIFIER = "Identifier";
	public final static String NAME = "Name";
	public final static String CENTRALIDENTIFIER = "CentralIdentifier";
	public final static String CENTRALIDENTIFIER_IDENTIFIER = "CentralIdentifier_Identifier";
	public final static String LABEL = "Label";
	public final static String ACCESSION = "Accession";
	public final static String ACCESSIONVERSION = "AccessionVersion";
	public final static String DESCRIPTION = "Description";
	public final static String COMPOSITION = "Composition";
	public final static String TOTALNUMBEROFINDIVIDUALS = "TotalNumberOfIndividuals";
	public final static String NUMBEROFSEXMALE = "NumberOfSexMale";
	public final static String NUMBEROFSEXFEMALE = "NumberOfSexFemale";
	public final static String NUMBEROFSEXUNKNOWN = "NumberOfSexUnknown";
	public final static String NUMBEROFPROBANDS = "NumberOfProbands";
	public final static String NUMBEROFPARENTS = "NumberOfParents";
	public final static String MODEOFRECRUITMENT = "ModeOfRecruitment";
	public final static String DIAGNOSISAGERANGE = "DiagnosisAgeRange";
	public final static String DIAGNOSISPERIOD = "DiagnosisPeriod";
	public final static String SAMPLINGAGERANGE = "SamplingAgeRange";
	public final static String SAMPLINGPERIOD = "SamplingPeriod";
	public final static String POPULATIONINFO = "PopulationInfo";
	public final static String GEOGRAPHICREGIONINFO = "GeographicRegionInfo";
	public final static String ETHNICITYINFO = "EthnicityInfo";
	public final static String BIRTHPLACEINFO = "BirthPlaceInfo";
	public final static String ADMIXTUREINFO = "AdmixtureInfo";
	public final static String ENVIRONMENTINFO = "EnvironmentInfo";
	public final static String SOURCEOFDNA = "SourceOfDNA";
	public final static String DNASAREPOOLED = "DNAsArePooled";
	public final static String DNASAREWGA = "DNAsAreWGA";
	
	//static methods
	/**
	 * Shorthand for db.query(SamplePanel.class).
	 */
	public static org.molgenis.framework.db.Query<? extends SamplePanel> query(org.molgenis.framework.db.Database db)
	{
		return db.query(SamplePanel.class);
	}
	
	/**
	 * Shorthand for db.find(SamplePanel.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends SamplePanel> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(SamplePanel.class, rules);
	}	
	
	/**
	 * 
	 */
	public static SamplePanel findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<SamplePanel> q = db.query(SamplePanel.class);
		q.eq(SamplePanel.ID, id);
		java.util.List<SamplePanel> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static SamplePanel findByIdentifier(org.molgenis.framework.db.Database db, String identifier) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<SamplePanel> q = db.query(SamplePanel.class);
		q.eq(SamplePanel.IDENTIFIER, identifier);
		java.util.List<SamplePanel> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//automatically generated internal id, only for internal use.[type=int]
	


	//user supplied or automatically assigned (using a decorator) unique and short identifier, e.g. MA1234[type=string]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="Identifier", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="identifier")
	
				

	@javax.validation.constraints.NotNull
	private String identifier =  null;


	//Name[type=string]
	@javax.persistence.Column(name="Name")
	@javax.xml.bind.annotation.XmlElement(name="name")
	
				

	private String name =  null;


	//The central GWAS identifier for this panel[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="CentralIdentifier")   	
	
				

	private org.molgenis.observ.target.OntologyTerm centralIdentifier = null;
	@javax.persistence.Transient
	private Integer centralIdentifier_id = null;	
	@javax.persistence.Transient
	private String centralIdentifier_Identifier = null;						


	//Label[type=string]
	@javax.persistence.Column(name="Label")
	@javax.xml.bind.annotation.XmlElement(name="label")
	
				

	private String label =  null;


	//Accession[type=string]
	@javax.persistence.Column(name="Accession")
	@javax.xml.bind.annotation.XmlElement(name="accession")
	
				

	private String accession =  null;


	//Accession version[type=string]
	@javax.persistence.Column(name="AccessionVersion")
	@javax.xml.bind.annotation.XmlElement(name="accessionVersion")
	
				

	private String accessionVersion =  null;


	//Description[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="Description", length=16777216)
	
				

	private String description =  null;


	//Composition[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="Composition", length=16777216)
	
				

	private String composition =  null;


	//*...but required for association datasets[type=int]
	@javax.persistence.Column(name="TotalNumberOfIndividuals")
	@javax.xml.bind.annotation.XmlElement(name="totalNumberOfIndividuals")
	
				

	private Integer totalNumberOfIndividuals =  null;


	//Number of males[type=int]
	@javax.persistence.Column(name="NumberOfSexMale")
	@javax.xml.bind.annotation.XmlElement(name="numberOfSexMale")
	
				

	private Integer numberOfSexMale =  null;


	//Number of females[type=int]
	@javax.persistence.Column(name="NumberOfSexFemale")
	@javax.xml.bind.annotation.XmlElement(name="numberOfSexFemale")
	
				

	private Integer numberOfSexFemale =  null;


	//Number of unknown sex[type=int]
	@javax.persistence.Column(name="NumberOfSexUnknown")
	@javax.xml.bind.annotation.XmlElement(name="numberOfSexUnknown")
	
				

	private Integer numberOfSexUnknown =  null;


	//field used only if Composition = 'Trios'[type=int]
	@javax.persistence.Column(name="NumberOfProbands")
	@javax.xml.bind.annotation.XmlElement(name="numberOfProbands")
	
				

	private Integer numberOfProbands =  null;


	//field used only if Composition = 'Trios'[type=int]
	@javax.persistence.Column(name="NumberOfParents")
	@javax.xml.bind.annotation.XmlElement(name="numberOfParents")
	
				

	private Integer numberOfParents =  null;


	//Mode of recruitment[type=string]
	@javax.persistence.Column(name="ModeOfRecruitment")
	@javax.xml.bind.annotation.XmlElement(name="modeOfRecruitment")
	
				

	private String modeOfRecruitment =  null;


	//Diagnosis age range[type=string]
	@javax.persistence.Column(name="DiagnosisAgeRange")
	@javax.xml.bind.annotation.XmlElement(name="diagnosisAgeRange")
	
				

	private String diagnosisAgeRange =  null;


	//Diagnosis period[type=string]
	@javax.persistence.Column(name="DiagnosisPeriod")
	@javax.xml.bind.annotation.XmlElement(name="diagnosisPeriod")
	
				

	private String diagnosisPeriod =  null;


	//Sampling age range[type=string]
	@javax.persistence.Column(name="SamplingAgeRange")
	@javax.xml.bind.annotation.XmlElement(name="samplingAgeRange")
	
				

	private String samplingAgeRange =  null;


	//Sampling period[type=string]
	@javax.persistence.Column(name="SamplingPeriod")
	@javax.xml.bind.annotation.XmlElement(name="samplingPeriod")
	
				

	private String samplingPeriod =  null;


	//Population information[type=string]
	@javax.persistence.Column(name="PopulationInfo")
	@javax.xml.bind.annotation.XmlElement(name="populationInfo")
	
				

	private String populationInfo =  null;


	//Geographic region information[type=string]
	@javax.persistence.Column(name="GeographicRegionInfo")
	@javax.xml.bind.annotation.XmlElement(name="geographicRegionInfo")
	
				

	private String geographicRegionInfo =  null;


	//Ethnicity information[type=string]
	@javax.persistence.Column(name="EthnicityInfo")
	@javax.xml.bind.annotation.XmlElement(name="ethnicityInfo")
	
				

	private String ethnicityInfo =  null;


	//Birth place information[type=string]
	@javax.persistence.Column(name="BirthPlaceInfo")
	@javax.xml.bind.annotation.XmlElement(name="birthPlaceInfo")
	
				

	private String birthPlaceInfo =  null;


	//Admixture information[type=string]
	@javax.persistence.Column(name="AdmixtureInfo")
	@javax.xml.bind.annotation.XmlElement(name="admixtureInfo")
	
				

	private String admixtureInfo =  null;


	//Environment information[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="EnvironmentInfo", length=16777216)
	
				

	private String environmentInfo =  null;


	//In (SELECT [SourceOfDNA] FROM [Sampleset_SourceOfDNAList];)[type=string]
	@javax.persistence.Column(name="SourceOfDNA")
	@javax.xml.bind.annotation.XmlElement(name="sourceOfDNA")
	
				

	private String sourceOfDNA =  null;


	//Are DNAs pooled?[type=enum]
	@javax.persistence.Column(name="DNAsArePooled", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="dNAsArePooled")
	
				

	@javax.validation.constraints.NotNull
	private String dNAsArePooled =  "Undefined";
	@javax.persistence.Transient
	private String dNAsArePooled_label = null;
	@javax.persistence.Transient
	private java.util.List<org.molgenis.util.ValueLabel> dNAsArePooled_options = new java.util.ArrayList<org.molgenis.util.ValueLabel>();


	//Are DNAs WGA?[type=enum]
	@javax.persistence.Column(name="DNAsAreWGA", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="dNAsAreWGA")
	
				

	@javax.validation.constraints.NotNull
	private String dNAsAreWGA =  "Undefined";
	@javax.persistence.Transient
	private String dNAsAreWGA_label = null;
	@javax.persistence.Transient
	private java.util.List<org.molgenis.util.ValueLabel> dNAsAreWGA_options = new java.util.ArrayList<org.molgenis.util.ValueLabel>();

	//constructors
	public SamplePanel()
	{
		//set the type for a new instance
		set__Type(this.getClass().getSimpleName());
	
		//options for enum DNAsArePooled
		dNAsArePooled_options.add(new org.molgenis.util.ValueLabel("Undefined","Undefined"));
		dNAsArePooled_options.add(new org.molgenis.util.ValueLabel("Pre-prep","Pre-prep"));
		dNAsArePooled_options.add(new org.molgenis.util.ValueLabel("Post-prep","Post-prep"));
		dNAsArePooled_options.add(new org.molgenis.util.ValueLabel("No","No"));
		//options for enum DNAsAreWGA
		dNAsAreWGA_options.add(new org.molgenis.util.ValueLabel("Undefined","Undefined"));
		dNAsAreWGA_options.add(new org.molgenis.util.ValueLabel("None","None"));
		dNAsAreWGA_options.add(new org.molgenis.util.ValueLabel("All","All"));
		dNAsAreWGA_options.add(new org.molgenis.util.ValueLabel("Some","Some"));
	}
	
	//getters and setters
	

	

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
				//hack to solve problem with variable hidden in supertype
				super.setIdentifier(identifier);
				//2222hack to solve problem with variable hidden in supertype
				super.setIdentifier(identifier);
		
		this.identifier = identifier;
	}

	

	/**
	 * Get the Name.
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
	 * Set the Name.
	 * @param name
	 */
	public void setName( String name)
	{
				//hack to solve problem with variable hidden in supertype
				super.setName(name);
				//2222hack to solve problem with variable hidden in supertype
				super.setName(name);
		
		this.name = name;
	}

	

	/**
	 * Get the The central GWAS identifier for this panel.
	 * @return centralIdentifier.
	 */
	public org.molgenis.observ.target.OntologyTerm getCentralIdentifier()
	{
		return this.centralIdentifier;
	}
	
	@Deprecated
	public org.molgenis.observ.target.OntologyTerm getCentralIdentifier(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the The central GWAS identifier for this panel.
	 * @param centralIdentifier
	 */
	public void setCentralIdentifier( org.molgenis.observ.target.OntologyTerm centralIdentifier)
	{
		
		this.centralIdentifier = centralIdentifier;
	}

	
	
	/**
	 * Set foreign key for field centralIdentifier.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setCentralIdentifier_Id(Integer centralIdentifier_id)
	{
		this.centralIdentifier_id = centralIdentifier_id;
	}	

	public void setCentralIdentifier(Integer centralIdentifier_id)
	{
		this.centralIdentifier_id = centralIdentifier_id;
	}
	
	public Integer getCentralIdentifier_Id()
	{
		
		if(centralIdentifier != null) 
		{
			return centralIdentifier.getId();
		}
		else
		{
			return centralIdentifier_id;
		}
	}	
	 
	/**
	 * Get a pretty label Identifier for cross reference CentralIdentifier to OntologyTerm.Id.
	 */
	public String getCentralIdentifier_Identifier()
	{		
		//FIXME should we auto-load based on getCentralIdentifier()?	
		if(centralIdentifier != null) {
			return centralIdentifier.getIdentifier();
		} else {
			return centralIdentifier_Identifier;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference CentralIdentifier to <a href="OntologyTerm.html#Id">OntologyTerm.Id</a>.
	 * Implies setCentralIdentifier(null) until save
	 */
	public void setCentralIdentifier_Identifier(String centralIdentifier_Identifier)
	{
		this.centralIdentifier_Identifier = centralIdentifier_Identifier;
	}		
	 
	

	/**
	 * Get the Label.
	 * @return label.
	 */
	public String getLabel()
	{
		return this.label;
	}
	
	@Deprecated
	public String getLabel(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Label.
	 * @param label
	 */
	public void setLabel( String label)
	{
		
		this.label = label;
	}

	

	/**
	 * Get the Accession.
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
	 * Set the Accession.
	 * @param accession
	 */
	public void setAccession( String accession)
	{
		
		this.accession = accession;
	}

	

	/**
	 * Get the Accession version.
	 * @return accessionVersion.
	 */
	public String getAccessionVersion()
	{
		return this.accessionVersion;
	}
	
	@Deprecated
	public String getAccessionVersion(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Accession version.
	 * @param accessionVersion
	 */
	public void setAccessionVersion( String accessionVersion)
	{
		
		this.accessionVersion = accessionVersion;
	}

	

	/**
	 * Get the Description.
	 * @return description.
	 */
	public String getDescription()
	{
		return this.description;
	}
	
	@Deprecated
	public String getDescription(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Description.
	 * @param description
	 */
	public void setDescription( String description)
	{
				//2222hack to solve problem with variable hidden in supertype
				super.setDescription(description);
		
		this.description = description;
	}

	

	/**
	 * Get the Composition.
	 * @return composition.
	 */
	public String getComposition()
	{
		return this.composition;
	}
	
	@Deprecated
	public String getComposition(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Composition.
	 * @param composition
	 */
	public void setComposition( String composition)
	{
		
		this.composition = composition;
	}

	

	/**
	 * Get the *...but required for association datasets.
	 * @return totalNumberOfIndividuals.
	 */
	public Integer getTotalNumberOfIndividuals()
	{
		return this.totalNumberOfIndividuals;
	}
	
	@Deprecated
	public Integer getTotalNumberOfIndividuals(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the *...but required for association datasets.
	 * @param totalNumberOfIndividuals
	 */
	public void setTotalNumberOfIndividuals( Integer totalNumberOfIndividuals)
	{
		
		this.totalNumberOfIndividuals = totalNumberOfIndividuals;
	}

	

	/**
	 * Get the Number of males.
	 * @return numberOfSexMale.
	 */
	public Integer getNumberOfSexMale()
	{
		return this.numberOfSexMale;
	}
	
	@Deprecated
	public Integer getNumberOfSexMale(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Number of males.
	 * @param numberOfSexMale
	 */
	public void setNumberOfSexMale( Integer numberOfSexMale)
	{
		
		this.numberOfSexMale = numberOfSexMale;
	}

	

	/**
	 * Get the Number of females.
	 * @return numberOfSexFemale.
	 */
	public Integer getNumberOfSexFemale()
	{
		return this.numberOfSexFemale;
	}
	
	@Deprecated
	public Integer getNumberOfSexFemale(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Number of females.
	 * @param numberOfSexFemale
	 */
	public void setNumberOfSexFemale( Integer numberOfSexFemale)
	{
		
		this.numberOfSexFemale = numberOfSexFemale;
	}

	

	/**
	 * Get the Number of unknown sex.
	 * @return numberOfSexUnknown.
	 */
	public Integer getNumberOfSexUnknown()
	{
		return this.numberOfSexUnknown;
	}
	
	@Deprecated
	public Integer getNumberOfSexUnknown(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Number of unknown sex.
	 * @param numberOfSexUnknown
	 */
	public void setNumberOfSexUnknown( Integer numberOfSexUnknown)
	{
		
		this.numberOfSexUnknown = numberOfSexUnknown;
	}

	

	/**
	 * Get the field used only if Composition = 'Trios'.
	 * @return numberOfProbands.
	 */
	public Integer getNumberOfProbands()
	{
		return this.numberOfProbands;
	}
	
	@Deprecated
	public Integer getNumberOfProbands(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the field used only if Composition = 'Trios'.
	 * @param numberOfProbands
	 */
	public void setNumberOfProbands( Integer numberOfProbands)
	{
		
		this.numberOfProbands = numberOfProbands;
	}

	

	/**
	 * Get the field used only if Composition = 'Trios'.
	 * @return numberOfParents.
	 */
	public Integer getNumberOfParents()
	{
		return this.numberOfParents;
	}
	
	@Deprecated
	public Integer getNumberOfParents(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the field used only if Composition = 'Trios'.
	 * @param numberOfParents
	 */
	public void setNumberOfParents( Integer numberOfParents)
	{
		
		this.numberOfParents = numberOfParents;
	}

	

	/**
	 * Get the Mode of recruitment.
	 * @return modeOfRecruitment.
	 */
	public String getModeOfRecruitment()
	{
		return this.modeOfRecruitment;
	}
	
	@Deprecated
	public String getModeOfRecruitment(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Mode of recruitment.
	 * @param modeOfRecruitment
	 */
	public void setModeOfRecruitment( String modeOfRecruitment)
	{
		
		this.modeOfRecruitment = modeOfRecruitment;
	}

	

	/**
	 * Get the Diagnosis age range.
	 * @return diagnosisAgeRange.
	 */
	public String getDiagnosisAgeRange()
	{
		return this.diagnosisAgeRange;
	}
	
	@Deprecated
	public String getDiagnosisAgeRange(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Diagnosis age range.
	 * @param diagnosisAgeRange
	 */
	public void setDiagnosisAgeRange( String diagnosisAgeRange)
	{
		
		this.diagnosisAgeRange = diagnosisAgeRange;
	}

	

	/**
	 * Get the Diagnosis period.
	 * @return diagnosisPeriod.
	 */
	public String getDiagnosisPeriod()
	{
		return this.diagnosisPeriod;
	}
	
	@Deprecated
	public String getDiagnosisPeriod(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Diagnosis period.
	 * @param diagnosisPeriod
	 */
	public void setDiagnosisPeriod( String diagnosisPeriod)
	{
		
		this.diagnosisPeriod = diagnosisPeriod;
	}

	

	/**
	 * Get the Sampling age range.
	 * @return samplingAgeRange.
	 */
	public String getSamplingAgeRange()
	{
		return this.samplingAgeRange;
	}
	
	@Deprecated
	public String getSamplingAgeRange(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Sampling age range.
	 * @param samplingAgeRange
	 */
	public void setSamplingAgeRange( String samplingAgeRange)
	{
		
		this.samplingAgeRange = samplingAgeRange;
	}

	

	/**
	 * Get the Sampling period.
	 * @return samplingPeriod.
	 */
	public String getSamplingPeriod()
	{
		return this.samplingPeriod;
	}
	
	@Deprecated
	public String getSamplingPeriod(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Sampling period.
	 * @param samplingPeriod
	 */
	public void setSamplingPeriod( String samplingPeriod)
	{
		
		this.samplingPeriod = samplingPeriod;
	}

	

	/**
	 * Get the Population information.
	 * @return populationInfo.
	 */
	public String getPopulationInfo()
	{
		return this.populationInfo;
	}
	
	@Deprecated
	public String getPopulationInfo(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Population information.
	 * @param populationInfo
	 */
	public void setPopulationInfo( String populationInfo)
	{
		
		this.populationInfo = populationInfo;
	}

	

	/**
	 * Get the Geographic region information.
	 * @return geographicRegionInfo.
	 */
	public String getGeographicRegionInfo()
	{
		return this.geographicRegionInfo;
	}
	
	@Deprecated
	public String getGeographicRegionInfo(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Geographic region information.
	 * @param geographicRegionInfo
	 */
	public void setGeographicRegionInfo( String geographicRegionInfo)
	{
		
		this.geographicRegionInfo = geographicRegionInfo;
	}

	

	/**
	 * Get the Ethnicity information.
	 * @return ethnicityInfo.
	 */
	public String getEthnicityInfo()
	{
		return this.ethnicityInfo;
	}
	
	@Deprecated
	public String getEthnicityInfo(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Ethnicity information.
	 * @param ethnicityInfo
	 */
	public void setEthnicityInfo( String ethnicityInfo)
	{
		
		this.ethnicityInfo = ethnicityInfo;
	}

	

	/**
	 * Get the Birth place information.
	 * @return birthPlaceInfo.
	 */
	public String getBirthPlaceInfo()
	{
		return this.birthPlaceInfo;
	}
	
	@Deprecated
	public String getBirthPlaceInfo(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Birth place information.
	 * @param birthPlaceInfo
	 */
	public void setBirthPlaceInfo( String birthPlaceInfo)
	{
		
		this.birthPlaceInfo = birthPlaceInfo;
	}

	

	/**
	 * Get the Admixture information.
	 * @return admixtureInfo.
	 */
	public String getAdmixtureInfo()
	{
		return this.admixtureInfo;
	}
	
	@Deprecated
	public String getAdmixtureInfo(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Admixture information.
	 * @param admixtureInfo
	 */
	public void setAdmixtureInfo( String admixtureInfo)
	{
		
		this.admixtureInfo = admixtureInfo;
	}

	

	/**
	 * Get the Environment information.
	 * @return environmentInfo.
	 */
	public String getEnvironmentInfo()
	{
		return this.environmentInfo;
	}
	
	@Deprecated
	public String getEnvironmentInfo(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Environment information.
	 * @param environmentInfo
	 */
	public void setEnvironmentInfo( String environmentInfo)
	{
		
		this.environmentInfo = environmentInfo;
	}

	

	/**
	 * Get the In (SELECT [SourceOfDNA] FROM [Sampleset_SourceOfDNAList];).
	 * @return sourceOfDNA.
	 */
	public String getSourceOfDNA()
	{
		return this.sourceOfDNA;
	}
	
	@Deprecated
	public String getSourceOfDNA(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the In (SELECT [SourceOfDNA] FROM [Sampleset_SourceOfDNAList];).
	 * @param sourceOfDNA
	 */
	public void setSourceOfDNA( String sourceOfDNA)
	{
		
		this.sourceOfDNA = sourceOfDNA;
	}

	

	/**
	 * Get the Are DNAs pooled?.
	 * @return dNAsArePooled.
	 */
	public String getDNAsArePooled()
	{
		return this.dNAsArePooled;
	}
	
	@Deprecated
	public String getDNAsArePooled(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Are DNAs pooled?.
	 * @param dNAsArePooled
	 */
	public void setDNAsArePooled( String dNAsArePooled)
	{
		
		this.dNAsArePooled = dNAsArePooled;
	}

	
	/**
	 * Get tha label for enum DNAsArePooled.
	 */
	public String getDNAsArePooledLabel()
	{
		return this.dNAsArePooled_label;
	}
	
	/**
	 * DNAsArePooled is enum. This method returns all available enum options.
	 */
	public java.util.List<org.molgenis.util.ValueLabel> getDNAsArePooledOptions()
	{
		return dNAsArePooled_options;
	}	
	

	/**
	 * Get the Are DNAs WGA?.
	 * @return dNAsAreWGA.
	 */
	public String getDNAsAreWGA()
	{
		return this.dNAsAreWGA;
	}
	
	@Deprecated
	public String getDNAsAreWGA(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Are DNAs WGA?.
	 * @param dNAsAreWGA
	 */
	public void setDNAsAreWGA( String dNAsAreWGA)
	{
		
		this.dNAsAreWGA = dNAsAreWGA;
	}

	
	/**
	 * Get tha label for enum DNAsAreWGA.
	 */
	public String getDNAsAreWGALabel()
	{
		return this.dNAsAreWGA_label;
	}
	
	/**
	 * DNAsAreWGA is enum. This method returns all available enum options.
	 */
	public java.util.List<org.molgenis.util.ValueLabel> getDNAsAreWGAOptions()
	{
		return dNAsAreWGA_options;
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
		if (name.toLowerCase().equals("paneltype"))
			return getPanelType();
		if(name.toLowerCase().equals("paneltype_id"))
			return getPanelType_Id();
		if(name.toLowerCase().equals("paneltype_identifier"))
			return getPanelType_Identifier();
		if (name.toLowerCase().equals("numberofindividuals"))
			return getNumberOfIndividuals();
		if (name.toLowerCase().equals("species"))
			return getSpecies();
		if(name.toLowerCase().equals("species_id"))
			return getSpecies_Id();
		if(name.toLowerCase().equals("species_identifier"))
			return getSpecies_Identifier();
		if (name.toLowerCase().equals("individuals"))
			return getIndividuals();
		if(name.toLowerCase().equals("individuals_id"))
			return getIndividuals_Id();
		if(name.toLowerCase().equals("individuals_identifier"))
			return getIndividuals_Identifier();
		if (name.toLowerCase().equals("centralidentifier"))
			return getCentralIdentifier();
		if(name.toLowerCase().equals("centralidentifier_id"))
			return getCentralIdentifier_Id();
		if(name.toLowerCase().equals("centralidentifier_identifier"))
			return getCentralIdentifier_Identifier();
		if (name.toLowerCase().equals("label"))
			return getLabel();
		if (name.toLowerCase().equals("accession"))
			return getAccession();
		if (name.toLowerCase().equals("accessionversion"))
			return getAccessionVersion();
		if (name.toLowerCase().equals("composition"))
			return getComposition();
		if (name.toLowerCase().equals("totalnumberofindividuals"))
			return getTotalNumberOfIndividuals();
		if (name.toLowerCase().equals("numberofsexmale"))
			return getNumberOfSexMale();
		if (name.toLowerCase().equals("numberofsexfemale"))
			return getNumberOfSexFemale();
		if (name.toLowerCase().equals("numberofsexunknown"))
			return getNumberOfSexUnknown();
		if (name.toLowerCase().equals("numberofprobands"))
			return getNumberOfProbands();
		if (name.toLowerCase().equals("numberofparents"))
			return getNumberOfParents();
		if (name.toLowerCase().equals("modeofrecruitment"))
			return getModeOfRecruitment();
		if (name.toLowerCase().equals("diagnosisagerange"))
			return getDiagnosisAgeRange();
		if (name.toLowerCase().equals("diagnosisperiod"))
			return getDiagnosisPeriod();
		if (name.toLowerCase().equals("samplingagerange"))
			return getSamplingAgeRange();
		if (name.toLowerCase().equals("samplingperiod"))
			return getSamplingPeriod();
		if (name.toLowerCase().equals("populationinfo"))
			return getPopulationInfo();
		if (name.toLowerCase().equals("geographicregioninfo"))
			return getGeographicRegionInfo();
		if (name.toLowerCase().equals("ethnicityinfo"))
			return getEthnicityInfo();
		if (name.toLowerCase().equals("birthplaceinfo"))
			return getBirthPlaceInfo();
		if (name.toLowerCase().equals("admixtureinfo"))
			return getAdmixtureInfo();
		if (name.toLowerCase().equals("environmentinfo"))
			return getEnvironmentInfo();
		if (name.toLowerCase().equals("sourceofdna"))
			return getSourceOfDNA();
		if (name.toLowerCase().equals("dnasarepooled"))
			return getDNAsArePooled();
		if(name.toLowerCase().equals("dnasarepooled_label"))
			return getDNAsArePooledLabel();
		if (name.toLowerCase().equals("dnasarewga"))
			return getDNAsAreWGA();
		if(name.toLowerCase().equals("dnasarewga_label"))
			return getDNAsAreWGALabel();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getIdentifier() == null) throw new org.molgenis.framework.db.DatabaseException("required field identifier is null");
		if(this.get__Type() == null) throw new org.molgenis.framework.db.DatabaseException("required field __Type is null");
		if(this.getNumberOfIndividuals() == null) throw new org.molgenis.framework.db.DatabaseException("required field numberOfIndividuals is null");
		if(this.getDNAsArePooled() == null) throw new org.molgenis.framework.db.DatabaseException("required field dNAsArePooled is null");
		if(this.getDNAsAreWGA() == null) throw new org.molgenis.framework.db.DatabaseException("required field dNAsAreWGA is null");
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
			this.setDescription(tuple.getString("Description"));
			//set PanelType
			this.setPanelType(tuple.getInt("PanelType"));
			//set label Identifier for xref field PanelType
			this.setPanelType_Identifier(tuple.getString("PanelType_Identifier"));	
			//set NumberOfIndividuals
			this.setNumberOfIndividuals(tuple.getInt("NumberOfIndividuals"));
			//set Species
			this.setSpecies(tuple.getInt("Species"));
			//set label Identifier for xref field Species
			this.setSpecies_Identifier(tuple.getString("Species_Identifier"));	
			//mrefs can not be directly retrieved
			//set Individuals			
			//set CentralIdentifier
			this.setCentralIdentifier(tuple.getInt("CentralIdentifier"));
			//set label Identifier for xref field CentralIdentifier
			this.setCentralIdentifier_Identifier(tuple.getString("CentralIdentifier_Identifier"));	
			//set Label
			this.setLabel(tuple.getString("Label"));
			//set Accession
			this.setAccession(tuple.getString("Accession"));
			//set AccessionVersion
			this.setAccessionVersion(tuple.getString("AccessionVersion"));
			//set Composition
			this.setComposition(tuple.getString("Composition"));
			//set TotalNumberOfIndividuals
			this.setTotalNumberOfIndividuals(tuple.getInt("TotalNumberOfIndividuals"));
			//set NumberOfSexMale
			this.setNumberOfSexMale(tuple.getInt("NumberOfSexMale"));
			//set NumberOfSexFemale
			this.setNumberOfSexFemale(tuple.getInt("NumberOfSexFemale"));
			//set NumberOfSexUnknown
			this.setNumberOfSexUnknown(tuple.getInt("NumberOfSexUnknown"));
			//set NumberOfProbands
			this.setNumberOfProbands(tuple.getInt("NumberOfProbands"));
			//set NumberOfParents
			this.setNumberOfParents(tuple.getInt("NumberOfParents"));
			//set ModeOfRecruitment
			this.setModeOfRecruitment(tuple.getString("ModeOfRecruitment"));
			//set DiagnosisAgeRange
			this.setDiagnosisAgeRange(tuple.getString("DiagnosisAgeRange"));
			//set DiagnosisPeriod
			this.setDiagnosisPeriod(tuple.getString("DiagnosisPeriod"));
			//set SamplingAgeRange
			this.setSamplingAgeRange(tuple.getString("SamplingAgeRange"));
			//set SamplingPeriod
			this.setSamplingPeriod(tuple.getString("SamplingPeriod"));
			//set PopulationInfo
			this.setPopulationInfo(tuple.getString("PopulationInfo"));
			//set GeographicRegionInfo
			this.setGeographicRegionInfo(tuple.getString("GeographicRegionInfo"));
			//set EthnicityInfo
			this.setEthnicityInfo(tuple.getString("EthnicityInfo"));
			//set BirthPlaceInfo
			this.setBirthPlaceInfo(tuple.getString("BirthPlaceInfo"));
			//set AdmixtureInfo
			this.setAdmixtureInfo(tuple.getString("AdmixtureInfo"));
			//set EnvironmentInfo
			this.setEnvironmentInfo(tuple.getString("EnvironmentInfo"));
			//set SourceOfDNA
			this.setSourceOfDNA(tuple.getString("SourceOfDNA"));
			//set DNAsArePooled
			this.setDNAsArePooled(tuple.getString("DNAsArePooled"));
			//set DNAsAreWGA
			this.setDNAsAreWGA(tuple.getString("DNAsAreWGA"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("SamplePanel_id") != null) this.setId(tuple.getInt("SamplePanel_id"));
			//set Identifier
			if( strict || tuple.getString("Identifier") != null) this.setIdentifier(tuple.getString("Identifier"));
			if( tuple.getString("SamplePanel_Identifier") != null) this.setIdentifier(tuple.getString("SamplePanel_Identifier"));
			//set Name
			if( strict || tuple.getString("Name") != null) this.setName(tuple.getString("Name"));
			if( tuple.getString("SamplePanel_Name") != null) this.setName(tuple.getString("SamplePanel_Name"));
			//set __Type
			if( strict || tuple.getString("__Type") != null) this.set__Type(tuple.getString("__Type"));
			if( tuple.getString("SamplePanel___Type") != null) this.set__Type(tuple.getString("SamplePanel___Type"));
			//set Description
			if( strict || tuple.getString("Description") != null) this.setDescription(tuple.getString("Description"));
			if( tuple.getString("SamplePanel_Description") != null) this.setDescription(tuple.getString("SamplePanel_Description"));
			//set PanelType
			if( strict || tuple.getInt("PanelType_id") != null) this.setPanelType(tuple.getInt("PanelType_id"));
			if( tuple.getInt("SamplePanel_PanelType_id") != null) this.setPanelType(tuple.getInt("SamplePanel_PanelType_id"));
			//alias of xref
			if( tuple.getObject("PanelType") != null) this.setPanelType(tuple.getInt("PanelType"));
			if( tuple.getObject("SamplePanel_PanelType") != null) this.setPanelType(tuple.getInt("SamplePanel_PanelType"));
			//set label for field PanelType
			if( strict || tuple.getObject("PanelType_Identifier") != null) this.setPanelType_Identifier(tuple.getString("PanelType_Identifier"));			
			if( tuple.getObject("SamplePanel_PanelType_Identifier") != null ) this.setPanelType_Identifier(tuple.getString("SamplePanel_PanelType_Identifier"));		
			//set NumberOfIndividuals
			if( strict || tuple.getInt("NumberOfIndividuals") != null) this.setNumberOfIndividuals(tuple.getInt("NumberOfIndividuals"));
			if( tuple.getInt("SamplePanel_NumberOfIndividuals") != null) this.setNumberOfIndividuals(tuple.getInt("SamplePanel_NumberOfIndividuals"));
			//set Species
			if( strict || tuple.getInt("Species_id") != null) this.setSpecies(tuple.getInt("Species_id"));
			if( tuple.getInt("SamplePanel_Species_id") != null) this.setSpecies(tuple.getInt("SamplePanel_Species_id"));
			//alias of xref
			if( tuple.getObject("Species") != null) this.setSpecies(tuple.getInt("Species"));
			if( tuple.getObject("SamplePanel_Species") != null) this.setSpecies(tuple.getInt("SamplePanel_Species"));
			//set label for field Species
			if( strict || tuple.getObject("Species_Identifier") != null) this.setSpecies_Identifier(tuple.getString("Species_Identifier"));			
			if( tuple.getObject("SamplePanel_Species_Identifier") != null ) this.setSpecies_Identifier(tuple.getString("SamplePanel_Species_Identifier"));		
			//set Individuals
			if( tuple.getObject("Individuals")!= null || tuple.getObject("SamplePanel_Individuals")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("Individuals");
				if(tuple.getObject("SamplePanel_Individuals")!= null) mrefs = tuple.getList("SamplePanel_Individuals");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setIndividuals_Id( values );
			}
			//set labels Identifier for mref field Individuals	
			if( tuple.getObject("Individuals_Identifier")!= null || tuple.getObject("SamplePanel_Individuals_Identifier")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("Individuals_Identifier");
				if(tuple.getObject("SamplePanel_Individuals_Identifier")!= null) mrefs = tuple.getList("SamplePanel_Individuals_Identifier");
				
				if(mrefs != null) 
					for(Object ref: mrefs)
					{
						String[] refs = ref.toString().split("\\|");
						for(String r : refs) {
							values.add(r);	
						}						
					}							
				this.setIndividuals_Identifier( values );			
			}	
			//set CentralIdentifier
			if( strict || tuple.getInt("CentralIdentifier_id") != null) this.setCentralIdentifier(tuple.getInt("CentralIdentifier_id"));
			if( tuple.getInt("SamplePanel_CentralIdentifier_id") != null) this.setCentralIdentifier(tuple.getInt("SamplePanel_CentralIdentifier_id"));
			//alias of xref
			if( tuple.getObject("CentralIdentifier") != null) this.setCentralIdentifier(tuple.getInt("CentralIdentifier"));
			if( tuple.getObject("SamplePanel_CentralIdentifier") != null) this.setCentralIdentifier(tuple.getInt("SamplePanel_CentralIdentifier"));
			//set label for field CentralIdentifier
			if( strict || tuple.getObject("CentralIdentifier_Identifier") != null) this.setCentralIdentifier_Identifier(tuple.getString("CentralIdentifier_Identifier"));			
			if( tuple.getObject("SamplePanel_CentralIdentifier_Identifier") != null ) this.setCentralIdentifier_Identifier(tuple.getString("SamplePanel_CentralIdentifier_Identifier"));		
			//set Label
			if( strict || tuple.getString("Label") != null) this.setLabel(tuple.getString("Label"));
			if( tuple.getString("SamplePanel_Label") != null) this.setLabel(tuple.getString("SamplePanel_Label"));
			//set Accession
			if( strict || tuple.getString("Accession") != null) this.setAccession(tuple.getString("Accession"));
			if( tuple.getString("SamplePanel_Accession") != null) this.setAccession(tuple.getString("SamplePanel_Accession"));
			//set AccessionVersion
			if( strict || tuple.getString("AccessionVersion") != null) this.setAccessionVersion(tuple.getString("AccessionVersion"));
			if( tuple.getString("SamplePanel_AccessionVersion") != null) this.setAccessionVersion(tuple.getString("SamplePanel_AccessionVersion"));
			//set Composition
			if( strict || tuple.getString("Composition") != null) this.setComposition(tuple.getString("Composition"));
			if( tuple.getString("SamplePanel_Composition") != null) this.setComposition(tuple.getString("SamplePanel_Composition"));
			//set TotalNumberOfIndividuals
			if( strict || tuple.getInt("TotalNumberOfIndividuals") != null) this.setTotalNumberOfIndividuals(tuple.getInt("TotalNumberOfIndividuals"));
			if( tuple.getInt("SamplePanel_TotalNumberOfIndividuals") != null) this.setTotalNumberOfIndividuals(tuple.getInt("SamplePanel_TotalNumberOfIndividuals"));
			//set NumberOfSexMale
			if( strict || tuple.getInt("NumberOfSexMale") != null) this.setNumberOfSexMale(tuple.getInt("NumberOfSexMale"));
			if( tuple.getInt("SamplePanel_NumberOfSexMale") != null) this.setNumberOfSexMale(tuple.getInt("SamplePanel_NumberOfSexMale"));
			//set NumberOfSexFemale
			if( strict || tuple.getInt("NumberOfSexFemale") != null) this.setNumberOfSexFemale(tuple.getInt("NumberOfSexFemale"));
			if( tuple.getInt("SamplePanel_NumberOfSexFemale") != null) this.setNumberOfSexFemale(tuple.getInt("SamplePanel_NumberOfSexFemale"));
			//set NumberOfSexUnknown
			if( strict || tuple.getInt("NumberOfSexUnknown") != null) this.setNumberOfSexUnknown(tuple.getInt("NumberOfSexUnknown"));
			if( tuple.getInt("SamplePanel_NumberOfSexUnknown") != null) this.setNumberOfSexUnknown(tuple.getInt("SamplePanel_NumberOfSexUnknown"));
			//set NumberOfProbands
			if( strict || tuple.getInt("NumberOfProbands") != null) this.setNumberOfProbands(tuple.getInt("NumberOfProbands"));
			if( tuple.getInt("SamplePanel_NumberOfProbands") != null) this.setNumberOfProbands(tuple.getInt("SamplePanel_NumberOfProbands"));
			//set NumberOfParents
			if( strict || tuple.getInt("NumberOfParents") != null) this.setNumberOfParents(tuple.getInt("NumberOfParents"));
			if( tuple.getInt("SamplePanel_NumberOfParents") != null) this.setNumberOfParents(tuple.getInt("SamplePanel_NumberOfParents"));
			//set ModeOfRecruitment
			if( strict || tuple.getString("ModeOfRecruitment") != null) this.setModeOfRecruitment(tuple.getString("ModeOfRecruitment"));
			if( tuple.getString("SamplePanel_ModeOfRecruitment") != null) this.setModeOfRecruitment(tuple.getString("SamplePanel_ModeOfRecruitment"));
			//set DiagnosisAgeRange
			if( strict || tuple.getString("DiagnosisAgeRange") != null) this.setDiagnosisAgeRange(tuple.getString("DiagnosisAgeRange"));
			if( tuple.getString("SamplePanel_DiagnosisAgeRange") != null) this.setDiagnosisAgeRange(tuple.getString("SamplePanel_DiagnosisAgeRange"));
			//set DiagnosisPeriod
			if( strict || tuple.getString("DiagnosisPeriod") != null) this.setDiagnosisPeriod(tuple.getString("DiagnosisPeriod"));
			if( tuple.getString("SamplePanel_DiagnosisPeriod") != null) this.setDiagnosisPeriod(tuple.getString("SamplePanel_DiagnosisPeriod"));
			//set SamplingAgeRange
			if( strict || tuple.getString("SamplingAgeRange") != null) this.setSamplingAgeRange(tuple.getString("SamplingAgeRange"));
			if( tuple.getString("SamplePanel_SamplingAgeRange") != null) this.setSamplingAgeRange(tuple.getString("SamplePanel_SamplingAgeRange"));
			//set SamplingPeriod
			if( strict || tuple.getString("SamplingPeriod") != null) this.setSamplingPeriod(tuple.getString("SamplingPeriod"));
			if( tuple.getString("SamplePanel_SamplingPeriod") != null) this.setSamplingPeriod(tuple.getString("SamplePanel_SamplingPeriod"));
			//set PopulationInfo
			if( strict || tuple.getString("PopulationInfo") != null) this.setPopulationInfo(tuple.getString("PopulationInfo"));
			if( tuple.getString("SamplePanel_PopulationInfo") != null) this.setPopulationInfo(tuple.getString("SamplePanel_PopulationInfo"));
			//set GeographicRegionInfo
			if( strict || tuple.getString("GeographicRegionInfo") != null) this.setGeographicRegionInfo(tuple.getString("GeographicRegionInfo"));
			if( tuple.getString("SamplePanel_GeographicRegionInfo") != null) this.setGeographicRegionInfo(tuple.getString("SamplePanel_GeographicRegionInfo"));
			//set EthnicityInfo
			if( strict || tuple.getString("EthnicityInfo") != null) this.setEthnicityInfo(tuple.getString("EthnicityInfo"));
			if( tuple.getString("SamplePanel_EthnicityInfo") != null) this.setEthnicityInfo(tuple.getString("SamplePanel_EthnicityInfo"));
			//set BirthPlaceInfo
			if( strict || tuple.getString("BirthPlaceInfo") != null) this.setBirthPlaceInfo(tuple.getString("BirthPlaceInfo"));
			if( tuple.getString("SamplePanel_BirthPlaceInfo") != null) this.setBirthPlaceInfo(tuple.getString("SamplePanel_BirthPlaceInfo"));
			//set AdmixtureInfo
			if( strict || tuple.getString("AdmixtureInfo") != null) this.setAdmixtureInfo(tuple.getString("AdmixtureInfo"));
			if( tuple.getString("SamplePanel_AdmixtureInfo") != null) this.setAdmixtureInfo(tuple.getString("SamplePanel_AdmixtureInfo"));
			//set EnvironmentInfo
			if( strict || tuple.getString("EnvironmentInfo") != null) this.setEnvironmentInfo(tuple.getString("EnvironmentInfo"));
			if( tuple.getString("SamplePanel_EnvironmentInfo") != null) this.setEnvironmentInfo(tuple.getString("SamplePanel_EnvironmentInfo"));
			//set SourceOfDNA
			if( strict || tuple.getString("SourceOfDNA") != null) this.setSourceOfDNA(tuple.getString("SourceOfDNA"));
			if( tuple.getString("SamplePanel_SourceOfDNA") != null) this.setSourceOfDNA(tuple.getString("SamplePanel_SourceOfDNA"));
			//set DNAsArePooled
			if( strict || tuple.getString("DNAsArePooled") != null) this.setDNAsArePooled(tuple.getString("DNAsArePooled"));
			if( tuple.getString("SamplePanel_DNAsArePooled") != null) this.setDNAsArePooled(tuple.getString("SamplePanel_DNAsArePooled"));
			//set DNAsAreWGA
			if( strict || tuple.getString("DNAsAreWGA") != null) this.setDNAsAreWGA(tuple.getString("DNAsAreWGA"));
			if( tuple.getString("SamplePanel_DNAsAreWGA") != null) this.setDNAsAreWGA(tuple.getString("SamplePanel_DNAsAreWGA"));
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
		String result = "SamplePanel(";
		result+= "id='" + getId()+"' ";	
		result+= "identifier='" + getIdentifier()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= "__Type='" + get__Type()+"' ";	
		result+= "description='" + getDescription()+"' ";	
		result+= " panelType_id='" + getPanelType_Id()+"' ";	
		result+= " panelType_identifier='" + getPanelType_Identifier()+"' ";
		result+= "numberOfIndividuals='" + getNumberOfIndividuals()+"' ";	
		result+= " species_id='" + getSpecies_Id()+"' ";	
		result+= " species_identifier='" + getSpecies_Identifier()+"' ";
		result+= " individuals_id='" + getIndividuals_Id()+"' ";	
		result+= " individuals_identifier='" + getIndividuals_Identifier()+"' ";
		result+= " centralIdentifier_id='" + getCentralIdentifier_Id()+"' ";	
		result+= " centralIdentifier_identifier='" + getCentralIdentifier_Identifier()+"' ";
		result+= "label='" + getLabel()+"' ";	
		result+= "accession='" + getAccession()+"' ";	
		result+= "accessionVersion='" + getAccessionVersion()+"' ";	
		result+= "composition='" + getComposition()+"' ";	
		result+= "totalNumberOfIndividuals='" + getTotalNumberOfIndividuals()+"' ";	
		result+= "numberOfSexMale='" + getNumberOfSexMale()+"' ";	
		result+= "numberOfSexFemale='" + getNumberOfSexFemale()+"' ";	
		result+= "numberOfSexUnknown='" + getNumberOfSexUnknown()+"' ";	
		result+= "numberOfProbands='" + getNumberOfProbands()+"' ";	
		result+= "numberOfParents='" + getNumberOfParents()+"' ";	
		result+= "modeOfRecruitment='" + getModeOfRecruitment()+"' ";	
		result+= "diagnosisAgeRange='" + getDiagnosisAgeRange()+"' ";	
		result+= "diagnosisPeriod='" + getDiagnosisPeriod()+"' ";	
		result+= "samplingAgeRange='" + getSamplingAgeRange()+"' ";	
		result+= "samplingPeriod='" + getSamplingPeriod()+"' ";	
		result+= "populationInfo='" + getPopulationInfo()+"' ";	
		result+= "geographicRegionInfo='" + getGeographicRegionInfo()+"' ";	
		result+= "ethnicityInfo='" + getEthnicityInfo()+"' ";	
		result+= "birthPlaceInfo='" + getBirthPlaceInfo()+"' ";	
		result+= "admixtureInfo='" + getAdmixtureInfo()+"' ";	
		result+= "environmentInfo='" + getEnvironmentInfo()+"' ";	
		result+= "sourceOfDNA='" + getSourceOfDNA()+"' ";	
		result+= "dNAsArePooled='" + getDNAsArePooled()+"' ";	
		result+= "dNAsAreWGA='" + getDNAsAreWGA()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of SamplePanel.
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
			fields.add("panelType_id");
		}
		fields.add("panelType_identifier");
		{
			fields.add("numberOfIndividuals");
		}
		{
			fields.add("species_id");
		}
		fields.add("species_identifier");
		{
			fields.add("individuals_id");
		}
		fields.add("individuals_identifier");
		{
			fields.add("centralIdentifier_id");
		}
		fields.add("centralIdentifier_identifier");
		{
			fields.add("label");
		}
		{
			fields.add("accession");
		}
		{
			fields.add("accessionVersion");
		}
		{
			fields.add("composition");
		}
		{
			fields.add("totalNumberOfIndividuals");
		}
		{
			fields.add("numberOfSexMale");
		}
		{
			fields.add("numberOfSexFemale");
		}
		{
			fields.add("numberOfSexUnknown");
		}
		{
			fields.add("numberOfProbands");
		}
		{
			fields.add("numberOfParents");
		}
		{
			fields.add("modeOfRecruitment");
		}
		{
			fields.add("diagnosisAgeRange");
		}
		{
			fields.add("diagnosisPeriod");
		}
		{
			fields.add("samplingAgeRange");
		}
		{
			fields.add("samplingPeriod");
		}
		{
			fields.add("populationInfo");
		}
		{
			fields.add("geographicRegionInfo");
		}
		{
			fields.add("ethnicityInfo");
		}
		{
			fields.add("birthPlaceInfo");
		}
		{
			fields.add("admixtureInfo");
		}
		{
			fields.add("environmentInfo");
		}
		{
			fields.add("sourceOfDNA");
		}
		{
			fields.add("dNAsArePooled");
		}
		{
			fields.add("dNAsAreWGA");
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
		+ "panelType" +sep
		+ "numberOfIndividuals" +sep
		+ "species" +sep
		+ "individuals" +sep
		+ "centralIdentifier" +sep
		+ "label" +sep
		+ "accession" +sep
		+ "accessionVersion" +sep
		+ "composition" +sep
		+ "totalNumberOfIndividuals" +sep
		+ "numberOfSexMale" +sep
		+ "numberOfSexFemale" +sep
		+ "numberOfSexUnknown" +sep
		+ "numberOfProbands" +sep
		+ "numberOfParents" +sep
		+ "modeOfRecruitment" +sep
		+ "diagnosisAgeRange" +sep
		+ "diagnosisPeriod" +sep
		+ "samplingAgeRange" +sep
		+ "samplingPeriod" +sep
		+ "populationInfo" +sep
		+ "geographicRegionInfo" +sep
		+ "ethnicityInfo" +sep
		+ "birthPlaceInfo" +sep
		+ "admixtureInfo" +sep
		+ "environmentInfo" +sep
		+ "sourceOfDNA" +sep
		+ "dNAsArePooled" +sep
		+ "dNAsAreWGA" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("panelType")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("species")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("individuals")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("centralIdentifier")) {
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
		SamplePanel rhs = (SamplePanel) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
             	.appendSuper(super.equals(obj))
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
             	.appendSuper(super.hashCode())
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
			Object valueO = getPanelType();
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
			Object valueO = getNumberOfIndividuals();
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
			out.write(valueS+sep);
		}
		{
			Object valueO = getIndividuals();
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
			Object valueO = getCentralIdentifier();
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
			Object valueO = getLabel();
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
			out.write(valueS+sep);
		}
		{
			Object valueO = getAccessionVersion();
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
			Object valueO = getComposition();
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
			Object valueO = getTotalNumberOfIndividuals();
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
			Object valueO = getNumberOfSexMale();
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
			Object valueO = getNumberOfSexFemale();
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
			Object valueO = getNumberOfSexUnknown();
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
			Object valueO = getNumberOfProbands();
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
			Object valueO = getNumberOfParents();
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
			Object valueO = getModeOfRecruitment();
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
			Object valueO = getDiagnosisAgeRange();
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
			Object valueO = getDiagnosisPeriod();
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
			Object valueO = getSamplingAgeRange();
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
			Object valueO = getSamplingPeriod();
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
			Object valueO = getPopulationInfo();
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
			Object valueO = getGeographicRegionInfo();
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
			Object valueO = getEthnicityInfo();
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
			Object valueO = getBirthPlaceInfo();
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
			Object valueO = getAdmixtureInfo();
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
			Object valueO = getEnvironmentInfo();
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
			Object valueO = getSourceOfDNA();
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
			Object valueO = getDNAsArePooled();
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
			Object valueO = getDNAsAreWGA();
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
	public SamplePanel create(org.molgenis.util.Tuple tuple) throws Exception
	{
		SamplePanel e = new SamplePanel();
		e.set(tuple);
		return e;
	}
	

	
}

