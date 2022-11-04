package com.test.management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.management.beans.Entities;

@Service
public interface CasesManagementService {
	
	public Entities createEntities(Entities entities);	
	public String updateRelation(String caseNumber,Entities entities);	
	public List<Entities> fetchRelationDetails(String caseNumber);
	
}
