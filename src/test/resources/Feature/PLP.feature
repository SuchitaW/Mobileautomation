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

  @GridviewProduct
  Scenario: To verify grid view functionality on PLP Page
    When User click on earring on landing page
    And User are able to see the grid view of the product
    Then User are able to see the product in grid view mode

  @MoreFilter
  Scenario: To verify MoreFiler functionality on productlisting page
    When User click on earring on landing page
    And User able to click on more filter
    And User select the any combination of product as per there choice
    Then User are able to see the combination of product

  @ClearAll
  Scenario: To verify Clear all functionality on productlisting page
    When User click on earring on landing page
    And User able to click on more filter
    And User select the any combination of product as per there choice
    And User are able to see the combination of product
    And User able to click on more filter
    Then User are able to ClearAll the filters

  @Sort
  Scenario: To verify Filter by price like low_to_high and high_to_low fuctionality on productlisting page
    When User click on rings on landing page
    And User click on sort
    And User are able to sort from Relevance,Price - Low To High,Price - High To Low and What's new
    Then User are able to see the sorted product

  @Expressdelivery
  Scenario: To verify the express delivery functionality on productlisting page
    When User click on chains on landing page
    And User click on express delivery
    And User are able to see all the ship fast product
    Then User again click on express delivery

  @Metalcolourchange
  Scenario Outline: To verify Color changer functionality on productlisting page
    When User click on rings on landing page
    And User scroll down
    And User select the any product
    Then User click on change background like gold and rosegold

    Examples: 
      | product |
      | ring    |

  @LoadMore
  Scenario: To verify LoadMore fuctionality on productlisting page
    When User click on earring on landing page
    And User scrolldown to the bootom of the page
    Then User click on load more button

  @Video
  Scenario: To verify LoadMore fuctionality on productlisting page
    When User click on earring on landing page
    And User click on video icon
    Then User able to see the video of that image

  @Perpageitems
  Scenario: To verify Per page items display in product listing page
    When User click on rings on landing page
    Then User are able to count the per page item in plp

  @plpwishlisticon
  Scenario Outline: To verify Wishlist functionality on productlisting page
    When User search for the  "<product>"
    And User scroll down
    And User click on wishlist icon on plp
    And User are able to see the signup and login popup and click on signup
    And User enters  "<name>"  and  "<emailid>" and "<mobileno>"
    And User click on Send Otp
    And User enters "<otp1>" Click on Verify Otp & Register
    And User click on wishlist icon on plp
    Then User successfully add this item into wishlist and click on wishlist icon

    Examples: 
      | product | name | emailid               | mobileno   | otp1   |
      | ring    | QWsa | Wetret440@candere.com | 8561178289 | 123456 |
