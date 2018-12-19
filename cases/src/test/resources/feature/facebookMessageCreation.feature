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
Feature: Message writing

  @FacebookTest2
  Scenario Outline: Writing message after login to facebook application
    Given User is on Loginpage
    And User enter Username
    And User enter Password
    When User click on LogIn button
    Then User should able to login successfully
    Then User send message to <friends>
    Then User minimize the message tab and close the tab
    Then User logout the facebook application
    Then User close the browser
    

    Examples: 
      | friends          |
      | Paritosh Agarwal |
