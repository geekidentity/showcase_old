/**
 * 
 */
package com.justdoit.showcase.base.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author 侯法超
 * @date 创建时间：2016年6月16日 下午9:41:35
 * 
 */
@Transactional
public class HibernateBaseDao<T, PK extends Serializable> {

	@Autowired
	private SessionFactory sessionFactory;
	private Class<T> entityClass;
	
	/**
	 * 
	 */
	public HibernateBaseDao() {
		entityClass = getEntityClass();
	}
	@Autowired
	public void setSessionFactory(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public T save(final T entity) {
		getSession().save(entity);
		return entity;
	}
	
	public void add(final T entity) {
		save(entity);
	}
	
	public T get(final PK id) {
		return getSession().get(entityClass, id);
	}

	
	public T delete(final PK id) {
		T t = get(id);
		delete(get(id)); //TODO:这个地方优化一下
		return t;
	}
	
	public void delete(final T entity) {
		getSession().delete(entity);
	}

	/**
	 * 根据条件查询
	 * @param params 查询条件 Map集合
	 * @return
	 */
	public List<T> findByParams(Map<String, String> params) {
		Criteria conditions = getSession().createCriteria(entityClass);
		conditions.add(Restrictions.allEq(params));
		return find(conditions);
	}
	
	/**
	 * 根据单个条件进行行查询
	 * 
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public List<T> findBy(final String propertyName, final Object value) {
		Criterion criterion = Restrictions.eq(propertyName, value);
		return find(criterion);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<T> find(final Criteria criteria) {
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> find(Criterion... criterions) {
		return createCriteria(criterions).list();
	}

	public Criteria createCriteria(Criterion...criterions) {
		Criteria criteria = getSession().createCriteria(entityClass);
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		return criteria;
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		Session session = getSession();
		Criteria criteria = session.createCriteria(entityClass);
		List<T> result = criteria.list();
		return result;
	}
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/*
	 * 根据参数化类型找到实体类Class
	 */
	@SuppressWarnings("unchecked")
	private Class<T> getEntityClass() {
		Type genType = getClass().getGenericSuperclass();
		if (genType instanceof ParameterizedType) {
			ParameterizedType paramType = (ParameterizedType) genType;
			Type[] type = paramType.getActualTypeArguments();
			return (Class<T>) type[0];
		}
		return (Class<T>) Object.class;
	}

}
