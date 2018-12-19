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

Feature: Negative Testing of Case Creation
  @Test10
  Scenario Outline: Case creation by providing invalid customerid
    Given Provided Case creation endpoint Url
    When JSON request body with case fields input parameters
    And Case statusId is as 100
    And Non-exist customerId as <Customer_id>
    And Case priority label is as <priority>
    And Case createdBy is as <createdBy>
    And Case updatedBy is as <updatedBy>
    And Case should be commented as <comment>
    And Case creation API Request called
    Then Validate response status as 500
    And Validate response HTTP error  as <error>
    And Validate response message as <message>

    Examples: 
      | Customer_id | priority | createdBy | updatedBy | comment                   | error                 | message                         |
      |       10008 | Low      | Paritosh  | Paritosh  | Testing negative scenario | Internal Server Error | "No customer found with id 10008" |
