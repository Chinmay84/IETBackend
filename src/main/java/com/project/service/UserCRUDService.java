package com.project.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.project.beans.User;
import com.project.dto.EditUser;


public interface UserCRUDService {

	
	int save(User user);
	
	void deleteUser(User user);
	
	User getUserByName(String name);

	void updateUser(User user);

	
	
}
