/**
 * 
 */
package com.justdoit.showcase.system.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.justdoit.showcase.base.entity.BaseEntity;

/**
 *
 * @author 侯法超
 * @date 创建时间：2016年6月19日  下午3:26:09
 * 
 */
@Entity
@Table(name="sys_role")
public class RoleEntity extends BaseEntity<Long> {
	private static final long serialVersionUID = 8419733708363229508L;

	private String name;
	private String remark;
	
	//删除标记（1:已删除；0：未删除
	private int deleted;
	
	//用户角色等级。1：超级管理员；20：普通管理员；30：用户；50：访客
	private Integer level;
	
	@OneToMany(targetEntity=UserEntity.class, mappedBy="role")
	private Set<UserEntity> userEntities = new HashSet<UserEntity>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Set<UserEntity> getUserEntities() {
		return userEntities;
	}

	public void setUserEntities(Set<UserEntity> userEntities) {
		this.userEntities = userEntities;
	}
	
}
