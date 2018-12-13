package com.rest.clarify.cases.stepdefination;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class CaseDeletionFunctionality {
	CommonData cd=new CommonData();
	
	@Given("^Provide servide endpointurl$")
	public void provide_servide_endpointurl() {
		String baseCaseUrl = MainTestCase.getValue("baseCaseURL");
		String getIndividualCase = MainTestCase.getValue("getIndividualCase");
		cd.setEndPointURL(baseCaseUrl + getIndividualCase);
	}

	@Given("^Provide caseID as (\\d+)$")
	public void provide_caseID_as(int arg1) {
		String apiEndpointUrl = cd.getEndPointURL() + arg1;
		cd.setApiUrl(apiEndpointUrl);
	}

	@When("^Call delete request API to delete the case$")
	public void call_delete_request_API_to_delete_the_case() {
		RequestSpecification request = null;

		request = RestAssured.given();
		Response response = request.when().delete(cd.getApiUrl());// Submit the request
		cd.setResponse(response);
	}

	@Then("^Validate service response code should be OK (\\d+)$")
	public void validate_service_response_code_should_be_OK(int arg1) {
		int responseStatusCode =cd.getResponse().getStatusCode();
		Assert.assertEquals("Status code is not matched to"+responseStatusCode,  responseStatusCode, arg1);
	}

	@Then("^Validate case got deleted as body will be null$")
	public void validate_case_got_deleted_as_body_will_be_null() {
		ResponseBody resBody=cd.getResponse().getBody();
		Assert.assertEquals("Case is not deleted as body is fetching", null, resBody);
	}

}
