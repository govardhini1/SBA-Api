package com.fse.sba.projectmanagement.controller;

import static org.junit.Assert.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.mock.mockito.MockBean;

import com.fse.sba.projectmanagement.dao.Users;
import com.fse.sba.projectmanagement.repository.UserRepository;
import com.fse.sba.projectmanagement.service.UserService;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerTest {
	
	private MockMvc mockMvc;
	
	
	private Users users;
	
	
	@Autowired
	private UserService userService;
	
	@MockBean
	private UserRepository userRepository;
	
	@InjectMocks
	private UserController userController = new UserController();


	@Before
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);

		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

		users = new Users(1,"Jhon123", "Jhon Simon", "123456");
	}
	
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


