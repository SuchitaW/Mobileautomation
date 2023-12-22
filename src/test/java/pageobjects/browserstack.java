package pageobjects;
import org.openqa.selenium.By;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class browserstack {
	


		public static final String USERNAME = "suchitatayde_ktgcCp";
		public static final String AUTOMATE_KEY = "JyJqF2eUA9d3XFXiwppS";
		public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	

	public static void main(String[] args) throws Exception  {
		
		DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("browser", "Chrome");
	    caps.setCapability("device", "Samsung Galaxy S10");
	    caps.setCapability("realMobile", "true");
	    caps.setCapability("os_version", "9.0");
	    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
	    //AppiumDriver driver = new AndroidDriver(new URL(URL), caps);
	    driver.get("https://www.candere.com/");

	  //Locating the search box of google
	  		WebElement element = driver.findElement(By.xpath("//div[@class='btn-navbar list_menu__']"));
	          element.click();
	          WebElement login = driver.findElement(By.xpath("//div[@class='sign_up_item']//a[@id='login_menuLink']"));
	          login.click();

//	          WebElement login = driver.findElement(By.xpath("//div[@class='sign_up_item']//a[@id='login_menuLink']"));
//	          login.click();
	          
	          WebElement nameInputFieldElement = driver.findElement(By.xpath("//input[@id='email-login-one']"));
	      	nameInputFieldElement.sendKeys("suchita.tayde@candere.com");
	      	//Thread.sleep(1000);
	      	
	      	WebElement continueButtonElement = driver.findElement(By.xpath("//fieldset[@data-hasrequired='* Required Fields']//div[@class='actions-toolbar form_btn_group']"));
	      	continueButtonElement.click();
	      	//Thread.sleep(1000);
	      	
	      	WebElement otp = driver.findElement(By.xpath("//div[@class='sign_up_item']//a[@id='login_menuLink']"));
	            //otp.sendKeys("123456");
	            //Thread.sleep(1000);
	            WebElement loginButtonElement = driver.findElement(By.xpath("//div[@id='customer-popup-login']//div[@class='third-step-login hide']//button[@name='send']"));
	     	     loginButtonElement.click();
	      	
	    driver.quit();
		}
		
		// TODO Auto-generated method stub

	}


