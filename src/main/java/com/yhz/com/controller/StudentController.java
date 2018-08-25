package com.yhz.com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yhz.com.dao.StudentMapper;
import com.yhz.com.model.Student;
import com.yhz.com.model.UserInfo;

@Controller
@RequestMapping("student")
public class StudentController {
	
	@Resource
	private StudentMapper studentMapper;

	
	@RequestMapping(value="/{classId}/students", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> query(@PathVariable(value="classId")@Required Integer classId) {
		List<Student> info = studentMapper.selectByClassId(classId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("listData", info);
		return map;
	}
	
	@RequestMapping(value="studentDetail/{Id}", method=RequestMethod.GET)
	@ResponseBody
    public Map<String, Object> query1(@PathVariable("Id")Integer id) {
		
		List<Student> info = studentMapper.studentDetail(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("studentMapper", info);
        return map;
    }
	
}
