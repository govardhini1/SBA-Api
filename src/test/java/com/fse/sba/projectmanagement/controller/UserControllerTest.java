package com.fse.sba.projectmanagement.controller;

import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fse.sba.projectmanagement.dao.Users;
import com.fse.sba.projectmanagement.repository.UserRepository;
import com.fse.sba.projectmanagement.service.UserService;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerTest {


	private MockMvc mockMvc;
	
	@Autowired
	private UserService userService;
	
	
	@MockBean
	private UserRepository userRepository;


    @Test
    public void getUser() {
    	Mockito.when(userRepository.findAll()).thenReturn(Stream.of(new Users(1,"Govardhini","Elangovan", "680828")).collect(Collectors.toList()));
    	assertEquals(1, userService.findAll().size());
    }
    @Test
    public void saveUser() {
    	Users user = new Users(1,"Govardhini","Elangovan", "680828");
    	Mockito.when(userRepository.save(user)).thenReturn(user);
    	assertEquals(user, userService.addUser(user));
    }
 
 
}


