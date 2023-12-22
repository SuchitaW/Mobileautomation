package stepdef;

import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.WebDriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.FooterSectionObjects;
import pageobjects.HomePageObject;

public class StepDef {
	
	

	private static final Logger logger = LogManager.getLogger(StepDef.class);
	WebDriver driver;

	WebDriverWait wait;
	JavascriptExecutor js;
	Scenario scn;
	String base_url = "https://www.candere.com  ";
	
	

//============== Declare object reference of pageObjects classes =============================//
	
	
	HomePageObject homePageObject;

	FooterSectionObjects footerPageObject;
//	SignUpPageObject signUpPageObject;
//	HeaderSectionObjects headerObject;
//	ProductListingPageObject productListingObject;
//	ProdductDescPageObjects productDescObject;
//	PaymentPageObjects paymentobject;
//	ShippingPageObject shippingobject;
//	MyAccountSectionObjects myaccountObject;
	
	//CartPageObjects cartobject;
//====================== Before Hook =========================================================//	
	@Before
	public void setUp(Scenario scn) throws MalformedURLException
	{
		this.scn=scn;

		//Get the desired browser to be invoked
		String browserName= WebDriverManager.getBrowserName();
		driver=WebDriverManager.getWebDriverForBrowser(browserName); 
		
		scn.log("Browser get invoked");

		//Initialize object of page objects classes 
		 homePageObject= new HomePageObject(driver, scn);

     footerPageObject=new FooterSectionObjects(driver, scn);
//		 signUpPageObject= new SignUpPageObject(driver, scn);
//		 headerObject= new HeaderSectionObjects(driver, scn);
//		 productListingObject =new ProductListingPageObject(driver, scn);
//		 productDescObject=new ProdductDescPageObjects(driver, scn);
//		 myaccountObject=new MyAccountSectionObjects(driver,scn);
//		 paymentobject=new PaymentPageObjects(driver, scn);
//	     shippingobject=new ShippingPageObject(driver, scn);
//	     cartobject=new CartPageObjects(driver, scn);
	      
	}

//====================== After Hook =========================================================//
	
	@After(order=2)
	
	//Capture screenshot if test case get failed
	
	public void captureScreenshot(Scenario scn)
	{
		if(scn.isFailed())
		{
			TakesScreenshot srnshot= ((TakesScreenshot)driver);
			byte [] data =srnshot.getScreenshotAs(OutputType.BYTES);
			scn.attach(data, "image/png", "Name of failed step is: "+ scn.getName());
			scn.log("Attach a screenshot as step get failed");
		}
		else
		{
			scn.log("Test case get passed, no screenshot is captured");
		}
	}
	
	@After(order=1)
	//Quit the browser
	public void tearDown(Scenario scn)
	{
		WebDriverManager.quitTheBrowser();
		scn.log("Browser is quit");
	}
	
	
	
	
//====================== Background ================================================//
	@Given("User navigate to URL and open the landing page")
	public void user_navigate_to_url_and_open_the_landing_page() {
		WebDriverManager.navigateToURL(base_url);
		scn.log("User navigated to the landing page of the application");
	    }

//===================== Scenarios =================================================//

	@When("User is on landing page")
	public void user_is_on_landing_page() {
		
		Assert.assertEquals(true, driver.getCurrentUrl().contains("candere"));
		scn.log("Application url contains :- candere");
		logger.info("Application url contains :- candere");
//		logger.info("User is on landing page after navigating to base URL");
//	    scn.log("User is on landing page after navigating to base URL");
	}
	@Then("Validate current URL of landing page with expected URL")
	public void validate_current_url_of_landing_page_with_expected_url() {
		 homePageObject.validatePageURL();
		 scn.log("Validate current URL is: "+ driver.getCurrentUrl());
	}
	
	@Then("Validate title of landing page with expected title as {string}")
	public void validate_title_of_landing_page_with_expected_title_as(String titleOfPage) {
		homePageObject.validatePageTitle(titleOfPage);
		scn.log("Validate page title is: "+ driver.getTitle());
	}
		
	@Then("User see the logo of application")
	public void user_see_the_logo_of_application() {
		homePageObject.displayLogo();
		scn.log("Display the application logo on landing page");
	}
	
	@When("fetch the height of logo")
	public void fetch_the_height_of_logo() {
		homePageObject.fetchLogoHeight();
	}

	@Then("Height of logo should be {string}")
	public void height_of_logo_should_be(String height) {
		homePageObject.logoHeightValid(height);
	}
		
	@When("fetch the width of logo")
	public void fetch_the_width_of_logo() {
		 
		homePageObject.fetchLogoWidth();
		
	}

