package com.gelrestwebservices.restfulwebservices.exception;

import java.util.Date;

public class ExceptionResponse {
	
	//time stamp, when it happen
	private Date timestamp;
	//message
	private String message;
	//detail
	private String details;
	public Date getTimestamp() {
		return timestamp;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
	public ExceptionResponse(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	
	@Override
	public String toString() {
		return "ExceptionResponse [message=" + message + ", details=" + details + "]";
	}
	

}
