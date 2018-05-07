/**
 * 
 */
package com.epam.libraryautotest.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.libraryautotest.steps.Steps;
import com.epam.libraryautotest.tests.constants.Constants;

/**
 * @author Артем
 *
 */
public class BooksHistoryVisibleElementsChange {
	private Steps steps;

	private final String COUNT_ONE = "25";
	private final String COUNT_TWO = "50";
	private final String COUNT_THREE = "100";

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}

	@Test(groups = { "5" }, description = "Changing books history visible elements count test")
	public void booksHistoryVisibleElementsChangeTest() {
		steps.login(Constants.Authorization.LOGIN, Constants.Authorization.PASSWORD);
		steps.openBookHistory();
		steps.sellectNewVisibleElementsCount(COUNT_ONE);
		assertTrue(steps.getBookHistoryList().size() == 25);
		steps.sellectNewVisibleElementsCount(COUNT_TWO);
		assertTrue(steps.getBookHistoryList().size() == 50);
		steps.sellectNewVisibleElementsCount(COUNT_THREE);
		assertTrue(steps.getBookHistoryList().size() > 50);

	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}
}
