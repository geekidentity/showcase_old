package com.justdoit.showcase.websocket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

/**
 * 系统推送
 * 
 * @author 侯法超
 * @date 2016年7月9日  下午2:27:35
 */
public class SystemWebSocketHandler implements WebSocketHandler {
	
	private static Logger logger = Logger.getLogger(SystemWebSocketHandler.class);
	
	private static Map<Long, List<WebSocketSession>> onlineUserMap = new HashMap<Long, List<WebSocketSession>>();
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		
		System.out.println("after closed");
	}

	/**
	 * 建立WebSocket连接后，将用户加入在线用户中
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		Map<String, Object> attrs = session.getAttributes();
		Long currentUserId = (Long) attrs.get(WebSocketConfig.WEBSOCKET_USERID);
		addUserToOnline(session, currentUserId);
		System.out.println("after connection");
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> msg) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("msg");
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable t) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("error:" + t);
	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * 将用户加入在线用户中，
	 */
	private void addUserToOnline(WebSocketSession session, Long currentUserId) {
		List<WebSocketSession> list = new ArrayList<>();
		list.add(session);
		onlineUserMap.put(currentUserId, list);
		logger.debug("添加用户" + currentUserId + "到 onlineUserMap");
	}
	
	/**
	 * 当用户下线后
	 */
	private void removeUserFromOnline() {
		
	}
	
}
