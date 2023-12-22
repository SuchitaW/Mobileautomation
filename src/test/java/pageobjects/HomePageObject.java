package pageobjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.cucumber.java.Scenario;

public class HomePageObject {
	
	

	private static final Logger logger= LogManager.getLogger(HomePageObject.class);
	WebDriver driver;
	Scenario scn;
	WebDriverWait wait;
	JavascriptExecutor js;

//============= Locators for WebElements on Landing page============================================//
	
	private By elementSearchBoxElement = By.xpath("//input[@id='search']");
    private By close = By.xpath("//aside[@class='modal-popup customer-popup reg-login modal-slide _inner-scroll _show']//button[@type='button']");

	private By logoImage= By.xpath("//a[@class='logo']//img[@title='Candere']");
	private By prodCatgory= By.xpath("//ul[contains(@class,'top-category-list_')]//li");
	
	
	 private By search_text_box = By.xpath("//input[@id='search']");;
	    private By search_button = By.xpath("//button[@title='Search']//img[@alt='search']");
	    private By nav_link_hamburgr =  By.xpath("//div[@class='btn-navbar list_menu__']");
	  //div[@class='btn-navbar list_menu__']
		private By nav_link_wishlist =  By.xpath("//a[@class='wishlist-custom-icon customer-login-link']");
		private By nav_link_bag =  By.xpath("//a[@class='action showcart']");
		
		private By minilogo =  By.xpath("//a[@class='logo-small']");
//============= Expected Results ====================================================================//
	
	String expCurrentURL= "https://www.candere.com/";
	
//============= Constructor ========================================================================//
	public HomePageObject(WebDriver driver,Scenario scn)
	{
		this.driver= driver;
		this.scn=scn;
	}
	

	//============ 1. Method to validate page URL =======================================================//
	
	//Capture screenshot if test case get passed
	public void capturePassScreenshot(Scenario scn) {
			
			TakesScreenshot srnshot= ((TakesScreenshot)driver);
			byte [] data =srnshot.getScreenshotAs(OutputType.BYTES);
			scn.attach(data, "image/png", "Name of passed step is: "+ scn.getName());
			scn.log("Attach a screenshot as step get passed");	
		}
	
	
	public void validatePageURL()
	{
	driver.get(expCurrentURL);
		scn.log("Browser navigated to url :- " + expCurrentURL);
		logger.info("Browser navigated to url :- " + expCurrentURL);
		
		
		
		//WebDriverWait wait= new WebDriverWait(driver,20);
//		boolean a = wait.until(ExpectedConditions.urlToBe(expCurrentURL));
//		Assert.assertEquals(true,a);
//	    logger.info("validate current URL of page ,so URL is: "+ driver.getCurrentUrl());
	}
	
//============ 2. Method to validate page Title =======================================================//
    public void validatePageTitle(String pageTitle)
    {
    	String actPageTitle= driver.getTitle();
    	Assert.assertEquals(pageTitle, actPageTitle);
        logger.info("Validate title of page, title is:" + actPageTitle);
    }
    
 //============ 3. Method to display a logo =============================================================//
    public void displayLogo()
    {
    	WebElement logo =driver.findElement(logoImage);
    	Assert.assertEquals(true, logo.isDisplayed());
    	logger.info("Display the logo on landing page");
    }
    
//============ 4. Method to fetch logo height =======================================================//   
    public void fetchLogoHeight()
    {
    	WebElement logo =driver.findElement(logoImage);
    	String logoHeight= logo.getAttribute("height");
    	logger.info("Height of logo is: "+ logoHeight);
    	scn.log("Height of logo is: "+ logoHeight);
    }
    
//============ 5. Method to validate logo height =======================================================//   
    public void logoHeightValid(String height)
    {
    	WebElement logo =driver.findElement(logoImage);
    	Assert.assertEquals(height, logo.getAttribute("height"));
    	logger.info("Validate the height of logo");
    	scn.log("Validate the height of logo");
    }
   
//============ 6. Method to fetch logo width =======================================================//   
    public void fetchLogoWidth()
    {
    	WebElement logo =driver.findElement(logoImage);
    	String logoWidth= logo.getAttribute("width");
    	logger.info("Width of logo is: "+ logoWidth);
    	scn.log("Width of logo is: "+ logoWidth);
    }
 
//============ 7. Method to validate logo width =======================================================//   
    public void logoWidthValid(String width)
    {
    	WebElement logo =driver.findElement(logoImage);
    	Assert.assertEquals(width, logo.getAttribute("width"));
    	logger.info("Validate the width of logo");
    	scn.log("Validate the width of logo");
    }
    
