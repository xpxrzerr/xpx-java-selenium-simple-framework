package com.xpanxion.training.java.selenium.automation;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(JUnitParamsRunner.class)
public class SampleDataDrivenTest /* extends BaseTest */ {

	public static final Logger LOG = LoggerFactory.getLogger(SampleTest.class);

	@Test
	@FileParameters("src/main/resources/animals.csv")
	public void testWithParameters(String animal, int num) {
		LOG.info("Number of {}(s): {}", animal, num);
	}
}
