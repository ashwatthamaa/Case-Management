package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DiseaseManagementCase")
public class DiseaseManagementCaseVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ObjectID")
	private Integer objectId;
	
	@Column(name = "CaseNumber")
	private String caseNumber;
	
	@Column(name = "CaseType")
	private String caseType;
	
	@Column(name = "fk_BreakdownTest")
	private Integer testNumber;
	
	@Column(name = "fk_BreakdownAnimalGroup")
	private String breakdownAnimalGroup;

	/**
	 * 
	 */
	public DiseaseManagementCaseVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param objectId
	 * @param caseNumber
	 * @param caseType
	 * @param testNumber
	 * @param breakdownAnimalGroup
	 */
	public DiseaseManagementCaseVO(Integer objectId, String caseNumber, String caseType, Integer testNumber,
			String breakdownAnimalGroup) {
		super();
		this.objectId = objectId;
		this.caseNumber = caseNumber;
		this.caseType = caseType;
		this.testNumber = testNumber;
		this.breakdownAnimalGroup = breakdownAnimalGroup;
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

	public Integer getTestNumber() {
		return testNumber;
	}

	public void setTestNumber(Integer testNumber) {
		this.testNumber = testNumber;
	}

	public String getBreakdownAnimalGroup() {
		return breakdownAnimalGroup;
	}

	public void setBreakdownAnimalGroup(String breakdownAnimalGroup) {
		this.breakdownAnimalGroup = breakdownAnimalGroup;
	}

	@Override
	public String toString() {
		return "DiseaseManagementCaseVO [objectId=" + objectId + ", caseNumber=" + caseNumber + ", caseType=" + caseType
				+ ", testNumber=" + testNumber + ", breakdownAnimalGroup=" + breakdownAnimalGroup + "]";
	}
}
