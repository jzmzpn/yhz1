package com.yhz.com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yhz.com.model.Employee;

public interface EmployeeMapper {
	
    int getSize(@Param("kindergartenId") Integer kindergartenId);
    
	List<Employee> getEmployees(@Param("kindergartenId") Integer kindergartenId, @Param("start") Integer start, @Param("rows") Integer rows);
	
	int deleteByPrimaryKey(Integer id);
	
	Employee getEmployee(Integer id);
	
	List<Employee> getAllEmployee();
	
	int insertEmployee(Employee employee);
}