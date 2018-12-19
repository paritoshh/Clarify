package com.rest.clarify.cases.stepdefination;

import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import org.junit.Assert;

import com.rest.clarify.cases.entity.Cases;
import com.rest.clarify.cases.model.CaseRequest;
import com.rest.clarify.cases.model.CaseResponse;
import com.rest.clarify.cases.model.CaseResponseList;

import io.restassured.specification.RequestSpecification;

public class CaseCreationAllFields {
	CaseRequest caseRequest=new CaseRequest();
	CommonData cd=new CommonData();
	public void setNewCaseCreationPostEndPointURL() {
		String baseCaseUrl = MainTestCase.getValue("baseCaseURL");
		String createCaseUrl = MainTestCase.getValue("createCaseUrl");
		cd.setEndPointURL(baseCaseUrl + createCaseUrl);
	}
	
	public void fetchCaseByCaseIdGetEndpointUrl() {
		String baseCaseUrl = MainTestCase.getValue("baseCaseURL");
		String getIndividualCaseUrl = MainTestCase.getValue("getIndividualCase");
		cd.setEndPointURL(baseCaseUrl + getIndividualCaseUrl);

	}
	public void apiPOSTCall_CaseCreation() {
		RequestSpecification request = null;

		request = RestAssured.given();
		Response response = request.contentType(ContentType.JSON).body(caseRequest).post(cd.getEndPointURL());
		cd.setResponse(response);
	}
	public void apiGET_Case_Call() {
		RequestSpecification request = null;

		request = RestAssured.given();
		Response response = request.when().get(cd.getApiUrl());// Submit the request
		cd.setResponse(response);
	}
	public void apiDELETECall() {
		RequestSpecification request = null;

		request = RestAssured.given();
		Response response = request.when().delete(cd.getApiUrl());// Submit the request
		cd.setResponse(response);
	}
	
	public void responseHTTPCode(int responseCode ){
		int responseStatusHTTPCode=cd.getResponse().getStatusCode();
		Assert.assertEquals("HTTP Response Code is not matching as : "+responseCode, responseCode, responseStatusHTTPCode);	
	}
	
	@Given("^Provided Case creation endpoint Url$")
	public void provided_Case_creation_endpoint_Url() {
		setNewCaseCreationPostEndPointURL();
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
				apiPOSTCall_CaseCreation();
	}

	@Then("^validate the case id is created$")
	public void validate_the_case_id_is_created() {
		System.out.println("Test");
	}

	@Then("^validate response code as (\\d+)$")
	public void validate_response_code_as(int responseCode) {
		responseHTTPCode(responseCode);
		}

	@Then("^validate priority as (.+)$")
	public void validate_priority_as(String priority) {
		String priorityResponse=cd.getResponse().getBody().as(CaseResponse.class).getPriority();
		Assert.assertEquals("Priority is not matched",priority, priorityResponse);
	}
	
	/*CaseCreationByInvalidCustomerId
	 * 
	 */
	@When("^Non-exist customerId as (\\d+)$")
	public void non_exist_customerId_as(int customerId) {
		caseRequest.setCustomerId(customerId);
	}

	@Then("^Validate response status as (\\d+)$")
	public void validate_response_status_as(int responseCode) {
		responseHTTPCode(responseCode);
	}

	@Then("^Validate response HTTP error  as (.+)$")
	public void validate_response_HTTP_error_as(String error) {
		String responseError=cd.getResponse().jsonPath().getString("error");
		System.out.println("TESTINg========="+responseError);
		Assert.assertEquals("HTTP Response Code is not matching as : "+error, error, responseError);
	}

	@Then("^Validate response message as \"([^\"]*)\"$")
	public void validate_response_message_as(String message) {
		
		String responseError=cd.getResponse().jsonPath().getString("message");
		System.out.println("TESTINg========="+responseError);
		Assert.assertEquals("HTTP Response Code is not matching as : "+message, message, responseError);
	}
	
	/*
	 * CaseDeletionFunctionality
	 */
	
	@Given("^Provide servide endpointurl$")
	public void provide_servide_endpointurl() {
		fetchCaseByCaseIdGetEndpointUrl();
	}

	@Given("^Provide caseID as (\\d+)$")
	public void provide_caseID_as(int arg1) {
		String apiEndpointUrl = cd.getEndPointURL() + arg1;
		cd.setApiUrl(apiEndpointUrl);
	}

	@When("^Call delete request API to delete the case$")
	public void call_delete_request_API_to_delete_the_case() {
		apiDELETECall();
	}

	@Then("^Validate service response code should be OK (\\d+)$")
	public void validate_service_response_code_should_be_OK(int responseCode) {
		responseHTTPCode(responseCode);
		}