    public void SetSearchTextBox() {
		driver.findElement(search_text_box).click();
		logger.info("Clicked on Search Button");
			
	}
//    public void SetSearchTextBox(String text) {
//		//WebDriverWait webDriverWait = new WebDriverWait(driver,20);
//		WebElement elementSearchBox = webDriverWait.until(ExpectedConditions.elementToBeClickable(search_text_box));
//		elementSearchBox.clear();
//		elementSearchBox.sendKeys(text);
//		logger.info("Value entered in search box: " + text);}

    
    
    public void ClickOnminilogo() {
		driver.findElement(minilogo).click();
		logger.info("Clicked on MiniLogo");
			
	}
    
    
    
    
    
	public void ClickOnSearchButton() {
		driver.findElement(search_button).click();
		logger.info("Clicked on Search Button");
			
	}
    
	public void ClickOnHamburger() {
		driver.findElement(nav_link_hamburgr).click();


		logger.info("Clicked on Hamburger");	
	}
	
	
	
	public void ClickOnClose() {
		driver.findElement(close).click();
		logger.info("Clicked on Close");	
	}
	
	
	public void validateCandereLogo() {
		boolean b = driver.findElement(logoImage).isDisplayed();
		Assert.assertEquals("Navigation link logo",true, b);
	}
	public void ClickOnWishlist() {
		driver.findElement(nav_link_wishlist).click();
		logger.info("Clicked on Wishlist");
	}
	public void ClickOnBag() {
		driver.findElement(nav_link_bag).click();
		logger.info("Clicked on Shopping Bag");
		
//		String actPageTitle2= driver.getTitle();
//    	Assert.assertEquals(BagPageTitle, actPageTitle2);
//        logger.info("Validate title of page, title is:" + actPageTitle2);
//        scn.log("Title of the page is: "+ actPageTitle2);
	}
	
	public void validateElementPresentInHeaderSection(String text) throws Exception {
		boolean b=true;

		switch(text.toLowerCase().trim()) {
		case "Hamburger":
			b = driver.findElement(nav_link_hamburgr).isDisplayed();
			break;
		case "Search text box":
			b = driver.findElement(search_text_box).isDisplayed();
			break;
		case "Search Button":
			b = driver.findElement(search_button).isDisplayed();
			break;
		case "Candere logo":
			b = driver.findElement(logoImage).isDisplayed();
			break;
		case "Wishlist	":
			b = driver.findElement(nav_link_wishlist).isDisplayed();
			break;	
		case "Bag":
			b = driver.findElement(nav_link_bag).isDisplayed();
			break;


			
		default:
			//logger.fatal("Header Link Description is  present in the case. Please add link description first.");
			//throw new Exception("Header Link Description is not present in the case. Please add link description first.");
		}

		if (b) {
			logger.info("Header Link is displayed: " + text);
			Assert.assertEquals("Header Link displayed",true, b);
		}else {
			logger.fatal("Header Link is not displayed: " + text);
			Assert.fail("Header Link is not displayed: " + text);
		}	}

	

	 //================================== 8.Method to validate ProductCategoryList ===============================================================//

	    public void setProdCategory()
	    {
	    	List <WebElement> prodCategoryList =driver.findElements(prodCatgory);
	    	Assert.assertEquals(false, prodCategoryList.isEmpty());
	    	logger.info("Display the product category list, size of list is: "+ prodCategoryList.size());
	    	scn.log("Product category is displayed on page with size is: "+ prodCategoryList.size());
	    }

