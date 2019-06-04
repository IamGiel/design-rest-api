package com.gelrestwebservices.restfulwebservices.crudOperations;

import java.util.ArrayList;
import java.util.Date;
//import java.util.Iterator;
//import java.util.Iterator;
import java.util.List;

import javax.persistence.Id;
import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.gelrestwebservices.restfulwebservices.user.User;

@Service
public class TodoHardCodedService {

	private static List<ToDo> toDos = new ArrayList<>();
	private static long counter = 0;

	static {
		toDos.add(new ToDo(++counter, "Adam needs apple", new Date(), true));
		toDos.add(new ToDo(++counter, "Get some stuff in walmart", new Date(), true));
		toDos.add(new ToDo(++counter, "New NorthFace Sweater needed", new Date(), true));
	}

	// public List<User> findAll()
	public List<ToDo> findAll() {
		return toDos;
	}

	// public user deleteById(int id)
	public ToDo deleteById(long id) {
		ToDo todos = findById(id);
		if (todos == null) {
			return null;
		}

		if (toDos.remove(todos)) {
			return todos;
		}
		return null;
	}

	public ToDo findById(long id) {
		// TODO Auto-generated method stub
		for (ToDo todo : toDos) {
			if (todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}

	// update
	public ToDo update(@Valid ToDo todoItem) {
		if (todoItem.getId() == -1 || todoItem.getId() == 0) {
			deleteById(todoItem.getId());
			todoItem.setId(++counter);
			toDos.add(todoItem);
		} else {
			deleteById(todoItem.getId());
			toDos.add(todoItem);
		}
		return todoItem;
		
	}

	// save
	public ToDo save(@Valid ToDo todoItem) {
		if (todoItem.getId() == -1 || todoItem.getId() == 0) {
			todoItem.setId(++counter);
			toDos.add(todoItem);
		} else {
			deleteById(todoItem.getId());
			toDos.add(todoItem);
		}
		return todoItem;
	}

}
