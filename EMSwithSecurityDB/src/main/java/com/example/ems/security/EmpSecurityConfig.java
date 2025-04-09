package com.example.ems.security;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

public class EmpSecurityConfig {

	// define users with names, pwds and rolles
	@Bean
	public UserDetailsManager userDetailsManager(DataSource datasource) {
		return new JdbcUserDetailsManager(datasource);
	}
	// restrict access based on roles

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	
	http.authorizeHttpRequests(configurer ->configurer
	.requestMatchers(HttpMethod.GET,"/ems/api/employees").hasAnyRole("EMPLOYEE","MANAGER","ADMIN")
	.requestMatchers(HttpMethod.GET,"/ems/api/employees/**").hasAnyRole("EMPLOYEE","MANAGER","ADMIN")
	.requestMatchers(HttpMethod.POST,"/ems/api/employees").hasRole("MANAGER") 
	.requestMatchers(HttpMethod.PUT,"/ems/api/employees").hasRole("MANAGER")
	.requestMatchers(HttpMethod.DELETE, "/ems/api/employees/**").hasRole("ADMIN"));
	
	// use HTTP Basic authentication 
	http.httpBasic(Customizer.withDefaults());
	// disable Cross Site Request Forgery (CSRF) 
	http.csrf(csrf -> csrf.disable());
	return http.build();
}
}