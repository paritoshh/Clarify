package com.rest.clarify.cases.stepdefination;

import java.net.URI;

import javax.persistence.criteria.CriteriaBuilder.Case;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import com.rest.clarify.cases.entity.Cases;
import com.rest.clarify.cases.model.CaseRequest;
import com.rest.clarify.cases.model.CaseResponse;

import io.restassured.specification.RequestSpecification;

public class CaseCreationAllFields {
	CaseRequest caseRequest=new CaseRequest();
	CommonData cd=new CommonData();
	@Given("^Provided Case creation endpoint Url$")
	public void provided_Case_creation_endpoint_Url() {
		
		String baseCaseUrl = MainTestCase.getValue("baseCaseURL");
		String createCaseUrl = MainTestCase.getValue("createCaseUrl");
		cd.setEndPointURL(baseCaseUrl + createCaseUrl);
	}

	@When("^JSON request body with case fields input parameters$")
	public void json_request_body_with_case_fields_input_parameters(){
		System.out.println( "Preparing Json Body format");
	}

	@When("^Case statusId is as (\\d+)$")
	public void case_statusId_is_as(int arg1) {
		caseRequest.setStatusId(arg1);
	}

	@When("^Case priority label is as (.+)$")
	public void case_priority_label_is_as(String priority) {
		caseRequest.setPriority(priority);
	}

	@When("^Case createdBy is as (.+)$")
	public void case_createdBy_is_as(String createdBy) {
		caseRequest.setCreatedBy(createdBy);
	}

	@When("^Case updatedBy is as (.+)$")
	public void case_updatedBy_is_as(String updatedBy) {
		caseRequest.setUpdatedBy(updatedBy);
	}

	@When("^Case should be commented as (.+)$")
	public void case_should_be_commented_as(String comment) {
		caseRequest.setComments(comment);
	}
	
	@When("^Case creation API Request called$")
	public void case_creation_API_Request_called() {
		//calling POST API@ Case Creation API
				RequestSpecification request = null;

				request = RestAssured.given();
				Response response = request.contentType(ContentType.JSON).body(caseRequest).post(cd.getEndPointURL());
				cd.setResponse(response);
	}

	@Then("^validate the case id is created$")
	public void validate_the_case_id_is_created() {
		System.out.println("Test");
	}

	@Then("^validate response code as (\\d+)$")
	public void validate_response_code_as(int arg1) {
		System.out.println("Status code is "+cd.getResponse().getStatusCode());
	}

	@Then("^validate priority as (.+)$")
	public void validate_priority_as(String priority) {
		String priorityResponse=cd.getResponse().getBody().as(CaseResponse.class).getPriority();
		Assert.assertEquals("Priority is not matched",priority, priorityResponse);
	}

	}