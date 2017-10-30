package generic;

public interface IAutoConst {

	
	String CHROME_KEY = "webdriver.chrome.driver";
	
	String CHROME_VALUE = "./driver/chromedriver";
	
	String GECKO_KEY = "webdriver.gecko.driver";
	
	String GECKO_VALUE = "./driver/geckodriver";
		
	String CONFIG_PATH = "./config.properties";
	
	String DATASHEET_PATH = "./data/CaratLaneDataSheet.xlsx";
	
	String URL = Lib.readProperties(CONFIG_PATH, "URL");
	
	int ITO = Integer.parseInt(Lib.readProperties(CONFIG_PATH, "impWait"));
	
	int ETO = Integer.parseInt(Lib.readProperties(CONFIG_PATH, "expWait"));
	
	String IMAGE_PATH = Lib.readProperties(CONFIG_PATH,"imgPath");
	
	
	
}