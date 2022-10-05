package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import Utils.utility;
import browserConfig.Base;
import pages.HomePage;
import pages.LoginButton;
import pages.LoginPage;
import pages.MyProfilePage;

public class TestNG_FK extends Base {
	
	private WebDriver driver;
	private HomePage homePage;
	private LoginButton loginButton;
	private LoginPage loginPage;
	private MyProfilePage myProfilePage;
	
	int TestID;
	
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@Parameters("browser")
	
	@BeforeTest
	public void launchBrowser(String browserName) {
		
		reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		
//		driver = openChromeBrowser();
		if (browserName.equals("Chrome"))
		{
			driver = openChromeBrowser();
		}
		if (browserName.equals("Edge"))
		{
			driver = openEdgeBrowser();
		}
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	}
	@BeforeClass
	public void createPOMObjects() {
		homePage = new HomePage(driver);
		loginButton = new LoginButton(driver);
		loginPage = new LoginPage(driver);
		myProfilePage = new MyProfilePage(driver);
	}
	@BeforeMethod
	public void loginApp() throws EncryptedDocumentException, IOException, InterruptedException {
		driver.get("https://www.flipkart.com");
		loginPage.sendUserName();
		loginPage.sendPassword();
		loginPage.clickLogin();
		Thread.sleep(3000);
		//loginButton.clickOnLogin();
//		for (int i=0; i<5; i++)
//		{
//		String data =utility.excelData("Flipkart", 4 , 0);
//		loginPage.sendUserName(data);
//		data =utility.excelData("Flipkart", 4 , 1);
//		loginPage.sendPassword(data);
//		loginPage.clickLogin();
//		}
	}
	@Test
	public void verifyUrlPANCardInfo() throws InterruptedException {
		TestID = 121;
		homePage.clickmyProfile();
		Thread.sleep(2000);
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0,1000)");
		driver.navigate().refresh();
		Thread.sleep(2000);
		myProfilePage.clickOnPanCardInfo();
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.flipkart.com/account/pancard");
	}
	@AfterMethod
	public void logOut(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus())
		{
			utility.captureScreenShot(driver, TestID);
		}
		myProfilePage.clickLogoutButton();
	}
	@AfterClass
	public void nullifyPOMObjects() {
		homePage = null;
		loginButton = null;
		loginPage = null;
		myProfilePage = null;
	}
	@AfterTest
	public void quitBrowser() {
		driver.quit();
		driver = null;
		System.gc();
	}

}
