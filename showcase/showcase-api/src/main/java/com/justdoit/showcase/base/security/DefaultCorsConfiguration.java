package com.justdoit.showcase.base.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Component
public class DefaultCorsConfiguration  implements CorsConfigurationSource  {

	@Override
	public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.addAllowedHeader(request.getHeader("Origin"));
		configuration.addAllowedMethod("*");
		configuration.addAllowedOrigin("*");
		configuration.setAllowCredentials(true);
		return configuration;
	}
	
}
