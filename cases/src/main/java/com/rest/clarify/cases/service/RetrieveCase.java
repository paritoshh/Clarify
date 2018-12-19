package com.rest.clarify.cases.service;

import com.rest.clarify.cases.model.CaseResponse;
import com.rest.clarify.cases.model.CaseResponseList;

public interface RetrieveCase {
	
	public CaseResponse getCase(int id);
	public CaseResponseList getAllCases();
	public CaseResponseList getAllCasesByCustomerId(Integer id);

}
