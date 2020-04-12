package com.example.springmongo.springmongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping(value = "/getBook")
    public Book getBook(@RequestParam(value = "name") String bookName){

        return bookRepository.findByBookName(bookName);
    }

    @PostMapping(value = "/insertBook")
    public void insertBook(@RequestBody CreateRequest createRequst) {
        bookRepository.save(new Book(createRequst.getBookName(), createRequst.getAuthorName(), createRequst.getCost()));
    }
}
