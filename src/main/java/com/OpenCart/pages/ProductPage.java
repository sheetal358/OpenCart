package com.OpenCart.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.OpenCart.DemoLogger.DemoLog;
import com.OpenCart.base.Browser;
import com.OpenCart.locators.Locator;
import com.OpenCart.screenshot.Screenshot;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class ProductPage extends Browser{
	static String wishListMsg;
	static String addToCompareMsg;
	static String products;
	static String productsName;
	static String wishList;
	static String product;
	static String compare;
	static String compareButton;
	static String successMessage;
	static String addToCart;

	// hover to compare button
	public static void hoverToComparisonButton() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("Hover to comparison button");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "Hovering over the comparison button");
			
			compareButton = Locator.getPropertyData("addToCompareButton");

			WebElement comparisonLink = driver.findElement(By.xpath(compareButton));
			Actions a = new Actions(driver);
			a.moveToElement(comparisonLink);
			
			DemoLog.LogMsg(2);
			log1.log(Status.PASS, "Successfully Hover over the comparison button");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed to hover over the comparison button");
		}
		report.flush();
	}

	//click compare button
	public static void clickComparisonButton(Integer int1) {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("Select data from sortBy dropdown");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "Selecting data from sortBy dropdown");
	
			for(int i=0; i<int1;i++) {
			driver.findElements(By.xpath(compareButton)).get(i).click();
			}
	
			DemoLog.LogMsg(2);
			log1.log(Status.PASS, "Successfully selected data from sortBy dropdown");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed selecting data from sortBy dropdown");
		}
		report.flush();
	}

	//verify the success message for successfully adding product for comparison
	public static void verifySuccessMessage(){
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("verify the success message");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "verifying the success message for product comparison");

			successMessage = driver.findElement(By.cssSelector(".alert-success")).getText();
			System.out.println(successMessage);
			
			Assert.assertTrue(successMessage.contains("Success: You have added"));
			Screenshot.screenShot(17);

			
			DemoLog.LogMsg(2);
			log1.log(Status.PASS, "Successfully verified the success message");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed to verify the success message");
		}
		report.flush();
	}
	
	//navigate to product comparison page
	public static void goToComparisonPage() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("Navigate to comparison page");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "click on product comparison link in success message");

			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("product comparison")));
			driver.findElement(By.partialLinkText("product comparison")).click();
			
			DemoLog.LogMsg(2);
			log1.log(Status.PASS, "Successfully navigated to product comparison link");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed to navigate to product comparison link");
		}
		report.flush();
		
	}

	//verify the heading, url, title of product compare page
	public static void verifyUI() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("verify the heading, url, title of product compare page");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "verifying the heading, url, title of product compare page");

			String heading = driver.findElement(By.xpath("//div[@id=\"content\"]/h1")).getText();
			Assert.assertEquals("Product Comparison",heading);
			Assert.assertTrue(driver.getCurrentUrl().contains("product/compare"));
			Assert.assertTrue(driver.getTitle().equals("Product Comparison"));
			
			DemoLog.LogMsg(2);
			log1.log(Status.PASS, "Successfully verified the heading, url, title of product compare page");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed to verify the heading, url, title of product compare page");
		}
		report.flush();
	}

	//check the addition of duplicate product 
	public static void verifyNoDuplicateProductAdded() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("check the addition of duplicate product");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "checking the addition of duplicate product");

			String productsInComparePage = Locator.getPropertyData("productsInComparePage");
			List<WebElement> products=  driver.findElements(By.xpath(productsInComparePage));
			System.out.println(products.size());

			//[1,2,5,3,1,2] -> [1,2]
			Set<WebElement> s = products.stream().distinct()
            .filter(i -> Collections.frequency(products, i) > 1)
            .collect(Collectors.toSet());
			
			if(s.size()>1) {
				System.out.println("duplicate products available");
			}
			else {
				System.out.println("no duplicate products added");
			}
			
			DemoLog.LogMsg(2);
			log1.log(Status.PASS, "Successfully checked the addition of duplicate product");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed to check the addition of duplicate product");
		}
		report.flush();	
	}

	//click compare button
	public static void clickComparisonButton(int i, int j, int k) {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("click compare button for a product");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "clicking compare button for a product");

			String productName = Locator.getExcelData(i,j,k);			
			driver.findElement(By.xpath("//div[@class='caption']/h4/a[text()='"+productName+"']/../../../div[3]/button[3]")).click();
	
			DemoLog.LogMsg(2);
			log1.log(Status.PASS, "Successfully clicked compare button for a product");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed to click compare button for a product");
		}
		report.flush();
	}

	//select the products to compare
	public static void selectProductToCompare(Integer int1) {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("Select the products to compare");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "Selecting the products to compare");
			
				List<WebElement> products = driver.findElements(By.xpath(compareButton));
				for(int i=0;i<products.size();i++) {
					Thread.sleep(1000);
					products.get(i).click();
					System.out.println(products.get(i).getText());
				}
			
			DemoLog.LogMsg(2);
			log1.log(Status.PASS, "Successfully selected the products to compare");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed to select the products to compare");
		}
		report.flush();
		
	}

	//check the total number of products can be added in compare page
	public static void verifyLimitOfProductsInComparisonPage(Integer int1) {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("check the total number of products can be added in compare page");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "checking the total number of products can be added in compare page");
			
			List<WebElement> products=  driver.findElements(By.xpath("//table/tbody[1]/tr[1]/td/a"));
			int size = products.size();
			
			if(size>int1) {
				System.out.println("more than "+int1+" products can be added");
			}
			else {
				System.out.println("limit to add product in comparison page is "+int1);
			}
			
			DemoLog.LogMsg(2);
			log1.log(Status.PASS, size+" is the limit of products can be added in compare page");
			Screenshot.screenShot(18);

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed to check the limit");
		}
		report.flush();
	}
	//navigate to remove button on product page
	public static void goToRemoveButton() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("navigate to remove button");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "navigating to remove button on product page");
			
			WebElement removeButton = driver.findElement(By.linkText("Remove"));
			action.moveToElement(removeButton).build().perform();
			Assert.assertTrue(driver.findElement(By.linkText("Remove")).isDisplayed());
			
			DemoLog.LogMsg(2);
			log1.log(Status.PASS, "Successfully navigated to remove button on product page");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed to navigate to remove button on product page");
		}
		report.flush();
		
	}

	//click the remove button on product page
	public static void clickRemoveButton() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("click the remove button");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "clicking the remove button for a product");
			
			WebElement removeButton = driver.findElement(By.partialLinkText("Remove"));
			removeButton.click();
			
			DemoLog.LogMsg(2);
			log1.log(Status.PASS, "the product is removed successfully");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed to remove the product");
		}
		report.flush();
		
	}

	//verify the product is removed
	public static void verifyProductRemoved() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("verify the product is removed");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "verifying the product is removed");
			
			String actualMessage = driver.findElement(By.className("alert")).getText();
			
			Assert.assertTrue(actualMessage.contains("Success: You have modified your product comparison!"));
			
			DemoLog.LogMsg(2);
			log1.log(Status.PASS, "the product is removed successfully");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed to remove the product");
		}
		report.flush();
	}

	//navigate to add to cart button
	public static void goToAddButton() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("navigate to add to cart button");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "navigate to add to cart button");
			
			WebElement addButton = driver.findElement(By.xpath(addToCart));
			Actions action = new Actions(driver);
			action.moveToElement(addButton).build().perform();
			
			DemoLog.LogMsg(2);
			log1.log(Status.PASS, "Successfully navigated to add to cart button");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed to navigate to add to cart button");
		}
		report.flush();
		// TODO Auto-generated method stub
		
	}

	//click add to cart button
	public static void clickAddButton() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("check click add to cart button is working");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "checking add to cart button");
			
			addToCart = Locator.getPropertyData("addToCart");
			WebElement addButton = driver.findElement(By.xpath(addToCart));
			Assert.assertTrue(addButton.isDisplayed());
			addButton.click();
			
			DemoLog.LogMsg(2);
			log1.log(Status.PASS, "add to cart button is working");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "add to cart button is not working");
		}
		report.flush();
	}

	//verify product added to cart
	public static void verifyProductAddedToCart() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("Verify product add to cart");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "verifying product is added to cart or not");
			
			String message = "Success: You have added";
			
			String actualMessage = driver.findElement(By.className("alert")).getText();
			
			Assert.assertTrue(actualMessage.contains(message));
			
			DemoLog.LogMsg(2);
			log1.log(Status.PASS, "Product is successfully added to the cart");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed to add product to the cart");
		}
		report.flush();
		
	}

}