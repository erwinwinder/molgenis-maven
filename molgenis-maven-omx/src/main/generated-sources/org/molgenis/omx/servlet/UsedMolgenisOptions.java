/*
 * Created by: org.molgenis.generators.server.UsedMolgenisOptionsGen
 * Date: January 2, 2013
 */

package org.molgenis.omx.servlet;
import java.util.ArrayList;
import java.util.Arrays;
import org.molgenis.MolgenisOptions;
import org.apache.log4j.Level;

public class UsedMolgenisOptions extends MolgenisOptions
{
	private static final long serialVersionUID = 345675892563442346L;
	
	public String appName;

	/**
	 * Generated constructor for MolgenisOptions, setting the options used
	 * when the application was generated to a MolgenisOptions object.
	 * 
	 * Example usage:
	 * 
	 * UsedMolgenisOptions o = new UsedMolgenisOptions();
	 * System.out.println(o.db_driver);
	 * System.out.println(o.generate_doc);
	 */
	public UsedMolgenisOptions(){
		this.appName = "org.molgenis.omx";
		this.generate_sql = true;
		this.model_database = new ArrayList<String>(Arrays.asList(new String[]{"src/main/resources/org/molgenis/omicsconnect/system.xml" ,"src/main/resources/org/molgenis/omicsconnect/observ.xml" ,"src/main/resources/org/molgenis/omicsconnect/extensions/variant.xml" ,"src/main/resources/org/molgenis/omicsconnect/extensions/organization.xml" ,"src/main/resources/org/molgenis/omicsconnect/extensions/gwascentral.xml"}));
		this.mail_smtp_hostname = "smtp.gmail.com";
		this.object_relational_mapping = "subclass_per_table";
		this.output_hand = "src/main/java/";
		this.db_password = "xxxxxx";
		this.mail_smtp_port = 465;
			this.generate_mobile = false;
 
		this.mapper_implementation = MapperImplementation.MULTIQUERY;
			this.generate_html = true;
		this.generate_doc = true;
		this.generate_persistence = true;
		this.generate_tests = true;
		this.generate_decorators = false;
		this.services = new ArrayList<String>(Arrays.asList(new String[]{"org.molgenis.omx.servlet.GuiService@/molgenis.do" ,"org.molgenis.framework.server.services.MolgenisXrefService@/xref" ,"org.molgenis.framework.server.services.MolgenisTmpFileService@/tmpfile" ,"org.molgenis.framework.server.services.FileService@/"}));
		this.auth_redirect = "";
		this.decorator_overriders = "";
		this.log4j_properties_uri = "";
		this.db_user = "molgenis";
		this.generate_imdb = true;
		this.mail_smtp_user = "";
		this.model_userinterface = "src/main/resources/org/molgenis/omicsconnect/observ_test_ui.xml";
		this.output_cpp = "generated/cpp/";
		this.mail_smtp_protocol = "smtps";
		this.generate_soap = false;
		this.db_test_password = "xxxxxx";
		this.example_data_dir = "data";
		this.db_driver = "com.mysql.jdbc.Driver";
		this.authorizable = new ArrayList<String>(Arrays.asList(new String[]{}));
 
		this.log_target = LogTarget.CONSOLE;
		this.output_dir = "generated";
		this.mail_smtp_from = "";
		this.generate_rest = false;
		this.output_src = "src/main/generated-sources/";
		this.hibernate_search_index_base = "/tmp/lucene";
		this.jpa_use_sequence = false;
		this.exclude_system = true;
		this.db_uri = "jdbc:mysql://localhost/omicsconnect?innodb_autoinc_lock_mode=2";
		this.db_jndiname = "molgenis_jndi";
		this.generate_ExcelImport = true;
		this.output_python = "generated/python/";
		this.db_test_uri = "jdbc:mysql://localhost/molgenis_test?innodb_autoinc_lock_mode=2";
		this.auth_loginclass = "org.molgenis.framework.security.SimpleLogin";
		this.generate_gui = true;
		this.generate_plugins = false;
		this.mail_smtp_au = "";
		this.generate_cpp = false;
		this.delete_generated_folder = true;
		this.db_test_user = "molgenis";
		this.disable_decorators = false;
		this.hibernate_dialect = "MySQL5Dialect";
		this.db_filepath = "omicsconnect/";
		this.generate_Python = false;
		this.generate_rdf = false;
		this.generate_csv = true;
 
		this.log_level = Level.INFO;
			this.output_doc = "src/main/webapp/generated-doc/";
		this.render_decorator = "org.molgenis.framework.ui.html.render.LinkoutRenderDecorator";
		this.generate_R = false;
		this.output_web = "src/main/webapp/";
		this.output_sql = "src/main/generated-sources/";
		this.copy_resources = true;
		this.generate_BOT = false;
		this.db_mode = "standalone";
	}
}


