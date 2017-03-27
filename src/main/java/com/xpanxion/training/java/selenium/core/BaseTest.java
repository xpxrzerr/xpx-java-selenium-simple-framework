package com.xpanxion.training.java.selenium.core;

import java.lang.reflect.Method;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.xpanxion.training.java.selenium.core.services.CSVService;

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
	 * Singleton CSVService object available to all classes.
	 */
	public static final CSVService csvService = new CSVService();
	
	/**
	 * This method is executed before a test method begins, using TestNG's @BeforeMethod
	 * annotation. This method is primarily responsible for obtaining a unique
	 * WebDriver object for the test to use.
	 */
	@BeforeMethod
	public void setup(Method m) {
		LOG.debug("Initializing WebDriver...");
		ChromeDriverManager.getInstance().setup();
		this.driver = new ChromeDriver();
		LOG.debug("Finished initializing WebDriver!");
		LOG.debug("Beginning Test '{}'...", this.getTestName(m));
	}
	
	/**
	 * This method is executed after a test method has completed, using TestNG's @AfterMethod
	 * annotation. This method is primarily responsible for taking care of all
	 * clean up tasks, so that more tests may be run.
	 */
	@AfterMethod
	public void teardown(Method m) {
		LOG.debug("Finished Test '{}'.", this.getTestName(m));
		LOG.debug("Tearing down WebDriver...");
		this.driver.quit();
		LOG.debug("Finished tearing down WebDriver!");
	}
	
	/**
	 * Provided a test <tt>Method</tt> object, returns the name of the test.
	 * @param m The method argument
	 * @return The name of the test.
	 */
	private String getTestName(Method m) {
		return m.getName();
	}
}
