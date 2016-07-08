package com.justdoit.showcase.base.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * 基类Entity，包含表的基本信息
 *
 * @param <PK>
 * @author 侯法超
 * @date 创建时间：2016年6月16日  下午7:23:21
 *
 */
@MappedSuperclass
public class BaseEntity<PK extends Serializable> extends IdEntity<PK> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -392664201233375928L;
	
	/**
	 * 创建时间
	 */
	@Column(insertable=true, updatable=false)
	protected Date gmtCreate = new Date();
	
	/**
	 * 修改时间
	 */
	@Column(insertable=true, updatable=true)
	protected Date gmtModified = new Date();
	
	/**
	 * 创建人ID
	 */
	@Column(insertable=true, updatable=false)
	protected Long createById;
	
	/**
	 * 最后更新人ID
	 */
	@Column(insertable=true, updatable=true)
	protected Long lastModifiedById;
	
	public Date getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public Date getGmtModified() {
		return gmtModified;
	}
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	public Long getCreateById() {
		return createById;
	}
	public void setCreateById(Long createById) {
		this.createById = createById;
	}
	public Long getLastModifiedById() {
		return lastModifiedById;
	}
	public void setLastModifiedById(Long lastModifiedById) {
		this.lastModifiedById = lastModifiedById;
	}
	
	
}
