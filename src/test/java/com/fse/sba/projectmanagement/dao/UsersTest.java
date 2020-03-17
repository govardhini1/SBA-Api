package com.fse.sba.projectmanagement.dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class UsersTest {

private Users users;
	
	@Test
	public void test() {
		users = new Users();
		users.setUserId(1);
		users.setFirstName("Govardhini");
		users.setLastName("Elangovan");
		users.setEmployeeId("680828");
	
	}
	
	@Test
	public void testgetuser() {
		users = new Users();
		users.getUserId();
		users.getFirstName();
		users.getLastName();
		users.getEmployeeId();
	
	}

}
