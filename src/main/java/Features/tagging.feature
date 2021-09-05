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

@FunctionalTest
Feature: Free CRM application testing

@SmokeTest @RegressionTest
Scenario: Login with correct username and correct password
Given This is a valid login test

@RegressionTest
Scenario: Login with incorrect username and correct password
Given This is a invalid login test

@SmokeTest @RegressionTest
Scenario: Create a contact
Given This is a contact test case

@SmokeTest @RegressionTest
Scenario: Create a deal
Given This is a deal test case

@SmokeTest @RegressionTest
Scenario: Create a case
Given This is a case test case

@RegressionTest
Scenario: Create a tasks
Given This is a tasks test case

@SmokeTest @RegressionTest
Scenario: Verify left panel links
Given clicking on left panel links

@SmokeTest
Scenario: Search a deal
Given This is a search deal test

@SmokeTest
Scenario: Search a contact
Given This is a search contact test

@SmokeTest @RegressionTest
Scenario: Search a case
Given This is a search case test

@SmokeTest @RegressionTest
Scenario: Search a task
Given This is a search task test

@SmokeTest @End2EndTest
Scenario: Search a call
Given This is a search call test

@SmokeTest @End2EndTest
Scenario: Search an email
Given This is a search email test

@SmokeTest @End2EndTest
Scenario: Search docs
Given This is a search docs test

@SmokeTest @End2EndTest
Scenario: Search forms
Given This is a search forms test

@End2EndTest
Scenario: validate a report
Given This is a report test

@End2EndTest
Scenario: Application Logout
Given This is a logout test

Scenario: browser closed
Given This is a close browser test
