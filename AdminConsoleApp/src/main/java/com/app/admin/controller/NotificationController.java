package com.app.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.app.admin.model.History;
import com.app.admin.model.Notification;
import com.app.admin.repository.NotificationRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/notification")
public class NotificationController {
	@Autowired
	private NotificationRepository repository;

	@GetMapping("/notifications")
	public List<Notification> findAll() {
		return repository.findAll();
	}

	@GetMapping(path = "/nameandtype/{title}")
	public Notification find(@PathVariable("title") String title) {
		return repository.findByDescription(title);
	}

	@PostMapping(consumes = "application/json")
	public Notification create(@RequestBody Notification notification) {
		 repository.save(notification);
		return repository.findByDescription(notification.getDescription());
	}

	@DeleteMapping(path = "/delete/id/{id}")
	public String delete(@PathVariable("id") int id) {
		repository.delete(repository.findById(id));
		return "Deleted id = "+id+" Successfully";
	}

	@PutMapping(path = "/update/nameandtype/{name}")
	public Notification update(@PathVariable("name") String name, @RequestBody Notification notification)
			throws BadHttpRequest {
		Notification notify = repository.findByDescription(name);
		if (notification.getTarget() != null)
			notify.setTarget(notification.getTarget());
		if (notification.getOrigin() != null)
			notify.setOrigin(notification.getOrigin());
		if (notification.getTitle() != null)
			notify.setTitle(notification.getTitle());
		if (notification.getDescription() != null)
			notify.setDescription(notification.getDescription());
		if (notification.getStatus() != null)
			notify.setStatus(notification.getStatus());
		return repository.save(notify);
	}
}
