package com.xpanxion.training.java.selenium.core;

import org.junit.After;
import org.junit.Before;
import java.lang.reflect.Method;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is the main testing class. Extend this class from a test class to
 * create a WebDriver object and gain access to it to use for testing.
 */
public class BaseTest {

	public static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);

	/**
	 * The WebDriver object for use in testing. Since the scope is protected,
	 * the object will be available to all sub-classes.
	 */
	protected WebDriver driver;

	/**
	 * This method is executed before a test method begins, using TestNG's @BeforeMethod
	 * annotation. This method is primarily responsible for obtaining a unique
	 * WebDriver object for the test to use.
	 */
	@Before
	public void setup() {
		LOG.debug("Initializing WebDriver...");
		ChromeDriverManager.getInstance().setup();
		this.driver = new ChromeDriver();
		LOG.debug("Finished initializing WebDriver!");
	}

	/**
	 * This method is executed after a test method has completed, using TestNG's @AfterMethod
	 * annotation. This method is primarily responsible for taking care of all
	 * clean up tasks, so that more tests may be run.
	 */
	@After
	public void teardown() {
		LOG.debug("Tearing down WebDriver...");
		this.driver.quit();
		LOG.debug("Finished tearing down WebDriver!");
	}
}
