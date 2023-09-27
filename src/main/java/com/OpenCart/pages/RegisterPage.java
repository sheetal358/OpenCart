package com.OpenCart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.OpenCart.DemoLogger.DemoLog;
import com.OpenCart.base.Browser;
import com.OpenCart.locators.Locator;
import com.OpenCart.screenshot.Screenshot;
import com.OpenCart.utils.FakeData;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;

public class RegisterPage extends Browser {
	
	static String agree_checkbox = Locator.getPropertyData("agreeCheckbox");
	static String continueButton;
	static String firstName;
	static String lastName;
	static String email;
	static String telephone;
	static String password;
	static String confirm_password;
	static String passwordMessage;
	
	FakeData fakeData = new FakeData();
	

	//add all the data to the field
	public static void addAllData() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("add all the data");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "adding all the data to the field");
			
			Faker faker = new Faker();
			
			FakeData.setFirstName(faker.name().firstName());
			FakeData.setLastName(faker.name().lastName());
			FakeData.setEmailId(faker.internet().emailAddress());
			FakeData.setPhone(faker.phoneNumber().phoneNumber());
			String pass = faker.internet().password();
			FakeData.setPassword(pass);
			FakeData.setConfirm_password(pass);
			
			String firstName = Locator.getPropertyData("firstName");
			String lastName = Locator.getPropertyData("lastName");
			String email = Locator.getPropertyData("email");
			String telephone = Locator.getPropertyData("telephone");
			String password = Locator.getPropertyData("password");
			String confirm_password = Locator.getPropertyData("confirm-password");

			driver.findElement(By.name(firstName)).sendKeys(FakeData.getFirstName());
			driver.findElement(By.name(lastName)).sendKeys(FakeData.getLastName());
			driver.findElement(By.name(email)).sendKeys(FakeData.getEmailId());
			driver.findElement(By.name(telephone)).sendKeys(FakeData.getPhone());
			driver.findElement(By.name(password)).sendKeys(FakeData.getPassword());
			driver.findElement(By.name(confirm_password)).sendKeys(FakeData.getConfirm_password());

			List<WebElement> radioButton = driver.findElements(By.name("newsletter"));
			for (WebElement button : radioButton) {
				if (button.getAttribute("value").equals("1")) {
					button.click();
					break;
				}
			}
			
			Assert.assertFalse(driver.findElement(By.name(firstName)).getAttribute("value").isEmpty(),"first name field is empty");
			Assert.assertFalse(driver.findElement(By.name(lastName)).getAttribute("value").isEmpty(),"last name field is empty");
			Assert.assertFalse(driver.findElement(By.name(email)).getAttribute("value").isEmpty(),"email field is empty");
			Assert.assertFalse(driver.findElement(By.name(telephone)).getAttribute("value").isEmpty(),"telephone field is empty");
			Assert.assertFalse(driver.findElement(By.name(password)).getAttribute("value").isEmpty(),"password field is empty");
			Assert.assertFalse(driver.findElement(By.name(confirm_password)).getAttribute("value").isEmpty(),"confirm password field is empty");

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "successfully added all the data");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "failed to add all the data");
		}
		report.flush();
	}

	//checklist the privacy policy
	public static void checklistPrivacyPolicy(boolean value) {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("checklist the privacy policy");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "checklisting the privacy policy");

			Assert.assertTrue(driver.findElement(By.name(agree_checkbox)).isDisplayed());
			
			if (value==true) {
				driver.findElement(By.name(agree_checkbox)).click();
			}
			
			//clickContinueButton(); //click the continue button

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "successfully checklisted the privacy policy");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "failed to checklist the privacy policy");
		}
		report.flush();

	}

	//add all the data to the field with parameter as password and confirm-password
	public static void addAllData(String pass, String confirm_pass) {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("add all the data to the field");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "adding all the data to the field");

			Faker faker = new Faker();
			
			FakeData.setFirstName(faker.name().firstName());
			FakeData.setLastName(faker.name().lastName());
			FakeData.setEmailId(faker.internet().emailAddress());
			FakeData.setPhone(faker.phoneNumber().phoneNumber());
			
			String firstName = Locator.getPropertyData("firstName");
			String lastName = Locator.getPropertyData("lastName");
			String email = Locator.getPropertyData("email");
			String telephone = Locator.getPropertyData("telephone");
			String password = Locator.getPropertyData("password");
			String confirm_password = Locator.getPropertyData("confirm-password");
			
			driver.findElement(By.name(firstName)).sendKeys(FakeData.getFirstName());
			driver.findElement(By.name(lastName)).sendKeys(FakeData.getLastName());
			driver.findElement(By.name(email)).sendKeys(FakeData.getEmailId());
			driver.findElement(By.name(telephone)).sendKeys(FakeData.getPhone());			
			driver.findElement(By.name(password)).sendKeys(pass);
			driver.findElement(By.name(confirm_password)).sendKeys(confirm_pass);

			//driver.findElement(By.name(agree_checkbox)).click();

			System.out.println(driver.findElement(By.name(password)).getText() + " "
					+ driver.findElement(By.name(confirm_password)).getText());

			List<WebElement> radioButton = driver.findElements(By.name("newsletter"));
			for (WebElement button : radioButton) {
				if (button.getAttribute("value").equals("1")) {
					button.click();
					break;
				}
			}
			
			Assert.assertFalse(driver.findElement(By.name(firstName)).getAttribute("value").isEmpty(),"first name field is empty");
			Assert.assertFalse(driver.findElement(By.name(lastName)).getAttribute("value").isEmpty(),"last name field is empty");
			Assert.assertFalse(driver.findElement(By.name(email)).getAttribute("value").isEmpty(),"email field is empty");
			Assert.assertFalse(driver.findElement(By.name(telephone)).getAttribute("value").isEmpty(),"telephone field is empty");
			Assert.assertFalse(driver.findElement(By.name(password)).getAttribute("value").isEmpty(),"password field is empty");

			clickContinueButton(); //click the continue button

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "successfully added all the data");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "failed to add the data");
		}
		report.flush();
	}

	//click continue button
	public static void clickContinueButton() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("clicks on continue button on register page");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "clicking on continue button on register page");

			continueButton = Locator.getPropertyData("continueButton");

			//wait = new WebDriverWait(driver, 5);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(continueButton)));
			driver.findElement(By.xpath(continueButton)).click();

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "clicked on continue button on register page");

			if (driver.getCurrentUrl().contains("account/success")) {
				DemoLog.LogMsg(2);
				log1.log(Status.INFO, "successfully registered");
			} else {
				DemoLog.LogMsg(3);
				log1.log(Status.INFO, "failed to registered");
			}

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "clicking on continue button on register page failed");
		}
		report.flush();
	}
	
	//click on continue button on account success page
	public static void clickAccountSuccessContinueButton() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("click on continue button on account success page");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "clicking on continue button on account success page");

			continueButton = Locator.getPropertyData("continueButton2");

			Assert.assertTrue(driver.getCurrentUrl().contains("account/success"));

			driver.findElement(By.linkText(continueButton)).click();

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "clicked on continue button on account success page");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "failed to click continue button on account success page");
			Assert.assertFalse(driver.getCurrentUrl().contains("account/success"));
		}
		report.flush();

	}

	//password message
	public static void verifyPasswordMessage() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("password message");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "checking the password message");

			String passwordMessage = Locator.getPropertyData("passwordMessage");

			String message = driver.findElement(By.className(passwordMessage)).getText();
			Assert.assertEquals(message, "Password confirmation does not match password!");

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "password message is visible");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "failed to get the password message");
			Assert.assertFalse(driver.getCurrentUrl().contains("account/success"));
		}
		report.flush();

	}
	
	//privacy policy message
	public static void verifyPrivacyPolicyMessage() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("verify privacy policy message");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "checking the privacy policy message");

			String msg = driver.findElement(By.id("account-register")).findElement(By.tagName("div")).getText();
			System.out.println(msg);
			Assert.assertEquals("Warning: You must agree to the Privacy Policy!",msg);

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "successfully checked the privacy policy message");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "failed to check the privacy policy message");
			Assert.assertFalse(driver.getCurrentUrl().contains("account/success"));
		}
		report.flush();

	}

	//add the existing data to the field
	public static void addExistingData(String firstName, String lastName, String emailId, String phone, String pass,
			String confirmPassword) {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("add the existing data");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "adding the existing data");

			driver.findElement(By.name(firstName)).sendKeys(firstName);
			driver.findElement(By.name(lastName)).sendKeys(lastName);
			driver.findElement(By.name(email)).sendKeys(emailId);
			driver.findElement(By.name(telephone)).sendKeys(phone);
			driver.findElement(By.name(password)).sendKeys(pass);
			driver.findElement(By.name(confirm_password)).sendKeys(confirmPassword);
			driver.findElement(By.name(agree_checkbox)).click();

			System.out.println(driver.findElement(By.name(password)).getText() + " "
					+ driver.findElement(By.name(confirm_password)).getText());

			List<WebElement> radioButton = driver.findElements(By.name("newsletter"));
			for (WebElement button : radioButton) {
				if (button.getAttribute("value").equals("1")) {
					button.click();
					break;
				}
			}

			driver.findElement(By.xpath(continueButton)).click();

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "successfully added the existing data");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "failed to add the existing data");
		}
		report.flush();
	}

	//verify the heading, url, title
	public static void verifyUI() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("verify the ui of register page");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "verifying the ui of register page");

			String accountRegisterHeading = Locator.getPropertyData("accountRegisterHeading");
			String heading = driver.findElement(By.xpath(accountRegisterHeading)).getText();
			Assert.assertEquals("Account", heading);
			Assert.assertTrue(driver.getCurrentUrl().contains("account/register"));
			Assert.assertTrue(driver.getTitle().equals("Register Account"));

			DemoLog.LogMsg(2);
			log1.log(Status.PASS, "Successfully verified the ui of register page");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed to verify the ui");
		}
		report.flush();
	}

	//add all the data in the field with emailid as parameter
	public static void addAllData(String emailId) {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("add all the data in the field");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "adding all the data");
			
			Faker faker = new Faker();
			
			FakeData.setFirstName(faker.name().firstName());
			FakeData.setLastName(faker.name().lastName());
			FakeData.setPhone(faker.phoneNumber().phoneNumber());
			String pass = faker.internet().password();
			FakeData.setPassword(pass);
			FakeData.setConfirm_password(pass);;

			driver.findElement(By.name(firstName)).sendKeys(FakeData.getFirstName());
			driver.findElement(By.name(lastName)).sendKeys(FakeData.getLastName());
			driver.findElement(By.name(email)).sendKeys(emailId);
			driver.findElement(By.name(telephone)).sendKeys(FakeData.getPhone());
			driver.findElement(By.name(password)).sendKeys(FakeData.getPassword());
			driver.findElement(By.name(confirm_password)).sendKeys(FakeData.getConfirm_password());
			driver.findElement(By.name(agree_checkbox)).click();

			System.out.println(driver.findElement(By.name(password)).getText() + " "
					+ driver.findElement(By.name(confirm_password)).getText());

			List<WebElement> radioButton = driver.findElements(By.name("newsletter"));
			for (WebElement button : radioButton) {
				if (button.getAttribute("value").equals("1")) {
					button.click();
					break;
				}
			}

			driver.findElement(By.xpath(continueButton)).click();
			if (driver.getCurrentUrl().contains("account/success")) {
				log1.log(Status.PASS, "email id is valid");
				Assert.assertTrue(true);
			} else {
				log1.log(Status.FAIL, "email id is invalid");
				String path = Screenshot.screenShot(10);
				log1.addScreenCaptureFromPath(path);
				Assert.assertTrue(false);
			}

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "added all the data");
		} catch (AssertionError e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "verified registering invalid email id ");
		}

		catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "failed to add all the data");
		}
		report.flush();
	}

}
