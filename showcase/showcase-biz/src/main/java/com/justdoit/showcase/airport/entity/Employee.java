package com.justdoit.showcase.airport.entity;

import java.util.Date;

import javax.persistence.Entity;

import com.justdoit.showcase.base.entity.BaseEntity;

@Entity
public class Employee extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8481119636537511641L;
	
	private String eno;
	private String name;
	private String password;
	private String phone;
	private String email;
	private int isAdmin;
	private int status;
	private Date lastLogin;
	private Date birthday;
	public String getEno() {
		return eno;
	}
	public void setEno(String eno) {
		this.eno = eno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
}
