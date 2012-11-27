package org.molgenis.framework.db.jpa;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.ejb.Ejb3Configuration;
import org.hibernate.ejb.HibernateEntityManager;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.service.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;
import org.molgenis.util.Entity;

/**
 * @author joris lops
 */
class HibernateImp implements JpaFramework
{

	@Override
	public <E extends Entity> List<E> findByExample(EntityManager em, E example)
	{
		Session session = (Session) em.getDelegate();
		Example customerExample = Example.create(example).excludeZeroes();
		Criteria criteria = session.createCriteria(example.getClass()).add(customerExample);
		@SuppressWarnings("unchecked")
		List<E> list = criteria.list();
		return list;
	}

	@Override
	public void createTables(final String persistenceUnitName, final Map<String, Object> configOverwrites)
	{
		final Ejb3Configuration cfg = new Ejb3Configuration();
		cfg.configure(persistenceUnitName, configOverwrites);
		final SchemaExport schemaExport = new SchemaExport(cfg.getHibernateConfiguration());
		schemaExport.setOutputFile("schema.sql");
		schemaExport.create(true, true);
	}

	@Override
	public void updateTables(String persistenceUnitName, final Map<String, Object> configOverwrites)
	{
		final Ejb3Configuration cfg = new Ejb3Configuration();
		cfg.configure(persistenceUnitName, configOverwrites);
		final SchemaUpdate schemaUpdate = new SchemaUpdate(cfg.getHibernateConfiguration());
		schemaUpdate.setOutputFile("schema.sql");
		schemaUpdate.execute(true, true);
	}

	@Override
	public void dropTables(String persistenceUnitName, final Map<String, Object> configOverwrites)
	{
		final Ejb3Configuration cfg = new Ejb3Configuration();
		cfg.configure(persistenceUnitName, configOverwrites);
		final SchemaExport schemaExport = new SchemaExport(cfg.getHibernateConfiguration());
		schemaExport.setOutputFile("schema.sql");
		schemaExport.drop(true, true);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Connection getConnection(EntityManager em) throws SQLException
	{
		Session session = ((HibernateEntityManager) em).getSession();
		SessionFactoryImplementor sfi = (SessionFactoryImplementor) session.getSessionFactory();
		ConnectionProvider cp = sfi.getConnectionProvider();
		return cp.getConnection();
	}
}
