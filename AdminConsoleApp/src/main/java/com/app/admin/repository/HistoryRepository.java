package com.app.admin.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.admin.model.History;

@Repository
public interface HistoryRepository extends CrudRepository<History, Long> {

	History findById(int id);

	History findByTimein(Timestamp timein);
	
	History findByTimeout(Timestamp timeout);

	List<History> findByCameratype(String type);

	List<History> findAll();

}
