#Author: SHEETAL
#Keywords Summary : BROWSE FUNCTIONALITY
Feature: To check the register user functionality

  Background: For the scenarios in the feature file, user is expected to be on home page
    Given open browser and enter the url
    When click on register in My Account

  Scenario: Validate regsitering an account by entering different password into password and confirm password field
    And user enter password as "qwert" into password field and "abcde" into password confirm field with all other details
    And select the privacy policy checkbox option
    Then user clicks on continue button
    And verify password does not match message
    And close the browser

  Scenario: Validate Regsitering an account, by filling password field and not filling password confirm field
    And user enters new account details into all the fields and not enter password in confirm password field
    And select the privacy policy checkbox option
    Then user clicks on continue button
    And verify password does not match message
    And close the browser

  Scenario Outline: Validate registering an account by providing invalid email address into email field
    And user enters new account details into all the fields but with invalid '<emailId>' into email field
    Then user clicks on continue button
    And close the browser

    Examples: 
      | emailId           |
      | paul.example.com  |
      | paul@exapmle.com  |
      | @example.com      |
      | paul@.com         |
      | paul@example      |
      | !paul@example.com |

  Scenario: Validate registering the account without selecting the privacy policy checkbox option
    And user enters new account details into all the fields
    And do not select the privacy policy checkbox option
    Then user clicks on continue button
    And verify privacy policy error message
    And close the browser

  Scenario: Validate registering an account by providing all the fields
    And user enters new account details into all the fields
    And select the privacy policy checkbox option
    And user clicks on continue button
    Then click on continue button that is displayed in account success page
    And close the browser

  Scenario: Validate registering an account by providing only the mandatory fields
    And user enters new account details into mandatory fields
    And user clicks on continue button
    Then click on continue button that is displayed in account success page
    And close the browser

  Scenario Outline: Validate registering an account by providing the existing account details
    And user enters existing account details into all the fields('<firstname>', '<lastname>', '<email>', '<telephone>', '<password>', '<confirmPassword>')
    Then user clicks on continue button
    And close the browser

    Examples: 
      | firstname |  | lastname |  | email                  |  | telephone |  | password |  | confirmPassword |
      | Sheetal   |  | Punia    |  | puniasheetal@gmail.com |  | 123456789 |  | asd123   |  | asd123          |

  Scenario: Validate the Breadcrumb, Page Heading, Page URL, Page Title of Registered Account
    Then verify the url, title, heading of registered page
    And close the browser
