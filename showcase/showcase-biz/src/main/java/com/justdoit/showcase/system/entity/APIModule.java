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
 * @date 2016年6月23日  上午8:46:24
 * 
 */
@Entity
@Table(name="sys_api_modules")
public class APIModule extends BaseEntity<Long> {
	private static final long serialVersionUID = 1199416968079023118L;
	
	private String name;
	private String description;
	
	@OneToMany(targetEntity=APIEntity.class, mappedBy="apiModule")
	private Set<APIEntity> apiEntities = new HashSet<APIEntity>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<APIEntity> getApiEntities() {
		return apiEntities;
	}
	public void setApiEntities(Set<APIEntity> apiEntities) {
		this.apiEntities = apiEntities;
	}
	
	
	
}
