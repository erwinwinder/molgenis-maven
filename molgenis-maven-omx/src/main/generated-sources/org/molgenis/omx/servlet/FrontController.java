/*
 * Created by: org.molgenis.generators.server.FrontControllerGen
 * Date: January 2, 2013
 */

package org.molgenis.omx.servlet;

import java.util.LinkedHashMap;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.molgenis.framework.db.Database;
import org.molgenis.framework.db.DatabaseException;
import org.molgenis.framework.server.MolgenisContext;
import org.molgenis.framework.server.MolgenisFrontController;
import org.molgenis.framework.server.MolgenisService;
import org.molgenis.framework.server.MolgenisRequest;
import org.molgenis.framework.security.Login;
import org.apache.commons.dbcp.BasicDataSource;
import org.molgenis.omx.DatabaseFactory;



public class FrontController extends MolgenisFrontController
{
	private static final long serialVersionUID = 3141439968743510237L;
	
	@Override
	public void init(javax.servlet.ServletConfig conf) throws javax.servlet.ServletException
	{
		//create fresh logger based on MolgenisOptions
		createLogger(new UsedMolgenisOptions());
		logger = Logger.getLogger(FrontController.class);
		
		//first, we initialize so the ServletContext is created from the webserver
		super.init(conf);
		
		//now we can create the MolgenisContext with objects reusable over many requests
		context = new MolgenisContext(this.getServletConfig(), this.createDataSource(), new UsedMolgenisOptions(), "org.molgenis.omx");
		
		//keep a map of active connections
		connections = new ConcurrentHashMap<UUID, Connection>();
		
		//finally, we store all mapped services, and pass them the context used for databasing, serving, etc.
		LinkedHashMap<String,MolgenisService> services = new LinkedHashMap<String,MolgenisService>();
		
		try
		{
			services.put("/molgenis.do", new org.molgenis.omx.servlet.GuiService(context));
			services.put("/xref", new org.molgenis.framework.server.services.MolgenisXrefService(context));
			services.put("/tmpfile", new org.molgenis.framework.server.services.MolgenisTmpFileService(context));
			services.put("/", new org.molgenis.framework.server.services.FileService(context));
		}
		catch(Exception e)
		{
			System.err.println("FATAL EXCEPTION: failure in starting services in FrontController. Check your services and/or mapping and try again.");
			e.printStackTrace();
			System.exit(0);
		}
		
		this.services = services;
	}
	
	@Override
	public void createLogin(MolgenisRequest request) throws Exception
	{
		Login login = (Login)request.getRequest().getSession().getAttribute("login");
		if(login == null) {
			login = new org.molgenis.framework.security.SimpleLogin(request.getDatabase(), context.getTokenFactory());
			request.getRequest().getSession().setAttribute("login", login);
		}
		request.getDatabase().setLogin(login);
	}
	
	@Override
	public UUID createDatabase(MolgenisRequest request) throws DatabaseException, SQLException
	{
		//TODO: store db instance in session and reuse, with fresh connection?
		//Database db = (Database)request.getRequest().getSession().getAttribute("database");
		
		//get a connection and keep track of it
		
		UUID id = UUID.randomUUID();
		
		Connection conn = context.getDataSource().getConnection();
		//Database db = new org.molgenis.omx.JDBCDatabase(conn);
		Database db = DatabaseFactory.create(conn);	
		connections.put(id, conn);
		request.setDatabase(db);
		return id;
	}
	
	@Override
	public DataSource createDataSource()
	{
		BasicDataSource data_src = new BasicDataSource();
		data_src.setDriverClassName("com.mysql.jdbc.Driver");
		data_src.setUsername("molgenis");
		data_src.setPassword("molgenis");
		data_src.setUrl("jdbc:mysql://localhost/omicsconnect?innodb_autoinc_lock_mode=2");
		//data_src.setMaxIdle(10);
		//data_src.setMaxWait(1000);
		data_src.setInitialSize(10);
		data_src.setTestOnBorrow(true);
		DataSource dataSource = (DataSource)data_src;
		return dataSource;
	}
	
}
