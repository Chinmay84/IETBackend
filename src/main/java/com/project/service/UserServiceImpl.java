package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.beans.Address;
import com.project.beans.Docter;
import com.project.beans.Role;
import com.project.beans.RoleName;
import com.project.beans.User;
import com.project.dto.SignUpRequest;
import com.project.repository.RoleRepository;
import com.project.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void addUser(SignUpRequest signUpRequest) {
		// create new User's account
		User user = new User();
		user.setName(signUpRequest.getName());
		user.setEmail(signUpRequest.getEmail());
		user.setMobileNo(signUpRequest.getMobileNo());
		user.setGender(signUpRequest.getGender());
		user.setAlternativeMobileNo(signUpRequest.getAlernativeMobileNo());
		Address address = new Address();
		address.setCity(signUpRequest.getCity());
		address.setState(signUpRequest.getState());
		address.setPincode(signUpRequest.getPincode());
//		address.setAddress(signUpRequest.getAddress());
		user.setAddress(address);
		user.setPassword(passwordEncoder
				.encode(signUpRequest.getPassword()));
		List<Role> roles = new ArrayList<>();
		Role userRole = roleRepository.findByRoleName(RoleName.USER)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(userRole);
		user.setRoles(roles);
		user.setProfession(signUpRequest.getProfession());
		userRepository.save(user);
	}

	@Override
	public void addAdmin(SignUpRequest signUpRequest) {
		User user = new User();
		user.setName(signUpRequest.getName());
		user.setEmail(signUpRequest.getEmail());
		user.setMobileNo(signUpRequest.getMobileNo());
		user.setGender(signUpRequest.getGender());
		Address address = new Address();
		address.setCity(signUpRequest.getCity());
		address.setState(signUpRequest.getState());
		address.setPincode(signUpRequest.getPincode());
//		address.setAddress(signUpRequest.getAddress());
		user.setAddress(address);
		user.setPassword(passwordEncoder
				.encode(signUpRequest.getPassword()));
		List<Role> roles = new ArrayList<>();
		Role userRole = roleRepository.findByRoleName(RoleName.ADMIN)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);

	}

}

