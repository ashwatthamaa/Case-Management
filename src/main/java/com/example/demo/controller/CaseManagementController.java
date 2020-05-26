package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.DiseaseManagementCase;
import com.example.demo.service.CaseManagementBM;

@RestController
@RequestMapping(value="/case-management")
public class CaseManagementController{
	
	@Autowired
	CaseManagementBM service;
	
	@RequestMapping(value="/create-case", method=RequestMethod.POST)
	public ResponseEntity<?> createCase(@RequestBody DiseaseManagementCase diseaseManagementCase) {
		String caseNumber = service.createCase(diseaseManagementCase);
		return new ResponseEntity<String>(caseNumber, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{case-number}")
	public ResponseEntity<?> getCase(@PathVariable("case-number") String caseNumber) {
		return new ResponseEntity<DiseaseManagementCase>(DiseaseManagementCase.map(service.getCase(caseNumber)), HttpStatus.OK);
	}
}
