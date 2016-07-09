package com.airplane.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@RequestMapping("/test")
	@ResponseBody
	public String index(@RequestHeader("User-Agent") String userAgent,
			@RequestHeader("Accept") String accept) {
		System.out.println("Agent:" + userAgent);
		System.out.println("accept:" + accept);
		return "hello";
	}
}
