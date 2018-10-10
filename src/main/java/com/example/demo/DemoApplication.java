package com.example.demo;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import com.example.demo.websocket.WebSocketController;

@Controller
@SpringBootApplication
public class DemoApplication {

	@Autowired
	TestService service;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@GetMapping("/")
	String index() {
		System.out.println(service.getAllusers());
		return "index";
	}
	
	@GetMapping("/test")
	String test() {
		return "test";
	}
	
	@ResponseBody
	@RequestMapping("api")
	String api(@RequestParam HashMap<String, String> params) {
		System.out.println(params);
		return "ok";
	}
	
	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
	  return new ServerEndpointExporter();
	}
	
	@Bean
	public WebSocketController chatServerEndpoint() {
	  return new WebSocketController();
	}	
}
