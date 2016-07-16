package com.justdoit.showcase.base.security;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.justdoit.showcase.system.entity.UserEntity;
import com.justdoit.showcase.system.service.UserService;

public class UserDetailService implements UserDetailsService {
	
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		System.out.println(name);
		Map<String, String> params = new HashMap<>();
		params.put("login_name", name);
		List<UserEntity> list = userService.findByParams(params);
		return list.get(0);
	}

}
