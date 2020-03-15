package com.fse.sba.projectmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fse.sba.projectmanagement.dao.ParentTask;
import com.fse.sba.projectmanagement.dao.Project;
import com.fse.sba.projectmanagement.dao.Task;
import com.fse.sba.projectmanagement.dao.Users;
import com.fse.sba.projectmanagement.model.TaskRequest;
import com.fse.sba.projectmanagement.repository.ParentTaskRepository;
import com.fse.sba.projectmanagement.repository.ProjectRepository;
import com.fse.sba.projectmanagement.repository.TaskRepository;
import com.fse.sba.projectmanagement.repository.UserRepository;

@Service
public class TaskService {
	
	@Autowired 
	private TaskRepository taskRepo;
	
	@Autowired
	private ParentTaskRepository repo;
	
	@Autowired
	private ProjectRepository projectRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	
	public String addTask(TaskRequest taskReq) {
		if(taskReq.isParentTask()){
			ParentTask pTask = new ParentTask();
			pTask.setParentTask(taskReq.getTaskName());
			repo.save(pTask);
		}else{
			Task task = new Task();
			task.setParentId(taskReq.getParentTaskId());
			task.setProjectId(taskReq.getProjectId());
			task.setTask(taskReq.getTaskName());
			task.setStartDate(taskReq.getStartDate());
			task.setEndDate(taskReq.getEndDate());
			task.setPriority(taskReq.getPriority());
			task.setUserId(taskReq.getUserId());	
			task.setStatus("STARTED");
			taskRepo.save(task);
		}
		
		return "Task Added Successfully";
	}
	
	public Task endTask(TaskRequest taskReq) {
		Task task = taskRepo.findOne(taskReq.getTaskId());
		task.setStatus("COMPLETED");
		taskRepo.save(task);
		return task;
		}

	
	public List<TaskRequest> getAllTasks() {
		List<TaskRequest> taskObjList = new ArrayList<>();
		List<Task> taskList =  (List<Task>) taskRepo.findAll();
		for(Task task: taskList){
			TaskRequest obj = new TaskRequest();
			obj.setTaskId(task.getTaskId());
			obj.setParentTaskId(task.getParentId());
			obj.setProjectId(task.getProjectId());
			obj.setTaskName(task.getTask());
			obj.setStartDate(task.getStartDate());
			obj.setEndDate(task.getEndDate());
			obj.setPriority(task.getPriority());
			obj.setStatus(task.getStatus());
			obj.setUserId(task.getUserId());
			if(task.getParentId() != null){
				ParentTask	 pTask = repo.findOne(task.getParentId());
				if(pTask != null){
					obj.setParentTaskName(pTask.getParentTask());
				}
			}
			if(task.getProjectId() != null){
				Project	 proj = projectRepo.findOne(task.getProjectId());
				if(proj != null){
					obj.setProjectName(proj.getProject());
				}	
			}
			if(task.getUserId() != null){
				Users user = userRepo.findOne(task.getUserId());
				if(user != null){
					obj.setUserName(user.getFirstName());
				}
			}
			
			taskObjList.add(obj);
			
		}
		
		return taskObjList;
	}
	

	public Task updateTask(TaskRequest taskreq) {
		Task task = taskRepo.findOne(taskreq.getTaskId());
		task.setParentId(taskreq.getParentTaskId());
		task.setProjectId(taskreq.getProjectId());
		task.setTask(taskreq.getTaskName());
		task.setStartDate(taskreq.getStartDate());
		task.setEndDate(taskreq.getEndDate());
		task.setPriority(taskreq.getPriority());
		task.setStatus(taskreq.getStatus()); 
	    taskRepo.save(task);
		return task;
	}


	public Iterable<TaskRequest> getTasksByProject(Integer id) {
		 List<TaskRequest> taskObjList = new ArrayList<>();
			List<Task> taskList = taskRepo.findAllByProjectId(id);
			for(Task task: taskList){
				TaskRequest obj = new TaskRequest();
				obj.setTaskId(task.getTaskId());
				obj.setParentTaskId(task.getParentId());
				obj.setProjectId(task.getProjectId());
				obj.setTaskName(task.getTask());
				obj.setStartDate(task.getStartDate());
				obj.setEndDate(task.getEndDate());
				obj.setPriority(task.getPriority());
				obj.setStatus(task.getStatus());
				obj.setUserId(task.getUserId());
				if(task.getParentId() != null){
					ParentTask pTask = repo.findOne(task.getParentId());
					if(pTask != null){
						obj.setParentTaskName(pTask.getParentTask());
					}
				}
				if(task.getProjectId() != null){
					Project project = projectRepo.findOne(task.getProjectId());
					if(project != null){
						obj.setProjectName(project.getProject());
					}	
				}
				if(task.getUserId() != null){
					Users user = userRepo.findOne(task.getUserId());
					if(user != null){
						obj.setUserName(user.getFirstName());
					}
				}
				
				taskObjList.add(obj);
				
			}
			return taskObjList;
	}
	


}