	    public void validateProdCategory(List<String> prodList1)
	    {
	    	List <WebElement> prodCategoryList1 =driver.findElements(prodCatgory);
	    	{
	    		for(int i=0; i< prodCategoryList1.size(); i++)
	    		{
	    			if(prodCategoryList1.get(i).getText().equals(prodList1.get(i).toString()))
	        		{
	        			Assert.assertTrue(true);
	        			logger.info(prodCategoryList1.get(i).getText()+ " is matched with expected "+ prodList1.get(i).toString()+" product name in datatable");
	        		}
	    			else
	    			{
	    				//Assert.fail();
	        			logger.fatal(prodCategoryList1.get(i).getText()+ " is not matched with expected "+ prodList1.get(i).toString()+" product name in datatable");
	    			}
	    		}
	    		logger.info("Validate the product category with expected datatable");
	    		scn.log("Validate the product category with expected datatable");
	    	}
	    }
	  
	    public void sizeOfProdCategory(int prodCount)
	    {
	 	   List <WebElement> prodCategoryList =driver.findElements(prodCatgory);
	 	   Assert.assertEquals(prodCount, prodCategoryList.size());
	 	   logger.info("validate the Size of product category, size is: "+ prodCategoryList.size());
	 	   scn.log("validate the Size of product category, size is: "+ prodCategoryList.size());
	    }
	    
	
	    //================================== 8.Method to validate Signup&Spin! ========================================   
	    
	    public void validateScrollSignUpSpin(){
		    {

		    	js= (JavascriptExecutor)driver;
	            js.executeScript("window.scrollBy(0,1000)", "");
            
	    	//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    	
	    	logger.info("Scroll up to the SignUp and Spin");
  		scn.log("Scroll up to the SignUp and Spin");
		    	
		    
		    	
		    }	
		    } 
	    
		   
		 public void clickOnSignUpSpin() throws Exception{
				    {
				    	
			         WebElement SignUpSpin =driver.findElement(By.xpath("//a[normalize-space()='Sign up & Spin!']"));
			            
			            JavascriptExecutor spin = (JavascriptExecutor) driver;
			            spin .executeScript("arguments[0].click();", SignUpSpin );
			            //SignUpSpin.click();
			            Thread.sleep(5000);
				    	//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				    	logger.info("Clicked on Sign up & Spin! button");
				    	scn.log("Clicked on Sign up & Spin! button");
				    	
				    } 
		    
			    }
	     
			    public void validateSignUpandSpinPageTitle()
			    
			 {
			    	String expected ="Create New Customer Account";
			    	String actPageTitle= driver.getTitle();
			    	
			    	Assert.assertEquals(expected, actPageTitle);
			        logger.info("Validate title of page, title is:" + actPageTitle);
			        scn.log("Title of the page is: "+ actPageTitle);
			       
			    }
		
			    
			    //================================== 8.Method to validate ProductCategoryList ===============================================================//

			    public void setProdCategoryList()
			    {
			    	js= (JavascriptExecutor)driver;
		            js.executeScript("window.scrollBy(0,800)", "");
		            
			    	//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			    	
			    	List <WebElement> prodCategoryList1 =driver.findElements(By.xpath("//p[@class='categories__list--title']"));
			    	Assert.assertEquals(false, prodCategoryList1.isEmpty());
			    	logger.info("Display the product category list, size of list is: "+ prodCategoryList1.size());
			    	scn.log("Product category is displayed on page with size is: "+ prodCategoryList1.size());
			    }

			    public void validateProdCategorylist(List<String> prodList)
			    {
			    	List <WebElement> prodCategoryList1 =driver.findElements(By.xpath("//p[@class='categories__list--title']"));
			    	{
			    		for(int i=0; i< prodCategoryList1.size(); i++)
			    		{
			    			if(prodCategoryList1.get(i).getText().equals(prodList.get(i).toString()))
			        		{
			        			Assert.assertTrue(true);
			        			logger.info(prodCategoryList1.get(i).getText()+ " is matched with expected "+ prodList.get(i).toString()+" product name in datatable");
			        		}
			    			else
			    			{
			    				//Assert.fail();
			        			logger.fatal(prodCategoryList1.get(i).getText()+ " is not matched with expected "+ prodList.get(i).toString()+" product name in datatable");
			    			}
			    		}
			    		logger.info("Validate the product category with expected datatable");
			    		scn.log("Validate the product category with expected datatable");
			    	}
			    }
			  
