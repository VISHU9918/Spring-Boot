package com.example.jpacrud.ems.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class EmpSecurityConfig {

	// define users with names, pwds and rolles
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		UserDetails ram = User.builder().username("ram").password("{noop}ram@123").roles("EMPLOYEE").build();
		UserDetails ankur = User.builder().username("ankur").password("{noop}ankur@123").roles("MANAGER").build();
		UserDetails dk = User.builder().username("dk").password("{noop}dk@123").roles("ADMIN").build();

		return new InMemoryUserDetailsManager(ram, ankur, dk);
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
