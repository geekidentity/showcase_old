package com.justdoit.showcase.airport.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.justdoit.showcase.airport.entity.Department;
import com.justdoit.showcase.airport.entity.Employee;
import com.justdoit.showcase.airport.entity.Role;
import com.justdoit.showcase.airport.service.DepartmentService;
import com.justdoit.showcase.base.controller.BaseController;

/**
 * 
 * @author Mr.Chen
 * @date 2016年7月14日 下午4:00:30
 */

@RestController
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
	@RequestMapping(value = "/addDepartment")
	public Object addDepartment(Department department) {
		Map<String, Object> response = new HashMap<>();
		Department dept = departmentService.addDept(department);
		if(dept != null){
			response.put("code", "1");
			response.put("msg", "录入成功");
			response.put("dept", dept);
			return response;
		}
		else {
			response.put("code", "0");
			response.put("msg", "录入失败，请重新操作！");
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
		Map<String, Object> response = new HashMap<>();
		Department dept = departmentService.updateDept(department);
		if (dept != null) {
			response.put("code", "1");
			response.put("msg", "修改成功");
			response.put("dept", dept);
			return response;
		}
		else {
			response.put("code", "0");
			response.put("msg", "修改失败，请重新操作！");
			return response;
		}
	}
	
	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteDepartment")
	public Object deleteDepartment(@RequestParam("id") Long id){
		Map<String, Object> response = new HashMap<>();
		if (departmentService.deleteDept(id)) {
			response.put("code", "1");
			response.put("msg", "删除成功");
			return response;	
		}
		else {
			response.put("code", "0");
			response.put("msg", "删除失败，请重新操作！");
			return response;
		}
	}
	
	
	/**
	 * 列出全部Department
	 * @return
	 */
	@Secured({Role.SUPER_ADMIN})
	@RequestMapping("/departmentList")
	public Object listDepartment(){
		List<Department> deptList = departmentService.listDept();
		Map<String, Object> response = new HashMap<>();
			response.put("code", "1");
			response.put("msg", "显示列表");
			response.put("deptList", deptList);
			return response;	
	}

}
