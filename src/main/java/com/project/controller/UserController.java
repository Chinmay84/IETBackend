package com.project.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.beans.User;
import com.project.dto.EditUser;
import com.project.dto.SignUpRequest;
import com.project.message.MessageResponse;
import com.project.repository.UserRepository;
import com.project.service.UserCRUDService;

@RequestMapping("/api/unauthuser")
@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserCRUDService userCRUDService;
	
	@PutMapping(value="/edit",produces = "application/json",consumes = "application/json")
	public ResponseEntity<?> forEditUser(@RequestBody User user)
	{
		User u=userRepository.findUserforDelete(user.getEmail());
		System.out.println(user);
		if(u!=null) {
			userCRUDService.updateUser(user);
			return ResponseEntity.ok("Updated Successfull");
		}
		return ResponseEntity.ok("not found");
		//return ResponseEntity.badRequest().body(new MessageResponse("Error : Username not found!"));
	}

/*	@PostMapping(value="/registerdoctor")
	public ResponseEntity<?> registerUser(@RequestBody SignUpRequest signUpRequest){
		Optional<User> optUser=userRepository.findByEmail(signUpRequest.getEmail());
		if(optUser.isPresent()) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error : Username is already taken!"));
		}
		userService.addUser(signUpRequest);
		return ResponseEntity.ok("user registered successfully");
	}
*/	
	
	
	
	
	@DeleteMapping(value="/delete/{email}",produces="application/json")
	public ResponseEntity<?> forDeleteEmployee(@PathVariable("email") String email) {
		
		User user=userRepository.findUserforDelete(email);
		if(user!=null) {
			userRepository.delete(user);
			return ResponseEntity.ok("Deleted Successfull");
		}
		return ResponseEntity.badRequest().body(new MessageResponse("Error : Username not found!"));
		
	}
	
}
