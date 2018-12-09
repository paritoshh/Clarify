
Feature: This feature is to check GET API Case Retrival

Scenario Outline: Check user is able to submit GET API request 
Given GET API Case Retrival EndPoint URl 
When Provide CaseID
And Set HEADER param request content type as "application/json"
And Set HEADER param response accept type as "application/json"
Then Validate HTTP response should be retrieved
And Response HTTP code should be 200
And Response Header content type should be "application/json"
And Response Body should not be null or empty

Examples:
|service name|Case ID|
|case|5|
|case|3|