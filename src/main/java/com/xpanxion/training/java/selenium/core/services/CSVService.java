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
	 * @return The testNG friendly String[][] object, representing the data from <i>filename</i>.
	 */
	public String[][] readCsv(String filename) {
		List<String[]> rows = null;
		
		try (CSVReader reader = new CSVReader(new FileReader("src/test/resources/" + filename))) {
			rows = reader.readAll();
		} catch (FileNotFoundException fnfe) {
			LOG.error("File {} not found.", filename, fnfe);
		} catch (IOException ioe) {
			LOG.error("Error reading file {}.", filename, ioe);
		}
		
		
		return convertToTestNGFormat(rows);
	}
	
	private String[][] convertToTestNGFormat(List<String[]> data) {
		String[][] convertedData = null;
		
		if (null != data) {
			convertedData = new String[data.size() - 1][];
			for(int i = 1; i < data.size(); i++) {
				convertedData[i - 1] = data.get(i);
			}
		}
		
		return convertedData;
	}
}
