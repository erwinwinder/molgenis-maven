package org.molgenis.omx;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


import org.molgenis.framework.db.Database;
import org.molgenis.framework.db.DatabaseException;
import org.molgenis.framework.db.QueryRule;
import org.molgenis.framework.db.QueryRule.Operator;
import java.text.ParseException;
import org.molgenis.framework.security.Login;
import org.molgenis.framework.security.SimpleLogin;

public class FillMetadata {
	protected static final Logger logger = Logger.getLogger(FillMetadata.class);
	public static void fillMetadata(Database db) throws Exception {
		logger.info("fillMetadata is Empty!");
	}
	public static void fillMetadata(Database db, boolean useLogin) throws Exception {
		logger.info("fillMetadata is Empty!");
	}
}
