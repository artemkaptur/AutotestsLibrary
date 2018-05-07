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
public class UserBooksPage extends AbstractPage {
	@FindBy(xpath = "//*[@id='testTable']/tbody/tr[1]/td[4]")
	private WebElement firstCheckInButton;

	@FindBy(xpath = "//*[@id='info-results']/h3")
	private WebElement infoResults;

	public UserBooksPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void clickOnFirstCheckInButton() {
		firstCheckInButton.click();
	}

	public String getCheckInProof() {
		return infoResults.getText();
	}

	@Override
	public void openPage() throws OperationNotSupportedException {
		throw new OperationNotSupportedException();
	}
}
