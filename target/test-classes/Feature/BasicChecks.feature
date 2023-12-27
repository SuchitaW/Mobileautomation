@healthCheck
Feature: E-Commerce website healthcheck

  Background: Navigation to the URL
    Given User navigate to URL and open the landing page

  @URLRedirection
  Scenario: User naviaget to URL, User redirect to landing page with expected current URL
    When User is on landing page
    Then Validate current URL of landing page with expected URL

  @LandingPageTitle
  Scenario: User naviaget to URL, User redirect to landing page with expected page title
    When User is on landing page
    Then Validate title of landing page with expected title as "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store"

  @SignUp
  Scenario Outline: User is able to SignUp into the application
    When User click on  hambugericon from home page
    And User click on SignUp
    And User enters  "<name>"  and  "<emailid>" and "<mobileno>"
    And User click on Send Otp
    And User enters "<otp1>" Click on Verify Otp & Register
    Then User successfully redirected to "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store"

    Examples: 
      | name   | emailid                   | mobileno   | otp1   |
      | mnbcxs | egh2U223932vs@candere.com | 1125276441 | 123456 |

  @loginmobileno
  Scenario Outline: HomePage- Login with Email Id -OTP
    When User click on  hambugericon from home page
    And User click on  Log In
    And User enters "<Emailid or mobileno>"
    And User click on continue button
    And User enters "<otp>" and click on login
    Then User successfully redirected to homepage "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store"

    Examples: 
      | Emailid or mobileno | otp    |
      |          1234444444 | 123456 |

  @loginemailid
  Scenario Outline: HomePage- Login with Email Id -OTP
    When User click on  hambugericon from home page
    And User click on  Log In
    And User enters "<Emailid or mobileno>"
    And User click on continue button
    And User enters "<otp>" and click on login
    Then User successfully redirected to homepage "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store"

    Examples: 
      | Emailid or mobileno       | otp    |
      | suchita.tayde@candere.com | 123456 |

  @LoginUsingGoogle
  Scenario: Login using Google Account
    When User click on  hambugericon from home page
    And User click on  Log In
    And User click on Login Using Google
    Then User enters Emailid or mobileno ,password and click on next button


  @CheckoutSignup
  Scenario Outline: CheckoutPage- Sign Up with OTP
    When User search for the  "<product>"
    And choose to buy the first item in list
    And Add first product to the shopping cart
    And User click on Checkout Securely
    And User are able to see the signup and login popup and click on signup
    And User enters  "<name>"  and  "<emailid>" and "<mobileno>"
    And User click on Send Otp
    And User enters "<otp1>" Click on Verify Otp & Register
    And Shipping page is open then user fill all details "<lastname>"  and  "<mobile>" and "<zip>" and "<flat>"  and  click on continue
    And User see the payment page and click on UPI
    Then User enter "<UPIId>" and click on pay

    Examples: 
      | product  | name     | emailid                 | mobileno   | otp1   | lastname | mobile     | zip    | flat                                   | UPIId              |
      | EARRINGS | selenium | 8134ghghf24@candere.com | 8490178903 | 123456 | Peter    | 9023458934 | 400068 | flat no 201,sanlkalp chsl dahisar east | suchitatayde@oksbi |

  @CheckoutLoginemailid
  Scenario Outline: CheckOutPage- Login with Email Id -OTP
    When User search for the  "<product>"
    And choose to buy the first item in list
    And Add first product to the shopping cart
    And User click on Checkout Securely
    And User enters "<Emailid or mobileno>"
    And User click on continue button
    And User enters "<otp>" and click on login
    And Click on Continue
    And Select the payment method Netbanking
    Then Click on pay

    Examples: 
      | product | Emailid or mobileno       | lastname1 | otp    | mobile1    | zip1   | flat1                                  | CardNumber          | NameOnCard | CVV | ExpiryYear | ExpiryMonth |
      | RINGS   | suchita.tayde@candere.com | Wadhe     | 123456 | 9023458934 | 400068 | flat no 201,sanlkalp chsl dahisar east | 4111 1111 1111 1111 | testing    | 123 |         24 |          12 |

  @homepageloginmobileno
  Scenario Outline: HomePage- Login with Email Id -OTP
    When User click on  hambugericon from home page
    And User click on  Log In
    And User enters "<Emailid or mobileno>"
    And User click on continue button
    And User enters "<otp>" and click on login
    And User search for the  "<product>"
    And choose to buy the first item in list
    And Add first product to the shopping cart
    And User click on edit order
    And User are able to see the popup Do you want to remove this product from Cart ?
    And User clicks on OK buttton
    Then User click on Start shopping

    Examples: 
      | Emailid or mobileno       | otp    | product |
      | suchita.tayde@candere.com | 123456 | Earring |

  #
  #@checkoutLoginUsingGoogle1
  #Scenario Outline: Login using Google Account
  #When User click on product type ring
  #And choose to buy the first item in list
  #And Add first product to the shopping cart
  #And User click on Checkout Securely
  #And User click on  Log In
  #And User click on Login Using Google
  #And User enters Emailid or mobileno ,password and click on next button
  #And Click on Continue
  #And Select the payment method Netbanking
  #Then Click on pay
  #
  #Examples:
  #| product | Emailidmobileno           | lastname1 | mobile1    | zip1   | flat1                                  | CardNumber          | NameOnCard | CVV | ExpiryYear | ExpiryMonth |
  #| RINGS   | suchita.tayde@candere.com | Wadhe     | 9023458934 | 400068 | flat no 201,sanlkalp chsl dahisar east | 4111 1111 1111 1111 | testing    | 123 |         24 |          12 |
  #
  #
  #
  #
  #
  #
  #
  #
  #
  #
  #@LoginUsingGoogle1
  #Scenario Outline: Login using Google Account
  #When User click on  hambugericon from home page
  #And User click on  Log In
  #And User click on Login Using Google
  #And User enters Emailid or mobileno ,password and click on next button
  #And User click on product type ring
  #And choose to buy the first item in list
  #And Add first product to the shopping cart
  #And User click on Checkout Securely
  #And Click on Continue
  #And Select the payment method Netbanking
  #Then Click on pay
  #
  #Examples:
  #| product | Emailidmobileno           | lastname1 | mobile1    | zip1   | flat1                                  | CardNumber          | NameOnCard | CVV | ExpiryYear | ExpiryMonth |
  #| RINGS   | suchita.tayde@candere.com | Wadhe     | 9023458934 | 400068 | flat no 201,sanlkalp chsl dahisar east | 4111 1111 1111 1111 | testing    | 123 |         24 |          12 |
  @HomepageSignUp
  Scenario Outline: Order Journey (includes other pdp,plp and cart page functionalities ) till payment page functionality
    When User click on  hambugericon from home page
    And User click on SignUp
    And User enters  "<name>"  and  "<emailid>" and "<mobileno>"
    And User click on Send Otp
    And User enters "<otp1>" Click on Verify Otp & Register
    #And User successfully redirected to "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store"
    And User click on product type ring
    And choose to buy the first item in list
    And User select the ring size
    And User enters "<Pincode>" and click on Check button
    And User see the Expected Delivery Date
    And User click on Price breakup link
    And User click on add to cart and see the cart page
    #And On cart page user is able to change the product qty and and size
    And User click on Checkout Securely
    And Fill all details "<lastname1>"  and  "<mobile1>" and "<zip1>" and "<flat1>"  and  click on continue
    And User see the payment page and click on DGRP
    And Select the No. of installments in months
    And Clikc on accept DGRP Terms and Conditions and click on pay now
    And User select the payment method as UPI
    Then User click on pay now

    Examples: 
      | otp1   | Pincode | name         | emailid                 | mobileno   | lastname1 | mobile1    | zip1   | flat1                                  | UPIId         |
      | 123456 |  400089 | javacucumber | twr3v877hvv@candere.com | 1826707922 | More      | 9023458934 | 400068 | flat no 201,sanlkalp chsl dahisar east | anything@payu |
