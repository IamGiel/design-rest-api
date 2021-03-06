package com.gelrestwebservices.restfulwebservices.helloworld;

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

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	//create method to return hello world
	//GET
	//URI /hello-world
	//method hello world
	@GetMapping(path="/hello-world")
	public	String helloWorld() {
		return "Hello World ! ";
	}
	
	//hello-world-bean
	@GetMapping(path="/hello-world-bean")
	public	HelloWorldBean helloWorldBean() {
		throw new RuntimeErrorException(null, "Some error, contact Support ***-***-****");
		// return new HelloWorldBean("Hello world - Changed");
	}
	
	//hello-world/path-variable/in28minutes
	@GetMapping(path="/hello-world/path-variable/{name}")
	public	HelloWorldBean HelloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello PAth Variable %s", name));
	}
	
	///hello-world/international
	@GetMapping(path="/hello-world/international")
	public	String helloWorldInternational() {
		return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
	}
	
}




