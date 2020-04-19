package com.example.jpademo3.demojpa3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DemoJpa3Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoJpa3Application.class, args);
	}

	@Autowired
	BookRepository bookRepository;

	@Autowired
	BookCategoryRepository bookCategoryRepository;

	@Override
	public void run(String... args) throws Exception {

		bookCategoryRepository.save(new BookCategory("Programming Lang", "This category contains prog langs."));

		Set<Book> books = new HashSet<>();
		books.add(new Book("Intro to Java", 1000, 1));
		books.add(new Book("Intro to Python", 2000, 1));
		books.add(new Book("Intro to C++", 500, 1));

		bookRepository.saveAll(books);
	}
}
