package com.example.demo.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/echo.do")
public class WebSocketController {

	private static final List<Session> sessionList = new ArrayList<Session>();;

	@OnOpen
	public void onOpen(Session session) throws IOException {
		System.out.println("Open session id:" + session.getId());
		session.getBasicRemote().sendText("Connection Established");
		sessionList.add(session);
	}

	private void sendAllSessionToMessage(Session self, String message) throws IOException {
		for (Session session : WebSocketController.sessionList) {
			System.out.println("sendAllSessionToMessage");
			session.getBasicRemote().sendText(message);
		}
	}

	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		System.out.println(message);
		sendAllSessionToMessage(session, message);
	}

	@OnError
	public void onError(Throwable e, Session session) {

	}

	@OnClose
	public void onClose(Session session) {
		System.out.println("Session " + session.getId() + " has ended");
		sessionList.remove(session);
	}
	
	
}