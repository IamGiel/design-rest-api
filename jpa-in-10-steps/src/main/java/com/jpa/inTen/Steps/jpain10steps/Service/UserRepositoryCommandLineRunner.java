package com.jpa.inTen.Steps.jpain10steps.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jpa.inTen.Steps.jpain10steps.Entity.User;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {
	
	private static Logger log = 
			LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user = new User("Jill", "Admin");
		
		// new user is created: User [id=1, name=Jack, role=Admin]
		userRepository.save(user);
		log.info("new user is created: " + user);
		
		Optional<User> userWithOneId = userRepository.findById(1L);
		log.info("find user with an id: " + userWithOneId);
		
		List<User> users = userRepository.findAll();
		log.info("find all users: " + users);
		
		
	}


}


