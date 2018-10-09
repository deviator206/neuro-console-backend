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
import com.app.admin.model.Camera;
import com.app.admin.model.User;
import com.app.admin.repository.CameraRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/camera")
public class CameraController {
	@Autowired
	private CameraRepository repository;

	@GetMapping("/cameras")
	public List<Camera> findAll() {
		return repository.findAll();
	}

	@GetMapping(path = "/name/{name}")
	public Camera find(@PathVariable("name") String name) {
		return repository.findByName(name);
	}
	
	@GetMapping(path = "/id/{id}")
	public Camera find(@PathVariable("id") int id) {
		return repository.findById(id);
	}

	@PostMapping(consumes = "application/json")
	public Camera create(@RequestBody Camera camera) {
		repository.save(camera);
		return repository.findByName(camera.getName());
	}

	@DeleteMapping(path = "/delete/id/{id}")
	public String delete(@PathVariable("id") int id) {
		repository.delete(repository.findById(id));
		return "Deleted id = " + id + " Successfully";
	}

	@PutMapping(path = "/update/name/{name}")
	public Camera update(@PathVariable("name") String name, @RequestBody Camera camera) throws BadHttpRequest {
		Camera oCamera = repository.findByName(name);
		if (oCamera != null) {
			if (camera.getName() != null)
				oCamera.setName(camera.getName());
			if (camera.getLocation() != null)
				oCamera.setLocation(camera.getLocation());
			if (camera.getType() != null)
				oCamera.setType(camera.getType());
			return repository.save(oCamera);
		} else {
			return oCamera;
		}

	}
}
