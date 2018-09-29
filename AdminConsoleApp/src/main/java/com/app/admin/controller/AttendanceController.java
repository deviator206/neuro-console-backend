package com.app.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.admin.repository.AttendanceRepository;
import com.app.admin.repository.HistoryRepository;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
	@Autowired
	private HistoryRepository historyRepository;
	
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	
}
