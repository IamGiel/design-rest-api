package com.gelrestwebservices.restfulwebservices.crudOperations;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.transaction.annotation.Transactional;
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

import com.gelrestwebservices.restfulwebservices.post.Post;
import com.gelrestwebservices.restfulwebservices.post.PostRepository;
import com.gelrestwebservices.restfulwebservices.user.User;
import com.gelrestwebservices.restfulwebservices.user.UserNotFoundException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ToDoListResource {

	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("*").allowedOrigins("http://localhost:4200", "http://localhost:9191");
	}

	// @Autowired
	//private  PostRepository  postRepository;
	
	@Autowired
	private TodoHardCodedService TodoService;
	
	@Autowired
	private TodoJpaRepositoryService todoJpaService;
	
	private final Log logger = LogFactory.getLog(WebSecurityConfigurerAdapter.class);
	// GET /all-todos
	// retrieveAllTodos
	@GetMapping("/users/{user}/all-todos")
	public List<ToDo> retrieveAllTodos(Long id) {
		// return service.findAll();
		// return userRepository.findAll();
		logger.debug("test log all-todos >>>>>>>> ");
		return (List<ToDo>) todoJpaService.findAll();
	}

	// GET /single-todo
	@GetMapping("/users/{user}/todo/{id}")
	public Optional<ToDo> getSingleToDoItem(@PathVariable long id) {
		Optional<ToDo> toDo = todoJpaService.findById(id);
		return toDo;
	}

	// delete
	@DeleteMapping("/users/{user}/todo/{id}")
	@Transactional
	public ResponseEntity<ToDo> deleteTodoById(@PathVariable long id) {
		logger.debug("test delete todo >>>>>>>> ");
		todoJpaService.deleteById(id);
//		if (toDo != null) {
//			return ResponseEntity.noContent().build();
//		}
//
//		return ResponseEntity.notFound().build();
		return null;

	}

	// PUT
	@PutMapping("/users/{user}/todo/{id}")
	public ResponseEntity<ToDo> updateTodoList(@Valid @RequestBody ToDo todoItem, @PathVariable long id,
			@PathVariable String user) {

		ToDo toDoUpdated = todoJpaService.save(todoItem);
		
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(toDoUpdated.getId())
//				.toUri();
//
//		// static method
//		return ResponseEntity.created(location).build();
		

		// static method
		return new ResponseEntity<ToDo>(toDoUpdated, HttpStatus.OK);

	}

	// POST
	@PostMapping("/users/{user}/todo")
	public ResponseEntity<Void> addTodoList(@Valid @RequestBody ToDo todoItem) {

		ToDo toDo = todoJpaService.save(todoItem);
		// CREATED 201 SUCCESS
		// /user/4
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(toDo.getId())
				.toUri();
		
		logger.debug("post request save a todo >>>>>>>> ");

		// static method
		return ResponseEntity.created(location).build();

	}

}
