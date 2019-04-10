package com.jpa.inTen.Steps.jpain10steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jpa.inTen.Steps.jpain10steps.Entity.User;
import com.jpa.inTen.Steps.jpain10steps.Service.UserDAOService;

@Component
public class UserDaoServiceCommandLineRunner implements CommandLineRunner {
	
	private static Logger log = 
			LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);
	
	@Autowired
	private UserDAOService userDAOService;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user = new User("Jack", "Admin");
		
		// new user is created: User [id=1, name=Jack, role=Admin]
		userDAOService.insert(user);
		log.info("new user is created: " + user);
	}

}
