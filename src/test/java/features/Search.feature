@search
Feature: Search Feature
This feature deals with the search functionality of the application

  Scenario Outline: Run valuation for property
    Given User is logged in application with  email "qaskillschallenge@geophy.com" and password "qaskillschallenge@geophy.com"
    And   User navigates to search page
    When  User enter information <address> , <netOperatingIncome> , <numberOfUnits> , <yearOfConstruction>, <occupancy>
    And   User clicks on run valuation button
    Then  The valuation report of the chosen property with <address> is shown to the user
    Examples:
      | address| netOperatingIncome | numberOfUnits | yearOfConstruction | occupancy |
      | "555 N. College Ave, Tempe, AZ, 85281" | "2,000,000" | "200" | "2000" | "80"|
