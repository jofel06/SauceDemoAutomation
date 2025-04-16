Feature: Login

  As a user, I want to log in to the Saucedemo website

  @regression @standard
  Scenario: Login with standard_user
    Given User is on the Saucedemo login page
    When User logs in as "standard_user"
    Then User should be logged in normally

  @regression @locked
  Scenario: Login with locked_out_user
    Given User is on the Saucedemo login page
    When User logs in as "locked_out_user"
    Then User should see the error message "Epic sadface: Sorry, this user has been locked out."

