package com.example.demo.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages="com.example.demo.config.security")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	RestAuthenticationEntryPoint authEntryPoint;
	
	@Autowired
	RestLoginSuccessHandler successHandler;
	
	@Autowired
	RestAuthenticationFailureHandler failureHandler;
	
	@Autowired
	RestLogoutSucessHandler logoutSuccessHandler;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.csrf().disable()
		.exceptionHandling()
			.authenticationEntryPoint(authEntryPoint)
		.and()
		.formLogin()
			.loginProcessingUrl("/api/login")
			.usernameParameter("username")
			.passwordParameter("password")
			.successHandler(successHandler)
			.failureHandler(failureHandler)
			.and()
		.logout()
			.logoutUrl("/api/logout")
			.logoutSuccessHandler(logoutSuccessHandler);
		http.authorizeRequests().antMatchers("/api/test").permitAll();
		http.authorizeRequests().antMatchers("/api/**").authenticated();
		
		
	}
	
//	@Bean
//	public RestLoginSuccessHandler loginSuccessHandler() {
//		return new RestLoginSuccessHandler();
//	}
//	
//	@Bean
//	public RestAuthenticationEntryPoint restAuthenticationEntryPoint () {
//		return new RestAuthenticationEntryPoint();
//	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("============================================================");
		System.out.println("Security config.configure");
		auth.inMemoryAuthentication().withUser("hsoo").password("gust2468").roles("USER")
		.and().withUser("a@a.com").password("Gust2468&&").roles("USER");
	}

	@Override
	public void setAuthenticationConfiguration(AuthenticationConfiguration authenticationConfiguration) {
		// TODO Auto-generated method stub
		super.setAuthenticationConfiguration(authenticationConfiguration);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new PasswordEncoder() {

			@Override
			public String encode(CharSequence rawPassword) {
				return String.valueOf(rawPassword);
			}

			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return rawPassword.equals(encodedPassword);
			}

		};
	}
}
