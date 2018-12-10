package com.rest.clarify.cases.service;

import java.util.List;

import com.rest.clarify.cases.entity.Cases;
import com.rest.clarify.cases.model.CaseResponse;

public interface RetrieveCase {
	
	public CaseResponse getCase(int id);
	public List<Cases> getAllCases();

}
