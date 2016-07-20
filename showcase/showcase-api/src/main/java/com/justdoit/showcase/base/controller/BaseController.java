package com.justdoit.showcase.base.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;

import com.justdoit.showcase.base.entity.BaseEntity;
import com.justdoit.showcase.base.service.BaseService;
import com.justdoit.showcase.base.util.JSONUtil;

/**
 *
 * @author 侯法超
 * @date 创建时间：2016年6月20日  下午4:59:32
 * 
 * 
 * 
 */
public abstract class BaseController<T extends BaseEntity<Long>, Service extends BaseService<T, ?>> {
	
	protected static Logger logger = Logger.getLogger(BaseController.class);
	@Autowired
	protected Service service;
	
	/**
	 * 默认主页
	 * @param model
	 * @return
	 */
	@RequestMapping()
	public abstract String index(Model model);
	
	@RequestMapping(value="/save")
	@ResponseBody
	public Map<String, Object> save(@ModelAttribute("T") T t, BindingResult result) {
		logger.debug(result);
		logger.debug("add something:" + t);
		if (t.getId() != null) {
			T temp = service.get(t.getId());
			BeanUtils.copyProperties(t, temp);
			temp.setGmtModified(new Date());
			temp.setLastModifiedById(0L);
			t = temp;
		} else {
			t.setGmtCreate(new Date());
			t.setCreateById(0L);
		}
		return service.save(t);
		
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	public Map<String, Object> delete(@RequestParam("id") long id) {
		T t = service.delete(id);
		Map<String, Object> result = new HashMap<>();
		result.put("sccess", true);
		result.put("status", t);
		return result;
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value="/list")
	@ResponseBody
	public List<T> getAll() {
		return service.getAll();
	}
	
	/**
	 * 条件查询
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/search")
	@ResponseBody
	public List<T> findByParams(HttpServletRequest request) {
		Enumeration<String> enumeration = request.getAttributeNames();
		Map<String, String> params = new HashMap<String, String>();
		while (enumeration.hasMoreElements()) {
			String name = (String) enumeration.nextElement();
			Object val = request.getAttribute(name);
			if (val instanceof String) {
				String param = (String) val;
				params.put(name, param);
			}
		}
		return service.findByParams(params);
	}
	
	@RequestMapping(value="/detail")
	@ResponseBody
	public T detail(@RequestParam("id") long id) {
		return service.get(id);
	}
	
	@ExceptionHandler
	public void handleException(HttpServletRequest request,
			HttpServletResponse response, HandlerMethod handlerMethod, Exception e) {
		
		
		if (e instanceof MissingServletRequestParameterException) {
			handleMissingServletRequestParameterException(request, response, handlerMethod, e);
		} else if (e instanceof AccessDeniedException) {
			handleAccessDeniedException(request, response, handlerMethod, e);
		} else {
			handleUnknowException(request, response, handlerMethod, e);
		}
		
	}
	
	private void handleMissingServletRequestParameterException(HttpServletRequest request,
			HttpServletResponse response, HandlerMethod handlerMethod, Exception e) {
		MissingServletRequestParameterException me = (MissingServletRequestParameterException) e;
		responseError(-1, "required parameters:" + me.getParameterName(), 400, request, response);
	}
	
	/**
	 * 处理未授权的异常
	 * @param request
	 * @param response
	 * @param handlerMethod
	 * @param e
	 */
	private void handleAccessDeniedException(HttpServletRequest request,
			HttpServletResponse response, HandlerMethod handlerMethod, Exception e) {
		AccessDeniedException exception = (AccessDeniedException) e;
		responseError(403, exception.getMessage(), 403, request, response);
	}
	
	private void handleUnknowException(HttpServletRequest request,
			HttpServletResponse response, HandlerMethod handlerMethod, Exception e) {
		logger.debug("unknow exception:", e);
		responseError(500, e.getMessage(), 500, request, response);
	}
	
	/**
	 * 向客户端响应异常消息
	 * @param code 异常编号
	 * @param msg 异常信息
	 * @param status HTTP响应头
	 * @param request
	 * @param response
	 */
	public static void responseError(int code, String msg, int status, HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/json;charest=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setStatus(status);
		PrintWriter out = null;
		try {
			out = response.getWriter();
			Map<Object, Object> info = new HashMap<>();
			info.put("code", code);
			info.put("msg", msg);
			JSONUtil.map2Json(out, info);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			out.close();
		}
	}
}
