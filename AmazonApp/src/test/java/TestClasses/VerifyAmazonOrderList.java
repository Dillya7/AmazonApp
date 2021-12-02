package TestClasses;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import UtilityPackage.UtilityClass;
import basePackage.Base;
import pomPackage.HomePage;
import pomPackage.LoginPage;

public class VerifyAmazonOrderList extends Base {
	
	WebDriver driver;
	HomePage homePage;
	LoginPage loginPage;
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser)
	{
		if(browser.equals("Chrome"))
		{
			driver = openChromeBrowser();
		}
//		if(browser.equals("Firefox"))
//		{
//			driver = openFirefoxBrowser();
//		}
		
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@BeforeClass
	public void launchApplication() throws IOException, InterruptedException
	{			
		driver.get("https://www.amazon.in/");
		UtilityClass.screenshot(driver);
		
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		homePage.amazonHome();
		UtilityClass.screenshot(driver);
	}
	
	@BeforeMethod
	public void verifyLoginToAmazon() throws IOException, EncryptedDocumentException, InterruptedException 
	{
		loginPage.amazonLogin();
		UtilityClass.screenshot(driver);
	} 
	
	@Test
	public void verifyYourOrders() throws InterruptedException, IOException
	{
		homePage.yourOrders();
		UtilityClass.screenshot(driver);
	}
	
	@Test
	public void verifyWishListOfAmazon() throws IOException, InterruptedException
	{		
		homePage.wishList();
		UtilityClass.screenshot(driver);
	}
	
	@AfterMethod
	public void verifyLogOutFromAmazon() throws IOException, InterruptedException
	{
		homePage.amazonLogout();
		UtilityClass.screenshot(driver);
	}
	
	@AfterClass
	public void afterClass()

	{
		homePage = null;
		loginPage = null;
		
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
		driver = null;
		System.gc();  // garbage collector
	}

}
