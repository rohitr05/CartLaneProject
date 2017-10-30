package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import pom.CaratLaneHomePage;

public class TestHomePageIsDisplayed extends BaseTest {

	@Test(priority=1)
	public void testHomePageIsDisplayed()
	{
		CaratLaneHomePage clHP = new CaratLaneHomePage(driver);
		
		//Verify Home page title 
		clHP.verifyHomePage(driver);
				
	}
	
	
}