package com.fse.sba.projectmanagement.dao;

import static org.junit.Assert.*;



import org.junit.Test;



public class ParentTaskTest {

	private ParentTask parentTask;
	
	@Test
	public void test() {
		parentTask = new ParentTask();
		parentTask.setParentId(1);
		parentTask.setParentTask("ISP");
	}
	
	@Test
	public void testgetParentTask() {
		parentTask = new ParentTask();
		parentTask.getParentId();
		parentTask.getParentTask();
	
	}

}
