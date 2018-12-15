package com.rest.clarify.cases.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.clarify.cases.entity.Cases;
import com.rest.clarify.cases.exception.GenericException;
import com.rest.clarify.cases.mapper.CaseMapper;
import com.rest.clarify.cases.model.CaseRequest;
import com.rest.clarify.cases.repository.CaseJdbcRepository;
import com.rest.clarify.cases.repository.CustomerJdbcRepository;

@Service
public class CreateCaseImpl implements CreateCase{
	
	@Autowired
	private CaseJdbcRepository createJdbcRepo;
	@Autowired
	private CaseMapper caseMapper;
	@Autowired
	private CustomerJdbcRepository customerRepository;

	@Override
	public Cases createNewCase(CaseRequest newCase) {
		
		if(customerRepository.findByCustomerId(newCase.getCustomerId())==null) {
			throw new GenericException("No customer found with id "+newCase.getCustomerId());
		}
		return createJdbcRepo.save(caseMapper.mapCreateCaseRequest(newCase));
	}

}
