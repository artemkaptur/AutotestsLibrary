/**
 * 
 */
package com.epam.libraryautotest.tests;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.libraryautotest.steps.Steps;
import com.epam.libraryautotest.tests.constants.Constants;

/**
 * @author Артем
 *
 */
public class SortByTitleTest {
	private Steps steps;

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}

	@Test(groups = { "10" }, description = "Are books sorting by title ot not")
	public void sortByTitleTest() {
		steps.login(Constants.Authorization.LOGIN, Constants.Authorization.PASSWORD);
		steps.openBookCatalog();
		List<WebElement> firstBooksOrder = steps.getBookCatalog();
		steps.sortByTitleFromBigger();
		assertTrue(reverseProof(firstBooksOrder, steps.getBookCatalog()));
	}

	private boolean reverseProof(List<WebElement> firstBooksOrder, List<WebElement> secondBooksOrder) {
		for (int i = 0, j = secondBooksOrder.size() - 1; j > i; i++, j--) {
			if (!firstBooksOrder.get(i).getText().equals(secondBooksOrder.get(j).getText())) {
				return false;
			}
		}
		return true;
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}
}
