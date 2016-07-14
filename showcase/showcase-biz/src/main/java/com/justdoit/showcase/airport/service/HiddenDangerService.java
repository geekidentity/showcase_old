package com.justdoit.showcase.airport.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.justdoit.showcase.airport.dao.HiddenDangerDAO;
import com.justdoit.showcase.airport.entity.HiddenDanger;
import com.justdoit.showcase.base.service.BaseService;

/**
 * 
 * @author Mr.Chen
 * @date 2016年7月14日 下午3:31:29
 */

@Service
@Transactional
public class HiddenDangerService extends BaseService<HiddenDanger, HiddenDangerDAO> {

}
