package com.demo.exception;

public final class UserInfoNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorDetail;
	
    public UserInfoNotFoundException(String message, String errorDetail) {
        super(message);
        this.errorDetail = errorDetail;
    }	
    
	public String getErrorDetail() {
		
		return errorDetail;
	}
}

