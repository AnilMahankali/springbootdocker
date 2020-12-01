package com.demo.controller;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.demo.data.PolicyDTO;
import com.demo.data.PolicyData;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class NoteRecordControllerTest2 {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testSave_success() throws Exception 
	{
	     
	    PolicyDTO policyDto = new PolicyDTO();
	    	PolicyData policy = new PolicyData();
	    policyDto.setRequestData(policy);

	    mockMvc.perform(MockMvcRequestBuilders.post("/noteRecord/save")
	    		.content(new ObjectMapper().writeValueAsString(policyDto))
	    	      .contentType(MediaType.APPLICATION_JSON)
	    	      .accept(MediaType.APPLICATION_JSON))
	    	      .andExpect(MockMvcResultMatchers.status().isOk())
	    		  .andReturn();
	}
	
	@Test
	public void testUpdate_success() throws Exception 
	{
	     
	    PolicyDTO policyDto = new PolicyDTO();
	    	PolicyData policy = new PolicyData();
	    policyDto.setRequestData(policy);

	    mockMvc.perform(MockMvcRequestBuilders.put("/noteRecord/update")
	    		.content(new ObjectMapper().writeValueAsString(policyDto))
	    	      .contentType(MediaType.APPLICATION_JSON)
	    	      .accept(MediaType.APPLICATION_JSON))
	    	      .andExpect(MockMvcResultMatchers.status().isOk())
	    		  .andReturn();
	}
	
	
	@Test
	public void testGet_success() throws Exception 
	{
	     
	    PolicyDTO policyDto = new PolicyDTO();
	    	PolicyData policy = new PolicyData();
	    policyDto.setRequestData(policy);

	    mockMvc.perform(MockMvcRequestBuilders.get("/noteRecord/get?id=1")
	    	      .accept(MediaType.APPLICATION_JSON))
	    		  .andExpect(MockMvcResultMatchers.status().isOk());
	    
	}
}
