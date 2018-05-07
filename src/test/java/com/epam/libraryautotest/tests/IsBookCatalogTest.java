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
public class IsBookCatalogTest {
	private Steps steps;

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}

	@Test(groups = { "3" }, description = "Is book catalog or not")
	public void isBookCatalogTest() throws InterruptedException {
		steps.login(Constants.Authorization.LOGIN, Constants.Authorization.PASSWORD);
		steps.openBookCatalog();
		Thread.sleep(2000);
		assertEquals(steps.getBookCatalogPageTitle(), "Book catalog");
		assertTrue(steps.getBookCatalog().size() != 0, "There are no books in catalog");
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}
}
