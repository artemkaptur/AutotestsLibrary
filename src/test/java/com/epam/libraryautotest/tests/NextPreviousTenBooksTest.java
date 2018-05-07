/**
 * 
 */
package com.epam.libraryautotest.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.libraryautotest.steps.Steps;
import com.epam.libraryautotest.tests.constants.Constants;

/**
 * @author Артем
 *
 */
public class NextPreviousTenBooksTest {
	private Steps steps;

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}

	@Test(groups = { "9" }, description = "Check showing next and previous ten books")
	public void nextTenVisibleElements() {
		steps.login(Constants.Authorization.LOGIN, Constants.Authorization.PASSWORD);
		steps.openBookHistory();
		String prev = steps.getCurrentVisibleBooks();
		steps.clickOnNextButton();
		assertNotEquals(steps.getCurrentVisibleBooks(), prev);
		steps.clickOnPreviousButton();
		assertEquals(steps.getCurrentVisibleBooks(), prev);
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}
}
