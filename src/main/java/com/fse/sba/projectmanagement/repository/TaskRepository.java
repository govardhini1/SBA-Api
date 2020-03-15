package com.fse.sba.projectmanagement.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fse.sba.projectmanagement.dao.Task;

public interface TaskRepository extends CrudRepository<Task,Integer>{

	List<Task> findAllByProjectId(Integer id);
		
	List<Task> findAllByProjectIdAndStatus(Integer id, String status);
	
}
