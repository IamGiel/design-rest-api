package com.gelrestwebservices.restfulwebservices.crudOperations;

import java.net.URI;
import java.util.List;

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

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ToDoListResource {

	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/users/**").allowedOrigins("http://localhost:4200", "http://localhost:9191");
	}

	// @Autowired
	// private PostRepository postRepository;
	@Autowired
	private TodoHardCodedService TodoService;

	// GET /all-todos
	// retrieveAllTodos
	@GetMapping("/users/{user}/all-todos")
	public List<toDo> retrieveAllTodos(String username) {
		// return service.findAll();
		// return userRepository.findAll();
		return TodoService.findAll();
	}

	// GET /single-todo
	@GetMapping("/users/{user}/todo/{id}")
	public toDo getSingleToDoItem(@PathVariable long id) {
		toDo toDo = TodoService.findById(id);
		return toDo;
	}

	// delete
	@DeleteMapping("/users/{user}/todo/{id}")
	public ResponseEntity<Void> deleteTodoById(@PathVariable long id) {

		toDo toDo = TodoService.deleteById(id);
		if (toDo != null) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();

	}

	// PUT
	@PutMapping("/users/{user}/todo/{id}")
	public ResponseEntity<toDo> updateTodoList(@Valid @RequestBody toDo todoItem, @PathVariable long id,
			@PathVariable String user) {

		toDo toDoUpdated = TodoService.save(todoItem);

		// URI location =
		// ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(toDoUpdated.getId())
		// .toUri();
		//
		// // static method
		// return ResponseEntity.created(location).build();

		// static method
		return new ResponseEntity<toDo>(toDoUpdated, HttpStatus.OK);

	}

	// POST
	@PostMapping("/users/{user}/todo")
	public ResponseEntity<Void> addTodoList(@Valid @RequestBody toDo todoItem) {

		toDo toDo = TodoService.save(todoItem);
		// CREATED 201 SUCCESS
		// /user/4
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(toDo.getId())
				.toUri();

		// static method
		return ResponseEntity.created(location).build();

	}

}
