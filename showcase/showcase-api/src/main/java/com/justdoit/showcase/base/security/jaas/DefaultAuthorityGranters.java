package com.justdoit.showcase.base.security.jaas;

import java.security.Principal;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.jaas.AuthorityGranter;

import com.justdoit.showcase.airport.entity.Employee;
import com.justdoit.showcase.airport.entity.Role;
import com.justdoit.showcase.airport.service.EmployeeService;

/**
 * 对用户进行授权
 * @author 侯法超
 * @date  2016年7月15日  下午4:00:29
 */
public class DefaultAuthorityGranters implements AuthorityGranter {
	
	@Autowired
	private EmployeeService employeeService;
	@Override
	public Set<String> grant(Principal principal) {
		Employee employee = (Employee) employeeService.loadUserByUsername(principal.getName());
		List<Role> list = (List<Role>) employee.getAuthorities();
		Set<String> grant = new HashSet<>();
		for (Role r : list) {
			grant.add(r.getAuthority());
		}
		return grant;
	}

}
