package com.gelrestwebservices.restfulwebservices.crudOperations;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// return status 404 not found
@ResponseStatus(HttpStatus.NOT_FOUND) 
public class ToDoNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ToDoNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ToDoNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
