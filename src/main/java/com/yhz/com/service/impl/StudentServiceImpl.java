package com.yhz.com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yhz.com.dao.StudentMapper;
import com.yhz.com.model.Student;
import com.yhz.com.service.StudentService;


/**
 * Created by CodeGenerator on 2018/08/05.
 */
@Service("StudentService")
@Transactional
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;

	@Override
	public List<Student> studentDetail(Integer id) {
		
		return studentMapper.studentDetail(id);
	}

}