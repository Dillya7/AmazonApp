package pomPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityPackage.UtilityClass;

public class LoginPage extends UtilityClass {
	
	
	
		
		@FindBy (xpath = "//input[contains(@type,'email')]")
		private WebElement mob;
		
		@FindBy (xpath = "//input[contains(@id,'continue')]")
		private WebElement conti;
		
		@FindBy (xpath = "//input[contains(@type,'password')]")
		private WebElement pass;
		
		@FindBy (xpath = "//input[contains(@id,'signInSubmit')]")
		private WebElement in;
		
		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		public void amazonLogin() throws EncryptedDocumentException, IOException
		{
			mob.sendKeys(excelSheet(1,0));
			conti.click();
			pass.sendKeys(excelSheet(1,1));
			in.click();
		}


}
