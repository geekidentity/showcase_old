package com.justdoit.showcase.airport.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.justdoit.showcase.airport.dao.CacheDAO;
import com.justdoit.showcase.airport.entity.Cache;
import com.justdoit.showcase.base.service.BaseService;

@Service
@Transactional
public class CacheService extends BaseService<Cache, CacheDAO> {
	@Autowired
	private CacheDAO cacheDAO;
	private Logger logger = Logger.getLogger(this.getClass());
	
	public void deleteTokenByEno(String eno) {
		List<Cache> caches = cacheDAO.findBy("eno", eno);
		for (Cache cache : caches) {
			logger.debug("delete eno" + eno);
			cacheDAO.delete(cache);
		}
	}
	
	public List<Cache> findBy(String propertyName, Object value) {
		return cacheDAO.findBy(propertyName, value);
	}
}
