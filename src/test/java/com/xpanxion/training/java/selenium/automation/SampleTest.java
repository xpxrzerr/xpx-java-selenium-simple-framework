package com.xpanxion.training.java.selenium.automation;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xpanxion.training.java.selenium.core.BaseTest;

public class SampleTest extends BaseTest {

	public static final Logger LOG = LoggerFactory.getLogger(SampleTest.class);

	@Test
	public void test() {
		LOG.info("Hello World");
	}
}
