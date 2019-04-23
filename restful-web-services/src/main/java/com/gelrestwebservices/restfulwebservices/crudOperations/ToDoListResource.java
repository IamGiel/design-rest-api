package com.gelrestwebservices.restfulwebservices.crudOperations;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gelrestwebservices.restfulwebservices.post.Post;
import com.gelrestwebservices.restfulwebservices.post.PostRepository;
import com.gelrestwebservices.restfulwebservices.user.User;
import com.gelrestwebservices.restfulwebservices.user.UserNotFoundException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ToDoListResource {

//	@Autowired
//	private  UserRepository  userRepository;

//	@Autowired
//	private  PostRepository  postRepository;
	@Autowired
	private TodoHardCodedService TodoService;

	// GET /all-todos
	// retrieveAllTodos
	@GetMapping("/users/{user}/all-todos")
	public List<ToDo> retrieveAllTodos(String username) {
		// return service.findAll();
		// return userRepository.findAll();
		return TodoService.findAll();
	}
	// delete
	@DeleteMapping("/users/{user}/todo/{id}")
	public ResponseEntity<Void> deleteTodoById(@PathVariable long id) {
		
		ToDo toDo = TodoService.deleteById(id);
		if(toDo != null) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.notFound().build();

	}
	
	

	

}
