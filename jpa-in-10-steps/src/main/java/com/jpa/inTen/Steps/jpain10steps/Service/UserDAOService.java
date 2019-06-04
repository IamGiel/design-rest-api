package com.jpa.inTen.Steps.jpain10steps.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.jpa.inTen.Steps.jpain10steps.Entity.User;


@Repository
@Transactional //each method will be involved in a transaction
public class UserDAOService {
	@PersistenceContext
	private EntityManager entityManager;
	
	public long insert(User user) {
		// method that make an instance managed and persistent
		entityManager.persist(user);
		return user.getId();
	}
}
