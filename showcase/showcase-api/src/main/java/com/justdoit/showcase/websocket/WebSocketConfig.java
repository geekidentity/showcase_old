package com.justdoit.showcase.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;


/**
 * WebSocket配置文件
 * @author 侯法超
 * @date 2016年7月8日  下午9:23:30
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
	
	public static final String WEBSOCKET_USERID = "WEBSOCKET_USERID";

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(systemHandler(), "/ws").setAllowedOrigins("http://localhost:63342");
	}
	
	@Bean
	public WebSocketHandler systemHandler() {
		return new SystemWebSocketHandler();
	}
}
