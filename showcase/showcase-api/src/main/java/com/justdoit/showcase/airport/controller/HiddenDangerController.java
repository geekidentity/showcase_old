package com.justdoit.showcase.airport.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.justdoit.showcase.airport.entity.HiddenDanger;
import com.justdoit.showcase.airport.service.HiddenDangerService;
import com.justdoit.showcase.base.controller.BaseController;

/**
 * 
 * @author Mr.Chen
 * @date 2016年7月15日 下午3:55:54
 */
@RestController
@Transactional
@RequestMapping("airport/hidden")
public class HiddenDangerController extends BaseController<HiddenDanger, HiddenDangerService> {

	@Autowired
	protected HiddenDangerService hiddenDangerService;
	
	@Override
	public String index(Model model) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
