package com.justdoit.showcase.airport.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.justdoit.showcase.airport.dao.DepartmentDAO;
import com.justdoit.showcase.airport.entity.Department;
import com.justdoit.showcase.base.service.BaseService;

/**
 * 
 * @author Mr.Chen
 * @date 2016年7月14日 下午3:30:44
 */

@Service
@Transactional
public class DepartmentService extends BaseService<Department, DepartmentDAO> {

}
