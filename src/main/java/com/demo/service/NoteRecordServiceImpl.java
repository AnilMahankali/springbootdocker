package com.demo.service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Base64.Encoder;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.demo.util.ResponseModel;
import com.demo.util.Utils;

import lombok.extern.slf4j.Slf4j;

@Component
@Service
@Slf4j
public class NoteRecordServiceImpl<T> implements NoteRecordService<T> {
	
	@Autowired
	public RestTemplate restTemplate;
	
	
	public ResponseModel getToken() throws Exception {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		//ResponseEntity<T> responseEntity = null;
		
		String url = "https://postman-echo.com/post";
		
		HttpEntity<Object> requestEntity = new HttpEntity<>("payload", headers);
		ResponseEntity<T> responseEntity = 
				(ResponseEntity<T>) restTemplate.postForEntity(url, requestEntity, Object.class, "POST");
		//return (T)responseEntity.getBody();
		
		 SecureRandom random = new SecureRandom();
		    byte bytes[] = new byte[20];
		    random.nextBytes(bytes);
		    Encoder encoder = Base64.getUrlEncoder().withoutPadding();
		    String token = encoder.encodeToString(bytes);
		ResponseModel response = new ResponseModel(true, "1", bytes.toString());
		response.setResponseData(token);
		return response;
	}

	public ResponseModel service(T proceedingContentExtract, String type) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		//ResponseEntity<T> responseEntity = null;
		
		String url = "https://postman-echo.com/post";
		try {
			//JSONObject data = new JSONObject(getToken().getResponseData().toString().trim());
			
			
			String token = getToken().getResponseData().toString().trim();
			
			
			HttpEntity<T> requestEntity = new HttpEntity<>(proceedingContentExtract, headers);
	
			
			ResponseEntity<T> responseEntity = 
					(ResponseEntity<T>) restTemplate.exchange(url, HttpMethod.POST, requestEntity, Object.class);
			//return (T)responseEntity.getBody();
			
			if(responseEntity.getBody() != null && responseEntity.getStatusCodeValue() == 200) {
				T obj = responseEntity.getBody();
				ResponseModel response = new ResponseModel();
				  response.setSuccess(true);
				  response.setTotalCount("1");
				  response.setMessage("Saving data successfully!");
				  response.setResponseData(obj);
				return response;
			}else {
				return new ResponseModel(false,
													 "Failed to find "+ responseEntity.getBody(),
													 null
													 );
			}
		}
		catch(RestClientException invokeExp) {
	    	//log.info("Exception by calling process api: {}, {}", url, invokeExp.getMessage());
	    	Utils.exceptionHandler(url, invokeExp);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseModel(false,"There is something wrong! Nothing in progress!",null);
	}
	
	private ResponseModel get(String id, String string) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		String url = "https://postman-echo.com/get?";
		try {

			ResponseEntity<T> responseEntity = 
					//(ResponseEntity<T>) restTemplate.getForEntity(url+"id="+id, Object.class);
			
			  (ResponseEntity<T>) restTemplate
			.exchange(url, HttpMethod.GET, new HttpEntity<Object>(headers),
	                Object.class);
			//return (T)responseEntity.getBody();
			
			if(responseEntity.getBody() != null && responseEntity.getStatusCodeValue() == 200) {
				T obj = responseEntity.getBody();
				ResponseModel response = new ResponseModel();
				  response.setSuccess(true);
				  response.setTotalCount("1");
				  response.setMessage("Data returned successfully!");
				  response.setResponseData(obj);
				return response;
			}else {
				return new ResponseModel(false,
													 "Failed to find "+ responseEntity.getBody(),
													 null
													 );
			}
		}
		catch(RestClientException invokeExp) {
	    	Utils.exceptionHandler(url, invokeExp);
		}
		return new ResponseModel(false,"There is something wrong! Nothing in progress!",null);
	}
	
	@Override
	public ResponseModel doGet(String id) {
		return get(id, "GET");
	}
	
	@Override
	public ResponseModel doPost(T proceedingContentExtract) {
		return service(proceedingContentExtract, "POST");
	}
	
	@Override
	public ResponseModel doPut(T proceedingContentExtract) {
		return service(proceedingContentExtract, "PUT");
	}

}
