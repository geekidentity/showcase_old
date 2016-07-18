package com.justdoit.showcase.system;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.justdoit.showcase.base.BaseTest;
import com.justdoit.showcase.base.util.JSONUtil;
import com.justdoit.showcase.system.entity.APIEntity;
import com.justdoit.showcase.system.entity.APIModule;
import com.justdoit.showcase.system.service.APIEntityService;

/**
 * API 增删改查类
 * @author 侯法超
 * @date  2016年7月12日  下午8:22:03
 */
public class APITest extends BaseTest {
	
	@Autowired
	private APIEntityService apiService;
	
	@Test
	@Ignore
	public void showAll() {
		@SuppressWarnings("deprecation")
		List<APIEntity> list = apiService.getAll();
		for (APIEntity a : list) {
			JSONUtil.printOjbect2Str(a);
		}
	}
	
	@Test
	@Ignore
	public void add() {
		APIEntity api = new APIEntity();
		api.setName("测试2");
		api.setUrl("/hello");
		api.setMethod("POST");
		api.setCreateById(0L);
		APIModule apiModule = new APIModule();
		apiModule.setId(1L);
		api.setApiModule(apiModule);
		apiService.add(api);
	}
	@Ignore
	@Test
	@Transactional
	@Rollback(false)
	public void save() {
		APIEntity api = apiService.get(16L);
		api.setMethod("POST");
		apiService.save(api);
	}
	
	@Test
	@Ignore
	public void delete() {
		long deleteId = 11L;
		APIEntity willDeleted = apiService.get(deleteId);
		APIEntity deletedAPI = apiService.delete(deleteId);
		assertEquals(willDeleted.getId(), deletedAPI.getId());
	}
	@Test
	public void news() {
		List<APIEntity> list = apiService.getNews();
		for (APIEntity a : list) {
			System.out.println(a);
		}
		assertNotEquals(0, list.size());
	}
}
