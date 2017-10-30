package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Lib;
import pom.CaratLaneHomePage;
import pom.CaratLaneSignInPage;
import pom.CaratLaneSignOutPage;
import pom.MyAccountPage;

public class TestSignInPage extends BaseTest{
	
	@Test(priority=3)
	public void testSignInPageIsDisplayed()
	{
		CaratLaneSignInPage clSIP = new CaratLaneSignInPage(driver);
		
		CaratLaneHomePage   clhp = new CaratLaneHomePage(driver);
		clhp.clickAccountLink(driver);
		clSIP.checkSignInPageIsDisplayed(driver);
	
	}
	
		
	
	@Test(priority=4)
	public void testValidSignIn()
	{
		CaratLaneHomePage   clhp = new CaratLaneHomePage(driver);
		//click on my account link
		clhp.clickAccountLink(driver);
		
		MyAccountPage myAccPage = new MyAccountPage(driver);
		
		CaratLaneSignOutPage clSOP = new CaratLaneSignOutPage(driver);
		
		int rc = Lib.rowCount(DATASHEET_PATH, "SignIn");
		
		for(int i=1; i<rc;i++)
		{
			String user = Lib.getCellValue(DATASHEET_PATH, "SignIn", i, 0);
			String pass = Lib.getCellValue(DATASHEET_PATH, "SignIn", i, 1);
		
		CaratLaneSignInPage clSIP = new CaratLaneSignInPage(driver);
		
		
		
		//Enter email
		clSIP.setEmail(driver, user);
		
		//Enter pass
		clSIP.setPassword(pass);
		
		//click on sign in
		clSIP.clickSignInBTN();
		
		
		
		try {
				Thread.sleep(4000);
				//Lib.handlePopup(driver);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Verify My Account Page is displayed
		myAccPage.checkSignoutLinkIsPresent();
		
		//go back to sign in page
		clSOP.clicktoSignInAgain(driver);
		try {
			Thread.sleep(2000);
			//Lib.handlePopup(driver);
		
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		}
	}

}