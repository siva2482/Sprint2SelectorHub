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
Feature: To test selectors hub elements
Background:
Given  User enters the application
Then User asserts the application
Scenario:User verifies disabled textbox

When User enters names in disabled name textbox
Then User asserts textbox are enabled

When User checks out the available option
Then verifies the new page and comes back

When User select the car
Then verifies his selection

When User selects value from UsersTable
Then verfies the home page

When User enters shadow Elements in the homepage
Then verifies values

