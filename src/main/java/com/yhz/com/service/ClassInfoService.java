package com.yhz.com.service;

public interface ClassInfoService {
	String changeClass(Integer studentId, Integer classId, Integer targetClassId);
	
	String deleteStudent(Integer studentId, Integer classId);
}
