package com.example.demo;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	
	@Autowired
	TestRepository rep;
	
	List<HashMap<String, String>> getAllusers () {
		return rep.getAllUser();
	}
}
