package com.justdoit.showcase.airport.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.justdoit.showcase.airport.dao.EmployeeDAO;
import com.justdoit.showcase.airport.entity.Employee;
import com.justdoit.showcase.airport.service.EmployeeService;
import com.justdoit.showcase.airport.service.EmployeeServiceTest;
import com.justdoit.showcase.base.controller.BaseController;


/**
 * 
 * @author Mr.Chen
 * @date 2016年7月12日 下午7:05:59
 */

@RestController
@RequestMapping("/airport/employee")
public class EmployeeController extends BaseController<Employee, EmployeeService> {

	@Autowired
	protected EmployeeService employeeService;
	@Override
	public String index(Model model) {
		return "hello";
	}
	
	@RequestMapping("/login")
	public Object login(@RequestParam("eno") String eno, @RequestParam("password") String password) {
		Employee employee = employeeService.login(eno, password);
		if(employee == null){
			Map<String, String> response = new HashMap<>();
			response.put("code", "0");
			response.put("msg", "用户名或密码错误，请重新输入！");
			return response;
		}
		return employee;
	}

}