package com.justdoit.showcase.system;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.justdoit.showcase.base.BaseTest;
import com.justdoit.showcase.system.entity.UserEntity;
import com.justdoit.showcase.system.service.UserService;


public class UserTest extends BaseTest {
	@Autowired
	private UserService userService;
	@Ignore
	@Test
	public void get() throws JsonGenerationException, JsonMappingException, IOException {
		UserEntity userEntity = userService.get(0);
		System.out.println(userEntity);
		ObjectMapper mapper = new ObjectMapper();
		Writer strWriter = new StringWriter();
		mapper.writeValue(strWriter, userEntity);
		String userDataJSON = strWriter.toString();
		System.out.println(userDataJSON);
	}
}
