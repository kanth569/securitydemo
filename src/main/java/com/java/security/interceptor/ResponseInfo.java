package com.java.security.interceptor;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class ResponseInfo extends ResourceSupport{

	private String messageCode;
	
	private String message;

	public ResponseInfo() {
	}

	public ResponseInfo(String messageCode, String message) {
		this.messageCode = messageCode;
		this.message = message;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
