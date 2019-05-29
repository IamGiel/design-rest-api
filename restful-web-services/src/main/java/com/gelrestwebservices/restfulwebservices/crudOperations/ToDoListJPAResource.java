package com.gelrestwebservices.restfulwebservices.crudOperations;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins = "*")
@RestController
public class ToDoListJPAResource {
	
	@Autowired
	private toDoJPARepository jpaTodoRepository;

	// GET /all-todos
	@GetMapping("/jpa/users/{user}/all-todos")
	public List<toDo> retrieveAllTodos(String username) {
		// return service.findAll();
		// return userRepository.findAll();
		return jpaTodoRepository.findByUsername(username);
	}

	// GET /single-todo
	@GetMapping("/jpa/users/{user}/todo/{id}")
	public toDo getSingleToDoItem(@PathVariable long id) {
		toDo toDo = jpaTodoRepository.findById(id).get();
		return toDo;
	}

	// delete
	@DeleteMapping("/jpa/users/{user}/todo/{id}")
	public void deleteTodoById(@PathVariable long id) {
		jpaTodoRepository.deleteById(id);
	}

	// PUT
	@PutMapping("/jpa/users/{user}/todo/{id}")
	public ResponseEntity<toDo> updateTodoList(@Valid @RequestBody toDo todoItem, @PathVariable long id,
			@PathVariable String user) {

		toDo toDoUpdated = jpaTodoRepository.save(todoItem);
		
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(toDoUpdated.getId())
//				.toUri();
//
//		// static method
//		return ResponseEntity.created(location).build();
		

		// static method
		return new ResponseEntity<toDo>(toDoUpdated, HttpStatus.OK);

	}

	// POST
	@PostMapping("/jpa/users/{user}/todo")
	public ResponseEntity<Void> addTodoList(@Valid @RequestBody toDo todoItem) {

		toDo toDo = jpaTodoRepository.save(todoItem);
		// CREATED 201 SUCCESS
		// /user/4
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(toDo.getId())
				.toUri();

		// static method
		return ResponseEntity.created(location).build();

	}

}
