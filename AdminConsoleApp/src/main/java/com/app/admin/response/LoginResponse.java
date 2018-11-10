package com.app.admin.response;

import com.app.admin.model.LoginDetails;


public class LoginResponse extends GenericResponse{

	LoginDetails loginData;

	public LoginDetails getLoginData() {
		return loginData;
	}

	public void setLoginData(LoginDetails loginData) {
		this.loginData = loginData;
	}
	
	

	
}
