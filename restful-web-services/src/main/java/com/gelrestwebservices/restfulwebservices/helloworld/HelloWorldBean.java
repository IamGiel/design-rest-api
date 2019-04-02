package com.gelrestwebservices.restfulwebservices.helloworld;

public class HelloWorldBean {
	
	private String message;

	public HelloWorldBean(String message) {
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
