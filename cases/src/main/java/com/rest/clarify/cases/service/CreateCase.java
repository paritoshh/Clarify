package com.rest.clarify.cases.service;

import com.rest.clarify.cases.entity.Cases;
import com.rest.clarify.cases.model.CaseRequest;

public interface CreateCase {
	
	public Cases createNewCase(CaseRequest newCase);

}
