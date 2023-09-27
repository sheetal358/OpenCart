package com.OpenCart.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.OpenCart.DemoLogger.DemoLog;
import com.OpenCart.base.Browser;
import com.OpenCart.locators.Locator;
import com.OpenCart.screenshot.Screenshot;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Login extends Browser {
	static String password;
	static String email;

	//check for the password masked or not
	public static void passwordField() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("check password is masked or not");
		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "Checking password is masked or not");
			password = Locator.getPropertyData("password");
			String type = driver.findElement(By.id(password)).getAttribute("type");
			System.out.println("type " + type);
			Assert.assertEquals(type, "password");
			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "password is masked properly");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "password is not masked properly");
		}
		report.flush();
	}

	// enters valid credentials
	public static void loginData(String emailValue, String passwordValue) {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("Valid credentials");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "Enters valid credentials");
			
			String email = Locator.getPropertyData("loginEmailId");
			System.out.println(".........."+email);
			driver.findElement(By.id(email)).sendKeys(emailValue);
			
			String password = Locator.getPropertyData("loginPassword");
			System.out.println(".........."+password);
			driver.findElement(By.id(password)).sendKeys(passwordValue);

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "Successfully entered valid credentials");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Valid credentials failed");
		}
		report.flush();
	}

	// click on login button
	public static void loginButton(){
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("Login Button");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "Clicks on login button");

			String loginButton = Locator.getPropertyData("loginButton");

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loginButton)));
			
			driver.findElement(By.xpath(loginButton)).click();

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "Clicked on login button");
			Screenshot.screenShot(11);

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Clicking on login button failed");
		}
		report.flush();
	}

	//check for the loggedin successfully
	public static void verifylogoutButton() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("Check Logged in successfully");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "checking if user is logged in");

			String myAccount = Locator.getPropertyData("myAccount");
			String myAccountList = Locator.getPropertyData("myAccountList");

			wait = new WebDriverWait(driver, 3);
			wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(myAccount))));

			driver.findElement(By.xpath(myAccount)).click();

			List<WebElement> MyAccountList = driver.findElements(By.xpath(myAccountList));
			for (WebElement item : MyAccountList) {
				if (item.getText().equals("Logout")) {
					System.out.println("logged in successfully");
					break;
				}
			}

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "Checked user is logged in properly");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "user is loggedin");
		}
		report.flush();
	}

	//check enter key is working for login button
	public static void enterButton() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("Check enter key is working for login button");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "Checking enter key is working for login button");

			String loginButton = Locator.getPropertyData("loginButton");
			driver.findElement(By.xpath(loginButton)).sendKeys(Keys.ENTER);

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "Enter key is working for login button");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Enter key is working for login button");
		}
		report.flush();
	}
	
	//error message for login
	public static void errorMessage(int i, int j, int k){
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("Check error message");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "Checking error message");

			String errorMessage = Locator.getPropertyData("errorMessage");

			String Expectedmessage = Locator.getExcelData(i, j, k); // change

			wait = new WebDriverWait(driver, 3);
			wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(errorMessage))));

			String actualMessage = driver.findElement(By.xpath(errorMessage)).getText();
			System.out.println(Expectedmessage + "   " + actualMessage);
			Assert.assertEquals(actualMessage, Expectedmessage);

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "Successfully checked error message");
			Screenshot.screenShot(12);

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed checking error message");
		}
		report.flush();
	}

	//clicking on the forgot password link 
	public static void ForgotPasswordLink(int i, int j, int k) {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("Click on Forgotten Password link");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "Clicking Forgotten Password link");

			String link = Locator.getExcelData(i, j, k); // change

			driver.findElement(By.linkText(link)).click();

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "Successfully clicked forgotten password link");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed clicking forgotten password link");
		}
		report.flush();
	}
	
	//verify the forgot password page
	public static void ForgottenPage() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("Check if user is on forgotten password page");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "Checking if user is on Forgotten Password Page");

			boolean val = driver.getCurrentUrl().contains("forgotten");
			if (val) {
				System.out.println("present");
				Assert.assertTrue(true);
			} else {
				System.out.println("not");
				Assert.assertTrue(false);
			}

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "Successfully present on forgotten password page");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed to be present on forgotten password page");
		}
		report.flush();
	}
}
