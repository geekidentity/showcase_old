package com.justdoit.showcase.airport.service;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.justdoit.showcase.airport.entity.Employee;
import com.justdoit.showcase.base.BaseTest;

public class EmployeeServiceTest extends BaseTest {
	
	@Autowired
	private EmployeeService employeeService;
	
		

	/**
	 * 测试 Employee 登录功能
	 * 
	 * 通过
	 */
	@Test
	@Transactional
	@Ignore
	
	//@Rollback(false)
	public void testLogin(){
		Employee employee = new Employee();
		employee.setEno("001");
		employee.setPassword("001");
		employeeService.add(employee);
		employee =  employeeService.login("002", "justdoit");
		if(employee == null){
			System.out.println("用户名或密码错误");
		}
		else {
			System.out.println(employee);
		}
	}
	
	/**
	 * 
	 * 测试添加 Employee 
	 * 
	 * 通过
	 */
	
	@Test
	@Transactional
	@Ignore
	public void testAddEmployee(){
		Employee employee = new Employee();
		employee.setEno("007");
		employee.setName("zhangsan");
		employee.setPassword("zhangsan");
		boolean result = employeeService.addEmployee(employee);
		assertTrue(result);
	}
	
	/**
	 *  测试findEmployeeByEno
	 *  
	 *  通过
	 */
	@Test
	@Transactional
	public void testFindEmployeeByEno(){
		Employee employee = employeeService.findEmployeeByEno("009");
		System.out.println(employee);
	}
}
