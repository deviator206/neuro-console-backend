package com.app.admin.response;
import java.util.List;

import com.app.admin.model.User;

public class ListOfUsersResponse extends GenericResponse{
	
	List<User> listOfUsers;

	public List<User> getListOfUsers() {
		return listOfUsers;
	}

	public void setListOfUsers(List<User> listOfUsers) {
		this.listOfUsers = listOfUsers;
	}
	
	

}
