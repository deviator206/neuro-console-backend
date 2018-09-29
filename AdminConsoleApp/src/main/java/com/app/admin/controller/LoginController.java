package com.app.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.admin.exception.BadHttpRequest;
import com.app.admin.model.LoginDetails;
import com.app.admin.model.User;
import com.app.admin.repository.LoginDetailsRepository;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginDetailsRepository repository;

	@RequestMapping(path = "/id/{id}")
	public LoginDetails findById(@PathVariable("id") int id) {
		return repository.findById(id);
	}

	@RequestMapping(path = "/username/{username}")
	public LoginDetails findByName(@PathVariable("username") String username) {
		return repository.findByUsername(username);
	}

	public LoginDetails findByNameAndRole(@Param("username") String username, @Param("Role") String role) {
		return repository.findByUsernameAndRole(username, role);
	}

	@PostMapping(consumes = "application/json")
	public LoginDetails create(@RequestBody LoginDetails loginDetails) {
		return repository.save(loginDetails);
	}

	@DeleteMapping(path = "/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		repository.delete(repository.findById(id));
	}

	@DeleteMapping(path = "/delete/{username}")
	public void delete(@PathVariable("username") String username) {
		repository.delete(repository.findByUsername(username));
	}

	@PutMapping(path = "/update/{username}")
	public LoginDetails update(@PathVariable("username") String username, @RequestBody LoginDetails loginDetails) throws BadHttpRequest {
		LoginDetails login = repository.findByUsername(username);
		if (loginDetails.getPassword() != null)
			login.setPassword(loginDetails.getPassword());
		if (loginDetails.getRole() != null)
			login.setRole(loginDetails.getRole());
		return repository.save(login);
	}

}
