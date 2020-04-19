package com.example.jpademo3.demojpa3;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.jnlp.IntegrationService;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer> {

}
