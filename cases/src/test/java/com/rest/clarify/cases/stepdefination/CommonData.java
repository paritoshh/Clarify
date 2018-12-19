package com.rest.clarify.cases.stepdefination;

import io.restassured.response.Response;

public  class CommonData {
	
	private String endPointURL;
	public Response response;
	private String apiUrl;
	int caseCount ;
	
	public int getCaseCount() {
		return caseCount;
	}
	public void setCaseCount(int caseCount) {
		this.caseCount = caseCount;
	}
	public Response getResponse() {
		return response;
	}
	public void setResponse(Response response) {
		this.response = response;
	}
	public String getEndPointURL() {
		return endPointURL;
	}
	public void setEndPointURL(String endPointURL) {
		this.endPointURL = endPointURL;
	}
	public String getApiUrl() {
		return apiUrl;
	}
	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}
	
	
}
