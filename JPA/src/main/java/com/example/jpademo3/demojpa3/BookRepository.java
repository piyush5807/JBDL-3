package com.example.jpademo3.demojpa3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    // Find all the books with book name E

    @Query(value = "SELECT * from my_books b where b.book_name=:name", nativeQuery = true)
    List<Book> myFunction(String name);
}
