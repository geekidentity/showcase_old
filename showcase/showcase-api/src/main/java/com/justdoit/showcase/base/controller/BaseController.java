/**
 * 
 */
package com.justdoit.showcase.base.controller;

import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.justdoit.showcase.base.entity.BaseEntity;
import com.justdoit.showcase.base.service.BaseService;

/**
 *
 * @author 侯法超
 * @date 创建时间：2016年6月20日  下午4:59:32
 * 
 */
public abstract class BaseController<T extends BaseEntity<Long>, Service extends BaseService<T, ?>> {
	
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
	public Map<String, Object> save(@ModelAttribute("T") T t) {
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
}
