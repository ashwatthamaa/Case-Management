package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.DiseaseManagementCase;
import com.example.demo.dao.DiseaseManagementCaseDao;
import com.example.demo.model.DiseaseManagementCaseVO;

@Service
public class CaseManagementBM {
	
	@Autowired
	DiseaseManagementCaseDao dao;

	public Integer createEmptyCase() {
		return dao.save(new DiseaseManagementCaseVO(null, null, null, null, null)).getObjectId();
	}
	
	public String createCase(DiseaseManagementCase caseInput) {
		Integer objectId = createEmptyCase();
		String caseNumber = String.format("%s%s%s-%s", caseInput.getCaseType(), caseInput.getBreakdownAnimalGroup(), new SimpleDateFormat("MMyyyy").format(new Date()), objectId);
		DiseaseManagementCaseVO caseVO = dao.findById(objectId).get();
		caseVO.setCaseNumber(caseNumber);
		caseVO.setCaseType(caseInput.getCaseType());
		caseVO.setTestNumber(caseInput.getTestNumber());
		caseVO.setBreakdownAnimalGroup(caseInput.getBreakdownAnimalGroup());
		return dao.save(caseVO).getCaseNumber();
	}
	
	public DiseaseManagementCaseVO getCase(String caseNumber) {
		return dao.findByCaseNumber(caseNumber).get(0);
	}
}
