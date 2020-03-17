package com.fse.sba.projectmanagement.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserRequestTest {

	private UserRequest userRequest;
	
	@Test
	public void test() {
		userRequest = new UserRequest();
		userRequest.setFirstName("Govardhini");
		userRequest.setLastName("Elangovan");
		userRequest.setEmployeeId("680828");
	}

	
	@Test
	public void testget() {
		userRequest = new UserRequest();
		userRequest.getFirstName();
		userRequest.getLastName();
		userRequest.getEmployeeId();
	}

}
