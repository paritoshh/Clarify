package com.rest.clarify.cases.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.clarify.cases.entity.Cases;
import com.rest.clarify.cases.mapper.CaseMapper;
import com.rest.clarify.cases.model.CaseRequest;
import com.rest.clarify.cases.repository.CaseJdbcRepository;

@Service
public class CreateCaseImpl implements CreateCase{
	
	@Autowired
	private CaseJdbcRepository createJdbcRepo;
	@Autowired
	private CaseMapper caseMapper;

	@Override
	public Cases createNewCase(CaseRequest newCase) {
		
		return createJdbcRepo.save(caseMapper.mapCreateCaseRequest(newCase));
	}

}
