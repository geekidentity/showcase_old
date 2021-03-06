/**
 * 
 */
package com.justdoit.showcase.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.justdoit.showcase.base.controller.BaseController;
import com.justdoit.showcase.system.entity.APIEntity;
import com.justdoit.showcase.system.service.APIEntityService;

/**
 *
 * @author 侯法超
 * @date 2016年6月26日  下午4:09:40
 * 
 */
@RestController
@RequestMapping(value="/api")
public class APIController extends BaseController<APIEntity, APIEntityService> {

	/* (non-Javadoc)
	 * @see com.justdoit.showcase.base.controller.BaseController#index(org.springframework.ui.Model)
	 */
	@Override
	public String index(Model model) {
		return null;
	}
	
	/**
	 * 获取最新发布的5个API
	 * @return
	 */
	@Secured({"ROLE_SUPER_ADMIN"})
	@RequestMapping(value="news")
	public Object getNews() {
		return service.getNews();
	}
	
}
