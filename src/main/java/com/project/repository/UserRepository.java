package com.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.beans.User;
import com.project.dto.EditUser;

public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByEmail(String email);
	
	@Query("SELECT u from User u WHERE u.email = ?1")
	User findUserforDelete(String email);
	
	
	
	
}
