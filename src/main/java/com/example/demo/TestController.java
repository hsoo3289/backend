package com.example.demo;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class TestController {
	
	@GetMapping("test")
	String test() {
		return "Hello";
	}
	@GetMapping("login")
	String login(@RequestParam HashMap<String, String> params) {
		System.out.println(params);
		return "success";
	}
}
