package com.app.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginDetailsRepository repository;

	@GetMapping("/logindetails")
	public Iterable<LoginDetails> findAll() {
		return repository.findAll();
	}
	
	@RequestMapping(path = "/id/{id}")
	public LoginDetails findById(@PathVariable("id") int id) {
		return repository.findById(id);
	}

	@RequestMapping(path = "/username/{username}")
	public LoginDetails findByName(@PathVariable("username") String username) {
		return repository.findByUsername(username);
	}

	@RequestMapping(value="/nameandrole")
	public LoginDetails findByNameAndRole(@Param("username") String username, @Param("role") String role) {
		return repository.findByUsernameAndRole(username, role);
	}

	@PostMapping(consumes = "application/json")
	public LoginDetails create(@RequestBody LoginDetails loginDetails) {
		repository.save(loginDetails);
		return  repository.findByUsername(loginDetails.getUsername());
	}

	@DeleteMapping(path = "/delete/id/{id}")
	public String delete(@PathVariable("id") int id) {
		repository.delete(repository.findById(id));
		return "Deleted id = " + id + " Successfully";
	}

	@DeleteMapping(path = "/delete/username/{username}")
	public String deleteByName(@PathVariable("username") String username) {
		repository.delete(repository.findByUsername(username));
		return "Deleted username = " + username + " Successfully";
	}

	@PutMapping(path = "/update/username/{username}")
	public LoginDetails update(@PathVariable("username") String username, @RequestBody LoginDetails loginDetails)
			throws BadHttpRequest {
		LoginDetails login = repository.findByUsername(username);
		if (login != null) {
			if (loginDetails.getPassword() != null)
				login.setPassword(loginDetails.getPassword());
			if (loginDetails.getRole() != null)
				login.setRole(loginDetails.getRole());
			return repository.save(login);
		} else {
			return login;
		}
	}

}
