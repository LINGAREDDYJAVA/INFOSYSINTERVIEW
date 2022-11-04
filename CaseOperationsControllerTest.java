package com.test.management.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.management.beans.Entities;
import com.test.management.service.CasesManagementService;

@WebMvcTest(CaseOperationsController.class)
public class CaseOperationsControllerTest {

	 @MockBean
	 CasesManagementService service;

	  @Autowired
	  private MockMvc mockMvc;

	  @Autowired
	  private ObjectMapper objectMapper;
	  
	  @Test
	  public void createEntitiesTest() throws JsonProcessingException, Exception {
		  Entities entities = new Entities();
		  mockMvc.perform(post("/entities").contentType(org.springframework.http.MediaType.APPLICATION_JSON)
			        .content(objectMapper.writeValueAsString(entities)))
			        .andExpect(status().is2xxSuccessful())
			        .andDo(print());
	 }
	  
	 @Test
	 public void updateRelation() throws Exception {
		 Entities entities = new Entities();
		 entities.setId(1);
		 entities.setCompany_name("abc");
		mockMvc.perform(post("/cases/{caseNumber}/entities","ZA").param("caseNumber","ZA").contentType(org.springframework.http.MediaType.APPLICATION_JSON)
		        .content(objectMapper.writeValueAsString(entities)))
		        .andExpect(status().is2xxSuccessful())
		        .andDo(print());
	 }
	 
	 
	 @Test
	 public void fetchRelationDetails() throws Exception {		
		mockMvc.perform(get("/cases/{caseNumber}/entities","ZA").param("caseNumber","ZA").contentType(org.springframework.http.MediaType.APPLICATION_JSON)
		        .content(objectMapper.writeValueAsString("")))
		        .andExpect(status().is2xxSuccessful())
		        .andDo(print());
	 }

}
