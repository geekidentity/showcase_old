package com.justdoit.showcase.airport.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.justdoit.showcase.airport.entity.Cache;
import com.justdoit.showcase.airport.entity.Employee;
import com.justdoit.showcase.airport.service.CacheService;
import com.justdoit.showcase.airport.service.EmployeeService;
import com.justdoit.showcase.base.controller.BaseController;

@RestController
public class UserAUTHController extends BaseController<Employee, EmployeeService> {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private CacheService cacheService;
	
	
	@Override
	public String index(Model model) {
		// TODO Auto-generated method stub
		return "hello";
	}
	@RequestMapping("/api/auth/login")
	public Object login(@RequestParam("eno") String eno, 
			@RequestParam("password") String password, 
			@RequestParam(value = "remember", required = false, defaultValue="false") String remember){

		Map<String, String> params = new HashMap<>();
		Map<String, Object> response = new HashMap<>();
		params.put("eno", eno);
		params.put("password", password);
		List<Employee> employees = employeeService.findByParams(params);
		if(employees != null && employees.size()>0){
			
			Cache cache = saveToken(eno, remember);
			response.put("code", 1);
			response.put("cache", cache);
		}else {
			response.put("code", -1);
			response.put("msg", "用户名或密码不正确");
		}
		return response;
	}

	
	@RequestMapping("/api/auth/check")
	public Object check(@RequestParam("token") String token, 
						@RequestParam("eno") String eno){
		Map<String, String> params = new HashMap<>();
		Map<String, Object> response = new HashMap<>();
		params.put("eno", eno);
		params.put("token", token);
		List<Cache> caches = cacheService.findByParams(params);
		if(caches != null && caches.size() > 0){
			Employee employee = employeeService.findBy("eno",eno).get(0);
			response.put("code", 1);
			response.put("employee", employee);
		}else {
			response.put("code", -1);
			response.put("msg", "验证失败，请重新登陆");
		}
		return response;
	}
	
	@RequestMapping("/api/auth/logout")
	public Object logout(@RequestParam("token") String token, 
						 @RequestParam("eno") String eno){
		Map<String, String> params = new HashMap<>();
		Map<String, Object> response = new HashMap<>();
		params.put("eno", eno);
		params.put("token", token);
		List<Cache> caches = cacheService.findByParams(params);
		for (Cache cache : caches) {
			logger.debug("delete eno" + eno);
			cacheService.delete(cache.getId());
		}
		if(cacheService.findBy("eno", eno).size() > 0){
			response.put("code", -1);
			response.put("msg", "注销失败");
		}else {
			response.put("code", 1);
			response.put("msg", "注销成功");
		}
		return response;
	}

	private Cache saveToken(String eno, String remember) {
		List<Cache> caches = cacheService.findBy("eno", eno);
		for (Cache cache : caches) {
			logger.debug("delete eno" + eno);
			cacheService.delete(cache.getId());
		}
		Date date = new Date(new Date().getTime() + (remember.equals("true")?7*24*3600*1000:30*60*1000));
		Cache cache = new Cache();
		cache.setEno(eno);
		cache.setToken(new Md5PasswordEncoder().encodePassword(new Date() + eno, "jdi"));
		cache.setOutTime(date);
		cacheService.save(cache);
		return cache;
	}
	
	/*private Cache deleteToken(String eno, String token){
		
	}*/
	//@Secured({Role.SUPER_ADMIN,Role.ADMIN})
	/*public Object check(HttpServletRequest request, HttpServletResponse response,HttpSession session){
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
		
	}*/

}
