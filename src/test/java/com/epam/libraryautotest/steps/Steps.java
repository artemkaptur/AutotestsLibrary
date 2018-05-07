/**
 * 
 */
package com.epam.libraryautotest.steps;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.epam.libraryautotest.driver.DriverSingleton;
import com.epam.libraryautotest.pages.BookCatalogPage;
import com.epam.libraryautotest.pages.BookHistoryPage;
import com.epam.libraryautotest.pages.LoginPage;
import com.epam.libraryautotest.pages.MainPage;
import com.epam.libraryautotest.pages.UserBooksPage;
import com.epam.libraryautotest.pages.UserPage;

/**
 * @author Артем
 *
 */
public class Steps {
	private WebDriver driver;

	private static Logger logger = LogManager.getLogger();

	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}

	public void login(String login, String password) {
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		logger.info("Main page opened");
		mainPage.clickOnLoginButton();
		logger.info("Login page opened");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.fillAllFields(login, password);
		loginPage.clickOnLoginButton();
		logger.info("Login performed");
	}

	public boolean checkLoginOrNot() throws InterruptedException {
		WebElement checkProof = null;
		UserPage userPage = new UserPage(driver);
		checkProof = userPage.getLogoutButton();
		if (checkProof != null)
			return true;
		else
			return false;
	}

	public void logout() {
		UserPage userPage = new UserPage(driver);
		userPage.clickoOnLogoutButton();
		logger.info("Logout performed");
	}

	public boolean checkLogoutOrNot() {
		WebElement checkProof = null;
		MainPage mainPage = new MainPage(driver);
		checkProof = mainPage.getLoginButton();
		if (checkProof != null)
			return true;
		else
			return false;
	}

	public void openBookCatalog() {
		UserPage userPage = new UserPage(driver);
		userPage.clickoOnShowBooksButton();
	}

	public void openBookHistory() {
		UserPage userPage = new UserPage(driver);
		userPage.clickoOnBooksHistoryButton();
	}

	public String getBookCatalogPageTitle() {
		BookCatalogPage bookCatalogPage = new BookCatalogPage(driver);
		return bookCatalogPage.getPageTitle();
	}

	public String getBookHistoryPageTitle() {
		BookHistoryPage bookHistoryPage = new BookHistoryPage(driver);
		return bookHistoryPage.getPageTitle();
	}

	public List<WebElement> getBookCatalog() {
		BookCatalogPage bookCatalogPage = new BookCatalogPage(driver);
		return bookCatalogPage.getBookCatalog();
	}

	public List<WebElement> getBookHistoryList() {
		BookHistoryPage bookHistoryPage = new BookHistoryPage(driver);
		return bookHistoryPage.getBooksHistoryList();
	}

	public void sellectNewVisibleElementsCount(String count) {
		BookHistoryPage bookHistoryPage = new BookHistoryPage(driver);
		bookHistoryPage.sellectVisibleElementsCount(count);
	}

	public String checkOutBook() {
		BookCatalogPage bookCatalogPage = new BookCatalogPage(driver);
		bookCatalogPage.clickOnFirstCheckOutButton();
		return bookCatalogPage.getCheckOutProof();
	}

	public void openUserBooksPage() {
		UserPage userPage = new UserPage(driver);
		userPage.clickoOnUserBooksButton();
	}

	public String checkInBook() {
		UserBooksPage userBooksPage = new UserBooksPage(driver);
		userBooksPage.clickOnFirstCheckInButton();
		return userBooksPage.getCheckInProof();
	}

	public void setSearchKey(String key) {
		BookHistoryPage bookHistoryPage = new BookHistoryPage(driver);
		bookHistoryPage.setSearchKey(key);
	}

	public void clickOnNextButton() {
		BookHistoryPage bookHistoryPage = new BookHistoryPage(driver);
		bookHistoryPage.clickOnNextButton();
	}

	public void clickOnPreviousButton() {
		BookHistoryPage bookHistoryPage = new BookHistoryPage(driver);
		bookHistoryPage.clickOnPreviousButton();
	}

	public String getCurrentVisibleBooks() {
		BookHistoryPage bookHistoryPage = new BookHistoryPage(driver);
		return bookHistoryPage.getCurrentVisibleBooks();
	}

	public void sortByTitleFromBigger() {
		BookCatalogPage bookCatalogPage = new BookCatalogPage(driver);
		bookCatalogPage.clickOnSortByTitleButton();
	}

}
