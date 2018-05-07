/**
 * 
 */
package com.epam.libraryautotest.tests;

import static org.testng.Assert.assertEquals;
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
public class SearchTest {
	private Steps steps;
	private final String POSITIVE_TEST_KEY = "Hunger";
	private final String NEGATIVE_TEST_KEY = "blablabla";

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}

	@Test(groups = { "8" }, description = "Check correct searching work")
	public void searchTest() throws InterruptedException {
		steps.login(Constants.Authorization.LOGIN, Constants.Authorization.PASSWORD);
		steps.openBookHistory();
		Thread.sleep(2000);
		steps.setSearchKey(POSITIVE_TEST_KEY);
		assertTrue(steps.getBookHistoryList().size() != 0, "There are no such books in catalog");
		Thread.sleep(2000);
		steps.setSearchKey(NEGATIVE_TEST_KEY);
		System.out.println("=============" + steps.getBookHistoryList().get(0).getText());
		assertEquals(steps.getBookHistoryList().get(0).getText(), "No matching records found");
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}
}
