/**
 * 
 */
package com.justdoit.showcase.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.justdoit.showcase.base.entity.BaseEntity;

/**
 *
 * @author 侯法超
 * @date 2016年6月23日  上午8:48:15
 * 
 */
@Entity()
@Table(name="sys_api")
public class APIEntity extends BaseEntity<Long> {
	private static final long serialVersionUID = -7070924361732450492L;
	
	private String name;
	private String description;
	private String url;
	private String method;
	
	@Column(name="data_format")
	private String dataFormat;
	
	@Column(name="has_auth")
	private Integer hasAuth;
	private String limits;
	private String attentions;
	private String parameters;
	private String response;
	private String example;
	private String others;
	private Integer deprecated;
	
	@ManyToOne()
	@JoinColumn(name="api_modules_id")
	private APIModule apiModule;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method.toUpperCase();
	}
	public String getDataFormat() {
		return dataFormat;
	}
	public void setDataFormat(String dataFormat) {
		this.dataFormat = dataFormat;
	}
	public Integer getHasAuth() {
		return hasAuth;
	}
	public void setHasAuth(Integer hasAuth) {
		this.hasAuth = hasAuth;
	}
	public String getLimit() {
		return limits;
	}
	public void setLimit(String limits) {
		this.limits = limits;
	}
	public String getAttentions() {
		return attentions;
	}
	public void setAttentions(String attentions) {
		this.attentions = attentions;
	}
	public String getParameters() {
		return parameters;
	}
	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String getExample() {
		return example;
	}
	public void setExample(String example) {
		this.example = example;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	public Integer getDeprecated() {
		return deprecated;
	}
	public void setDeprecated(Integer deprecated) {
		this.deprecated = deprecated;
	}
	public APIModule getApiModule() {
		return apiModule;
	}
	public void setApiModule(APIModule apiModule) {
		this.apiModule = apiModule;
	}
	
}
