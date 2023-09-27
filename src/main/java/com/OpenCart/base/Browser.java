package com.OpenCart.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.OpenCart.DemoLogger.DemoLog;
import com.OpenCart.utils.ReadConfigureProperty;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	public static WebDriver driver;
	public static Actions action;
	public static WebDriverWait wait;

	public static ExtentHtmlReporter HtmlReport = new ExtentHtmlReporter("./reports/ExtentReport1.html");
	public static ExtentReports report = new ExtentReports();

	// WebDriver Setup Selection Method
	public static WebDriver setDriver() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("Open Test");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "Opening the browser");

			String browserChoice = ReadConfigureProperty.fileProperties("browser");
			System.out.println(browserChoice);
			if (browserChoice.equals("chrome")) {
				driver = setChromeDriver();
			} else if (browserChoice.equals("firefox")) {
				driver = setMozillaDriver();
			} else {
				System.out.println("Invalid data...");
			}

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "Browser opened successfully");
			action = new Actions(driver);

		} catch (Exception e) {
			System.out.println("Browser Input error");
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "Browser opening failed");
		}
		report.flush();
		return driver;
	}

	// ChromeDriver Setup Method
	public static WebDriver setChromeDriver() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("open chrome");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "opening the chrome");

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "opened the chrome");

		} catch (Exception e) {
			System.out.println("Chrome not opened");
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "chrome opening failed");
		}
		report.flush();
		return driver;
	}

	// FirefoxDriver Setup Method
	public static WebDriver setMozillaDriver() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("open firefox");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "opening the firefox");

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "opened the firefox");

		} catch (Exception e) {
			System.out.println("firefox not opened");
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "firefox opening failed");
		}
		report.flush();
		return driver;
	}

	// Opening url in browser
	public static void getUrl(String url) {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("open application");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "opening the application");

			driver.get(url);

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "opened the application");

		} catch (Exception e) {
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "application opening failed");
		}
		report.flush();
	}

	// Driver Close Method
	public static void closeBrowser() {
		report.attachReporter(HtmlReport);
		ExtentTest log1 = report.createTest("close browser");

		try {
			DemoLog.LogMsg(2);
			log1.log(Status.INFO, "closing the application");

			driver.quit();

			DemoLog.LogMsg(1);
			log1.log(Status.PASS, "closed the application");

		} catch (Exception e) {
			System.out.println("browser not closed");
			System.out.println(e);
			DemoLog.LogMsg(3);
			log1.log(Status.FAIL, "browser closing failed");
		}
		report.flush();
	}
}
