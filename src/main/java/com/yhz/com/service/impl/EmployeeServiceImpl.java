package com.yhz.com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yhz.com.dao.EmployeeMapper;
import com.yhz.com.model.Employee;
import com.yhz.com.service.EmployeeService;


/**
 * Created by CodeGenerator on 2018/08/05.
 */
@Service("EmployeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeMapper employeeMapper;


	@Override
	public int deleteByKey(int id) {
		return employeeMapper.deleteByPrimaryKey(id);
	}


	@Override
	public int getSize(Integer kindergartenId) {
		return employeeMapper.getSize(kindergartenId);
	}


	@Override
	public List<Employee> getEmployee(Integer kindergartenId, Integer start,
			Integer rows) {
		return employeeMapper.getEmployees(kindergartenId, start, rows);
	}


	@Override
	public Employee getEmployee(Integer id) {
		return employeeMapper.getEmployee(id);
	}
    

}