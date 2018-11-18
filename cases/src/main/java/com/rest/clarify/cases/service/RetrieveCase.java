package com.rest.clarify.cases.service;

import java.util.List;

import com.rest.clarify.cases.entity.Cases;

public interface RetrieveCase {
	
	public Cases getCase(int id);
	public List<Cases> getAllCases();

}
