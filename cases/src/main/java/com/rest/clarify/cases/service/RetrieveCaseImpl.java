package com.rest.clarify.cases.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.clarify.cases.entity.Cases;
import com.rest.clarify.cases.mapper.CaseMapper;
import com.rest.clarify.cases.model.CaseResponse;
import com.rest.clarify.cases.repository.CaseJdbcRepository;

@Service
public class RetrieveCaseImpl implements RetrieveCase{

	@Autowired
	CaseJdbcRepository caseRepo;
	@Autowired
	CaseMapper caseMapper;
	
	@Override
	public CaseResponse getCase(int id) {
		
		return caseMapper.mapCreateCaseResoponse(caseRepo.findByCaseId(id));
	}

	@Override
	public List<Cases> getAllCases() {
		return (List<Cases>) caseRepo.findAll();
	}

}
