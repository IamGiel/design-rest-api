package com.gelrestwebservices.restfulwebservices.basic.auth;

import java.util.Locale;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.gelrestwebservices.rest.basic.auth.AuthenticationBean;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BasicAuthController {

	@Autowired
	private MessageSource messageSource;
	// create method to return hello world
	// GET
	// URI /hello-world
	// method hello world
//	@GetMapping(path="/hello-world")
//	public	String helloWorld() {
//		return "Hello World ! ";
//	}

	// hello-world-bean
	@GetMapping(path = "/basicAuth")
	public AuthenticationBean helloWorldBean() {

		try {

			return new AuthenticationBean("authenticated ");
			// return new HelloWorldBean("Hello world - Changed");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("what is e >>> " + e);
		}
		
		// return new AuthenticationBean("new auth bean ");
		
		return null;
	}

}
