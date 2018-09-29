package com.app.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.admin.exception.BadHttpRequest;
import com.app.admin.model.User;
import com.app.admin.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository repository;

	@GetMapping("/users")
	public Iterable<User> findAll() {
		return repository.findAll();
	}

	@RequestMapping(path = "/id/{id}" )
	public User findById(@PathVariable("id") int id) {
		return repository.findById(id);
	}
	
	@RequestMapping(path = "/name/{user}" )
	public User findByName(@PathVariable("user") String user) {
		return repository.findByName(user);
	}
	
	@RequestMapping(path = "/phone/{phone}" )
	public User findByPhone(@PathVariable("phone") String phone) {
		return repository.findByPhone(phone);
	}
	
	@RequestMapping(path = "/email/{email}" )
	public User findByEmail(@PathVariable("email") String email) {
		return repository.findByEmail(email);
	}

	@PostMapping(consumes = "application/json")
	public User create(@RequestBody User user) {
		return repository.save(user);
	}

	@DeleteMapping(path = "/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		repository.delete(repository.findById(id));
	}

	@PutMapping(path = "/update/{user}")
	public User update(@PathVariable("user") String user, @RequestBody User userObj) throws BadHttpRequest {
		User u = repository.findByName(user);
		if(userObj.getDepartment() != null) u.setDepartment(userObj.getDepartment());
		if(userObj.getDob() != null) u.setDob(userObj.getDob());
		if(userObj.getEmail() != null) u.setEmail(userObj.getEmail());
		if(userObj.getGender() != null) u.setGender(userObj.getGender());
		if(userObj.getMisc() != null) u.setMisc(userObj.getMisc());
		if(userObj.getName() != null) u.setName(userObj.getName());
		if(userObj.getPhone() != null) u.setPhone(userObj.getPhone());
		if(userObj.getPicname() != null) u.setPicname(userObj.getPicname());
		if(userObj.getPictemplate() != null) u.setPictemplate(userObj.getPictemplate());
		if(userObj.getPicurl() != null) u.setPicurl(userObj.getPicurl());
		return repository.save(u);
	}
}
