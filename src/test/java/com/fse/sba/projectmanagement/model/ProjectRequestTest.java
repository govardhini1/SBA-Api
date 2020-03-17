package com.fse.sba.projectmanagement.model;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class ProjectRequestTest {

	private ProjectRequest projectRequest;
	
	@Test
	public void test() {
		projectRequest = new ProjectRequest();
		projectRequest.setManager("Govardhini");
		projectRequest.setUserId(1);
		projectRequest.setTaskNumber(1);
		projectRequest.setCompletedTaskNumber(1);
		projectRequest.setProjectId(1);
		projectRequest.setProjectName("IPLUS");
		projectRequest.setStartDate(new Date());
		projectRequest.setEndDate(new Date());
		projectRequest.setPriority(1);
	}

	@Test
	public void testgetproject() {
		projectRequest = new ProjectRequest();
		projectRequest.getManager();
		projectRequest.getUserId();
		projectRequest.getTaskNumber();
		projectRequest.getCompletedTaskNumber();
		projectRequest.getProjectId();
		projectRequest.getProjectName();
		projectRequest.getStartDate();
		projectRequest.getEndDate();
		projectRequest.getPriority();
	}


}

