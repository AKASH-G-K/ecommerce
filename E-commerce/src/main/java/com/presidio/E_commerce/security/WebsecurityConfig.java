package com.presidio.E_commerce.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebsecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	UserDetailsService service;

	
	@Bean
	public AuthenticationProvider provider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(service);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
		.antMatchers(HttpMethod.POST,"/api/seller/add").hasAuthority("seller")
		.antMatchers(HttpMethod.GET,"/api/seller/id").hasAnyAuthority("seller","buyer")
		.antMatchers(HttpMethod.GET,"/api/seller/all").hasAnyAuthority("seller","buyer")
		.antMatchers(HttpMethod.PUT,"/api/seller/update/id").hasAuthority("seller")
		.antMatchers(HttpMethod.DELETE,"/api/seller/delete/id").hasAuthority("seller")
		.anyRequest().authenticated().and().httpBasic()
		.and().cors().and().csrf().disable();
	}

	
}
