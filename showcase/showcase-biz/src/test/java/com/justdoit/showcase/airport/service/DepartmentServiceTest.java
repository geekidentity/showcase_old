package com.justdoit.showcase.airport.service;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.justdoit.showcase.airport.entity.Department;
import com.justdoit.showcase.base.BaseTest;


/**
 * 
 * @author Mr.Chen
 * @date 2016年7月15日 上午8:41:06
 */
public class DepartmentServiceTest extends BaseTest {
	
	@Autowired
	protected DepartmentService departmentService;

	
	/**
	 * 测试add
	 * 
	 * 通过
	 */
	@Test
	@Transactional
	//@Rollback(false)
	@Ignore
	public void testAddDept() {
		Department department = new Department();
		department.setName("测试");
		department.setPhone("12345");
		department.setEmail("12345@showcase.com");
		department.setAddress("创业大厦五楼505");
		department.setDescription("测试用");
		assertNotNull(departmentService.addDept(department));
		
		
	}

	
	/**
	 * update
	 * 
	 * 通过
	 */
	@Test
	@Transactional
	@Ignore
	public void testUpdateDept() {
		Department department = departmentService.get(3L);
		department.setPhone("54321");
		assertNotNull(departmentService.updateDept(department));
	}

	/**
	 * delete
	 * 
	 * 通过
	 */
	@Test
	@Transactional
	@Ignore
	public void testDeleteDept() {
		boolean result = departmentService.deleteDept(3L);
		assertTrue(result);
	}

	/**
	 * List
	 * 
	 * 通过
	 * 
	 */
	@Test
	@Transactional
	@Ignore
	public void testListDept() {
		assertNotNull(departmentService.listDept());
	}

}
