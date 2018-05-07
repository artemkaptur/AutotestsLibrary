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
public class LoginPage extends AbstractPage {
	private final String BASE_URL = "http://node51579-env-1995265.mycloud.by/login.jsp";

	@FindBy(name = "login")
	private WebElement loginField;

	@FindBy(name = "password")
	private WebElement passwordField;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void fillAllFields(String login, String password) {
		loginField.sendKeys(login);
		passwordField.sendKeys(password);
	}

	public void clickOnLoginButton() {
		WebElement submitButton = (new WebDriverWait(driver, 7))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='login_form']/button")));
		submitButton.click();
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}
}
