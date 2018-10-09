package com.app.admin.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.admin.model.History;
import com.app.admin.repository.HistoryRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/attendance")
public class AttendanceController {
	@Autowired
	private HistoryRepository historyRepository;

//	@Autowired
//	private AttendanceRepository attendanceRepository;
	Timestamp startDate;
	Timestamp endDate;

	@RequestMapping(value = "/fromto")
	public List<History> findByDateLessThanEqualAndDateGreaterThanEqual(
			@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @Param("from") String from,
			@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @Param("to") String to) throws ParseException {
		return historyRepository.findByMinMaxTimeWhereTimestampBetweenFromTo(getTimestamp(from, null),
				getTimestamp(to, null));
	}

	@RequestMapping(value = "/fordate/{date}")
	public List<History> findByMinMaxTimeWhereTimestamp(@PathVariable("date") String date) throws ParseException {
		return historyRepository.findByMinMaxTimeWhereTimestamp(getTimestamp(date, null));
	}

	@RequestMapping(value = "/formonth/{month}")
	public List<History> findByMinMaxTimeWhereTimestampForMonth(@PathVariable("month") String month)
			throws ParseException {
		getMonthValue(month);
		return historyRepository.findByMinMaxTimeWhereTimestampBetweenFromTo(getStartDate(),getEndDate());
	}

	private Timestamp getTimestamp(String timestamp, String month) throws ParseException {
		SimpleDateFormat fromServer = null;
		if (month == null) {
			fromServer = new SimpleDateFormat("yyyy-MM-dd");
		} else {
			fromServer = new SimpleDateFormat("yyyy-MM");
		}
		Date now = fromServer.parse(timestamp);
		Timestamp nowTimestamp = new Timestamp(now.getTime());
		System.out.println(nowTimestamp);
		return nowTimestamp;
	}

	private Timestamp getTimestamp(Date date) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
		Date now = (Date) sdf.parse(date.toString());

		Timestamp nowTimestamp = new Timestamp(now.getTime());
		return nowTimestamp;
	}

	private void getMonthValue(String month) throws ParseException {
		int mnth = 0;
		if (month.contains("-")) {
			month = month.split("-")[1];
			System.out.println(month);
			mnth = Integer.parseInt(month) - 1;
			System.out.println(mnth);
		} else if (month.equalsIgnoreCase("JANUARY") || month.equalsIgnoreCase("JAN")) {
			mnth = Calendar.JANUARY;
		} else if (month.equalsIgnoreCase("FEBRUARY") || month.equalsIgnoreCase("FEB")) {
			mnth = Calendar.FEBRUARY;
		} else if (month.equalsIgnoreCase("MARCH") || month.equalsIgnoreCase("MAR")) {
			mnth = Calendar.MARCH;
		} else if (month.equalsIgnoreCase("APRIL") || month.equalsIgnoreCase("APR")) {
			mnth = Calendar.APRIL;
		} else if (month.equalsIgnoreCase("MAY")) {
			mnth = Calendar.MAY;
		} else if (month.equalsIgnoreCase("JUNE") || month.equalsIgnoreCase("JUN")) {
			mnth = Calendar.JUNE;
		} else if (month.equalsIgnoreCase("JULY") || month.equalsIgnoreCase("JUL")) {
			mnth = Calendar.JULY;
		} else if (month.equalsIgnoreCase("AUGUST") || month.equalsIgnoreCase("AUG")) {
			mnth = Calendar.AUGUST;
		} else if (month.equalsIgnoreCase("SEPTEMBER") || month.equalsIgnoreCase("SEP")
				|| month.equalsIgnoreCase("SEPT")) {
			mnth = Calendar.SEPTEMBER;
		} else if (month.equalsIgnoreCase("OCTOBER") || month.equalsIgnoreCase("OCT")) {
			mnth = Calendar.OCTOBER;
		} else if (month.equalsIgnoreCase("NOVEMBER") || month.equalsIgnoreCase("NOV")) {
			mnth = Calendar.NOVEMBER;
		} else if (month.equalsIgnoreCase("DECEMBER") || month.equalsIgnoreCase("DEC")) {
			mnth = Calendar.DECEMBER;
		}

		Calendar calendar = Calendar.getInstance();
		calendar.set(2018, mnth, 01, 00, 00, 00);
		calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		Date monthFirstDay = calendar.getTime();
		System.out.println(monthFirstDay);
		Timestamp startDate = getTimestamp(monthFirstDay);
		setStartDate(startDate);

		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date monthLastDay = calendar.getTime();
		System.out.println(monthLastDay);
		Timestamp endDate = getTimestamp(monthLastDay);
		setEndDate(endDate);
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

}
