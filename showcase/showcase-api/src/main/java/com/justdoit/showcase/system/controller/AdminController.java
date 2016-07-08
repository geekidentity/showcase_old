/**
 * 
 */
package com.justdoit.showcase.system.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.justdoit.showcase.base.controller.BaseController;
import com.justdoit.showcase.system.entity.UserEntity;
import com.justdoit.showcase.system.service.UserService;

/**
 *
 * @author 侯法超
 * @date 2016年6月20日  下午10:02:46
 * 
 */
@RestController()
@RequestMapping(value="/system/user")
public class AdminController extends BaseController<UserEntity, UserService> {

	@Autowired
	private UserService adminService;
	
	/* (non-Javadoc)
	 * @see com.justdoit.showcase.base.controller.BaseController#index(org.springframework.ui.Model)
	 */
	@Override
	public String index(Model model) {
		return "hello";
	}
	
	@RequestMapping(value="/login")
	public Object login(@RequestParam("name")String name, @RequestParam("passwd")String passwd) {
		UserEntity admin = adminService.login(name, passwd);
		if (admin == null) {
			Map<String, String> response = new HashMap<>();
			response.put("code", "0");
			response.put("msg","登录失败");
			return response;
		}
		return admin;
	}

}
