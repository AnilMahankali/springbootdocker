package com.demo.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.Application;
import com.demo.controller.NoteRecordController;
import com.demo.data.PolicyData;
import com.demo.repo.PcdngContentExtractRepository;
import com.demo.repo.StndDocumentExtrctPurpsRepository;
import com.demo.service.ProceedingContentExtractService;
import com.demo.util.PTABBusinessUtils;

import junit.framework.Assert;


@RunWith(SpringRunner.class)
@SpringBootTest(classes= {
		Application.class,
		NoteRecordController.class,
		ProceedingContentExtractService.class,
		StndDocumentExtrctPurpsRepository.class,
		PcdngContentExtractRepository.class,
		PTABBusinessUtils.class
		
},
webEnvironment=WebEnvironment.RANDOM_PORT)
public class NoteRecordControllerTest {

	@LocalServerPort
    int randomServerPort = 8080;
	
	@Autowired
	private TestRestTemplate template;
     
	@Test
	public void testAddEmployeeWithoutHeader_success() throws URISyntaxException 
	{
	     
	    final String baseUrl = "http://localhost:"+randomServerPort+"/noteRecord/save";
	    URI uri = new URI(baseUrl);
	     
	    PolicyData employee = new PolicyData();
	 
	    ResponseEntity<Object> result = template.postForEntity(uri, employee, Object.class);
	     
	    //Verify request succeed
	    Assert.assertEquals(200, result.getStatusCodeValue());
	}
}
