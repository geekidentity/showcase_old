/**
 * 
 */
package com.justdoit.showcase.system.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.justdoit.showcase.base.service.BaseService;
import com.justdoit.showcase.system.dao.APIEntityDao;
import com.justdoit.showcase.system.entity.APIEntity;

/**
 *
 * @author 侯法超
 * @date 2016年6月23日  上午8:58:58
 * 
 */
@Service
@Transactional
public class APIEntityService extends BaseService<APIEntity, APIEntityDao> {

	@SuppressWarnings("unchecked")
	public List<APIEntity> getNews() {
		Criterion deprecated = Restrictions.eq("deprecated", 1);
		Criterion criterion = Restrictions.not(deprecated);
		Criteria criteria = dao.createCriteria(criterion);
		criteria.setMaxResults(5);
		return criteria.list();
	}

}
