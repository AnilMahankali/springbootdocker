package com.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.data.PolicyDTO;
import com.demo.service.NoteRecordService;
import com.demo.util.CommonResponseModel;

@RestController
@RequestMapping(value = "/noteRecord" )
public class NoteRecordController {

	@Autowired
	public NoteRecordService<PolicyDTO> noteRecordService;
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> save(
			@Valid @RequestBody final PolicyDTO policyData) {
		CommonResponseModel response = 
				noteRecordService.doPost(policyData);
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
	}
	
	@RequestMapping(value = "update", method = RequestMethod.PUT)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> update(
			@Valid @RequestBody final PolicyDTO proceedingContentExtract) {
		CommonResponseModel response = 
				noteRecordService.doPut(proceedingContentExtract);
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
	}
	
	@RequestMapping(value = "get", method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> get(
			@RequestParam(value = "id", required = false) String id) {
		CommonResponseModel response = 
				noteRecordService.doGet(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
	}

}
