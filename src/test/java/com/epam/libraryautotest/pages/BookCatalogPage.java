/**
 * 
 */
package com.epam.libraryautotest.pages;

import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Артем
 *
 */
public class BookCatalogPage extends AbstractPage {
	@FindBy(id = "header")
	private WebElement pageTitle;

	@FindBy(xpath = "//*[@id='testTable']/thead/tr/th[1]")
	private WebElement sortByTitleButton;

	@FindBy(xpath = "//*[@id='testTable']/tbody/tr[1]/td[4]")
	private WebElement firstCheckOutButton;

	@FindBy(xpath = "//*[@id='info-results']/h3")
	private WebElement infoResults;

	public BookCatalogPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void clickOnFirstCheckOutButton() {
		firstCheckOutButton.click();
	}

	public void clickOnSortByTitleButton() {
		sortByTitleButton.click();
	}

	public String getCheckOutProof() {
		return infoResults.getText();
	}

	public String getPageTitle() {
		return pageTitle.getText();
	}

	public List<WebElement> getBookCatalog() {
		List<WebElement> bookCatalog = driver.findElements(By.xpath("//*[@id='testTable']/tbody/tr"));
		return bookCatalog;
	}

	@Override
	public void openPage() throws OperationNotSupportedException {
		throw new OperationNotSupportedException();
	}
}
