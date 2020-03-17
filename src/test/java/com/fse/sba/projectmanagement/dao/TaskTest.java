package com.fse.sba.projectmanagement.dao;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class TaskTest {

private Task task;
	
	@Test
	public void test() {
		task = new Task();
		task.setStatus("completed");
		task.setPriority(25);
		task.setTaskId(1);
		task.setStartDate(new Date());
		task.setEndDate(new Date());
		task.setProjectId(1);
		task.setUserId(1);
		task.setParentId(1);
		task.setTask("jobs");
		
	
	}

	
	@Test
	public void testgettask() {
		task = new Task();
		task.getStatus();
		task.getPriority();
		task.getTaskId();
		task.getStartDate();
		task.getEndDate();
		task.getProjectId();
		task.getUserId();
		task.getParentId();
		task.getTask();
		
	
	}

}
