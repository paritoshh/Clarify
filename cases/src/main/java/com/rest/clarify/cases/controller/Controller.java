package com.rest.clarify.cases.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.clarify.cases.entity.Cases;
import com.rest.clarify.cases.model.CaseRequest;
import com.rest.clarify.cases.model.CaseResponse;
import com.rest.clarify.cases.service.CreateCase;
import com.rest.clarify.cases.service.DeleteCase;
import com.rest.clarify.cases.service.RetrieveCase;

@RestController
@RequestMapping("/clarify")
public class Controller {
	
	@Autowired
	CreateCase createCase;
	@Autowired
	RetrieveCase retrieveCase;
	@Autowired
	DeleteCase deleteCase;
	
	@PostMapping("/create")
	public ResponseEntity<Cases> createCase(@RequestBody CaseRequest requestCase){
		Cases response = createCase.createNewCase(requestCase);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/case/{id}")
	public CaseResponse findCase(@PathVariable int id) {
		return retrieveCase.getCase(id);
	}
	
	@GetMapping("/cases")
	public List<Cases> findAllCases() {
		return retrieveCase.getAllCases();
	}
	@PutMapping("/case/{id}")
	public void deleteCase(@PathVariable int id) {
		 deleteCase.deleteCase(id);
	}

}
