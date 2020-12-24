package com.demo.service;

import org.springframework.stereotype.Service;

import com.demo.util.ResponseModel;

@Service
public interface NoteRecordService<T> {

	public ResponseModel doGet(String id);
	
	public ResponseModel doPost(T proceedingContentExtract);
	
	public ResponseModel doPut(T proceedingContentExtract);

}
