/**
 * 
 */
package com.epam.libraryautotest.listener;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.epam.libraryautotest.driver.DriverSingleton;

/**
 * @author Артем
 *
 */
public class ScreenShotOnFailListener implements ITestListener, ISuiteListener, IInvokedMethodListener {

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {
		takeScreenshot();
	}

	private void takeScreenshot() {
		System.out.println("!!! Scrreeenshot !!!");
		File screenCapture = ((TakesScreenshot) DriverSingleton.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			File f = new File(".//target/screenshots/screenshot.png");
			FileUtils.copyFile(screenCapture, f);
			System.setProperty("org.uncommons.reportng.escape-output ", "false");
			Reporter.log("<img src=\"" + f.getAbsolutePath() + "\"/>");

		} catch (IOException e) {
			System.out.println("Failed to save screenshot: " + e.getLocalizedMessage());
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