	@Then("^Validate case got deleted as body will be null$")
	public void validate_case_got_deleted_as_body_will_be_null() {
		ResponseBody resBody=cd.getResponse().getBody();
		Assert.assertEquals("Case is not deleted as body is fetching", null, resBody);
	}
	
	/*
	 * GetCaseDefinition
	 */
	Cases caseResponse = null;

	@Given("^GET API Case Retrival EndPoint URl$")
	public void get_API_Case_Retrival_EndPoint_URl() {
		fetchCaseByCaseIdGetEndpointUrl();
	}

	@When("^Provide caseId as (\\d+)$")
	public void provide_caseId_as(int arg1) throws Exception {
		String apiEndpointUrl = cd.getEndPointURL() + arg1;
		cd.setApiUrl(apiEndpointUrl);
	}

	@Then("^Call GetAPI to fetch case$")
	public void call_GetAPI_to_fetch_case() {
		apiGET_Case_Call();
	}

	@Then("^Validate HTTP response should be retrieved$")
	public void validate_HTTP_response_should_be_retrieved() {
		Response response=cd.getResponse();
		Assert.assertNotNull("Response of API is null",response);
		
	}

	@Then("^Response HTTP code should be (\\d+)$")
	public void response_HTTP_code_should_be(int responseCode) {
		responseHTTPCode(responseCode);
		
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
	/*
	 * SearchByCustomerId
	 */
	@Given("^Provide service endpoint URL$")
	public void provide_service_endpoint_URL() {
		String baseCaseUrl = MainTestCase.getValue("baseCaseURL");
		String caseByCustomerId = MainTestCase.getValue("caseByCustomerId");
		cd.setEndPointURL(baseCaseUrl + caseByCustomerId);
	}

	@Given("^Provide customer id to search the case as (\\d+)$")
	public void provide_customer_id_to_search_the_case_as(int customerId) {
		String apiEndpointUrl = cd.getEndPointURL() + customerId;
		cd.setApiUrl(apiEndpointUrl);
	}

	@When("^Request service API$")
	public void request_service_API() {
		apiGET_Case_Call();
	}

	@Then("^Validate service status code as (\\d+)$")
	public void validate_service_status_code_as(int responseCode) {
		responseHTTPCode(responseCode);
	}

	@Then("^Validate the customer_id as (\\d+)$")
	public void validate_the_customer_id_as(int customerId) {
		
		List<CaseResponse> responseArr = cd.getResponse().getBody().as(CaseResponseList.class).getCaseResponseList();

		int responseCustomerId=responseArr.get(0).getCustomerId();
		
		 Assert.assertEquals("Customer is not equal to: "+customerId, customerId,responseCustomerId);
		
	}

	@Then("^Count the number of cases fetch with this customer_id$")
	public void count_the_number_of_cases_fetch_with_this_customer_id() {
		
	
		List<CaseResponse> responseArr = cd.getResponse().getBody().as(CaseResponseList.class).getCaseResponseList();
		int caseCount= responseArr.size();
		cd.setCaseCount(caseCount);
		System.out.println("Number of cases fetched :"+caseCount);

	}

	@Then("^Validate the customerFirstName with (.+)$")
	public void validate_the_customerFirstName_with(String name) {
		
		List<CaseResponse> responseArr = cd.getResponse().getBody().as(CaseResponseList.class).getCaseResponseList();
	
		for( int i=1;i<=cd.getCaseCount();i++) {
		String responseCustomerName = responseArr.get(0).getCustomerFName();
		Assert.assertEquals("Customer Name is not equal to: " + name, name, responseCustomerName);
		System.out.println("test");
		}
	}

/*
 * SearchCaseWithNegativeValue	
 */
	@Given("^Provided service endpoint URI$")
	public void provided_service_endpoint_URI() {
		fetchCaseByCaseIdGetEndpointUrl();
	}

	@When("^Provided caseId as -(\\d+)$")
	public void provided_caseId_as(int arg1){
		String apiEndpointUrl = cd.getEndPointURL() + arg1;
		cd.setApiUrl(apiEndpointUrl);
	}

	@When("^Call Get API Call Request$")
	public void call_Get_API_Call_Request() {
		apiGET_Case_Call();
	}

	@Then("^Validate Status code as Bad Request (\\d+)$")
	public void validate_Status_code_as_Bad_Request(int responseCode) {
		responseHTTPCode(responseCode);
		}

	@Then("^Validate body is null$")
	public void validate_body_is_null() {
		ResponseBody responseBody=cd.getResponse().getBody();
		Assert.assertEquals("Body should be null", null, responseBody);
	}

	}