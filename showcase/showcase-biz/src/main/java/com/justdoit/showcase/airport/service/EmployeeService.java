package com.justdoit.showcase.airport.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
public class EmployeeService extends BaseService<Employee, EmployeeDAO> implements UserDetailsService{
	
	
	/**
	 * 登录
	 * 
	 * @param eno
	 * @param password
	 * 
	 * @return
	 */
	public Employee login(String eno, String password){
		Map<String, String> param = new HashMap<String, String>();
		param.put("eno", eno);
		param.put("password", password);
		List<Employee> emp = dao.findByParams(param);
		if(emp.size() > 0){
			return emp.get(0);
		}
		else{
			return null;
		}
	}
	
	/**
	 * 添加Employee
	 * 
	 * @param employee
	 * @return
	 */
	public boolean addEmployee(Employee employee){
		dao.add(employee);
		if(dao.findBy("eno", employee.getEno()).size() > 0){
			return true;
		}
		else return false;
	}
	
	
	/**
	 * findEmployeeByEno
	 * 
	 * @param eno
	 * @return
	 */
	public Employee findEmployeeByEno(String eno){
		if(dao.findBy("eno", eno).size() > 0){
			return dao.findBy("eno", eno).get(0);
		}
		return null;
	}
	
	public List<Employee> empList() {
		return dao.getAll();
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<Employee> list = dao.findBy("eno", username);
		if (list.size() > 0) {
			System.out.println(list.size());
		}
		return list.get(0);
	}
	
}
