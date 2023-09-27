#Author: SHEETAL
#Keywords Summary : SEARCH FUNCTIONALITY
Feature: To check the search functionality

  Background: For the scenarios in the feature file, user is expected to be on home page
    Given open browser and enter the url
    When click on Login in My Account
    When user enters "puniasheetal@gmail.com" and "asd123"
    And user clicks login button

  Scenario: Validate searching with an existing product
    And user enters a valid product in searchbar
    And click on search icon
    And user goes to the search result page
    Then valid product should be present in search result page
    And close the browser

  Scenario: Validate searching with an non existing product
    And user enters a invalid product in searchbar
    And click on search icon
    Then a message should be visible on screen with shopping cart as empty
    And close the browser

  Scenario: Validate searching without providing any product name
    And click on search icon
    Then a message should be visible on screen with shopping cart as empty
    And close the browser

  Scenario: Validate user is able to sort the products list in the search results
    And user enters a valid product in searchbar
    And click on search icon
    And user goes to the search result page
    And user clicks on sortby option to sort the product
    Then search result page should be sorted accordingly
    And close the browser

  Scenario Outline: Validate search by selecting the category of product
    And user selects a "<category>"
    And user enters a valid product in searchbar
    And click on search icon
    And user goes to the search result page
    Then valid product should be present in search result page
    And close the browser

    Examples: 
      | category            |
      | Laptops & Notebooks |

  Scenario: Validate search using the text from product description
    And user enters a valid product in searchbar
    And click on search icon
    And user goes to the search result page
    And copy the product description
    And user enters product description in search option
    And click on search icon
    Then same product should be present in search result page
    And close the browser