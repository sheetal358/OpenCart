package com.OpenCart.pages;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
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

public class Home extends Browser {
	static String imgName;
	static String resultedImgName;
	static String heroImage;
	static String resultedImage;
	static String myAccount;
	static String login;
	static String register;
	static String wishlist;
	static String wishlistHeadinglink;
	static String homeIcon;
	static String baseurl;
	static String footerLink;
	static String headerLink;
	static String prevSlider;
	static String nextSlider;
	static String productThumb;
	static String wishlist_total;

	static int actualProduct = 4;

	// user clicks on login in my account dropdown
	public static void clickMyAccount() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("click on login option in my account dropdown");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "clicking on login option in my account dropdown");

			myAccount = Locator.getPropertyData("myAccount");
			login = Locator.getExcelData(2, 3, 0);

			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(myAccount))));

			driver.findElement(By.xpath(myAccount)).click();
			driver.findElement(By.partialLinkText(login)).click();

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "clicked on login option in my account dropdown");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "clicking on login option in my account failed");
		}
		report.flush();
	}

	// user clicks on register in my account dropdown
	public static void clickRegister() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("click on register option in my account dropdown");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "clicking on register option in my account dropdown");

			myAccount = Locator.getPropertyData("myAccount");
			register = Locator.getExcelData(1, 3, 4);

			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(myAccount))));

			driver.findElement(By.xpath(myAccount)).click();
			driver.findElement(By.partialLinkText(register)).click();

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "clicked on register option in my account dropdown");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "clicking on register option in my account dropdown failed");
		}
		report.flush();
	}

	// user clicks on wishlist in header section
	public static void clickWishList() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("click on wishlist in header section");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "clicking on wishlist in header section");

			wishlist = Locator.getPropertyData("wishlist");
			wishlistHeadinglink = Locator.getPropertyData("wishlistHeading");

			wait = new WebDriverWait(driver, 4);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(wishlist)));

			driver.findElement(By.xpath(wishlist)).click();
			Assert.assertTrue(driver.getCurrentUrl().contains("wishlist"));
			String wishlistHeading = driver.findElement(By.xpath(wishlistHeadinglink)).getText();
			Assert.assertEquals(wishlistHeading, "My Wishlist");

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "clicked on wishlist in header section");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "clicking on wishlist in header section failed");
		}
		report.flush();
	}

	// user clicks on home icon in breadcrumb
	public static void clickHomeIcon(){
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("click on home icon in breadcrumb");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "clicking on home icon in breadcrumb");

			homeIcon = Locator.getPropertyData("breadCrumbHome");

			List<WebElement> ele = driver.findElements(By.xpath(homeIcon));
			for (int i = 0; i < ele.size(); i++) {
				if (i == 0) {
					if (ele.get(i).getAttribute("href").contains("home")) {
						ele.get(i).click();
						break;
					} else {
						System.out.println("not present");
					}

				}
			}

			Assert.assertTrue(driver.getCurrentUrl().contains("home"), "home icon is working");

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "clicked on home icon in breadcrumb");
			Screenshot.screenShot(13);


		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "clicking on home icon in breadcrumb failed");
		}
		report.flush();
	}

	// check for the footer section link is working or not
	public static void checkFooterLinks() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("check footer section links ");

		String url = "";
		HttpURLConnection huc = null;
		int respCode = 200;

		baseurl = Locator.getPropertyData("url");
		footerLink = Locator.getPropertyData("footer");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "checking footer section links ");

			WebElement footer = driver.findElement(By.tagName(footerLink));
			List<WebElement> links = footer.findElements(By.tagName("a"));

			Iterator<WebElement> it = links.iterator();

			while (it.hasNext()) {

				url = it.next().getAttribute("href");
				if (url == null || url.isEmpty()) {
					DemoLog.LogMsg(4);
					log1.log(Status.WARNING, " URL is either not configured for anchor tag or it is empty");
					continue;
				}
				if (!url.startsWith(baseurl)) {
					DemoLog.LogMsg(4);
					log1.log(Status.WARNING, "URL belongs to another domain, skipping it.");
					continue;
				}

				huc = (HttpURLConnection) (new URL(url).openConnection());

				huc.setRequestMethod("HEAD");

				huc.connect();

				respCode = huc.getResponseCode();

				if (respCode >= 400) {
					DemoLog.LogMsg(3);
					log1.log(Status.FAIL, url + " is a broken link");
				} else {
					DemoLog.LogMsg(1);
					log1.log(Status.PASS, url + " is a valid link");
				}

				DemoLog.LogMsg(1);
				log1.log(Status.PASS, "checked footer section links are valid ");
			}

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "some of the footer section links are not valid");
		}
		report.flush();
	}

	// check for the header section link is working or not
	public static void checkHeaderLinks() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("check header section links ");

		String url = "";
		HttpURLConnection huc = null;
		int respCode = 200;

		baseurl = Locator.getPropertyData("url");
		headerLink = Locator.getPropertyData("header");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "checking header section links ");

			WebElement footer = driver.findElement(By.id("top"));
			List<WebElement> links = footer.findElements(By.tagName("a"));
			System.out.println("size:  " + links.size());

			Iterator<WebElement> it = links.iterator();

			while (it.hasNext()) {
				System.out.println(it.next().getAttribute("href"));
				url = it.next().getAttribute("href");
				if (url == null || url.isEmpty()) {

					DemoLog.LogMsg(4);
					log1.log(Status.WARNING, " URL is either not configured for anchor tag or it is empty");
					System.out.println(" URL is either not configured for anchor tag or it is empty");
					continue;

				}
				if (!url.startsWith(baseurl)) {

					DemoLog.LogMsg(4);
					log1.log(Status.WARNING, "URL belongs to another domain, skipping it.");
					System.out.println("URL belongs to another domain, skipping it.");
					continue;

				}

				huc = (HttpURLConnection) (new URL(url).openConnection());
				huc.setRequestMethod("HEAD");
				huc.connect();
				respCode = huc.getResponseCode();

				if (respCode >= 400) {
					DemoLog.LogMsg(3);
					log1.log(Status.FAIL, url + " is a broken link");
					System.out.println("broken link");
				} else {
					DemoLog.LogMsg(1);
					log1.log(Status.PASS, url + " is a valid link");
					System.out.println("valid link");
				}

				DemoLog.LogMsg(1);
				log1.log(Status.PASS, "checked header section links are valid ");
			}

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "some of the header section links are not valid");
		}
		report.flush();
	}

	// check slider button for hero image
	public static void checkHeroImageSlider() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("check hero image slider");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "checking hero image slider");

			prevSlider = Locator.getPropertyData("prevSlider");
			nextSlider = Locator.getPropertyData("nextSlider");

			Assert.assertTrue(driver.findElements(By.className(nextSlider)).get(0).isEnabled());
			Assert.assertTrue(driver.findElements(By.className(prevSlider)).get(0).isEnabled());

			for (int i = 0; i < 2; i++) { // click both slider two times
				driver.findElements(By.className(nextSlider)).get(0).click();
				driver.findElements(By.className(prevSlider)).get(0).click();
			}

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "hero image slider is working");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "hero image slider is not working");
		}
		report.flush();
	}

	// check hero image is clickable
	public static void clickHeroImage() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("check clicking on hero image");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "checking click on hero image");

			heroImage = Locator.getPropertyData("heroImage");

			WebElement img = driver.findElement(By.xpath(heroImage));
			imgName = img.getAttribute("alt");
			img.click();

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "hero image is clickable");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "hero image is not clickable");
		}
		report.flush();
	}

	// check clicking hero image takes to correct product page
	public static void clickHeroImageProductPage() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("check hero image product page");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "checking hero image product page");

			heroImage = Locator.getPropertyData("heroImage");
			resultedImage = Locator.getPropertyData("heroclickedImage");

			resultedImgName = driver.findElement(By.cssSelector(resultedImage)).getAttribute("alt");

			Assert.assertEquals(imgName, resultedImgName,
					"clicking on hero image correctly navigated to correct product");

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "hero image product page is corrected");

		} catch (AssertionError e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "hero image product page is not correct");
		} catch (Exception e) {
			System.out.println(e);
		}
		report.flush();
	}

	// check the accessibility of app logo
	public static void clickAppLogo(){
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("check app logo is clickable and taking to home page");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "checking app logo is clickable");

			String appLogo = Locator.getPropertyData("appLogo");

			wait = new WebDriverWait(driver, 4);
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText(appLogo)));
			
			Assert.assertTrue(driver.findElement(By.linkText(appLogo)).isDisplayed());

			WebElement logo = driver.findElement(By.linkText(appLogo));

			logo.click();

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "app logo is clickable");
			Screenshot.screenShot(14);

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "app logo is not clickable");
		}
		report.flush();
	}

	// navigation to home page
	public static void navigationToHomePage() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("check navigation to home page");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "checking navigation to home page");
			
			System.out.println("urllll "+driver.getCurrentUrl());

			Assert.assertTrue(driver.getCurrentUrl().contains("home"));

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "Successfully reached the home page");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed to reach home page");
		}
		report.flush();
	}

	// navigating to the featured section on home page
	public static void goToFeaturedSection() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("check navigation to featured section on home page");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "checking navigation to featured section on home page");

			action.moveToElement(driver.findElement(By.tagName("h3"))).build().perform();

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "Successfully reached the featured section on home page");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed to reach the featured section on home page");
		}
		report.flush();

	}

	// check for the availability of hero image on home page
	public static void checkHeroImage() {

		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("check the availability of hero image on home page");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "checking the availability of hero image on home page");

			heroImage = Locator.getPropertyData("heroImage");
			int size = driver.findElements(By.xpath(heroImage)).size();
			for (int i = 0; i < size; i++) {
				if (i == 1) {
					Assert.assertTrue(driver.findElements(By.xpath(heroImage)).get(i).isDisplayed());
					break;
				}
			}

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "Successfully checked the availability of hero image on home page");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed to check the availability of hero image on home page");
		}
		report.flush();

	}

	// go down to the partner section on home page and check for the availability
	public static void goToPartnerSection() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("check the navigation to partner section availability on home page");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "checking for the partner section availability on home page");

			String partnerSectionArea = Locator.getPropertyData("partnerSection");

			WebElement partnerSection = driver.findElement(By.cssSelector(partnerSectionArea));
			action.moveToElement(partnerSection).build().perform();
			Assert.assertTrue(partnerSection.isDisplayed());

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "Successfully partner section is available on home page");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed to check partner section availability on home page");
		}
		report.flush();

	}

	// check for the partner section image slider on home page
	public static void checkPartnerSectionImageSlider() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("check and click for the partner section image slider on home page");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "checking and clicking for the partner section image slider on home page");

			prevSlider = Locator.getPropertyData("prevSlider");
			nextSlider = Locator.getPropertyData("nextSlider");

			WebElement partnerSectionPrevSlider = driver.findElements(By.className(prevSlider)).get(1);
			WebElement partnerSectionNextSlider = driver.findElements(By.className(nextSlider)).get(1);

			System.out.println(partnerSectionPrevSlider + " : " + partnerSectionNextSlider);
			for (int i = 0; i < 2; i++) {
				partnerSectionPrevSlider.click();
				partnerSectionNextSlider.click();
			}

			Assert.assertTrue(driver.findElement(By.className(nextSlider)).isEnabled());
			Assert.assertTrue(driver.findElement(By.className(prevSlider)).isEnabled());

			for (int i = 0; i < 2; i++) {
				driver.findElement(By.className(nextSlider)).click();
				driver.findElement(By.className(prevSlider)).click();

			}

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "partner section image slider on home page is successfully working");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed to check the partner section image slider on home page working");
		}
		report.flush();

	}

	// click wishlist option in header section
	public static void goToWishlistSection() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("click the wishlist option in header section");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "clicking the wishlist option in header section");

			wishlist_total = Locator.getPropertyData("wishlist_total");
			driver.findElement(By.id(wishlist_total)).click();

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "Successfully clicked the wishlist option in header section");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed to click the wishlist option in header section");
		}
		report.flush();
	}

	// check for the footer section links
	public static void goToFooterSection() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("check the footer section links");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "checking the footer section links");

			footerLink = Locator.getPropertyData("footer");
			WebElement footer = driver.findElement(By.tagName(footerLink));
			action.moveToElement(footer).build().perform();

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "Successfully checked the footer section links");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed to check the footer section links");
		}
		report.flush();
	}

	// check for the total featured product
	public static void verifyTotalFeaturedProduct() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("check for total featured product at home page");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "checking for total featured product at home page");

			productThumb = Locator.getPropertyData("featuredProducts");

			List<WebElement> products = driver.findElements(By.className(productThumb));
			int expectedProduct = products.size();

			Assert.assertEquals(expectedProduct, actualProduct);

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "Successfully checked for total featured product at home page");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Failed to check the total featured product at home page");
		}
		report.flush();

	}
}
