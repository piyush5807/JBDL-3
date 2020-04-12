package com.example.jpademo3.demojpa3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoJpa3Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoJpa3Application.class, args);
	}

	@Autowired
	BookRepository bookRepository;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(bookRepository.myFunction("C"));
	}
}
