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

import com.yhz.com.core.PageInfo;
import com.yhz.com.dao.StudentMapper;
import com.yhz.com.model.NewsInfo;
import com.yhz.com.model.Student;

@Controller
@RequestMapping("student")
public class StudentController {
	
	@Resource
	private StudentMapper studentMapper;
	
	@RequestMapping("student-list")
	public String articles() {
		return "/student/student-list";
	}
	
	@RequestMapping(value = "query", method= RequestMethod.POST)
	@ResponseBody
	public PageInfo query(PageInfo pageInfo) {
		System.out.println(pageInfo);
		Integer newsType = pageInfo.getSearch() == null || "".equals(pageInfo.getSearch()) ? 
				null : Integer.parseInt(pageInfo.getSearch());
		int total = studentMapper.getStusSize(newsType);
    	pageInfo.setTotal(total);
    	if(total != 0) {
    		int start  = 0;
    		int page = pageInfo.getPage() == null ? 1 : pageInfo.getPage();
    		int rows = pageInfo.getRows() == null ? 10 : pageInfo.getRows();
            if(page != 1) {
            	start = rows * (page - 1); 
            }
            List<Student> list = studentMapper.getStus(newsType, start, rows);
            pageInfo.setList(list);
    	}
        return pageInfo;
	}

	
	@RequestMapping(value="/{classId}/students", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> query(@PathVariable(value="classId")@Required Integer classId) {
		List<Student> info = studentMapper.selectByClassId(classId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("listData", info);
		return map;
	}
	
}
