/**
 * 
 */
package com.justdoit.showcase.base.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.justdoit.showcase.base.dao.HibernateBaseDao;

/**
 * Service层基类，提供Service层的基本方法，其余方法请自己实现
 * 
 * @author 侯法超
 * @date 创建时间：2016年6月16日  下午9:36:34
 * 
 */
public abstract class BaseService<T, DAO extends HibernateBaseDao<T, Long>> {
	
	@Autowired
	protected DAO dao;
	
	public Map<String, Object> save(T t) {
		t = dao.save(t);
		Map<String, Object> result = new HashMap<>();
		result.put("seccess", true);
		result.put("status", t);
		return result;
	}
	
	public T delete(long id) {
		return dao.delete(id);
	}
	
	public void add(T entity) {
		dao.add(entity);
	}
	
	/**
	 * 查找全部,禁止使用
	 * @return 
	 */
	@Deprecated
	public List<T> getAll() {
		return dao.getAll();
	}
	
	public T get(long id) {
		return dao.get(id);
	}
	
	/**
	 * 根据条件查询
	 * @param params 查询条件
	 * @return
	 */
	public List<T> findByParams(Map<String, String> params) {
		return dao.findByParams(params);
	}
	
	/**
	 * 根据属性Map查找一个对象，将返回找到的第一个，如果没有返回 NULL
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public T findOneByParams(Map<String, String> params) {
		List<T> list = dao.findByParams(params);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	
	public List<T> findBy(String propertyName, Object value) {
		return dao.findBy(propertyName, value);
	}
	
	/**
	 * 根据属性查找一个对象，将返回找到的第一个，如果没有返回 NULL
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public T findOneBy(String propertyName, Object value) {
		List<T> list = dao.findBy(propertyName, value);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	
}
