package com.example.demo.bean;

import com.example.demo.model.DiseaseManagementCaseVO;

public class DiseaseManagementCaseResponse {
	
	private Integer objectId;
	
	private String caseNumber;
	
	private String caseType;
	
	private Integer fkBreakdownTest;
	
	private Integer fkBreakdownAnimalGroup;

	/**
	 * 
	 */
	public DiseaseManagementCaseResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param objectId
	 * @param caseNumber
	 * @param caseType
	 * @param fkBreakdownTest
	 * @param fkBreakdownAnimalGroup
	 */
	public DiseaseManagementCaseResponse(Integer objectId, String caseNumber, String caseType, Integer fkBreakdownTest,
			Integer fkBreakdownAnimalGroup) {
		super();
		this.objectId = objectId;
		this.caseNumber = caseNumber;
		this.caseType = caseType;
		this.fkBreakdownTest = fkBreakdownTest;
		this.fkBreakdownAnimalGroup = fkBreakdownAnimalGroup;
	}
	
	public static DiseaseManagementCaseResponse map(DiseaseManagementCaseVO caseVO) {
		DiseaseManagementCaseResponse response = new DiseaseManagementCaseResponse();
		response.setObjectId(caseVO.getObjectId());
		response.setCaseNumber(caseVO.getCaseNumber());
		response.setCaseType(caseVO.getCaseType());
		response.setFkBreakdownTest(caseVO.getTestNumber());
		response.setFkBreakdownAnimalGroup(caseVO.getBreakdownAnimalGroup());
		return response;
	}

	public Integer getObjectId() {
		return objectId;
	}

	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
	}

	public String getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}

	public String getCaseType() {
		return caseType;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	public Integer getFkBreakdownTest() {
		return fkBreakdownTest;
	}

	public void setFkBreakdownTest(Integer fkBreakdownTest) {
		this.fkBreakdownTest = fkBreakdownTest;
	}

	public Integer getFkBreakdownAnimalGroup() {
		return fkBreakdownAnimalGroup;
	}

	public void setFkBreakdownAnimalGroup(Integer fkBreakdownAnimalGroup) {
		this.fkBreakdownAnimalGroup = fkBreakdownAnimalGroup;
	}

	@Override
	public String toString() {
		return "DiseaseManagementCaseResponse [objectId=" + objectId + ", caseNumber=" + caseNumber + ", caseType="
				+ caseType + ", fkBreakdownTest=" + fkBreakdownTest + ", fkBreakdownAnimalGroup="
				+ fkBreakdownAnimalGroup + "]";
	}
}
