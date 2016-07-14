package com.justdoit.showcase.airport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.justdoit.showcase.airport.dao.DepartmentDAO;
import com.justdoit.showcase.airport.entity.Department;
import com.justdoit.showcase.base.service.BaseService;

/**
 * 
 * @author Mr.Chen
 * @date 2016年7月14日 下午3:30:44
 */

@Service
@Transactional
public class DepartmentService extends BaseService<Department, DepartmentDAO> {	
	
	@Autowired
	protected DepartmentService departmentService;
	
	/**
	 * 添加
	 * 
	 * @param department
	 * @return
	 */
	public Department addDept(Department department){
		departmentService.add(department);
		if(departmentService.get(department.getId()) != null){
			return department;
		}
		else return null;
	}
	
	public void updateDept(Department department){
		departmentService.save(department);
	}

}
