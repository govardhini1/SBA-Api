package com.fse.sba.projectmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fse.sba.projectmanagement.dao.Users;
import com.fse.sba.projectmanagement.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	

	public Users addUser(Users users) {
//		Users user = new Users();
//		user.setFirstName(users.getFirstName());
//		user.setLastName(users.getLastName());
//		user.setEmployeeId(users.getEmployeeId());
		return userRepository.save(users);
	}

	public List<Users> findAll() {
		
		return (List<Users>) userRepository.findAll();
	}

	
	 public Users updateUser(Users users) {
		Users user = userRepository.findOne(users.getUserId());
		user.setEmployeeId(users.getEmployeeId());
		user.setFirstName(users.getFirstName());
		user.setLastName(users.getLastName());
		userRepository.save(user);
		return user;
	} 


}
