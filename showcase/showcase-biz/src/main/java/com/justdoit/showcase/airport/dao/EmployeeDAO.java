package com.justdoit.showcase.airport.dao;

import org.springframework.stereotype.Repository;

import com.justdoit.showcase.airport.entity.Employee;
import com.justdoit.showcase.base.dao.HibernateBaseDao;

/**
 * 
 * @author Mr.Chen 
 *
 */

@Repository
public class EmployeeDAO extends HibernateBaseDao<Employee, Long> {
	
}
