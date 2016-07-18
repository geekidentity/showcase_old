package com.justdoit.showcase.base.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import com.justdoit.showcase.base.controller.BaseController;


/**
 * 自定义向客户端返回要求登陆JSON信息
 * @author 侯法超
 * @date  2016年7月18日  上午8:04:28
 *
 */
public class JsonLoginPage extends GenericFilterBean {
	public static final String DEFAULT_LOGIN_PAGE_URL = "/login";
	public static final String ERROR_PARAMETER_NAME = "error";
	private String loginPageUrl;
	private boolean formLoginEnabled;
	private boolean openIdEnabled;

	public JsonLoginPage() {
		this.loginPageUrl = DEFAULT_LOGIN_PAGE_URL;
	}

	public boolean isEnabled() {
		return formLoginEnabled || openIdEnabled;
	}


	public String getLoginPageUrl() {
		return loginPageUrl;
	}

	public void setLoginPageUrl(String loginPageUrl) {
		this.loginPageUrl = loginPageUrl;
	}


	public void setFormLoginEnabled(boolean formLoginEnabled) {
		this.formLoginEnabled = formLoginEnabled;
	}

	public void setOpenIdEnabled(boolean openIdEnabled) {
		this.openIdEnabled = openIdEnabled;
	}


	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		if (isLoginUrlRequest(request)) {
			generateJsonLoginPageHtml(request, response);

			return;
		}

		chain.doFilter(request, response);
	}

	private void generateJsonLoginPageHtml(HttpServletRequest request, HttpServletResponse response) {
		BaseController.responseError(-1, "请登陆", 403, request, response);
	}


	private boolean isLoginUrlRequest(HttpServletRequest request) {
		return matches(request, loginPageUrl);
	}


	private boolean matches(HttpServletRequest request, String url) {
		if (url == null) {
			return false;
		}
		String uri = request.getRequestURI();
		int pathParamIndex = uri.indexOf(';');

		if (pathParamIndex > 0) {
			// strip everything after the first semi-colon
			uri = uri.substring(0, pathParamIndex);
		}

		if (request.getQueryString() != null) {
			uri += "?" + request.getQueryString();
		}

		if ("".equals(request.getContextPath())) {
			return uri.equals(url);
		}

		return uri.equals(request.getContextPath() + url);
	}
}
