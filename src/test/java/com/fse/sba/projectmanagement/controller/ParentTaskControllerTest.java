package com.fse.sba.projectmanagement.controller;

import static org.junit.Assert.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.fse.sba.projectmanagement.dao.ParentTask;
import com.fse.sba.projectmanagement.repository.ParentTaskRepository;
import com.fse.sba.projectmanagement.service.ParentTaskService;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ParentTaskControllerTest {
	
	@Autowired
	private ParentTaskService parentTaskService;
	
	@MockBean
	private ParentTaskRepository parentTaskrepository;
	

	 @Test
	    public void getUser() {
	    	Mockito.when(parentTaskrepository.findAll()).thenReturn(Stream.of(new ParentTask(1,"")).collect(Collectors.toList()));
	    	assertEquals(1, parentTaskService.getAllUsers().size());
	    }
	    
//	  @Test
//	    public void saveParent() {
//		  ParentTask ptask = new ParentTask(1,"isd");
//	    	Mockito.when(parentTaskrepository.save(ptask)).thenReturn(ptask);
//	    	assertEquals(ptask, parentTaskService.addParentTask(""));
//	    }

}
