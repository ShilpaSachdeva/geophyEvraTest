@logout
Feature: Logout Feature
This feature deals with the logout functionality of the application

  Scenario: Logout from application
    Given User navigates to login page
    And   User provides email "qaskillschallenge@geophy.com" and password "qaskillschallenge@geophy.com"
    And   User click on login button
    When  user clicks on logout button
    Then  user is logged out