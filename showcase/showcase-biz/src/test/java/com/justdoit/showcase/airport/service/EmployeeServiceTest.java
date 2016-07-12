package com.justdoit.showcase.airport.service;


import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.justdoit.showcase.airport.entity.Employee;
import com.justdoit.showcase.base.BaseTest;

public class EmployeeServiceTest extends BaseTest {
	
	@Autowired
	private EmployeeService employeeService;
		

	/**
	 * 测试Employee登录功能
	 */
	@Test
	@Transactional
	@Ignore
	public void testLogin(){
		Employee employee = new Employee();
		employee.setEno("001");
		employee.setPassword("001");
		employeeService.add(employee);
		employee =  employeeService.login("001", "002");
		if(employee == null){
			System.out.println("用户名或密码错误");
		}
		else {
			System.out.println(employee);
		}
	}
	
}
