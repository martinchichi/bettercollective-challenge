@signUp  @regression

Feature: Roto Grinder - Sign up Page

  Background:
    Given I access the Roto Grinder sign up page


  Scenario: Validate Successful Sign Up
    When I enter a username
    And I enter an email address
    And I enter a password
    And I check the captcha box
    And I click on the create account button
    Then I should be presented with the successful signing up message