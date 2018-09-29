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
import com.app.admin.model.UnIdentifiedPerson;
import com.app.admin.repository.UnIdentifiedPersonRepository;

@RestController
@RequestMapping("/unidentifiedperson")
public class UnIdentifiedPersonController {
	@Autowired
	private UnIdentifiedPersonRepository repository;
	

	@GetMapping("/unidentifiedpersons")
	public List<UnIdentifiedPerson> findAll() {
		return repository.findAll();
	}

	@GetMapping(path = "/id/{id}")
	public UnIdentifiedPerson findById(@PathVariable("id") int id) {
		return repository.findById(id);
	}

	
	@GetMapping(path = "/name/{name}")
	public UnIdentifiedPerson find(@PathVariable("name") String name) {
		return repository.findByName(name);
	}

	@PostMapping(consumes = "application/json")
	public UnIdentifiedPerson create(@RequestBody UnIdentifiedPerson unIdentifiedPerson) {
		return repository.save(unIdentifiedPerson);
	}

	@DeleteMapping(path = "/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		repository.delete(repository.findById(id));
	}
	

	@PutMapping(path = "/update/{name}")
	public UnIdentifiedPerson update(@PathVariable("name") String name, @RequestBody UnIdentifiedPerson unIdentifiedPerson) throws BadHttpRequest {
			return repository.save(unIdentifiedPerson);
	}
}

