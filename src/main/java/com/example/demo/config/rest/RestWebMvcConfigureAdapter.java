//package com.example.demo.config.rest;
//
//import java.util.List;
//
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//@Configuration
//@ConditionalOnMissingBean
//public class RestWebMvcConfigureAdapter extends WebMvcConfigurationSupport {
//	
//	@Override
//	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//		converters.add(new Jaxb2RootElementHttpMessageConverter());
//		super.configureMessageConverters(converters);
//	}
//	
//}
