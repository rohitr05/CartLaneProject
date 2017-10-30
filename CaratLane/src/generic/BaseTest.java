package generic;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import java.net.URL;
import java.net.MalformedURLException;

public class BaseTest implements IAutoConst {

	public WebDriver driver;

	static {

		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}

	@Parameters({ "node", "browser" })
	@BeforeMethod
	public void openApplication(String node, String browser) throws MalformedURLException {

		// ChromeOptions options = new ChromeOptions();
		//
		// options.addArguments("--disable-notifications");
		//
		URL system = new URL(node);

		DesiredCapabilities whichBrowser = new DesiredCapabilities();

		whichBrowser.setBrowserName(browser);

		driver = new RemoteWebDriver(system, whichBrowser);

		driver.get(URL);

		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		// driver.manage().window().maximize();
	}

	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if (ITestResult.FAILURE==result.getStatus()) {
			
			Lib.screenShot(driver, result.getName());
			
		} 
		
	}
	
	@AfterMethod
	public void closeApplication() {
		driver.close();
	}

}