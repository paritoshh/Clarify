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
@tag
Feature: Search case by Customer id

  @Test4
  Scenario Outline: Case search by customer id
    Given Provide service endpoint URL
    And Provide customer id to search the case as <CustomerID>
    When Request service API
    Then Validate service status code as 200
    And Validate the customer_id as <CustomerID>
    And Count the number of cases fetch with this customer_id
    And Validate the customerFirstName with <name>

    Examples: 
      | CustomerID |  | name |
      |      10003 |  | JYSK |
