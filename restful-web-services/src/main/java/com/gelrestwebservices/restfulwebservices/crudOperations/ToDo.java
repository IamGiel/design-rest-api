package com.gelrestwebservices.restfulwebservices.crudOperations;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.aspectj.weaver.ast.Var;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Lettuce;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gelrestwebservices.restfulwebservices.post.Post;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All details about the user")
@Entity // create this as entity
public class ToDo {

	@Id // create this as id
	@GeneratedValue // create this as value generated by database
	private Long id;
	@Size(min = 3, message = "Name Should be atleast 3 length")
	@ApiModelProperty(notes = "Minimum 3 characters")
	private String description;
	// @Future
	// @ApiModelProperty(notes = "Set date should not be in the past")
	private Date setDate;
	private Boolean isDone;

	// JPA expects a default constructor
	 protected ToDo() {}

	public Long getId() {
		return id;
	}

	public void setId(long counter) {
		this.id = counter;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getSetDate() {
		System.out.println("TESTING DATE >>>>> " + setDate);
		return setDate;
	}

	public void setSetDate(Date setDate) {
		System.out.println("TESTING DATE >>>>> " + setDate);
		this.setDate = setDate;
	}

	public Boolean getIsDone() {
		return isDone;
	}

	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}

	public ToDo(long counter, @Size(min = 3, message = "Name Should be atleast 3 length") String description,
			 Date setDate, Boolean isDone) {
		super();
		this.id = counter;
		this.description = description;
		this.setDate = setDate;
		this.isDone = isDone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		System.out.println("this is RESULT of HASHCODE >>>> " + result);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ToDo other = (ToDo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
