package com.fse.sba.projectmanagement.repository;


import org.springframework.data.repository.CrudRepository;

import com.fse.sba.projectmanagement.dao.Users;


public interface UserRepository extends CrudRepository<Users, Integer> {

}