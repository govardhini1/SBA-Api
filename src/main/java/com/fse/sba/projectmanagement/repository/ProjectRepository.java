package com.fse.sba.projectmanagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.fse.sba.projectmanagement.dao.Project;

public interface ProjectRepository extends CrudRepository<Project,Integer>{

}
