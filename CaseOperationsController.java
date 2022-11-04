package com.test.management.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.test.management.beans.Entities;
import com.test.management.service.CasesManagementService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@Api(value="cases-management-api")
public class CaseOperationsController {
	
	@Autowired
	CasesManagementService service;
	
    
    @ApiOperation(value = "create Entities",response = Entities.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Entities created Successfully"),
            @ApiResponse(code = 500, message = "Entities creation Failed"),
    })
	@RequestMapping(method =RequestMethod.POST,value = "/entities")
	public Entities createEntities(@RequestBody Entities entities) {    	
		return service.createEntities(entities);
	}
        
    
    
    @ApiOperation(value = "Relation Update",response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "case and entitiy relation updated Successfully"),
            @ApiResponse(code = 500, message = "relation Updation Failed"),
    })
	@RequestMapping(method =RequestMethod.POST,value = "/cases/{caseNumber}/entities")
	public String updateRelation(@RequestParam("caseNumber") String caseNumber, @RequestBody Entities entities) {
    	try {
    		return service.updateRelation(caseNumber, entities);
		} catch (Exception e) {
			e.printStackTrace();
			return "FAILED";
		}		
	}
    
    
    
    @ApiOperation(value = "fetch Relation Details",response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "relationship details fetched Successfully"),
            @ApiResponse(code = 500, message = "fetch Failed"),
    })
	@RequestMapping(method =RequestMethod.GET,value = "/cases/{caseNumber}/entities")
	public List<Entities> fetchRelationDetails(@RequestParam("caseNumber") String caseNumber) {
		return service.fetchRelationDetails(caseNumber);
	}

}
