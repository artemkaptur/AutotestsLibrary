/**
 * 
 */
package com.epam.libraryautotest.pages;

import javax.naming.OperationNotSupportedException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Артем
 *
 */
public class UserPage extends AbstractPage {

	@FindBy(id = "bttLogout")
	private WebElement logoutButton;

	@FindBy(id = "AVAILABLEBOOKS")
	private WebElement showBooksButton;

	@FindBy(id = "MYBOOKS")
	private WebElement userBooksButton;

	@FindBy(id = "history")
	private WebElement booksHistoryButton;

	public UserPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}

	public void clickoOnLogoutButton() {
		logoutButton.click();
	}

	public void clickoOnShowBooksButton() {
		showBooksButton.click();
	}

	public void clickoOnUserBooksButton() {
		userBooksButton.click();
	}

	public void clickoOnBooksHistoryButton() {
		booksHistoryButton.click();
	}

	@Override
	public void openPage() throws OperationNotSupportedException {
		throw new OperationNotSupportedException();
	}
}
