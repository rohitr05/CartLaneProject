package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.Lib;

public class CaratLaneSignOutPage {
	
	@FindBy(xpath="//a[@class='loginLink success_page_event']")
	private WebElement SignInAgainLink;
	
	public CaratLaneSignOutPage(WebDriver driver) {
	
		PageFactory.initElements(driver, this);
	}
	
	public void clicktoSignInAgain(WebDriver driver)
	{
		Lib.waitMethod(driver, SignInAgainLink);
		SignInAgainLink.click();
	}
	

}
