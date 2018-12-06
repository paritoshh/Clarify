Feature: Cases can be fetched

@Test
	Scenario: client makes call to GET /case API
	Given I have GET URL
	When hit the URL
	Then the client receives status code 200