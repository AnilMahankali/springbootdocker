package com.demo.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;

import com.demo.exception.ProcessApiInvokeException;
import com.demo.exception.TimeOutException;
import com.demo.exception.UnauthorizedException;

public class Utils {

public static void exceptionHandler(String url, RestClientException re ) {
 
		
		if (re instanceof HttpServerErrorException &&
			HttpStatus.GATEWAY_TIMEOUT.value() == ((HttpServerErrorException) re).getRawStatusCode()) {
			throw new TimeOutException("Time out trying to call api: " + url, re.getMessage());
        }
		
		if (re instanceof HttpClientErrorException &&
				HttpStatus.UNAUTHORIZED.value() == ((HttpClientErrorException) re).getRawStatusCode()) {
				throw new UnauthorizedException("Failed to call url: " + url, re.getMessage());
	        }
		
		throw new ProcessApiInvokeException("Error by calling api: " + url, re.getMessage());
	}
}
