package com.app.admin.repository;

import com.app.admin.model.History;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

public interface AttendanceRepository extends PagingAndSortingRepository<History, Long> {

	
	 Page<History> findByDateLessThanEqualAndDateGreaterThanEqual(
	            @DateTimeFormat(pattern = "yyyy-MM-dd") @Param("from") Date from,
	            @DateTimeFormat(pattern = "yyyy-MM-dd") @Param("to") Date to,
	            Pageable pageable
	    );
}
