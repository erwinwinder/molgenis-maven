/* File:        app/DatabaseFactory
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 26, 2012
 * 
 * generator:   org.molgenis.generators.db.DatabaseFactoryGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Map;
import javax.sql.DataSource;
import java.sql.Connection;
import org.molgenis.MolgenisOptions;
import org.molgenis.framework.db.Database;
import org.molgenis.framework.db.DatabaseException;
import org.molgenis.framework.db.jdbc.DataSourceWrapper;


public class DatabaseFactory
{
	@Deprecated
	public static Database create(Connection conn) throws DatabaseException
	{
		return new app.JDBCDatabase(conn);
	}


		@Deprecated
        public static Database createInsecure(DataSource data_src, File file_src) throws DatabaseException {
            try {
                return new app.JDBCDatabase(data_src, file_src);
            } catch (Exception ex) {
                throw new DatabaseException(ex);
            }
        }
        
        @Deprecated
        public static Database createInsecure() throws DatabaseException {
            try {
                return new app.JDBCDatabase();
            } catch (Exception ex) {
                throw new DatabaseException(ex);
            }
        }        

	@Deprecated
	public static Database create(DataSource data_src, File file_source) throws DatabaseException
	{
            try {
                return new app.JDBCDatabase(data_src, file_source);            
            } catch (Exception ex) {
                throw new DatabaseException(ex);
            }
	}

	@Deprecated
	public static Database create(DataSourceWrapper data_src, File file_src) throws DatabaseException
	{
            try {
                return new app.JDBCDatabase(data_src, file_src);            
            } catch (Exception ex) {
                throw new DatabaseException(ex);
            }
	}

	@Deprecated
	public static Database create(Properties p) throws DatabaseException
	{
            try {
                return new app.JDBCDatabase(p);            
            } catch (Exception ex) {
                throw new DatabaseException(ex);
            }
	}

	public static Database create(MolgenisOptions options) throws DatabaseException
	{
            try {
                return new app.JDBCDatabase(options);            
            } catch (Exception ex) {
                throw new DatabaseException(ex);
            }
	}
	
	public static Database create() throws DatabaseException
	{
            try {
                return new app.JDBCDatabase();            
            } catch (Exception ex) {
                throw new DatabaseException(ex);
            }
	}

	@Deprecated
	public static Database create(boolean test) throws DatabaseException
	{
            try {
                return new app.JDBCDatabase();            
            } catch (Exception ex) {
                throw new DatabaseException(ex);
            }
	}       

	@Deprecated
	public static Database create(String propertiesFilePath) throws DatabaseException
	{
        return create(propertiesFilePath, false);
    }

	@Deprecated
    public static Database createTest() throws DatabaseException {
		throw new UnsupportedOperationException();
    }

	@Deprecated
    public static Database createTest(String propertiesFilePath) throws DatabaseException {
        return create(propertiesFilePath, true);
    }

	@Deprecated
	private static Database create(String propertiesFilePath, boolean test) throws DatabaseException
	{
            try {
            	if(test) {
                	new org.molgenis.Molgenis(propertiesFilePath).updateDb(false);
            	} 
            	return new app.JDBCDatabase(propertiesFilePath);
            } catch (Exception ex) {
                throw new DatabaseException(ex);
            }
	}

	public static Database create(Map<String, Object> configOverrides) throws DatabaseException {
		 try {
            return new app.JDBCDatabase();            
        } catch (Exception ex) {
            throw new DatabaseException(ex);
        }
	}


}