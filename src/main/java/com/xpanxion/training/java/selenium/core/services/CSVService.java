package com.xpanxion.training.java.selenium.core.services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opencsv.CSVReader;

public class CSVService {

	public static final Logger LOG = LoggerFactory.getLogger(CSVService.class);
	
	/**
	 * Accepts a string, <i>filename</i>, referencing a comma-separated-value (.csv) file and returns 
	 * a TestNG friendly <tt>String[][]</tt> object. Each row's data is represented as a <tt>String[]</tt> 
	 * object, stored in an array of String[] objects.
	 * 
	 * @param filename The .csv file to load.
	 * @param skipHeaderRow Set to true if the csv contains a header row, false if it does not.
	 * @return The testNG friendly String[][] object, representing the data from <i>filename</i>.
	 */
	public String[][] readCsv(String filename, boolean skipHeaderRow) {
		List<String[]> rows = null;
		
		try (CSVReader reader = new CSVReader(new FileReader(filename))) {
			rows = reader.readAll();
		} catch (FileNotFoundException fnfe) {
			LOG.error("File {} not found.", filename, fnfe);
		} catch (IOException ioe) {
			LOG.error("Error reading file {}.", filename, ioe);
		}
		
		return convertToTestNGFormat(rows);
	}
	
	/**
	 * Accepts a string, <i>filename</i>, referencing a comma-separated-value (.csv) file and returns 
	 * a TestNG friendly <tt>String[][]</tt> object. Each row's data is represented as a <tt>String[]</tt> 
	 * object, stored in an array of String[] objects.
	 * 
	 * If the csv contains a "header" row (or a row at the top that is used for identification purposes
	 * and should not be used in the test, consider calling 
	 * <b>readCsv(String filename, boolean skipHeaderRow)</b> instead.
	 * 
	 * @param filename The .csv file to load.
	 * @return The testNG friendly String[][] object, representing the data from <i>filename</i>.
	 */
	public String[][] readCsv(String filename) {
		return this.readCsv(filename, false);
	}
	
	/**
	 * Converts a List<String[]> object to a TestNG friendly String[][] object.
	 *  
	 * @param data The list of data.
	 * @return a TestNG friendly String[][] object.
	 */
	private String[][] convertToTestNGFormat(List<String[]> data) {
		return this.convertToTestNGFormat(data, false);
	}
	
	/**
	 * Converts a List<String[]> object to a TestNG friendly String[][] object.
	 *  
	 * @param data The list of data.
	 * @param skipHeaderRow If true, the first element in the <b>data</b> is ignored.
	 * @return a TestNG friendly String[][] object.
	 */
	private String[][] convertToTestNGFormat(List<String[]> data, boolean skipHeaderRow) {
		String[][] convertedData = null;
		
		if (null != data) {
			convertedData = new String[data.size() - 1][];
			int startingIndex = skipHeaderRow ? 1 : 0;
			for(int i = startingIndex; i < data.size(); i++) {
				convertedData[i - 1] = data.get(i);
			}
		}
		
		return convertedData;
	}
}
