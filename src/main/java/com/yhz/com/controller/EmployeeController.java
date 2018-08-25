package com.yhz.com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yhz.com.core.PageInfo;
import com.yhz.com.dao.EmployeeMapper;
import com.yhz.com.model.Employee;

@Controller
@RequestMapping("employee")
public class EmployeeController {
	
	@Resource
	private EmployeeMapper employeeMapper;
	
	@RequestMapping("employee-list")
	public String articles() {
		return "/employee/employee-list";
	}
	
	@RequestMapping(value = "employeeList", method= RequestMethod.POST)
	@ResponseBody
	public PageInfo query(PageInfo pageInfo) {
		System.out.println(pageInfo);
		Integer newsType = pageInfo.getSearch() == null || "".equals(pageInfo.getSearch()) ? 
				null : Integer.parseInt(pageInfo.getSearch());
		int total = employeeMapper.getSize(newsType);
    	pageInfo.setTotal(total);
    	if(total != 0) {
    		int start  = 0;
    		int page = pageInfo.getPage() == null ? 1 : pageInfo.getPage();
    		int rows = pageInfo.getRows() == null ? 10 : pageInfo.getRows();
            if(page != 1) {
            	start = rows * (page - 1); 
            }
            List<Employee> list = employeeMapper.getEmployees(newsType, start, rows);
            pageInfo.setList(list);
    	}
        return pageInfo;
	}
	
	@RequestMapping(value = "employeeDetail/{id}", method= RequestMethod.GET)
	@ResponseBody
	public  Map<String, Object> employeeDetail(@PathVariable Integer id) {
		Employee employee=employeeMapper.getEmployee(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("messageInfo", employee);
        return map;
	}
	
	@RequestMapping(value = "deleteEmployee", method= RequestMethod.POST)
	@ResponseBody
	public int deleteByKey(@PathVariable Integer id) {
        return employeeMapper.deleteByPrimaryKey(id);
	}

	
}
