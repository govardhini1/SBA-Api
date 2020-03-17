package com.fse.sba.projectmanagement.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fse.sba.projectmanagement.dao.Users;
import com.fse.sba.projectmanagement.repository.UserRepository;
import com.fse.sba.projectmanagement.service.UserService;


@CrossOrigin(origins="http://localhost:4200")
@Controller   
@RequestMapping(path="/user")
public class UserController {
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	  private UserRepository userRepository;

	@PostMapping(path="/addUser")
	public @ResponseBody Users addUser (@RequestBody Users users) {
//		userService.addUser(users);
		return 	userService.addUser(users);
	}

	@GetMapping(path="/viewUser")
	public @ResponseBody List<Users> getAllUsers() {
		return userService.findAll();
	}
	
	@PutMapping(path="/updateUser")
	public @ResponseBody Users updateUser(@RequestBody Users users){

		return userService.updateUser(users);
	}
	
	/*@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteUser(@PathVariable("id") Integer id){
	     userRepository.delete(id);
	     return "return";
		
	} */
	
	  @DeleteMapping("/deleteUser/{id}")
	  public String deleteUser(@PathVariable Integer id) {
		  userRepository.delete(id);
	  return "UserDetails deleted Successfully!";
	  }
}

