package com.test.management.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.test.management.beans.Entities;
import com.test.management.beans.EntityToCases;

import com.test.management.repo.EntitiesRepo;
import com.test.management.repo.EntityToCasesRepo;

@Service
public class CasesManagementServiceImpl implements CasesManagementService{

	@Autowired
	private EntitiesRepo entitiesRepo;
	
	@Autowired
	private EntityToCasesRepo entityToCasesRepo;	
	
	@Autowired(required=true)
	EntityToCases entityToCases;
	
	public Entities createEntities(Entities entities) {    	
		return entitiesRepo.save(entities);
	}
	
	
	public String updateRelation(String caseNumber,Entities entities) {		
		entityToCases.setCaseNumber(caseNumber);
		entityToCases.setEntityId(entities.getId());		
		entityToCasesRepo.save(entityToCases);	
		return "UPDATED";
	}
	
	
	public List<Entities> fetchRelationDetails(String caseNumber) {
		List<Entities> entityList = new ArrayList<Entities>();
		List<EntityToCases>  relationList = entityToCasesRepo.findAllById(new ArrayList<Integer>(Integer.parseInt(caseNumber)));
		
		for (EntityToCases entityToCases : relationList) {
			Optional<Entities> optionalEntities = entitiesRepo.findById(entityToCases.getEntityId());
			if(optionalEntities.isPresent())
			 entityList.add(optionalEntities.get());
		}
		return entityList;
	}
}
