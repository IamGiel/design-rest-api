package com.gelrestwebservices.restfulwebservices.crudOperations;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface toDoJPARepository extends JpaRepository<toDo, Long> {
	List<toDo> findByUsername(String username);
}
