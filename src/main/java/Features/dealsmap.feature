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

Feature: Deal data creation

	Scenario: Free CRM Create a new deal scenario
	
		Given user is already on Login Page
		When title of login page is Free CRM
		Then user enters username and password
		| username 			  | password	 |
		| groupautomation | Test@12345 |
	
		Then user clicks on login button
		Then user is on home page
		Then user moves to new deal page
		Then user enters deal details
		|  title     | amount | probability | commission |		
		| test deal1 | 1000	  | 50          | 10         |
		| test deal2 | 2000   | 60          | 20         |
		| test deal3 | 3000   | 70          | 30         |		
		Then close the browser