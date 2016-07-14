package com.justdoit.showcase.airport.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.justdoit.showcase.base.entity.BaseEntity;

/**
 * 
 * @author Mr.Chen
 * @date 2016年7月14日 下午2:59:34
 */
@Entity
public class OperateLog extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6540689858540449186L;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "userId")
	private Employee employee;

	private String description;
	
	private String ip;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
