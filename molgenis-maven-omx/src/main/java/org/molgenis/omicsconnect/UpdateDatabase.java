package org.molgenis.omicsconnect;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.molgenis.Molgenis;

public class UpdateDatabase
{
	public static void main(String[] args) throws FileNotFoundException, SQLException, IOException, Exception
	{
		new Molgenis("org/molgenis/omicsconnect/omicsconnect.properties").updateDb();
	}
}
