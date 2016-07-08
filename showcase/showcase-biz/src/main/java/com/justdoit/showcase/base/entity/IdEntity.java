package com.justdoit.showcase.base.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 基类EntityID
 * @author 侯法超
 *
 * @param <PK>
 */
@MappedSuperclass
public class IdEntity<PK extends Serializable> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3886797195921565979L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected PK id;

	public PK getId() {
		return id;
	}

	public void setId(PK id) {
		this.id = id;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	
}
