package com.rest.clarify.cases.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.clarify.cases.entity.Cases;
import com.rest.clarify.cases.entity.Customer;
import com.rest.clarify.cases.exception.CaseNotFoundException;
import com.rest.clarify.cases.exception.GenericException;
import com.rest.clarify.cases.mapper.CaseMapper;
import com.rest.clarify.cases.model.CaseResponse;
import com.rest.clarify.cases.model.CaseResponseList;
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
			throw new CaseNotFoundException("No case found for id "+id);
		}
		Customer customer = getCustomerDetailsById(caseInDB.getCustomerId());
		if(caseInDB!=null & customer!=null) {
			return caseMapper.mapCreateCaseResoponse(caseInDB, customer);
		}
		if(customer==null) {
			return caseMapper.mapCreateCaseResoponse(caseInDB);
		}
		throw new GenericException("Something went wrong");
	}

	@Override
	public List<CaseResponse> getAllCases() {
		List<CaseResponse> caseResponses = new ArrayList<>();
		List<Cases> cases = (List<Cases>) caseRepo.findAll();
		cases.stream().forEach(eachCase->{
			caseResponses.add(caseMapper.mapCreateCaseResoponse(eachCase, getCustomerDetailsById(eachCase.getCustomerId())));
		});
		return caseResponses;
	}

	@Override
	public CaseResponseList getAllCasesByCustomerId(Integer id) {
		
		List<Cases> cases = (List<Cases>) caseRepo.findByCustomerId(id);
		List<CaseResponse> caseResponses = new ArrayList<>();
		Customer customer = getCustomerDetailsById(id);
		cases.stream().forEach(caseElement->{
			caseResponses.add(caseMapper.mapCreateCaseResoponse(caseElement,customer));
		});
		return CaseResponseList.builder().caseResponseList(caseResponses).build();
	}
	
	private Customer getCustomerDetailsById(Integer id) {
		return customerRepo.findByCustomerId(id);
	}

}
