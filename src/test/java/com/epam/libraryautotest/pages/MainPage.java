/**
 * 
 */
package com.epam.libraryautotest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Артем
 *
 */
public class MainPage extends AbstractPage {
	private final String BASE_URL = "http://node51579-env-1995265.mycloud.by/MainServlet";

	@FindBy(xpath = "/html/body/div[1]/a[1]")
	private WebElement loginButton;

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void clickOnLoginButton() {
		WebElement loginButton = (new WebDriverWait(driver, 7))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/a[1]")));
		loginButton.click();
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}
}
