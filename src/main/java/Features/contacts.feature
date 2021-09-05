#Author: your.email@your.domain.com
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

Feature: FreeCRM Application
	
	Scenario Outline: FreeCRM Login Test Scenario
    Given user is already on Login Page
    When title of login page is Free CRM
    Then user enters "<username>" as uname
    Then user enters "<password>" as pwd
		And user clicks on login button
	  Then user is on Home Page

		When user mouse over and clicks on New Contact link under Contacts
		Then user enters the <FirstName>,<LastName>,<Company>,<Position>
		And user clicks on save button
		Then verify the new contact created <FirstName> and <LastName> and <Company> and <Position>
		Then user clicks on logout button
		Then close the browser
		
		Examples: 
 			|username  		 	| password 	| FirstName   	| LastName 		| Company 							|Position 		 |
  		|groupautomation| Test@12345| Sharath Kumar | Rajashekar  | Naveen Automation Labs|Manager  		 |
     	|groupautomation| Test@12345| Munaf         | Patel  		 	| Siemens								|Director 		 |
     	|groupautomation| Test@12345| Irfan         | Pathan 			| Safran								|Technical Lead|
