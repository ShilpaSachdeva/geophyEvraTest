@history
Feature: History Feature
This feature deals with the History functionality of the application

  Scenario Outline: Opening of saved reports from history section
    Given User is logged in application with  email "qaskillschallenge@geophy.com" and password "qaskillschallenge@geophy.com"
    And   User navigates to history page
    When  User opens a saved report for <address>
    Then  User will see the saved report for <address>
    Examples:
      | address |
      |"555 N. College Ave, Tempe, AZ, 85281" |