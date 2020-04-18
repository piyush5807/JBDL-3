package com.example.springmongo.springmongo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, Integer> {

    Book findById(int id);

    Book findByBookName(String name);

}
