package com.justdoit.showcase.airport.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.justdoit.showcase.airport.entity.Employee;
import com.justdoit.showcase.airport.entity.HiddenDanger;
import com.justdoit.showcase.airport.entity.HiddenDangerType;
import com.justdoit.showcase.base.BaseTest;

public class HiddenDangerServiceTest extends BaseTest {

	@Autowired
	protected HiddenDangerService hiddenDangerService;
	protected EmployeeService employeeService;
	protected HiddenDangerTypeService hiddenDangerTyperService;

	@Test(expected = IllegalArgumentException.class)
	@Transactional
	//@Ignore
	public void testSave() {
		//有毒！！！！！！！
		/*HiddenDanger hiddenDanger = new HiddenDanger();
		hiddenDanger.setName("测试");
		int i = hiddenDangerService.getAll().size();
		hiddenDangerService.add(hiddenDanger);
		int j = hiddenDangerService.getAll().size();
		assertTrue( j>i );*/
		/*//Employee employee = employeeService.get(2L);
		//HiddenDangerType hiddenDangerType = hiddenDangerTyperService.get(1L);
		HiddenDanger hiddenDanger = new HiddenDanger();
		hiddenDanger.setName("测试");
		hiddenDanger.setDescription("测试数据");
		hiddenDanger.setLevel(1);
		hiddenDanger.setCreateById(2L);
		hiddenDanger.setArchiving(0);
		hiddenDanger.setVerify(0);
		hiddenDanger.setLastModifiedById(2L);
		hiddenDanger.setHiddenDangerType(null);
		hiddenDanger.setEmployee(null);
		hiddenDanger.setGmtCreate(new Date());
		hiddenDanger.setGmtModified(new Date());
		
		System.out.println(hiddenDanger);
		// hiddenDangerService.save(hiddenDanger);
		// Map<String, Object> map = new HashMap<String, Object>();

		boolean result = (boolean) hiddenDangerService.save(hiddenDanger).get("success");
		assertTrue(result);*/

	}

	/**
	 * 通过
	 */
	@Test
	@Transactional
	@Ignore
	public void testDelete() {
		HiddenDanger hiddenDanger = hiddenDangerService.delete(1L);
		assertNotNull(hiddenDanger);
		Map<String, String> params = new HashMap<>();
		params.put("eno", "001");
		List<HiddenDanger> findByParams = hiddenDangerService.findByParams(params);
		assertEquals(0, findByParams.size());
	}

	
	/**
	 * 通过
	 */
	@Test
	@Transactional
	@Ignore
	public void testAdd() {
		HiddenDanger hiddenDanger = new HiddenDanger();
		hiddenDanger.setName("测试");
		int i = hiddenDangerService.getAll().size();
		hiddenDangerService.add(hiddenDanger);
		int j = hiddenDangerService.getAll().size();
		assertTrue( j>i );
	}

	/**
	 * 通过
	 */
	@Test
	@Transactional
	@Ignore
	public void testGetAll() {
		System.out.println(hiddenDangerService.getAll());
	}

	/**
	 * 通过
	 */
	@Test
	@Transactional
	@Ignore
	public void testGet() {
		HiddenDanger hiddenDanger = hiddenDangerService.get(1L);
		assertEquals("测试", hiddenDanger.getName());
	}

	@Test
	@Transactional
//	@Ignore
	public void testFindByParams() {
		Map<String, String> params = new HashMap<>();
		params.put("name", "测试");
		assertNotNull(hiddenDangerService.findByParams(params));
	}

}
