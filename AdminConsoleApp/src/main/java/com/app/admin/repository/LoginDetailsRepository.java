package com.app.admin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.admin.model.LoginDetails;

@Repository
public interface LoginDetailsRepository extends CrudRepository<LoginDetails, Long> {

	LoginDetails findById(int id);
	
	LoginDetails findByUsername(String username);
	
	LoginDetails findByUsernameAndRole(String username,String role);

	LoginDetails findByUsernameAndPassword(String username,String password);

}
