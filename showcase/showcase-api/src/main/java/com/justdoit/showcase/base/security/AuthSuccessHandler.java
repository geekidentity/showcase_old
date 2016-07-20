package com.justdoit.showcase.base.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.justdoit.showcase.airport.entity.Employee;
import com.justdoit.showcase.airport.service.EmployeeService;
import com.justdoit.showcase.base.util.JSONUtil;

/**
 * 用户验证成功后返回JSON数据
 * @author 侯法超
 * @date  2016年7月15日  上午11:21:53
 */
@Component
public class AuthSuccessHandler implements AuthenticationSuccessHandler {
	
	@Autowired
	private EmployeeService employeeService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		Map<Object, Object> msg = new HashMap<>();
		Employee employee = (Employee) employeeService.loadUserByUsername(request.getParameter("eno"));
		if (authentication.isAuthenticated()) {
			msg.put("code", 1);
			msg.put("user", employee);
			msg.put("sessionid", authentication.getDetails());
		}
		response.setContentType("application/json;charset=UTF-8");
		
		request.getSession().setAttribute("curUser", employee);
		PrintWriter out = response.getWriter();
		JSONUtil.map2Json(out, msg);
		out.close();
	}

}
