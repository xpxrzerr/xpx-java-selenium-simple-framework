package com.xpanxion.training.java.selenium.core;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * <p>Base PageObject class.
 * 
 * <p>This class is the intended root class for all Selenium Page Objects.  All page objects should
 * extend this class, and provide the Selenium WebDriver object as an argument constructor to
 * interact with the current web page.
 * 
 *
 */
public class PageObject {

	protected WebDriver driver;
	
	/**
	 * Instantiates this PageObject and subsequently loads all of the WebElements associated
	 * with this PageObject, annotated with @FindBy and other Selenium PageFactory annotations.
	 * 
	 * <p>This constructor assumes the required page has already been opened and loaded.
	 *  
	 * @param driver The WebDriver object to use. This should be passed in from the test method.
	 */
	public PageObject(WebDriver driver) {
		this(driver, null);
	}
	
	/**
	 * Instantiates this PageObject and subsequently loads all of the WebElements associated
	 * with this PageObject, annotated with @FindBy and other Selenium PageFactory annotations.
	 * 
	 * <p>If <b>url</b> is provided, that URL will be opened prior to instantiation.
	 *  
	 * @param driver The WebDriver object to use. This should be passed in from the test method.
	 * @param url The URL to load prior to instantiation.
	 */
	public PageObject(WebDriver driver, String url) {
		this.driver = driver;
		
		if (!StringUtils.isEmpty(url)) {
			this.driver.get("http://xpanxion.com/");
		}
		
		this.load();
	}
	
	/**
	 * Initializes the PageFactory annotated WebElements associated with this PageObject instance.
	 * 
	 * This method is called as a consequence of creating a new instance of this PageObject.
	 */
	public void load() {
		PageFactory.initElements(this.driver, this);
	}
}
