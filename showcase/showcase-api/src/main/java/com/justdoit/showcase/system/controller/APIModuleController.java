package com.justdoit.showcase.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.justdoit.showcase.base.controller.BaseController;
import com.justdoit.showcase.system.entity.APIModule;
import com.justdoit.showcase.system.service.APIModuleService;

@Controller
@RequestMapping(value="/apimodule")
public class APIModuleController extends BaseController<APIModule, APIModuleService> {

	@Override
	public String index(Model model) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping(value="/{id}/apis")
	public Object getApis(@PathVariable("id") int id) {
		return service.getApis(id);
	}

}
