package com.justdoit.showcase.airport.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.justdoit.showcase.base.entity.BaseEntity;
import com.justdoit.showcase.base.entity.IdEntity;

/**
 * 
 * @author Mr.Chen
 * @date 2016年7月19日 下午7:53:02
 */
@Entity
public class Cache extends IdEntity<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8535777341756701737L;
	
	private String eno;
	private String token;
	private Date outTime;

	public Cache(Long id, String eno, String token, Date outTime) {
		super();
		this.id = id;
		this.eno = eno;
		this.token = token;
		this.outTime = outTime;
	}

	public Cache() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEno() {
		return eno;
	}

	public void setEno(String eno) {
		this.eno = eno;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getOutTime() {
		return outTime;
	}

	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}
	
}
