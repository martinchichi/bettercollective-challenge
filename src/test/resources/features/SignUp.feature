@SignUp

Feature: Roto Grinder - Sign up Page

  Background:
    Given I access the Roto Grinder sign up page

  @01 @Smoke
  Scenario: Validate Successful Sign Up with Random Data
    When I enter a random username
    And I enter a random email address
    And I enter a password
    And I check the captcha box
    And I click on the create account button
    Then I should be presented with the successful signing up message

  @2 @Regression
  Scenario: Validate Missing Username
    When I enter a random email address
    And I enter a password
    And I check the captcha box
    And I click on the create account button
    Then I should see an error message indicating that the username is required

  @3 @Regression
  Scenario: Validate Missing Email
    When I enter a random username
    And I enter a password
    And I check the captcha box
    And I click on the create account button
    Then I should see an error message indicating that the email is required

  @4 @Regression
  Scenario: Validate Missing Password
    When I enter a random username
    And I enter a random email address
    And I check the captcha box
    And I click on the create account button
    Then I should see an error message indicating that the password is required

  @5 @Regression
  Scenario: Validate Weak Password
    When I enter a random username
    And I enter a random email address
    And I enter a weak password
    And I check the captcha box
    And I click on the create account button
    Then I should see an error message indicating that password is too weak

  @6 @Regression
  Scenario: Validate Username Already Exists
    When I enter an existing username
    And I enter a random email address
    And I enter a password
    And I check the captcha box
    And I click on the create account button
    Then I should see a warning message indicating que el username already exists

  @7 @Regression
  Scenario: Validate Email Already Exists
    When I enter a random username
    And I enter an existing email address
    And I enter a password
    And I check the captcha box
    And I click on the create account button
    Then I should see a warning message indicating que el email already exists

