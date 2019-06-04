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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins = "*")
@RestController
public class ToDoListJPAResource {

	@Autowired
	private ToDoJpaRepository jpaTodoRepository;

	// GET /all-todos
	@GetMapping("/sql/users/{user}/all-todos")
	public List<toDo> retrieveAllTodos(String username) {
		return (List<toDo>) jpaTodoRepository.findByUsername(username);
	}
	// @GetMapping("/sql/users/{user}/all-todos")
	// public List<toDo> retrieveAllTodos(String username) {
	// return jpaTodoRepository.findByUsername(username);
	// }

	// GET /single-todo
	@GetMapping("/sql/users/{user}/todo/{id}")
	public toDo getSingleToDoItem(@PathVariable Long id) {
		return jpaTodoRepository.findById(id).get();
	}

	// delete
	@DeleteMapping("/sql/users/{user}/todo/{id}")
	public ResponseEntity<Void> deleteTodoById(@PathVariable Long id) {

		jpaTodoRepository.deleteById(id);

		return ResponseEntity.noContent().build();
		// return ResponseEntity.notFound().build();

	}

	// PUT
	@PutMapping("/sql/users/{user}/todo/{id}")
	public ResponseEntity<toDo> updateTodoList(@Valid @RequestBody toDo todoItem, @PathVariable Long id,
			@PathVariable String user) {

		toDo toDoUpdated = jpaTodoRepository.save(todoItem);

		// static method
		return new ResponseEntity<toDo>(toDoUpdated, HttpStatus.OK);

	}

	// POST
	@PostMapping("/sql/users/{user}/todo")
	public ResponseEntity<Void> addTodoList(@PathVariable String user, @Valid @RequestBody toDo todoItem) {
		todoItem.setUsername(user);
		toDo toDo = jpaTodoRepository.save(todoItem);
		// CREATED 201 SUCCESS
		// /user/4
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(toDo.getId())
				.toUri();

		// static method
		return ResponseEntity.created(location).build();

	}

}
