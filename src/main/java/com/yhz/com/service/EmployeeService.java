package com.yhz.com.service;
import java.util.List;

import com.yhz.com.model.Employee;


/**
 * Created by CodeGenerator on 2018/08/05.
 */
public interface EmployeeService {
	
	int getSize(Integer ikindergartenIdd);
	
	List<Employee> getEmployee(Integer kindergartenId, Integer start, Integer rows);
	
	int deleteByKey(int kindergartenId);
	
	Employee getEmployee(Integer id);
}