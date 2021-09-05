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

Feature: Free CRM app test 

Scenario: free crm create deal test 
	Given user is on deal page 
	When user fills the deals form 
	Then deal is created 

Scenario: free crm create contact test 
	Given user is on contact page 
	When user fills the contact form 
	Then contact is created 


Scenario Outline: free crm create mail test 
	Given user is on mail page 
	When user fills the mail form 
	Then mail is created 
	Examples: 
		|mail1|
		|mail2|
		|mail3|	

