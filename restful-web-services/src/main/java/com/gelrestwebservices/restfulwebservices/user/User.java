package com.gelrestwebservices.restfulwebservices.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="All details about the user")
@Entity //create this as entity
public class User {
	
	@Id //create this as id
	@GeneratedValue //create this as value generated by database
	private Integer id;
	
	@Size(min=3, message="Name Should be atleast 3 length")
	@ApiModelProperty(notes="Minimum 3 characters")
	private String name;
	
	@Past
	@ApiModelProperty(notes="Birthday should be in the past")
	private Date birthday;
	
	// JPA expects a default constructor 
	protected User() {
		
	}
	
	
	public User(Integer id, String name, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthday=" + birthday + "]";
	}


	
	

}
