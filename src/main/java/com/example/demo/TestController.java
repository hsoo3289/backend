package com.example.demo;

import java.security.Principal;
import java.util.HashMap;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class TestController {
	
	@GetMapping("test")
	String test(@RequestParam HashMap<String, String> params, @AuthenticationPrincipal Principal user) {
		System.out.println("test params:"+params+", Principal:"+user);
		return "Hello";
	}
	@PostMapping("test")
	String test2(@RequestParam HashMap<String, String> params, @AuthenticationPrincipal Principal user) {
		System.out.println("test post params:"+params+", Principal:"+user);
		return "Hello post";
	}
	
//	@GetMapping("login")
//	String login(@RequestParam HashMap<String, String> params) {
//		System.out.println(params);
//		return "success";
//	}
	
	@RequestMapping("userinfo")
	String userinfo(@RequestParam HashMap<String, String> params, @AuthenticationPrincipal Principal user) {
		System.out.println("userinfo params:"+params);
		return user.toString();
	}
	
	@RequestMapping("test.around")
	String testAround(@RequestParam HashMap<String, String> params) {
		System.out.println("test Around: params"+params);
		return "??";
	}
}
