package com.security.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
//@EnableWebSecurity
public class AppSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider authProvider() {

		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
	//	provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		//Useing Becrypt 
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
//For using BCrypt must login with password : 	 $2y$12$z.uur69w1k7xojx/Ml4lAOnabzUv8zepVt.mgt6Tqvc4TZHUWYiFm -->abcd	
		return provider;
	}

	/*
	 * @Bean
	 * 
	 * @Override protected UserDetailsService userDetailsService() {
	 * 
	 * List<UserDetails> user = new ArrayList<>();
	 * user.add(User.withDefaultPasswordEncoder().username("rohit").password("1234")
	 * .roles("USER").build()); return new InMemoryUserDetailsManager(user); }
	 */

}
