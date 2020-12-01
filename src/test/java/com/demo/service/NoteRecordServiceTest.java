package com.demo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.demo.data.PolicyDTO;
import com.demo.data.PolicyData;
import com.demo.util.CommonResponseModel;

@RunWith(MockitoJUnitRunner.class)
public class NoteRecordServiceTest {

	@Mock
	RestTemplate restTemplateMock;
	
	NoteRecordServiceImpl<PolicyData> noteRecordService = new NoteRecordServiceImpl<PolicyData>();
	
	@Before
	public void setUp() {
		noteRecordService.restTemplate = restTemplateMock;
	}
	
	@Test
	public void test_getData() {
		
		ResponseEntity<Object> mocked = this.setResponseEntity();
		CommonResponseModel mockedResponseModel = new CommonResponseModel();
		mockedResponseModel.setResponseData(mocked);
		mockedResponseModel.setResponseData(this.setResponse());
		Mockito.when(restTemplateMock.getForEntity(Mockito.anyString(), any(Class.class))).thenReturn(mocked);
        String id = "1";
		CommonResponseModel rs = noteRecordService.doGet(id);
		if (rs != null) {
			assertTrue(rs.getSuccess());
			assertEquals("Data returned successfully!", rs.getMessage());
		} else {
			assertFalse("No Response", (rs != null));
		}
		
	}
	
	@Test
	public void test_postData() {
		
		ResponseEntity<Object> mocked = this.setResponseEntity();
		CommonResponseModel mockedResponseModel = new CommonResponseModel();
		mockedResponseModel.setResponseData(mocked);
		mockedResponseModel.setResponseData(this.setResponse());
		Mockito.when(restTemplateMock.postForEntity(Mockito.anyString(), Mockito.anyObject(), 
				any(Class.class), Mockito.anyString())).thenReturn(mocked);
		
//		ResponseEntity<T> responseEntity = 
//				(ResponseEntity<T>) restTemplate.postForEntity(url, requestEntity, Object.class, type);
		
		PolicyData proceedingContentExtract = new PolicyData();
		CommonResponseModel rs = noteRecordService.doPost(proceedingContentExtract);
		if (rs != null) {
			assertTrue(rs.getSuccess());
			assertEquals("Saving data successfully!", rs.getMessage());
		} else {
			assertFalse("No Response", (rs != null));
		}
		
	}
	
	//initial some parameters and mocked outputs
		public ResponseEntity<Object> setResponseEntity(){
			List<Map> ls = new ArrayList<>();
			Map<String, Object> params = new HashMap<>();
			params.put("id", "1");
			
			ls.add(params);
			ResponseEntity<Object> entity = new  ResponseEntity<Object>(ls, HttpStatus.OK);	
			return entity;	
		}
		
		public List<PolicyDTO> setResponse(){
			List<PolicyDTO> list = new ArrayList<>();
			PolicyDTO data = new PolicyDTO();
				PolicyData rs = new PolicyData();
				rs.setProceedingCoreId("1");
				rs.setDescriptionTx("descriptionTx");
			data.setRequestData(rs);
			
			list.add(data);
			return list;
		}	
}
