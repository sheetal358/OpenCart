#Author: SHEETAL
#Keywords Summary : HOME PAGE FUNCTIONALITY
Feature: To check the home page functionality

  Background: For the scenarios in the feature file, user is expected to be on home page
    Given open browser and enter the url
    When click on Login in My Account
    When user enters "puniasheetal@gmail.com" and "asd123"
    And user clicks login button

  Scenario: validate hero image and its slider option in home page
    And clicks on home icon
    And verify slider option is working fine for hero image
    Then check hero image is displayed
    And clicking on hero image
    Then takes user to respective product page
    And close the browser

  Scenario: validate all links present in header section working properly
    And clicks on home icon
    Then verify all links in header section is working properly
    And close the browser

  Scenario: validate navigating  to home page from any page of application by clicking on logo
    Then verify user is logged in
    And clicks on application logo
    Then user should be directed to home page
		And close the browser
		
  Scenario: validate partner section and its slider option in home page
    And clicks on home icon
    And scroll downs to the partner section
    Then verify slider option is working fine for partner section
    And close the browser

  Scenario: validating navigating to home page using "home icon" option present on different pages on app
    Then user goes to wishlist page
    And clicks on home icon
    Then user should be directed to home page
    And close the browser

  Scenario: validate all links present in footer section working properly
    And clicks on home icon
    Then user goes to footer section
    And verify all links in footer section is working properly
    And close the browser

  Scenario: validate four featured product is displayed on home page
    And clicks on home icon
    Then user goes to featured section
    And verify four featured product is displayed on home page
    And close the browser