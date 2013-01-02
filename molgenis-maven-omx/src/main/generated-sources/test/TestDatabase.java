/* File:        org.molgenis.omx/JUnitTest.java
 * Copyright:   GBIC 2000-2013, all rights reserved
 * Date:        January 2, 2013
 * 
 * generator:   org.molgenis.generators.tests.TestDatabaseGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package test;

import org.molgenis.omx.DatabaseFactory;
import org.molgenis.omx.JDBCDatabase;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;

import org.molgenis.Molgenis;
import org.molgenis.util.Entity;
import org.molgenis.util.SimpleTuple;
import org.molgenis.framework.db.Database;
import org.molgenis.framework.db.Query;
import org.molgenis.framework.db.DatabaseException;

import static  org.testng.AssertJUnit.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.molgenis.core.Autoid;
import org.molgenis.core.Identifiable;
import org.molgenis.core.MolgenisEntity;
import org.molgenis.core.MolgenisFile;
import org.molgenis.core.RuntimeProperty;
import org.molgenis.auth.MolgenisRole;
import org.molgenis.auth.MolgenisGroup;
import org.molgenis.auth.MolgenisUser;
import org.molgenis.auth.MolgenisRoleGroupLink;
import org.molgenis.auth.MolgenisPermission;
import org.molgenis.auth.Authorizable;
import org.molgenis.observ.Characteristic;
import org.molgenis.observ.ObservationTarget;
import org.molgenis.observ.ObservableFeature;
import org.molgenis.observ.Category;
import org.molgenis.observ.Protocol;
import org.molgenis.observ.DataSet;
import org.molgenis.observ.ObservationSet;
import org.molgenis.observ.ObservedValue;
import org.molgenis.observ.target.Species;
import org.molgenis.observ.target.Individual;
import org.molgenis.observ.target.Panel;
import org.molgenis.observ.target.PanelSource;
import org.molgenis.observ.target.Ontology;
import org.molgenis.observ.target.OntologyTerm;
import org.molgenis.observ.target.Accession;
import org.molgenis.variant.BioSequence;
import org.molgenis.variant.GdnaPosition;
import org.molgenis.variant.CdnaPosition;
import org.molgenis.variant.AaPosition;
import org.molgenis.variant.Genome;
import org.molgenis.variant.Chromosome;
import org.molgenis.variant.Gene;
import org.molgenis.variant.Protein;
import org.molgenis.variant.ProteinDomain;
import org.molgenis.variant.Exon;
import org.molgenis.variant.Variant;
import org.molgenis.organization.Study;
import org.molgenis.organization.Experiment;
import org.molgenis.organization.Institute;
import org.molgenis.organization.Person;
import org.molgenis.organization.Citation;
import org.molgenis.organization.Contribution;
import org.molgenis.organization.Submission;
import org.molgenis.gwascentral.Investigation;
import org.molgenis.gwascentral.StudyDetails;
import org.molgenis.gwascentral.FrequencyCluster;
import org.molgenis.gwascentral.GenotypeFrequency;
import org.molgenis.gwascentral.AlleleFrequency;
import org.molgenis.gwascentral.PhenotypeProperty;
import org.molgenis.gwascentral.PhenotypeMethod;
import org.molgenis.gwascentral.PhenotypeValue;
import org.molgenis.gwascentral.SamplePanel;
import org.molgenis.gwascentral.AssayedPanel;
import org.molgenis.gwascentral.GWASExperiment;
import org.molgenis.gwascentral.UsedMarkerSet;
import org.molgenis.gwascentral.Significance;
import org.molgenis.gwascentral.EffectSize;
import org.molgenis.gwascentral.SelectionCriteria;
import org.molgenis.observ.Protocol_Subprotocols;
import org.molgenis.observ.Protocol_Features;
import org.molgenis.observ.target.Panel_Individuals;
import org.molgenis.organization.Experiment_AssayedPanels;
import org.molgenis.organization.Experiment_DataSets;
import org.molgenis.organization.Person_AffiliateInstitutions;
import org.molgenis.organization.Citation_OntologyTerms;
import org.molgenis.gwascentral.StudyDetails_OtherCitations;

public class TestDatabase
{
	private static int total = 10;
	private static Database db;
	private static final Logger logger = Logger.getLogger(TestDatabase.class);
	DateFormat dateFormat = new SimpleDateFormat(SimpleTuple.DATEFORMAT, Locale.US);
	DateFormat dateTimeFormat = new SimpleDateFormat(SimpleTuple.DATETIMEFORMAT, Locale.US);	 


	/*
	 * Create a database to use
	 */
	@BeforeClass(alwaysRun = true)
	public static void oneTimeSetUp()   
	{
		try
		{
		//bad: test expects an existing, but empty database.
		//this means the previous test will need to end with e.g.
		//new emptyDatabase(new MolgenisServlet().getDatabase(), false);	
			//db = new MolgenisServlet().getDatabase();
                        db = DatabaseFactory.createTest("src/main/resources/org/molgenis/omicsconnect/omicsconnect.properties"); //correct?	
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		logger.info("Database created");
	}
		
	@Test
	public void testMolgenisEntity() throws DatabaseException
	{
		//create entities
		List<MolgenisEntity> entities = new ArrayList<MolgenisEntity>();

		//retrieve xref entity candidates

		for(Integer i = 0; i < total; i++)
		{
			MolgenisEntity e = new MolgenisEntity();
			e.setName(truncate("molgenisentity_name_"+i, 255));
			e.setType(truncate("molgenisentity_type__"+i, 255));
			e.setClassName(truncate("molgenisentity_classname_"+i, 255));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<MolgenisEntity> q = db.query(MolgenisEntity.class);
		assertEquals(total, q.count());
		List<MolgenisEntity> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getType(), entitiesDb.get(i).getType());
			assertEquals(entities.get(i).getClassName(), entitiesDb.get(i).getClassName());
		}	
		
		//test the query capabilities by finding on all fields
		for(MolgenisEntity entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<MolgenisEntity> q2 = db.query(MolgenisEntity.class);
				q2.equals("id",entity.getId());
				List<MolgenisEntity> results = q2.find();
				assertEquals(results.size(),1);
				for(MolgenisEntity r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<MolgenisEntity> q2 = db.query(MolgenisEntity.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<MolgenisEntity> results = q2.find();
				assertEquals(results.size(),1);
				for(MolgenisEntity r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<MolgenisEntity> q2 = db.query(MolgenisEntity.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<MolgenisEntity> results = q2.find();
				for(MolgenisEntity r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<MolgenisEntity> q2 = db.query(MolgenisEntity.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<MolgenisEntity> results = q2.find();
				for(MolgenisEntity r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'name', type 'string'
			{
				Query<MolgenisEntity> q2 = db.query(MolgenisEntity.class);
				q2.equals("name",entity.getName());
				List<MolgenisEntity> results = q2.find();
				for(MolgenisEntity r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'name'
			{
				Query<MolgenisEntity> q2 = db.query(MolgenisEntity.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<MolgenisEntity> results = q2.find();
				for(MolgenisEntity r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'name'
			{
				Query<MolgenisEntity> q2 = db.query(MolgenisEntity.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<MolgenisEntity> results = q2.find();
				for(MolgenisEntity r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'type_', type 'string'
			{
				Query<MolgenisEntity> q2 = db.query(MolgenisEntity.class);
				q2.equals("type_",entity.getType());
				List<MolgenisEntity> results = q2.find();
				for(MolgenisEntity r: results)
				{
					assertEquals(r.getType(),entity.getType());
				}
			}
			//test operator 'in' for field 'type_'
			{
				Query<MolgenisEntity> q2 = db.query(MolgenisEntity.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getType());
				q2.in("type_", inList);
				List<MolgenisEntity> results = q2.find();
				for(MolgenisEntity r: results)
				{
					assertEquals(r.getType(),entity.getType());
				}
			}
			//test operator 'like' for field 'type_'
			{
				Query<MolgenisEntity> q2 = db.query(MolgenisEntity.class);
				q2.like("type_", entity.getType() + "%");
				q2.sortASC("type_");
				List<MolgenisEntity> results = q2.find();
				for(MolgenisEntity r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getType(), entity.getType()));
				}
			}

			//test field 'className', type 'string'
			{
				Query<MolgenisEntity> q2 = db.query(MolgenisEntity.class);
				q2.equals("className",entity.getClassName());
				List<MolgenisEntity> results = q2.find();
				for(MolgenisEntity r: results)
				{
					assertEquals(r.getClassName(),entity.getClassName());
				}
			}
			//test operator 'in' for field 'className'
			{
				Query<MolgenisEntity> q2 = db.query(MolgenisEntity.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getClassName());
				q2.in("className", inList);
				List<MolgenisEntity> results = q2.find();
				for(MolgenisEntity r: results)
				{
					assertEquals(r.getClassName(),entity.getClassName());
				}
			}
			//test operator 'like' for field 'className'
			{
				Query<MolgenisEntity> q2 = db.query(MolgenisEntity.class);
				q2.like("className", entity.getClassName() + "%");
				q2.sortASC("className");
				List<MolgenisEntity> results = q2.find();
				for(MolgenisEntity r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getClassName(), entity.getClassName()));
				}
			}

		}
	}

	@Test
	public void testMolgenisFile() throws DatabaseException
	{
		//create entities
		List<MolgenisFile> entities = new ArrayList<MolgenisFile>();

		//retrieve xref entity candidates

		for(Integer i = 0; i < total; i++)
		{
			MolgenisFile e = new MolgenisFile();
			e.setIdentifier(truncate("molgenisfile_identifier_"+i, 255));
			e.setName(truncate("molgenisfile_name_"+i, 255));
			e.setExtension(truncate("molgenisfile_extension_"+i, 8));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<MolgenisFile> q = db.query(MolgenisFile.class);
		assertEquals(total, q.count());
		List<MolgenisFile> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getExtension(), entitiesDb.get(i).getExtension());
		}	
		
		//test the query capabilities by finding on all fields
		for(MolgenisFile entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<MolgenisFile> q2 = db.query(MolgenisFile.class);
				q2.equals("id",entity.getId());
				List<MolgenisFile> results = q2.find();
				for(MolgenisFile r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<MolgenisFile> q2 = db.query(MolgenisFile.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<MolgenisFile> results = q2.find();
				for(MolgenisFile r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<MolgenisFile> q2 = db.query(MolgenisFile.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<MolgenisFile> results = q2.find();
				for(MolgenisFile r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<MolgenisFile> q2 = db.query(MolgenisFile.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<MolgenisFile> results = q2.find();
				for(MolgenisFile r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<MolgenisFile> q2 = db.query(MolgenisFile.class);
				q2.equals("identifier",entity.getIdentifier());
				List<MolgenisFile> results = q2.find();
				for(MolgenisFile r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<MolgenisFile> q2 = db.query(MolgenisFile.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<MolgenisFile> results = q2.find();
				for(MolgenisFile r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<MolgenisFile> q2 = db.query(MolgenisFile.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<MolgenisFile> results = q2.find();
				for(MolgenisFile r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<MolgenisFile> q2 = db.query(MolgenisFile.class);
				q2.equals("name",entity.getName());
				List<MolgenisFile> results = q2.find();
				for(MolgenisFile r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<MolgenisFile> q2 = db.query(MolgenisFile.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<MolgenisFile> results = q2.find();
				for(MolgenisFile r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<MolgenisFile> q2 = db.query(MolgenisFile.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<MolgenisFile> results = q2.find();
				for(MolgenisFile r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'Extension', type 'string'
			{
				Query<MolgenisFile> q2 = db.query(MolgenisFile.class);
				q2.equals("extension",entity.getExtension());
				List<MolgenisFile> results = q2.find();
				for(MolgenisFile r: results)
				{
					assertEquals(r.getExtension(),entity.getExtension());
				}
			}
			//test operator 'in' for field 'Extension'
			{
				Query<MolgenisFile> q2 = db.query(MolgenisFile.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getExtension());
				q2.in("extension", inList);
				List<MolgenisFile> results = q2.find();
				for(MolgenisFile r: results)
				{
					assertEquals(r.getExtension(),entity.getExtension());
				}
			}
			//test operator 'like' for field 'Extension'
			{
				Query<MolgenisFile> q2 = db.query(MolgenisFile.class);
				q2.like("extension", entity.getExtension() + "%");
				q2.sortASC("extension");
				List<MolgenisFile> results = q2.find();
				for(MolgenisFile r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getExtension(), entity.getExtension()));
				}
			}

		}
	}

	@Test
	public void testRuntimeProperty() throws DatabaseException
	{
		//create entities
		List<RuntimeProperty> entities = new ArrayList<RuntimeProperty>();

		//retrieve xref entity candidates

		for(Integer i = 0; i < total; i++)
		{
			RuntimeProperty e = new RuntimeProperty();
			e.setIdentifier(truncate("runtimeproperty_identifier_"+i, 255));
			e.setName(truncate("runtimeproperty_name_"+i, 255));
			e.setValue(truncate("runtimeproperty_value_"+i, 127));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<RuntimeProperty> q = db.query(RuntimeProperty.class);
		assertEquals(total, q.count());
		List<RuntimeProperty> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getValue(), entitiesDb.get(i).getValue());
		}	
		
		//test the query capabilities by finding on all fields
		for(RuntimeProperty entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<RuntimeProperty> q2 = db.query(RuntimeProperty.class);
				q2.equals("id",entity.getId());
				List<RuntimeProperty> results = q2.find();
				for(RuntimeProperty r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<RuntimeProperty> q2 = db.query(RuntimeProperty.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<RuntimeProperty> results = q2.find();
				for(RuntimeProperty r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<RuntimeProperty> q2 = db.query(RuntimeProperty.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<RuntimeProperty> results = q2.find();
				for(RuntimeProperty r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<RuntimeProperty> q2 = db.query(RuntimeProperty.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<RuntimeProperty> results = q2.find();
				for(RuntimeProperty r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<RuntimeProperty> q2 = db.query(RuntimeProperty.class);
				q2.equals("identifier",entity.getIdentifier());
				List<RuntimeProperty> results = q2.find();
				for(RuntimeProperty r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<RuntimeProperty> q2 = db.query(RuntimeProperty.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<RuntimeProperty> results = q2.find();
				for(RuntimeProperty r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<RuntimeProperty> q2 = db.query(RuntimeProperty.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<RuntimeProperty> results = q2.find();
				for(RuntimeProperty r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<RuntimeProperty> q2 = db.query(RuntimeProperty.class);
				q2.equals("name",entity.getName());
				List<RuntimeProperty> results = q2.find();
				for(RuntimeProperty r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<RuntimeProperty> q2 = db.query(RuntimeProperty.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<RuntimeProperty> results = q2.find();
				for(RuntimeProperty r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<RuntimeProperty> q2 = db.query(RuntimeProperty.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<RuntimeProperty> results = q2.find();
				for(RuntimeProperty r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'Value', type 'string'
			{
				Query<RuntimeProperty> q2 = db.query(RuntimeProperty.class);
				q2.equals("value",entity.getValue());
				List<RuntimeProperty> results = q2.find();
				for(RuntimeProperty r: results)
				{
					assertEquals(r.getValue(),entity.getValue());
				}
			}
			//test operator 'in' for field 'Value'
			{
				Query<RuntimeProperty> q2 = db.query(RuntimeProperty.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getValue());
				q2.in("value", inList);
				List<RuntimeProperty> results = q2.find();
				for(RuntimeProperty r: results)
				{
					assertEquals(r.getValue(),entity.getValue());
				}
			}
			//test operator 'like' for field 'Value'
			{
				Query<RuntimeProperty> q2 = db.query(RuntimeProperty.class);
				q2.like("value", entity.getValue() + "%");
				q2.sortASC("value");
				List<RuntimeProperty> results = q2.find();
				for(RuntimeProperty r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getValue(), entity.getValue()));
				}
			}

		}
	}

	@Test
	public void testMolgenisRole() throws DatabaseException
	{
		//create entities
		List<MolgenisRole> entities = new ArrayList<MolgenisRole>();

		//retrieve xref entity candidates

		for(Integer i = 0; i < total; i++)
		{
			MolgenisRole e = new MolgenisRole();
			e.setName(truncate("molgenisrole_name_"+i, 255));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<MolgenisRole> q = db.query(MolgenisRole.class).eq("__Type",MolgenisRole.class.getSimpleName());
		assertEquals(total, q.count());
		List<MolgenisRole> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
		}	
		
		//test the query capabilities by finding on all fields
		for(MolgenisRole entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<MolgenisRole> q2 = db.query(MolgenisRole.class);
				q2.equals("id",entity.getId());
				List<MolgenisRole> results = q2.find();
				assertEquals(results.size(),1);
				for(MolgenisRole r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<MolgenisRole> q2 = db.query(MolgenisRole.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<MolgenisRole> results = q2.find();
				assertEquals(results.size(),1);
				for(MolgenisRole r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<MolgenisRole> q2 = db.query(MolgenisRole.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<MolgenisRole> results = q2.find();
				for(MolgenisRole r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<MolgenisRole> q2 = db.query(MolgenisRole.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<MolgenisRole> results = q2.find();
				for(MolgenisRole r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'name', type 'string'
			{
				Query<MolgenisRole> q2 = db.query(MolgenisRole.class);
				q2.equals("name",entity.getName());
				List<MolgenisRole> results = q2.find();
				for(MolgenisRole r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'name'
			{
				Query<MolgenisRole> q2 = db.query(MolgenisRole.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<MolgenisRole> results = q2.find();
				for(MolgenisRole r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'name'
			{
				Query<MolgenisRole> q2 = db.query(MolgenisRole.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<MolgenisRole> results = q2.find();
				for(MolgenisRole r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

		}
	}

	@Test
	public void testMolgenisGroup() throws DatabaseException
	{
		//create entities
		List<MolgenisGroup> entities = new ArrayList<MolgenisGroup>();

		//retrieve xref entity candidates

		for(Integer i = 0; i < total; i++)
		{
			MolgenisGroup e = new MolgenisGroup();
			e.setName(truncate("molgenisgroup_name_"+i, 255));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<MolgenisGroup> q = db.query(MolgenisGroup.class).eq("__Type",MolgenisGroup.class.getSimpleName());
		assertEquals(total, q.count());
		List<MolgenisGroup> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
		}	
		
		//test the query capabilities by finding on all fields
		for(MolgenisGroup entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<MolgenisGroup> q2 = db.query(MolgenisGroup.class);
				q2.equals("id",entity.getId());
				List<MolgenisGroup> results = q2.find();
				for(MolgenisGroup r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<MolgenisGroup> q2 = db.query(MolgenisGroup.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<MolgenisGroup> results = q2.find();
				for(MolgenisGroup r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<MolgenisGroup> q2 = db.query(MolgenisGroup.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<MolgenisGroup> results = q2.find();
				for(MolgenisGroup r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<MolgenisGroup> q2 = db.query(MolgenisGroup.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<MolgenisGroup> results = q2.find();
				for(MolgenisGroup r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'name', type 'string'
			{
				Query<MolgenisGroup> q2 = db.query(MolgenisGroup.class);
				q2.equals("name",entity.getName());
				List<MolgenisGroup> results = q2.find();
				for(MolgenisGroup r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'name'
			{
				Query<MolgenisGroup> q2 = db.query(MolgenisGroup.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<MolgenisGroup> results = q2.find();
				for(MolgenisGroup r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'name'
			{
				Query<MolgenisGroup> q2 = db.query(MolgenisGroup.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<MolgenisGroup> results = q2.find();
				for(MolgenisGroup r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

		}
	}

	@Test
	public void testMolgenisUser() throws DatabaseException
	{
		//create entities
		List<MolgenisUser> entities = new ArrayList<MolgenisUser>();

		//retrieve xref entity candidates

		for(Integer i = 0; i < total; i++)
		{
			MolgenisUser e = new MolgenisUser();
			e.setUsername(truncate("molgenisuser_username_"+i, 255));
			e.setPassword(truncate("molgenisuser_password__"+i, 255));
			e.setActivationCode(truncate("molgenisuser_activationcode_"+i, 255));
			e.setActive(randomBool(i));
			e.setSuperuser(randomBool(i));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<MolgenisUser> q = db.query(MolgenisUser.class);
		assertEquals(total, q.count());
		List<MolgenisUser> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getUsername(), entitiesDb.get(i).getUsername());
			assertEquals(entities.get(i).getPassword(), entitiesDb.get(i).getPassword());
			assertEquals(entities.get(i).getActivationCode(), entitiesDb.get(i).getActivationCode());
			assertEquals(entities.get(i).getActive(), entitiesDb.get(i).getActive());
			assertEquals(entities.get(i).getSuperuser(), entitiesDb.get(i).getSuperuser());
		}	
		
		//test the query capabilities by finding on all fields
		for(MolgenisUser entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.equals("id",entity.getId());
				List<MolgenisUser> results = q2.find();
				assertEquals(results.size(),1);
				for(MolgenisUser r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<MolgenisUser> results = q2.find();
				assertEquals(results.size(),1);
				for(MolgenisUser r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'username', type 'string'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.equals("username",entity.getUsername());
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getUsername(),entity.getUsername());
				}
			}
			//test operator 'in' for field 'username'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getUsername());
				q2.in("username", inList);
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getUsername(),entity.getUsername());
				}
			}
			//test operator 'like' for field 'username'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.like("username", entity.getUsername() + "%");
				q2.sortASC("username");
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getUsername(), entity.getUsername()));
				}
			}

			//test field 'password_', type 'string'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.equals("password_",entity.getPassword());
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getPassword(),entity.getPassword());
				}
			}
			//test operator 'in' for field 'password_'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getPassword());
				q2.in("password_", inList);
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getPassword(),entity.getPassword());
				}
			}
			//test operator 'like' for field 'password_'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.like("password_", entity.getPassword() + "%");
				q2.sortASC("password_");
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getPassword(), entity.getPassword()));
				}
			}

			//test field 'activationCode', type 'string'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.equals("activationCode",entity.getActivationCode());
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getActivationCode(),entity.getActivationCode());
				}
			}
			//test operator 'in' for field 'activationCode'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getActivationCode());
				q2.in("activationCode", inList);
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getActivationCode(),entity.getActivationCode());
				}
			}
			//test operator 'like' for field 'activationCode'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.like("activationCode", entity.getActivationCode() + "%");
				q2.sortASC("activationCode");
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getActivationCode(), entity.getActivationCode()));
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testMolgenisGroup","testMolgenisRole"})
	public void testMolgenisRoleGroupLink() throws DatabaseException
	{
		//create entities
		List<MolgenisRoleGroupLink> entities = new ArrayList<MolgenisRoleGroupLink>();

		//retrieve xref entity candidates
		List<MolgenisGroup> group_Xrefs = db.query(MolgenisGroup.class).eq("__Type",MolgenisGroup.class.getSimpleName()).find();	
		List<MolgenisRole> role_Xrefs = db.query(MolgenisRole.class).find();	

		for(Integer i = 0; i < total; i++)
		{
			MolgenisRoleGroupLink e = new MolgenisRoleGroupLink();
			e.setIdentifier(truncate("molgenisrolegrouplink_identifier_"+i, 255));
			e.setName(truncate("molgenisrolegrouplink_name_"+i, 255));
			if(group_Xrefs.size() > 0) e.setGroup_Id( group_Xrefs.get(i).getId() );
			if(role_Xrefs.size() > 0) e.setRole_Id( role_Xrefs.get(i).getId() );
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<MolgenisRoleGroupLink> q = db.query(MolgenisRoleGroupLink.class);
		assertEquals(total, q.count());
		List<MolgenisRoleGroupLink> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getGroup_Id(), entitiesDb.get(i).getGroup_Id());
			assertEquals(entities.get(i).getRole_Id(), entitiesDb.get(i).getRole_Id());
		}	
		
		//test the query capabilities by finding on all fields
		for(MolgenisRoleGroupLink entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<MolgenisRoleGroupLink> q2 = db.query(MolgenisRoleGroupLink.class);
				q2.equals("id",entity.getId());
				List<MolgenisRoleGroupLink> results = q2.find();
				for(MolgenisRoleGroupLink r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<MolgenisRoleGroupLink> q2 = db.query(MolgenisRoleGroupLink.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<MolgenisRoleGroupLink> results = q2.find();
				for(MolgenisRoleGroupLink r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<MolgenisRoleGroupLink> q2 = db.query(MolgenisRoleGroupLink.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<MolgenisRoleGroupLink> results = q2.find();
				for(MolgenisRoleGroupLink r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<MolgenisRoleGroupLink> q2 = db.query(MolgenisRoleGroupLink.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<MolgenisRoleGroupLink> results = q2.find();
				for(MolgenisRoleGroupLink r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<MolgenisRoleGroupLink> q2 = db.query(MolgenisRoleGroupLink.class);
				q2.equals("identifier",entity.getIdentifier());
				List<MolgenisRoleGroupLink> results = q2.find();
				for(MolgenisRoleGroupLink r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<MolgenisRoleGroupLink> q2 = db.query(MolgenisRoleGroupLink.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<MolgenisRoleGroupLink> results = q2.find();
				for(MolgenisRoleGroupLink r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<MolgenisRoleGroupLink> q2 = db.query(MolgenisRoleGroupLink.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<MolgenisRoleGroupLink> results = q2.find();
				for(MolgenisRoleGroupLink r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<MolgenisRoleGroupLink> q2 = db.query(MolgenisRoleGroupLink.class);
				q2.equals("name",entity.getName());
				List<MolgenisRoleGroupLink> results = q2.find();
				for(MolgenisRoleGroupLink r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<MolgenisRoleGroupLink> q2 = db.query(MolgenisRoleGroupLink.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<MolgenisRoleGroupLink> results = q2.find();
				for(MolgenisRoleGroupLink r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<MolgenisRoleGroupLink> q2 = db.query(MolgenisRoleGroupLink.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<MolgenisRoleGroupLink> results = q2.find();
				for(MolgenisRoleGroupLink r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'group_', type 'xref'
			{
				Query<MolgenisRoleGroupLink> q2 = db.query(MolgenisRoleGroupLink.class);
				q2.equals("group_",entity.getGroup_Id());
				List<MolgenisRoleGroupLink> results = q2.find();
				for(MolgenisRoleGroupLink r: results)
				{
					assertEquals(r.getGroup_Id(), entity.getGroup_Id());
				}
			}
			//test operator 'in' for field 'group_'
			{
				Query<MolgenisRoleGroupLink> q2 = db.query(MolgenisRoleGroupLink.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getGroup_Id());
				q2.in("group_", inList);
				List<MolgenisRoleGroupLink> results = q2.find();
				for(MolgenisRoleGroupLink r: results)
				{
					assertEquals(r.getGroup_Id(), entity.getGroup_Id());
				}
			}
			//test operator 'equals' for implicit join field 'group__name'
			{
				Query<MolgenisRoleGroupLink> q2 = db.query(MolgenisRoleGroupLink.class);
				q2.equals("group__name",entity.getGroup_Name());
				List<MolgenisRoleGroupLink> results = q2.find();
				for(MolgenisRoleGroupLink r: results)
				{
					assertEquals(r.getGroup_Id(), entity.getGroup_Id());
				}
			}
			//test operator 'in' for implicit join field 'group__name'
			{
				Query<MolgenisRoleGroupLink> q2 = db.query(MolgenisRoleGroupLink.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getGroup_Name());
				q2.in("group__name", inList);
				q2.sortDESC("group__name");
				List<MolgenisRoleGroupLink> results = q2.find();
				for(MolgenisRoleGroupLink r: results)
				{
					assertEquals(r.getGroup_Id(), entity.getGroup_Id());
				}
			}

			//test field 'role_', type 'xref'
			{
				Query<MolgenisRoleGroupLink> q2 = db.query(MolgenisRoleGroupLink.class);
				q2.equals("role_",entity.getRole_Id());
				List<MolgenisRoleGroupLink> results = q2.find();
				for(MolgenisRoleGroupLink r: results)
				{
					assertEquals(r.getRole_Id(), entity.getRole_Id());
				}
			}
			//test operator 'in' for field 'role_'
			{
				Query<MolgenisRoleGroupLink> q2 = db.query(MolgenisRoleGroupLink.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getRole_Id());
				q2.in("role_", inList);
				List<MolgenisRoleGroupLink> results = q2.find();
				for(MolgenisRoleGroupLink r: results)
				{
					assertEquals(r.getRole_Id(), entity.getRole_Id());
				}
			}
			//test operator 'equals' for implicit join field 'role__name'
			{
				Query<MolgenisRoleGroupLink> q2 = db.query(MolgenisRoleGroupLink.class);
				q2.equals("role__name",entity.getRole_Name());
				List<MolgenisRoleGroupLink> results = q2.find();
				for(MolgenisRoleGroupLink r: results)
				{
					assertEquals(r.getRole_Id(), entity.getRole_Id());
				}
			}
			//test operator 'in' for implicit join field 'role__name'
			{
				Query<MolgenisRoleGroupLink> q2 = db.query(MolgenisRoleGroupLink.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getRole_Name());
				q2.in("role__name", inList);
				q2.sortDESC("role__name");
				List<MolgenisRoleGroupLink> results = q2.find();
				for(MolgenisRoleGroupLink r: results)
				{
					assertEquals(r.getRole_Id(), entity.getRole_Id());
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testMolgenisRole","testMolgenisEntity"})
	public void testMolgenisPermission() throws DatabaseException
	{
		//create entities
		List<MolgenisPermission> entities = new ArrayList<MolgenisPermission>();

		//retrieve xref entity candidates
		List<MolgenisRole> role_Xrefs = db.query(MolgenisRole.class).find();	
		List<MolgenisEntity> entityXrefs = db.query(MolgenisEntity.class).find();	

		for(Integer i = 0; i < total; i++)
		{
			MolgenisPermission e = new MolgenisPermission();
			if(role_Xrefs.size() > 0) e.setRole_Id( role_Xrefs.get(i).getId() );
			if(entityXrefs.size() > 0) e.setEntity_Id( entityXrefs.get(i).getId() );
			e.setPermission(randomEnum(new String[]{"read","write","own"}));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<MolgenisPermission> q = db.query(MolgenisPermission.class);
		assertEquals(total, q.count());
		List<MolgenisPermission> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getRole_Id(), entitiesDb.get(i).getRole_Id());
			assertEquals(entities.get(i).getEntity_Id(), entitiesDb.get(i).getEntity_Id());
			assertEquals(entities.get(i).getPermission(), entitiesDb.get(i).getPermission());
		}	
		
		//test the query capabilities by finding on all fields
		for(MolgenisPermission entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<MolgenisPermission> q2 = db.query(MolgenisPermission.class);
				q2.equals("id",entity.getId());
				List<MolgenisPermission> results = q2.find();
				assertEquals(results.size(),1);
				for(MolgenisPermission r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<MolgenisPermission> q2 = db.query(MolgenisPermission.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<MolgenisPermission> results = q2.find();
				assertEquals(results.size(),1);
				for(MolgenisPermission r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<MolgenisPermission> q2 = db.query(MolgenisPermission.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<MolgenisPermission> results = q2.find();
				for(MolgenisPermission r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<MolgenisPermission> q2 = db.query(MolgenisPermission.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<MolgenisPermission> results = q2.find();
				for(MolgenisPermission r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'role_', type 'xref'
			{
				Query<MolgenisPermission> q2 = db.query(MolgenisPermission.class);
				q2.equals("role_",entity.getRole_Id());
				List<MolgenisPermission> results = q2.find();
				for(MolgenisPermission r: results)
				{
					assertEquals(r.getRole_Id(), entity.getRole_Id());
				}
			}
			//test operator 'in' for field 'role_'
			{
				Query<MolgenisPermission> q2 = db.query(MolgenisPermission.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getRole_Id());
				q2.in("role_", inList);
				List<MolgenisPermission> results = q2.find();
				for(MolgenisPermission r: results)
				{
					assertEquals(r.getRole_Id(), entity.getRole_Id());
				}
			}
			//test operator 'equals' for implicit join field 'role__name'
			{
				Query<MolgenisPermission> q2 = db.query(MolgenisPermission.class);
				q2.equals("role__name",entity.getRole_Name());
				List<MolgenisPermission> results = q2.find();
				for(MolgenisPermission r: results)
				{
					assertEquals(r.getRole_Id(), entity.getRole_Id());
				}
			}
			//test operator 'in' for implicit join field 'role__name'
			{
				Query<MolgenisPermission> q2 = db.query(MolgenisPermission.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getRole_Name());
				q2.in("role__name", inList);
				q2.sortDESC("role__name");
				List<MolgenisPermission> results = q2.find();
				for(MolgenisPermission r: results)
				{
					assertEquals(r.getRole_Id(), entity.getRole_Id());
				}
			}

			//test field 'entity', type 'xref'
			{
				Query<MolgenisPermission> q2 = db.query(MolgenisPermission.class);
				q2.equals("entity",entity.getEntity_Id());
				List<MolgenisPermission> results = q2.find();
				for(MolgenisPermission r: results)
				{
					assertEquals(r.getEntity_Id(), entity.getEntity_Id());
				}
			}
			//test operator 'in' for field 'entity'
			{
				Query<MolgenisPermission> q2 = db.query(MolgenisPermission.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getEntity_Id());
				q2.in("entity", inList);
				List<MolgenisPermission> results = q2.find();
				for(MolgenisPermission r: results)
				{
					assertEquals(r.getEntity_Id(), entity.getEntity_Id());
				}
			}
			//test operator 'equals' for implicit join field 'entity_className'
			{
				Query<MolgenisPermission> q2 = db.query(MolgenisPermission.class);
				q2.equals("entity_className",entity.getEntity_ClassName());
				List<MolgenisPermission> results = q2.find();
				for(MolgenisPermission r: results)
				{
					assertEquals(r.getEntity_Id(), entity.getEntity_Id());
				}
			}
			//test operator 'in' for implicit join field 'entity_className'
			{
				Query<MolgenisPermission> q2 = db.query(MolgenisPermission.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getEntity_ClassName());
				q2.in("entity_className", inList);
				q2.sortDESC("entity_className");
				List<MolgenisPermission> results = q2.find();
				for(MolgenisPermission r: results)
				{
					assertEquals(r.getEntity_Id(), entity.getEntity_Id());
				}
			}

		}
	}

	@Test
	public void testCharacteristic() throws DatabaseException
	{
		//create entities
		List<Characteristic> entities = new ArrayList<Characteristic>();

		//retrieve xref entity candidates

		for(Integer i = 0; i < total; i++)
		{
			Characteristic e = new Characteristic();
			e.setIdentifier(truncate("characteristic_identifier_"+i, 255));
			e.setName(truncate("characteristic_name_"+i, 255));
			e.setDescription("characteristic_description_"+i);
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<Characteristic> q = db.query(Characteristic.class).eq("__Type",Characteristic.class.getSimpleName());
		assertEquals(total, q.count());
		List<Characteristic> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
		}	
		
		//test the query capabilities by finding on all fields
		for(Characteristic entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<Characteristic> q2 = db.query(Characteristic.class);
				q2.equals("id",entity.getId());
				List<Characteristic> results = q2.find();
				for(Characteristic r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<Characteristic> q2 = db.query(Characteristic.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<Characteristic> results = q2.find();
				for(Characteristic r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<Characteristic> q2 = db.query(Characteristic.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<Characteristic> results = q2.find();
				for(Characteristic r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<Characteristic> q2 = db.query(Characteristic.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<Characteristic> results = q2.find();
				for(Characteristic r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<Characteristic> q2 = db.query(Characteristic.class);
				q2.equals("identifier",entity.getIdentifier());
				List<Characteristic> results = q2.find();
				for(Characteristic r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<Characteristic> q2 = db.query(Characteristic.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<Characteristic> results = q2.find();
				for(Characteristic r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<Characteristic> q2 = db.query(Characteristic.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<Characteristic> results = q2.find();
				for(Characteristic r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<Characteristic> q2 = db.query(Characteristic.class);
				q2.equals("name",entity.getName());
				List<Characteristic> results = q2.find();
				for(Characteristic r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<Characteristic> q2 = db.query(Characteristic.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<Characteristic> results = q2.find();
				for(Characteristic r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<Characteristic> q2 = db.query(Characteristic.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<Characteristic> results = q2.find();
				for(Characteristic r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'description', type 'text'
			{
				Query<Characteristic> q2 = db.query(Characteristic.class);
				q2.equals("description",entity.getDescription());
				List<Characteristic> results = q2.find();
				for(Characteristic r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'description'
			{
				Query<Characteristic> q2 = db.query(Characteristic.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<Characteristic> results = q2.find();
				for(Characteristic r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'description'
			{
				Query<Characteristic> q2 = db.query(Characteristic.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<Characteristic> results = q2.find();
				for(Characteristic r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

		}
	}

	@Test
	public void testObservationTarget() throws DatabaseException
	{
		//create entities
		List<ObservationTarget> entities = new ArrayList<ObservationTarget>();

		//retrieve xref entity candidates

		for(Integer i = 0; i < total; i++)
		{
			ObservationTarget e = new ObservationTarget();
			e.setIdentifier(truncate("observationtarget_identifier_"+i, 255));
			e.setName(truncate("observationtarget_name_"+i, 255));
			e.setDescription("observationtarget_description_"+i);
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<ObservationTarget> q = db.query(ObservationTarget.class).eq("__Type",ObservationTarget.class.getSimpleName());
		assertEquals(total, q.count());
		List<ObservationTarget> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
		}	
		
		//test the query capabilities by finding on all fields
		for(ObservationTarget entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<ObservationTarget> q2 = db.query(ObservationTarget.class);
				q2.equals("id",entity.getId());
				List<ObservationTarget> results = q2.find();
				for(ObservationTarget r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<ObservationTarget> q2 = db.query(ObservationTarget.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<ObservationTarget> results = q2.find();
				for(ObservationTarget r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<ObservationTarget> q2 = db.query(ObservationTarget.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<ObservationTarget> results = q2.find();
				for(ObservationTarget r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<ObservationTarget> q2 = db.query(ObservationTarget.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<ObservationTarget> results = q2.find();
				for(ObservationTarget r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<ObservationTarget> q2 = db.query(ObservationTarget.class);
				q2.equals("identifier",entity.getIdentifier());
				List<ObservationTarget> results = q2.find();
				for(ObservationTarget r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<ObservationTarget> q2 = db.query(ObservationTarget.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<ObservationTarget> results = q2.find();
				for(ObservationTarget r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<ObservationTarget> q2 = db.query(ObservationTarget.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<ObservationTarget> results = q2.find();
				for(ObservationTarget r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<ObservationTarget> q2 = db.query(ObservationTarget.class);
				q2.equals("name",entity.getName());
				List<ObservationTarget> results = q2.find();
				for(ObservationTarget r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<ObservationTarget> q2 = db.query(ObservationTarget.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<ObservationTarget> results = q2.find();
				for(ObservationTarget r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<ObservationTarget> q2 = db.query(ObservationTarget.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<ObservationTarget> results = q2.find();
				for(ObservationTarget r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'description', type 'text'
			{
				Query<ObservationTarget> q2 = db.query(ObservationTarget.class);
				q2.equals("description",entity.getDescription());
				List<ObservationTarget> results = q2.find();
				for(ObservationTarget r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'description'
			{
				Query<ObservationTarget> q2 = db.query(ObservationTarget.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<ObservationTarget> results = q2.find();
				for(ObservationTarget r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'description'
			{
				Query<ObservationTarget> q2 = db.query(ObservationTarget.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<ObservationTarget> results = q2.find();
				for(ObservationTarget r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

		}
	}

	@Test
	public void testIndividual() throws DatabaseException
	{
		//create entities
		List<Individual> entities = new ArrayList<Individual>();

		//retrieve xref entity candidates
		List<Individual> motherXrefs = db.query(Individual.class).eq("__Type",Individual.class.getSimpleName()).find();	
		List<Individual> fatherXrefs = db.query(Individual.class).eq("__Type",Individual.class.getSimpleName()).find();	

		for(Integer i = 0; i < total; i++)
		{
			Individual e = new Individual();
			e.setIdentifier(truncate("individual_identifier_"+i, 255));
			e.setName(truncate("individual_name_"+i, 255));
			e.setDescription("individual_description_"+i);
			if(motherXrefs.size() > 0) e.setMother_Id( motherXrefs.get(i).getId() );
			if(fatherXrefs.size() > 0) e.setFather_Id( fatherXrefs.get(i).getId() );
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<Individual> q = db.query(Individual.class).eq("__Type",Individual.class.getSimpleName());
		assertEquals(total, q.count());
		List<Individual> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			assertEquals(entities.get(i).getMother_Id(), entitiesDb.get(i).getMother_Id());
			assertEquals(entities.get(i).getFather_Id(), entitiesDb.get(i).getFather_Id());
		}	
		
		//test the query capabilities by finding on all fields
		for(Individual entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<Individual> q2 = db.query(Individual.class);
				q2.equals("id",entity.getId());
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<Individual> q2 = db.query(Individual.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<Individual> q2 = db.query(Individual.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<Individual> q2 = db.query(Individual.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<Individual> q2 = db.query(Individual.class);
				q2.equals("identifier",entity.getIdentifier());
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<Individual> q2 = db.query(Individual.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<Individual> q2 = db.query(Individual.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<Individual> q2 = db.query(Individual.class);
				q2.equals("name",entity.getName());
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<Individual> q2 = db.query(Individual.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<Individual> q2 = db.query(Individual.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'description', type 'text'
			{
				Query<Individual> q2 = db.query(Individual.class);
				q2.equals("description",entity.getDescription());
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'description'
			{
				Query<Individual> q2 = db.query(Individual.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'description'
			{
				Query<Individual> q2 = db.query(Individual.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

			//test field 'Mother', type 'xref'
			{
				Query<Individual> q2 = db.query(Individual.class);
				q2.equals("mother",entity.getMother_Id());
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertEquals(r.getMother_Id(), entity.getMother_Id());
				}
			}
			//test operator 'in' for field 'Mother'
			{
				Query<Individual> q2 = db.query(Individual.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getMother_Id());
				q2.in("mother", inList);
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertEquals(r.getMother_Id(), entity.getMother_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Mother_Identifier'
			{
				Query<Individual> q2 = db.query(Individual.class);
				q2.equals("mother_Identifier",entity.getMother_Identifier());
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertEquals(r.getMother_Id(), entity.getMother_Id());
				}
			}
			//test operator 'in' for implicit join field 'Mother_Identifier'
			{
				Query<Individual> q2 = db.query(Individual.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getMother_Identifier());
				q2.in("mother_Identifier", inList);
				q2.sortDESC("mother_Identifier");
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertEquals(r.getMother_Id(), entity.getMother_Id());
				}
			}

			//test field 'Father', type 'xref'
			{
				Query<Individual> q2 = db.query(Individual.class);
				q2.equals("father",entity.getFather_Id());
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertEquals(r.getFather_Id(), entity.getFather_Id());
				}
			}
			//test operator 'in' for field 'Father'
			{
				Query<Individual> q2 = db.query(Individual.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getFather_Id());
				q2.in("father", inList);
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertEquals(r.getFather_Id(), entity.getFather_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Father_Identifier'
			{
				Query<Individual> q2 = db.query(Individual.class);
				q2.equals("father_Identifier",entity.getFather_Identifier());
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertEquals(r.getFather_Id(), entity.getFather_Id());
				}
			}
			//test operator 'in' for implicit join field 'Father_Identifier'
			{
				Query<Individual> q2 = db.query(Individual.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getFather_Identifier());
				q2.in("father_Identifier", inList);
				q2.sortDESC("father_Identifier");
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertEquals(r.getFather_Id(), entity.getFather_Id());
				}
			}

		}
	}

	@Test
	public void testOntology() throws DatabaseException
	{
		//create entities
		List<Ontology> entities = new ArrayList<Ontology>();

		//retrieve xref entity candidates

		for(Integer i = 0; i < total; i++)
		{
			Ontology e = new Ontology();
			e.setIdentifier(truncate("ontology_identifier_"+i, 255));
			e.setName(truncate("ontology_name_"+i, 255));
			e.setOntologyAccession(truncate("ontology_ontologyaccession_"+i, 255));
			e.setOntologyURI("ontology_ontologyuri_"+i);
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<Ontology> q = db.query(Ontology.class);
		assertEquals(total, q.count());
		List<Ontology> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getOntologyAccession(), entitiesDb.get(i).getOntologyAccession());
			assertEquals(entities.get(i).getOntologyURI(), entitiesDb.get(i).getOntologyURI());
		}	
		
		//test the query capabilities by finding on all fields
		for(Ontology entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<Ontology> q2 = db.query(Ontology.class);
				q2.equals("id",entity.getId());
				List<Ontology> results = q2.find();
				for(Ontology r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<Ontology> q2 = db.query(Ontology.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<Ontology> results = q2.find();
				for(Ontology r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<Ontology> q2 = db.query(Ontology.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<Ontology> results = q2.find();
				for(Ontology r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<Ontology> q2 = db.query(Ontology.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<Ontology> results = q2.find();
				for(Ontology r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<Ontology> q2 = db.query(Ontology.class);
				q2.equals("identifier",entity.getIdentifier());
				List<Ontology> results = q2.find();
				for(Ontology r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<Ontology> q2 = db.query(Ontology.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<Ontology> results = q2.find();
				for(Ontology r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<Ontology> q2 = db.query(Ontology.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<Ontology> results = q2.find();
				for(Ontology r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<Ontology> q2 = db.query(Ontology.class);
				q2.equals("name",entity.getName());
				List<Ontology> results = q2.find();
				for(Ontology r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<Ontology> q2 = db.query(Ontology.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<Ontology> results = q2.find();
				for(Ontology r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<Ontology> q2 = db.query(Ontology.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<Ontology> results = q2.find();
				for(Ontology r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'ontologyAccession', type 'string'
			{
				Query<Ontology> q2 = db.query(Ontology.class);
				q2.equals("ontologyAccession",entity.getOntologyAccession());
				List<Ontology> results = q2.find();
				for(Ontology r: results)
				{
					assertEquals(r.getOntologyAccession(),entity.getOntologyAccession());
				}
			}
			//test operator 'in' for field 'ontologyAccession'
			{
				Query<Ontology> q2 = db.query(Ontology.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getOntologyAccession());
				q2.in("ontologyAccession", inList);
				List<Ontology> results = q2.find();
				for(Ontology r: results)
				{
					assertEquals(r.getOntologyAccession(),entity.getOntologyAccession());
				}
			}
			//test operator 'like' for field 'ontologyAccession'
			{
				Query<Ontology> q2 = db.query(Ontology.class);
				q2.like("ontologyAccession", entity.getOntologyAccession() + "%");
				q2.sortASC("ontologyAccession");
				List<Ontology> results = q2.find();
				for(Ontology r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getOntologyAccession(), entity.getOntologyAccession()));
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testOntology"})
	public void testSpecies() throws DatabaseException
	{
		//create entities
		List<Species> entities = new ArrayList<Species>();

		//retrieve xref entity candidates
		List<Ontology> ontologyXrefs = db.query(Ontology.class).find();	

		for(Integer i = 0; i < total; i++)
		{
			Species e = new Species();
			e.setIdentifier(truncate("species_identifier_"+i, 255));
			e.setName(truncate("species_name_"+i, 255));
			if(ontologyXrefs.size() > 0) e.setOntology_Id( ontologyXrefs.get(i).getId() );
			e.setTermAccession(truncate("species_termaccession_"+i, 255));
			e.setDefinition(truncate("species_definition_"+i, 255));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<Species> q = db.query(Species.class).eq("__Type",Species.class.getSimpleName());
		assertEquals(total, q.count());
		List<Species> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getOntology_Id(), entitiesDb.get(i).getOntology_Id());
			assertEquals(entities.get(i).getTermAccession(), entitiesDb.get(i).getTermAccession());
			assertEquals(entities.get(i).getDefinition(), entitiesDb.get(i).getDefinition());
		}	
		
		//test the query capabilities by finding on all fields
		for(Species entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<Species> q2 = db.query(Species.class);
				q2.equals("id",entity.getId());
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<Species> q2 = db.query(Species.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<Species> q2 = db.query(Species.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<Species> q2 = db.query(Species.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<Species> q2 = db.query(Species.class);
				q2.equals("identifier",entity.getIdentifier());
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<Species> q2 = db.query(Species.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<Species> q2 = db.query(Species.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<Species> q2 = db.query(Species.class);
				q2.equals("name",entity.getName());
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<Species> q2 = db.query(Species.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<Species> q2 = db.query(Species.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'ontology', type 'xref'
			{
				Query<Species> q2 = db.query(Species.class);
				q2.equals("ontology",entity.getOntology_Id());
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertEquals(r.getOntology_Id(), entity.getOntology_Id());
				}
			}
			//test operator 'in' for field 'ontology'
			{
				Query<Species> q2 = db.query(Species.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getOntology_Id());
				q2.in("ontology", inList);
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertEquals(r.getOntology_Id(), entity.getOntology_Id());
				}
			}
			//test operator 'equals' for implicit join field 'ontology_Identifier'
			{
				Query<Species> q2 = db.query(Species.class);
				q2.equals("ontology_Identifier",entity.getOntology_Identifier());
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertEquals(r.getOntology_Id(), entity.getOntology_Id());
				}
			}
			//test operator 'in' for implicit join field 'ontology_Identifier'
			{
				Query<Species> q2 = db.query(Species.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getOntology_Identifier());
				q2.in("ontology_Identifier", inList);
				q2.sortDESC("ontology_Identifier");
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertEquals(r.getOntology_Id(), entity.getOntology_Id());
				}
			}

			//test field 'termAccession', type 'string'
			{
				Query<Species> q2 = db.query(Species.class);
				q2.equals("termAccession",entity.getTermAccession());
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertEquals(r.getTermAccession(),entity.getTermAccession());
				}
			}
			//test operator 'in' for field 'termAccession'
			{
				Query<Species> q2 = db.query(Species.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getTermAccession());
				q2.in("termAccession", inList);
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertEquals(r.getTermAccession(),entity.getTermAccession());
				}
			}
			//test operator 'like' for field 'termAccession'
			{
				Query<Species> q2 = db.query(Species.class);
				q2.like("termAccession", entity.getTermAccession() + "%");
				q2.sortASC("termAccession");
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getTermAccession(), entity.getTermAccession()));
				}
			}

			//test field 'definition', type 'string'
			{
				Query<Species> q2 = db.query(Species.class);
				q2.equals("definition",entity.getDefinition());
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertEquals(r.getDefinition(),entity.getDefinition());
				}
			}
			//test operator 'in' for field 'definition'
			{
				Query<Species> q2 = db.query(Species.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDefinition());
				q2.in("definition", inList);
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertEquals(r.getDefinition(),entity.getDefinition());
				}
			}
			//test operator 'like' for field 'definition'
			{
				Query<Species> q2 = db.query(Species.class);
				q2.like("definition", entity.getDefinition() + "%");
				q2.sortASC("definition");
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDefinition(), entity.getDefinition()));
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testOntology"})
	public void testOntologyTerm() throws DatabaseException
	{
		//create entities
		List<OntologyTerm> entities = new ArrayList<OntologyTerm>();

		//retrieve xref entity candidates
		List<Ontology> ontologyXrefs = db.query(Ontology.class).find();	

		for(Integer i = 0; i < total; i++)
		{
			OntologyTerm e = new OntologyTerm();
			e.setIdentifier(truncate("ontologyterm_identifier_"+i, 255));
			e.setName(truncate("ontologyterm_name_"+i, 255));
			if(ontologyXrefs.size() > 0) e.setOntology_Id( ontologyXrefs.get(i).getId() );
			e.setTermAccession(truncate("ontologyterm_termaccession_"+i, 255));
			e.setDefinition(truncate("ontologyterm_definition_"+i, 255));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<OntologyTerm> q = db.query(OntologyTerm.class).eq("__Type",OntologyTerm.class.getSimpleName());
		assertEquals(total, q.count());
		List<OntologyTerm> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getOntology_Id(), entitiesDb.get(i).getOntology_Id());
			assertEquals(entities.get(i).getTermAccession(), entitiesDb.get(i).getTermAccession());
			assertEquals(entities.get(i).getDefinition(), entitiesDb.get(i).getDefinition());
		}	
		
		//test the query capabilities by finding on all fields
		for(OntologyTerm entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				q2.equals("id",entity.getId());
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				q2.equals("identifier",entity.getIdentifier());
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				q2.equals("name",entity.getName());
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'ontology', type 'xref'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				q2.equals("ontology",entity.getOntology_Id());
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertEquals(r.getOntology_Id(), entity.getOntology_Id());
				}
			}
			//test operator 'in' for field 'ontology'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getOntology_Id());
				q2.in("ontology", inList);
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertEquals(r.getOntology_Id(), entity.getOntology_Id());
				}
			}
			//test operator 'equals' for implicit join field 'ontology_Identifier'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				q2.equals("ontology_Identifier",entity.getOntology_Identifier());
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertEquals(r.getOntology_Id(), entity.getOntology_Id());
				}
			}
			//test operator 'in' for implicit join field 'ontology_Identifier'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getOntology_Identifier());
				q2.in("ontology_Identifier", inList);
				q2.sortDESC("ontology_Identifier");
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertEquals(r.getOntology_Id(), entity.getOntology_Id());
				}
			}

			//test field 'termAccession', type 'string'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				q2.equals("termAccession",entity.getTermAccession());
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertEquals(r.getTermAccession(),entity.getTermAccession());
				}
			}
			//test operator 'in' for field 'termAccession'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getTermAccession());
				q2.in("termAccession", inList);
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertEquals(r.getTermAccession(),entity.getTermAccession());
				}
			}
			//test operator 'like' for field 'termAccession'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				q2.like("termAccession", entity.getTermAccession() + "%");
				q2.sortASC("termAccession");
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getTermAccession(), entity.getTermAccession()));
				}
			}

			//test field 'definition', type 'string'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				q2.equals("definition",entity.getDefinition());
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertEquals(r.getDefinition(),entity.getDefinition());
				}
			}
			//test operator 'in' for field 'definition'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDefinition());
				q2.in("definition", inList);
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertEquals(r.getDefinition(),entity.getDefinition());
				}
			}
			//test operator 'like' for field 'definition'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				q2.like("definition", entity.getDefinition() + "%");
				q2.sortASC("definition");
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDefinition(), entity.getDefinition()));
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testOntology"})
	public void testAccession() throws DatabaseException
	{
		//create entities
		List<Accession> entities = new ArrayList<Accession>();

		//retrieve xref entity candidates
		List<Ontology> ontologyXrefs = db.query(Ontology.class).find();	

		for(Integer i = 0; i < total; i++)
		{
			Accession e = new Accession();
			e.setIdentifier(truncate("accession_identifier_"+i, 255));
			e.setName(truncate("accession_name_"+i, 255));
			if(ontologyXrefs.size() > 0) e.setOntology_Id( ontologyXrefs.get(i).getId() );
			e.setTermAccession(truncate("accession_termaccession_"+i, 255));
			e.setDefinition(truncate("accession_definition_"+i, 255));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<Accession> q = db.query(Accession.class).eq("__Type",Accession.class.getSimpleName());
		assertEquals(total, q.count());
		List<Accession> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getOntology_Id(), entitiesDb.get(i).getOntology_Id());
			assertEquals(entities.get(i).getTermAccession(), entitiesDb.get(i).getTermAccession());
			assertEquals(entities.get(i).getDefinition(), entitiesDb.get(i).getDefinition());
		}	
		
		//test the query capabilities by finding on all fields
		for(Accession entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<Accession> q2 = db.query(Accession.class);
				q2.equals("id",entity.getId());
				List<Accession> results = q2.find();
				for(Accession r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<Accession> q2 = db.query(Accession.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<Accession> results = q2.find();
				for(Accession r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<Accession> q2 = db.query(Accession.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<Accession> results = q2.find();
				for(Accession r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<Accession> q2 = db.query(Accession.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<Accession> results = q2.find();
				for(Accession r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<Accession> q2 = db.query(Accession.class);
				q2.equals("identifier",entity.getIdentifier());
				List<Accession> results = q2.find();
				for(Accession r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<Accession> q2 = db.query(Accession.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<Accession> results = q2.find();
				for(Accession r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<Accession> q2 = db.query(Accession.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<Accession> results = q2.find();
				for(Accession r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<Accession> q2 = db.query(Accession.class);
				q2.equals("name",entity.getName());
				List<Accession> results = q2.find();
				for(Accession r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<Accession> q2 = db.query(Accession.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<Accession> results = q2.find();
				for(Accession r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<Accession> q2 = db.query(Accession.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<Accession> results = q2.find();
				for(Accession r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'ontology', type 'xref'
			{
				Query<Accession> q2 = db.query(Accession.class);
				q2.equals("ontology",entity.getOntology_Id());
				List<Accession> results = q2.find();
				for(Accession r: results)
				{
					assertEquals(r.getOntology_Id(), entity.getOntology_Id());
				}
			}
			//test operator 'in' for field 'ontology'
			{
				Query<Accession> q2 = db.query(Accession.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getOntology_Id());
				q2.in("ontology", inList);
				List<Accession> results = q2.find();
				for(Accession r: results)
				{
					assertEquals(r.getOntology_Id(), entity.getOntology_Id());
				}
			}
			//test operator 'equals' for implicit join field 'ontology_Identifier'
			{
				Query<Accession> q2 = db.query(Accession.class);
				q2.equals("ontology_Identifier",entity.getOntology_Identifier());
				List<Accession> results = q2.find();
				for(Accession r: results)
				{
					assertEquals(r.getOntology_Id(), entity.getOntology_Id());
				}
			}
			//test operator 'in' for implicit join field 'ontology_Identifier'
			{
				Query<Accession> q2 = db.query(Accession.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getOntology_Identifier());
				q2.in("ontology_Identifier", inList);
				q2.sortDESC("ontology_Identifier");
				List<Accession> results = q2.find();
				for(Accession r: results)
				{
					assertEquals(r.getOntology_Id(), entity.getOntology_Id());
				}
			}

			//test field 'termAccession', type 'string'
			{
				Query<Accession> q2 = db.query(Accession.class);
				q2.equals("termAccession",entity.getTermAccession());
				List<Accession> results = q2.find();
				for(Accession r: results)
				{
					assertEquals(r.getTermAccession(),entity.getTermAccession());
				}
			}
			//test operator 'in' for field 'termAccession'
			{
				Query<Accession> q2 = db.query(Accession.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getTermAccession());
				q2.in("termAccession", inList);
				List<Accession> results = q2.find();
				for(Accession r: results)
				{
					assertEquals(r.getTermAccession(),entity.getTermAccession());
				}
			}
			//test operator 'like' for field 'termAccession'
			{
				Query<Accession> q2 = db.query(Accession.class);
				q2.like("termAccession", entity.getTermAccession() + "%");
				q2.sortASC("termAccession");
				List<Accession> results = q2.find();
				for(Accession r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getTermAccession(), entity.getTermAccession()));
				}
			}

			//test field 'definition', type 'string'
			{
				Query<Accession> q2 = db.query(Accession.class);
				q2.equals("definition",entity.getDefinition());
				List<Accession> results = q2.find();
				for(Accession r: results)
				{
					assertEquals(r.getDefinition(),entity.getDefinition());
				}
			}
			//test operator 'in' for field 'definition'
			{
				Query<Accession> q2 = db.query(Accession.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDefinition());
				q2.in("definition", inList);
				List<Accession> results = q2.find();
				for(Accession r: results)
				{
					assertEquals(r.getDefinition(),entity.getDefinition());
				}
			}
			//test operator 'like' for field 'definition'
			{
				Query<Accession> q2 = db.query(Accession.class);
				q2.like("definition", entity.getDefinition() + "%");
				q2.sortASC("definition");
				List<Accession> results = q2.find();
				for(Accession r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDefinition(), entity.getDefinition()));
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testOntologyTerm"})
	public void testObservableFeature() throws DatabaseException
	{
		//create entities
		List<ObservableFeature> entities = new ArrayList<ObservableFeature>();

		//retrieve xref entity candidates
		List<OntologyTerm> unitXrefs = db.query(OntologyTerm.class).find();	

		for(Integer i = 0; i < total; i++)
		{
			ObservableFeature e = new ObservableFeature();
			e.setIdentifier(truncate("observablefeature_identifier_"+i, 255));
			e.setName(truncate("observablefeature_name_"+i, 255));
			e.setDescription("observablefeature_description_"+i);
			if(unitXrefs.size() > 0) e.setUnit_Id( unitXrefs.get(i).getId() );
			e.setDataType(randomEnum(new String[]{"xref","string","categorical","nominal","ordinal","date","datetime","int","code","image","decimal","bool","file","log","data","exe"}));
			e.setTemporal(randomBool(i));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<ObservableFeature> q = db.query(ObservableFeature.class).eq("__Type",ObservableFeature.class.getSimpleName());
		assertEquals(total, q.count());
		List<ObservableFeature> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			assertEquals(entities.get(i).getUnit_Id(), entitiesDb.get(i).getUnit_Id());
			assertEquals(entities.get(i).getDataType(), entitiesDb.get(i).getDataType());
			assertEquals(entities.get(i).getTemporal(), entitiesDb.get(i).getTemporal());
		}	
		
		//test the query capabilities by finding on all fields
		for(ObservableFeature entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<ObservableFeature> q2 = db.query(ObservableFeature.class);
				q2.equals("id",entity.getId());
				List<ObservableFeature> results = q2.find();
				for(ObservableFeature r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<ObservableFeature> q2 = db.query(ObservableFeature.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<ObservableFeature> results = q2.find();
				for(ObservableFeature r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<ObservableFeature> q2 = db.query(ObservableFeature.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<ObservableFeature> results = q2.find();
				for(ObservableFeature r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<ObservableFeature> q2 = db.query(ObservableFeature.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<ObservableFeature> results = q2.find();
				for(ObservableFeature r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<ObservableFeature> q2 = db.query(ObservableFeature.class);
				q2.equals("identifier",entity.getIdentifier());
				List<ObservableFeature> results = q2.find();
				for(ObservableFeature r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<ObservableFeature> q2 = db.query(ObservableFeature.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<ObservableFeature> results = q2.find();
				for(ObservableFeature r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<ObservableFeature> q2 = db.query(ObservableFeature.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<ObservableFeature> results = q2.find();
				for(ObservableFeature r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<ObservableFeature> q2 = db.query(ObservableFeature.class);
				q2.equals("name",entity.getName());
				List<ObservableFeature> results = q2.find();
				for(ObservableFeature r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<ObservableFeature> q2 = db.query(ObservableFeature.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<ObservableFeature> results = q2.find();
				for(ObservableFeature r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<ObservableFeature> q2 = db.query(ObservableFeature.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<ObservableFeature> results = q2.find();
				for(ObservableFeature r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'description', type 'text'
			{
				Query<ObservableFeature> q2 = db.query(ObservableFeature.class);
				q2.equals("description",entity.getDescription());
				List<ObservableFeature> results = q2.find();
				for(ObservableFeature r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'description'
			{
				Query<ObservableFeature> q2 = db.query(ObservableFeature.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<ObservableFeature> results = q2.find();
				for(ObservableFeature r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'description'
			{
				Query<ObservableFeature> q2 = db.query(ObservableFeature.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<ObservableFeature> results = q2.find();
				for(ObservableFeature r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

			//test field 'unit', type 'xref'
			{
				Query<ObservableFeature> q2 = db.query(ObservableFeature.class);
				q2.equals("unit",entity.getUnit_Id());
				List<ObservableFeature> results = q2.find();
				for(ObservableFeature r: results)
				{
					assertEquals(r.getUnit_Id(), entity.getUnit_Id());
				}
			}
			//test operator 'in' for field 'unit'
			{
				Query<ObservableFeature> q2 = db.query(ObservableFeature.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getUnit_Id());
				q2.in("unit", inList);
				List<ObservableFeature> results = q2.find();
				for(ObservableFeature r: results)
				{
					assertEquals(r.getUnit_Id(), entity.getUnit_Id());
				}
			}
			//test operator 'equals' for implicit join field 'unit_Identifier'
			{
				Query<ObservableFeature> q2 = db.query(ObservableFeature.class);
				q2.equals("unit_Identifier",entity.getUnit_Identifier());
				List<ObservableFeature> results = q2.find();
				for(ObservableFeature r: results)
				{
					assertEquals(r.getUnit_Id(), entity.getUnit_Id());
				}
			}
			//test operator 'in' for implicit join field 'unit_Identifier'
			{
				Query<ObservableFeature> q2 = db.query(ObservableFeature.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getUnit_Identifier());
				q2.in("unit_Identifier", inList);
				q2.sortDESC("unit_Identifier");
				List<ObservableFeature> results = q2.find();
				for(ObservableFeature r: results)
				{
					assertEquals(r.getUnit_Id(), entity.getUnit_Id());
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testOntologyTerm"})
	public void testProtocol() throws DatabaseException
	{
		//create entities
		List<Protocol> entities = new ArrayList<Protocol>();

		//retrieve xref entity candidates
		List<OntologyTerm> protocolTypeXrefs = db.query(OntologyTerm.class).find();	
		List<Protocol> subprotocolsXrefs = db.query(Protocol.class).eq("__Type",Protocol.class.getSimpleName()).find();	
		List<ObservableFeature> featuresXrefs = db.query(ObservableFeature.class).eq("__Type",ObservableFeature.class.getSimpleName()).find();	

		for(Integer i = 0; i < total; i++)
		{
			Protocol e = new Protocol();
			e.setIdentifier(truncate("protocol_identifier_"+i, 255));
			e.setName(truncate("protocol_name_"+i, 255));
			e.setDescription("protocol_description_"+i);
			if(protocolTypeXrefs.size() > 0) e.setProtocolType_Id( protocolTypeXrefs.get(i).getId() );
			if(subprotocolsXrefs.size() > 0)
			{
				e.getSubprotocols_Id().add( subprotocolsXrefs.get(i).getId() );
				//e.getSubprotocols().add( random(subprotocolsXrefs).getId() );
			}
			if(featuresXrefs.size() > 0)
			{
				e.getFeatures_Id().add( featuresXrefs.get(i).getId() );
				//e.getFeatures().add( random(featuresXrefs).getId() );
			}
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<Protocol> q = db.query(Protocol.class).eq("__Type",Protocol.class.getSimpleName());
		assertEquals(total, q.count());
		List<Protocol> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			assertEquals(entities.get(i).getProtocolType_Id(), entitiesDb.get(i).getProtocolType_Id());
			assertEquals(entities.get(i).getSubprotocols_Id(), entitiesDb.get(i).getSubprotocols_Id());
			assertEquals(entities.get(i).getFeatures_Id(), entitiesDb.get(i).getFeatures_Id());
		}	
		
		//test the query capabilities by finding on all fields
		for(Protocol entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				q2.equals("id",entity.getId());
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				q2.equals("identifier",entity.getIdentifier());
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				q2.equals("name",entity.getName());
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'description', type 'text'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				q2.equals("description",entity.getDescription());
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'description'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'description'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

			//test field 'ProtocolType', type 'xref'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				q2.equals("protocolType",entity.getProtocolType_Id());
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertEquals(r.getProtocolType_Id(), entity.getProtocolType_Id());
				}
			}
			//test operator 'in' for field 'ProtocolType'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getProtocolType_Id());
				q2.in("protocolType", inList);
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertEquals(r.getProtocolType_Id(), entity.getProtocolType_Id());
				}
			}
			//test operator 'equals' for implicit join field 'ProtocolType_Identifier'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				q2.equals("protocolType_Identifier",entity.getProtocolType_Identifier());
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertEquals(r.getProtocolType_Id(), entity.getProtocolType_Id());
				}
			}
			//test operator 'in' for implicit join field 'ProtocolType_Identifier'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getProtocolType_Identifier());
				q2.in("protocolType_Identifier", inList);
				q2.sortDESC("protocolType_Identifier");
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertEquals(r.getProtocolType_Id(), entity.getProtocolType_Id());
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testProtocol"})
	public void testDataSet() throws DatabaseException
	{
		//create entities
		List<DataSet> entities = new ArrayList<DataSet>();

		//retrieve xref entity candidates
		List<Protocol> protocolUsedXrefs = db.query(Protocol.class).eq("__Type",Protocol.class.getSimpleName()).find();	

		for(Integer i = 0; i < total; i++)
		{
			DataSet e = new DataSet();
			e.setIdentifier(truncate("dataset_identifier_"+i, 255));
			e.setName(truncate("dataset_name_"+i, 255));
			e.setDescription("dataset_description_"+i);
			if(protocolUsedXrefs.size() > 0) e.setProtocolUsed_Id( protocolUsedXrefs.get(i).getId() );
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<DataSet> q = db.query(DataSet.class).eq("__Type",DataSet.class.getSimpleName());
		assertEquals(total, q.count());
		List<DataSet> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			assertEquals(entities.get(i).getProtocolUsed_Id(), entitiesDb.get(i).getProtocolUsed_Id());
		}	
		
		//test the query capabilities by finding on all fields
		for(DataSet entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<DataSet> q2 = db.query(DataSet.class);
				q2.equals("id",entity.getId());
				List<DataSet> results = q2.find();
				for(DataSet r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<DataSet> q2 = db.query(DataSet.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<DataSet> results = q2.find();
				for(DataSet r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<DataSet> q2 = db.query(DataSet.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<DataSet> results = q2.find();
				for(DataSet r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<DataSet> q2 = db.query(DataSet.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<DataSet> results = q2.find();
				for(DataSet r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<DataSet> q2 = db.query(DataSet.class);
				q2.equals("identifier",entity.getIdentifier());
				List<DataSet> results = q2.find();
				for(DataSet r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<DataSet> q2 = db.query(DataSet.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<DataSet> results = q2.find();
				for(DataSet r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<DataSet> q2 = db.query(DataSet.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<DataSet> results = q2.find();
				for(DataSet r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<DataSet> q2 = db.query(DataSet.class);
				q2.equals("name",entity.getName());
				List<DataSet> results = q2.find();
				for(DataSet r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<DataSet> q2 = db.query(DataSet.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<DataSet> results = q2.find();
				for(DataSet r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<DataSet> q2 = db.query(DataSet.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<DataSet> results = q2.find();
				for(DataSet r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'description', type 'text'
			{
				Query<DataSet> q2 = db.query(DataSet.class);
				q2.equals("description",entity.getDescription());
				List<DataSet> results = q2.find();
				for(DataSet r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'description'
			{
				Query<DataSet> q2 = db.query(DataSet.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<DataSet> results = q2.find();
				for(DataSet r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'description'
			{
				Query<DataSet> q2 = db.query(DataSet.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<DataSet> results = q2.find();
				for(DataSet r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

			//test field 'ProtocolUsed', type 'xref'
			{
				Query<DataSet> q2 = db.query(DataSet.class);
				q2.equals("protocolUsed",entity.getProtocolUsed_Id());
				List<DataSet> results = q2.find();
				for(DataSet r: results)
				{
					assertEquals(r.getProtocolUsed_Id(), entity.getProtocolUsed_Id());
				}
			}
			//test operator 'in' for field 'ProtocolUsed'
			{
				Query<DataSet> q2 = db.query(DataSet.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getProtocolUsed_Id());
				q2.in("protocolUsed", inList);
				List<DataSet> results = q2.find();
				for(DataSet r: results)
				{
					assertEquals(r.getProtocolUsed_Id(), entity.getProtocolUsed_Id());
				}
			}
			//test operator 'equals' for implicit join field 'ProtocolUsed_Identifier'
			{
				Query<DataSet> q2 = db.query(DataSet.class);
				q2.equals("protocolUsed_Identifier",entity.getProtocolUsed_Identifier());
				List<DataSet> results = q2.find();
				for(DataSet r: results)
				{
					assertEquals(r.getProtocolUsed_Id(), entity.getProtocolUsed_Id());
				}
			}
			//test operator 'in' for implicit join field 'ProtocolUsed_Identifier'
			{
				Query<DataSet> q2 = db.query(DataSet.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getProtocolUsed_Identifier());
				q2.in("protocolUsed_Identifier", inList);
				q2.sortDESC("protocolUsed_Identifier");
				List<DataSet> results = q2.find();
				for(DataSet r: results)
				{
					assertEquals(r.getProtocolUsed_Id(), entity.getProtocolUsed_Id());
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testOntologyTerm","testSpecies"})
	public void testPanel() throws DatabaseException
	{
		//create entities
		List<Panel> entities = new ArrayList<Panel>();

		//retrieve xref entity candidates
		List<OntologyTerm> panelTypeXrefs = db.query(OntologyTerm.class).find();	
		List<Species> speciesXrefs = db.query(Species.class).eq("__Type",Species.class.getSimpleName()).find();	
		List<Individual> individualsXrefs = db.query(Individual.class).eq("__Type",Individual.class.getSimpleName()).find();	

		for(Integer i = 0; i < total; i++)
		{
			Panel e = new Panel();
			e.setIdentifier(truncate("panel_identifier_"+i, 255));
			e.setName(truncate("panel_name_"+i, 255));
			e.setDescription("panel_description_"+i);
			if(panelTypeXrefs.size() > 0) e.setPanelType_Id( panelTypeXrefs.get(i).getId() );
			e.setNumberOfIndividuals(i);
			if(speciesXrefs.size() > 0) e.setSpecies_Id( speciesXrefs.get(i).getId() );
			if(individualsXrefs.size() > 0)
			{
				e.getIndividuals_Id().add( individualsXrefs.get(i).getId() );
				//e.getIndividuals().add( random(individualsXrefs).getId() );
			}
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<Panel> q = db.query(Panel.class).eq("__Type",Panel.class.getSimpleName());
		assertEquals(total, q.count());
		List<Panel> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			assertEquals(entities.get(i).getPanelType_Id(), entitiesDb.get(i).getPanelType_Id());
			assertEquals(entities.get(i).getNumberOfIndividuals(), entitiesDb.get(i).getNumberOfIndividuals());
			assertEquals(entities.get(i).getSpecies_Id(), entitiesDb.get(i).getSpecies_Id());
			assertEquals(entities.get(i).getIndividuals_Id(), entitiesDb.get(i).getIndividuals_Id());
		}	
		
		//test the query capabilities by finding on all fields
		for(Panel entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<Panel> q2 = db.query(Panel.class);
				q2.equals("id",entity.getId());
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<Panel> q2 = db.query(Panel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<Panel> q2 = db.query(Panel.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<Panel> q2 = db.query(Panel.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<Panel> q2 = db.query(Panel.class);
				q2.equals("identifier",entity.getIdentifier());
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<Panel> q2 = db.query(Panel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<Panel> q2 = db.query(Panel.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<Panel> q2 = db.query(Panel.class);
				q2.equals("name",entity.getName());
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<Panel> q2 = db.query(Panel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<Panel> q2 = db.query(Panel.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'description', type 'text'
			{
				Query<Panel> q2 = db.query(Panel.class);
				q2.equals("description",entity.getDescription());
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'description'
			{
				Query<Panel> q2 = db.query(Panel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'description'
			{
				Query<Panel> q2 = db.query(Panel.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

			//test field 'PanelType', type 'xref'
			{
				Query<Panel> q2 = db.query(Panel.class);
				q2.equals("panelType",entity.getPanelType_Id());
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getPanelType_Id(), entity.getPanelType_Id());
				}
			}
			//test operator 'in' for field 'PanelType'
			{
				Query<Panel> q2 = db.query(Panel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getPanelType_Id());
				q2.in("panelType", inList);
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getPanelType_Id(), entity.getPanelType_Id());
				}
			}
			//test operator 'equals' for implicit join field 'PanelType_Identifier'
			{
				Query<Panel> q2 = db.query(Panel.class);
				q2.equals("panelType_Identifier",entity.getPanelType_Identifier());
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getPanelType_Id(), entity.getPanelType_Id());
				}
			}
			//test operator 'in' for implicit join field 'PanelType_Identifier'
			{
				Query<Panel> q2 = db.query(Panel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getPanelType_Identifier());
				q2.in("panelType_Identifier", inList);
				q2.sortDESC("panelType_Identifier");
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getPanelType_Id(), entity.getPanelType_Id());
				}
			}

			//test field 'NumberOfIndividuals', type 'int'
			{
				Query<Panel> q2 = db.query(Panel.class);
				q2.equals("numberOfIndividuals",entity.getNumberOfIndividuals());
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getNumberOfIndividuals(),entity.getNumberOfIndividuals());
				}
			}
			//test operator 'in' for field 'NumberOfIndividuals'
			{
				Query<Panel> q2 = db.query(Panel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getNumberOfIndividuals());
				q2.in("numberOfIndividuals", inList);
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getNumberOfIndividuals(),entity.getNumberOfIndividuals());
				}
			}
			//test operator 'lessOrEqual' for field 'NumberOfIndividuals'
			{
				Query<Panel> q2 = db.query(Panel.class);
				q2.lessOrEqual("numberOfIndividuals", entity.getNumberOfIndividuals());
				q2.sortASC("numberOfIndividuals");
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertTrue(r.getNumberOfIndividuals().compareTo(entity.getNumberOfIndividuals()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'NumberOfIndividuals'
			{
				Query<Panel> q2 = db.query(Panel.class);
				q2.greaterOrEqual("numberOfIndividuals", entity.getNumberOfIndividuals());
				q2.sortDESC("numberOfIndividuals");
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertTrue(r.getNumberOfIndividuals().compareTo(entity.getNumberOfIndividuals()) > -1);
				}
			}

			//test field 'Species', type 'xref'
			{
				Query<Panel> q2 = db.query(Panel.class);
				q2.equals("species",entity.getSpecies_Id());
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getSpecies_Id(), entity.getSpecies_Id());
				}
			}
			//test operator 'in' for field 'Species'
			{
				Query<Panel> q2 = db.query(Panel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getSpecies_Id());
				q2.in("species", inList);
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getSpecies_Id(), entity.getSpecies_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Species_Identifier'
			{
				Query<Panel> q2 = db.query(Panel.class);
				q2.equals("species_Identifier",entity.getSpecies_Identifier());
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getSpecies_Id(), entity.getSpecies_Id());
				}
			}
			//test operator 'in' for implicit join field 'Species_Identifier'
			{
				Query<Panel> q2 = db.query(Panel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getSpecies_Identifier());
				q2.in("species_Identifier", inList);
				q2.sortDESC("species_Identifier");
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getSpecies_Id(), entity.getSpecies_Id());
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testSpecies"})
	public void testGenome() throws DatabaseException
	{
		//create entities
		List<Genome> entities = new ArrayList<Genome>();

		//retrieve xref entity candidates
		List<Species> speciesXrefs = db.query(Species.class).eq("__Type",Species.class.getSimpleName()).find();	

		for(Integer i = 0; i < total; i++)
		{
			Genome e = new Genome();
			e.setIdentifier(truncate("genome_identifier_"+i, 255));
			e.setName(truncate("genome_name_"+i, 255));
			e.setDescription("genome_description_"+i);
			e.setResidues("genome_residues_"+i);
			e.setSeqlen(i);
			if(speciesXrefs.size() > 0) e.setSpecies_Id( speciesXrefs.get(i).getId() );
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<Genome> q = db.query(Genome.class).eq("__Type",Genome.class.getSimpleName());
		assertEquals(total, q.count());
		List<Genome> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			assertEquals(entities.get(i).getResidues(), entitiesDb.get(i).getResidues());
			assertEquals(entities.get(i).getSeqlen(), entitiesDb.get(i).getSeqlen());
			assertEquals(entities.get(i).getSpecies_Id(), entitiesDb.get(i).getSpecies_Id());
		}	
		
		//test the query capabilities by finding on all fields
		for(Genome entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<Genome> q2 = db.query(Genome.class);
				q2.equals("id",entity.getId());
				List<Genome> results = q2.find();
				for(Genome r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<Genome> q2 = db.query(Genome.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<Genome> results = q2.find();
				for(Genome r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<Genome> q2 = db.query(Genome.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<Genome> results = q2.find();
				for(Genome r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<Genome> q2 = db.query(Genome.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<Genome> results = q2.find();
				for(Genome r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<Genome> q2 = db.query(Genome.class);
				q2.equals("identifier",entity.getIdentifier());
				List<Genome> results = q2.find();
				for(Genome r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<Genome> q2 = db.query(Genome.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<Genome> results = q2.find();
				for(Genome r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<Genome> q2 = db.query(Genome.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<Genome> results = q2.find();
				for(Genome r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<Genome> q2 = db.query(Genome.class);
				q2.equals("name",entity.getName());
				List<Genome> results = q2.find();
				for(Genome r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<Genome> q2 = db.query(Genome.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<Genome> results = q2.find();
				for(Genome r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<Genome> q2 = db.query(Genome.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<Genome> results = q2.find();
				for(Genome r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'description', type 'text'
			{
				Query<Genome> q2 = db.query(Genome.class);
				q2.equals("description",entity.getDescription());
				List<Genome> results = q2.find();
				for(Genome r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'description'
			{
				Query<Genome> q2 = db.query(Genome.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<Genome> results = q2.find();
				for(Genome r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'description'
			{
				Query<Genome> q2 = db.query(Genome.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<Genome> results = q2.find();
				for(Genome r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

			//test field 'residues', type 'text'
			{
				Query<Genome> q2 = db.query(Genome.class);
				q2.equals("residues",entity.getResidues());
				List<Genome> results = q2.find();
				for(Genome r: results)
				{
					assertEquals(r.getResidues(),entity.getResidues());
				}
			}
			//test operator 'in' for field 'residues'
			{
				Query<Genome> q2 = db.query(Genome.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getResidues());
				q2.in("residues", inList);
				List<Genome> results = q2.find();
				for(Genome r: results)
				{
					assertEquals(r.getResidues(),entity.getResidues());
				}
			}
			//test operator 'like' for field 'residues'
			{
				Query<Genome> q2 = db.query(Genome.class);
				q2.like("residues", entity.getResidues() + "%");
				q2.sortASC("residues");
				List<Genome> results = q2.find();
				for(Genome r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getResidues(), entity.getResidues()));
				}
			}

			//test field 'seqlen', type 'int'
			{
				Query<Genome> q2 = db.query(Genome.class);
				q2.equals("seqlen",entity.getSeqlen());
				List<Genome> results = q2.find();
				for(Genome r: results)
				{
					assertEquals(r.getSeqlen(),entity.getSeqlen());
				}
			}
			//test operator 'in' for field 'seqlen'
			{
				Query<Genome> q2 = db.query(Genome.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getSeqlen());
				q2.in("seqlen", inList);
				List<Genome> results = q2.find();
				for(Genome r: results)
				{
					assertEquals(r.getSeqlen(),entity.getSeqlen());
				}
			}
			//test operator 'lessOrEqual' for field 'seqlen'
			{
				Query<Genome> q2 = db.query(Genome.class);
				q2.lessOrEqual("seqlen", entity.getSeqlen());
				q2.sortASC("seqlen");
				List<Genome> results = q2.find();
				for(Genome r: results)
				{
					assertTrue(r.getSeqlen().compareTo(entity.getSeqlen()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'seqlen'
			{
				Query<Genome> q2 = db.query(Genome.class);
				q2.greaterOrEqual("seqlen", entity.getSeqlen());
				q2.sortDESC("seqlen");
				List<Genome> results = q2.find();
				for(Genome r: results)
				{
					assertTrue(r.getSeqlen().compareTo(entity.getSeqlen()) > -1);
				}
			}

			//test field 'species', type 'xref'
			{
				Query<Genome> q2 = db.query(Genome.class);
				q2.equals("species",entity.getSpecies_Id());
				List<Genome> results = q2.find();
				for(Genome r: results)
				{
					assertEquals(r.getSpecies_Id(), entity.getSpecies_Id());
				}
			}
			//test operator 'in' for field 'species'
			{
				Query<Genome> q2 = db.query(Genome.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getSpecies_Id());
				q2.in("species", inList);
				List<Genome> results = q2.find();
				for(Genome r: results)
				{
					assertEquals(r.getSpecies_Id(), entity.getSpecies_Id());
				}
			}
			//test operator 'equals' for implicit join field 'species_Identifier'
			{
				Query<Genome> q2 = db.query(Genome.class);
				q2.equals("species_Identifier",entity.getSpecies_Identifier());
				List<Genome> results = q2.find();
				for(Genome r: results)
				{
					assertEquals(r.getSpecies_Id(), entity.getSpecies_Id());
				}
			}
			//test operator 'in' for implicit join field 'species_Identifier'
			{
				Query<Genome> q2 = db.query(Genome.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getSpecies_Identifier());
				q2.in("species_Identifier", inList);
				q2.sortDESC("species_Identifier");
				List<Genome> results = q2.find();
				for(Genome r: results)
				{
					assertEquals(r.getSpecies_Id(), entity.getSpecies_Id());
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testGenome"})
	public void testChromosome() throws DatabaseException
	{
		//create entities
		List<Chromosome> entities = new ArrayList<Chromosome>();

		//retrieve xref entity candidates
		List<Genome> genomeXrefs = db.query(Genome.class).eq("__Type",Genome.class.getSimpleName()).find();	

		for(Integer i = 0; i < total; i++)
		{
			Chromosome e = new Chromosome();
			e.setIdentifier(truncate("chromosome_identifier_"+i, 255));
			e.setName(truncate("chromosome_name_"+i, 255));
			e.setDescription("chromosome_description_"+i);
			e.setResidues("chromosome_residues_"+i);
			e.setSeqlen(i);
			if(genomeXrefs.size() > 0) e.setGenome_Id( genomeXrefs.get(i).getId() );
			e.setOrderNr(i);
			e.setIsAutosomal(randomBool(i));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<Chromosome> q = db.query(Chromosome.class).eq("__Type",Chromosome.class.getSimpleName());
		assertEquals(total, q.count());
		List<Chromosome> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			assertEquals(entities.get(i).getResidues(), entitiesDb.get(i).getResidues());
			assertEquals(entities.get(i).getSeqlen(), entitiesDb.get(i).getSeqlen());
			assertEquals(entities.get(i).getGenome_Id(), entitiesDb.get(i).getGenome_Id());
			assertEquals(entities.get(i).getOrderNr(), entitiesDb.get(i).getOrderNr());
			assertEquals(entities.get(i).getIsAutosomal(), entitiesDb.get(i).getIsAutosomal());
		}	
		
		//test the query capabilities by finding on all fields
		for(Chromosome entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<Chromosome> q2 = db.query(Chromosome.class);
				q2.equals("id",entity.getId());
				List<Chromosome> results = q2.find();
				for(Chromosome r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<Chromosome> q2 = db.query(Chromosome.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<Chromosome> results = q2.find();
				for(Chromosome r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<Chromosome> q2 = db.query(Chromosome.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<Chromosome> results = q2.find();
				for(Chromosome r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<Chromosome> q2 = db.query(Chromosome.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<Chromosome> results = q2.find();
				for(Chromosome r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<Chromosome> q2 = db.query(Chromosome.class);
				q2.equals("identifier",entity.getIdentifier());
				List<Chromosome> results = q2.find();
				for(Chromosome r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<Chromosome> q2 = db.query(Chromosome.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<Chromosome> results = q2.find();
				for(Chromosome r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<Chromosome> q2 = db.query(Chromosome.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<Chromosome> results = q2.find();
				for(Chromosome r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<Chromosome> q2 = db.query(Chromosome.class);
				q2.equals("name",entity.getName());
				List<Chromosome> results = q2.find();
				for(Chromosome r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<Chromosome> q2 = db.query(Chromosome.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<Chromosome> results = q2.find();
				for(Chromosome r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<Chromosome> q2 = db.query(Chromosome.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<Chromosome> results = q2.find();
				for(Chromosome r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'description', type 'text'
			{
				Query<Chromosome> q2 = db.query(Chromosome.class);
				q2.equals("description",entity.getDescription());
				List<Chromosome> results = q2.find();
				for(Chromosome r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'description'
			{
				Query<Chromosome> q2 = db.query(Chromosome.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<Chromosome> results = q2.find();
				for(Chromosome r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'description'
			{
				Query<Chromosome> q2 = db.query(Chromosome.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<Chromosome> results = q2.find();
				for(Chromosome r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

			//test field 'residues', type 'text'
			{
				Query<Chromosome> q2 = db.query(Chromosome.class);
				q2.equals("residues",entity.getResidues());
				List<Chromosome> results = q2.find();
				for(Chromosome r: results)
				{
					assertEquals(r.getResidues(),entity.getResidues());
				}
			}
			//test operator 'in' for field 'residues'
			{
				Query<Chromosome> q2 = db.query(Chromosome.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getResidues());
				q2.in("residues", inList);
				List<Chromosome> results = q2.find();
				for(Chromosome r: results)
				{
					assertEquals(r.getResidues(),entity.getResidues());
				}
			}
			//test operator 'like' for field 'residues'
			{
				Query<Chromosome> q2 = db.query(Chromosome.class);
				q2.like("residues", entity.getResidues() + "%");
				q2.sortASC("residues");
				List<Chromosome> results = q2.find();
				for(Chromosome r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getResidues(), entity.getResidues()));
				}
			}

			//test field 'seqlen', type 'int'
			{
				Query<Chromosome> q2 = db.query(Chromosome.class);
				q2.equals("seqlen",entity.getSeqlen());
				List<Chromosome> results = q2.find();
				for(Chromosome r: results)
				{
					assertEquals(r.getSeqlen(),entity.getSeqlen());
				}
			}
			//test operator 'in' for field 'seqlen'
			{
				Query<Chromosome> q2 = db.query(Chromosome.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getSeqlen());
				q2.in("seqlen", inList);
				List<Chromosome> results = q2.find();
				for(Chromosome r: results)
				{
					assertEquals(r.getSeqlen(),entity.getSeqlen());
				}
			}
			//test operator 'lessOrEqual' for field 'seqlen'
			{
				Query<Chromosome> q2 = db.query(Chromosome.class);
				q2.lessOrEqual("seqlen", entity.getSeqlen());
				q2.sortASC("seqlen");
				List<Chromosome> results = q2.find();
				for(Chromosome r: results)
				{
					assertTrue(r.getSeqlen().compareTo(entity.getSeqlen()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'seqlen'
			{
				Query<Chromosome> q2 = db.query(Chromosome.class);
				q2.greaterOrEqual("seqlen", entity.getSeqlen());
				q2.sortDESC("seqlen");
				List<Chromosome> results = q2.find();
				for(Chromosome r: results)
				{
					assertTrue(r.getSeqlen().compareTo(entity.getSeqlen()) > -1);
				}
			}

			//test field 'genome', type 'xref'
			{
				Query<Chromosome> q2 = db.query(Chromosome.class);
				q2.equals("genome",entity.getGenome_Id());
				List<Chromosome> results = q2.find();
				for(Chromosome r: results)
				{
					assertEquals(r.getGenome_Id(), entity.getGenome_Id());
				}
			}
			//test operator 'in' for field 'genome'
			{
				Query<Chromosome> q2 = db.query(Chromosome.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getGenome_Id());
				q2.in("genome", inList);
				List<Chromosome> results = q2.find();
				for(Chromosome r: results)
				{
					assertEquals(r.getGenome_Id(), entity.getGenome_Id());
				}
			}
			//test operator 'equals' for implicit join field 'genome_Identifier'
			{
				Query<Chromosome> q2 = db.query(Chromosome.class);
				q2.equals("genome_Identifier",entity.getGenome_Identifier());
				List<Chromosome> results = q2.find();
				for(Chromosome r: results)
				{
					assertEquals(r.getGenome_Id(), entity.getGenome_Id());
				}
			}
			//test operator 'in' for implicit join field 'genome_Identifier'
			{
				Query<Chromosome> q2 = db.query(Chromosome.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getGenome_Identifier());
				q2.in("genome_Identifier", inList);
				q2.sortDESC("genome_Identifier");
				List<Chromosome> results = q2.find();
				for(Chromosome r: results)
				{
					assertEquals(r.getGenome_Id(), entity.getGenome_Id());
				}
			}

			//test field 'orderNr', type 'int'
			{
				Query<Chromosome> q2 = db.query(Chromosome.class);
				q2.equals("orderNr",entity.getOrderNr());
				List<Chromosome> results = q2.find();
				for(Chromosome r: results)
				{
					assertEquals(r.getOrderNr(),entity.getOrderNr());
				}
			}
			//test operator 'in' for field 'orderNr'
			{
				Query<Chromosome> q2 = db.query(Chromosome.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getOrderNr());
				q2.in("orderNr", inList);
				List<Chromosome> results = q2.find();
				for(Chromosome r: results)
				{
					assertEquals(r.getOrderNr(),entity.getOrderNr());
				}
			}
			//test operator 'lessOrEqual' for field 'orderNr'
			{
				Query<Chromosome> q2 = db.query(Chromosome.class);
				q2.lessOrEqual("orderNr", entity.getOrderNr());
				q2.sortASC("orderNr");
				List<Chromosome> results = q2.find();
				for(Chromosome r: results)
				{
					assertTrue(r.getOrderNr().compareTo(entity.getOrderNr()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'orderNr'
			{
				Query<Chromosome> q2 = db.query(Chromosome.class);
				q2.greaterOrEqual("orderNr", entity.getOrderNr());
				q2.sortDESC("orderNr");
				List<Chromosome> results = q2.find();
				for(Chromosome r: results)
				{
					assertTrue(r.getOrderNr().compareTo(entity.getOrderNr()) > -1);
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testChromosome"})
	public void testGene() throws DatabaseException
	{
		//create entities
		List<Gene> entities = new ArrayList<Gene>();

		//retrieve xref entity candidates
		List<Chromosome> gdnaXrefs = db.query(Chromosome.class).eq("__Type",Chromosome.class.getSimpleName()).find();	

		for(Integer i = 0; i < total; i++)
		{
			Gene e = new Gene();
			e.setIdentifier(truncate("gene_identifier_"+i, 255));
			e.setName(truncate("gene_name_"+i, 255));
			e.setDescription("gene_description_"+i);
			if(gdnaXrefs.size() > 0) e.setGdna_Id( gdnaXrefs.get(i).getId() );
			e.setGdna_Start(i);
			e.setGdna_End(i);
			e.setResidues("gene_residues_"+i);
			e.setSeqlen(i);
			e.setStrand(randomEnum(new String[]{"0","-1","+1"}));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<Gene> q = db.query(Gene.class).eq("__Type",Gene.class.getSimpleName());
		assertEquals(total, q.count());
		List<Gene> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			assertEquals(entities.get(i).getGdna_Id(), entitiesDb.get(i).getGdna_Id());
			assertEquals(entities.get(i).getGdna_Start(), entitiesDb.get(i).getGdna_Start());
			assertEquals(entities.get(i).getGdna_End(), entitiesDb.get(i).getGdna_End());
			assertEquals(entities.get(i).getResidues(), entitiesDb.get(i).getResidues());
			assertEquals(entities.get(i).getSeqlen(), entitiesDb.get(i).getSeqlen());
			assertEquals(entities.get(i).getStrand(), entitiesDb.get(i).getStrand());
		}	
		
		//test the query capabilities by finding on all fields
		for(Gene entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<Gene> q2 = db.query(Gene.class);
				q2.equals("id",entity.getId());
				List<Gene> results = q2.find();
				for(Gene r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<Gene> q2 = db.query(Gene.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<Gene> results = q2.find();
				for(Gene r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<Gene> q2 = db.query(Gene.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<Gene> results = q2.find();
				for(Gene r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<Gene> q2 = db.query(Gene.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<Gene> results = q2.find();
				for(Gene r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<Gene> q2 = db.query(Gene.class);
				q2.equals("identifier",entity.getIdentifier());
				List<Gene> results = q2.find();
				for(Gene r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<Gene> q2 = db.query(Gene.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<Gene> results = q2.find();
				for(Gene r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<Gene> q2 = db.query(Gene.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<Gene> results = q2.find();
				for(Gene r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<Gene> q2 = db.query(Gene.class);
				q2.equals("name",entity.getName());
				List<Gene> results = q2.find();
				for(Gene r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<Gene> q2 = db.query(Gene.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<Gene> results = q2.find();
				for(Gene r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<Gene> q2 = db.query(Gene.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<Gene> results = q2.find();
				for(Gene r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'description', type 'text'
			{
				Query<Gene> q2 = db.query(Gene.class);
				q2.equals("description",entity.getDescription());
				List<Gene> results = q2.find();
				for(Gene r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'description'
			{
				Query<Gene> q2 = db.query(Gene.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<Gene> results = q2.find();
				for(Gene r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'description'
			{
				Query<Gene> q2 = db.query(Gene.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<Gene> results = q2.find();
				for(Gene r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

			//test field 'gdna', type 'xref'
			{
				Query<Gene> q2 = db.query(Gene.class);
				q2.equals("gdna",entity.getGdna_Id());
				List<Gene> results = q2.find();
				for(Gene r: results)
				{
					assertEquals(r.getGdna_Id(), entity.getGdna_Id());
				}
			}
			//test operator 'in' for field 'gdna'
			{
				Query<Gene> q2 = db.query(Gene.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getGdna_Id());
				q2.in("gdna", inList);
				List<Gene> results = q2.find();
				for(Gene r: results)
				{
					assertEquals(r.getGdna_Id(), entity.getGdna_Id());
				}
			}
			//test operator 'equals' for implicit join field 'gdna_Identifier'
			{
				Query<Gene> q2 = db.query(Gene.class);
				q2.equals("gdna_Identifier",entity.getGdna_Identifier());
				List<Gene> results = q2.find();
				for(Gene r: results)
				{
					assertEquals(r.getGdna_Id(), entity.getGdna_Id());
				}
			}
			//test operator 'in' for implicit join field 'gdna_Identifier'
			{
				Query<Gene> q2 = db.query(Gene.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getGdna_Identifier());
				q2.in("gdna_Identifier", inList);
				q2.sortDESC("gdna_Identifier");
				List<Gene> results = q2.find();
				for(Gene r: results)
				{
					assertEquals(r.getGdna_Id(), entity.getGdna_Id());
				}
			}

			//test field 'gdna_start', type 'int'
			{
				Query<Gene> q2 = db.query(Gene.class);
				q2.equals("gdna_start",entity.getGdna_Start());
				List<Gene> results = q2.find();
				for(Gene r: results)
				{
					assertEquals(r.getGdna_Start(),entity.getGdna_Start());
				}
			}
			//test operator 'in' for field 'gdna_start'
			{
				Query<Gene> q2 = db.query(Gene.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getGdna_Start());
				q2.in("gdna_start", inList);
				List<Gene> results = q2.find();
				for(Gene r: results)
				{
					assertEquals(r.getGdna_Start(),entity.getGdna_Start());
				}
			}
			//test operator 'lessOrEqual' for field 'gdna_start'
			{
				Query<Gene> q2 = db.query(Gene.class);
				q2.lessOrEqual("gdna_start", entity.getGdna_Start());
				q2.sortASC("gdna_start");
				List<Gene> results = q2.find();
				for(Gene r: results)
				{
					assertTrue(r.getGdna_Start().compareTo(entity.getGdna_Start()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'gdna_start'
			{
				Query<Gene> q2 = db.query(Gene.class);
				q2.greaterOrEqual("gdna_start", entity.getGdna_Start());
				q2.sortDESC("gdna_start");
				List<Gene> results = q2.find();
				for(Gene r: results)
				{
					assertTrue(r.getGdna_Start().compareTo(entity.getGdna_Start()) > -1);
				}
			}

			//test field 'gdna_end', type 'int'
			{
				Query<Gene> q2 = db.query(Gene.class);
				q2.equals("gdna_end",entity.getGdna_End());
				List<Gene> results = q2.find();
				for(Gene r: results)
				{
					assertEquals(r.getGdna_End(),entity.getGdna_End());
				}
			}
			//test operator 'in' for field 'gdna_end'
			{
				Query<Gene> q2 = db.query(Gene.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getGdna_End());
				q2.in("gdna_end", inList);
				List<Gene> results = q2.find();
				for(Gene r: results)
				{
					assertEquals(r.getGdna_End(),entity.getGdna_End());
				}
			}
			//test operator 'lessOrEqual' for field 'gdna_end'
			{
				Query<Gene> q2 = db.query(Gene.class);
				q2.lessOrEqual("gdna_end", entity.getGdna_End());
				q2.sortASC("gdna_end");
				List<Gene> results = q2.find();
				for(Gene r: results)
				{
					assertTrue(r.getGdna_End().compareTo(entity.getGdna_End()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'gdna_end'
			{
				Query<Gene> q2 = db.query(Gene.class);
				q2.greaterOrEqual("gdna_end", entity.getGdna_End());
				q2.sortDESC("gdna_end");
				List<Gene> results = q2.find();
				for(Gene r: results)
				{
					assertTrue(r.getGdna_End().compareTo(entity.getGdna_End()) > -1);
				}
			}

			//test field 'residues', type 'text'
			{
				Query<Gene> q2 = db.query(Gene.class);
				q2.equals("residues",entity.getResidues());
				List<Gene> results = q2.find();
				for(Gene r: results)
				{
					assertEquals(r.getResidues(),entity.getResidues());
				}
			}
			//test operator 'in' for field 'residues'
			{
				Query<Gene> q2 = db.query(Gene.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getResidues());
				q2.in("residues", inList);
				List<Gene> results = q2.find();
				for(Gene r: results)
				{
					assertEquals(r.getResidues(),entity.getResidues());
				}
			}
			//test operator 'like' for field 'residues'
			{
				Query<Gene> q2 = db.query(Gene.class);
				q2.like("residues", entity.getResidues() + "%");
				q2.sortASC("residues");
				List<Gene> results = q2.find();
				for(Gene r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getResidues(), entity.getResidues()));
				}
			}

			//test field 'seqlen', type 'int'
			{
				Query<Gene> q2 = db.query(Gene.class);
				q2.equals("seqlen",entity.getSeqlen());
				List<Gene> results = q2.find();
				for(Gene r: results)
				{
					assertEquals(r.getSeqlen(),entity.getSeqlen());
				}
			}
			//test operator 'in' for field 'seqlen'
			{
				Query<Gene> q2 = db.query(Gene.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getSeqlen());
				q2.in("seqlen", inList);
				List<Gene> results = q2.find();
				for(Gene r: results)
				{
					assertEquals(r.getSeqlen(),entity.getSeqlen());
				}
			}
			//test operator 'lessOrEqual' for field 'seqlen'
			{
				Query<Gene> q2 = db.query(Gene.class);
				q2.lessOrEqual("seqlen", entity.getSeqlen());
				q2.sortASC("seqlen");
				List<Gene> results = q2.find();
				for(Gene r: results)
				{
					assertTrue(r.getSeqlen().compareTo(entity.getSeqlen()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'seqlen'
			{
				Query<Gene> q2 = db.query(Gene.class);
				q2.greaterOrEqual("seqlen", entity.getSeqlen());
				q2.sortDESC("seqlen");
				List<Gene> results = q2.find();
				for(Gene r: results)
				{
					assertTrue(r.getSeqlen().compareTo(entity.getSeqlen()) > -1);
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testGene"})
	public void testProtein() throws DatabaseException
	{
		//create entities
		List<Protein> entities = new ArrayList<Protein>();

		//retrieve xref entity candidates
		List<Gene> cdnaXrefs = db.query(Gene.class).eq("__Type",Gene.class.getSimpleName()).find();	

		for(Integer i = 0; i < total; i++)
		{
			Protein e = new Protein();
			e.setIdentifier(truncate("protein_identifier_"+i, 255));
			e.setName(truncate("protein_name_"+i, 255));
			e.setDescription("protein_description_"+i);
			if(cdnaXrefs.size() > 0) e.setCdna_Id( cdnaXrefs.get(i).getId() );
			e.setCdna_Start(i);
			e.setCdna_End(i);
			e.setResidues("protein_residues_"+i);
			e.setSeqlen(i);
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<Protein> q = db.query(Protein.class).eq("__Type",Protein.class.getSimpleName());
		assertEquals(total, q.count());
		List<Protein> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			assertEquals(entities.get(i).getCdna_Id(), entitiesDb.get(i).getCdna_Id());
			assertEquals(entities.get(i).getCdna_Start(), entitiesDb.get(i).getCdna_Start());
			assertEquals(entities.get(i).getCdna_End(), entitiesDb.get(i).getCdna_End());
			assertEquals(entities.get(i).getResidues(), entitiesDb.get(i).getResidues());
			assertEquals(entities.get(i).getSeqlen(), entitiesDb.get(i).getSeqlen());
		}	
		
		//test the query capabilities by finding on all fields
		for(Protein entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<Protein> q2 = db.query(Protein.class);
				q2.equals("id",entity.getId());
				List<Protein> results = q2.find();
				for(Protein r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<Protein> q2 = db.query(Protein.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<Protein> results = q2.find();
				for(Protein r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<Protein> q2 = db.query(Protein.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<Protein> results = q2.find();
				for(Protein r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<Protein> q2 = db.query(Protein.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<Protein> results = q2.find();
				for(Protein r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<Protein> q2 = db.query(Protein.class);
				q2.equals("identifier",entity.getIdentifier());
				List<Protein> results = q2.find();
				for(Protein r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<Protein> q2 = db.query(Protein.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<Protein> results = q2.find();
				for(Protein r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<Protein> q2 = db.query(Protein.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<Protein> results = q2.find();
				for(Protein r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<Protein> q2 = db.query(Protein.class);
				q2.equals("name",entity.getName());
				List<Protein> results = q2.find();
				for(Protein r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<Protein> q2 = db.query(Protein.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<Protein> results = q2.find();
				for(Protein r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<Protein> q2 = db.query(Protein.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<Protein> results = q2.find();
				for(Protein r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'description', type 'text'
			{
				Query<Protein> q2 = db.query(Protein.class);
				q2.equals("description",entity.getDescription());
				List<Protein> results = q2.find();
				for(Protein r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'description'
			{
				Query<Protein> q2 = db.query(Protein.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<Protein> results = q2.find();
				for(Protein r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'description'
			{
				Query<Protein> q2 = db.query(Protein.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<Protein> results = q2.find();
				for(Protein r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

			//test field 'cdna', type 'xref'
			{
				Query<Protein> q2 = db.query(Protein.class);
				q2.equals("cdna",entity.getCdna_Id());
				List<Protein> results = q2.find();
				for(Protein r: results)
				{
					assertEquals(r.getCdna_Id(), entity.getCdna_Id());
				}
			}
			//test operator 'in' for field 'cdna'
			{
				Query<Protein> q2 = db.query(Protein.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getCdna_Id());
				q2.in("cdna", inList);
				List<Protein> results = q2.find();
				for(Protein r: results)
				{
					assertEquals(r.getCdna_Id(), entity.getCdna_Id());
				}
			}
			//test operator 'equals' for implicit join field 'cdna_Identifier'
			{
				Query<Protein> q2 = db.query(Protein.class);
				q2.equals("cdna_Identifier",entity.getCdna_Identifier());
				List<Protein> results = q2.find();
				for(Protein r: results)
				{
					assertEquals(r.getCdna_Id(), entity.getCdna_Id());
				}
			}
			//test operator 'in' for implicit join field 'cdna_Identifier'
			{
				Query<Protein> q2 = db.query(Protein.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getCdna_Identifier());
				q2.in("cdna_Identifier", inList);
				q2.sortDESC("cdna_Identifier");
				List<Protein> results = q2.find();
				for(Protein r: results)
				{
					assertEquals(r.getCdna_Id(), entity.getCdna_Id());
				}
			}

			//test field 'cdna_start', type 'int'
			{
				Query<Protein> q2 = db.query(Protein.class);
				q2.equals("cdna_start",entity.getCdna_Start());
				List<Protein> results = q2.find();
				for(Protein r: results)
				{
					assertEquals(r.getCdna_Start(),entity.getCdna_Start());
				}
			}
			//test operator 'in' for field 'cdna_start'
			{
				Query<Protein> q2 = db.query(Protein.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getCdna_Start());
				q2.in("cdna_start", inList);
				List<Protein> results = q2.find();
				for(Protein r: results)
				{
					assertEquals(r.getCdna_Start(),entity.getCdna_Start());
				}
			}
			//test operator 'lessOrEqual' for field 'cdna_start'
			{
				Query<Protein> q2 = db.query(Protein.class);
				q2.lessOrEqual("cdna_start", entity.getCdna_Start());
				q2.sortASC("cdna_start");
				List<Protein> results = q2.find();
				for(Protein r: results)
				{
					assertTrue(r.getCdna_Start().compareTo(entity.getCdna_Start()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'cdna_start'
			{
				Query<Protein> q2 = db.query(Protein.class);
				q2.greaterOrEqual("cdna_start", entity.getCdna_Start());
				q2.sortDESC("cdna_start");
				List<Protein> results = q2.find();
				for(Protein r: results)
				{
					assertTrue(r.getCdna_Start().compareTo(entity.getCdna_Start()) > -1);
				}
			}

			//test field 'cdna_end', type 'int'
			{
				Query<Protein> q2 = db.query(Protein.class);
				q2.equals("cdna_end",entity.getCdna_End());
				List<Protein> results = q2.find();
				for(Protein r: results)
				{
					assertEquals(r.getCdna_End(),entity.getCdna_End());
				}
			}
			//test operator 'in' for field 'cdna_end'
			{
				Query<Protein> q2 = db.query(Protein.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getCdna_End());
				q2.in("cdna_end", inList);
				List<Protein> results = q2.find();
				for(Protein r: results)
				{
					assertEquals(r.getCdna_End(),entity.getCdna_End());
				}
			}
			//test operator 'lessOrEqual' for field 'cdna_end'
			{
				Query<Protein> q2 = db.query(Protein.class);
				q2.lessOrEqual("cdna_end", entity.getCdna_End());
				q2.sortASC("cdna_end");
				List<Protein> results = q2.find();
				for(Protein r: results)
				{
					assertTrue(r.getCdna_End().compareTo(entity.getCdna_End()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'cdna_end'
			{
				Query<Protein> q2 = db.query(Protein.class);
				q2.greaterOrEqual("cdna_end", entity.getCdna_End());
				q2.sortDESC("cdna_end");
				List<Protein> results = q2.find();
				for(Protein r: results)
				{
					assertTrue(r.getCdna_End().compareTo(entity.getCdna_End()) > -1);
				}
			}

			//test field 'residues', type 'text'
			{
				Query<Protein> q2 = db.query(Protein.class);
				q2.equals("residues",entity.getResidues());
				List<Protein> results = q2.find();
				for(Protein r: results)
				{
					assertEquals(r.getResidues(),entity.getResidues());
				}
			}
			//test operator 'in' for field 'residues'
			{
				Query<Protein> q2 = db.query(Protein.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getResidues());
				q2.in("residues", inList);
				List<Protein> results = q2.find();
				for(Protein r: results)
				{
					assertEquals(r.getResidues(),entity.getResidues());
				}
			}
			//test operator 'like' for field 'residues'
			{
				Query<Protein> q2 = db.query(Protein.class);
				q2.like("residues", entity.getResidues() + "%");
				q2.sortASC("residues");
				List<Protein> results = q2.find();
				for(Protein r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getResidues(), entity.getResidues()));
				}
			}

			//test field 'seqlen', type 'int'
			{
				Query<Protein> q2 = db.query(Protein.class);
				q2.equals("seqlen",entity.getSeqlen());
				List<Protein> results = q2.find();
				for(Protein r: results)
				{
					assertEquals(r.getSeqlen(),entity.getSeqlen());
				}
			}
			//test operator 'in' for field 'seqlen'
			{
				Query<Protein> q2 = db.query(Protein.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getSeqlen());
				q2.in("seqlen", inList);
				List<Protein> results = q2.find();
				for(Protein r: results)
				{
					assertEquals(r.getSeqlen(),entity.getSeqlen());
				}
			}
			//test operator 'lessOrEqual' for field 'seqlen'
			{
				Query<Protein> q2 = db.query(Protein.class);
				q2.lessOrEqual("seqlen", entity.getSeqlen());
				q2.sortASC("seqlen");
				List<Protein> results = q2.find();
				for(Protein r: results)
				{
					assertTrue(r.getSeqlen().compareTo(entity.getSeqlen()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'seqlen'
			{
				Query<Protein> q2 = db.query(Protein.class);
				q2.greaterOrEqual("seqlen", entity.getSeqlen());
				q2.sortDESC("seqlen");
				List<Protein> results = q2.find();
				for(Protein r: results)
				{
					assertTrue(r.getSeqlen().compareTo(entity.getSeqlen()) > -1);
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testGene","testChromosome"})
	public void testProteinDomain() throws DatabaseException
	{
		//create entities
		List<ProteinDomain> entities = new ArrayList<ProteinDomain>();

		//retrieve xref entity candidates
		List<Gene> cdnaXrefs = db.query(Gene.class).eq("__Type",Gene.class.getSimpleName()).find();	
		List<Chromosome> gdnaXrefs = db.query(Chromosome.class).eq("__Type",Chromosome.class.getSimpleName()).find();	

		for(Integer i = 0; i < total; i++)
		{
			ProteinDomain e = new ProteinDomain();
			e.setIdentifier(truncate("proteindomain_identifier_"+i, 255));
			e.setName(truncate("proteindomain_name_"+i, 255));
			e.setDescription("proteindomain_description_"+i);
			if(cdnaXrefs.size() > 0) e.setCdna_Id( cdnaXrefs.get(i).getId() );
			e.setCdna_Start(i);
			e.setCdna_End(i);
			if(gdnaXrefs.size() > 0) e.setGdna_Id( gdnaXrefs.get(i).getId() );
			e.setGdna_Start(i);
			e.setGdna_End(i);
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<ProteinDomain> q = db.query(ProteinDomain.class).eq("__Type",ProteinDomain.class.getSimpleName());
		assertEquals(total, q.count());
		List<ProteinDomain> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			assertEquals(entities.get(i).getCdna_Id(), entitiesDb.get(i).getCdna_Id());
			assertEquals(entities.get(i).getCdna_Start(), entitiesDb.get(i).getCdna_Start());
			assertEquals(entities.get(i).getCdna_End(), entitiesDb.get(i).getCdna_End());
			assertEquals(entities.get(i).getGdna_Id(), entitiesDb.get(i).getGdna_Id());
			assertEquals(entities.get(i).getGdna_Start(), entitiesDb.get(i).getGdna_Start());
			assertEquals(entities.get(i).getGdna_End(), entitiesDb.get(i).getGdna_End());
		}	
		
		//test the query capabilities by finding on all fields
		for(ProteinDomain entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				q2.equals("id",entity.getId());
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				q2.equals("identifier",entity.getIdentifier());
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				q2.equals("name",entity.getName());
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'description', type 'text'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				q2.equals("description",entity.getDescription());
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'description'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'description'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

			//test field 'cdna', type 'xref'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				q2.equals("cdna",entity.getCdna_Id());
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertEquals(r.getCdna_Id(), entity.getCdna_Id());
				}
			}
			//test operator 'in' for field 'cdna'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getCdna_Id());
				q2.in("cdna", inList);
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertEquals(r.getCdna_Id(), entity.getCdna_Id());
				}
			}
			//test operator 'equals' for implicit join field 'cdna_Identifier'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				q2.equals("cdna_Identifier",entity.getCdna_Identifier());
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertEquals(r.getCdna_Id(), entity.getCdna_Id());
				}
			}
			//test operator 'in' for implicit join field 'cdna_Identifier'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getCdna_Identifier());
				q2.in("cdna_Identifier", inList);
				q2.sortDESC("cdna_Identifier");
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertEquals(r.getCdna_Id(), entity.getCdna_Id());
				}
			}

			//test field 'cdna_start', type 'int'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				q2.equals("cdna_start",entity.getCdna_Start());
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertEquals(r.getCdna_Start(),entity.getCdna_Start());
				}
			}
			//test operator 'in' for field 'cdna_start'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getCdna_Start());
				q2.in("cdna_start", inList);
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertEquals(r.getCdna_Start(),entity.getCdna_Start());
				}
			}
			//test operator 'lessOrEqual' for field 'cdna_start'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				q2.lessOrEqual("cdna_start", entity.getCdna_Start());
				q2.sortASC("cdna_start");
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertTrue(r.getCdna_Start().compareTo(entity.getCdna_Start()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'cdna_start'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				q2.greaterOrEqual("cdna_start", entity.getCdna_Start());
				q2.sortDESC("cdna_start");
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertTrue(r.getCdna_Start().compareTo(entity.getCdna_Start()) > -1);
				}
			}

			//test field 'cdna_end', type 'int'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				q2.equals("cdna_end",entity.getCdna_End());
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertEquals(r.getCdna_End(),entity.getCdna_End());
				}
			}
			//test operator 'in' for field 'cdna_end'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getCdna_End());
				q2.in("cdna_end", inList);
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertEquals(r.getCdna_End(),entity.getCdna_End());
				}
			}
			//test operator 'lessOrEqual' for field 'cdna_end'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				q2.lessOrEqual("cdna_end", entity.getCdna_End());
				q2.sortASC("cdna_end");
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertTrue(r.getCdna_End().compareTo(entity.getCdna_End()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'cdna_end'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				q2.greaterOrEqual("cdna_end", entity.getCdna_End());
				q2.sortDESC("cdna_end");
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertTrue(r.getCdna_End().compareTo(entity.getCdna_End()) > -1);
				}
			}

			//test field 'gdna', type 'xref'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				q2.equals("gdna",entity.getGdna_Id());
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertEquals(r.getGdna_Id(), entity.getGdna_Id());
				}
			}
			//test operator 'in' for field 'gdna'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getGdna_Id());
				q2.in("gdna", inList);
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertEquals(r.getGdna_Id(), entity.getGdna_Id());
				}
			}
			//test operator 'equals' for implicit join field 'gdna_Identifier'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				q2.equals("gdna_Identifier",entity.getGdna_Identifier());
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertEquals(r.getGdna_Id(), entity.getGdna_Id());
				}
			}
			//test operator 'in' for implicit join field 'gdna_Identifier'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getGdna_Identifier());
				q2.in("gdna_Identifier", inList);
				q2.sortDESC("gdna_Identifier");
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertEquals(r.getGdna_Id(), entity.getGdna_Id());
				}
			}

			//test field 'gdna_start', type 'int'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				q2.equals("gdna_start",entity.getGdna_Start());
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertEquals(r.getGdna_Start(),entity.getGdna_Start());
				}
			}
			//test operator 'in' for field 'gdna_start'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getGdna_Start());
				q2.in("gdna_start", inList);
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertEquals(r.getGdna_Start(),entity.getGdna_Start());
				}
			}
			//test operator 'lessOrEqual' for field 'gdna_start'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				q2.lessOrEqual("gdna_start", entity.getGdna_Start());
				q2.sortASC("gdna_start");
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertTrue(r.getGdna_Start().compareTo(entity.getGdna_Start()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'gdna_start'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				q2.greaterOrEqual("gdna_start", entity.getGdna_Start());
				q2.sortDESC("gdna_start");
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertTrue(r.getGdna_Start().compareTo(entity.getGdna_Start()) > -1);
				}
			}

			//test field 'gdna_end', type 'int'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				q2.equals("gdna_end",entity.getGdna_End());
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertEquals(r.getGdna_End(),entity.getGdna_End());
				}
			}
			//test operator 'in' for field 'gdna_end'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getGdna_End());
				q2.in("gdna_end", inList);
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertEquals(r.getGdna_End(),entity.getGdna_End());
				}
			}
			//test operator 'lessOrEqual' for field 'gdna_end'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				q2.lessOrEqual("gdna_end", entity.getGdna_End());
				q2.sortASC("gdna_end");
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertTrue(r.getGdna_End().compareTo(entity.getGdna_End()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'gdna_end'
			{
				Query<ProteinDomain> q2 = db.query(ProteinDomain.class);
				q2.greaterOrEqual("gdna_end", entity.getGdna_End());
				q2.sortDESC("gdna_end");
				List<ProteinDomain> results = q2.find();
				for(ProteinDomain r: results)
				{
					assertTrue(r.getGdna_End().compareTo(entity.getGdna_End()) > -1);
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testGene","testChromosome"})
	public void testExon() throws DatabaseException
	{
		//create entities
		List<Exon> entities = new ArrayList<Exon>();

		//retrieve xref entity candidates
		List<Gene> cdnaXrefs = db.query(Gene.class).eq("__Type",Gene.class.getSimpleName()).find();	
		List<Chromosome> gdnaXrefs = db.query(Chromosome.class).eq("__Type",Chromosome.class.getSimpleName()).find();	

		for(Integer i = 0; i < total; i++)
		{
			Exon e = new Exon();
			e.setIdentifier(truncate("exon_identifier_"+i, 255));
			e.setName(truncate("exon_name_"+i, 255));
			e.setDescription("exon_description_"+i);
			if(cdnaXrefs.size() > 0) e.setCdna_Id( cdnaXrefs.get(i).getId() );
			e.setCdna_Start(i);
			e.setCdna_End(i);
			if(gdnaXrefs.size() > 0) e.setGdna_Id( gdnaXrefs.get(i).getId() );
			e.setGdna_Start(i);
			e.setGdna_End(i);
			e.setIsIntron(randomBool(i));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<Exon> q = db.query(Exon.class).eq("__Type",Exon.class.getSimpleName());
		assertEquals(total, q.count());
		List<Exon> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			assertEquals(entities.get(i).getCdna_Id(), entitiesDb.get(i).getCdna_Id());
			assertEquals(entities.get(i).getCdna_Start(), entitiesDb.get(i).getCdna_Start());
			assertEquals(entities.get(i).getCdna_End(), entitiesDb.get(i).getCdna_End());
			assertEquals(entities.get(i).getGdna_Id(), entitiesDb.get(i).getGdna_Id());
			assertEquals(entities.get(i).getGdna_Start(), entitiesDb.get(i).getGdna_Start());
			assertEquals(entities.get(i).getGdna_End(), entitiesDb.get(i).getGdna_End());
			assertEquals(entities.get(i).getIsIntron(), entitiesDb.get(i).getIsIntron());
		}	
		
		//test the query capabilities by finding on all fields
		for(Exon entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<Exon> q2 = db.query(Exon.class);
				q2.equals("id",entity.getId());
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<Exon> q2 = db.query(Exon.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<Exon> q2 = db.query(Exon.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<Exon> q2 = db.query(Exon.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<Exon> q2 = db.query(Exon.class);
				q2.equals("identifier",entity.getIdentifier());
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<Exon> q2 = db.query(Exon.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<Exon> q2 = db.query(Exon.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<Exon> q2 = db.query(Exon.class);
				q2.equals("name",entity.getName());
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<Exon> q2 = db.query(Exon.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<Exon> q2 = db.query(Exon.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'description', type 'text'
			{
				Query<Exon> q2 = db.query(Exon.class);
				q2.equals("description",entity.getDescription());
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'description'
			{
				Query<Exon> q2 = db.query(Exon.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'description'
			{
				Query<Exon> q2 = db.query(Exon.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

			//test field 'cdna', type 'xref'
			{
				Query<Exon> q2 = db.query(Exon.class);
				q2.equals("cdna",entity.getCdna_Id());
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertEquals(r.getCdna_Id(), entity.getCdna_Id());
				}
			}
			//test operator 'in' for field 'cdna'
			{
				Query<Exon> q2 = db.query(Exon.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getCdna_Id());
				q2.in("cdna", inList);
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertEquals(r.getCdna_Id(), entity.getCdna_Id());
				}
			}
			//test operator 'equals' for implicit join field 'cdna_Identifier'
			{
				Query<Exon> q2 = db.query(Exon.class);
				q2.equals("cdna_Identifier",entity.getCdna_Identifier());
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertEquals(r.getCdna_Id(), entity.getCdna_Id());
				}
			}
			//test operator 'in' for implicit join field 'cdna_Identifier'
			{
				Query<Exon> q2 = db.query(Exon.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getCdna_Identifier());
				q2.in("cdna_Identifier", inList);
				q2.sortDESC("cdna_Identifier");
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertEquals(r.getCdna_Id(), entity.getCdna_Id());
				}
			}

			//test field 'cdna_start', type 'int'
			{
				Query<Exon> q2 = db.query(Exon.class);
				q2.equals("cdna_start",entity.getCdna_Start());
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertEquals(r.getCdna_Start(),entity.getCdna_Start());
				}
			}
			//test operator 'in' for field 'cdna_start'
			{
				Query<Exon> q2 = db.query(Exon.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getCdna_Start());
				q2.in("cdna_start", inList);
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertEquals(r.getCdna_Start(),entity.getCdna_Start());
				}
			}
			//test operator 'lessOrEqual' for field 'cdna_start'
			{
				Query<Exon> q2 = db.query(Exon.class);
				q2.lessOrEqual("cdna_start", entity.getCdna_Start());
				q2.sortASC("cdna_start");
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertTrue(r.getCdna_Start().compareTo(entity.getCdna_Start()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'cdna_start'
			{
				Query<Exon> q2 = db.query(Exon.class);
				q2.greaterOrEqual("cdna_start", entity.getCdna_Start());
				q2.sortDESC("cdna_start");
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertTrue(r.getCdna_Start().compareTo(entity.getCdna_Start()) > -1);
				}
			}

			//test field 'cdna_end', type 'int'
			{
				Query<Exon> q2 = db.query(Exon.class);
				q2.equals("cdna_end",entity.getCdna_End());
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertEquals(r.getCdna_End(),entity.getCdna_End());
				}
			}
			//test operator 'in' for field 'cdna_end'
			{
				Query<Exon> q2 = db.query(Exon.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getCdna_End());
				q2.in("cdna_end", inList);
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertEquals(r.getCdna_End(),entity.getCdna_End());
				}
			}
			//test operator 'lessOrEqual' for field 'cdna_end'
			{
				Query<Exon> q2 = db.query(Exon.class);
				q2.lessOrEqual("cdna_end", entity.getCdna_End());
				q2.sortASC("cdna_end");
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertTrue(r.getCdna_End().compareTo(entity.getCdna_End()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'cdna_end'
			{
				Query<Exon> q2 = db.query(Exon.class);
				q2.greaterOrEqual("cdna_end", entity.getCdna_End());
				q2.sortDESC("cdna_end");
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertTrue(r.getCdna_End().compareTo(entity.getCdna_End()) > -1);
				}
			}

			//test field 'gdna', type 'xref'
			{
				Query<Exon> q2 = db.query(Exon.class);
				q2.equals("gdna",entity.getGdna_Id());
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertEquals(r.getGdna_Id(), entity.getGdna_Id());
				}
			}
			//test operator 'in' for field 'gdna'
			{
				Query<Exon> q2 = db.query(Exon.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getGdna_Id());
				q2.in("gdna", inList);
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertEquals(r.getGdna_Id(), entity.getGdna_Id());
				}
			}
			//test operator 'equals' for implicit join field 'gdna_Identifier'
			{
				Query<Exon> q2 = db.query(Exon.class);
				q2.equals("gdna_Identifier",entity.getGdna_Identifier());
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertEquals(r.getGdna_Id(), entity.getGdna_Id());
				}
			}
			//test operator 'in' for implicit join field 'gdna_Identifier'
			{
				Query<Exon> q2 = db.query(Exon.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getGdna_Identifier());
				q2.in("gdna_Identifier", inList);
				q2.sortDESC("gdna_Identifier");
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertEquals(r.getGdna_Id(), entity.getGdna_Id());
				}
			}

			//test field 'gdna_start', type 'int'
			{
				Query<Exon> q2 = db.query(Exon.class);
				q2.equals("gdna_start",entity.getGdna_Start());
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertEquals(r.getGdna_Start(),entity.getGdna_Start());
				}
			}
			//test operator 'in' for field 'gdna_start'
			{
				Query<Exon> q2 = db.query(Exon.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getGdna_Start());
				q2.in("gdna_start", inList);
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertEquals(r.getGdna_Start(),entity.getGdna_Start());
				}
			}
			//test operator 'lessOrEqual' for field 'gdna_start'
			{
				Query<Exon> q2 = db.query(Exon.class);
				q2.lessOrEqual("gdna_start", entity.getGdna_Start());
				q2.sortASC("gdna_start");
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertTrue(r.getGdna_Start().compareTo(entity.getGdna_Start()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'gdna_start'
			{
				Query<Exon> q2 = db.query(Exon.class);
				q2.greaterOrEqual("gdna_start", entity.getGdna_Start());
				q2.sortDESC("gdna_start");
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertTrue(r.getGdna_Start().compareTo(entity.getGdna_Start()) > -1);
				}
			}

			//test field 'gdna_end', type 'int'
			{
				Query<Exon> q2 = db.query(Exon.class);
				q2.equals("gdna_end",entity.getGdna_End());
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertEquals(r.getGdna_End(),entity.getGdna_End());
				}
			}
			//test operator 'in' for field 'gdna_end'
			{
				Query<Exon> q2 = db.query(Exon.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getGdna_End());
				q2.in("gdna_end", inList);
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertEquals(r.getGdna_End(),entity.getGdna_End());
				}
			}
			//test operator 'lessOrEqual' for field 'gdna_end'
			{
				Query<Exon> q2 = db.query(Exon.class);
				q2.lessOrEqual("gdna_end", entity.getGdna_End());
				q2.sortASC("gdna_end");
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertTrue(r.getGdna_End().compareTo(entity.getGdna_End()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'gdna_end'
			{
				Query<Exon> q2 = db.query(Exon.class);
				q2.greaterOrEqual("gdna_end", entity.getGdna_End());
				q2.sortDESC("gdna_end");
				List<Exon> results = q2.find();
				for(Exon r: results)
				{
					assertTrue(r.getGdna_End().compareTo(entity.getGdna_End()) > -1);
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testChromosome","testGene","testProtein","testOntologyTerm"})
	public void testVariant() throws DatabaseException
	{
		//create entities
		List<Variant> entities = new ArrayList<Variant>();

		//retrieve xref entity candidates
		List<Chromosome> gdnaXrefs = db.query(Chromosome.class).eq("__Type",Chromosome.class.getSimpleName()).find();	
		List<Gene> cdnaXrefs = db.query(Gene.class).eq("__Type",Gene.class.getSimpleName()).find();	
		List<Protein> aaXrefs = db.query(Protein.class).eq("__Type",Protein.class.getSimpleName()).find();	
		List<OntologyTerm> variantTypeXrefs = db.query(OntologyTerm.class).find();	

		for(Integer i = 0; i < total; i++)
		{
			Variant e = new Variant();
			e.setIdentifier(truncate("variant_identifier_"+i, 255));
			e.setName(truncate("variant_name_"+i, 255));
			e.setDescription("variant_description_"+i);
			if(gdnaXrefs.size() > 0) e.setGdna_Id( gdnaXrefs.get(i).getId() );
			e.setGdna_Start(i);
			e.setGdna_End(i);
			if(cdnaXrefs.size() > 0) e.setCdna_Id( cdnaXrefs.get(i).getId() );
			e.setCdna_Start(i);
			e.setCdna_End(i);
			if(aaXrefs.size() > 0) e.setAa_Id( aaXrefs.get(i).getId() );
			e.setAa_Start(i);
			e.setAa_End(i);
			e.setGdna_Notation(truncate("variant_gdna_notation_"+i, 255));
			e.setCdna_Notation(truncate("variant_cdna_notation_"+i, 255));
			e.setAa_Notation(truncate("variant_aa_notation_"+i, 255));
			if(variantTypeXrefs.size() > 0) e.setVariantType_Id( variantTypeXrefs.get(i).getId() );
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<Variant> q = db.query(Variant.class).eq("__Type",Variant.class.getSimpleName());
		assertEquals(total, q.count());
		List<Variant> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			assertEquals(entities.get(i).getGdna_Id(), entitiesDb.get(i).getGdna_Id());
			assertEquals(entities.get(i).getGdna_Start(), entitiesDb.get(i).getGdna_Start());
			assertEquals(entities.get(i).getGdna_End(), entitiesDb.get(i).getGdna_End());
			assertEquals(entities.get(i).getCdna_Id(), entitiesDb.get(i).getCdna_Id());
			assertEquals(entities.get(i).getCdna_Start(), entitiesDb.get(i).getCdna_Start());
			assertEquals(entities.get(i).getCdna_End(), entitiesDb.get(i).getCdna_End());
			assertEquals(entities.get(i).getAa_Id(), entitiesDb.get(i).getAa_Id());
			assertEquals(entities.get(i).getAa_Start(), entitiesDb.get(i).getAa_Start());
			assertEquals(entities.get(i).getAa_End(), entitiesDb.get(i).getAa_End());
			assertEquals(entities.get(i).getGdna_Notation(), entitiesDb.get(i).getGdna_Notation());
			assertEquals(entities.get(i).getCdna_Notation(), entitiesDb.get(i).getCdna_Notation());
			assertEquals(entities.get(i).getAa_Notation(), entitiesDb.get(i).getAa_Notation());
			assertEquals(entities.get(i).getVariantType_Id(), entitiesDb.get(i).getVariantType_Id());
		}	
		
		//test the query capabilities by finding on all fields
		for(Variant entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.equals("id",entity.getId());
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<Variant> q2 = db.query(Variant.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.equals("identifier",entity.getIdentifier());
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<Variant> q2 = db.query(Variant.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.equals("name",entity.getName());
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<Variant> q2 = db.query(Variant.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'description', type 'text'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.equals("description",entity.getDescription());
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'description'
			{
				Query<Variant> q2 = db.query(Variant.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'description'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

			//test field 'gdna', type 'xref'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.equals("gdna",entity.getGdna_Id());
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getGdna_Id(), entity.getGdna_Id());
				}
			}
			//test operator 'in' for field 'gdna'
			{
				Query<Variant> q2 = db.query(Variant.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getGdna_Id());
				q2.in("gdna", inList);
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getGdna_Id(), entity.getGdna_Id());
				}
			}
			//test operator 'equals' for implicit join field 'gdna_Identifier'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.equals("gdna_Identifier",entity.getGdna_Identifier());
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getGdna_Id(), entity.getGdna_Id());
				}
			}
			//test operator 'in' for implicit join field 'gdna_Identifier'
			{
				Query<Variant> q2 = db.query(Variant.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getGdna_Identifier());
				q2.in("gdna_Identifier", inList);
				q2.sortDESC("gdna_Identifier");
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getGdna_Id(), entity.getGdna_Id());
				}
			}

			//test field 'gdna_start', type 'int'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.equals("gdna_start",entity.getGdna_Start());
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getGdna_Start(),entity.getGdna_Start());
				}
			}
			//test operator 'in' for field 'gdna_start'
			{
				Query<Variant> q2 = db.query(Variant.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getGdna_Start());
				q2.in("gdna_start", inList);
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getGdna_Start(),entity.getGdna_Start());
				}
			}
			//test operator 'lessOrEqual' for field 'gdna_start'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.lessOrEqual("gdna_start", entity.getGdna_Start());
				q2.sortASC("gdna_start");
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertTrue(r.getGdna_Start().compareTo(entity.getGdna_Start()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'gdna_start'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.greaterOrEqual("gdna_start", entity.getGdna_Start());
				q2.sortDESC("gdna_start");
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertTrue(r.getGdna_Start().compareTo(entity.getGdna_Start()) > -1);
				}
			}

			//test field 'gdna_end', type 'int'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.equals("gdna_end",entity.getGdna_End());
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getGdna_End(),entity.getGdna_End());
				}
			}
			//test operator 'in' for field 'gdna_end'
			{
				Query<Variant> q2 = db.query(Variant.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getGdna_End());
				q2.in("gdna_end", inList);
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getGdna_End(),entity.getGdna_End());
				}
			}
			//test operator 'lessOrEqual' for field 'gdna_end'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.lessOrEqual("gdna_end", entity.getGdna_End());
				q2.sortASC("gdna_end");
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertTrue(r.getGdna_End().compareTo(entity.getGdna_End()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'gdna_end'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.greaterOrEqual("gdna_end", entity.getGdna_End());
				q2.sortDESC("gdna_end");
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertTrue(r.getGdna_End().compareTo(entity.getGdna_End()) > -1);
				}
			}

			//test field 'cdna', type 'xref'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.equals("cdna",entity.getCdna_Id());
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getCdna_Id(), entity.getCdna_Id());
				}
			}
			//test operator 'in' for field 'cdna'
			{
				Query<Variant> q2 = db.query(Variant.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getCdna_Id());
				q2.in("cdna", inList);
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getCdna_Id(), entity.getCdna_Id());
				}
			}
			//test operator 'equals' for implicit join field 'cdna_Identifier'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.equals("cdna_Identifier",entity.getCdna_Identifier());
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getCdna_Id(), entity.getCdna_Id());
				}
			}
			//test operator 'in' for implicit join field 'cdna_Identifier'
			{
				Query<Variant> q2 = db.query(Variant.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getCdna_Identifier());
				q2.in("cdna_Identifier", inList);
				q2.sortDESC("cdna_Identifier");
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getCdna_Id(), entity.getCdna_Id());
				}
			}

			//test field 'cdna_start', type 'int'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.equals("cdna_start",entity.getCdna_Start());
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getCdna_Start(),entity.getCdna_Start());
				}
			}
			//test operator 'in' for field 'cdna_start'
			{
				Query<Variant> q2 = db.query(Variant.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getCdna_Start());
				q2.in("cdna_start", inList);
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getCdna_Start(),entity.getCdna_Start());
				}
			}
			//test operator 'lessOrEqual' for field 'cdna_start'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.lessOrEqual("cdna_start", entity.getCdna_Start());
				q2.sortASC("cdna_start");
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertTrue(r.getCdna_Start().compareTo(entity.getCdna_Start()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'cdna_start'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.greaterOrEqual("cdna_start", entity.getCdna_Start());
				q2.sortDESC("cdna_start");
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertTrue(r.getCdna_Start().compareTo(entity.getCdna_Start()) > -1);
				}
			}

			//test field 'cdna_end', type 'int'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.equals("cdna_end",entity.getCdna_End());
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getCdna_End(),entity.getCdna_End());
				}
			}
			//test operator 'in' for field 'cdna_end'
			{
				Query<Variant> q2 = db.query(Variant.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getCdna_End());
				q2.in("cdna_end", inList);
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getCdna_End(),entity.getCdna_End());
				}
			}
			//test operator 'lessOrEqual' for field 'cdna_end'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.lessOrEqual("cdna_end", entity.getCdna_End());
				q2.sortASC("cdna_end");
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertTrue(r.getCdna_End().compareTo(entity.getCdna_End()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'cdna_end'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.greaterOrEqual("cdna_end", entity.getCdna_End());
				q2.sortDESC("cdna_end");
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertTrue(r.getCdna_End().compareTo(entity.getCdna_End()) > -1);
				}
			}

			//test field 'aa', type 'xref'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.equals("aa",entity.getAa_Id());
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getAa_Id(), entity.getAa_Id());
				}
			}
			//test operator 'in' for field 'aa'
			{
				Query<Variant> q2 = db.query(Variant.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getAa_Id());
				q2.in("aa", inList);
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getAa_Id(), entity.getAa_Id());
				}
			}
			//test operator 'equals' for implicit join field 'aa_Identifier'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.equals("aa_Identifier",entity.getAa_Identifier());
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getAa_Id(), entity.getAa_Id());
				}
			}
			//test operator 'in' for implicit join field 'aa_Identifier'
			{
				Query<Variant> q2 = db.query(Variant.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getAa_Identifier());
				q2.in("aa_Identifier", inList);
				q2.sortDESC("aa_Identifier");
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getAa_Id(), entity.getAa_Id());
				}
			}

			//test field 'aa_start', type 'int'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.equals("aa_start",entity.getAa_Start());
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getAa_Start(),entity.getAa_Start());
				}
			}
			//test operator 'in' for field 'aa_start'
			{
				Query<Variant> q2 = db.query(Variant.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getAa_Start());
				q2.in("aa_start", inList);
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getAa_Start(),entity.getAa_Start());
				}
			}
			//test operator 'lessOrEqual' for field 'aa_start'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.lessOrEqual("aa_start", entity.getAa_Start());
				q2.sortASC("aa_start");
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertTrue(r.getAa_Start().compareTo(entity.getAa_Start()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'aa_start'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.greaterOrEqual("aa_start", entity.getAa_Start());
				q2.sortDESC("aa_start");
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertTrue(r.getAa_Start().compareTo(entity.getAa_Start()) > -1);
				}
			}

			//test field 'aa_end', type 'int'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.equals("aa_end",entity.getAa_End());
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getAa_End(),entity.getAa_End());
				}
			}
			//test operator 'in' for field 'aa_end'
			{
				Query<Variant> q2 = db.query(Variant.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getAa_End());
				q2.in("aa_end", inList);
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getAa_End(),entity.getAa_End());
				}
			}
			//test operator 'lessOrEqual' for field 'aa_end'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.lessOrEqual("aa_end", entity.getAa_End());
				q2.sortASC("aa_end");
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertTrue(r.getAa_End().compareTo(entity.getAa_End()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'aa_end'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.greaterOrEqual("aa_end", entity.getAa_End());
				q2.sortDESC("aa_end");
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertTrue(r.getAa_End().compareTo(entity.getAa_End()) > -1);
				}
			}

			//test field 'gdna_notation', type 'string'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.equals("gdna_notation",entity.getGdna_Notation());
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getGdna_Notation(),entity.getGdna_Notation());
				}
			}
			//test operator 'in' for field 'gdna_notation'
			{
				Query<Variant> q2 = db.query(Variant.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getGdna_Notation());
				q2.in("gdna_notation", inList);
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getGdna_Notation(),entity.getGdna_Notation());
				}
			}
			//test operator 'like' for field 'gdna_notation'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.like("gdna_notation", entity.getGdna_Notation() + "%");
				q2.sortASC("gdna_notation");
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getGdna_Notation(), entity.getGdna_Notation()));
				}
			}

			//test field 'cdna_notation', type 'string'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.equals("cdna_notation",entity.getCdna_Notation());
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getCdna_Notation(),entity.getCdna_Notation());
				}
			}
			//test operator 'in' for field 'cdna_notation'
			{
				Query<Variant> q2 = db.query(Variant.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getCdna_Notation());
				q2.in("cdna_notation", inList);
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getCdna_Notation(),entity.getCdna_Notation());
				}
			}
			//test operator 'like' for field 'cdna_notation'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.like("cdna_notation", entity.getCdna_Notation() + "%");
				q2.sortASC("cdna_notation");
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getCdna_Notation(), entity.getCdna_Notation()));
				}
			}

			//test field 'aa_notation', type 'string'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.equals("aa_notation",entity.getAa_Notation());
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getAa_Notation(),entity.getAa_Notation());
				}
			}
			//test operator 'in' for field 'aa_notation'
			{
				Query<Variant> q2 = db.query(Variant.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getAa_Notation());
				q2.in("aa_notation", inList);
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getAa_Notation(),entity.getAa_Notation());
				}
			}
			//test operator 'like' for field 'aa_notation'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.like("aa_notation", entity.getAa_Notation() + "%");
				q2.sortASC("aa_notation");
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getAa_Notation(), entity.getAa_Notation()));
				}
			}

			//test field 'variantType', type 'xref'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.equals("variantType",entity.getVariantType_Id());
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getVariantType_Id(), entity.getVariantType_Id());
				}
			}
			//test operator 'in' for field 'variantType'
			{
				Query<Variant> q2 = db.query(Variant.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getVariantType_Id());
				q2.in("variantType", inList);
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getVariantType_Id(), entity.getVariantType_Id());
				}
			}
			//test operator 'equals' for implicit join field 'variantType_Identifier'
			{
				Query<Variant> q2 = db.query(Variant.class);
				q2.equals("variantType_Identifier",entity.getVariantType_Identifier());
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getVariantType_Id(), entity.getVariantType_Id());
				}
			}
			//test operator 'in' for implicit join field 'variantType_Identifier'
			{
				Query<Variant> q2 = db.query(Variant.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getVariantType_Identifier());
				q2.in("variantType_Identifier", inList);
				q2.sortDESC("variantType_Identifier");
				List<Variant> results = q2.find();
				for(Variant r: results)
				{
					assertEquals(r.getVariantType_Id(), entity.getVariantType_Id());
				}
			}

		}
	}

	@Test
	public void testInstitute() throws DatabaseException
	{
		//create entities
		List<Institute> entities = new ArrayList<Institute>();

		//retrieve xref entity candidates

		for(Integer i = 0; i < total; i++)
		{
			Institute e = new Institute();
			e.setName(truncate("institute_name_"+i, 255));
			e.setAddress("institute_address_"+i);
			e.setPhone(truncate("institute_phone_"+i, 255));
			e.setCity(truncate("institute_city_"+i, 255));
			e.setCountry(truncate("institute_country_"+i, 255));
			e.setFax(truncate("institute_fax_"+i, 255));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<Institute> q = db.query(Institute.class);
		assertEquals(total, q.count());
		List<Institute> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getAddress(), entitiesDb.get(i).getAddress());
			assertEquals(entities.get(i).getPhone(), entitiesDb.get(i).getPhone());
			assertEquals(entities.get(i).getCity(), entitiesDb.get(i).getCity());
			assertEquals(entities.get(i).getCountry(), entitiesDb.get(i).getCountry());
			assertEquals(entities.get(i).getFax(), entitiesDb.get(i).getFax());
		}	
		
		//test the query capabilities by finding on all fields
		for(Institute entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<Institute> q2 = db.query(Institute.class);
				q2.equals("id",entity.getId());
				List<Institute> results = q2.find();
				assertEquals(results.size(),1);
				for(Institute r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<Institute> q2 = db.query(Institute.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<Institute> results = q2.find();
				assertEquals(results.size(),1);
				for(Institute r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<Institute> q2 = db.query(Institute.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<Institute> q2 = db.query(Institute.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'name', type 'string'
			{
				Query<Institute> q2 = db.query(Institute.class);
				q2.equals("name",entity.getName());
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'name'
			{
				Query<Institute> q2 = db.query(Institute.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'name'
			{
				Query<Institute> q2 = db.query(Institute.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'Address', type 'text'
			{
				Query<Institute> q2 = db.query(Institute.class);
				q2.equals("address",entity.getAddress());
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertEquals(r.getAddress(),entity.getAddress());
				}
			}
			//test operator 'in' for field 'Address'
			{
				Query<Institute> q2 = db.query(Institute.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getAddress());
				q2.in("address", inList);
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertEquals(r.getAddress(),entity.getAddress());
				}
			}
			//test operator 'like' for field 'Address'
			{
				Query<Institute> q2 = db.query(Institute.class);
				q2.like("address", entity.getAddress() + "%");
				q2.sortASC("address");
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getAddress(), entity.getAddress()));
				}
			}

			//test field 'Phone', type 'string'
			{
				Query<Institute> q2 = db.query(Institute.class);
				q2.equals("phone",entity.getPhone());
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertEquals(r.getPhone(),entity.getPhone());
				}
			}
			//test operator 'in' for field 'Phone'
			{
				Query<Institute> q2 = db.query(Institute.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getPhone());
				q2.in("phone", inList);
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertEquals(r.getPhone(),entity.getPhone());
				}
			}
			//test operator 'like' for field 'Phone'
			{
				Query<Institute> q2 = db.query(Institute.class);
				q2.like("phone", entity.getPhone() + "%");
				q2.sortASC("phone");
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getPhone(), entity.getPhone()));
				}
			}

			//test field 'City', type 'string'
			{
				Query<Institute> q2 = db.query(Institute.class);
				q2.equals("city",entity.getCity());
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertEquals(r.getCity(),entity.getCity());
				}
			}
			//test operator 'in' for field 'City'
			{
				Query<Institute> q2 = db.query(Institute.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getCity());
				q2.in("city", inList);
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertEquals(r.getCity(),entity.getCity());
				}
			}
			//test operator 'like' for field 'City'
			{
				Query<Institute> q2 = db.query(Institute.class);
				q2.like("city", entity.getCity() + "%");
				q2.sortASC("city");
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getCity(), entity.getCity()));
				}
			}

			//test field 'Country', type 'string'
			{
				Query<Institute> q2 = db.query(Institute.class);
				q2.equals("country",entity.getCountry());
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertEquals(r.getCountry(),entity.getCountry());
				}
			}
			//test operator 'in' for field 'Country'
			{
				Query<Institute> q2 = db.query(Institute.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getCountry());
				q2.in("country", inList);
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertEquals(r.getCountry(),entity.getCountry());
				}
			}
			//test operator 'like' for field 'Country'
			{
				Query<Institute> q2 = db.query(Institute.class);
				q2.like("country", entity.getCountry() + "%");
				q2.sortASC("country");
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getCountry(), entity.getCountry()));
				}
			}

			//test field 'Fax', type 'string'
			{
				Query<Institute> q2 = db.query(Institute.class);
				q2.equals("fax",entity.getFax());
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertEquals(r.getFax(),entity.getFax());
				}
			}
			//test operator 'in' for field 'Fax'
			{
				Query<Institute> q2 = db.query(Institute.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getFax());
				q2.in("fax", inList);
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertEquals(r.getFax(),entity.getFax());
				}
			}
			//test operator 'like' for field 'Fax'
			{
				Query<Institute> q2 = db.query(Institute.class);
				q2.like("fax", entity.getFax() + "%");
				q2.sortASC("fax");
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getFax(), entity.getFax()));
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testInstitute","testOntologyTerm"})
	public void testPerson() throws DatabaseException
	{
		//create entities
		List<Person> entities = new ArrayList<Person>();

		//retrieve xref entity candidates
		List<Institute> primaryAffilationXrefs = db.query(Institute.class).find();	
		List<Institute> affiliateInstitutionsXrefs = db.query(Institute.class).find();	
		List<OntologyTerm> orcidPersonReferenceXrefs = db.query(OntologyTerm.class).find();	

		for(Integer i = 0; i < total; i++)
		{
			Person e = new Person();
			e.setName(truncate("person_name_"+i, 255));
			e.setTitle(truncate("person_title_"+i, 255));
			e.setFirstName(truncate("person_firstname_"+i, 255));
			e.setMidInitials(truncate("person_midinitials_"+i, 255));
			e.setLastName(truncate("person_lastname_"+i, 255));
			e.setEmail("person_email_"+i);
			e.setPhone(truncate("person_phone_"+i, 255));
			if(primaryAffilationXrefs.size() > 0) e.setPrimaryAffilation_Id( primaryAffilationXrefs.get(i).getId() );
			if(affiliateInstitutionsXrefs.size() > 0)
			{
				e.getAffiliateInstitutions_Id().add( affiliateInstitutionsXrefs.get(i).getId() );
				//e.getAffiliateInstitutions().add( random(affiliateInstitutionsXrefs).getId() );
			}
			if(orcidPersonReferenceXrefs.size() > 0) e.setOrcidPersonReference_Id( orcidPersonReferenceXrefs.get(i).getId() );
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<Person> q = db.query(Person.class);
		assertEquals(total, q.count());
		List<Person> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getTitle(), entitiesDb.get(i).getTitle());
			assertEquals(entities.get(i).getFirstName(), entitiesDb.get(i).getFirstName());
			assertEquals(entities.get(i).getMidInitials(), entitiesDb.get(i).getMidInitials());
			assertEquals(entities.get(i).getLastName(), entitiesDb.get(i).getLastName());
			assertEquals(entities.get(i).getEmail(), entitiesDb.get(i).getEmail());
			assertEquals(entities.get(i).getPhone(), entitiesDb.get(i).getPhone());
			assertEquals(entities.get(i).getPrimaryAffilation_Id(), entitiesDb.get(i).getPrimaryAffilation_Id());
			assertEquals(entities.get(i).getAffiliateInstitutions_Id(), entitiesDb.get(i).getAffiliateInstitutions_Id());
			assertEquals(entities.get(i).getOrcidPersonReference_Id(), entitiesDb.get(i).getOrcidPersonReference_Id());
		}	
		
		//test the query capabilities by finding on all fields
		for(Person entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.equals("id",entity.getId());
				List<Person> results = q2.find();
				assertEquals(results.size(),1);
				for(Person r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<Person> q2 = db.query(Person.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<Person> results = q2.find();
				assertEquals(results.size(),1);
				for(Person r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Name', type 'string'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.equals("name",entity.getName());
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<Person> q2 = db.query(Person.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'Title', type 'string'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.equals("title",entity.getTitle());
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getTitle(),entity.getTitle());
				}
			}
			//test operator 'in' for field 'Title'
			{
				Query<Person> q2 = db.query(Person.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getTitle());
				q2.in("title", inList);
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getTitle(),entity.getTitle());
				}
			}
			//test operator 'like' for field 'Title'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.like("title", entity.getTitle() + "%");
				q2.sortASC("title");
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getTitle(), entity.getTitle()));
				}
			}

			//test field 'FirstName', type 'string'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.equals("firstName",entity.getFirstName());
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getFirstName(),entity.getFirstName());
				}
			}
			//test operator 'in' for field 'FirstName'
			{
				Query<Person> q2 = db.query(Person.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getFirstName());
				q2.in("firstName", inList);
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getFirstName(),entity.getFirstName());
				}
			}
			//test operator 'like' for field 'FirstName'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.like("firstName", entity.getFirstName() + "%");
				q2.sortASC("firstName");
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getFirstName(), entity.getFirstName()));
				}
			}

			//test field 'MidInitials', type 'string'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.equals("midInitials",entity.getMidInitials());
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getMidInitials(),entity.getMidInitials());
				}
			}
			//test operator 'in' for field 'MidInitials'
			{
				Query<Person> q2 = db.query(Person.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getMidInitials());
				q2.in("midInitials", inList);
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getMidInitials(),entity.getMidInitials());
				}
			}
			//test operator 'like' for field 'MidInitials'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.like("midInitials", entity.getMidInitials() + "%");
				q2.sortASC("midInitials");
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getMidInitials(), entity.getMidInitials()));
				}
			}

			//test field 'LastName', type 'string'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.equals("lastName",entity.getLastName());
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getLastName(),entity.getLastName());
				}
			}
			//test operator 'in' for field 'LastName'
			{
				Query<Person> q2 = db.query(Person.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getLastName());
				q2.in("lastName", inList);
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getLastName(),entity.getLastName());
				}
			}
			//test operator 'like' for field 'LastName'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.like("lastName", entity.getLastName() + "%");
				q2.sortASC("lastName");
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getLastName(), entity.getLastName()));
				}
			}

			//test field 'Phone', type 'string'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.equals("phone",entity.getPhone());
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getPhone(),entity.getPhone());
				}
			}
			//test operator 'in' for field 'Phone'
			{
				Query<Person> q2 = db.query(Person.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getPhone());
				q2.in("phone", inList);
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getPhone(),entity.getPhone());
				}
			}
			//test operator 'like' for field 'Phone'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.like("phone", entity.getPhone() + "%");
				q2.sortASC("phone");
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getPhone(), entity.getPhone()));
				}
			}

			//test field 'PrimaryAffilation', type 'xref'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.equals("primaryAffilation",entity.getPrimaryAffilation_Id());
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getPrimaryAffilation_Id(), entity.getPrimaryAffilation_Id());
				}
			}
			//test operator 'in' for field 'PrimaryAffilation'
			{
				Query<Person> q2 = db.query(Person.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getPrimaryAffilation_Id());
				q2.in("primaryAffilation", inList);
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getPrimaryAffilation_Id(), entity.getPrimaryAffilation_Id());
				}
			}
			//test operator 'equals' for implicit join field 'PrimaryAffilation_name'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.equals("primaryAffilation_name",entity.getPrimaryAffilation_Name());
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getPrimaryAffilation_Id(), entity.getPrimaryAffilation_Id());
				}
			}
			//test operator 'in' for implicit join field 'PrimaryAffilation_name'
			{
				Query<Person> q2 = db.query(Person.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getPrimaryAffilation_Name());
				q2.in("primaryAffilation_name", inList);
				q2.sortDESC("primaryAffilation_name");
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getPrimaryAffilation_Id(), entity.getPrimaryAffilation_Id());
				}
			}

			//test field 'OrcidPersonReference', type 'xref'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.equals("orcidPersonReference",entity.getOrcidPersonReference_Id());
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getOrcidPersonReference_Id(), entity.getOrcidPersonReference_Id());
				}
			}
			//test operator 'in' for field 'OrcidPersonReference'
			{
				Query<Person> q2 = db.query(Person.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getOrcidPersonReference_Id());
				q2.in("orcidPersonReference", inList);
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getOrcidPersonReference_Id(), entity.getOrcidPersonReference_Id());
				}
			}
			//test operator 'equals' for implicit join field 'OrcidPersonReference_Identifier'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.equals("orcidPersonReference_Identifier",entity.getOrcidPersonReference_Identifier());
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getOrcidPersonReference_Id(), entity.getOrcidPersonReference_Id());
				}
			}
			//test operator 'in' for implicit join field 'OrcidPersonReference_Identifier'
			{
				Query<Person> q2 = db.query(Person.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getOrcidPersonReference_Identifier());
				q2.in("orcidPersonReference_Identifier", inList);
				q2.sortDESC("orcidPersonReference_Identifier");
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getOrcidPersonReference_Id(), entity.getOrcidPersonReference_Id());
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testOntologyTerm"})
	public void testCitation() throws DatabaseException
	{
		//create entities
		List<Citation> entities = new ArrayList<Citation>();

		//retrieve xref entity candidates
		List<OntologyTerm> ontologyTermsXrefs = db.query(OntologyTerm.class).find();	
		List<OntologyTerm> statusXrefs = db.query(OntologyTerm.class).find();	

		for(Integer i = 0; i < total; i++)
		{
			Citation e = new Citation();
			e.setIdentifier(truncate("citation_identifier_"+i, 255));
			e.setName(truncate("citation_name_"+i, 255));
			e.setPubmedID(truncate("citation_pubmedid_"+i, 255));
			e.setDOI(truncate("citation_doi_"+i, 255));
			if(ontologyTermsXrefs.size() > 0)
			{
				e.getOntologyTerms_Id().add( ontologyTermsXrefs.get(i).getId() );
				//e.getOntologyTerms().add( random(ontologyTermsXrefs).getId() );
			}
			e.setAuthorList("citation_authorlist_"+i);
			e.setTitle(truncate("citation_title_"+i, 255));
			e.setDescription("citation_description_"+i);
			if(statusXrefs.size() > 0) e.setStatus_Id( statusXrefs.get(i).getId() );
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<Citation> q = db.query(Citation.class);
		assertEquals(total, q.count());
		List<Citation> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getPubmedID(), entitiesDb.get(i).getPubmedID());
			assertEquals(entities.get(i).getDOI(), entitiesDb.get(i).getDOI());
			assertEquals(entities.get(i).getOntologyTerms_Id(), entitiesDb.get(i).getOntologyTerms_Id());
			assertEquals(entities.get(i).getAuthorList(), entitiesDb.get(i).getAuthorList());
			assertEquals(entities.get(i).getTitle(), entitiesDb.get(i).getTitle());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			assertEquals(entities.get(i).getStatus_Id(), entitiesDb.get(i).getStatus_Id());
		}	
		
		//test the query capabilities by finding on all fields
		for(Citation entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<Citation> q2 = db.query(Citation.class);
				q2.equals("id",entity.getId());
				List<Citation> results = q2.find();
				for(Citation r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<Citation> q2 = db.query(Citation.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<Citation> results = q2.find();
				for(Citation r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<Citation> q2 = db.query(Citation.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<Citation> results = q2.find();
				for(Citation r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<Citation> q2 = db.query(Citation.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<Citation> results = q2.find();
				for(Citation r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<Citation> q2 = db.query(Citation.class);
				q2.equals("identifier",entity.getIdentifier());
				List<Citation> results = q2.find();
				for(Citation r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<Citation> q2 = db.query(Citation.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<Citation> results = q2.find();
				for(Citation r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<Citation> q2 = db.query(Citation.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<Citation> results = q2.find();
				for(Citation r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<Citation> q2 = db.query(Citation.class);
				q2.equals("name",entity.getName());
				List<Citation> results = q2.find();
				for(Citation r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<Citation> q2 = db.query(Citation.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<Citation> results = q2.find();
				for(Citation r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<Citation> q2 = db.query(Citation.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<Citation> results = q2.find();
				for(Citation r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'PubmedID', type 'string'
			{
				Query<Citation> q2 = db.query(Citation.class);
				q2.equals("pubmedID",entity.getPubmedID());
				List<Citation> results = q2.find();
				for(Citation r: results)
				{
					assertEquals(r.getPubmedID(),entity.getPubmedID());
				}
			}
			//test operator 'in' for field 'PubmedID'
			{
				Query<Citation> q2 = db.query(Citation.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getPubmedID());
				q2.in("pubmedID", inList);
				List<Citation> results = q2.find();
				for(Citation r: results)
				{
					assertEquals(r.getPubmedID(),entity.getPubmedID());
				}
			}
			//test operator 'like' for field 'PubmedID'
			{
				Query<Citation> q2 = db.query(Citation.class);
				q2.like("pubmedID", entity.getPubmedID() + "%");
				q2.sortASC("pubmedID");
				List<Citation> results = q2.find();
				for(Citation r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getPubmedID(), entity.getPubmedID()));
				}
			}

			//test field 'DOI', type 'string'
			{
				Query<Citation> q2 = db.query(Citation.class);
				q2.equals("dOI",entity.getDOI());
				List<Citation> results = q2.find();
				for(Citation r: results)
				{
					assertEquals(r.getDOI(),entity.getDOI());
				}
			}
			//test operator 'in' for field 'DOI'
			{
				Query<Citation> q2 = db.query(Citation.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDOI());
				q2.in("dOI", inList);
				List<Citation> results = q2.find();
				for(Citation r: results)
				{
					assertEquals(r.getDOI(),entity.getDOI());
				}
			}
			//test operator 'like' for field 'DOI'
			{
				Query<Citation> q2 = db.query(Citation.class);
				q2.like("dOI", entity.getDOI() + "%");
				q2.sortASC("dOI");
				List<Citation> results = q2.find();
				for(Citation r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDOI(), entity.getDOI()));
				}
			}

			//test field 'authorList', type 'text'
			{
				Query<Citation> q2 = db.query(Citation.class);
				q2.equals("authorList",entity.getAuthorList());
				List<Citation> results = q2.find();
				for(Citation r: results)
				{
					assertEquals(r.getAuthorList(),entity.getAuthorList());
				}
			}
			//test operator 'in' for field 'authorList'
			{
				Query<Citation> q2 = db.query(Citation.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getAuthorList());
				q2.in("authorList", inList);
				List<Citation> results = q2.find();
				for(Citation r: results)
				{
					assertEquals(r.getAuthorList(),entity.getAuthorList());
				}
			}
			//test operator 'like' for field 'authorList'
			{
				Query<Citation> q2 = db.query(Citation.class);
				q2.like("authorList", entity.getAuthorList() + "%");
				q2.sortASC("authorList");
				List<Citation> results = q2.find();
				for(Citation r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getAuthorList(), entity.getAuthorList()));
				}
			}

			//test field 'Title', type 'string'
			{
				Query<Citation> q2 = db.query(Citation.class);
				q2.equals("title",entity.getTitle());
				List<Citation> results = q2.find();
				for(Citation r: results)
				{
					assertEquals(r.getTitle(),entity.getTitle());
				}
			}
			//test operator 'in' for field 'Title'
			{
				Query<Citation> q2 = db.query(Citation.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getTitle());
				q2.in("title", inList);
				List<Citation> results = q2.find();
				for(Citation r: results)
				{
					assertEquals(r.getTitle(),entity.getTitle());
				}
			}
			//test operator 'like' for field 'Title'
			{
				Query<Citation> q2 = db.query(Citation.class);
				q2.like("title", entity.getTitle() + "%");
				q2.sortASC("title");
				List<Citation> results = q2.find();
				for(Citation r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getTitle(), entity.getTitle()));
				}
			}

			//test field 'Description', type 'text'
			{
				Query<Citation> q2 = db.query(Citation.class);
				q2.equals("description",entity.getDescription());
				List<Citation> results = q2.find();
				for(Citation r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'Description'
			{
				Query<Citation> q2 = db.query(Citation.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<Citation> results = q2.find();
				for(Citation r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'Description'
			{
				Query<Citation> q2 = db.query(Citation.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<Citation> results = q2.find();
				for(Citation r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

			//test field 'Status', type 'xref'
			{
				Query<Citation> q2 = db.query(Citation.class);
				q2.equals("status",entity.getStatus_Id());
				List<Citation> results = q2.find();
				for(Citation r: results)
				{
					assertEquals(r.getStatus_Id(), entity.getStatus_Id());
				}
			}
			//test operator 'in' for field 'Status'
			{
				Query<Citation> q2 = db.query(Citation.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getStatus_Id());
				q2.in("status", inList);
				List<Citation> results = q2.find();
				for(Citation r: results)
				{
					assertEquals(r.getStatus_Id(), entity.getStatus_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Status_Identifier'
			{
				Query<Citation> q2 = db.query(Citation.class);
				q2.equals("status_Identifier",entity.getStatus_Identifier());
				List<Citation> results = q2.find();
				for(Citation r: results)
				{
					assertEquals(r.getStatus_Id(), entity.getStatus_Id());
				}
			}
			//test operator 'in' for implicit join field 'Status_Identifier'
			{
				Query<Citation> q2 = db.query(Citation.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getStatus_Identifier());
				q2.in("status_Identifier", inList);
				q2.sortDESC("status_Identifier");
				List<Citation> results = q2.find();
				for(Citation r: results)
				{
					assertEquals(r.getStatus_Id(), entity.getStatus_Id());
				}
			}

		}
	}

	@Test
	public void testInvestigation() throws DatabaseException
	{
		//create entities
		List<Investigation> entities = new ArrayList<Investigation>();

		//retrieve xref entity candidates

		for(Integer i = 0; i < total; i++)
		{
			Investigation e = new Investigation();
			e.setIdentifier(truncate("investigation_identifier_"+i, 255));
			e.setName(truncate("investigation_name_"+i, 255));
			e.setTitle("investigation_title_"+i);
			e.setShortName("investigation_shortname_"+i);
			e.setVersion(truncate("investigation_version_"+i, 255));
			e.setBackground("investigation_background_"+i);
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<Investigation> q = db.query(Investigation.class);
		assertEquals(total, q.count());
		List<Investigation> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getTitle(), entitiesDb.get(i).getTitle());
			assertEquals(entities.get(i).getShortName(), entitiesDb.get(i).getShortName());
			assertEquals(entities.get(i).getVersion(), entitiesDb.get(i).getVersion());
			assertEquals(entities.get(i).getBackground(), entitiesDb.get(i).getBackground());
		}	
		
		//test the query capabilities by finding on all fields
		for(Investigation entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<Investigation> q2 = db.query(Investigation.class);
				q2.equals("id",entity.getId());
				List<Investigation> results = q2.find();
				for(Investigation r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<Investigation> q2 = db.query(Investigation.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<Investigation> results = q2.find();
				for(Investigation r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<Investigation> q2 = db.query(Investigation.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<Investigation> results = q2.find();
				for(Investigation r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<Investigation> q2 = db.query(Investigation.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<Investigation> results = q2.find();
				for(Investigation r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<Investigation> q2 = db.query(Investigation.class);
				q2.equals("identifier",entity.getIdentifier());
				List<Investigation> results = q2.find();
				for(Investigation r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<Investigation> q2 = db.query(Investigation.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<Investigation> results = q2.find();
				for(Investigation r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<Investigation> q2 = db.query(Investigation.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<Investigation> results = q2.find();
				for(Investigation r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<Investigation> q2 = db.query(Investigation.class);
				q2.equals("name",entity.getName());
				List<Investigation> results = q2.find();
				for(Investigation r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<Investigation> q2 = db.query(Investigation.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<Investigation> results = q2.find();
				for(Investigation r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<Investigation> q2 = db.query(Investigation.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<Investigation> results = q2.find();
				for(Investigation r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'Title', type 'text'
			{
				Query<Investigation> q2 = db.query(Investigation.class);
				q2.equals("title",entity.getTitle());
				List<Investigation> results = q2.find();
				for(Investigation r: results)
				{
					assertEquals(r.getTitle(),entity.getTitle());
				}
			}
			//test operator 'in' for field 'Title'
			{
				Query<Investigation> q2 = db.query(Investigation.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getTitle());
				q2.in("title", inList);
				List<Investigation> results = q2.find();
				for(Investigation r: results)
				{
					assertEquals(r.getTitle(),entity.getTitle());
				}
			}
			//test operator 'like' for field 'Title'
			{
				Query<Investigation> q2 = db.query(Investigation.class);
				q2.like("title", entity.getTitle() + "%");
				q2.sortASC("title");
				List<Investigation> results = q2.find();
				for(Investigation r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getTitle(), entity.getTitle()));
				}
			}

			//test field 'ShortName', type 'text'
			{
				Query<Investigation> q2 = db.query(Investigation.class);
				q2.equals("shortName",entity.getShortName());
				List<Investigation> results = q2.find();
				for(Investigation r: results)
				{
					assertEquals(r.getShortName(),entity.getShortName());
				}
			}
			//test operator 'in' for field 'ShortName'
			{
				Query<Investigation> q2 = db.query(Investigation.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getShortName());
				q2.in("shortName", inList);
				List<Investigation> results = q2.find();
				for(Investigation r: results)
				{
					assertEquals(r.getShortName(),entity.getShortName());
				}
			}
			//test operator 'like' for field 'ShortName'
			{
				Query<Investigation> q2 = db.query(Investigation.class);
				q2.like("shortName", entity.getShortName() + "%");
				q2.sortASC("shortName");
				List<Investigation> results = q2.find();
				for(Investigation r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getShortName(), entity.getShortName()));
				}
			}

			//test field 'Version', type 'string'
			{
				Query<Investigation> q2 = db.query(Investigation.class);
				q2.equals("version",entity.getVersion());
				List<Investigation> results = q2.find();
				for(Investigation r: results)
				{
					assertEquals(r.getVersion(),entity.getVersion());
				}
			}
			//test operator 'in' for field 'Version'
			{
				Query<Investigation> q2 = db.query(Investigation.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getVersion());
				q2.in("version", inList);
				List<Investigation> results = q2.find();
				for(Investigation r: results)
				{
					assertEquals(r.getVersion(),entity.getVersion());
				}
			}
			//test operator 'like' for field 'Version'
			{
				Query<Investigation> q2 = db.query(Investigation.class);
				q2.like("version", entity.getVersion() + "%");
				q2.sortASC("version");
				List<Investigation> results = q2.find();
				for(Investigation r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getVersion(), entity.getVersion()));
				}
			}

			//test field 'Background', type 'text'
			{
				Query<Investigation> q2 = db.query(Investigation.class);
				q2.equals("background",entity.getBackground());
				List<Investigation> results = q2.find();
				for(Investigation r: results)
				{
					assertEquals(r.getBackground(),entity.getBackground());
				}
			}
			//test operator 'in' for field 'Background'
			{
				Query<Investigation> q2 = db.query(Investigation.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getBackground());
				q2.in("background", inList);
				List<Investigation> results = q2.find();
				for(Investigation r: results)
				{
					assertEquals(r.getBackground(),entity.getBackground());
				}
			}
			//test operator 'like' for field 'Background'
			{
				Query<Investigation> q2 = db.query(Investigation.class);
				q2.like("background", entity.getBackground() + "%");
				q2.sortASC("background");
				List<Investigation> results = q2.find();
				for(Investigation r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getBackground(), entity.getBackground()));
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testPerson","testInvestigation"})
	public void testStudy() throws DatabaseException
	{
		//create entities
		List<Study> entities = new ArrayList<Study>();

		//retrieve xref entity candidates
		List<Person> contactXrefs = db.query(Person.class).find();	
		List<Investigation> partOfInvestigationXrefs = db.query(Investigation.class).find();	

		for(Integer i = 0; i < total; i++)
		{
			Study e = new Study();
			e.setIdentifier(truncate("study_identifier_"+i, 255));
			e.setName(truncate("study_name_"+i, 255));
			e.setDescription("study_description_"+i);
			e.setEndDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			if(contactXrefs.size() > 0) e.setContact_Id( contactXrefs.get(i).getId() );
			if(partOfInvestigationXrefs.size() > 0) e.setPartOfInvestigation_Id( partOfInvestigationXrefs.get(i).getId() );
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<Study> q = db.query(Study.class);
		assertEquals(total, q.count());
		List<Study> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			//check formatted because of milliseconds rounding
			assertEquals(dateTimeFormat.format(entities.get(i).getEndDate()),dateTimeFormat.format(entitiesDb.get(i).getEndDate()));
			assertEquals(entities.get(i).getContact_Id(), entitiesDb.get(i).getContact_Id());
			assertEquals(entities.get(i).getPartOfInvestigation_Id(), entitiesDb.get(i).getPartOfInvestigation_Id());
		}	
		
		//test the query capabilities by finding on all fields
		for(Study entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<Study> q2 = db.query(Study.class);
				q2.equals("id",entity.getId());
				List<Study> results = q2.find();
				for(Study r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<Study> q2 = db.query(Study.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<Study> results = q2.find();
				for(Study r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<Study> q2 = db.query(Study.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<Study> results = q2.find();
				for(Study r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<Study> q2 = db.query(Study.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<Study> results = q2.find();
				for(Study r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<Study> q2 = db.query(Study.class);
				q2.equals("identifier",entity.getIdentifier());
				List<Study> results = q2.find();
				for(Study r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<Study> q2 = db.query(Study.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<Study> results = q2.find();
				for(Study r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<Study> q2 = db.query(Study.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<Study> results = q2.find();
				for(Study r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<Study> q2 = db.query(Study.class);
				q2.equals("name",entity.getName());
				List<Study> results = q2.find();
				for(Study r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<Study> q2 = db.query(Study.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<Study> results = q2.find();
				for(Study r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<Study> q2 = db.query(Study.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<Study> results = q2.find();
				for(Study r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'Description', type 'text'
			{
				Query<Study> q2 = db.query(Study.class);
				q2.equals("description",entity.getDescription());
				List<Study> results = q2.find();
				for(Study r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'Description'
			{
				Query<Study> q2 = db.query(Study.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<Study> results = q2.find();
				for(Study r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'Description'
			{
				Query<Study> q2 = db.query(Study.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<Study> results = q2.find();
				for(Study r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

			//test field 'Contact', type 'xref'
			{
				Query<Study> q2 = db.query(Study.class);
				q2.equals("contact",entity.getContact_Id());
				List<Study> results = q2.find();
				for(Study r: results)
				{
					assertEquals(r.getContact_Id(), entity.getContact_Id());
				}
			}
			//test operator 'in' for field 'Contact'
			{
				Query<Study> q2 = db.query(Study.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getContact_Id());
				q2.in("contact", inList);
				List<Study> results = q2.find();
				for(Study r: results)
				{
					assertEquals(r.getContact_Id(), entity.getContact_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Contact_Name'
			{
				Query<Study> q2 = db.query(Study.class);
				q2.equals("contact_Name",entity.getContact_Name());
				List<Study> results = q2.find();
				for(Study r: results)
				{
					assertEquals(r.getContact_Id(), entity.getContact_Id());
				}
			}
			//test operator 'in' for implicit join field 'Contact_Name'
			{
				Query<Study> q2 = db.query(Study.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getContact_Name());
				q2.in("contact_Name", inList);
				q2.sortDESC("contact_Name");
				List<Study> results = q2.find();
				for(Study r: results)
				{
					assertEquals(r.getContact_Id(), entity.getContact_Id());
				}
			}

			//test field 'PartOfInvestigation', type 'xref'
			{
				Query<Study> q2 = db.query(Study.class);
				q2.equals("partOfInvestigation",entity.getPartOfInvestigation_Id());
				List<Study> results = q2.find();
				for(Study r: results)
				{
					assertEquals(r.getPartOfInvestigation_Id(), entity.getPartOfInvestigation_Id());
				}
			}
			//test operator 'in' for field 'PartOfInvestigation'
			{
				Query<Study> q2 = db.query(Study.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getPartOfInvestigation_Id());
				q2.in("partOfInvestigation", inList);
				List<Study> results = q2.find();
				for(Study r: results)
				{
					assertEquals(r.getPartOfInvestigation_Id(), entity.getPartOfInvestigation_Id());
				}
			}
			//test operator 'equals' for implicit join field 'PartOfInvestigation_Identifier'
			{
				Query<Study> q2 = db.query(Study.class);
				q2.equals("partOfInvestigation_Identifier",entity.getPartOfInvestigation_Identifier());
				List<Study> results = q2.find();
				for(Study r: results)
				{
					assertEquals(r.getPartOfInvestigation_Id(), entity.getPartOfInvestigation_Id());
				}
			}
			//test operator 'in' for implicit join field 'PartOfInvestigation_Identifier'
			{
				Query<Study> q2 = db.query(Study.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getPartOfInvestigation_Identifier());
				q2.in("partOfInvestigation_Identifier", inList);
				q2.sortDESC("partOfInvestigation_Identifier");
				List<Study> results = q2.find();
				for(Study r: results)
				{
					assertEquals(r.getPartOfInvestigation_Id(), entity.getPartOfInvestigation_Id());
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testStudy","testOntologyTerm"})
	public void testExperiment() throws DatabaseException
	{
		//create entities
		List<Experiment> entities = new ArrayList<Experiment>();

		//retrieve xref entity candidates
		List<Study> studyXrefs = db.query(Study.class).find();	
		List<OntologyTerm> experimentTypeXrefs = db.query(OntologyTerm.class).find();	
		List<Panel> assayedPanelsXrefs = db.query(Panel.class).eq("__Type",Panel.class.getSimpleName()).find();	
		List<DataSet> dataSetsXrefs = db.query(DataSet.class).eq("__Type",DataSet.class.getSimpleName()).find();	

		for(Integer i = 0; i < total; i++)
		{
			Experiment e = new Experiment();
			e.setIdentifier(truncate("experiment_identifier_"+i, 255));
			e.setName(truncate("experiment_name_"+i, 255));
			if(studyXrefs.size() > 0) e.setStudy_Id( studyXrefs.get(i).getId() );
			e.setDesign(truncate("experiment_design_"+i, 50));
			if(experimentTypeXrefs.size() > 0) e.setExperimentType_Id( experimentTypeXrefs.get(i).getId() );
			e.setTotalMarkersTested(i);
			e.setTotalMarkersImported(i);
			e.setObjective("experiment_objective_"+i);
			e.setOutcome("experiment_outcome_"+i);
			e.setComments("experiment_comments_"+i);
			e.setIndividualDataStatement("experiment_individualdatastatement_"+i);
			e.setTimeCreated(new java.sql.Timestamp(new java.util.Date().getTime()));
			if(assayedPanelsXrefs.size() > 0)
			{
				e.getAssayedPanels_Id().add( assayedPanelsXrefs.get(i).getId() );
				//e.getAssayedPanels().add( random(assayedPanelsXrefs).getId() );
			}
			if(dataSetsXrefs.size() > 0)
			{
				e.getDataSets_Id().add( dataSetsXrefs.get(i).getId() );
				//e.getDataSets().add( random(dataSetsXrefs).getId() );
			}
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<Experiment> q = db.query(Experiment.class).eq("__Type",Experiment.class.getSimpleName());
		assertEquals(total, q.count());
		List<Experiment> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getStudy_Id(), entitiesDb.get(i).getStudy_Id());
			assertEquals(entities.get(i).getDesign(), entitiesDb.get(i).getDesign());
			assertEquals(entities.get(i).getExperimentType_Id(), entitiesDb.get(i).getExperimentType_Id());
			assertEquals(entities.get(i).getTotalMarkersTested(), entitiesDb.get(i).getTotalMarkersTested());
			assertEquals(entities.get(i).getTotalMarkersImported(), entitiesDb.get(i).getTotalMarkersImported());
			assertEquals(entities.get(i).getObjective(), entitiesDb.get(i).getObjective());
			assertEquals(entities.get(i).getOutcome(), entitiesDb.get(i).getOutcome());
			assertEquals(entities.get(i).getComments(), entitiesDb.get(i).getComments());
			assertEquals(entities.get(i).getIndividualDataStatement(), entitiesDb.get(i).getIndividualDataStatement());
			//check formatted because of milliseconds rounding
			assertEquals(dateTimeFormat.format(entities.get(i).getTimeCreated()),dateTimeFormat.format(entitiesDb.get(i).getTimeCreated()));
			assertEquals(entities.get(i).getAssayedPanels_Id(), entitiesDb.get(i).getAssayedPanels_Id());
			assertEquals(entities.get(i).getDataSets_Id(), entitiesDb.get(i).getDataSets_Id());
		}	
		
		//test the query capabilities by finding on all fields
		for(Experiment entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				q2.equals("id",entity.getId());
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				q2.equals("identifier",entity.getIdentifier());
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				q2.equals("name",entity.getName());
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'Study', type 'xref'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				q2.equals("study",entity.getStudy_Id());
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertEquals(r.getStudy_Id(), entity.getStudy_Id());
				}
			}
			//test operator 'in' for field 'Study'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getStudy_Id());
				q2.in("study", inList);
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertEquals(r.getStudy_Id(), entity.getStudy_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Study_Identifier'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				q2.equals("study_Identifier",entity.getStudy_Identifier());
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertEquals(r.getStudy_Id(), entity.getStudy_Id());
				}
			}
			//test operator 'in' for implicit join field 'Study_Identifier'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getStudy_Identifier());
				q2.in("study_Identifier", inList);
				q2.sortDESC("study_Identifier");
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertEquals(r.getStudy_Id(), entity.getStudy_Id());
				}
			}

			//test field 'Design', type 'string'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				q2.equals("design",entity.getDesign());
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertEquals(r.getDesign(),entity.getDesign());
				}
			}
			//test operator 'in' for field 'Design'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDesign());
				q2.in("design", inList);
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertEquals(r.getDesign(),entity.getDesign());
				}
			}
			//test operator 'like' for field 'Design'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				q2.like("design", entity.getDesign() + "%");
				q2.sortASC("design");
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDesign(), entity.getDesign()));
				}
			}

			//test field 'ExperimentType', type 'xref'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				q2.equals("experimentType",entity.getExperimentType_Id());
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertEquals(r.getExperimentType_Id(), entity.getExperimentType_Id());
				}
			}
			//test operator 'in' for field 'ExperimentType'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getExperimentType_Id());
				q2.in("experimentType", inList);
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertEquals(r.getExperimentType_Id(), entity.getExperimentType_Id());
				}
			}
			//test operator 'equals' for implicit join field 'ExperimentType_Identifier'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				q2.equals("experimentType_Identifier",entity.getExperimentType_Identifier());
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertEquals(r.getExperimentType_Id(), entity.getExperimentType_Id());
				}
			}
			//test operator 'in' for implicit join field 'ExperimentType_Identifier'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getExperimentType_Identifier());
				q2.in("experimentType_Identifier", inList);
				q2.sortDESC("experimentType_Identifier");
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertEquals(r.getExperimentType_Id(), entity.getExperimentType_Id());
				}
			}

			//test field 'TotalMarkersTested', type 'int'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				q2.equals("totalMarkersTested",entity.getTotalMarkersTested());
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertEquals(r.getTotalMarkersTested(),entity.getTotalMarkersTested());
				}
			}
			//test operator 'in' for field 'TotalMarkersTested'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getTotalMarkersTested());
				q2.in("totalMarkersTested", inList);
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertEquals(r.getTotalMarkersTested(),entity.getTotalMarkersTested());
				}
			}
			//test operator 'lessOrEqual' for field 'TotalMarkersTested'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				q2.lessOrEqual("totalMarkersTested", entity.getTotalMarkersTested());
				q2.sortASC("totalMarkersTested");
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertTrue(r.getTotalMarkersTested().compareTo(entity.getTotalMarkersTested()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'TotalMarkersTested'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				q2.greaterOrEqual("totalMarkersTested", entity.getTotalMarkersTested());
				q2.sortDESC("totalMarkersTested");
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertTrue(r.getTotalMarkersTested().compareTo(entity.getTotalMarkersTested()) > -1);
				}
			}

			//test field 'TotalMarkersImported', type 'int'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				q2.equals("totalMarkersImported",entity.getTotalMarkersImported());
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertEquals(r.getTotalMarkersImported(),entity.getTotalMarkersImported());
				}
			}
			//test operator 'in' for field 'TotalMarkersImported'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getTotalMarkersImported());
				q2.in("totalMarkersImported", inList);
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertEquals(r.getTotalMarkersImported(),entity.getTotalMarkersImported());
				}
			}
			//test operator 'lessOrEqual' for field 'TotalMarkersImported'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				q2.lessOrEqual("totalMarkersImported", entity.getTotalMarkersImported());
				q2.sortASC("totalMarkersImported");
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertTrue(r.getTotalMarkersImported().compareTo(entity.getTotalMarkersImported()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'TotalMarkersImported'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				q2.greaterOrEqual("totalMarkersImported", entity.getTotalMarkersImported());
				q2.sortDESC("totalMarkersImported");
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertTrue(r.getTotalMarkersImported().compareTo(entity.getTotalMarkersImported()) > -1);
				}
			}

			//test field 'Objective', type 'text'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				q2.equals("objective",entity.getObjective());
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertEquals(r.getObjective(),entity.getObjective());
				}
			}
			//test operator 'in' for field 'Objective'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getObjective());
				q2.in("objective", inList);
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertEquals(r.getObjective(),entity.getObjective());
				}
			}
			//test operator 'like' for field 'Objective'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				q2.like("objective", entity.getObjective() + "%");
				q2.sortASC("objective");
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getObjective(), entity.getObjective()));
				}
			}

			//test field 'Outcome', type 'text'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				q2.equals("outcome",entity.getOutcome());
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertEquals(r.getOutcome(),entity.getOutcome());
				}
			}
			//test operator 'in' for field 'Outcome'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getOutcome());
				q2.in("outcome", inList);
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertEquals(r.getOutcome(),entity.getOutcome());
				}
			}
			//test operator 'like' for field 'Outcome'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				q2.like("outcome", entity.getOutcome() + "%");
				q2.sortASC("outcome");
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getOutcome(), entity.getOutcome()));
				}
			}

			//test field 'Comments', type 'text'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				q2.equals("comments",entity.getComments());
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertEquals(r.getComments(),entity.getComments());
				}
			}
			//test operator 'in' for field 'Comments'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getComments());
				q2.in("comments", inList);
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertEquals(r.getComments(),entity.getComments());
				}
			}
			//test operator 'like' for field 'Comments'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				q2.like("comments", entity.getComments() + "%");
				q2.sortASC("comments");
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getComments(), entity.getComments()));
				}
			}

			//test field 'IndividualDataStatement', type 'text'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				q2.equals("individualDataStatement",entity.getIndividualDataStatement());
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertEquals(r.getIndividualDataStatement(),entity.getIndividualDataStatement());
				}
			}
			//test operator 'in' for field 'IndividualDataStatement'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIndividualDataStatement());
				q2.in("individualDataStatement", inList);
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertEquals(r.getIndividualDataStatement(),entity.getIndividualDataStatement());
				}
			}
			//test operator 'like' for field 'IndividualDataStatement'
			{
				Query<Experiment> q2 = db.query(Experiment.class);
				q2.like("individualDataStatement", entity.getIndividualDataStatement() + "%");
				q2.sortASC("individualDataStatement");
				List<Experiment> results = q2.find();
				for(Experiment r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIndividualDataStatement(), entity.getIndividualDataStatement()));
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testStudy"})
	public void testSubmission() throws DatabaseException
	{
		//create entities
		List<Submission> entities = new ArrayList<Submission>();

		//retrieve xref entity candidates
		List<Study> studyXrefs = db.query(Study.class).find();	

		for(Integer i = 0; i < total; i++)
		{
			Submission e = new Submission();
			e.setIdentifier(truncate("submission_identifier_"+i, 255));
			e.setName(truncate("submission_name_"+i, 255));
			e.setTimeCreated(new java.sql.Timestamp(new java.util.Date().getTime()));
			if(studyXrefs.size() > 0) e.setStudy_Id( studyXrefs.get(i).getId() );
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<Submission> q = db.query(Submission.class);
		assertEquals(total, q.count());
		List<Submission> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			//check formatted because of milliseconds rounding
			assertEquals(dateTimeFormat.format(entities.get(i).getTimeCreated()),dateTimeFormat.format(entitiesDb.get(i).getTimeCreated()));
			assertEquals(entities.get(i).getStudy_Id(), entitiesDb.get(i).getStudy_Id());
		}	
		
		//test the query capabilities by finding on all fields
		for(Submission entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<Submission> q2 = db.query(Submission.class);
				q2.equals("id",entity.getId());
				List<Submission> results = q2.find();
				for(Submission r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<Submission> q2 = db.query(Submission.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<Submission> results = q2.find();
				for(Submission r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<Submission> q2 = db.query(Submission.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<Submission> results = q2.find();
				for(Submission r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<Submission> q2 = db.query(Submission.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<Submission> results = q2.find();
				for(Submission r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<Submission> q2 = db.query(Submission.class);
				q2.equals("identifier",entity.getIdentifier());
				List<Submission> results = q2.find();
				for(Submission r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<Submission> q2 = db.query(Submission.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<Submission> results = q2.find();
				for(Submission r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<Submission> q2 = db.query(Submission.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<Submission> results = q2.find();
				for(Submission r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<Submission> q2 = db.query(Submission.class);
				q2.equals("name",entity.getName());
				List<Submission> results = q2.find();
				for(Submission r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<Submission> q2 = db.query(Submission.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<Submission> results = q2.find();
				for(Submission r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<Submission> q2 = db.query(Submission.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<Submission> results = q2.find();
				for(Submission r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'Study', type 'xref'
			{
				Query<Submission> q2 = db.query(Submission.class);
				q2.equals("study",entity.getStudy_Id());
				List<Submission> results = q2.find();
				for(Submission r: results)
				{
					assertEquals(r.getStudy_Id(), entity.getStudy_Id());
				}
			}
			//test operator 'in' for field 'Study'
			{
				Query<Submission> q2 = db.query(Submission.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getStudy_Id());
				q2.in("study", inList);
				List<Submission> results = q2.find();
				for(Submission r: results)
				{
					assertEquals(r.getStudy_Id(), entity.getStudy_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Study_Identifier'
			{
				Query<Submission> q2 = db.query(Submission.class);
				q2.equals("study_Identifier",entity.getStudy_Identifier());
				List<Submission> results = q2.find();
				for(Submission r: results)
				{
					assertEquals(r.getStudy_Id(), entity.getStudy_Id());
				}
			}
			//test operator 'in' for implicit join field 'Study_Identifier'
			{
				Query<Submission> q2 = db.query(Submission.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getStudy_Identifier());
				q2.in("study_Identifier", inList);
				q2.sortDESC("study_Identifier");
				List<Submission> results = q2.find();
				for(Submission r: results)
				{
					assertEquals(r.getStudy_Id(), entity.getStudy_Id());
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testPerson","testSubmission"})
	public void testContribution() throws DatabaseException
	{
		//create entities
		List<Contribution> entities = new ArrayList<Contribution>();

		//retrieve xref entity candidates
		List<Person> researcherXrefs = db.query(Person.class).find();	
		List<Submission> submissionXrefs = db.query(Submission.class).find();	

		for(Integer i = 0; i < total; i++)
		{
			Contribution e = new Contribution();
			e.setIdentifier(truncate("contribution_identifier_"+i, 255));
			e.setName(truncate("contribution_name_"+i, 255));
			if(researcherXrefs.size() > 0) e.setResearcher_Id( researcherXrefs.get(i).getId() );
			if(submissionXrefs.size() > 0) e.setSubmission_Id( submissionXrefs.get(i).getId() );
			e.setIsSubmitter(randomEnum(new String[]{"yes","no"}));
			e.setIsAuthor(randomEnum(new String[]{"yes","no"}));
			e.setIsSource(randomEnum(new String[]{"yes","no"}));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<Contribution> q = db.query(Contribution.class);
		assertEquals(total, q.count());
		List<Contribution> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getResearcher_Id(), entitiesDb.get(i).getResearcher_Id());
			assertEquals(entities.get(i).getSubmission_Id(), entitiesDb.get(i).getSubmission_Id());
			assertEquals(entities.get(i).getIsSubmitter(), entitiesDb.get(i).getIsSubmitter());
			assertEquals(entities.get(i).getIsAuthor(), entitiesDb.get(i).getIsAuthor());
			assertEquals(entities.get(i).getIsSource(), entitiesDb.get(i).getIsSource());
		}	
		
		//test the query capabilities by finding on all fields
		for(Contribution entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<Contribution> q2 = db.query(Contribution.class);
				q2.equals("id",entity.getId());
				List<Contribution> results = q2.find();
				for(Contribution r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<Contribution> q2 = db.query(Contribution.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<Contribution> results = q2.find();
				for(Contribution r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<Contribution> q2 = db.query(Contribution.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<Contribution> results = q2.find();
				for(Contribution r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<Contribution> q2 = db.query(Contribution.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<Contribution> results = q2.find();
				for(Contribution r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<Contribution> q2 = db.query(Contribution.class);
				q2.equals("identifier",entity.getIdentifier());
				List<Contribution> results = q2.find();
				for(Contribution r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<Contribution> q2 = db.query(Contribution.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<Contribution> results = q2.find();
				for(Contribution r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<Contribution> q2 = db.query(Contribution.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<Contribution> results = q2.find();
				for(Contribution r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<Contribution> q2 = db.query(Contribution.class);
				q2.equals("name",entity.getName());
				List<Contribution> results = q2.find();
				for(Contribution r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<Contribution> q2 = db.query(Contribution.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<Contribution> results = q2.find();
				for(Contribution r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<Contribution> q2 = db.query(Contribution.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<Contribution> results = q2.find();
				for(Contribution r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'Researcher', type 'xref'
			{
				Query<Contribution> q2 = db.query(Contribution.class);
				q2.equals("researcher",entity.getResearcher_Id());
				List<Contribution> results = q2.find();
				for(Contribution r: results)
				{
					assertEquals(r.getResearcher_Id(), entity.getResearcher_Id());
				}
			}
			//test operator 'in' for field 'Researcher'
			{
				Query<Contribution> q2 = db.query(Contribution.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getResearcher_Id());
				q2.in("researcher", inList);
				List<Contribution> results = q2.find();
				for(Contribution r: results)
				{
					assertEquals(r.getResearcher_Id(), entity.getResearcher_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Researcher_Name'
			{
				Query<Contribution> q2 = db.query(Contribution.class);
				q2.equals("researcher_Name",entity.getResearcher_Name());
				List<Contribution> results = q2.find();
				for(Contribution r: results)
				{
					assertEquals(r.getResearcher_Id(), entity.getResearcher_Id());
				}
			}
			//test operator 'in' for implicit join field 'Researcher_Name'
			{
				Query<Contribution> q2 = db.query(Contribution.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getResearcher_Name());
				q2.in("researcher_Name", inList);
				q2.sortDESC("researcher_Name");
				List<Contribution> results = q2.find();
				for(Contribution r: results)
				{
					assertEquals(r.getResearcher_Id(), entity.getResearcher_Id());
				}
			}

			//test field 'Submission', type 'xref'
			{
				Query<Contribution> q2 = db.query(Contribution.class);
				q2.equals("submission",entity.getSubmission_Id());
				List<Contribution> results = q2.find();
				for(Contribution r: results)
				{
					assertEquals(r.getSubmission_Id(), entity.getSubmission_Id());
				}
			}
			//test operator 'in' for field 'Submission'
			{
				Query<Contribution> q2 = db.query(Contribution.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getSubmission_Id());
				q2.in("submission", inList);
				List<Contribution> results = q2.find();
				for(Contribution r: results)
				{
					assertEquals(r.getSubmission_Id(), entity.getSubmission_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Submission_Identifier'
			{
				Query<Contribution> q2 = db.query(Contribution.class);
				q2.equals("submission_Identifier",entity.getSubmission_Identifier());
				List<Contribution> results = q2.find();
				for(Contribution r: results)
				{
					assertEquals(r.getSubmission_Id(), entity.getSubmission_Id());
				}
			}
			//test operator 'in' for implicit join field 'Submission_Identifier'
			{
				Query<Contribution> q2 = db.query(Contribution.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getSubmission_Identifier());
				q2.in("submission_Identifier", inList);
				q2.sortDESC("submission_Identifier");
				List<Contribution> results = q2.find();
				for(Contribution r: results)
				{
					assertEquals(r.getSubmission_Id(), entity.getSubmission_Id());
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testStudy","testCitation"})
	public void testStudyDetails() throws DatabaseException
	{
		//create entities
		List<StudyDetails> entities = new ArrayList<StudyDetails>();

		//retrieve xref entity candidates
		List<Study> studyXrefs = db.query(Study.class).find();	
		List<Citation> primaryCitationXrefs = db.query(Citation.class).find();	
		List<Citation> otherCitationsXrefs = db.query(Citation.class).find();	

		for(Integer i = 0; i < total; i++)
		{
			StudyDetails e = new StudyDetails();
			if(studyXrefs.size() > 0) e.setStudy_Id( studyXrefs.get(i).getId() );
			e.setTitle("studydetails_title_"+i);
			e.setShortName("studydetails_shortname_"+i);
			e.setStudyAbstract("studydetails_studyabstract_"+i);
			e.setVersion(truncate("studydetails_version_"+i, 255));
			e.setBackground("studydetails_background_"+i);
			e.setObjectives("studydetails_objectives_"+i);
			e.setKeyResults("studydetails_keyresults_"+i);
			e.setConclusions("studydetails_conclusions_"+i);
			e.setStudyDesign("studydetails_studydesign_"+i);
			e.setStudySizeReason("studydetails_studysizereason_"+i);
			e.setStudyPower("studydetails_studypower_"+i);
			e.setSourcesOfBias("studydetails_sourcesofbias_"+i);
			e.setLimitations("studydetails_limitations_"+i);
			e.setAcknowledgements("studydetails_acknowledgements_"+i);
			if(primaryCitationXrefs.size() > 0) e.setPrimaryCitation_Id( primaryCitationXrefs.get(i).getId() );
			if(otherCitationsXrefs.size() > 0)
			{
				e.getOtherCitations_Id().add( otherCitationsXrefs.get(i).getId() );
				//e.getOtherCitations().add( random(otherCitationsXrefs).getId() );
			}
			e.setAccession("studydetails_accession_"+i);
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<StudyDetails> q = db.query(StudyDetails.class);
		assertEquals(total, q.count());
		List<StudyDetails> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getStudy_Id(), entitiesDb.get(i).getStudy_Id());
			assertEquals(entities.get(i).getTitle(), entitiesDb.get(i).getTitle());
			assertEquals(entities.get(i).getShortName(), entitiesDb.get(i).getShortName());
			assertEquals(entities.get(i).getStudyAbstract(), entitiesDb.get(i).getStudyAbstract());
			assertEquals(entities.get(i).getVersion(), entitiesDb.get(i).getVersion());
			assertEquals(entities.get(i).getBackground(), entitiesDb.get(i).getBackground());
			assertEquals(entities.get(i).getObjectives(), entitiesDb.get(i).getObjectives());
			assertEquals(entities.get(i).getKeyResults(), entitiesDb.get(i).getKeyResults());
			assertEquals(entities.get(i).getConclusions(), entitiesDb.get(i).getConclusions());
			assertEquals(entities.get(i).getStudyDesign(), entitiesDb.get(i).getStudyDesign());
			assertEquals(entities.get(i).getStudySizeReason(), entitiesDb.get(i).getStudySizeReason());
			assertEquals(entities.get(i).getStudyPower(), entitiesDb.get(i).getStudyPower());
			assertEquals(entities.get(i).getSourcesOfBias(), entitiesDb.get(i).getSourcesOfBias());
			assertEquals(entities.get(i).getLimitations(), entitiesDb.get(i).getLimitations());
			assertEquals(entities.get(i).getAcknowledgements(), entitiesDb.get(i).getAcknowledgements());
			assertEquals(entities.get(i).getPrimaryCitation_Id(), entitiesDb.get(i).getPrimaryCitation_Id());
			assertEquals(entities.get(i).getOtherCitations_Id(), entitiesDb.get(i).getOtherCitations_Id());
			assertEquals(entities.get(i).getAccession(), entitiesDb.get(i).getAccession());
		}	
		
		//test the query capabilities by finding on all fields
		for(StudyDetails entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				q2.equals("id",entity.getId());
				List<StudyDetails> results = q2.find();
				assertEquals(results.size(),1);
				for(StudyDetails r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<StudyDetails> results = q2.find();
				assertEquals(results.size(),1);
				for(StudyDetails r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Study', type 'xref'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				q2.equals("study",entity.getStudy_Id());
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertEquals(r.getStudy_Id(), entity.getStudy_Id());
				}
			}
			//test operator 'in' for field 'Study'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getStudy_Id());
				q2.in("study", inList);
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertEquals(r.getStudy_Id(), entity.getStudy_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Study_Identifier'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				q2.equals("study_Identifier",entity.getStudy_Identifier());
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertEquals(r.getStudy_Id(), entity.getStudy_Id());
				}
			}
			//test operator 'in' for implicit join field 'Study_Identifier'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getStudy_Identifier());
				q2.in("study_Identifier", inList);
				q2.sortDESC("study_Identifier");
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertEquals(r.getStudy_Id(), entity.getStudy_Id());
				}
			}

			//test field 'Title', type 'text'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				q2.equals("title",entity.getTitle());
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertEquals(r.getTitle(),entity.getTitle());
				}
			}
			//test operator 'in' for field 'Title'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getTitle());
				q2.in("title", inList);
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertEquals(r.getTitle(),entity.getTitle());
				}
			}
			//test operator 'like' for field 'Title'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				q2.like("title", entity.getTitle() + "%");
				q2.sortASC("title");
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getTitle(), entity.getTitle()));
				}
			}

			//test field 'ShortName', type 'text'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				q2.equals("shortName",entity.getShortName());
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertEquals(r.getShortName(),entity.getShortName());
				}
			}
			//test operator 'in' for field 'ShortName'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getShortName());
				q2.in("shortName", inList);
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertEquals(r.getShortName(),entity.getShortName());
				}
			}
			//test operator 'like' for field 'ShortName'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				q2.like("shortName", entity.getShortName() + "%");
				q2.sortASC("shortName");
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getShortName(), entity.getShortName()));
				}
			}

			//test field 'StudyAbstract', type 'text'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				q2.equals("studyAbstract",entity.getStudyAbstract());
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertEquals(r.getStudyAbstract(),entity.getStudyAbstract());
				}
			}
			//test operator 'in' for field 'StudyAbstract'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getStudyAbstract());
				q2.in("studyAbstract", inList);
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertEquals(r.getStudyAbstract(),entity.getStudyAbstract());
				}
			}
			//test operator 'like' for field 'StudyAbstract'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				q2.like("studyAbstract", entity.getStudyAbstract() + "%");
				q2.sortASC("studyAbstract");
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getStudyAbstract(), entity.getStudyAbstract()));
				}
			}

			//test field 'Version', type 'string'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				q2.equals("version",entity.getVersion());
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertEquals(r.getVersion(),entity.getVersion());
				}
			}
			//test operator 'in' for field 'Version'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getVersion());
				q2.in("version", inList);
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertEquals(r.getVersion(),entity.getVersion());
				}
			}
			//test operator 'like' for field 'Version'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				q2.like("version", entity.getVersion() + "%");
				q2.sortASC("version");
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getVersion(), entity.getVersion()));
				}
			}

			//test field 'Background', type 'text'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				q2.equals("background",entity.getBackground());
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertEquals(r.getBackground(),entity.getBackground());
				}
			}
			//test operator 'in' for field 'Background'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getBackground());
				q2.in("background", inList);
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertEquals(r.getBackground(),entity.getBackground());
				}
			}
			//test operator 'like' for field 'Background'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				q2.like("background", entity.getBackground() + "%");
				q2.sortASC("background");
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getBackground(), entity.getBackground()));
				}
			}

			//test field 'Objectives', type 'text'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				q2.equals("objectives",entity.getObjectives());
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertEquals(r.getObjectives(),entity.getObjectives());
				}
			}
			//test operator 'in' for field 'Objectives'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getObjectives());
				q2.in("objectives", inList);
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertEquals(r.getObjectives(),entity.getObjectives());
				}
			}
			//test operator 'like' for field 'Objectives'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				q2.like("objectives", entity.getObjectives() + "%");
				q2.sortASC("objectives");
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getObjectives(), entity.getObjectives()));
				}
			}

			//test field 'KeyResults', type 'text'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				q2.equals("keyResults",entity.getKeyResults());
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertEquals(r.getKeyResults(),entity.getKeyResults());
				}
			}
			//test operator 'in' for field 'KeyResults'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getKeyResults());
				q2.in("keyResults", inList);
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertEquals(r.getKeyResults(),entity.getKeyResults());
				}
			}
			//test operator 'like' for field 'KeyResults'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				q2.like("keyResults", entity.getKeyResults() + "%");
				q2.sortASC("keyResults");
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getKeyResults(), entity.getKeyResults()));
				}
			}

			//test field 'Conclusions', type 'text'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				q2.equals("conclusions",entity.getConclusions());
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertEquals(r.getConclusions(),entity.getConclusions());
				}
			}
			//test operator 'in' for field 'Conclusions'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getConclusions());
				q2.in("conclusions", inList);
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertEquals(r.getConclusions(),entity.getConclusions());
				}
			}
			//test operator 'like' for field 'Conclusions'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				q2.like("conclusions", entity.getConclusions() + "%");
				q2.sortASC("conclusions");
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getConclusions(), entity.getConclusions()));
				}
			}

			//test field 'StudyDesign', type 'text'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				q2.equals("studyDesign",entity.getStudyDesign());
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertEquals(r.getStudyDesign(),entity.getStudyDesign());
				}
			}
			//test operator 'in' for field 'StudyDesign'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getStudyDesign());
				q2.in("studyDesign", inList);
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertEquals(r.getStudyDesign(),entity.getStudyDesign());
				}
			}
			//test operator 'like' for field 'StudyDesign'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				q2.like("studyDesign", entity.getStudyDesign() + "%");
				q2.sortASC("studyDesign");
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getStudyDesign(), entity.getStudyDesign()));
				}
			}

			//test field 'StudySizeReason', type 'text'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				q2.equals("studySizeReason",entity.getStudySizeReason());
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertEquals(r.getStudySizeReason(),entity.getStudySizeReason());
				}
			}
			//test operator 'in' for field 'StudySizeReason'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getStudySizeReason());
				q2.in("studySizeReason", inList);
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertEquals(r.getStudySizeReason(),entity.getStudySizeReason());
				}
			}
			//test operator 'like' for field 'StudySizeReason'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				q2.like("studySizeReason", entity.getStudySizeReason() + "%");
				q2.sortASC("studySizeReason");
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getStudySizeReason(), entity.getStudySizeReason()));
				}
			}

			//test field 'StudyPower', type 'text'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				q2.equals("studyPower",entity.getStudyPower());
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertEquals(r.getStudyPower(),entity.getStudyPower());
				}
			}
			//test operator 'in' for field 'StudyPower'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getStudyPower());
				q2.in("studyPower", inList);
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertEquals(r.getStudyPower(),entity.getStudyPower());
				}
			}
			//test operator 'like' for field 'StudyPower'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				q2.like("studyPower", entity.getStudyPower() + "%");
				q2.sortASC("studyPower");
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getStudyPower(), entity.getStudyPower()));
				}
			}

			//test field 'SourcesOfBias', type 'text'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				q2.equals("sourcesOfBias",entity.getSourcesOfBias());
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertEquals(r.getSourcesOfBias(),entity.getSourcesOfBias());
				}
			}
			//test operator 'in' for field 'SourcesOfBias'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getSourcesOfBias());
				q2.in("sourcesOfBias", inList);
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertEquals(r.getSourcesOfBias(),entity.getSourcesOfBias());
				}
			}
			//test operator 'like' for field 'SourcesOfBias'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				q2.like("sourcesOfBias", entity.getSourcesOfBias() + "%");
				q2.sortASC("sourcesOfBias");
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getSourcesOfBias(), entity.getSourcesOfBias()));
				}
			}

			//test field 'Limitations', type 'text'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				q2.equals("limitations",entity.getLimitations());
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertEquals(r.getLimitations(),entity.getLimitations());
				}
			}
			//test operator 'in' for field 'Limitations'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getLimitations());
				q2.in("limitations", inList);
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertEquals(r.getLimitations(),entity.getLimitations());
				}
			}
			//test operator 'like' for field 'Limitations'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				q2.like("limitations", entity.getLimitations() + "%");
				q2.sortASC("limitations");
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getLimitations(), entity.getLimitations()));
				}
			}

			//test field 'Acknowledgements', type 'text'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				q2.equals("acknowledgements",entity.getAcknowledgements());
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertEquals(r.getAcknowledgements(),entity.getAcknowledgements());
				}
			}
			//test operator 'in' for field 'Acknowledgements'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getAcknowledgements());
				q2.in("acknowledgements", inList);
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertEquals(r.getAcknowledgements(),entity.getAcknowledgements());
				}
			}
			//test operator 'like' for field 'Acknowledgements'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				q2.like("acknowledgements", entity.getAcknowledgements() + "%");
				q2.sortASC("acknowledgements");
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getAcknowledgements(), entity.getAcknowledgements()));
				}
			}

			//test field 'primaryCitation', type 'xref'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				q2.equals("primaryCitation",entity.getPrimaryCitation_Id());
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertEquals(r.getPrimaryCitation_Id(), entity.getPrimaryCitation_Id());
				}
			}
			//test operator 'in' for field 'primaryCitation'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getPrimaryCitation_Id());
				q2.in("primaryCitation", inList);
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertEquals(r.getPrimaryCitation_Id(), entity.getPrimaryCitation_Id());
				}
			}
			//test operator 'equals' for implicit join field 'primaryCitation_Identifier'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				q2.equals("primaryCitation_Identifier",entity.getPrimaryCitation_Identifier());
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertEquals(r.getPrimaryCitation_Id(), entity.getPrimaryCitation_Id());
				}
			}
			//test operator 'in' for implicit join field 'primaryCitation_Identifier'
			{
				Query<StudyDetails> q2 = db.query(StudyDetails.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getPrimaryCitation_Identifier());
				q2.in("primaryCitation_Identifier", inList);
				q2.sortDESC("primaryCitation_Identifier");
				List<StudyDetails> results = q2.find();
				for(StudyDetails r: results)
				{
					assertEquals(r.getPrimaryCitation_Id(), entity.getPrimaryCitation_Id());
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testOntologyTerm"})
	public void testPhenotypeProperty() throws DatabaseException
	{
		//create entities
		List<PhenotypeProperty> entities = new ArrayList<PhenotypeProperty>();

		//retrieve xref entity candidates
		List<OntologyTerm> unitXrefs = db.query(OntologyTerm.class).find();	

		for(Integer i = 0; i < total; i++)
		{
			PhenotypeProperty e = new PhenotypeProperty();
			e.setIdentifier(truncate("phenotypeproperty_identifier_"+i, 255));
			e.setName(truncate("phenotypeproperty_name_"+i, 100));
			e.setDescription("phenotypeproperty_description_"+i);
			if(unitXrefs.size() > 0) e.setUnit_Id( unitXrefs.get(i).getId() );
			e.setDataType(randomEnum(new String[]{"xref","string","categorical","nominal","ordinal","date","datetime","int","code","image","decimal","bool","file","log","data","exe"}));
			e.setTemporal(randomBool(i));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<PhenotypeProperty> q = db.query(PhenotypeProperty.class).eq("__Type",PhenotypeProperty.class.getSimpleName());
		assertEquals(total, q.count());
		List<PhenotypeProperty> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			assertEquals(entities.get(i).getUnit_Id(), entitiesDb.get(i).getUnit_Id());
			assertEquals(entities.get(i).getDataType(), entitiesDb.get(i).getDataType());
			assertEquals(entities.get(i).getTemporal(), entitiesDb.get(i).getTemporal());
		}	
		
		//test the query capabilities by finding on all fields
		for(PhenotypeProperty entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<PhenotypeProperty> q2 = db.query(PhenotypeProperty.class);
				q2.equals("id",entity.getId());
				List<PhenotypeProperty> results = q2.find();
				for(PhenotypeProperty r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<PhenotypeProperty> q2 = db.query(PhenotypeProperty.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<PhenotypeProperty> results = q2.find();
				for(PhenotypeProperty r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<PhenotypeProperty> q2 = db.query(PhenotypeProperty.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<PhenotypeProperty> results = q2.find();
				for(PhenotypeProperty r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<PhenotypeProperty> q2 = db.query(PhenotypeProperty.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<PhenotypeProperty> results = q2.find();
				for(PhenotypeProperty r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<PhenotypeProperty> q2 = db.query(PhenotypeProperty.class);
				q2.equals("identifier",entity.getIdentifier());
				List<PhenotypeProperty> results = q2.find();
				for(PhenotypeProperty r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<PhenotypeProperty> q2 = db.query(PhenotypeProperty.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<PhenotypeProperty> results = q2.find();
				for(PhenotypeProperty r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<PhenotypeProperty> q2 = db.query(PhenotypeProperty.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<PhenotypeProperty> results = q2.find();
				for(PhenotypeProperty r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<PhenotypeProperty> q2 = db.query(PhenotypeProperty.class);
				q2.equals("name",entity.getName());
				List<PhenotypeProperty> results = q2.find();
				for(PhenotypeProperty r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<PhenotypeProperty> q2 = db.query(PhenotypeProperty.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<PhenotypeProperty> results = q2.find();
				for(PhenotypeProperty r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<PhenotypeProperty> q2 = db.query(PhenotypeProperty.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<PhenotypeProperty> results = q2.find();
				for(PhenotypeProperty r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'description', type 'text'
			{
				Query<PhenotypeProperty> q2 = db.query(PhenotypeProperty.class);
				q2.equals("description",entity.getDescription());
				List<PhenotypeProperty> results = q2.find();
				for(PhenotypeProperty r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'description'
			{
				Query<PhenotypeProperty> q2 = db.query(PhenotypeProperty.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<PhenotypeProperty> results = q2.find();
				for(PhenotypeProperty r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'description'
			{
				Query<PhenotypeProperty> q2 = db.query(PhenotypeProperty.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<PhenotypeProperty> results = q2.find();
				for(PhenotypeProperty r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

			//test field 'unit', type 'xref'
			{
				Query<PhenotypeProperty> q2 = db.query(PhenotypeProperty.class);
				q2.equals("unit",entity.getUnit_Id());
				List<PhenotypeProperty> results = q2.find();
				for(PhenotypeProperty r: results)
				{
					assertEquals(r.getUnit_Id(), entity.getUnit_Id());
				}
			}
			//test operator 'in' for field 'unit'
			{
				Query<PhenotypeProperty> q2 = db.query(PhenotypeProperty.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getUnit_Id());
				q2.in("unit", inList);
				List<PhenotypeProperty> results = q2.find();
				for(PhenotypeProperty r: results)
				{
					assertEquals(r.getUnit_Id(), entity.getUnit_Id());
				}
			}
			//test operator 'equals' for implicit join field 'unit_Identifier'
			{
				Query<PhenotypeProperty> q2 = db.query(PhenotypeProperty.class);
				q2.equals("unit_Identifier",entity.getUnit_Identifier());
				List<PhenotypeProperty> results = q2.find();
				for(PhenotypeProperty r: results)
				{
					assertEquals(r.getUnit_Id(), entity.getUnit_Id());
				}
			}
			//test operator 'in' for implicit join field 'unit_Identifier'
			{
				Query<PhenotypeProperty> q2 = db.query(PhenotypeProperty.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getUnit_Identifier());
				q2.in("unit_Identifier", inList);
				q2.sortDESC("unit_Identifier");
				List<PhenotypeProperty> results = q2.find();
				for(PhenotypeProperty r: results)
				{
					assertEquals(r.getUnit_Id(), entity.getUnit_Id());
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testProtocol","testStudy","testPhenotypeProperty"})
	public void testPhenotypeMethod() throws DatabaseException
	{
		//create entities
		List<PhenotypeMethod> entities = new ArrayList<PhenotypeMethod>();

		//retrieve xref entity candidates
		List<Protocol> protocolUsedXrefs = db.query(Protocol.class).eq("__Type",Protocol.class.getSimpleName()).find();	
		List<Study> studyIDXrefs = db.query(Study.class).find();	
		List<PhenotypeProperty> phenotypePropertyIDXrefs = db.query(PhenotypeProperty.class).eq("__Type",PhenotypeProperty.class.getSimpleName()).find();	

		for(Integer i = 0; i < total; i++)
		{
			PhenotypeMethod e = new PhenotypeMethod();
			e.setIdentifier(truncate("phenotypemethod_identifier_"+i, 255));
			e.setName(truncate("phenotypemethod_name_"+i, 255));
			e.setDescription("phenotypemethod_description_"+i);
			if(protocolUsedXrefs.size() > 0) e.setProtocolUsed_Id( protocolUsedXrefs.get(i).getId() );
			if(studyIDXrefs.size() > 0) e.setStudyID_Id( studyIDXrefs.get(i).getId() );
			if(phenotypePropertyIDXrefs.size() > 0) e.setPhenotypePropertyID_Id( phenotypePropertyIDXrefs.get(i).getId() );
			e.setSample(truncate("phenotypemethod_sample_"+i, 100));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<PhenotypeMethod> q = db.query(PhenotypeMethod.class).eq("__Type",PhenotypeMethod.class.getSimpleName());
		assertEquals(total, q.count());
		List<PhenotypeMethod> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			assertEquals(entities.get(i).getProtocolUsed_Id(), entitiesDb.get(i).getProtocolUsed_Id());
			assertEquals(entities.get(i).getStudyID_Id(), entitiesDb.get(i).getStudyID_Id());
			assertEquals(entities.get(i).getPhenotypePropertyID_Id(), entitiesDb.get(i).getPhenotypePropertyID_Id());
			assertEquals(entities.get(i).getSample(), entitiesDb.get(i).getSample());
		}	
		
		//test the query capabilities by finding on all fields
		for(PhenotypeMethod entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<PhenotypeMethod> q2 = db.query(PhenotypeMethod.class);
				q2.equals("id",entity.getId());
				List<PhenotypeMethod> results = q2.find();
				for(PhenotypeMethod r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<PhenotypeMethod> q2 = db.query(PhenotypeMethod.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<PhenotypeMethod> results = q2.find();
				for(PhenotypeMethod r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<PhenotypeMethod> q2 = db.query(PhenotypeMethod.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<PhenotypeMethod> results = q2.find();
				for(PhenotypeMethod r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<PhenotypeMethod> q2 = db.query(PhenotypeMethod.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<PhenotypeMethod> results = q2.find();
				for(PhenotypeMethod r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<PhenotypeMethod> q2 = db.query(PhenotypeMethod.class);
				q2.equals("identifier",entity.getIdentifier());
				List<PhenotypeMethod> results = q2.find();
				for(PhenotypeMethod r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<PhenotypeMethod> q2 = db.query(PhenotypeMethod.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<PhenotypeMethod> results = q2.find();
				for(PhenotypeMethod r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<PhenotypeMethod> q2 = db.query(PhenotypeMethod.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<PhenotypeMethod> results = q2.find();
				for(PhenotypeMethod r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<PhenotypeMethod> q2 = db.query(PhenotypeMethod.class);
				q2.equals("name",entity.getName());
				List<PhenotypeMethod> results = q2.find();
				for(PhenotypeMethod r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<PhenotypeMethod> q2 = db.query(PhenotypeMethod.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<PhenotypeMethod> results = q2.find();
				for(PhenotypeMethod r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<PhenotypeMethod> q2 = db.query(PhenotypeMethod.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<PhenotypeMethod> results = q2.find();
				for(PhenotypeMethod r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'description', type 'text'
			{
				Query<PhenotypeMethod> q2 = db.query(PhenotypeMethod.class);
				q2.equals("description",entity.getDescription());
				List<PhenotypeMethod> results = q2.find();
				for(PhenotypeMethod r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'description'
			{
				Query<PhenotypeMethod> q2 = db.query(PhenotypeMethod.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<PhenotypeMethod> results = q2.find();
				for(PhenotypeMethod r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'description'
			{
				Query<PhenotypeMethod> q2 = db.query(PhenotypeMethod.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<PhenotypeMethod> results = q2.find();
				for(PhenotypeMethod r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

			//test field 'ProtocolUsed', type 'xref'
			{
				Query<PhenotypeMethod> q2 = db.query(PhenotypeMethod.class);
				q2.equals("protocolUsed",entity.getProtocolUsed_Id());
				List<PhenotypeMethod> results = q2.find();
				for(PhenotypeMethod r: results)
				{
					assertEquals(r.getProtocolUsed_Id(), entity.getProtocolUsed_Id());
				}
			}
			//test operator 'in' for field 'ProtocolUsed'
			{
				Query<PhenotypeMethod> q2 = db.query(PhenotypeMethod.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getProtocolUsed_Id());
				q2.in("protocolUsed", inList);
				List<PhenotypeMethod> results = q2.find();
				for(PhenotypeMethod r: results)
				{
					assertEquals(r.getProtocolUsed_Id(), entity.getProtocolUsed_Id());
				}
			}
			//test operator 'equals' for implicit join field 'ProtocolUsed_Identifier'
			{
				Query<PhenotypeMethod> q2 = db.query(PhenotypeMethod.class);
				q2.equals("protocolUsed_Identifier",entity.getProtocolUsed_Identifier());
				List<PhenotypeMethod> results = q2.find();
				for(PhenotypeMethod r: results)
				{
					assertEquals(r.getProtocolUsed_Id(), entity.getProtocolUsed_Id());
				}
			}
			//test operator 'in' for implicit join field 'ProtocolUsed_Identifier'
			{
				Query<PhenotypeMethod> q2 = db.query(PhenotypeMethod.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getProtocolUsed_Identifier());
				q2.in("protocolUsed_Identifier", inList);
				q2.sortDESC("protocolUsed_Identifier");
				List<PhenotypeMethod> results = q2.find();
				for(PhenotypeMethod r: results)
				{
					assertEquals(r.getProtocolUsed_Id(), entity.getProtocolUsed_Id());
				}
			}

			//test field 'StudyID', type 'xref'
			{
				Query<PhenotypeMethod> q2 = db.query(PhenotypeMethod.class);
				q2.equals("studyID",entity.getStudyID_Id());
				List<PhenotypeMethod> results = q2.find();
				for(PhenotypeMethod r: results)
				{
					assertEquals(r.getStudyID_Id(), entity.getStudyID_Id());
				}
			}
			//test operator 'in' for field 'StudyID'
			{
				Query<PhenotypeMethod> q2 = db.query(PhenotypeMethod.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getStudyID_Id());
				q2.in("studyID", inList);
				List<PhenotypeMethod> results = q2.find();
				for(PhenotypeMethod r: results)
				{
					assertEquals(r.getStudyID_Id(), entity.getStudyID_Id());
				}
			}
			//test operator 'equals' for implicit join field 'StudyID_Identifier'
			{
				Query<PhenotypeMethod> q2 = db.query(PhenotypeMethod.class);
				q2.equals("studyID_Identifier",entity.getStudyID_Identifier());
				List<PhenotypeMethod> results = q2.find();
				for(PhenotypeMethod r: results)
				{
					assertEquals(r.getStudyID_Id(), entity.getStudyID_Id());
				}
			}
			//test operator 'in' for implicit join field 'StudyID_Identifier'
			{
				Query<PhenotypeMethod> q2 = db.query(PhenotypeMethod.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getStudyID_Identifier());
				q2.in("studyID_Identifier", inList);
				q2.sortDESC("studyID_Identifier");
				List<PhenotypeMethod> results = q2.find();
				for(PhenotypeMethod r: results)
				{
					assertEquals(r.getStudyID_Id(), entity.getStudyID_Id());
				}
			}

			//test field 'PhenotypePropertyID', type 'xref'
			{
				Query<PhenotypeMethod> q2 = db.query(PhenotypeMethod.class);
				q2.equals("phenotypePropertyID",entity.getPhenotypePropertyID_Id());
				List<PhenotypeMethod> results = q2.find();
				for(PhenotypeMethod r: results)
				{
					assertEquals(r.getPhenotypePropertyID_Id(), entity.getPhenotypePropertyID_Id());
				}
			}
			//test operator 'in' for field 'PhenotypePropertyID'
			{
				Query<PhenotypeMethod> q2 = db.query(PhenotypeMethod.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getPhenotypePropertyID_Id());
				q2.in("phenotypePropertyID", inList);
				List<PhenotypeMethod> results = q2.find();
				for(PhenotypeMethod r: results)
				{
					assertEquals(r.getPhenotypePropertyID_Id(), entity.getPhenotypePropertyID_Id());
				}
			}
			//test operator 'equals' for implicit join field 'PhenotypePropertyID_Identifier'
			{
				Query<PhenotypeMethod> q2 = db.query(PhenotypeMethod.class);
				q2.equals("phenotypePropertyID_Identifier",entity.getPhenotypePropertyID_Identifier());
				List<PhenotypeMethod> results = q2.find();
				for(PhenotypeMethod r: results)
				{
					assertEquals(r.getPhenotypePropertyID_Id(), entity.getPhenotypePropertyID_Id());
				}
			}
			//test operator 'in' for implicit join field 'PhenotypePropertyID_Identifier'
			{
				Query<PhenotypeMethod> q2 = db.query(PhenotypeMethod.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getPhenotypePropertyID_Identifier());
				q2.in("phenotypePropertyID_Identifier", inList);
				q2.sortDESC("phenotypePropertyID_Identifier");
				List<PhenotypeMethod> results = q2.find();
				for(PhenotypeMethod r: results)
				{
					assertEquals(r.getPhenotypePropertyID_Id(), entity.getPhenotypePropertyID_Id());
				}
			}

			//test field 'Sample', type 'string'
			{
				Query<PhenotypeMethod> q2 = db.query(PhenotypeMethod.class);
				q2.equals("sample",entity.getSample());
				List<PhenotypeMethod> results = q2.find();
				for(PhenotypeMethod r: results)
				{
					assertEquals(r.getSample(),entity.getSample());
				}
			}
			//test operator 'in' for field 'Sample'
			{
				Query<PhenotypeMethod> q2 = db.query(PhenotypeMethod.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getSample());
				q2.in("sample", inList);
				List<PhenotypeMethod> results = q2.find();
				for(PhenotypeMethod r: results)
				{
					assertEquals(r.getSample(),entity.getSample());
				}
			}
			//test operator 'like' for field 'Sample'
			{
				Query<PhenotypeMethod> q2 = db.query(PhenotypeMethod.class);
				q2.like("sample", entity.getSample() + "%");
				q2.sortASC("sample");
				List<PhenotypeMethod> results = q2.find();
				for(PhenotypeMethod r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getSample(), entity.getSample()));
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testOntologyTerm","testSpecies","testOntologyTerm"})
	public void testSamplePanel() throws DatabaseException
	{
		//create entities
		List<SamplePanel> entities = new ArrayList<SamplePanel>();

		//retrieve xref entity candidates
		List<OntologyTerm> panelTypeXrefs = db.query(OntologyTerm.class).find();	
		List<Species> speciesXrefs = db.query(Species.class).eq("__Type",Species.class.getSimpleName()).find();	
		List<Individual> individualsXrefs = db.query(Individual.class).eq("__Type",Individual.class.getSimpleName()).find();	
		List<OntologyTerm> centralIdentifierXrefs = db.query(OntologyTerm.class).find();	

		for(Integer i = 0; i < total; i++)
		{
			SamplePanel e = new SamplePanel();
			e.setIdentifier(truncate("samplepanel_identifier_"+i, 255));
			e.setName(truncate("samplepanel_name_"+i, 100));
			e.setDescription("samplepanel_description_"+i);
			if(panelTypeXrefs.size() > 0) e.setPanelType_Id( panelTypeXrefs.get(i).getId() );
			e.setNumberOfIndividuals(i);
			if(speciesXrefs.size() > 0) e.setSpecies_Id( speciesXrefs.get(i).getId() );
			if(individualsXrefs.size() > 0)
			{
				e.getIndividuals_Id().add( individualsXrefs.get(i).getId() );
				//e.getIndividuals().add( random(individualsXrefs).getId() );
			}
			if(centralIdentifierXrefs.size() > 0) e.setCentralIdentifier_Id( centralIdentifierXrefs.get(i).getId() );
			e.setLabel(truncate("samplepanel_label_"+i, 10));
			e.setAccession(truncate("samplepanel_accession_"+i, 15));
			e.setAccessionVersion(truncate("samplepanel_accessionversion_"+i, 10));
			e.setComposition("samplepanel_composition_"+i);
			e.setTotalNumberOfIndividuals(i);
			e.setNumberOfSexMale(i);
			e.setNumberOfSexFemale(i);
			e.setNumberOfSexUnknown(i);
			e.setNumberOfProbands(i);
			e.setNumberOfParents(i);
			e.setModeOfRecruitment(truncate("samplepanel_modeofrecruitment_"+i, 255));
			e.setDiagnosisAgeRange(truncate("samplepanel_diagnosisagerange_"+i, 150));
			e.setDiagnosisPeriod(truncate("samplepanel_diagnosisperiod_"+i, 150));
			e.setSamplingAgeRange(truncate("samplepanel_samplingagerange_"+i, 150));
			e.setSamplingPeriod(truncate("samplepanel_samplingperiod_"+i, 150));
			e.setPopulationInfo(truncate("samplepanel_populationinfo_"+i, 250));
			e.setGeographicRegionInfo(truncate("samplepanel_geographicregioninfo_"+i, 250));
			e.setEthnicityInfo(truncate("samplepanel_ethnicityinfo_"+i, 250));
			e.setBirthPlaceInfo(truncate("samplepanel_birthplaceinfo_"+i, 250));
			e.setAdmixtureInfo(truncate("samplepanel_admixtureinfo_"+i, 250));
			e.setEnvironmentInfo("samplepanel_environmentinfo_"+i);
			e.setSourceOfDNA(truncate("samplepanel_sourceofdna_"+i, 100));
			e.setDNAsArePooled(randomEnum(new String[]{"Undefined","Pre-prep","Post-prep","No"}));
			e.setDNAsAreWGA(randomEnum(new String[]{"Undefined","None","All","Some"}));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<SamplePanel> q = db.query(SamplePanel.class).eq("__Type",SamplePanel.class.getSimpleName());
		assertEquals(total, q.count());
		List<SamplePanel> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			assertEquals(entities.get(i).getPanelType_Id(), entitiesDb.get(i).getPanelType_Id());
			assertEquals(entities.get(i).getNumberOfIndividuals(), entitiesDb.get(i).getNumberOfIndividuals());
			assertEquals(entities.get(i).getSpecies_Id(), entitiesDb.get(i).getSpecies_Id());
			assertEquals(entities.get(i).getIndividuals_Id(), entitiesDb.get(i).getIndividuals_Id());
			assertEquals(entities.get(i).getCentralIdentifier_Id(), entitiesDb.get(i).getCentralIdentifier_Id());
			assertEquals(entities.get(i).getLabel(), entitiesDb.get(i).getLabel());
			assertEquals(entities.get(i).getAccession(), entitiesDb.get(i).getAccession());
			assertEquals(entities.get(i).getAccessionVersion(), entitiesDb.get(i).getAccessionVersion());
			assertEquals(entities.get(i).getComposition(), entitiesDb.get(i).getComposition());
			assertEquals(entities.get(i).getTotalNumberOfIndividuals(), entitiesDb.get(i).getTotalNumberOfIndividuals());
			assertEquals(entities.get(i).getNumberOfSexMale(), entitiesDb.get(i).getNumberOfSexMale());
			assertEquals(entities.get(i).getNumberOfSexFemale(), entitiesDb.get(i).getNumberOfSexFemale());
			assertEquals(entities.get(i).getNumberOfSexUnknown(), entitiesDb.get(i).getNumberOfSexUnknown());
			assertEquals(entities.get(i).getNumberOfProbands(), entitiesDb.get(i).getNumberOfProbands());
			assertEquals(entities.get(i).getNumberOfParents(), entitiesDb.get(i).getNumberOfParents());
			assertEquals(entities.get(i).getModeOfRecruitment(), entitiesDb.get(i).getModeOfRecruitment());
			assertEquals(entities.get(i).getDiagnosisAgeRange(), entitiesDb.get(i).getDiagnosisAgeRange());
			assertEquals(entities.get(i).getDiagnosisPeriod(), entitiesDb.get(i).getDiagnosisPeriod());
			assertEquals(entities.get(i).getSamplingAgeRange(), entitiesDb.get(i).getSamplingAgeRange());
			assertEquals(entities.get(i).getSamplingPeriod(), entitiesDb.get(i).getSamplingPeriod());
			assertEquals(entities.get(i).getPopulationInfo(), entitiesDb.get(i).getPopulationInfo());
			assertEquals(entities.get(i).getGeographicRegionInfo(), entitiesDb.get(i).getGeographicRegionInfo());
			assertEquals(entities.get(i).getEthnicityInfo(), entitiesDb.get(i).getEthnicityInfo());
			assertEquals(entities.get(i).getBirthPlaceInfo(), entitiesDb.get(i).getBirthPlaceInfo());
			assertEquals(entities.get(i).getAdmixtureInfo(), entitiesDb.get(i).getAdmixtureInfo());
			assertEquals(entities.get(i).getEnvironmentInfo(), entitiesDb.get(i).getEnvironmentInfo());
			assertEquals(entities.get(i).getSourceOfDNA(), entitiesDb.get(i).getSourceOfDNA());
			assertEquals(entities.get(i).getDNAsArePooled(), entitiesDb.get(i).getDNAsArePooled());
			assertEquals(entities.get(i).getDNAsAreWGA(), entitiesDb.get(i).getDNAsAreWGA());
		}	
		
		//test the query capabilities by finding on all fields
		for(SamplePanel entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.equals("id",entity.getId());
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.equals("identifier",entity.getIdentifier());
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.equals("name",entity.getName());
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'Description', type 'text'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.equals("description",entity.getDescription());
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'Description'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'Description'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

			//test field 'PanelType', type 'xref'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.equals("panelType",entity.getPanelType_Id());
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getPanelType_Id(), entity.getPanelType_Id());
				}
			}
			//test operator 'in' for field 'PanelType'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getPanelType_Id());
				q2.in("panelType", inList);
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getPanelType_Id(), entity.getPanelType_Id());
				}
			}
			//test operator 'equals' for implicit join field 'PanelType_Identifier'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.equals("panelType_Identifier",entity.getPanelType_Identifier());
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getPanelType_Id(), entity.getPanelType_Id());
				}
			}
			//test operator 'in' for implicit join field 'PanelType_Identifier'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getPanelType_Identifier());
				q2.in("panelType_Identifier", inList);
				q2.sortDESC("panelType_Identifier");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getPanelType_Id(), entity.getPanelType_Id());
				}
			}

			//test field 'NumberOfIndividuals', type 'int'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.equals("numberOfIndividuals",entity.getNumberOfIndividuals());
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getNumberOfIndividuals(),entity.getNumberOfIndividuals());
				}
			}
			//test operator 'in' for field 'NumberOfIndividuals'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getNumberOfIndividuals());
				q2.in("numberOfIndividuals", inList);
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getNumberOfIndividuals(),entity.getNumberOfIndividuals());
				}
			}
			//test operator 'lessOrEqual' for field 'NumberOfIndividuals'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.lessOrEqual("numberOfIndividuals", entity.getNumberOfIndividuals());
				q2.sortASC("numberOfIndividuals");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertTrue(r.getNumberOfIndividuals().compareTo(entity.getNumberOfIndividuals()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'NumberOfIndividuals'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.greaterOrEqual("numberOfIndividuals", entity.getNumberOfIndividuals());
				q2.sortDESC("numberOfIndividuals");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertTrue(r.getNumberOfIndividuals().compareTo(entity.getNumberOfIndividuals()) > -1);
				}
			}

			//test field 'Species', type 'xref'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.equals("species",entity.getSpecies_Id());
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getSpecies_Id(), entity.getSpecies_Id());
				}
			}
			//test operator 'in' for field 'Species'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getSpecies_Id());
				q2.in("species", inList);
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getSpecies_Id(), entity.getSpecies_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Species_Identifier'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.equals("species_Identifier",entity.getSpecies_Identifier());
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getSpecies_Id(), entity.getSpecies_Id());
				}
			}
			//test operator 'in' for implicit join field 'Species_Identifier'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getSpecies_Identifier());
				q2.in("species_Identifier", inList);
				q2.sortDESC("species_Identifier");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getSpecies_Id(), entity.getSpecies_Id());
				}
			}

			//test field 'CentralIdentifier', type 'xref'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.equals("centralIdentifier",entity.getCentralIdentifier_Id());
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getCentralIdentifier_Id(), entity.getCentralIdentifier_Id());
				}
			}
			//test operator 'in' for field 'CentralIdentifier'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getCentralIdentifier_Id());
				q2.in("centralIdentifier", inList);
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getCentralIdentifier_Id(), entity.getCentralIdentifier_Id());
				}
			}
			//test operator 'equals' for implicit join field 'CentralIdentifier_Identifier'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.equals("centralIdentifier_Identifier",entity.getCentralIdentifier_Identifier());
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getCentralIdentifier_Id(), entity.getCentralIdentifier_Id());
				}
			}
			//test operator 'in' for implicit join field 'CentralIdentifier_Identifier'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getCentralIdentifier_Identifier());
				q2.in("centralIdentifier_Identifier", inList);
				q2.sortDESC("centralIdentifier_Identifier");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getCentralIdentifier_Id(), entity.getCentralIdentifier_Id());
				}
			}

			//test field 'Label', type 'string'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.equals("label",entity.getLabel());
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getLabel(),entity.getLabel());
				}
			}
			//test operator 'in' for field 'Label'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getLabel());
				q2.in("label", inList);
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getLabel(),entity.getLabel());
				}
			}
			//test operator 'like' for field 'Label'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.like("label", entity.getLabel() + "%");
				q2.sortASC("label");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getLabel(), entity.getLabel()));
				}
			}

			//test field 'Accession', type 'string'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.equals("accession",entity.getAccession());
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getAccession(),entity.getAccession());
				}
			}
			//test operator 'in' for field 'Accession'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getAccession());
				q2.in("accession", inList);
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getAccession(),entity.getAccession());
				}
			}
			//test operator 'like' for field 'Accession'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.like("accession", entity.getAccession() + "%");
				q2.sortASC("accession");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getAccession(), entity.getAccession()));
				}
			}

			//test field 'AccessionVersion', type 'string'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.equals("accessionVersion",entity.getAccessionVersion());
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getAccessionVersion(),entity.getAccessionVersion());
				}
			}
			//test operator 'in' for field 'AccessionVersion'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getAccessionVersion());
				q2.in("accessionVersion", inList);
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getAccessionVersion(),entity.getAccessionVersion());
				}
			}
			//test operator 'like' for field 'AccessionVersion'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.like("accessionVersion", entity.getAccessionVersion() + "%");
				q2.sortASC("accessionVersion");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getAccessionVersion(), entity.getAccessionVersion()));
				}
			}

			//test field 'Composition', type 'text'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.equals("composition",entity.getComposition());
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getComposition(),entity.getComposition());
				}
			}
			//test operator 'in' for field 'Composition'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getComposition());
				q2.in("composition", inList);
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getComposition(),entity.getComposition());
				}
			}
			//test operator 'like' for field 'Composition'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.like("composition", entity.getComposition() + "%");
				q2.sortASC("composition");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getComposition(), entity.getComposition()));
				}
			}

			//test field 'TotalNumberOfIndividuals', type 'int'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.equals("totalNumberOfIndividuals",entity.getTotalNumberOfIndividuals());
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getTotalNumberOfIndividuals(),entity.getTotalNumberOfIndividuals());
				}
			}
			//test operator 'in' for field 'TotalNumberOfIndividuals'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getTotalNumberOfIndividuals());
				q2.in("totalNumberOfIndividuals", inList);
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getTotalNumberOfIndividuals(),entity.getTotalNumberOfIndividuals());
				}
			}
			//test operator 'lessOrEqual' for field 'TotalNumberOfIndividuals'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.lessOrEqual("totalNumberOfIndividuals", entity.getTotalNumberOfIndividuals());
				q2.sortASC("totalNumberOfIndividuals");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertTrue(r.getTotalNumberOfIndividuals().compareTo(entity.getTotalNumberOfIndividuals()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'TotalNumberOfIndividuals'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.greaterOrEqual("totalNumberOfIndividuals", entity.getTotalNumberOfIndividuals());
				q2.sortDESC("totalNumberOfIndividuals");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertTrue(r.getTotalNumberOfIndividuals().compareTo(entity.getTotalNumberOfIndividuals()) > -1);
				}
			}

			//test field 'NumberOfSexMale', type 'int'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.equals("numberOfSexMale",entity.getNumberOfSexMale());
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getNumberOfSexMale(),entity.getNumberOfSexMale());
				}
			}
			//test operator 'in' for field 'NumberOfSexMale'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getNumberOfSexMale());
				q2.in("numberOfSexMale", inList);
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getNumberOfSexMale(),entity.getNumberOfSexMale());
				}
			}
			//test operator 'lessOrEqual' for field 'NumberOfSexMale'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.lessOrEqual("numberOfSexMale", entity.getNumberOfSexMale());
				q2.sortASC("numberOfSexMale");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertTrue(r.getNumberOfSexMale().compareTo(entity.getNumberOfSexMale()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'NumberOfSexMale'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.greaterOrEqual("numberOfSexMale", entity.getNumberOfSexMale());
				q2.sortDESC("numberOfSexMale");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertTrue(r.getNumberOfSexMale().compareTo(entity.getNumberOfSexMale()) > -1);
				}
			}

			//test field 'NumberOfSexFemale', type 'int'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.equals("numberOfSexFemale",entity.getNumberOfSexFemale());
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getNumberOfSexFemale(),entity.getNumberOfSexFemale());
				}
			}
			//test operator 'in' for field 'NumberOfSexFemale'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getNumberOfSexFemale());
				q2.in("numberOfSexFemale", inList);
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getNumberOfSexFemale(),entity.getNumberOfSexFemale());
				}
			}
			//test operator 'lessOrEqual' for field 'NumberOfSexFemale'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.lessOrEqual("numberOfSexFemale", entity.getNumberOfSexFemale());
				q2.sortASC("numberOfSexFemale");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertTrue(r.getNumberOfSexFemale().compareTo(entity.getNumberOfSexFemale()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'NumberOfSexFemale'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.greaterOrEqual("numberOfSexFemale", entity.getNumberOfSexFemale());
				q2.sortDESC("numberOfSexFemale");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertTrue(r.getNumberOfSexFemale().compareTo(entity.getNumberOfSexFemale()) > -1);
				}
			}

			//test field 'NumberOfSexUnknown', type 'int'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.equals("numberOfSexUnknown",entity.getNumberOfSexUnknown());
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getNumberOfSexUnknown(),entity.getNumberOfSexUnknown());
				}
			}
			//test operator 'in' for field 'NumberOfSexUnknown'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getNumberOfSexUnknown());
				q2.in("numberOfSexUnknown", inList);
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getNumberOfSexUnknown(),entity.getNumberOfSexUnknown());
				}
			}
			//test operator 'lessOrEqual' for field 'NumberOfSexUnknown'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.lessOrEqual("numberOfSexUnknown", entity.getNumberOfSexUnknown());
				q2.sortASC("numberOfSexUnknown");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertTrue(r.getNumberOfSexUnknown().compareTo(entity.getNumberOfSexUnknown()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'NumberOfSexUnknown'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.greaterOrEqual("numberOfSexUnknown", entity.getNumberOfSexUnknown());
				q2.sortDESC("numberOfSexUnknown");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertTrue(r.getNumberOfSexUnknown().compareTo(entity.getNumberOfSexUnknown()) > -1);
				}
			}

			//test field 'NumberOfProbands', type 'int'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.equals("numberOfProbands",entity.getNumberOfProbands());
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getNumberOfProbands(),entity.getNumberOfProbands());
				}
			}
			//test operator 'in' for field 'NumberOfProbands'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getNumberOfProbands());
				q2.in("numberOfProbands", inList);
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getNumberOfProbands(),entity.getNumberOfProbands());
				}
			}
			//test operator 'lessOrEqual' for field 'NumberOfProbands'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.lessOrEqual("numberOfProbands", entity.getNumberOfProbands());
				q2.sortASC("numberOfProbands");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertTrue(r.getNumberOfProbands().compareTo(entity.getNumberOfProbands()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'NumberOfProbands'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.greaterOrEqual("numberOfProbands", entity.getNumberOfProbands());
				q2.sortDESC("numberOfProbands");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertTrue(r.getNumberOfProbands().compareTo(entity.getNumberOfProbands()) > -1);
				}
			}

			//test field 'NumberOfParents', type 'int'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.equals("numberOfParents",entity.getNumberOfParents());
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getNumberOfParents(),entity.getNumberOfParents());
				}
			}
			//test operator 'in' for field 'NumberOfParents'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getNumberOfParents());
				q2.in("numberOfParents", inList);
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getNumberOfParents(),entity.getNumberOfParents());
				}
			}
			//test operator 'lessOrEqual' for field 'NumberOfParents'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.lessOrEqual("numberOfParents", entity.getNumberOfParents());
				q2.sortASC("numberOfParents");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertTrue(r.getNumberOfParents().compareTo(entity.getNumberOfParents()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'NumberOfParents'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.greaterOrEqual("numberOfParents", entity.getNumberOfParents());
				q2.sortDESC("numberOfParents");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertTrue(r.getNumberOfParents().compareTo(entity.getNumberOfParents()) > -1);
				}
			}

			//test field 'ModeOfRecruitment', type 'string'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.equals("modeOfRecruitment",entity.getModeOfRecruitment());
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getModeOfRecruitment(),entity.getModeOfRecruitment());
				}
			}
			//test operator 'in' for field 'ModeOfRecruitment'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getModeOfRecruitment());
				q2.in("modeOfRecruitment", inList);
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getModeOfRecruitment(),entity.getModeOfRecruitment());
				}
			}
			//test operator 'like' for field 'ModeOfRecruitment'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.like("modeOfRecruitment", entity.getModeOfRecruitment() + "%");
				q2.sortASC("modeOfRecruitment");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getModeOfRecruitment(), entity.getModeOfRecruitment()));
				}
			}

			//test field 'DiagnosisAgeRange', type 'string'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.equals("diagnosisAgeRange",entity.getDiagnosisAgeRange());
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getDiagnosisAgeRange(),entity.getDiagnosisAgeRange());
				}
			}
			//test operator 'in' for field 'DiagnosisAgeRange'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDiagnosisAgeRange());
				q2.in("diagnosisAgeRange", inList);
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getDiagnosisAgeRange(),entity.getDiagnosisAgeRange());
				}
			}
			//test operator 'like' for field 'DiagnosisAgeRange'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.like("diagnosisAgeRange", entity.getDiagnosisAgeRange() + "%");
				q2.sortASC("diagnosisAgeRange");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDiagnosisAgeRange(), entity.getDiagnosisAgeRange()));
				}
			}

			//test field 'DiagnosisPeriod', type 'string'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.equals("diagnosisPeriod",entity.getDiagnosisPeriod());
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getDiagnosisPeriod(),entity.getDiagnosisPeriod());
				}
			}
			//test operator 'in' for field 'DiagnosisPeriod'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDiagnosisPeriod());
				q2.in("diagnosisPeriod", inList);
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getDiagnosisPeriod(),entity.getDiagnosisPeriod());
				}
			}
			//test operator 'like' for field 'DiagnosisPeriod'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.like("diagnosisPeriod", entity.getDiagnosisPeriod() + "%");
				q2.sortASC("diagnosisPeriod");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDiagnosisPeriod(), entity.getDiagnosisPeriod()));
				}
			}

			//test field 'SamplingAgeRange', type 'string'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.equals("samplingAgeRange",entity.getSamplingAgeRange());
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getSamplingAgeRange(),entity.getSamplingAgeRange());
				}
			}
			//test operator 'in' for field 'SamplingAgeRange'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getSamplingAgeRange());
				q2.in("samplingAgeRange", inList);
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getSamplingAgeRange(),entity.getSamplingAgeRange());
				}
			}
			//test operator 'like' for field 'SamplingAgeRange'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.like("samplingAgeRange", entity.getSamplingAgeRange() + "%");
				q2.sortASC("samplingAgeRange");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getSamplingAgeRange(), entity.getSamplingAgeRange()));
				}
			}

			//test field 'SamplingPeriod', type 'string'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.equals("samplingPeriod",entity.getSamplingPeriod());
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getSamplingPeriod(),entity.getSamplingPeriod());
				}
			}
			//test operator 'in' for field 'SamplingPeriod'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getSamplingPeriod());
				q2.in("samplingPeriod", inList);
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getSamplingPeriod(),entity.getSamplingPeriod());
				}
			}
			//test operator 'like' for field 'SamplingPeriod'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.like("samplingPeriod", entity.getSamplingPeriod() + "%");
				q2.sortASC("samplingPeriod");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getSamplingPeriod(), entity.getSamplingPeriod()));
				}
			}

			//test field 'PopulationInfo', type 'string'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.equals("populationInfo",entity.getPopulationInfo());
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getPopulationInfo(),entity.getPopulationInfo());
				}
			}
			//test operator 'in' for field 'PopulationInfo'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getPopulationInfo());
				q2.in("populationInfo", inList);
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getPopulationInfo(),entity.getPopulationInfo());
				}
			}
			//test operator 'like' for field 'PopulationInfo'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.like("populationInfo", entity.getPopulationInfo() + "%");
				q2.sortASC("populationInfo");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getPopulationInfo(), entity.getPopulationInfo()));
				}
			}

			//test field 'GeographicRegionInfo', type 'string'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.equals("geographicRegionInfo",entity.getGeographicRegionInfo());
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getGeographicRegionInfo(),entity.getGeographicRegionInfo());
				}
			}
			//test operator 'in' for field 'GeographicRegionInfo'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getGeographicRegionInfo());
				q2.in("geographicRegionInfo", inList);
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getGeographicRegionInfo(),entity.getGeographicRegionInfo());
				}
			}
			//test operator 'like' for field 'GeographicRegionInfo'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.like("geographicRegionInfo", entity.getGeographicRegionInfo() + "%");
				q2.sortASC("geographicRegionInfo");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getGeographicRegionInfo(), entity.getGeographicRegionInfo()));
				}
			}

			//test field 'EthnicityInfo', type 'string'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.equals("ethnicityInfo",entity.getEthnicityInfo());
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getEthnicityInfo(),entity.getEthnicityInfo());
				}
			}
			//test operator 'in' for field 'EthnicityInfo'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getEthnicityInfo());
				q2.in("ethnicityInfo", inList);
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getEthnicityInfo(),entity.getEthnicityInfo());
				}
			}
			//test operator 'like' for field 'EthnicityInfo'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.like("ethnicityInfo", entity.getEthnicityInfo() + "%");
				q2.sortASC("ethnicityInfo");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getEthnicityInfo(), entity.getEthnicityInfo()));
				}
			}

			//test field 'BirthPlaceInfo', type 'string'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.equals("birthPlaceInfo",entity.getBirthPlaceInfo());
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getBirthPlaceInfo(),entity.getBirthPlaceInfo());
				}
			}
			//test operator 'in' for field 'BirthPlaceInfo'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getBirthPlaceInfo());
				q2.in("birthPlaceInfo", inList);
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getBirthPlaceInfo(),entity.getBirthPlaceInfo());
				}
			}
			//test operator 'like' for field 'BirthPlaceInfo'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.like("birthPlaceInfo", entity.getBirthPlaceInfo() + "%");
				q2.sortASC("birthPlaceInfo");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getBirthPlaceInfo(), entity.getBirthPlaceInfo()));
				}
			}

			//test field 'AdmixtureInfo', type 'string'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.equals("admixtureInfo",entity.getAdmixtureInfo());
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getAdmixtureInfo(),entity.getAdmixtureInfo());
				}
			}
			//test operator 'in' for field 'AdmixtureInfo'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getAdmixtureInfo());
				q2.in("admixtureInfo", inList);
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getAdmixtureInfo(),entity.getAdmixtureInfo());
				}
			}
			//test operator 'like' for field 'AdmixtureInfo'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.like("admixtureInfo", entity.getAdmixtureInfo() + "%");
				q2.sortASC("admixtureInfo");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getAdmixtureInfo(), entity.getAdmixtureInfo()));
				}
			}

			//test field 'EnvironmentInfo', type 'text'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.equals("environmentInfo",entity.getEnvironmentInfo());
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getEnvironmentInfo(),entity.getEnvironmentInfo());
				}
			}
			//test operator 'in' for field 'EnvironmentInfo'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getEnvironmentInfo());
				q2.in("environmentInfo", inList);
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getEnvironmentInfo(),entity.getEnvironmentInfo());
				}
			}
			//test operator 'like' for field 'EnvironmentInfo'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.like("environmentInfo", entity.getEnvironmentInfo() + "%");
				q2.sortASC("environmentInfo");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getEnvironmentInfo(), entity.getEnvironmentInfo()));
				}
			}

			//test field 'SourceOfDNA', type 'string'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.equals("sourceOfDNA",entity.getSourceOfDNA());
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getSourceOfDNA(),entity.getSourceOfDNA());
				}
			}
			//test operator 'in' for field 'SourceOfDNA'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getSourceOfDNA());
				q2.in("sourceOfDNA", inList);
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertEquals(r.getSourceOfDNA(),entity.getSourceOfDNA());
				}
			}
			//test operator 'like' for field 'SourceOfDNA'
			{
				Query<SamplePanel> q2 = db.query(SamplePanel.class);
				q2.like("sourceOfDNA", entity.getSourceOfDNA() + "%");
				q2.sortASC("sourceOfDNA");
				List<SamplePanel> results = q2.find();
				for(SamplePanel r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getSourceOfDNA(), entity.getSourceOfDNA()));
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testOntologyTerm","testSpecies"})
	public void testAssayedPanel() throws DatabaseException
	{
		//create entities
		List<AssayedPanel> entities = new ArrayList<AssayedPanel>();

		//retrieve xref entity candidates
		List<OntologyTerm> panelTypeXrefs = db.query(OntologyTerm.class).find();	
		List<Species> speciesXrefs = db.query(Species.class).eq("__Type",Species.class.getSimpleName()).find();	
		List<Individual> individualsXrefs = db.query(Individual.class).eq("__Type",Individual.class.getSimpleName()).find();	

		for(Integer i = 0; i < total; i++)
		{
			AssayedPanel e = new AssayedPanel();
			e.setIdentifier(truncate("assayedpanel_identifier_"+i, 255));
			e.setName(truncate("assayedpanel_name_"+i, 100));
			e.setDescription("assayedpanel_description_"+i);
			if(panelTypeXrefs.size() > 0) e.setPanelType_Id( panelTypeXrefs.get(i).getId() );
			e.setNumberOfIndividuals(i);
			if(speciesXrefs.size() > 0) e.setSpecies_Id( speciesXrefs.get(i).getId() );
			if(individualsXrefs.size() > 0)
			{
				e.getIndividuals_Id().add( individualsXrefs.get(i).getId() );
				//e.getIndividuals().add( random(individualsXrefs).getId() );
			}
			e.setTotalNumberOfIndividuals(i);
			e.setNumberOfSexMale(i);
			e.setNumberOfSexFemale(i);
			e.setNumberOfSexUnknown(i);
			e.setNumberOfProbands(i);
			e.setNumberOfParents(i);
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<AssayedPanel> q = db.query(AssayedPanel.class).eq("__Type",AssayedPanel.class.getSimpleName());
		assertEquals(total, q.count());
		List<AssayedPanel> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			assertEquals(entities.get(i).getPanelType_Id(), entitiesDb.get(i).getPanelType_Id());
			assertEquals(entities.get(i).getNumberOfIndividuals(), entitiesDb.get(i).getNumberOfIndividuals());
			assertEquals(entities.get(i).getSpecies_Id(), entitiesDb.get(i).getSpecies_Id());
			assertEquals(entities.get(i).getIndividuals_Id(), entitiesDb.get(i).getIndividuals_Id());
			assertEquals(entities.get(i).getTotalNumberOfIndividuals(), entitiesDb.get(i).getTotalNumberOfIndividuals());
			assertEquals(entities.get(i).getNumberOfSexMale(), entitiesDb.get(i).getNumberOfSexMale());
			assertEquals(entities.get(i).getNumberOfSexFemale(), entitiesDb.get(i).getNumberOfSexFemale());
			assertEquals(entities.get(i).getNumberOfSexUnknown(), entitiesDb.get(i).getNumberOfSexUnknown());
			assertEquals(entities.get(i).getNumberOfProbands(), entitiesDb.get(i).getNumberOfProbands());
			assertEquals(entities.get(i).getNumberOfParents(), entitiesDb.get(i).getNumberOfParents());
		}	
		
		//test the query capabilities by finding on all fields
		for(AssayedPanel entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				q2.equals("id",entity.getId());
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				q2.equals("identifier",entity.getIdentifier());
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				q2.equals("name",entity.getName());
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'Description', type 'text'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				q2.equals("description",entity.getDescription());
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'Description'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'Description'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

			//test field 'PanelType', type 'xref'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				q2.equals("panelType",entity.getPanelType_Id());
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertEquals(r.getPanelType_Id(), entity.getPanelType_Id());
				}
			}
			//test operator 'in' for field 'PanelType'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getPanelType_Id());
				q2.in("panelType", inList);
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertEquals(r.getPanelType_Id(), entity.getPanelType_Id());
				}
			}
			//test operator 'equals' for implicit join field 'PanelType_Identifier'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				q2.equals("panelType_Identifier",entity.getPanelType_Identifier());
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertEquals(r.getPanelType_Id(), entity.getPanelType_Id());
				}
			}
			//test operator 'in' for implicit join field 'PanelType_Identifier'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getPanelType_Identifier());
				q2.in("panelType_Identifier", inList);
				q2.sortDESC("panelType_Identifier");
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertEquals(r.getPanelType_Id(), entity.getPanelType_Id());
				}
			}

			//test field 'NumberOfIndividuals', type 'int'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				q2.equals("numberOfIndividuals",entity.getNumberOfIndividuals());
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertEquals(r.getNumberOfIndividuals(),entity.getNumberOfIndividuals());
				}
			}
			//test operator 'in' for field 'NumberOfIndividuals'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getNumberOfIndividuals());
				q2.in("numberOfIndividuals", inList);
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertEquals(r.getNumberOfIndividuals(),entity.getNumberOfIndividuals());
				}
			}
			//test operator 'lessOrEqual' for field 'NumberOfIndividuals'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				q2.lessOrEqual("numberOfIndividuals", entity.getNumberOfIndividuals());
				q2.sortASC("numberOfIndividuals");
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertTrue(r.getNumberOfIndividuals().compareTo(entity.getNumberOfIndividuals()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'NumberOfIndividuals'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				q2.greaterOrEqual("numberOfIndividuals", entity.getNumberOfIndividuals());
				q2.sortDESC("numberOfIndividuals");
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertTrue(r.getNumberOfIndividuals().compareTo(entity.getNumberOfIndividuals()) > -1);
				}
			}

			//test field 'Species', type 'xref'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				q2.equals("species",entity.getSpecies_Id());
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertEquals(r.getSpecies_Id(), entity.getSpecies_Id());
				}
			}
			//test operator 'in' for field 'Species'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getSpecies_Id());
				q2.in("species", inList);
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertEquals(r.getSpecies_Id(), entity.getSpecies_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Species_Identifier'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				q2.equals("species_Identifier",entity.getSpecies_Identifier());
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertEquals(r.getSpecies_Id(), entity.getSpecies_Id());
				}
			}
			//test operator 'in' for implicit join field 'Species_Identifier'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getSpecies_Identifier());
				q2.in("species_Identifier", inList);
				q2.sortDESC("species_Identifier");
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertEquals(r.getSpecies_Id(), entity.getSpecies_Id());
				}
			}

			//test field 'TotalNumberOfIndividuals', type 'int'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				q2.equals("totalNumberOfIndividuals",entity.getTotalNumberOfIndividuals());
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertEquals(r.getTotalNumberOfIndividuals(),entity.getTotalNumberOfIndividuals());
				}
			}
			//test operator 'in' for field 'TotalNumberOfIndividuals'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getTotalNumberOfIndividuals());
				q2.in("totalNumberOfIndividuals", inList);
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertEquals(r.getTotalNumberOfIndividuals(),entity.getTotalNumberOfIndividuals());
				}
			}
			//test operator 'lessOrEqual' for field 'TotalNumberOfIndividuals'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				q2.lessOrEqual("totalNumberOfIndividuals", entity.getTotalNumberOfIndividuals());
				q2.sortASC("totalNumberOfIndividuals");
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertTrue(r.getTotalNumberOfIndividuals().compareTo(entity.getTotalNumberOfIndividuals()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'TotalNumberOfIndividuals'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				q2.greaterOrEqual("totalNumberOfIndividuals", entity.getTotalNumberOfIndividuals());
				q2.sortDESC("totalNumberOfIndividuals");
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertTrue(r.getTotalNumberOfIndividuals().compareTo(entity.getTotalNumberOfIndividuals()) > -1);
				}
			}

			//test field 'NumberOfSexMale', type 'int'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				q2.equals("numberOfSexMale",entity.getNumberOfSexMale());
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertEquals(r.getNumberOfSexMale(),entity.getNumberOfSexMale());
				}
			}
			//test operator 'in' for field 'NumberOfSexMale'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getNumberOfSexMale());
				q2.in("numberOfSexMale", inList);
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertEquals(r.getNumberOfSexMale(),entity.getNumberOfSexMale());
				}
			}
			//test operator 'lessOrEqual' for field 'NumberOfSexMale'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				q2.lessOrEqual("numberOfSexMale", entity.getNumberOfSexMale());
				q2.sortASC("numberOfSexMale");
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertTrue(r.getNumberOfSexMale().compareTo(entity.getNumberOfSexMale()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'NumberOfSexMale'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				q2.greaterOrEqual("numberOfSexMale", entity.getNumberOfSexMale());
				q2.sortDESC("numberOfSexMale");
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertTrue(r.getNumberOfSexMale().compareTo(entity.getNumberOfSexMale()) > -1);
				}
			}

			//test field 'NumberOfSexFemale', type 'int'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				q2.equals("numberOfSexFemale",entity.getNumberOfSexFemale());
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertEquals(r.getNumberOfSexFemale(),entity.getNumberOfSexFemale());
				}
			}
			//test operator 'in' for field 'NumberOfSexFemale'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getNumberOfSexFemale());
				q2.in("numberOfSexFemale", inList);
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertEquals(r.getNumberOfSexFemale(),entity.getNumberOfSexFemale());
				}
			}
			//test operator 'lessOrEqual' for field 'NumberOfSexFemale'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				q2.lessOrEqual("numberOfSexFemale", entity.getNumberOfSexFemale());
				q2.sortASC("numberOfSexFemale");
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertTrue(r.getNumberOfSexFemale().compareTo(entity.getNumberOfSexFemale()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'NumberOfSexFemale'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				q2.greaterOrEqual("numberOfSexFemale", entity.getNumberOfSexFemale());
				q2.sortDESC("numberOfSexFemale");
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertTrue(r.getNumberOfSexFemale().compareTo(entity.getNumberOfSexFemale()) > -1);
				}
			}

			//test field 'NumberOfSexUnknown', type 'int'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				q2.equals("numberOfSexUnknown",entity.getNumberOfSexUnknown());
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertEquals(r.getNumberOfSexUnknown(),entity.getNumberOfSexUnknown());
				}
			}
			//test operator 'in' for field 'NumberOfSexUnknown'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getNumberOfSexUnknown());
				q2.in("numberOfSexUnknown", inList);
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertEquals(r.getNumberOfSexUnknown(),entity.getNumberOfSexUnknown());
				}
			}
			//test operator 'lessOrEqual' for field 'NumberOfSexUnknown'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				q2.lessOrEqual("numberOfSexUnknown", entity.getNumberOfSexUnknown());
				q2.sortASC("numberOfSexUnknown");
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertTrue(r.getNumberOfSexUnknown().compareTo(entity.getNumberOfSexUnknown()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'NumberOfSexUnknown'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				q2.greaterOrEqual("numberOfSexUnknown", entity.getNumberOfSexUnknown());
				q2.sortDESC("numberOfSexUnknown");
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertTrue(r.getNumberOfSexUnknown().compareTo(entity.getNumberOfSexUnknown()) > -1);
				}
			}

			//test field 'NumberOfProbands', type 'int'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				q2.equals("numberOfProbands",entity.getNumberOfProbands());
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertEquals(r.getNumberOfProbands(),entity.getNumberOfProbands());
				}
			}
			//test operator 'in' for field 'NumberOfProbands'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getNumberOfProbands());
				q2.in("numberOfProbands", inList);
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertEquals(r.getNumberOfProbands(),entity.getNumberOfProbands());
				}
			}
			//test operator 'lessOrEqual' for field 'NumberOfProbands'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				q2.lessOrEqual("numberOfProbands", entity.getNumberOfProbands());
				q2.sortASC("numberOfProbands");
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertTrue(r.getNumberOfProbands().compareTo(entity.getNumberOfProbands()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'NumberOfProbands'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				q2.greaterOrEqual("numberOfProbands", entity.getNumberOfProbands());
				q2.sortDESC("numberOfProbands");
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertTrue(r.getNumberOfProbands().compareTo(entity.getNumberOfProbands()) > -1);
				}
			}

			//test field 'NumberOfParents', type 'int'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				q2.equals("numberOfParents",entity.getNumberOfParents());
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertEquals(r.getNumberOfParents(),entity.getNumberOfParents());
				}
			}
			//test operator 'in' for field 'NumberOfParents'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getNumberOfParents());
				q2.in("numberOfParents", inList);
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertEquals(r.getNumberOfParents(),entity.getNumberOfParents());
				}
			}
			//test operator 'lessOrEqual' for field 'NumberOfParents'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				q2.lessOrEqual("numberOfParents", entity.getNumberOfParents());
				q2.sortASC("numberOfParents");
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertTrue(r.getNumberOfParents().compareTo(entity.getNumberOfParents()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'NumberOfParents'
			{
				Query<AssayedPanel> q2 = db.query(AssayedPanel.class);
				q2.greaterOrEqual("numberOfParents", entity.getNumberOfParents());
				q2.sortDESC("numberOfParents");
				List<AssayedPanel> results = q2.find();
				for(AssayedPanel r: results)
				{
					assertTrue(r.getNumberOfParents().compareTo(entity.getNumberOfParents()) > -1);
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testPanel","testPanel"})
	public void testPanelSource() throws DatabaseException
	{
		//create entities
		List<PanelSource> entities = new ArrayList<PanelSource>();

		//retrieve xref entity candidates
		List<Panel> currentPanelXrefs = db.query(Panel.class).eq("__Type",Panel.class.getSimpleName()).find();	
		List<Panel> sourcePanelXrefs = db.query(Panel.class).eq("__Type",Panel.class.getSimpleName()).find();	

		for(Integer i = 0; i < total; i++)
		{
			PanelSource e = new PanelSource();
			if(currentPanelXrefs.size() > 0) e.setCurrentPanel_Id( currentPanelXrefs.get(i).getId() );
			if(sourcePanelXrefs.size() > 0) e.setSourcePanel_Id( sourcePanelXrefs.get(i).getId() );
			e.setNumberOfIndividuals(i);
			e.setSelectionCriteria("panelsource_selectioncriteria_"+i);
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<PanelSource> q = db.query(PanelSource.class);
		assertEquals(total, q.count());
		List<PanelSource> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getCurrentPanel_Id(), entitiesDb.get(i).getCurrentPanel_Id());
			assertEquals(entities.get(i).getSourcePanel_Id(), entitiesDb.get(i).getSourcePanel_Id());
			assertEquals(entities.get(i).getNumberOfIndividuals(), entitiesDb.get(i).getNumberOfIndividuals());
			assertEquals(entities.get(i).getSelectionCriteria(), entitiesDb.get(i).getSelectionCriteria());
		}	
		
		//test the query capabilities by finding on all fields
		for(PanelSource entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<PanelSource> q2 = db.query(PanelSource.class);
				q2.equals("id",entity.getId());
				List<PanelSource> results = q2.find();
				assertEquals(results.size(),1);
				for(PanelSource r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<PanelSource> q2 = db.query(PanelSource.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<PanelSource> results = q2.find();
				assertEquals(results.size(),1);
				for(PanelSource r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<PanelSource> q2 = db.query(PanelSource.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<PanelSource> results = q2.find();
				for(PanelSource r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<PanelSource> q2 = db.query(PanelSource.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<PanelSource> results = q2.find();
				for(PanelSource r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'CurrentPanel', type 'xref'
			{
				Query<PanelSource> q2 = db.query(PanelSource.class);
				q2.equals("currentPanel",entity.getCurrentPanel_Id());
				List<PanelSource> results = q2.find();
				for(PanelSource r: results)
				{
					assertEquals(r.getCurrentPanel_Id(), entity.getCurrentPanel_Id());
				}
			}
			//test operator 'in' for field 'CurrentPanel'
			{
				Query<PanelSource> q2 = db.query(PanelSource.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getCurrentPanel_Id());
				q2.in("currentPanel", inList);
				List<PanelSource> results = q2.find();
				for(PanelSource r: results)
				{
					assertEquals(r.getCurrentPanel_Id(), entity.getCurrentPanel_Id());
				}
			}
			//test operator 'equals' for implicit join field 'CurrentPanel_Identifier'
			{
				Query<PanelSource> q2 = db.query(PanelSource.class);
				q2.equals("currentPanel_Identifier",entity.getCurrentPanel_Identifier());
				List<PanelSource> results = q2.find();
				for(PanelSource r: results)
				{
					assertEquals(r.getCurrentPanel_Id(), entity.getCurrentPanel_Id());
				}
			}
			//test operator 'in' for implicit join field 'CurrentPanel_Identifier'
			{
				Query<PanelSource> q2 = db.query(PanelSource.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getCurrentPanel_Identifier());
				q2.in("currentPanel_Identifier", inList);
				q2.sortDESC("currentPanel_Identifier");
				List<PanelSource> results = q2.find();
				for(PanelSource r: results)
				{
					assertEquals(r.getCurrentPanel_Id(), entity.getCurrentPanel_Id());
				}
			}

			//test field 'SourcePanel', type 'xref'
			{
				Query<PanelSource> q2 = db.query(PanelSource.class);
				q2.equals("sourcePanel",entity.getSourcePanel_Id());
				List<PanelSource> results = q2.find();
				for(PanelSource r: results)
				{
					assertEquals(r.getSourcePanel_Id(), entity.getSourcePanel_Id());
				}
			}
			//test operator 'in' for field 'SourcePanel'
			{
				Query<PanelSource> q2 = db.query(PanelSource.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getSourcePanel_Id());
				q2.in("sourcePanel", inList);
				List<PanelSource> results = q2.find();
				for(PanelSource r: results)
				{
					assertEquals(r.getSourcePanel_Id(), entity.getSourcePanel_Id());
				}
			}
			//test operator 'equals' for implicit join field 'SourcePanel_Identifier'
			{
				Query<PanelSource> q2 = db.query(PanelSource.class);
				q2.equals("sourcePanel_Identifier",entity.getSourcePanel_Identifier());
				List<PanelSource> results = q2.find();
				for(PanelSource r: results)
				{
					assertEquals(r.getSourcePanel_Id(), entity.getSourcePanel_Id());
				}
			}
			//test operator 'in' for implicit join field 'SourcePanel_Identifier'
			{
				Query<PanelSource> q2 = db.query(PanelSource.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getSourcePanel_Identifier());
				q2.in("sourcePanel_Identifier", inList);
				q2.sortDESC("sourcePanel_Identifier");
				List<PanelSource> results = q2.find();
				for(PanelSource r: results)
				{
					assertEquals(r.getSourcePanel_Id(), entity.getSourcePanel_Id());
				}
			}

			//test field 'NumberOfIndividuals', type 'int'
			{
				Query<PanelSource> q2 = db.query(PanelSource.class);
				q2.equals("numberOfIndividuals",entity.getNumberOfIndividuals());
				List<PanelSource> results = q2.find();
				for(PanelSource r: results)
				{
					assertEquals(r.getNumberOfIndividuals(),entity.getNumberOfIndividuals());
				}
			}
			//test operator 'in' for field 'NumberOfIndividuals'
			{
				Query<PanelSource> q2 = db.query(PanelSource.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getNumberOfIndividuals());
				q2.in("numberOfIndividuals", inList);
				List<PanelSource> results = q2.find();
				for(PanelSource r: results)
				{
					assertEquals(r.getNumberOfIndividuals(),entity.getNumberOfIndividuals());
				}
			}
			//test operator 'lessOrEqual' for field 'NumberOfIndividuals'
			{
				Query<PanelSource> q2 = db.query(PanelSource.class);
				q2.lessOrEqual("numberOfIndividuals", entity.getNumberOfIndividuals());
				q2.sortASC("numberOfIndividuals");
				List<PanelSource> results = q2.find();
				for(PanelSource r: results)
				{
					assertTrue(r.getNumberOfIndividuals().compareTo(entity.getNumberOfIndividuals()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'NumberOfIndividuals'
			{
				Query<PanelSource> q2 = db.query(PanelSource.class);
				q2.greaterOrEqual("numberOfIndividuals", entity.getNumberOfIndividuals());
				q2.sortDESC("numberOfIndividuals");
				List<PanelSource> results = q2.find();
				for(PanelSource r: results)
				{
					assertTrue(r.getNumberOfIndividuals().compareTo(entity.getNumberOfIndividuals()) > -1);
				}
			}

			//test field 'SelectionCriteria', type 'text'
			{
				Query<PanelSource> q2 = db.query(PanelSource.class);
				q2.equals("selectionCriteria",entity.getSelectionCriteria());
				List<PanelSource> results = q2.find();
				for(PanelSource r: results)
				{
					assertEquals(r.getSelectionCriteria(),entity.getSelectionCriteria());
				}
			}
			//test operator 'in' for field 'SelectionCriteria'
			{
				Query<PanelSource> q2 = db.query(PanelSource.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getSelectionCriteria());
				q2.in("selectionCriteria", inList);
				List<PanelSource> results = q2.find();
				for(PanelSource r: results)
				{
					assertEquals(r.getSelectionCriteria(),entity.getSelectionCriteria());
				}
			}
			//test operator 'like' for field 'SelectionCriteria'
			{
				Query<PanelSource> q2 = db.query(PanelSource.class);
				q2.like("selectionCriteria", entity.getSelectionCriteria() + "%");
				q2.sortASC("selectionCriteria");
				List<PanelSource> results = q2.find();
				for(PanelSource r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getSelectionCriteria(), entity.getSelectionCriteria()));
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testStudy","testOntologyTerm"})
	public void testGWASExperiment() throws DatabaseException
	{
		//create entities
		List<GWASExperiment> entities = new ArrayList<GWASExperiment>();

		//retrieve xref entity candidates
		List<Study> studyXrefs = db.query(Study.class).find();	
		List<OntologyTerm> experimentTypeXrefs = db.query(OntologyTerm.class).find();	
		List<Panel> assayedPanelsXrefs = db.query(Panel.class).eq("__Type",Panel.class.getSimpleName()).find();	
		List<DataSet> dataSetsXrefs = db.query(DataSet.class).eq("__Type",DataSet.class.getSimpleName()).find();	

		for(Integer i = 0; i < total; i++)
		{
			GWASExperiment e = new GWASExperiment();
			e.setIdentifier(truncate("gwasexperiment_identifier_"+i, 255));
			e.setName(truncate("gwasexperiment_name_"+i, 255));
			if(studyXrefs.size() > 0) e.setStudy_Id( studyXrefs.get(i).getId() );
			e.setDesign(truncate("gwasexperiment_design_"+i, 50));
			if(experimentTypeXrefs.size() > 0) e.setExperimentType_Id( experimentTypeXrefs.get(i).getId() );
			e.setTotalMarkersTested(i);
			e.setTotalMarkersImported(i);
			e.setObjective("gwasexperiment_objective_"+i);
			e.setOutcome("gwasexperiment_outcome_"+i);
			e.setComments("gwasexperiment_comments_"+i);
			e.setIndividualDataStatement("gwasexperiment_individualdatastatement_"+i);
			e.setTimeCreated(new java.sql.Timestamp(new java.util.Date().getTime()));
			if(assayedPanelsXrefs.size() > 0)
			{
				e.getAssayedPanels_Id().add( assayedPanelsXrefs.get(i).getId() );
				//e.getAssayedPanels().add( random(assayedPanelsXrefs).getId() );
			}
			if(dataSetsXrefs.size() > 0)
			{
				e.getDataSets_Id().add( dataSetsXrefs.get(i).getId() );
				//e.getDataSets().add( random(dataSetsXrefs).getId() );
			}
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<GWASExperiment> q = db.query(GWASExperiment.class).eq("__Type",GWASExperiment.class.getSimpleName());
		assertEquals(total, q.count());
		List<GWASExperiment> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getStudy_Id(), entitiesDb.get(i).getStudy_Id());
			assertEquals(entities.get(i).getDesign(), entitiesDb.get(i).getDesign());
			assertEquals(entities.get(i).getExperimentType_Id(), entitiesDb.get(i).getExperimentType_Id());
			assertEquals(entities.get(i).getTotalMarkersTested(), entitiesDb.get(i).getTotalMarkersTested());
			assertEquals(entities.get(i).getTotalMarkersImported(), entitiesDb.get(i).getTotalMarkersImported());
			assertEquals(entities.get(i).getObjective(), entitiesDb.get(i).getObjective());
			assertEquals(entities.get(i).getOutcome(), entitiesDb.get(i).getOutcome());
			assertEquals(entities.get(i).getComments(), entitiesDb.get(i).getComments());
			assertEquals(entities.get(i).getIndividualDataStatement(), entitiesDb.get(i).getIndividualDataStatement());
			//check formatted because of milliseconds rounding
			assertEquals(dateTimeFormat.format(entities.get(i).getTimeCreated()),dateTimeFormat.format(entitiesDb.get(i).getTimeCreated()));
			assertEquals(entities.get(i).getAssayedPanels_Id(), entitiesDb.get(i).getAssayedPanels_Id());
			assertEquals(entities.get(i).getDataSets_Id(), entitiesDb.get(i).getDataSets_Id());
		}	
		
		//test the query capabilities by finding on all fields
		for(GWASExperiment entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				q2.equals("id",entity.getId());
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				q2.equals("identifier",entity.getIdentifier());
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				q2.equals("name",entity.getName());
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'Study', type 'xref'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				q2.equals("study",entity.getStudy_Id());
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertEquals(r.getStudy_Id(), entity.getStudy_Id());
				}
			}
			//test operator 'in' for field 'Study'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getStudy_Id());
				q2.in("study", inList);
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertEquals(r.getStudy_Id(), entity.getStudy_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Study_Identifier'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				q2.equals("study_Identifier",entity.getStudy_Identifier());
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertEquals(r.getStudy_Id(), entity.getStudy_Id());
				}
			}
			//test operator 'in' for implicit join field 'Study_Identifier'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getStudy_Identifier());
				q2.in("study_Identifier", inList);
				q2.sortDESC("study_Identifier");
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertEquals(r.getStudy_Id(), entity.getStudy_Id());
				}
			}

			//test field 'Design', type 'string'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				q2.equals("design",entity.getDesign());
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertEquals(r.getDesign(),entity.getDesign());
				}
			}
			//test operator 'in' for field 'Design'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDesign());
				q2.in("design", inList);
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertEquals(r.getDesign(),entity.getDesign());
				}
			}
			//test operator 'like' for field 'Design'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				q2.like("design", entity.getDesign() + "%");
				q2.sortASC("design");
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDesign(), entity.getDesign()));
				}
			}

			//test field 'ExperimentType', type 'xref'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				q2.equals("experimentType",entity.getExperimentType_Id());
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertEquals(r.getExperimentType_Id(), entity.getExperimentType_Id());
				}
			}
			//test operator 'in' for field 'ExperimentType'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getExperimentType_Id());
				q2.in("experimentType", inList);
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertEquals(r.getExperimentType_Id(), entity.getExperimentType_Id());
				}
			}
			//test operator 'equals' for implicit join field 'ExperimentType_Identifier'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				q2.equals("experimentType_Identifier",entity.getExperimentType_Identifier());
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertEquals(r.getExperimentType_Id(), entity.getExperimentType_Id());
				}
			}
			//test operator 'in' for implicit join field 'ExperimentType_Identifier'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getExperimentType_Identifier());
				q2.in("experimentType_Identifier", inList);
				q2.sortDESC("experimentType_Identifier");
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertEquals(r.getExperimentType_Id(), entity.getExperimentType_Id());
				}
			}

			//test field 'TotalMarkersTested', type 'int'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				q2.equals("totalMarkersTested",entity.getTotalMarkersTested());
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertEquals(r.getTotalMarkersTested(),entity.getTotalMarkersTested());
				}
			}
			//test operator 'in' for field 'TotalMarkersTested'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getTotalMarkersTested());
				q2.in("totalMarkersTested", inList);
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertEquals(r.getTotalMarkersTested(),entity.getTotalMarkersTested());
				}
			}
			//test operator 'lessOrEqual' for field 'TotalMarkersTested'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				q2.lessOrEqual("totalMarkersTested", entity.getTotalMarkersTested());
				q2.sortASC("totalMarkersTested");
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertTrue(r.getTotalMarkersTested().compareTo(entity.getTotalMarkersTested()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'TotalMarkersTested'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				q2.greaterOrEqual("totalMarkersTested", entity.getTotalMarkersTested());
				q2.sortDESC("totalMarkersTested");
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertTrue(r.getTotalMarkersTested().compareTo(entity.getTotalMarkersTested()) > -1);
				}
			}

			//test field 'TotalMarkersImported', type 'int'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				q2.equals("totalMarkersImported",entity.getTotalMarkersImported());
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertEquals(r.getTotalMarkersImported(),entity.getTotalMarkersImported());
				}
			}
			//test operator 'in' for field 'TotalMarkersImported'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getTotalMarkersImported());
				q2.in("totalMarkersImported", inList);
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertEquals(r.getTotalMarkersImported(),entity.getTotalMarkersImported());
				}
			}
			//test operator 'lessOrEqual' for field 'TotalMarkersImported'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				q2.lessOrEqual("totalMarkersImported", entity.getTotalMarkersImported());
				q2.sortASC("totalMarkersImported");
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertTrue(r.getTotalMarkersImported().compareTo(entity.getTotalMarkersImported()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'TotalMarkersImported'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				q2.greaterOrEqual("totalMarkersImported", entity.getTotalMarkersImported());
				q2.sortDESC("totalMarkersImported");
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertTrue(r.getTotalMarkersImported().compareTo(entity.getTotalMarkersImported()) > -1);
				}
			}

			//test field 'Objective', type 'text'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				q2.equals("objective",entity.getObjective());
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertEquals(r.getObjective(),entity.getObjective());
				}
			}
			//test operator 'in' for field 'Objective'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getObjective());
				q2.in("objective", inList);
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertEquals(r.getObjective(),entity.getObjective());
				}
			}
			//test operator 'like' for field 'Objective'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				q2.like("objective", entity.getObjective() + "%");
				q2.sortASC("objective");
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getObjective(), entity.getObjective()));
				}
			}

			//test field 'Outcome', type 'text'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				q2.equals("outcome",entity.getOutcome());
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertEquals(r.getOutcome(),entity.getOutcome());
				}
			}
			//test operator 'in' for field 'Outcome'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getOutcome());
				q2.in("outcome", inList);
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertEquals(r.getOutcome(),entity.getOutcome());
				}
			}
			//test operator 'like' for field 'Outcome'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				q2.like("outcome", entity.getOutcome() + "%");
				q2.sortASC("outcome");
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getOutcome(), entity.getOutcome()));
				}
			}

			//test field 'Comments', type 'text'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				q2.equals("comments",entity.getComments());
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertEquals(r.getComments(),entity.getComments());
				}
			}
			//test operator 'in' for field 'Comments'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getComments());
				q2.in("comments", inList);
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertEquals(r.getComments(),entity.getComments());
				}
			}
			//test operator 'like' for field 'Comments'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				q2.like("comments", entity.getComments() + "%");
				q2.sortASC("comments");
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getComments(), entity.getComments()));
				}
			}

			//test field 'IndividualDataStatement', type 'text'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				q2.equals("individualDataStatement",entity.getIndividualDataStatement());
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertEquals(r.getIndividualDataStatement(),entity.getIndividualDataStatement());
				}
			}
			//test operator 'in' for field 'IndividualDataStatement'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIndividualDataStatement());
				q2.in("individualDataStatement", inList);
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertEquals(r.getIndividualDataStatement(),entity.getIndividualDataStatement());
				}
			}
			//test operator 'like' for field 'IndividualDataStatement'
			{
				Query<GWASExperiment> q2 = db.query(GWASExperiment.class);
				q2.like("individualDataStatement", entity.getIndividualDataStatement() + "%");
				q2.sortASC("individualDataStatement");
				List<GWASExperiment> results = q2.find();
				for(GWASExperiment r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIndividualDataStatement(), entity.getIndividualDataStatement()));
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testOntologyTerm","testExperiment"})
	public void testUsedMarkerSet() throws DatabaseException
	{
		//create entities
		List<UsedMarkerSet> entities = new ArrayList<UsedMarkerSet>();

		//retrieve xref entity candidates
		List<OntologyTerm> unitXrefs = db.query(OntologyTerm.class).find();	
		List<Experiment> experimentIDXrefs = db.query(Experiment.class).find();	

		for(Integer i = 0; i < total; i++)
		{
			UsedMarkerSet e = new UsedMarkerSet();
			e.setIdentifier(truncate("usedmarkerset_identifier_"+i, 255));
			e.setName(truncate("usedmarkerset_name_"+i, 255));
			e.setDescription("usedmarkerset_description_"+i);
			if(unitXrefs.size() > 0) e.setUnit_Id( unitXrefs.get(i).getId() );
			e.setDataType(randomEnum(new String[]{"xref","string","categorical","nominal","ordinal","date","datetime","int","code","image","decimal","bool","file","log","data","exe"}));
			e.setTemporal(randomBool(i));
			if(experimentIDXrefs.size() > 0) e.setExperimentID_Id( experimentIDXrefs.get(i).getId() );
			e.setMarkerIdentifier(truncate("usedmarkerset_markeridentifier_"+i, 255));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<UsedMarkerSet> q = db.query(UsedMarkerSet.class).eq("__Type",UsedMarkerSet.class.getSimpleName());
		assertEquals(total, q.count());
		List<UsedMarkerSet> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			assertEquals(entities.get(i).getUnit_Id(), entitiesDb.get(i).getUnit_Id());
			assertEquals(entities.get(i).getDataType(), entitiesDb.get(i).getDataType());
			assertEquals(entities.get(i).getTemporal(), entitiesDb.get(i).getTemporal());
			assertEquals(entities.get(i).getExperimentID_Id(), entitiesDb.get(i).getExperimentID_Id());
			assertEquals(entities.get(i).getMarkerIdentifier(), entitiesDb.get(i).getMarkerIdentifier());
		}	
		
		//test the query capabilities by finding on all fields
		for(UsedMarkerSet entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<UsedMarkerSet> q2 = db.query(UsedMarkerSet.class);
				q2.equals("id",entity.getId());
				List<UsedMarkerSet> results = q2.find();
				for(UsedMarkerSet r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<UsedMarkerSet> q2 = db.query(UsedMarkerSet.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<UsedMarkerSet> results = q2.find();
				for(UsedMarkerSet r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<UsedMarkerSet> q2 = db.query(UsedMarkerSet.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<UsedMarkerSet> results = q2.find();
				for(UsedMarkerSet r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<UsedMarkerSet> q2 = db.query(UsedMarkerSet.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<UsedMarkerSet> results = q2.find();
				for(UsedMarkerSet r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<UsedMarkerSet> q2 = db.query(UsedMarkerSet.class);
				q2.equals("identifier",entity.getIdentifier());
				List<UsedMarkerSet> results = q2.find();
				for(UsedMarkerSet r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<UsedMarkerSet> q2 = db.query(UsedMarkerSet.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<UsedMarkerSet> results = q2.find();
				for(UsedMarkerSet r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<UsedMarkerSet> q2 = db.query(UsedMarkerSet.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<UsedMarkerSet> results = q2.find();
				for(UsedMarkerSet r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<UsedMarkerSet> q2 = db.query(UsedMarkerSet.class);
				q2.equals("name",entity.getName());
				List<UsedMarkerSet> results = q2.find();
				for(UsedMarkerSet r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<UsedMarkerSet> q2 = db.query(UsedMarkerSet.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<UsedMarkerSet> results = q2.find();
				for(UsedMarkerSet r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<UsedMarkerSet> q2 = db.query(UsedMarkerSet.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<UsedMarkerSet> results = q2.find();
				for(UsedMarkerSet r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'description', type 'text'
			{
				Query<UsedMarkerSet> q2 = db.query(UsedMarkerSet.class);
				q2.equals("description",entity.getDescription());
				List<UsedMarkerSet> results = q2.find();
				for(UsedMarkerSet r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'description'
			{
				Query<UsedMarkerSet> q2 = db.query(UsedMarkerSet.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<UsedMarkerSet> results = q2.find();
				for(UsedMarkerSet r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'description'
			{
				Query<UsedMarkerSet> q2 = db.query(UsedMarkerSet.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<UsedMarkerSet> results = q2.find();
				for(UsedMarkerSet r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

			//test field 'unit', type 'xref'
			{
				Query<UsedMarkerSet> q2 = db.query(UsedMarkerSet.class);
				q2.equals("unit",entity.getUnit_Id());
				List<UsedMarkerSet> results = q2.find();
				for(UsedMarkerSet r: results)
				{
					assertEquals(r.getUnit_Id(), entity.getUnit_Id());
				}
			}
			//test operator 'in' for field 'unit'
			{
				Query<UsedMarkerSet> q2 = db.query(UsedMarkerSet.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getUnit_Id());
				q2.in("unit", inList);
				List<UsedMarkerSet> results = q2.find();
				for(UsedMarkerSet r: results)
				{
					assertEquals(r.getUnit_Id(), entity.getUnit_Id());
				}
			}
			//test operator 'equals' for implicit join field 'unit_Identifier'
			{
				Query<UsedMarkerSet> q2 = db.query(UsedMarkerSet.class);
				q2.equals("unit_Identifier",entity.getUnit_Identifier());
				List<UsedMarkerSet> results = q2.find();
				for(UsedMarkerSet r: results)
				{
					assertEquals(r.getUnit_Id(), entity.getUnit_Id());
				}
			}
			//test operator 'in' for implicit join field 'unit_Identifier'
			{
				Query<UsedMarkerSet> q2 = db.query(UsedMarkerSet.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getUnit_Identifier());
				q2.in("unit_Identifier", inList);
				q2.sortDESC("unit_Identifier");
				List<UsedMarkerSet> results = q2.find();
				for(UsedMarkerSet r: results)
				{
					assertEquals(r.getUnit_Id(), entity.getUnit_Id());
				}
			}

			//test field 'ExperimentID', type 'xref'
			{
				Query<UsedMarkerSet> q2 = db.query(UsedMarkerSet.class);
				q2.equals("experimentID",entity.getExperimentID_Id());
				List<UsedMarkerSet> results = q2.find();
				for(UsedMarkerSet r: results)
				{
					assertEquals(r.getExperimentID_Id(), entity.getExperimentID_Id());
				}
			}
			//test operator 'in' for field 'ExperimentID'
			{
				Query<UsedMarkerSet> q2 = db.query(UsedMarkerSet.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getExperimentID_Id());
				q2.in("experimentID", inList);
				List<UsedMarkerSet> results = q2.find();
				for(UsedMarkerSet r: results)
				{
					assertEquals(r.getExperimentID_Id(), entity.getExperimentID_Id());
				}
			}
			//test operator 'equals' for implicit join field 'ExperimentID_Identifier'
			{
				Query<UsedMarkerSet> q2 = db.query(UsedMarkerSet.class);
				q2.equals("experimentID_Identifier",entity.getExperimentID_Identifier());
				List<UsedMarkerSet> results = q2.find();
				for(UsedMarkerSet r: results)
				{
					assertEquals(r.getExperimentID_Id(), entity.getExperimentID_Id());
				}
			}
			//test operator 'in' for implicit join field 'ExperimentID_Identifier'
			{
				Query<UsedMarkerSet> q2 = db.query(UsedMarkerSet.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getExperimentID_Identifier());
				q2.in("experimentID_Identifier", inList);
				q2.sortDESC("experimentID_Identifier");
				List<UsedMarkerSet> results = q2.find();
				for(UsedMarkerSet r: results)
				{
					assertEquals(r.getExperimentID_Id(), entity.getExperimentID_Id());
				}
			}

			//test field 'MarkerIdentifier', type 'string'
			{
				Query<UsedMarkerSet> q2 = db.query(UsedMarkerSet.class);
				q2.equals("markerIdentifier",entity.getMarkerIdentifier());
				List<UsedMarkerSet> results = q2.find();
				for(UsedMarkerSet r: results)
				{
					assertEquals(r.getMarkerIdentifier(),entity.getMarkerIdentifier());
				}
			}
			//test operator 'in' for field 'MarkerIdentifier'
			{
				Query<UsedMarkerSet> q2 = db.query(UsedMarkerSet.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getMarkerIdentifier());
				q2.in("markerIdentifier", inList);
				List<UsedMarkerSet> results = q2.find();
				for(UsedMarkerSet r: results)
				{
					assertEquals(r.getMarkerIdentifier(),entity.getMarkerIdentifier());
				}
			}
			//test operator 'like' for field 'MarkerIdentifier'
			{
				Query<UsedMarkerSet> q2 = db.query(UsedMarkerSet.class);
				q2.like("markerIdentifier", entity.getMarkerIdentifier() + "%");
				q2.sortASC("markerIdentifier");
				List<UsedMarkerSet> results = q2.find();
				for(UsedMarkerSet r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getMarkerIdentifier(), entity.getMarkerIdentifier()));
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testObservableFeature"})
	public void testCategory() throws DatabaseException
	{
		//create entities
		List<Category> entities = new ArrayList<Category>();

		//retrieve xref entity candidates
		List<ObservableFeature> observableFeatureXrefs = db.query(ObservableFeature.class).eq("__Type",ObservableFeature.class.getSimpleName()).find();	

		for(Integer i = 0; i < total; i++)
		{
			Category e = new Category();
			e.setIdentifier(truncate("category_identifier_"+i, 255));
			e.setName(truncate("category_name_"+i, 255));
			e.setDescription("category_description_"+i);
			if(observableFeatureXrefs.size() > 0) e.setObservableFeature_Id( observableFeatureXrefs.get(i).getId() );
			e.setValueCode(truncate("category_valuecode_"+i, 255));
			e.setIsMissing(randomBool(i));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<Category> q = db.query(Category.class).eq("__Type",Category.class.getSimpleName());
		assertEquals(total, q.count());
		List<Category> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			assertEquals(entities.get(i).getObservableFeature_Id(), entitiesDb.get(i).getObservableFeature_Id());
			assertEquals(entities.get(i).getValueCode(), entitiesDb.get(i).getValueCode());
			assertEquals(entities.get(i).getIsMissing(), entitiesDb.get(i).getIsMissing());
		}	
		
		//test the query capabilities by finding on all fields
		for(Category entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<Category> q2 = db.query(Category.class);
				q2.equals("id",entity.getId());
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<Category> q2 = db.query(Category.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<Category> q2 = db.query(Category.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<Category> q2 = db.query(Category.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<Category> q2 = db.query(Category.class);
				q2.equals("identifier",entity.getIdentifier());
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<Category> q2 = db.query(Category.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<Category> q2 = db.query(Category.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<Category> q2 = db.query(Category.class);
				q2.equals("name",entity.getName());
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<Category> q2 = db.query(Category.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<Category> q2 = db.query(Category.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'description', type 'text'
			{
				Query<Category> q2 = db.query(Category.class);
				q2.equals("description",entity.getDescription());
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'description'
			{
				Query<Category> q2 = db.query(Category.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'description'
			{
				Query<Category> q2 = db.query(Category.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

			//test field 'observableFeature', type 'xref'
			{
				Query<Category> q2 = db.query(Category.class);
				q2.equals("observableFeature",entity.getObservableFeature_Id());
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertEquals(r.getObservableFeature_Id(), entity.getObservableFeature_Id());
				}
			}
			//test operator 'in' for field 'observableFeature'
			{
				Query<Category> q2 = db.query(Category.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getObservableFeature_Id());
				q2.in("observableFeature", inList);
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertEquals(r.getObservableFeature_Id(), entity.getObservableFeature_Id());
				}
			}
			//test operator 'equals' for implicit join field 'observableFeature_Identifier'
			{
				Query<Category> q2 = db.query(Category.class);
				q2.equals("observableFeature_Identifier",entity.getObservableFeature_Identifier());
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertEquals(r.getObservableFeature_Id(), entity.getObservableFeature_Id());
				}
			}
			//test operator 'in' for implicit join field 'observableFeature_Identifier'
			{
				Query<Category> q2 = db.query(Category.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getObservableFeature_Identifier());
				q2.in("observableFeature_Identifier", inList);
				q2.sortDESC("observableFeature_Identifier");
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertEquals(r.getObservableFeature_Id(), entity.getObservableFeature_Id());
				}
			}

			//test field 'valueCode', type 'string'
			{
				Query<Category> q2 = db.query(Category.class);
				q2.equals("valueCode",entity.getValueCode());
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertEquals(r.getValueCode(),entity.getValueCode());
				}
			}
			//test operator 'in' for field 'valueCode'
			{
				Query<Category> q2 = db.query(Category.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getValueCode());
				q2.in("valueCode", inList);
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertEquals(r.getValueCode(),entity.getValueCode());
				}
			}
			//test operator 'like' for field 'valueCode'
			{
				Query<Category> q2 = db.query(Category.class);
				q2.like("valueCode", entity.getValueCode() + "%");
				q2.sortASC("valueCode");
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getValueCode(), entity.getValueCode()));
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testProtocol","testUsedMarkerSet"})
	public void testSignificance() throws DatabaseException
	{
		//create entities
		List<Significance> entities = new ArrayList<Significance>();

		//retrieve xref entity candidates
		List<Protocol> protocolUsedXrefs = db.query(Protocol.class).eq("__Type",Protocol.class.getSimpleName()).find();	
		List<UsedMarkerSet> usedmarkersetIDXrefs = db.query(UsedMarkerSet.class).eq("__Type",UsedMarkerSet.class.getSimpleName()).find();	

		for(Integer i = 0; i < total; i++)
		{
			Significance e = new Significance();
			e.setIdentifier(truncate("significance_identifier_"+i, 255));
			e.setName(truncate("significance_name_"+i, 255));
			e.setDescription("significance_description_"+i);
			if(protocolUsedXrefs.size() > 0) e.setProtocolUsed_Id( protocolUsedXrefs.get(i).getId() );
			if(usedmarkersetIDXrefs.size() > 0) e.setUsedmarkersetID_Id( usedmarkersetIDXrefs.get(i).getId() );
			e.setNegLogPValue(i.doubleValue());
			e.setUnadjustedPValue("significance_unadjustedpvalue_"+i);
			e.setAdjustedPValue(i.doubleValue());
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<Significance> q = db.query(Significance.class).eq("__Type",Significance.class.getSimpleName());
		assertEquals(total, q.count());
		List<Significance> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			assertEquals(entities.get(i).getProtocolUsed_Id(), entitiesDb.get(i).getProtocolUsed_Id());
			assertEquals(entities.get(i).getUsedmarkersetID_Id(), entitiesDb.get(i).getUsedmarkersetID_Id());
			assertEquals(entities.get(i).getNegLogPValue(), entitiesDb.get(i).getNegLogPValue());
			assertEquals(entities.get(i).getUnadjustedPValue(), entitiesDb.get(i).getUnadjustedPValue());
			assertEquals(entities.get(i).getAdjustedPValue(), entitiesDb.get(i).getAdjustedPValue());
		}	
		
		//test the query capabilities by finding on all fields
		for(Significance entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<Significance> q2 = db.query(Significance.class);
				q2.equals("id",entity.getId());
				List<Significance> results = q2.find();
				for(Significance r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<Significance> q2 = db.query(Significance.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<Significance> results = q2.find();
				for(Significance r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<Significance> q2 = db.query(Significance.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<Significance> results = q2.find();
				for(Significance r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<Significance> q2 = db.query(Significance.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<Significance> results = q2.find();
				for(Significance r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<Significance> q2 = db.query(Significance.class);
				q2.equals("identifier",entity.getIdentifier());
				List<Significance> results = q2.find();
				for(Significance r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<Significance> q2 = db.query(Significance.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<Significance> results = q2.find();
				for(Significance r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<Significance> q2 = db.query(Significance.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<Significance> results = q2.find();
				for(Significance r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<Significance> q2 = db.query(Significance.class);
				q2.equals("name",entity.getName());
				List<Significance> results = q2.find();
				for(Significance r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<Significance> q2 = db.query(Significance.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<Significance> results = q2.find();
				for(Significance r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<Significance> q2 = db.query(Significance.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<Significance> results = q2.find();
				for(Significance r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'description', type 'text'
			{
				Query<Significance> q2 = db.query(Significance.class);
				q2.equals("description",entity.getDescription());
				List<Significance> results = q2.find();
				for(Significance r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'description'
			{
				Query<Significance> q2 = db.query(Significance.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<Significance> results = q2.find();
				for(Significance r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'description'
			{
				Query<Significance> q2 = db.query(Significance.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<Significance> results = q2.find();
				for(Significance r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

			//test field 'ProtocolUsed', type 'xref'
			{
				Query<Significance> q2 = db.query(Significance.class);
				q2.equals("protocolUsed",entity.getProtocolUsed_Id());
				List<Significance> results = q2.find();
				for(Significance r: results)
				{
					assertEquals(r.getProtocolUsed_Id(), entity.getProtocolUsed_Id());
				}
			}
			//test operator 'in' for field 'ProtocolUsed'
			{
				Query<Significance> q2 = db.query(Significance.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getProtocolUsed_Id());
				q2.in("protocolUsed", inList);
				List<Significance> results = q2.find();
				for(Significance r: results)
				{
					assertEquals(r.getProtocolUsed_Id(), entity.getProtocolUsed_Id());
				}
			}
			//test operator 'equals' for implicit join field 'ProtocolUsed_Identifier'
			{
				Query<Significance> q2 = db.query(Significance.class);
				q2.equals("protocolUsed_Identifier",entity.getProtocolUsed_Identifier());
				List<Significance> results = q2.find();
				for(Significance r: results)
				{
					assertEquals(r.getProtocolUsed_Id(), entity.getProtocolUsed_Id());
				}
			}
			//test operator 'in' for implicit join field 'ProtocolUsed_Identifier'
			{
				Query<Significance> q2 = db.query(Significance.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getProtocolUsed_Identifier());
				q2.in("protocolUsed_Identifier", inList);
				q2.sortDESC("protocolUsed_Identifier");
				List<Significance> results = q2.find();
				for(Significance r: results)
				{
					assertEquals(r.getProtocolUsed_Id(), entity.getProtocolUsed_Id());
				}
			}

			//test field 'UsedmarkersetID', type 'xref'
			{
				Query<Significance> q2 = db.query(Significance.class);
				q2.equals("usedmarkersetID",entity.getUsedmarkersetID_Id());
				List<Significance> results = q2.find();
				for(Significance r: results)
				{
					assertEquals(r.getUsedmarkersetID_Id(), entity.getUsedmarkersetID_Id());
				}
			}
			//test operator 'in' for field 'UsedmarkersetID'
			{
				Query<Significance> q2 = db.query(Significance.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getUsedmarkersetID_Id());
				q2.in("usedmarkersetID", inList);
				List<Significance> results = q2.find();
				for(Significance r: results)
				{
					assertEquals(r.getUsedmarkersetID_Id(), entity.getUsedmarkersetID_Id());
				}
			}
			//test operator 'equals' for implicit join field 'UsedmarkersetID_Identifier'
			{
				Query<Significance> q2 = db.query(Significance.class);
				q2.equals("usedmarkersetID_Identifier",entity.getUsedmarkersetID_Identifier());
				List<Significance> results = q2.find();
				for(Significance r: results)
				{
					assertEquals(r.getUsedmarkersetID_Id(), entity.getUsedmarkersetID_Id());
				}
			}
			//test operator 'in' for implicit join field 'UsedmarkersetID_Identifier'
			{
				Query<Significance> q2 = db.query(Significance.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getUsedmarkersetID_Identifier());
				q2.in("usedmarkersetID_Identifier", inList);
				q2.sortDESC("usedmarkersetID_Identifier");
				List<Significance> results = q2.find();
				for(Significance r: results)
				{
					assertEquals(r.getUsedmarkersetID_Id(), entity.getUsedmarkersetID_Id());
				}
			}

			//test field 'UnadjustedPValue', type 'text'
			{
				Query<Significance> q2 = db.query(Significance.class);
				q2.equals("unadjustedPValue",entity.getUnadjustedPValue());
				List<Significance> results = q2.find();
				for(Significance r: results)
				{
					assertEquals(r.getUnadjustedPValue(),entity.getUnadjustedPValue());
				}
			}
			//test operator 'in' for field 'UnadjustedPValue'
			{
				Query<Significance> q2 = db.query(Significance.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getUnadjustedPValue());
				q2.in("unadjustedPValue", inList);
				List<Significance> results = q2.find();
				for(Significance r: results)
				{
					assertEquals(r.getUnadjustedPValue(),entity.getUnadjustedPValue());
				}
			}
			//test operator 'like' for field 'UnadjustedPValue'
			{
				Query<Significance> q2 = db.query(Significance.class);
				q2.like("unadjustedPValue", entity.getUnadjustedPValue() + "%");
				q2.sortASC("unadjustedPValue");
				List<Significance> results = q2.find();
				for(Significance r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getUnadjustedPValue(), entity.getUnadjustedPValue()));
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testProtocol","testUsedMarkerSet"})
	public void testEffectSize() throws DatabaseException
	{
		//create entities
		List<EffectSize> entities = new ArrayList<EffectSize>();

		//retrieve xref entity candidates
		List<Protocol> protocolUsedXrefs = db.query(Protocol.class).eq("__Type",Protocol.class.getSimpleName()).find();	
		List<UsedMarkerSet> usedMarkerSetIDXrefs = db.query(UsedMarkerSet.class).eq("__Type",UsedMarkerSet.class.getSimpleName()).find();	

		for(Integer i = 0; i < total; i++)
		{
			EffectSize e = new EffectSize();
			e.setIdentifier(truncate("effectsize_identifier_"+i, 255));
			e.setName(truncate("effectsize_name_"+i, 255));
			e.setDescription("effectsize_description_"+i);
			if(protocolUsedXrefs.size() > 0) e.setProtocolUsed_Id( protocolUsedXrefs.get(i).getId() );
			if(usedMarkerSetIDXrefs.size() > 0) e.setUsedMarkerSetID_Id( usedMarkerSetIDXrefs.get(i).getId() );
			e.setLower95Bound(i.doubleValue());
			e.setUpper95Bound(i.doubleValue());
			e.setStdError(i.doubleValue());
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<EffectSize> q = db.query(EffectSize.class).eq("__Type",EffectSize.class.getSimpleName());
		assertEquals(total, q.count());
		List<EffectSize> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			assertEquals(entities.get(i).getProtocolUsed_Id(), entitiesDb.get(i).getProtocolUsed_Id());
			assertEquals(entities.get(i).getUsedMarkerSetID_Id(), entitiesDb.get(i).getUsedMarkerSetID_Id());
			assertEquals(entities.get(i).getLower95Bound(), entitiesDb.get(i).getLower95Bound());
			assertEquals(entities.get(i).getUpper95Bound(), entitiesDb.get(i).getUpper95Bound());
			assertEquals(entities.get(i).getStdError(), entitiesDb.get(i).getStdError());
		}	
		
		//test the query capabilities by finding on all fields
		for(EffectSize entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<EffectSize> q2 = db.query(EffectSize.class);
				q2.equals("id",entity.getId());
				List<EffectSize> results = q2.find();
				for(EffectSize r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<EffectSize> q2 = db.query(EffectSize.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<EffectSize> results = q2.find();
				for(EffectSize r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<EffectSize> q2 = db.query(EffectSize.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<EffectSize> results = q2.find();
				for(EffectSize r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<EffectSize> q2 = db.query(EffectSize.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<EffectSize> results = q2.find();
				for(EffectSize r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<EffectSize> q2 = db.query(EffectSize.class);
				q2.equals("identifier",entity.getIdentifier());
				List<EffectSize> results = q2.find();
				for(EffectSize r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<EffectSize> q2 = db.query(EffectSize.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<EffectSize> results = q2.find();
				for(EffectSize r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<EffectSize> q2 = db.query(EffectSize.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<EffectSize> results = q2.find();
				for(EffectSize r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<EffectSize> q2 = db.query(EffectSize.class);
				q2.equals("name",entity.getName());
				List<EffectSize> results = q2.find();
				for(EffectSize r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<EffectSize> q2 = db.query(EffectSize.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<EffectSize> results = q2.find();
				for(EffectSize r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<EffectSize> q2 = db.query(EffectSize.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<EffectSize> results = q2.find();
				for(EffectSize r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'description', type 'text'
			{
				Query<EffectSize> q2 = db.query(EffectSize.class);
				q2.equals("description",entity.getDescription());
				List<EffectSize> results = q2.find();
				for(EffectSize r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'description'
			{
				Query<EffectSize> q2 = db.query(EffectSize.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<EffectSize> results = q2.find();
				for(EffectSize r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'description'
			{
				Query<EffectSize> q2 = db.query(EffectSize.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<EffectSize> results = q2.find();
				for(EffectSize r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

			//test field 'ProtocolUsed', type 'xref'
			{
				Query<EffectSize> q2 = db.query(EffectSize.class);
				q2.equals("protocolUsed",entity.getProtocolUsed_Id());
				List<EffectSize> results = q2.find();
				for(EffectSize r: results)
				{
					assertEquals(r.getProtocolUsed_Id(), entity.getProtocolUsed_Id());
				}
			}
			//test operator 'in' for field 'ProtocolUsed'
			{
				Query<EffectSize> q2 = db.query(EffectSize.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getProtocolUsed_Id());
				q2.in("protocolUsed", inList);
				List<EffectSize> results = q2.find();
				for(EffectSize r: results)
				{
					assertEquals(r.getProtocolUsed_Id(), entity.getProtocolUsed_Id());
				}
			}
			//test operator 'equals' for implicit join field 'ProtocolUsed_Identifier'
			{
				Query<EffectSize> q2 = db.query(EffectSize.class);
				q2.equals("protocolUsed_Identifier",entity.getProtocolUsed_Identifier());
				List<EffectSize> results = q2.find();
				for(EffectSize r: results)
				{
					assertEquals(r.getProtocolUsed_Id(), entity.getProtocolUsed_Id());
				}
			}
			//test operator 'in' for implicit join field 'ProtocolUsed_Identifier'
			{
				Query<EffectSize> q2 = db.query(EffectSize.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getProtocolUsed_Identifier());
				q2.in("protocolUsed_Identifier", inList);
				q2.sortDESC("protocolUsed_Identifier");
				List<EffectSize> results = q2.find();
				for(EffectSize r: results)
				{
					assertEquals(r.getProtocolUsed_Id(), entity.getProtocolUsed_Id());
				}
			}

			//test field 'UsedMarkerSetID', type 'xref'
			{
				Query<EffectSize> q2 = db.query(EffectSize.class);
				q2.equals("usedMarkerSetID",entity.getUsedMarkerSetID_Id());
				List<EffectSize> results = q2.find();
				for(EffectSize r: results)
				{
					assertEquals(r.getUsedMarkerSetID_Id(), entity.getUsedMarkerSetID_Id());
				}
			}
			//test operator 'in' for field 'UsedMarkerSetID'
			{
				Query<EffectSize> q2 = db.query(EffectSize.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getUsedMarkerSetID_Id());
				q2.in("usedMarkerSetID", inList);
				List<EffectSize> results = q2.find();
				for(EffectSize r: results)
				{
					assertEquals(r.getUsedMarkerSetID_Id(), entity.getUsedMarkerSetID_Id());
				}
			}
			//test operator 'equals' for implicit join field 'UsedMarkerSetID_Identifier'
			{
				Query<EffectSize> q2 = db.query(EffectSize.class);
				q2.equals("usedMarkerSetID_Identifier",entity.getUsedMarkerSetID_Identifier());
				List<EffectSize> results = q2.find();
				for(EffectSize r: results)
				{
					assertEquals(r.getUsedMarkerSetID_Id(), entity.getUsedMarkerSetID_Id());
				}
			}
			//test operator 'in' for implicit join field 'UsedMarkerSetID_Identifier'
			{
				Query<EffectSize> q2 = db.query(EffectSize.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getUsedMarkerSetID_Identifier());
				q2.in("usedMarkerSetID_Identifier", inList);
				q2.sortDESC("usedMarkerSetID_Identifier");
				List<EffectSize> results = q2.find();
				for(EffectSize r: results)
				{
					assertEquals(r.getUsedMarkerSetID_Id(), entity.getUsedMarkerSetID_Id());
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testPanel","testPanel"})
	public void testSelectionCriteria() throws DatabaseException
	{
		//create entities
		List<SelectionCriteria> entities = new ArrayList<SelectionCriteria>();

		//retrieve xref entity candidates
		List<Panel> sourcePanelXrefs = db.query(Panel.class).eq("__Type",Panel.class.getSimpleName()).find();	
		List<Panel> targetPanelXrefs = db.query(Panel.class).eq("__Type",Panel.class.getSimpleName()).find();	

		for(Integer i = 0; i < total; i++)
		{
			SelectionCriteria e = new SelectionCriteria();
			if(sourcePanelXrefs.size() > 0) e.setSourcePanel_Id( sourcePanelXrefs.get(i).getId() );
			if(targetPanelXrefs.size() > 0) e.setTargetPanel_Id( targetPanelXrefs.get(i).getId() );
			e.setNumberOfIndividuals(i);
			e.setDetails("selectioncriteria_details_"+i);
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<SelectionCriteria> q = db.query(SelectionCriteria.class);
		assertEquals(total, q.count());
		List<SelectionCriteria> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getSourcePanel_Id(), entitiesDb.get(i).getSourcePanel_Id());
			assertEquals(entities.get(i).getTargetPanel_Id(), entitiesDb.get(i).getTargetPanel_Id());
			assertEquals(entities.get(i).getNumberOfIndividuals(), entitiesDb.get(i).getNumberOfIndividuals());
			assertEquals(entities.get(i).getDetails(), entitiesDb.get(i).getDetails());
		}	
		
		//test the query capabilities by finding on all fields
		for(SelectionCriteria entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<SelectionCriteria> q2 = db.query(SelectionCriteria.class);
				q2.equals("id",entity.getId());
				List<SelectionCriteria> results = q2.find();
				assertEquals(results.size(),1);
				for(SelectionCriteria r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<SelectionCriteria> q2 = db.query(SelectionCriteria.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<SelectionCriteria> results = q2.find();
				assertEquals(results.size(),1);
				for(SelectionCriteria r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<SelectionCriteria> q2 = db.query(SelectionCriteria.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<SelectionCriteria> results = q2.find();
				for(SelectionCriteria r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<SelectionCriteria> q2 = db.query(SelectionCriteria.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<SelectionCriteria> results = q2.find();
				for(SelectionCriteria r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'SourcePanel', type 'xref'
			{
				Query<SelectionCriteria> q2 = db.query(SelectionCriteria.class);
				q2.equals("sourcePanel",entity.getSourcePanel_Id());
				List<SelectionCriteria> results = q2.find();
				for(SelectionCriteria r: results)
				{
					assertEquals(r.getSourcePanel_Id(), entity.getSourcePanel_Id());
				}
			}
			//test operator 'in' for field 'SourcePanel'
			{
				Query<SelectionCriteria> q2 = db.query(SelectionCriteria.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getSourcePanel_Id());
				q2.in("sourcePanel", inList);
				List<SelectionCriteria> results = q2.find();
				for(SelectionCriteria r: results)
				{
					assertEquals(r.getSourcePanel_Id(), entity.getSourcePanel_Id());
				}
			}
			//test operator 'equals' for implicit join field 'SourcePanel_Identifier'
			{
				Query<SelectionCriteria> q2 = db.query(SelectionCriteria.class);
				q2.equals("sourcePanel_Identifier",entity.getSourcePanel_Identifier());
				List<SelectionCriteria> results = q2.find();
				for(SelectionCriteria r: results)
				{
					assertEquals(r.getSourcePanel_Id(), entity.getSourcePanel_Id());
				}
			}
			//test operator 'in' for implicit join field 'SourcePanel_Identifier'
			{
				Query<SelectionCriteria> q2 = db.query(SelectionCriteria.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getSourcePanel_Identifier());
				q2.in("sourcePanel_Identifier", inList);
				q2.sortDESC("sourcePanel_Identifier");
				List<SelectionCriteria> results = q2.find();
				for(SelectionCriteria r: results)
				{
					assertEquals(r.getSourcePanel_Id(), entity.getSourcePanel_Id());
				}
			}

			//test field 'TargetPanel', type 'xref'
			{
				Query<SelectionCriteria> q2 = db.query(SelectionCriteria.class);
				q2.equals("targetPanel",entity.getTargetPanel_Id());
				List<SelectionCriteria> results = q2.find();
				for(SelectionCriteria r: results)
				{
					assertEquals(r.getTargetPanel_Id(), entity.getTargetPanel_Id());
				}
			}
			//test operator 'in' for field 'TargetPanel'
			{
				Query<SelectionCriteria> q2 = db.query(SelectionCriteria.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getTargetPanel_Id());
				q2.in("targetPanel", inList);
				List<SelectionCriteria> results = q2.find();
				for(SelectionCriteria r: results)
				{
					assertEquals(r.getTargetPanel_Id(), entity.getTargetPanel_Id());
				}
			}
			//test operator 'equals' for implicit join field 'TargetPanel_Identifier'
			{
				Query<SelectionCriteria> q2 = db.query(SelectionCriteria.class);
				q2.equals("targetPanel_Identifier",entity.getTargetPanel_Identifier());
				List<SelectionCriteria> results = q2.find();
				for(SelectionCriteria r: results)
				{
					assertEquals(r.getTargetPanel_Id(), entity.getTargetPanel_Id());
				}
			}
			//test operator 'in' for implicit join field 'TargetPanel_Identifier'
			{
				Query<SelectionCriteria> q2 = db.query(SelectionCriteria.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getTargetPanel_Identifier());
				q2.in("targetPanel_Identifier", inList);
				q2.sortDESC("targetPanel_Identifier");
				List<SelectionCriteria> results = q2.find();
				for(SelectionCriteria r: results)
				{
					assertEquals(r.getTargetPanel_Id(), entity.getTargetPanel_Id());
				}
			}

			//test field 'NumberOfIndividuals', type 'int'
			{
				Query<SelectionCriteria> q2 = db.query(SelectionCriteria.class);
				q2.equals("numberOfIndividuals",entity.getNumberOfIndividuals());
				List<SelectionCriteria> results = q2.find();
				for(SelectionCriteria r: results)
				{
					assertEquals(r.getNumberOfIndividuals(),entity.getNumberOfIndividuals());
				}
			}
			//test operator 'in' for field 'NumberOfIndividuals'
			{
				Query<SelectionCriteria> q2 = db.query(SelectionCriteria.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getNumberOfIndividuals());
				q2.in("numberOfIndividuals", inList);
				List<SelectionCriteria> results = q2.find();
				for(SelectionCriteria r: results)
				{
					assertEquals(r.getNumberOfIndividuals(),entity.getNumberOfIndividuals());
				}
			}
			//test operator 'lessOrEqual' for field 'NumberOfIndividuals'
			{
				Query<SelectionCriteria> q2 = db.query(SelectionCriteria.class);
				q2.lessOrEqual("numberOfIndividuals", entity.getNumberOfIndividuals());
				q2.sortASC("numberOfIndividuals");
				List<SelectionCriteria> results = q2.find();
				for(SelectionCriteria r: results)
				{
					assertTrue(r.getNumberOfIndividuals().compareTo(entity.getNumberOfIndividuals()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'NumberOfIndividuals'
			{
				Query<SelectionCriteria> q2 = db.query(SelectionCriteria.class);
				q2.greaterOrEqual("numberOfIndividuals", entity.getNumberOfIndividuals());
				q2.sortDESC("numberOfIndividuals");
				List<SelectionCriteria> results = q2.find();
				for(SelectionCriteria r: results)
				{
					assertTrue(r.getNumberOfIndividuals().compareTo(entity.getNumberOfIndividuals()) > -1);
				}
			}

			//test field 'Details', type 'text'
			{
				Query<SelectionCriteria> q2 = db.query(SelectionCriteria.class);
				q2.equals("details",entity.getDetails());
				List<SelectionCriteria> results = q2.find();
				for(SelectionCriteria r: results)
				{
					assertEquals(r.getDetails(),entity.getDetails());
				}
			}
			//test operator 'in' for field 'Details'
			{
				Query<SelectionCriteria> q2 = db.query(SelectionCriteria.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDetails());
				q2.in("details", inList);
				List<SelectionCriteria> results = q2.find();
				for(SelectionCriteria r: results)
				{
					assertEquals(r.getDetails(),entity.getDetails());
				}
			}
			//test operator 'like' for field 'Details'
			{
				Query<SelectionCriteria> q2 = db.query(SelectionCriteria.class);
				q2.like("details", entity.getDetails() + "%");
				q2.sortASC("details");
				List<SelectionCriteria> results = q2.find();
				for(SelectionCriteria r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDetails(), entity.getDetails()));
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testDataSet","testCharacteristic"})
	public void testObservationSet() throws DatabaseException
	{
		//create entities
		List<ObservationSet> entities = new ArrayList<ObservationSet>();

		//retrieve xref entity candidates
		List<DataSet> partOfDataSetXrefs = db.query(DataSet.class).eq("__Type",DataSet.class.getSimpleName()).find();	
		List<Characteristic> targetXrefs = db.query(Characteristic.class).find();	

		for(Integer i = 0; i < total; i++)
		{
			ObservationSet e = new ObservationSet();
			if(partOfDataSetXrefs.size() > 0) e.setPartOfDataSet_Id( partOfDataSetXrefs.get(i).getId() );
			if(targetXrefs.size() > 0) e.setTarget_Id( targetXrefs.get(i).getId() );
			e.setTime(new java.sql.Timestamp(new java.util.Date().getTime()));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<ObservationSet> q = db.query(ObservationSet.class);
		assertEquals(total, q.count());
		List<ObservationSet> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getPartOfDataSet_Id(), entitiesDb.get(i).getPartOfDataSet_Id());
			assertEquals(entities.get(i).getTarget_Id(), entitiesDb.get(i).getTarget_Id());
			//check formatted because of milliseconds rounding
			assertEquals(dateTimeFormat.format(entities.get(i).getTime()),dateTimeFormat.format(entitiesDb.get(i).getTime()));
		}	
		
		//test the query capabilities by finding on all fields
		for(ObservationSet entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<ObservationSet> q2 = db.query(ObservationSet.class);
				q2.equals("id",entity.getId());
				List<ObservationSet> results = q2.find();
				assertEquals(results.size(),1);
				for(ObservationSet r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<ObservationSet> q2 = db.query(ObservationSet.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<ObservationSet> results = q2.find();
				assertEquals(results.size(),1);
				for(ObservationSet r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<ObservationSet> q2 = db.query(ObservationSet.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<ObservationSet> results = q2.find();
				for(ObservationSet r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<ObservationSet> q2 = db.query(ObservationSet.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<ObservationSet> results = q2.find();
				for(ObservationSet r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'partOfDataSet', type 'xref'
			{
				Query<ObservationSet> q2 = db.query(ObservationSet.class);
				q2.equals("partOfDataSet",entity.getPartOfDataSet_Id());
				List<ObservationSet> results = q2.find();
				for(ObservationSet r: results)
				{
					assertEquals(r.getPartOfDataSet_Id(), entity.getPartOfDataSet_Id());
				}
			}
			//test operator 'in' for field 'partOfDataSet'
			{
				Query<ObservationSet> q2 = db.query(ObservationSet.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getPartOfDataSet_Id());
				q2.in("partOfDataSet", inList);
				List<ObservationSet> results = q2.find();
				for(ObservationSet r: results)
				{
					assertEquals(r.getPartOfDataSet_Id(), entity.getPartOfDataSet_Id());
				}
			}
			//test operator 'equals' for implicit join field 'partOfDataSet_Identifier'
			{
				Query<ObservationSet> q2 = db.query(ObservationSet.class);
				q2.equals("partOfDataSet_Identifier",entity.getPartOfDataSet_Identifier());
				List<ObservationSet> results = q2.find();
				for(ObservationSet r: results)
				{
					assertEquals(r.getPartOfDataSet_Id(), entity.getPartOfDataSet_Id());
				}
			}
			//test operator 'in' for implicit join field 'partOfDataSet_Identifier'
			{
				Query<ObservationSet> q2 = db.query(ObservationSet.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getPartOfDataSet_Identifier());
				q2.in("partOfDataSet_Identifier", inList);
				q2.sortDESC("partOfDataSet_Identifier");
				List<ObservationSet> results = q2.find();
				for(ObservationSet r: results)
				{
					assertEquals(r.getPartOfDataSet_Id(), entity.getPartOfDataSet_Id());
				}
			}

			//test field 'Target', type 'xref'
			{
				Query<ObservationSet> q2 = db.query(ObservationSet.class);
				q2.equals("target",entity.getTarget_Id());
				List<ObservationSet> results = q2.find();
				for(ObservationSet r: results)
				{
					assertEquals(r.getTarget_Id(), entity.getTarget_Id());
				}
			}
			//test operator 'in' for field 'Target'
			{
				Query<ObservationSet> q2 = db.query(ObservationSet.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getTarget_Id());
				q2.in("target", inList);
				List<ObservationSet> results = q2.find();
				for(ObservationSet r: results)
				{
					assertEquals(r.getTarget_Id(), entity.getTarget_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Target_Identifier'
			{
				Query<ObservationSet> q2 = db.query(ObservationSet.class);
				q2.equals("target_Identifier",entity.getTarget_Identifier());
				List<ObservationSet> results = q2.find();
				for(ObservationSet r: results)
				{
					assertEquals(r.getTarget_Id(), entity.getTarget_Id());
				}
			}
			//test operator 'in' for implicit join field 'Target_Identifier'
			{
				Query<ObservationSet> q2 = db.query(ObservationSet.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getTarget_Identifier());
				q2.in("target_Identifier", inList);
				q2.sortDESC("target_Identifier");
				List<ObservationSet> results = q2.find();
				for(ObservationSet r: results)
				{
					assertEquals(r.getTarget_Id(), entity.getTarget_Id());
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testObservationSet","testObservableFeature","testCharacteristic"})
	public void testObservedValue() throws DatabaseException
	{
		//create entities
		List<ObservedValue> entities = new ArrayList<ObservedValue>();

		//retrieve xref entity candidates
		List<ObservationSet> observationSetXrefs = db.query(ObservationSet.class).find();	
		List<ObservableFeature> featureXrefs = db.query(ObservableFeature.class).eq("__Type",ObservableFeature.class.getSimpleName()).find();	
		List<Characteristic> characteristicXrefs = db.query(Characteristic.class).find();	

		for(Integer i = 0; i < total; i++)
		{
			ObservedValue e = new ObservedValue();
			if(observationSetXrefs.size() > 0) e.setObservationSet_Id( observationSetXrefs.get(i).getId() );
			if(featureXrefs.size() > 0) e.setFeature_Id( featureXrefs.get(i).getId() );
			if(characteristicXrefs.size() > 0) e.setCharacteristic_Id( characteristicXrefs.get(i).getId() );
			e.setValue(truncate("observedvalue_value_"+i, 255));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<ObservedValue> q = db.query(ObservedValue.class).eq("__Type",ObservedValue.class.getSimpleName());
		assertEquals(total, q.count());
		List<ObservedValue> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getObservationSet_Id(), entitiesDb.get(i).getObservationSet_Id());
			assertEquals(entities.get(i).getFeature_Id(), entitiesDb.get(i).getFeature_Id());
			assertEquals(entities.get(i).getCharacteristic_Id(), entitiesDb.get(i).getCharacteristic_Id());
			assertEquals(entities.get(i).getValue(), entitiesDb.get(i).getValue());
		}	
		
		//test the query capabilities by finding on all fields
		for(ObservedValue entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				q2.equals("id",entity.getId());
				List<ObservedValue> results = q2.find();
				assertEquals(results.size(),1);
				for(ObservedValue r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<ObservedValue> results = q2.find();
				assertEquals(results.size(),1);
				for(ObservedValue r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'ObservationSet', type 'xref'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				q2.equals("observationSet",entity.getObservationSet_Id());
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getObservationSet_Id(), entity.getObservationSet_Id());
				}
			}
			//test operator 'in' for field 'ObservationSet'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getObservationSet_Id());
				q2.in("observationSet", inList);
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getObservationSet_Id(), entity.getObservationSet_Id());
				}
			}
			//test operator 'equals' for implicit join field 'ObservationSet_id'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				q2.equals("observationSet_id",entity.getObservationSet_Id());
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getObservationSet_Id(), entity.getObservationSet_Id());
				}
			}
			//test operator 'in' for implicit join field 'ObservationSet_id'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getObservationSet_Id());
				q2.in("observationSet_id", inList);
				q2.sortDESC("observationSet_id");
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getObservationSet_Id(), entity.getObservationSet_Id());
				}
			}

			//test field 'Feature', type 'xref'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				q2.equals("feature",entity.getFeature_Id());
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getFeature_Id(), entity.getFeature_Id());
				}
			}
			//test operator 'in' for field 'Feature'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getFeature_Id());
				q2.in("feature", inList);
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getFeature_Id(), entity.getFeature_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Feature_Identifier'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				q2.equals("feature_Identifier",entity.getFeature_Identifier());
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getFeature_Id(), entity.getFeature_Id());
				}
			}
			//test operator 'in' for implicit join field 'Feature_Identifier'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getFeature_Identifier());
				q2.in("feature_Identifier", inList);
				q2.sortDESC("feature_Identifier");
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getFeature_Id(), entity.getFeature_Id());
				}
			}

			//test field 'Characteristic', type 'xref'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				q2.equals("characteristic",entity.getCharacteristic_Id());
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getCharacteristic_Id(), entity.getCharacteristic_Id());
				}
			}
			//test operator 'in' for field 'Characteristic'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getCharacteristic_Id());
				q2.in("characteristic", inList);
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getCharacteristic_Id(), entity.getCharacteristic_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Characteristic_Identifier'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				q2.equals("characteristic_Identifier",entity.getCharacteristic_Identifier());
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getCharacteristic_Id(), entity.getCharacteristic_Id());
				}
			}
			//test operator 'in' for implicit join field 'Characteristic_Identifier'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getCharacteristic_Identifier());
				q2.in("characteristic_Identifier", inList);
				q2.sortDESC("characteristic_Identifier");
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getCharacteristic_Id(), entity.getCharacteristic_Id());
				}
			}

			//test field 'Value', type 'string'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				q2.equals("value",entity.getValue());
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getValue(),entity.getValue());
				}
			}
			//test operator 'in' for field 'Value'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getValue());
				q2.in("value", inList);
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getValue(),entity.getValue());
				}
			}
			//test operator 'like' for field 'Value'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				q2.like("value", entity.getValue() + "%");
				q2.sortASC("value");
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getValue(), entity.getValue()));
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testProtocol","testDataSet","testUsedMarkerSet"})
	public void testFrequencyCluster() throws DatabaseException
	{
		//create entities
		List<FrequencyCluster> entities = new ArrayList<FrequencyCluster>();

		//retrieve xref entity candidates
		List<Protocol> protocolUsedXrefs = db.query(Protocol.class).eq("__Type",Protocol.class.getSimpleName()).find();	
		List<DataSet> dataSetXrefs = db.query(DataSet.class).eq("__Type",DataSet.class.getSimpleName()).find();	
		List<UsedMarkerSet> usedMarkerSetXrefs = db.query(UsedMarkerSet.class).eq("__Type",UsedMarkerSet.class.getSimpleName()).find();	

		for(Integer i = 0; i < total; i++)
		{
			FrequencyCluster e = new FrequencyCluster();
			e.setIdentifier(truncate("frequencycluster_identifier_"+i, 255));
			e.setName(truncate("frequencycluster_name_"+i, 255));
			e.setDescription("frequencycluster_description_"+i);
			if(protocolUsedXrefs.size() > 0) e.setProtocolUsed_Id( protocolUsedXrefs.get(i).getId() );
			if(dataSetXrefs.size() > 0) e.setDataSet_Id( dataSetXrefs.get(i).getId() );
			if(usedMarkerSetXrefs.size() > 0) e.setUsedMarkerSet_Id( usedMarkerSetXrefs.get(i).getId() );
			e.setMarkerID(i);
			e.setNumberOfGenotypedSamples(i);
			e.setPValueHWE(i.doubleValue());
			e.setUnadjustedPValue(i.doubleValue());
			e.setOddsRatioStatement(truncate("frequencycluster_oddsratiostatement_"+i, 255));
			e.setAttributableRiskStatement(truncate("frequencycluster_attributableriskstatement_"+i, 255));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<FrequencyCluster> q = db.query(FrequencyCluster.class).eq("__Type",FrequencyCluster.class.getSimpleName());
		assertEquals(total, q.count());
		List<FrequencyCluster> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			assertEquals(entities.get(i).getProtocolUsed_Id(), entitiesDb.get(i).getProtocolUsed_Id());
			assertEquals(entities.get(i).getDataSet_Id(), entitiesDb.get(i).getDataSet_Id());
			assertEquals(entities.get(i).getUsedMarkerSet_Id(), entitiesDb.get(i).getUsedMarkerSet_Id());
			assertEquals(entities.get(i).getMarkerID(), entitiesDb.get(i).getMarkerID());
			assertEquals(entities.get(i).getNumberOfGenotypedSamples(), entitiesDb.get(i).getNumberOfGenotypedSamples());
			assertEquals(entities.get(i).getPValueHWE(), entitiesDb.get(i).getPValueHWE());
			assertEquals(entities.get(i).getUnadjustedPValue(), entitiesDb.get(i).getUnadjustedPValue());
			assertEquals(entities.get(i).getOddsRatioStatement(), entitiesDb.get(i).getOddsRatioStatement());
			assertEquals(entities.get(i).getAttributableRiskStatement(), entitiesDb.get(i).getAttributableRiskStatement());
		}	
		
		//test the query capabilities by finding on all fields
		for(FrequencyCluster entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				q2.equals("id",entity.getId());
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				q2.equals("identifier",entity.getIdentifier());
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				q2.equals("name",entity.getName());
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'description', type 'text'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				q2.equals("description",entity.getDescription());
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'description'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'description'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

			//test field 'ProtocolUsed', type 'xref'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				q2.equals("protocolUsed",entity.getProtocolUsed_Id());
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertEquals(r.getProtocolUsed_Id(), entity.getProtocolUsed_Id());
				}
			}
			//test operator 'in' for field 'ProtocolUsed'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getProtocolUsed_Id());
				q2.in("protocolUsed", inList);
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertEquals(r.getProtocolUsed_Id(), entity.getProtocolUsed_Id());
				}
			}
			//test operator 'equals' for implicit join field 'ProtocolUsed_Identifier'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				q2.equals("protocolUsed_Identifier",entity.getProtocolUsed_Identifier());
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertEquals(r.getProtocolUsed_Id(), entity.getProtocolUsed_Id());
				}
			}
			//test operator 'in' for implicit join field 'ProtocolUsed_Identifier'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getProtocolUsed_Identifier());
				q2.in("protocolUsed_Identifier", inList);
				q2.sortDESC("protocolUsed_Identifier");
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertEquals(r.getProtocolUsed_Id(), entity.getProtocolUsed_Id());
				}
			}

			//test field 'DataSet', type 'xref'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				q2.equals("dataSet",entity.getDataSet_Id());
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertEquals(r.getDataSet_Id(), entity.getDataSet_Id());
				}
			}
			//test operator 'in' for field 'DataSet'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDataSet_Id());
				q2.in("dataSet", inList);
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertEquals(r.getDataSet_Id(), entity.getDataSet_Id());
				}
			}
			//test operator 'equals' for implicit join field 'DataSet_Identifier'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				q2.equals("dataSet_Identifier",entity.getDataSet_Identifier());
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertEquals(r.getDataSet_Id(), entity.getDataSet_Id());
				}
			}
			//test operator 'in' for implicit join field 'DataSet_Identifier'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDataSet_Identifier());
				q2.in("dataSet_Identifier", inList);
				q2.sortDESC("dataSet_Identifier");
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertEquals(r.getDataSet_Id(), entity.getDataSet_Id());
				}
			}

			//test field 'UsedMarkerSet', type 'xref'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				q2.equals("usedMarkerSet",entity.getUsedMarkerSet_Id());
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertEquals(r.getUsedMarkerSet_Id(), entity.getUsedMarkerSet_Id());
				}
			}
			//test operator 'in' for field 'UsedMarkerSet'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getUsedMarkerSet_Id());
				q2.in("usedMarkerSet", inList);
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertEquals(r.getUsedMarkerSet_Id(), entity.getUsedMarkerSet_Id());
				}
			}
			//test operator 'equals' for implicit join field 'UsedMarkerSet_Identifier'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				q2.equals("usedMarkerSet_Identifier",entity.getUsedMarkerSet_Identifier());
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertEquals(r.getUsedMarkerSet_Id(), entity.getUsedMarkerSet_Id());
				}
			}
			//test operator 'in' for implicit join field 'UsedMarkerSet_Identifier'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getUsedMarkerSet_Identifier());
				q2.in("usedMarkerSet_Identifier", inList);
				q2.sortDESC("usedMarkerSet_Identifier");
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertEquals(r.getUsedMarkerSet_Id(), entity.getUsedMarkerSet_Id());
				}
			}

			//test field 'MarkerID', type 'int'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				q2.equals("markerID",entity.getMarkerID());
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertEquals(r.getMarkerID(),entity.getMarkerID());
				}
			}
			//test operator 'in' for field 'MarkerID'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getMarkerID());
				q2.in("markerID", inList);
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertEquals(r.getMarkerID(),entity.getMarkerID());
				}
			}
			//test operator 'lessOrEqual' for field 'MarkerID'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				q2.lessOrEqual("markerID", entity.getMarkerID());
				q2.sortASC("markerID");
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertTrue(r.getMarkerID().compareTo(entity.getMarkerID()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'MarkerID'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				q2.greaterOrEqual("markerID", entity.getMarkerID());
				q2.sortDESC("markerID");
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertTrue(r.getMarkerID().compareTo(entity.getMarkerID()) > -1);
				}
			}

			//test field 'NumberOfGenotypedSamples', type 'int'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				q2.equals("numberOfGenotypedSamples",entity.getNumberOfGenotypedSamples());
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertEquals(r.getNumberOfGenotypedSamples(),entity.getNumberOfGenotypedSamples());
				}
			}
			//test operator 'in' for field 'NumberOfGenotypedSamples'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getNumberOfGenotypedSamples());
				q2.in("numberOfGenotypedSamples", inList);
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertEquals(r.getNumberOfGenotypedSamples(),entity.getNumberOfGenotypedSamples());
				}
			}
			//test operator 'lessOrEqual' for field 'NumberOfGenotypedSamples'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				q2.lessOrEqual("numberOfGenotypedSamples", entity.getNumberOfGenotypedSamples());
				q2.sortASC("numberOfGenotypedSamples");
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertTrue(r.getNumberOfGenotypedSamples().compareTo(entity.getNumberOfGenotypedSamples()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'NumberOfGenotypedSamples'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				q2.greaterOrEqual("numberOfGenotypedSamples", entity.getNumberOfGenotypedSamples());
				q2.sortDESC("numberOfGenotypedSamples");
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertTrue(r.getNumberOfGenotypedSamples().compareTo(entity.getNumberOfGenotypedSamples()) > -1);
				}
			}

			//test field 'OddsRatioStatement', type 'string'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				q2.equals("oddsRatioStatement",entity.getOddsRatioStatement());
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertEquals(r.getOddsRatioStatement(),entity.getOddsRatioStatement());
				}
			}
			//test operator 'in' for field 'OddsRatioStatement'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getOddsRatioStatement());
				q2.in("oddsRatioStatement", inList);
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertEquals(r.getOddsRatioStatement(),entity.getOddsRatioStatement());
				}
			}
			//test operator 'like' for field 'OddsRatioStatement'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				q2.like("oddsRatioStatement", entity.getOddsRatioStatement() + "%");
				q2.sortASC("oddsRatioStatement");
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getOddsRatioStatement(), entity.getOddsRatioStatement()));
				}
			}

			//test field 'AttributableRiskStatement', type 'string'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				q2.equals("attributableRiskStatement",entity.getAttributableRiskStatement());
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertEquals(r.getAttributableRiskStatement(),entity.getAttributableRiskStatement());
				}
			}
			//test operator 'in' for field 'AttributableRiskStatement'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getAttributableRiskStatement());
				q2.in("attributableRiskStatement", inList);
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertEquals(r.getAttributableRiskStatement(),entity.getAttributableRiskStatement());
				}
			}
			//test operator 'like' for field 'AttributableRiskStatement'
			{
				Query<FrequencyCluster> q2 = db.query(FrequencyCluster.class);
				q2.like("attributableRiskStatement", entity.getAttributableRiskStatement() + "%");
				q2.sortASC("attributableRiskStatement");
				List<FrequencyCluster> results = q2.find();
				for(FrequencyCluster r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getAttributableRiskStatement(), entity.getAttributableRiskStatement()));
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testProtocol","testFrequencyCluster"})
	public void testGenotypeFrequency() throws DatabaseException
	{
		//create entities
		List<GenotypeFrequency> entities = new ArrayList<GenotypeFrequency>();

		//retrieve xref entity candidates
		List<Protocol> protocolUsedXrefs = db.query(Protocol.class).eq("__Type",Protocol.class.getSimpleName()).find();	
		List<FrequencyCluster> frequencyClusterXrefs = db.query(FrequencyCluster.class).eq("__Type",FrequencyCluster.class.getSimpleName()).find();	

		for(Integer i = 0; i < total; i++)
		{
			GenotypeFrequency e = new GenotypeFrequency();
			e.setIdentifier(truncate("genotypefrequency_identifier_"+i, 255));
			e.setName(truncate("genotypefrequency_name_"+i, 255));
			e.setDescription("genotypefrequency_description_"+i);
			if(protocolUsedXrefs.size() > 0) e.setProtocolUsed_Id( protocolUsedXrefs.get(i).getId() );
			if(frequencyClusterXrefs.size() > 0) e.setFrequencyCluster_Id( frequencyClusterXrefs.get(i).getId() );
			e.setGenotypeCombo("genotypefrequency_genotypecombo_"+i);
			e.setFrequencyAsProportion(i.doubleValue());
			e.setNumberSamplesWithGenotype(i);
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<GenotypeFrequency> q = db.query(GenotypeFrequency.class).eq("__Type",GenotypeFrequency.class.getSimpleName());
		assertEquals(total, q.count());
		List<GenotypeFrequency> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			assertEquals(entities.get(i).getProtocolUsed_Id(), entitiesDb.get(i).getProtocolUsed_Id());
			assertEquals(entities.get(i).getFrequencyCluster_Id(), entitiesDb.get(i).getFrequencyCluster_Id());
			assertEquals(entities.get(i).getGenotypeCombo(), entitiesDb.get(i).getGenotypeCombo());
			assertEquals(entities.get(i).getFrequencyAsProportion(), entitiesDb.get(i).getFrequencyAsProportion());
			assertEquals(entities.get(i).getNumberSamplesWithGenotype(), entitiesDb.get(i).getNumberSamplesWithGenotype());
		}	
		
		//test the query capabilities by finding on all fields
		for(GenotypeFrequency entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<GenotypeFrequency> q2 = db.query(GenotypeFrequency.class);
				q2.equals("id",entity.getId());
				List<GenotypeFrequency> results = q2.find();
				for(GenotypeFrequency r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<GenotypeFrequency> q2 = db.query(GenotypeFrequency.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<GenotypeFrequency> results = q2.find();
				for(GenotypeFrequency r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<GenotypeFrequency> q2 = db.query(GenotypeFrequency.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<GenotypeFrequency> results = q2.find();
				for(GenotypeFrequency r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<GenotypeFrequency> q2 = db.query(GenotypeFrequency.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<GenotypeFrequency> results = q2.find();
				for(GenotypeFrequency r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<GenotypeFrequency> q2 = db.query(GenotypeFrequency.class);
				q2.equals("identifier",entity.getIdentifier());
				List<GenotypeFrequency> results = q2.find();
				for(GenotypeFrequency r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<GenotypeFrequency> q2 = db.query(GenotypeFrequency.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<GenotypeFrequency> results = q2.find();
				for(GenotypeFrequency r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<GenotypeFrequency> q2 = db.query(GenotypeFrequency.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<GenotypeFrequency> results = q2.find();
				for(GenotypeFrequency r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<GenotypeFrequency> q2 = db.query(GenotypeFrequency.class);
				q2.equals("name",entity.getName());
				List<GenotypeFrequency> results = q2.find();
				for(GenotypeFrequency r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<GenotypeFrequency> q2 = db.query(GenotypeFrequency.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<GenotypeFrequency> results = q2.find();
				for(GenotypeFrequency r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<GenotypeFrequency> q2 = db.query(GenotypeFrequency.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<GenotypeFrequency> results = q2.find();
				for(GenotypeFrequency r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'description', type 'text'
			{
				Query<GenotypeFrequency> q2 = db.query(GenotypeFrequency.class);
				q2.equals("description",entity.getDescription());
				List<GenotypeFrequency> results = q2.find();
				for(GenotypeFrequency r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'description'
			{
				Query<GenotypeFrequency> q2 = db.query(GenotypeFrequency.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<GenotypeFrequency> results = q2.find();
				for(GenotypeFrequency r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'description'
			{
				Query<GenotypeFrequency> q2 = db.query(GenotypeFrequency.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<GenotypeFrequency> results = q2.find();
				for(GenotypeFrequency r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

			//test field 'ProtocolUsed', type 'xref'
			{
				Query<GenotypeFrequency> q2 = db.query(GenotypeFrequency.class);
				q2.equals("protocolUsed",entity.getProtocolUsed_Id());
				List<GenotypeFrequency> results = q2.find();
				for(GenotypeFrequency r: results)
				{
					assertEquals(r.getProtocolUsed_Id(), entity.getProtocolUsed_Id());
				}
			}
			//test operator 'in' for field 'ProtocolUsed'
			{
				Query<GenotypeFrequency> q2 = db.query(GenotypeFrequency.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getProtocolUsed_Id());
				q2.in("protocolUsed", inList);
				List<GenotypeFrequency> results = q2.find();
				for(GenotypeFrequency r: results)
				{
					assertEquals(r.getProtocolUsed_Id(), entity.getProtocolUsed_Id());
				}
			}
			//test operator 'equals' for implicit join field 'ProtocolUsed_Identifier'
			{
				Query<GenotypeFrequency> q2 = db.query(GenotypeFrequency.class);
				q2.equals("protocolUsed_Identifier",entity.getProtocolUsed_Identifier());
				List<GenotypeFrequency> results = q2.find();
				for(GenotypeFrequency r: results)
				{
					assertEquals(r.getProtocolUsed_Id(), entity.getProtocolUsed_Id());
				}
			}
			//test operator 'in' for implicit join field 'ProtocolUsed_Identifier'
			{
				Query<GenotypeFrequency> q2 = db.query(GenotypeFrequency.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getProtocolUsed_Identifier());
				q2.in("protocolUsed_Identifier", inList);
				q2.sortDESC("protocolUsed_Identifier");
				List<GenotypeFrequency> results = q2.find();
				for(GenotypeFrequency r: results)
				{
					assertEquals(r.getProtocolUsed_Id(), entity.getProtocolUsed_Id());
				}
			}

			//test field 'FrequencyCluster', type 'xref'
			{
				Query<GenotypeFrequency> q2 = db.query(GenotypeFrequency.class);
				q2.equals("frequencyCluster",entity.getFrequencyCluster_Id());
				List<GenotypeFrequency> results = q2.find();
				for(GenotypeFrequency r: results)
				{
					assertEquals(r.getFrequencyCluster_Id(), entity.getFrequencyCluster_Id());
				}
			}
			//test operator 'in' for field 'FrequencyCluster'
			{
				Query<GenotypeFrequency> q2 = db.query(GenotypeFrequency.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getFrequencyCluster_Id());
				q2.in("frequencyCluster", inList);
				List<GenotypeFrequency> results = q2.find();
				for(GenotypeFrequency r: results)
				{
					assertEquals(r.getFrequencyCluster_Id(), entity.getFrequencyCluster_Id());
				}
			}
			//test operator 'equals' for implicit join field 'FrequencyCluster_Identifier'
			{
				Query<GenotypeFrequency> q2 = db.query(GenotypeFrequency.class);
				q2.equals("frequencyCluster_Identifier",entity.getFrequencyCluster_Identifier());
				List<GenotypeFrequency> results = q2.find();
				for(GenotypeFrequency r: results)
				{
					assertEquals(r.getFrequencyCluster_Id(), entity.getFrequencyCluster_Id());
				}
			}
			//test operator 'in' for implicit join field 'FrequencyCluster_Identifier'
			{
				Query<GenotypeFrequency> q2 = db.query(GenotypeFrequency.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getFrequencyCluster_Identifier());
				q2.in("frequencyCluster_Identifier", inList);
				q2.sortDESC("frequencyCluster_Identifier");
				List<GenotypeFrequency> results = q2.find();
				for(GenotypeFrequency r: results)
				{
					assertEquals(r.getFrequencyCluster_Id(), entity.getFrequencyCluster_Id());
				}
			}

			//test field 'GenotypeCombo', type 'text'
			{
				Query<GenotypeFrequency> q2 = db.query(GenotypeFrequency.class);
				q2.equals("genotypeCombo",entity.getGenotypeCombo());
				List<GenotypeFrequency> results = q2.find();
				for(GenotypeFrequency r: results)
				{
					assertEquals(r.getGenotypeCombo(),entity.getGenotypeCombo());
				}
			}
			//test operator 'in' for field 'GenotypeCombo'
			{
				Query<GenotypeFrequency> q2 = db.query(GenotypeFrequency.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getGenotypeCombo());
				q2.in("genotypeCombo", inList);
				List<GenotypeFrequency> results = q2.find();
				for(GenotypeFrequency r: results)
				{
					assertEquals(r.getGenotypeCombo(),entity.getGenotypeCombo());
				}
			}
			//test operator 'like' for field 'GenotypeCombo'
			{
				Query<GenotypeFrequency> q2 = db.query(GenotypeFrequency.class);
				q2.like("genotypeCombo", entity.getGenotypeCombo() + "%");
				q2.sortASC("genotypeCombo");
				List<GenotypeFrequency> results = q2.find();
				for(GenotypeFrequency r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getGenotypeCombo(), entity.getGenotypeCombo()));
				}
			}

			//test field 'NumberSamplesWithGenotype', type 'int'
			{
				Query<GenotypeFrequency> q2 = db.query(GenotypeFrequency.class);
				q2.equals("numberSamplesWithGenotype",entity.getNumberSamplesWithGenotype());
				List<GenotypeFrequency> results = q2.find();
				for(GenotypeFrequency r: results)
				{
					assertEquals(r.getNumberSamplesWithGenotype(),entity.getNumberSamplesWithGenotype());
				}
			}
			//test operator 'in' for field 'NumberSamplesWithGenotype'
			{
				Query<GenotypeFrequency> q2 = db.query(GenotypeFrequency.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getNumberSamplesWithGenotype());
				q2.in("numberSamplesWithGenotype", inList);
				List<GenotypeFrequency> results = q2.find();
				for(GenotypeFrequency r: results)
				{
					assertEquals(r.getNumberSamplesWithGenotype(),entity.getNumberSamplesWithGenotype());
				}
			}
			//test operator 'lessOrEqual' for field 'NumberSamplesWithGenotype'
			{
				Query<GenotypeFrequency> q2 = db.query(GenotypeFrequency.class);
				q2.lessOrEqual("numberSamplesWithGenotype", entity.getNumberSamplesWithGenotype());
				q2.sortASC("numberSamplesWithGenotype");
				List<GenotypeFrequency> results = q2.find();
				for(GenotypeFrequency r: results)
				{
					assertTrue(r.getNumberSamplesWithGenotype().compareTo(entity.getNumberSamplesWithGenotype()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'NumberSamplesWithGenotype'
			{
				Query<GenotypeFrequency> q2 = db.query(GenotypeFrequency.class);
				q2.greaterOrEqual("numberSamplesWithGenotype", entity.getNumberSamplesWithGenotype());
				q2.sortDESC("numberSamplesWithGenotype");
				List<GenotypeFrequency> results = q2.find();
				for(GenotypeFrequency r: results)
				{
					assertTrue(r.getNumberSamplesWithGenotype().compareTo(entity.getNumberSamplesWithGenotype()) > -1);
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testProtocol","testFrequencyCluster"})
	public void testAlleleFrequency() throws DatabaseException
	{
		//create entities
		List<AlleleFrequency> entities = new ArrayList<AlleleFrequency>();

		//retrieve xref entity candidates
		List<Protocol> protocolUsedXrefs = db.query(Protocol.class).eq("__Type",Protocol.class.getSimpleName()).find();	
		List<FrequencyCluster> frequencyClusterXrefs = db.query(FrequencyCluster.class).eq("__Type",FrequencyCluster.class.getSimpleName()).find();	

		for(Integer i = 0; i < total; i++)
		{
			AlleleFrequency e = new AlleleFrequency();
			e.setIdentifier(truncate("allelefrequency_identifier_"+i, 255));
			e.setName(truncate("allelefrequency_name_"+i, 255));
			e.setDescription("allelefrequency_description_"+i);
			if(protocolUsedXrefs.size() > 0) e.setProtocolUsed_Id( protocolUsedXrefs.get(i).getId() );
			if(frequencyClusterXrefs.size() > 0) e.setFrequencyCluster_Id( frequencyClusterXrefs.get(i).getId() );
			e.setAlleleCombo("allelefrequency_allelecombo_"+i);
			e.setFrequencyAsProportion(i.doubleValue());
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<AlleleFrequency> q = db.query(AlleleFrequency.class).eq("__Type",AlleleFrequency.class.getSimpleName());
		assertEquals(total, q.count());
		List<AlleleFrequency> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			assertEquals(entities.get(i).getProtocolUsed_Id(), entitiesDb.get(i).getProtocolUsed_Id());
			assertEquals(entities.get(i).getFrequencyCluster_Id(), entitiesDb.get(i).getFrequencyCluster_Id());
			assertEquals(entities.get(i).getAlleleCombo(), entitiesDb.get(i).getAlleleCombo());
			assertEquals(entities.get(i).getFrequencyAsProportion(), entitiesDb.get(i).getFrequencyAsProportion());
		}	
		
		//test the query capabilities by finding on all fields
		for(AlleleFrequency entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<AlleleFrequency> q2 = db.query(AlleleFrequency.class);
				q2.equals("id",entity.getId());
				List<AlleleFrequency> results = q2.find();
				for(AlleleFrequency r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<AlleleFrequency> q2 = db.query(AlleleFrequency.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<AlleleFrequency> results = q2.find();
				for(AlleleFrequency r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<AlleleFrequency> q2 = db.query(AlleleFrequency.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<AlleleFrequency> results = q2.find();
				for(AlleleFrequency r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<AlleleFrequency> q2 = db.query(AlleleFrequency.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<AlleleFrequency> results = q2.find();
				for(AlleleFrequency r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<AlleleFrequency> q2 = db.query(AlleleFrequency.class);
				q2.equals("identifier",entity.getIdentifier());
				List<AlleleFrequency> results = q2.find();
				for(AlleleFrequency r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<AlleleFrequency> q2 = db.query(AlleleFrequency.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<AlleleFrequency> results = q2.find();
				for(AlleleFrequency r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<AlleleFrequency> q2 = db.query(AlleleFrequency.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<AlleleFrequency> results = q2.find();
				for(AlleleFrequency r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<AlleleFrequency> q2 = db.query(AlleleFrequency.class);
				q2.equals("name",entity.getName());
				List<AlleleFrequency> results = q2.find();
				for(AlleleFrequency r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<AlleleFrequency> q2 = db.query(AlleleFrequency.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<AlleleFrequency> results = q2.find();
				for(AlleleFrequency r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<AlleleFrequency> q2 = db.query(AlleleFrequency.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<AlleleFrequency> results = q2.find();
				for(AlleleFrequency r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'description', type 'text'
			{
				Query<AlleleFrequency> q2 = db.query(AlleleFrequency.class);
				q2.equals("description",entity.getDescription());
				List<AlleleFrequency> results = q2.find();
				for(AlleleFrequency r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'description'
			{
				Query<AlleleFrequency> q2 = db.query(AlleleFrequency.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<AlleleFrequency> results = q2.find();
				for(AlleleFrequency r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'description'
			{
				Query<AlleleFrequency> q2 = db.query(AlleleFrequency.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<AlleleFrequency> results = q2.find();
				for(AlleleFrequency r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

			//test field 'ProtocolUsed', type 'xref'
			{
				Query<AlleleFrequency> q2 = db.query(AlleleFrequency.class);
				q2.equals("protocolUsed",entity.getProtocolUsed_Id());
				List<AlleleFrequency> results = q2.find();
				for(AlleleFrequency r: results)
				{
					assertEquals(r.getProtocolUsed_Id(), entity.getProtocolUsed_Id());
				}
			}
			//test operator 'in' for field 'ProtocolUsed'
			{
				Query<AlleleFrequency> q2 = db.query(AlleleFrequency.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getProtocolUsed_Id());
				q2.in("protocolUsed", inList);
				List<AlleleFrequency> results = q2.find();
				for(AlleleFrequency r: results)
				{
					assertEquals(r.getProtocolUsed_Id(), entity.getProtocolUsed_Id());
				}
			}
			//test operator 'equals' for implicit join field 'ProtocolUsed_Identifier'
			{
				Query<AlleleFrequency> q2 = db.query(AlleleFrequency.class);
				q2.equals("protocolUsed_Identifier",entity.getProtocolUsed_Identifier());
				List<AlleleFrequency> results = q2.find();
				for(AlleleFrequency r: results)
				{
					assertEquals(r.getProtocolUsed_Id(), entity.getProtocolUsed_Id());
				}
			}
			//test operator 'in' for implicit join field 'ProtocolUsed_Identifier'
			{
				Query<AlleleFrequency> q2 = db.query(AlleleFrequency.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getProtocolUsed_Identifier());
				q2.in("protocolUsed_Identifier", inList);
				q2.sortDESC("protocolUsed_Identifier");
				List<AlleleFrequency> results = q2.find();
				for(AlleleFrequency r: results)
				{
					assertEquals(r.getProtocolUsed_Id(), entity.getProtocolUsed_Id());
				}
			}

			//test field 'FrequencyCluster', type 'xref'
			{
				Query<AlleleFrequency> q2 = db.query(AlleleFrequency.class);
				q2.equals("frequencyCluster",entity.getFrequencyCluster_Id());
				List<AlleleFrequency> results = q2.find();
				for(AlleleFrequency r: results)
				{
					assertEquals(r.getFrequencyCluster_Id(), entity.getFrequencyCluster_Id());
				}
			}
			//test operator 'in' for field 'FrequencyCluster'
			{
				Query<AlleleFrequency> q2 = db.query(AlleleFrequency.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getFrequencyCluster_Id());
				q2.in("frequencyCluster", inList);
				List<AlleleFrequency> results = q2.find();
				for(AlleleFrequency r: results)
				{
					assertEquals(r.getFrequencyCluster_Id(), entity.getFrequencyCluster_Id());
				}
			}
			//test operator 'equals' for implicit join field 'FrequencyCluster_Identifier'
			{
				Query<AlleleFrequency> q2 = db.query(AlleleFrequency.class);
				q2.equals("frequencyCluster_Identifier",entity.getFrequencyCluster_Identifier());
				List<AlleleFrequency> results = q2.find();
				for(AlleleFrequency r: results)
				{
					assertEquals(r.getFrequencyCluster_Id(), entity.getFrequencyCluster_Id());
				}
			}
			//test operator 'in' for implicit join field 'FrequencyCluster_Identifier'
			{
				Query<AlleleFrequency> q2 = db.query(AlleleFrequency.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getFrequencyCluster_Identifier());
				q2.in("frequencyCluster_Identifier", inList);
				q2.sortDESC("frequencyCluster_Identifier");
				List<AlleleFrequency> results = q2.find();
				for(AlleleFrequency r: results)
				{
					assertEquals(r.getFrequencyCluster_Id(), entity.getFrequencyCluster_Id());
				}
			}

			//test field 'AlleleCombo', type 'text'
			{
				Query<AlleleFrequency> q2 = db.query(AlleleFrequency.class);
				q2.equals("alleleCombo",entity.getAlleleCombo());
				List<AlleleFrequency> results = q2.find();
				for(AlleleFrequency r: results)
				{
					assertEquals(r.getAlleleCombo(),entity.getAlleleCombo());
				}
			}
			//test operator 'in' for field 'AlleleCombo'
			{
				Query<AlleleFrequency> q2 = db.query(AlleleFrequency.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getAlleleCombo());
				q2.in("alleleCombo", inList);
				List<AlleleFrequency> results = q2.find();
				for(AlleleFrequency r: results)
				{
					assertEquals(r.getAlleleCombo(),entity.getAlleleCombo());
				}
			}
			//test operator 'like' for field 'AlleleCombo'
			{
				Query<AlleleFrequency> q2 = db.query(AlleleFrequency.class);
				q2.like("alleleCombo", entity.getAlleleCombo() + "%");
				q2.sortASC("alleleCombo");
				List<AlleleFrequency> results = q2.find();
				for(AlleleFrequency r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getAlleleCombo(), entity.getAlleleCombo()));
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testObservationSet","testObservableFeature","testCharacteristic","testPhenotypeProperty"})
	public void testPhenotypeValue() throws DatabaseException
	{
		//create entities
		List<PhenotypeValue> entities = new ArrayList<PhenotypeValue>();

		//retrieve xref entity candidates
		List<ObservationSet> observationSetXrefs = db.query(ObservationSet.class).find();	
		List<ObservableFeature> featureXrefs = db.query(ObservableFeature.class).eq("__Type",ObservableFeature.class.getSimpleName()).find();	
		List<Characteristic> characteristicXrefs = db.query(Characteristic.class).find();	
		List<PhenotypeProperty> phenotypePropertyIDXrefs = db.query(PhenotypeProperty.class).eq("__Type",PhenotypeProperty.class.getSimpleName()).find();	

		for(Integer i = 0; i < total; i++)
		{
			PhenotypeValue e = new PhenotypeValue();
			if(observationSetXrefs.size() > 0) e.setObservationSet_Id( observationSetXrefs.get(i).getId() );
			if(featureXrefs.size() > 0) e.setFeature_Id( featureXrefs.get(i).getId() );
			if(characteristicXrefs.size() > 0) e.setCharacteristic_Id( characteristicXrefs.get(i).getId() );
			e.setValue(truncate("phenotypevalue_value_"+i, 255));
			e.setIdentifier(truncate("phenotypevalue_identifier_"+i, 255));
			e.setName(truncate("phenotypevalue_name_"+i, 255));
			if(phenotypePropertyIDXrefs.size() > 0) e.setPhenotypePropertyID_Id( phenotypePropertyIDXrefs.get(i).getId() );
			e.setValueRank(truncate("phenotypevalue_valuerank_"+i, 255));
			e.setValueIsMean(truncate("phenotypevalue_valueismean_"+i, 255));
			e.setSTD(truncate("phenotypevalue_std_"+i, 255));
			e.setMin(truncate("phenotypevalue_min_"+i, 255));
			e.setMax(truncate("phenotypevalue_max_"+i, 255));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<PhenotypeValue> q = db.query(PhenotypeValue.class).eq("__Type",PhenotypeValue.class.getSimpleName());
		assertEquals(total, q.count());
		List<PhenotypeValue> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getObservationSet_Id(), entitiesDb.get(i).getObservationSet_Id());
			assertEquals(entities.get(i).getFeature_Id(), entitiesDb.get(i).getFeature_Id());
			assertEquals(entities.get(i).getCharacteristic_Id(), entitiesDb.get(i).getCharacteristic_Id());
			assertEquals(entities.get(i).getValue(), entitiesDb.get(i).getValue());
			assertEquals(entities.get(i).getIdentifier(), entitiesDb.get(i).getIdentifier());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getPhenotypePropertyID_Id(), entitiesDb.get(i).getPhenotypePropertyID_Id());
			assertEquals(entities.get(i).getValueRank(), entitiesDb.get(i).getValueRank());
			assertEquals(entities.get(i).getValueIsMean(), entitiesDb.get(i).getValueIsMean());
			assertEquals(entities.get(i).getSTD(), entitiesDb.get(i).getSTD());
			assertEquals(entities.get(i).getMin(), entitiesDb.get(i).getMin());
			assertEquals(entities.get(i).getMax(), entitiesDb.get(i).getMax());
		}	
		
		//test the query capabilities by finding on all fields
		for(PhenotypeValue entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				q2.equals("id",entity.getId());
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'ObservationSet', type 'xref'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				q2.equals("observationSet",entity.getObservationSet_Id());
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertEquals(r.getObservationSet_Id(), entity.getObservationSet_Id());
				}
			}
			//test operator 'in' for field 'ObservationSet'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getObservationSet_Id());
				q2.in("observationSet", inList);
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertEquals(r.getObservationSet_Id(), entity.getObservationSet_Id());
				}
			}
			//test operator 'equals' for implicit join field 'ObservationSet_id'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				q2.equals("observationSet_id",entity.getObservationSet_Id());
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertEquals(r.getObservationSet_Id(), entity.getObservationSet_Id());
				}
			}
			//test operator 'in' for implicit join field 'ObservationSet_id'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getObservationSet_Id());
				q2.in("observationSet_id", inList);
				q2.sortDESC("observationSet_id");
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertEquals(r.getObservationSet_Id(), entity.getObservationSet_Id());
				}
			}

			//test field 'Feature', type 'xref'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				q2.equals("feature",entity.getFeature_Id());
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertEquals(r.getFeature_Id(), entity.getFeature_Id());
				}
			}
			//test operator 'in' for field 'Feature'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getFeature_Id());
				q2.in("feature", inList);
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertEquals(r.getFeature_Id(), entity.getFeature_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Feature_Identifier'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				q2.equals("feature_Identifier",entity.getFeature_Identifier());
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertEquals(r.getFeature_Id(), entity.getFeature_Id());
				}
			}
			//test operator 'in' for implicit join field 'Feature_Identifier'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getFeature_Identifier());
				q2.in("feature_Identifier", inList);
				q2.sortDESC("feature_Identifier");
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertEquals(r.getFeature_Id(), entity.getFeature_Id());
				}
			}

			//test field 'Characteristic', type 'xref'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				q2.equals("characteristic",entity.getCharacteristic_Id());
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertEquals(r.getCharacteristic_Id(), entity.getCharacteristic_Id());
				}
			}
			//test operator 'in' for field 'Characteristic'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getCharacteristic_Id());
				q2.in("characteristic", inList);
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertEquals(r.getCharacteristic_Id(), entity.getCharacteristic_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Characteristic_Identifier'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				q2.equals("characteristic_Identifier",entity.getCharacteristic_Identifier());
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertEquals(r.getCharacteristic_Id(), entity.getCharacteristic_Id());
				}
			}
			//test operator 'in' for implicit join field 'Characteristic_Identifier'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getCharacteristic_Identifier());
				q2.in("characteristic_Identifier", inList);
				q2.sortDESC("characteristic_Identifier");
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertEquals(r.getCharacteristic_Id(), entity.getCharacteristic_Id());
				}
			}

			//test field 'Value', type 'string'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				q2.equals("value",entity.getValue());
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertEquals(r.getValue(),entity.getValue());
				}
			}
			//test operator 'in' for field 'Value'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getValue());
				q2.in("value", inList);
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertEquals(r.getValue(),entity.getValue());
				}
			}
			//test operator 'like' for field 'Value'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				q2.like("value", entity.getValue() + "%");
				q2.sortASC("value");
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getValue(), entity.getValue()));
				}
			}

			//test field 'Identifier', type 'string'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				q2.equals("identifier",entity.getIdentifier());
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'in' for field 'Identifier'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getIdentifier());
				q2.in("identifier", inList);
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertEquals(r.getIdentifier(),entity.getIdentifier());
				}
			}
			//test operator 'like' for field 'Identifier'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				q2.like("identifier", entity.getIdentifier() + "%");
				q2.sortASC("identifier");
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getIdentifier(), entity.getIdentifier()));
				}
			}

			//test field 'Name', type 'string'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				q2.equals("name",entity.getName());
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'Name'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'Name'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'PhenotypePropertyID', type 'xref'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				q2.equals("phenotypePropertyID",entity.getPhenotypePropertyID_Id());
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertEquals(r.getPhenotypePropertyID_Id(), entity.getPhenotypePropertyID_Id());
				}
			}
			//test operator 'in' for field 'PhenotypePropertyID'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getPhenotypePropertyID_Id());
				q2.in("phenotypePropertyID", inList);
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertEquals(r.getPhenotypePropertyID_Id(), entity.getPhenotypePropertyID_Id());
				}
			}
			//test operator 'equals' for implicit join field 'PhenotypePropertyID_Identifier'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				q2.equals("phenotypePropertyID_Identifier",entity.getPhenotypePropertyID_Identifier());
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertEquals(r.getPhenotypePropertyID_Id(), entity.getPhenotypePropertyID_Id());
				}
			}
			//test operator 'in' for implicit join field 'PhenotypePropertyID_Identifier'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getPhenotypePropertyID_Identifier());
				q2.in("phenotypePropertyID_Identifier", inList);
				q2.sortDESC("phenotypePropertyID_Identifier");
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertEquals(r.getPhenotypePropertyID_Id(), entity.getPhenotypePropertyID_Id());
				}
			}

			//test field 'ValueRank', type 'string'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				q2.equals("valueRank",entity.getValueRank());
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertEquals(r.getValueRank(),entity.getValueRank());
				}
			}
			//test operator 'in' for field 'ValueRank'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getValueRank());
				q2.in("valueRank", inList);
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertEquals(r.getValueRank(),entity.getValueRank());
				}
			}
			//test operator 'like' for field 'ValueRank'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				q2.like("valueRank", entity.getValueRank() + "%");
				q2.sortASC("valueRank");
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getValueRank(), entity.getValueRank()));
				}
			}

			//test field 'ValueIsMean', type 'string'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				q2.equals("valueIsMean",entity.getValueIsMean());
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertEquals(r.getValueIsMean(),entity.getValueIsMean());
				}
			}
			//test operator 'in' for field 'ValueIsMean'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getValueIsMean());
				q2.in("valueIsMean", inList);
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertEquals(r.getValueIsMean(),entity.getValueIsMean());
				}
			}
			//test operator 'like' for field 'ValueIsMean'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				q2.like("valueIsMean", entity.getValueIsMean() + "%");
				q2.sortASC("valueIsMean");
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getValueIsMean(), entity.getValueIsMean()));
				}
			}

			//test field 'STD', type 'string'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				q2.equals("sTD",entity.getSTD());
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertEquals(r.getSTD(),entity.getSTD());
				}
			}
			//test operator 'in' for field 'STD'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getSTD());
				q2.in("sTD", inList);
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertEquals(r.getSTD(),entity.getSTD());
				}
			}
			//test operator 'like' for field 'STD'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				q2.like("sTD", entity.getSTD() + "%");
				q2.sortASC("sTD");
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getSTD(), entity.getSTD()));
				}
			}

			//test field 'Min', type 'string'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				q2.equals("min",entity.getMin());
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertEquals(r.getMin(),entity.getMin());
				}
			}
			//test operator 'in' for field 'Min'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getMin());
				q2.in("min", inList);
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertEquals(r.getMin(),entity.getMin());
				}
			}
			//test operator 'like' for field 'Min'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				q2.like("min", entity.getMin() + "%");
				q2.sortASC("min");
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getMin(), entity.getMin()));
				}
			}

			//test field 'Max', type 'string'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				q2.equals("max",entity.getMax());
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertEquals(r.getMax(),entity.getMax());
				}
			}
			//test operator 'in' for field 'Max'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getMax());
				q2.in("max", inList);
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertEquals(r.getMax(),entity.getMax());
				}
			}
			//test operator 'like' for field 'Max'
			{
				Query<PhenotypeValue> q2 = db.query(PhenotypeValue.class);
				q2.like("max", entity.getMax() + "%");
				q2.sortASC("max");
				List<PhenotypeValue> results = q2.find();
				for(PhenotypeValue r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getMax(), entity.getMax()));
				}
			}

		}
	}

	
	/** Helper to get random element from a list */
	public <E extends Entity> E random(List<E> entities)
	{
		return entities.get( Long.valueOf( Math.round( Math.random() * (entities.size() - 1) )).intValue() );
	}
	
	public Boolean randomBool(int i)
	{
		return i % 2 == 0 ? true : false;
	}
	
	public String randomEnum(String[] options)
	{
		Integer index = Long.valueOf(Math.round(Math.random() * (options.length - 1) )).intValue();
		return options[index];
	}
	
	public String truncate(String value, int length)
	{
	   if (value != null && value.length() > length)
          value = value.substring(0, length-1);
       return value;
	}
	
	 
	 
}