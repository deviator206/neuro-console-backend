package com.app.admin.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.admin.model.History;
package com.app.admin.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
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

	List<History> findByName(String name);

	@Query("select min(h.timein),max(h.timeout) from History h where h.date =?1 and h.name=?2")
	List<History> findByMinMaxTimeWhereTimestampAndName(Timestamp timestamp, String name);
	
	
	@Query("select min(h.timein),max(h.timeout) from History h where h.date like '?1%'")
	List<History> findByMinMaxTimeWhereTimestamp(Timestamp timestamp);
	
	@Query("select min(h.timein),max(h.timeout), name from History h where h.date  >=  ?1 and h.date <= ?2")
	List<History> findByMinMaxTimeWhereTimestampBetweenFromTo(Timestamp timeStampFrom, Timestamp timeStampTo);

	List<History> findByNameAndCameratype(String name, String cameratype);
}

@Repository
public interface HistoryRepository extends CrudRepository<History, Long> {

	History findById(int id);

	History findByTimein(Timestamp timein);
	
	History findByTimeout(Timestamp timeout);

	List<History> findByCameratype(String type);

	List<History> findAll();

}
