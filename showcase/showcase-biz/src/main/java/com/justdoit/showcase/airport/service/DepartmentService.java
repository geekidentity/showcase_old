package com.justdoit.showcase.airport.service;


import java.util.List;

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
	
	
	
	/**
	 * add
	 * 
	 * @param department
	 * @return
	 */
	public Department addDept(Department department){
		dao.add(department);
		if(dao.get(department.getId()) != null){
			return department;
		}
		else return null;
	}
	
	/**
	 * update
	 * 
	 * @param department
	 * @return
	 */
	public Department updateDept(Department department){
		try{
			dao.save(department);
			return department;
		}catch(Exception exception){
			exception.printStackTrace();
			System.out.println("error is:" + exception.getMessage());
			return null;
		}
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteDept(Long id){
		dao.delete(id);
		if(dao.get(id) == null) return true;
		else return false;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public List<Department> listDept(){
		return dao.getAll();
	}

}
