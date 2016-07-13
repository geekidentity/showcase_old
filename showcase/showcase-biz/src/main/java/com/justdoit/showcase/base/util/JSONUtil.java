package com.justdoit.showcase.base.util;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JSON的帮助类，基于Jackson
 * @author 侯法超
 * @date  2016年7月12日  下午7:16:08
 */
public class JSONUtil {
	
	private static ObjectMapper mapper = new ObjectMapper();
	/**
	 * 
	 * @param o
	 */
	public static void printOjbect2Str(Object o) {
		try {
			String json = mapper.writeValueAsString(o);
			System.out.println(json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void map2Json(Writer writer, Map<Object, Object> map) throws JsonGenerationException, JsonMappingException, IOException {
		mapper.writeValue(writer, map);
	}
}
