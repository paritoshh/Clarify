package com.rest.clarify.cases.stepdefination;

import java.net.URI;

import javax.persistence.criteria.CriteriaBuilder.Case;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import com.rest.clarify.cases.entity.Cases;

import io.restassured.specification.RequestSpecification;

public class GetCaseDefinition {

	CommonData cd = new CommonData();
	Cases caseResponse = null;

	@Given("^GET API Case Retrival EndPoint URl$")
	public void get_API_Case_Retrival_EndPoint_URl() {

		String baseCaseUrl = MainTestCase.getValue("baseCaseURL");
		String getIndividualCaseUrl = MainTestCase.getValue("getIndividualCase");
		cd.setEndPointURL(baseCaseUrl + getIndividualCaseUrl);

	}

	@When("^Provide caseId as (\\d+)$")
	public void provide_caseId_as(int arg1) throws Exception {
		String apiEndpointUrl = cd.getEndPointURL() + arg1;
		cd.setApiUrl(apiEndpointUrl);
	}

	@Then("^Call GetAPI to fetch case$")
	public void call_GetAPI_to_fetch_case() {
		RequestSpecification request = null;

		request = RestAssured.given();
		Response response = request.when().get(cd.getApiUrl());// Submit the request
		cd.setResponse(response);
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
	}

	@Then("^Validate HTTP response should be retrieved$")
	public void validate_HTTP_response_should_be_retrieved() {
		Response response=cd.getResponse();
		Assert.assertNotNull("Response of API is null",response);
		
	}

	@Then("^Response HTTP code should be (\\d+)$")
	public void response_HTTP_code_should_be(int responseCode) {
		Response response=cd.getResponse();
		int statusCode=response.getStatusCode();
		Assert.assertEquals("API response code is not"+responseCode,responseCode, statusCode);
	}
	@Then("^CustomerNumber should be as (.+)$")
	public void customernumber_should_be_as(String customerNumber) throws Throwable {
		/*Response response=cd.getResponse();
		System.out.println("In test call"+customerNumber);
		caseResponse = response.getBody().as(Cases.class);
		Assert.assertEquals("Customer name is not correct",customerNumber, caseResponse.getCustomerNumber());*/
		
	}
	@Then("^Response Body should not be null or empty$")
	public void response_Body_should_not_be_null_or_empty()  {
		
	}
}
