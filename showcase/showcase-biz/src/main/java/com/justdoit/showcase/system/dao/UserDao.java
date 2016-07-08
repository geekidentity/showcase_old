/**
 * 
 */
package com.justdoit.showcase.system.dao;

import org.springframework.stereotype.Repository;

import com.justdoit.showcase.base.dao.HibernateBaseDao;
import com.justdoit.showcase.system.entity.UserEntity;

/**
 *
 * @author 侯法超
 * @date 创建时间：2016年6月16日  下午8:20:19
 * 
 */
@Repository
public class UserDao extends HibernateBaseDao<UserEntity, Long> {
	
}
