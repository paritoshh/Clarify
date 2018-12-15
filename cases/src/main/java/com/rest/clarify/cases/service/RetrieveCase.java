package com.rest.clarify.cases.service;

import java.util.List;

import com.rest.clarify.cases.model.CaseResponse;
import com.rest.clarify.cases.model.CaseResponseList;

public interface RetrieveCase {
	
	public CaseResponse getCase(int id);
	public List<CaseResponse> getAllCases();
	public CaseResponseList getAllCasesByCustomerId(Integer id);

}
