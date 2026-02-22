
Feature: Happy Path – End-to-End Purchase Flow

  @smoke @Regression
  Scenario Outline: Complete purchase flow with valid user

    Given User launches saucedemo website
    When User enters username "<Username>" and password "<Password>"
    And User clicks on login button
    Then User should land on dashboard page
    And Verify dashboard title

    When User select product
    And User clicks on Add to Cart button
    And User clicks on cart icon
    Then Verify cart page URL contains

    When User clicks on checkout button and filled all the details
    Then User should see order confirmation message

    Examples:
      |Username|Password|
      |standard_user|secret_sauce|

  @Regression
  Scenario Outline: Login with invalid cred
    Given User launches saucedemo website
    When User enters username "<Username>" and password "<Password>"
    And User clicks on login button
    Then User should see login error message
    Examples:
      |Username|Password|
      |standarduser|secretsauce|