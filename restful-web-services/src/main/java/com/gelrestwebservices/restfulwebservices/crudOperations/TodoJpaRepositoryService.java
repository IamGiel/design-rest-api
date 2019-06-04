package com.gelrestwebservices.restfulwebservices.crudOperations;




import java.util.List;
import java.util.Optional;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface TodoJpaRepositoryService extends CrudRepository<ToDo, Long> {
	Optional<ToDo> findById(Long id);
}
