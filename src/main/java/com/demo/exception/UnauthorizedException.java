package com.demo.exception;

public final class UnauthorizedException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String errorDetail;
	
	public UnauthorizedException(String message, String errorDetail) {
        super(message);
        this.errorDetail = errorDetail;
    }
	
	public String getErrorDetail() {
		
		return errorDetail;
	}
}

