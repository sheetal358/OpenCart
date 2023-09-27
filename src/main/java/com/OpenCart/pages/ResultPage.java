package com.OpenCart.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.OpenCart.DemoLogger.DemoLog;
import com.OpenCart.base.Browser;
import com.OpenCart.locators.Locator;
import com.OpenCart.screenshot.Screenshot;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ResultPage extends Browser {
	static String wishListMsg;
	static String addToCompareMsg;
	static String productsLocator;
	static String productsNameLocator;
	static String wishListLocator;
	static String product;
	static String compareLocator;
	static String sortBy;
	static String price_tax;
	static List<WebElement> productsList1;
	static List<WebElement> productNameList1;			
	static List<WebElement> wishlistButton1;
	static String numberOfSearchResult;
	//locators
	//private static By sortByOption = ;
	//private static By priceTax = ;
	//private static By productList = ;
	//private static By productNameList = ;
	//private static By compareButton = ;
	//private static By wishlistButton = ;
	//private static By totalSearchResult = ;
	

	// select data from sortBy dropdown
	public static void sort(int i, int j, int k) {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("Select data from sortBy dropdown");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "Selecting data from sortBy dropdown");

			String value = Locator.getExcelData(i, j, k);
			sortBy = Locator.getPropertyData("sortBy");

			wait = new WebDriverWait(driver, 4);
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(sortBy)));

			WebElement sort = driver.findElement(By.cssSelector(sortBy));
			sort.click();
			Select s = new Select(sort);
			s.selectByVisibleText(value);

			DemoLog.LogMsg(2);
			log1.log(Status.PASS, "Successfully selected data from sortBy dropdown");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed selecting data from sortBy dropdown");
		}
		report.flush();
	}

	// verify result page is sorted or not
	public static void verifyPageSorted() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("Verify result page is sorted");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "Verifying result page is sorted");

			price_tax = Locator.getPropertyData("price");
			List<WebElement> products = driver.findElements(By.className(price_tax));
			
			List<Double> priceList = new ArrayList<Double>();
			for (int i = 0; i < products.size(); i++) {
				String price = products.get(i).getText();
		
				String[] tokens = price.split("[$]");

				 String strNew = tokens[1].replace(",", "");
				 
				Double ii = Double.valueOf(strNew);
				priceList.add(ii);
			}

			for (int i = 0; i < priceList.size() - 1; i++) {
				if (priceList.get(i + 1) < priceList.get(i)) {
					System.out.println("result page is sorted");
					Assert.assertTrue(priceList.get(i + 1) < priceList.get(i));
				} else {
					System.out.println("result page is not sorted");
					Assert.assertFalse(priceList.get(i + 1) < priceList.get(i));
				}
			}

			String path = Screenshot.screenShot(1);
			log1.addScreenCaptureFromPath(path);

			DemoLog.LogMsg(2);
			log1.log(Status.PASS, "Successfully verified result page is sorted");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed to verify result page is sorted");
		}
		report.flush();
	}

	// when user clicks on a product
	public static void clickProduct() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("When user clicks on a product");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "When user clicks on a product");

			String productName = Locator.getExcelData(11, 3, 0);
			WebElement product = driver.findElement(By.partialLinkText(productName));
			action.moveToElement(product).build().perform();
			product.click();

			DemoLog.LogMsg(2);
			log1.log(Status.PASS, "Successfilly user clicked on a product");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed user clicking on a product");
		}
		report.flush();
	}

	// clicks on add to wishlist button
	public static void wishlist(int i, int j, int k) {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("User clicks on add to wishlist button");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "User clicks on add to wishlist button");

			productsLocator = Locator.getPropertyData("product");
			productsNameLocator = Locator.getPropertyData("productName");
			wishListLocator = Locator.getPropertyData("wishListButton");
			
			product = Locator.getExcelData(i, j, k);

			List<WebElement> productsList = driver.findElements(By.xpath(productsLocator));
			List<WebElement> productNameList1 = driver.findElements(By.xpath(productsNameLocator));			
			List<WebElement> wishlistButton1 = driver.findElements(By.xpath(wishListLocator));

			for (int a = 0; a < productsList.size(); a++) {
				String name = productNameList1.get(a).getText();
				System.out.println(name);
				if (name.equals(product)) {
					System.out.println(product + " is clicked for wishlist");
					wishlistButton1.get(a).click();
					wishListMsg = "Success: You have added " + name + " to your wishlist!";
					break;
				} // end of if
			} // end of for loop

			DemoLog.LogMsg(2);
			log1.log(Status.PASS, "User clicked on add to wishlist button successfully");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed to clicked on add to wishlist button");
		}
		report.flush();
	}

	// verify wishlist message whether product is added to wishlist
	public static void verifyWishlist() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("Verify wishlist message");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "Verifying wishlist message");

			Pattern p = Pattern.compile("^[A-Za-z:\\s]+[A-Za-z0-9'\"\\s]+[.?!]$");
			Matcher m = p.matcher(wishListMsg);
			if (m.matches()) {
				System.out.println("product is added to wishlist successfully!");
				Assert.assertTrue(true);
			} else
			{
				System.out.println("product is not added to wishlist");
				String path = Screenshot.screenShot(11);
				log1.addScreenCaptureFromPath(path);
				Assert.assertTrue(false);
			}
			String path = Screenshot.screenShot(2);
			log1.addScreenCaptureFromPath(path);

			DemoLog.LogMsg(2);
			log1.log(Status.PASS, "Successfully verified wishlist message");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed to verify wishlist message");
		}
		report.flush();
	}

	// clicks on add to compare button
	public static void compareProduct(int i, int j, int k) {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("User clicks on add to compare button");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "User clicks on add to compare button");

		//	compare = Locator.getPropertyData("addToCompareButton");
		//	String product = Locator.getExcelData(i, j, k);

			List<WebElement> productsList1 = driver.findElements(By.xpath(productsLocator));
			List<WebElement> productNameList1 = driver.findElements(By.xpath(productsNameLocator));
			List<WebElement> compareButton1 = driver.findElements(By.xpath(compareLocator));

			for (int a = 0; a < productsList1.size(); a++) {
				String name = productNameList1.get(a).getText();
				System.out.println(name);
				if (name.equals(product)) {
					System.out.println(product + " is clicked for comparison");
					compareButton1.get(a).click();
					addToCompareMsg = "Success: You have added " + name + " to your product comparison!";
					break;
				}
			}
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
			DemoLog.LogMsg(2);
			log1.log(Status.PASS, "User clicked on add to compare button successfully");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed to clicked on add to compare button");
		}
		report.flush();
	}

	// verify add to compare message when product is added for comparison
	public static void verifyaddToCompare() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("Verify add to compare message");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "Verifying add to compare message");

			Pattern p = Pattern.compile("^[A-Za-z:\\s]+[A-Za-z0-9'\"\\s]+[.?!]$");
			Matcher m = p.matcher(addToCompareMsg);
			if (m.matches()) {
				System.out.println("product is added for add to compare successfully!");
				Assert.assertTrue(true);
			} else {
				System.out.println("product is not added for comparison");
				Assert.assertTrue(false);
			}

			String path = Screenshot.screenShot(3);
			log1.addScreenCaptureFromPath(path);
			Thread.sleep(3000);
			DemoLog.LogMsg(2);
			log1.log(Status.PASS, "Successfully verified add to compare message");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed to verify add to compare message");
		}
		report.flush();
	}

	// scroll to bottom on result page
	public static void scrollBottom() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("Verify scroll to bottom on result page");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "Verifying scroll to bottom on result page");

			String numberOfSearchResult = Locator.getPropertyData("numberOfSearchResult");
			action.moveToElement(driver.findElement(By.xpath(numberOfSearchResult))).build().perform();

			DemoLog.LogMsg(2);
			log1.log(Status.PASS, "Successfully verified scrolling to bottom on result page");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed to verify scrolling to bottom on result page");
		}
		report.flush();
	}

	// verify number of records on result page
	public static void verifyRecords() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("Verify number of records on result page");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "Verifying number of records on result page");

			numberOfSearchResult = Locator.getPropertyData("numberOfSearchResult");
			String expectedText = driver.findElement(By.xpath(numberOfSearchResult)).getText();
			List<WebElement> product = driver.findElements(By.xpath(productsLocator));
			int size1 = product.size();
			String size = String.valueOf(size1);
			String actualText = "Showing 1 to " + size + " of " + size + " (1 Pages)";

			Assert.assertEquals(actualText, expectedText);
			System.out.println("No. of records on search page is correct");

			String path = Screenshot.screenShot(4);
			log1.addScreenCaptureFromPath(path);
			DemoLog.LogMsg(2);
			log1.log(Status.PASS, "Successfully verified number of records on result page");

		} catch (AssertionError e) {
			System.out.println("No. of records on search page is incorrect");
		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed to verify number of records on result page");
		}
		report.flush();
	}

	// verify product description page when user clicks on a product in result page
	/*public static void verifyProductPage() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("Verify product description page when user clicks on a product");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "Verifying product description page when user clicks on a product");

			String productName = Locator.getExcelData(11, 3, 0);
			WebElement product = driver.findElement(By.partialLinkText(productName));
			String productClicked = product.getText();
			String productPageHeading = driver.findElement(By.xpath("//*[@id='content']/div/div[2]/h1")).getText();
			Assert.assertEquals(productClicked, productPageHeading);
			System.out.println("correct product page is opened");

			String path = Screenshot.screenShot(0);
			log1.addScreenCaptureFromPath(path);

			DemoLog.LogMsg(2);
			log1.log(Status.PASS, "Successfully verified product description page when user clicks on a product");

		} catch (AssertionError e) {
			System.out.println("Incorrect product page is opened");
		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed to verify product description page when user clicks on a product");
		}
		report.flush();
	}*/
	
	public static void goToProductPage(int i, int j, int k) {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("Verify number of records on result page");
		
		String productHeading = Locator.getPropertyData("productHeading");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "Verifying number of records on result page");
			Assert.assertTrue(driver.findElement(By.tagName("h2")).isDisplayed());

			String productName = Locator.getExcelData(i,j,k);
			WebElement product = driver.findElement(By.xpath("//div[@class='description']/h4/a"));
			String productClicked = product.getText();

			product.click();

			String productPageHeading = driver.findElement(By.xpath(productHeading)).getText();
			Assert.assertEquals(productClicked, productPageHeading);
			System.out.println("correct product page is opened");

			String path = Screenshot.screenShot(0);
			log1.addScreenCaptureFromPath(path);;

			DemoLog.LogMsg(2);
			log1.log(Status.PASS, "Successfully verified number of records on result page");

		} catch (AssertionError e) {
			System.out.println("No. of records on search page is incorrect");
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("not working");
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed to verify number of records on result page");
		}
		report.flush();
	}


}
