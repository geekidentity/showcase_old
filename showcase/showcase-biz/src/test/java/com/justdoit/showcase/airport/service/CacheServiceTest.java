package com.justdoit.showcase.airport.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.justdoit.showcase.base.BaseTest;

public class CacheServiceTest extends BaseTest {
	@Autowired
	private CacheService service;
	@Test
	public void testDelete() {
		service.deleteTokenByEno("001");
	}
}
