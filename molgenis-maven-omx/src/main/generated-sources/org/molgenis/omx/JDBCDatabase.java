/* File:        org.molgenis.omx/model/JDBCDatabase
 * Copyright:   GBIC 2000-2013, all rights reserved
 * Date:        January 2, 2013
 * 
 * generator:   org.molgenis.generators.db.JDBCDatabaseGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.omx;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import javax.sql.DataSource;
import java.sql.Connection;
import org.molgenis.MolgenisOptions;
import org.molgenis.framework.db.DatabaseException;
import org.molgenis.framework.db.jdbc.DataSourceWrapper;
import org.molgenis.framework.db.jdbc.SimpleDataSourceWrapper;
import org.molgenis.model.elements.Model;
import org.apache.commons.dbcp.BasicDataSource;


public class JDBCDatabase extends org.molgenis.framework.db.jdbc.JDBCDatabase
{
	private JDBCMetaDatabase metaData = null;
	

	public JDBCDatabase(Connection conn) throws DatabaseException
	{
		super(conn);
		this.setup();
		
	}

	public JDBCDatabase(DataSource data_src, File file_source) throws DatabaseException
	{
		this(new SimpleDataSourceWrapper(data_src), file_source);
	}

	public JDBCDatabase(DataSourceWrapper data_src, File file_src) throws DatabaseException
	{
		super(data_src, file_src);
		this.setup();
		
	}

	public JDBCDatabase(Properties p) throws DatabaseException
	{
		super(p);
		this.setup();
		
	}
	
	public JDBCDatabase(MolgenisOptions options) throws DatabaseException
	{
		super(options);
		this.setup();
		
	}
	
	@Deprecated
	public JDBCDatabase() throws DatabaseException
	{
		super((DataSource)JDBCDatabase.createDataSource(), new File("omicsconnect/"));
		this.setup();
		
	}

	@Deprecated
	private static DataSource createDataSource() {
		BasicDataSource data_src = new BasicDataSource();
		data_src.setDriverClassName("com.mysql.jdbc.Driver");
		data_src.setUsername("molgenis");
		data_src.setPassword("molgenis");
		data_src.setUrl("jdbc:mysql://localhost/omicsconnect?innodb_autoinc_lock_mode=2"); // a path within the src folder?
		data_src.setMaxIdle(10);
		data_src.setMaxWait(1000);
		return (DataSource)data_src;	
	}

	public JDBCDatabase(String propertiesFilePath) throws FileNotFoundException, IOException, DatabaseException
	{
		super(propertiesFilePath);
		this.setup();
		
	}
	
	private void setup()
	{
		this.putMapper(org.molgenis.core.MolgenisEntity.class, new org.molgenis.core.db.MolgenisEntityMapper(this));
		this.putMapper(org.molgenis.core.MolgenisFile.class, new org.molgenis.core.db.MolgenisFileMapper(this));
		this.putMapper(org.molgenis.core.RuntimeProperty.class, new org.molgenis.core.db.RuntimePropertyMapper(this));
		this.putMapper(org.molgenis.auth.MolgenisRole.class, new org.molgenis.auth.db.MolgenisRoleMapper(this));
		this.putMapper(org.molgenis.auth.MolgenisGroup.class, new org.molgenis.auth.db.MolgenisGroupMapper(this));
		this.putMapper(org.molgenis.auth.MolgenisUser.class, new org.molgenis.auth.db.MolgenisUserMapper(this));
		this.putMapper(org.molgenis.auth.MolgenisRoleGroupLink.class, new org.molgenis.auth.db.MolgenisRoleGroupLinkMapper(this));
		this.putMapper(org.molgenis.auth.MolgenisPermission.class, new org.molgenis.auth.db.MolgenisPermissionMapper(this));
		this.putMapper(org.molgenis.observ.Characteristic.class, new org.molgenis.observ.db.CharacteristicMapper(this));
		this.putMapper(org.molgenis.observ.ObservationTarget.class, new org.molgenis.observ.db.ObservationTargetMapper(this));
		this.putMapper(org.molgenis.observ.target.Individual.class, new org.molgenis.observ.target.db.IndividualMapper(this));
		this.putMapper(org.molgenis.observ.target.Ontology.class, new org.molgenis.observ.target.db.OntologyMapper(this));
		this.putMapper(org.molgenis.observ.target.Species.class, new org.molgenis.observ.target.db.SpeciesMapper(this));
		this.putMapper(org.molgenis.observ.target.OntologyTerm.class, new org.molgenis.observ.target.db.OntologyTermMapper(this));
		this.putMapper(org.molgenis.observ.target.Accession.class, new org.molgenis.observ.target.db.AccessionMapper(this));
		this.putMapper(org.molgenis.observ.ObservableFeature.class, new org.molgenis.observ.db.ObservableFeatureMapper(this));
		this.putMapper(org.molgenis.observ.Protocol.class, new org.molgenis.observ.db.ProtocolMapper(this));
		this.putMapper(org.molgenis.observ.DataSet.class, new org.molgenis.observ.db.DataSetMapper(this));
		this.putMapper(org.molgenis.observ.target.Panel.class, new org.molgenis.observ.target.db.PanelMapper(this));
		this.putMapper(org.molgenis.variant.Genome.class, new org.molgenis.variant.db.GenomeMapper(this));
		this.putMapper(org.molgenis.variant.Chromosome.class, new org.molgenis.variant.db.ChromosomeMapper(this));
		this.putMapper(org.molgenis.variant.Gene.class, new org.molgenis.variant.db.GeneMapper(this));
		this.putMapper(org.molgenis.variant.Protein.class, new org.molgenis.variant.db.ProteinMapper(this));
		this.putMapper(org.molgenis.variant.ProteinDomain.class, new org.molgenis.variant.db.ProteinDomainMapper(this));
		this.putMapper(org.molgenis.variant.Exon.class, new org.molgenis.variant.db.ExonMapper(this));
		this.putMapper(org.molgenis.variant.Variant.class, new org.molgenis.variant.db.VariantMapper(this));
		this.putMapper(org.molgenis.organization.Institute.class, new org.molgenis.organization.db.InstituteMapper(this));
		this.putMapper(org.molgenis.organization.Person.class, new org.molgenis.organization.db.PersonMapper(this));
		this.putMapper(org.molgenis.organization.Citation.class, new org.molgenis.organization.db.CitationMapper(this));
		this.putMapper(org.molgenis.gwascentral.Investigation.class, new org.molgenis.gwascentral.db.InvestigationMapper(this));
		this.putMapper(org.molgenis.organization.Study.class, new org.molgenis.organization.db.StudyMapper(this));
		this.putMapper(org.molgenis.organization.Experiment.class, new org.molgenis.organization.db.ExperimentMapper(this));
		this.putMapper(org.molgenis.organization.Submission.class, new org.molgenis.organization.db.SubmissionMapper(this));
		this.putMapper(org.molgenis.organization.Contribution.class, new org.molgenis.organization.db.ContributionMapper(this));
		this.putMapper(org.molgenis.gwascentral.StudyDetails.class, new org.molgenis.gwascentral.db.StudyDetailsMapper(this));
		this.putMapper(org.molgenis.gwascentral.PhenotypeProperty.class, new org.molgenis.gwascentral.db.PhenotypePropertyMapper(this));
		this.putMapper(org.molgenis.gwascentral.PhenotypeMethod.class, new org.molgenis.gwascentral.db.PhenotypeMethodMapper(this));
		this.putMapper(org.molgenis.gwascentral.SamplePanel.class, new org.molgenis.gwascentral.db.SamplePanelMapper(this));
		this.putMapper(org.molgenis.gwascentral.AssayedPanel.class, new org.molgenis.gwascentral.db.AssayedPanelMapper(this));
		this.putMapper(org.molgenis.observ.target.PanelSource.class, new org.molgenis.observ.target.db.PanelSourceMapper(this));
		this.putMapper(org.molgenis.gwascentral.GWASExperiment.class, new org.molgenis.gwascentral.db.GWASExperimentMapper(this));
		this.putMapper(org.molgenis.gwascentral.UsedMarkerSet.class, new org.molgenis.gwascentral.db.UsedMarkerSetMapper(this));
		this.putMapper(org.molgenis.observ.Category.class, new org.molgenis.observ.db.CategoryMapper(this));
		this.putMapper(org.molgenis.gwascentral.Significance.class, new org.molgenis.gwascentral.db.SignificanceMapper(this));
		this.putMapper(org.molgenis.gwascentral.EffectSize.class, new org.molgenis.gwascentral.db.EffectSizeMapper(this));
		this.putMapper(org.molgenis.gwascentral.SelectionCriteria.class, new org.molgenis.gwascentral.db.SelectionCriteriaMapper(this));
		this.putMapper(org.molgenis.observ.Protocol_Subprotocols.class, new org.molgenis.observ.db.Protocol_SubprotocolsMapper(this));
		this.putMapper(org.molgenis.observ.Protocol_Features.class, new org.molgenis.observ.db.Protocol_FeaturesMapper(this));
		this.putMapper(org.molgenis.observ.target.Panel_Individuals.class, new org.molgenis.observ.target.db.Panel_IndividualsMapper(this));
		this.putMapper(org.molgenis.organization.Experiment_AssayedPanels.class, new org.molgenis.organization.db.Experiment_AssayedPanelsMapper(this));
		this.putMapper(org.molgenis.organization.Person_AffiliateInstitutions.class, new org.molgenis.organization.db.Person_AffiliateInstitutionsMapper(this));
		this.putMapper(org.molgenis.organization.Citation_OntologyTerms.class, new org.molgenis.organization.db.Citation_OntologyTermsMapper(this));
		this.putMapper(org.molgenis.gwascentral.StudyDetails_OtherCitations.class, new org.molgenis.gwascentral.db.StudyDetails_OtherCitationsMapper(this));
		this.putMapper(org.molgenis.observ.ObservationSet.class, new org.molgenis.observ.db.ObservationSetMapper(this));
		this.putMapper(org.molgenis.observ.ObservedValue.class, new org.molgenis.observ.db.ObservedValueMapper(this));
		this.putMapper(org.molgenis.gwascentral.FrequencyCluster.class, new org.molgenis.gwascentral.db.FrequencyClusterMapper(this));
		this.putMapper(org.molgenis.gwascentral.GenotypeFrequency.class, new org.molgenis.gwascentral.db.GenotypeFrequencyMapper(this));
		this.putMapper(org.molgenis.gwascentral.AlleleFrequency.class, new org.molgenis.gwascentral.db.AlleleFrequencyMapper(this));
		this.putMapper(org.molgenis.gwascentral.PhenotypeValue.class, new org.molgenis.gwascentral.db.PhenotypeValueMapper(this));
		this.putMapper(org.molgenis.organization.Experiment_DataSets.class, new org.molgenis.organization.db.Experiment_DataSetsMapper(this));
	}
	
	
	
	@Override
	public Model getMetaData() throws DatabaseException
	{
		//load on demand.
		//nb: the JDBCMetaDatabase must be made much faster which is done in the generator
		//because now it is still validating which it shouldn't
		if(metaData == null)
			metaData = new JDBCMetaDatabase();
		return metaData;
	}
	
}