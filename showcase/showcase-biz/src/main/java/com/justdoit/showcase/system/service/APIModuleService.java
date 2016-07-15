/**
 * 
 */
package com.justdoit.showcase.system.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.justdoit.showcase.base.service.BaseService;
import com.justdoit.showcase.system.dao.APIModuleDao;
import com.justdoit.showcase.system.entity.APIEntity;
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

	public List<APIEntity> getApis(int id) {
		
		return null;
	}
	
}