			    public void clickOnAnyProdCategory()
			    {
			 	   
			    	WebElement Prodcat = driver.findElement(By.xpath("//img[@alt='Gorgeous Bracelets']"));
			    	Prodcat.click();		    	
			    	//WebDriverWait wait = new WebDriverWait(driver, 30);
			    	logger.info("Product Listing page is display");
			    	scn.log("User clicked on a any product category");
			    }	
			    	
			    public void validateProductListPageTitle() {
			    
			    String productlistPageTitle= "500+ Gold Bracelet Designs for Men & Women @ Best Price - Candere by Kalyan Jewellers.";

				//WebDriverWait wait = new WebDriverWait(driver, 30);
				boolean p =wait.until(ExpectedConditions.titleIs(productlistPageTitle));
				Assert.assertEquals(true, p);
				logger.info("Validate product list page with its title, title is: "+ productlistPageTitle);
				scn.log("navigate to product list page , page title is: "+ productlistPageTitle);
			    
			    
			    }	    
			    
			    //================================================@ShowMeMore===========================
			    
			    

			    public void scrolldownShowMeMore() throws Exception
			    {
			 	   
			    	JavascriptExecutor	js= (JavascriptExecutor)driver;
			    	js.executeScript("window.scrollBy(0,2900)", "");

		            logger.info("Scroll down to  the Show Me More");
		    		scn.log("Scroll down to the Show Me More");
		    	//Thread.sleep(5000);
			    }	
			    
			    public void clickOnShowMeMore()
			    {
			    	
			    	WebElement showMeMore = driver.findElement(By.xpath("//a[normalize-space()='Show Me More']"));
			    	((JavascriptExecutor)driver).executeScript("arguments[0].click;", showMeMore);
			    	
			    	//showMeMore.click();
			    	
			    	
			    	logger.info("More Collection page is display");
			    	scn.log("User clicked on Show Me More");
			    	
			    	
			    }	
			    
			    
			    public void validateShowMeMorePageTitle() {
				    
				    String ShowMeMorePageTitle= "Candere Collections | Candere by Kalyan Jewellers";

					//WebDriverWait wait = new WebDriverWait(driver, 30);
					boolean p =wait.until(ExpectedConditions.titleIs(ShowMeMorePageTitle));
					Assert.assertEquals(true, p);
					logger.info("Validate Show Me More page with its title, title is: "+ ShowMeMorePageTitle);
					scn.log("navigate to Show Me More page , page title is: "+ ShowMeMorePageTitle);
				    
				    
				    }
			     
			  //=============================  
			    public void searchProduct(String prodName) {
					


		          WebElement elementSearchBox = driver.findElement(elementSearchBoxElement);
			    	elementSearchBox.sendKeys(prodName);
			    	logger.info("Sent the keys to search box as -> " + prodName);
		    	driver.findElement(search_button).click();
			    	logger.info("Clicked on search button");
		
				}
			    
			    
			    public void ClickOnAddToCart()
			    {
			    
			    	WebElement addtocart = driver.findElement(By.xpath("//button[@id='product-addtocart-button']"));
			    	JavascriptExecutor add = (JavascriptExecutor) driver;
			    	add.executeScript("arguments[0].click();",addtocart  );
			    	
			    	scn.log("Add to cart button is displayed");
			    logger.info("Add to cart button is displayed");
			    
				
			    }
			    

			    public void ClickOnCheckoutSecurely()
			    {
			    
			    	WebElement checkoutSecurely =driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div/div[7]/div[2]/ul/li[1]/div/button"));

			    	JavascriptExecutor checkout = (JavascriptExecutor) driver;
			    	checkout.executeScript("arguments[0].click();", checkoutSecurely );
			    	scn.log("Checkout Securely button is displayed");
			    	logger.info("Checkout Securely button is displayed");
				
			    }
}


