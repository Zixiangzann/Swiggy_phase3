@Regression
Feature: To test negative sign up functionality.

  Background: 
    Given User at main menu page
    And Click on Sign up button

  Scenario: 
    Then Sign up menu should show
    Then User enter Phone number and System check the validity of the information entered
    Then User enter Name and System check the validity of the information entered
    Then User enter Email and System check the validity of the information entered
    Then User enter Password and System check the validity of the information entered
#to facilitator, I can only perform negative scenario as I do not have a valid India phone number and I do not want to send OTP to random people.
 