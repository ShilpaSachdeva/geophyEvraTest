@login
Feature: Login Feature
This feature deals with the login functionality of the application


  Scenario: Blank fields validation for email and password
    Given User navigates to login page
    When  User click on login button
    Then  Blank field Error messages are shown

  Scenario: Valid email and password for successful login
    Given User navigates to login page
    When  User provides email "qaskillschallenge@geophy.com" and password "qaskillschallenge@geophy.com"
    And   User click on login button
    Then  User is successfully logged in