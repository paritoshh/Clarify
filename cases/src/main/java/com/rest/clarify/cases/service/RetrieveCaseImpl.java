package com.rest.clarify.cases.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.clarify.cases.entity.Cases;
import com.rest.clarify.cases.entity.Customer;
import com.rest.clarify.cases.mapper.CaseMapper;
import com.rest.clarify.cases.model.CaseResponse;
import com.rest.clarify.cases.repository.CaseJdbcRepository;
import com.rest.clarify.cases.repository.CustomerJdbcRepository;

@Service
public class RetrieveCaseImpl implements RetrieveCase{

	@Autowired
	CaseJdbcRepository caseRepo;
	@Autowired
	CustomerJdbcRepository customerRepo;
	@Autowired
	CaseMapper caseMapper;
	
	@Override
	public CaseResponse getCase(int id) {
		
		Cases caseInDB = caseRepo.findByCaseId(id);
		if(caseInDB==null) {
			return null;
		}
		Customer customer = customerRepo.findByCustomerId(caseInDB.getCustomerId());
		if(caseInDB!=null & customer!=null) {
			return caseMapper.mapCreateCaseResoponse(caseInDB, customer);
		}
		if(customer==null) {
			return caseMapper.mapCreateCaseResoponse(caseInDB);
		}
		return null;
		
	}

	@Override
	public List<Cases> getAllCases() {
		return (List<Cases>) caseRepo.findAll();
	}

}
