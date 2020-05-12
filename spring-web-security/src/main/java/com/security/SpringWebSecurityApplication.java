package com.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
class SpringWebSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebSecurityApplication.class, args);
	}

}
