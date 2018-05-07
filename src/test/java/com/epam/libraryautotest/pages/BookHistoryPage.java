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
import org.openqa.selenium.support.ui.Select;

/**
 * @author Артем
 *
 */
public class BookHistoryPage extends AbstractPage {
	@FindBy(id = "testTable_next")
	private WebElement nextButton;

	@FindBy(id = "testTable_previous")
	private WebElement previousButton;

	@FindBy(id = "header")
	private WebElement pageTitle;
	
	@FindBy(id = "testTable_info")
	private WebElement currentVisibleBooks;

	@FindBy(name = "testTable_length")
	private WebElement visibleElementsCount;

	@FindBy(xpath = "//*[@id='testTable_filter']/label/input")
	private WebElement searchField;

	public BookHistoryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public String getPageTitle() {
		return pageTitle.getText();
	}

	public void setSearchKey(String key) {
		searchField.sendKeys(key);
	}

	public void clickOnNextButton() {
		nextButton.click();
	}

	public void clickOnPreviousButton() {
		previousButton.click();
	}
	
	public String getCurrentVisibleBooks() {
		return currentVisibleBooks.getText();
	}

	public List<WebElement> getBooksHistoryList() {
		List<WebElement> booksHistoryList = driver.findElements(By.xpath("//*[@id='testTable']/tbody/tr"));
		return booksHistoryList;
	}

	public void sellectVisibleElementsCount(String count) {
		Select selectCount = new Select(visibleElementsCount);
		selectCount.selectByVisibleText(count);
	}

	@Override
	public void openPage() throws OperationNotSupportedException {
		throw new OperationNotSupportedException();
	}
}
