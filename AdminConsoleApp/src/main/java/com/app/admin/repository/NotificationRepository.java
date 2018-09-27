package com.app.admin.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.admin.model.History;
import com.app.admin.model.Notification;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, Long> {
	   

	Notification findById(int id);
	
	Notification findByStatus(String  status);
	
	Notification findByTimestamp(Timestamp timestamp);

	Notification findByTitle(String title);
	
	Notification findByOrigin(String origin);
	
	Notification findByTarget(String target);

	List<Notification> findAll();
	}