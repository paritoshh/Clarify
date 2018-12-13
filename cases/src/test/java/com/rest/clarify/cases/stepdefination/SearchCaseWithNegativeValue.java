package com.rest.clarify.cases.stepdefination;

import org.junit.Assert;

import com.rest.clarify.cases.entity.Cases;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class SearchCaseWithNegativeValue {
	CommonData cd = new CommonData();
	Cases caseResponse = null;
	
	@Given("^Provided service endpoint URI$")
	public void provided_service_endpoint_URI() {
		String baseCaseUrl = MainTestCase.getValue("baseCaseURL");
		String getIndividualCaseUrl = MainTestCase.getValue("getIndividualCase");
		cd.setEndPointURL(baseCaseUrl + getIndividualCaseUrl);
	}

	@When("^Provided caseId as -(\\d+)$")
	public void provided_caseId_as(int arg1){
		String apiEndpointUrl = cd.getEndPointURL() + arg1;
		cd.setApiUrl(apiEndpointUrl);
	}

	@When("^Call Get API Call Request$")
	public void call_Get_API_Call_Request() {
		RequestSpecification request = null;

		request = RestAssured.given();
		Response response = request.when().get(cd.getApiUrl());// Submit the request
		cd.setResponse(response);
	}

	@Then("^Validate Status code as Bad Request (\\d+)$")
	public void validate_Status_code_as_Bad_Request(int responseCode) {
		Response response=cd.getResponse();
		int statusCode=response.getStatusCode();
		Assert.assertEquals("API response code is not"+responseCode,responseCode, statusCode);
	}

	@Then("^Validate body is null$")
	public void validate_body_is_null() {
		ResponseBody responseBody=cd.getResponse().getBody();
		Assert.assertEquals("Body should be null", null, responseBody);
	}


}
