package com.example.demo.aop.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AopConfig {

	@Bean
	public MyFirstAspect myFirstAspect() {
		return new MyFirstAspect();
	}
}
