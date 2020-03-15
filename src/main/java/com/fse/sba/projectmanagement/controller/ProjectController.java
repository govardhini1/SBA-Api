package com.fse.sba.projectmanagement.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fse.sba.projectmanagement.model.ProjectRequest;
import com.fse.sba.projectmanagement.repository.ProjectRepository;
import com.fse.sba.projectmanagement.service.ProjectService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(path="/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@Autowired 
	private ProjectRepository projectRepository;
	
	@PostMapping(path="/addProject")
	public @ResponseBody ProjectRequest addProject(@RequestBody ProjectRequest project){
		return projectService.addProject(project);
	}
	
	@PutMapping(path="/updateProject")
	public @ResponseBody ProjectRequest updateProject(@RequestBody ProjectRequest project){
		
	return projectService.updateProject(project);
	}
	
	@GetMapping(path="/viewProjects")
	public @ResponseBody List<ProjectRequest> getAllProject() {
		
		return projectService.getAllProject();
	}
	
	  @DeleteMapping("/deleteProject/{id}")
	  public String deleteFeedback(@PathVariable Integer id) {
		  projectRepository.delete(id);
	  return "projectDetails deleted Successfully!";
	  }
	
}
