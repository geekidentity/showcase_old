/**
 * 
 */
package com.justdoit.showcase.system.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.justdoit.showcase.base.service.BaseService;
import com.justdoit.showcase.system.dao.RoleDao;
import com.justdoit.showcase.system.entity.RoleEntity;

/**
 *
 * @author 侯法超
 * @date 创建时间：2016年6月19日  下午4:26:37
 * 
 */
@Service
@Transactional
public class RoleService extends BaseService<RoleEntity, RoleDao> {

}
