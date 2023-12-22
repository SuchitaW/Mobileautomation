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

  @DisplayLogo
  Scenario: User able to see logo of application on landing page
    When User is on landing page
    Then User see the logo of application

  @HomePageHeaderLinks
  Scenario: Validate Header links
    When User validate all headerlink are clickable or not
    Then Below header Links are displayed
      | Candere logo    |
      | Hamburger       |
      | Wishlist        |
      | MiniBag         |
      | search text box |
      | search Button   |

  @ProductCategoryList
  Scenario: User able to see product category on landing page
    When User see the product category
    Then Validate product category as per expected product category listed below
      | Solitaires   |
      | Rings        |
      | Necklaces    |
      | Earrings     |
      | Chains       |
      | Bestseller   |
      | New Arrivals |
      | Bangles      |
      | Mangalsutra  |
      | Pendants     |
      | Bracelets    |
      | Platinum     |
      | Men’s        |
      | Coins        |
    And Size of product category should be 14

  @Signup&Spin!
  Scenario: User able to see Sign up & Spin! on landing page
    When User scroll down to Sign up & Spin!
    And User click on Sign up & Spin button
    Then User are able to see the Sign Up form

  @SignUp
  Scenario Outline: User is able to SignUp into the application
    When User click on  hambugericon from home page
    And User click on SignUp
    And User enters  "<name>"  and  "<emailid>" and "<mobileno>"
    And User click on Send Otp
    And User enter otp
    And Click on Verify Otp & Register
    Then User successfully redirected to "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store"

    Examples: 
      | name   | emailid                  | mobileno   |
      | mnbcxs | selenium4512@candere.com | 7645686441 |

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

  @ProductCategory
  Scenario: User able to see product category list on landing page
    When User see the product category on the landing page
    And Validate product category list as per expected product category listed below
      | Stunning Rings       |
      | Classy Earrings      |
      | Stylish Mangalsutras |
      | Elegant Necklaces    |
      | Gorgeous Bracelets   |
      | Dainty Pendants      |
      | Statement Chains     |
    And User click on any product
    Then The product list page is displayed

  @ShowMeMore
  Scenario: User able to see Show Me More  on landing page
    When User scroll down to Show Me More
    And User click on show me more
    Then User are able to see the more collection

  @SubscribeNow
  Scenario Outline: Validate SubscribeNow Functionality
    When User scroldown to the botton of the landing page of the application
    And User enters "<emailid>" and "<mobileno>"
    And User is click on subscribe now
    Then Subscribe now message is displayed

    Examples: 
      | emailid          | mobileno   |
      | ddfdsf@yahoo.com | 9074567846 |

  @FooterLinksLists
  Scenario: Validate all footer links on landing page of the application
    When user scroldown to the botton of the landing page of the application
    And user is able to see 6 main options categories
    And the categories having the option "STORE LOCATOR", "ABOUT US", "WHY CANDERE?","EXPERIENCE CANDERE" ,"JEWELLERY GUIDES" and "MORE ABOUT CANDERE"
    Then under STORE LOCATOR category below options are visible
      | Find Experience Centre |
      | Kalyan Store Locator   |
    And under ABOUT US category below options are visible
      | About Our Company    |
      | Terms and Conditions |
      | Privacy Policy       |
      | FAQ                  |
      | Offers T&Cs          |
      | Customer Reviews     |
    And under WHY CANDERE? category below options are visible
      | 15-Day Returns      |
      | Cancel & Refund     |
      | Lifetime Exchange   |
      | DGRP                |
      | Certified Jewellery |
      | Candere Wallet      |
      | Jewellery Insurance |
    And under EXPERIENCE CANDERE category below options are visible
      | Refer And Earn |
      | DigiGold       |
      | Lookbook       |
      | Stylery Blog   |
      | Video Gallery  |
      | Order Tracking |
      | Virtual Try On |
    And under JEWELLERY GUIDES category below options are visible
      | Diamond Education  |
      | Gemstone Education |
      | Metal Education    |
      | Size Guide         |
      | Gold Rate Guide    |
      | Jewellery Care     |

  @TwitterHandle
  Scenario: Validate twitter social media handle
    When User click on twitter link
    And navigate to twitter account page
    Then User opened with twitter url "https://twitter.com/i/flow/login"

  @FacebookHandle
  Scenario: Validate facebook social media handle
    When User click on facebook link
    And navigate to facebook account page
    Then User opened with facebook url "https://www.facebook.com/canderejewellery"
