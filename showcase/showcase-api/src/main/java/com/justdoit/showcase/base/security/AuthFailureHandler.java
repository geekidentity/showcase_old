package com.justdoit.showcase.base.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.justdoit.showcase.base.util.JSONUtil;

/**
 * 
 * @author 侯法超
 * @date  2016年7月15日  上午11:57:44
 */
@Component
public class AuthFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		Map<Object, Object> msg = new HashMap<>();
		msg.put("code", 1);
		JSONUtil.map2Json(out, msg);
	}

}
