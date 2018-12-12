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

Feature: Case Creation
  

  @Test
  Scenario Outline: Case creation mentioning all the fields of case
    Given Provided Case creation endpoint Url
    When JSON request body with case fields input parameters    
    And Case statusId is as 100
    And Case priority label is as <priority>
    And Case createdBy is as <createdBy>
    And Case updatedBy is as <updatedBy>
    And Case should be commented as <comment>  
    And Case creation API Request called
    Then validate the case id is created  
    And validate response code as 200
    And validate priority as Low
    
 Examples:
|priority|createdBy| updatedBy| comment|
|Low|Paritosh|Paritosh|This is test|
    
    
    

  