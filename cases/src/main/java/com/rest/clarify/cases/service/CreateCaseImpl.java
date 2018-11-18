package com.rest.clarify.cases.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.clarify.cases.entity.Cases;
import com.rest.clarify.cases.repository.CaseJdbcRepository;

@Service
public class CreateCaseImpl implements CreateCase{
	
	@Autowired
	private CaseJdbcRepository createJdbcRepo;

	@Override
	public Cases createNewCase(Cases newCase) {
		
		return createJdbcRepo.save(newCase);
	}

}
