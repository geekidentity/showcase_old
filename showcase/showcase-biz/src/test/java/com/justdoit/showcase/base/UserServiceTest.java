package com.justdoit.showcase.base;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.justdoit.showcase.base.BaseTest;
import com.justdoit.showcase.system.entity.UserEntity;
import com.justdoit.showcase.system.service.UserService;

public class UserServiceTest extends BaseTest {

	@Autowired
	private UserService userService;
	@Ignore
	@Test
	public void findByParamsTest() {
		Map<String, String> params = new HashMap<>();
		params.put("loginName", "geek");
		List<UserEntity> list = userService.findByParams(params);
		for (UserEntity e : list) {
			System.out.println(e);
		}
	}

}
