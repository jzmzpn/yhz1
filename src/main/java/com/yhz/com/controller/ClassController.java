package com.yhz.com.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yhz.com.dao.ClassInfoMapper;
import com.yhz.com.dao.StudentMapper;
import com.yhz.com.model.ClassInfo;

@Controller
@RequestMapping("class")
public class ClassController {
	
	@Resource
	private ClassInfoMapper classInfoMapper;
	
	@Resource
	private StudentMapper studentMapper;

	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> query(@PathVariable(value="id")@Required Integer id) {
		ClassInfo info = classInfoMapper.selectByPrimaryKey(id);
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(info == null) {
			return map;
		}
		if(info.getStudentNum() == null || info.getStudentNum() == 0) {
			info.setMaleNum(0);
			info.setFemaleNum(0);
			return map;
		}
		int mNum = studentMapper.getMaleNum(id);
		
		int fNum = info.getStudentNum() - mNum;
		info.setMaleNum(mNum);
		info.setFemaleNum(fNum);
		map.put("classInfo", info);
		return map;
	}
	
}
