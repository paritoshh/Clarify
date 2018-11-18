package com.rest.clarify.cases.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.clarify.cases.entity.Cases;
import com.rest.clarify.cases.repository.CaseJdbcRepository;

@Service
public class RetrieveCaseImpl implements RetrieveCase{

	@Autowired
	CaseJdbcRepository caseRepo;
	
	@Override
	public Cases getCase(int id) {
		
		return caseRepo.findByCaseId(id);
	}

	@Override
	public List<Cases> getAllCases() {
		return (List<Cases>) caseRepo.findAll();
	}

}
