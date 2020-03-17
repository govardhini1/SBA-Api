package com.fse.sba.projectmanagement.dao;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class ProjectTest {

private Project project;
	
	@Test
	public void test() {
		project = new Project();
		project.setUserId(1);
		project.setProjectId(1);
		project.setProject("IPLUS");
		project.setStartDate(new Date());
		project.setEndDate(new Date());
		project.setPriority(1);	
	}
	
	@Test
	public void testgetproject() {
		project = new Project();
		project.getUserId();
		project.getProjectId();
		project.getProject();
		project.getStartDate();
		project.getEndDate();
		project.getPriority();
		
	
	}



}
