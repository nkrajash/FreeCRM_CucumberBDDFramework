#Author: rnavinkmr45.12@gmail.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: FreeCRM Login Feature

  Scenario: FreeCRM Login Test Scenario
    Given user is already on Login Page
    When title of login page is Free CRM
    Then user enters "groupautomation" as username
    Then user enters "Test@12345" as password
		And user clicks on login button
		Then user is on home page
		Then user clicks on logout button
		Then close the browser