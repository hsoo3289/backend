package com.example.demo;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestMapper {

	@Select("select * from test")
	List<HashMap<String, String>> selectAll();
}
