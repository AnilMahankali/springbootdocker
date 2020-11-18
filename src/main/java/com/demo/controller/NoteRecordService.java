package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.WebRequest;

import com.demo.util.CommonResponseModel;
import com.demo.util.Utils;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NoteRecordService<T> {
	
	@Autowired
	private RestTemplate restTemplate;
	

	public CommonResponseModel service(T proceedingContentExtract, String type) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		String url = "https://postman-echo.com/post";
		try {

			HttpEntity<T> requestEntity = new HttpEntity<>(proceedingContentExtract, headers);
	
			
			ResponseEntity<T> responseEntity = 
					(ResponseEntity<T>) restTemplate.postForEntity(url, requestEntity, Object.class, type);
			//return (T)responseEntity.getBody();
			
			if(responseEntity.getBody() != null && responseEntity.getStatusCodeValue() == 200) {
				T obj = responseEntity.getBody();
				CommonResponseModel response = new CommonResponseModel();
				  response.setSuccess(true);
				  response.setTotalCount("1");
				  response.setMessage("Saving data successfully!");
				  response.setResponseData(obj);
				return response;
			}else {
				return new CommonResponseModel(false,
													 "Failed to find "+ responseEntity.getBody(),
													 null
													 );
			}
		}
		catch(RestClientException invokeExp) {
	    	//log.info("Exception by calling process api: {}, {}", url, invokeExp.getMessage());
	    	Utils.exceptionHandler(url, invokeExp);
		}
		return new CommonResponseModel(false,"There is something wrong! Nothing in progress!",null);
	}
	
	public CommonResponseModel doPost(T proceedingContentExtract) {
		return service(proceedingContentExtract, "POST");
	}
	
	public CommonResponseModel doPut(T proceedingContentExtract) {
		return service(proceedingContentExtract, "PUT");
	}

}
