package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import generic.IAutoConst;
import generic.Lib;

public class CaratLaneSignInPage {
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="pass")
	private WebElement password;
	
	
	@FindBy(id="send2")
	private WebElement signInBTN;
	
	
	public CaratLaneSignInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public void setEmail(WebDriver driver, String emails) {
		Lib.waitMethod(driver, email);
		email.clear();
		email.sendKeys(emails);
	}


	public void setPassword(String pass) {
		password.clear();
		password.sendKeys(pass);
	}


	public void clickSignInBTN() {
		signInBTN.click();
	}
	
	public void checkSignInPageIsDisplayed(WebDriver driver)
	{
		
		String title = driver.getTitle();
		
		Assert.assertEquals(title, "CaratLane Account");
		
	}
	
	// method for invalid login scenario
	public void verifySignInPage()
	{
		try{
			
		
		if(signInBTN.isDisplayed())
			{
				Reporter.log("Invalid Sign in", true);
				Assert.fail();
			}
		
		}
		catch (Exception e) {
			
			Reporter.log("Sign In Successfull",true);
			
		}
	}

}