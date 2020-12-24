package com.demo.util;

public class ResponseModel {
	public Boolean success;
	private String message;
	private String totalCount; 
	
	public ResponseModel() {
	}
	
	public ResponseModel(Boolean success, String message, String totalCount) {
		this.success = success;
		this.message = message;
		this.totalCount = totalCount;
	}
	
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
	public Object getResponseData() {
		return responseData;
	}
	public void setResponseData(Object responseData) {
		this.responseData = responseData;
	}
	private Object responseData; 
}
