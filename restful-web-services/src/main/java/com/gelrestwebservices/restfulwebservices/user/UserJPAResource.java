package com.gelrestwebservices.restfulwebservices.user;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gelrestwebservices.restfulwebservices.post.Post;
import com.gelrestwebservices.restfulwebservices.post.PostRepository;

@RestController
public class UserJPAResource {

	@Autowired
	private  UserRepository  userRepository;
	
	@Autowired
	private  PostRepository  postRepository;
	
	//GET /users
	//retrieveAllUsers
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers(){
		// return service.findAll();
		return userRepository.findAll();
	}
	
	//Get /users/{id}
	//retrieveUser(int id)
	@GetMapping("/jpa/users/{id}")
	public Resource<User> retrieveUser(@PathVariable int id) {
		//User user = service.findOne(id);
		Optional<User> user = userRepository.findById(id); //id exists or not, so return Optional
		//throw an error if user not found
		if(!user.isPresent())
			throw new UserNotFoundException("id-" + id);
		//HATEOAS - Hypermedia As the Engine of Application State
		Resource<User> resource = new Resource<User>(user.get());
		ControllerLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		// resource.add(linkTo.withRel("all-users"));
		
		resource.add(linkTo.withRel("all-users"));

		return resource;
	}
	
	//DELETE
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		//User user = service.deleteById(id);
		userRepository.deleteById(id);
	}
	
	//HATEOAS
	
	//input - details of user
	//output - CREATED & Return the created URI
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		
		//CREATED 201 SUCCESS
		// /user/4
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedUser.getId()).toUri();
		
		
		return ResponseEntity.created(location).build();
	}
	
	//GET /users and their posts
	//retrieveAllUsers and their posts
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> getUserPosts(@PathVariable int id) {
		// return service.findAll();
		 Optional<User> userOptional = userRepository.findById(id);
		 if(!userOptional.isPresent()) {
			 throw new UserNotFoundException("id-" + id);
		 }
		 List<Post> numPosts = userOptional.get().getPost();
		 System.out.println(">>>>>>>> THIS IS GEL >>>>>>>> " + numPosts);
		 return userOptional.get().getPost();
	}
	
	//POST /users and their posts
	//retrieveAllUsers and their posts
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createUserPosts(@PathVariable int id, @RequestBody Post post) {

		// return service.findAll();
		 Optional<User> userOptional = userRepository.findById(id);
		 if(!userOptional.isPresent()) {
			 throw new UserNotFoundException("id-" + id);
		 }
		 
		 User user = userOptional.get();
		 
		//map user to the post
		post.setUser(user);
		//saver post to database
		postRepository.save(post);
		 
		//CREATED 201 SUCCESS
		// /user/4
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(post.getId()).toUri();
			
		 
		 return ResponseEntity.created(location).build();
	}
	
	
	


}
