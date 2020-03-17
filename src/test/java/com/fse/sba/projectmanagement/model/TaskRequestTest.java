package com.fse.sba.projectmanagement.model;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class TaskRequestTest {

	private TaskRequest taskRequest;
	
	@Test
	public void test() {
		taskRequest = new TaskRequest();
		taskRequest.setStatus("completed");
		taskRequest.setPriority(25);
		taskRequest.setTaskId(1);
		taskRequest.setTaskName("ISP");
		taskRequest.setParentTask(true);
		taskRequest.setProjectName("Toyota");
		taskRequest.setStartDate(new Date());
		taskRequest.setEndDate(new Date());
		taskRequest.setParentTaskName("FSE");
		taskRequest.setParentTaskId(1);
		taskRequest.setProjectId(1);
		taskRequest.setUserName("Govardhini");
		taskRequest.setUserId(1);
	}

	
	@Test
	public void testgetTask() {
		taskRequest = new TaskRequest();
		taskRequest.getStatus();
		taskRequest.getPriority();
		taskRequest.getTaskId();
		taskRequest.getTaskName();
		taskRequest.setParentTask(true);
		taskRequest.getProjectName();
		taskRequest.getStartDate();
		taskRequest.getEndDate();
		taskRequest.getParentTaskName();
		taskRequest.getParentTaskId();
		taskRequest.getProjectId();
		taskRequest.getUserName();
		taskRequest.getUserId();
	}
}
