package com.yhz.com.service;

import java.util.Date;
import java.util.Map;

import com.yhz.com.model.Attendance;

public interface AttendanceService {
	
	Map<String, Object> countAttendance(Integer classId, String date);
	
	Map<String, Object> classDetail(Integer classId, String date);
	
	int addAttend(Attendance attendance);

}
