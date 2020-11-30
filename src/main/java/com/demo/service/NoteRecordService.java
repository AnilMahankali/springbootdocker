package com.demo.service;

import com.demo.util.CommonResponseModel;

public interface NoteRecordService<T> {

	public CommonResponseModel doGet(String id);
	
	public CommonResponseModel doPost(T proceedingContentExtract);
	
	public CommonResponseModel doPut(T proceedingContentExtract);

}
