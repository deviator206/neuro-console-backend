package com.app.admin.controller;

import java.util.List;

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
import com.app.admin.model.History;
import com.app.admin.model.Notification;
import com.app.admin.repository.NotificationRepository;

@RestController
@RequestMapping("/notification")
public class NotificationController {
	@Autowired
	private NotificationRepository repository;

	@GetMapping("/histories")
	public List<Notification> findAll() {
		return repository.findAll();
	}

	@GetMapping(path = "/{title}")
	public Notification find(@PathVariable("title") String title) {
		return repository.findByTitle(title);
	}

	@PostMapping(consumes = "application/json")
	public Notification create(@RequestBody Notification notification) {
		return repository.save(notification);
	}

	@DeleteMapping(path = "/{history}")
	public void delete(@PathVariable("history") Notification notification) {
		repository.delete(notification);
	}

	@PutMapping(path = "/{name}")
	public Notification update(@PathVariable("name") String name, @RequestBody Notification notification)
			throws BadHttpRequest {
		return repository.save(notification);
	}
}
