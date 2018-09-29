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
import com.app.admin.repository.HistoryRepository;

@RestController
@RequestMapping("/history")
public class HistoryController {
	@Autowired
	private HistoryRepository repository;
	
	@GetMapping("/histories")
	public List<History> findAll() {
		return repository.findAll();
	}

	@GetMapping(path = "/{cameraType}")
	public List<History> find(@PathVariable("cameraType") String cameraType) {
		return repository.findByCameratype(cameraType);
	}

	@PostMapping(consumes = "application/json")
	public History create(@RequestBody History history) {
		return repository.save(history);
	}

	@DeleteMapping(path = "/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		repository.delete(repository.findById(id));
	}

	@PutMapping(path = "/update/{name}")
	public History update(@PathVariable("name") String name, @RequestBody History history) throws BadHttpRequest {
			return repository.save(history);
	}
}