	@Then("Width of logo should be {string}")
	public void width_of_logo_should_be(String width) {
		homePageObject.logoWidthValid(width);
	}


@When("User validate all headerlink are clickable or not")
public void user_validate_all_headerlink_are_clickable_or_not() throws Exception {
	
	homePageObject.SetSearchTextBox();
	Thread.sleep(1000);
	homePageObject.ClickOnSearchButton();
	Thread.sleep(1000);
	homePageObject.validateCandereLogo();
	Thread.sleep(1000);
	homePageObject.ClickOnBag();
	Thread.sleep(1000);
	homePageObject.ClickOnminilogo();
	Thread.sleep(1000);
	homePageObject.ClickOnWishlist();
	Thread.sleep(2000);
	homePageObject.ClickOnClose();
	homePageObject.ClickOnHamburger();
	Thread.sleep(2000);
	




   
}

@Then("Below header Links are displayed")
public void below_header_links_are_displayed(List<String> list) throws Exception {
	for (int i=0;i<list.size();i++) {
		homePageObject.validateElementPresentInHeaderSection(list.get(i));	
		
}}
	


//========================================@ProductCategoryList===============================


@When("User see the product category")
public void user_see_the_product_category() {
 homePageObject.setProdCategory();
}

@Then("Validate product category as per expected product category listed below")
public void validate_product_category_as_per_expected_product_category_listed_below(List<String> prodList1) {
  homePageObject.validateProdCategory(prodList1);


}

@Then("Size of product category should be {int}")
public void size_of_product_category_should_be(Integer prodCatCount) {
  homePageObject.sizeOfProdCategory(prodCatCount);
}


//===============================Signup&Spin!=======================================================

@When("User scroll down to Sign up & Spin!")
public void user_scroll_down_to_sign_up_spin() {
  homePageObject.validateScrollSignUpSpin();
}

@When("User click on Sign up & Spin button")
public void user_click_on_sign_up_spin_button() throws Exception {
  homePageObject.clickOnSignUpSpin();
  //Thread.sleep(7000);
}
@Then("User are able to see the Sign Up form")
public void user_are_able_to_see_the_sign_up_form() {
 homePageObject.validateSignUpandSpinPageTitle();
 
 homePageObject.capturePassScreenshot(scn);
}
//==================================Signup=====================================



@When("User click on  hambugericon from home page")
public void user_click_on_hambugericon_from_home_page() {

homePageObject.ClickOnHamburger();
}


@When("User click on SignUp")
public void user_click_on_sign_up() {
	WebElement signup = driver.findElement(By.xpath("//div[@class='sign_up_item']//a[@id='register_menuLink']"));
    signup.click();
}
@When("User enters  {string}  and  {string} and {string}")
public void user_enters_and_and(String name, String emailid, String mobileno) throws Exception {
	WebElement nameInputFieldElement = driver.findElement(By.xpath("//input[@id='firstname']"));
	nameInputFieldElement.sendKeys(name);
	((AndroidDriver) driver).hideKeyboard();

	WebElement emailIdInputFieldElement = driver.findElement(By.xpath("//input[@id='popup-email_address']"));
	emailIdInputFieldElement.sendKeys(emailid);
	((AndroidDriver) driver).hideKeyboard();
	WebElement mobilenoInputFieldElement = driver.findElement(By.xpath("//input[@id='phone']"));
	mobilenoInputFieldElement.sendKeys(mobileno);
	//((AndroidDriver) driver).hideKeyboard();
	
	Thread.sleep(1000);

}
@When("User click on Send Otp")
public void user_click_on_send_otp() throws Exception {
	WebElement sendotp = driver.findElement(By.xpath("//form[@id='customer-popup-form-register']//div[@class='actions-toolbar form_btn_group']/button"));
	
	JavascriptExecutor sendotp1 = (JavascriptExecutor) driver;
	sendotp1.executeScript("arguments[0].click();",sendotp  );
	
	//sendotp.click();
	 Thread.sleep(4000);
	scn.log("Otp send successful");
	logger.info("Otp send successful");
}


@When("User enters {string} Click on Verify Otp & Register")
public void user_enters_click_on_verify_otp_register(String otp1) throws Exception {
	WebElement Sendotp = driver.findElement(By.xpath("//div[@id='registration_verifyotp_form_mobile']//input[@name='new_otp']"));
	Sendotp.sendKeys(otp1);
    Thread.sleep(4000);
	
	WebElement verifyotp1 = driver.findElement(By.xpath("//div[@id='registration_verifyotp_form_mobile']//button[@name='send']"));
	
	JavascriptExecutor otp = (JavascriptExecutor) driver;
   otp.executeScript("arguments[0].click();",verifyotp1  );
	Thread.sleep(25000);
}


@When("User enter {string}")
public void user_enter_otp1 (String otp1) throws Exception {
	WebElement sendotp = driver.findElement(By.xpath("//div[@id='registration_verifyotp_form_mobile']//input[@name='new_otp']"));
	sendotp.sendKeys(otp1);
	Thread.sleep(4000);
	
}
@When("Click on Verify Otp & Register")
public void click_on_verify_otp_register() throws Exception {
	//Thread.sleep(1000);
	WebElement verifyotp = driver.findElement(By.xpath("//div[@id='registration_verifyotp_form_mobile']//button[@name='send']"));
	verifyotp.click();
	Thread.sleep(20000);
}
@Then("User successfully redirected to {string}")
public void user_successfully_redirected_to(String string) throws Exception {
	 homePageObject.ClickOnHamburger();
	 Thread.sleep(3000);
	homePageObject.capturePassScreenshot(scn);
	
	

}

//========================Login==========================================================
@When("User click on  Log In")
public void user_click_on_log_in() {
	 WebElement login = driver.findElement(By.xpath("//div[@class='sign_up_item']//a[@id='login_menuLink']"));
     login.click();
}


@When("User enters {string}")
public void user_enters(String Emailidmobileno) {
	WebElement nameInputFieldElement = driver.findElement(By.xpath("//input[@id='email-login-one']"));
	nameInputFieldElement.sendKeys(Emailidmobileno);
	((AndroidDriver) driver).hideKeyboard();
}


@When("User click on continue button")
public void user_click_on_continue_button() throws Exception {
	WebElement continueButtonElement = driver.findElement(By.xpath("//button[@id='send2-login-one']"));
	continueButtonElement.click();
	Thread.sleep(5000);
	
}

@When("User enters {string} and click on login")
public void user_enters_and_click_on_login(String otp) throws Exception {
	WebElement loginotp= driver.findElement(By.xpath("//div[@id='customer-popup-login']//input[@name='new_otp']"));
	loginotp.sendKeys(otp);
	((AndroidDriver) driver).hideKeyboard();
	Thread.sleep(1000);
	WebElement login = driver.findElement(By.xpath("//*[@id='customer-popup-login-form-three']/fieldset/div[3]/button"));
   
	JavascriptExecutor net = (JavascriptExecutor) driver;
	net.executeScript("arguments[0].click();",login  );

   
   Thread.sleep(3000);
}


@Then("User successfully redirected to homepage {string}")
public void user_successfully_redirected_to_homepage(String string) throws Exception {
	 
	 //Thread.sleep(10000);
	 js= (JavascriptExecutor)driver;
     js.executeScript("window.scrollBy(0,-1000)", "");
 
	 homePageObject.ClickOnHamburger();
	 Thread.sleep(3000);	
	 
	 homePageObject.capturePassScreenshot(scn);
}

//=============================== @LoginUsingGoogle=====================


@When("User click on Login Using Google")
public void user_click_on_login_using_google() throws Exception {
	  WebElement logingoogle =driver.findElement(By.xpath("//*[@id=\"customer-popup-login\"]/div[1]/div[3]/div[1]/div/div[2]"));
     logingoogle.click();
     
     Thread.sleep(3000);
}


@When("User enters Emailid or mobileno ,password and click on next button")
public void user_enters_emailid_or_mobileno_password_and_click_on_next_button() throws Exception {
	Set<String> handles = driver.getWindowHandles(); // get all the open windows
	Iterator<String> it = handles.iterator(); // get the iterator to iterate the elements in set
	String original1 = it.next();// gives the parent window id
	String childwindow = it.next();// gives the child window id

	driver.switchTo().window(childwindow); // switch to product Descp
	
	
	WebElement username= driver.findElement(By.xpath("//input[@id='identifierId']"));
	username.clear();
	username.sendKeys("suchita.tayde@candere.com");
	((AndroidDriver) driver).hideKeyboard();
	WebElement next =driver.findElement(By.xpath("//*[@id='identifierNext']"));
  	next.click();
  	logger.info("Click on the Next Button");
  	scn.log("Click on the Next Button");
		
	
	  Thread.sleep(2000);
	WebElement p = driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input"));
	p.sendKeys("Suchita@11");
	((AndroidDriver) driver).hideKeyboard();
	
	WebElement b = driver.findElement(By.xpath("//div[@id='passwordNext']//div[@class='VfPpkd-dgl2Hf-ppHlrf-sM5MNb']"));
		      b.click();
		      Thread.sleep(25000);
}
@Then("User successfully redirected to homepage")
public void user_successfully_redirected_to_homepage() throws Exception {
	WebElement usericon = driver.findElement(By.xpath("//div[@class='btn-navbar list_menu__']"));
  usericon.click();
    Thread.sleep(10000);

	//homePageObject.ClickOnHamburger();
		 //Thread.sleep(3000);	
		 
		 homePageObject.capturePassScreenshot(scn);

}

///==========================================



@When("User search for the  {string}")
public void user_search_for_the(String prodName) throws Exception {
	 Thread.sleep(4000);
	homePageObject.searchProduct(prodName);
    Thread.sleep(4000);
}


@When("choose to buy the first item in list")
public void choose_to_buy_the_first_item_in_list() throws Exception {
	
	Thread.sleep(3000);
	List<WebElement> firstProd = driver.findElements(By.xpath("//*[@id=\"amasty-shopby-product-list\"]/div[4]/ol/li"));
	firstProd.get(1).click();
	 Thread.sleep(3000);   
	 logger.info("Clicked on First product link");
	
	scn.log("Clicked on First product link");
//	
//	Set<String> handles = driver.getWindowHandles(); // get all the open windows
//	Iterator<String> it = handles.iterator(); // get the iterator to iterate the elements in set
//	String original = it.next();// gives the parent window id
//	String prodDescp = it.next();// gives the child window id
//
//	driver.switchTo().window(prodDescp); // switch to product Descp
//
//    logger.info("driver is switched back to prodDescp window");
//	
}
@When("Add first product to the shopping cart")
public void add_first_product_to_the_shopping_cart() {
homePageObject.ClickOnAddToCart();
}
@When("User click on Checkout Securely")
public void user_click_on_checkout_securely() throws Exception {
	Thread.sleep(2000);
homePageObject.ClickOnCheckoutSecurely();

Thread.sleep(2000);
}

@When("User are able to see the signup and login popup and click on signup")
public void user_are_able_to_see_the_signup_and_login_popup_and_click_on_signup() {
	WebElement  signupcheckout = driver.findElement(By.xpath("//span[normalize-space()='Sign up']"));
	 signupcheckout.click();

}
@When("Shipping page is open then user fill all details {string}  and  {string} and {string} and {string}  and  click on continue")
public void shipping_page_is_open_then_user_fill_all_details_and_and_and_and_click_on_continue(String lastname, String mobile, String zip, String flat) throws Exception {
	Thread.sleep(10000);
	WebElement Lastname =driver.findElement(By.xpath("//div[@name='billingAddresscheckmo.lastname']//div[@class='control']/input[1]"));
	Lastname.sendKeys(lastname);
	
	WebElement MobileNumber =driver.findElement(By.xpath("//div[@name='billingAddresscheckmo.telephone']//div[@class='control']/input"));
	MobileNumber.sendKeys(mobile);
	
	WebElement ZipPostalCode =driver.findElement(By.xpath("//div[@name='billingAddresscheckmo.postcode']//div[@class='control']/input"));
	ZipPostalCode .sendKeys(zip);
	
	Thread.sleep(3000);
	//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	WebElement Flat =driver.findElement(By.xpath("//div[@name='billingAddresscheckmo.street.0']//div[@class='control']/input"));
	Flat .sendKeys(flat );
	
	
	Thread.sleep(5000);
}
@When("User see the payment page and click on UPI")
public void user_see_the_payment_page_and_click_on_upi() throws Exception {
	WebElement continue11 =driver.findElement(By.xpath("//div[@class='action primary base_btn btn_lg address_cont']"));


	JavascriptExecutor js=((JavascriptExecutor) driver);
    js.executeScript("arguments[0].click();",continue11);
		//continue11.click();
		Thread.sleep(10000);
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		 js1.executeScript("window.scrollBy(0,350)", "");

		 Thread.sleep(4000);
	
	 WebElement UPI=driver.findElement(By.xpath("//div[@data-group-tab='UPI']//label[@class='label']"));
	 
	//*[@id='payment_section_payment_page']/div[2]/div/div/div[1]/div[1]
	//div[@data-group-tab='UPI']//label[@class='label']
 	JavascriptExecutor upi = (JavascriptExecutor) driver;
 	upi.executeScript("arguments[0].click();",UPI );
 	Thread.sleep(4000);

}
@Then("User enter {string} and click on pay")
public void user_enter_and_click_on_pay(String UPIId) throws Exception {

	WebElement VPA=driver.findElement(By.xpath("//input[@id='vpa']"));
    
	VPA.sendKeys(UPIId);
	Thread.sleep(4000);
	
WebElement verifyVPA=driver.findElement(By.xpath("//div[@class='vpa_btn']"));
    
verifyVPA.click();
	
	Thread.sleep(3000);
	
	WebElement pay=driver.findElement(By.xpath("//div[@class='payment-method _active']//button[@type='submit']"));
	pay.click();
	Thread.sleep(10000);


}
//===========================


@When("User click on product type ring")
public void user_click_on_product_type_ring() throws InterruptedException {
	
	Thread.sleep(5000);
	WebElement ring11=driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div/div[6]/div/div/div/ul/li[2]"));
	

	JavascriptExecutor jss=((JavascriptExecutor) driver);
    jss.executeScript("arguments[0].click();",ring11);
	
	//ring11.click();
	Thread.sleep(4000);
}

@When("User select the ring size")
public void user_select_the_ring_size() {
	js= (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,250)", "");
	
	WebElement ringsizedropdown =driver.findElement(By.xpath("//select[@id='mt_size']"));
	Select size=new Select(ringsizedropdown);
	size.selectByValue("25");
 

}
@When("User enters {string} and click on Check button")
public void user_enters_and_click_on_check_button(String pincode) throws Exception {
	WebElement pin = driver.findElement(By.xpath("//input[@id='eedpincode']"));
	pin.sendKeys(pincode);	
	WebElement checkbutton = driver.findElement(By.xpath("//input[@id='check-eed']"));
	checkbutton.click();
	Thread.sleep(3000);
}
@When("User see the Expected Delivery Date")
public void user_see_the_expected_delivery_date() {
//	WebElement e=driver.findElement(By.xpath("//span[@class='productDeliveryDateMsg edd']"));  
//	 String s1 = e.getText();
//	 scn.log(s1);
//   System.out.println("Alert text is: " + s1); 
}
@When("User click on add to cart and see the cart page")
public void user_click_on_add_to_cart_and_see_the_cart_page() {
	homePageObject.ClickOnAddToCart();
}
@When("On cart page user is able to change the product qty and and size")
public void on_cart_page_user_is_able_to_change_the_product_qty_and_and_size() throws InterruptedException {
	WebElement dropdownsize =driver.findElement(By.xpath("//select[@class='mt_size']"));
	Select select=new Select(dropdownsize);
	select.selectByValue("25");
	Thread.sleep(5000);
	WebElement dropdownqty =driver.findElement(By.xpath("//select[@class='qty custom-qty']"));
	Select select1=new Select(dropdownqty);
	select1.selectByValue("2");
	Thread.sleep(5000);
	scn.log("Change the product qty and size");
	logger.info("Change the product qty and size");
}
@When("Fill all details {string}  and  {string} and {string} and {string}  and  click on continue")
public void fill_all_details_and_and_and_and_click_on_continue(String lastname1, String mobile1, String zip1, String flat1) throws Exception {

	Thread.sleep(10000);
	WebElement Lastname =driver.findElement(By.xpath("//div[@name='billingAddresscheckmo.lastname']//div[@class='control']/input[1]"));
	Lastname.sendKeys(lastname1);
	
	WebElement MobileNumber =driver.findElement(By.xpath("//div[@name='billingAddresscheckmo.telephone']//div[@class='control']/input"));
	MobileNumber.sendKeys(mobile1);
	
	WebElement ZipPostalCode =driver.findElement(By.xpath("//div[@name='billingAddresscheckmo.postcode']//div[@class='control']/input"));
	ZipPostalCode .sendKeys(zip1);
	
	Thread.sleep(3000);
	//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	WebElement Flat =driver.findElement(By.xpath("//div[@name='billingAddresscheckmo.street.0']//div[@class='control']/input"));
	Flat .sendKeys(flat1 );
	Thread.sleep(5000);
	
	WebElement continue11 =driver.findElement(By.xpath("//div[@class='action primary base_btn btn_lg address_cont']"));


	JavascriptExecutor js=((JavascriptExecutor) driver);
    js.executeScript("arguments[0].click();",continue11);
		//continue11.click();
		Thread.sleep(10000);
}
@When("User see the payment page and click on DGRP")
public void user_see_the_payment_page_and_click_on_dgrp() throws Exception {
	 WebElement dgrp=driver.findElement(By.xpath("//div[@data-group-tab='DGRP']//label[@class='label']"));
	
	 	JavascriptExecutor DGRP = (JavascriptExecutor) driver;
	 	DGRP.executeScript("arguments[0].click();",dgrp );
	 	Thread.sleep(4000);
}
@When("Select the No. of installments in months")
public void select_the_no_of_installments_in_months() {
	WebElement installmentdrop = driver.findElement(By.xpath("//select[@id='no_of_installments']"));
	Select select1=new Select(installmentdrop);
	select1.selectByValue("2");
	//WebDriverWait wait = new WebDriverWait(driver, 50);
	scn.log("Select the No. of installments");
	logger.info("Select the No. of installments");
}
@When("Clikc on accept DGRP Terms and Conditions and click on pay now")
public void clikc_on_accept_dgrp_terms_and_conditions_and_click_on_pay_now() throws InterruptedException {
	Thread.sleep(2000);
	WebElement terms = driver.findElement(By.xpath("//div[@class='payment_info_message dgrp__']//span[@class='custome_checkmark']"));
	terms.click();
	Thread.sleep(4000);
	WebElement pay=driver.findElement(By.xpath("//div[@class='payment-method dgrp _active']//button[@type='submit']"));
	pay.click();
	//div[@class='payment-method dgrp _active']//button[@type='submit']
	Thread.sleep(20000);
	
	
}
@When("User select the payment method as UPI")
public void user_select_the_payment_method_as_upi() throws Exception {
	Thread.sleep(5000);
	
	homePageObject.capturePassScreenshot(scn);
	
//	WebElement UPI=driver.findElement(By.xpath("//article[normalize-space()='Other UPI Options']"));
//	UPI.click();
//	
//	Thread.sleep(5000);
//	 WebElement upiid=driver.findElement(By.xpath("//input[@placeholder='Username@bankname']"));
//	 upiid.sendKeys("anything@payu");
//	 Thread.sleep(1000);
	
	
}
@When("User click on pay now")
public void user_click_on_pay_now() throws Exception {
//	Thread.sleep(2000);
//	WebElement paynow1=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[4]/div[2]/div[1]"));
//	paynow1.click();
//	
//	Thread.sleep(10000);
	
	homePageObject.capturePassScreenshot(scn);
	
}













////========================================ProductCategory====================


@When("User see the product category on the landing page")
public void user_see_the_product_category_on_the_landing_page() throws Exception {

homePageObject.setProdCategoryList();
Thread.sleep(3000);
}
@When("Validate product category list as per expected product category listed below")
public void validate_product_category_list_as_per_expected_product_category_listed_below(List<String> prodList) {

homePageObject.validateProdCategorylist(prodList);
	

}
@When("User click on any product")
public void user_click_on_any_product() throws Exception {

homePageObject.clickOnAnyProdCategory();

Thread.sleep(3000);
}
@Then("The product list page is displayed")
public void the_product_list_page_is_displayed() {

	homePageObject.capturePassScreenshot(scn);
	
//homePageObject.validateProductListPageTitle();
}
//=========================================================================ShowMore==============================


@When("User scroll down to Show Me More")
public void user_scroll_down_to_show_me_more() throws Exception {

homePageObject.scrolldownShowMeMore();
}

@When("User click on show me more")
public void user_click_on_show_me_more() throws Exception {
    homePageObject.clickOnShowMeMore();
    
    Thread.sleep(4000);
}
@Then("User are able to see the more collection")
public void user_are_able_to_see_the_more_collection() {
  // homePageObject.validateShowMeMorePageTitle();
	
	homePageObject.capturePassScreenshot(scn);
}
	

//====================================
//=================================================@SubscribeNow====================================


@When("User scroldown to the botton of the landing page of the application")
public void user_scroldown_to_the_botton_of_the_landing_page_of_the_application() {
	js= (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,750)", "");
}

@When("User enters {string} and {string}")
public void user_enters_and(String emailid , String mobileno) {
	WebElement EmailId =driver.findElement(By.xpath("//input[@id='newsletter']"));
	EmailId.sendKeys(emailid);
	
	WebElement Mobileno =driver.findElement(By.xpath("//input[@id='mobile']"));
	Mobileno.sendKeys(mobileno);
}
@When("User is click on subscribe now")
public void user_is_click_on_subscribe_now() throws Exception {
	WebElement Subscribenow =driver.findElement(By.xpath("//button[@title='Subscribe Now']"));
	Subscribenow.click();
	Thread.sleep(5000);
}
@Then("Subscribe now message is displayed")
public void subscribe_now_message_is_displayed() throws Exception {
	
	Thread.sleep(2000);
  String exp = "Email doesn't exist";
  
  WebElement m = driver.findElement(By.xpath("//div[@class='newsletter-ajax-error']"));
  String act = m.getText();
  System.out.println(" Message is: "+ act);
  Assert.assertEquals(exp, act);
  logger.info("Validate Subscribe now, message is: "+ act);
scn.log("Navigate to Subscribe now , page message is: "+ act);
}



//===================================TwitterHandle================================================


@When("User click on twitter link")
public void user_click_on_twitter_link() throws Exception {

footerPageObject.setTwitterLink();
footerPageObject.clickOnTwitterLink();

Thread.sleep(10000);
}

@When("navigate to twitter account page")
public void navigate_to_twitter_account_page() throws Exception {

	//footerPageObject.twitterAcPage();
 
}
@Then("User opened with twitter url {string}")
public void user_opened_with_twitter_url(String AcName) {
 
	//footerPageObject.twitterAclinkValidation(AcName);
}

@When("User click on facebook link")
public void user_click_on_facebook_link() throws Exception {
 footerPageObject.setFacebookLink();
 footerPageObject.clickOnFacebookLink();
 Thread.sleep(10000);
 
}


@When("navigate to facebook account page")
public void navigate_to_facebook_account_page() {
 // footerPageObject.facebookAcPage();
}
@Then("User opened with facebook url {string}")
public void user_opened_with_facebook_url(String AcName) {
 //footerPageObject.facebookAclinkValidation(AcName);
}

//====================


//=========================================@FooterLinksLists==============

@When("user scroldown to the botton of the landing page of the application")
public void user_scroldown_to_the_botton_of_the_landing_page_of_the_application1() throws InterruptedException {
	WebElement AboutUsElement = driver.findElement(By.xpath("//p[normalize-space()='ABOUT US']"));
   JavascriptExecutor js=((JavascriptExecutor) driver);


	js.executeScript("arguments[0].scrollIntoView(true);", AboutUsElement);

	Thread.sleep(5000);
}
@When("user is able to see {int} main options categories")
public void user_is_able_to_see_main_options_categories(int footerMainCatCount) {

	List<WebElement> footerMainCatListEle = driver.findElements(By.xpath("//*[@id=\"foot-accord\"]/div/div/p"));
	Assert.assertEquals(footerMainCatCount, footerMainCatListEle.size());
}

//@When("the categories having the option {string}, {string}, {string}, {string},{string} and {string}")
//public void the_categories_having_the_option_and(String categoryOneNameExp, String categoryTwoNameExp, String categoryThreeNameExp, String categoryFourNameExp, String categoryFiveNameExp, String categorySixNameExp) {
//	List<WebElement> footerMainCatListEle = driver.findElements(By.xpath("//*[@id=\"foot-accord\"]/div/div/p"));
//	Assert.assertEquals(categoryOneNameExp, footerMainCatListEle.get(0).getText());
//	Assert.assertEquals(categoryTwoNameExp, footerMainCatListEle.get(1).getText());
//	Assert.assertEquals(categoryThreeNameExp, footerMainCatListEle.get(2).getText());
//	Assert.assertEquals(categoryFourNameExp, footerMainCatListEle.get(3).getText());
//	Assert.assertEquals(categoryFiveNameExp, footerMainCatListEle.get(4).getText());
//	Assert.assertEquals(categorySixNameExp, footerMainCatListEle.get(5).getText());
//}


@When("the categories having the option {string}, {string}, {string},{string} ,{string} and {string}")
public void the_categories_having_the_option_and1(String categoryOneNameExp, String categoryTwoNameExp, String categoryThreeNameExp, String categoryFourNameExp, String categoryFiveNameExp, String categorySixNameExp) {
	List<WebElement> footerMainCatListEle = driver.findElements(By.xpath("//*[@id=\"foot-accord\"]/div/div/p"));
	Assert.assertEquals(categoryOneNameExp, footerMainCatListEle.get(0).getText());
	Assert.assertEquals(categoryTwoNameExp, footerMainCatListEle.get(1).getText());
	Assert.assertEquals(categoryThreeNameExp, footerMainCatListEle.get(2).getText());
	Assert.assertEquals(categoryFourNameExp, footerMainCatListEle.get(3).getText());
	Assert.assertEquals(categoryFiveNameExp, footerMainCatListEle.get(4).getText());
	Assert.assertEquals(categorySixNameExp, footerMainCatListEle.get(5).getText());
}



@Then("under ABOUT US category below options are visible")
public void under_about_us_category_below_options_are_visible(List<String> expectedAboutUsOptions) throws Exception {
	
	WebElement aboutus = driver.findElement(By.xpath("//p[normalize-space()='ABOUT US']"));
	aboutus.click();
	Thread.sleep(3000);
	
	List<WebElement> AboutUsOptionsActElement = driver.findElements(By.xpath("//*[@id=\"foot-accord\"]/div[4]/nav/a"));

	for (int i = 0; i < expectedAboutUsOptions.size(); i++) {
		if (expectedAboutUsOptions.get(i).equals(AboutUsOptionsActElement.get(i).getText())) {
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
		
	}
}

@Then("under WHY CANDERE? category below options are visible")
public void under_why_candere_category_below_options_are_visible(List<String> expectedWHYCANDEROptions) throws Exception {
	WebElement why = driver.findElement(By.xpath("//p[@class='footer_header c-us']"));
	why.click();
	Thread.sleep(3000);
	
	List<WebElement> WHYCANDEREOptionsActElement = driver.findElements(By.xpath("//*[@id=\"foot-accord\"]/div[6]/nav/a"));

	for (int i = 0; i < expectedWHYCANDEROptions.size(); i++) {
		if (expectedWHYCANDEROptions.get(i).equals(WHYCANDEREOptionsActElement.get(i).getText())) {
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
	}}

@Then("under EXPERIENCE CANDERE category below options are visible")
public void under_experience_candere_category_below_options_are_visible(List<String> expectedEXPERIENCECANDEREOptions) throws Exception {
	
	WebElement exp = driver.findElement(By.xpath("//p[normalize-space()='EXPERIENCE CANDERE']"));
	exp.click();
	Thread.sleep(3000);
	List<WebElement> EXPERIENCECANDEREOptionsActElement = driver.findElements(By.xpath("//*[@id=\"foot-accord\"]/div[8]/nav/a"));

	for (int i = 0; i < expectedEXPERIENCECANDEREOptions.size(); i++) {
		if (expectedEXPERIENCECANDEREOptions.get(i).equals(EXPERIENCECANDEREOptionsActElement.get(i).getText())) {
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
	}}

@Then("under JEWELLERY GUIDES category below options are visible")
public void under_jewellery_guides_category_below_options_are_visible(List<String> expectedJEWELLERYGUIDESOptions) throws Exception {

	js= (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,200)", "");
	
	WebElement guide = driver.findElement(By.xpath("//p[normalize-space()='Jewellery guides']"));
	guide.click();
	Thread.sleep(3000);
	
	List<WebElement> JEWELLERYGUIDESOptionsActElement = driver.findElements(By.xpath("//*[@id=\"foot-accord\"]/div[10]/nav/a"));

	for (int i = 0; i < expectedJEWELLERYGUIDESOptions.size(); i++) {
		if (expectedJEWELLERYGUIDESOptions.get(i).equals(JEWELLERYGUIDESOptionsActElement.get(i).getText())) {
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
	}}

@Then("under STORE LOCATOR category below options are visible")
public void under_contact_us_category_below_options_are_visible(List<String> expectedSTORELOCATOROptions) throws Exception {
	
	WebElement storelocator = driver.findElement(By.xpath("//*[@id=\"foot-accord\"]/div[1]/div/p[1]"));
	JavascriptExecutor net1 = (JavascriptExecutor) driver;
	net1.executeScript("arguments[0].click();",storelocator  );

	Thread.sleep(5000);
	
	List<WebElement> StoreActElement = driver.findElements(By.xpath("//*[@id=\"foot-accord\"]/div[2]/nav/a"));

	for (int i = 0; i < expectedSTORELOCATOROptions.size(); i++) {
		if (expectedSTORELOCATOROptions.get(i).equals(StoreActElement.get(i).getText())) {
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
	}}



///===================================

@When("Click on Continue")
public void click_on_continue() throws Exception {
	Thread.sleep(5000);
	
	WebElement continue11 =driver.findElement(By.xpath("//div[@class='action primary base_btn btn_lg address_cont']"));
	//WebElement continueshopping = driver.findElement(By.xpath("//span[normalize-space()='Continue Shopping']"));
	JavascriptExecutor js=((JavascriptExecutor) driver);
    js.executeScript("arguments[0].scrollIntoView(true);", continue11);
		continue11.click();
		Thread.sleep(5000);
	
}

@When("Select the payment method Netbanking")
public void select_the_payment_method_Netbanking() {
	 WebElement creditdebitCard=driver.findElement(By.xpath("//div[@data-group-tab='Net Banking']"));
 	
 	JavascriptExecutor credit = (JavascriptExecutor) driver;
 	credit.executeScript("arguments[0].click();", creditdebitCard );
 	scn.log("Credit / Debit Card Payment Option is displayed");
 	logger.info("Credit / Debit Card Payment Option is displayed");
 	
 	WebElement hdfc=driver.findElement(By.xpath("//label[@for='hdfc']//div[@class='custome_input_wrapper']"));
 	 hdfc.click();
 	
 	
}



@Then("Click on pay")
public void click_on_pay() throws Exception {
	WebElement pay=driver.findElement(By.xpath("//div[@class='payment-method _active']//button[@type='submit']"));
	pay.click();
	Thread.sleep(15000);

}

@When("User click on edit order")
public void user_click_on_edit_order() throws Exception {
	Thread.sleep(4000);
	WebElement edit =driver.findElement(By.xpath("//a[@title='Remove item']//*[name()='svg']"));
	edit.click();
	//a[@title='Remove item']//*[name()='svg']
	
}

@When("User are able to remove the item on cart page")
public void user_are_able_to_remove_the_item_on_cart_page() throws Exception {
	
	
	WebElement remove= driver.findElement(By.xpath("//a[@title='Remove item']"));
	remove.click();
	Thread.sleep(2000);
}


@When("User are able to see the popup Do you want to remove this product from Cart ?")
public void user_are_able_to_see_the_popup_do_you_want_to_remove_this_product_from_cart() {
	
	homePageObject.capturePassScreenshot(scn);
}
@When("User clicks on OK buttton")
public void user_clicks_on_ok_buttton() {

	WebElement ok= driver.findElement(By.xpath("//button[@class='action-primary action-accept']"));
	ok.click();
	
	//button[@class='action-primary action-accept']
}

@Then("User click on Start shopping")
public void user_click_on_start_shopping() throws Exception {


	WebElement startshopping= driver.findElement(By.xpath("//a[normalize-space()='Start Shopping']"));
	startshopping.click();
	
	Thread.sleep(2000);
	
	homePageObject.capturePassScreenshot(scn);
}




}
