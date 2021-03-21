package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.beans.Address;
import com.project.beans.User;
import com.project.repository.UserRepository;

@Service
public class UserCRUDServiceImpl implements UserCRUDService{
	
	@Autowired
	UserRepository userRepository; 
	
	
	
	User user = new User();

	@Override
	public int save(User user) {
		// TODO Auto-generated method stub
		return 0;
	}
/*
	@Override
	public int updateUser(User user,User u) {
		
		// TODO Auto-generated method stub
		u.setMobileNo(user.getMobileNo());
		u.setName(user.getName());
		
		return userRepository.save(u).getUserId();
	}
*/
	
	

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		userRepository.delete(user);
	}

	@Override
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void updateUser(User user) {

		User u=userRepository.findUserforDelete(user.getEmail());
		u.setEmail(user.getEmail());
		u.setGender(user.getGender());
		u.setMobileNo(user.getMobileNo());
		u.setName(user.getName());
		u.setPassword(user.getPassword());
		u.setProfession(user.getProfession());
		u.setAlternativeMobileNo(user.getAlternativeMobileNo());
//		System.out.println("address is "+user.getAddress());
//		Address oldaddr=u.getAddress();
//		oldaddr.setCity(user.getAddress().getCity());
//		oldaddr.setPincode(user.getAddress().getPincode());
//		oldaddr.setState(user.getAddress().getState());
//		u.setAddress(oldaddr);
		userRepository.save(u);
	}


		
	

	
	
	
	
	
}
