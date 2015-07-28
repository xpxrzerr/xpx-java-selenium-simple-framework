package com.xpanxion.training.java.selenium.core.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Utility class to provide a wrapper around several commonly used WebDriverWait
 * methods.
 *
 */
public class WaitUtils {

	private static final Sleeper sleeper = Sleeper.SYSTEM_SLEEPER;
	
	public static final long DEFAULT_DELAY_MS = 1000;
	public static final long DEFAULT_TIMEOUT_MS = 30;
	
	/**
	 * Performs a thread safe hard sleep of time <i>duration</i>.
	 * 
	 * @param driver
	 * @param element
	 * @param duration
	 * @param timeout
	 */
	private static void iWaitUntilElementIsVisible(WebDriver driver, WebElement element, long duration, long timeout) {
		hardWait(duration);
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * Performs a thread safe wait until <b>element</b> is visible on the page.
	 * Uses a default timeout of 30 seconds.
	 * 
	 * @param driver The WebDriver object to use.
	 * @param element The WebElement to wait on.
	 * @param delay The delay (in milliseconds) before the wait begins.
	 */
	public static void waitUntilElementIsVisible(WebDriver driver, WebElement element, long delay) {
		iWaitUntilElementIsVisible(driver, element, delay, DEFAULT_TIMEOUT_MS);
	}
	
	/**
	 * Performs a thread safe wait until <b>element</b> is visible on the page. 
	 * 
	 * @param driver The WebDriver object to use.
	 * @param element The WebElement to wait on.
	 * @param delay The delay (in milliseconds) before the wait begins.
	 * @param timeout The length of time (in milliseconds) to attempt to wait until the <b>element</b> is found.
	 */
	public static void waitUntilElementIsVisible(WebDriver driver, WebElement element, long delay, long timeout) {
		iWaitUntilElementIsVisible(driver, element, delay, timeout);
	}
	
	/**
	 * Performs a thread safe wait until <b>element</b> is visible on the page.
	 * Uses a default delay of 1 second.
	 * Uses a default timeout of 30 seconds.
	 * 
	 * @param driver The WebDriver object to use.
	 * @param element The WebElement to wait on.
	 */
	public static void waitUntilElementIsVisible(WebDriver driver, WebElement element) {
		waitUntilElementIsVisible(driver, element, DEFAULT_DELAY_MS);
	}
	
	/**
	 * Performs a thread safe hard sleep of time <i>duration</i>.
	 * 
	 * @param duration
	 */
	public static void hardWait(long duration) {
		final Duration _duration = new Duration(duration, TimeUnit.MILLISECONDS);
		try {
	        sleeper.sleep(_duration); 
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			throw new WebDriverException(e);
		}
	}
}
