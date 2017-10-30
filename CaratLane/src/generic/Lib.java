package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Lib {
	
	//method for Handling Advertisement pop-up
	
	public static void handlePopup(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, IAutoConst.ETO);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("__ta_notif_frame_1"));

		String xp = "//div[@class='close']";
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xp)));
		
		driver.findElement(By.xpath(xp)).click();
	}
	
	
	//Method for scrolling to specific element
	
	public static void scroll(WebDriver driver, WebElement element)
	{
	 int x = element.getLocation().getX();
	 int y = element.getLocation().getY();
	 JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy("+x+","+y+")");
	 
	}
	
	//Method for taking screenshot
	
	public static void screenShot(WebDriver driver, String screenshot) 
	{
		try {
			TakesScreenshot scr = (TakesScreenshot)driver;
			File srcFile = scr.getScreenshotAs(OutputType.FILE);
			File destFile = new File(IAutoConst.IMAGE_PATH+Lib.fileNameProcess(driver,screenshot));
			FileUtils.copyFile(srcFile, destFile);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	
	//Method for Screenshot Name
		public static String fileNameProcess(WebDriver driver,String fname)
		{
			
			String screenshotName = fname;
			
			screenshotName = screenshotName + ".png";
			
			return screenshotName;
			
		}
	
				
		
	//Method for reading config Property File
	
	public static String readProperties(String path, String name)
	{
		String value = "";
		Properties p = new Properties();
		try {
			p.load(new FileInputStream(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		value = p.getProperty(name);
		
		return value;
	}

	//Method for MouseHover
	public static void mouseHover(WebDriver driver, WebElement element)
	{
		WebDriverWait wait1 = new WebDriverWait(driver, IAutoConst.ETO);
		Actions actions = new Actions(driver); 
		if(element.isEnabled())
		actions.moveToElement(element).perform();
		else
		wait1.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	//Method for wait 
	public static void waitMethod(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, IAutoConst.ETO);
		wait.until(ExpectedConditions.elementToBeClickable(element));	
			
	}
	
	//Method for getting cell value from Excel Sheet
	public static String getCellValue(String dataSheetPath, String sheetName, int row, int cell)
	{
		String value = "";
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(dataSheetPath));
			value = wb.getSheet(sheetName).getRow(row).getCell(cell).toString();
		
		
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return value;
			
	}
	
	
	//Method for getting row count
	public static int rowCount(String dataSheetPath, String sheetName)
	{
		int rCount = 0;
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(dataSheetPath));
			rCount = wb.getSheet(sheetName).getLastRowNum();
			
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rCount;
	}
	
	
	
}