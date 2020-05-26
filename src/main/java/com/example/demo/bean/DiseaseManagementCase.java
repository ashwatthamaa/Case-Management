package com.example.demo.bean;

import com.example.demo.model.DiseaseManagementCaseVO;

public class DiseaseManagementCase {
	
	public String caseType;
	
	public String breakdownAnimalGroup;
	
	public Integer testNumber;

	/**
	 * 
	 */
	public DiseaseManagementCase() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param caseType
	 * @param breakdownAnimalGroup
	 * @param testNumber
	 */
	public DiseaseManagementCase(String caseType, String breakdownAnimalGroup, Integer testNumber) {
		super();
		this.caseType = caseType;
		this.breakdownAnimalGroup = breakdownAnimalGroup;
		this.testNumber = testNumber;
	}
	
	public static DiseaseManagementCase map(DiseaseManagementCaseVO caseVO) {
		DiseaseManagementCase diseaseManagementCase = new DiseaseManagementCase();
		diseaseManagementCase.setCaseType(caseVO.getCaseType());
		diseaseManagementCase.setBreakdownAnimalGroup(caseVO.getBreakdownAnimalGroup());
		diseaseManagementCase.setTestNumber(caseVO.getTestNumber());
		return diseaseManagementCase;
	}

	public String getCaseType() {
		return caseType;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	public String getBreakdownAnimalGroup() {
		return breakdownAnimalGroup;
	}

	public void setBreakdownAnimalGroup(String breakdownAnimalGroup) {
		this.breakdownAnimalGroup = breakdownAnimalGroup;
	}

	public Integer getTestNumber() {
		return testNumber;
	}

	public void setTestNumber(Integer testNumber) {
		this.testNumber = testNumber;
	}

	@Override
	public String toString() {
		return "DiseaseManagementCase [caseType=" + caseType + ", breakdownAnimalGroup=" + breakdownAnimalGroup
				+ ", testNumber=" + testNumber + "]";
	}	
}
