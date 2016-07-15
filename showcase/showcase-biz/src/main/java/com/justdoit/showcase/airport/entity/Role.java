package com.justdoit.showcase.airport.entity;


import javax.persistence.Entity;

import org.springframework.security.core.GrantedAuthority;

import com.justdoit.showcase.base.entity.BaseEntity;

/**
 * 
 * @author Mr.Chen
 * @date 2016年7月14日 上午10:11:59
 */
@Entity
public class Role extends BaseEntity<Long> implements GrantedAuthority {
	/**
	 * 
	 */
	private static final long serialVersionUID = -384719586959547518L;
	
	private String name;
	private int departmentId;
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * 
	 * @author 侯法超
	 * 用户权限，这里用角色名做权限限制
	 */
	@Override
	public String getAuthority() {
		return name;
	}

}
