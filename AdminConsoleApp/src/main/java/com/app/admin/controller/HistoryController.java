package com.app.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.admin.model.History;
import com.app.admin.repository.HistoryRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/history")
public class HistoryController {
	@Autowired
	private HistoryRepository repository;

	@GetMapping("/histories")
	public List<History> findAll() {
		return repository.findAll();
	}

	@GetMapping(path = "/id/{id}")
	public History find(@PathVariable("id") int id) {
		return repository.findById(id);
	}

	@GetMapping(path = "/name/{name}")
	public List<History> findByName(@PathVariable("name") String name) {
		return repository.findByName(name);
	}

	@GetMapping(path = "/cameratype/{cameraType}")
	public List<History> find(@PathVariable("cameraType") String cameraType) {
		return repository.findByCameratype(cameraType);
	}
	
	@RequestMapping(value="/nameandtype")
	public List<History> findByNameAndCameratype(@Param("name") String name, @Param("cameratype") String cameratype) {
		return repository.findByNameAndCameratype(name, cameratype);
	}

	/*@PostMapping(consumes = "application/json")
	public History create(@RequestBody History history) {
		return repository.save(history);
	}*/

	@DeleteMapping(path = "/delete/id/{id}")
	public String delete(@PathVariable("id") int id) {
		repository.delete(repository.findById(id));
		return "Deleted id = " + id + " Successfully";
	}

	/*@PutMapping(path = "/update/name/{name}")
	public History update(@PathVariable("name") String name, @RequestBody History history) throws BadHttpRequest {
		History hist = repository.findByName(history.getName());
		if (history.getCameratype() != null)
			hist.setCameratype(history.getCameratype());
		if (history.getTimein() != null)
			hist.setTimein(history.getTimein());
		if (history.getTimeout() != null)
			hist.setTimeout(history.getTimeout());
		return repository.save(hist);
	}*/
}
