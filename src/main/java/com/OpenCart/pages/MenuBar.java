package com.OpenCart.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.OpenCart.DemoLogger.DemoLog;
import com.OpenCart.base.Browser;
import com.OpenCart.locators.Locator;
import com.OpenCart.screenshot.Screenshot;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MenuBar extends Browser {
	static String subCategory;

	// choosing a category in navigation bar
	public static void category(int i, int j,int k){
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("choose category");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "choosing category in navigation bar");

			String categoryAddress = Locator.getPropertyData("category");
			List<WebElement> categories = driver.findElements(By.xpath(categoryAddress));
			String category = Locator.getExcelData(i, j, k);
			for (int a = 0; a < categoryAddress.length(); a++) {
				String categoryData = categories.get(a).getText();
				if (categoryData.equals(category)) {
					categories.get(a).click();
					break;
				} // end of if
			} // end of for loop
			Screenshot.screenShot(15);
			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "Successfully choose category in navigation bar");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed choosing category in navigation bar");
		}
		report.flush();
	}

	// choosing a subcategory in navigation bar
	public static void subCategory(int i, int j, int k){
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("choose subcategory");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "choosing subcategory in navigation bar");

			String subCategoryAddress = Locator.getPropertyData("subCategory");
			List<WebElement> subCategories = driver.findElements(By.xpath(subCategoryAddress));
			subCategory = Locator.getExcelData(i, j, k);
			for (int a = 0; a < subCategoryAddress.length(); a++) {
				String subCategoryData = subCategories.get(a).getText();
				if (subCategoryData.equals(subCategory)) {
					subCategories.get(a).click();
					break;
				} // end of if
			} // end of for loop

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "Successfully choose subcategory in navigation bar");
			Screenshot.screenShot(16);

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed choosing subcategory in navigation bar");
		}
		report.flush();
	}

	// verify result page
	public static void verifyNavigatedResultPage() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("verify result page");
		
		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "verifying result page");
			String heading = Locator.getPropertyData("resultPageHeading");
			String text = driver.findElement(By.xpath(heading)).getText();

			if (subCategory.contains(text)) {
				System.out.println("Result page is correct");
				Assert.assertTrue(true);
			} else {
				System.out.println("Result page is not correct");
				Assert.assertTrue(false);
			}

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "Successfully verified result page");
		
		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed verifying result page");
		}
		report.flush();
	}
}
