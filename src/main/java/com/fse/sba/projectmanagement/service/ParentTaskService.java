package com.fse.sba.projectmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fse.sba.projectmanagement.dao.ParentTask;
import com.fse.sba.projectmanagement.repository.ParentTaskRepository;

@Service
public class ParentTaskService {
	
	@Autowired
	private ParentTaskRepository parentTaskrepository;
	

	public List<ParentTask> getAllUsers() {
		return (List<ParentTask>) parentTaskrepository.findAll();
	}
	
	

	public ParentTask addParentTask(String task) {
		ParentTask ptask = new ParentTask();
		ptask.setParentTask(task);
		parentTaskrepository.save(ptask);
		return ptask;
	}
	

}
