
/* File:        org.molgenis.omx/model/SamplePanel.java
 * Copyright:   GBIC 2000-2013, all rights reserved
 * Date:        January 2, 2013
 * 
 * generator:   org.molgenis.generators.excel.ExcelReaderGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.gwascentral.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;

import org.apache.log4j.Logger;
import org.molgenis.framework.db.Database;
import org.molgenis.framework.db.DatabaseException;
import org.molgenis.framework.db.Database.DatabaseAction;
import org.molgenis.util.CsvWriter;
import org.molgenis.util.SimpleTuple;
import org.molgenis.util.Tuple;

import org.molgenis.gwascentral.SamplePanel;
import org.molgenis.gwascentral.csv.SamplePanelCsvReader;

/**
 * Reads SamplePanel from Excel file.
 */
public class SamplePanelExcelReader
{
	private static final Logger logger = Logger.getLogger(SamplePanelExcelReader.class);
			
	/**
	 * Imports SamplePanel from a workbook sheet.
	 */
	public int importSheet(final Database db, Sheet sheet, final Tuple defaults, final DatabaseAction dbAction, final String missingValue) throws DatabaseException, IOException, Exception 
	{
		File tmpSamplePanel = new File(System.getProperty("java.io.tmpdir") + File.separator + "tmpSamplePanel.txt");
		if(tmpSamplePanel.exists()){
			boolean deleteSuccess = tmpSamplePanel.delete();
			if(!deleteSuccess){
				throw new Exception("Deletion of tmp file 'tmpSamplePanel.txt' failed, cannot proceed.");
			}
		}
		boolean createSuccess = tmpSamplePanel.createNewFile();
		if(!createSuccess){
			throw new Exception("Creation of tmp file 'tmpSamplePanel.txt' failed, cannot proceed.");
		}
		boolean fileHasHeaders = writeSheetToFile(sheet, tmpSamplePanel);
		if(fileHasHeaders){
			int count = new SamplePanelCsvReader().importCsv(db, tmpSamplePanel, defaults, dbAction, missingValue);
			tmpSamplePanel.delete();
			return count;
		}else{
			tmpSamplePanel.delete();
			return 0;
		}
	}
	
	public List<String> getNonEmptyHeaders(Sheet sheet){
		List<String> headers = new ArrayList<String>();
		Cell[] headerCells = sheet.getRow(0); //assume headers are on first line
		for(int i = 0; i < headerCells.length; i++){
			if(!headerCells[i].getContents().equals("")){
				headers.add(headerCells[i].getContents());
			}
		}
		return headers;
	}
	
	private boolean writeSheetToFile(Sheet sheet, File file) throws IOException{
		List<String> headers = new ArrayList<String>();
		Cell[] headerCells = sheet.getRow(0); //assume headers are on first line
		if(headerCells.length == 0){
			return false;
		}
		ArrayList<Integer> namelessHeaderLocations = new ArrayList<Integer>(); //allow for empty columns, also column order does not matter
		for(int i = 0; i < headerCells.length; i++){
			if(!headerCells[i].getContents().equals("")){
				headers.add(headerCells[i].getContents());
			}else{
				headers.add("nameless"+i);
				namelessHeaderLocations.add(i);
			}
		}
		CsvWriter cw = new CsvWriter(new FileOutputStream(file), Charset.forName("UTF-8"), headers);
		try
		{
			cw.setMissingValue("");
			cw.writeHeader();
			for (int rowIndex = 1; rowIndex < sheet.getRows(); rowIndex++)
			{
				Tuple t = new SimpleTuple();
				int colIndex = 0;
				for (Cell c : sheet.getRow(rowIndex))
				{
					if (!namelessHeaderLocations.contains(colIndex) && colIndex < headers.size()
							&& c.getContents() != null)
					{
						t.set(headers.get(colIndex), c.getContents());
					}
					colIndex++;
				}
				cw.writeRow(t);
			}
		}
		finally
		{
			cw.close();
		}
		return true;
	}
}