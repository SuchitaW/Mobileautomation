package Base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class WebDriverManager {

	private static final Logger logger= LogManager.getLogger(WebDriverManager.class);
	private static WebDriver driver= null;
	
//====================== Method to get WebDriver for Browser =========================================//
	public static WebDriver getWebDriverForBrowser(String browser) throws MalformedURLException
	{
		//AndroidDriver driver;
//		ChromeOptions options1=new ChromeOptions();
//		options1.addArguments("disable-notifications"); 
		
		AppiumDriverLocalService service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Suchita\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		
		
		switch(browser.toLowerCase())
		{
		case "chrome":
			ChromeOptions options1=new ChromeOptions();
		    options1.addArguments("disable-notifications");
			
		    
		    
		    
			UiAutomator2Options options = new UiAutomator2Options();
			options.setDeviceName("Pixel XL API 27");
			options.setChromedriverExecutable("C:\\Users\\Suchita\\eclipse-workspace\\CandereByKalayanJewellerMobileTesting\\chromedriver.exe");//
			options.setCapability("platformName", "ANDROID");
			options.setCapability("browserName", "Chrome");
			options.autoGrantPermissions();
			options.setCapability(ChromeOptions.CAPABILITY, options1);
			//options.SetCapability("autoAcceptAlerts", true);
	//options.setCapability("autoAcceptAlerts", true);

			 driver= new AndroidDriver( new URL("http://127.0.0.1:4723"), options);
			
			
			
			
			
			
			//WebDriverManager.chromedriver().setup();
			//driver= new ChromeDriver(options);
			logger.info("Chrome browser invoked");
			break;
		case "firefox":
//			WebDriverManager.firefoxdriver().setup();
//			driver= new FirefoxDriver();
			logger.info("Firefox browser invoked");
			break;
		case "edge":
//			driver= new FirefoxDriver();
//			logger.info("Edge browser invoked");
			break;
		case "headless":
//			ChromeOptions option= new ChromeOptions();
//			option.addArguments("headless");
//			driver= new ChromeDriver(option);
			logger.info("Headless chrome browser invoked");
		default:
			logger.fatal("No such browser is implemented, browser name is: "+ browser);
		}
		
	//.get("https://www.candere.com/");
		//driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		logger.info("browser window maximized and set timeout is 20 second");
		return driver;
	}
	
//=================== 1. Method to navigate to URL =======================================================//
	public static void navigateToURL(String url)
	{
		//driver.manage().deleteAllCookies();
		driver.get(url);
		logger.info("navigate to url");
		
	}

//===================== 2. Method to quit the browser ====================================================//
	public static void quitTheBrowser()
	{
		driver.quit();
		logger.info("Quit the browser");
	}

//===================== 3. Method to switch to new window ===============================================//
	public static void switchToNewWindow()
	{
		//1.using Set
		Set <String> set= driver.getWindowHandles();
		Iterator <String> itr= set.iterator();
		itr.next();
		String newWindowId =itr.next();
		driver.switchTo().window(newWindowId);
        //2.Using ArrayList
//		ArrayList <String> arr= new ArrayList<String> (driver.getWindowHandles());
//		String childWindow=	arr.get(1);
//		driver.switchTo().window(childWindow);
		logger.info("Switch to new Window, its id is: "+ newWindowId);
	}

//====================== Method to get desired browser name =============================================//
	public static String getBrowserName()
	{
		String defaultBrowser= "chrome";                            //Set chrome as default browser
		String browserSentFromCmd= System.getProperty("chrome");  //Get browser name from command line
		if(browserSentFromCmd==null)
		{
			return defaultBrowser;
		}
		else 
		{
			return browserSentFromCmd;
		}
	}
//=======================================================================================================//


}

