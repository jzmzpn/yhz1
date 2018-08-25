package com.yhz.com.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.yhz.com.dao.AttendanceMapper;
import com.yhz.com.dao.ClassInfoMapper;
import com.yhz.com.model.Attendance;
import com.yhz.com.model.ClassInfo;
import com.yhz.com.service.AttendanceService;

@Service("attendanceService")
public class AttendanceServiceImpl implements AttendanceService {
	
	private static final boolean STATUS_FALSE = false;
	
	private static final boolean STATUS_TRUE = true;
	
	@Autowired
	private AttendanceMapper attendanceMapper;
	
	@Autowired
	private ClassInfoMapper classInfoMapper;

	@Override
	public Map<String, Object> countAttendance(Integer classId, String date) {
		int status0Count = attendanceMapper.countByDate(classId, date, STATUS_FALSE);
		
		int status1Count = attendanceMapper.countByDate(classId, date, STATUS_TRUE);
		
		ClassInfo clazz = classInfoMapper.selectByPrimaryKey(classId);
		if(clazz == null) {
			return null;
		}
		
        Map<String, Object> map = new HashMap<String, Object>();
		map.put("class_name", clazz.getClassName());
        map.put("shouldcome", status0Count + status1Count);
		map.put("fact", status1Count);
		map.put("leave", status0Count);
		map.put("cql_today", 0);
		map.put("cql_yesterday", 0);
		
		return map;
	}

	@Override
	public Map<String, Object> classDetail(Integer classId, String date) {
		// TODO Auto-generated method stub
		return attendanceMapper.classDetail(classId, date);
	}

	@Override
	public int addAttend(Attendance attendance) {
		// TODO Auto-generated method stub
		attendance.setAttendanceTime(new Date());
		return attendanceMapper.insertSelective(attendance);
	}

}
