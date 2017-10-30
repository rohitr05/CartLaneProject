package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import generic.IAutoConst;
import generic.Lib;

public class CaratLaneHomePage{
	
	
	@FindBy(xpath="//a[.=' My Account']")
	private WebElement myAccountLink;
	
	
	@FindBy(xpath="//SPAN[.='JEWELLERY']")
	private WebElement jewelleryLink; 
	
	@FindBy(xpath="//a[.='Cufflinks']")
	private WebElement cuffLinksLink;
	
 public CaratLaneHomePage(WebDriver driver)
 {
	 PageFactory.initElements(driver, this);
 }

 public void clickAccountLink(WebDriver driver)
 {
	 Lib.waitMethod(driver, myAccountLink);
	 myAccountLink.click();
 }
	
public void verifyHomePage(WebDriver driver) {

/*
	WebDriverWait wait = new WebDriverWait(driver, IAutoConst.ETO);
	
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("__ta_notif_frame_1"));

	String xp = "//div[@class='close']";
	
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xp)));
	
	driver.findElement(By.xpath(xp)).click();*/
	
	String title = driver.getTitle();
	
	Assert.assertEquals(title, "CaratLane A Tanishq Partnership | Best Diwali Offers | Online Jewellery Shopping Store India");
	Reporter.log(title, true);

}


public void clickCuffLinksLink(WebDriver driver) {
	
	WebDriverWait wait = new WebDriverWait(driver, IAutoConst.ETO);
	
	wait.until(ExpectedConditions.visibilityOf(jewelleryLink));
	
	Lib.mouseHover(driver, jewelleryLink);
	
	Lib.waitMethod(driver, cuffLinksLink);
	
	cuffLinksLink.click();
	
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	String title = driver.getTitle();
	Assert.assertEquals(title,"Cufflinks for Men - Men's Cufflinks Designs Online in India");
	Reporter.log(title, true);

}






}
	
	

