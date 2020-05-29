package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.bean.AnimalGroupTO;
import com.example.demo.bean.DiseaseManagementCaseRequest;
import com.example.demo.dao.DiseaseManagementCaseDao;
import com.example.demo.model.DiseaseManagementCaseVO;

@Service
public class CaseManagementBM {
	
	@Autowired
	DiseaseManagementCaseDao dao;
	
	@Autowired
	@LoadBalanced
	RestTemplate restTemplate;

	public Integer createEmptyCase() {
		return dao.save(new DiseaseManagementCaseVO(null, null, null, null, null)).getObjectId();
	}
	
	public String createCase(DiseaseManagementCaseRequest caseInput) {
		Integer objectId = createEmptyCase();
		String caseNumber = String.format("%s%s%s-%s", caseInput.getCaseType(), caseInput.getBreakdownAnimalGroup(), new SimpleDateFormat("MMyyyy").format(new Date()), objectId);
		DiseaseManagementCaseVO caseVO = dao.findById(objectId).get();
		caseVO.setCaseNumber(caseNumber);
		caseVO.setCaseType(caseInput.getCaseType());
		caseVO.setTestNumber(caseInput.getTestNumber());
		caseVO.setBreakdownAnimalGroup(getAnimalGroupId(caseInput.getBreakdownAnimalGroup()));
		return dao.save(caseVO).getCaseNumber();
	}
	
	private Integer getAnimalGroupId(String breakdownAnimalGroup) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		String uri = "http://animal-group-registration/get-animal-group-details/" + breakdownAnimalGroup;
		UriComponents builder = UriComponentsBuilder.fromHttpUrl(uri).build();
		HttpEntity<String> requestEntity = new HttpEntity<String>(null, headers);
		ResponseEntity<AnimalGroupTO> responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, requestEntity, AnimalGroupTO.class);
		return responseEntity.getBody().getId();
	}

	public DiseaseManagementCaseVO getCase(String caseNumber) {
		return dao.findByCaseNumber(caseNumber).get(0);
	}
}
