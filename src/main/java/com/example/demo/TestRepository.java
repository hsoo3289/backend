package com.example.demo;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestRepository {
	@Autowired
	TestMapper testMapper;
	
	List<HashMap<String, String>> getAllUser() {
		return testMapper.selectAll();
	}
}
