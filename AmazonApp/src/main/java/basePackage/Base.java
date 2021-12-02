package basePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public WebDriver openChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Vcity\\Automation\\Related_Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}

	public WebDriver openFirefoxBrowser()
	{
		System.setProperty("webdriver.gecko.driver", "D:\\Vcity\\Automation\\Related_Files\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
}
