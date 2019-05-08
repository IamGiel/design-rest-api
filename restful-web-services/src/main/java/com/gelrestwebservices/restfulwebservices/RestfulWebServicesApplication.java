package com.gelrestwebservices.restfulwebservices;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;



@SpringBootApplication
//@ComponentScan("com.gelsrestwebservices")
public class RestfulWebServicesApplication {
	
	// private TimeZone defaultTimeZone;
	public static void main(String[] args) {
		System.out.println(">>>>>> Gels " + args);
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}
	
	@Bean
	public AcceptHeaderLocaleResolver localResolver() {
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	//remove resource ResourceBundleMessageSource code block
	

}
