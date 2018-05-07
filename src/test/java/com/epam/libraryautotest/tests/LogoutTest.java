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
public class LogoutTest {
	private Steps steps;

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}

	@Test(groups = { "2" }, description = "Logout test")
	public void logoutTest() throws InterruptedException {
		steps.login(Constants.Authorization.LOGIN, Constants.Authorization.PASSWORD);
		assertTrue(steps.checkLoginOrNot());
		steps.logout();
		assertTrue(steps.checkLogoutOrNot());
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}
}
