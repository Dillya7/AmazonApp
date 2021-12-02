package UtilityPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass {
	
	public static void screenshot (WebDriver driver) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		File dest = new File("D:\\Vcity\\Automation\\Operations\\Amazon"+timestamp+".JPG");
		FileHandler.copy(src, dest);
	}
	
	public static String excelSheet(int r, int c) throws EncryptedDocumentException, IOException
	{
		String path = "D:\\Vcity\\Automation\\Related_Files\\Book.xlsx";
		FileInputStream f = new FileInputStream(path);
		String data = WorkbookFactory.create(f).getSheet("Velocity").getRow(r).getCell(c).getStringCellValue();
		return data;
	}

}
