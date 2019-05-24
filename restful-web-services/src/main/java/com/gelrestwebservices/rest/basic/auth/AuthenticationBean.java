package com.gelrestwebservices.rest.basic.auth;

public class AuthenticationBean {
	
	private String message;

	public AuthenticationBean(String message) {
		// TODO Auto-generated constructor stub
		this.message = message;
	}
	
	//generate setters
	public void setMessage(String message) {
		this.message = message;
	}
	
	//set getter
	public String getMessage() {
		return message;
	}


	// generate toString()
	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}
	
	
	
	
	
	
}
