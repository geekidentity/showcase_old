package com.justdoit.showcase.airport.entity;

import javax.persistence.Entity;
import com.justdoit.showcase.base.entity.BaseEntity;

/**
 * 
 * @author Mr.Chen
 * @date 2016年7月13日 下午2:25:35
 */
@Entity
public class Department extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8728168827111858301L;
	
	
	private String name;
	private String phone;
	private String email;
	private String address;
	private String description;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
