package com.justdoit.showcase.airport.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.justdoit.showcase.airport.entity.Employee;
import com.justdoit.showcase.airport.entity.Role;
import com.justdoit.showcase.airport.service.EmployeeService;
import com.justdoit.showcase.base.controller.BaseController;

/**
 * 
 * @author Mr.Chen
 * @date 2016年7月12日 下午7:05:59
 */

@RestController
@RequestMapping("/airport/employee")
@SessionAttributes({"emp"})
public class EmployeeController extends BaseController<Employee, EmployeeService> {

	@Autowired
	protected EmployeeService employeeService;

	@Override
	public String index(Model model) {
		return "hello";
	}

	@Secured({Role.SUPER_ADMIN,Role.ADMIN})
	@Override
	public Map<String, Object> save(Employee t) {
		return super.save(t);
	}

	@Secured({Role.SUPER_ADMIN,Role.ADMIN})
	@Override
	public Map<String, Object> delete(long id) {
		return super.delete(id);
	}
	
	@Secured({Role.ADMIN})
	@RequestMapping("/employeeList")
	public Object employeeList(){
		List<Employee> empList = employeeService.empList();
		Map<String, Object> response = new HashMap<>();
			response.put("code", "1");
			response.put("msg", "显示列表");
			response.put("deptList", empList);
			return response;	
	}

}
