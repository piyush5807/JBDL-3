package com.example.springmongo.springmongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "books")
public class Book {

    private String bookName;
    private String authorName;
    private int cost;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;

    }

    public Book(String bookName, String authorName, int cost) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.cost = cost;
    }
}
