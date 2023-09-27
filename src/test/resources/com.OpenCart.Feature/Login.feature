#Author: SHEETAL
#Keywords Summary : LOGIN FUNCTIONALITY
Feature: To check the login functionality

  Background: For the scenarios in the feature file, user is expected to be on home page
    Given open browser and enter the url
    When click on Login in My Account

  Scenario Outline: Users log in with invalid email or invalid password credentials.
    When user enters '<emailid>' and '<password>'
    And user clicks login button
    Then user sees a error message
    And close the browser

    Examples: 
      | emailid                |  | password |
      | puniasheetal@gmail.com |  | asdfg123 |
      | sheetal@gmail.com      |  | asd123   |
      | sheetal@gmail.com      |  | asdfg123 |

  Scenario Outline: Users log in with valid credentials.
    When user enters '<emailid>' and '<password>'
    And user clicks login button
    Then verify user is logged in
    And close the browser

    Examples: 
      | emailid                |  | password |
      | puniasheetal@gmail.com |  | asd123   |

  Scenario Outline: User should see the password in bullet signs by default
    When user enters '<emailid>' and '<password>'
    Then password should be visible in bullet format.
    And close the browser

    Examples: 
      | emailid                |  | password |
      | puniasheetal@gmail.com |  | asd123   |

  Scenario Outline: User tries whether enter button works on the login page.
    When user enters '<emailid>' and '<password>'
    And user press enter key.
    Then verify user is logged in
    And close the browser

    Examples: 
      | emailid                |  | password |
      | puniasheetal@gmail.com |  | asd123   |

  Scenario: User land on the ‘reset password’ page after clicking on the Forgot password link
    When user clicks on Forgot Password link
    Then user should be able to see reset password page
    And close the browser

  Scenario Outline: Please fill out this field" message should be displayed if the password or username is empty
    When user enters '<emailid>' and '<password>'
    And user clicks login button
    Then user sees a error message
    And close the browser

    Examples: 
      | emailid                |  | password |
      |                        |  | asd123   |
      | puniasheetal@gmail.com |  |          |