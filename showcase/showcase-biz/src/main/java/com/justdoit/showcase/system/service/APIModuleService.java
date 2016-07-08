/**
 * 
 */
package com.justdoit.showcase.system.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.justdoit.showcase.base.service.BaseService;
import com.justdoit.showcase.system.dao.APIModuleDao;
import com.justdoit.showcase.system.entity.APIModule;

/**
 *
 * @author 侯法超
 * @date 2016年6月23日  上午8:56:11
 * 
 */
@Service
@Transactional
public class APIModuleService extends BaseService<APIModule, APIModuleDao> {
	
}
