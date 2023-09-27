#Author: SHEETAL
#Keywords Summary : PRODUCT COMPARE FUNCTIONALITY
Feature: To check the product compare functionality

  Background: For the scenarios in the feature file, user is expected to be on home page
    Given open browser and enter the url
    When click on Login in My Account
    When user enters "puniasheetal@gmail.com" and "asd123"
    And user clicks login button

  Scenario: Validate adding the product to cart from comparison page
    And navigate to home page
    Then user goes to featured section
    And select compare this product option
    Then a success message should be displayed
    And click on product comparison link
    Then go to add to cart button on comparison page
    And click add to cart button
    Then verify product is added to cart
    And close the browser
 
 Scenario: validate removing the product from comparison page
    And navigate to home page
    Then user goes to featured section
    And select compare this product option
    Then a success message should be displayed
    And click on product comparison link
    Then go to remove button on comparison page
    And click remove button
    Then verify product is removed from comparison page
    And close the browser
	
  Scenario: Validate page title, page url and page heading for comparison page
    And navigate to home page
    Then user goes to featured section
    And select compare this product option
    Then a success message should be displayed
    And click on product comparison link
    Then verify title, url, heading
    And close the browser
  
  Scenario: Validate that more than 4 products cannot be added to comparison page
    And navigate to home page
    Then user goes to featured section
    And select compare this product option for 4 product
    Then a success message should be displayed
    And click on product comparison link
    Then verify more than 4 products cannot be added
    And close the browser
	
 Scenario: Validate success message when product is added for comparison
    And navigate to home page
    Then user goes to featured section
    And select compare this product option
    Then a success message should be displayed
    And close the browser
	
 Scenario: Validate comparison page when same product is added twice
    And user enters a valid product in searchbar
    And click on search icon
    And user goes to the search result page
    And select compare this product for same product 2 times
    Then a success message should be displayed
    And click on product comparison link
    Then verify no duplicate product is present
    And close the browser