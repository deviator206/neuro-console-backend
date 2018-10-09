package com.app.admin.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.admin.model.Camera;

@Repository
public interface CameraRepository extends CrudRepository<Camera, Long> {

	Camera findByName(String name);

	Camera findById(int id);

	Camera findByType(String type);

	List<Camera> findAll();

}