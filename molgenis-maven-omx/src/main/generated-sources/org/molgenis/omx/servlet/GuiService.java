/*
 * Created by: org.molgenis.generators.server.MolgenisGuiServiceGen
 * Date: January 2, 2013
 */

package org.molgenis.omx.servlet;

import org.molgenis.framework.db.Database;
import org.molgenis.framework.server.MolgenisContext;
import org.molgenis.framework.server.MolgenisService;
import org.molgenis.framework.server.services.MolgenisGuiService;
import org.molgenis.framework.ui.ApplicationController;
import org.molgenis.util.EmailService;
import org.molgenis.util.SimpleEmailService;

public class GuiService extends MolgenisGuiService implements MolgenisService
{
	public GuiService(MolgenisContext mc)
	{
		super(mc);
	}

	public ApplicationController createUserInterface()
	{
		ApplicationController app = null;
		try {
			final Database dbForController = super.db;
			app = new ApplicationController(mc)
			{
				private static final long serialVersionUID = 6962189567229247434L;
			
				@Override
				public Database getDatabase()
				{
					return dbForController;
				}
			};
			app.getModel().setLabel("org.molgenis.omx");
			app.getModel().setVersion("4.0.0-testing");
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		
		new org.molgenis.omx.ui.InvestigationFormController(app);
		return app;
	}
}
