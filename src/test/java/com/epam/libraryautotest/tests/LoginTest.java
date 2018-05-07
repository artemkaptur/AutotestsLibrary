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
public class LoginTest {
	private Steps steps;

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}

	@Test(groups = { "1" }, description = "Login test")
	public void loginTest() throws InterruptedException {
		steps.login(Constants.Authorization.LOGIN, Constants.Authorization.PASSWORD);
		assertTrue(steps.checkLoginOrNot());
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}
}
