package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import pom.CaratLaneHomePage;

public class TestCuffLinksSearchPageisDisplayed extends BaseTest {

	
	@Test(priority=2)
	public void testCuffLinksSearchPageisDisplayed()
	{	
		CaratLaneHomePage clHP = new CaratLaneHomePage(driver);
		
		//click on cuff links shopping page
		
		clHP.clickCuffLinksLink(driver);
	}
	
}