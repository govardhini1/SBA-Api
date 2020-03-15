package com.fse.sba.projectmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fse.sba.projectmanagement.dao.Project;
import com.fse.sba.projectmanagement.dao.Users;
import com.fse.sba.projectmanagement.model.ProjectRequest;
import com.fse.sba.projectmanagement.repository.ProjectRepository;
import com.fse.sba.projectmanagement.repository.TaskRepository;
import com.fse.sba.projectmanagement.repository.UserRepository;

@Service
public class ProjectService {

	@Autowired 
	private ProjectRepository projectRepository;
	
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired 
	TaskRepository taskRepository;
	
	public ProjectRequest addProject(ProjectRequest projectreq) {
		Project project = new Project();
		project.setProject(projectreq.getProjectName());
		project.setStartDate(projectreq.getStartDate());
		project.setEndDate(projectreq.getEndDate());
		project.setPriority(projectreq.getPriority());
		project.setUserId(projectreq.getUserId());
		projectRepository.save(project);
		projectreq.setCompletedTaskNumber(0);
		projectreq.setTaskNumber(0);
		return projectreq;
	}
	
	public ProjectRequest updateProject(ProjectRequest projectreq) {
		Project project = projectRepository.findOne(projectreq.getProjectId());
		if(project!= null){
			project.setProject(projectreq.getProjectName());
			project.setStartDate(projectreq.getStartDate());
			project.setEndDate(projectreq.getEndDate());
			project.setPriority(projectreq.getPriority());
			project.setUserId(projectreq.getUserId());
			projectRepository.save(project);
			return projectreq;
		}else{
			return null;
		}	
	}
	
	public List<ProjectRequest> getAllProject() {
		 Iterable<Project> projectDetails =  projectRepository.findAll();
		 List<ProjectRequest> projectList = new ArrayList<>();
		 for(Project project: projectDetails){
			 ProjectRequest  projectreq = new ProjectRequest();
			 projectreq.setProjectId(project.getProjectId());
			 projectreq.setProjectName(project.getProject());
			 projectreq.setStartDate(project.getStartDate());
			 projectreq.setEndDate(project.getEndDate());
			 projectreq.setPriority(project.getPriority());
			 projectreq.setTaskNumber(taskRepository.findAllByProjectId(project.getProjectId()).size());
			 projectreq.setCompletedTaskNumber(taskRepository.findAllByProjectIdAndStatus(project.getProjectId(), "COMPLETED").size());
			 projectreq.setUserId(project.getUserId());
			 if(project.getUserId() != null){
				 Users  user = userRepository.findOne(project.getUserId());
				 if( user != null){
					 projectreq.setManager(user.getFirstName());
				 }
			 }
			 
			 projectList.add(projectreq);
		 }
		
		return projectList;
	}
	
}
