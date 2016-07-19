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

	@RequestMapping("/login")
	public Object login( @RequestParam(value = "eno", required = false,defaultValue="0") String eno, 
						  @RequestParam(value = "password", required = false, defaultValue=" ") String password, 
						  ModelMap modelMap, HttpSession httpSession) {
		Map<String, Object> response = new HashMap<>();
		Employee employee = employeeService.login(eno, password);
		if(httpSession.getAttribute("eno") != null){
			response.put("code", "1");
			response.put("msg", "登录成功！");
			//response.put("emp", employee);
			return response;
			
		}
		else if(employee != null){
			httpSession.setAttribute("eno", eno);
			modelMap.addAttribute("emp",httpSession);
			response.put("code", "1");
			response.put("msg", "登录成功！");
			response.put("emp", employee);
			return response;
		}else {
			response.put("code", "0");
			response.put("msg", "用户名或密码错误，请重新输入！");
			return response;
		}
	}
	
	@RequestMapping("/logout")
	public Object logout(HttpServletRequest request, @ModelAttribute("emp") HttpSession httpSession){
		//清除session
		Enumeration<String> em = request.getSession().getAttributeNames();
		while(em.hasMoreElements()){
			request.getSession().removeAttribute(em.nextElement().toString());
		}
		//System.out.println(em.nextElement().toString());
		request.getSession().removeAttribute("emp");
		request.getSession().invalidate();
		Map<String, Object> response = new HashMap<>();
		response.put("code", "1");
		response.put("msg", "注销成功。");
		System.out.println(response);
		return response;
		
	}

	@RequestMapping("/addEmployee")
	public Object addEmployee(Employee employee) {
		Map<String, Object> response = new HashMap<>();
		boolean result = employeeService.addEmployee(employee);
		if (result) {
			response.put("code", "1");
			response.put("msg", "添加成功");
			return response;
		} else {
			response.put("code", "0");
			response.put("msg", "添加失败！");
			return response;
		}
	}

	@RequestMapping("/deleteEmployee")
	public Object deleteEmployee(@RequestParam("id") Long id) {
		employeeService.delete(id);
		if (employeeService.get(id) != null) {
			Map<String, Object> response = new HashMap<>();
			response.put("code", "0");
			response.put("msg", "删除失败");
			return response;
		} else {
			Map<String, Object> response = new HashMap<>();
			response.put("code", "1");
			response.put("msg", "删除成功");
			return response;
		}
	}

	@RequestMapping("/updateEmployee")
	public Object updateEmployee(Employee employee) {
		employeeService.save(employee);
		return employeeService.getAll();
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
