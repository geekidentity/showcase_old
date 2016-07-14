package com.justdoit.showcase.airport.entity;

import javax.persistence.Entity;

import com.justdoit.showcase.base.entity.BaseEntity;

/**
 * 
 * @author Mr.Chen
 * @date 2016年7月14日 下午2:57:26
 */
@Entity
public class HiddenDangerType extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5128221091441515164L;

	private String name;
	private String description;

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

}
