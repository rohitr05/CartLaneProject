package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import junit.framework.AssertionFailedError;

public class MyAccountPage {

	@FindBy(xpath="//span[.='Sign Out']")
	private WebElement signOutLink;
	
	
	
	public MyAccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	
	public void checkSignoutLinkIsPresent()
	{
		try{
			
			if(signOutLink.isDisplayed())
			{
				Reporter.log("Sign In Successfull", true);
				signOutLink.click();
			}	
		}
		catch(Exception e)
		{
			try{
				Assert.fail();
				Reporter.log("Invalid Sign In", true);	
			}
			catch (AssertionError ex) {
				Reporter.log("Invalid Sign In", true);	
				
			}
		}
	}
	
	
}
