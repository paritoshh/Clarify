package com.rest.clarify.cases.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.clarify.cases.repository.CaseJdbcRepository;

@Service
public class DeleteCaseImpl implements DeleteCase{

	@Autowired
	CaseJdbcRepository caseRepo;
	
	@Override
	public void deleteCase(int id) {
		caseRepo.deleteByCaseId(id);
		
	}

}
