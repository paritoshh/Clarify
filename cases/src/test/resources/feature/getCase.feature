
Feature: This feature is to check GET API Case Retrival
@Test1
Scenario Outline: Check user is able to submit GET API request 
Given GET API Case Retrival EndPoint URl 
When Provide caseId as <caseId>
Then Call GetAPI to fetch case
Then Validate HTTP response should be retrieved
And Response HTTP code should be 200
And CustomerNumber should be as <customerNumber>

Examples:
|serviceName|caseId| location| customername|customerNumber|
|case|5|Banglore|NIKE|Ikea00005|
|case|3|Delhi|ADDIDAS|NETTO003|