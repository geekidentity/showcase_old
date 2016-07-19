package com.justdoit.showcase.airport.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.justdoit.showcase.airport.entity.Employee;
import com.justdoit.showcase.airport.entity.Role;
import com.justdoit.showcase.airport.service.EmployeeService;
import com.justdoit.showcase.base.controller.BaseController;

@RestController
@Transactional
public class UserAUTHController extends BaseController<Employee, EmployeeService> {

	@Override
	public String index(Model model) {
		// TODO Auto-generated method stub
		return "hello";
	}
	
	@Secured({Role.SUPER_ADMIN,Role.ADMIN})
	@RequestMapping("/check")
	public Object check(HttpServletRequest request, HttpServletResponse response,HttpSession session){
		//session.getAttribute("curUser");
		Map<String, Object> result = new HashMap<>();
		Employee employee = (Employee) request.getSession().getAttribute("curUser");
		if(employee == null){
			result.put("code",-1);
			System.out.println("-1");
			return result;
		}
		else {
			result.put("code", 1);
			result.put("user", employee);
			System.out.println("1");
			return result;
		}
		
	}

}
