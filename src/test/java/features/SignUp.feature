@signup
Feature: Sign up Feature
This feature deals with the sign up functionality of the application


  Scenario: Sign up a new user
    Given User navigates to sign up page
    When  User enter all required fields in Sign Up Form
    And   User click on Sign up button
    Then  User is created