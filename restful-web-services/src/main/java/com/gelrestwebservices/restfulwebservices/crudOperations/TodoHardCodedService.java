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

	private static List<toDo> toDos = new ArrayList<>();
	private static long counter = 0;

	static {
		toDos.add(new toDo(++counter, "Adam needs apple", new Date(), "Adam", true));
		toDos.add(new toDo(++counter, "Get some stuff in walmart", new Date(), "Adam", true));
		toDos.add(new toDo(++counter, "New NorthFace Sweater needed", new Date(), "Adam",  true));
	}

	// public List<User> findAll()
	public List<toDo> findAll() {
		return toDos;
	}

	// public user deleteById(int id)
	public toDo deleteById(long id) {
		toDo todos = findById(id);
		if (todos == null) {
			return null;
		}

		if (toDos.remove(todos)) {
			return todos;
		}
		return null;
	}

	public toDo findById(long id) {
		// TODO Auto-generated method stub
		for (toDo todo : toDos) {
			if (todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}

	// update
	public toDo update(@Valid toDo todoItem) {
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
	public toDo save(@Valid toDo todoItem) {
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
