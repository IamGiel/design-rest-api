package com.jpa.inTen.Steps.jpain10steps.Service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.inTen.Steps.jpain10steps.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
