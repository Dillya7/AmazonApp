package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	private Actions act;
	
	@FindBy (xpath = "//span[contains(text(),'Account & Lists')]")
	private WebElement account;
	
	@FindBy (xpath = "(//span[contains(text(),'Sign in')])[2]")
	private WebElement signIn;
	
	@FindBy (xpath = "//span[contains(text(),'Sign Out')]")
	private WebElement out;	
	
	@FindBy (xpath ="//span[text()='Your Orders']")
	private WebElement order;
	
	@FindBy (xpath = "(//span[contains(text(),'Your Wish List')])[2]")
	private WebElement wish;
	
	
	
	public HomePage(WebDriver driver)
	{
		act = new Actions(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	public void amazonHome() throws InterruptedException 
	{
		act.moveToElement(account).perform();
		Thread.sleep(2000);
		act.moveToElement(signIn).click().build().perform();
		Thread.sleep(2000);
		
	}
	
	public void amazonLogout() throws InterruptedException
	{
		act.moveToElement(account).perform();
		Thread.sleep(2000);
		act.moveToElement(out).click().build().perform();
		Thread.sleep(2000);
		
	}
	
	public void yourOrders() throws InterruptedException 
	{
		act.moveToElement(account).perform();
		Thread.sleep(2000);
		act.moveToElement(order).click().build().perform();
		Thread.sleep(2000);
		
	}
	
	public void wishList() throws InterruptedException
	{
		act.moveToElement(account).perform();
		Thread.sleep(2000);
		act.moveToElement(wish).click().build().perform();
		Thread.sleep(2000);
	}

}
