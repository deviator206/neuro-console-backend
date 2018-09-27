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

	@RequestMapping(path = "/{user}" )
	public User find(@PathVariable("user") String user) {
		return repository.findByName(user);
	}

	@PostMapping(consumes = "application/json")
	public User create(@RequestBody User user) {
		return repository.save(user);
	}

	@DeleteMapping(path = "/{user}")
	public void delete(@PathVariable("user") User user) {
		repository.delete(user);
	}

	@PutMapping(path = "/{user}")
	public User update(@PathVariable("user") String user, @RequestBody User userObj) throws BadHttpRequest {
		return repository.save(userObj);
	}
}
