package com.xpanxion.training.java.selenium.automation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.xpanxion.training.java.selenium.core.services.CSVService;

public class SampleDataDrivenTest /* extends BaseTest */ {
	
	public static final Logger LOG = LoggerFactory.getLogger(SampleDataDrivenTest.class);
	
	@DataProvider
	public String[][] animalDataProvider() {
		final CSVService csvService = new CSVService();
		return csvService.readCsv("src/main/resources/animals.csv");
	}
	
	@Test(dataProvider = "animalDataProvider")
	public void sampleTest(String animal, String age) {
		LOG.info("Number of {}(s): {}", animal, age);
	}
}
