package com.app.admin.response;

import com.app.admin.model.User;


public class CreateUserRespose extends GenericResponse{

	private User userObj;
	

	public User getUserObj() {
		return userObj;
	}

	public void setUserObj(User userObj) {
		this.userObj = userObj;
	}
	
	
	
	
}
