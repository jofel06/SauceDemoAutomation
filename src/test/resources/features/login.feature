Feature: Login
  As a user, I want to log in to the Saucedemo website

  Scenario: Successful login with standard user
    Given I am on the Saucedemo login page
    When I enter the username and password
    And I click the login button
    Then I should be logged in normally