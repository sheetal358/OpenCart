#Author: SHEETAL
#Keywords Summary : BROWSE FUNCTIONALITY
Feature: To check the browse functionality

 Background: For the scenarios in the feature file, user is expected to be on home page
    Given open browser and enter the url
    When click on Login in My Account
    When user enters "puniasheetal@gmail.com" and "asd123"
    And user clicks login button

  Scenario: To verify the functionality that search field accepts alphabets and numbers when customer enter product detail
     and whether a user is able to navigate to product description page when clicks on a product
    And navigate to home page
    When user enters the product name in search field
    And clicks on search icon
    Then verify search field shows relevant result page.
    When user clicks on a product
    Then verify user is navigated to product description page
    And close the browser

  Scenario: To verify the functionality of receiving a error message, when enter wrong product name in search field
    And navigate to home page
    When user enters the wrong data in search field
    And clicks on search icon
    Then verify error message is displayed with invalid product
    And close the browser

  Scenario: To verify whether the products in result page sorts according to options available in dropdown
    And navigate to home page
    When user clicks on a product category
    And clicks on the sub-category
    Then verify user is navigated to result page
    When user clicks on Sort by dropdown and choose an option
    Then verify result page is sorted according to option
    And close the browser

  Scenario: To verify that when user clicks on add to wishlist and for comparison, the product adds to Wishlist and adds for comparison page
    Then navigate to home page
    When user clicks on a product category
    And clicks on the sub-category
    Then verify user is navigated to result page
    When user clicks on add to wishlist button
    Then verify product is added to wishlist
    When user clicks on add to compare button
    Then verify product is added for comparison
    And close the browser

  Scenario: To verify total number of search records displays on page
    And navigate to home page
    When user clicks on a product category
    And clicks on the sub-category
    Then verify user is navigated to result page
    And scroll to bottom
    Then verify number of search records displayed
    And close the browser