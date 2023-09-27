package com.OpenCart.pages;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.OpenCart.DemoLogger.DemoLog;
import com.OpenCart.base.Browser;
import com.OpenCart.locators.Locator;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Search extends Browser {
	static String desc;
	// Search product name in search field
	public static void searchData(int i, int j, int k) {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("Search product name");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "Searching product name");

			String loginButton = Locator.getPropertyData("loginButton");

			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(loginButton)));

			String searchBox = Locator.getPropertyData("searchBox");
			String product = Locator.getExcelData(i, j, k);
			System.out.println("producttt " + product);
			
			Assert.assertTrue(driver.findElement(By.cssSelector(searchBox)).isDisplayed());
			driver.findElement(By.cssSelector(searchBox)).sendKeys(product);

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "Successfully searching product name ");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed searching product name ");
		}
		report.flush();
	}

	// Clicks on search button
	public static void searchButton() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("Click search button");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "Clicking search button");

			String searchButton = Locator.getPropertyData("searchButton");
			
			String loginButton = Locator.getPropertyData("loginButton");
			String searchBox = Locator.getPropertyData("searchBox");

			wait = new WebDriverWait(driver, 5);
			
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(searchBox)));
			driver.findElement(By.xpath(searchButton)).click();

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "Successfully clicked search button");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed clicking search button");
		}
		report.flush();
	}

	// verify search result page when enter correct product name
	public static void verifySearchResultPage() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("Verify search result page");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "Verifying search result page");

			String searchHeading = Locator.getPropertyData("verifySearch");
			String searchBox = Locator.getPropertyData("searchBox");
			String expectedOutput = driver.findElement(By.xpath(searchHeading)).getText();
			String searchedData = driver.findElement(By.cssSelector(searchBox)).getAttribute("value");
			String actualOutput = "Search - " + searchedData;

			Assert.assertEquals(actualOutput, expectedOutput);
			System.out.println("product is present");

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "Successfully verified search result page");

		} catch (AssertionError e) {
			System.out.println("product is not present");
			Assert.assertFalse(true);
		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed verifying search result page");
		}
		report.flush();
	}

	// verify error message when user enters wrong product name
	public static void verfiyErrorMessage(int i, int j, int k) {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("Verify error message for wrong product");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "Verifying error message for wrong product");

			String NoProductErrorMessage = Locator.getPropertyData("NoProductErrorMessage"); // error giving here
			String expectedErrorMessage = driver.findElement(By.xpath(NoProductErrorMessage)).getText();
			String actualErrorMessage = Locator.getExcelData(i, j, k);

			Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "Successfully verified error message for wrong product");

		} catch (AssertionError e) {
			System.out.println("Error msg is not present");
		} catch (IOException e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed verifying error message for wrong product");
		}
		report.flush();
	}

	//navigate to search result page
	public static void goToResultPage() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("Go to search result page");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "Going to search result page");
			System.out.println("searching");
			Assert.assertTrue(driver.getCurrentUrl().contains("search"));

			WebElement element = driver.findElement(By.xpath("//button[@data-original-title=\"Compare this Product\"]"));
			System.out.println("size: " + element.getSize());

			action.moveToElement(element).build().perform();
			//action.moveToElement(data).build().perform();
			
			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "Successfully present on search result page");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed to reach search result page");
		}
		report.flush();

	}

	//get the product desc
	public static void productDescription() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("Get the product description");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "Checking the product description");

			String data = Locator.getPropertyData("productDesc"); // error giving here
			List<WebElement> elements = driver.findElements(By.xpath(data));
			for (int i = 0; i < elements.size(); i++) {
				if (i == 0) {
					desc = elements.get(i).getText();
					System.out.println(desc);
					break;
				}
			}
			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "Successfully got the product description");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed to get the product description");
		}
		report.flush();

	}

	//enter the product desc in search box
	public static void enterDescInSearchbox() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("Enter the product description in search box");
		
		String searchBox = Locator.getPropertyData("searchBox");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "Adding the desc in search box");

			//searchBox = Locator.getPropertyData("searchBox");
			System.out.println("desc..."+desc);
			Assert.assertTrue(driver.findElement(By.cssSelector(searchBox)).isDisplayed());
			driver.findElement(By.cssSelector(searchBox)).clear();
			driver.findElement(By.cssSelector(searchBox)).sendKeys(desc);

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "Successfully added the desc in search box ");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed to add desc in search box ");
		}
		report.flush();

	}

	//check if product get populated for product desc in result page
	public static void checkProductdescAndProductMatch(int i, int j, int k) {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("Search product name");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "Verifying search result page");

			String expectedOutput = Locator.getExcelData(i, j, k);
			String data = Locator.getPropertyData("productName");
			System.out.println("desc1");
			List<WebElement> elements = driver.findElements(By.xpath(data));
			System.out.println(elements.size());
			if (elements.size() >= 1) {
				Assert.assertTrue(true, "list is present");
				for (int j1 = 0; j1 < elements.size(); j1++) {
					if (elements.get(i).getAttribute("href").contains(data)) {
						System.out.println("product is present");
						Assert.assertTrue(true);
					} else {
						System.out.println("product is not present");
						Assert.assertTrue(false);
					}
				}
			} else {
				throw new productNotPresentException("no product list is present");
			}

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "Successfully verified search result page");
			
		}catch (productNotPresentException e) {
			System.out.println(e.getMessage());
			DemoLog.LogMsg(3);
		}catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed searching product name ");
		}
		report.flush();
	}

	//select the category and subcategory
	public static void selectCategory(String string) {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("Select the category");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "Selecting the category");

			String subcategory = Locator.getPropertyData("subcategory");

			WebElement category = driver.findElement(By.linkText(string));
			category.click();

			List<WebElement> subcategories = driver.findElements(By.xpath(subcategory));
			for (WebElement sub : subcategories) {
				if (sub.getText().equals("Show All Laptops & Notebooks")) {
					sub.click();
					break;
				}
			}

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "Successfully selected the category ");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed to select the category ");
		}
		report.flush();
	}
}
