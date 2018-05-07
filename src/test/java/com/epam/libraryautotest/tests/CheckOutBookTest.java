/**
 * 
 */
package com.epam.libraryautotest.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.libraryautotest.steps.Steps;
import com.epam.libraryautotest.tests.constants.Constants;

/**
 * @author Артем
 *
 */
public class CheckOutBookTest {
	private Steps steps;

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}

	@Test(groups = { "6" }, description = "Possibility of checking out book test")
	public void checkOutBookTest() {
		steps.login(Constants.Authorization.LOGIN, Constants.Authorization.PASSWORD);
		steps.openBookCatalog();
		assertEquals(steps.checkOutBook(), "Book checked out successfully");
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}
}
