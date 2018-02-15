package com.java.security.exception;

public class SecurityException extends Exception {

	private int messageCode;

	public SecurityException() {
		// TODO Auto-generated constructor stub
	}

	public SecurityException(int messageCode, String message) {
		super(message);
		this.messageCode = messageCode;
	}

	public int getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(int messageCode) {
		this.messageCode = messageCode;
	}


}
