package com.fse.sba.projectmanagement.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fse.sba.projectmanagement.dao.Task;
import com.fse.sba.projectmanagement.model.TaskRequest;
import com.fse.sba.projectmanagement.repository.TaskRepository;
import com.fse.sba.projectmanagement.service.TaskService;

@CrossOrigin(origins="http://localhost:4200")
@Controller
@RequestMapping(path="/task")
public class TaskController {
	
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private TaskRepository taskrepository;
	
	@PostMapping(path="/addTask")
	public @ResponseBody String addTask (@RequestBody TaskRequest task) {

		return taskService.addTask(task);
	}
	
	@PutMapping(path="/endTask")
	public @ResponseBody Task endTask (@RequestBody TaskRequest task) {

		return taskService.endTask(task);
	}


	@GetMapping(path="/viewTask")
	public @ResponseBody List<TaskRequest> getAllTasks() {
		return taskService.getAllTasks();
	}
	
	@PutMapping(path="/updateTask")
	public @ResponseBody Task updateTask(@RequestBody TaskRequest task){
		
		return taskService.updateTask(task);
	}
	
	
	@RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
	public @ResponseBody Iterable<TaskRequest> getTasksByProject(@PathVariable("id") Integer id){
 
		return taskService.getTasksByProject(id);
		
	}
	
	 @RequestMapping(value = "/task/{id}", method = RequestMethod.DELETE)
		public @ResponseBody String deleteTask(@PathVariable("id") Integer id){
			 taskrepository.delete(id);
		     return "task deleted";
			
		} 

}
