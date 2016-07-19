package com.justdoit.showcase.airport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import com.justdoit.showcase.airport.dao.HiddenDangerTypeDAO;
import com.justdoit.showcase.airport.entity.HiddenDangerType;
import com.justdoit.showcase.base.service.BaseService;

@RestController
@Transactional
public class HiddenDangerTypeService extends BaseService<HiddenDangerType, HiddenDangerTypeDAO> {

	@Autowired
	protected HiddenDangerService hiddenDangerTypeService;
}
