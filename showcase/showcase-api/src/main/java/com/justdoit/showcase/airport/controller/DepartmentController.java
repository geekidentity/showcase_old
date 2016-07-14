package com.justdoit.showcase.airport.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.justdoit.showcase.airport.entity.Department;
import com.justdoit.showcase.airport.entity.Employee;
import com.justdoit.showcase.airport.service.DepartmentService;
import com.justdoit.showcase.base.controller.BaseController;

/**
 * 
 * @author Mr.Chen
 * @date 2016年7月14日 下午4:00:30
 */

@Controller
@RequestMapping("/airport/department")
public class DepartmentController extends BaseController<Department, DepartmentService> {

	@Override
	public String index(Model model) {
		// TODO Auto-generated method stub
		return "hello";
	}
	
	@Autowired
	protected DepartmentService departmentService;
	
	/**
	 * 录入
	 * @param department
	 * @return
	 */
	@RequestMapping("/addDepartment")
	public Object addDepartment(Department department) {
		Department dept = departmentService.addDept(department);
		if(dept != null){
			Map<String, Object> response = new HashMap<>();
			response.put("code", "0");
			response.put("msg", dept);
			return response;
		}
		else {
			Map<String, Object> response = new HashMap<>();
			response.put("code", "1");
			response.put("msg", "录入失败");
			return response;		
		}
	}
	
	/**
	 * 修改
	 * 
	 * @param department
	 * @return
	 */
	@RequestMapping("/updateDepartment")
	public Object updateDepartment(Department department){
		departmentService.save(department);
		return departmentService.getAll();
	}
	
	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteDepartment")
	public Object deleteDepartment(@RequestParam("id") Long id){
		departmentService.delete(id);
		return departmentService.getAll();
		
	}

}
