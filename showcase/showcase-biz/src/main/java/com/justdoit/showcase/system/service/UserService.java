 /**
 * 
 */
package com.justdoit.showcase.system.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.justdoit.showcase.base.service.BaseService;
import com.justdoit.showcase.system.dao.UserDao;
import com.justdoit.showcase.system.entity.UserEntity;

/**
 *
 * @author 侯法超
 * @date 创建时间：2016年6月16日  下午9:15:43
 * 
 */
@Service
@Transactional
public class UserService extends BaseService<UserEntity,UserDao> {
	
	public UserEntity login(String name, String passwd) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("login_name", name);
		params.put("passwd", passwd);
		List<UserEntity> admins = dao.findByParams(params);
		if (admins.size() > 0) {
			return admins.get(0);
		}
		return null;
	}
}
