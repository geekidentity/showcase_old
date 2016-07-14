package com.justdoit.showcase.airport.entity;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class Role {
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

}
