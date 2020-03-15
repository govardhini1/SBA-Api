package com.fse.sba.projectmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fse.sba.projectmanagement.dao.ParentTask;
import com.fse.sba.projectmanagement.service.ParentTaskService;

@CrossOrigin(origins="http://localhost:4200")
@Controller
@RequestMapping(path="/parentTask")
public class ParentTaskController {

	@Autowired
	private ParentTaskService parentTaskService;
	
	@GetMapping(path="/viewParentTask")
	public @ResponseBody List<ParentTask> getAllUsers() {
		return (List<ParentTask>) parentTaskService.getAllUsers();
	}
	
	@PostMapping(path="/addparentTask")
	public @ResponseBody ParentTask addParentTask (@RequestBody String task) {
		return parentTaskService.addParentTask(task);
	}

}
