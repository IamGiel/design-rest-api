package com.gelrestwebservices.restfulwebservices.basic.auth;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@Order()
@CrossOrigin(origins = "http://localhost:4200")
public class SpringSecurityBasicConfiguration extends WebSecurityConfigurerAdapter {
	
	
	private final Log logger = LogFactory.getLog(WebSecurityConfigurerAdapter.class);
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.debug(" >>>>>>>>> Using default configure(HttpSecurity). If subclassed this will potentially override subclass configure(HttpSecurity).");
		http
		.csrf().disable() // use JWT 
		.authorizeRequests()
		.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
			.anyRequest().authenticated()
			.and()
		// .formLogin().and()
		.httpBasic();
	}
}
