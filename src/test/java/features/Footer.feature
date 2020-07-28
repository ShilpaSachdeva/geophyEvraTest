@footer
Feature: Footer Feature
This feature deals with the footer functionality of the application


  Scenario: Verify Linked button is working
    Given User navigates to home page
    When  User clicks on linkedin icon in footer
    Then  user is navigated to page "linkedin"

  Scenario: Verify twitter  button is working
    Given User navigates to home page
    When  User clicks on twitter icon in footer
    Then  user is navigated to page "https://twitter.com/geophy"

  Scenario: Verify Geophy icon in footer is working
    Given User navigates to home page
    When  User clicks on Geophy icon in footer
    Then  user is navigated to page "https://geophy.com/"

  Scenario: Verify terms and conditions link is working
    Given User navigates to home page
    When  User clicks on terms and conditions link in footer
    Then  user is navigated to page "https://evra.geophy.com/disclaimer"

