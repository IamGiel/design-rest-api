package com.gelrestwebservices.restfulwebservices.crudOperations;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoJpaRepository extends CrudRepository<toDo, Long> {
	List<toDo> findByUsername(String username);
}
