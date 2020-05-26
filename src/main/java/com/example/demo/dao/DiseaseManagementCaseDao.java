package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DiseaseManagementCaseVO;

@Repository
public interface DiseaseManagementCaseDao extends JpaRepository<DiseaseManagementCaseVO, Integer>{
	
	List<DiseaseManagementCaseVO> findByCaseNumber(String caseNumber);
}
