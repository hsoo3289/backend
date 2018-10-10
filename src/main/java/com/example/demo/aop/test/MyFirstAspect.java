package com.example.demo.aop.test;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class MyFirstAspect {
	
	
	@Before("execution(* *com.example.demo.*.*(..))")
	public void before(JoinPoint jp) {
		System.out.println("before excution");
	}
	
//	@Around("execution( String com.example.demo.TestController.testAround(..))")
//	public void around(ProceedingJoinPoint pjp) throws Throwable {
//		
//		pjp.proceed();
//	}
}
