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
public class CheckInBookTest {
	private Steps steps;

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}

	@Test(groups = { "7" }, description = "Possibility of checking in book test")
	public void checkInBookTest() {
		steps.login(Constants.Authorization.LOGIN, Constants.Authorization.PASSWORD);
		steps.openUserBooksPage();
		assertEquals(steps.checkOutBook(), "Book checked in successfully");
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}
}
