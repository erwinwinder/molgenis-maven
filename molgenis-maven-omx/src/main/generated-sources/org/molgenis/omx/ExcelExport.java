
/* Date:        January 2, 2013
 * 
 * generator:   org.molgenis.generators.excel.ExcelExportGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
package org.molgenis.omx;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.molgenis.framework.db.Database;
import org.molgenis.framework.db.QueryRule;
import org.molgenis.util.CsvFileReader;
import org.molgenis.util.Tuple;

public class ExcelExport
{
	static Logger logger = Logger.getLogger(ExcelExport.class.getSimpleName());
	
	protected int sheetIndex = 0;
	
	/**
	 * Default export all using a target file and a database to export
	 * @param directory
	 * @param db
	 * @throws Exception
	 */
	public void exportAll(File excelFile, Database db) throws Exception
	{
		exportAll(excelFile, db, false, new QueryRule[]{});
	}
	
	/**
	 * Export all using a set of QueryRules used for all entities if applicable to that entity
	 * @param directory
	 * @param db
	 * @param rules
	 * @throws Exception
	 */
	public void exportAll(File excelFile, Database db, QueryRule ... rules) throws Exception
	{
		exportAll(excelFile, db, false, rules);
	}
	
	/**
	 * Export all where a boolean skipAutoId forces an ignore of the auto id field ("id")
	 * @param directory
	 * @param db
	 * @param skipAutoId
	 * @throws Exception
	 */
	public void exportAll(File excelFile, Database db, boolean skipAutoId) throws Exception
	{
		exportAll(excelFile, db, skipAutoId, new QueryRule[]{});
	}
	
	/**
	 * Export all with both a boolean skipAutoId and a set of QueryRules to specify both the skipping of auto id, and applying of a filter
	 * @param directory
	 * @param db
	 * @param skipAutoId
	 * @param rules
	 * @throws Exception
	 */
	public void exportAll(File excelFile, Database db, boolean skipAutoId, QueryRule ... rules) throws Exception
	{
		// Do checks on target file
		if(excelFile.exists()){
			throw new Exception("Target file " + excelFile.getAbsolutePath() + " already exists, will not proceed.");
		}
		boolean createSuccess = excelFile.createNewFile();
		if(!createSuccess){
			throw new Exception("Creation of target file " + excelFile.getAbsolutePath() + " failed, cannot proceed.");
		}
		
		// Create temporary directory
		File directory = new File(System.getProperty("java.io.tmpdir") + File.separator + "molgenis_export"+System.currentTimeMillis());
		directory.mkdir();
		
		// Export CSV to this directory
		new CsvExport().exportAll(directory, db, skipAutoId, rules);
			
		// Create new Excel workbook
		WorkbookSettings ws = new WorkbookSettings();
		ws.setLocale(new Locale("en", "EN"));
		WritableWorkbook workbook = Workbook.createWorkbook(excelFile,
				ws);

		// Format the fonts
	    WritableFont headerFont = new WritableFont(WritableFont.ARIAL, 
	      10, WritableFont.BOLD);
	    WritableCellFormat headerFormat = new WritableCellFormat(headerFont);
	    headerFormat.setWrap(false);
	    WritableFont cellFont = new WritableFont(WritableFont.ARIAL, 
	  	      10, WritableFont.NO_BOLD);
	  	   WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
	  	    cellFormat.setWrap(false);
		
	  	// Variable: copy file contents to the workbook sheets
		copyCsvToWorkbook("MolgenisFile", new File(directory+"/molgenisfile.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("RuntimeProperty", new File(directory+"/runtimeproperty.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("Characteristic", new File(directory+"/characteristic.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("ObservationTarget", new File(directory+"/observationtarget.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("Individual", new File(directory+"/individual.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("Ontology", new File(directory+"/ontology.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("Species", new File(directory+"/species.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("OntologyTerm", new File(directory+"/ontologyterm.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("Accession", new File(directory+"/accession.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("ObservableFeature", new File(directory+"/observablefeature.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("Protocol", new File(directory+"/protocol.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("DataSet", new File(directory+"/dataset.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("Panel", new File(directory+"/panel.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("Genome", new File(directory+"/genome.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("Chromosome", new File(directory+"/chromosome.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("Gene", new File(directory+"/gene.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("Protein", new File(directory+"/protein.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("ProteinDomain", new File(directory+"/proteindomain.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("Exon", new File(directory+"/exon.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("Variant", new File(directory+"/variant.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("Institute", new File(directory+"/institute.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("Person", new File(directory+"/person.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("Citation", new File(directory+"/citation.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("Investigation", new File(directory+"/investigation.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("Study", new File(directory+"/study.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("Experiment", new File(directory+"/experiment.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("Submission", new File(directory+"/submission.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("Contribution", new File(directory+"/contribution.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("StudyDetails", new File(directory+"/studydetails.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("PhenotypeProperty", new File(directory+"/phenotypeproperty.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("PhenotypeMethod", new File(directory+"/phenotypemethod.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("SamplePanel", new File(directory+"/samplepanel.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("AssayedPanel", new File(directory+"/assayedpanel.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("PanelSource", new File(directory+"/panelsource.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("GWASExperiment", new File(directory+"/gwasexperiment.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("UsedMarkerSet", new File(directory+"/usedmarkerset.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("Category", new File(directory+"/category.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("Significance", new File(directory+"/significance.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("EffectSize", new File(directory+"/effectsize.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("SelectionCriteria", new File(directory+"/selectioncriteria.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("ObservationSet", new File(directory+"/observationset.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("ObservedValue", new File(directory+"/observedvalue.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("FrequencyCluster", new File(directory+"/frequencycluster.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("GenotypeFrequency", new File(directory+"/genotypefrequency.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("AlleleFrequency", new File(directory+"/allelefrequency.txt"), workbook, headerFormat, cellFormat);		
		copyCsvToWorkbook("PhenotypeValue", new File(directory+"/phenotypevalue.txt"), workbook, headerFormat, cellFormat);		

	  	// Close workbook
		workbook.write();
	    workbook.close();
	    
	    // Remove temporary directory
		FileUtils.deleteDirectory(directory);
	}

	/**
	 * Convert a CSV to an Excel sheet inside a workbook
	 * @throws Exception 
	 */
	public void copyCsvToWorkbook(String sheetName, File file, WritableWorkbook workbook, WritableCellFormat headerFormat, WritableCellFormat cellFormat) throws Exception
	{
		if(file.exists())
		{
			// Create sheet
			WritableSheet sheet = workbook.createSheet(sheetName, sheetIndex);
			
			// Parse CSV file to tuples TODO: batch this
			final List<Tuple> tuples = new ArrayList<Tuple>();
			for(Tuple tuple: new CsvFileReader(file))
			{
				tuples.add(tuple);
			}
			
			// Add and store headers
			List<String> tupleFields = new ArrayList<String>();
			for(int i = 0; i < tuples.get(0).getFields().size(); i++){
				tupleFields.add(tuples.get(0).getFields().get(i));
				Label l = new Label(i, 0, tuples.get(0).getFields().get(i), headerFormat);
				sheet.addCell(l);
			}
			
			// Add cells
			int rowIndex = 1;
			for(Tuple t : tuples){
				for(int i = 0; i < tupleFields.size(); i++){
					if(!(t.getObject(tupleFields.get(i)) == null)){
						Label l = new Label(i, rowIndex, t.getObject(tupleFields.get(i)).toString(), cellFormat);
						sheet.addCell(l);
					}else{
						sheet.addCell(new Label(i, rowIndex, "", cellFormat));
					}
					
				}
				rowIndex++;
			}
		    sheetIndex++;
		}
	}
}