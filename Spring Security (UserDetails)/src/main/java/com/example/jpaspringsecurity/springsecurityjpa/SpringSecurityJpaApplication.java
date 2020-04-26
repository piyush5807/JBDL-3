package com.example.jpaspringsecurity.springsecurityjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityJpaApplication {

	@Autowired
	UserServiceRepository userServiceRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJpaApplication.class, args);
	}


//	@Override
//	public void run(String... args) throws Exception {
//		userServiceRepository.save(new MyUserDetails("piyush", "pass", true,
//				"USER:ADMIN"));
//		userServiceRepository.save(new MyUserDetails("abc", "1234", true,
//				"USER"));
//	}
}
