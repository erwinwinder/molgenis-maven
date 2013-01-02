
/* File:        org.molgenis.omx/model/GWASExperiment.java
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.gwascentral;

/**
 * GWASExperiment: .
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "GWASExperiment", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "Identifier" } ) }
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.gwascentral.db.GWASExperimentEntityListener.class})
public class GWASExperiment extends org.molgenis.organization.Experiment implements org.molgenis.core.Identifiable
{
	// fieldname constants
	public final static String ID = "id";
	public final static String IDENTIFIER = "Identifier";
	public final static String NAME = "Name";
	public final static String INDIVIDUALDATASTATEMENT = "IndividualDataStatement";
	public final static String TOTALMARKERSTESTED = "TotalMarkersTested";
	public final static String TOTALMARKERSIMPORTED = "TotalMarkersImported";
	
	//static methods
	/**
	 * Shorthand for db.query(GWASExperiment.class).
	 */
	public static org.molgenis.framework.db.Query<? extends GWASExperiment> query(org.molgenis.framework.db.Database db)
	{
		return db.query(GWASExperiment.class);
	}
	
	/**
	 * Shorthand for db.find(GWASExperiment.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends GWASExperiment> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(GWASExperiment.class, rules);
	}	
	
	/**
	 * 
	 */
	public static GWASExperiment findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<GWASExperiment> q = db.query(GWASExperiment.class);
		q.eq(GWASExperiment.ID, id);
		java.util.List<GWASExperiment> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static GWASExperiment findByIdentifier(org.molgenis.framework.db.Database db, String identifier) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<GWASExperiment> q = db.query(GWASExperiment.class);
		q.eq(GWASExperiment.IDENTIFIER, identifier);
		java.util.List<GWASExperiment> result = q.find();
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


	//human readible name, not necessary unique.[type=string]
	@javax.persistence.Column(name="Name", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="name")
	
				

	@javax.validation.constraints.NotNull
	private String name =  null;


	//Individual data statement[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="IndividualDataStatement", length=16777216)
	
				

	private String individualDataStatement =  "Access to individual-level data must be made to the study authors";


	//Total markers tested[type=int]
	@javax.persistence.Column(name="TotalMarkersTested")
	@javax.xml.bind.annotation.XmlElement(name="totalMarkersTested")
	
				

	private Integer totalMarkersTested =  null;


	//Total markers imported[type=int]
	@javax.persistence.Column(name="TotalMarkersImported")
	@javax.xml.bind.annotation.XmlElement(name="totalMarkersImported")
	
				

	private Integer totalMarkersImported =  null;

	//constructors
	public GWASExperiment()
	{
		//set the type for a new instance
		set__Type(this.getClass().getSimpleName());
	
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
				//hack to solve problem with variable hidden in supertype
				super.setName(name);
				//2222hack to solve problem with variable hidden in supertype
				super.setName(name);
		
		this.name = name;
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
				//hack to solve problem with variable hidden in supertype
				super.setIndividualDataStatement(individualDataStatement);
				//2222hack to solve problem with variable hidden in supertype
				super.setIndividualDataStatement(individualDataStatement);
		
		this.individualDataStatement = individualDataStatement;
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
				//hack to solve problem with variable hidden in supertype
				super.setTotalMarkersTested(totalMarkersTested);
				//2222hack to solve problem with variable hidden in supertype
				super.setTotalMarkersTested(totalMarkersTested);
		
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
				//hack to solve problem with variable hidden in supertype
				super.setTotalMarkersImported(totalMarkersImported);
				//2222hack to solve problem with variable hidden in supertype
				super.setTotalMarkersImported(totalMarkersImported);
		
		this.totalMarkersImported = totalMarkersImported;
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
			if( tuple.getInt("GWASExperiment_id") != null) this.setId(tuple.getInt("GWASExperiment_id"));
			//set Identifier
			if( strict || tuple.getString("Identifier") != null) this.setIdentifier(tuple.getString("Identifier"));
			if( tuple.getString("GWASExperiment_Identifier") != null) this.setIdentifier(tuple.getString("GWASExperiment_Identifier"));
			//set Name
			if( strict || tuple.getString("Name") != null) this.setName(tuple.getString("Name"));
			if( tuple.getString("GWASExperiment_Name") != null) this.setName(tuple.getString("GWASExperiment_Name"));
			//set __Type
			if( strict || tuple.getString("__Type") != null) this.set__Type(tuple.getString("__Type"));
			if( tuple.getString("GWASExperiment___Type") != null) this.set__Type(tuple.getString("GWASExperiment___Type"));
			//set Study
			if( strict || tuple.getInt("Study_id") != null) this.setStudy(tuple.getInt("Study_id"));
			if( tuple.getInt("GWASExperiment_Study_id") != null) this.setStudy(tuple.getInt("GWASExperiment_Study_id"));
			//alias of xref
			if( tuple.getObject("Study") != null) this.setStudy(tuple.getInt("Study"));
			if( tuple.getObject("GWASExperiment_Study") != null) this.setStudy(tuple.getInt("GWASExperiment_Study"));
			//set label for field Study
			if( strict || tuple.getObject("Study_Identifier") != null) this.setStudy_Identifier(tuple.getString("Study_Identifier"));			
			if( tuple.getObject("GWASExperiment_Study_Identifier") != null ) this.setStudy_Identifier(tuple.getString("GWASExperiment_Study_Identifier"));		
			//set Design
			if( strict || tuple.getString("Design") != null) this.setDesign(tuple.getString("Design"));
			if( tuple.getString("GWASExperiment_Design") != null) this.setDesign(tuple.getString("GWASExperiment_Design"));
			//set ExperimentType
			if( strict || tuple.getInt("ExperimentType_id") != null) this.setExperimentType(tuple.getInt("ExperimentType_id"));
			if( tuple.getInt("GWASExperiment_ExperimentType_id") != null) this.setExperimentType(tuple.getInt("GWASExperiment_ExperimentType_id"));
			//alias of xref
			if( tuple.getObject("ExperimentType") != null) this.setExperimentType(tuple.getInt("ExperimentType"));
			if( tuple.getObject("GWASExperiment_ExperimentType") != null) this.setExperimentType(tuple.getInt("GWASExperiment_ExperimentType"));
			//set label for field ExperimentType
			if( strict || tuple.getObject("ExperimentType_Identifier") != null) this.setExperimentType_Identifier(tuple.getString("ExperimentType_Identifier"));			
			if( tuple.getObject("GWASExperiment_ExperimentType_Identifier") != null ) this.setExperimentType_Identifier(tuple.getString("GWASExperiment_ExperimentType_Identifier"));		
			//set TotalMarkersTested
			if( strict || tuple.getInt("TotalMarkersTested") != null) this.setTotalMarkersTested(tuple.getInt("TotalMarkersTested"));
			if( tuple.getInt("GWASExperiment_TotalMarkersTested") != null) this.setTotalMarkersTested(tuple.getInt("GWASExperiment_TotalMarkersTested"));
			//set TotalMarkersImported
			if( strict || tuple.getInt("TotalMarkersImported") != null) this.setTotalMarkersImported(tuple.getInt("TotalMarkersImported"));
			if( tuple.getInt("GWASExperiment_TotalMarkersImported") != null) this.setTotalMarkersImported(tuple.getInt("GWASExperiment_TotalMarkersImported"));
			//set Objective
			if( strict || tuple.getString("Objective") != null) this.setObjective(tuple.getString("Objective"));
			if( tuple.getString("GWASExperiment_Objective") != null) this.setObjective(tuple.getString("GWASExperiment_Objective"));
			//set Outcome
			if( strict || tuple.getString("Outcome") != null) this.setOutcome(tuple.getString("Outcome"));
			if( tuple.getString("GWASExperiment_Outcome") != null) this.setOutcome(tuple.getString("GWASExperiment_Outcome"));
			//set Comments
			if( strict || tuple.getString("Comments") != null) this.setComments(tuple.getString("Comments"));
			if( tuple.getString("GWASExperiment_Comments") != null) this.setComments(tuple.getString("GWASExperiment_Comments"));
			//set IndividualDataStatement
			if( strict || tuple.getString("IndividualDataStatement") != null) this.setIndividualDataStatement(tuple.getString("IndividualDataStatement"));
			if( tuple.getString("GWASExperiment_IndividualDataStatement") != null) this.setIndividualDataStatement(tuple.getString("GWASExperiment_IndividualDataStatement"));
			//set TimeCreated
			if( strict || tuple.getTimestamp("TimeCreated") != null) this.setTimeCreated(tuple.getTimestamp("TimeCreated"));
			if( tuple.getTimestamp("GWASExperiment_TimeCreated") != null) this.setTimeCreated(tuple.getTimestamp("GWASExperiment_TimeCreated"));
			//set AssayedPanels
			if( tuple.getObject("AssayedPanels")!= null || tuple.getObject("GWASExperiment_AssayedPanels")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("AssayedPanels");
				if(tuple.getObject("GWASExperiment_AssayedPanels")!= null) mrefs = tuple.getList("GWASExperiment_AssayedPanels");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setAssayedPanels_Id( values );
			}
			//set labels Identifier for mref field AssayedPanels	
			if( tuple.getObject("AssayedPanels_Identifier")!= null || tuple.getObject("GWASExperiment_AssayedPanels_Identifier")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("AssayedPanels_Identifier");
				if(tuple.getObject("GWASExperiment_AssayedPanels_Identifier")!= null) mrefs = tuple.getList("GWASExperiment_AssayedPanels_Identifier");
				
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
			if( tuple.getObject("DataSets")!= null || tuple.getObject("GWASExperiment_DataSets")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("DataSets");
				if(tuple.getObject("GWASExperiment_DataSets")!= null) mrefs = tuple.getList("GWASExperiment_DataSets");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setDataSets_Id( values );
			}
			//set labels Identifier for mref field DataSets	
			if( tuple.getObject("DataSets_Identifier")!= null || tuple.getObject("GWASExperiment_DataSets_Identifier")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("DataSets_Identifier");
				if(tuple.getObject("GWASExperiment_DataSets_Identifier")!= null) mrefs = tuple.getList("GWASExperiment_DataSets_Identifier");
				
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
		String result = "GWASExperiment(";
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
	 * Get the names of all public properties of GWASExperiment.
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
		GWASExperiment rhs = (GWASExperiment) obj;
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
	public GWASExperiment create(org.molgenis.util.Tuple tuple) throws Exception
	{
		GWASExperiment e = new GWASExperiment();
		e.set(tuple);
		return e;
	}
	

	
}

