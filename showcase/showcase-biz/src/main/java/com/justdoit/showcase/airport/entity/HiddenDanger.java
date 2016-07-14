package com.justdoit.showcase.airport.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.justdoit.showcase.base.entity.BaseEntity;

/**
 * 
 * @author Mr.Chen
 * @date 2016年7月14日 下午2:53:30
 */
@Entity
public class HiddenDanger extends BaseEntity<Long> {

	private static final long serialVersionUID = 5556153812718702202L;
	
	private String name;
	
	private String description;
	
	private int level;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name = "category")
	private HiddenDangerType hiddenDangerType;

	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name = "publicAuthor")
	private Employee employee;
	
	private int verify;
	
	private int archiving;

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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public HiddenDangerType getHiddenDangerType() {
		return hiddenDangerType;
	}

	public void setHiddenDangerType(HiddenDangerType hiddenDangerType) {
		this.hiddenDangerType = hiddenDangerType;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getVerify() {
		return verify;
	}

	public void setVerify(int verify) {
		this.verify = verify;
	}

	public int getArchiving() {
		return archiving;
	}

	public void setArchiving(int archiving) {
		this.archiving = archiving;
	}
}
