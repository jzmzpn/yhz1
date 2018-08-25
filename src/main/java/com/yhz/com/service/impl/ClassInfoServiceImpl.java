package com.yhz.com.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yhz.com.dao.ClassInfoMapper;
import com.yhz.com.dao.StudentMapper;
import com.yhz.com.model.ClassInfo;
import com.yhz.com.model.Student;
import com.yhz.com.service.ClassInfoService;

@Service("classInfoService")
public class ClassInfoServiceImpl implements ClassInfoService {

	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private ClassInfoMapper classMapper;
	
	@Override
	@Transactional
	public String changeClass(Integer studentId, Integer classId, Integer targetClassId) {
		ClassInfo classInfo = classMapper.selectByPrimaryKey(classId);
		if(classInfo == null) return "fail";
		ClassInfo targetClass = classMapper.selectByPrimaryKey(targetClassId);
		if(targetClass == null) return "fail";
		Student stu = new Student();
		stu.setId(studentId);
		stu.setClassId(targetClassId);
		int operateResult = studentMapper.updateByPrimaryKeySelective(stu);
		if(operateResult == 0) {
			return "fail";
		} else {
			classInfo.setStudentNum(classInfo.getStudentNum() - 1);
			classInfo.setUpdateDate(new Date());
			classMapper.updateByPrimaryKeySelective(classInfo);
			targetClass.setStudentNum(targetClass.getStudentNum() + 1);
			targetClass.setUpdateDate(new Date());
			classMapper.updateByPrimaryKeySelective(targetClass);
		}
		
		return "success";
	}

	@Override
	public String deleteStudent(Integer studentId, Integer classId) {
		// TODO Auto-generated method stub
		ClassInfo classInfo = classMapper.selectByPrimaryKey(classId);
		if(classInfo == null) return "fail";
		Student stu = new Student();
		stu.setId(studentId);
		stu.setIsDelete(true);
		int operateResult = studentMapper.updateByPrimaryKeySelective(stu);
		if(operateResult == 0) {
			return "fail";
		} else {
			classInfo.setStudentNum(classInfo.getStudentNum() - 1);
			classInfo.setUpdateDate(new Date());
			classMapper.updateByPrimaryKeySelective(classInfo);
		}
		
		return "success";
	}

}
