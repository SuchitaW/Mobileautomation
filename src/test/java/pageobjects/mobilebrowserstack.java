package pageobjects;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class mobilebrowserstack {
	
	public static final String USERNAME = "suchitatayde_ktgcCp";
	public static final String AUTOMATE_KEY = "JyJqF2eUA9d3XFXiwppS";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		//DesiredCapabilities caps = new DesiredCapabilities();
		//MutableCapabilities capabilities=new 
		MutableCapabilities capabilities = new MutableCapabilities();
		//HashMap<K, V>
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("osVersion", "12.0");
		browserstackOptions.put("deviceName", "Google Pixel 5");
		browserstackOptions.put("local", "false");
		capabilities.setCapability("browserstack.ie.enablePopups", "true");
		//browserstackOptions.put("buildName", build_name);  // CI/CD job or build name
		capabilities.setCapability("bstack:options", browserstackOptions);
		//capabilities.setCapability("bstack:options", browserstackOptions);
		
		
		options.merge(capabilities);
		WebDriver driver = new RemoteWebDriver(new URL(URL), capabilities);
		// Navigating through the URL
		driver.get("https://www.candere.com/");
		//Locating the search box of google
		WebElement element = driver.findElement(By.xpath("//div[@class='btn-navbar list_menu__']"));
        element.click();
        WebElement login = driver.findElement(By.xpath("//div[@class='sign_up_item']//a[@id='login_menuLink']"));
        login.click();

//        WebElement login = driver.findElement(By.xpath("//div[@class='sign_up_item']//a[@id='login_menuLink']"));
//        login.click();
        
        WebElement nameInputFieldElement = driver.findElement(By.xpath("//input[@id='email-login-one']"));
    	nameInputFieldElement.sendKeys("suchita.tayde@candere.com");
    	//Thread.sleep(1000);
    	
    	WebElement continueButtonElement = driver.findElement(By.xpath("//fieldset[@data-hasrequired='* Required Fields']//div[@class='actions-toolbar form_btn_group']"));
    	continueButtonElement.click();
    	//Thread.sleep(1000);
    	
    	WebElement otp = driver.findElement(By.xpath("//div[@class='sign_up_item']//a[@id='login_menuLink']"));
          otp.sendKeys("123456");
          //Thread.sleep(1000);
          WebElement loginButtonElement = driver.findElement(By.xpath("//div[@id='customer-popup-login']//div[@class='third-step-login hide']//button[@name='send']"));
   	     loginButtonElement.click();
    	
        
   	
   	
		System.out.println(driver.getTitle());
		//driver.quit();

	}

}
