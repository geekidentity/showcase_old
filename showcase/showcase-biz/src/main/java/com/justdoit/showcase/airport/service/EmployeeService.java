package com.justdoit.showcase.airport.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.justdoit.showcase.airport.dao.EmployeeDAO;
import com.justdoit.showcase.airport.entity.Employee;
import com.justdoit.showcase.base.service.BaseService;

/**
 * 
 * @author Mr.Chen
 * 
 */
@Service
@Transactional
public class EmployeeService extends BaseService<Employee, EmployeeDAO>{
	
	public Employee login(String eno, String password){
		Map<String, String> param = new HashMap<String, String>();
		param.put("eno", eno);
		param.put("password", password);
		List<Employee> emp = dao.findByParams(param);
		if(emp.size() > 0){
			return emp.get(0);
		}
		return null;
	}
}
