package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.WebRequest;

import com.demo.util.CommonResponseModel;
import com.demo.util.Utils;
import lombok.extern.slf4j.Slf4j;

@Component
@Service
@Slf4j
public class NoteRecordServiceImpl<T> implements NoteRecordService<T> {
	
	@Autowired
	public RestTemplate restTemplate;
	

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
	
	private CommonResponseModel get(String id, String string) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		String url = "https://postman-echo.com/get?";
		try {

			ResponseEntity<T> responseEntity = 
					(ResponseEntity<T>) restTemplate.getForEntity(url+"id="+id, Object.class);
			//return (T)responseEntity.getBody();
			
			if(responseEntity.getBody() != null && responseEntity.getStatusCodeValue() == 200) {
				T obj = responseEntity.getBody();
				CommonResponseModel response = new CommonResponseModel();
				  response.setSuccess(true);
				  response.setTotalCount("1");
				  response.setMessage("Data returned successfully!");
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
	    	Utils.exceptionHandler(url, invokeExp);
		}
		return new CommonResponseModel(false,"There is something wrong! Nothing in progress!",null);
	}
	
	@Override
	public CommonResponseModel doGet(String id) {
		return get(id, "GET");
	}
	
	@Override
	public CommonResponseModel doPost(T proceedingContentExtract) {
		return service(proceedingContentExtract, "POST");
	}
	
	@Override
	public CommonResponseModel doPut(T proceedingContentExtract) {
		return service(proceedingContentExtract, "PUT");
	}

}
