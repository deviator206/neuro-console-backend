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
import com.app.admin.model.Camera;
import com.app.admin.model.User;
import com.app.admin.repository.CameraRepository;

@RestController
@RequestMapping("/camera")
public class CameraController {
	@Autowired
	private CameraRepository repository;

	@GetMapping("/cameras")
	public List<Camera> findAll() {
		return repository.findAll();
	}

	@GetMapping(path = "/{name}")
	public Camera find(@PathVariable("name") String name) {
		return repository.findByName(name);
	}

	@PostMapping(consumes = "application/json")
	public Camera create(@RequestBody Camera camera) {
		return repository.save(camera);
	}

	@DeleteMapping(path = "/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		repository.delete(repository.findById(id));
	}

	@PutMapping(path = "/update/{name}")
	public Camera update(@PathVariable("name") String name, @RequestBody Camera camera) throws BadHttpRequest {
//		if (repository.exists(name)) {
//			camera.setName(name);
			return repository.save(camera);
//		} else {
//			throw new BadHttpRequest();
//		}
	}
}
