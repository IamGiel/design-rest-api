package com.jpa.inTen.Steps.jpain10steps.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// TABLE - User

@Entity // this allows us to store this User to a table
public class User {
	
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String role;
	
	// JPA expects a default constructor 
	protected User() {
		
	}
	
	public User(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", role=" + role + "]";
	}
	
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getRole() {
		return role;
	}
	
	

}
