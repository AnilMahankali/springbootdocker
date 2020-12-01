package com.demo.service;

import org.springframework.stereotype.Service;

import com.demo.util.CommonResponseModel;

@Service
public interface NoteRecordService<T> {

	public CommonResponseModel doGet(String id);
	
	public CommonResponseModel doPost(T proceedingContentExtract);
	
	public CommonResponseModel doPut(T proceedingContentExtract);

}
